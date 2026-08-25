package com.cloud.tmc.miniapp.bridge;

import android.content.Context;
import android.net.Uri;
import com.cloud.tmc.integration.proxy.PathProxy;
import com.cloud.tmc.integration.structure.App;
import com.cloud.tmc.integration.structure.AppContext;
import com.cloud.tmc.integration.utils.AppPrepareUtils;
import com.cloud.tmc.integration.utils.FileUtil;
import com.cloud.tmc.kernel.annotation.ActionFilter;
import com.cloud.tmc.kernel.annotation.ThreadType;
import com.cloud.tmc.kernel.bridge.RenderCallContext;
import com.cloud.tmc.kernel.bridge.extension.BridgeCallback;
import com.cloud.tmc.kernel.bridge.extension.annotation.BindingCallback;
import com.cloud.tmc.kernel.bridge.extension.annotation.BindingNode;
import com.cloud.tmc.kernel.bridge.extension.annotation.BindingParam;
import com.cloud.tmc.kernel.constants.TmcConstants;
import com.cloud.tmc.kernel.executor.ExecutorType;
import com.cloud.tmc.kernel.extension.BridgeExtension;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.proxy.TmcProxy;
import com.cloud.tmc.kernel.proxy.storage.KVStorageProxy;
import com.cloud.tmc.kernel.security.Permission;
import com.cloud.tmc.kernel.utils.TmcGsonUtils;
import com.cloud.tmc.miniapp.prestrategy.PrefetchConfigModel;
import com.cloud.tmc.miniutils.util.FileUtils;
import com.cloud.tmc.miniutils.util.GsonUtils;
import com.cloud.tmc.miniutils.util.NetworkUtils;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.tmc.network.HttpRequestor;
import com.tmc.network.INetworkCallback;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import okhttp3.Call;
import okhttp3.Response;
import okhttp3.ResponseBody;

@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class PrefetchStrategyBridge implements BridgeExtension {
    public static final OooO00o Companion = new OooO00o();
    public static final String TAG = "PrefetchStrategyBridge";

    public static final class OooO implements INetworkCallback {
        public final /* synthetic */ BridgeCallback OooO00o;
        public final /* synthetic */ Function2<Response, BridgeCallback, Unit> OooO0O0;

        public OooO(BridgeCallback bridgeCallback, Function2<? super Response, ? super BridgeCallback, Unit> function2) {
            this.OooO00o = bridgeCallback;
            this.OooO0O0 = function2;
        }

        public void onFailure(Call call, Exception exc) {
            Intrinsics.h(exc, "e");
            BridgeCallback bridgeCallback = this.OooO00o;
            if (bridgeCallback != null) {
                bridgeCallback.sendFailResponse();
            }
        }

        public void onResponse(Call call, Response response) {
            Intrinsics.h(call, RenderCallContext.TYPE_CALL);
            Intrinsics.h(response, "response");
            this.OooO0O0.invoke(response, this.OooO00o);
        }
    }

    public static final class OooO00o {
    }

    public static final class OooO0O0 extends Lambda implements Function2<PrefetchConfigModel, PrefetchConfigModel, Integer> {
        public static final OooO0O0 OooO00o = new OooO0O0();

        public OooO0O0() {
            super(2);
        }

        public Object invoke(Object obj, Object obj2) {
            PrefetchConfigModel prefetchConfigModel = (PrefetchConfigModel) obj;
            PrefetchConfigModel prefetchConfigModel2 = (PrefetchConfigModel) obj2;
            return Integer.valueOf((prefetchConfigModel != null ? prefetchConfigModel.getPriority() : 0) - (prefetchConfigModel2 != null ? prefetchConfigModel2.getPriority() : 0));
        }
    }

    public static final class OooO0OO implements INetworkCallback {
        public final /* synthetic */ BridgeCallback OooO00o;
        public final /* synthetic */ Function2<Response, BridgeCallback, Unit> OooO0O0;

        public OooO0OO(BridgeCallback bridgeCallback, Function2<? super Response, ? super BridgeCallback, Unit> function2) {
            this.OooO00o = bridgeCallback;
            this.OooO0O0 = function2;
        }

        public void onFailure(Call call, Exception exc) {
            Intrinsics.h(exc, "e");
            BridgeCallback bridgeCallback = this.OooO00o;
            if (bridgeCallback != null) {
                bridgeCallback.sendFailResponse();
            }
        }

        public void onResponse(Call call, Response response) {
            Intrinsics.h(call, RenderCallContext.TYPE_CALL);
            Intrinsics.h(response, "response");
            this.OooO0O0.invoke(response, this.OooO00o);
        }
    }

    public static final class OooO0o implements INetworkCallback {
        public final /* synthetic */ BridgeCallback OooO00o;
        public final /* synthetic */ Function2<Response, BridgeCallback, Unit> OooO0O0;

        public OooO0o(BridgeCallback bridgeCallback, Function2<? super Response, ? super BridgeCallback, Unit> function2) {
            this.OooO00o = bridgeCallback;
            this.OooO0O0 = function2;
        }

        public void onFailure(Call call, Exception exc) {
            Intrinsics.h(exc, "e");
            BridgeCallback bridgeCallback = this.OooO00o;
            if (bridgeCallback != null) {
                bridgeCallback.sendFailResponse();
            }
        }

        public void onResponse(Call call, Response response) {
            Intrinsics.h(call, RenderCallContext.TYPE_CALL);
            Intrinsics.h(response, "response");
            this.OooO0O0.invoke(response, this.OooO00o);
        }
    }

    public static final class OooOO0 implements INetworkCallback {
        public final /* synthetic */ BridgeCallback OooO00o;
        public final /* synthetic */ Function2<Response, BridgeCallback, Unit> OooO0O0;

        public OooOO0(BridgeCallback bridgeCallback, Function2<? super Response, ? super BridgeCallback, Unit> function2) {
            this.OooO00o = bridgeCallback;
            this.OooO0O0 = function2;
        }

        public void onFailure(Call call, Exception exc) {
            Intrinsics.h(exc, "e");
            BridgeCallback bridgeCallback = this.OooO00o;
            if (bridgeCallback != null) {
                bridgeCallback.sendFailResponse();
            }
        }

        public void onResponse(Call call, Response response) {
            Intrinsics.h(call, RenderCallContext.TYPE_CALL);
            Intrinsics.h(response, "response");
            this.OooO0O0.invoke(response, this.OooO00o);
        }
    }

    @SourceDebugExtension
    public static final class OooOO0O extends Lambda implements Function2<Response, BridgeCallback, Unit> {
        public final /* synthetic */ String OooO00o;
        public final /* synthetic */ String OooO0O0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OooOO0O(String str, String str2) {
            super(2);
            this.OooO00o = str;
            this.OooO0O0 = str2;
        }

        /* JADX WARN: Removed duplicated region for block: B:59:0x0158 A[Catch: all -> 0x0140, TRY_ENTER, TryCatch #0 {all -> 0x0140, blocks: (B:80:0x013c, B:81:0x0142, B:59:0x0158, B:61:0x015d), top: B:28:0x0081 }] */
        /* JADX WARN: Removed duplicated region for block: B:61:0x015d A[Catch: all -> 0x0140, TRY_LEAVE, TryCatch #0 {all -> 0x0140, blocks: (B:80:0x013c, B:81:0x0142, B:59:0x0158, B:61:0x015d), top: B:28:0x0081 }] */
        /* JADX WARN: Removed duplicated region for block: B:63:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:77:0x014d A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void OooO00o(Response response, BridgeCallback bridgeCallback) {
            String valueOf;
            InputStream inputStream;
            Throwable th;
            Integer valueOf2;
            Intrinsics.h(response, "response");
            if (response.code() != 200) {
                if (bridgeCallback != null) {
                    bridgeCallback.sendFailResponse();
                    return;
                }
                return;
            }
            String str = response.headers().get("content-type");
            JsonObject jsonObject = new JsonObject();
            FileOutputStream fileOutputStream = null;
            if (Intrinsics.c(str, "application/json")) {
                ResponseBody body = response.body();
                jsonObject.addProperty(TmcConstants.KEY_BRIDGE_RESULT_DATA, body != null ? body.string() : null);
                if (bridgeCallback != null) {
                    bridgeCallback.sendSuccessResponse(jsonObject);
                    return;
                }
                return;
            }
            String path = Uri.parse(this.OooO00o).getPath();
            if (path == null || path.length() == 0) {
                valueOf = String.valueOf(System.currentTimeMillis());
            } else {
                int length = path.length() - 1;
                if (length >= 0) {
                    while (true) {
                        int i = length - 1;
                        if (path.charAt(length) == '/') {
                            break;
                        } else if (i < 0) {
                            break;
                        } else {
                            length = i;
                        }
                    }
                }
                length = -1;
                valueOf = path.substring(length);
                Intrinsics.g(valueOf, "this as java.lang.String).substring(startIndex)");
            }
            byte[] bArr = new byte[2048];
            try {
                try {
                    ResponseBody body2 = response.body();
                    InputStream inputStream2 = body2 != null ? body2.byteStream() : null;
                    try {
                        String appBaseFilePath = ((PathProxy) TmcProxy.get(PathProxy.class)).getAppBaseFilePath(this.OooO0O0);
                        String str2 = File.separator;
                        String str3 = appBaseFilePath + str2 + TmcConstants.TEMP_DATA_PATH;
                        FileUtils.createOrExistsDir(new File(str3));
                        File file = new File(str3 + str2 + valueOf);
                        if (file.exists()) {
                            file.delete();
                        }
                        FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                        while (true) {
                            if (inputStream2 != null) {
                                try {
                                    valueOf2 = Integer.valueOf(inputStream2.read(bArr));
                                } catch (Throwable th2) {
                                    th = th2;
                                    fileOutputStream = fileOutputStream2;
                                    if (bridgeCallback != null) {
                                        try {
                                            bridgeCallback.sendFailResponse();
                                        } finally {
                                            if (inputStream2 != null) {
                                                try {
                                                    inputStream2.close();
                                                } catch (Throwable th3) {
                                                    TmcLogger.e(PrefetchStrategyBridge.TAG, th3);
                                                }
                                            }
                                            if (fileOutputStream != null) {
                                                fileOutputStream.close();
                                            }
                                        }
                                    }
                                    TmcLogger.e(PrefetchStrategyBridge.TAG, th);
                                    if (inputStream2 != null) {
                                        inputStream2.close();
                                    }
                                    if (fileOutputStream == null) {
                                        fileOutputStream.close();
                                        return;
                                    }
                                    return;
                                }
                            } else {
                                valueOf2 = null;
                            }
                            int intValue = valueOf2 != null ? valueOf2.intValue() : 0;
                            if (valueOf2 != null && valueOf2.intValue() == -1) {
                                break;
                            }
                            fileOutputStream2.write(bArr, 0, intValue);
                        }
                        fileOutputStream2.flush();
                        String vhost = FileUtil.getVhost(this.OooO0O0);
                        String str4 = File.separator;
                        jsonObject.addProperty(TmcConstants.KEY_BRIDGE_RESULT_DATA, vhost + str4 + TmcConstants.TEMP_DATA_PATH + str4 + file.getName());
                        if (bridgeCallback != null) {
                            bridgeCallback.sendSuccessResponse(jsonObject);
                        }
                        if (inputStream2 != null) {
                            inputStream2.close();
                        }
                        fileOutputStream2.close();
                    } catch (Throwable th4) {
                        inputStream = inputStream2;
                        th = th4;
                        InputStream inputStream3 = inputStream;
                        th = th;
                        inputStream2 = inputStream3;
                        if (bridgeCallback != null) {
                        }
                        TmcLogger.e(PrefetchStrategyBridge.TAG, th);
                        if (inputStream2 != null) {
                        }
                        if (fileOutputStream == null) {
                        }
                    }
                } catch (Throwable th5) {
                    TmcLogger.e(PrefetchStrategyBridge.TAG, th5);
                }
            } catch (Throwable th6) {
                th = th6;
                inputStream = null;
            }
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            OooO00o((Response) obj, (BridgeCallback) obj2);
            return Unit.a;
        }
    }

    public static final int OooO00o(Function2 function2, Object obj, Object obj2) {
        Intrinsics.h(function2, "$tmp0");
        return ((Number) function2.invoke(obj, obj2)).intValue();
    }

    @Override // com.cloud.tmc.kernel.extension.BridgeExtension
    public /* synthetic */ void callbackFail(BridgeCallback bridgeCallback, String str, Boolean bool) {
        com.cloud.tmc.kernel.extension.a.a(this, bridgeCallback, str, bool);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0039 A[Catch: all -> 0x0016, TryCatch #0 {all -> 0x0016, blocks: (B:24:0x000b, B:26:0x0011, B:7:0x001c, B:10:0x0031, B:12:0x0039, B:13:0x003d, B:15:0x0047), top: B:23:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0047 A[Catch: all -> 0x0016, TRY_LEAVE, TryCatch #0 {all -> 0x0016, blocks: (B:24:0x000b, B:26:0x0011, B:7:0x001c, B:10:0x0031, B:12:0x0039, B:13:0x003d, B:15:0x0047), top: B:23:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    @ActionFilter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void changePrefetchStatus(@BindingNode(App.class) App app) {
        Context context;
        JsonObject jsonObject;
        JsonElement jsonElement;
        if (app != null) {
            try {
                AppContext appContext = app.getAppContext();
                if (appContext != null) {
                    context = appContext.getContext();
                    if (context == null && (jsonObject = (JsonObject) GsonUtils.fromJson(((KVStorageProxy) TmcProxy.get(KVStorageProxy.class)).getString(context, "100000_web", "prefetch_state_key"), JsonObject.class)) != null) {
                        jsonElement = jsonObject.get("appId");
                        if (Intrinsics.c(jsonElement != null ? jsonElement.getAsString() : null, app.getAppId())) {
                            return;
                        }
                        TmcLogger.e(TAG, app.getAppId() + " destroy. change prefetch state");
                        jsonObject.addProperty("state", Boolean.FALSE);
                        ((KVStorageProxy) TmcProxy.get(KVStorageProxy.class)).putString(context, "100000_web", "prefetch_state_key", jsonObject.toString());
                        return;
                    }
                    return;
                }
            } catch (Throwable th) {
                TmcLogger.e(TAG, th);
                return;
            }
        }
        context = null;
        if (context == null) {
            return;
        }
        jsonElement = jsonObject.get("appId");
        if (Intrinsics.c(jsonElement != null ? jsonElement.getAsString() : null, app.getAppId())) {
        }
    }

    @ActionFilter
    @ThreadType(ExecutorType.IO)
    public final void getPreStrategy(@BindingNode(App.class) App app, @BindingCallback BridgeCallback bridgeCallback) {
        String str;
        ArrayList<String> h5Url;
        String obj;
        JsonObject jsonObject = new JsonObject();
        JsonArray jsonArray = new JsonArray();
        try {
            List<PrefetchConfigModel> R0 = CollectionsKt.R0(com.cloud.tmc.miniapp.prestrategy.OooO0o.OooO0Oo.snapshot().keySet());
            final OooO0O0 oooO0O0 = OooO0O0.OooO00o;
            Collections.sort(R0, new Comparator() { // from class: com.cloud.tmc.miniapp.bridge.a
                @Override // java.util.Comparator
                public final int compare(Object obj2, Object obj3) {
                    return PrefetchStrategyBridge.OooO00o(oooO0O0, obj2, obj3);
                }
            });
            for (PrefetchConfigModel prefetchConfigModel : R0) {
                JsonObject jsonObject2 = new JsonObject();
                jsonObject2.addProperty("sceneId", prefetchConfigModel.getSceneId());
                jsonObject2.addProperty("appId", prefetchConfigModel.getAppId());
                jsonObject2.addProperty("priority", Integer.valueOf(prefetchConfigModel.getPriority()));
                jsonObject2.addProperty("dataType", prefetchConfigModel.getDataType());
                ArrayList<JsonObject> source = prefetchConfigModel.getSource();
                String str2 = "[]";
                if (source != null) {
                    str = source.toString();
                    if (str == null) {
                    }
                    jsonObject2.addProperty("source", str);
                    h5Url = prefetchConfigModel.getH5Url();
                    if (h5Url != null && (obj = h5Url.toString()) != null) {
                        str2 = obj;
                    }
                    jsonObject2.addProperty("h5Url", str2);
                    jsonObject2.addProperty("netType", Integer.valueOf(prefetchConfigModel.getNetType()));
                    jsonObject2.addProperty("expiredTime", Long.valueOf(prefetchConfigModel.getExpiredTime()));
                    jsonObject2.addProperty("executeTime", Long.valueOf(prefetchConfigModel.getExecuteTime()));
                    jsonArray.add(jsonObject2);
                }
                str = "[]";
                jsonObject2.addProperty("source", str);
                h5Url = prefetchConfigModel.getH5Url();
                if (h5Url != null) {
                    str2 = obj;
                }
                jsonObject2.addProperty("h5Url", str2);
                jsonObject2.addProperty("netType", Integer.valueOf(prefetchConfigModel.getNetType()));
                jsonObject2.addProperty("expiredTime", Long.valueOf(prefetchConfigModel.getExpiredTime()));
                jsonObject2.addProperty("executeTime", Long.valueOf(prefetchConfigModel.getExecuteTime()));
                jsonArray.add(jsonObject2);
            }
            jsonObject.add(TmcConstants.KEY_BRIDGE_RESULT_DATA, jsonArray);
            if (bridgeCallback != null) {
                bridgeCallback.sendSuccessResponse(jsonObject);
            }
        } catch (Throwable th) {
            TmcLogger.e(TAG, th);
            if (bridgeCallback != null) {
                bridgeCallback.sendFailResponse();
            }
        }
    }

    @Override // com.cloud.tmc.kernel.extension.Extension
    public void onFinalized() {
    }

    @Override // com.cloud.tmc.kernel.extension.Extension
    public void onInitialized() {
    }

    @Override // com.cloud.tmc.kernel.security.Guard
    public Permission permit() {
        return null;
    }

    @ActionFilter
    @ThreadType(ExecutorType.NETWORK)
    public final void requestStrategy(@BindingNode(App.class) App app, @BindingParam({"appId"}) String str, @BindingParam({"url"}) String str2, @BindingParam({"header"}) String str3, @BindingParam({"method"}) String str4, @BindingParam({"param"}) String str5, @BindingParam({"supportCell"}) boolean z, @BindingCallback BridgeCallback bridgeCallback) {
        Map<String, String> JsonToMapValueIsString;
        Map<String, String> JsonToMapValueIsString2;
        if (str == null || str.length() == 0 || str2 == null || str2.length() == 0 || str4 == null || str4.length() == 0) {
            if (bridgeCallback != null) {
                bridgeCallback.sendFailResponse();
                return;
            }
            return;
        }
        try {
            if (NetworkUtils.isMobileData() && !z) {
                TmcLogger.e(TAG, "current netType is cellular");
                if (bridgeCallback != null) {
                    bridgeCallback.sendFailResponse();
                    return;
                }
                return;
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            if (str5 != null && str5.length() != 0 && (JsonToMapValueIsString2 = TmcGsonUtils.JsonToMapValueIsString(str5)) != null) {
                for (Map.Entry<String, String> entry : JsonToMapValueIsString2.entrySet()) {
                    linkedHashMap.put(entry.getKey(), entry.getValue());
                }
            }
            Map commonHeader = AppPrepareUtils.INSTANCE.getCommonHeader(new LinkedHashMap(), true);
            if (str3 != null && str3.length() != 0 && (JsonToMapValueIsString = TmcGsonUtils.JsonToMapValueIsString(str5)) != null) {
                for (Map.Entry<String, String> entry2 : JsonToMapValueIsString.entrySet()) {
                    commonHeader.put(entry2.getKey(), entry2.getValue());
                }
            }
            OooOO0O oooOO0O = new OooOO0O(str2, str);
            int hashCode = str4.hashCode();
            if (hashCode != -2019344435) {
                if (hashCode == 102230) {
                    if (str4.equals("get")) {
                        HttpRequestor companion = HttpRequestor.Companion.getInstance();
                        if (companion != null) {
                            companion.get(str2, commonHeader, linkedHashMap, new OooO0OO(bridgeCallback, oooOO0O));
                            return;
                        }
                        return;
                    }
                } else if (hashCode == 3446944) {
                    if (str4.equals("post")) {
                        HttpRequestor companion2 = HttpRequestor.Companion.getInstance();
                        if (companion2 != null) {
                            companion2.post(str2, commonHeader, new LinkedHashMap(), linkedHashMap, new OooO(bridgeCallback, oooOO0O));
                            return;
                        }
                        return;
                    }
                } else if (hashCode == 2002678055 && str4.equals("post_json")) {
                    HttpRequestor companion3 = HttpRequestor.Companion.getInstance();
                    if (companion3 != null) {
                        companion3.postJSON(str2, commonHeader, new LinkedHashMap(), linkedHashMap, new OooO0o(bridgeCallback, oooOO0O));
                        return;
                    }
                    return;
                }
            } else if (str4.equals("post_multipart")) {
                HttpRequestor companion4 = HttpRequestor.Companion.getInstance();
                if (companion4 != null) {
                    companion4.postMultipart(str2, commonHeader, new LinkedHashMap(), linkedHashMap, new OooOO0(bridgeCallback, oooOO0O));
                    return;
                }
                return;
            }
            if (bridgeCallback != null) {
                bridgeCallback.sendFailResponse();
            }
        } catch (Throwable th) {
            if (bridgeCallback != null) {
                bridgeCallback.sendFailResponse();
            }
            TmcLogger.e(TAG, th);
        }
    }
}
