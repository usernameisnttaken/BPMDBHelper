package ru.ertelecom.bpms.db;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.lombardisoftware.core.TWObject;
import ru.ertelecom.bpms.db.entity.*;
import ru.ertelecom.bpms.db.service.*;
import ru.ertelecom.bpms.db.utils.BPMHibernateSessionFactoryUtil;
import ru.ertelecom.bpms.reports.entities.B2B3ReportEntity;

import java.io.IOException;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

import com.ibm.bpm.enums.InstanceStatus;
import com.lombardisoftware.client.persistence.BPDActivityInstance.TaskType;


public class BPMDBHelper {
    public static void main(String[] args)
            throws Exception {
        long startTime = System.nanoTime();
        System.out.println("Hola!");
        System.out.println("start time = " + startTime);

        // выгрузка по подключке
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String afterStr = "10/11/2020 00:00:01";
        String beforeStr = "01/10/2021 23:59:59";
        Date after = sdf.parse(afterStr);
        Date before = sdf.parse(beforeStr);
        // выгрузка по подключке
//        List<BPMProcessInstance> bpmProcessInstances = (List<BPMProcessInstance>)
//                BPMHibernateSessionFactoryUtil
//                        .getSessionFactory()
//                        .openSession()
//                        .createQuery("FROM " +
//                                "BPMProcessInstance bpi " +
//                                "WHERE " +
//                                "bpi.bpmProject.acronym = :acronym " +
//                                "and bpi.executionStatusId in (:statusIds) " +
//                                "and bpi.createDatetime between :after and :before")
//                        .setParameter("acronym", "B2B3")
//                        .setParameter("statusIds", Arrays.asList(InstanceStatus.ACTIVE.getValue(), InstanceStatus.COMPLETED.getValue()))
//                        .setParameter("after", after)
//                        .setParameter("before", before)
//                        .list();

        // для разработки
        List<BPMProcessInstance> bpmProcessInstances = (List<BPMProcessInstance>)
                BPMHibernateSessionFactoryUtil
                        .getSessionFactory()
                        .openSession()
                        .createQuery("FROM " +
                                "BPMProcessInstance bpi " +
                                "WHERE " +
                                "bpi.bpdInstanceId IN (70997,71084,71085,71086,71107,71108,71109,71130,71131,71132,71133,71154,71155,71156,71157,71158,71184,71185,71222,71223,71228)")
                        .list();
//        List<BPMProcessInstance> bpmProcessInstances = (List<BPMProcessInstance>)
//                BPMHibernateSessionFactoryUtil
//                        .getSessionFactory()
//                        .openSession()
//                        .createQuery("FROM " +
//                                "BPMProcessInstance bpi " +
//                                "WHERE " +
//                                "bpi.bpmProject.acronym LIKE :acronym")
//                        .setParameter("acronym", "STR%")
//                        .list();

        // записывать в архив пока будем через jdbc
        final String archUrl = "jdbc:postgresql://10.121.15.70:5432/hdlake";
        final String archUser = "archivar";
        final String archPassword = "v8dYEh3hd9k1";
        final String INSERT_METADATA_SQL = "INSERT" +
                " INTO bpms_process_instance" +
                "  (piid, name, creation_datetime, due_datetime, last_modification_datetime, close_datetime, execution_state_id, snapshot_id)" +
                " VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        final String INSERT_BUSINESS_DATA_SQL = "INSERT" +
                " INTO bpms_process_instance_data (piid, business_data)" +
                " VALUES (?, to_json(?::json))";
        final String INSERT_TASK_SQL = "INSERT" +
                " INTO bpms_process_instance_task" +
                " (tkid, subject, bpd_instance_id, activity_task_type, priority_id, rcvd_datetime, close_datetime, read_datetime, last_modified_datetime, due_date, user_id, group_id, close_by)" +
                " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        final String INSERT_USER_SQL = "INSERT" +
                " INTO bpms_user (user_id, user_name, full_name)" +
                " VALUES (?, ?, ?)" +
                " ON CONFLICT (user_id) DO NOTHING";
        final String INSERT_GROUP_SQL = "INSERT" +
                " INTO bpms_group (group_id, group_name, display_name, parent_group_id, group_type, description, group_state, participant_id)" +
                " VALUES (?, ?, ?, ?, ?, ?, ?, ?)" +
                " ON CONFLICT (group_id) DO NOTHING";
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(archUrl, archUser, archPassword);
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(-1);
        }

        BPMTaskInstanceService bpmTaskInstanceService = new BPMTaskInstanceService();
        BPMProcessInstanceDataService bpmProcessInstanceDataService = new BPMProcessInstanceDataService();
        BPMUserService bpmUserService = new BPMUserService();
        BPMGroupService bpmGroupService = new BPMGroupService();

        for (BPMProcessInstance bpmProcessInstance : bpmProcessInstances) {
            System.out.println("Processing instance " + bpmProcessInstance.getBpdInstanceId());
            try {
                BPMProcessInstanceData bpmProcessInstanceData = bpmProcessInstanceDataService
                        .findByBpdInstanceId(bpmProcessInstance.getBpdInstanceId());
                ObjectNode objectNode = bpmProcessInstanceDataService.getBPDDataAsJson(bpmProcessInstanceData.getData());
                List<BPMTaskInstance> bpmTaskInstances = bpmTaskInstanceService.findAllByBpdInstanceId(bpmProcessInstance.getBpdInstanceId(), TaskType.USER_TASK.getValue());

                // запись в архив
                PreparedStatement preparedStatement = connection.prepareStatement(INSERT_METADATA_SQL);
                preparedStatement.setLong(1, bpmProcessInstance.getBpdInstanceId());
                preparedStatement.setString(2, bpmProcessInstance.getInstanceName());
                preparedStatement.setDate(3, new java.sql.Date(bpmProcessInstance.getCreateDatetime().getTime()));
                preparedStatement.setDate(4, new java.sql.Date(bpmProcessInstance.getDueDatetime().getTime()));
                preparedStatement.setDate(5, new java.sql.Date(bpmProcessInstance.getLastModifiedDatetime().getTime()));

                if (bpmProcessInstance.getCloseDatetime() == null)
                    preparedStatement.setDate(6, null);
                else
                    preparedStatement.setDate(6, new java.sql.Date(bpmProcessInstance.getCloseDatetime().getTime()));

                preparedStatement.setInt(7, bpmProcessInstance.getExecutionStatusId());
                preparedStatement.setString(8, bpmProcessInstance.getSnapshotId());
                preparedStatement.executeUpdate();
                PreparedStatement preparedStatement1 = connection.prepareStatement(INSERT_BUSINESS_DATA_SQL);
                preparedStatement1.setLong(1, bpmProcessInstance.getBpdInstanceId());
                preparedStatement1.setString(2, objectNode.toString());
                preparedStatement1.executeUpdate();
                for (BPMTaskInstance bpmTaskInstance : bpmTaskInstances) {
                    PreparedStatement preparedStatement2 = connection.prepareStatement(INSERT_TASK_SQL);
                    preparedStatement2.setLong(1, bpmTaskInstance.getTaskId());
                    preparedStatement2.setString(2, bpmTaskInstance.getSubject());
                    preparedStatement2.setLong(3, bpmTaskInstance.getBpdInstanceId());
                    preparedStatement2.setInt(4, bpmTaskInstance.getActivityTaskTypeId());
                    preparedStatement2.setInt(5, bpmTaskInstance.getPriorityId());
                    preparedStatement2.setDate(6, new java.sql.Date(bpmTaskInstance.getReceivedDatetime().getTime()));
                    if (bpmTaskInstance.getCloseDatetime() == null)
                        preparedStatement2.setDate(7, null);
                    else
                        preparedStatement2.setDate(7, new java.sql.Date(bpmTaskInstance.getCloseDatetime().getTime()));
                    if (bpmTaskInstance.getReadDatetime() == null)
                        preparedStatement2.setDate(8, null);
                    else
                        preparedStatement2.setDate(8, new java.sql.Date(bpmTaskInstance.getReadDatetime().getTime()));
                    preparedStatement2.setDate(9, new java.sql.Date(bpmTaskInstance.getLastModifiedDatetime().getTime()));
                    preparedStatement2.setDate(10, new java.sql.Date(bpmTaskInstance.getDueDatetime().getTime()));
                    preparedStatement2.setLong(11, bpmTaskInstance.getAssignedToUserId());
                    preparedStatement2.setLong(12, bpmTaskInstance.getAssignedToGroupId());
                    if (bpmTaskInstance.getClosedByUserId() == null)
                        preparedStatement2.setNull(13, Types.INTEGER);
                    else
                        preparedStatement2.setLong(13, bpmTaskInstance.getClosedByUserId());
                    preparedStatement2.executeUpdate();

                    Long assignedToUserId = bpmTaskInstance.getAssignedToUserId() > 0 ? bpmTaskInstance.getAssignedToUserId() : -1 * bpmTaskInstance.getAssignedToUserId();
                    BPMUser assignedToUser = bpmUserService.findByUserId(assignedToUserId);
                    PreparedStatement preparedStatement3 = connection.prepareStatement(INSERT_USER_SQL);
                    preparedStatement3.setLong(1, assignedToUser.getUserId());
                    preparedStatement3.setString(2, assignedToUser.getUserName());
                    preparedStatement3.setString(3, assignedToUser.getFullName());
                    preparedStatement3.executeUpdate();

                    Long assignedToGroupId = bpmTaskInstance.getAssignedToGroupId() > 0 ? bpmTaskInstance.getAssignedToGroupId() : -1 * bpmTaskInstance.getAssignedToGroupId();
                    BPMGroup assignedToGroup = bpmGroupService.findByGroupId(assignedToGroupId);
                    PreparedStatement preparedStatement4 = connection.prepareStatement(INSERT_GROUP_SQL);
                    preparedStatement4.setLong(1, assignedToGroup.getGroupId());
                    preparedStatement4.setString(2, assignedToGroup.getGroupName());
                    preparedStatement4.setString(3, assignedToGroup.getDisplayName());
                    if (assignedToGroup.getParentGroupId() == null)
                        preparedStatement4.setNull(4, Types.BIGINT);
                    else
                        preparedStatement4.setLong(4, assignedToGroup.getParentGroupId());
                    preparedStatement4.setInt(5, assignedToGroup.getTypeId());
                    preparedStatement4.setString(6, assignedToGroup.getDescription());
                    preparedStatement4.setInt(7, assignedToGroup.getStateId());
                    preparedStatement4.setString(8, assignedToGroup.getParticipantId());
                    preparedStatement4.executeUpdate();
                }

            } catch (IOException | ClassNotFoundException | NoSuchFieldException | IllegalAccessException e) {
                e.printStackTrace();
            } finally {
                System.out.println("processed " + bpmProcessInstance.getBpdInstanceId());
            }
        }
        connection.close();

        long endTime   = System.nanoTime();
        long totalTime = endTime - startTime;
        System.out.println("run time = " + totalTime / 1000000000 + " seconds");
        System.out.println("That's all folks!");
    }

}
