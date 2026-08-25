package wr;

import android.text.TextUtils;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.transsion.gslb.BuildConfig;
import com.transsion.player.mediasession.MediaItem;
import com.transsion.player.orplayer.PlayError;
import com.transsion.player.orplayer.e;
import com.transsion.player.orplayer.f;
import com.transsion.push.bean.MsgStyle;
import com.transsion.shorttv.bean.Subject;
import com.transsion.shorttv.viewmodel.ShortTvViewModel;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;
import qi.h;
import qn.d;
import wf.a;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class c implements e {
    private int A;
    private Subject B;
    private String C;
    private String D;
    private int E;
    private int F;
    private boolean G;
    private String H;
    private final Fragment a;
    private final ShortTvViewModel b;
    private final String c;
    private f d;
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
    private boolean u;
    private boolean v;
    private String w;
    private String x;
    private int y;
    private int z;

    public c(Fragment fragment, ShortTvViewModel shortTvViewModel) {
        Intrinsics.h(fragment, "fragment");
        this.a = fragment;
        this.b = shortTvViewModel;
        this.c = c.class.getSimpleName();
        this.v = true;
        this.w = BuildConfig.FLAVOR;
        this.x = BuildConfig.FLAVOR;
        this.y = -1;
        this.C = BuildConfig.FLAVOR;
        this.D = BuildConfig.FLAVOR;
        this.H = "postdetail";
    }

    public static /* synthetic */ void f(c cVar, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        cVar.d(z);
    }

    private final void i(boolean z) {
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
        this.r = null;
        this.G = false;
        if (z) {
            return;
        }
        this.y = -1;
        this.u = false;
    }

    public final void a(int i, int i2) {
        this.f = System.currentTimeMillis();
        a.a.f(wf.a.a, "video_play", "addSurface", false, 4, (Object) null);
    }

    public final void b() {
        a.a aVar = wf.a.a;
        String str = this.c;
        Intrinsics.g(str, "TAG");
        a.a.f(aVar, str, "clickPause", false, 4, (Object) null);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("module_name", MediaItem.MUSIC_FLOAT_STATE_PAUSE);
        linkedHashMap.put("content_type", "ugc_video");
        h.a.o(this.H, linkedHashMap);
    }

    public final void c() {
        a.a aVar = wf.a.a;
        String str = this.c;
        Intrinsics.g(str, "TAG");
        a.a.f(aVar, str, "clickPlay", false, 4, (Object) null);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("module_name", MediaItem.MUSIC_FLOAT_STATE_PLAY);
        linkedHashMap.put("content_type", "ugc_video");
        h.a.o(this.H, linkedHashMap);
    }

    @Override // com.transsion.player.orplayer.e
    public void canNonSubscriberPlay(boolean z, int i, int i2, d dVar) {
        e.a.a(this, z, i, i2, dVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:106:0x0144  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void d(boolean z) {
        String str;
        String str2;
        long j;
        String str3;
        ur.a D0;
        String valueOf;
        String ops;
        if (this.e == 0 && !this.u) {
            a.a aVar = wf.a.a;
            String str4 = this.c;
            Intrinsics.g(str4, "TAG");
            a.a.f(aVar, str4, "exitPlay, return", false, 4, (Object) null);
            return;
        }
        if (!this.u) {
            a.a aVar2 = wf.a.a;
            String str5 = this.c;
            Intrinsics.g(str5, "TAG");
            a.a.v(aVar2, str5, "curVideoIsApp2Background = " + z, false, 4, (Object) null);
            this.u = z;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("opt_type", this.C);
        Subject subject = this.B;
        String str6 = BuildConfig.FLAVOR;
        if (subject == null || (str = subject.getSubjectId()) == null) {
            str = BuildConfig.FLAVOR;
        }
        linkedHashMap.put("subject_id", str);
        String str7 = this.s;
        if (str7 == null) {
            str7 = BuildConfig.FLAVOR;
        }
        linkedHashMap.put("base_post_id", str7);
        linkedHashMap.put("item_type", "7");
        linkedHashMap.put("ep", this.D);
        String str8 = this.t;
        if (str8 == null) {
            str8 = BuildConfig.FLAVOR;
        }
        linkedHashMap.put("base_item_type", str8);
        Subject subject2 = this.B;
        linkedHashMap.put("has_resource", String.valueOf(subject2 != null ? subject2.getHasResource() : null));
        String str9 = this.w;
        if (str9.length() == 0) {
            str9 = h.a.h();
        }
        linkedHashMap.put("page_from", str9);
        Subject subject3 = this.B;
        if (!TextUtils.isEmpty(subject3 != null ? subject3.getOps() : null)) {
            Subject subject4 = this.B;
            if (subject4 != null && (ops = subject4.getOps()) != null) {
                str6 = ops;
            }
            linkedHashMap.put("ops", str6);
        }
        int i = this.E;
        if (i > 0) {
            linkedHashMap.put("subject_type", String.valueOf(i));
        }
        long j2 = this.g;
        String str10 = MsgStyle.CUSTOM_LEFT_PIC;
        if (j2 > 0 || (this.u && this.m > 0)) {
            linkedHashMap.put("is_start", MsgStyle.CUSTOM_LEFT_PIC);
            long j3 = this.e;
            if (j3 > 0) {
                long j4 = this.g;
                if (j4 > 0) {
                    str2 = String.valueOf(j4 - j3);
                    linkedHashMap.put("delay_v", str2);
                    j = this.f;
                    if (j > 0) {
                        long j5 = this.g;
                        if (j5 > 0) {
                            str3 = String.valueOf(j5 - j);
                            linkedHashMap.put("delay", str3);
                            linkedHashMap.put("buffer_time", String.valueOf(this.h));
                            linkedHashMap.put("buffer_count", String.valueOf(this.j));
                            linkedHashMap.put("play_complete", String.valueOf(((this.k / this.q) * 100.0f) + (this.n * 100.0f)));
                            linkedHashMap.put("play_duration", String.valueOf(this.m));
                            linkedHashMap.put("pause_duration", String.valueOf(this.p));
                            linkedHashMap.put("completeCount", String.valueOf(this.n));
                        }
                    }
                    str3 = "0";
                    linkedHashMap.put("delay", str3);
                    linkedHashMap.put("buffer_time", String.valueOf(this.h));
                    linkedHashMap.put("buffer_count", String.valueOf(this.j));
                    linkedHashMap.put("play_complete", String.valueOf(((this.k / this.q) * 100.0f) + (this.n * 100.0f)));
                    linkedHashMap.put("play_duration", String.valueOf(this.m));
                    linkedHashMap.put("pause_duration", String.valueOf(this.p));
                    linkedHashMap.put("completeCount", String.valueOf(this.n));
                }
            }
            str2 = "0";
            linkedHashMap.put("delay_v", str2);
            j = this.f;
            if (j > 0) {
            }
            str3 = "0";
            linkedHashMap.put("delay", str3);
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
        linkedHashMap.put("url", this.x);
        linkedHashMap.put("download_status", String.valueOf(this.F));
        long j6 = this.q;
        if (j6 > 0) {
            linkedHashMap.put("total_duration", String.valueOf(j6));
        }
        int i2 = this.y;
        if (i2 >= 0) {
            linkedHashMap.put("position", String.valueOf(i2));
        }
        linkedHashMap.put("player_type", MsgStyle.CUSTOM_LEFT_PIC);
        Integer num = this.r;
        if (num != null) {
            linkedHashMap.put("error_code", String.valueOf(num));
        }
        if (this.F == 0) {
            long j7 = this.g;
            if (j7 > 0) {
                long j8 = this.e;
                if (j8 > 0) {
                    valueOf = String.valueOf(j7 - j8);
                    linkedHashMap.put("delay_net_source", valueOf);
                }
            }
            valueOf = this.e > 0 ? String.valueOf(System.currentTimeMillis() - this.e) : "0";
            linkedHashMap.put("delay_net_source", valueOf);
        }
        if (!this.G) {
            str10 = "0";
        }
        linkedHashMap.put("is_first_play", str10);
        if (!this.u || this.m > 0 || this.v) {
            if (z) {
                this.v = false;
            }
            ShortTvViewModel shortTvViewModel = this.b;
            if (shortTvViewModel != null && (D0 = shortTvViewModel.D0()) != null) {
                D0.b(this.m);
            }
            linkedHashMap.put("video_bitrate", String.valueOf(this.z));
            linkedHashMap.put("audio_bitrate", String.valueOf(this.A));
            h.a.C(this.H, "video_play", this.m, linkedHashMap);
            i(z);
        }
    }

    public final void e(boolean z, boolean z2) {
        if (z) {
            d(z2);
        } else {
            i(z2);
        }
    }

    public final void g(View view, boolean z) {
        Intrinsics.h(view, "rootView");
        this.e = System.currentTimeMillis();
        this.v = true;
        a.a.f(wf.a.a, "video_play", "initView", false, 4, (Object) null);
    }

    public final void h() {
        f(this, false, 1, null);
    }

    @Override // com.transsion.player.orplayer.e
    public void initPlayer() {
        e.a.b(this);
    }

    public final void j(String str) {
        this.t = str;
    }

    public final void k(String str) {
        this.s = str;
    }

    public final void l(int i) {
        this.F = i;
    }

    public final void m(String str) {
        Intrinsics.h(str, "<set-?>");
        this.D = str;
    }

    public final void n(boolean z) {
        this.G = z;
    }

    public final void o(String str) {
        Intrinsics.h(str, "<set-?>");
        this.C = str;
    }

    @Override // com.transsion.player.orplayer.e
    public void onAliyunDecodeErrorChangeSoftwareDecoder(gn.e eVar) {
        e.a.c(this, eVar);
    }

    @Override // com.transsion.player.orplayer.e
    public void onBufferedPosition(long j, gn.e eVar) {
        e.a.d(this, j, eVar);
    }

    @Override // com.transsion.player.orplayer.e
    public void onCompletion(gn.e eVar) {
        e.a.e(this, eVar);
        e.a.z(this, this.q, null, 2, null);
    }

    @Override // com.transsion.player.orplayer.e
    public void onFocusChange(boolean z) {
        e.a.g(this, z);
    }

    @Override // com.transsion.player.orplayer.e
    public void onIsPlayingChanged(boolean z) {
        e.a.h(this, z);
    }

    @Override // com.transsion.player.orplayer.e
    public void onLoadingBegin(gn.e eVar) {
        this.i = System.currentTimeMillis();
    }

    @Override // com.transsion.player.orplayer.e
    public void onLoadingEnd(gn.e eVar) {
        if (this.i > 0) {
            this.h += System.currentTimeMillis() - this.i;
            this.j++;
            this.i = 0L;
        }
    }

    @Override // com.transsion.player.orplayer.e
    public void onLoadingProgress(int i, float f, gn.e eVar) {
        e.a.m(this, i, f, eVar);
    }

    @Override // com.transsion.player.orplayer.e
    public void onLoopingStart() {
        this.n++;
        this.k = 0L;
    }

    @Override // com.transsion.player.orplayer.e
    public void onMediaItemTransition(String str) {
        e.a.p(this, str);
    }

    @Override // com.transsion.player.orplayer.e
    public void onPlayError(PlayError playError, gn.e eVar) {
        Intrinsics.h(playError, "errorInfo");
        this.r = playError.getErrorCode();
    }

    @Override // com.transsion.player.orplayer.e
    public void onPlayerRelease(gn.e eVar) {
        e.a.t(this, eVar);
    }

    @Override // com.transsion.player.orplayer.e
    public void onPlayerReset() {
        e.a.v(this);
    }

    @Override // com.transsion.player.orplayer.e
    public void onPrepare(gn.e eVar) {
        e.a.w(this, eVar);
    }

    @Override // com.transsion.player.orplayer.e
    public void onProgress(long j, gn.e eVar) {
        ur.a D0;
        if (0 == this.q) {
            f fVar = this.d;
            this.q = fVar != null ? fVar.getDuration() : 0L;
        }
        long j2 = this.l;
        long j3 = j - j2;
        if (1 <= j3 && j3 < 1000) {
            this.m += j - j2;
        }
        this.l = j;
        if (j > this.k) {
            this.k = j;
        }
        ShortTvViewModel shortTvViewModel = this.b;
        if (shortTvViewModel == null || (D0 = shortTvViewModel.D0()) == null) {
            return;
        }
        D0.a(this.m);
    }

    @Override // com.transsion.player.orplayer.e
    public void onRenderFirstFrame() {
        a.a.f(wf.a.a, "video_play", "onRenderFirstFrame", false, 4, (Object) null);
        this.g = System.currentTimeMillis();
    }

    @Override // com.transsion.player.orplayer.e
    public void onSetDataSource() {
        e.a.B(this);
    }

    @Override // com.transsion.player.orplayer.e
    public void onTracksAudioBitrateChange(int i) {
        this.A = i;
    }

    @Override // com.transsion.player.orplayer.e
    public void onTracksChange(qn.c cVar) {
        e.a.D(this, cVar);
    }

    @Override // com.transsion.player.orplayer.e
    public void onTracksVideoBitrateChange(int i) {
        this.z = i;
    }

    @Override // com.transsion.player.orplayer.e
    public void onVideoPause(gn.e eVar) {
        this.o = System.currentTimeMillis();
    }

    @Override // com.transsion.player.orplayer.e
    public void onVideoSizeChanged(int i, int i2) {
        e.a.H(this, i, i2);
    }

    @Override // com.transsion.player.orplayer.e
    public void onVideoStart(gn.e eVar) {
        if (this.o != 0) {
            this.p += System.currentTimeMillis() - this.o;
            this.o = 0L;
        }
    }

    public final void p(f fVar) {
        this.d = fVar;
    }

    public final void q(String str) {
        Intrinsics.h(str, "pageFrom");
        this.w = str;
    }

    public final void r(String str) {
        Intrinsics.h(str, "<set-?>");
        this.H = str;
    }

    public final void s(Integer num) {
        this.y = num != null ? num.intValue() : -1;
    }

    @Override // com.transsion.player.orplayer.e
    public void setOnSeekCompleteListener() {
        e.a.K(this);
    }

    public final void t(Subject subject) {
        this.B = subject;
    }

    public final void u(int i) {
        this.E = i;
    }

    public final void v(String str) {
        Intrinsics.h(str, "url");
        this.x = str;
    }
}
