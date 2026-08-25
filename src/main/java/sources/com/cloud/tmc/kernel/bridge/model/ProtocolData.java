package com.cloud.tmc.kernel.bridge.model;

import com.cloud.tmc.kernel.minicover.NativeComponentConstants;
import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;
import java.io.Serializable;
import java.util.HashMap;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public class ProtocolData<T> implements Serializable {
    private String abilityName;
    private String callbackId;
    private T dataJson;
    private String renderId = "";
    private String source;
    private String target;
    private long time;

    public static class ApiDataJson implements Serializable {
        private String args;
        private String methodName;

        public ApiDataJson(String str, String str2) {
            this.methodName = str;
            this.args = str2;
        }

        public static ApiDataJson parse(LinkedTreeMap<String, String> linkedTreeMap) {
            return new ApiDataJson((String) linkedTreeMap.get("methodName"), (String) linkedTreeMap.get(NativeComponentConstants.KEY_COMPONENT_EVENT_ARGS));
        }

        public String getArgs() {
            return this.args;
        }

        public String getMethodName() {
            return this.methodName;
        }

        public void setArgs(String str) {
            this.args = str;
        }

        public void setMethodName(String str) {
            this.methodName = str;
        }
    }

    public static class ConsumeTimeDataJson implements Serializable {
        private HashMap<String, long[]> dataJson;

        ConsumeTimeDataJson(HashMap<String, long[]> hashMap) {
            this.dataJson = hashMap;
        }

        public static ConsumeTimeDataJson parse(LinkedTreeMap<String, Object> linkedTreeMap) {
            try {
                return new ConsumeTimeDataJson((HashMap) new Gson().fromJson(linkedTreeMap.get(NativeComponentConstants.KEY_COMPONENT_DATA_JSON).toString(), HashMap.class));
            } catch (Exception unused) {
                HashMap hashMap = new HashMap();
                hashMap.put("time", new long[0]);
                return new ConsumeTimeDataJson(hashMap);
            }
        }

        public HashMap<String, long[]> getDataJson() {
            return this.dataJson;
        }

        public void setDataJson(HashMap<String, long[]> hashMap) {
            this.dataJson = hashMap;
        }
    }

    public static class DispatchEventDataJson implements Serializable {
        private String dataJson;
        private String eventName;

        public DispatchEventDataJson(String str, String str2) {
            this.eventName = str;
            this.dataJson = str2;
        }

        public static DispatchEventDataJson parse(LinkedTreeMap<String, String> linkedTreeMap) {
            return new DispatchEventDataJson((String) linkedTreeMap.get("eventName"), (String) linkedTreeMap.get(NativeComponentConstants.KEY_COMPONENT_DATA_JSON));
        }

        public String getDataJson() {
            return this.dataJson;
        }

        public String getEventName() {
            return this.eventName;
        }

        public void setDataJson(String str) {
            this.dataJson = str;
        }

        public void setEventName(String str) {
            this.eventName = str;
        }
    }

    public static class LifeCycleDataJson implements Serializable {
        private String lifecycleName;

        public LifeCycleDataJson(String str) {
            this.lifecycleName = str;
        }

        public static LifeCycleDataJson parse(LinkedTreeMap<String, String> linkedTreeMap) {
            return new LifeCycleDataJson((String) linkedTreeMap.get("lifecycleName"));
        }

        public String getLifecycleName() {
            return this.lifecycleName;
        }

        public void setLifecycleName(String str) {
            this.lifecycleName = str;
        }
    }

    public static class NativeComponentDataJson implements Serializable {
        private String args;
        private String callbackId;
        private String methodName;

        public NativeComponentDataJson(String str, String str2, String str3) {
            this.methodName = str;
            this.args = str2;
            this.callbackId = str3;
        }

        public static NativeComponentDataJson parse(LinkedTreeMap<String, String> linkedTreeMap) {
            return new NativeComponentDataJson((String) linkedTreeMap.get("methodName"), (String) linkedTreeMap.get(NativeComponentConstants.KEY_COMPONENT_EVENT_ARGS), (String) linkedTreeMap.get("callbackId"));
        }

        public String getArgs() {
            return this.args;
        }

        public String getCallbackId() {
            return this.callbackId;
        }

        public String getMethodName() {
            return this.methodName;
        }

        public void setArgs(String str) {
            this.args = str;
        }

        public void setCallbackId(String str) {
            this.callbackId = str;
        }

        public void setMethodName(String str) {
            this.methodName = str;
        }
    }

    public static class OnMessageDataJson implements Serializable {
        private String dataJson;

        public OnMessageDataJson(String str) {
            this.dataJson = str;
        }

        public static OnMessageDataJson parse(LinkedTreeMap<String, String> linkedTreeMap) {
            return new OnMessageDataJson((String) linkedTreeMap.get(NativeComponentConstants.KEY_COMPONENT_DATA_JSON));
        }

        public String getDataJson() {
            return this.dataJson;
        }

        public void setDataJson(String str) {
            this.dataJson = str;
        }
    }

    public ProtocolData(String str, String str2, String str3, long j, String str4, T t) {
        this.abilityName = str;
        this.target = str2;
        this.source = str3;
        this.time = j;
        this.callbackId = str4;
        this.dataJson = t;
    }

    public String getAbilityName() {
        return this.abilityName;
    }

    public String getCallbackId() {
        return this.callbackId;
    }

    public T getDataJson() {
        return this.dataJson;
    }

    public String getRenderId() {
        return this.renderId;
    }

    public String getSource() {
        return this.source;
    }

    public String getTarget() {
        return this.target;
    }

    public long getTime() {
        return this.time;
    }

    public void setAbilityName(String str) {
        this.abilityName = str;
    }

    public void setCallbackId(String str) {
        this.callbackId = str;
    }

    public void setDataJson(T t) {
        this.dataJson = t;
    }

    public void setRenderId(String str) {
        this.renderId = str;
    }

    public void setSource(String str) {
        this.source = str;
    }

    public void setTarget(String str) {
        this.target = str;
    }

    public void setTime(long j) {
        this.time = j;
    }
}
