package com.cloud.tmc.miniapp.utils.intercept;

import android.content.Context;
import android.os.Build;
import com.cloud.tmc.integration.processor.intercept.IBackPressedIntercept;
import com.cloud.tmc.integration.structure.App;
import com.cloud.tmc.integration.structure.node.AppNode;
import com.cloud.tmc.integration.utils.AddHomeToScreenUtils;
import com.cloud.tmc.integration.utils.AppUtils;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.miniapp.ui.MiniAppActivity;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class OooO00o implements IBackPressedIntercept {
    public IBackPressedIntercept.Result backResult(App app, boolean z, IBackPressedIntercept iBackPressedIntercept, boolean z2) {
        return IBackPressedIntercept.DefaultImpls.backResult(this, app, z, iBackPressedIntercept, z2);
    }

    public String getInterceptName() {
        return "BackToShowAddHomeDialogIntercept";
    }

    public int getPriority() {
        return 30;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public IBackPressedIntercept.Result intercept(IBackPressedIntercept.Chain chain) {
        AppNode app;
        Intrinsics.h(chain, "chain");
        TmcLogger.i("BackToShowAddHomeDialogIntercept", "BackToShowAddHomeDialogIntercept: " + chain.params());
        String appId = chain.params().getAppId();
        if (appId != null && (app = chain.params().getApp()) != null) {
            app.getMiniAppAutoPopover();
            Context context = chain.params().getContext();
            if (context != 0 && Build.VERSION.SDK_INT >= 26 && !AppUtils.INSTANCE.queryShortcutExist(context, appId) && !AddHomeToScreenUtils.INSTANCE.checkAddhomeShowStatus(83, app)) {
                MiniAppActivity miniAppActivity = context instanceof MiniAppActivity ? (MiniAppActivity) context : null;
                if (miniAppActivity != null) {
                    miniAppActivity.showAddHomeTipsDialog(chain.params().getFromType());
                }
                app.updateAddHomeShowStatus(83);
                return IBackPressedIntercept.DefaultImpls.backResult$default(this, chain.params().getApp(), true, this, false, 8, (Object) null);
            }
            return IBackPressedIntercept.DefaultImpls.backResult$default(this, chain.params().getApp(), false, this, false, 8, (Object) null);
        }
        return IBackPressedIntercept.DefaultImpls.backResult$default(this, chain.params().getApp(), false, this, false, 8, (Object) null);
    }
}
