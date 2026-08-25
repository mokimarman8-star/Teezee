package qi;

import com.transsion.gslb.BuildConfig;
import java.util.HashMap;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class b {
    private final String a;
    private final boolean b;
    private final HashMap c;
    private String d;
    private String e;
    private boolean f;
    private boolean g;
    private long h;
    private boolean i;
    private String j;

    public b(String str, boolean z) {
        Intrinsics.h(str, "pageName");
        this.a = str;
        this.b = z;
        this.c = new HashMap();
        this.e = BuildConfig.FLAVOR;
        this.g = true;
        this.h = -1L;
    }

    public /* synthetic */ b(String str, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? true : z);
    }

    public final String a() {
        return this.d;
    }

    public final boolean b() {
        return this.b;
    }

    public final boolean c() {
        return this.f;
    }

    public final boolean d() {
        return this.g;
    }

    public final String e() {
        return this.j;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return Intrinsics.c(this.a, bVar.a) && this.b == bVar.b;
    }

    public final String f() {
        return this.a;
    }

    public final HashMap g() {
        return this.c;
    }

    public final long h() {
        return this.h;
    }

    public int hashCode() {
        return (this.a.hashCode() * 31) + androidx.compose.foundation.e.a(this.b);
    }

    public final boolean i() {
        return this.i;
    }

    public final void j(String str) {
        this.d = str;
    }

    public final void k(boolean z) {
        this.i = z;
    }

    public final void l(boolean z) {
        this.f = z;
    }

    public final void m(boolean z) {
        this.g = z;
    }

    public final void n(String str) {
        this.j = str;
    }

    public final void o(long j) {
        this.h = j;
    }

    public String toString() {
        return "LogViewConfig(pageName=" + this.a + ", needAddToPageFrom=" + this.b + ')';
    }
}
