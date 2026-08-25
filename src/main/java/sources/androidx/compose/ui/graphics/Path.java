package androidx.compose.ui.graphics;

import kotlin.Metadata;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public interface Path {

    /* renamed from: a, reason: collision with root package name */
    public static final a f3272a = a.f3273a;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Landroidx/compose/ui/graphics/Path$Direction;", "", "(Ljava/lang/String;I)V", "CounterClockwise", "Clockwise", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public enum Direction {
        CounterClockwise,
        Clockwise
    }

    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ a f3273a = new a();

        private a() {
        }
    }

    boolean a();

    void b();

    void c(float f5, float f6);

    void close();

    void d(float f5, float f6, float f7, float f8, float f9, float f10);

    void e(int i5);

    void f(float f5, float f6, float f7, float f8);

    void g(float f5, float f6, float f7, float f8);

    y.i getBounds();

    int h();

    void i(y.k kVar, Direction direction);

    boolean isEmpty();

    void j(float f5, float f6);

    void k(float f5, float f6, float f7, float f8, float f9, float f10);

    boolean l(Path path, Path path2, int i5);

    void m(float f5, float f6);

    void n(y.i iVar, Direction direction);

    void o(float f5, float f6);

    void reset();
}
