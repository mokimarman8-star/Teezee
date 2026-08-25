package com.transsion.athena.aethna.anehat;

import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.transsion.athena.config.data.model.TidConfigBean;
import com.transsion.athena.config.data.model.aatnhe;
import com.transsion.athena.config.data.model.anateh;
import com.transsion.athena.config.data.model.anehat;
import com.transsion.athena.config.data.model.ehanat;
import com.transsion.athena.config.data.model.enatha;
import com.transsion.athena.hatnea.atenha;
import com.transsion.athena.hatnea.athaen;
import com.transsion.athena.taaneh.aethna;
import com.transsion.ga.AthenaAnalytics;
import com.transsion.gslb.BuildConfig;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public class athena {
    private static volatile athena a;
    private com.transsion.athena.aethna.anehat.aethna.athena b;
    private anateh c = new anateh();

    private athena(com.transsion.athena.aethna.anehat.aethna.athena athenaVar) {
        this.b = athenaVar;
    }

    public static athena a(com.transsion.athena.aethna.anehat.aethna.athena athenaVar) {
        if (a == null) {
            synchronized (athena.class) {
                try {
                    if (a == null) {
                        a = new athena(athenaVar);
                    }
                } finally {
                }
            }
        }
        return a;
    }

    private void c() {
        String str;
        try {
            try {
                this.b.getClass();
                byte[] a2 = anehat.a("63D4BEBEBC7ABCA4BC6A796B6AB06B766A6C7D706B6B756F70B07B6F71A4A5AEBCB2D4BEBEBC6A69BCA4BC7A6B69B16A796B6AB06B767D72726A6C65B07B6F71BCB2D4BEBEBC6A7BBCA4BC7A6B7BB16A796B6AB06B767D72726A6C65B07B6F71BCB2D4BEBEBC6F69BCA4BC7A6B69B06B767D72726A6C65B07B6F71BCB2D4BEBEBC6F7BBCA4BC7A6B7BB06B767D72726A6C65B07B6F71BCB2D4BEBEBC7BBCA4BCAF726F777B6F7078AF68A8AF696E726F7D7A7B6F7078BCB2D4BEBEBC77BCA4BCAF726F777B6F7078AF68ADAF6B797B6C796ABCB2D4BEBEBC69BCA4BCAF7D6A7679707DAF7B76797B736E6F75706AAF68ACAF696E726F7D7ABCB2D4BEBEBC787BBCA4BC68AEAC7BBCB2D4BEBEBC787ABCA4BC68AEAC7ABCB2D4BEBEBC7879BCA4BC68AEAC79BCB2D4BEBEBC7568BCA4BC7D7C7B7A79787776757473AD71706F6EBCB2D4BEBEBC67BCA4BCABA7ADA899A99B9CAD9CA5A6AC9BAEABA9AEADAB99A9ACADA8A79D9D98A9AA9DBCD461D4D4");
                if (a2 == null) {
                    str = BuildConfig.FLAVOR;
                } else {
                    for (int i = 0; i < a2.length; i++) {
                        a2[i] = (byte) (222 - ((char) a2[i]));
                    }
                    str = new String(a2);
                }
                ehanat.c(str);
                this.b.a(ehanat.j);
                this.b.a(ehanat.m);
            } catch (Exception e) {
                aethna.b(Log.getStackTraceString(e));
                com.transsion.ga.anateh.a("initSDKConfig", e);
                this.b.a(ehanat.j);
                this.b.a(ehanat.m);
            }
        } catch (Throwable th2) {
            this.b.a(ehanat.j);
            this.b.a(ehanat.m);
            throw th2;
        }
    }

    public com.transsion.athena.config.data.model.aethna a(long j) {
        com.transsion.athena.config.data.model.aethna aethnaVar = new com.transsion.athena.config.data.model.aethna();
        String a2 = this.c.a(j);
        if (TextUtils.isEmpty(a2)) {
            a2 = ehanat.a(true);
        }
        aethnaVar.a = a2 + ehanat.h;
        aethnaVar.b = e();
        aethnaVar.c = this.c.b().f();
        return aethnaVar;
    }

    public List<com.transsion.athena.config.data.model.athena> a() {
        return this.c.a();
    }

    public void a(int i) {
        List<com.transsion.athena.config.data.model.athena> a2 = this.c.a();
        Iterator<com.transsion.athena.config.data.model.athena> it = a2.iterator();
        while (it.hasNext()) {
            if (it.next().b() == i) {
                return;
            }
        }
        com.transsion.athena.config.data.model.athena athenaVar = new com.transsion.athena.config.data.model.athena();
        athenaVar.a(i);
        a2.add(athenaVar);
    }

    public void a(Handler handler, com.transsion.athena.aethna.aethna aethnaVar) {
        if (ehanat.r()) {
            enatha b = this.c.b();
            if (b.a(32)) {
                com.transsion.athena.hatnea.athena.a().a(new atenha(handler, b, aethnaVar));
            }
            for (com.transsion.athena.config.data.model.athena athenaVar : this.c.a()) {
                int e = athenaVar.e();
                long c = e > 0 ? e * 3600000 : b.c();
                if (athenaVar.a(c, 32)) {
                    com.transsion.athena.hatnea.athena.a().a(new athaen(athenaVar, c, aethnaVar));
                }
            }
        }
    }

    public void a(@NonNull com.transsion.athena.config.data.model.athena athenaVar, @NonNull String str) {
        String str2;
        String str3;
        com.transsion.athena.config.data.model.athena athenaVar2 = athenaVar;
        String str4 = "cfg";
        String str5 = "gpct";
        String str6 = "upct";
        String str7 = "pr";
        String str8 = "stats";
        String str9 = "cv";
        String str10 = "frq";
        try {
            String str11 = "ur";
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("ver")) {
                str2 = "iw";
                athenaVar2.c(jSONObject.getLong("ver"));
            } else {
                str2 = "iw";
            }
            if (jSONObject.has("url")) {
                athenaVar2.e(jSONObject.getString("url"));
            }
            if (jSONObject.has("interval")) {
                athenaVar2.c(jSONObject.getInt("interval"));
            }
            if (jSONObject.has("offline")) {
                athenaVar2.d(jSONObject.getInt("offline"));
            }
            if (jSONObject.has("url_config")) {
                athenaVar2.c(jSONObject.getString("url_config"));
            }
            if (jSONObject.has("data")) {
                JSONArray jSONArray = jSONObject.getJSONArray("data");
                if (jSONArray.length() > 0) {
                    int i = 0;
                    JSONObject jSONObject2 = jSONArray.getJSONObject(0).getJSONObject("cfg");
                    int i2 = 0;
                    while (i2 < jSONArray.length()) {
                        JSONObject jSONObject3 = jSONArray.getJSONObject(i2).getJSONObject(str4);
                        JSONArray jSONArray2 = jSONArray.getJSONObject(i2).getJSONArray("tids");
                        int i3 = i;
                        while (i3 < jSONArray2.length()) {
                            JSONObject jSONObject4 = jSONObject2;
                            long j = jSONArray2.getLong(i3);
                            TidConfigBean a2 = athenaVar2.a(j);
                            if (a2 == null) {
                                str3 = str4;
                                TidConfigBean tidConfigBean = new TidConfigBean();
                                tidConfigBean.setTid(j);
                                athenaVar2.a(tidConfigBean);
                                a2 = tidConfigBean;
                            } else {
                                str3 = str4;
                            }
                            int optInt = jSONObject4.optInt(str9, 0);
                            if (jSONObject3.has(str9)) {
                                optInt = jSONObject3.getInt(str9);
                            }
                            aatnhe tidConfig = a2.getTidConfig();
                            String str12 = str9;
                            JSONObject jSONObject5 = jSONObject;
                            long j2 = optInt;
                            if (optInt > 0) {
                                j2 *= 60000;
                            }
                            tidConfig.b(j2);
                            int optInt2 = jSONObject4.optInt("gmin", 0);
                            if (jSONObject3.has("gmin")) {
                                optInt2 = jSONObject3.getInt("gmin");
                            }
                            a2.getTidConfig().c(optInt2);
                            int optInt3 = jSONObject4.optInt("gmax", 100);
                            if (jSONObject3.has("gmax")) {
                                optInt3 = jSONObject3.getInt("gmax");
                            }
                            a2.getTidConfig().b(optInt3);
                            int optInt4 = jSONObject4.optInt("num", 0);
                            if (jSONObject3.has("num")) {
                                optInt4 = jSONObject3.getInt("num");
                            }
                            a2.getTidConfig().e(optInt4);
                            int optInt5 = jSONObject4.optInt("s", 10);
                            if (jSONObject3.has("s")) {
                                optInt5 = jSONObject3.getInt("s");
                            }
                            a2.getTidConfig().d(optInt5 * 60000);
                            String str13 = str2;
                            int optInt6 = jSONObject4.optInt(str13, 0);
                            if (jSONObject3.has(str13)) {
                                optInt6 = jSONObject3.getInt(str13);
                            }
                            a2.getTidConfig().f(optInt6);
                            String str14 = str11;
                            int optInt7 = jSONObject4.optInt(str14, 100);
                            if (jSONObject3.has(str14)) {
                                optInt7 = jSONObject3.getInt(str14);
                            }
                            a2.getTidConfig().j(optInt7);
                            String str15 = str10;
                            int optInt8 = jSONObject4.optInt(str15, 0);
                            if (jSONObject3.has(str15)) {
                                optInt8 = jSONObject3.getInt(str15);
                            }
                            str2 = str13;
                            a2.getTidConfig().a(optInt8 * 60 * 1000);
                            String str16 = str8;
                            int optInt9 = jSONObject4.optInt(str16, 0);
                            if (jSONObject3.has(str16)) {
                                optInt9 = jSONObject3.getInt(str16);
                            }
                            a2.getTidConfig().h(optInt9);
                            String str17 = str7;
                            int optInt10 = jSONObject4.optInt(str17, 0);
                            if (jSONObject3.has(str17)) {
                                optInt10 = jSONObject3.getInt(str17);
                            }
                            str8 = str16;
                            a2.getTidConfig().g(optInt10);
                            String str18 = str6;
                            int optInt11 = jSONObject4.optInt(str18, 1);
                            if (jSONObject3.has(str18)) {
                                optInt11 = jSONObject3.getInt(str18);
                            }
                            a2.getTidConfig().i(optInt11);
                            String str19 = str5;
                            int optInt12 = jSONObject4.optInt(str19, 1);
                            if (jSONObject3.has(str19)) {
                                optInt12 = jSONObject3.getInt(str19);
                            }
                            str5 = str19;
                            a2.getTidConfig().d(optInt12);
                            i3++;
                            athenaVar2 = athenaVar;
                            str10 = str15;
                            str11 = str14;
                            str9 = str12;
                            str7 = str17;
                            str4 = str3;
                            jSONObject2 = jSONObject4;
                            str6 = str18;
                            jSONObject = jSONObject5;
                        }
                        i2++;
                        athenaVar2 = athenaVar;
                        str9 = str9;
                        jSONObject2 = jSONObject2;
                        str6 = str6;
                        jSONObject = jSONObject;
                        i = 0;
                    }
                }
            }
            JSONObject jSONObject6 = jSONObject;
            if (jSONObject6.has("table")) {
                JSONObject jSONObject7 = jSONObject6.getJSONObject("table");
                for (TidConfigBean tidConfigBean2 : athenaVar.j()) {
                    String optString = jSONObject7.optString(String.valueOf(tidConfigBean2.getTid()), BuildConfig.FLAVOR);
                    if (optString.length() > 0) {
                        tidConfigBean2.setEvent(optString);
                    }
                }
            }
            try {
                com.transsion.athena.config.data.model.athena a3 = this.c.a(com.transsion.athena.data.athena.b());
                if (a3 == null) {
                    return;
                }
                ehanat.a(a3.i());
            } catch (Exception e) {
                e = e;
                aethna.b(Log.getStackTraceString(e));
                com.transsion.ga.anateh.a("updateAppConfig", e);
            }
        } catch (Exception e2) {
            e = e2;
        }
    }

    public void a(@NonNull String str) {
        try {
            enatha b = this.c.b();
            JSONObject jSONObject = new JSONObject(str);
            b.d(jSONObject.getLong("cv") * 3600000);
            b.e(jSONObject.getLong("threshold"));
            b.b(jSONObject.getInt("once") == 1);
            if (jSONObject.has("networks")) {
                JSONObject jSONObject2 = jSONObject.getJSONObject("networks");
                b.c(jSONObject2.getString("url"));
                b.b(jSONObject2.getJSONObject("tids"));
            }
            if (jSONObject.has("p")) {
                b.a(jSONObject.getJSONArray("p"));
            }
            if (jSONObject.has("ver")) {
                b.f(jSONObject.getLong("ver"));
            }
            if (jSONObject.has("delays")) {
                String[] split = jSONObject.getString("delays").split(",");
                b.a(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
            }
            if (jSONObject.has("tz")) {
                b.b(jSONObject.getString("tz"));
            }
            if (jSONObject.has("dlt")) {
                b.d(jSONObject.getInt("dlt"));
            }
            b.b(jSONObject.optInt("geo", 6));
        } catch (Exception e) {
            aethna.b(Log.getStackTraceString(e));
            com.transsion.ga.anateh.a("updateGlobalConfig", e);
        }
    }

    public void a(List<com.transsion.athena.config.data.model.athena> list) {
        this.c.a(list);
    }

    public anateh b() {
        return this.c;
    }

    public List<TidConfigBean> b(int i) {
        if (i == -1) {
            return this.c.c();
        }
        com.transsion.athena.config.data.model.athena a2 = this.c.a(i);
        return a2 != null ? a2.j() : Collections.emptyList();
    }

    public void d() {
        try {
            c();
            anateh a2 = anateh.a(this.b.c());
            if (a2 == null) {
                this.b.b(this.c.e());
            } else {
                this.c = a2;
            }
            com.transsion.athena.config.data.model.athena a3 = this.c.a(com.transsion.athena.data.athena.b());
            if (a3 == null) {
                return;
            }
            ehanat.a(a3.i());
        } catch (Exception e) {
            aethna.b(Log.getStackTraceString(e));
        }
    }

    @NonNull
    public Pair<Integer, byte[]> e() {
        List<byte[]> b = this.c.b().b();
        if (!anehat.b(b)) {
            return new Pair<>(0, ehanat.n);
        }
        int currentTimeMillis = (int) (System.currentTimeMillis() % b.size());
        return new Pair<>(Integer.valueOf(currentTimeMillis), b.get(currentTimeMillis));
    }

    public void f() {
        this.c.d();
        this.b.b(this.c.e());
    }

    public void g() {
        enatha b = this.c.b();
        b.a(com.transsion.athena.taaneh.athena.j(AthenaAnalytics.J()));
        b.a(true);
        this.b.b(this.c.e());
    }

    public void h() {
        com.transsion.athena.aethna.anehat.aethna.athena athenaVar = this.b;
        if (athenaVar != null) {
            athenaVar.b(this.c.e());
        }
    }
}
