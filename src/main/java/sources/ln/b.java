package ln;

import androidx.compose.foundation.e;
import com.transsion.gslb.BuildConfig;
import com.transsion.player.longvideo.constants.LongVodPlayerConfigType;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class b {
    private boolean a;
    private final String b;
    private final LongVodPlayerConfigType c;

    public b() {
        this(false, null, null, 7, null);
    }

    public b(boolean z, String str, LongVodPlayerConfigType longVodPlayerConfigType) {
        Intrinsics.h(str, "content");
        Intrinsics.h(longVodPlayerConfigType, "configType");
        this.a = z;
        this.b = str;
        this.c = longVodPlayerConfigType;
    }

    public /* synthetic */ b(boolean z, String str, LongVodPlayerConfigType longVodPlayerConfigType, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? BuildConfig.FLAVOR : str, (i & 4) != 0 ? LongVodPlayerConfigType.BITRATE : longVodPlayerConfigType);
    }

    public static /* synthetic */ b b(b bVar, boolean z, String str, LongVodPlayerConfigType longVodPlayerConfigType, int i, Object obj) {
        if ((i & 1) != 0) {
            z = bVar.a;
        }
        if ((i & 2) != 0) {
            str = bVar.b;
        }
        if ((i & 4) != 0) {
            longVodPlayerConfigType = bVar.c;
        }
        return bVar.a(z, str, longVodPlayerConfigType);
    }

    public final b a(boolean z, String str, LongVodPlayerConfigType longVodPlayerConfigType) {
        Intrinsics.h(str, "content");
        Intrinsics.h(longVodPlayerConfigType, "configType");
        return new b(z, str, longVodPlayerConfigType);
    }

    public final LongVodPlayerConfigType c() {
        return this.c;
    }

    public final String d() {
        return this.b;
    }

    public final boolean e() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.a == bVar.a && Intrinsics.c(this.b, bVar.b) && this.c == bVar.c;
    }

    public final void f(boolean z) {
        this.a = z;
    }

    public int hashCode() {
        return (((e.a(this.a) * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
    }

    public String toString() {
        return "LongVdPlayerConfigBean(isSelected=" + this.a + ", content=" + this.b + ", configType=" + this.c + ")";
    }
}
