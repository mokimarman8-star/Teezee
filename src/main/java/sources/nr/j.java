package nr;

import com.transsion.player.ui.ORPlayerView;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class j {
    private final ORPlayerView a;
    private final com.transsion.player.orplayer.f b;
    private final String c;
    private final int d;
    private final int e;
    private final String f;
    private final String g;
    private final String h;
    private final List i;

    public j(ORPlayerView oRPlayerView, com.transsion.player.orplayer.f fVar, String str, int i, int i2, String str2, String str3, String str4, List list) {
        Intrinsics.h(oRPlayerView, "playerView");
        Intrinsics.h(fVar, "orPlayer");
        Intrinsics.h(str, "subjectId");
        Intrinsics.h(str2, "pageName");
        Intrinsics.h(list, "playList");
        this.a = oRPlayerView;
        this.b = fVar;
        this.c = str;
        this.d = i;
        this.e = i2;
        this.f = str2;
        this.g = str3;
        this.h = str4;
        this.i = list;
    }

    public final int a() {
        return this.e;
    }

    public final String b() {
        return this.g;
    }

    public final com.transsion.player.orplayer.f c() {
        return this.b;
    }

    public final String d() {
        return this.h;
    }

    public final String e() {
        return this.f;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof j)) {
            return false;
        }
        j jVar = (j) obj;
        return Intrinsics.c(this.a, jVar.a) && Intrinsics.c(this.b, jVar.b) && Intrinsics.c(this.c, jVar.c) && this.d == jVar.d && this.e == jVar.e && Intrinsics.c(this.f, jVar.f) && Intrinsics.c(this.g, jVar.g) && Intrinsics.c(this.h, jVar.h) && Intrinsics.c(this.i, jVar.i);
    }

    public final List f() {
        return this.i;
    }

    public final ORPlayerView g() {
        return this.a;
    }

    public final int h() {
        return this.d;
    }

    public int hashCode() {
        int hashCode = ((((((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d) * 31) + this.e) * 31) + this.f.hashCode()) * 31;
        String str = this.g;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.h;
        return ((hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31) + this.i.hashCode();
    }

    public final String i() {
        return this.c;
    }

    public String toString() {
        return "ShortTvFloatBean(playerView=" + this.a + ", orPlayer=" + this.b + ", subjectId=" + this.c + ", se=" + this.d + ", ep=" + this.e + ", pageName=" + this.f + ", ops=" + this.g + ", pageFrom=" + this.h + ", playList=" + this.i + ")";
    }
}
