package com.transsion.push.config;

import com.transsion.push.IClientIdListener;
import com.transsion.push.utils.FirebaseUtils;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
class PushRepository$a implements FirebaseUtils.b {
    final /* synthetic */ IClientIdListener a;
    final /* synthetic */ PushRepository b;

    PushRepository$a(PushRepository pushRepository, IClientIdListener iClientIdListener) {
        this.b = pushRepository;
        this.a = iClientIdListener;
    }

    @Override // com.transsion.push.utils.FirebaseUtils.b
    public void onFail() {
        IClientIdListener iClientIdListener = this.a;
        if (iClientIdListener != null) {
            iClientIdListener.onFail("get token fail");
        }
    }

    @Override // com.transsion.push.utils.FirebaseUtils.b
    public void onSuccess() {
        PushRepository.b(this.b, this.a);
    }
}
