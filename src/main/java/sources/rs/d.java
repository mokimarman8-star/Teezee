package rs;

import com.transsion.player.orplayer.f;
import com.transsion.player.ui.ORPlayerView;
import com.transsion.shorttv_pugc.ShorttvModel;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class d {
    private final ORPlayerView a;
    private final f b;
    private final String c;
    private final int d;
    private final String e;
    private final String f;
    private final String g;
    private final List h;
    private final ShorttvModel.UGCVideo i;

    public d(ORPlayerView playerView, f orPlayer, String ugcVideoId, int i, String pageName, String str, String str2, List playList, ShorttvModel.UGCVideo uGCVideo) {
        Intrinsics.h(playerView, "playerView");
        Intrinsics.h(orPlayer, "orPlayer");
        Intrinsics.h(ugcVideoId, "ugcVideoId");
        Intrinsics.h(pageName, "pageName");
        Intrinsics.h(playList, "playList");
        this.a = playerView;
        this.b = orPlayer;
        this.c = ugcVideoId;
        this.d = i;
        this.e = pageName;
        this.f = str;
        this.g = str2;
        this.h = playList;
        this.i = uGCVideo;
    }

    public final int a() {
        return this.d;
    }

    public final String b() {
        return this.f;
    }

    public final f c() {
        return this.b;
    }

    public final String d() {
        return this.g;
    }

    public final String e() {
        return this.e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return Intrinsics.c(this.a, dVar.a) && Intrinsics.c(this.b, dVar.b) && Intrinsics.c(this.c, dVar.c) && this.d == dVar.d && Intrinsics.c(this.e, dVar.e) && Intrinsics.c(this.f, dVar.f) && Intrinsics.c(this.g, dVar.g) && Intrinsics.c(this.h, dVar.h) && Intrinsics.c(this.i, dVar.i);
    }

    public final List f() {
        return this.h;
    }

    public final ORPlayerView g() {
        return this.a;
    }

    public final ShorttvModel.UGCVideo h() {
        return this.i;
    }

    public int hashCode() {
        int hashCode = ((((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d) * 31) + this.e.hashCode()) * 31;
        String str = this.f;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.g;
        int hashCode3 = (((hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31) + this.h.hashCode()) * 31;
        ShorttvModel.UGCVideo uGCVideo = this.i;
        return hashCode3 + (uGCVideo != null ? uGCVideo.hashCode() : 0);
    }

    public String toString() {
        return "ShortTvFloatBean(playerView=" + this.a + ", orPlayer=" + this.b + ", ugcVideoId=" + this.c + ", ep=" + this.d + ", pageName=" + this.e + ", ops=" + this.f + ", pageFrom=" + this.g + ", playList=" + this.h + ", ugcVideo=" + this.i + ")";
    }
}
