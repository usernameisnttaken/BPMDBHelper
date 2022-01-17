package ru.ertelecom.bpms.db.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.lombardisoftware.bpd.runtime.engine.BPDExecutionContext;
import com.lombardisoftware.bpd.runtime.engine.RootBPDExecutionTreeNode;
import com.lombardisoftware.bpd.runtime.engine.st.LocalBPDSymbolTable;
import com.lombardisoftware.core.TWObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.jdom.output.XMLOutputter;
import ru.ertelecom.bpms.db.dao.BPMProcessInstanceDataDAO;
import ru.ertelecom.bpms.db.entity.BPMProcessInstanceData;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.lang.reflect.Field;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.zip.GZIPInputStream;


/**
 * @author Evgeniy Fedoseev
 */
public class BPMProcessInstanceDataService {
    public static final DateFormat ISO8601 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm'Z'");
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    private final BPMProcessInstanceDataDAO bpmProcessInstanceDataDAO = new BPMProcessInstanceDataDAO();

    public BPMProcessInstanceDataService() {
    }

    public BPMProcessInstanceData findByBpdInstanceId(Long bpdInstanceId) {
        return bpmProcessInstanceDataDAO.findByBpdInstanceId(bpdInstanceId);
    }

    public List<BPMProcessInstanceData> findAll() {
        return bpmProcessInstanceDataDAO.findAll();
    }

    public ObjectNode getBPDDataAsJson (final byte[] bytes)
            throws IOException, ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
        BPDExecutionContext bpdExecutionContext = this.deserialize(bytes);
        RootBPDExecutionTreeNode rootBPDExecutionTreeNode = bpdExecutionContext.getExecutionTree().getRoot();
        Field f = rootBPDExecutionTreeNode.getClass().getSuperclass().getDeclaredField("localSymbolTable");
        f.setAccessible(true);
        LocalBPDSymbolTable localBPDSymbolTable = (LocalBPDSymbolTable) f.get(rootBPDExecutionTreeNode);
        Field f1 = localBPDSymbolTable.getClass().getSuperclass().getDeclaredField("data");
        f1.setAccessible(true);
        HashMap<String, TWObject> localBPDSymbolTableData = (HashMap<String, TWObject>) f1.get(localBPDSymbolTable);

        return transformBPMSHashMapToJSON(localBPDSymbolTableData);
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

    public static ObjectNode transformBPMSHashMapToJSON(HashMap<String, ?> hashMap) {
        ObjectNode objectNode = OBJECT_MAPPER.createObjectNode();
        for (String key : hashMap.keySet()) {
            Object value = hashMap.get(key);
            if (value == null) {
                objectNode.put(key, "null");
            }
            else {
                switch (value.getClass().getName()) {
                    case ("com.lombardisoftware.core.TWObject"):
                        try{
                            JsonNode childNode = transformTWObjectToJSON((TWObject) value);
                            objectNode.set(key, childNode);
                        } catch (NoSuchFieldException | IllegalAccessException  e) {
                            e.printStackTrace();
                        }
                        break;
                    case ("java.lang.Boolean"):
                        objectNode.put(key, (boolean) value);
                        break;
                    case ("java.lang.String"):
                        objectNode.put(key, value.toString());
                        break;
                    case ("java.lang.Integer"):
                        objectNode.put(key, (int) value);
                        break;
                    case ("java.lang.Double"):
                        objectNode.put(key, (double) value);
                        break;
                    case ("java.util.GregorianCalendar"):
                        GregorianCalendar cal = (GregorianCalendar) value;
                        Date date = cal.getTime();
                        objectNode.put(key, ISO8601.format(date));
                        break;
                    case ("org.jdom.Element"):
                        XMLOutputter xmlOutputter = new XMLOutputter();
                        objectNode.put(key, xmlOutputter.outputString((org.jdom.Element) value));
                        break;
                    default:
                        objectNode.put(key, "UNKNOWN: " + value.getClass().getName());
                        break;
                }
            }
        }
        return objectNode;
    }

    private static JsonNode transformTWObjectToJSON(TWObject twObject)
            throws NoSuchFieldException, IllegalAccessException {
        JsonNode jsonNode;
        Field serializedFormField = twObject.getClass().getDeclaredField("serializedForm");
        serializedFormField.setAccessible(true);
        Object serializedFormObj = serializedFormField.get(twObject);
        Field serializedFormTypeField = serializedFormObj.getClass().getDeclaredField("type");
        serializedFormTypeField.setAccessible(true);
        Integer serializedFormTypeValue = (Integer) serializedFormTypeField.get(serializedFormObj);
        switch (serializedFormTypeValue) {
            case (TWObject.TYPE_PROPERTIES):
                Field serializedFormPropertiesField = serializedFormObj.getClass().getDeclaredField("properties");
                serializedFormPropertiesField.setAccessible(true);
                LinkedHashMap<String, Object> properties = (LinkedHashMap<String, Object>) serializedFormPropertiesField.get(serializedFormObj);
                jsonNode = transformBPMSHashMapToJSON(properties);
                break;
            case (TWObject.TYPE_ARRAY):
                ArrayNode arrayNode = OBJECT_MAPPER.createArrayNode();
                Field arrayField = serializedFormObj.getClass().getDeclaredField("array");
                arrayField.setAccessible(true);
                ArrayList arrayList = (ArrayList) arrayField.get(serializedFormObj);
                for (Object obj : arrayList) {
                    if (obj.getClass().getName().equals("com.lombardisoftware.core.TWObject"))
                        arrayNode.add(transformTWObjectToJSON((TWObject) obj));
                    else
                        switch (obj.getClass().getName()) {
                            case ("java.lang.Boolean"):
                                arrayNode.add((Boolean) obj);
                                break;
                            case ("java.lang.String"):
                                arrayNode.add(obj.toString());
                                break;
                            case ("java.lang.Integer"):
                                arrayNode.add((int) obj);
                                break;
                            case ("java.lang.Double"):
                                arrayNode.add((double) obj);
                                break;
                            case ("java.util.GregorianCalendar"):
                                GregorianCalendar cal = (GregorianCalendar) obj;
                                Date date = cal.getTime();
                                arrayNode.add(ISO8601.format(date));
                                break;
                            case ("org.jdom.Element"):
                                XMLOutputter xmlOutputter = new XMLOutputter();
                                arrayNode.add(xmlOutputter.outputString((org.jdom.Element) obj));
                                break;
                            default:
                                arrayNode.add("UNKNOWN: " + obj.getClass().getName());
                                break;
                        }
                }
//                List<TWObject> twObjects = (List<TWObject>) arrayField.get(serializedFormObj);
//                for (TWObject obj : twObjects)
//                    arrayNode.add(transformTWObjectToJSON(obj));
                jsonNode = arrayNode;
                break;
            default:
                throw new RuntimeException("Unknown TWObject type!");
        }
        return jsonNode;
    }

}
