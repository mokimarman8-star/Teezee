package androidx.viewpager.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.ViewGroup;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public class ViewPager$e extends ViewGroup.LayoutParams {

    /* renamed from: a, reason: collision with root package name */
    public boolean f13744a;

    /* renamed from: b, reason: collision with root package name */
    public int f13745b;

    /* renamed from: c, reason: collision with root package name */
    float f13746c;

    /* renamed from: d, reason: collision with root package name */
    boolean f13747d;

    /* renamed from: e, reason: collision with root package name */
    int f13748e;

    /* renamed from: f, reason: collision with root package name */
    int f13749f;

    public ViewPager$e() {
        super(-1, -1);
        this.f13746c = 0.0f;
    }

    public ViewPager$e(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f13746c = 0.0f;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ViewPager.LAYOUT_ATTRS);
        this.f13745b = obtainStyledAttributes.getInteger(0, 48);
        obtainStyledAttributes.recycle();
    }
}
