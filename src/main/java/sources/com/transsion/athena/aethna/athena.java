package com.transsion.athena.aethna;

import android.os.Handler;
import android.util.Pair;
import com.transsion.athena.config.data.model.TidConfigBean;
import com.transsion.athena.config.data.model.anateh;
import com.transsion.athena.config.data.model.anehat;
import com.transsion.athena.config.data.model.ehanat;
import com.transsion.athena.config.data.model.enatha;
import java.security.SecureRandom;
import java.util.List;
import org.json.JSONObject;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public class athena {
    private static volatile athena a;
    public static SecureRandom b = new SecureRandom();
    private final com.transsion.athena.aethna.anehat.athena c = com.transsion.athena.aethna.anehat.athena.a(com.transsion.athena.aethna.anehat.aethna.athena.b());
    private volatile boolean d;

    private athena() {
    }

    private boolean a(float f) {
        if (f == 1.0f) {
            return true;
        }
        int i = (int) (10000.0f * f);
        int abs = Math.abs(b.nextInt()) % 10000;
        boolean z = abs < i;
        com.transsion.athena.taaneh.aethna.a("checkSamplingRate false, samplingRate : %f, samplingRateInTenThousand : %d, randomHash : %d", Float.valueOf(f), Integer.valueOf(i), Integer.valueOf(abs));
        return z;
    }

    public static athena c() {
        if (a == null) {
            synchronized (athena.class) {
                try {
                    if (a == null) {
                        a = new athena();
                    }
                } finally {
                }
            }
        }
        return a;
    }

    public int a(int i, String str, float f) {
        if (!this.d) {
            com.transsion.athena.taaneh.aethna.a("isTidEnable init not completed");
            return 101;
        }
        if (!ehanat.r()) {
            com.transsion.athena.taaneh.aethna.a("isTidEnable sdk disable");
            return 100;
        }
        enatha b2 = this.c.b().b();
        com.transsion.athena.config.data.model.athena a2 = this.c.b().a(i);
        if (anehat.a(b2.b()) || a2 == null || a2.l()) {
            if (!ehanat.p() || "location#page_view#athena_anr_full#athena_crash_full".contains(str)) {
                return 102;
            }
            if (a(f)) {
                return 0;
            }
            return TidConfigBean.REASON_SAMPLING_RATE;
        }
        TidConfigBean b3 = a2.b(str);
        if (b3 != null) {
            if (!b3.inSamplingRange()) {
                com.transsion.athena.taaneh.aethna.a("isTidEnable device is not in sampling range");
                return TidConfigBean.REASON_SAMPLING_RATE;
            }
            if (b3.isEnable()) {
                return 0;
            }
            com.transsion.athena.taaneh.aethna.a("isTidEnable tid config is closed");
            return TidConfigBean.REASON_TID_DISABLE;
        }
        try {
            if (!com.transsion.athena.taaneh.anehat.b()) {
                return 103;
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("appid", i);
            jSONObject.put("event", str);
            com.transsion.athena.taaneh.aethna.b("invalid or not registered:%s", jSONObject.toString());
            return 103;
        } catch (Exception e) {
            com.transsion.athena.taaneh.aethna.b("checkTidEnable exception:%s", e.getMessage());
            return 103;
        }
    }

    public int a(long j, float f) {
        if (!this.d) {
            com.transsion.athena.taaneh.aethna.a("isTidEnable init not completed");
            return 101;
        }
        if (!ehanat.r()) {
            com.transsion.athena.taaneh.aethna.a("isTidEnable sdk disable");
            return 100;
        }
        enatha b2 = this.c.b().b();
        anateh b3 = this.c.b();
        b3.getClass();
        com.transsion.athena.config.data.model.athena a2 = b3.a(com.transsion.athena.taaneh.anehat.a(j));
        if (anehat.a(b2.b()) || a2 == null || a2.l()) {
            if (!ehanat.p()) {
                return 102;
            }
            if (a(f)) {
                return 0;
            }
            return TidConfigBean.REASON_SAMPLING_RATE;
        }
        TidConfigBean a3 = a2.a(j);
        if (a3 == null) {
            com.transsion.athena.taaneh.aethna.a("isTidEnable tid config is null");
            return 103;
        }
        if (a3.inSamplingRange()) {
            if (a3.isEnable()) {
                return 0;
            }
            com.transsion.athena.taaneh.aethna.a("isTidEnable tid config is closed");
            return TidConfigBean.REASON_TID_DISABLE;
        }
        com.transsion.athena.taaneh.aethna.a("isTidEnable tid " + a3.getTid() + " is not in sampling range");
        return TidConfigBean.REASON_SAMPLING_RATE;
    }

    public TidConfigBean a(int i, String str) {
        com.transsion.athena.config.data.model.athena a2 = this.c.b().a(i);
        if (a2 != null) {
            return a2.b(str);
        }
        return null;
    }

    public com.transsion.athena.config.data.model.aethna a(long j) {
        return this.c.a(j);
    }

    public List<com.transsion.athena.config.data.model.athena> a() {
        return this.c.a();
    }

    public void a(int i) {
        this.c.a(i);
    }

    public void a(Handler handler, aethna aethnaVar) {
        this.c.a(handler, aethnaVar);
    }

    public void a(com.transsion.athena.config.data.model.athena athenaVar, String str) {
        this.c.a(athenaVar, str);
    }

    public void a(String str) {
        this.c.a(str);
    }

    public void a(List<com.transsion.athena.config.data.model.athena> list) {
        this.c.a(list);
    }

    public int b() {
        return this.c.b().b().a();
    }

    public TidConfigBean b(long j) {
        anateh b2 = this.c.b();
        b2.getClass();
        com.transsion.athena.config.data.model.athena a2 = b2.a(com.transsion.athena.taaneh.anehat.a(j));
        if (a2 == null) {
            return null;
        }
        for (TidConfigBean tidConfigBean : a2.j()) {
            if (tidConfigBean.getTid() == j) {
                return tidConfigBean;
            }
        }
        return null;
    }

    public com.transsion.athena.config.data.model.athena b(int i) {
        return this.c.b().a(i);
    }

    public List<TidConfigBean> c(int i) {
        return this.c.b(i);
    }

    public List<byte[]> d() {
        return this.c.b().b().b();
    }

    public int e() {
        return this.c.b().b().e();
    }

    public String f() {
        return this.c.b().b().g();
    }

    public int g() {
        return this.c.b().b().h();
    }

    public void h() {
        this.c.d();
        this.d = true;
    }

    public Pair<Integer, byte[]> i() {
        return this.c.e();
    }

    public void j() {
        this.c.f();
    }

    public void k() {
        this.c.g();
    }

    public void l() {
        this.c.h();
    }
}
