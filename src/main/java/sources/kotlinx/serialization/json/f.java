package kotlinx.serialization.json;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.apache.tools.zip.UnixStat;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class f {
    private final boolean a;
    private final boolean b;
    private final boolean c;
    private final boolean d;
    private final boolean e;
    private final boolean f;
    private final String g;
    private final boolean h;
    private final boolean i;
    private final String j;
    private final boolean k;
    private final boolean l;

    public f() {
        this(false, false, false, false, false, false, null, false, false, null, false, false, UnixStat.PERM_MASK, null);
    }

    public f(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, String prettyPrintIndent, boolean z7, boolean z8, String classDiscriminator, boolean z9, boolean z10) {
        Intrinsics.h(prettyPrintIndent, "prettyPrintIndent");
        Intrinsics.h(classDiscriminator, "classDiscriminator");
        this.a = z;
        this.b = z2;
        this.c = z3;
        this.d = z4;
        this.e = z5;
        this.f = z6;
        this.g = prettyPrintIndent;
        this.h = z7;
        this.i = z8;
        this.j = classDiscriminator;
        this.k = z9;
        this.l = z10;
    }

    public /* synthetic */ f(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, String str, boolean z7, boolean z8, String str2, boolean z9, boolean z10, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? false : z2, (i & 4) != 0 ? false : z3, (i & 8) != 0 ? false : z4, (i & 16) != 0 ? false : z5, (i & 32) != 0 ? true : z6, (i & 64) != 0 ? "    " : str, (i & 128) != 0 ? false : z7, (i & 256) != 0 ? false : z8, (i & 512) != 0 ? "type" : str2, (i & 1024) == 0 ? z9 : false, (i & 2048) == 0 ? z10 : true);
    }

    public final boolean a() {
        return this.k;
    }

    public final boolean b() {
        return this.d;
    }

    public final String c() {
        return this.j;
    }

    public final boolean d() {
        return this.h;
    }

    public final boolean e() {
        return this.a;
    }

    public final boolean f() {
        return this.f;
    }

    public final boolean g() {
        return this.b;
    }

    public final boolean h() {
        return this.e;
    }

    public final String i() {
        return this.g;
    }

    public final boolean j() {
        return this.l;
    }

    public final boolean k() {
        return this.i;
    }

    public final boolean l() {
        return this.c;
    }

    public String toString() {
        return "JsonConfiguration(encodeDefaults=" + this.a + ", ignoreUnknownKeys=" + this.b + ", isLenient=" + this.c + ", allowStructuredMapKeys=" + this.d + ", prettyPrint=" + this.e + ", explicitNulls=" + this.f + ", prettyPrintIndent='" + this.g + "', coerceInputValues=" + this.h + ", useArrayPolymorphism=" + this.i + ", classDiscriminator='" + this.j + "', allowSpecialFloatingPointValues=" + this.k + ')';
    }
}
