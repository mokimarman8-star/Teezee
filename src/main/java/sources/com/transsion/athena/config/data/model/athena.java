package com.transsion.athena.config.data.model;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import com.transsion.gslb.BuildConfig;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public class athena {
    private int a;
    private long d;
    private int e;
    private String g;
    private String h;
    private int i;
    private int j;
    private String k;
    private long b = -1;
    private int c = 0;
    private final List<TidConfigBean> f = new CopyOnWriteArrayList();

    @Nullable
    public static athena a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            athena athenaVar = new athena();
            athenaVar.b = jSONObject.getLong("npt");
            athenaVar.c = jSONObject.getInt("rt");
            athenaVar.d = jSONObject.getLong("ver");
            athenaVar.e = jSONObject.optInt("dim");
            athenaVar.h = jSONObject.optString("url");
            athenaVar.k = jSONObject.optString("url_config");
            athenaVar.g = jSONObject.optString("opcode");
            athenaVar.i = jSONObject.optInt("interval");
            athenaVar.j = jSONObject.optInt("offline");
            return athenaVar;
        } catch (Exception e) {
            com.transsion.athena.taaneh.aethna.b(Log.getStackTraceString(e));
            return null;
        }
    }

    public TidConfigBean a(long j) {
        for (TidConfigBean tidConfigBean : this.f) {
            if (tidConfigBean.getTid() == j) {
                return tidConfigBean;
            }
        }
        return null;
    }

    public void a(int i) {
        this.a = i;
    }

    public void a(TidConfigBean tidConfigBean) {
        this.f.add(tidConfigBean);
    }

    public boolean a() {
        return this.j == 2;
    }

    public boolean a(long j, int i) {
        if (this.b == -1 || j == -1) {
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis();
        long j2 = currentTimeMillis - this.b;
        if (Math.abs(j2) >= j) {
            b(currentTimeMillis);
            return true;
        }
        if (j2 >= 0) {
            return this.c < i;
        }
        long j3 = this.b;
        Calendar calendar = Calendar.getInstance();
        calendar.get(1);
        calendar.get(2);
        calendar.get(5);
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        long timeInMillis = calendar.getTimeInMillis();
        calendar.add(5, 1);
        return j3 >= timeInMillis && j3 < calendar.getTimeInMillis();
    }

    public int b() {
        return this.a;
    }

    public TidConfigBean b(String str) {
        for (TidConfigBean tidConfigBean : this.f) {
            if (TextUtils.equals(tidConfigBean.getEvent(), str)) {
                return tidConfigBean;
            }
        }
        return null;
    }

    public void b(int i) {
        this.e = i;
    }

    public void b(long j) {
        this.b = j;
        this.c = 0;
    }

    public String c() {
        String str = this.k;
        return str == null ? BuildConfig.FLAVOR : str;
    }

    public void c(int i) {
        this.i = i;
    }

    public void c(long j) {
        this.d = j;
    }

    public void c(String str) {
        this.k = str;
    }

    public int d() {
        return this.e;
    }

    public void d(int i) {
        this.j = i;
    }

    public void d(String str) {
        this.g = str;
    }

    public int e() {
        return this.i;
    }

    public void e(int i) {
        this.c = i;
    }

    public void e(String str) {
        this.h = str;
    }

    public String f() {
        return this.g;
    }

    public int g() {
        return this.c;
    }

    public String h() {
        return this.h;
    }

    public long i() {
        if (anehat.a(this.f)) {
            return 0L;
        }
        return this.f.get(0).getTidConfig().k();
    }

    public List<TidConfigBean> j() {
        return this.f;
    }

    public long k() {
        return this.d;
    }

    public boolean l() {
        return anehat.a(this.f);
    }

    public String m() {
        try {
            return new JSONObject().put("npt", this.b).put("rt", this.c).put("ver", this.d).put("dim", this.e).put("url", this.h).put("url_config", this.k).put("interval", this.i).put("offline", this.j).put("opcode", this.g).toString();
        } catch (Exception e) {
            com.transsion.athena.taaneh.aethna.b(Log.getStackTraceString(e));
            return null;
        }
    }
}
