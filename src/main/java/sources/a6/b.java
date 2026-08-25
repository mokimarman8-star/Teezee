package a6;

import android.text.TextUtils;
import org.json.JSONObject;
import y5.c;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class b {
    private int a;
    private int b;
    private long c;
    private double d;
    private String e;
    private String f;
    private String g;
    private String h;
    private String i;
    private String j;
    private double k;
    private int l;
    private int m;
    private float n = -1.0f;
    private int o = 0;
    private int p = 0;
    private int q = 0;
    private int r = 0;
    private int s = 307200;
    private int t = 1;

    public int A() {
        return this.r;
    }

    public boolean B() {
        return this.q == 0;
    }

    public int C() {
        return this.a;
    }

    public void D(int i) {
        this.a = i;
    }

    public void E(String str) {
        this.f = str;
    }

    public int F() {
        return this.p;
    }

    public String G() {
        if (TextUtils.isEmpty(this.j)) {
            this.j = c.a(this.g);
        }
        return this.j;
    }

    public String H() {
        return this.e;
    }

    public void I(int i) {
        this.p = i;
    }

    public int J() {
        return this.q;
    }

    public double K() {
        return this.d;
    }

    public void L(int i) {
        this.q = i;
    }

    public void M(String str) {
        this.j = str;
    }

    public int N() {
        return this.t;
    }

    public float a() {
        return this.n;
    }

    public void b(int i) {
        this.o = i;
    }

    public int c() {
        return this.m;
    }

    public void d(int i) {
        this.m = i;
    }

    public void e(String str) {
        this.h = str;
    }

    public String f() {
        return this.i;
    }

    public long g() {
        return this.c;
    }

    public void h(int i) {
        this.s = i;
    }

    public void i(String str) {
        this.i = str;
    }

    public double j() {
        return this.k;
    }

    public void k(int i) {
        this.r = i;
    }

    public int l() {
        return this.o;
    }

    public int m() {
        return this.l;
    }

    public void n(double d) {
        this.d = d;
    }

    public void o(int i) {
        this.l = i;
    }

    public void p(long j) {
        this.c = j;
    }

    public void q(String str) {
        this.e = str;
    }

    public String r() {
        return this.f;
    }

    public void s(int i) {
        this.t = Math.min(4, Math.max(1, i));
    }

    public int t() {
        return this.b;
    }

    public void u(int i) {
        this.b = i;
    }

    public void v(String str) {
        this.g = str;
    }

    public JSONObject w() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("cover_height", C());
            jSONObject.put("cover_url", r());
            jSONObject.put("cover_width", t());
            jSONObject.put("endcard", z());
            jSONObject.put("file_hash", G());
            jSONObject.put("resolution", H());
            jSONObject.put("size", g());
            jSONObject.put("video_duration", K());
            jSONObject.put("video_url", x());
            jSONObject.put("playable_download_url", f());
            jSONObject.put("if_playable_loading_show", l());
            jSONObject.put("remove_loading_page_type", F());
            jSONObject.put("fallback_endcard_judge", m());
            jSONObject.put("video_preload_size", y());
            jSONObject.put("reward_video_cached_type", J());
            jSONObject.put("execute_cached_type", A());
            jSONObject.put("endcard_render", c());
            jSONObject.put("replay_time", N());
            jSONObject.put("play_speed_ratio", a());
            if (j() > 0.0d) {
                jSONObject.put("start", j());
            }
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    public String x() {
        return this.g;
    }

    public int y() {
        if (this.s < 0) {
            this.s = 307200;
        }
        long j = this.s;
        long j2 = this.c;
        if (j > j2) {
            this.s = (int) j2;
        }
        return this.s;
    }

    public String z() {
        return this.h;
    }
}
