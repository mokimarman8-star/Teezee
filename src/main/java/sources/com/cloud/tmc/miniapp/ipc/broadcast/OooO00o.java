package com.cloud.tmc.miniapp.ipc.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.cloud.tmc.component_api_ps.MiniAppProtocolModuleLogger;
import com.cloud.tmc.component_api_ps.ipc.MiniAppProtocolHelper;
import com.cloud.tmc.component_api_ps.ipc.callbcak.IMiniAppDataSyncCallback;
import com.cloud.tmc.integration.model.CacheReportBean;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class OooO00o extends BroadcastReceiver {
    public static final C0018OooO00o OooO00o = new C0018OooO00o();

    /* renamed from: com.cloud.tmc.miniapp.ipc.broadcast.OooO00o$OooO00o, reason: collision with other inner class name */
    public static final class C0018OooO00o {
    }

    public final void OooO00o(Bundle bundle) {
        try {
            int i = bundle.getInt("miniProcessId");
            String string = bundle.getString("miniGaid");
            if (string == null) {
                string = "";
            }
            MiniAppProtocolHelper miniAppProtocolHelper = MiniAppProtocolHelper.INSTANCE;
            miniAppProtocolHelper.updateMiniPid(i);
            Bundle bundle2 = new Bundle();
            bundle2.putString("miniGaid", string);
            IMiniAppDataSyncCallback dataSyncCallback = miniAppProtocolHelper.getDataSyncCallback();
            if (dataSyncCallback != null) {
                dataSyncCallback.onSyncData("miniInitProcess", bundle2);
            }
        } catch (Throwable unused) {
        }
    }

    public final void OooO00o(String str, Bundle bundle) {
        try {
            MiniAppProtocolModuleLogger.d("MiniBroadcastReceiver", "MiniBroadcastReceiver -> reportDataToPs:" + str);
            bundle.getString("miniGaid");
            IMiniAppDataSyncCallback dataSyncCallback = MiniAppProtocolHelper.INSTANCE.getDataSyncCallback();
            if (dataSyncCallback != null) {
                dataSyncCallback.onSyncData(str, bundle);
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:80:0x004a, code lost:
    
        if (r10 == null) goto L21;
     */
    @Override // android.content.BroadcastReceiver
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onReceive(Context context, Intent intent) {
        Bundle extras;
        if (!Intrinsics.c(intent != null ? intent.getPackage() : null, context != null ? context.getPackageName() : null)) {
            MiniAppProtocolModuleLogger.d("MiniBroadcastReceiver", "MiniBroadcastReceiver -> onReceive:" + (intent != null ? intent.getPackage() : null) + " != " + (context != null ? context.getPackageName() : null));
            return;
        }
        if (intent != null) {
            try {
                extras = intent.getExtras();
            } catch (Throwable unused) {
                extras = new Bundle();
            }
        }
        extras = new Bundle();
        String action = intent != null ? intent.getAction() : null;
        if (Intrinsics.c(action, "com.cloud.tmc.miniapp.process_id")) {
            OooO00o(extras);
            return;
        }
        if (Intrinsics.c(action, "com.cloud.tmc.miniapp.addhome_success")) {
            OooO00o("miniAddHomeSuccess", extras);
            return;
        }
        if (Intrinsics.c(action, "com.cloud.tmc.miniapp.start_time")) {
            OooO00o("miniAppStartTime", extras);
            return;
        }
        if (Intrinsics.c(action, "com.cloud.tmc.miniapp.use_time")) {
            OooO00o("miniAppUseTime", extras);
            return;
        }
        if (Intrinsics.c(action, "com.cloud.tmc.miniapp.report_cache")) {
            try {
                ArrayList<CacheReportBean> parcelableArrayListExtra = intent.getParcelableArrayListExtra("reportCachedata");
                if (parcelableArrayListExtra != null) {
                    for (CacheReportBean cacheReportBean : parcelableArrayListExtra) {
                        String event = cacheReportBean.getEvent();
                        if (Intrinsics.c(event, "com.cloud.tmc.miniapp.process_id")) {
                            OooO00o(cacheReportBean.getData());
                        } else if (Intrinsics.c(event, "com.cloud.tmc.miniapp.addhome_success")) {
                            OooO00o("miniAddHomeSuccess", cacheReportBean.getData());
                        } else if (Intrinsics.c(event, "com.cloud.tmc.miniapp.start_time")) {
                            OooO00o("miniAppStartTime", cacheReportBean.getData());
                        } else if (Intrinsics.c(event, "com.cloud.tmc.miniapp.use_time")) {
                            OooO00o("miniAppUseTime", cacheReportBean.getData());
                        }
                    }
                }
            } catch (Throwable unused2) {
            }
        }
    }
}
