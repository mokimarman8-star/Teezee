package com.bytedance.adsdk.ugeno.uA.EjP;

import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.util.Log;
import android.widget.ImageView;
import com.bumptech.glide.load.resource.drawable.b;
import java.util.HashSet;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class sP extends Drawable {
    private final RectF Dq;
    private final Bitmap EjP;
    private Shader.TileMode Fmk;
    private final Paint HiB;
    private final int Jcg;
    private ColorStateList RiZ;
    private final Matrix TEQ;
    private final RectF TKC;
    private float TzV;
    private final RectF Ym;
    private float Zq;
    private Shader.TileMode aa;
    private boolean dNu;
    private ImageView.ScaleType sU;
    private boolean sef;
    private final Paint uA;
    private final boolean[] uvD;
    private final int vS;
    private final RectF Sj = new RectF();
    private final RectF sP = new RectF();

    /* renamed from: com.bytedance.adsdk.ugeno.uA.EjP.sP$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] Sj;

        static {
            int[] iArr = new int[ImageView.ScaleType.values().length];
            Sj = iArr;
            try {
                iArr[ImageView.ScaleType.CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                Sj[ImageView.ScaleType.CENTER_CROP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                Sj[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                Sj[ImageView.ScaleType.FIT_CENTER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                Sj[ImageView.ScaleType.FIT_END.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                Sj[ImageView.ScaleType.FIT_START.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                Sj[ImageView.ScaleType.FIT_XY.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public sP(Bitmap bitmap) {
        RectF rectF = new RectF();
        this.TKC = rectF;
        this.Dq = new RectF();
        this.TEQ = new Matrix();
        this.Ym = new RectF();
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        this.aa = tileMode;
        this.Fmk = tileMode;
        this.sef = true;
        this.Zq = 0.0f;
        this.uvD = new boolean[]{true, true, true, true};
        this.dNu = false;
        this.TzV = 0.0f;
        this.RiZ = ColorStateList.valueOf(-16777216);
        this.sU = ImageView.ScaleType.FIT_CENTER;
        this.EjP = bitmap;
        int width = bitmap.getWidth();
        this.vS = width;
        int height = bitmap.getHeight();
        this.Jcg = height;
        rectF.set(0.0f, 0.0f, width, height);
        Paint paint = new Paint();
        this.HiB = paint;
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);
        Paint paint2 = new Paint();
        this.uA = paint2;
        paint2.setStyle(Paint.Style.STROKE);
        paint2.setAntiAlias(true);
        paint2.setColor(this.RiZ.getColorForState(getState(), -16777216));
        paint2.setStrokeWidth(this.TzV);
    }

    public static Drawable Sj(Drawable drawable) {
        if (drawable != null) {
            if (drawable instanceof sP) {
                return drawable;
            }
            if (Build.VERSION.SDK_INT >= 28 && b.a(drawable)) {
                return drawable;
            }
            if (drawable instanceof LayerDrawable) {
                Drawable.ConstantState constantState = drawable.mutate().getConstantState();
                if (constantState != null) {
                    drawable = constantState.newDrawable();
                }
                LayerDrawable layerDrawable = (LayerDrawable) drawable;
                int numberOfLayers = layerDrawable.getNumberOfLayers();
                for (int i = 0; i < numberOfLayers; i++) {
                    layerDrawable.setDrawableByLayerId(layerDrawable.getId(i), Sj(layerDrawable.getDrawable(i)));
                }
                return layerDrawable;
            }
        }
        Bitmap sP = sP(drawable);
        return sP != null ? new sP(sP) : drawable;
    }

    public static sP Sj(Bitmap bitmap) {
        if (bitmap != null) {
            return new sP(bitmap);
        }
        return null;
    }

    private void Sj() {
        float width;
        float height;
        int i = AnonymousClass1.Sj[this.sU.ordinal()];
        if (i == 1) {
            this.Dq.set(this.Sj);
            RectF rectF = this.Dq;
            float f = this.TzV;
            rectF.inset(f / 2.0f, f / 2.0f);
            this.TEQ.reset();
            this.TEQ.setTranslate((int) (((this.Dq.width() - this.vS) * 0.5f) + 0.5f), (int) (((this.Dq.height() - this.Jcg) * 0.5f) + 0.5f));
        } else if (i == 2) {
            this.Dq.set(this.Sj);
            RectF rectF2 = this.Dq;
            float f2 = this.TzV;
            rectF2.inset(f2 / 2.0f, f2 / 2.0f);
            this.TEQ.reset();
            float f3 = 0.0f;
            if (this.vS * this.Dq.height() > this.Dq.width() * this.Jcg) {
                width = this.Dq.height() / this.Jcg;
                height = 0.0f;
                f3 = (this.Dq.width() - (this.vS * width)) * 0.5f;
            } else {
                width = this.Dq.width() / this.vS;
                height = (this.Dq.height() - (this.Jcg * width)) * 0.5f;
            }
            this.TEQ.setScale(width, width);
            Matrix matrix = this.TEQ;
            float f4 = this.TzV;
            matrix.postTranslate(((int) (f3 + 0.5f)) + (f4 / 2.0f), ((int) (height + 0.5f)) + (f4 / 2.0f));
        } else if (i == 3) {
            this.TEQ.reset();
            float min = (((float) this.vS) > this.Sj.width() || ((float) this.Jcg) > this.Sj.height()) ? Math.min(this.Sj.width() / this.vS, this.Sj.height() / this.Jcg) : 1.0f;
            float width2 = (int) (((this.Sj.width() - (this.vS * min)) * 0.5f) + 0.5f);
            float height2 = (int) (((this.Sj.height() - (this.Jcg * min)) * 0.5f) + 0.5f);
            this.TEQ.setScale(min, min);
            this.TEQ.postTranslate(width2, height2);
            this.Dq.set(this.TKC);
            this.TEQ.mapRect(this.Dq);
            RectF rectF3 = this.Dq;
            float f8 = this.TzV;
            rectF3.inset(f8 / 2.0f, f8 / 2.0f);
            this.TEQ.setRectToRect(this.TKC, this.Dq, Matrix.ScaleToFit.FILL);
        } else if (i == 5) {
            this.Dq.set(this.TKC);
            this.TEQ.setRectToRect(this.TKC, this.Sj, Matrix.ScaleToFit.END);
            this.TEQ.mapRect(this.Dq);
            RectF rectF4 = this.Dq;
            float f9 = this.TzV;
            rectF4.inset(f9 / 2.0f, f9 / 2.0f);
            this.TEQ.setRectToRect(this.TKC, this.Dq, Matrix.ScaleToFit.FILL);
        } else if (i == 6) {
            this.Dq.set(this.TKC);
            this.TEQ.setRectToRect(this.TKC, this.Sj, Matrix.ScaleToFit.START);
            this.TEQ.mapRect(this.Dq);
            RectF rectF5 = this.Dq;
            float f10 = this.TzV;
            rectF5.inset(f10 / 2.0f, f10 / 2.0f);
            this.TEQ.setRectToRect(this.TKC, this.Dq, Matrix.ScaleToFit.FILL);
        } else if (i != 7) {
            this.Dq.set(this.TKC);
            this.TEQ.setRectToRect(this.TKC, this.Sj, Matrix.ScaleToFit.CENTER);
            this.TEQ.mapRect(this.Dq);
            RectF rectF6 = this.Dq;
            float f11 = this.TzV;
            rectF6.inset(f11 / 2.0f, f11 / 2.0f);
            this.TEQ.setRectToRect(this.TKC, this.Dq, Matrix.ScaleToFit.FILL);
        } else {
            this.Dq.set(this.Sj);
            RectF rectF7 = this.Dq;
            float f12 = this.TzV;
            rectF7.inset(f12 / 2.0f, f12 / 2.0f);
            this.TEQ.reset();
            this.TEQ.setRectToRect(this.TKC, this.Dq, Matrix.ScaleToFit.FILL);
        }
        this.sP.set(this.Dq);
        this.sef = true;
    }

    private void Sj(Canvas canvas) {
        if (sP(this.uvD) || this.Zq == 0.0f) {
            return;
        }
        RectF rectF = this.sP;
        float f = rectF.left;
        float f2 = rectF.top;
        float width = rectF.width() + f;
        float height = this.sP.height() + f2;
        float f3 = this.Zq;
        if (!this.uvD[0]) {
            this.Ym.set(f, f2, f + f3, f2 + f3);
            canvas.drawRect(this.Ym, this.HiB);
        }
        if (!this.uvD[1]) {
            this.Ym.set(width - f3, f2, width, f3);
            canvas.drawRect(this.Ym, this.HiB);
        }
        if (!this.uvD[2]) {
            this.Ym.set(width - f3, height - f3, width, height);
            canvas.drawRect(this.Ym, this.HiB);
        }
        if (this.uvD[3]) {
            return;
        }
        this.Ym.set(f, height - f3, f3 + f, height);
        canvas.drawRect(this.Ym, this.HiB);
    }

    private static boolean Sj(boolean[] zArr) {
        for (boolean z : zArr) {
            if (z) {
                return true;
            }
        }
        return false;
    }

    public static Bitmap sP(Drawable drawable) {
        if (drawable == null) {
            return null;
        }
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        try {
            Bitmap createBitmap = Bitmap.createBitmap(Math.max(drawable.getIntrinsicWidth(), 2), Math.max(drawable.getIntrinsicHeight(), 2), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            drawable.draw(canvas);
            return createBitmap;
        } catch (Throwable unused) {
            Log.w("RoundedDrawable", "Failed to create bitmap from drawable!");
            return null;
        }
    }

    private void sP(Canvas canvas) {
        float f;
        if (sP(this.uvD) || this.Zq == 0.0f) {
            return;
        }
        RectF rectF = this.sP;
        float f2 = rectF.left;
        float f3 = rectF.top;
        float width = rectF.width() + f2;
        float height = f3 + this.sP.height();
        float f4 = this.Zq;
        float f8 = this.TzV / 2.0f;
        if (!this.uvD[0]) {
            canvas.drawLine(f2 - f8, f3, f2 + f4, f3, this.uA);
            canvas.drawLine(f2, f3 - f8, f2, f3 + f4, this.uA);
        }
        if (!this.uvD[1]) {
            canvas.drawLine((width - f4) - f8, f3, width, f3, this.uA);
            canvas.drawLine(width, f3 - f8, width, f3 + f4, this.uA);
        }
        if (this.uvD[2]) {
            f = f4;
        } else {
            f = f4;
            canvas.drawLine((width - f4) - f8, height, width + f8, height, this.uA);
            canvas.drawLine(width, height - f, width, height, this.uA);
        }
        if (this.uvD[3]) {
            return;
        }
        canvas.drawLine(f2 - f8, height, f2 + f, height, this.uA);
        canvas.drawLine(f2, height - f, f2, height, this.uA);
    }

    private static boolean sP(boolean[] zArr) {
        for (boolean z : zArr) {
            if (z) {
                return false;
            }
        }
        return true;
    }

    public sP Sj(float f) {
        this.TzV = f;
        this.uA.setStrokeWidth(f);
        return this;
    }

    public sP Sj(float f, float f2, float f3, float f4) {
        HashSet hashSet = new HashSet(4);
        hashSet.add(Float.valueOf(f));
        hashSet.add(Float.valueOf(f2));
        hashSet.add(Float.valueOf(f3));
        hashSet.add(Float.valueOf(f4));
        hashSet.remove(Float.valueOf(0.0f));
        if (hashSet.size() > 1) {
            throw new IllegalArgumentException("Multiple nonzero corner radii not yet supported.");
        }
        if (hashSet.isEmpty()) {
            this.Zq = 0.0f;
        } else {
            float floatValue = ((Float) hashSet.iterator().next()).floatValue();
            if (Float.isInfinite(floatValue) || Float.isNaN(floatValue) || floatValue < 0.0f) {
                throw new IllegalArgumentException("Invalid radius value: ".concat(String.valueOf(floatValue)));
            }
            this.Zq = floatValue;
        }
        boolean[] zArr = this.uvD;
        zArr[0] = f > 0.0f;
        zArr[1] = f2 > 0.0f;
        zArr[2] = f3 > 0.0f;
        zArr[3] = f4 > 0.0f;
        return this;
    }

    public sP Sj(ColorStateList colorStateList) {
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        this.RiZ = colorStateList;
        this.uA.setColor(colorStateList.getColorForState(getState(), -16777216));
        return this;
    }

    public sP Sj(Shader.TileMode tileMode) {
        if (this.aa != tileMode) {
            this.aa = tileMode;
            this.sef = true;
            invalidateSelf();
        }
        return this;
    }

    public sP Sj(ImageView.ScaleType scaleType) {
        if (scaleType == null) {
            scaleType = ImageView.ScaleType.FIT_CENTER;
        }
        if (this.sU != scaleType) {
            this.sU = scaleType;
            Sj();
        }
        return this;
    }

    public sP Sj(boolean z) {
        this.dNu = z;
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.sef) {
            BitmapShader bitmapShader = new BitmapShader(this.EjP, this.aa, this.Fmk);
            Shader.TileMode tileMode = this.aa;
            Shader.TileMode tileMode2 = Shader.TileMode.CLAMP;
            if (tileMode == tileMode2 && this.Fmk == tileMode2) {
                bitmapShader.setLocalMatrix(this.TEQ);
            }
            this.HiB.setShader(bitmapShader);
            this.sef = false;
        }
        if (this.dNu) {
            if (this.TzV <= 0.0f) {
                canvas.drawOval(this.sP, this.HiB);
                return;
            } else {
                canvas.drawOval(this.sP, this.HiB);
                canvas.drawOval(this.Dq, this.uA);
                return;
            }
        }
        if (!Sj(this.uvD)) {
            canvas.drawRect(this.sP, this.HiB);
            if (this.TzV > 0.0f) {
                canvas.drawRect(this.Dq, this.uA);
                return;
            }
            return;
        }
        float f = this.Zq;
        if (this.TzV <= 0.0f) {
            canvas.drawRoundRect(this.sP, f, f, this.HiB);
            Sj(canvas);
        } else {
            canvas.drawRoundRect(this.sP, f, f, this.HiB);
            canvas.drawRoundRect(this.Dq, f, f, this.uA);
            Sj(canvas);
            sP(canvas);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.HiB.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        return this.HiB.getColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.Jcg;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.vS;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return this.RiZ.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.Sj.set(rect);
        Sj();
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        int colorForState = this.RiZ.getColorForState(iArr, 0);
        if (this.uA.getColor() == colorForState) {
            return super.onStateChange(iArr);
        }
        this.uA.setColor(colorForState);
        return true;
    }

    public sP sP(Shader.TileMode tileMode) {
        if (this.Fmk != tileMode) {
            this.Fmk = tileMode;
            this.sef = true;
            invalidateSelf();
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.HiB.setAlpha(i);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.HiB.setColorFilter(colorFilter);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z) {
        this.HiB.setDither(z);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean z) {
        this.HiB.setFilterBitmap(z);
        invalidateSelf();
    }
}
