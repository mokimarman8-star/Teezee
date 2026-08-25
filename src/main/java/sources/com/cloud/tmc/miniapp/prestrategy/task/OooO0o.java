package com.cloud.tmc.miniapp.prestrategy.task;

import android.app.Application;
import com.cloud.tmc.integration.model.AppInfoQuery;
import com.cloud.tmc.integration.model.AppModel;
import com.cloud.tmc.integration.model.ExtendModel;
import com.cloud.tmc.integration.proxy.PreHtmStrategyProxy;
import com.cloud.tmc.kernel.constants.TmcConstants;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.proxy.TmcProxy;
import com.cloud.tmc.kernel.proxy.storage.KVStorageProxy;
import com.cloud.tmc.kernel.utils.KUrlUtils;
import com.cloud.tmc.miniapp.ByteAppManager;
import com.cloud.tmc.miniapp.prepare.manager.TmcAppInfoManager;
import com.cloud.tmc.miniapp.prestrategy.PrefetchConfigModel;
import com.cloud.tmc.miniutils.util.EncryptUtils;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class OooO0o {
    public final PrefetchConfigModel OooO00o;

    public static final class OooO00o extends Lambda implements Function1<Boolean, Unit> {
        public final /* synthetic */ CountDownLatch OooO00o;
        public final /* synthetic */ Application OooO0O0;
        public final /* synthetic */ String OooO0OO;
        public final /* synthetic */ String OooO0Oo;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OooO00o(CountDownLatch countDownLatch, Application application, String str, String str2) {
            super(1);
            this.OooO00o = countDownLatch;
            this.OooO0O0 = application;
            this.OooO0OO = str;
            this.OooO0Oo = str2;
        }

        public final void OooO00o(boolean z) {
            this.OooO00o.countDown();
            if (z) {
                ((KVStorageProxy) TmcProxy.get(KVStorageProxy.class)).putLong(this.OooO0O0, this.OooO0OO, this.OooO0Oo + "_time", System.currentTimeMillis());
            }
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            OooO00o(((Boolean) obj).booleanValue());
            return Unit.a;
        }
    }

    public OooO0o(PrefetchConfigModel prefetchConfigModel) {
        Intrinsics.h(prefetchConfigModel, TmcConstants.KEY_BRIDGE_RESULT_DATA);
        this.OooO00o = prefetchConfigModel;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0064 A[Catch: all -> 0x0059, TryCatch #0 {all -> 0x0059, blocks: (B:3:0x0002, B:7:0x002e, B:10:0x0037, B:13:0x004c, B:15:0x0052, B:18:0x005e, B:20:0x0064, B:22:0x0079, B:24:0x00aa, B:26:0x00c3, B:28:0x00b4, B:30:0x00cb), top: B:2:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0079 A[Catch: all -> 0x0059, TryCatch #0 {all -> 0x0059, blocks: (B:3:0x0002, B:7:0x002e, B:10:0x0037, B:13:0x004c, B:15:0x0052, B:18:0x005e, B:20:0x0064, B:22:0x0079, B:24:0x00aa, B:26:0x00c3, B:28:0x00b4, B:30:0x00cb), top: B:2:0x0002 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void OooO00o() {
        String appId;
        AppModel appModel;
        String str;
        try {
            TmcLogger.d("Prefetch:ShellH5Task", "request start appId=" + this.OooO00o.getAppId() + TmcConstants.EXTENSION_SEPARATOR);
            long currentTimeMillis = System.currentTimeMillis();
            Application application$com_cloud_tmc_miniapp_sdk = ByteAppManager.INSTANCE.getApplication$com_cloud_tmc_miniapp_sdk();
            if (application$com_cloud_tmc_miniapp_sdk == null || (appId = this.OooO00o.getAppId()) == null || (appModel = ((TmcAppInfoManager) TmcProxy.get(TmcAppInfoManager.class)).getAppModel(application$com_cloud_tmc_miniapp_sdk, AppInfoQuery.Companion.make(appId))) == null) {
                return;
            }
            ExtendModel extend = appModel.getExtend();
            if (extend != null) {
                str = extend.getH5Url();
                if (str == null) {
                }
                if (str.length() != 0) {
                    TmcLogger.d("Prefetch:ShellH5Task", appId + " ->h5Url is empty ,return!");
                    return;
                }
                String generateShellUrl = KUrlUtils.generateShellUrl(str, this.OooO00o.getBundle());
                String encryptMD5ToString = EncryptUtils.encryptMD5ToString(generateShellUrl);
                long j = ((KVStorageProxy) TmcProxy.get(KVStorageProxy.class)).getLong(application$com_cloud_tmc_miniapp_sdk, appId, encryptMD5ToString + "_time");
                if ((j > 0 && this.OooO00o.getExecuteTime() == 0) || currentTimeMillis - j < this.OooO00o.getExecuteTime() * 1000) {
                    TmcLogger.e("Prefetch:H5Task", "No need to make repeated requests during the validity period");
                    return;
                }
                CountDownLatch countDownLatch = new CountDownLatch(1);
                ((PreHtmStrategyProxy) TmcProxy.get(PreHtmStrategyProxy.class)).requestHtml(application$com_cloud_tmc_miniapp_sdk, generateShellUrl, new OooO00o(countDownLatch, application$com_cloud_tmc_miniapp_sdk, appId, encryptMD5ToString));
                countDownLatch.await(60L, TimeUnit.SECONDS);
                return;
            }
            str = "";
            if (str.length() != 0) {
            }
        } catch (Throwable th) {
            TmcLogger.e("Prefetch:ShellH5Task", th);
        }
    }
}
