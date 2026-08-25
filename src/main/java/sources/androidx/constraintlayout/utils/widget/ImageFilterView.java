package androidx.constraintlayout.utils.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.R;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public class ImageFilterView extends AppCompatImageView {

    /* renamed from: d, reason: collision with root package name */
    private c f6444d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f6445e;

    /* renamed from: f, reason: collision with root package name */
    private Drawable f6446f;

    /* renamed from: g, reason: collision with root package name */
    private Drawable f6447g;

    /* renamed from: h, reason: collision with root package name */
    private float f6448h;

    /* renamed from: i, reason: collision with root package name */
    private float f6449i;

    /* renamed from: j, reason: collision with root package name */
    private float f6450j;

    /* renamed from: k, reason: collision with root package name */
    private Path f6451k;

    /* renamed from: l, reason: collision with root package name */
    ViewOutlineProvider f6452l;

    /* renamed from: m, reason: collision with root package name */
    RectF f6453m;

    /* renamed from: n, reason: collision with root package name */
    Drawable[] f6454n;

    /* renamed from: o, reason: collision with root package name */
    LayerDrawable f6455o;

    /* renamed from: p, reason: collision with root package name */
    float f6456p;

    /* renamed from: q, reason: collision with root package name */
    float f6457q;

    /* renamed from: r, reason: collision with root package name */
    float f6458r;

    /* renamed from: s, reason: collision with root package name */
    float f6459s;

    class a extends ViewOutlineProvider {
        a() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            outline.setRoundRect(0, 0, ImageFilterView.this.getWidth(), ImageFilterView.this.getHeight(), (Math.min(r3, r4) * ImageFilterView.this.f6449i) / 2.0f);
        }
    }

    class b extends ViewOutlineProvider {
        b() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            outline.setRoundRect(0, 0, ImageFilterView.this.getWidth(), ImageFilterView.this.getHeight(), ImageFilterView.this.f6450j);
        }
    }

    static class c {

        /* renamed from: a, reason: collision with root package name */
        float[] f6462a = new float[20];

        /* renamed from: b, reason: collision with root package name */
        ColorMatrix f6463b = new ColorMatrix();

        /* renamed from: c, reason: collision with root package name */
        ColorMatrix f6464c = new ColorMatrix();

        /* renamed from: d, reason: collision with root package name */
        float f6465d = 1.0f;

        /* renamed from: e, reason: collision with root package name */
        float f6466e = 1.0f;

        /* renamed from: f, reason: collision with root package name */
        float f6467f = 1.0f;

        /* renamed from: g, reason: collision with root package name */
        float f6468g = 1.0f;

        c() {
        }

        private void a(float f5) {
            float[] fArr = this.f6462a;
            fArr[0] = f5;
            fArr[1] = 0.0f;
            fArr[2] = 0.0f;
            fArr[3] = 0.0f;
            fArr[4] = 0.0f;
            fArr[5] = 0.0f;
            fArr[6] = f5;
            fArr[7] = 0.0f;
            fArr[8] = 0.0f;
            fArr[9] = 0.0f;
            fArr[10] = 0.0f;
            fArr[11] = 0.0f;
            fArr[12] = f5;
            fArr[13] = 0.0f;
            fArr[14] = 0.0f;
            fArr[15] = 0.0f;
            fArr[16] = 0.0f;
            fArr[17] = 0.0f;
            fArr[18] = 1.0f;
            fArr[19] = 0.0f;
        }

        private void b(float f5) {
            float f6 = 1.0f - f5;
            float f7 = 0.2999f * f6;
            float f8 = 0.587f * f6;
            float f9 = f6 * 0.114f;
            float[] fArr = this.f6462a;
            fArr[0] = f7 + f5;
            fArr[1] = f8;
            fArr[2] = f9;
            fArr[3] = 0.0f;
            fArr[4] = 0.0f;
            fArr[5] = f7;
            fArr[6] = f8 + f5;
            fArr[7] = f9;
            fArr[8] = 0.0f;
            fArr[9] = 0.0f;
            fArr[10] = f7;
            fArr[11] = f8;
            fArr[12] = f9 + f5;
            fArr[13] = 0.0f;
            fArr[14] = 0.0f;
            fArr[15] = 0.0f;
            fArr[16] = 0.0f;
            fArr[17] = 0.0f;
            fArr[18] = 1.0f;
            fArr[19] = 0.0f;
        }

        private void d(float f5) {
            float log;
            float f6;
            if (f5 <= 0.0f) {
                f5 = 0.01f;
            }
            float f7 = (5000.0f / f5) / 100.0f;
            if (f7 > 66.0f) {
                double d5 = f7 - 60.0f;
                f6 = ((float) Math.pow(d5, -0.13320475816726685d)) * 329.69873f;
                log = ((float) Math.pow(d5, 0.07551484555006027d)) * 288.12216f;
            } else {
                log = (((float) Math.log(f7)) * 99.4708f) - 161.11957f;
                f6 = 255.0f;
            }
            float log2 = f7 < 66.0f ? f7 > 19.0f ? (((float) Math.log(f7 - 10.0f)) * 138.51773f) - 305.0448f : 0.0f : 255.0f;
            float min = Math.min(255.0f, Math.max(f6, 0.0f));
            float min2 = Math.min(255.0f, Math.max(log, 0.0f));
            float min3 = Math.min(255.0f, Math.max(log2, 0.0f));
            float log3 = (((float) Math.log(50.0f)) * 99.4708f) - 161.11957f;
            float log4 = (((float) Math.log(40.0f)) * 138.51773f) - 305.0448f;
            float min4 = Math.min(255.0f, Math.max(255.0f, 0.0f));
            float min5 = Math.min(255.0f, Math.max(log3, 0.0f));
            float min6 = min3 / Math.min(255.0f, Math.max(log4, 0.0f));
            float[] fArr = this.f6462a;
            fArr[0] = min / min4;
            fArr[1] = 0.0f;
            fArr[2] = 0.0f;
            fArr[3] = 0.0f;
            fArr[4] = 0.0f;
            fArr[5] = 0.0f;
            fArr[6] = min2 / min5;
            fArr[7] = 0.0f;
            fArr[8] = 0.0f;
            fArr[9] = 0.0f;
            fArr[10] = 0.0f;
            fArr[11] = 0.0f;
            fArr[12] = min6;
            fArr[13] = 0.0f;
            fArr[14] = 0.0f;
            fArr[15] = 0.0f;
            fArr[16] = 0.0f;
            fArr[17] = 0.0f;
            fArr[18] = 1.0f;
            fArr[19] = 0.0f;
        }

        void c(ImageView imageView) {
            boolean z5;
            this.f6463b.reset();
            float f5 = this.f6466e;
            boolean z6 = true;
            if (f5 != 1.0f) {
                b(f5);
                this.f6463b.set(this.f6462a);
                z5 = true;
            } else {
                z5 = false;
            }
            float f6 = this.f6467f;
            if (f6 != 1.0f) {
                this.f6464c.setScale(f6, f6, f6, 1.0f);
                this.f6463b.postConcat(this.f6464c);
                z5 = true;
            }
            float f7 = this.f6468g;
            if (f7 != 1.0f) {
                d(f7);
                this.f6464c.set(this.f6462a);
                this.f6463b.postConcat(this.f6464c);
                z5 = true;
            }
            float f8 = this.f6465d;
            if (f8 != 1.0f) {
                a(f8);
                this.f6464c.set(this.f6462a);
                this.f6463b.postConcat(this.f6464c);
            } else {
                z6 = z5;
            }
            if (z6) {
                imageView.setColorFilter(new ColorMatrixColorFilter(this.f6463b));
            } else {
                imageView.clearColorFilter();
            }
        }
    }

    public ImageFilterView(Context context) {
        super(context);
        this.f6444d = new c();
        this.f6445e = true;
        this.f6446f = null;
        this.f6447g = null;
        this.f6448h = 0.0f;
        this.f6449i = 0.0f;
        this.f6450j = Float.NaN;
        this.f6454n = new Drawable[2];
        this.f6456p = Float.NaN;
        this.f6457q = Float.NaN;
        this.f6458r = Float.NaN;
        this.f6459s = Float.NaN;
        init(context, null);
    }

    public ImageFilterView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f6444d = new c();
        this.f6445e = true;
        this.f6446f = null;
        this.f6447g = null;
        this.f6448h = 0.0f;
        this.f6449i = 0.0f;
        this.f6450j = Float.NaN;
        this.f6454n = new Drawable[2];
        this.f6456p = Float.NaN;
        this.f6457q = Float.NaN;
        this.f6458r = Float.NaN;
        this.f6459s = Float.NaN;
        init(context, attributeSet);
    }

    public ImageFilterView(Context context, AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
        this.f6444d = new c();
        this.f6445e = true;
        this.f6446f = null;
        this.f6447g = null;
        this.f6448h = 0.0f;
        this.f6449i = 0.0f;
        this.f6450j = Float.NaN;
        this.f6454n = new Drawable[2];
        this.f6456p = Float.NaN;
        this.f6457q = Float.NaN;
        this.f6458r = Float.NaN;
        this.f6459s = Float.NaN;
        init(context, attributeSet);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void c() {
        if (Float.isNaN(this.f6456p) && Float.isNaN(this.f6457q) && Float.isNaN(this.f6458r) && Float.isNaN(this.f6459s)) {
            return;
        }
        float f5 = Float.isNaN(this.f6456p) ? 0.0f : this.f6456p;
        float f6 = Float.isNaN(this.f6457q) ? 0.0f : this.f6457q;
        float f7 = Float.isNaN(this.f6458r) ? 1.0f : this.f6458r;
        float f8 = Float.isNaN(this.f6459s) ? 0.0f : this.f6459s;
        Matrix matrix = new Matrix();
        matrix.reset();
        float intrinsicWidth = getDrawable().getIntrinsicWidth();
        float intrinsicHeight = getDrawable().getIntrinsicHeight();
        float width = getWidth();
        float height = getHeight();
        float f9 = f7 * (intrinsicWidth * height < intrinsicHeight * width ? width / intrinsicWidth : height / intrinsicHeight);
        matrix.postScale(f9, f9);
        float f10 = intrinsicWidth * f9;
        float f11 = f9 * intrinsicHeight;
        matrix.postTranslate((((f5 * (width - f10)) + width) - f10) * 0.5f, (((f6 * (height - f11)) + height) - f11) * 0.5f);
        matrix.postRotate(f8, width / 2.0f, height / 2.0f);
        setImageMatrix(matrix);
        setScaleType(ImageView.ScaleType.MATRIX);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void d() {
        if (Float.isNaN(this.f6456p) && Float.isNaN(this.f6457q) && Float.isNaN(this.f6458r) && Float.isNaN(this.f6459s)) {
            setScaleType(ImageView.ScaleType.FIT_CENTER);
        } else {
            c();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void init(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.ImageFilterView);
            int indexCount = obtainStyledAttributes.getIndexCount();
            this.f6446f = obtainStyledAttributes.getDrawable(R.styleable.ImageFilterView_altSrc);
            for (int i5 = 0; i5 < indexCount; i5++) {
                int index = obtainStyledAttributes.getIndex(i5);
                if (index == R.styleable.ImageFilterView_crossfade) {
                    this.f6448h = obtainStyledAttributes.getFloat(index, 0.0f);
                } else if (index == R.styleable.ImageFilterView_warmth) {
                    setWarmth(obtainStyledAttributes.getFloat(index, 0.0f));
                } else if (index == R.styleable.ImageFilterView_saturation) {
                    setSaturation(obtainStyledAttributes.getFloat(index, 0.0f));
                } else if (index == R.styleable.ImageFilterView_contrast) {
                    setContrast(obtainStyledAttributes.getFloat(index, 0.0f));
                } else if (index == R.styleable.ImageFilterView_brightness) {
                    setBrightness(obtainStyledAttributes.getFloat(index, 0.0f));
                } else if (index == R.styleable.ImageFilterView_round) {
                    setRound(obtainStyledAttributes.getDimension(index, 0.0f));
                } else if (index == R.styleable.ImageFilterView_roundPercent) {
                    setRoundPercent(obtainStyledAttributes.getFloat(index, 0.0f));
                } else if (index == R.styleable.ImageFilterView_overlay) {
                    setOverlay(obtainStyledAttributes.getBoolean(index, this.f6445e));
                } else if (index == R.styleable.ImageFilterView_imagePanX) {
                    setImagePanX(obtainStyledAttributes.getFloat(index, this.f6456p));
                } else if (index == R.styleable.ImageFilterView_imagePanY) {
                    setImagePanY(obtainStyledAttributes.getFloat(index, this.f6457q));
                } else if (index == R.styleable.ImageFilterView_imageRotate) {
                    setImageRotate(obtainStyledAttributes.getFloat(index, this.f6459s));
                } else if (index == R.styleable.ImageFilterView_imageZoom) {
                    setImageZoom(obtainStyledAttributes.getFloat(index, this.f6458r));
                }
            }
            obtainStyledAttributes.recycle();
            Drawable drawable = getDrawable();
            this.f6447g = drawable;
            if (this.f6446f == null || drawable == null) {
                Drawable drawable2 = getDrawable();
                this.f6447g = drawable2;
                if (drawable2 != null) {
                    Drawable[] drawableArr = this.f6454n;
                    Drawable mutate = drawable2.mutate();
                    this.f6447g = mutate;
                    drawableArr[0] = mutate;
                    return;
                }
                return;
            }
            Drawable[] drawableArr2 = this.f6454n;
            Drawable mutate2 = getDrawable().mutate();
            this.f6447g = mutate2;
            drawableArr2[0] = mutate2;
            this.f6454n[1] = this.f6446f.mutate();
            LayerDrawable layerDrawable = new LayerDrawable(this.f6454n);
            this.f6455o = layerDrawable;
            layerDrawable.getDrawable(1).setAlpha((int) (this.f6448h * 255.0f));
            if (!this.f6445e) {
                this.f6455o.getDrawable(0).setAlpha((int) ((1.0f - this.f6448h) * 255.0f));
            }
            super.setImageDrawable(this.f6455o);
        }
    }

    private void setOverlay(boolean z5) {
        this.f6445e = z5;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void draw(Canvas canvas) {
        super/*android.widget.ImageView*/.draw(canvas);
    }

    public float getBrightness() {
        return this.f6444d.f6465d;
    }

    public float getContrast() {
        return this.f6444d.f6467f;
    }

    public float getCrossfade() {
        return this.f6448h;
    }

    public float getImagePanX() {
        return this.f6456p;
    }

    public float getImagePanY() {
        return this.f6457q;
    }

    public float getImageRotate() {
        return this.f6459s;
    }

    public float getImageZoom() {
        return this.f6458r;
    }

    public float getRound() {
        return this.f6450j;
    }

    public float getRoundPercent() {
        return this.f6449i;
    }

    public float getSaturation() {
        return this.f6444d.f6466e;
    }

    public float getWarmth() {
        return this.f6444d.f6468g;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void layout(int i5, int i6, int i7, int i8) {
        super/*android.widget.ImageView*/.layout(i5, i6, i7, i8);
        c();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setAltImageResource(int i5) {
        Drawable mutate = g.a.b(getContext(), i5).mutate();
        this.f6446f = mutate;
        Drawable[] drawableArr = this.f6454n;
        drawableArr[0] = this.f6447g;
        drawableArr[1] = mutate;
        LayerDrawable layerDrawable = new LayerDrawable(this.f6454n);
        this.f6455o = layerDrawable;
        super.setImageDrawable(layerDrawable);
        setCrossfade(this.f6448h);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setBrightness(float f5) {
        c cVar = this.f6444d;
        cVar.f6465d = f5;
        cVar.c(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setContrast(float f5) {
        c cVar = this.f6444d;
        cVar.f6467f = f5;
        cVar.c(this);
    }

    public void setCrossfade(float f5) {
        this.f6448h = f5;
        if (this.f6454n != null) {
            if (!this.f6445e) {
                this.f6455o.getDrawable(0).setAlpha((int) ((1.0f - this.f6448h) * 255.0f));
            }
            this.f6455o.getDrawable(1).setAlpha((int) (this.f6448h * 255.0f));
            super.setImageDrawable(this.f6455o);
        }
    }

    public void setImageDrawable(Drawable drawable) {
        if (this.f6446f == null || drawable == null) {
            super.setImageDrawable(drawable);
            return;
        }
        Drawable mutate = drawable.mutate();
        this.f6447g = mutate;
        Drawable[] drawableArr = this.f6454n;
        drawableArr[0] = mutate;
        drawableArr[1] = this.f6446f;
        LayerDrawable layerDrawable = new LayerDrawable(this.f6454n);
        this.f6455o = layerDrawable;
        super.setImageDrawable(layerDrawable);
        setCrossfade(this.f6448h);
    }

    public void setImagePanX(float f5) {
        this.f6456p = f5;
        d();
    }

    public void setImagePanY(float f5) {
        this.f6457q = f5;
        d();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setImageResource(int i5) {
        if (this.f6446f == null) {
            super.setImageResource(i5);
            return;
        }
        Drawable mutate = g.a.b(getContext(), i5).mutate();
        this.f6447g = mutate;
        Drawable[] drawableArr = this.f6454n;
        drawableArr[0] = mutate;
        drawableArr[1] = this.f6446f;
        LayerDrawable layerDrawable = new LayerDrawable(this.f6454n);
        this.f6455o = layerDrawable;
        super.setImageDrawable(layerDrawable);
        setCrossfade(this.f6448h);
    }

    public void setImageRotate(float f5) {
        this.f6459s = f5;
        d();
    }

    public void setImageZoom(float f5) {
        this.f6458r = f5;
        d();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setRound(float f5) {
        if (Float.isNaN(f5)) {
            this.f6450j = f5;
            float f6 = this.f6449i;
            this.f6449i = -1.0f;
            setRoundPercent(f6);
            return;
        }
        boolean z5 = this.f6450j != f5;
        this.f6450j = f5;
        if (f5 != 0.0f) {
            if (this.f6451k == null) {
                this.f6451k = new Path();
            }
            if (this.f6453m == null) {
                this.f6453m = new RectF();
            }
            if (this.f6452l == null) {
                b bVar = new b();
                this.f6452l = bVar;
                setOutlineProvider(bVar);
            }
            setClipToOutline(true);
            this.f6453m.set(0.0f, 0.0f, getWidth(), getHeight());
            this.f6451k.reset();
            Path path = this.f6451k;
            RectF rectF = this.f6453m;
            float f7 = this.f6450j;
            path.addRoundRect(rectF, f7, f7, Path.Direction.CW);
        } else {
            setClipToOutline(false);
        }
        if (z5) {
            invalidateOutline();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setRoundPercent(float f5) {
        boolean z5 = this.f6449i != f5;
        this.f6449i = f5;
        if (f5 != 0.0f) {
            if (this.f6451k == null) {
                this.f6451k = new Path();
            }
            if (this.f6453m == null) {
                this.f6453m = new RectF();
            }
            if (this.f6452l == null) {
                a aVar = new a();
                this.f6452l = aVar;
                setOutlineProvider(aVar);
            }
            setClipToOutline(true);
            int width = getWidth();
            int height = getHeight();
            float min = (Math.min(width, height) * this.f6449i) / 2.0f;
            this.f6453m.set(0.0f, 0.0f, width, height);
            this.f6451k.reset();
            this.f6451k.addRoundRect(this.f6453m, min, min, Path.Direction.CW);
        } else {
            setClipToOutline(false);
        }
        if (z5) {
            invalidateOutline();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setSaturation(float f5) {
        c cVar = this.f6444d;
        cVar.f6466e = f5;
        cVar.c(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setWarmth(float f5) {
        c cVar = this.f6444d;
        cVar.f6468g = f5;
        cVar.c(this);
    }
}
