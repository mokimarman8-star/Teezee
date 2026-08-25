package nr;

import com.transsion.shorttv.bean.ShortTVItem;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class d {
    private final String a;
    private final int b;
    private boolean c;
    private boolean d;
    private ShortTVItem e;

    public d(String str, int i, boolean z, boolean z2, ShortTVItem shortTVItem) {
        Intrinsics.h(str, "subjectId");
        this.a = str;
        this.b = i;
        this.c = z;
        this.d = z2;
        this.e = shortTVItem;
    }

    public /* synthetic */ d(String str, int i, boolean z, boolean z2, ShortTVItem shortTVItem, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i, (i2 & 4) != 0 ? false : z, (i2 & 8) != 0 ? false : z2, (i2 & 16) != 0 ? null : shortTVItem);
    }

    public final ShortTVItem a() {
        return this.e;
    }

    public final int b() {
        return this.b;
    }

    public final boolean c() {
        return this.d;
    }

    public final boolean d() {
        return this.c;
    }

    public final void e(boolean z) {
        this.d = z;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return Intrinsics.c(this.a, dVar.a) && this.b == dVar.b && this.c == dVar.c && this.d == dVar.d && Intrinsics.c(this.e, dVar.e);
    }

    public final void f(ShortTVItem shortTVItem) {
        this.e = shortTVItem;
    }

    public final void g(boolean z) {
        this.c = z;
    }

    public int hashCode() {
        int hashCode = ((((((this.a.hashCode() * 31) + this.b) * 31) + androidx.compose.foundation.e.a(this.c)) * 31) + androidx.compose.foundation.e.a(this.d)) * 31;
        ShortTVItem shortTVItem = this.e;
        return hashCode + (shortTVItem == null ? 0 : shortTVItem.hashCode());
    }

    public String toString() {
        return "ShortTvDownloadEpisodeSelectItem(subjectId=" + this.a + ", position=" + this.b + ", isSelect=" + this.c + ", isDownload=" + this.d + ", episodeItem=" + this.e + ")";
    }
}
