package androidx.constraintlayout.helper.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.widget.ConstraintHelper;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintLayout$b;
import androidx.constraintlayout.widget.R;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public class Layer extends ConstraintHelper {
    private boolean A;

    /* renamed from: j, reason: collision with root package name */
    private float f5998j;

    /* renamed from: k, reason: collision with root package name */
    private float f5999k;

    /* renamed from: l, reason: collision with root package name */
    private float f6000l;

    /* renamed from: m, reason: collision with root package name */
    ConstraintLayout f6001m;

    /* renamed from: n, reason: collision with root package name */
    private float f6002n;

    /* renamed from: o, reason: collision with root package name */
    private float f6003o;

    /* renamed from: p, reason: collision with root package name */
    protected float f6004p;

    /* renamed from: q, reason: collision with root package name */
    protected float f6005q;

    /* renamed from: r, reason: collision with root package name */
    protected float f6006r;

    /* renamed from: s, reason: collision with root package name */
    protected float f6007s;

    /* renamed from: t, reason: collision with root package name */
    protected float f6008t;

    /* renamed from: u, reason: collision with root package name */
    protected float f6009u;

    /* renamed from: v, reason: collision with root package name */
    boolean f6010v;

    /* renamed from: w, reason: collision with root package name */
    View[] f6011w;

    /* renamed from: x, reason: collision with root package name */
    private float f6012x;

    /* renamed from: y, reason: collision with root package name */
    private float f6013y;

    /* renamed from: z, reason: collision with root package name */
    private boolean f6014z;

    public Layer(Context context) {
        super(context);
        this.f5998j = Float.NaN;
        this.f5999k = Float.NaN;
        this.f6000l = Float.NaN;
        this.f6002n = 1.0f;
        this.f6003o = 1.0f;
        this.f6004p = Float.NaN;
        this.f6005q = Float.NaN;
        this.f6006r = Float.NaN;
        this.f6007s = Float.NaN;
        this.f6008t = Float.NaN;
        this.f6009u = Float.NaN;
        this.f6010v = true;
        this.f6011w = null;
        this.f6012x = 0.0f;
        this.f6013y = 0.0f;
    }

    public Layer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5998j = Float.NaN;
        this.f5999k = Float.NaN;
        this.f6000l = Float.NaN;
        this.f6002n = 1.0f;
        this.f6003o = 1.0f;
        this.f6004p = Float.NaN;
        this.f6005q = Float.NaN;
        this.f6006r = Float.NaN;
        this.f6007s = Float.NaN;
        this.f6008t = Float.NaN;
        this.f6009u = Float.NaN;
        this.f6010v = true;
        this.f6011w = null;
        this.f6012x = 0.0f;
        this.f6013y = 0.0f;
    }

    public Layer(Context context, AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
        this.f5998j = Float.NaN;
        this.f5999k = Float.NaN;
        this.f6000l = Float.NaN;
        this.f6002n = 1.0f;
        this.f6003o = 1.0f;
        this.f6004p = Float.NaN;
        this.f6005q = Float.NaN;
        this.f6006r = Float.NaN;
        this.f6007s = Float.NaN;
        this.f6008t = Float.NaN;
        this.f6009u = Float.NaN;
        this.f6010v = true;
        this.f6011w = null;
        this.f6012x = 0.0f;
        this.f6013y = 0.0f;
    }

    private void m() {
        int i5;
        if (this.f6001m == null || (i5 = ((ConstraintHelper) this).b) == 0) {
            return;
        }
        View[] viewArr = this.f6011w;
        if (viewArr == null || viewArr.length != i5) {
            this.f6011w = new View[i5];
        }
        for (int i6 = 0; i6 < ((ConstraintHelper) this).b; i6++) {
            this.f6011w[i6] = this.f6001m.getViewById(((ConstraintHelper) this).a[i6]);
        }
    }

    private void n() {
        if (this.f6001m == null) {
            return;
        }
        if (this.f6011w == null) {
            m();
        }
        l();
        double radians = Float.isNaN(this.f6000l) ? 0.0d : Math.toRadians(this.f6000l);
        float sin = (float) Math.sin(radians);
        float cos = (float) Math.cos(radians);
        float f5 = this.f6002n;
        float f6 = f5 * cos;
        float f7 = this.f6003o;
        float f8 = (-f7) * sin;
        float f9 = f5 * sin;
        float f10 = f7 * cos;
        for (int i5 = 0; i5 < ((ConstraintHelper) this).b; i5++) {
            View view = this.f6011w[i5];
            int left = (view.getLeft() + view.getRight()) / 2;
            int top = (view.getTop() + view.getBottom()) / 2;
            float f11 = left - this.f6004p;
            float f12 = top - this.f6005q;
            float f13 = (((f6 * f11) + (f8 * f12)) - f11) + this.f6012x;
            float f14 = (((f11 * f9) + (f10 * f12)) - f12) + this.f6013y;
            view.setTranslationX(f13);
            view.setTranslationY(f14);
            view.setScaleY(this.f6003o);
            view.setScaleX(this.f6002n);
            if (!Float.isNaN(this.f6000l)) {
                view.setRotation(this.f6000l);
            }
        }
    }

    protected void f(ConstraintLayout constraintLayout) {
        e(constraintLayout);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void k(AttributeSet attributeSet) {
        super.k(attributeSet);
        ((ConstraintHelper) this).e = false;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.ConstraintLayout_Layout);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i5 = 0; i5 < indexCount; i5++) {
                int index = obtainStyledAttributes.getIndex(i5);
                if (index == R.styleable.ConstraintLayout_Layout_android_visibility) {
                    this.f6014z = true;
                } else if (index == R.styleable.ConstraintLayout_Layout_android_elevation) {
                    this.A = true;
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    protected void l() {
        if (this.f6001m == null) {
            return;
        }
        if (this.f6010v || Float.isNaN(this.f6004p) || Float.isNaN(this.f6005q)) {
            if (!Float.isNaN(this.f5998j) && !Float.isNaN(this.f5999k)) {
                this.f6005q = this.f5999k;
                this.f6004p = this.f5998j;
                return;
            }
            View[] j5 = j(this.f6001m);
            int left = j5[0].getLeft();
            int top = j5[0].getTop();
            int right = j5[0].getRight();
            int bottom = j5[0].getBottom();
            for (int i5 = 0; i5 < ((ConstraintHelper) this).b; i5++) {
                View view = j5[i5];
                left = Math.min(left, view.getLeft());
                top = Math.min(top, view.getTop());
                right = Math.max(right, view.getRight());
                bottom = Math.max(bottom, view.getBottom());
            }
            this.f6006r = right;
            this.f6007s = bottom;
            this.f6008t = left;
            this.f6009u = top;
            if (Float.isNaN(this.f5998j)) {
                this.f6004p = (left + right) / 2;
            } else {
                this.f6004p = this.f5998j;
            }
            if (Float.isNaN(this.f5999k)) {
                this.f6005q = (top + bottom) / 2;
            } else {
                this.f6005q = this.f5999k;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f6001m = getParent();
        if (this.f6014z || this.A) {
            int visibility = getVisibility();
            float elevation = getElevation();
            for (int i5 = 0; i5 < ((ConstraintHelper) this).b; i5++) {
                View viewById = this.f6001m.getViewById(((ConstraintHelper) this).a[i5]);
                if (viewById != null) {
                    if (this.f6014z) {
                        viewById.setVisibility(visibility);
                    }
                    if (this.A && elevation > 0.0f) {
                        viewById.setTranslationZ(viewById.getTranslationZ() + elevation);
                    }
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setElevation(float f5) {
        super/*android.view.View*/.setElevation(f5);
        d();
    }

    public void setPivotX(float f5) {
        this.f5998j = f5;
        n();
    }

    public void setPivotY(float f5) {
        this.f5999k = f5;
        n();
    }

    public void setRotation(float f5) {
        this.f6000l = f5;
        n();
    }

    public void setScaleX(float f5) {
        this.f6002n = f5;
        n();
    }

    public void setScaleY(float f5) {
        this.f6003o = f5;
        n();
    }

    public void setTranslationX(float f5) {
        this.f6012x = f5;
        n();
    }

    public void setTranslationY(float f5) {
        this.f6013y = f5;
        n();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setVisibility(int i5) {
        super/*android.view.View*/.setVisibility(i5);
        d();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void updatePostLayout(ConstraintLayout constraintLayout) {
        m();
        this.f6004p = Float.NaN;
        this.f6005q = Float.NaN;
        ConstraintWidget b5 = ((ConstraintLayout$b) getLayoutParams()).b();
        b5.o1(0);
        b5.P0(0);
        l();
        layout(((int) this.f6008t) - getPaddingLeft(), ((int) this.f6009u) - getPaddingTop(), ((int) this.f6006r) + getPaddingRight(), ((int) this.f6007s) + getPaddingBottom());
        n();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void updatePreDraw(ConstraintLayout constraintLayout) {
        this.f6001m = constraintLayout;
        float rotation = getRotation();
        if (rotation != 0.0f) {
            this.f6000l = rotation;
        } else {
            if (Float.isNaN(this.f6000l)) {
                return;
            }
            this.f6000l = rotation;
        }
    }
}
