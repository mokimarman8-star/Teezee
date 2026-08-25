package androidx.compose.ui.text.input;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class l implements m {

    /* renamed from: a, reason: collision with root package name */
    private final int f5234a;

    /* renamed from: b, reason: collision with root package name */
    private final int f5235b;

    public l(int i5, int i6) {
        this.f5234a = i5;
        this.f5235b = i6;
        if (i5 < 0 || i6 < 0) {
            throw new IllegalArgumentException(("Expected lengthBeforeCursor and lengthAfterCursor to be non-negative, were " + i5 + " and " + i6 + " respectively.").toString());
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof l)) {
            return false;
        }
        l lVar = (l) obj;
        return this.f5234a == lVar.f5234a && this.f5235b == lVar.f5235b;
    }

    public int hashCode() {
        return (this.f5234a * 31) + this.f5235b;
    }

    public String toString() {
        return "DeleteSurroundingTextInCodePointsCommand(lengthBeforeCursor=" + this.f5234a + ", lengthAfterCursor=" + this.f5235b + ')';
    }
}
