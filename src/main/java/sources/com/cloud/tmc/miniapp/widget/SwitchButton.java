package com.cloud.tmc.miniapp.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import com.cloud.tmc.miniapp.R;
import com.cloud.tmc.miniutils.constant.MemoryConstants;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class SwitchButton extends View {
    public final float OooO;
    public final AccelerateInterpolator OooO00o;
    public final Paint OooO0O0;
    public final Path OooO0OO;
    public final Path OooO0Oo;
    public float OooO0o;
    public final RectF OooO0o0;
    public float OooO0oO;
    public RadialGradient OooO0oo;
    public final float OooOO0;
    public int OooOO0O;
    public int OooOO0o;
    public boolean OooOOO;
    public boolean OooOOO0;
    public boolean OooOOOO;
    public int OooOOOo;
    public int OooOOo;
    public int OooOOo0;
    public int OooOOoo;
    public float OooOo;
    public OooO00o OooOo0;
    public int OooOo00;
    public float OooOo0O;
    public float OooOo0o;
    public float OooOoO;
    public float OooOoO0;
    public float OooOoOO;
    public float OooOoo;
    public float OooOoo0;
    public float OooOooO;
    public float OooOooo;
    public float Oooo0;
    public float Oooo000;
    public float Oooo00O;
    public float Oooo00o;
    public float Oooo0O0;

    public interface OooO00o {
        void OooO00o(SwitchButton switchButton, boolean z);
    }

    public static final class SavedState extends View.BaseSavedState {

        @JvmField
        public static final Parcelable.Creator<SavedState> CREATOR = new OooO00o();
        public boolean OooO00o;

        public static final class OooO00o implements Parcelable.Creator<SavedState> {
            @Override // android.os.Parcelable.Creator
            public SavedState createFromParcel(Parcel parcel) {
                Intrinsics.h(parcel, "in");
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        }

        public SavedState(Parcel parcel) {
            super(parcel);
            this.OooO00o = 1 == parcel.readInt();
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // android.view.AbsSavedState, android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            Intrinsics.h(parcel, "out");
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.OooO00o ? 1 : 0);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public SwitchButton(Context context) {
        this(context, null, 0, 0, 14, null);
        Intrinsics.h(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public SwitchButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
        Intrinsics.h(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public SwitchButton(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0, 8, null);
        Intrinsics.h(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public SwitchButton(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.h(context, "context");
        this.OooO00o = new AccelerateInterpolator(2.0f);
        this.OooO0O0 = new Paint();
        this.OooO0OO = new Path();
        this.OooO0Oo = new Path();
        this.OooO0o0 = new RectF();
        this.OooO = 0.68f;
        this.OooOO0 = 0.1f;
        this.OooOOOo = Color.parseColor("#0081FF");
        this.OooOOo0 = Color.parseColor("#0081FF");
        Color.parseColor("#C2C6CE");
        this.OooOOo = Color.parseColor("#BFBFBF");
        this.OooOo00 = Color.parseColor("#333333");
        setLayerType(1, null);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SwitchButton);
        Intrinsics.g(obtainStyledAttributes, "context.obtainStyledAttr…R.styleable.SwitchButton)");
        this.OooOOOO = obtainStyledAttributes.getBoolean(R.styleable.SwitchButton_android_checked, this.OooOOOO);
        setEnabled(obtainStyledAttributes.getBoolean(R.styleable.SwitchButton_android_enabled, isEnabled()));
        int i3 = this.OooOOOO ? 3 : 1;
        this.OooOO0o = i3;
        this.OooOO0O = i3;
        this.OooOOoo = androidx.core.content.b.getColor(context, R.color.mini_color_switch_off_bg);
        this.OooOOOo = androidx.core.content.b.getColor(context, R.color.mini_color_primary);
        this.OooOOo0 = androidx.core.content.b.getColor(context, R.color.mini_color_primary);
        obtainStyledAttributes.recycle();
    }

    public /* synthetic */ SwitchButton(Context context, AttributeSet attributeSet, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i, (i3 & 8) != 0 ? 0 : i2);
    }

    public static void OooO00o(SwitchButton switchButton, boolean z, boolean z2, boolean z3, int i) {
        OooO00o oooO00o;
        if ((i & 4) != 0) {
            z3 = true;
        }
        int i2 = z ? 3 : 1;
        int i3 = switchButton.OooOO0o;
        if (i2 == i3) {
            return;
        }
        if ((i2 == 3 && (i3 == 1 || i3 == 2)) || (i2 == 1 && (i3 == 3 || i3 == 4))) {
            switchButton.OooO0o = z3 ? 1.0f : 0.0f;
        }
        switchButton.OooO0oO = z3 ? 1.0f : 0.0f;
        boolean z4 = switchButton.OooOOOO;
        if (!z4 && i2 == 3) {
            switchButton.OooOOOO = true;
        } else if (z4 && i2 == 1) {
            switchButton.OooOOOO = false;
        }
        switchButton.OooOO0O = i3;
        switchButton.OooOO0o = i2;
        switchButton.postInvalidate();
        if (!z2 || (oooO00o = switchButton.OooOo0) == null) {
            return;
        }
        oooO00o.OooO00o(switchButton, z);
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x01b3  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x01b6  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onDraw(Canvas canvas) {
        float f;
        float f2;
        float f3;
        int i;
        float f4;
        float f5;
        Intrinsics.h(canvas, "canvas");
        if (this.OooOOO0) {
            this.OooO0O0.setAntiAlias(true);
            int i2 = this.OooOO0o;
            boolean z = i2 == 3 || i2 == 4;
            Paint paint = this.OooO0O0;
            Paint.Style style = Paint.Style.FILL;
            paint.setStyle(style);
            this.OooO0O0.setColor(z ? this.OooOOOo : this.OooOOoo);
            canvas.drawPath(this.OooO0OO, this.OooO0O0);
            float f6 = this.OooO0o;
            float f7 = this.OooOO0;
            float f10 = f6 - f7;
            if (f10 <= 0.0f) {
                f10 = 0.0f;
            }
            this.OooO0o = f10;
            float f11 = this.OooO0oO - f7;
            if (f11 <= 0.0f) {
                f11 = 0.0f;
            }
            this.OooO0oO = f11;
            float interpolation = this.OooO00o.getInterpolation(f10);
            float interpolation2 = this.OooO00o.getInterpolation(this.OooO0oO);
            float f12 = this.OooOoO0 * (z ? interpolation : 1 - interpolation);
            float f13 = (this.OooOo0O - this.OooOo0o) - this.OooOoOO;
            if (z) {
                interpolation = 1 - interpolation;
            }
            canvas.save();
            canvas.scale(f12, f12, this.OooOo0o + (f13 * interpolation), this.OooOo);
            if (isEnabled()) {
                this.OooO0O0.setColor(this.OooOOoo);
            } else {
                this.OooO0O0.setColor(Color.parseColor("#BBBBBB"));
            }
            canvas.drawPath(this.OooO0OO, this.OooO0O0);
            canvas.restore();
            canvas.save();
            int i3 = this.OooOO0o;
            int i4 = i3 - this.OooOO0O;
            if (i4 != -3) {
                if (i4 != -2) {
                    if (i4 != -1) {
                        if (i4 != 1) {
                            if (i4 == 2) {
                                if (i3 == 3) {
                                    f4 = this.Oooo000;
                                    f5 = this.Oooo0;
                                } else {
                                    if (i3 == 4) {
                                        f4 = this.Oooo00O;
                                        f5 = this.Oooo0;
                                    }
                                    f3 = 0.0f;
                                }
                                f3 = f4 - ((f4 - f5) * interpolation2);
                            } else if (i4 == 3) {
                                f4 = this.Oooo000;
                                f5 = this.Oooo0;
                                f3 = f4 - ((f4 - f5) * interpolation2);
                            } else if (i3 == 1) {
                                f3 = this.Oooo0;
                            } else {
                                if (i3 == 3) {
                                    f3 = this.Oooo000;
                                }
                                f3 = 0.0f;
                            }
                        } else if (i3 == 2) {
                            f3 = this.Oooo0;
                        } else {
                            if (i3 == 3) {
                                f4 = this.Oooo000;
                                f5 = this.Oooo00O;
                                f3 = f4 - ((f4 - f5) * interpolation2);
                            }
                            f3 = 0.0f;
                        }
                    } else if (i3 == 4) {
                        f = this.Oooo00O;
                        f2 = this.Oooo000;
                    } else {
                        if (i3 == 1) {
                            f3 = this.Oooo0;
                        }
                        f3 = 0.0f;
                    }
                } else if (i3 == 1) {
                    f = this.Oooo0;
                    f2 = this.Oooo00O;
                } else {
                    if (i3 == 2) {
                        f = this.Oooo00o;
                        f2 = this.Oooo000;
                    }
                    f3 = 0.0f;
                }
                canvas.translate(f3 - this.Oooo0, this.Oooo0O0);
                i = this.OooOO0o;
                if (i != 4 || i == 2) {
                    interpolation2 = 1 - interpolation2;
                }
                this.OooO0Oo.reset();
                RectF rectF = this.OooO0o0;
                float f14 = this.OooOooO;
                float f15 = 2;
                float f16 = this.OooOoo0 / f15;
                rectF.left = f14 + f16;
                rectF.right = this.OooOooo - f16;
                this.OooO0Oo.arcTo(rectF, 90.0f, 180.0f);
                RectF rectF2 = this.OooO0o0;
                float f17 = this.OooOooO;
                float f18 = interpolation2 * this.OooOoO;
                float f19 = this.OooOoo0 / f15;
                rectF2.left = f17 + f18 + f19;
                rectF2.right = (f18 + this.OooOooo) - f19;
                this.OooO0Oo.arcTo(rectF2, 270.0f, 180.0f);
                this.OooO0Oo.close();
                if (this.OooOOO) {
                    this.OooO0O0.setStyle(style);
                    this.OooO0O0.setShader(this.OooO0oo);
                    canvas.drawPath(this.OooO0Oo, this.OooO0O0);
                    this.OooO0O0.setShader(null);
                }
                canvas.translate(0.0f, -this.Oooo0O0);
                float f20 = this.OooOoo / f15;
                canvas.scale(0.98f, 0.98f, f20, f20);
                this.OooO0O0.setStyle(style);
                this.OooO0O0.setColor(Color.parseColor("#FFFFFF"));
                canvas.drawPath(this.OooO0Oo, this.OooO0O0);
                this.OooO0O0.setStyle(Paint.Style.STROKE);
                this.OooO0O0.setStrokeWidth(this.OooOoo0 * 0.5f);
                this.OooO0O0.setColor(!z ? this.OooOOo0 : this.OooOOo);
                canvas.drawPath(this.OooO0Oo, this.OooO0O0);
                canvas.restore();
                this.OooO0O0.reset();
                if (this.OooO0o <= 0.0f || this.OooO0oO > 0.0f) {
                    invalidate();
                }
                return;
            }
            f = this.Oooo0;
            f2 = this.Oooo000;
            f3 = f + ((f2 - f) * interpolation2);
            canvas.translate(f3 - this.Oooo0, this.Oooo0O0);
            i = this.OooOO0o;
            if (i != 4) {
            }
            interpolation2 = 1 - interpolation2;
            this.OooO0Oo.reset();
            RectF rectF3 = this.OooO0o0;
            float f142 = this.OooOooO;
            float f152 = 2;
            float f162 = this.OooOoo0 / f152;
            rectF3.left = f142 + f162;
            rectF3.right = this.OooOooo - f162;
            this.OooO0Oo.arcTo(rectF3, 90.0f, 180.0f);
            RectF rectF22 = this.OooO0o0;
            float f172 = this.OooOooO;
            float f182 = interpolation2 * this.OooOoO;
            float f192 = this.OooOoo0 / f152;
            rectF22.left = f172 + f182 + f192;
            rectF22.right = (f182 + this.OooOooo) - f192;
            this.OooO0Oo.arcTo(rectF22, 270.0f, 180.0f);
            this.OooO0Oo.close();
            if (this.OooOOO) {
            }
            canvas.translate(0.0f, -this.Oooo0O0);
            float f202 = this.OooOoo / f152;
            canvas.scale(0.98f, 0.98f, f202, f202);
            this.OooO0O0.setStyle(style);
            this.OooO0O0.setColor(Color.parseColor("#FFFFFF"));
            canvas.drawPath(this.OooO0Oo, this.OooO0O0);
            this.OooO0O0.setStyle(Paint.Style.STROKE);
            this.OooO0O0.setStrokeWidth(this.OooOoo0 * 0.5f);
            this.OooO0O0.setColor(!z ? this.OooOOo0 : this.OooOOo);
            canvas.drawPath(this.OooO0Oo, this.OooO0O0);
            canvas.restore();
            this.OooO0O0.reset();
            if (this.OooO0o <= 0.0f) {
            }
            invalidate();
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        if (mode == Integer.MIN_VALUE || mode == 0) {
            i = View.MeasureSpec.makeMeasureSpec((int) (getResources().getDimension(R.dimen.mini_dp_56) + getPaddingLeft() + getPaddingRight()), MemoryConstants.GB);
        }
        int mode2 = View.MeasureSpec.getMode(i2);
        if (mode2 == Integer.MIN_VALUE || mode2 == 0) {
            i2 = View.MeasureSpec.makeMeasureSpec(getPaddingBottom() + getPaddingTop() + ((int) (View.MeasureSpec.getSize(i) * this.OooO)), MemoryConstants.GB);
        }
        setMeasuredDimension(i, i2);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        Intrinsics.f(parcelable, "null cannot be cast to non-null type com.cloud.tmc.miniapp.widget.SwitchButton.SavedState");
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        boolean z = savedState.OooO00o;
        this.OooOOOO = z;
        this.OooOO0o = z ? 3 : 1;
        invalidate();
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.OooO00o = this.OooOOOO;
        return savedState;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001e  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        boolean z;
        int paddingLeft;
        int width;
        int paddingTop;
        int height;
        if (i > getPaddingRight() + getPaddingLeft()) {
            if (i2 > getPaddingBottom() + getPaddingTop()) {
                z = true;
                this.OooOOO0 = z;
                if (z) {
                    return;
                }
                int paddingLeft2 = (i - getPaddingLeft()) - getPaddingRight();
                int paddingTop2 = (i2 - getPaddingTop()) - getPaddingBottom();
                float f = paddingLeft2;
                float f2 = this.OooO;
                float f3 = paddingTop2;
                if (f * f2 < f3) {
                    paddingLeft = getPaddingLeft();
                    width = i - getPaddingRight();
                    int i5 = ((int) (f3 - (f * this.OooO))) / 2;
                    paddingTop = getPaddingTop() + i5;
                    height = (getHeight() - getPaddingBottom()) - i5;
                } else {
                    int i6 = ((int) (f - (f3 / f2))) / 2;
                    paddingLeft = getPaddingLeft() + i6;
                    width = (getWidth() - getPaddingRight()) - i6;
                    paddingTop = getPaddingTop();
                    height = getHeight() - getPaddingBottom();
                }
                float f4 = (int) ((height - paddingTop) * 0.07f);
                this.Oooo0O0 = f4;
                float f5 = paddingLeft;
                float f6 = paddingTop + f4;
                float f7 = width;
                this.OooOo0O = f7;
                float f10 = height - f4;
                float f11 = f10 - f6;
                float f12 = 2;
                this.OooOo0o = (f7 + f5) / f12;
                float f13 = (f10 + f6) / f12;
                this.OooOo = f13;
                this.OooOooO = f5;
                this.OooOoo = f11;
                float f14 = f5 + f11;
                this.OooOooo = f14;
                float f15 = f11 / f12;
                float f16 = 0.95f * f15;
                this.OooOoOO = f16;
                float f17 = 0.2f * f16;
                this.OooOoO = f17;
                float f18 = (f15 - f16) * f12;
                this.OooOoo0 = f18;
                float f19 = f7 - f11;
                this.Oooo000 = f19;
                this.Oooo00O = f19 - f17;
                this.Oooo0 = f5;
                this.Oooo00o = f17 + f5;
                this.OooOoO0 = 1 - (f18 / f11);
                this.OooO0OO.reset();
                RectF rectF = new RectF();
                rectF.top = f6;
                rectF.bottom = f10;
                rectF.left = f5;
                rectF.right = f14;
                this.OooO0OO.arcTo(rectF, 90.0f, 180.0f);
                float f20 = this.OooOo0O;
                rectF.left = f20 - f11;
                rectF.right = f20;
                this.OooO0OO.arcTo(rectF, 270.0f, 180.0f);
                this.OooO0OO.close();
                RectF rectF2 = this.OooO0o0;
                float f21 = this.OooOooO;
                rectF2.left = f21;
                float f22 = this.OooOooo;
                rectF2.right = f22;
                float f23 = this.OooOoo0 / f12;
                rectF2.top = f6 + f23;
                rectF2.bottom = f10 - f23;
                float f24 = (f22 + f21) / f12;
                int i7 = this.OooOo00;
                int i10 = (i7 >> 16) & 255;
                int i11 = (i7 >> 8) & 255;
                int i12 = i7 & 255;
                this.OooO0oo = new RadialGradient(f24, f13, this.OooOoOO, Color.argb(200, i10, i11, i12), Color.argb(25, i10, i11, i12), Shader.TileMode.CLAMP);
                return;
            }
        }
        z = false;
        this.OooOOO0 = z;
        if (z) {
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int i;
        Intrinsics.h(motionEvent, "event");
        super.onTouchEvent(motionEvent);
        if (isEnabled() && (((i = this.OooOO0o) == 3 || i == 1) && this.OooO0o * this.OooO0oO == 0.0f && motionEvent.getAction() == 1)) {
            int i2 = this.OooOO0o;
            this.OooOO0O = i2;
            this.OooO0oO = 1.0f;
            if (i2 == 1) {
                OooO00o(this, true, false, false, 4);
                OooO00o oooO00o = this.OooOo0;
                if (oooO00o != null) {
                    oooO00o.OooO00o(this, true);
                }
            } else if (i2 == 3) {
                OooO00o(this, false, false, false, 4);
                OooO00o oooO00o2 = this.OooOo0;
                if (oooO00o2 != null) {
                    oooO00o2.OooO00o(this, false);
                }
            }
        }
        return true;
    }

    public final void setChecked(boolean z) {
        OooO00o(this, z, true, false, 4);
    }

    public final void setOnCheckedChangeListener(OooO00o oooO00o) {
        this.OooOo0 = oooO00o;
    }

    public final void setShadow(boolean z) {
        this.OooOOO = z;
        invalidate();
    }
}
