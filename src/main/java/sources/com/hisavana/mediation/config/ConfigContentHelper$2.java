package com.hisavana.mediation.config;

import com.hisavana.mediation.bean.CloudControlConfig;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public class ConfigContentHelper$2 implements Runnable {
    final /* synthetic */ ConfigContentHelper this$0;
    final /* synthetic */ CloudControlConfig.CodeSeat val$codeSeat;

    public ConfigContentHelper$2(ConfigContentHelper configContentHelper, CloudControlConfig.CodeSeat codeSeat) {
        this.this$0 = configContentHelper;
        this.val$codeSeat = codeSeat;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (ConfigContentHelper.a(this.this$0) != null) {
            ConfigContentHelper.a(this.this$0).a(this.val$codeSeat);
        }
    }
}
