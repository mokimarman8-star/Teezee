package androidx.recyclerview.widget;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public abstract class m {
    protected final RecyclerView.m a;
    private int b;
    final Rect c;

    private m(RecyclerView.m mVar) {
        this.b = Integer.MIN_VALUE;
        this.c = new Rect();
        this.a = mVar;
    }

    public static m a(RecyclerView.m mVar) {
        return new a(mVar);
    }

    public static m b(RecyclerView.m mVar, int i) {
        if (i == 0) {
            return a(mVar);
        }
        if (i == 1) {
            return c(mVar);
        }
        throw new IllegalArgumentException("invalid orientation");
    }

    public static m c(RecyclerView.m mVar) {
        return new b(mVar);
    }

    public abstract int d(View view);

    public abstract int e(View view);

    public abstract int f(View view);

    public abstract int g(View view);

    public abstract int h();

    public abstract int i();

    public abstract int j();

    public abstract int k();

    public abstract int l();

    public abstract int m();

    public abstract int n();

    public int o() {
        if (Integer.MIN_VALUE == this.b) {
            return 0;
        }
        return n() - this.b;
    }

    public abstract int p(View view);

    public abstract int q(View view);

    public abstract void r(int i);

    public void s() {
        this.b = n();
    }
}
