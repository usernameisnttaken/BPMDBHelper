package ru.ertelecom.bpms.db.service;

import com.lombardisoftware.bpd.runtime.engine.BPDExecutionContext;
import com.lombardisoftware.bpd.runtime.engine.RootBPDExecutionTreeNode;
import com.lombardisoftware.bpd.runtime.engine.st.LocalBPDSymbolTable;
import com.lombardisoftware.core.TWObject;
import ru.ertelecom.bpms.db.dao.BPMProcessInstanceDataDAO;
import ru.ertelecom.bpms.db.entity.BPMProcessInstanceData;

import java.io.*;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.zip.GZIPInputStream;


public class BPMProcessInstanceDataService {
    private BPMProcessInstanceDataDAO bpmProcessInstanceDataDAO = new BPMProcessInstanceDataDAO();

    public BPMProcessInstanceDataService() {
    }

    public BPMProcessInstanceData findByBpdInstanceId(Long bpdInstanceId) {
        return bpmProcessInstanceDataDAO.findByBpdInstanceId(bpdInstanceId);
    }

    public List<BPMProcessInstanceData> findAll() {
        return bpmProcessInstanceDataDAO.findAll();
    }

    public HashMap<String, TWObject> getBPMProcessInstanceData(final byte[] bytes)
            throws IOException, ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
        BPDExecutionContext bpdExecutionContext = this.deserialize(bytes);
        RootBPDExecutionTreeNode rootBPDExecutionTreeNode = bpdExecutionContext.getExecutionTree().getRoot();
        Field f = rootBPDExecutionTreeNode.getClass().getSuperclass().getDeclaredField("localSymbolTable");
        f.setAccessible(true);
        LocalBPDSymbolTable localBPDSymbolTable = (LocalBPDSymbolTable) f.get(rootBPDExecutionTreeNode);
        Field f1 = localBPDSymbolTable.getClass().getSuperclass().getDeclaredField("data");
        f1.setAccessible(true);
        return  (HashMap<String, TWObject>) f1.get(localBPDSymbolTable);
    }

    private BPDExecutionContext deserialize(final byte[] bytes)
            throws IOException, ClassNotFoundException {
        ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
        GZIPInputStream gis = new GZIPInputStream(bis);
        ObjectInputStream ois = new ObjectInputStream(gis);
        BPDExecutionContext bpdExecutionContext = (BPDExecutionContext) (ois.readObject());
        bis.close();
        gis.close();
        ois.close();
        return bpdExecutionContext;
    }

//    private <T> T getFieldValue(final Class<T> tClass, final String fieldName, final Object object) {
//        Field f;
//        try {
//            f = object.getClass().getDeclaredField(fieldName);
//        } catch (NoSuchFieldException e) {
//            f = object.getClass().getSuperclass().getDeclaredField(fieldName);
//        }
//        f.setAccessible(true);
//        LocalBPDSymbolTable localBPDSymbolTable = (LocalBPDSymbolTable) f.get(rootBPDExecutionTreeNode);
//    }
}
