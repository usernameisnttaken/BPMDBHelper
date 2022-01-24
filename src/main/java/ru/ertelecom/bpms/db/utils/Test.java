package ru.ertelecom.bpms.db.utils;

import ru.ertelecom.bpms.db.entity.*;
import ru.ertelecom.bpms.db.service.*;

import java.sql.*;
import java.text.ParseException;
import java.util.List;

public class Test {
    public static void test()
            throws SQLException, ParseException {
        // выгрузка по подключке
//        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
//        String afterStr = "10/11/2020 00:00:01";
//        String beforeStr = "01/10/2021 23:59:59";
//        Date after = sdf.parse(afterStr);
//        Date before = sdf.parse(beforeStr);
//        List<LSWBpdInstance> LSWBpdInstances = (List<LSWBpdInstance>)
//                BPMHibernateSessionFactoryUtil
//                        .getSessionFactory()
//                        .openSession()
//                        .createQuery("FROM " +
//                                "LSWBpdInstance bpi " +
//                                "WHERE " +
//                                "bpi.bpmProject.acronym = :acronym " +
//                                "and bpi.executionStatusId in (:statusIds) " +
//                                "and bpi.createDatetime between :after and :before")
//                        .setParameter("acronym", "B2B3")
//                        .setParameter("statusIds", Arrays.asList(InstanceStatus.ACTIVE.getValue(), InstanceStatus.COMPLETED.getValue()))
//                        .setParameter("after", new java.sql.Date(after.getTime()))
//                        .setParameter("before", new java.sql.Date(before.getTime()))
//                        .list();
        // для разработки
        List<LSWBpdInstance> LSWBpdInstances = (List<LSWBpdInstance>)
                BPMHibernateSessionFactoryUtil
                        .getSessionFactory()
                        .openSession()
                        .createQuery("FROM " +
                                "LSWBpdInstance bpi " +
                                "WHERE " +
                                "bpi.bpdInstanceId IN (70997,71084,71085,71086,71107,71108,71109,71130,71131,71132,71133,71154,71155,71156,71157,71158,71184,71185,71222,71223,71228)")
                        .list();

        // записывать в архив пока будем через jdbc
        final String archUrl = "jdbc:postgresql://10.121.15.70:5432/hdlake";
        final String archUser = "archivar";
        final String archPassword = "v8dYEh3hd9k1";
        final String INSERT_METADATA_SQL = "INSERT" +
                " INTO bpms_process_instance" +
                "  (piid, name, creation_datetime, due_datetime, last_modification_datetime, close_datetime, execution_state_id, snapshot_id)" +
                " VALUES (?, ?, ?, ?, ?, ?, ?, ?)" +
                " ON CONFLICT (piid) DO NOTHING;";
        final String INSERT_BUSINESS_DATA_SQL = "INSERT" +
                " INTO bpms_process_instance_data (piid, business_data)" +
                " VALUES (?, to_json(?::json))" +
                " ON CONFLICT (piid) DO NOTHING;";
        final String INSERT_TASK_SQL = "INSERT" +
                " INTO bpms_process_instance_task" +
                " (tkid, subject, bpd_instance_id, activity_task_type, priority_id, rcvd_datetime, close_datetime, read_datetime, last_modified_datetime, due_date, user_id, group_id, close_by)" +
                " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" +
                " ON CONFLICT (tkid) DO NOTHING;";
        final String INSERT_USER_SQL = "INSERT" +
                " INTO bpms_user (user_id, user_name, full_name)" +
                " VALUES (?, ?, ?)" +
                " ON CONFLICT (user_id) DO NOTHING";
        final String INSERT_GROUP_SQL = "INSERT" +
                " INTO bpms_group (group_id, group_name, display_name, parent_group_id, group_type, description, group_state, participant_id)" +
                " VALUES (?, ?, ?, ?, ?, ?, ?, ?)" +
                " ON CONFLICT (group_id) DO NOTHING";
        final String INSERT_TASK_ADDR = "INSERT" +
                " INTO bpms_task_addr (task_addr_id, task_id, seq, send_to_id)" +
                " VALUES (?, ?, ?, ?)" +
                " ON CONFLICT (task_addr_id) DO NOTHING";
        final String INSERT_TASK_EXECUTION_CONTEXT = "INSERT" +
                " INTO bpms_task_execution_context (task_execution_context_id, task_id, execution_context)" +
                " VALUES (?, ?, ?)" +
                " ON CONFLICT (task_execution_context_id) DO NOTHING";
        final String INSERT_TASK_NARR = "INSERT" +
                " INTO bpms_task_narr (task_narr_id, task_id, seq, narrative, narrative_raw, i18n_narratives, field1, field2, field3, field4, field5)" +
                " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" +
                " ON CONFLICT (task_narr_id) DO NOTHING";
        final String INSERT_TASK_FILE = "INSERT" +
                " INTO bpms_task_file (task_id, seq, file_id)" +
                " VALUES (?, ?, ?)";
        final String INSERT_TASK_IPF_DATA = "INSERT" +
                " INTO bpms_task_ipf_data (task_infopathform_data_id, task_id, infopath_form_ref, data)" +
                " VALUES (?, ?, ?, ?)";
        final String INSERT_TASK_EXTACT_DATA = "INSERT" +
                " INTO bpms_task_extact_data (task_extact_data_id, task_id, external_activity_ref, data)" +
                " VALUES (?, ?, ?, ?)";
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(archUrl, archUser, archPassword);
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(-1);
        }

        LSWTaskService LSWTaskService = new LSWTaskService();
        LSWBPDInstanceDataService LSWBPDInstanceDataService = new LSWBPDInstanceDataService();
        LSWUsrXrefService LSWUsrXrefService = new LSWUsrXrefService();
        LSWUsrGrpXrefService LSWUsrGrpXrefService = new LSWUsrGrpXrefService();
        LSWTaskAddrService LSWTaskAddrService = new LSWTaskAddrService();
        LSWTaskExecutionContextService LSWTaskExecutionContextService = new LSWTaskExecutionContextService();
        LSWTaskNarrService LSWTaskNarrService = new LSWTaskNarrService();
        LSWTaskFileService LSWTaskFileService = new LSWTaskFileService();
        LSWTaskIpfDataService LSWTaskIpfDataService = new LSWTaskIpfDataService();
        LSWTaskExtactDataService LSWTaskExtactDataService = new LSWTaskExtactDataService();

//        for (LSWBpdInstance LSWBpdInstance : LSWBpdInstances) {
//            System.out.println("Processing instance " + LSWBpdInstance.getBpdInstanceId());
//            try {
//                LSWBPDInstanceData LSWBPDInstanceData = LSWBPDInstanceDataService
//                        .findByBpdInstanceId(LSWBpdInstance.getBpdInstanceId());
//                ObjectNode objectNode = LSWBPDInstanceDataService.getBPDDataAsJson(LSWBPDInstanceData.getData());
//                List<LSWTask> LSWTasks = LSWTaskService.findAllByBpdInstanceId(LSWBpdInstance.getBpdInstanceId(), BPDActivityInstance.TaskType.USER_TASK.getValue());
//
//                // запись в архив
//                // метаданные инстанса
//                PreparedStatement preparedStatement = connection.prepareStatement(INSERT_METADATA_SQL);
//                preparedStatement.setLong(1, LSWBpdInstance.getBpdInstanceId());
//                preparedStatement.setString(2, LSWBpdInstance.getInstanceName());
//                preparedStatement.setDate(3, new java.sql.Date(LSWBpdInstance.getCreateDatetime().getTime()));
//                preparedStatement.setDate(4, new java.sql.Date(LSWBpdInstance.getDueDatetime().getTime()));
//                preparedStatement.setDate(5, new java.sql.Date(LSWBpdInstance.getLastModifiedDatetime().getTime()));
//
//                if (LSWBpdInstance.getCloseDatetime() == null)
//                    preparedStatement.setDate(6, null);
//                else
//                    preparedStatement.setDate(6, new java.sql.Date(LSWBpdInstance.getCloseDatetime().getTime()));
//
//                preparedStatement.setInt(7, LSWBpdInstance.getExecutionStatusId());
//                preparedStatement.setString(8, LSWBpdInstance.getSnapshotId());
//                preparedStatement.executeUpdate();
//                PreparedStatement preparedStatement1 = connection.prepareStatement(INSERT_BUSINESS_DATA_SQL);
//                preparedStatement1.setLong(1, LSWBpdInstance.getBpdInstanceId());
//                preparedStatement1.setString(2, objectNode.toString());
//                preparedStatement1.executeUpdate();
//
//                // метаданные таски
//                for (LSWTask LSWTask : LSWTasks) {
//                    PreparedStatement preparedStatement2 = connection.prepareStatement(INSERT_TASK_SQL);
//                    preparedStatement2.setLong(1, LSWTask.getTaskId());
//                    preparedStatement2.setString(2, LSWTask.getSubject());
//                    preparedStatement2.setLong(3, LSWTask.getBpdInstanceId());
//                    preparedStatement2.setInt(4, LSWTask.getActivityTaskType());
//                    preparedStatement2.setLong(5, LSWTask.getPriorityId());
//                    preparedStatement2.setDate(6, new java.sql.Date(LSWTask.getReceivedDatetime().getTime()));
//                    if (LSWTask.getCloseDatetime() == null)
//                        preparedStatement2.setDate(7, null);
//                    else
//                        preparedStatement2.setDate(7, new java.sql.Date(LSWTask.getCloseDatetime().getTime()));
//                    if (LSWTask.getReadDatetime() == null)
//                        preparedStatement2.setDate(8, null);
//                    else
//                        preparedStatement2.setDate(8, new java.sql.Date(LSWTask.getReadDatetime().getTime()));
//                    preparedStatement2.setDate(9, new java.sql.Date(LSWTask.getLastModifiedDatetime().getTime()));
//                    preparedStatement2.setDate(10, new java.sql.Date(LSWTask.getDueDatetime().getTime()));
//                    preparedStatement2.setLong(11, LSWTask.getUserId());
//                    preparedStatement2.setLong(12, LSWTask.getAssignedToGroupId());
//                    if (LSWTask.getClosedByUserId() == null)
//                        preparedStatement2.setNull(13, Types.INTEGER);
//                    else
//                        preparedStatement2.setLong(13, LSWTask.getClosedByUserId());
//                    preparedStatement2.executeUpdate();
//
//                    // назначено пользователю
//                    Long assignedToUserId = LSWTask.getUserId() > 0 ? LSWTask.getUserId() : -1 * LSWTask.getUserId();
//                    LSWUsrXref assignedToUser = LSWUsrXrefService.findByUserId(assignedToUserId);
//                    PreparedStatement preparedStatement3 = connection.prepareStatement(INSERT_USER_SQL);
//                    preparedStatement3.setLong(1, assignedToUser.getUserId());
//                    preparedStatement3.setString(2, assignedToUser.getUserName());
//                    preparedStatement3.setString(3, assignedToUser.getFullName());
//                    preparedStatement3.executeUpdate();
//
//                    // назначено группе
//                    Long assignedToGroupId = LSWTask.getAssignedToGroupId() > 0 ? LSWTask.getAssignedToGroupId() : -1 * LSWTask.getAssignedToGroupId();
//                    LSWUsrGrpXref assignedToGroup = LSWUsrGrpXrefService.findByGroupId(assignedToGroupId);
//                    PreparedStatement preparedStatement4 = connection.prepareStatement(INSERT_GROUP_SQL);
//                    preparedStatement4.setLong(1, assignedToGroup.getGroupId());
//                    preparedStatement4.setString(2, assignedToGroup.getGroupName());
//                    preparedStatement4.setString(3, assignedToGroup.getDisplayName());
//                    if (assignedToGroup.getParentGroupId() == null)
//                        preparedStatement4.setNull(4, Types.BIGINT);
//                    else
//                        preparedStatement4.setLong(4, assignedToGroup.getParentGroupId());
//                    preparedStatement4.setInt(5, assignedToGroup.getTypeId());
//                    preparedStatement4.setString(6, assignedToGroup.getDescription());
//                    preparedStatement4.setInt(7, assignedToGroup.getStateId());
//                    preparedStatement4.setString(8, assignedToGroup.getParticipantId());
//                    preparedStatement4.executeUpdate();
//
//                    // lsw_task_addr
//                    List<LSWTaskAddr> LSWTaskAddrs = LSWTaskAddrService.findByTaskId(LSWTask.getTaskId());
//                    for (LSWTaskAddr LSWTaskAddr : LSWTaskAddrs) {
//                        PreparedStatement preparedStatement5 = connection.prepareStatement(INSERT_TASK_ADDR);
//                        preparedStatement5.setLong(1, LSWTaskAddr.getTaskAddrId());
//                        preparedStatement5.setLong(2, LSWTaskAddr.getTaskId());
//                        preparedStatement5.setLong(3, LSWTaskAddr.getSeq());
//                        preparedStatement5.setString(4, LSWTaskAddr.getSendToId());
//                        preparedStatement5.executeUpdate();
//                    }
//
//                    // task_execution_context
//                    LSWTaskExecutionContext LSWTaskExecutionContext = LSWTaskExecutionContextService.findByTaskId(LSWTask.getTaskId());
//                    PreparedStatement preparedStatement6 = connection.prepareStatement(INSERT_TASK_EXECUTION_CONTEXT);
//                    preparedStatement6.setLong(1, LSWTaskExecutionContext.getTaskExecutionContextId());
//                    preparedStatement6.setLong(2, LSWTaskExecutionContext.getTaskId());
//                    preparedStatement6.setBytes(3, LSWTaskExecutionContext.getExecutionContext());
//                    preparedStatement6.executeUpdate();
//
//                    // task_narr
//                    LSWTaskNarr LSWTaskNarr = LSWTaskNarrService.findByTaskId(LSWTask.getTaskId());
//                    if (LSWTaskNarr != null) {
//                        PreparedStatement preparedStatement7 = connection.prepareStatement(INSERT_TASK_NARR);
//                        preparedStatement7.setLong(1, LSWTaskNarr.getTaskNarrId());
//                        preparedStatement7.setLong(2, LSWTaskNarr.getTaskId());
//                        preparedStatement7.setLong(3, LSWTaskNarr.getSeq());
//                        preparedStatement7.setBytes(4, LSWTaskNarr.getNarrative());
//                        preparedStatement7.setBytes(5, LSWTaskNarr.getNarrativeRaw());
//                        preparedStatement7.setBytes(6, LSWTaskNarr.getI18nNarratives());
//                        preparedStatement7.setObject(7, LSWTaskNarr.getField1());
//                        preparedStatement7.setObject(8, LSWTaskNarr.getField2());
//                        preparedStatement7.setObject(9, LSWTaskNarr.getField3());
//                        preparedStatement7.setObject(10, LSWTaskNarr.getField4());
//                        preparedStatement7.setObject(11, LSWTaskNarr.getField5());
//                        preparedStatement7.executeUpdate();
//                    }
//
//                    // task_file
//                    List<LSWTaskFile> LSWTaskFiles = LSWTaskFileService.findByTaskId(LSWTask.getTaskId());
//                    for (LSWTaskFile LSWTaskFile : LSWTaskFiles) {
//                        PreparedStatement preparedStatement8 = connection.prepareStatement(INSERT_TASK_FILE);
//                        preparedStatement8.setLong(1, LSWTaskFile.getFileId());
//                        preparedStatement8.setLong(2, LSWTaskFile.getSeq());
//                        preparedStatement8.setLong(3, LSWTaskFile.getFileId());
//                        preparedStatement8.executeUpdate();
//                    }
//
//                    // task_ipf_data
//                    List<LSWTaskIpfData> LSWTaskIpfDataList = LSWTaskIpfDataService.findByTaskId(LSWTask.getTaskId());
//                    for (LSWTaskIpfData LSWTaskIpfData : LSWTaskIpfDataList) {
//                        PreparedStatement preparedStatement9 = connection.prepareStatement(INSERT_TASK_IPF_DATA);
//                        preparedStatement9.setLong(1, LSWTaskIpfData.getTaskInfopathformDataId());
//                        preparedStatement9.setLong(2, LSWTaskIpfData.getTaskId());
//                        preparedStatement9.setString(3, LSWTaskIpfData.getInfopathFormRef());
//                        preparedStatement9.setBytes(4, LSWTaskIpfData.getData());
//                        preparedStatement9.executeUpdate();
//                    }
//
//                    // task_extact_data
//                    List<LSWTaskExtactData> LSWTaskExtactDataList = LSWTaskExtactDataService.findByTaskId(LSWTask.getTaskId());
//                    for (LSWTaskExtactData LSWTaskExtactData : LSWTaskExtactDataList) {
//                        PreparedStatement preparedStatement10 = connection.prepareStatement(INSERT_TASK_EXTACT_DATA);
//                        preparedStatement10.setLong(1, LSWTaskExtactData.getTaskExtactDataId());
//                        preparedStatement10.setLong(2, LSWTaskExtactData.getTaskId());
//                        preparedStatement10.setString(3, LSWTaskExtactData.getExternalActivityRef());
//                        preparedStatement10.setBytes(4, LSWTaskExtactData.getData());
//                        preparedStatement10.executeUpdate();
//                    }
//
//
//
//                }
//
//            } catch (IOException | ClassNotFoundException | NoSuchFieldException | IllegalAccessException e) {
//                e.printStackTrace();
//            } finally {
//                System.out.println("processed " + LSWBpdInstance.getBpdInstanceId());
//            }
//        }
        connection.close();
    }

}
