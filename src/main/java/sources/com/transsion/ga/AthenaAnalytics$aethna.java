package com.transsion.ga;

import com.transsion.athena.config.data.model.ehanat;
import com.transsion.athena.taaneh.anehat;

/* JADX INFO: Access modifiers changed from: private */
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public class AthenaAnalytics$aethna implements Runnable {
    private com.transsion.athena.enatha.athena a;

    private AthenaAnalytics$aethna(com.transsion.athena.enatha.athena athenaVar) {
        this.a = athenaVar;
    }

    /* synthetic */ AthenaAnalytics$aethna(com.transsion.athena.enatha.athena athenaVar, AthenaAnalytics$athena athenaAnalytics$athena) {
        this(athenaVar);
    }

    @Override // java.lang.Runnable
    public void run() {
        if (ehanat.v()) {
            anehat.a("Athena is in Test mode，should not release this APK（测试模式）[" + AthenaAnalytics.g().getPackageName() + "]");
            this.a.a(this, 60000L);
            return;
        }
        if (ehanat.t() && ehanat.q()) {
            anehat.a("  - Athena is in Release mode with log enabled. Please set AthenaAnalytics.setDebug(false) to release this APK （Debug模式）[" + AthenaAnalytics.g().getPackageName() + "]");
            this.a.a(this, 60000L);
        }
    }
}
