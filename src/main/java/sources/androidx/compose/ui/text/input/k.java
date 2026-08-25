package androidx.compose.ui.text.input;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class k implements m {

    /* renamed from: a, reason: collision with root package name */
    private final int f5232a;

    /* renamed from: b, reason: collision with root package name */
    private final int f5233b;

    public k(int i5, int i6) {
        this.f5232a = i5;
        this.f5233b = i6;
        if (i5 < 0 || i6 < 0) {
            throw new IllegalArgumentException(("Expected lengthBeforeCursor and lengthAfterCursor to be non-negative, were " + i5 + " and " + i6 + " respectively.").toString());
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof k)) {
            return false;
        }
        k kVar = (k) obj;
        return this.f5232a == kVar.f5232a && this.f5233b == kVar.f5233b;
    }

    public int hashCode() {
        return (this.f5232a * 31) + this.f5233b;
    }

    public String toString() {
        return "DeleteSurroundingTextCommand(lengthBeforeCursor=" + this.f5232a + ", lengthAfterCursor=" + this.f5233b + ')';
    }
}
