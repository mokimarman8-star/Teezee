package androidx.media3.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class AspectRatioFrameLayout extends FrameLayout {
    public static final int RESIZE_MODE_FILL = 3;
    public static final int RESIZE_MODE_FIT = 0;
    public static final int RESIZE_MODE_FIXED_HEIGHT = 2;
    public static final int RESIZE_MODE_FIXED_WIDTH = 1;
    public static final int RESIZE_MODE_ZOOM = 4;

    /* renamed from: a, reason: collision with root package name */
    private final AspectRatioUpdateDispatcher f12107a;

    /* renamed from: b, reason: collision with root package name */
    private float f12108b;

    /* renamed from: c, reason: collision with root package name */
    private int f12109c;

    private final class AspectRatioUpdateDispatcher implements Runnable {
        private boolean aspectRatioMismatch;
        private boolean isScheduled;
        private float naturalAspectRatio;
        private float targetAspectRatio;

        private AspectRatioUpdateDispatcher() {
        }

        @Override // java.lang.Runnable
        public void run() {
            this.isScheduled = false;
            AspectRatioFrameLayout.a(AspectRatioFrameLayout.this);
        }

        public void scheduleUpdate(float f5, float f6, boolean z5) {
            this.targetAspectRatio = f5;
            this.naturalAspectRatio = f6;
            this.aspectRatioMismatch = z5;
            if (this.isScheduled) {
                return;
            }
            this.isScheduled = true;
            AspectRatioFrameLayout.this.post(this);
        }
    }

    public interface b {
    }

    public AspectRatioFrameLayout(Context context) {
        this(context, null);
    }

    public AspectRatioFrameLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f12109c = 0;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R$styleable.AspectRatioFrameLayout, 0, 0);
            try {
                this.f12109c = obtainStyledAttributes.getInt(R$styleable.AspectRatioFrameLayout_resize_mode, 0);
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
        this.f12107a = new AspectRatioUpdateDispatcher();
    }

    static /* synthetic */ b a(AspectRatioFrameLayout aspectRatioFrameLayout) {
        aspectRatioFrameLayout.getClass();
        return null;
    }

    public int getResizeMode() {
        return this.f12109c;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i5, int i6) {
        float f5;
        float f6;
        super.onMeasure(i5, i6);
        if (this.f12108b <= 0.0f) {
            return;
        }
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        float f7 = measuredWidth;
        float f8 = measuredHeight;
        float f9 = f7 / f8;
        float f10 = (this.f12108b / f9) - 1.0f;
        if (Math.abs(f10) <= 0.01f) {
            this.f12107a.scheduleUpdate(this.f12108b, f9, false);
            return;
        }
        int i7 = this.f12109c;
        if (i7 != 0) {
            if (i7 != 1) {
                if (i7 == 2) {
                    f5 = this.f12108b;
                } else if (i7 == 4) {
                    if (f10 > 0.0f) {
                        f5 = this.f12108b;
                    } else {
                        f6 = this.f12108b;
                    }
                }
                measuredWidth = (int) (f8 * f5);
            } else {
                f6 = this.f12108b;
            }
            measuredHeight = (int) (f7 / f6);
        } else if (f10 > 0.0f) {
            f6 = this.f12108b;
            measuredHeight = (int) (f7 / f6);
        } else {
            f5 = this.f12108b;
            measuredWidth = (int) (f8 * f5);
        }
        this.f12107a.scheduleUpdate(this.f12108b, f9, true);
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824));
    }

    public void setAspectRatio(float f5) {
        if (this.f12108b != f5) {
            this.f12108b = f5;
            requestLayout();
        }
    }

    public void setAspectRatioListener(@Nullable b bVar) {
    }

    public void setResizeMode(int i5) {
        if (this.f12109c != i5) {
            this.f12109c = i5;
            requestLayout();
        }
    }
}
