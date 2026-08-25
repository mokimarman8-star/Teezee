package com.cloud.tmc.miniapp.widget.badgeview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.RelativeLayout;
import com.cloud.tmc.kernel.constants.LauncherLifecycleType;
import com.cloud.tmc.kernel.constants.TmcConstants;
import com.cloud.tmc.miniapp.widget.badgeview.OooO0O0;
import com.cloud.tmc.miniutils.constant.MemoryConstants;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public class OooO0o extends View implements com.cloud.tmc.miniapp.widget.badgeview.OooO00o {
    public float OooO;
    public int OooO00o;
    public int OooO0O0;
    public float OooO0OO;
    public float OooO0Oo;
    public String OooO0o;
    public int OooO0o0;
    public boolean OooO0oO;
    public int OooO0oo;
    public float OooOO0;
    public int OooOO0O;
    public RectF OooOO0o;
    public Path OooOOO;
    public RectF OooOOO0;
    public Paint.FontMetrics OooOOOO;
    public PointF OooOOOo;
    public PointF OooOOo;
    public PointF OooOOo0;
    public PointF OooOOoo;
    public TextPaint OooOo;
    public View OooOo0;
    public List<PointF> OooOo00;
    public int OooOo0O;
    public int OooOo0o;
    public Paint OooOoO;
    public Paint OooOoO0;
    public OooO0O0 OooOoOO;
    public ViewGroup OooOoo0;

    public class OooO00o extends ViewGroup {
        public OooO00o(OooO0o oooO0o, Context context) {
            super(context);
        }

        @Override // android.view.ViewGroup, android.view.View
        public void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
            if (getParent() instanceof RelativeLayout) {
                return;
            }
            super.dispatchRestoreInstanceState(sparseArray);
        }

        @Override // android.view.ViewGroup, android.view.View
        public void onLayout(boolean z, int i, int i2, int i3, int i4) {
            for (int i5 = 0; i5 < getChildCount(); i5++) {
                View childAt = getChildAt(i5);
                childAt.layout(0, 0, childAt.getMeasuredWidth(), childAt.getMeasuredHeight());
            }
        }

        @Override // android.view.View
        public void onMeasure(int i, int i2) {
            View view = null;
            View view2 = null;
            for (int i3 = 0; i3 < getChildCount(); i3++) {
                View childAt = getChildAt(i3);
                if (childAt instanceof OooO0o) {
                    view2 = childAt;
                } else {
                    view = childAt;
                }
            }
            if (view == null) {
                super.onMeasure(i, i2);
                return;
            }
            view.measure(i, i2);
            if (view2 != null) {
                view2.measure(View.MeasureSpec.makeMeasureSpec(view.getMeasuredWidth(), MemoryConstants.GB), View.MeasureSpec.makeMeasureSpec(view.getMeasuredHeight(), MemoryConstants.GB));
            }
            setMeasuredDimension(view.getMeasuredWidth(), view.getMeasuredHeight());
        }
    }

    public OooO0o(Context context, AttributeSet attributeSet) {
        this(context, null, 0);
    }

    public OooO0o(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        OooO00o();
    }

    private float getBadgeCircleRadius() {
        float width;
        float f;
        if (this.OooO0o.isEmpty()) {
            return this.OooO0Oo;
        }
        if (this.OooO0o.length() != 1) {
            return this.OooOOO0.height() / 2.0f;
        }
        if (this.OooOO0o.height() > this.OooOO0o.width()) {
            width = this.OooOO0o.height() / 2.0f;
            f = this.OooO0Oo;
        } else {
            width = this.OooOO0o.width() / 2.0f;
            f = this.OooO0Oo;
        }
        return (f * 0.5f) + width;
    }

    public com.cloud.tmc.miniapp.widget.badgeview.OooO00o OooO00o(int i) {
        this.OooO0o0 = i;
        if (i < 0) {
            this.OooO0o = "";
        } else if (i > 99) {
            this.OooO0o = "99+";
        } else if (i > 0 && i <= 99) {
            this.OooO0o = String.valueOf(i);
        } else if (i == 0) {
            this.OooO0o = null;
        }
        OooO0OO();
        invalidate();
        return this;
    }

    public com.cloud.tmc.miniapp.widget.badgeview.OooO00o OooO00o(View view) {
        if (view == null) {
            throw new IllegalStateException("targetView can not be null");
        }
        if (getParent() != null) {
            ((ViewGroup) getParent()).removeView(this);
        }
        ViewParent parent = view.getParent();
        if (!(parent instanceof ViewGroup)) {
            throw new IllegalStateException("targetView must have a parent");
        }
        this.OooOo0 = view;
        if (parent instanceof OooO00o) {
            ((OooO00o) parent).addView(this);
        } else {
            ViewGroup viewGroup = (ViewGroup) parent;
            int indexOfChild = viewGroup.indexOfChild(view);
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            viewGroup.removeView(view);
            OooO00o oooO00o = new OooO00o(this, getContext());
            if (viewGroup instanceof RelativeLayout) {
                oooO00o.setId(view.getId());
            }
            viewGroup.addView(oooO00o, indexOfChild, layoutParams);
            oooO00o.addView(view);
            oooO00o.addView(this);
        }
        return this;
    }

    public final void OooO00o() {
        setLayerType(1, null);
        this.OooOO0o = new RectF();
        this.OooOOO0 = new RectF();
        this.OooOOO = new Path();
        this.OooOOOo = new PointF();
        this.OooOOo0 = new PointF();
        this.OooOOo = new PointF();
        this.OooOOoo = new PointF();
        this.OooOo00 = new ArrayList();
        TextPaint textPaint = new TextPaint();
        this.OooOo = textPaint;
        textPaint.setAntiAlias(true);
        this.OooOo.setSubpixelText(true);
        this.OooOo.setFakeBoldText(true);
        this.OooOo.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        Paint paint = new Paint();
        this.OooOoO0 = paint;
        paint.setAntiAlias(true);
        this.OooOoO0.setStyle(Paint.Style.FILL);
        Paint paint2 = new Paint();
        this.OooOoO = paint2;
        paint2.setAntiAlias(true);
        this.OooOoO.setStyle(Paint.Style.STROKE);
        this.OooO00o = -1552832;
        this.OooO0O0 = -1;
        this.OooO0OO = OooO0OO.OooO00o(getContext(), 11.0f);
        this.OooO0Oo = OooO0OO.OooO00o(getContext(), 5.0f);
        this.OooO0o0 = 0;
        this.OooO0oo = 8388661;
        this.OooO = OooO0OO.OooO00o(getContext(), 1.0f);
        this.OooOO0 = OooO0OO.OooO00o(getContext(), 1.0f);
        OooO0OO.OooO00o(getContext(), 90.0f);
        this.OooO0oO = true;
        setTranslationZ(1000.0f);
    }

    public final void OooO00o(Canvas canvas, PointF pointF, float f) {
        if (pointF.x == -1000.0f && pointF.y == -1000.0f) {
            return;
        }
        if (this.OooO0o.isEmpty() || this.OooO0o.length() == 1) {
            RectF rectF = this.OooOOO0;
            float f2 = pointF.x;
            float f3 = (int) f;
            rectF.left = f2 - f3;
            float f4 = pointF.y;
            rectF.top = f4 - f3;
            rectF.right = f2 + f3;
            rectF.bottom = f3 + f4;
            canvas.drawCircle(f2, f4, f, this.OooOoO0);
        } else {
            this.OooOOO0.left = pointF.x - ((this.OooOO0o.width() / 2.0f) + this.OooO0Oo);
            this.OooOOO0.top = pointF.y - ((this.OooO0Oo * 0.5f) + (this.OooOO0o.height() / 2.0f));
            this.OooOOO0.right = (this.OooOO0o.width() / 2.0f) + this.OooO0Oo + pointF.x;
            this.OooOOO0.bottom = (this.OooO0Oo * 0.5f) + (this.OooOO0o.height() / 2.0f) + pointF.y;
            float height = this.OooOOO0.height() / 2.0f;
            canvas.drawRoundRect(this.OooOOO0, height, height, this.OooOoO0);
        }
        if (this.OooO0o.isEmpty()) {
            return;
        }
        String str = this.OooO0o;
        float f5 = pointF.x;
        RectF rectF2 = this.OooOOO0;
        float f6 = rectF2.bottom + rectF2.top;
        Paint.FontMetrics fontMetrics = this.OooOOOO;
        canvas.drawText(str, f5, ((f6 - fontMetrics.bottom) - fontMetrics.top) / 2.0f, this.OooOo);
    }

    public final void OooO00o(boolean z) {
        int OooO00o2 = OooO0OO.OooO00o(getContext(), 1.0f);
        int OooO00o3 = OooO0OO.OooO00o(getContext(), 1.5f);
        int i = this.OooOO0O;
        if (i == 1) {
            OooO00o2 = OooO0OO.OooO00o(getContext(), 1.0f);
            OooO00o3 = OooO0OO.OooO00o(getContext(), -1.5f);
        } else if (i == 2) {
            OooO00o2 = OooO0OO.OooO00o(getContext(), -1.0f);
            OooO00o3 = OooO0OO.OooO00o(getContext(), -1.5f);
        } else if (i == 3) {
            OooO00o2 = OooO0OO.OooO00o(getContext(), -1.0f);
            OooO00o3 = OooO0OO.OooO00o(getContext(), 1.5f);
        } else if (i == 4) {
            OooO00o2 = OooO0OO.OooO00o(getContext(), 1.0f);
            OooO00o3 = OooO0OO.OooO00o(getContext(), 1.5f);
        }
        this.OooOoO0.setShadowLayer(z ? OooO0OO.OooO00o(getContext(), 2.0f) : 0.0f, OooO00o2, OooO00o3, 855638016);
    }

    public final void OooO0O0() {
        getLocationOnScreen(new int[2]);
        PointF pointF = this.OooOOo;
        PointF pointF2 = this.OooOOOo;
        pointF.x = pointF2.x + r0[0];
        pointF.y = pointF2.y + r0[1];
    }

    public final void OooO0O0(View view) {
        if (view.getParent() instanceof View) {
            OooO0O0((View) view.getParent());
        } else if (view instanceof ViewGroup) {
            this.OooOoo0 = (ViewGroup) view;
        }
    }

    public final void OooO0OO() {
        RectF rectF = this.OooOO0o;
        rectF.left = 0.0f;
        rectF.top = 0.0f;
        if (TextUtils.isEmpty(this.OooO0o)) {
            RectF rectF2 = this.OooOO0o;
            rectF2.right = 0.0f;
            rectF2.bottom = 0.0f;
            return;
        }
        this.OooOo.setTextSize(this.OooO0OO);
        this.OooOO0o.right = this.OooOo.measureText(this.OooO0o);
        Paint.FontMetrics fontMetrics = this.OooOo.getFontMetrics();
        this.OooOOOO = fontMetrics;
        this.OooOO0o.bottom = fontMetrics.descent - fontMetrics.ascent;
    }

    public Drawable getBadgeBackground() {
        return null;
    }

    public int getBadgeBackgroundColor() {
        return this.OooO00o;
    }

    public int getBadgeGravity() {
        return this.OooO0oo;
    }

    public int getBadgeNumber() {
        return this.OooO0o0;
    }

    public String getBadgeText() {
        return this.OooO0o;
    }

    public int getBadgeTextColor() {
        return this.OooO0O0;
    }

    public PointF getDragCenter() {
        return null;
    }

    public View getTargetView() {
        return this.OooOo0;
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.OooOoo0 == null) {
            View view = this.OooOo0;
            ViewGroup viewGroup = (ViewGroup) view.getRootView();
            this.OooOoo0 = viewGroup;
            if (viewGroup == null) {
                OooO0O0(view);
            }
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        OooO0O0 oooO0O0 = this.OooOoOO;
        if (oooO0O0 != null && oooO0O0.isRunning()) {
            OooO0O0 oooO0O02 = this.OooOoOO;
            for (int i = 0; i < oooO0O02.OooO00o.length; i++) {
                int i2 = 0;
                while (true) {
                    OooO0O0.OooO00o[] oooO00oArr = oooO0O02.OooO00o[i];
                    if (i2 < oooO00oArr.length) {
                        OooO0O0.OooO00o oooO00o = oooO00oArr[i2];
                        float parseFloat = Float.parseFloat(oooO0O02.getAnimatedValue().toString());
                        oooO00o.OooO0oO.setColor(oooO00o.OooO0o0);
                        oooO00o.OooO0O0 = ((oooO00o.OooO00o.nextFloat() - 0.5f) * oooO00o.OooO00o.nextInt(oooO00o.OooO0o) * 0.1f) + oooO00o.OooO0O0;
                        float nextFloat = ((oooO00o.OooO00o.nextFloat() - 0.5f) * oooO00o.OooO00o.nextInt(oooO00o.OooO0o) * 0.1f) + oooO00o.OooO0OO;
                        oooO00o.OooO0OO = nextFloat;
                        float f = oooO00o.OooO0O0;
                        float f2 = oooO00o.OooO0Oo;
                        canvas.drawCircle(f, nextFloat, f2 - (parseFloat * f2), oooO00o.OooO0oO);
                        i2++;
                    }
                }
            }
            return;
        }
        if (this.OooO0o != null) {
            OooO00o(this.OooO0oO);
            this.OooOoO0.setColor(this.OooO00o);
            this.OooOoO.setColor(0);
            this.OooOoO.setStrokeWidth(0.0f);
            this.OooOo.setColor(this.OooO0O0);
            this.OooOo.setTextAlign(Paint.Align.CENTER);
            float badgeCircleRadius = getBadgeCircleRadius();
            PointF pointF = this.OooOOo;
            PointF pointF2 = this.OooOOo0;
            Math.sqrt(Math.pow(pointF.y - pointF2.y, 2.0d) + Math.pow(pointF.x - pointF2.x, 2.0d));
            float height = this.OooOO0o.height() > this.OooOO0o.width() ? this.OooOO0o.height() : this.OooOO0o.width();
            switch (this.OooO0oo) {
                case LauncherLifecycleType.LAUNCHER_MINIAPP_START /* 17 */:
                    PointF pointF3 = this.OooOOOo;
                    pointF3.x = this.OooOo0O / 2.0f;
                    pointF3.y = this.OooOo0o / 2.0f;
                    break;
                case 49:
                    PointF pointF4 = this.OooOOOo;
                    pointF4.x = this.OooOo0O / 2.0f;
                    pointF4.y = (this.OooOO0o.height() / 2.0f) + this.OooOO0 + this.OooO0Oo;
                    break;
                case TmcConstants.NOTIFY_ADDHOME_GUIDE_TOP_SHOW /* 81 */:
                    PointF pointF5 = this.OooOOOo;
                    pointF5.x = this.OooOo0O / 2.0f;
                    pointF5.y = this.OooOo0o - ((this.OooOO0o.height() / 2.0f) + (this.OooOO0 + this.OooO0Oo));
                    break;
                case 8388627:
                    PointF pointF6 = this.OooOOOo;
                    pointF6.x = (height / 2.0f) + this.OooO + this.OooO0Oo;
                    pointF6.y = this.OooOo0o / 2.0f;
                    break;
                case 8388629:
                    PointF pointF7 = this.OooOOOo;
                    pointF7.x = this.OooOo0O - ((height / 2.0f) + (this.OooO + this.OooO0Oo));
                    pointF7.y = this.OooOo0o / 2.0f;
                    break;
                case 8388659:
                    PointF pointF8 = this.OooOOOo;
                    float f3 = this.OooO;
                    float f4 = this.OooO0Oo;
                    pointF8.x = (height / 2.0f) + f3 + f4;
                    pointF8.y = (this.OooOO0o.height() / 2.0f) + this.OooOO0 + f4;
                    break;
                case 8388661:
                    PointF pointF9 = this.OooOOOo;
                    float f5 = this.OooOo0O;
                    float f6 = this.OooO;
                    float f7 = this.OooO0Oo;
                    pointF9.x = f5 - ((height / 2.0f) + (f6 + f7));
                    pointF9.y = (this.OooOO0o.height() / 2.0f) + this.OooOO0 + f7;
                    break;
                case 8388691:
                    PointF pointF10 = this.OooOOOo;
                    float f10 = this.OooO;
                    float f11 = this.OooO0Oo;
                    pointF10.x = (height / 2.0f) + f10 + f11;
                    pointF10.y = this.OooOo0o - ((this.OooOO0o.height() / 2.0f) + (this.OooOO0 + f11));
                    break;
                case 8388693:
                    PointF pointF11 = this.OooOOOo;
                    float f12 = this.OooOo0O;
                    float f13 = this.OooO;
                    float f14 = this.OooO0Oo;
                    pointF11.x = f12 - ((height / 2.0f) + (f13 + f14));
                    pointF11.y = this.OooOo0o - ((this.OooOO0o.height() / 2.0f) + (this.OooOO0 + f14));
                    break;
            }
            OooO0O0();
            OooO00o(canvas, this.OooOOOo, badgeCircleRadius);
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.OooOo0O = i;
        this.OooOo0o = i2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0010, code lost:
    
        if (r0 != 6) goto L15;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked != 1 && actionMasked != 3) {
                if (actionMasked != 5) {
                }
            }
            motionEvent.getPointerId(motionEvent.getActionIndex());
            return super.onTouchEvent(motionEvent);
        }
        motionEvent.getX();
        motionEvent.getY();
        return super.onTouchEvent(motionEvent);
    }
}
