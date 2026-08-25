package com.transsion.ugcvideodetail.hepler;

import com.transsion.player.orplayer.ORPlayerPreloadManager;
import com.transsion.player.orplayer.PlayError;
import com.transsion.ugcvideodetail.api.bean.UGCVideo;
import com.transsion.web.api.WebConstants;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.HttpUrl;
import wf.a;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class a {
    private final String a;
    private final String b;
    private final String c;
    private com.transsion.player.orplayer.f d;
    private UGCVideo e;
    private long f;
    private long g;
    private long h;
    private long i;
    private long j;
    private int k;
    private long l;
    private long m;
    private long n;
    private int o;
    private long p;
    private long q;
    private long r;
    private Integer s;
    private boolean t;
    private boolean u;
    private String v;
    private int w;
    private gj.c x;
    private String y;
    private int z;

    public a(String pageName, String str) {
        Intrinsics.h(pageName, "pageName");
        this.a = pageName;
        this.b = str;
        this.c = a.class.getSimpleName();
        this.u = true;
        this.v = HttpUrl.FRAGMENT_ENCODE_SET;
        this.w = -1;
        this.y = HttpUrl.FRAGMENT_ENCODE_SET;
    }

    public static /* synthetic */ void d(a aVar, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        aVar.b(z);
    }

    private final gj.c e() {
        if (this.x == null) {
            this.x = (gj.c) gj.a.a.a(gj.c.class);
        }
        return this.x;
    }

    private final void q(boolean z) {
        this.f = 0L;
        this.g = 0L;
        this.h = 0L;
        this.i = 0L;
        this.j = 0L;
        this.k = 0;
        this.l = 0L;
        this.m = 0L;
        this.n = 0L;
        this.o = 0;
        this.p = 0L;
        this.q = 0L;
        this.r = 0L;
        if (z) {
            return;
        }
        this.w = -1;
        this.t = false;
    }

    public final void a() {
        this.g = System.currentTimeMillis();
        a.a.f(wf.a.a, "video_play", "addSurface", false, 4, (Object) null);
    }

    /* JADX WARN: Removed duplicated region for block: B:72:0x00ea  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void b(boolean z) {
        String str;
        String str2;
        long j;
        String str3;
        if (this.f == 0 && !this.t) {
            a.a aVar = wf.a.a;
            String TAG = this.c;
            Intrinsics.g(TAG, "TAG");
            a.a.f(aVar, TAG, "exitPlay, return", false, 4, (Object) null);
            return;
        }
        if (!this.t) {
            a.a aVar2 = wf.a.a;
            String TAG2 = this.c;
            Intrinsics.g(TAG2, "TAG");
            a.a.v(aVar2, TAG2, "curVideoIsApp2Background = " + z, false, 4, (Object) null);
            this.t = z;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("ep", this.y);
        String str4 = this.b;
        if (str4 == null) {
            str4 = qi.h.a.h();
        }
        linkedHashMap.put(WebConstants.PAGE_FROM, str4);
        UGCVideo uGCVideo = this.e;
        if (uGCVideo == null || (str = uGCVideo.getOps()) == null) {
            str = HttpUrl.FRAGMENT_ENCODE_SET;
        }
        linkedHashMap.put("ops", str);
        int i = this.z;
        if (i > 0) {
            linkedHashMap.put("subject_type", String.valueOf(i));
        }
        long j2 = this.h;
        String str5 = com.vungle.ads.internal.b.AD_VISIBILITY_INVISIBLE;
        if (j2 > 0 || (this.t && this.n > 0)) {
            linkedHashMap.put("is_start", com.vungle.ads.internal.b.AD_VISIBILITY_INVISIBLE);
            long j3 = this.f;
            if (j3 > 0) {
                long j4 = this.h;
                if (j4 > 0) {
                    str2 = String.valueOf(j4 - j3);
                    linkedHashMap.put("delay_v", str2);
                    j = this.g;
                    if (j > 0) {
                        long j5 = this.h;
                        if (j5 > 0) {
                            str3 = String.valueOf(j5 - j);
                            linkedHashMap.put("delay", str3);
                            linkedHashMap.put("buffer_time", String.valueOf(this.i));
                            linkedHashMap.put("buffer_count", String.valueOf(this.k));
                            linkedHashMap.put("play_complete", String.valueOf(((this.l / this.r) * 100.0f) + (this.o * 100.0f)));
                            linkedHashMap.put("play_duration", String.valueOf(this.n));
                            linkedHashMap.put("pause_duration", String.valueOf(this.q));
                            linkedHashMap.put("completeCount", String.valueOf(this.o));
                        }
                    }
                    str3 = "0";
                    linkedHashMap.put("delay", str3);
                    linkedHashMap.put("buffer_time", String.valueOf(this.i));
                    linkedHashMap.put("buffer_count", String.valueOf(this.k));
                    linkedHashMap.put("play_complete", String.valueOf(((this.l / this.r) * 100.0f) + (this.o * 100.0f)));
                    linkedHashMap.put("play_duration", String.valueOf(this.n));
                    linkedHashMap.put("pause_duration", String.valueOf(this.q));
                    linkedHashMap.put("completeCount", String.valueOf(this.o));
                }
            }
            str2 = "0";
            linkedHashMap.put("delay_v", str2);
            j = this.g;
            if (j > 0) {
            }
            str3 = "0";
            linkedHashMap.put("delay", str3);
            linkedHashMap.put("buffer_time", String.valueOf(this.i));
            linkedHashMap.put("buffer_count", String.valueOf(this.k));
            linkedHashMap.put("play_complete", String.valueOf(((this.l / this.r) * 100.0f) + (this.o * 100.0f)));
            linkedHashMap.put("play_duration", String.valueOf(this.n));
            linkedHashMap.put("pause_duration", String.valueOf(this.q));
            linkedHashMap.put("completeCount", String.valueOf(this.o));
        } else {
            linkedHashMap.put("is_start", "0");
            linkedHashMap.put("delay_v", this.f > 0 ? String.valueOf(System.currentTimeMillis() - this.f) : "0");
            linkedHashMap.put("delay", this.g > 0 ? String.valueOf(System.currentTimeMillis() - this.g) : "0");
        }
        linkedHashMap.put("app_to_background", z ? com.vungle.ads.internal.b.AD_VISIBILITY_INVISIBLE : "0");
        if (!ORPlayerPreloadManager.i.a().e(this.v)) {
            str5 = "0";
        }
        linkedHashMap.put("is_preloaded", str5);
        linkedHashMap.put(WebConstants.FIELD_URL, this.v);
        long j6 = this.r;
        if (j6 > 0) {
            linkedHashMap.put("total_duration", String.valueOf(j6));
        }
        int i2 = this.w;
        if (i2 >= 0) {
            linkedHashMap.put("position", String.valueOf(i2));
        }
        Integer num = this.s;
        if (num != null) {
            linkedHashMap.put("error_code", String.valueOf(num));
        }
        if (!this.t || this.n > 0 || this.u) {
            if (z) {
                this.u = false;
            }
            gj.c e = e();
            if (e != null) {
                e.b(this.n);
            }
            qi.h.a.C(this.a, "video_play", this.n, linkedHashMap);
            q(z);
        }
    }

    public final void c(boolean z, boolean z2) {
        if (z) {
            b(z2);
        } else {
            q(z2);
        }
    }

    public final void f() {
        this.f = System.currentTimeMillis();
        this.u = true;
        a.a.f(wf.a.a, "video_play", "initView", false, 4, (Object) null);
    }

    public final void g() {
        l(this.r);
    }

    public final void h() {
        this.j = System.currentTimeMillis();
    }

    public final void i() {
        if (this.j > 0) {
            this.i += System.currentTimeMillis() - this.j;
            this.k++;
            this.j = 0L;
        }
    }

    public final void j() {
        this.o++;
        this.l = 0L;
    }

    public final void k(PlayError errorInfo) {
        Intrinsics.h(errorInfo, "errorInfo");
        this.s = errorInfo.getErrorCode();
    }

    public final void l(long j) {
        if (this.r <= 0) {
            com.transsion.player.orplayer.f fVar = this.d;
            this.r = fVar != null ? fVar.getDuration() : 0L;
        }
        long j2 = this.m;
        long j3 = j - j2;
        if (1 <= j3 && j3 < 1000) {
            this.n += j - j2;
        }
        this.m = j;
        if (j > this.l) {
            this.l = j;
        }
        gj.c e = e();
        if (e != null) {
            e.a(this.n);
        }
    }

    public final void m() {
        a.a.f(wf.a.a, "video_play", "onRenderFirstFrame", false, 4, (Object) null);
        this.h = System.currentTimeMillis();
    }

    public final void n() {
        this.p = System.currentTimeMillis();
    }

    public final void o() {
        if (this.p != 0) {
            this.q += System.currentTimeMillis() - this.p;
            this.p = 0L;
        }
    }

    public final void p() {
        d(this, false, 1, null);
    }

    public final void r(Integer num) {
        this.w = num != null ? num.intValue() : -1;
    }

    public final void s(UGCVideo uGCVideo) {
        a.a aVar = wf.a.a;
        String TAG = this.c;
        Intrinsics.g(TAG, "TAG");
        a.a.f(aVar, TAG, "setData----->", false, 4, (Object) null);
        this.e = uGCVideo;
    }

    public final void t(com.transsion.player.orplayer.f fVar) {
        a.a aVar = wf.a.a;
        String TAG = this.c;
        Intrinsics.g(TAG, "TAG");
        a.a.f(aVar, TAG, "setPlayer----->", false, 4, (Object) null);
        this.d = fVar;
    }

    public final void u(String url) {
        Intrinsics.h(url, "url");
        this.v = url;
    }
}
