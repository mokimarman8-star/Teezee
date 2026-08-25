package androidx.compose.ui.input.pointer;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class g0 {

    /* renamed from: a, reason: collision with root package name */
    private final int f3988a;

    private /* synthetic */ g0(int i5) {
        this.f3988a = i5;
    }

    public static final /* synthetic */ g0 a(int i5) {
        return new g0(i5);
    }

    public static int b(int i5) {
        return i5;
    }

    public static boolean c(int i5, Object obj) {
        return (obj instanceof g0) && i5 == ((g0) obj).f();
    }

    public static int d(int i5) {
        return i5;
    }

    public static String e(int i5) {
        return "PointerKeyboardModifiers(packedValue=" + i5 + ')';
    }

    public boolean equals(Object obj) {
        return c(this.f3988a, obj);
    }

    public final /* synthetic */ int f() {
        return this.f3988a;
    }

    public int hashCode() {
        return d(this.f3988a);
    }

    public String toString() {
        return e(this.f3988a);
    }
}
