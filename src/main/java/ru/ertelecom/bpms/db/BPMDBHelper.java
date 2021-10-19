package ru.ertelecom.bpms.db;

import com.lombardisoftware.core.TWObject;
import ru.ertelecom.bpms.db.entity.BPMProcessInstance;
import ru.ertelecom.bpms.db.entity.BPMProcessInstanceData;
import ru.ertelecom.bpms.db.entity.BPMTaskInstance;
import ru.ertelecom.bpms.db.service.BPMProcessInstanceDataService;
import ru.ertelecom.bpms.db.service.BPMTaskInstanceService;
import ru.ertelecom.bpms.db.utils.BPMHibernateSessionFactoryUtil;
import ru.ertelecom.bpms.reports.entities.B2B3ReportEntity;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.zip.GZIPInputStream;
import com.ibm.bpm.enums.InstanceStatus;
import com.lombardisoftware.client.persistence.BPDActivityInstance.TaskType;


public class BPMDBHelper {
    public static void main(String[] args)
            throws Exception {
        long startTime = System.nanoTime();

        // выгрузка по подключке
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String afterStr = "10/11/2020 00:00:01";
        String beforeStr = "01/10/2021 23:59:59";
        Date after = sdf.parse(afterStr);
        Date before = sdf.parse(beforeStr);
        List<BPMProcessInstance> bpmProcessInstances = (List<BPMProcessInstance>)
                BPMHibernateSessionFactoryUtil
                        .getSessionFactory()
                        .openSession()
                        .createQuery("FROM " +
                                "BPMProcessInstance bpi " +
                                "WHERE " +
                                "bpi.bpmProject.acronym = :acronym " +
                                "and bpi.executionStatusId in (:statusIds)" +
                                "and bpi.createDatetime between :after and :before")
                        .setParameter("acronym", "B2B3")
                        .setParameter("statusIds", Arrays.asList(InstanceStatus.ACTIVE.getValue(), InstanceStatus.COMPLETED.getValue()))
                        .setParameter("after", after)
                        .setParameter("before", before)
                        .list();

        List<B2B3ReportEntity> b2B3ReportEntities = new ArrayList<>();
        BPMTaskInstanceService bpmTaskInstanceService = new BPMTaskInstanceService();
        BPMProcessInstanceDataService bpmProcessInstanceDataService = new BPMProcessInstanceDataService();
        bpmProcessInstances.forEach(bpmProcessInstance -> {
            System.out.println("Processing instance " + bpmProcessInstance.getBpdInstanceId());
            B2B3ReportEntity b2B3ReportEntity = new B2B3ReportEntity();
            List<BPMTaskInstance> bpmTaskInstances = bpmTaskInstanceService
                    .findAllByBpdInstanceId(bpmProcessInstance.getBpdInstanceId(), TaskType.USER_TASK.getValue());
            BPMProcessInstanceData bpmProcessInstanceData = bpmProcessInstanceDataService
                    .findByBpdInstanceId(bpmProcessInstance.getBpdInstanceId());
            try {
                HashMap<String, TWObject> data = bpmProcessInstanceDataService.getBPMProcessInstanceData(bpmProcessInstanceData.getData());
                TWObject requestData = data.get("requestData");
                b2B3ReportEntity.setCityId(0);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                System.out.println("processed " + bpmProcessInstance.getBpdInstanceId());
            }
        });
        long endTime   = System.nanoTime();
        long totalTime = endTime - startTime;
        System.out.println("run time = " + totalTime / 1000000000 + " seconds");
        System.out.println("That's all folks!");
    }

    // десереализация для любого класса
    public static <T> T deserialize(final Class<T> tClass, final byte[] bytes)
            throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(new GZIPInputStream(new ByteArrayInputStream(bytes)));
        return tClass.cast(objectInputStream.readObject());
    }
}
