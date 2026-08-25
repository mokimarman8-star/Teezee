package nr;

import com.transsion.shorttv.bean.ShortTVItem;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class e extends k {
    private final String a;
    private final int b;
    private ShortTVItem c;
    private int d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(String str, int i, ShortTVItem shortTVItem, int i2) {
        super(null);
        Intrinsics.h(str, "subjectId");
        this.a = str;
        this.b = i;
        this.c = shortTVItem;
        this.d = i2;
    }

    public /* synthetic */ e(String str, int i, ShortTVItem shortTVItem, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i, (i3 & 4) != 0 ? null : shortTVItem, (i3 & 8) != 0 ? 0 : i2);
    }

    public final String a() {
        return "shorttv_ad_" + this.a + "_" + this.b;
    }

    public final int b() {
        return this.d;
    }

    public final int c() {
        return this.b;
    }

    public final ShortTVItem d() {
        return this.c;
    }

    public final String e() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!Intrinsics.c(e.class, obj != null ? obj.getClass() : null)) {
            return false;
        }
        Intrinsics.f(obj, "null cannot be cast to non-null type com.transsion.shorttv.bean.ShortTvEpisodeSelectItem");
        e eVar = (e) obj;
        return Intrinsics.c(this.a, eVar.a) && this.b == eVar.b;
    }

    public final String f() {
        return this.a + "_" + this.b + "short";
    }

    public final void g(int i) {
        this.d = i;
    }

    public final void h(ShortTVItem shortTVItem) {
        this.c = shortTVItem;
    }

    public int hashCode() {
        return (this.a.hashCode() * 31) + this.b;
    }

    public String toString() {
        return "ShortTvEpisodeSelectItem(subjectId=" + this.a + ", ep=" + this.b + ", item=" + this.c + ", downloadStatus=" + this.d + ")";
    }
}
