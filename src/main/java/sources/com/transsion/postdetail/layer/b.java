package com.transsion.postdetail.layer;

import android.text.TextUtils;
import com.transsion.gslb.BuildConfig;
import com.transsion.moviedetailapi.bean.PostSubjectItem;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.player.mediasession.MediaItem;
import com.transsion.player.orplayer.ORPlayerPreloadManager;
import com.transsion.player.orplayer.PlayError;
import com.transsion.player.orplayer.f;
import com.transsion.push.bean.MsgStyle;
import gj.c;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;
import qi.h;
import wf.a;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class b {
    private c A;
    private int D;
    private f b;
    private String c;
    private PostSubjectItem d;
    private long e;
    private long f;
    private long g;
    private long h;
    private long i;
    private int j;
    private long k;
    private long l;
    private long m;
    private int n;
    private long o;
    private long p;
    private long q;
    private Integer r;
    private String s;
    private String t;
    private String u;
    private boolean v;
    private final String a = b.class.getSimpleName();
    private boolean w = true;
    private String x = BuildConfig.FLAVOR;
    private String y = BuildConfig.FLAVOR;
    private int z = -1;
    private String B = BuildConfig.FLAVOR;
    private String C = BuildConfig.FLAVOR;
    private String E = "postdetail";

    public static /* synthetic */ void e(b bVar, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        bVar.d(z);
    }

    private final c f() {
        if (this.A == null) {
            this.A = (c) gj.a.a.a(c.class);
        }
        return this.A;
    }

    private final void q(boolean z) {
        this.e = 0L;
        this.f = 0L;
        this.g = 0L;
        this.h = 0L;
        this.i = 0L;
        this.j = 0;
        this.k = 0L;
        this.l = 0L;
        this.m = 0L;
        this.n = 0;
        this.o = 0L;
        this.p = 0L;
        this.q = 0L;
        if (z) {
            return;
        }
        this.z = -1;
        this.v = false;
    }

    public final void A(String str) {
        Intrinsics.h(str, "url");
        this.y = str;
    }

    public final void a(int i, int i2) {
        this.f = System.currentTimeMillis();
        a.a.f(wf.a.a, "video_play", "addSurface", false, 4, (Object) null);
    }

    public final void b() {
        a.a aVar = wf.a.a;
        String str = this.a;
        Intrinsics.g(str, "TAG");
        a.a.f(aVar, str, "clickPause", false, 4, (Object) null);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("module_name", MediaItem.MUSIC_FLOAT_STATE_PAUSE);
        h.a.q(this.E, "module_name", linkedHashMap);
    }

    public final void c() {
        a.a aVar = wf.a.a;
        String str = this.a;
        Intrinsics.g(str, "TAG");
        a.a.f(aVar, str, "clickPlay", false, 4, (Object) null);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("module_name", MediaItem.MUSIC_FLOAT_STATE_PLAY);
        h.a.q(this.E, "module_name", linkedHashMap);
    }

    /* JADX WARN: Removed duplicated region for block: B:118:0x017e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void d(boolean z) {
        String str;
        String str2;
        String str3;
        String str4;
        long j;
        String str5;
        String str6;
        Subject subject;
        Subject subject2;
        if (this.e == 0 && !this.v) {
            a.a aVar = wf.a.a;
            String str7 = this.a;
            Intrinsics.g(str7, "TAG");
            a.a.f(aVar, str7, "exitPlay, return", false, 4, (Object) null);
            return;
        }
        if (!this.v) {
            a.a aVar2 = wf.a.a;
            String str8 = this.a;
            Intrinsics.g(str8, "TAG");
            a.a.v(aVar2, str8, "curVideoIsApp2Background = " + z, false, 4, (Object) null);
            this.v = z;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        PostSubjectItem postSubjectItem = this.d;
        String str9 = BuildConfig.FLAVOR;
        if (postSubjectItem == null || (str = postSubjectItem.getPostId()) == null) {
            str = BuildConfig.FLAVOR;
        }
        linkedHashMap.put("post_id", str);
        linkedHashMap.put("opt_type", this.B);
        PostSubjectItem postSubjectItem2 = this.d;
        if (postSubjectItem2 == null || (subject2 = postSubjectItem2.getSubject()) == null || (str2 = subject2.getSubjectId()) == null) {
            str2 = BuildConfig.FLAVOR;
        }
        linkedHashMap.put("subject_id", str2);
        String str10 = this.s;
        if (str10 == null) {
            str10 = BuildConfig.FLAVOR;
        }
        linkedHashMap.put("base_post_id", str10);
        PostSubjectItem postSubjectItem3 = this.d;
        if (postSubjectItem3 == null || (str3 = postSubjectItem3.getItemType()) == null) {
            str3 = BuildConfig.FLAVOR;
        }
        linkedHashMap.put("item_type", str3);
        linkedHashMap.put("ep", this.C);
        String str11 = this.t;
        if (str11 == null) {
            str11 = BuildConfig.FLAVOR;
        }
        linkedHashMap.put("base_item_type", str11);
        PostSubjectItem postSubjectItem4 = this.d;
        linkedHashMap.put("has_resource", String.valueOf((postSubjectItem4 == null || (subject = postSubjectItem4.getSubject()) == null) ? null : subject.getHasResource()));
        String str12 = this.x;
        if (str12.length() == 0) {
            str12 = h.a.h();
        }
        linkedHashMap.put("page_from", str12);
        PostSubjectItem postSubjectItem5 = this.d;
        if (!TextUtils.isEmpty(postSubjectItem5 != null ? postSubjectItem5.getRec_ops() : null)) {
            PostSubjectItem postSubjectItem6 = this.d;
            if (postSubjectItem6 == null || (str6 = postSubjectItem6.getRec_ops()) == null) {
                str6 = BuildConfig.FLAVOR;
            }
            linkedHashMap.put("ops", str6);
        }
        String str13 = this.u;
        if (str13 != null && str13.length() != 0) {
            String str14 = this.u;
            if (str14 != null) {
                str9 = str14;
            }
            linkedHashMap.put("subpage_name", str9);
        }
        int i = this.D;
        if (i > 0) {
            linkedHashMap.put("subject_type", String.valueOf(i));
        }
        long j2 = this.g;
        String str15 = MsgStyle.CUSTOM_LEFT_PIC;
        if (j2 > 0 || (this.v && this.m > 0)) {
            linkedHashMap.put("is_start", MsgStyle.CUSTOM_LEFT_PIC);
            long j3 = this.e;
            if (j3 > 0) {
                long j4 = this.g;
                if (j4 > 0) {
                    str4 = String.valueOf(j4 - j3);
                    linkedHashMap.put("delay_v", str4);
                    j = this.f;
                    if (j > 0) {
                        long j5 = this.g;
                        if (j5 > 0) {
                            str5 = String.valueOf(j5 - j);
                            linkedHashMap.put("delay", str5);
                            linkedHashMap.put("buffer_time", String.valueOf(this.h));
                            linkedHashMap.put("buffer_count", String.valueOf(this.j));
                            linkedHashMap.put("play_complete", String.valueOf(((this.k / this.q) * 100.0f) + (this.n * 100.0f)));
                            linkedHashMap.put("play_duration", String.valueOf(this.m));
                            linkedHashMap.put("pause_duration", String.valueOf(this.p));
                            linkedHashMap.put("completeCount", String.valueOf(this.n));
                        }
                    }
                    str5 = "0";
                    linkedHashMap.put("delay", str5);
                    linkedHashMap.put("buffer_time", String.valueOf(this.h));
                    linkedHashMap.put("buffer_count", String.valueOf(this.j));
                    linkedHashMap.put("play_complete", String.valueOf(((this.k / this.q) * 100.0f) + (this.n * 100.0f)));
                    linkedHashMap.put("play_duration", String.valueOf(this.m));
                    linkedHashMap.put("pause_duration", String.valueOf(this.p));
                    linkedHashMap.put("completeCount", String.valueOf(this.n));
                }
            }
            str4 = "0";
            linkedHashMap.put("delay_v", str4);
            j = this.f;
            if (j > 0) {
            }
            str5 = "0";
            linkedHashMap.put("delay", str5);
            linkedHashMap.put("buffer_time", String.valueOf(this.h));
            linkedHashMap.put("buffer_count", String.valueOf(this.j));
            linkedHashMap.put("play_complete", String.valueOf(((this.k / this.q) * 100.0f) + (this.n * 100.0f)));
            linkedHashMap.put("play_duration", String.valueOf(this.m));
            linkedHashMap.put("pause_duration", String.valueOf(this.p));
            linkedHashMap.put("completeCount", String.valueOf(this.n));
        } else {
            linkedHashMap.put("is_start", "0");
            linkedHashMap.put("delay_v", this.e > 0 ? String.valueOf(System.currentTimeMillis() - this.e) : "0");
            linkedHashMap.put("delay", this.f > 0 ? String.valueOf(System.currentTimeMillis() - this.f) : "0");
        }
        linkedHashMap.put("app_to_background", z ? MsgStyle.CUSTOM_LEFT_PIC : "0");
        linkedHashMap.put("is_preloaded", ORPlayerPreloadManager.i.a().e(this.y) ? MsgStyle.CUSTOM_LEFT_PIC : "0");
        linkedHashMap.put("url", this.y);
        PostSubjectItem postSubjectItem7 = this.d;
        if (postSubjectItem7 == null || !postSubjectItem7.getBuiltIn()) {
            str15 = "0";
        }
        linkedHashMap.put("builtin", str15);
        long j6 = this.q;
        if (j6 > 0) {
            linkedHashMap.put("total_duration", String.valueOf(j6));
        }
        int i2 = this.z;
        if (i2 >= 0) {
            linkedHashMap.put("position", String.valueOf(i2));
        }
        Integer num = this.r;
        if (num != null) {
            linkedHashMap.put("error_code", String.valueOf(num));
        }
        if (!this.v || this.m > 0 || this.w) {
            if (z) {
                this.w = false;
            }
            c f = f();
            if (f != null) {
                f.b(this.m);
            }
            h.a.C(this.E, "video_play", this.m, linkedHashMap);
            q(z);
        }
    }

    public final void g() {
        this.e = System.currentTimeMillis();
        this.w = true;
        a.a.f(wf.a.a, "video_play", "initView", false, 4, (Object) null);
    }

    public final void h() {
        this.i = System.currentTimeMillis();
    }

    public final void i() {
        if (this.i > 0) {
            this.h += System.currentTimeMillis() - this.i;
            this.j++;
            this.i = 0L;
        }
    }

    public final void j() {
        this.n++;
        this.k = 0L;
    }

    public final void k(PlayError playError) {
        Intrinsics.h(playError, "errorInfo");
        this.r = playError.getErrorCode();
    }

    public final void l(long j) {
        f fVar = this.b;
        this.q = fVar != null ? fVar.getDuration() : 0L;
        long j2 = this.l;
        long j3 = j - j2;
        if (1 <= j3 && j3 < 1000) {
            this.m += j - j2;
        }
        this.l = j;
        if (j > this.k) {
            this.k = j;
        }
        c f = f();
        if (f != null) {
            f.a(this.m);
        }
    }

    public final void m() {
        a.a.f(wf.a.a, "video_play", "onRenderFirstFrame", false, 4, (Object) null);
        this.g = System.currentTimeMillis();
    }

    public final void n() {
        this.o = System.currentTimeMillis();
    }

    public final void o() {
        if (this.o != 0) {
            this.p += System.currentTimeMillis() - this.o;
            this.o = 0L;
        }
    }

    public final void p() {
        e(this, false, 1, null);
    }

    public final void r(String str) {
        this.t = str;
    }

    public final void s(String str) {
        this.s = str;
    }

    public final void t(String str) {
        Intrinsics.h(str, "pageFrom");
        this.x = str;
    }

    public final void u(String str) {
        Intrinsics.h(str, "<set-?>");
        this.E = str;
    }

    public final void v(f fVar) {
        Intrinsics.h(fVar, "orPlayer");
        a.a aVar = wf.a.a;
        String str = this.a;
        Intrinsics.g(str, "TAG");
        a.a.f(aVar, str, "setPlayer----->", false, 4, (Object) null);
        this.b = fVar;
    }

    public final void w(Integer num) {
        this.z = num != null ? num.intValue() : -1;
    }

    public final void x(String str, PostSubjectItem postSubjectItem) {
        a.a aVar = wf.a.a;
        String str2 = this.a;
        Intrinsics.g(str2, "TAG");
        a.a.f(aVar, str2, "setPostData----->", false, 4, (Object) null);
        this.c = str;
        this.d = postSubjectItem;
    }

    public final void y(int i) {
        this.D = i;
    }

    public final void z(String str) {
        Intrinsics.h(str, "subpageName");
        this.u = str;
    }
}
