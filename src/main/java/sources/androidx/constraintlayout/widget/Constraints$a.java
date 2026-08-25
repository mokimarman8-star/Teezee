package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public class Constraints$a extends ConstraintLayout$b {
    public float A0;
    public float B0;
    public float C0;
    public float D0;
    public float E0;
    public float F0;
    public float G0;
    public float H0;
    public float I0;
    public float J0;

    /* renamed from: x0, reason: collision with root package name */
    public float f6593x0;

    /* renamed from: y0, reason: collision with root package name */
    public boolean f6594y0;

    /* renamed from: z0, reason: collision with root package name */
    public float f6595z0;

    public Constraints$a(int i5, int i6) {
        super(i5, i6);
        this.f6593x0 = 1.0f;
        this.f6594y0 = false;
        this.f6595z0 = 0.0f;
        this.A0 = 0.0f;
        this.B0 = 0.0f;
        this.C0 = 0.0f;
        this.D0 = 1.0f;
        this.E0 = 1.0f;
        this.F0 = 0.0f;
        this.G0 = 0.0f;
        this.H0 = 0.0f;
        this.I0 = 0.0f;
        this.J0 = 0.0f;
    }

    public Constraints$a(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f6593x0 = 1.0f;
        this.f6594y0 = false;
        this.f6595z0 = 0.0f;
        this.A0 = 0.0f;
        this.B0 = 0.0f;
        this.C0 = 0.0f;
        this.D0 = 1.0f;
        this.E0 = 1.0f;
        this.F0 = 0.0f;
        this.G0 = 0.0f;
        this.H0 = 0.0f;
        this.I0 = 0.0f;
        this.J0 = 0.0f;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ConstraintSet);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i5 = 0; i5 < indexCount; i5++) {
            int index = obtainStyledAttributes.getIndex(i5);
            if (index == R.styleable.ConstraintSet_android_alpha) {
                this.f6593x0 = obtainStyledAttributes.getFloat(index, this.f6593x0);
            } else if (index == R.styleable.ConstraintSet_android_elevation) {
                this.f6595z0 = obtainStyledAttributes.getFloat(index, this.f6595z0);
                this.f6594y0 = true;
            } else if (index == R.styleable.ConstraintSet_android_rotationX) {
                this.B0 = obtainStyledAttributes.getFloat(index, this.B0);
            } else if (index == R.styleable.ConstraintSet_android_rotationY) {
                this.C0 = obtainStyledAttributes.getFloat(index, this.C0);
            } else if (index == R.styleable.ConstraintSet_android_rotation) {
                this.A0 = obtainStyledAttributes.getFloat(index, this.A0);
            } else if (index == R.styleable.ConstraintSet_android_scaleX) {
                this.D0 = obtainStyledAttributes.getFloat(index, this.D0);
            } else if (index == R.styleable.ConstraintSet_android_scaleY) {
                this.E0 = obtainStyledAttributes.getFloat(index, this.E0);
            } else if (index == R.styleable.ConstraintSet_android_transformPivotX) {
                this.F0 = obtainStyledAttributes.getFloat(index, this.F0);
            } else if (index == R.styleable.ConstraintSet_android_transformPivotY) {
                this.G0 = obtainStyledAttributes.getFloat(index, this.G0);
            } else if (index == R.styleable.ConstraintSet_android_translationX) {
                this.H0 = obtainStyledAttributes.getFloat(index, this.H0);
            } else if (index == R.styleable.ConstraintSet_android_translationY) {
                this.I0 = obtainStyledAttributes.getFloat(index, this.I0);
            } else if (index == R.styleable.ConstraintSet_android_translationZ) {
                this.J0 = obtainStyledAttributes.getFloat(index, this.J0);
            }
        }
        obtainStyledAttributes.recycle();
    }
}
