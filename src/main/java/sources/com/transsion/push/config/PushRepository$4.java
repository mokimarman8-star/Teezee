package com.transsion.push.config;

import com.transsion.push.IClientIdListener;
import com.transsion.push.PushConstants;
import com.transsion.push.bean.ConfigInfo;
import com.transsion.push.utils.PushLogUtils;
import com.transsion.push.utils.k0;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
class PushRepository$4 implements Runnable {
    final /* synthetic */ PushRepository this$0;
    final /* synthetic */ IClientIdListener val$listener;

    PushRepository$4(PushRepository pushRepository, IClientIdListener iClientIdListener) {
        this.this$0 = pushRepository;
        this.val$listener = iClientIdListener;
    }

    @Override // java.lang.Runnable
    public void run() {
        ConfigInfo.Whitelist whitelist;
        ConfigInfo.Config config;
        ConfigInfo f = PushRepository.a(this.this$0).f();
        if (f == null) {
            IClientIdListener iClientIdListener = this.val$listener;
            if (iClientIdListener != null) {
                iClientIdListener.onFail("get client id fail");
            }
            PushLogUtils.LOG.g("get client id fail");
            return;
        }
        PushLogUtils.LOG.g("get config response data: " + f.toString());
        this.this$0.putSpValue(PushConstants.SP_KEY_IS_NEXT_WITH_APP, Boolean.valueOf(f.nextWithApp));
        this.this$0.putSpValue(PushConstants.SP_KEY_IS_REPORT_DETAIL, Boolean.valueOf(f.nextWithDetail));
        this.this$0.putSpValue(PushConstants.SP_KEY_CLIENT_ID, f.clientId);
        k0.f(f.destroyAppIds, f.syncInfoInterval);
        if (f.configRefresh && (config = f.config) != null && config.version > 0) {
            this.this$0.saveConfig(config);
            this.this$0.putSpValue(PushConstants.SP_KEY_SELF_DESTROYING, Integer.valueOf(f.config.destroy));
        }
        if (f.whitelistRefresh && (whitelist = f.whitelist) != null && whitelist.version > 0) {
            this.this$0.saveWhiteList(whitelist);
        }
        IClientIdListener iClientIdListener2 = this.val$listener;
        if (iClientIdListener2 != null) {
            iClientIdListener2.onSuccess(f.clientId);
        }
    }
}
