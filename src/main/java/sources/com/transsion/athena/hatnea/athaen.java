package com.transsion.athena.hatnea;

import com.transsion.ga.AthenaAnalytics;
import com.transsion.gslb.BuildConfig;
import org.json.JSONObject;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public class athaen extends anateh {
    private final com.transsion.athena.config.data.model.athena c;
    private long d;
    private final int e;
    private final com.transsion.athena.aethna.aethna f;

    public athaen(com.transsion.athena.config.data.model.athena athenaVar, long j, com.transsion.athena.aethna.aethna aethnaVar) {
        int b = com.transsion.athena.config.data.model.anehat.b(AthenaAnalytics.J());
        this.e = b;
        if (athenaVar.k() > 0 && b != athenaVar.d()) {
            com.transsion.athena.taaneh.aethna.c("dimensionChanged, so set appConfig version to 0");
            athenaVar.c(0L);
        }
        this.c = athenaVar;
        this.d = j;
        this.f = aethnaVar;
    }

    @Override // com.transsion.athena.hatnea.anateh
    protected void a() {
        String str;
        boolean z = false;
        try {
            JSONObject a = com.transsion.athena.config.data.model.anehat.a(AthenaAnalytics.J());
            a.put("sname", String.valueOf(this.c.b()));
            a.put("sdkver", com.transsion.athena.config.data.model.ehanat.a(this.c.b()));
            str = a.toString();
        } catch (Exception e) {
            com.transsion.athena.taaneh.aethna.b(e.getMessage());
            str = BuildConfig.FLAVOR;
        }
        ehanat<String> a2 = anehat.a(com.transsion.athena.config.data.model.ehanat.a(this.c.c()), str, this.c.k(), this.c.b());
        int i = a2.a;
        if (i == 0) {
            String str2 = a2.b;
            com.transsion.athena.taaneh.aethna.c("<-- appIdConfig:%s", str2);
            com.transsion.athena.aethna.athena.c().a(this.c, str2);
            this.c.b(this.e);
            if (this.c.e() > 0) {
                this.d = this.c.e() * 3600000;
            }
            this.c.b(System.currentTimeMillis() + this.d);
            z = true;
        } else if (i != 1) {
            com.transsion.athena.config.data.model.athena athenaVar = this.c;
            athenaVar.e(athenaVar.g() + 1);
        } else {
            com.transsion.athena.taaneh.aethna.c("<-- appIdConfig:%s", "NOT_MODIFIED");
            this.c.b(this.e);
            this.c.b(System.currentTimeMillis() + this.d);
        }
        com.transsion.athena.aethna.aethna aethnaVar = this.f;
        if (aethnaVar != null) {
            aethnaVar.a(this.c.b(), z);
        }
    }

    @Override // com.transsion.athena.hatnea.anateh
    protected String c() {
        return "Retrieve-" + this.c.b() + "-Config";
    }
}
