package com.transsion.athena.config.data.model;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import com.transsion.ga.AthenaAnalytics;
import org.json.JSONObject;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public class TidConfigBean {
    public static final int REASON_ATHENA_DISABLE = 100;
    public static final int REASON_CONFIG_NOT_READY = 102;
    public static final int REASON_DB_EXCEPTION = 106;
    public static final int REASON_INITIALIZING = 101;
    public static final int REASON_NONE = 0;
    public static final int REASON_SAMPLING_RATE = 105;
    public static final int REASON_TID_DISABLE = 104;
    public static final int REASON_TID_NOT_EXIST = 103;
    private long a;
    private String b;
    private aatnhe c;
    private long d;

    public TidConfigBean() {
        this.c = new aatnhe();
    }

    public TidConfigBean(long j, String str, aatnhe aatnheVar) {
        new aatnhe();
        this.a = j;
        this.b = str;
        this.c = aatnheVar;
    }

    @Nullable
    public static TidConfigBean fromJSON(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        try {
            TidConfigBean tidConfigBean = new TidConfigBean();
            tidConfigBean.setTid(jSONObject.getLong("tid"));
            tidConfigBean.setTidConfig(aatnhe.a(jSONObject.getJSONObject("tidConfig")));
            return tidConfigBean;
        } catch (Exception e) {
            com.transsion.athena.taaneh.aethna.b(Log.getStackTraceString(e));
            return null;
        }
    }

    public boolean allowTrack(long j) {
        return this.c.b() == 0 || j >= this.d + this.c.b();
    }

    public boolean allowUpload(long j) {
        long j2 = this.c.j();
        long i = this.c.i();
        if (j2 == -1 || i == -1) {
            return false;
        }
        boolean z = Math.abs(j - j2) >= i;
        boolean z2 = this.c.f() > 0 && this.c.f() <= this.c.a();
        int g = this.c.g();
        if (g == 0 || (g == 1 && com.transsion.athena.taaneh.aatnhe.d(AthenaAnalytics.J()))) {
            return z || z2;
        }
        return false;
    }

    public String getEvent() {
        return this.b;
    }

    public long getTid() {
        return this.a;
    }

    public aatnhe getTidConfig() {
        return this.c;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x006c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean inSamplingRange() {
        boolean z;
        int d = this.c.d();
        int c = this.c.c();
        int e = this.c.e();
        int m = this.c.m();
        int l = this.c.l();
        if (m == 100 && d == 0 && c == 100 && e == 1 && l == 1) {
            return true;
        }
        String a = !TextUtils.isEmpty(com.transsion.athena.taaneh.anehat.a()) ? com.transsion.athena.taaneh.anehat.a() : com.transsion.athena.taaneh.athena.b(AthenaAnalytics.J());
        if (!TextUtils.isEmpty(a)) {
            int abs = Math.abs(a.hashCode()) % (e * 100);
            if (abs < d || abs > c) {
                z = false;
                boolean z2 = Math.abs(com.transsion.athena.aethna.athena.b.nextInt()) % (l * 100) >= m;
                if (com.transsion.athena.taaneh.anehat.b()) {
                    com.transsion.athena.taaneh.aethna.c("gaidHashHit: " + z + " eventHashHit: " + z2 + " gmin = " + d + " gmax = " + c);
                }
                return !z && z2;
            }
        }
        z = true;
        if (Math.abs(com.transsion.athena.aethna.athena.b.nextInt()) % (l * 100) >= m) {
        }
        if (com.transsion.athena.taaneh.anehat.b()) {
        }
        if (z) {
        }
    }

    public boolean isCacheEnable() {
        return this.c.h() == 0;
    }

    public boolean isEnable() {
        aatnhe aatnheVar = this.c;
        return aatnheVar != null && aatnheVar.i() >= 0;
    }

    public void setEvent(String str) {
        this.b = str;
    }

    public void setLastTTime(long j) {
        this.d = j;
    }

    public void setTid(long j) {
        this.a = j;
    }

    public void setTidConfig(aatnhe aatnheVar) {
        this.c = aatnheVar;
    }

    public JSONObject toJSON() {
        try {
            return new JSONObject().put("tid", getTid()).put("tidConfig", this.c.n());
        } catch (Exception e) {
            com.transsion.athena.taaneh.aethna.b(Log.getStackTraceString(e));
            return null;
        }
    }
}
