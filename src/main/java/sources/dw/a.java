package dw;

import android.view.ViewGroup;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.player.enum.PlayMimeType;
import com.transsion.player.orplayer.f;
import com.transsion.player.ui.ORPlayerView;
import com.transsion.ugcvideodetail.api.bean.UGCVideo;
import com.transsion.videofloat.bean.FloatPlayType;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class a {
    private final ORPlayerView a;
    private final f b;
    private final ViewGroup c;
    private final FloatPlayType d;
    private final String e;
    private int f;
    private int g;
    private String h;
    private String i;
    private long j;
    private String k;
    private PlayMimeType l;
    private UGCVideo m;
    private DownloadBean n;
    private String o;
    private Integer p;
    private String q;
    private String r;
    private String s;
    private boolean t;
    private String u;
    private boolean v;
    private final boolean w;

    public a(ORPlayerView playerView, f orPlayer, ViewGroup viewGroup, FloatPlayType playType, String subjectId, int i, int i2, String str, String pageName) {
        Intrinsics.h(playerView, "playerView");
        Intrinsics.h(orPlayer, "orPlayer");
        Intrinsics.h(playType, "playType");
        Intrinsics.h(subjectId, "subjectId");
        Intrinsics.h(pageName, "pageName");
        this.a = playerView;
        this.b = orPlayer;
        this.c = viewGroup;
        this.d = playType;
        this.e = subjectId;
        this.f = i;
        this.g = i2;
        this.h = str;
        this.i = pageName;
        this.w = playType == FloatPlayType.LOCAL || playType == FloatPlayType.STREAM;
    }

    private final boolean d() {
        PlayMimeType playMimeType = this.l;
        return playMimeType == PlayMimeType.DASH || playMimeType == PlayMimeType.HLS;
    }

    public final void A(String str) {
        this.q = str;
    }

    public final void B(String str) {
        this.s = str;
    }

    public final void C(String str) {
        this.u = str;
    }

    public final void D(boolean z) {
        this.v = z;
    }

    public final void E(String str) {
        this.r = str;
    }

    public final void F(long j) {
        this.j = j;
    }

    public final void G(String str) {
        this.k = str;
    }

    public final void H(int i) {
        this.f = i;
    }

    public final void I(PlayMimeType playMimeType) {
        this.l = playMimeType;
    }

    public final void J(Integer num) {
        this.p = num;
    }

    public final void K(String str) {
        this.o = str;
    }

    public final void L(UGCVideo uGCVideo) {
        this.m = uGCVideo;
    }

    public final boolean a() {
        return this.t;
    }

    public final DownloadBean b() {
        return this.n;
    }

    public final int c() {
        return this.g;
    }

    public final String e() {
        return this.q;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return Intrinsics.c(this.a, aVar.a) && Intrinsics.c(this.b, aVar.b) && Intrinsics.c(this.c, aVar.c) && this.d == aVar.d && Intrinsics.c(this.e, aVar.e) && this.f == aVar.f && this.g == aVar.g && Intrinsics.c(this.h, aVar.h) && Intrinsics.c(this.i, aVar.i);
    }

    public final f f() {
        return this.b;
    }

    public final String g() {
        return this.s;
    }

    public final String h() {
        return this.i;
    }

    public int hashCode() {
        int hashCode = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
        ViewGroup viewGroup = this.c;
        int hashCode2 = (((((((((hashCode + (viewGroup == null ? 0 : viewGroup.hashCode())) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31) + this.f) * 31) + this.g) * 31;
        String str = this.h;
        return ((hashCode2 + (str != null ? str.hashCode() : 0)) * 31) + this.i.hashCode();
    }

    public final FloatPlayType i() {
        return this.d;
    }

    public final String j() {
        return this.u;
    }

    public final String k() {
        if (this.m != null) {
            String name = this.d.name();
            UGCVideo uGCVideo = this.m;
            Intrinsics.e(uGCVideo);
            String ugcVideoId = uGCVideo.getUgcVideoId();
            if (ugcVideoId == null) {
                ugcVideoId = "ugcVideo";
            }
            return name + ugcVideoId;
        }
        if (this.n != null) {
            String name2 = this.d.name();
            DownloadBean downloadBean = this.n;
            Intrinsics.e(downloadBean);
            String ugcVideoId2 = downloadBean.getUgcVideoId();
            if (ugcVideoId2 == null) {
                ugcVideoId2 = "ugcLocalVideo";
            }
            return name2 + ugcVideoId2;
        }
        FloatPlayType floatPlayType = this.d;
        if (floatPlayType == FloatPlayType.LOCAL) {
            return floatPlayType.name() + this.k;
        }
        return floatPlayType.name() + this.e;
    }

    public final ORPlayerView l() {
        return this.a;
    }

    public final String m() {
        return this.r;
    }

    public final long n() {
        return this.j;
    }

    public final String o() {
        return this.h;
    }

    public final String p() {
        return this.k;
    }

    public final int q() {
        return this.f;
    }

    public final String r() {
        return this.e;
    }

    public final Integer s() {
        return this.p;
    }

    public final String t() {
        UGCVideo uGCVideo = this.m;
        if (uGCVideo != null) {
            Intrinsics.e(uGCVideo);
            return uGCVideo.getUgcVideoId() + "_" + this.o;
        }
        DownloadBean downloadBean = this.n;
        if (downloadBean != null) {
            Intrinsics.e(downloadBean);
            return downloadBean.getSubtitleResId();
        }
        return this.e + "_" + this.f + "_" + this.g + "_en_" + (d() ? 2 : 1);
    }

    public String toString() {
        return "VideoFloatBean(playerView=" + this.a + ", orPlayer=" + this.b + ", subtitleViewGroup=" + this.c + ", playType=" + this.d + ", subjectId=" + this.e + ", se=" + this.f + ", ep=" + this.g + ", resolution=" + this.h + ", pageName=" + this.i + ")";
    }

    public final ViewGroup u() {
        return this.c;
    }

    public final UGCVideo v() {
        return this.m;
    }

    public final boolean w() {
        return this.v;
    }

    public final boolean x() {
        return this.w;
    }

    public final void y(DownloadBean downloadBean) {
        this.n = downloadBean;
    }

    public final void z(int i) {
        this.g = i;
    }
}
