package androidx.drawerlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.ViewGroup;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public class DrawerLayout$f extends ViewGroup.MarginLayoutParams {

    /* renamed from: a, reason: collision with root package name */
    public int f7803a;

    /* renamed from: b, reason: collision with root package name */
    float f7804b;

    /* renamed from: c, reason: collision with root package name */
    boolean f7805c;

    /* renamed from: d, reason: collision with root package name */
    int f7806d;

    public DrawerLayout$f(int i5, int i6) {
        super(i5, i6);
        this.f7803a = 0;
    }

    public DrawerLayout$f(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f7803a = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, DrawerLayout.M);
        this.f7803a = obtainStyledAttributes.getInt(0, 0);
        obtainStyledAttributes.recycle();
    }

    public DrawerLayout$f(ViewGroup.LayoutParams layoutParams) {
        super(layoutParams);
        this.f7803a = 0;
    }

    public DrawerLayout$f(ViewGroup.MarginLayoutParams marginLayoutParams) {
        super(marginLayoutParams);
        this.f7803a = 0;
    }

    public DrawerLayout$f(DrawerLayout$f drawerLayout$f) {
        super((ViewGroup.MarginLayoutParams) drawerLayout$f);
        this.f7803a = 0;
        this.f7803a = drawerLayout$f.f7803a;
    }
}
