package androidx.compose.runtime.snapshots;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class s {

    /* renamed from: a, reason: collision with root package name */
    private static final Object f3015a = new Object();

    /* JADX INFO: Access modifiers changed from: private */
    public static final Void e() {
        throw new IllegalStateException("Cannot call set before the first call to next() or previous() or immediately after a call to add() or remove()");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Void f() {
        throw new IllegalStateException("Cannot modify a state list through an iterator");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(int i5, int i6) {
        if (i5 < 0 || i5 >= i6) {
            throw new IndexOutOfBoundsException("index (" + i5 + ") is out of bound of [0, " + i6 + ')');
        }
    }
}
