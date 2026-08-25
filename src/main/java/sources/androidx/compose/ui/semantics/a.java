package androidx.compose.ui.semantics;

import kotlin.Function;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private final String f4948a;

    /* renamed from: b, reason: collision with root package name */
    private final Function f4949b;

    public a(String str, Function function) {
        this.f4948a = str;
        this.f4949b = function;
    }

    public final Function a() {
        return this.f4949b;
    }

    public final String b() {
        return this.f4948a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return Intrinsics.c(this.f4948a, aVar.f4948a) && Intrinsics.c(this.f4949b, aVar.f4949b);
    }

    public int hashCode() {
        String str = this.f4948a;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        Function function = this.f4949b;
        return hashCode + (function != null ? function.hashCode() : 0);
    }

    public String toString() {
        return "AccessibilityAction(label=" + this.f4948a + ", action=" + this.f4949b + ')';
    }
}
