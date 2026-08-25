package androidx.compose.ui.text.input;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class c0 implements m {

    /* renamed from: a, reason: collision with root package name */
    private final int f5221a;

    /* renamed from: b, reason: collision with root package name */
    private final int f5222b;

    public c0(int i5, int i6) {
        this.f5221a = i5;
        this.f5222b = i6;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c0)) {
            return false;
        }
        c0 c0Var = (c0) obj;
        return this.f5221a == c0Var.f5221a && this.f5222b == c0Var.f5222b;
    }

    public int hashCode() {
        return (this.f5221a * 31) + this.f5222b;
    }

    public String toString() {
        return "SetSelectionCommand(start=" + this.f5221a + ", end=" + this.f5222b + ')';
    }
}
