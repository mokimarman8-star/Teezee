package com.cloud.tmc.miniapp.prestrategy.task;

import android.app.Application;
import com.cloud.tmc.kernel.constants.TmcConstants;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.proxy.TmcProxy;
import com.cloud.tmc.kernel.proxy.storage.KVStorageProxy;
import com.cloud.tmc.miniapp.ByteAppManager;
import com.cloud.tmc.miniapp.prestrategy.PrefetchConfigModel;
import com.cloud.tmc.offline.download.OfflineManager;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class OooO0OO {
    public final PrefetchConfigModel OooO00o;

    public static final class OooO00o extends Lambda implements Function1<Boolean, Unit> {
        public final /* synthetic */ CountDownLatch OooO00o;
        public final /* synthetic */ Application OooO0O0;
        public final /* synthetic */ String OooO0OO;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OooO00o(CountDownLatch countDownLatch, Application application, String str) {
            super(1);
            this.OooO00o = countDownLatch;
            this.OooO0O0 = application;
            this.OooO0OO = str;
        }

        public final void OooO00o(boolean z) {
            this.OooO00o.countDown();
            if (z) {
                KVStorageProxy kVStorageProxy = (KVStorageProxy) TmcProxy.get(KVStorageProxy.class);
                Application application = this.OooO0O0;
                String str = this.OooO0OO;
                kVStorageProxy.putLong(application, str, str + "_offline_time", System.currentTimeMillis());
            }
            TmcLogger.e("Prefetch:OfflinePackageTask", "PrefetchOfflinePackageTask task finish. success =" + z);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            OooO00o(((Boolean) obj).booleanValue());
            return Unit.a;
        }
    }

    public OooO0OO(PrefetchConfigModel prefetchConfigModel) {
        Intrinsics.h(prefetchConfigModel, TmcConstants.KEY_BRIDGE_RESULT_DATA);
        this.OooO00o = prefetchConfigModel;
    }

    public final void OooO00o() {
        String appId;
        try {
            TmcLogger.d("Prefetch:OfflinePackageTask", "request start appId=" + this.OooO00o.getAppId() + TmcConstants.EXTENSION_SEPARATOR);
            long currentTimeMillis = System.currentTimeMillis();
            Application application$com_cloud_tmc_miniapp_sdk = ByteAppManager.INSTANCE.getApplication$com_cloud_tmc_miniapp_sdk();
            if (application$com_cloud_tmc_miniapp_sdk == null || (appId = this.OooO00o.getAppId()) == null) {
                return;
            }
            long j = ((KVStorageProxy) TmcProxy.get(KVStorageProxy.class)).getLong(application$com_cloud_tmc_miniapp_sdk, appId, appId + "_offline_time");
            if (j > 0) {
                if (this.OooO00o.getExecuteTime() != 0) {
                }
                TmcLogger.e("Prefetch:OfflinePackageTask", "No need to make repeated requests during the validity period");
            }
            if (currentTimeMillis - j >= this.OooO00o.getExecuteTime() * 1000) {
                CountDownLatch countDownLatch = new CountDownLatch(1);
                OfflineManager.downloadPkgFromPlatform(appId, false, new OooO00o(countDownLatch, application$com_cloud_tmc_miniapp_sdk, appId));
                countDownLatch.await(60L, TimeUnit.SECONDS);
                return;
            }
            TmcLogger.e("Prefetch:OfflinePackageTask", "No need to make repeated requests during the validity period");
        } catch (Throwable th) {
            TmcLogger.e("Prefetch:OfflinePackageTask", th);
        }
    }
}
