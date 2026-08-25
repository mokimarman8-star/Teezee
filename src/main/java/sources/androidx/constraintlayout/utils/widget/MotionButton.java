package androidx.constraintlayout.utils.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Outline;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.appcompat.widget.AppCompatButton;
import androidx.constraintlayout.widget.R;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public class MotionButton extends AppCompatButton {

    /* renamed from: a, reason: collision with root package name */
    private float f6480a;

    /* renamed from: b, reason: collision with root package name */
    private float f6481b;

    /* renamed from: c, reason: collision with root package name */
    private Path f6482c;

    /* renamed from: d, reason: collision with root package name */
    ViewOutlineProvider f6483d;

    /* renamed from: e, reason: collision with root package name */
    RectF f6484e;

    class a extends ViewOutlineProvider {
        a() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            outline.setRoundRect(0, 0, MotionButton.this.getWidth(), MotionButton.this.getHeight(), (Math.min(r3, r4) * MotionButton.this.f6480a) / 2.0f);
        }
    }

    class b extends ViewOutlineProvider {
        b() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            outline.setRoundRect(0, 0, MotionButton.this.getWidth(), MotionButton.this.getHeight(), MotionButton.this.f6481b);
        }
    }

    public MotionButton(Context context) {
        super(context);
        this.f6480a = 0.0f;
        this.f6481b = Float.NaN;
        init(context, null);
    }

    public MotionButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f6480a = 0.0f;
        this.f6481b = Float.NaN;
        init(context, attributeSet);
    }

    public MotionButton(Context context, AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
        this.f6480a = 0.0f;
        this.f6481b = Float.NaN;
        init(context, attributeSet);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void init(Context context, AttributeSet attributeSet) {
        setPadding(0, 0, 0, 0);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.ImageFilterView);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i5 = 0; i5 < indexCount; i5++) {
                int index = obtainStyledAttributes.getIndex(i5);
                if (index == R.styleable.ImageFilterView_round) {
                    setRound(obtainStyledAttributes.getDimension(index, 0.0f));
                } else if (index == R.styleable.ImageFilterView_roundPercent) {
                    setRoundPercent(obtainStyledAttributes.getFloat(index, 0.0f));
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void draw(Canvas canvas) {
        super/*android.widget.Button*/.draw(canvas);
    }

    public float getRound() {
        return this.f6481b;
    }

    public float getRoundPercent() {
        return this.f6480a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setRound(float f5) {
        if (Float.isNaN(f5)) {
            this.f6481b = f5;
            float f6 = this.f6480a;
            this.f6480a = -1.0f;
            setRoundPercent(f6);
            return;
        }
        boolean z5 = this.f6481b != f5;
        this.f6481b = f5;
        if (f5 != 0.0f) {
            if (this.f6482c == null) {
                this.f6482c = new Path();
            }
            if (this.f6484e == null) {
                this.f6484e = new RectF();
            }
            if (this.f6483d == null) {
                b bVar = new b();
                this.f6483d = bVar;
                setOutlineProvider(bVar);
            }
            setClipToOutline(true);
            this.f6484e.set(0.0f, 0.0f, getWidth(), getHeight());
            this.f6482c.reset();
            Path path = this.f6482c;
            RectF rectF = this.f6484e;
            float f7 = this.f6481b;
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
        boolean z5 = this.f6480a != f5;
        this.f6480a = f5;
        if (f5 != 0.0f) {
            if (this.f6482c == null) {
                this.f6482c = new Path();
            }
            if (this.f6484e == null) {
                this.f6484e = new RectF();
            }
            if (this.f6483d == null) {
                a aVar = new a();
                this.f6483d = aVar;
                setOutlineProvider(aVar);
            }
            setClipToOutline(true);
            int width = getWidth();
            int height = getHeight();
            float min = (Math.min(width, height) * this.f6480a) / 2.0f;
            this.f6484e.set(0.0f, 0.0f, width, height);
            this.f6482c.reset();
            this.f6482c.addRoundRect(this.f6484e, min, min, Path.Direction.CW);
        } else {
            setClipToOutline(false);
        }
        if (z5) {
            invalidateOutline();
        }
    }
}
