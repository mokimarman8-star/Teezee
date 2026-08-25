package w;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public static final d f18080a = new d();

    private d() {
    }

    public static final void a(int i5, int i6) {
        if (i5 < 0 || i5 >= i6) {
            throw new IndexOutOfBoundsException("index: " + i5 + ", size: " + i6);
        }
    }

    public static final void b(int i5, int i6) {
        if (i5 < 0 || i5 > i6) {
            throw new IndexOutOfBoundsException("index: " + i5 + ", size: " + i6);
        }
    }

    public static final void c(int i5, int i6, int i7) {
        if (i5 < 0 || i6 > i7) {
            throw new IndexOutOfBoundsException("fromIndex: " + i5 + ", toIndex: " + i6 + ", size: " + i7);
        }
        if (i5 <= i6) {
            return;
        }
        throw new IllegalArgumentException("fromIndex: " + i5 + " > toIndex: " + i6);
    }
}
