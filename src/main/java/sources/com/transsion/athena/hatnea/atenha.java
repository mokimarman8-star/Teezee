package com.transsion.athena.hatnea;

import android.os.Handler;
import android.os.Message;
import androidx.annotation.NonNull;
import com.transsion.gslb.BuildConfig;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public class atenha extends anateh {
    private final com.transsion.athena.config.data.model.enatha c;
    private final com.transsion.athena.aethna.aethna d;

    public atenha(@NonNull Handler handler, com.transsion.athena.config.data.model.enatha enathaVar, com.transsion.athena.aethna.aethna aethnaVar) {
        super(handler);
        this.c = enathaVar;
        this.d = aethnaVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d() {
        com.transsion.athena.aethna.aethna aethnaVar = this.d;
        if (aethnaVar != null) {
            aethnaVar.a(0, false);
        }
    }

    @Override // com.transsion.athena.hatnea.anateh
    protected void a() {
        ehanat<String> a = anehat.a(com.transsion.athena.config.data.model.ehanat.i(), BuildConfig.FLAVOR, this.c.i());
        if (a.a == -1 && com.transsion.athena.config.data.model.anehat.a(this.c.b()) && com.transsion.athena.config.data.model.ehanat.u() && !this.a.hasMessages(298)) {
            Message obtainMessage = this.a.obtainMessage(298);
            obtainMessage.arg1 = 1;
            this.a.sendMessageDelayed(obtainMessage, 300000L);
            return;
        }
        int i = a.a;
        if (i == 0) {
            String str = a.b;
            com.transsion.athena.taaneh.aethna.c("<-- globalConfig:%s", str);
            com.transsion.athena.aethna.athena.c().a(str);
            this.c.b(System.currentTimeMillis() + this.c.c());
            this.a.postAtFrontOfQueue(new Runnable() { // from class: com.transsion.athena.hatnea.a
                @Override // java.lang.Runnable
                public final void run() {
                    atenha.this.d();
                }
            });
        } else if (i != 1) {
            com.transsion.athena.config.data.model.enatha enathaVar = this.c;
            enathaVar.c(enathaVar.d() + 1);
        } else {
            com.transsion.athena.taaneh.aethna.c("<-- globalConfig:%s", "NOT_MODIFIED");
            this.c.b(System.currentTimeMillis() + this.c.c());
        }
        com.transsion.athena.aethna.athena.c().l();
    }

    @Override // com.transsion.athena.hatnea.anateh
    protected String c() {
        return "Retrieve-Global-Config";
    }
}
