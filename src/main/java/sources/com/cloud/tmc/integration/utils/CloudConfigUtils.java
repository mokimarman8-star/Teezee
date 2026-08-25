package com.cloud.tmc.integration.utils;

import android.content.Context;
import com.cloud.tmc.integration.BuildConfig;
import com.cloud.tmc.integration.MiniAppConfigHelper;
import com.cloud.tmc.integration.model.ConfigCdnBean;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.proxy.TmcProxy;
import com.cloud.tmc.kernel.proxy.network.INetWorkProxy;
import com.cloud.tmc.kernel.proxy.network.IResponseCallback;
import com.cloud.tmc.kernel.proxy.storage.KVStorageProxy;
import com.cloud.tmc.miniutils.util.GsonUtils;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Cookie;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0018\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0004H\u0002J.\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u001a\u001a\u0004\u0018\u00010\u00042\u0014\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001cJ\u0010\u0010\u001e\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0010\u0010\u001f\u001a\u00020\u001d2\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u001e\u0010 \u001a\u00020\u001d2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u000fJ \u0010\"\u001a\u00020\u001d2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010#\u001a\u00020\u000f2\u0006\u0010$\u001a\u00020\u000fH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000f0\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006%"}, d2 = {"Lcom/cloud/tmc/integration/utils/CloudConfigUtils;", "", "()V", "DEFAULT_QUERY_KEY", "", "TAG", "getTAG", "()Ljava/lang/String;", "cloudConfigRequestInterval", "", "getCloudConfigRequestInterval", "()J", "setCloudConfigRequestInterval", "(J)V", "isRequesting", "", "requestingMap", "Ljava/util/concurrent/ConcurrentHashMap;", "getRequestingMap", "()Ljava/util/concurrent/ConcurrentHashMap;", "checkAllowCloudConfigRequest", "context", "Landroid/content/Context;", "checkCloudConfigRequestInterval", "requestKey", "checkEnableConfigRequest", "queryKey", "complete", "Lkotlin/Function1;", "", "checkUseSuccessCallback", "updateCdnConfig", "updateCloudConfigRequestStatus", "success", "updateCloudConfigStatus", "status", "intervalBySuccess", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public final class CloudConfigUtils {
    public static final String DEFAULT_QUERY_KEY = "defaultKey";
    private static long cloudConfigRequestInterval;
    private static volatile boolean isRequesting;
    public static final CloudConfigUtils INSTANCE = new CloudConfigUtils();
    private static final String TAG = "CloudConfigUtils";
    private static final ConcurrentHashMap<String, Boolean> requestingMap = new ConcurrentHashMap<>();

    private CloudConfigUtils() {
    }

    private final boolean checkAllowCloudConfigRequest(Context context) {
        try {
            updateCdnConfig(context);
            return ((KVStorageProxy) TmcProxy.get(KVStorageProxy.class)).getBoolean(context, "miniLauncherGlobal", "enableRequestConfig", true);
        } catch (Throwable th) {
            TmcLogger.e(TAG, "checkAllowCloudConfigRequest", th);
            return true;
        }
    }

    private final boolean checkCloudConfigRequestInterval(Context context, String requestKey) {
        try {
            cloudConfigRequestInterval = MiniAppConfigHelper.INSTANCE.getConfigTargetLong("ccrInterval", 43200000L);
            long j = ((KVStorageProxy) TmcProxy.get(KVStorageProxy.class)).getLong(context, "miniLauncherGlobal", "latestRequestTime_" + requestKey);
            long currentTimeMillis = System.currentTimeMillis() - j;
            long j2 = cloudConfigRequestInterval;
            if (currentTimeMillis >= j2) {
                TmcLogger.d(TAG, "cloud config request interval is over,latestReuestTime->" + j + ",cloudConfigRequestInterval->" + j2);
                return true;
            }
            TmcLogger.d(TAG, "cloud config request interval is not over,currentTime->" + System.currentTimeMillis() + ",latestReuestTime->" + j + ",cloudConfigRequestInterval->" + cloudConfigRequestInterval);
            return false;
        } catch (Throwable th) {
            TmcLogger.e(TAG, "checkCloudConfigRequestInterval error", th);
            return true;
        }
    }

    private final boolean checkUseSuccessCallback(Context context) {
        try {
            return ((KVStorageProxy) TmcProxy.get(KVStorageProxy.class)).getBoolean(context, "miniLauncherGlobal", "requestIntervalBySuccess", true);
        } catch (Throwable th) {
            TmcLogger.e(TAG, "updateCloudConfigStatus", th);
            return false;
        }
    }

    private final void updateCdnConfig(final Context context) {
        if (isRequesting) {
            TmcLogger.d(TAG, "updateCdnConfig isRequesting->" + isRequesting);
            return;
        }
        isRequesting = true;
        if (System.currentTimeMillis() - ((KVStorageProxy) TmcProxy.get(KVStorageProxy.class)).getLong(context, "miniLauncherGlobal", "laterestRequestCdnTime") >= MiniAppConfigHelper.INSTANCE.getConfigTargetLong("cdnrInterval", 43200000L)) {
            ((INetWorkProxy) TmcProxy.get(INetWorkProxy.class)).get("https://cloud-config-oss.shalltry.com/cloudconfig/config/onoff/miniapp_cloudconfig_onoff.json", new LinkedHashMap(), new LinkedHashMap(), Boolean.FALSE, new IResponseCallback() { // from class: com.cloud.tmc.integration.utils.CloudConfigUtils$updateCdnConfig$1
                public void onFailure(String errCode, String errMsg, String callbackId) {
                    CloudConfigUtils.isRequesting = false;
                    if (MiniAppConfigHelper.INSTANCE.getConfigTargetBool("cdnConfigsuccess", false)) {
                        return;
                    }
                    ((KVStorageProxy) TmcProxy.get(KVStorageProxy.class)).putLong(context, "miniLauncherGlobal", "laterestRequestCdnTime", System.currentTimeMillis());
                }

                public void onSuccess(int responseCode, String responseStr, Map<String, String> headers, List<Cookie> cookies, String callbackId) {
                    try {
                        CloudConfigUtils cloudConfigUtils = CloudConfigUtils.INSTANCE;
                        TmcLogger.d(cloudConfigUtils.getTAG(), "getMyByteAppRecommendList onSuccess: " + responseStr);
                        if (responseStr != null && responseStr.length() != 0) {
                            ConfigCdnBean configCdnBean = (ConfigCdnBean) GsonUtils.fromJson(responseStr, ConfigCdnBean.class);
                            String s = configCdnBean.getS();
                            String str = "";
                            if (s == null) {
                                s = "";
                            }
                            boolean z = Intrinsics.c(s, "0") || !Intrinsics.c(s, "1");
                            String a = configCdnBean.getA();
                            if (a != null) {
                                str = a;
                            }
                            cloudConfigUtils.updateCloudConfigStatus(context, z, !Intrinsics.c(str, "0") && Intrinsics.c(str, "1"));
                            ((KVStorageProxy) TmcProxy.get(KVStorageProxy.class)).putLong(context, "miniLauncherGlobal", "laterestRequestCdnTime", System.currentTimeMillis());
                            CloudConfigUtils.isRequesting = false;
                        }
                    } catch (Throwable th) {
                        CloudConfigUtils.isRequesting = false;
                        TmcLogger.d(CloudConfigUtils.INSTANCE.getTAG(), "getCloudConfig error " + th);
                    }
                }
            });
            return;
        }
        TmcLogger.d(TAG, "updateCdnConfig isRequesting->" + isRequesting);
        isRequesting = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateCloudConfigStatus(Context context, boolean status, boolean intervalBySuccess) {
        try {
            ((KVStorageProxy) TmcProxy.get(KVStorageProxy.class)).putBoolean(context, "miniLauncherGlobal", "enableRequestConfig", status);
        } catch (Throwable th) {
            TmcLogger.e(TAG, "updateCloudConfigStatus", th);
        }
        try {
            ((KVStorageProxy) TmcProxy.get(KVStorageProxy.class)).putBoolean(context, "miniLauncherGlobal", "requestIntervalBySuccess", intervalBySuccess);
        } catch (Throwable th2) {
            TmcLogger.e(TAG, "updateCloudConfigStatus", th2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0044 A[Catch: all -> 0x000f, TryCatch #0 {all -> 0x000f, blocks: (B:28:0x0008, B:4:0x0013, B:6:0x001d, B:7:0x001f, B:9:0x0026, B:11:0x003e, B:14:0x0044, B:16:0x004f, B:18:0x005d, B:20:0x0061, B:22:0x0067, B:24:0x006e), top: B:27:0x0008 }] */
    /* JADX WARN: Removed duplicated region for block: B:6:0x001d A[Catch: all -> 0x000f, TryCatch #0 {all -> 0x000f, blocks: (B:28:0x0008, B:4:0x0013, B:6:0x001d, B:7:0x001f, B:9:0x0026, B:11:0x003e, B:14:0x0044, B:16:0x004f, B:18:0x005d, B:20:0x0061, B:22:0x0067, B:24:0x006e), top: B:27:0x0008 }] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0026 A[Catch: all -> 0x000f, TryCatch #0 {all -> 0x000f, blocks: (B:28:0x0008, B:4:0x0013, B:6:0x001d, B:7:0x001f, B:9:0x0026, B:11:0x003e, B:14:0x0044, B:16:0x004f, B:18:0x005d, B:20:0x0061, B:22:0x0067, B:24:0x006e), top: B:27:0x0008 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean checkEnableConfigRequest(Context context, String queryKey, Function1<? super Boolean, Unit> complete) {
        Boolean bool;
        Intrinsics.h(context, "context");
        if (queryKey != null) {
            try {
                if (queryKey.length() == 0) {
                }
                ConcurrentHashMap<String, Boolean> concurrentHashMap = requestingMap;
                bool = concurrentHashMap.get(queryKey);
                if (bool == null) {
                    bool = Boolean.FALSE;
                }
                if (!bool.booleanValue()) {
                    TmcLogger.d(TAG, "cloud config request is requesting, key: " + queryKey);
                    if (complete != null) {
                        complete.invoke(Boolean.TRUE);
                    }
                    return false;
                }
                Boolean bool2 = Boolean.TRUE;
                concurrentHashMap.put(queryKey, bool2);
                if (!checkAllowCloudConfigRequest(context)) {
                    TmcLogger.d(TAG, "cloud config request is not enable");
                    concurrentHashMap.put(queryKey, Boolean.FALSE);
                    if (complete != null) {
                        complete.invoke(bool2);
                    }
                    return false;
                }
                if (checkCloudConfigRequestInterval(context, queryKey)) {
                    return true;
                }
                concurrentHashMap.put(queryKey, Boolean.FALSE);
                if (complete != null) {
                    complete.invoke(bool2);
                }
                return false;
            } catch (Throwable th) {
                TmcLogger.e(TAG, "checkEnableConfigRequest", th);
                return true;
            }
        }
        queryKey = DEFAULT_QUERY_KEY;
        ConcurrentHashMap<String, Boolean> concurrentHashMap2 = requestingMap;
        bool = concurrentHashMap2.get(queryKey);
        if (bool == null) {
        }
        if (!bool.booleanValue()) {
        }
    }

    public final long getCloudConfigRequestInterval() {
        return cloudConfigRequestInterval;
    }

    public final ConcurrentHashMap<String, Boolean> getRequestingMap() {
        return requestingMap;
    }

    public final String getTAG() {
        return TAG;
    }

    public final void setCloudConfigRequestInterval(long j) {
        cloudConfigRequestInterval = j;
    }

    public final void updateCloudConfigRequestStatus(Context context, String requestKey, boolean success) {
        Intrinsics.h(context, "context");
        Intrinsics.h(requestKey, "requestKey");
        try {
            requestingMap.put(requestKey, Boolean.FALSE);
            if (!success && !checkUseSuccessCallback(context)) {
                return;
            }
            ((KVStorageProxy) TmcProxy.get(KVStorageProxy.class)).putLong(context, "miniLauncherGlobal", "latestRequestTime_" + requestKey, System.currentTimeMillis());
            TmcLogger.d(TAG, "updateCloudConfigRequestStatus requestKey: " + requestKey);
        } catch (Throwable th) {
            TmcLogger.e(TAG, "updateCloudConfigRequestStatus error: ", th);
        }
    }
}
