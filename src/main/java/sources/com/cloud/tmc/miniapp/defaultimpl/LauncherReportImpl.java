package com.cloud.tmc.miniapp.defaultimpl;

import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import com.cloud.tmc.integration.model.CacheReportBean;
import com.cloud.tmc.integration.proxy.LauncherReportProxy;
import com.cloud.tmc.integration.utils.DeviceUtil;
import com.cloud.tmc.integration.utils.MiniForceAddHomeManager;
import com.cloud.tmc.kernel.constants.TmcConstants;
import com.cloud.tmc.kernel.executor.ExecutorType;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.utils.ExecutorUtils;
import com.cloud.tmc.miniapp.ByteAppManager;
import com.cloud.tmc.miniapp.ipc.broadcast.OooO00o;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class LauncherReportImpl implements LauncherReportProxy {
    public final String OooO00o = "LauncherReport";

    public static final void OooO00o(int i, LauncherReportImpl launcherReportImpl) {
        Intrinsics.h(launcherReportImpl, "this$0");
        try {
            Bundle bundle = new Bundle();
            OooO00o.C0018OooO00o c0018OooO00o = com.cloud.tmc.miniapp.ipc.broadcast.OooO00o.OooO00o;
            bundle.putInt("miniProcessId", i);
            if (DeviceUtil.INSTANCE.getIsNewUserStatus()) {
                TmcLogger.d(launcherReportImpl.OooO00o, "reportCache ->reportMiniProcessId");
                com.cloud.tmc.miniapp.utils.OooO0OO.OooO00o.OooO00o(new CacheReportBean("", "com.cloud.tmc.miniapp.process_id", false, bundle));
                return;
            }
            TmcLogger.d(launcherReportImpl.OooO00o, "reportMiniProcessId -> pid ->" + i);
            Application application$com_cloud_tmc_miniapp_sdk = ByteAppManager.INSTANCE.getApplication$com_cloud_tmc_miniapp_sdk();
            if (application$com_cloud_tmc_miniapp_sdk != null) {
                Intent intent = new Intent("com.cloud.tmc.miniapp.process_id");
                bundle.putString("miniGaid", DeviceUtil.getGAId());
                intent.putExtras(bundle);
                intent.setPackage(application$com_cloud_tmc_miniapp_sdk.getPackageName());
                application$com_cloud_tmc_miniapp_sdk.sendBroadcast(intent);
            }
        } catch (Throwable th) {
            TmcLogger.e(launcherReportImpl.OooO00o, "reportMiniProcessId", th);
        }
    }

    public static final void OooO00o(String str, long j, LauncherReportImpl launcherReportImpl) {
        Intrinsics.h(launcherReportImpl, "this$0");
        try {
            Bundle bundle = new Bundle();
            OooO00o.C0018OooO00o c0018OooO00o = com.cloud.tmc.miniapp.ipc.broadcast.OooO00o.OooO00o;
            bundle.putString(TmcConstants.EXTRA_APP_ID, str);
            bundle.putLong("usageTime", j);
            MiniForceAddHomeManager miniForceAddHomeManager = MiniForceAddHomeManager.INSTANCE;
            boolean checkInterectMFAHWithBookPrivacy = miniForceAddHomeManager.checkInterectMFAHWithBookPrivacy(str);
            if (!DeviceUtil.INSTANCE.getIsNewUserStatus() && !checkInterectMFAHWithBookPrivacy) {
                TmcLogger.d(launcherReportImpl.OooO00o, "reportMiniAppUseTime -> usageTime ->" + j);
                Application application$com_cloud_tmc_miniapp_sdk = ByteAppManager.INSTANCE.getApplication$com_cloud_tmc_miniapp_sdk();
                if (application$com_cloud_tmc_miniapp_sdk != null) {
                    Intent intent = new Intent("com.cloud.tmc.miniapp.use_time");
                    bundle.putString("miniGaid", DeviceUtil.getGAId());
                    intent.putExtras(bundle);
                    intent.setPackage(application$com_cloud_tmc_miniapp_sdk.getPackageName());
                    application$com_cloud_tmc_miniapp_sdk.sendBroadcast(intent);
                    return;
                }
                return;
            }
            TmcLogger.d(launcherReportImpl.OooO00o, "reportCache ->reportMiniAppUseTime " + str);
            CacheReportBean cacheReportBean = new CacheReportBean(str == null ? "" : str, "com.cloud.tmc.miniapp.use_time", miniForceAddHomeManager.checkInterectMFAH(str), bundle);
            if (!Intrinsics.c(miniForceAddHomeManager.getInterceptRealMFAHMap().get(str), Boolean.TRUE)) {
                com.cloud.tmc.miniapp.utils.OooO0OO.OooO00o.OooO00o(cacheReportBean);
                return;
            }
            TmcLogger.d(launcherReportImpl.OooO00o, "reportCache ->mfah reportMiniAppUseTime");
            com.cloud.tmc.miniapp.utils.OooO0OO oooO0OO = com.cloud.tmc.miniapp.utils.OooO0OO.OooO00o;
            if (str == null) {
                str = "";
            }
            oooO0OO.OooO00o(str, cacheReportBean);
        } catch (Throwable th) {
            TmcLogger.e(launcherReportImpl.OooO00o, "reportMiniAppUseTime", th);
        }
    }

    public static final void OooO00o(String str, LauncherReportImpl launcherReportImpl) {
        Intrinsics.h(str, "$appId");
        Intrinsics.h(launcherReportImpl, "this$0");
        try {
            Bundle bundle = new Bundle();
            OooO00o.C0018OooO00o c0018OooO00o = com.cloud.tmc.miniapp.ipc.broadcast.OooO00o.OooO00o;
            bundle.putString(TmcConstants.EXTRA_APP_ID, str);
            if (DeviceUtil.INSTANCE.getIsNewUserStatus()) {
                TmcLogger.d(launcherReportImpl.OooO00o, "reportCache ->reportMiniAddhomeSuccess");
                com.cloud.tmc.miniapp.utils.OooO0OO.OooO00o.OooO00o(new CacheReportBean(str, "com.cloud.tmc.miniapp.addhome_success", false, bundle));
                return;
            }
            TmcLogger.d(launcherReportImpl.OooO00o, "reportMiniAddhomeSuccess -> appId ->" + str);
            Application application$com_cloud_tmc_miniapp_sdk = ByteAppManager.INSTANCE.getApplication$com_cloud_tmc_miniapp_sdk();
            if (application$com_cloud_tmc_miniapp_sdk != null) {
                Intent intent = new Intent("com.cloud.tmc.miniapp.addhome_success");
                bundle.putString("miniGaid", DeviceUtil.getGAId());
                intent.putExtras(bundle);
                intent.setPackage(application$com_cloud_tmc_miniapp_sdk.getPackageName());
                application$com_cloud_tmc_miniapp_sdk.sendBroadcast(intent);
            }
        } catch (Throwable th) {
            TmcLogger.e(launcherReportImpl.OooO00o, "reportMiniAddhomeSuccess", th);
        }
    }

    public void report(String str, Bundle bundle) {
        try {
            TmcLogger.d(this.OooO00o, "tag:" + str + ",bundle:" + (bundle != null ? bundle.toString() : null));
        } catch (Throwable th) {
            TmcLogger.e(this.OooO00o, th);
        }
    }

    public void reportAllCacheData(String str) {
        try {
            com.cloud.tmc.miniapp.utils.OooO0OO.OooO00o.OooO00o(str);
        } catch (Throwable unused) {
        }
    }

    public void reportCacheData(String str) {
        try {
            com.cloud.tmc.miniapp.utils.OooO0OO.OooO00o.OooO0O0(str);
        } catch (Throwable unused) {
        }
    }

    public void reportMiniAddhomeSuccess(final String str) {
        Intrinsics.h(str, "appId");
        try {
            ExecutorUtils.execute(ExecutorType.IO, new Runnable() { // from class: com.cloud.tmc.miniapp.defaultimpl.h
                @Override // java.lang.Runnable
                public final void run() {
                    LauncherReportImpl.OooO00o(str, this);
                }
            });
        } catch (Throwable th) {
            TmcLogger.e(this.OooO00o, "reportMiniAddhomeSuccess", th);
        }
    }

    public void reportMiniAppStartRecord(String str, String str2, String str3) {
    }

    public void reportMiniAppStartTime(String str, long j, String str2) {
        Intrinsics.h(str2, "startType");
        try {
            Bundle bundle = new Bundle();
            OooO00o.C0018OooO00o c0018OooO00o = com.cloud.tmc.miniapp.ipc.broadcast.OooO00o.OooO00o;
            bundle.putString(TmcConstants.EXTRA_APP_ID, str);
            bundle.putLong("startTime", j);
            bundle.putString("startType", str2);
            MiniForceAddHomeManager miniForceAddHomeManager = MiniForceAddHomeManager.INSTANCE;
            boolean checkInterectMFAHWithBookPrivacy = miniForceAddHomeManager.checkInterectMFAHWithBookPrivacy(str);
            if (!DeviceUtil.INSTANCE.getIsNewUserStatus() && !checkInterectMFAHWithBookPrivacy) {
                TmcLogger.d(this.OooO00o, "reportMiniAppStartTime -> startTime ->" + j);
                Application application$com_cloud_tmc_miniapp_sdk = ByteAppManager.INSTANCE.getApplication$com_cloud_tmc_miniapp_sdk();
                if (application$com_cloud_tmc_miniapp_sdk != null) {
                    Intent intent = new Intent("com.cloud.tmc.miniapp.start_time");
                    bundle.putString("miniGaid", DeviceUtil.getGAId());
                    intent.putExtras(bundle);
                    intent.setPackage(application$com_cloud_tmc_miniapp_sdk.getPackageName());
                    application$com_cloud_tmc_miniapp_sdk.sendBroadcast(intent);
                    return;
                }
                return;
            }
            TmcLogger.d(this.OooO00o, "reportCache ->reportMiniAppStartTime " + str);
            CacheReportBean cacheReportBean = new CacheReportBean(str == null ? "" : str, "com.cloud.tmc.miniapp.start_time", false, bundle);
            if (!Intrinsics.c(miniForceAddHomeManager.getInterceptRealMFAHMap().get(str), Boolean.TRUE)) {
                com.cloud.tmc.miniapp.utils.OooO0OO.OooO00o.OooO00o(cacheReportBean);
                return;
            }
            TmcLogger.d(this.OooO00o, "reportCache ->mfah startTime");
            com.cloud.tmc.miniapp.utils.OooO0OO oooO0OO = com.cloud.tmc.miniapp.utils.OooO0OO.OooO00o;
            if (str == null) {
                str = "";
            }
            oooO0OO.OooO00o(str, cacheReportBean);
        } catch (Throwable th) {
            TmcLogger.e(this.OooO00o, "reportMiniAppStartTime", th);
        }
    }

    public void reportMiniAppUseTime(final String str, final long j) {
        try {
            ExecutorUtils.execute(ExecutorType.IO, new Runnable() { // from class: com.cloud.tmc.miniapp.defaultimpl.g
                @Override // java.lang.Runnable
                public final void run() {
                    LauncherReportImpl.OooO00o(str, j, this);
                }
            });
        } catch (Throwable unused) {
        }
    }

    public void reportMiniProcessId(final int i) {
        try {
            ExecutorUtils.execute(ExecutorType.IO, new Runnable() { // from class: com.cloud.tmc.miniapp.defaultimpl.i
                @Override // java.lang.Runnable
                public final void run() {
                    LauncherReportImpl.OooO00o(i, this);
                }
            });
        } catch (Throwable th) {
            TmcLogger.e(this.OooO00o, "reportMiniProcessId", th);
        }
    }
}
