package com.transsion.transfer.wifi.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Shader;
import android.util.AttributeSet;
import com.journeyapps.barcodescanner.CameraPreview;
import com.journeyapps.barcodescanner.ViewfinderView;
import com.transsion.transfer.R$styleable;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public class CustomViewfinderView extends ViewfinderView {
    public static final long INT_ANIMATION_DELAY = 12;
    public Paint mBitmapPaint;
    public int mLineColor;
    public float mLineDepth;
    public float mLineRate;
    public LinearGradient mLinearGradient;
    public float[] mPositions;
    public float mScanFrameHeight;
    public float mScanFrameWidth;
    public int[] mScanLineColor;
    public float mScanLineDepth;
    public float mScanLineDy;
    public int mScanLinePosition;

    public CustomViewfinderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mLineRate = 0.1f;
        this.mLineDepth = b(4);
        this.mScanLinePosition = 0;
        this.mScanLineDepth = b(4);
        this.mScanLineDy = b(3);
        this.mPositions = new float[]{0.0f, 0.5f, 1.0f};
        this.mScanLineColor = new int[]{0, -256, 0};
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.CustomViewfinderView);
        this.mLineColor = obtainStyledAttributes.getColor(R$styleable.CustomViewfinderView_lineColor, -256);
        this.mScanLineColor[1] = obtainStyledAttributes.getColor(R$styleable.CustomViewfinderView_cornerColor, -256);
        this.mScanFrameWidth = obtainStyledAttributes.getDimension(R$styleable.CustomViewfinderView_scanFrameWidth, b(160));
        this.mScanFrameHeight = obtainStyledAttributes.getDimension(R$styleable.CustomViewfinderView_scanFrameHeight, b(160));
        obtainStyledAttributes.recycle();
        Paint paint = new Paint();
        this.mBitmapPaint = paint;
        paint.setAntiAlias(true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private int b(int i) {
        return (int) ((i * getContext().getResources().getDisplayMetrics().density) + 0.5f);
    }

    protected void a() {
        CameraPreview cameraPreview = ((ViewfinderView) this).k;
        if (cameraPreview == null) {
            return;
        }
        cameraPreview.setFramingRectSize(new af.q((int) this.mScanFrameWidth, (int) this.mScanFrameHeight));
        Rect framingRect = ((ViewfinderView) this).k.getFramingRect();
        af.q previewSize = ((ViewfinderView) this).k.getPreviewSize();
        if (framingRect == null || previewSize == null) {
            return;
        }
        ((ViewfinderView) this).l = framingRect;
        ((ViewfinderView) this).m = previewSize;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SuppressLint({"DrawAllocation"})
    public void onDraw(Canvas canvas) {
        a();
        Rect rect = ((ViewfinderView) this).l;
        if (rect == null || ((ViewfinderView) this).m == null) {
            return;
        }
        int width = getWidth();
        int height = getHeight();
        ((ViewfinderView) this).a.setColor(((ViewfinderView) this).b != null ? ((ViewfinderView) this).d : ((ViewfinderView) this).c);
        float f = width;
        canvas.drawRect(0.0f, 0.0f, f, rect.top, ((ViewfinderView) this).a);
        canvas.drawRect(0.0f, rect.top, rect.left, rect.bottom + 1, ((ViewfinderView) this).a);
        canvas.drawRect(rect.right + 1, rect.top, f, rect.bottom + 1, ((ViewfinderView) this).a);
        canvas.drawRect(0.0f, rect.bottom + 1, f, height, ((ViewfinderView) this).a);
        ((ViewfinderView) this).a.setColor(this.mLineColor);
        int i = rect.left;
        canvas.drawRect(i, rect.top, i + (rect.width() * this.mLineRate), rect.top + this.mLineDepth, ((ViewfinderView) this).a);
        int i2 = rect.left;
        int i3 = rect.top;
        canvas.drawRect(i2, i3, this.mLineDepth + i2, i3 + (rect.height() * this.mLineRate), ((ViewfinderView) this).a);
        float width2 = rect.right - (rect.width() * this.mLineRate);
        int i4 = rect.top;
        canvas.drawRect(width2, i4, rect.right, i4 + this.mLineDepth, ((ViewfinderView) this).a);
        int i5 = rect.right;
        float f2 = i5 - this.mLineDepth;
        int i6 = rect.top;
        canvas.drawRect(f2, i6, i5, i6 + (rect.height() * this.mLineRate), ((ViewfinderView) this).a);
        int i7 = rect.left;
        canvas.drawRect(i7, rect.bottom - this.mLineDepth, i7 + (rect.width() * this.mLineRate), rect.bottom, ((ViewfinderView) this).a);
        canvas.drawRect(rect.left, rect.bottom - (rect.height() * this.mLineRate), rect.left + this.mLineDepth, rect.bottom, ((ViewfinderView) this).a);
        float width3 = rect.right - (rect.width() * this.mLineRate);
        int i8 = rect.bottom;
        canvas.drawRect(width3, i8 - this.mLineDepth, rect.right, i8, ((ViewfinderView) this).a);
        canvas.drawRect(rect.right - this.mLineDepth, rect.bottom - (rect.height() * this.mLineRate), rect.right, rect.bottom, ((ViewfinderView) this).a);
        if (((ViewfinderView) this).b != null) {
            ((ViewfinderView) this).a.setAlpha(160);
            canvas.drawBitmap(((ViewfinderView) this).b, (Rect) null, rect, ((ViewfinderView) this).a);
        } else {
            int i9 = (int) (this.mScanLinePosition + this.mScanLineDy);
            this.mScanLinePosition = i9;
            if (i9 >= rect.height()) {
                this.mScanLinePosition = 0;
            }
            float f3 = rect.left;
            int i10 = rect.top;
            int i11 = this.mScanLinePosition;
            LinearGradient linearGradient = new LinearGradient(f3, i10 + i11, rect.right, i10 + i11, this.mScanLineColor, this.mPositions, Shader.TileMode.CLAMP);
            this.mLinearGradient = linearGradient;
            ((ViewfinderView) this).a.setShader(linearGradient);
            float f4 = rect.left;
            int i12 = rect.top;
            int i13 = this.mScanLinePosition;
            canvas.drawRect(f4, i12 + i13, rect.right, i12 + i13 + this.mScanLineDepth, ((ViewfinderView) this).a);
            ((ViewfinderView) this).a.setShader(null);
        }
        postInvalidateDelayed(12L, rect.left - 6, rect.top - 6, rect.right + 6, rect.bottom + 6);
    }
}
