package io.realm;


import android.annotation.TargetApi;
import android.os.Build;
import android.util.JsonReader;
import android.util.JsonToken;
import io.realm.ImportFlag;
import io.realm.ProxyUtils;
import io.realm.exceptions.RealmMigrationNeededException;
import io.realm.internal.ColumnInfo;
import io.realm.internal.NativeContext;
import io.realm.internal.OsList;
import io.realm.internal.OsMap;
import io.realm.internal.OsObject;
import io.realm.internal.OsObjectSchemaInfo;
import io.realm.internal.OsSchemaInfo;
import io.realm.internal.OsSet;
import io.realm.internal.Property;
import io.realm.internal.RealmObjectProxy;
import io.realm.internal.Row;
import io.realm.internal.Table;
import io.realm.internal.android.JsonUtils;
import io.realm.internal.core.NativeRealmAny;
import io.realm.internal.objectstore.OsObjectBuilder;
import io.realm.log.RealmLog;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@SuppressWarnings("all")
public class com_example_weatherapp_NoteApp_NoteRealmProxy extends com.example.weatherapp.NoteApp.Note
    implements RealmObjectProxy, com_example_weatherapp_NoteApp_NoteRealmProxyInterface {

    static final class NoteColumnInfo extends ColumnInfo {
        long idColKey;
        long titleColKey;
        long descriptionColKey;
        long createdTimeColKey;

        NoteColumnInfo(OsSchemaInfo schemaInfo) {
            super(4);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("Note");
            this.idColKey = addColumnDetails("id", "id", objectSchemaInfo);
            this.titleColKey = addColumnDetails("title", "title", objectSchemaInfo);
            this.descriptionColKey = addColumnDetails("description", "description", objectSchemaInfo);
            this.createdTimeColKey = addColumnDetails("createdTime", "createdTime", objectSchemaInfo);
        }

        NoteColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new NoteColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final NoteColumnInfo src = (NoteColumnInfo) rawSrc;
            final NoteColumnInfo dst = (NoteColumnInfo) rawDst;
            dst.idColKey = src.idColKey;
            dst.titleColKey = src.titleColKey;
            dst.descriptionColKey = src.descriptionColKey;
            dst.createdTimeColKey = src.createdTimeColKey;
        }
    }

    private static final String NO_ALIAS = "";
    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();

    private NoteColumnInfo columnInfo;
    private ProxyState<com.example.weatherapp.NoteApp.Note> proxyState;

    com_example_weatherapp_NoteApp_NoteRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (NoteColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.example.weatherapp.NoteApp.Note>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$id() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.idColKey);
    }

    @Override
    public void realmSet$id(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.idColKey, row.getObjectKey(), true);
                return;
            }
            row.getTable().setString(columnInfo.idColKey, row.getObjectKey(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.idColKey);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.idColKey, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$title() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.titleColKey);
    }

    @Override
    public void realmSet$title(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.titleColKey, row.getObjectKey(), true);
                return;
            }
            row.getTable().setString(columnInfo.titleColKey, row.getObjectKey(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.titleColKey);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.titleColKey, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$description() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.descriptionColKey);
    }

    @Override
    public void realmSet$description(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.descriptionColKey, row.getObjectKey(), true);
                return;
            }
            row.getTable().setString(columnInfo.descriptionColKey, row.getObjectKey(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.descriptionColKey);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.descriptionColKey, value);
    }

    @Override
    @SuppressWarnings("cast")
    public long realmGet$createdTime() {
        proxyState.getRealm$realm().checkIfValid();
        return (long) proxyState.getRow$realm().getLong(columnInfo.createdTimeColKey);
    }

    @Override
    public void realmSet$createdTime(long value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.createdTimeColKey, row.getObjectKey(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.createdTimeColKey, value);
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder(NO_ALIAS, "Note", false, 4, 0);
        builder.addPersistedProperty(NO_ALIAS, "id", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty(NO_ALIAS, "title", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty(NO_ALIAS, "description", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty(NO_ALIAS, "createdTime", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static NoteColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new NoteColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "Note";
    }

    public static final class ClassNameHelper {
        public static final String INTERNAL_CLASS_NAME = "Note";
    }

    @SuppressWarnings("cast")
    public static com.example.weatherapp.NoteApp.Note createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.example.weatherapp.NoteApp.Note obj = realm.createObjectInternal(com.example.weatherapp.NoteApp.Note.class, true, excludeFields);

        final com_example_weatherapp_NoteApp_NoteRealmProxyInterface objProxy = (com_example_weatherapp_NoteApp_NoteRealmProxyInterface) obj;
        if (json.has("id")) {
            if (json.isNull("id")) {
                objProxy.realmSet$id(null);
            } else {
                objProxy.realmSet$id((String) json.getString("id"));
            }
        }
        if (json.has("title")) {
            if (json.isNull("title")) {
                objProxy.realmSet$title(null);
            } else {
                objProxy.realmSet$title((String) json.getString("title"));
            }
        }
        if (json.has("description")) {
            if (json.isNull("description")) {
                objProxy.realmSet$description(null);
            } else {
                objProxy.realmSet$description((String) json.getString("description"));
            }
        }
        if (json.has("createdTime")) {
            if (json.isNull("createdTime")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'createdTime' to null.");
            } else {
                objProxy.realmSet$createdTime((long) json.getLong("createdTime"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.example.weatherapp.NoteApp.Note createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        final com.example.weatherapp.NoteApp.Note obj = new com.example.weatherapp.NoteApp.Note();
        final com_example_weatherapp_NoteApp_NoteRealmProxyInterface objProxy = (com_example_weatherapp_NoteApp_NoteRealmProxyInterface) obj;
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("id")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$id((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$id(null);
                }
            } else if (name.equals("title")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$title((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$title(null);
                }
            } else if (name.equals("description")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$description((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$description(null);
                }
            } else if (name.equals("createdTime")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$createdTime((long) reader.nextLong());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'createdTime' to null.");
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return realm.copyToRealm(obj);
    }

    static com_example_weatherapp_NoteApp_NoteRealmProxy newProxyInstance(BaseRealm realm, Row row) {
        // Ignore default values to avoid creating unexpected objects from RealmModel/RealmList fields
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        objectContext.set(realm, row, realm.getSchema().getColumnInfo(com.example.weatherapp.NoteApp.Note.class), false, Collections.<String>emptyList());
        io.realm.com_example_weatherapp_NoteApp_NoteRealmProxy obj = new io.realm.com_example_weatherapp_NoteApp_NoteRealmProxy();
        objectContext.clear();
        return obj;
    }

    public static com.example.weatherapp.NoteApp.Note copyOrUpdate(Realm realm, NoteColumnInfo columnInfo, com.example.weatherapp.NoteApp.Note object, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
        if (object instanceof RealmObjectProxy && !RealmObject.isFrozen(object) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null) {
            final BaseRealm otherRealm = ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm();
            if (otherRealm.threadId != realm.threadId) {
                throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
            }
            if (otherRealm.getPath().equals(realm.getPath())) {
                return object;
            }
        }
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        RealmObjectProxy cachedRealmObject = cache.get(object);
        if (cachedRealmObject != null) {
            return (com.example.weatherapp.NoteApp.Note) cachedRealmObject;
        }

        return copy(realm, columnInfo, object, update, cache, flags);
    }

    public static com.example.weatherapp.NoteApp.Note copy(Realm realm, NoteColumnInfo columnInfo, com.example.weatherapp.NoteApp.Note newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.example.weatherapp.NoteApp.Note) cachedRealmObject;
        }

        com_example_weatherapp_NoteApp_NoteRealmProxyInterface unmanagedSource = (com_example_weatherapp_NoteApp_NoteRealmProxyInterface) newObject;

        Table table = realm.getTable(com.example.weatherapp.NoteApp.Note.class);
        OsObjectBuilder builder = new OsObjectBuilder(table, flags);

        // Add all non-"object reference" fields
        builder.addString(columnInfo.idColKey, unmanagedSource.realmGet$id());
        builder.addString(columnInfo.titleColKey, unmanagedSource.realmGet$title());
        builder.addString(columnInfo.descriptionColKey, unmanagedSource.realmGet$description());
        builder.addInteger(columnInfo.createdTimeColKey, unmanagedSource.realmGet$createdTime());

        // Create the underlying object and cache it before setting any object/objectlist references
        // This will allow us to break any circular dependencies by using the object cache.
        Row row = builder.createNewObject();
        io.realm.com_example_weatherapp_NoteApp_NoteRealmProxy managedCopy = newProxyInstance(realm, row);
        cache.put(newObject, managedCopy);

        return managedCopy;
    }

    public static long insert(Realm realm, com.example.weatherapp.NoteApp.Note object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && !RealmObject.isFrozen(object) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getObjectKey();
        }
        Table table = realm.getTable(com.example.weatherapp.NoteApp.Note.class);
        long tableNativePtr = table.getNativePtr();
        NoteColumnInfo columnInfo = (NoteColumnInfo) realm.getSchema().getColumnInfo(com.example.weatherapp.NoteApp.Note.class);
        long objKey = OsObject.createRow(table);
        cache.put(object, objKey);
        String realmGet$id = ((com_example_weatherapp_NoteApp_NoteRealmProxyInterface) object).realmGet$id();
        if (realmGet$id != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.idColKey, objKey, realmGet$id, false);
        }
        String realmGet$title = ((com_example_weatherapp_NoteApp_NoteRealmProxyInterface) object).realmGet$title();
        if (realmGet$title != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.titleColKey, objKey, realmGet$title, false);
        }
        String realmGet$description = ((com_example_weatherapp_NoteApp_NoteRealmProxyInterface) object).realmGet$description();
        if (realmGet$description != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.descriptionColKey, objKey, realmGet$description, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.createdTimeColKey, objKey, ((com_example_weatherapp_NoteApp_NoteRealmProxyInterface) object).realmGet$createdTime(), false);
        return objKey;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.example.weatherapp.NoteApp.Note.class);
        long tableNativePtr = table.getNativePtr();
        NoteColumnInfo columnInfo = (NoteColumnInfo) realm.getSchema().getColumnInfo(com.example.weatherapp.NoteApp.Note.class);
        com.example.weatherapp.NoteApp.Note object = null;
        while (objects.hasNext()) {
            object = (com.example.weatherapp.NoteApp.Note) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && !RealmObject.isFrozen(object) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getObjectKey());
                continue;
            }
            long objKey = OsObject.createRow(table);
            cache.put(object, objKey);
            String realmGet$id = ((com_example_weatherapp_NoteApp_NoteRealmProxyInterface) object).realmGet$id();
            if (realmGet$id != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.idColKey, objKey, realmGet$id, false);
            }
            String realmGet$title = ((com_example_weatherapp_NoteApp_NoteRealmProxyInterface) object).realmGet$title();
            if (realmGet$title != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.titleColKey, objKey, realmGet$title, false);
            }
            String realmGet$description = ((com_example_weatherapp_NoteApp_NoteRealmProxyInterface) object).realmGet$description();
            if (realmGet$description != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.descriptionColKey, objKey, realmGet$description, false);
            }
            Table.nativeSetLong(tableNativePtr, columnInfo.createdTimeColKey, objKey, ((com_example_weatherapp_NoteApp_NoteRealmProxyInterface) object).realmGet$createdTime(), false);
        }
    }

    public static long insertOrUpdate(Realm realm, com.example.weatherapp.NoteApp.Note object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && !RealmObject.isFrozen(object) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getObjectKey();
        }
        Table table = realm.getTable(com.example.weatherapp.NoteApp.Note.class);
        long tableNativePtr = table.getNativePtr();
        NoteColumnInfo columnInfo = (NoteColumnInfo) realm.getSchema().getColumnInfo(com.example.weatherapp.NoteApp.Note.class);
        long objKey = OsObject.createRow(table);
        cache.put(object, objKey);
        String realmGet$id = ((com_example_weatherapp_NoteApp_NoteRealmProxyInterface) object).realmGet$id();
        if (realmGet$id != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.idColKey, objKey, realmGet$id, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.idColKey, objKey, false);
        }
        String realmGet$title = ((com_example_weatherapp_NoteApp_NoteRealmProxyInterface) object).realmGet$title();
        if (realmGet$title != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.titleColKey, objKey, realmGet$title, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.titleColKey, objKey, false);
        }
        String realmGet$description = ((com_example_weatherapp_NoteApp_NoteRealmProxyInterface) object).realmGet$description();
        if (realmGet$description != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.descriptionColKey, objKey, realmGet$description, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.descriptionColKey, objKey, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.createdTimeColKey, objKey, ((com_example_weatherapp_NoteApp_NoteRealmProxyInterface) object).realmGet$createdTime(), false);
        return objKey;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.example.weatherapp.NoteApp.Note.class);
        long tableNativePtr = table.getNativePtr();
        NoteColumnInfo columnInfo = (NoteColumnInfo) realm.getSchema().getColumnInfo(com.example.weatherapp.NoteApp.Note.class);
        com.example.weatherapp.NoteApp.Note object = null;
        while (objects.hasNext()) {
            object = (com.example.weatherapp.NoteApp.Note) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && !RealmObject.isFrozen(object) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getObjectKey());
                continue;
            }
            long objKey = OsObject.createRow(table);
            cache.put(object, objKey);
            String realmGet$id = ((com_example_weatherapp_NoteApp_NoteRealmProxyInterface) object).realmGet$id();
            if (realmGet$id != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.idColKey, objKey, realmGet$id, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.idColKey, objKey, false);
            }
            String realmGet$title = ((com_example_weatherapp_NoteApp_NoteRealmProxyInterface) object).realmGet$title();
            if (realmGet$title != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.titleColKey, objKey, realmGet$title, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.titleColKey, objKey, false);
            }
            String realmGet$description = ((com_example_weatherapp_NoteApp_NoteRealmProxyInterface) object).realmGet$description();
            if (realmGet$description != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.descriptionColKey, objKey, realmGet$description, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.descriptionColKey, objKey, false);
            }
            Table.nativeSetLong(tableNativePtr, columnInfo.createdTimeColKey, objKey, ((com_example_weatherapp_NoteApp_NoteRealmProxyInterface) object).realmGet$createdTime(), false);
        }
    }

    public static com.example.weatherapp.NoteApp.Note createDetachedCopy(com.example.weatherapp.NoteApp.Note realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.example.weatherapp.NoteApp.Note unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new com.example.weatherapp.NoteApp.Note();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.example.weatherapp.NoteApp.Note) cachedObject.object;
            }
            unmanagedObject = (com.example.weatherapp.NoteApp.Note) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        com_example_weatherapp_NoteApp_NoteRealmProxyInterface unmanagedCopy = (com_example_weatherapp_NoteApp_NoteRealmProxyInterface) unmanagedObject;
        com_example_weatherapp_NoteApp_NoteRealmProxyInterface realmSource = (com_example_weatherapp_NoteApp_NoteRealmProxyInterface) realmObject;
        Realm objectRealm = (Realm) ((RealmObjectProxy) realmObject).realmGet$proxyState().getRealm$realm();
        unmanagedCopy.realmSet$id(realmSource.realmGet$id());
        unmanagedCopy.realmSet$title(realmSource.realmGet$title());
        unmanagedCopy.realmSet$description(realmSource.realmGet$description());
        unmanagedCopy.realmSet$createdTime(realmSource.realmGet$createdTime());

        return unmanagedObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("Note = proxy[");
        stringBuilder.append("{id:");
        stringBuilder.append(realmGet$id() != null ? realmGet$id() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{title:");
        stringBuilder.append(realmGet$title() != null ? realmGet$title() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{description:");
        stringBuilder.append(realmGet$description() != null ? realmGet$description() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{createdTime:");
        stringBuilder.append(realmGet$createdTime());
        stringBuilder.append("}");
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    @Override
    public ProxyState<?> realmGet$proxyState() {
        return proxyState;
    }

    @Override
    public int hashCode() {
        String realmName = proxyState.getRealm$realm().getPath();
        String tableName = proxyState.getRow$realm().getTable().getName();
        long objKey = proxyState.getRow$realm().getObjectKey();

        int result = 17;
        result = 31 * result + ((realmName != null) ? realmName.hashCode() : 0);
        result = 31 * result + ((tableName != null) ? tableName.hashCode() : 0);
        result = 31 * result + (int) (objKey ^ (objKey >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        com_example_weatherapp_NoteApp_NoteRealmProxy aNote = (com_example_weatherapp_NoteApp_NoteRealmProxy)o;

        BaseRealm realm = proxyState.getRealm$realm();
        BaseRealm otherRealm = aNote.proxyState.getRealm$realm();
        String path = realm.getPath();
        String otherPath = otherRealm.getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;
        if (realm.isFrozen() != otherRealm.isFrozen()) return false;
        if (!realm.sharedRealm.getVersionID().equals(otherRealm.sharedRealm.getVersionID())) {
            return false;
        }

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aNote.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getObjectKey() != aNote.proxyState.getRow$realm().getObjectKey()) return false;

        return true;
    }
}
