package androidx.constraintlayout.utils.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
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
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.constraintlayout.utils.widget.ImageFilterView;
import androidx.constraintlayout.widget.R;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public class ImageFilterButton extends AppCompatImageButton {

    /* renamed from: a, reason: collision with root package name */
    private ImageFilterView.c f6426a;

    /* renamed from: b, reason: collision with root package name */
    private float f6427b;

    /* renamed from: c, reason: collision with root package name */
    private float f6428c;

    /* renamed from: d, reason: collision with root package name */
    private float f6429d;

    /* renamed from: e, reason: collision with root package name */
    private Path f6430e;

    /* renamed from: f, reason: collision with root package name */
    ViewOutlineProvider f6431f;

    /* renamed from: g, reason: collision with root package name */
    RectF f6432g;

    /* renamed from: h, reason: collision with root package name */
    Drawable[] f6433h;

    /* renamed from: i, reason: collision with root package name */
    LayerDrawable f6434i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f6435j;

    /* renamed from: k, reason: collision with root package name */
    private Drawable f6436k;

    /* renamed from: l, reason: collision with root package name */
    private Drawable f6437l;

    /* renamed from: m, reason: collision with root package name */
    private float f6438m;

    /* renamed from: n, reason: collision with root package name */
    private float f6439n;

    /* renamed from: o, reason: collision with root package name */
    private float f6440o;

    /* renamed from: p, reason: collision with root package name */
    private float f6441p;

    class a extends ViewOutlineProvider {
        a() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            outline.setRoundRect(0, 0, ImageFilterButton.this.getWidth(), ImageFilterButton.this.getHeight(), (Math.min(r3, r4) * ImageFilterButton.this.f6428c) / 2.0f);
        }
    }

    class b extends ViewOutlineProvider {
        b() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            outline.setRoundRect(0, 0, ImageFilterButton.this.getWidth(), ImageFilterButton.this.getHeight(), ImageFilterButton.this.f6429d);
        }
    }

    public ImageFilterButton(Context context) {
        super(context);
        this.f6426a = new ImageFilterView.c();
        this.f6427b = 0.0f;
        this.f6428c = 0.0f;
        this.f6429d = Float.NaN;
        this.f6433h = new Drawable[2];
        this.f6435j = true;
        this.f6436k = null;
        this.f6437l = null;
        this.f6438m = Float.NaN;
        this.f6439n = Float.NaN;
        this.f6440o = Float.NaN;
        this.f6441p = Float.NaN;
        init(context, null);
    }

    public ImageFilterButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f6426a = new ImageFilterView.c();
        this.f6427b = 0.0f;
        this.f6428c = 0.0f;
        this.f6429d = Float.NaN;
        this.f6433h = new Drawable[2];
        this.f6435j = true;
        this.f6436k = null;
        this.f6437l = null;
        this.f6438m = Float.NaN;
        this.f6439n = Float.NaN;
        this.f6440o = Float.NaN;
        this.f6441p = Float.NaN;
        init(context, attributeSet);
    }

    public ImageFilterButton(Context context, AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
        this.f6426a = new ImageFilterView.c();
        this.f6427b = 0.0f;
        this.f6428c = 0.0f;
        this.f6429d = Float.NaN;
        this.f6433h = new Drawable[2];
        this.f6435j = true;
        this.f6436k = null;
        this.f6437l = null;
        this.f6438m = Float.NaN;
        this.f6439n = Float.NaN;
        this.f6440o = Float.NaN;
        this.f6441p = Float.NaN;
        init(context, attributeSet);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void c() {
        if (Float.isNaN(this.f6438m) && Float.isNaN(this.f6439n) && Float.isNaN(this.f6440o) && Float.isNaN(this.f6441p)) {
            return;
        }
        float f5 = Float.isNaN(this.f6438m) ? 0.0f : this.f6438m;
        float f6 = Float.isNaN(this.f6439n) ? 0.0f : this.f6439n;
        float f7 = Float.isNaN(this.f6440o) ? 1.0f : this.f6440o;
        float f8 = Float.isNaN(this.f6441p) ? 0.0f : this.f6441p;
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
        if (Float.isNaN(this.f6438m) && Float.isNaN(this.f6439n) && Float.isNaN(this.f6440o) && Float.isNaN(this.f6441p)) {
            setScaleType(ImageView.ScaleType.FIT_CENTER);
        } else {
            c();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void init(Context context, AttributeSet attributeSet) {
        setPadding(0, 0, 0, 0);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.ImageFilterView);
            int indexCount = obtainStyledAttributes.getIndexCount();
            this.f6436k = obtainStyledAttributes.getDrawable(R.styleable.ImageFilterView_altSrc);
            for (int i5 = 0; i5 < indexCount; i5++) {
                int index = obtainStyledAttributes.getIndex(i5);
                if (index == R.styleable.ImageFilterView_crossfade) {
                    this.f6427b = obtainStyledAttributes.getFloat(index, 0.0f);
                } else if (index == R.styleable.ImageFilterView_warmth) {
                    setWarmth(obtainStyledAttributes.getFloat(index, 0.0f));
                } else if (index == R.styleable.ImageFilterView_saturation) {
                    setSaturation(obtainStyledAttributes.getFloat(index, 0.0f));
                } else if (index == R.styleable.ImageFilterView_contrast) {
                    setContrast(obtainStyledAttributes.getFloat(index, 0.0f));
                } else if (index == R.styleable.ImageFilterView_round) {
                    setRound(obtainStyledAttributes.getDimension(index, 0.0f));
                } else if (index == R.styleable.ImageFilterView_roundPercent) {
                    setRoundPercent(obtainStyledAttributes.getFloat(index, 0.0f));
                } else if (index == R.styleable.ImageFilterView_overlay) {
                    setOverlay(obtainStyledAttributes.getBoolean(index, this.f6435j));
                } else if (index == R.styleable.ImageFilterView_imagePanX) {
                    setImagePanX(obtainStyledAttributes.getFloat(index, this.f6438m));
                } else if (index == R.styleable.ImageFilterView_imagePanY) {
                    setImagePanY(obtainStyledAttributes.getFloat(index, this.f6439n));
                } else if (index == R.styleable.ImageFilterView_imageRotate) {
                    setImageRotate(obtainStyledAttributes.getFloat(index, this.f6441p));
                } else if (index == R.styleable.ImageFilterView_imageZoom) {
                    setImageZoom(obtainStyledAttributes.getFloat(index, this.f6440o));
                }
            }
            obtainStyledAttributes.recycle();
            Drawable drawable = getDrawable();
            this.f6437l = drawable;
            if (this.f6436k == null || drawable == null) {
                Drawable drawable2 = getDrawable();
                this.f6437l = drawable2;
                if (drawable2 != null) {
                    Drawable[] drawableArr = this.f6433h;
                    Drawable mutate = drawable2.mutate();
                    this.f6437l = mutate;
                    drawableArr[0] = mutate;
                    return;
                }
                return;
            }
            Drawable[] drawableArr2 = this.f6433h;
            Drawable mutate2 = getDrawable().mutate();
            this.f6437l = mutate2;
            drawableArr2[0] = mutate2;
            this.f6433h[1] = this.f6436k.mutate();
            LayerDrawable layerDrawable = new LayerDrawable(this.f6433h);
            this.f6434i = layerDrawable;
            layerDrawable.getDrawable(1).setAlpha((int) (this.f6427b * 255.0f));
            if (!this.f6435j) {
                this.f6434i.getDrawable(0).setAlpha((int) ((1.0f - this.f6427b) * 255.0f));
            }
            super.setImageDrawable(this.f6434i);
        }
    }

    private void setOverlay(boolean z5) {
        this.f6435j = z5;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void draw(Canvas canvas) {
        super/*android.widget.ImageButton*/.draw(canvas);
    }

    public float getContrast() {
        return this.f6426a.f6467f;
    }

    public float getCrossfade() {
        return this.f6427b;
    }

    public float getImagePanX() {
        return this.f6438m;
    }

    public float getImagePanY() {
        return this.f6439n;
    }

    public float getImageRotate() {
        return this.f6441p;
    }

    public float getImageZoom() {
        return this.f6440o;
    }

    public float getRound() {
        return this.f6429d;
    }

    public float getRoundPercent() {
        return this.f6428c;
    }

    public float getSaturation() {
        return this.f6426a.f6466e;
    }

    public float getWarmth() {
        return this.f6426a.f6468g;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void layout(int i5, int i6, int i7, int i8) {
        super/*android.widget.ImageButton*/.layout(i5, i6, i7, i8);
        c();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setAltImageResource(int i5) {
        Drawable mutate = g.a.b(getContext(), i5).mutate();
        this.f6436k = mutate;
        Drawable[] drawableArr = this.f6433h;
        drawableArr[0] = this.f6437l;
        drawableArr[1] = mutate;
        LayerDrawable layerDrawable = new LayerDrawable(this.f6433h);
        this.f6434i = layerDrawable;
        super.setImageDrawable(layerDrawable);
        setCrossfade(this.f6427b);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setBrightness(float f5) {
        ImageFilterView.c cVar = this.f6426a;
        cVar.f6465d = f5;
        cVar.c(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setContrast(float f5) {
        ImageFilterView.c cVar = this.f6426a;
        cVar.f6467f = f5;
        cVar.c(this);
    }

    public void setCrossfade(float f5) {
        this.f6427b = f5;
        if (this.f6433h != null) {
            if (!this.f6435j) {
                this.f6434i.getDrawable(0).setAlpha((int) ((1.0f - this.f6427b) * 255.0f));
            }
            this.f6434i.getDrawable(1).setAlpha((int) (this.f6427b * 255.0f));
            super.setImageDrawable(this.f6434i);
        }
    }

    public void setImageDrawable(Drawable drawable) {
        if (this.f6436k == null || drawable == null) {
            super.setImageDrawable(drawable);
            return;
        }
        Drawable mutate = drawable.mutate();
        this.f6437l = mutate;
        Drawable[] drawableArr = this.f6433h;
        drawableArr[0] = mutate;
        drawableArr[1] = this.f6436k;
        LayerDrawable layerDrawable = new LayerDrawable(this.f6433h);
        this.f6434i = layerDrawable;
        super.setImageDrawable(layerDrawable);
        setCrossfade(this.f6427b);
    }

    public void setImagePanX(float f5) {
        this.f6438m = f5;
        d();
    }

    public void setImagePanY(float f5) {
        this.f6439n = f5;
        d();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setImageResource(int i5) {
        if (this.f6436k == null) {
            super.setImageResource(i5);
            return;
        }
        Drawable mutate = g.a.b(getContext(), i5).mutate();
        this.f6437l = mutate;
        Drawable[] drawableArr = this.f6433h;
        drawableArr[0] = mutate;
        drawableArr[1] = this.f6436k;
        LayerDrawable layerDrawable = new LayerDrawable(this.f6433h);
        this.f6434i = layerDrawable;
        super.setImageDrawable(layerDrawable);
        setCrossfade(this.f6427b);
    }

    public void setImageRotate(float f5) {
        this.f6441p = f5;
        d();
    }

    public void setImageZoom(float f5) {
        this.f6440o = f5;
        d();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setRound(float f5) {
        if (Float.isNaN(f5)) {
            this.f6429d = f5;
            float f6 = this.f6428c;
            this.f6428c = -1.0f;
            setRoundPercent(f6);
            return;
        }
        boolean z5 = this.f6429d != f5;
        this.f6429d = f5;
        if (f5 != 0.0f) {
            if (this.f6430e == null) {
                this.f6430e = new Path();
            }
            if (this.f6432g == null) {
                this.f6432g = new RectF();
            }
            if (this.f6431f == null) {
                b bVar = new b();
                this.f6431f = bVar;
                setOutlineProvider(bVar);
            }
            setClipToOutline(true);
            this.f6432g.set(0.0f, 0.0f, getWidth(), getHeight());
            this.f6430e.reset();
            Path path = this.f6430e;
            RectF rectF = this.f6432g;
            float f7 = this.f6429d;
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
        boolean z5 = this.f6428c != f5;
        this.f6428c = f5;
        if (f5 != 0.0f) {
            if (this.f6430e == null) {
                this.f6430e = new Path();
            }
            if (this.f6432g == null) {
                this.f6432g = new RectF();
            }
            if (this.f6431f == null) {
                a aVar = new a();
                this.f6431f = aVar;
                setOutlineProvider(aVar);
            }
            setClipToOutline(true);
            int width = getWidth();
            int height = getHeight();
            float min = (Math.min(width, height) * this.f6428c) / 2.0f;
            this.f6432g.set(0.0f, 0.0f, width, height);
            this.f6430e.reset();
            this.f6430e.addRoundRect(this.f6432g, min, min, Path.Direction.CW);
        } else {
            setClipToOutline(false);
        }
        if (z5) {
            invalidateOutline();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setSaturation(float f5) {
        ImageFilterView.c cVar = this.f6426a;
        cVar.f6466e = f5;
        cVar.c(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setWarmth(float f5) {
        ImageFilterView.c cVar = this.f6426a;
        cVar.f6468g = f5;
        cVar.c(this);
    }
}
