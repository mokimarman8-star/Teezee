package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.ViewGroup;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.f;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.inputmethod.EditorInfoCompat;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public class ConstraintLayout$b extends ViewGroup.MarginLayoutParams {
    public int A;
    public int B;
    public int C;
    public int D;
    boolean E;
    boolean F;
    public float G;
    public float H;
    public String I;
    float J;
    int K;
    public float L;
    public float M;
    public int N;
    public int O;
    public int P;
    public int Q;
    public int R;
    public int S;
    public int T;
    public int U;
    public float V;
    public float W;
    public int X;
    public int Y;
    public int Z;

    /* renamed from: a, reason: collision with root package name */
    public int f6535a;

    /* renamed from: a0, reason: collision with root package name */
    public boolean f6536a0;

    /* renamed from: b, reason: collision with root package name */
    public int f6537b;

    /* renamed from: b0, reason: collision with root package name */
    public boolean f6538b0;

    /* renamed from: c, reason: collision with root package name */
    public float f6539c;

    /* renamed from: c0, reason: collision with root package name */
    public String f6540c0;

    /* renamed from: d, reason: collision with root package name */
    public boolean f6541d;

    /* renamed from: d0, reason: collision with root package name */
    public int f6542d0;

    /* renamed from: e, reason: collision with root package name */
    public int f6543e;

    /* renamed from: e0, reason: collision with root package name */
    boolean f6544e0;

    /* renamed from: f, reason: collision with root package name */
    public int f6545f;

    /* renamed from: f0, reason: collision with root package name */
    boolean f6546f0;

    /* renamed from: g, reason: collision with root package name */
    public int f6547g;

    /* renamed from: g0, reason: collision with root package name */
    boolean f6548g0;

    /* renamed from: h, reason: collision with root package name */
    public int f6549h;

    /* renamed from: h0, reason: collision with root package name */
    boolean f6550h0;

    /* renamed from: i, reason: collision with root package name */
    public int f6551i;

    /* renamed from: i0, reason: collision with root package name */
    boolean f6552i0;

    /* renamed from: j, reason: collision with root package name */
    public int f6553j;

    /* renamed from: j0, reason: collision with root package name */
    boolean f6554j0;

    /* renamed from: k, reason: collision with root package name */
    public int f6555k;

    /* renamed from: k0, reason: collision with root package name */
    boolean f6556k0;

    /* renamed from: l, reason: collision with root package name */
    public int f6557l;

    /* renamed from: l0, reason: collision with root package name */
    int f6558l0;

    /* renamed from: m, reason: collision with root package name */
    public int f6559m;

    /* renamed from: m0, reason: collision with root package name */
    int f6560m0;

    /* renamed from: n, reason: collision with root package name */
    public int f6561n;

    /* renamed from: n0, reason: collision with root package name */
    int f6562n0;

    /* renamed from: o, reason: collision with root package name */
    public int f6563o;

    /* renamed from: o0, reason: collision with root package name */
    int f6564o0;

    /* renamed from: p, reason: collision with root package name */
    public int f6565p;

    /* renamed from: p0, reason: collision with root package name */
    int f6566p0;

    /* renamed from: q, reason: collision with root package name */
    public int f6567q;

    /* renamed from: q0, reason: collision with root package name */
    int f6568q0;

    /* renamed from: r, reason: collision with root package name */
    public float f6569r;

    /* renamed from: r0, reason: collision with root package name */
    float f6570r0;

    /* renamed from: s, reason: collision with root package name */
    public int f6571s;

    /* renamed from: s0, reason: collision with root package name */
    int f6572s0;

    /* renamed from: t, reason: collision with root package name */
    public int f6573t;

    /* renamed from: t0, reason: collision with root package name */
    int f6574t0;

    /* renamed from: u, reason: collision with root package name */
    public int f6575u;

    /* renamed from: u0, reason: collision with root package name */
    float f6576u0;

    /* renamed from: v, reason: collision with root package name */
    public int f6577v;

    /* renamed from: v0, reason: collision with root package name */
    ConstraintWidget f6578v0;

    /* renamed from: w, reason: collision with root package name */
    public int f6579w;

    /* renamed from: w0, reason: collision with root package name */
    public boolean f6580w0;

    /* renamed from: x, reason: collision with root package name */
    public int f6581x;

    /* renamed from: y, reason: collision with root package name */
    public int f6582y;

    /* renamed from: z, reason: collision with root package name */
    public int f6583z;

    private static class a {

        /* renamed from: a, reason: collision with root package name */
        public static final SparseIntArray f6584a;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            f6584a = sparseIntArray;
            sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintWidth, 64);
            sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintHeight, 65);
            sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintLeft_toLeftOf, 8);
            sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintLeft_toRightOf, 9);
            sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintRight_toLeftOf, 10);
            sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintRight_toRightOf, 11);
            sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintTop_toTopOf, 12);
            sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintTop_toBottomOf, 13);
            sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintBottom_toTopOf, 14);
            sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintBottom_toBottomOf, 15);
            sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintBaseline_toBaselineOf, 16);
            sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintBaseline_toTopOf, 52);
            sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintBaseline_toBottomOf, 53);
            sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintCircle, 2);
            sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintCircleRadius, 3);
            sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintCircleAngle, 4);
            sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_editor_absoluteX, 49);
            sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_editor_absoluteY, 50);
            sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintGuide_begin, 5);
            sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintGuide_end, 6);
            sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintGuide_percent, 7);
            sparseIntArray.append(R.styleable.ConstraintLayout_Layout_guidelineUseRtl, 67);
            sparseIntArray.append(R.styleable.ConstraintLayout_Layout_android_orientation, 1);
            sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintStart_toEndOf, 17);
            sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintStart_toStartOf, 18);
            sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintEnd_toStartOf, 19);
            sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintEnd_toEndOf, 20);
            sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginLeft, 21);
            sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginTop, 22);
            sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginRight, 23);
            sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginBottom, 24);
            sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginStart, 25);
            sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginEnd, 26);
            sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginBaseline, 55);
            sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_marginBaseline, 54);
            sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintHorizontal_bias, 29);
            sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintVertical_bias, 30);
            sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintDimensionRatio, 44);
            sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintHorizontal_weight, 45);
            sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintVertical_weight, 46);
            sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintHorizontal_chainStyle, 47);
            sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintVertical_chainStyle, 48);
            sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constrainedWidth, 27);
            sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constrainedHeight, 28);
            sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintWidth_default, 31);
            sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintHeight_default, 32);
            sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintWidth_min, 33);
            sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintWidth_max, 34);
            sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintWidth_percent, 35);
            sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintHeight_min, 36);
            sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintHeight_max, 37);
            sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintHeight_percent, 38);
            sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintLeft_creator, 39);
            sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintTop_creator, 40);
            sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintRight_creator, 41);
            sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintBottom_creator, 42);
            sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintBaseline_creator, 43);
            sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintTag, 51);
            sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_wrapBehaviorInParent, 66);
        }
    }

    public ConstraintLayout$b(int i5, int i6) {
        super(i5, i6);
        this.f6535a = -1;
        this.f6537b = -1;
        this.f6539c = -1.0f;
        this.f6541d = true;
        this.f6543e = -1;
        this.f6545f = -1;
        this.f6547g = -1;
        this.f6549h = -1;
        this.f6551i = -1;
        this.f6553j = -1;
        this.f6555k = -1;
        this.f6557l = -1;
        this.f6559m = -1;
        this.f6561n = -1;
        this.f6563o = -1;
        this.f6565p = -1;
        this.f6567q = 0;
        this.f6569r = 0.0f;
        this.f6571s = -1;
        this.f6573t = -1;
        this.f6575u = -1;
        this.f6577v = -1;
        this.f6579w = EditorInfoCompat.IME_FLAG_FORCE_ASCII;
        this.f6581x = EditorInfoCompat.IME_FLAG_FORCE_ASCII;
        this.f6582y = EditorInfoCompat.IME_FLAG_FORCE_ASCII;
        this.f6583z = EditorInfoCompat.IME_FLAG_FORCE_ASCII;
        this.A = EditorInfoCompat.IME_FLAG_FORCE_ASCII;
        this.B = EditorInfoCompat.IME_FLAG_FORCE_ASCII;
        this.C = EditorInfoCompat.IME_FLAG_FORCE_ASCII;
        this.D = 0;
        this.E = true;
        this.F = true;
        this.G = 0.5f;
        this.H = 0.5f;
        this.I = null;
        this.J = 0.0f;
        this.K = 1;
        this.L = -1.0f;
        this.M = -1.0f;
        this.N = 0;
        this.O = 0;
        this.P = 0;
        this.Q = 0;
        this.R = 0;
        this.S = 0;
        this.T = 0;
        this.U = 0;
        this.V = 1.0f;
        this.W = 1.0f;
        this.X = -1;
        this.Y = -1;
        this.Z = -1;
        this.f6536a0 = false;
        this.f6538b0 = false;
        this.f6540c0 = null;
        this.f6542d0 = 0;
        this.f6544e0 = true;
        this.f6546f0 = true;
        this.f6548g0 = false;
        this.f6550h0 = false;
        this.f6552i0 = false;
        this.f6554j0 = false;
        this.f6556k0 = false;
        this.f6558l0 = -1;
        this.f6560m0 = -1;
        this.f6562n0 = -1;
        this.f6564o0 = -1;
        this.f6566p0 = EditorInfoCompat.IME_FLAG_FORCE_ASCII;
        this.f6568q0 = EditorInfoCompat.IME_FLAG_FORCE_ASCII;
        this.f6570r0 = 0.5f;
        this.f6578v0 = new ConstraintWidget();
        this.f6580w0 = false;
    }

    public ConstraintLayout$b(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f6535a = -1;
        this.f6537b = -1;
        this.f6539c = -1.0f;
        this.f6541d = true;
        this.f6543e = -1;
        this.f6545f = -1;
        this.f6547g = -1;
        this.f6549h = -1;
        this.f6551i = -1;
        this.f6553j = -1;
        this.f6555k = -1;
        this.f6557l = -1;
        this.f6559m = -1;
        this.f6561n = -1;
        this.f6563o = -1;
        this.f6565p = -1;
        this.f6567q = 0;
        this.f6569r = 0.0f;
        this.f6571s = -1;
        this.f6573t = -1;
        this.f6575u = -1;
        this.f6577v = -1;
        this.f6579w = EditorInfoCompat.IME_FLAG_FORCE_ASCII;
        this.f6581x = EditorInfoCompat.IME_FLAG_FORCE_ASCII;
        this.f6582y = EditorInfoCompat.IME_FLAG_FORCE_ASCII;
        this.f6583z = EditorInfoCompat.IME_FLAG_FORCE_ASCII;
        this.A = EditorInfoCompat.IME_FLAG_FORCE_ASCII;
        this.B = EditorInfoCompat.IME_FLAG_FORCE_ASCII;
        this.C = EditorInfoCompat.IME_FLAG_FORCE_ASCII;
        this.D = 0;
        this.E = true;
        this.F = true;
        this.G = 0.5f;
        this.H = 0.5f;
        this.I = null;
        this.J = 0.0f;
        this.K = 1;
        this.L = -1.0f;
        this.M = -1.0f;
        this.N = 0;
        this.O = 0;
        this.P = 0;
        this.Q = 0;
        this.R = 0;
        this.S = 0;
        this.T = 0;
        this.U = 0;
        this.V = 1.0f;
        this.W = 1.0f;
        this.X = -1;
        this.Y = -1;
        this.Z = -1;
        this.f6536a0 = false;
        this.f6538b0 = false;
        this.f6540c0 = null;
        this.f6542d0 = 0;
        this.f6544e0 = true;
        this.f6546f0 = true;
        this.f6548g0 = false;
        this.f6550h0 = false;
        this.f6552i0 = false;
        this.f6554j0 = false;
        this.f6556k0 = false;
        this.f6558l0 = -1;
        this.f6560m0 = -1;
        this.f6562n0 = -1;
        this.f6564o0 = -1;
        this.f6566p0 = EditorInfoCompat.IME_FLAG_FORCE_ASCII;
        this.f6568q0 = EditorInfoCompat.IME_FLAG_FORCE_ASCII;
        this.f6570r0 = 0.5f;
        this.f6578v0 = new ConstraintWidget();
        this.f6580w0 = false;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ConstraintLayout_Layout);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i5 = 0; i5 < indexCount; i5++) {
            int index = obtainStyledAttributes.getIndex(i5);
            int i6 = a.f6584a.get(index);
            switch (i6) {
                case 1:
                    this.Z = obtainStyledAttributes.getInt(index, this.Z);
                    break;
                case 2:
                    int resourceId = obtainStyledAttributes.getResourceId(index, this.f6565p);
                    this.f6565p = resourceId;
                    if (resourceId == -1) {
                        this.f6565p = obtainStyledAttributes.getInt(index, -1);
                        break;
                    } else {
                        break;
                    }
                case 3:
                    this.f6567q = obtainStyledAttributes.getDimensionPixelSize(index, this.f6567q);
                    break;
                case 4:
                    float f5 = obtainStyledAttributes.getFloat(index, this.f6569r) % 360.0f;
                    this.f6569r = f5;
                    if (f5 < 0.0f) {
                        this.f6569r = (360.0f - f5) % 360.0f;
                        break;
                    } else {
                        break;
                    }
                case 5:
                    this.f6535a = obtainStyledAttributes.getDimensionPixelOffset(index, this.f6535a);
                    break;
                case 6:
                    this.f6537b = obtainStyledAttributes.getDimensionPixelOffset(index, this.f6537b);
                    break;
                case 7:
                    this.f6539c = obtainStyledAttributes.getFloat(index, this.f6539c);
                    break;
                case 8:
                    int resourceId2 = obtainStyledAttributes.getResourceId(index, this.f6543e);
                    this.f6543e = resourceId2;
                    if (resourceId2 == -1) {
                        this.f6543e = obtainStyledAttributes.getInt(index, -1);
                        break;
                    } else {
                        break;
                    }
                case 9:
                    int resourceId3 = obtainStyledAttributes.getResourceId(index, this.f6545f);
                    this.f6545f = resourceId3;
                    if (resourceId3 == -1) {
                        this.f6545f = obtainStyledAttributes.getInt(index, -1);
                        break;
                    } else {
                        break;
                    }
                case 10:
                    int resourceId4 = obtainStyledAttributes.getResourceId(index, this.f6547g);
                    this.f6547g = resourceId4;
                    if (resourceId4 == -1) {
                        this.f6547g = obtainStyledAttributes.getInt(index, -1);
                        break;
                    } else {
                        break;
                    }
                case 11:
                    int resourceId5 = obtainStyledAttributes.getResourceId(index, this.f6549h);
                    this.f6549h = resourceId5;
                    if (resourceId5 == -1) {
                        this.f6549h = obtainStyledAttributes.getInt(index, -1);
                        break;
                    } else {
                        break;
                    }
                case 12:
                    int resourceId6 = obtainStyledAttributes.getResourceId(index, this.f6551i);
                    this.f6551i = resourceId6;
                    if (resourceId6 == -1) {
                        this.f6551i = obtainStyledAttributes.getInt(index, -1);
                        break;
                    } else {
                        break;
                    }
                case 13:
                    int resourceId7 = obtainStyledAttributes.getResourceId(index, this.f6553j);
                    this.f6553j = resourceId7;
                    if (resourceId7 == -1) {
                        this.f6553j = obtainStyledAttributes.getInt(index, -1);
                        break;
                    } else {
                        break;
                    }
                case 14:
                    int resourceId8 = obtainStyledAttributes.getResourceId(index, this.f6555k);
                    this.f6555k = resourceId8;
                    if (resourceId8 == -1) {
                        this.f6555k = obtainStyledAttributes.getInt(index, -1);
                        break;
                    } else {
                        break;
                    }
                case 15:
                    int resourceId9 = obtainStyledAttributes.getResourceId(index, this.f6557l);
                    this.f6557l = resourceId9;
                    if (resourceId9 == -1) {
                        this.f6557l = obtainStyledAttributes.getInt(index, -1);
                        break;
                    } else {
                        break;
                    }
                case 16:
                    int resourceId10 = obtainStyledAttributes.getResourceId(index, this.f6559m);
                    this.f6559m = resourceId10;
                    if (resourceId10 == -1) {
                        this.f6559m = obtainStyledAttributes.getInt(index, -1);
                        break;
                    } else {
                        break;
                    }
                case 17:
                    int resourceId11 = obtainStyledAttributes.getResourceId(index, this.f6571s);
                    this.f6571s = resourceId11;
                    if (resourceId11 == -1) {
                        this.f6571s = obtainStyledAttributes.getInt(index, -1);
                        break;
                    } else {
                        break;
                    }
                case 18:
                    int resourceId12 = obtainStyledAttributes.getResourceId(index, this.f6573t);
                    this.f6573t = resourceId12;
                    if (resourceId12 == -1) {
                        this.f6573t = obtainStyledAttributes.getInt(index, -1);
                        break;
                    } else {
                        break;
                    }
                case MotionEventCompat.AXIS_THROTTLE /* 19 */:
                    int resourceId13 = obtainStyledAttributes.getResourceId(index, this.f6575u);
                    this.f6575u = resourceId13;
                    if (resourceId13 == -1) {
                        this.f6575u = obtainStyledAttributes.getInt(index, -1);
                        break;
                    } else {
                        break;
                    }
                case MotionEventCompat.AXIS_RUDDER /* 20 */:
                    int resourceId14 = obtainStyledAttributes.getResourceId(index, this.f6577v);
                    this.f6577v = resourceId14;
                    if (resourceId14 == -1) {
                        this.f6577v = obtainStyledAttributes.getInt(index, -1);
                        break;
                    } else {
                        break;
                    }
                case 21:
                    this.f6579w = obtainStyledAttributes.getDimensionPixelSize(index, this.f6579w);
                    break;
                case 22:
                    this.f6581x = obtainStyledAttributes.getDimensionPixelSize(index, this.f6581x);
                    break;
                case 23:
                    this.f6582y = obtainStyledAttributes.getDimensionPixelSize(index, this.f6582y);
                    break;
                case 24:
                    this.f6583z = obtainStyledAttributes.getDimensionPixelSize(index, this.f6583z);
                    break;
                case 25:
                    this.A = obtainStyledAttributes.getDimensionPixelSize(index, this.A);
                    break;
                case 26:
                    this.B = obtainStyledAttributes.getDimensionPixelSize(index, this.B);
                    break;
                case 27:
                    this.f6536a0 = obtainStyledAttributes.getBoolean(index, this.f6536a0);
                    break;
                case MotionEventCompat.AXIS_RELATIVE_Y /* 28 */:
                    this.f6538b0 = obtainStyledAttributes.getBoolean(index, this.f6538b0);
                    break;
                case 29:
                    this.G = obtainStyledAttributes.getFloat(index, this.G);
                    break;
                case 30:
                    this.H = obtainStyledAttributes.getFloat(index, this.H);
                    break;
                case 31:
                    int i7 = obtainStyledAttributes.getInt(index, 0);
                    this.P = i7;
                    if (i7 == 1) {
                        Log.e("ConstraintLayout", "layout_constraintWidth_default=\"wrap\" is deprecated.\nUse layout_width=\"WRAP_CONTENT\" and layout_constrainedWidth=\"true\" instead.");
                        break;
                    } else {
                        break;
                    }
                case 32:
                    int i8 = obtainStyledAttributes.getInt(index, 0);
                    this.Q = i8;
                    if (i8 == 1) {
                        Log.e("ConstraintLayout", "layout_constraintHeight_default=\"wrap\" is deprecated.\nUse layout_height=\"WRAP_CONTENT\" and layout_constrainedHeight=\"true\" instead.");
                        break;
                    } else {
                        break;
                    }
                case MotionEventCompat.AXIS_GENERIC_2 /* 33 */:
                    try {
                        this.R = obtainStyledAttributes.getDimensionPixelSize(index, this.R);
                        break;
                    } catch (Exception unused) {
                        if (obtainStyledAttributes.getInt(index, this.R) == -2) {
                            this.R = -2;
                            break;
                        } else {
                            break;
                        }
                    }
                case MotionEventCompat.AXIS_GENERIC_3 /* 34 */:
                    try {
                        this.T = obtainStyledAttributes.getDimensionPixelSize(index, this.T);
                        break;
                    } catch (Exception unused2) {
                        if (obtainStyledAttributes.getInt(index, this.T) == -2) {
                            this.T = -2;
                            break;
                        } else {
                            break;
                        }
                    }
                case MotionEventCompat.AXIS_GENERIC_4 /* 35 */:
                    this.V = Math.max(0.0f, obtainStyledAttributes.getFloat(index, this.V));
                    this.P = 2;
                    break;
                case MotionEventCompat.AXIS_GENERIC_5 /* 36 */:
                    try {
                        this.S = obtainStyledAttributes.getDimensionPixelSize(index, this.S);
                        break;
                    } catch (Exception unused3) {
                        if (obtainStyledAttributes.getInt(index, this.S) == -2) {
                            this.S = -2;
                            break;
                        } else {
                            break;
                        }
                    }
                case MotionEventCompat.AXIS_GENERIC_6 /* 37 */:
                    try {
                        this.U = obtainStyledAttributes.getDimensionPixelSize(index, this.U);
                        break;
                    } catch (Exception unused4) {
                        if (obtainStyledAttributes.getInt(index, this.U) == -2) {
                            this.U = -2;
                            break;
                        } else {
                            break;
                        }
                    }
                case MotionEventCompat.AXIS_GENERIC_7 /* 38 */:
                    this.W = Math.max(0.0f, obtainStyledAttributes.getFloat(index, this.W));
                    this.Q = 2;
                    break;
                default:
                    switch (i6) {
                        case MotionEventCompat.AXIS_GENERIC_13 /* 44 */:
                            b.J(this, obtainStyledAttributes.getString(index));
                            break;
                        case MotionEventCompat.AXIS_GENERIC_14 /* 45 */:
                            this.L = obtainStyledAttributes.getFloat(index, this.L);
                            break;
                        case MotionEventCompat.AXIS_GENERIC_15 /* 46 */:
                            this.M = obtainStyledAttributes.getFloat(index, this.M);
                            break;
                        case MotionEventCompat.AXIS_GENERIC_16 /* 47 */:
                            this.N = obtainStyledAttributes.getInt(index, 0);
                            break;
                        case 48:
                            this.O = obtainStyledAttributes.getInt(index, 0);
                            break;
                        case 49:
                            this.X = obtainStyledAttributes.getDimensionPixelOffset(index, this.X);
                            break;
                        case AccessibilityNodeInfoCompat.MAX_NUMBER_OF_PREFETCHED_NODES /* 50 */:
                            this.Y = obtainStyledAttributes.getDimensionPixelOffset(index, this.Y);
                            break;
                        case 51:
                            this.f6540c0 = obtainStyledAttributes.getString(index);
                            break;
                        case 52:
                            int resourceId15 = obtainStyledAttributes.getResourceId(index, this.f6561n);
                            this.f6561n = resourceId15;
                            if (resourceId15 == -1) {
                                this.f6561n = obtainStyledAttributes.getInt(index, -1);
                                break;
                            } else {
                                break;
                            }
                        case 53:
                            int resourceId16 = obtainStyledAttributes.getResourceId(index, this.f6563o);
                            this.f6563o = resourceId16;
                            if (resourceId16 == -1) {
                                this.f6563o = obtainStyledAttributes.getInt(index, -1);
                                break;
                            } else {
                                break;
                            }
                        case 54:
                            this.D = obtainStyledAttributes.getDimensionPixelSize(index, this.D);
                            break;
                        case 55:
                            this.C = obtainStyledAttributes.getDimensionPixelSize(index, this.C);
                            break;
                        default:
                            switch (i6) {
                                case 64:
                                    b.H(this, obtainStyledAttributes, index, 0);
                                    this.E = true;
                                    break;
                                case 65:
                                    b.H(this, obtainStyledAttributes, index, 1);
                                    this.F = true;
                                    break;
                                case 66:
                                    this.f6542d0 = obtainStyledAttributes.getInt(index, this.f6542d0);
                                    break;
                                case 67:
                                    this.f6541d = obtainStyledAttributes.getBoolean(index, this.f6541d);
                                    break;
                            }
                    }
            }
        }
        obtainStyledAttributes.recycle();
        c();
    }

    public ConstraintLayout$b(ViewGroup.LayoutParams layoutParams) {
        super(layoutParams);
        this.f6535a = -1;
        this.f6537b = -1;
        this.f6539c = -1.0f;
        this.f6541d = true;
        this.f6543e = -1;
        this.f6545f = -1;
        this.f6547g = -1;
        this.f6549h = -1;
        this.f6551i = -1;
        this.f6553j = -1;
        this.f6555k = -1;
        this.f6557l = -1;
        this.f6559m = -1;
        this.f6561n = -1;
        this.f6563o = -1;
        this.f6565p = -1;
        this.f6567q = 0;
        this.f6569r = 0.0f;
        this.f6571s = -1;
        this.f6573t = -1;
        this.f6575u = -1;
        this.f6577v = -1;
        this.f6579w = EditorInfoCompat.IME_FLAG_FORCE_ASCII;
        this.f6581x = EditorInfoCompat.IME_FLAG_FORCE_ASCII;
        this.f6582y = EditorInfoCompat.IME_FLAG_FORCE_ASCII;
        this.f6583z = EditorInfoCompat.IME_FLAG_FORCE_ASCII;
        this.A = EditorInfoCompat.IME_FLAG_FORCE_ASCII;
        this.B = EditorInfoCompat.IME_FLAG_FORCE_ASCII;
        this.C = EditorInfoCompat.IME_FLAG_FORCE_ASCII;
        this.D = 0;
        this.E = true;
        this.F = true;
        this.G = 0.5f;
        this.H = 0.5f;
        this.I = null;
        this.J = 0.0f;
        this.K = 1;
        this.L = -1.0f;
        this.M = -1.0f;
        this.N = 0;
        this.O = 0;
        this.P = 0;
        this.Q = 0;
        this.R = 0;
        this.S = 0;
        this.T = 0;
        this.U = 0;
        this.V = 1.0f;
        this.W = 1.0f;
        this.X = -1;
        this.Y = -1;
        this.Z = -1;
        this.f6536a0 = false;
        this.f6538b0 = false;
        this.f6540c0 = null;
        this.f6542d0 = 0;
        this.f6544e0 = true;
        this.f6546f0 = true;
        this.f6548g0 = false;
        this.f6550h0 = false;
        this.f6552i0 = false;
        this.f6554j0 = false;
        this.f6556k0 = false;
        this.f6558l0 = -1;
        this.f6560m0 = -1;
        this.f6562n0 = -1;
        this.f6564o0 = -1;
        this.f6566p0 = EditorInfoCompat.IME_FLAG_FORCE_ASCII;
        this.f6568q0 = EditorInfoCompat.IME_FLAG_FORCE_ASCII;
        this.f6570r0 = 0.5f;
        this.f6578v0 = new ConstraintWidget();
        this.f6580w0 = false;
    }

    public String a() {
        return this.f6540c0;
    }

    public ConstraintWidget b() {
        return this.f6578v0;
    }

    public void c() {
        this.f6550h0 = false;
        this.f6544e0 = true;
        this.f6546f0 = true;
        int i5 = ((ViewGroup.MarginLayoutParams) this).width;
        if (i5 == -2 && this.f6536a0) {
            this.f6544e0 = false;
            if (this.P == 0) {
                this.P = 1;
            }
        }
        int i6 = ((ViewGroup.MarginLayoutParams) this).height;
        if (i6 == -2 && this.f6538b0) {
            this.f6546f0 = false;
            if (this.Q == 0) {
                this.Q = 1;
            }
        }
        if (i5 == 0 || i5 == -1) {
            this.f6544e0 = false;
            if (i5 == 0 && this.P == 1) {
                ((ViewGroup.MarginLayoutParams) this).width = -2;
                this.f6536a0 = true;
            }
        }
        if (i6 == 0 || i6 == -1) {
            this.f6546f0 = false;
            if (i6 == 0 && this.Q == 1) {
                ((ViewGroup.MarginLayoutParams) this).height = -2;
                this.f6538b0 = true;
            }
        }
        if (this.f6539c == -1.0f && this.f6535a == -1 && this.f6537b == -1) {
            return;
        }
        this.f6550h0 = true;
        this.f6544e0 = true;
        this.f6546f0 = true;
        if (!(this.f6578v0 instanceof f)) {
            this.f6578v0 = new f();
        }
        ((f) this.f6578v0).E1(this.Z);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0082  */
    @Override // android.view.ViewGroup.MarginLayoutParams, android.view.ViewGroup.LayoutParams
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void resolveLayoutDirection(int i5) {
        int i6;
        int i7;
        int i8;
        int i9;
        int i10 = ((ViewGroup.MarginLayoutParams) this).leftMargin;
        int i11 = ((ViewGroup.MarginLayoutParams) this).rightMargin;
        super.resolveLayoutDirection(i5);
        boolean z5 = false;
        boolean z6 = 1 == getLayoutDirection();
        this.f6562n0 = -1;
        this.f6564o0 = -1;
        this.f6558l0 = -1;
        this.f6560m0 = -1;
        this.f6566p0 = this.f6579w;
        this.f6568q0 = this.f6582y;
        float f5 = this.G;
        this.f6570r0 = f5;
        int i12 = this.f6535a;
        this.f6572s0 = i12;
        int i13 = this.f6537b;
        this.f6574t0 = i13;
        float f6 = this.f6539c;
        this.f6576u0 = f6;
        if (z6) {
            int i14 = this.f6571s;
            if (i14 != -1) {
                this.f6562n0 = i14;
            } else {
                int i15 = this.f6573t;
                if (i15 != -1) {
                    this.f6564o0 = i15;
                }
                i6 = this.f6575u;
                if (i6 != -1) {
                    this.f6560m0 = i6;
                    z5 = true;
                }
                i7 = this.f6577v;
                if (i7 != -1) {
                    this.f6558l0 = i7;
                    z5 = true;
                }
                i8 = this.A;
                if (i8 != Integer.MIN_VALUE) {
                    this.f6568q0 = i8;
                }
                i9 = this.B;
                if (i9 != Integer.MIN_VALUE) {
                    this.f6566p0 = i9;
                }
                if (z5) {
                    this.f6570r0 = 1.0f - f5;
                }
                if (this.f6550h0 && this.Z == 1 && this.f6541d) {
                    if (f6 == -1.0f) {
                        this.f6576u0 = 1.0f - f6;
                        this.f6572s0 = -1;
                        this.f6574t0 = -1;
                    } else if (i12 != -1) {
                        this.f6574t0 = i12;
                        this.f6572s0 = -1;
                        this.f6576u0 = -1.0f;
                    } else if (i13 != -1) {
                        this.f6572s0 = i13;
                        this.f6574t0 = -1;
                        this.f6576u0 = -1.0f;
                    }
                }
            }
            z5 = true;
            i6 = this.f6575u;
            if (i6 != -1) {
            }
            i7 = this.f6577v;
            if (i7 != -1) {
            }
            i8 = this.A;
            if (i8 != Integer.MIN_VALUE) {
            }
            i9 = this.B;
            if (i9 != Integer.MIN_VALUE) {
            }
            if (z5) {
            }
            if (this.f6550h0) {
                if (f6 == -1.0f) {
                }
            }
        } else {
            int i16 = this.f6571s;
            if (i16 != -1) {
                this.f6560m0 = i16;
            }
            int i17 = this.f6573t;
            if (i17 != -1) {
                this.f6558l0 = i17;
            }
            int i18 = this.f6575u;
            if (i18 != -1) {
                this.f6562n0 = i18;
            }
            int i19 = this.f6577v;
            if (i19 != -1) {
                this.f6564o0 = i19;
            }
            int i20 = this.A;
            if (i20 != Integer.MIN_VALUE) {
                this.f6566p0 = i20;
            }
            int i21 = this.B;
            if (i21 != Integer.MIN_VALUE) {
                this.f6568q0 = i21;
            }
        }
        if (this.f6575u == -1 && this.f6577v == -1 && this.f6573t == -1 && this.f6571s == -1) {
            int i22 = this.f6547g;
            if (i22 != -1) {
                this.f6562n0 = i22;
                if (((ViewGroup.MarginLayoutParams) this).rightMargin <= 0 && i11 > 0) {
                    ((ViewGroup.MarginLayoutParams) this).rightMargin = i11;
                }
            } else {
                int i23 = this.f6549h;
                if (i23 != -1) {
                    this.f6564o0 = i23;
                    if (((ViewGroup.MarginLayoutParams) this).rightMargin <= 0 && i11 > 0) {
                        ((ViewGroup.MarginLayoutParams) this).rightMargin = i11;
                    }
                }
            }
            int i24 = this.f6543e;
            if (i24 != -1) {
                this.f6558l0 = i24;
                if (((ViewGroup.MarginLayoutParams) this).leftMargin > 0 || i10 <= 0) {
                    return;
                }
                ((ViewGroup.MarginLayoutParams) this).leftMargin = i10;
                return;
            }
            int i25 = this.f6545f;
            if (i25 != -1) {
                this.f6560m0 = i25;
                if (((ViewGroup.MarginLayoutParams) this).leftMargin > 0 || i10 <= 0) {
                    return;
                }
                ((ViewGroup.MarginLayoutParams) this).leftMargin = i10;
            }
        }
    }
}
