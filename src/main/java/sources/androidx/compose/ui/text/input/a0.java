package androidx.compose.ui.text.input;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class a0 implements m {

    /* renamed from: a, reason: collision with root package name */
    private final int f5217a;

    /* renamed from: b, reason: collision with root package name */
    private final int f5218b;

    public a0(int i5, int i6) {
        this.f5217a = i5;
        this.f5218b = i6;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a0)) {
            return false;
        }
        a0 a0Var = (a0) obj;
        return this.f5217a == a0Var.f5217a && this.f5218b == a0Var.f5218b;
    }

    public int hashCode() {
        return (this.f5217a * 31) + this.f5218b;
    }

    public String toString() {
        return "SetComposingRegionCommand(start=" + this.f5217a + ", end=" + this.f5218b + ')';
    }
}
