package androidx.appcompat.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.PopupWindow;
import androidx.appcompat.R;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
class k extends PopupWindow {

    /* renamed from: b, reason: collision with root package name */
    private static final boolean f1054b = false;

    /* renamed from: a, reason: collision with root package name */
    private boolean f1055a;

    public k(Context context, AttributeSet attributeSet, int i5, int i6) {
        super(context, attributeSet, i5, i6);
        a(context, attributeSet, i5, i6);
    }

    private void a(Context context, AttributeSet attributeSet, int i5, int i6) {
        j0 v5 = j0.v(context, attributeSet, R.styleable.PopupWindow, i5, i6);
        if (v5.s(R.styleable.PopupWindow_overlapAnchor)) {
            b(v5.a(R.styleable.PopupWindow_overlapAnchor, false));
        }
        setBackgroundDrawable(v5.g(R.styleable.PopupWindow_android_popupBackground));
        v5.x();
    }

    private void b(boolean z5) {
        if (f1054b) {
            this.f1055a = z5;
        } else {
            androidx.core.widget.k.a(this, z5);
        }
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(View view, int i5, int i6) {
        if (f1054b && this.f1055a) {
            i6 -= view.getHeight();
        }
        super.showAsDropDown(view, i5, i6);
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(View view, int i5, int i6, int i7) {
        if (f1054b && this.f1055a) {
            i6 -= view.getHeight();
        }
        super.showAsDropDown(view, i5, i6, i7);
    }

    @Override // android.widget.PopupWindow
    public void update(View view, int i5, int i6, int i7, int i8) {
        if (f1054b && this.f1055a) {
            i6 -= view.getHeight();
        }
        super.update(view, i5, i6, i7, i8);
    }
}
