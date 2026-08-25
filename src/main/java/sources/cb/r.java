package cb;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Build;
import android.view.View;
import ra.a;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public abstract class r {
    n c;
    boolean a = false;
    boolean b = false;
    RectF d = new RectF();
    final Path e = new Path();

    public static r a(View view) {
        return Build.VERSION.SDK_INT >= 33 ? new t(view) : new s(view);
    }

    private boolean d() {
        RectF rectF = this.d;
        return rectF.left <= rectF.right && rectF.top <= rectF.bottom;
    }

    private void k() {
        if (!d() || this.c == null) {
            return;
        }
        o.k().d(this.c, 1.0f, this.d, this.e);
    }

    abstract void b(View view);

    public boolean c() {
        return this.a;
    }

    public void e(Canvas canvas, a.InterfaceC0198a interfaceC0198a) {
        if (!j() || this.e.isEmpty()) {
            interfaceC0198a.a(canvas);
            return;
        }
        canvas.save();
        canvas.clipPath(this.e);
        interfaceC0198a.a(canvas);
        canvas.restore();
    }

    public void f(View view, RectF rectF) {
        this.d = rectF;
        k();
        b(view);
    }

    public void g(View view, n nVar) {
        this.c = nVar;
        k();
        b(view);
    }

    public void h(View view, boolean z) {
        if (z != this.a) {
            this.a = z;
            b(view);
        }
    }

    public void i(View view, boolean z) {
        this.b = z;
        b(view);
    }

    abstract boolean j();
}
