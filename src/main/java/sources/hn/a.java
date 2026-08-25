package hn;

import androidx.compose.foundation.e;
import com.transsion.player.config.PlayerType;
import com.transsion.player.p003enum.ScaleMode;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class a {
    private final d a;
    private final PlayerType b;
    private final boolean c;
    private final boolean d;
    private final float e;
    private final ScaleMode f;

    public a(d dVar, PlayerType playerType, boolean z, boolean z2, float f, ScaleMode scaleMode) {
        Intrinsics.h(dVar, "vodConfig");
        Intrinsics.h(playerType, "playerType");
        Intrinsics.h(scaleMode, "scaleMode");
        this.a = dVar;
        this.b = playerType;
        this.c = z;
        this.d = z2;
        this.e = f;
        this.f = scaleMode;
    }

    public /* synthetic */ a(d dVar, PlayerType playerType, boolean z, boolean z2, float f, ScaleMode scaleMode, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(dVar, (i & 2) != 0 ? PlayerType.EXO : playerType, (i & 4) != 0 ? true : z, (i & 8) != 0 ? true : z2, f, scaleMode);
    }

    public final ScaleMode a() {
        return this.f;
    }

    public final float b() {
        return this.e;
    }

    public final boolean c() {
        return this.d;
    }

    public final d d() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return Intrinsics.c(this.a, aVar.a) && this.b == aVar.b && this.c == aVar.c && this.d == aVar.d && Float.compare(this.e, aVar.e) == 0 && this.f == aVar.f;
    }

    public int hashCode() {
        return (((((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + e.a(this.c)) * 31) + e.a(this.d)) * 31) + Float.floatToIntBits(this.e)) * 31) + this.f.hashCode();
    }

    public String toString() {
        return "LongVodConfig(vodConfig=" + this.a + ", playerType=" + this.b + ", openMediaNotification=" + this.c + ", useSurface=" + this.d + ", speed=" + this.e + ", scaleMode=" + this.f + ")";
    }
}
