package androidx.appcompat.app;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.R;
import androidx.appcompat.view.b;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class a {

    /* renamed from: androidx.appcompat.app.a$a, reason: collision with other inner class name */
    public static class C0002a extends ViewGroup.MarginLayoutParams {

        /* renamed from: a, reason: collision with root package name */
        public int f256a;

        public C0002a(int i5, int i6) {
            super(i5, i6);
            this.f256a = 8388627;
        }

        public C0002a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f256a = 0;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ActionBarLayout);
            this.f256a = obtainStyledAttributes.getInt(R.styleable.ActionBarLayout_android_layout_gravity, 0);
            obtainStyledAttributes.recycle();
        }

        public C0002a(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f256a = 0;
        }

        public C0002a(C0002a c0002a) {
            super((ViewGroup.MarginLayoutParams) c0002a);
            this.f256a = 0;
            this.f256a = c0002a.f256a;
        }
    }

    public static abstract class b {
        public abstract CharSequence a();

        public abstract View b();

        public abstract Drawable c();

        public abstract CharSequence d();

        public abstract void e();
    }

    public boolean g() {
        return false;
    }

    public boolean h() {
        return false;
    }

    public void i(boolean z5) {
    }

    public abstract int j();

    public Context k() {
        return null;
    }

    public abstract void l();

    public boolean m() {
        return false;
    }

    public void n(Configuration configuration) {
    }

    void o() {
    }

    public boolean p(int i5, KeyEvent keyEvent) {
        return false;
    }

    public boolean q(KeyEvent keyEvent) {
        return false;
    }

    public boolean r() {
        return false;
    }

    public void s(boolean z5) {
    }

    public void t(boolean z5) {
    }

    public void u(CharSequence charSequence) {
    }

    public androidx.appcompat.view.b v(b.a aVar) {
        return null;
    }
}
