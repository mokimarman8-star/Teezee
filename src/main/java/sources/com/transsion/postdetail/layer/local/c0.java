package com.transsion.postdetail.layer.local;

import android.os.Bundle;
import android.text.TextUtils;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.gslb.BuildConfig;
import com.transsion.player.orplayer.PlayError;
import com.transsion.player.orplayer.global.TnPlayerType;
import com.transsion.push.bean.MsgStyle;
import com.transsion.ugcvideodetail.api.bean.UGCVideo;
import com.transsion.ugcvideodetail.api.bean.UGCVideoBelongToCollection;
import cw.e;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import wf.a;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class c0 {
    public static final a e0 = new a(null);
    private String A;
    private String B;
    private String C;
    private String D;
    private String F;
    private String G;
    private DownloadBean H;
    private String I;
    private int J;
    private boolean K;
    private int L;
    private int M;
    private String P;
    private UGCVideo S;
    private String T;
    private String U;
    private String V;
    private boolean Y;
    private TnPlayerType Z;
    private com.transsion.player.orplayer.f a;
    private boolean a0;
    private boolean b0;
    private long c;
    private gj.c c0;
    private long d;
    private boolean d0;
    private long e;
    private long f;
    private long g;
    private int h;
    private int i;
    private long j;
    private long k;
    private long l;
    private long m;
    private long n;
    private long o;
    private boolean p;
    private boolean r;
    private boolean s;
    private long t;
    private long u;
    private int v;
    private long w;
    private Integer x;
    private String y;
    private String z;
    private final String b = "long_video_play";
    private boolean q = true;
    private int E = -1;
    private int N = -1;
    private int O = -1;
    private String Q = "local_video_detail";
    private String R = "long_video_play";
    private Map W = new LinkedHashMap();
    private final List X = new ArrayList();

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public static /* synthetic */ void c(c0 c0Var, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        c0Var.b(z);
    }

    private final gj.c f() {
        if (this.c0 == null) {
            this.c0 = (gj.c) gj.a.a.a(gj.c.class);
        }
        return this.c0;
    }

    private final void x(boolean z) {
        this.c = 0L;
        this.d = 0L;
        this.e = 0L;
        this.f = 0L;
        this.g = 0L;
        this.h = 0;
        this.k = 0L;
        this.l = 0L;
        this.t = 0L;
        this.u = 0L;
        this.v = 0;
        this.m = 0L;
        this.n = 0L;
        this.o = 0L;
        this.i = 0;
        this.p = false;
        this.x = null;
        this.y = null;
        this.J = 0;
        this.z = BuildConfig.FLAVOR;
        if (z) {
            return;
        }
        this.j = 0L;
        this.w = 0L;
        this.Z = null;
        this.a0 = false;
        this.b0 = false;
        this.s = false;
    }

    public final void A(int i) {
        this.O = i;
    }

    public final void B(int i) {
        this.N = i;
    }

    public final void C(boolean z) {
        this.r = z;
    }

    public final void D(String str) {
        Intrinsics.h(str, "<set-?>");
        this.R = str;
    }

    public final void E(boolean z) {
        this.Y = z;
    }

    public final void F(boolean z) {
        this.d0 = z;
    }

    public final void G(int i, String str) {
        String str2;
        if (i == 1 || this.J != 1 || (str2 = this.z) == null || str2.length() <= 0) {
            this.J = i;
            this.z = str;
        }
    }

    public final void H(com.transsion.player.orplayer.f fVar) {
        this.a = fVar;
    }

    public final void I(String str) {
        Intrinsics.h(str, "<set-?>");
        this.Q = str;
    }

    public final void J(String str) {
        this.F = str;
    }

    public final void K(String str) {
        this.P = str;
    }

    public final void L(boolean z) {
        this.b0 = z;
    }

    public final void M(String str) {
        this.T = str;
    }

    public final void N(String str) {
        this.V = str;
    }

    public final void O(String str) {
        this.U = str;
    }

    public final void P(UGCVideo uGCVideo) {
        this.S = uGCVideo;
    }

    public final void a() {
        this.d = System.currentTimeMillis();
        a.a.f(wf.a.a, this.b, "addSurface", false, 4, (Object) null);
    }

    /* JADX WARN: Removed duplicated region for block: B:125:0x02aa  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x02b5  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x02c2  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x02cf  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x02e0  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x0422  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x042f  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x043c  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x0449  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x0456  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x046b  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x049b  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x04ac  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x04b9  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x05b2  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x064f  */
    /* JADX WARN: Removed duplicated region for block: B:210:0x05d0  */
    /* JADX WARN: Removed duplicated region for block: B:221:0x04c0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:248:0x0459  */
    /* JADX WARN: Removed duplicated region for block: B:249:0x044c  */
    /* JADX WARN: Removed duplicated region for block: B:250:0x0432  */
    /* JADX WARN: Removed duplicated region for block: B:251:0x0425  */
    /* JADX WARN: Removed duplicated region for block: B:256:0x0350  */
    /* JADX WARN: Removed duplicated region for block: B:261:0x0366  */
    /* JADX WARN: Removed duplicated region for block: B:266:0x039f  */
    /* JADX WARN: Removed duplicated region for block: B:269:0x0401  */
    /* JADX WARN: Removed duplicated region for block: B:271:0x0404  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void b(boolean z) {
        String str;
        String str2;
        String str3;
        String ugcVideoId;
        int i;
        int i2;
        int i3;
        int i4;
        long j;
        String str4;
        Object obj;
        String str5;
        long j2;
        String str6;
        long j3;
        TnPlayerType tnPlayerType;
        Map a2;
        Integer num;
        String str7;
        DownloadBean downloadBean;
        DownloadBean downloadBean2;
        DownloadBean downloadBean3;
        String str8;
        gj.c f;
        Long size;
        Long size2;
        String str9;
        String ugcVideoCollectionId;
        String str10;
        UGCVideoBelongToCollection belongToCollection;
        if (this.c == 0 && !this.s) {
            a.a.f(wf.a.a, this.b, " exitPlay, return", false, 4, (Object) null);
            return;
        }
        if (!this.s) {
            a.a.v(wf.a.a, this.b, " curVideoIsApp2Background = " + z, false, 4, (Object) null);
            this.s = z;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        DownloadBean downloadBean4 = this.H;
        String str11 = BuildConfig.FLAVOR;
        if (downloadBean4 == null || (str = downloadBean4.getPostId()) == null) {
            str = BuildConfig.FLAVOR;
        }
        linkedHashMap.put("post_id", str);
        DownloadBean downloadBean5 = this.H;
        if (downloadBean5 == null || (str2 = downloadBean5.getSubjectId()) == null) {
            str2 = BuildConfig.FLAVOR;
        }
        linkedHashMap.put("subject_id", str2);
        DownloadBean downloadBean6 = this.H;
        if (downloadBean6 == null || (str3 = downloadBean6.getResourceId()) == null) {
            str3 = BuildConfig.FLAVOR;
        }
        linkedHashMap.put("resource_id", str3);
        String str12 = this.F;
        if (str12 == null) {
            str12 = BuildConfig.FLAVOR;
        }
        linkedHashMap.put("play_type", str12);
        String str13 = this.I;
        if (str13 == null) {
            str13 = qi.h.a.h();
        }
        linkedHashMap.put("page_from", str13);
        String str14 = this.G;
        if (str14 == null) {
            str14 = BuildConfig.FLAVOR;
        }
        linkedHashMap.put("url", str14);
        com.transsion.baselib.helper.d dVar = com.transsion.baselib.helper.d.a;
        linkedHashMap.put("speed", String.valueOf(dVar.d()));
        linkedHashMap.put("scale_mode", String.valueOf(dVar.c().getValue()));
        linkedHashMap.put("lock", this.Y ? MsgStyle.CUSTOM_LEFT_PIC : "0");
        UGCVideo uGCVideo = this.S;
        if (uGCVideo == null || (ugcVideoId = uGCVideo.getUgcVideoId()) == null) {
            DownloadBean downloadBean7 = this.H;
            ugcVideoId = downloadBean7 != null ? downloadBean7.getUgcVideoId() : null;
        }
        if (ugcVideoId != null && ugcVideoId.length() != 0) {
            UGCVideo uGCVideo2 = this.S;
            if (uGCVideo2 == null || (belongToCollection = uGCVideo2.getBelongToCollection()) == null || (ugcVideoCollectionId = belongToCollection.getCollectionId()) == null) {
                DownloadBean downloadBean8 = this.H;
                ugcVideoCollectionId = downloadBean8 != null ? downloadBean8.getUgcVideoCollectionId() : null;
                if (ugcVideoCollectionId == null) {
                    ugcVideoCollectionId = BuildConfig.FLAVOR;
                }
            }
            linkedHashMap.put("content_id", ugcVideoId);
            linkedHashMap.put("belong_to_collection_id", ugcVideoCollectionId);
            linkedHashMap.put("content_type", "ugc_video");
            DownloadBean downloadBean9 = this.H;
            if (downloadBean9 == null || (str10 = downloadBean9.getSubjectId()) == null) {
                str10 = BuildConfig.FLAVOR;
            }
            linkedHashMap.put("refer_subject_id", str10);
        }
        String str15 = this.T;
        if (str15 != null) {
            linkedHashMap.put("parent_content_id", str15);
        }
        String str16 = this.U;
        if (str16 != null) {
            linkedHashMap.put("track_id", str16);
        }
        String str17 = this.V;
        if (str17 != null) {
            linkedHashMap.put("parent_track_id", str17);
        }
        e.a aVar = cw.e.a;
        linkedHashMap.put("pip_feature", String.valueOf(aVar.b().c()));
        linkedHashMap.put("pip_system_feature", String.valueOf(aVar.b().i()));
        String str18 = this.P;
        if (str18 != null && str18.length() > 0) {
            String str19 = this.P;
            Intrinsics.e(str19);
            linkedHashMap.put("resolution", str19);
        }
        if (Intrinsics.c(this.F, "0") || Intrinsics.c(this.F, MsgStyle.CUSTOM_LEFT_PIC)) {
            DownloadBean downloadBean10 = this.H;
            linkedHashMap.put("item_type", String.valueOf(downloadBean10 != null ? Integer.valueOf(downloadBean10.getType()) : null));
        }
        DownloadBean downloadBean11 = this.H;
        if (!TextUtils.isEmpty(downloadBean11 != null ? downloadBean11.getOps() : null)) {
            DownloadBean downloadBean12 = this.H;
            if (downloadBean12 == null || (str9 = downloadBean12.getOps()) == null) {
                str9 = BuildConfig.FLAVOR;
            }
            linkedHashMap.put("ops", str9);
        }
        DownloadBean downloadBean13 = this.H;
        if (downloadBean13 != null && (size2 = downloadBean13.getSize()) != null) {
            linkedHashMap.put("resource_size", String.valueOf(size2.longValue()));
        }
        DownloadBean downloadBean14 = this.H;
        if (downloadBean14 != null) {
            long progress = downloadBean14.getProgress();
            if (Intrinsics.c(this.F, MsgStyle.CUSTOM_LEFT_PIC)) {
                float f2 = progress * 100.0f;
                DownloadBean downloadBean15 = this.H;
                linkedHashMap.put("downloaded_percent", String.valueOf(f2 / ((downloadBean15 == null || (size = downloadBean15.getSize()) == null) ? 1L : size.longValue())));
            }
        }
        for (Map.Entry entry : this.W.entrySet()) {
            linkedHashMap.put("subtitle_use_time_" + ((ht.a) entry.getKey()).b().getType() + "_" + ((ht.a) entry.getKey()).b().getLan(), String.valueOf(((Number) entry.getValue()).longValue()));
        }
        DownloadBean downloadBean16 = this.H;
        if (downloadBean16 != null && downloadBean16.isSeries()) {
            DownloadBean downloadBean17 = this.H;
            if ((downloadBean17 != null ? downloadBean17.getEp() : 0) > 0) {
                DownloadBean downloadBean18 = this.H;
                i = downloadBean18 != null ? downloadBean18.getSe() : 0;
                DownloadBean downloadBean19 = this.H;
                if (downloadBean19 != null) {
                    i2 = downloadBean19.getEp();
                }
            } else {
                DownloadBean downloadBean20 = this.H;
                i = downloadBean20 != null ? downloadBean20.getEpse() / 100 : 0;
                DownloadBean downloadBean21 = this.H;
                if (downloadBean21 != null) {
                    i2 = downloadBean21.getEpse() % 100;
                }
            }
            if (i > 0) {
                linkedHashMap.put("seasons", String.valueOf(i));
            }
            if (i2 > 0) {
                linkedHashMap.put("episode", String.valueOf(i2));
            }
            i3 = this.N;
            if (i3 >= 0) {
                linkedHashMap.put("position", String.valueOf(i3));
            }
            i4 = this.O;
            if (i4 >= 0) {
                linkedHashMap.put("parent_position", String.valueOf(i4));
            }
            if (this.t != 0) {
                this.u += System.currentTimeMillis() - this.t;
                this.t = 0L;
            }
            if (this.e <= 0 || this.s) {
                linkedHashMap.put("is_start", MsgStyle.CUSTOM_LEFT_PIC);
                j = this.c;
                str4 = "play_type";
                obj = MsgStyle.CUSTOM_LEFT_PIC;
                if (j > 0) {
                    long j4 = this.e;
                    if (j4 > 0) {
                        str5 = String.valueOf(j4 - j);
                        linkedHashMap.put("delay_v", str5);
                        j2 = this.d;
                        if (j2 > 0) {
                            long j5 = this.e;
                            if (j5 > 0) {
                                str6 = String.valueOf(j5 - j2);
                                linkedHashMap.put("delay", str6);
                                linkedHashMap.put("buffer_time", String.valueOf(this.f));
                                linkedHashMap.put("buffer_count", String.valueOf(this.h));
                                linkedHashMap.put("seek_count", String.valueOf(this.i));
                                j3 = this.w;
                                if (j3 > 0) {
                                    linkedHashMap.put("play_complete", String.valueOf((this.j / j3) * 100.0f));
                                    linkedHashMap.put("total_duration", String.valueOf(this.w));
                                }
                                linkedHashMap.put("play_duration", String.valueOf(this.l));
                                linkedHashMap.put("play_duration_middlepage", String.valueOf(this.n));
                                linkedHashMap.put("play_duration_fullscreen", String.valueOf(this.m));
                                linkedHashMap.put("play_duration_pip", String.valueOf(this.o));
                                linkedHashMap.put("pause_duration", String.valueOf(this.u));
                                linkedHashMap.put("pause_count", String.valueOf(this.v));
                                linkedHashMap.put("complete", !this.p ? obj : "0");
                                linkedHashMap.put("video_bitrate", String.valueOf(this.L));
                                linkedHashMap.put("audio_bitrate", String.valueOf(this.M));
                            }
                        }
                        str6 = "0";
                        linkedHashMap.put("delay", str6);
                        linkedHashMap.put("buffer_time", String.valueOf(this.f));
                        linkedHashMap.put("buffer_count", String.valueOf(this.h));
                        linkedHashMap.put("seek_count", String.valueOf(this.i));
                        j3 = this.w;
                        if (j3 > 0) {
                        }
                        linkedHashMap.put("play_duration", String.valueOf(this.l));
                        linkedHashMap.put("play_duration_middlepage", String.valueOf(this.n));
                        linkedHashMap.put("play_duration_fullscreen", String.valueOf(this.m));
                        linkedHashMap.put("play_duration_pip", String.valueOf(this.o));
                        linkedHashMap.put("pause_duration", String.valueOf(this.u));
                        linkedHashMap.put("pause_count", String.valueOf(this.v));
                        linkedHashMap.put("complete", !this.p ? obj : "0");
                        linkedHashMap.put("video_bitrate", String.valueOf(this.L));
                        linkedHashMap.put("audio_bitrate", String.valueOf(this.M));
                    }
                }
                str5 = "0";
                linkedHashMap.put("delay_v", str5);
                j2 = this.d;
                if (j2 > 0) {
                }
                str6 = "0";
                linkedHashMap.put("delay", str6);
                linkedHashMap.put("buffer_time", String.valueOf(this.f));
                linkedHashMap.put("buffer_count", String.valueOf(this.h));
                linkedHashMap.put("seek_count", String.valueOf(this.i));
                j3 = this.w;
                if (j3 > 0) {
                }
                linkedHashMap.put("play_duration", String.valueOf(this.l));
                linkedHashMap.put("play_duration_middlepage", String.valueOf(this.n));
                linkedHashMap.put("play_duration_fullscreen", String.valueOf(this.m));
                linkedHashMap.put("play_duration_pip", String.valueOf(this.o));
                linkedHashMap.put("pause_duration", String.valueOf(this.u));
                linkedHashMap.put("pause_count", String.valueOf(this.v));
                linkedHashMap.put("complete", !this.p ? obj : "0");
                linkedHashMap.put("video_bitrate", String.valueOf(this.L));
                linkedHashMap.put("audio_bitrate", String.valueOf(this.M));
            } else {
                linkedHashMap.put("is_start", "0");
                linkedHashMap.put("delay_v", this.c > 0 ? String.valueOf(System.currentTimeMillis() - this.c) : "0");
                linkedHashMap.put("delay", this.d > 0 ? String.valueOf(System.currentTimeMillis() - this.d) : "0");
                linkedHashMap.put("not_play_error_msg", String.valueOf(this.z));
                str4 = "play_type";
                obj = MsgStyle.CUSTOM_LEFT_PIC;
            }
            linkedHashMap.put("app_to_background", !z ? obj : "0");
            linkedHashMap.put("is_replay", !this.K ? obj : "0");
            tnPlayerType = this.Z;
            if (tnPlayerType != null) {
                linkedHashMap.put("error_player", String.valueOf(tnPlayerType));
            }
            linkedHashMap.put("aliyun_2_sfotdecoder", !this.a0 ? obj : "0");
            linkedHashMap.put("timeout_replay", !this.b0 ? obj : "0");
            a2 = com.transsnet.downloader.util.h.a.a();
            if (!a2.isEmpty()) {
                for (Map.Entry entry2 : a2.entrySet()) {
                    linkedHashMap.put((String) entry2.getKey(), String.valueOf(((Number) entry2.getValue()).longValue()));
                }
            }
            num = this.x;
            if (num != null) {
                linkedHashMap.put("player_error_code", String.valueOf(num.intValue()));
            }
            str7 = this.y;
            if (str7 != null) {
                linkedHashMap.put("player_error_msg", str7);
            }
            if (this.X.isEmpty()) {
                try {
                    LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                    List list = this.X;
                    ArrayList<ht.a> arrayList = new ArrayList();
                    arrayList.addAll(list);
                    for (ht.a aVar2 : arrayList) {
                        if (aVar2.d()) {
                            String lan = aVar2.b().getLan();
                            Intrinsics.e(lan);
                            if (!linkedHashMap2.containsKey(lan)) {
                                String lan2 = aVar2.b().getLan();
                                Intrinsics.e(lan2);
                                linkedHashMap2.put(lan2, BuildConfig.FLAVOR);
                            }
                        }
                    }
                } catch (Throwable unused) {
                }
                String str20 = this.C;
                if (str20 == null) {
                    str20 = BuildConfig.FLAVOR;
                }
                linkedHashMap.put("subtitle_type", str20);
                String str21 = this.D;
                if (str21 == null) {
                    str21 = BuildConfig.FLAVOR;
                }
                linkedHashMap.put("subtitle_lan", str21);
                linkedHashMap.put("subtitle_from", String.valueOf(this.E));
                a.a.f(wf.a.a, "ORSubtitle", "LanName= " + this.C + ",Lan = " + this.D + ", From = " + this.E, false, 4, (Object) null);
            } else {
                linkedHashMap.put("subtitle_downloaded", "0");
            }
            if (TextUtils.isEmpty(this.A) || !TextUtils.isEmpty(this.B)) {
                linkedHashMap.put("subtitle_bilingual", CollectionsKt.q(new String[]{this.A, this.B}).toString());
            }
            downloadBean = this.H;
            if (!(downloadBean == null && downloadBean.getSubjectType() == 6) && (f = f()) != null) {
                f.b(this.l);
            }
            a.a aVar3 = wf.a.a;
            a.a.f(aVar3, this.b, "video exit， report and reset data", false, 4, (Object) null);
            if (this.x == null) {
                aVar3.i(this.b, "error " + qi.h.a.n(linkedHashMap), true);
            } else {
                String str22 = this.b;
                Object obj2 = linkedHashMap.get("is_start");
                DownloadBean downloadBean22 = this.H;
                String subjectId = downloadBean22 != null ? downloadBean22.getSubjectId() : null;
                DownloadBean downloadBean23 = this.H;
                String resourceId = downloadBean23 != null ? downloadBean23.getResourceId() : null;
                aVar3.i(str22, "is_start=" + obj2 + " subject_id=" + subjectId + " requestId=" + resourceId + " urlOrPath=" + this.G, true);
            }
            qi.h.a.C(this.Q, this.R, this.l, linkedHashMap);
            Bundle bundle = new Bundle();
            downloadBean2 = this.H;
            if (downloadBean2 != null || (r3 = downloadBean2.getSubjectId()) == null) {
                String str23 = BuildConfig.FLAVOR;
            }
            bundle.putString("subject_id", str23);
            downloadBean3 = this.H;
            if (downloadBean3 != null || (r3 = downloadBean3.getResourceId()) == null) {
                String str24 = BuildConfig.FLAVOR;
            }
            bundle.putString("resource_id", str24);
            str8 = this.F;
            if (str8 != null) {
                str11 = str8;
            }
            bundle.putString(str4, str11);
            bundle.putBoolean("is_music_liked_fragment", this.d0);
            com.transsion.baselib.report.e.a.l(this.R, bundle, com.transsion.baselib.report.k.a.o());
            x(z);
        }
        i = 0;
        i2 = 0;
        if (i > 0) {
        }
        if (i2 > 0) {
        }
        i3 = this.N;
        if (i3 >= 0) {
        }
        i4 = this.O;
        if (i4 >= 0) {
        }
        if (this.t != 0) {
        }
        if (this.e <= 0) {
        }
        linkedHashMap.put("is_start", MsgStyle.CUSTOM_LEFT_PIC);
        j = this.c;
        str4 = "play_type";
        obj = MsgStyle.CUSTOM_LEFT_PIC;
        if (j > 0) {
        }
        str5 = "0";
        linkedHashMap.put("delay_v", str5);
        j2 = this.d;
        if (j2 > 0) {
        }
        str6 = "0";
        linkedHashMap.put("delay", str6);
        linkedHashMap.put("buffer_time", String.valueOf(this.f));
        linkedHashMap.put("buffer_count", String.valueOf(this.h));
        linkedHashMap.put("seek_count", String.valueOf(this.i));
        j3 = this.w;
        if (j3 > 0) {
        }
        linkedHashMap.put("play_duration", String.valueOf(this.l));
        linkedHashMap.put("play_duration_middlepage", String.valueOf(this.n));
        linkedHashMap.put("play_duration_fullscreen", String.valueOf(this.m));
        linkedHashMap.put("play_duration_pip", String.valueOf(this.o));
        linkedHashMap.put("pause_duration", String.valueOf(this.u));
        linkedHashMap.put("pause_count", String.valueOf(this.v));
        linkedHashMap.put("complete", !this.p ? obj : "0");
        linkedHashMap.put("video_bitrate", String.valueOf(this.L));
        linkedHashMap.put("audio_bitrate", String.valueOf(this.M));
        linkedHashMap.put("app_to_background", !z ? obj : "0");
        linkedHashMap.put("is_replay", !this.K ? obj : "0");
        tnPlayerType = this.Z;
        if (tnPlayerType != null) {
        }
        linkedHashMap.put("aliyun_2_sfotdecoder", !this.a0 ? obj : "0");
        linkedHashMap.put("timeout_replay", !this.b0 ? obj : "0");
        a2 = com.transsnet.downloader.util.h.a.a();
        if (!a2.isEmpty()) {
        }
        num = this.x;
        if (num != null) {
        }
        str7 = this.y;
        if (str7 != null) {
        }
        if (this.X.isEmpty()) {
        }
        if (TextUtils.isEmpty(this.A)) {
        }
        linkedHashMap.put("subtitle_bilingual", CollectionsKt.q(new String[]{this.A, this.B}).toString());
        downloadBean = this.H;
        if (!(downloadBean == null && downloadBean.getSubjectType() == 6)) {
            f.b(this.l);
        }
        a.a aVar32 = wf.a.a;
        a.a.f(aVar32, this.b, "video exit， report and reset data", false, 4, (Object) null);
        if (this.x == null) {
        }
        qi.h.a.C(this.Q, this.R, this.l, linkedHashMap);
        Bundle bundle2 = new Bundle();
        downloadBean2 = this.H;
        if (downloadBean2 != null) {
        }
        String str232 = BuildConfig.FLAVOR;
        bundle2.putString("subject_id", str232);
        downloadBean3 = this.H;
        if (downloadBean3 != null) {
        }
        String str242 = BuildConfig.FLAVOR;
        bundle2.putString("resource_id", str242);
        str8 = this.F;
        if (str8 != null) {
        }
        bundle2.putString(str4, str11);
        bundle2.putBoolean("is_music_liked_fragment", this.d0);
        com.transsion.baselib.report.e.a.l(this.R, bundle2, com.transsion.baselib.report.k.a.o());
        x(z);
    }

    public final boolean d() {
        return this.Y;
    }

    public final Map e() {
        return this.W;
    }

    public final void g() {
        this.c = System.currentTimeMillis();
        a.a.f(wf.a.a, this.b, "initView", false, 4, (Object) null);
    }

    public final void h() {
        a.a.f(wf.a.a, this.b, "onCompletion", false, 4, (Object) null);
        this.p = true;
    }

    public final void i() {
        a.a.f(wf.a.a, this.b, "onLoadingBegin", false, 4, (Object) null);
        this.g = System.currentTimeMillis();
    }

    public final void j() {
        if (this.g > 0) {
            this.f += System.currentTimeMillis() - this.g;
            this.h++;
            this.g = 0L;
        }
    }

    public final void k(LocalUiType localUiType) {
        Intrinsics.h(localUiType, "uiType");
        this.q = localUiType == LocalUiType.MIDDLE;
        a.a.f(wf.a.a, this.b, "onLocalUiChanged， uiType= " + localUiType, false, 4, (Object) null);
    }

    public final void l(PlayError playError) {
        Intrinsics.h(playError, "errorInfo");
        this.x = playError.getErrorCode();
        String errorMessage = playError.getErrorMessage();
        this.y = errorMessage;
        a.a.f(wf.a.a, this.b, "onPlayError, playerErrorCode  =" + this.x + ", playerErrorMessage =" + errorMessage, false, 4, (Object) null);
        G(3, this.y);
    }

    public final void m(long j) {
        gj.c f;
        if (this.w <= 0) {
            com.transsion.player.orplayer.f fVar = this.a;
            this.w = fVar != null ? fVar.getDuration() : 0L;
        }
        long j2 = this.k;
        long j3 = j - j2;
        if (1 <= j3 && j3 < 2000) {
            this.l += j - j2;
            if (this.r) {
                this.o += j - j2;
            } else if (this.q) {
                this.n += j - j2;
            } else {
                this.m += j - j2;
            }
        }
        this.k = j;
        if (j > this.j) {
            this.j = j;
        }
        DownloadBean downloadBean = this.H;
        if ((downloadBean == null || downloadBean.getSubjectType() != 6) && (f = f()) != null) {
            f.a(this.l);
        }
    }

    public final void n() {
        a.a.f(wf.a.a, this.b, "onRenderFirstFrame", false, 4, (Object) null);
        this.e = System.currentTimeMillis();
    }

    public final void o() {
        a.a.f(wf.a.a, this.b, "oonReplayonReplay", false, 4, (Object) null);
        this.K = true;
        this.s = false;
    }

    public final void p() {
        this.i++;
    }

    public final void q(List list) {
        Intrinsics.h(list, "list");
        this.X.clear();
        this.X.addAll(list);
    }

    public final void r(String str, String str2, int i) {
        Intrinsics.h(str, "name");
        Intrinsics.h(str2, "lan");
        a.a.f(wf.a.a, this.b, "onSubtitleSelected = " + str, false, 4, (Object) null);
        this.C = str;
        this.D = str2;
        this.E = i;
    }

    public final void s(String str, String str2) {
        this.A = str;
        this.B = str2;
    }

    public final void t(int i) {
        this.M = i;
    }

    public final void u(int i) {
        this.L = i;
    }

    public final void v() {
        this.v++;
        a.a.f(wf.a.a, this.b, "onVideoPause", false, 4, (Object) null);
        this.t = System.currentTimeMillis();
    }

    public final void w() {
        a.a.f(wf.a.a, this.b, "onVideoStart", false, 4, (Object) null);
        if (this.t != 0) {
            this.u += System.currentTimeMillis() - this.t;
            this.t = 0L;
        }
    }

    public final void y(boolean z) {
        this.a0 = z;
    }

    public final void z(DownloadBean downloadBean, String str) {
        this.I = str;
        this.H = downloadBean;
        if (downloadBean == null || !downloadBean.isInnerRes()) {
            this.F = "2";
            this.G = downloadBean != null ? downloadBean.getPath() : null;
        } else if (downloadBean == null || downloadBean.getStatus() != 5) {
            this.F = MsgStyle.CUSTOM_LEFT_PIC;
            this.G = downloadBean != null ? downloadBean.getUrl() : null;
        } else {
            this.F = "0";
            this.G = downloadBean.getPath();
        }
        a.a.f(wf.a.a, this.b, "setData", false, 4, (Object) null);
    }
}
