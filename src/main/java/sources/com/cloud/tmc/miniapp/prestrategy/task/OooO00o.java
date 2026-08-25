package com.cloud.tmc.miniapp.prestrategy.task;

import android.app.Application;
import com.cloud.tmc.integration.model.AppInfoModel;
import com.cloud.tmc.integration.model.AppModel;
import com.cloud.tmc.integration.net.BaseResponse;
import com.cloud.tmc.integration.utils.MiniRequestUtils;
import com.cloud.tmc.kernel.constants.TmcConstants;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.proxy.TmcProxy;
import com.cloud.tmc.miniapp.ByteAppManager;
import com.cloud.tmc.miniapp.prepare.manager.TmcAppInfoManager;
import com.cloud.tmc.miniapp.prestrategy.PrefetchConfigModel;
import com.cloud.tmc.miniapp.utils.MiniAppLaunch;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class OooO00o {
    public final PrefetchConfigModel OooO00o;

    /* renamed from: com.cloud.tmc.miniapp.prestrategy.task.OooO00o$OooO00o, reason: collision with other inner class name */
    public static final class C0027OooO00o extends Lambda implements Function1<BaseResponse<? extends AppInfoModel>, Unit> {
        public final /* synthetic */ CountDownLatch OooO00o;
        public final /* synthetic */ Application OooO0O0;
        public final /* synthetic */ String OooO0OO;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0027OooO00o(CountDownLatch countDownLatch, Application application, String str) {
            super(1);
            this.OooO00o = countDownLatch;
            this.OooO0O0 = application;
            this.OooO0OO = str;
        }

        public final void OooO00o(BaseResponse<AppInfoModel> baseResponse) {
            Intrinsics.h(baseResponse, "it");
            try {
                this.OooO00o.countDown();
                AppInfoModel appInfoModel = (AppInfoModel) baseResponse.getData();
                if (appInfoModel == null) {
                    return;
                }
                AppModel generateAppModel = MiniAppLaunch.INSTANCE.generateAppModel(appInfoModel);
                ((TmcAppInfoManager) TmcProxy.get(TmcAppInfoManager.class)).updateAppModel(this.OooO0O0, generateAppModel, this.OooO0OO + "_pre");
                ((TmcAppInfoManager) TmcProxy.get(TmcAppInfoManager.class)).refreshUpdateTime(this.OooO0O0, this.OooO0OO, System.currentTimeMillis());
                TmcLogger.d("Prefetch:AppInfoTask", "request success.");
            } catch (Throwable th) {
                TmcLogger.e("Prefetch:AppInfoTask", th);
            }
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            OooO00o((BaseResponse) obj);
            return Unit.a;
        }
    }

    public static final class OooO0O0 extends Lambda implements Function1<BaseResponse<? extends Object>, Unit> {
        public final /* synthetic */ CountDownLatch OooO00o;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OooO0O0(CountDownLatch countDownLatch) {
            super(1);
            this.OooO00o = countDownLatch;
        }

        public Object invoke(Object obj) {
            Intrinsics.h((BaseResponse) obj, "it");
            try {
                this.OooO00o.countDown();
                TmcLogger.d("Prefetch:AppInfoTask", "request failed.");
            } catch (Throwable th) {
                TmcLogger.e("Prefetch:AppInfoTask", th);
            }
            return Unit.a;
        }
    }

    public OooO00o(PrefetchConfigModel prefetchConfigModel) {
        Intrinsics.h(prefetchConfigModel, TmcConstants.KEY_BRIDGE_RESULT_DATA);
        this.OooO00o = prefetchConfigModel;
    }

    public final void OooO00o() {
        String appId;
        try {
            TmcLogger.d("Prefetch:AppInfoTask", "request start appId=" + this.OooO00o.getAppId() + TmcConstants.EXTENSION_SEPARATOR);
            long currentTimeMillis = System.currentTimeMillis();
            Application application$com_cloud_tmc_miniapp_sdk = ByteAppManager.INSTANCE.getApplication$com_cloud_tmc_miniapp_sdk();
            if (application$com_cloud_tmc_miniapp_sdk == null || (appId = this.OooO00o.getAppId()) == null) {
                return;
            }
            long lastUpdateTime = ((TmcAppInfoManager) TmcProxy.get(TmcAppInfoManager.class)).getLastUpdateTime(application$com_cloud_tmc_miniapp_sdk, appId);
            if (lastUpdateTime > 0) {
                if (this.OooO00o.getExecuteTime() != 0) {
                }
                TmcLogger.e("Prefetch:AppInfoTask", "No need to make repeated requests during the validity period");
            }
            if (currentTimeMillis - lastUpdateTime >= this.OooO00o.getExecuteTime() * 1000) {
                CountDownLatch countDownLatch = new CountDownLatch(1);
                MiniRequestUtils.updateAppInfoForCdn(appId, new C0027OooO00o(countDownLatch, application$com_cloud_tmc_miniapp_sdk, appId), new OooO0O0(countDownLatch));
                countDownLatch.await(60L, TimeUnit.SECONDS);
                return;
            }
            TmcLogger.e("Prefetch:AppInfoTask", "No need to make repeated requests during the validity period");
        } catch (Throwable th) {
            TmcLogger.e("Prefetch:AppInfoTask", th);
        }
    }
}
