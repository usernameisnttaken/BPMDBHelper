package ru.ertelecom.bpms.db.utils;

import com.ibm.bpm.enums.InstanceStatus;
import ru.ertelecom.bpms.db.entity.*;
import ru.ertelecom.bpms.db.service.*;

import javax.persistence.Column;
import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class Test1 {
    public static void test()
        throws SQLException, IntrospectionException, IllegalAccessException, InvocationTargetException {
        // записывать в архив пока будем через jdbc
        final String archUrl = "jdbc:postgresql://10.121.15.70:5432/hdlake";
        final String archUser = "archivar";
        final String archPassword = "v8dYEh3hd9k1";
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(archUrl, archUser, archPassword);
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(-1);
        }
        connection.setAutoCommit(false);

        //  сервисы для получения сущностей
        LSWTaskService lswTaskService = new LSWTaskService();
        LSWBPDInstanceDataService lswbpdInstanceDataService = new LSWBPDInstanceDataService();
        LSWUsrXrefService LSWUsrXrefService = new LSWUsrXrefService();
        LSWUsrGrpXrefService lswUsrGrpXrefService = new LSWUsrGrpXrefService();
        LSWTaskAddrService lswTaskAddrService = new LSWTaskAddrService();
        LSWTaskExecutionContextService lswTaskExecutionContextService = new LSWTaskExecutionContextService();
        LSWTaskNarrService lswTaskNarrService = new LSWTaskNarrService();
        LSWTaskFileService lswTaskFileService = new LSWTaskFileService();
        LSWTaskIpfDataService lswTaskIpfDataService = new LSWTaskIpfDataService();
        LSWTaskExtactDataService lswTaskExtactDataService = new LSWTaskExtactDataService();
        BPMECMObjectService bpmecmObjectService = new BPMECMObjectService();
        LSWBPDInstanceSharedUsageService lswbpdInstanceSharedUsageService = new LSWBPDInstanceSharedUsageService();
        LSWBPDActivityInstanceService lswbpdActivityInstanceService = new LSWBPDActivityInstanceService();
        LSWInstMsgExclService lswInstMsgExclService = new LSWInstMsgExclService();
        LSWInstMsgInclService lswInstMsgInclService = new LSWInstMsgInclService();
        LSWRuntimeErrorService lswRuntimeErrorService = new LSWRuntimeErrorService();
        LSWBPDNotificationService lswbpdNotificationService = new LSWBPDNotificationService();
        LSWBPDInstanceExtDataService lswbpdInstanceExtDataService = new LSWBPDInstanceExtDataService();
        LSWBPDInstanceCorrelationService lswbpdInstanceCorrelationService = new LSWBPDInstanceCorrelationService();
        LSWBPDInstanceVariablesService lswbpdInstanceVariablesService = new LSWBPDInstanceVariablesService();
        LSWBPDInstanceDocumentsService lswbpdInstanceDocumentsService = new LSWBPDInstanceDocumentsService();
        LSWBPDInstanceDocPropsService lswbpdInstanceDocPropsService = new LSWBPDInstanceDocPropsService();

        // для разработки
//        List<LSWBpdInstance> lswBpdInstances = (List<LSWBpdInstance>)
//                BPMHibernateSessionFactoryUtil
//                        .getSessionFactory()
//                        .openSession()
//                        .createQuery("FROM " +
//                                "LSWBpdInstance bpi " +
//                                "WHERE " +
//                                "bpi.bpdInstanceId IN (70997,71084,71085,71086,71107,71108,71109,71130,71131,71132,71133,71154,71155,71156,71157,71158,71184,71185,71222,71223,71228)")
//                        .list();
        BPMProjectService bpmProjectService = new BPMProjectService();
        BPMProject bpmProject = bpmProjectService.findByAcronym("STRME");
        List<LSWBpdInstance> lswBpdInstances = (List<LSWBpdInstance>)
                BPMHibernateSessionFactoryUtil
                        .getSessionFactory()
                        .openSession()
                        .createQuery("FROM " +
                                "LSWBpdInstance bpi " +
                                "WHERE " +
                                "bpi.projectId = :projectId " +
                                "and bpi.executionStatus = :executionStatus")
                        .setParameter("projectId", bpmProject.getProjectId())
                        .setParameter("executionStatus", InstanceStatus.COMPLETED.getValue())
                        .list();
        System.out.println("Found " + lswBpdInstances.size() + " instances");
        for (LSWBpdInstance lswbpdInstance : lswBpdInstances) {
            System.out.println("Processing instance: " + lswbpdInstance.getBpdInstanceId());

            // LSW_BPD_INSTANCE
            persistToArchiveDB(connection, lswbpdInstance);

            // LSW_BPD_INSTANCE_DATA
            LSWBPDInstanceData lswbpdInstanceData = lswbpdInstanceDataService.findByBpdInstanceId(lswbpdInstance.getBpdInstanceId());
            persistToArchiveDB(connection, lswbpdInstanceData);

            // LSW_TASK
            List<LSWTask> lswTasks = lswTaskService.findByBpdInstanceId(lswbpdInstance.getBpdInstanceId());
            System.out.println("found " + lswTasks.size() + " tasks");
            for (LSWTask lswTask : lswTasks) {
                System.out.println("processing task " + lswTask.getTaskId());
                persistToArchiveDB(connection, lswTask);

                // LSW_TASK_EXTACT_DATA
                List<LSWTaskExtactData> lswTaskExtactDataList = lswTaskExtactDataService.findByTaskId(lswTask.getTaskId());
                System.out.println("found " + lswTaskExtactDataList.size() + " lsw_task_extact_data");
                for (LSWTaskExtactData lswTaskExtactData : lswTaskExtactDataList) {
                    System.out.println("processing " + lswTaskExtactData.getTaskExtactDataId() + " task extact data");
                    persistToArchiveDB(connection, lswTaskExtactData);
                }

                // LSW_TASK_IPF_DATA
                List<LSWTaskIpfData> lswTaskIpfDataList = lswTaskIpfDataService.findByTaskId(lswTask.getTaskId());
                System.out.println("found " + lswTaskIpfDataList.size() + " in lsw_task_ipf_data");
                for (LSWTaskIpfData lswTaskIpfData : lswTaskIpfDataList) {
                    System.out.println("processing " + lswTaskIpfData.getTaskInfopathformDataId() + " lsw task ipf data");
                    persistToArchiveDB(connection, lswTaskIpfData);
                }

                // LSW_TASK_FILE
                List<LSWTaskFile> lswTaskFiles = lswTaskFileService.findByTaskId(lswTask.getTaskId());
                System.out.println("found " + lswTaskFiles.size() + " lsw_task_file");
                for (LSWTaskFile lswTaskFile : lswTaskFiles) {
                    System.out.println("processing " + lswTaskFile.getFileId() + " lsw task file");
                    persistToArchiveDB(connection, lswTaskFile);
                }

                // LSW_TASK_NARR
                List<LSWTaskNarr> lswTaskNarrs = lswTaskNarrService.findByTaskId(lswTask.getTaskId());
                System.out.println("found " + lswTaskNarrs.size() + " lsw_task_narr");
                for (LSWTaskNarr lswTaskNarr : lswTaskNarrs) {
                    System.out.println("processing " + lswTaskNarr.getTaskNarrId() + " lsw task narr");
                    persistToArchiveDB(connection, lswTaskNarr);
                }

                // LSW_TASK_EXECUTION_CONTEXT
                List<LSWTaskExecutionContext> lswTaskExecutionContexts = lswTaskExecutionContextService.findByTaskId(lswTask.getTaskId());
                System.out.println("found " + lswTaskExecutionContexts.size() + " lsw_task_execution_context");
                for (LSWTaskExecutionContext lswTaskExecutionContext : lswTaskExecutionContexts) {
                    System.out.println("processing " + lswTaskExecutionContext.getTaskExecutionContextId() + " lsw task execution context");
                    persistToArchiveDB(connection, lswTaskExecutionContext);
                }

                // LSW_TASK_ADDR
                List<LSWTaskAddr> lswTaskAddrs = lswTaskAddrService.findByTaskId(lswTask.getTaskId());
                System.out.println("found " + lswTaskAddrs.size() + " lsw_task_addr");
                for (LSWTaskAddr lswTaskAddr : lswTaskAddrs) {
                    System.out.println("processing " + lswTaskAddr.getTaskAddrId() + " lsw task addr");
                    persistToArchiveDB(connection, lswTaskAddr);
                }
            }

            // BPM_ECM_OBJECT
            List<BPMECMObject> bpmecmObjects = bpmecmObjectService.findByBPDInstanceId(lswbpdInstance.getBpdInstanceId());
            System.out.println("found " + bpmecmObjects.size() + " bpm_ecm_object");
            for (BPMECMObject bpmecmObject : bpmecmObjects) {
                System.out.println("processing " + bpmecmObject.getEcmObjectId() + " bpm_ecm_object");
                persistToArchiveDB(connection, bpmecmObject);
            }

            // LSW_BPD_INSTANCE_SHARED_USAGE
            List<LSWBpdInstanceSharedUsage> LSWBpdInstanceSharedUsages = lswbpdInstanceSharedUsageService.findByBpdInstanceId(lswbpdInstance.getBpdInstanceId());
            System.out.println("found " + LSWBpdInstanceSharedUsages.size() + " lsw_bpd_instance_shared_usage");
            for (LSWBpdInstanceSharedUsage lswbpdInstanceSharedUsage : LSWBpdInstanceSharedUsages) {
                System.out.println("processing " + lswbpdInstanceSharedUsage.getBpdInstanceId() + " " + lswbpdInstanceSharedUsage.getSharedObjectId() + " lsw_bpd_instance_shared_usage");
                persistToArchiveDB(connection, lswbpdInstanceSharedUsage);
            }

            // LSW_BPD_ACTIVITY_INSTANCE
            List<LSWBPDActivityInstance> lswbpdActivityInstances = lswbpdActivityInstanceService.findByBPDInstanceId(lswbpdInstance.getBpdInstanceId());
            System.out.println("found " + lswbpdActivityInstances.size() + " lsw_bpd_activity_instance");
            for (LSWBPDActivityInstance lswbpdActivityInstance : lswbpdActivityInstances) {
                persistToArchiveDB(connection, lswbpdActivityInstance);
            }

            // LSW_INST_MSG_EXCL
            List<LSWInstMsgExcl> lswInstMsgExcls = lswInstMsgExclService.findByBpdInstanceId(lswbpdInstance.getBpdInstanceId());
            System.out.println("found " + lswInstMsgExcls.size() + " lsw_inst_msg_excl");
            for (LSWInstMsgExcl lswInstMsgExcl : lswInstMsgExcls) {
                persistToArchiveDB(connection, lswInstMsgExcl);
            }

            // LSW_INST_MSG_INCL
            List<LSWInstMsgIncl> lswInstMsgIncls = lswInstMsgInclService.finByBpdInstanceId(lswbpdInstance.getBpdInstanceId());
            System.out.println("found " + lswInstMsgIncls.size() + " lsw_inst_msg_incl");
            for (LSWInstMsgIncl lswInstMsgIncl : lswInstMsgIncls) {
                persistToArchiveDB(connection, lswInstMsgIncl);
            }

            // LSW_RUNTIME_ERROR
            List<LSWRuntimeError> lswRuntimeErrors = lswRuntimeErrorService.findByBpdInstanceId(lswbpdInstance.getBpdInstanceId());
            System.out.println("found " + lswRuntimeErrors.size() + " lsw_runtime_error");
            for (LSWRuntimeError lswRuntimeError : lswRuntimeErrors) {
                persistToArchiveDB(connection, lswRuntimeError);
            }

            // LSW_BPD_NOTIFICATION
            List<LSWBPDNotification> lswbpdNotifications = lswbpdNotificationService.findByBpdInstanceId(lswbpdInstance.getBpdInstanceId());
            System.out.println("found " + lswbpdNotifications.size() + " lsw_bpd_notification");
            for (LSWBPDNotification lswbpdNotification : lswbpdNotifications) {
                persistToArchiveDB(connection, lswbpdNotification);
            }

            // LSW_BPD_INSTANCE_EXT_DATA
            List<LSWBPDInstanceExtData> lswbpdInstanceExtDataList = lswbpdInstanceExtDataService.findByBpdInstanceId(lswbpdInstance.getBpdInstanceId());
            System.out.println("found " + lswbpdInstanceExtDataList.size() + " lsw_bpd_instance_ext_data");
            for(LSWBPDInstanceExtData lswbpdInstanceExtData : lswbpdInstanceExtDataList) {
                persistToArchiveDB(connection, lswbpdInstanceExtData);
            }

            // LSW_BPD_INSTANCE_CORRELATION
            List<LSWBPDInstanceCorrelation> lswbpdInstanceCorrelations = lswbpdInstanceCorrelationService.findByBPDInstanceId(lswbpdInstance.getBpdInstanceId());
            System.out.println("found " + lswbpdInstanceCorrelations.size() + " lsw_bpd_instance_correlation");
            for (LSWBPDInstanceCorrelation lswbpdInstanceCorrelation : lswbpdInstanceCorrelations) {
                persistToArchiveDB(connection, lswbpdInstanceCorrelation);
            }

            // LSW_BPD_INSTANCE_VARIABLES
            List<LSWBPDInstanceVariables> lswbpdInstanceVariablesList = lswbpdInstanceVariablesService.findByBpdInstanceId(lswbpdInstance.getBpdInstanceId());
            System.out.println("found " + lswbpdInstanceVariablesList.size() + " lsw_bpd_instance_variables");
            for (LSWBPDInstanceVariables lswbpdInstanceVariables : lswbpdInstanceVariablesList) {
                persistToArchiveDB(connection, lswbpdInstanceVariables);
            }

            // LSW_BPD_INSTANCE_DOCUMENTS
            List<LSWBPDInstanceDocuments> lswbpdInstanceDocumentsList = lswbpdInstanceDocumentsService.findByBpdInstanceId(lswbpdInstance.getBpdInstanceId());
            System.out.println("found " + lswbpdInstanceDocumentsList.size() + " lsw_bpd_instance_documents");
            for (LSWBPDInstanceDocuments lswbpdInstanceDocuments : lswbpdInstanceDocumentsList) {
                persistToArchiveDB(connection, lswbpdInstanceDocuments);
                // LSW_BPD_INSTANCE_DOC_PROPS
                List<LSWBPDInstanceDocProps> lswbpdInstanceDocPropsList = lswbpdInstanceDocPropsService.findByDocId(lswbpdInstanceDocuments.getDocId());
                System.out.println("found " + lswbpdInstanceDocPropsList.size() + " lsw_bpd_instance_doc_props");
                for (LSWBPDInstanceDocProps lswbpdInstanceDocProps : lswbpdInstanceDocPropsList) {
                    persistToArchiveDB(connection, lswbpdInstanceDocProps);
                }
            }
            connection.commit();
        }

        connection.close();
    }

    private static void persistToArchiveDB(final Connection connection,
                                    final BPMDBEntity bpmdbEntity)
        throws SQLException, IntrospectionException, IllegalAccessException, InvocationTargetException {
        String sql = "INSERT INTO";
        String table = bpmdbEntity.getClass().getAnnotation(javax.persistence.Table.class).name();
        sql += " \"" + table + "\"";
        Field[] fields = bpmdbEntity.getClass().getDeclaredFields();
        String[] dbFields = new String[fields.length];
        String[] values = new String[fields.length];
        for (int i = 0; i < fields.length; i++) {
            dbFields[i] = "\"" + fields[i].getAnnotation(Column.class).name() + "\"";
            values[i] = "?";
        }
        sql += " (" +  String.join(",", dbFields) + ") VALUES (" + String.join(",", values) + ");";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        for (int i = 0; i < fields.length; i++) {
            preparedStatement.setObject(i + 1, new PropertyDescriptor(fields[i].getName(), bpmdbEntity.getClass()).getReadMethod().invoke(bpmdbEntity));
        }
        preparedStatement.executeUpdate();

    }

}
