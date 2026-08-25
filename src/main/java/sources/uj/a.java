package uj;

import com.transsion.ad.ps.model.RecommendInfo;
import com.transsion.bean.GameInfoType;
import com.transsion.commercialization.gameres.aha.c;
import com.transsion.gslb.BuildConfig;
import kotlin.jvm.internal.Intrinsics;
import zg.b;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class a {
    private final GameInfoType a;
    private final RecommendInfo b;
    private final c c;
    private transient String d;
    private transient String e;

    /* renamed from: uj.a$a, reason: collision with other inner class name */
    public /* synthetic */ class C0095a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[GameInfoType.values().length];
            try {
                iArr[GameInfoType.AHA.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[GameInfoType.PS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            a = iArr;
        }
    }

    public a(GameInfoType gameInfoType, RecommendInfo recommendInfo, c cVar) {
        Intrinsics.h(gameInfoType, "type");
        this.a = gameInfoType;
        this.b = recommendInfo;
        this.c = cVar;
    }

    public final c a() {
        return this.c;
    }

    public final String b() {
        String categoryName;
        RecommendInfo recommendInfo = this.b;
        if (recommendInfo != null && (categoryName = recommendInfo.getCategoryName()) != null) {
            return categoryName;
        }
        c cVar = this.c;
        String b = cVar != null ? cVar.b() : null;
        return b == null ? BuildConfig.FLAVOR : b;
    }

    public final String c() {
        String iconUrl;
        RecommendInfo recommendInfo = this.b;
        if (recommendInfo != null && (iconUrl = recommendInfo.getIconUrl()) != null) {
            return iconUrl;
        }
        c cVar = this.c;
        String c = cVar != null ? cVar.c() : null;
        return c == null ? BuildConfig.FLAVOR : c;
    }

    public final String d() {
        String name;
        RecommendInfo recommendInfo = this.b;
        if (recommendInfo != null && (name = recommendInfo.getName()) != null) {
            return name;
        }
        c cVar = this.c;
        String f = cVar != null ? cVar.f() : null;
        return f == null ? BuildConfig.FLAVOR : f;
    }

    public final String e() {
        String d;
        int i = C0095a.a[this.a.ordinal()];
        if (i == 1) {
            c cVar = this.c;
            return (cVar == null || (d = cVar.d()) == null) ? BuildConfig.FLAVOR : d;
        }
        if (i != 2) {
            return BuildConfig.FLAVOR;
        }
        RecommendInfo recommendInfo = this.b;
        if ((recommendInfo != null ? recommendInfo.getSize() : 0L) <= 0) {
            return BuildConfig.FLAVOR;
        }
        RecommendInfo recommendInfo2 = this.b;
        return b.a(recommendInfo2 != null ? recommendInfo2.getSize() : 0L, 1);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.a == aVar.a && Intrinsics.c(this.b, aVar.b) && Intrinsics.c(this.c, aVar.c);
    }

    public final String f() {
        Double e;
        String star;
        RecommendInfo recommendInfo = this.b;
        if (recommendInfo != null && (star = recommendInfo.getStar()) != null) {
            return star;
        }
        c cVar = this.c;
        return (cVar == null || (e = cVar.e()) == null) ? BuildConfig.FLAVOR : e.toString();
    }

    public final String g() {
        return this.e;
    }

    public final String h() {
        return this.d;
    }

    public int hashCode() {
        int hashCode = this.a.hashCode() * 31;
        RecommendInfo recommendInfo = this.b;
        int hashCode2 = (hashCode + (recommendInfo == null ? 0 : recommendInfo.hashCode())) * 31;
        c cVar = this.c;
        return hashCode2 + (cVar != null ? cVar.hashCode() : 0);
    }

    public final RecommendInfo i() {
        return this.b;
    }

    public final GameInfoType j() {
        return this.a;
    }

    public final void k(String str) {
        this.e = str;
    }

    public final void l(String str) {
        this.d = str;
    }

    public String toString() {
        return "GameResInfo(type=" + this.a + ", psInfo=" + this.b + ", ahaInfo=" + this.c + ")";
    }
}
