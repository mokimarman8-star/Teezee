package com.cloud.tmc.miniapp.prestrategy;

import com.cloud.tmc.integration.net.BaseResponse;
import com.cloud.tmc.integration.net.TmcResponseCallback;
import com.cloud.tmc.kernel.constants.TmcConstants;
import com.cloud.tmc.kernel.executor.ExecutorType;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.utils.ExecutorUtils;
import com.cloud.tmc.miniapp.ByteAppManager;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class PrefetchConfigManager$requestStrategyConfig$4 extends TmcResponseCallback<ArrayList<PrefetchConfigModel>> {
    public final /* synthetic */ PrefetchData OooO00o;

    public PrefetchConfigManager$requestStrategyConfig$4(PrefetchData prefetchData) {
        this.OooO00o = prefetchData;
    }

    public static final void OooO00o(List list, PrefetchData prefetchData) {
        Intrinsics.h(prefetchData, "$data");
        OooO0o.OooO00o.OooO00o((List<PrefetchConfigModel>) list, prefetchData.getBundleMap());
    }

    public Type getType() {
        Type type = new TypeToken<BaseResponse<? extends ArrayList<PrefetchConfigModel>>>() { // from class: com.cloud.tmc.miniapp.prestrategy.PrefetchConfigManager$requestStrategyConfig$4$getType$1
        }.getType();
        Intrinsics.g(type, "object : TypeToken<BaseR…hConfigModel>>>() {}.type");
        return type;
    }

    public void onFail(BaseResponse<? extends Object> baseResponse, Map<String, String> map) {
        Intrinsics.h(baseResponse, "fail");
        OooO0OO.OooO0o0.set(0);
        TmcLogger.d("Prefetch:PrefetchConfigManager", "requestStrategyConfig failed( " + baseResponse.getCode() + ":" + baseResponse.getMessage() + ").");
    }

    public void onSuccess(BaseResponse<? extends ArrayList<PrefetchConfigModel>> baseResponse, Map<String, String> map) {
        Intrinsics.h(baseResponse, "bean");
        OooO0OO.OooO0o0.set(0);
        TmcLogger.d("Prefetch:PrefetchConfigManager", "requestStrategyConfig success.");
        if (ByteAppManager.INSTANCE.getApplication$com_cloud_tmc_miniapp_sdk() != null) {
            final PrefetchData prefetchData = this.OooO00o;
            try {
                final List list = (List) baseResponse.getData();
                if (list != null && !list.isEmpty()) {
                    TmcLogger.d("Prefetch:PrefetchConfigManager", "requestStrategyConfig data=" + list + TmcConstants.EXTENSION_SEPARATOR);
                    ExecutorUtils.execute(ExecutorType.IDLE, new Runnable() { // from class: com.cloud.tmc.miniapp.prestrategy.f
                        @Override // java.lang.Runnable
                        public final void run() {
                            PrefetchConfigManager$requestStrategyConfig$4.OooO00o(list, prefetchData);
                        }
                    });
                    return;
                }
                TmcLogger.e("Prefetch:PrefetchConfigManager", "modelList is empty.");
            } catch (Throwable th) {
                TmcLogger.e("Prefetch:PrefetchConfigManager", th);
            }
        }
    }
}
