package androidx.appcompat.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import androidx.appcompat.app.a;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public class Toolbar$f extends a.C0002a {

    /* renamed from: b, reason: collision with root package name */
    int f956b;

    public Toolbar$f(int i5, int i6) {
        super(i5, i6);
        this.f956b = 0;
        this.f256a = 8388627;
    }

    public Toolbar$f(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f956b = 0;
    }

    public Toolbar$f(ViewGroup.LayoutParams layoutParams) {
        super(layoutParams);
        this.f956b = 0;
    }

    public Toolbar$f(ViewGroup.MarginLayoutParams marginLayoutParams) {
        super(marginLayoutParams);
        this.f956b = 0;
        a(marginLayoutParams);
    }

    public Toolbar$f(a.C0002a c0002a) {
        super(c0002a);
        this.f956b = 0;
    }

    public Toolbar$f(Toolbar$f toolbar$f) {
        super((a.C0002a) toolbar$f);
        this.f956b = 0;
        this.f956b = toolbar$f.f956b;
    }

    void a(ViewGroup.MarginLayoutParams marginLayoutParams) {
        ((ViewGroup.MarginLayoutParams) this).leftMargin = marginLayoutParams.leftMargin;
        ((ViewGroup.MarginLayoutParams) this).topMargin = marginLayoutParams.topMargin;
        ((ViewGroup.MarginLayoutParams) this).rightMargin = marginLayoutParams.rightMargin;
        ((ViewGroup.MarginLayoutParams) this).bottomMargin = marginLayoutParams.bottomMargin;
    }
}
