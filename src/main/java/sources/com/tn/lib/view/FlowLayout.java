package com.tn.lib.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import com.cloud.tmc.offline.download.model.TaskResultKt;
import com.tn.lib.widget.R;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public class FlowLayout extends ViewGroup {
    public static final int SPACING_ALIGN = -65537;
    public static final int SPACING_AUTO = -65536;
    private boolean a;
    private int b;
    private int c;
    private int d;
    private float e;
    private float f;
    private boolean g;
    private int h;
    private int i;
    private int j;
    private int k;
    private List l;
    private List m;
    private List n;
    private List o;

    public FlowLayout(Context context) {
        this(context, null);
    }

    public FlowLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = true;
        this.b = 0;
        this.c = 0;
        this.d = -65538;
        this.e = 0.0f;
        this.f = 0.0f;
        this.g = false;
        this.h = Integer.MAX_VALUE;
        this.i = -1;
        this.j = SPACING_AUTO;
        this.l = new ArrayList();
        this.m = new ArrayList();
        this.n = new ArrayList();
        this.o = new ArrayList();
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.FlowLayout, 0, 0);
        try {
            this.a = obtainStyledAttributes.getBoolean(R.styleable.FlowLayout_flFlow, true);
            this.b = b(obtainStyledAttributes, R.styleable.FlowLayout_flChildSpacing, (int) a(0.0f));
            this.c = b(obtainStyledAttributes, R.styleable.FlowLayout_flMinChildSpacing, (int) a(0.0f));
            this.d = b(obtainStyledAttributes, R.styleable.FlowLayout_flChildSpacingForLastRow, -65538);
            this.e = b(obtainStyledAttributes, R.styleable.FlowLayout_flRowSpacing, (int) a(0.0f));
            this.h = obtainStyledAttributes.getInt(R.styleable.FlowLayout_flMaxRows, Integer.MAX_VALUE);
            this.g = obtainStyledAttributes.getBoolean(R.styleable.FlowLayout_flRtl, false);
            this.i = obtainStyledAttributes.getInt(R.styleable.FlowLayout_android_gravity, -1);
            this.j = obtainStyledAttributes.getInt(R.styleable.FlowLayout_flRowVerticalGravity, SPACING_AUTO);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    private float a(float f) {
        return TypedValue.applyDimension(1, f, getResources().getDisplayMetrics());
    }

    private int b(TypedArray typedArray, int i, int i2) {
        TypedValue typedValue = new TypedValue();
        typedArray.getValue(i, typedValue);
        return typedValue.type == 5 ? typedArray.getDimensionPixelSize(i, i2) : typedArray.getInt(i, i2);
    }

    private int c(int i, int i2, int i3, int i4) {
        if (this.b == -65536 || i4 >= this.n.size() || i4 >= this.o.size() || ((Integer) this.o.get(i4)).intValue() <= 0) {
            return 0;
        }
        if (i == 1) {
            return ((i2 - i3) - ((Integer) this.n.get(i4)).intValue()) / 2;
        }
        if (i != 5) {
            return 0;
        }
        return (i2 - i3) - ((Integer) this.n.get(i4)).intValue();
    }

    private float d(int i, int i2, int i3, int i4) {
        if (i != -65536) {
            return i;
        }
        if (i4 > 1) {
            return (i2 - i3) / (i4 - 1);
        }
        return 0.0f;
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new ViewGroup.MarginLayoutParams(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new ViewGroup.MarginLayoutParams(layoutParams);
    }

    public int getChildSpacing() {
        return this.b;
    }

    public int getChildSpacingForLastRow() {
        return this.d;
    }

    public int getCountInRow(int i) {
        return ((Integer) this.o.get(i)).intValue();
    }

    public int getMaxRows() {
        return this.h;
    }

    public int getMinChildSpacing() {
        return this.c;
    }

    public float getRowSpacing() {
        return this.e;
    }

    public int getRowsCount() {
        return this.o.size();
    }

    public boolean isFlow() {
        return this.a;
    }

    public boolean isRtl() {
        return this.g;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0174  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int size;
        int i6;
        int i7;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        float f;
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int width = this.g ? getWidth() - paddingRight : paddingLeft;
        int i20 = this.i;
        int i21 = i20 & TaskResultKt.ERROR_LOAD_REQUEST_FAIL;
        int i22 = i20 & 7;
        if (i21 != 16) {
            if (i21 == 80) {
                i5 = (((i4 - i2) - paddingTop) - paddingBottom) - this.k;
            }
            int i23 = paddingLeft + paddingRight;
            int i24 = i3 - i;
            int c = width + c(i22, i24, i23, 0);
            int i25 = this.j & TaskResultKt.ERROR_LOAD_REQUEST_FAIL;
            size = this.o.size();
            i6 = 0;
            i7 = 0;
            while (i6 < Math.min(size, this.h)) {
                int intValue = ((Integer) this.o.get(i6)).intValue();
                int intValue2 = ((Integer) this.m.get(i6)).intValue();
                float floatValue = ((Float) this.l.get(i6)).floatValue();
                int i26 = 0;
                while (true) {
                    i10 = paddingLeft;
                    if (i26 >= intValue || i7 >= getChildCount()) {
                        break;
                    }
                    int i27 = i7 + 1;
                    View childAt = getChildAt(i7);
                    int i28 = size;
                    if (childAt.getVisibility() == 8) {
                        i7 = i27;
                        size = i28;
                        paddingLeft = i10;
                    } else {
                        int i29 = i26 + 1;
                        ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                            int i30 = marginLayoutParams.leftMargin;
                            i11 = i29;
                            int i31 = marginLayoutParams.rightMargin;
                            i15 = marginLayoutParams.topMargin;
                            i14 = marginLayoutParams.bottomMargin;
                            i12 = i23;
                            int i32 = intValue;
                            i17 = i30;
                            i16 = i31;
                            i13 = i32;
                        } else {
                            i11 = i29;
                            i12 = i23;
                            i13 = intValue;
                            i14 = 0;
                            i15 = 0;
                            i16 = 0;
                            i17 = 0;
                        }
                        int measuredWidth = childAt.getMeasuredWidth();
                        int measuredHeight = childAt.getMeasuredHeight();
                        int i33 = paddingTop + i15;
                        int i34 = i22;
                        if (i25 == 80) {
                            i18 = ((paddingTop + intValue2) - i14) - measuredHeight;
                        } else {
                            if (i25 == 16) {
                                i33 += (((intValue2 - i15) - i14) - measuredHeight) / 2;
                            }
                            i18 = i33;
                        }
                        int i35 = i18 + measuredHeight;
                        if (this.g) {
                            int i36 = c - i16;
                            i19 = i25;
                            childAt.layout(i36 - measuredWidth, i18, i36, i35);
                            f = c - (((measuredWidth + floatValue) + i17) + i16);
                        } else {
                            i19 = i25;
                            int i37 = c + i17;
                            childAt.layout(i37, i18, i37 + measuredWidth, i35);
                            f = c + measuredWidth + floatValue + i17 + i16;
                        }
                        c = (int) f;
                        i7 = i27;
                        size = i28;
                        i26 = i11;
                        paddingLeft = i10;
                        intValue = i13;
                        i23 = i12;
                        i25 = i19;
                        i22 = i34;
                    }
                }
                int i38 = i23;
                int i39 = i22;
                int i40 = i25;
                int i41 = size;
                i6++;
                int width2 = (this.g ? getWidth() - paddingRight : i10) + c(i39, i24, i38, i6);
                paddingTop = (int) (paddingTop + intValue2 + this.f);
                size = i41;
                i22 = i39;
                i23 = i38;
                i25 = i40;
                c = width2;
                paddingLeft = i10;
            }
            while (i7 < getChildCount()) {
                View childAt2 = getChildAt(i7);
                if (childAt2.getVisibility() != 8) {
                    childAt2.layout(0, 0, 0, 0);
                }
                i7++;
            }
        }
        i5 = ((((i4 - i2) - paddingTop) - paddingBottom) - this.k) / 2;
        paddingTop += i5;
        int i232 = paddingLeft + paddingRight;
        int i242 = i3 - i;
        int c2 = width + c(i22, i242, i232, 0);
        int i252 = this.j & TaskResultKt.ERROR_LOAD_REQUEST_FAIL;
        size = this.o.size();
        i6 = 0;
        i7 = 0;
        while (i6 < Math.min(size, this.h)) {
        }
        while (i7 < getChildCount()) {
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int i3;
        int min;
        int i4;
        int i5;
        int i6;
        int i7;
        int i10;
        int i11;
        float f;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        View view;
        int i17;
        int i18;
        int measuredWidth;
        int i19;
        int i20;
        super.onMeasure(i, i2);
        int size = View.MeasureSpec.getSize(i);
        int mode = View.MeasureSpec.getMode(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int mode2 = View.MeasureSpec.getMode(i2);
        this.l.clear();
        this.m.clear();
        this.n.clear();
        this.o.clear();
        int childCount = getChildCount();
        int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
        boolean z = mode != 0 && this.a;
        int i21 = this.b;
        int i22 = SPACING_AUTO;
        int i23 = (i21 == -65536 && mode == 0) ? 0 : i21;
        float f2 = i23 == -65536 ? this.c : i23;
        int i24 = 0;
        int i25 = 0;
        int i26 = 0;
        int i27 = 0;
        int i28 = 0;
        int i29 = 0;
        int i30 = 0;
        while (i26 < childCount) {
            float f3 = f2;
            View childAt = getChildAt(i26);
            int i31 = i24;
            if (childAt.getVisibility() == 8) {
                i5 = i26;
                i19 = i23;
                i7 = mode;
                i10 = mode2;
                i11 = childCount;
                f = f3;
                i20 = i31;
                i13 = SPACING_AUTO;
                measuredWidth = i25;
                i14 = size;
                i15 = size2;
            } else {
                ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    i11 = childCount;
                    i12 = i31;
                    i15 = size2;
                    i16 = i25;
                    i5 = i26;
                    i10 = mode2;
                    f = f3;
                    i14 = size;
                    view = childAt;
                    i6 = i23;
                    i7 = mode;
                    i13 = SPACING_AUTO;
                    measureChildWithMargins(childAt, i, 0, i2, i29);
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    i17 = marginLayoutParams.leftMargin + marginLayoutParams.rightMargin;
                    i18 = marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
                } else {
                    i5 = i26;
                    i6 = i23;
                    i7 = mode;
                    i10 = mode2;
                    i11 = childCount;
                    f = f3;
                    i12 = i31;
                    i13 = SPACING_AUTO;
                    i14 = size;
                    i15 = size2;
                    i16 = i25;
                    view = childAt;
                    measureChild(view, i, i2);
                    i17 = 0;
                    i18 = 0;
                }
                measuredWidth = i17 + view.getMeasuredWidth();
                int measuredHeight = view.getMeasuredHeight() + i18;
                if (!z || i28 + measuredWidth <= paddingLeft) {
                    i19 = i6;
                    i20 = i12 + 1;
                    i28 = (int) (i28 + measuredWidth + f);
                    measuredWidth += i16;
                    i30 = Math.max(i30, measuredHeight);
                } else {
                    i19 = i6;
                    this.l.add(Float.valueOf(d(i19, paddingLeft, i16, i12)));
                    this.o.add(Integer.valueOf(i12));
                    this.m.add(Integer.valueOf(i30));
                    int i32 = (int) f;
                    this.n.add(Integer.valueOf(i28 - i32));
                    if (this.l.size() <= this.h) {
                        i29 += i30;
                    }
                    i27 = Math.max(i27, i28);
                    i28 = measuredWidth + i32;
                    i30 = measuredHeight;
                    i20 = 1;
                }
            }
            i25 = measuredWidth;
            i24 = i20;
            i26 = i5 + 1;
            i23 = i19;
            i22 = i13;
            f2 = f;
            size = i14;
            size2 = i15;
            mode = i7;
            childCount = i11;
            mode2 = i10;
        }
        int i33 = i24;
        int i34 = size;
        int i35 = mode;
        int i36 = size2;
        int i37 = mode2;
        int i38 = i30;
        int i39 = i25;
        float f4 = f2;
        int i40 = i22;
        int i41 = i23;
        int i42 = this.d;
        if (i42 == -65537) {
            if (this.l.size() >= 1) {
                List list = this.l;
                list.add((Float) list.get(list.size() - 1));
            } else {
                this.l.add(Float.valueOf(d(i41, paddingLeft, i39, i33)));
            }
        } else if (i42 != -65538) {
            this.l.add(Float.valueOf(d(i42, paddingLeft, i39, i33)));
        } else {
            this.l.add(Float.valueOf(d(i41, paddingLeft, i39, i33)));
        }
        this.o.add(Integer.valueOf(i33));
        this.m.add(Integer.valueOf(i38));
        this.n.add(Integer.valueOf(i28 - ((int) f4)));
        if (this.l.size() <= this.h) {
            i29 += i38;
        }
        int max = Math.max(i27, i28);
        if (i41 == i40) {
            min = i34;
            i3 = min;
        } else if (i35 == 0) {
            min = max + getPaddingLeft() + getPaddingRight();
            i3 = i34;
        } else {
            i3 = i34;
            min = Math.min(max + getPaddingLeft() + getPaddingRight(), i3);
        }
        int paddingTop = i29 + getPaddingTop() + getPaddingBottom();
        int min2 = Math.min(this.l.size(), this.h);
        float f5 = this.e;
        if (f5 == -65536.0f && i37 == 0) {
            f5 = 0.0f;
        }
        if (f5 == -65536.0f) {
            if (min2 > 1) {
                this.f = (i36 - paddingTop) / (min2 - 1);
            } else {
                this.f = 0.0f;
            }
            paddingTop = i36;
            i4 = paddingTop;
        } else {
            this.f = f5;
            if (min2 > 1) {
                if (i37 == 0) {
                    paddingTop = (int) (paddingTop + (f5 * (min2 - 1)));
                } else {
                    int i43 = (int) (paddingTop + (f5 * (min2 - 1)));
                    i4 = i36;
                    paddingTop = Math.min(i43, i4);
                }
            }
            i4 = i36;
        }
        this.k = paddingTop;
        setMeasuredDimension(i35 == 1073741824 ? i3 : min, i37 == 1073741824 ? i4 : paddingTop);
    }

    public void setChildSpacing(int i) {
        this.b = i;
        requestLayout();
    }

    public void setChildSpacingForLastRow(int i) {
        this.d = i;
        requestLayout();
    }

    public void setFlow(boolean z) {
        this.a = z;
        requestLayout();
    }

    public void setGravity(int i) {
        if (this.i != i) {
            this.i = i;
            requestLayout();
        }
    }

    public void setMaxRows(int i) {
        this.h = i;
        requestLayout();
    }

    public void setMinChildSpacing(int i) {
        this.c = i;
        requestLayout();
    }

    public void setRowSpacing(float f) {
        this.e = f;
        requestLayout();
    }

    public void setRowVerticalGravity(int i) {
        if (this.j != i) {
            this.j = i;
            requestLayout();
        }
    }

    public void setRtl(boolean z) {
        this.g = z;
        requestLayout();
    }
}
