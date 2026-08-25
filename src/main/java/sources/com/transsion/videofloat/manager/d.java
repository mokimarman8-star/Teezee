package com.transsion.videofloat.manager;

import com.transsion.videofloat.bean.FloatPlayType;
import com.transsion.web.api.WebConstants;
import java.util.HashMap;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.HttpUrl;
import wf.a;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class d {
    private final dw.a a;
    private final boolean b;
    private long c;
    private long d;
    private long e;
    private long f;
    private long g;
    private int h;
    private long i;
    private long j;
    private long k;
    private int l;
    private long m;
    private long n;
    private long o;
    private Integer p;
    private String q;
    private String r;
    private String s;
    private gj.c t;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[FloatPlayType.values().length];
            try {
                iArr[FloatPlayType.SHORT_TV.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[FloatPlayType.STREAM.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[FloatPlayType.LOCAL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            a = iArr;
        }
    }

    public d(dw.a floatBean, boolean z) {
        Intrinsics.h(floatBean, "floatBean");
        this.a = floatBean;
        this.b = z;
        this.q = HttpUrl.FRAGMENT_ENCODE_SET;
        if (z) {
            q(floatBean.f().getDuration());
        }
    }

    private final gj.c c() {
        if (this.t == null) {
            this.t = (gj.c) gj.a.a.a(gj.c.class);
        }
        return this.t;
    }

    private final void o() {
        this.c = 0L;
        this.d = 0L;
        this.e = 0L;
        this.f = 0L;
        this.g = 0L;
        this.h = 0;
        this.i = 0L;
        this.j = 0L;
        this.k = 0L;
        this.l = 0;
        this.m = 0L;
        this.n = 0L;
        this.o = 0L;
        this.r = null;
    }

    public final void a() {
        this.d = System.currentTimeMillis();
        a.a.f(wf.a.a, "video_play", "addSurface", false, 4, (Object) null);
    }

    public final void b() {
        String str;
        String str2;
        String str3;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("is_positive", String.valueOf(this.a.w()));
        String m = this.a.m();
        String str4 = HttpUrl.FRAGMENT_ENCODE_SET;
        if (m == null) {
            m = HttpUrl.FRAGMENT_ENCODE_SET;
        }
        linkedHashMap.put("post_id", m);
        linkedHashMap.put("subject_id", this.a.r());
        String str5 = this.s;
        if (str5 != null) {
            str4 = str5;
        }
        linkedHashMap.put("play_type", str4);
        linkedHashMap.put("opt_type", "float");
        if (this.a.q() > 0) {
            linkedHashMap.put("se", String.valueOf(this.a.q()));
        }
        if (this.a.c() > 0) {
            linkedHashMap.put("ep", String.valueOf(this.a.c()));
        }
        String g = this.a.g();
        if (g != null && g.length() != 0) {
            String g2 = this.a.g();
            Intrinsics.e(g2);
            linkedHashMap.put(WebConstants.PAGE_FROM, g2);
        }
        String e = this.a.e();
        if (e != null && e.length() != 0) {
            String e2 = this.a.e();
            Intrinsics.e(e2);
            linkedHashMap.put("ops", e2);
        }
        if (this.a.s() != null) {
            linkedHashMap.put("subject_type", String.valueOf(this.a.s()));
        }
        if (this.e > 0 || this.b) {
            linkedHashMap.put("is_start", com.vungle.ads.internal.b.AD_VISIBILITY_INVISIBLE);
            long j = this.e;
            if (j > 0) {
                long j2 = this.c;
                linkedHashMap.put("delay_v", (j2 <= 0 || j <= 0) ? "0" : String.valueOf(j - j2));
                long j3 = this.d;
                if (j3 > 0) {
                    long j4 = this.e;
                    if (j4 > 0) {
                        str = String.valueOf(j4 - j3);
                        linkedHashMap.put("delay", str);
                    }
                }
                str = "0";
                linkedHashMap.put("delay", str);
            }
            linkedHashMap.put("buffer_time", String.valueOf(this.f));
            linkedHashMap.put("buffer_count", String.valueOf(this.h));
            linkedHashMap.put("play_complete", String.valueOf(((this.i / this.o) * 100.0f) + (this.l * 100.0f)));
            linkedHashMap.put("play_duration", String.valueOf(this.k));
            linkedHashMap.put("pause_duration", String.valueOf(this.n));
            linkedHashMap.put("completeCount", String.valueOf(this.l));
            linkedHashMap.put("play_duration_float", String.valueOf(this.k));
        } else {
            linkedHashMap.put("is_start", "0");
            linkedHashMap.put("delay_v", this.c > 0 ? String.valueOf(System.currentTimeMillis() - this.c) : "0");
            linkedHashMap.put("delay", this.d > 0 ? String.valueOf(System.currentTimeMillis() - this.d) : "0");
        }
        String str6 = this.r;
        if (str6 != null) {
            linkedHashMap.put("is_preloaded", str6);
        }
        linkedHashMap.put(WebConstants.FIELD_URL, this.q);
        linkedHashMap.put("builtin", this.a.a() ? com.vungle.ads.internal.b.AD_VISIBILITY_INVISIBLE : "0");
        long j5 = this.o;
        if (j5 > 0) {
            linkedHashMap.put("total_duration", String.valueOf(j5));
        }
        linkedHashMap.put("player_type", com.vungle.ads.internal.b.AD_VISIBILITY_INVISIBLE);
        Integer num = this.p;
        if (num != null) {
            linkedHashMap.put("error_code", String.valueOf(num));
        }
        gj.c c = c();
        if (c != null) {
            c.b(this.k);
        }
        int i = a.a[this.a.i().ordinal()];
        if (i != 1) {
            str3 = "long_video_play";
            if (i == 2) {
                str2 = "stream_detail";
            } else if (i != 3) {
                return;
            } else {
                str2 = "local_video_detail";
            }
        } else {
            str2 = "minitv_play";
            str3 = "video_play";
        }
        qi.h.a.C(str2, str3, this.k, linkedHashMap);
        o();
    }

    public final void d() {
        this.c = System.currentTimeMillis();
        a.a.f(wf.a.a, "video_play", "initView", false, 4, (Object) null);
    }

    public final void e() {
        h(this.o);
    }

    public final void f() {
        this.g = System.currentTimeMillis();
    }

    public final void g() {
        if (this.g > 0) {
            this.f += System.currentTimeMillis() - this.g;
            this.h++;
            this.g = 0L;
        }
    }

    public final void h(long j) {
        long j2 = this.j;
        long j3 = j - j2;
        if (1 <= j3 && j3 < 1000) {
            this.k += j - j2;
        }
        this.j = j;
        if (j > this.i) {
            this.i = j;
        }
        gj.c c = c();
        if (c != null) {
            c.a(this.k);
        }
    }

    public final void i() {
        q(this.a.f().getDuration());
        a.a.f(wf.a.a, "video_play", "onRenderFirstFrame", false, 4, (Object) null);
        this.e = System.currentTimeMillis();
    }

    public final void j() {
        this.m = System.currentTimeMillis();
    }

    public final void k() {
        if (this.m != 0) {
            this.n += System.currentTimeMillis() - this.m;
            this.m = 0L;
        }
    }

    public final void l() {
        HashMap hashMap = new HashMap();
        hashMap.put("subject_id", this.a.r());
        hashMap.put("action", "float_back_to_detail");
        String e = this.a.e();
        if (e == null) {
            e = HttpUrl.FRAGMENT_ENCODE_SET;
        }
        hashMap.put("ops", e);
        qi.h.a.o(this.a.h(), hashMap);
    }

    public final void m() {
        HashMap hashMap = new HashMap();
        hashMap.put("subject_id", this.a.r());
        hashMap.put("action", "float_close");
        String e = this.a.e();
        if (e == null) {
            e = HttpUrl.FRAGMENT_ENCODE_SET;
        }
        hashMap.put("ops", e);
        qi.h.a.o(this.a.h(), hashMap);
    }

    public final void n() {
        HashMap hashMap = new HashMap();
        hashMap.put("subject_id", this.a.r());
        hashMap.put("action", "float_show");
        hashMap.put("is_positive", String.valueOf(this.a.w()));
        String e = this.a.e();
        if (e == null) {
            e = HttpUrl.FRAGMENT_ENCODE_SET;
        }
        hashMap.put("ops", e);
        qi.h.a.z(this.a.h(), hashMap);
    }

    public final void p(String type) {
        Intrinsics.h(type, "type");
        this.s = type;
    }

    public final void q(long j) {
        this.o = j;
    }

    public final void r(String url) {
        Intrinsics.h(url, "url");
        this.q = url;
    }
}
