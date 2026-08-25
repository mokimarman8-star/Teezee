package com.transsion.baseui.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.text.style.ImageSpan;
import android.view.ViewTreeObserver;
import android.widget.TextView;
import com.transsion.baseui.widget.c;
import java.lang.ref.WeakReference;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class c extends ImageSpan {
    private final TextView a;
    private final int b;
    private final WeakReference c;
    private Animatable d;
    private Rect e;
    private final Handler f;
    private Runnable g;
    private boolean h;
    private final a i;
    private ViewTreeObserver j;
    private final ViewTreeObserver.OnPreDrawListener k;

    public static final class a implements Drawable.Callback {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Code restructure failed: missing block: B:11:0x001e, code lost:
        
            if (r0 == null) goto L13;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public static final void b(c cVar) {
            Unit unit;
            if (cVar.h) {
                cVar.g = null;
                return;
            }
            Rect rect = cVar.e;
            if (rect != null) {
                TextView textView = cVar.a;
                if (textView != null) {
                    textView.invalidate(rect);
                    unit = Unit.a;
                } else {
                    unit = null;
                }
            }
            TextView textView2 = cVar.a;
            if (textView2 != null) {
                textView2.invalidate();
                Unit unit2 = Unit.a;
            }
            cVar.g = null;
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void invalidateDrawable(Drawable drawable) {
            Intrinsics.h(drawable, "who");
            if (c.this.h) {
                return;
            }
            Runnable runnable = c.this.g;
            if (runnable != null) {
                c.this.f.removeCallbacks(runnable);
            }
            final c cVar = c.this;
            cVar.g = new Runnable() { // from class: com.transsion.baseui.widget.b
                @Override // java.lang.Runnable
                public final void run() {
                    c.a.b(c.this);
                }
            };
            Handler handler = c.this.f;
            Runnable runnable2 = c.this.g;
            Intrinsics.e(runnable2);
            handler.postDelayed(runnable2, 16L);
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
            Intrinsics.h(drawable, "who");
            Intrinsics.h(runnable, "what");
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
            Intrinsics.h(drawable, "who");
            Intrinsics.h(runnable, "what");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public c(Drawable drawable, TextView textView, int i, int i2) {
        super(drawable, i);
        Intrinsics.h(drawable, "drawable");
        this.a = textView;
        this.b = i2;
        this.c = new WeakReference(drawable);
        this.f = new Handler(Looper.getMainLooper());
        a aVar = new a();
        this.i = aVar;
        this.k = new ViewTreeObserver.OnPreDrawListener() { // from class: com.transsion.baseui.widget.a
            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public final boolean onPreDraw() {
                boolean i3;
                i3 = c.i(c.this);
                return i3;
            }
        };
        if (drawable instanceof Animatable) {
            this.d = (Animatable) drawable;
            drawable.setCallback(aVar);
            l();
            j();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void h(Drawable drawable) {
        if (drawable instanceof Animatable) {
            if (!Intrinsics.c(drawable.getCallback(), this.i)) {
                drawable.setCallback(this.i);
            }
            Animatable animatable = (Animatable) drawable;
            if (animatable.isRunning()) {
                return;
            }
            animatable.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final boolean i(c cVar) {
        TextView textView;
        Drawable drawable = (Drawable) cVar.c.get();
        if (!(drawable instanceof Animatable) || ((Animatable) drawable).isRunning() || cVar.h || (textView = cVar.a) == null || textView.getVisibility() != 0 || !cVar.a.isShown()) {
            return true;
        }
        cVar.h(drawable);
        return true;
    }

    private final void j() {
        ViewTreeObserver viewTreeObserver;
        TextView textView = this.a;
        if (textView == null || (viewTreeObserver = textView.getViewTreeObserver()) == null) {
            return;
        }
        if (!viewTreeObserver.isAlive()) {
            viewTreeObserver = null;
        }
        if (viewTreeObserver != null) {
            this.j = viewTreeObserver;
            viewTreeObserver.addOnPreDrawListener(this.k);
        }
    }

    private final void l() {
        TextView textView;
        Object obj = (Drawable) this.c.get();
        if ((obj instanceof Animatable) && (textView = this.a) != null && textView.getVisibility() == 0 && this.a.isShown()) {
            Animatable animatable = (Animatable) obj;
            if (animatable.isRunning()) {
                return;
            }
            animatable.start();
        }
    }

    private final void n() {
        ViewTreeObserver viewTreeObserver = this.j;
        if (viewTreeObserver != null) {
            if (!viewTreeObserver.isAlive()) {
                viewTreeObserver = null;
            }
            if (viewTreeObserver != null) {
                viewTreeObserver.removeOnPreDrawListener(this.k);
            }
        }
        this.j = null;
    }

    private final void o(float f, int i, int i2, int i3, Paint paint, Drawable drawable) {
        int i4;
        int verticalAlignment = getVerticalAlignment();
        if (verticalAlignment == 0) {
            i4 = i3 - drawable.getBounds().bottom;
        } else if (verticalAlignment != 1) {
            Paint.FontMetricsInt fontMetricsInt = paint.getFontMetricsInt();
            int i5 = fontMetricsInt.descent;
            i4 = ((i2 + i5) - ((i5 - fontMetricsInt.ascent) / 2)) - (drawable.getBounds().height() / 2);
        } else {
            i4 = (i2 - drawable.getBounds().bottom) + paint.getFontMetricsInt().descent;
        }
        int i6 = (int) f;
        this.e = new Rect(i6, i4, drawable.getBounds().width() + i6, drawable.getBounds().height() + i4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
        int i6;
        Intrinsics.h(canvas, "canvas");
        Intrinsics.h(charSequence, "text");
        Intrinsics.h(paint, "paint");
        Drawable drawable = (Drawable) this.c.get();
        if (drawable == 0) {
            return;
        }
        if (this.h) {
            o(f, i3, i4, i5, paint, drawable);
            return;
        }
        o(f, i3, i4, i5, paint, drawable);
        if (drawable instanceof Animatable) {
            TextView textView = this.a;
            boolean z = textView != null && textView.getVisibility() == 0 && this.a.isShown();
            if (z && !Intrinsics.c(drawable.getCallback(), this.i)) {
                drawable.setCallback(this.i);
            }
            if (z) {
                Animatable animatable = (Animatable) drawable;
                if (!animatable.isRunning()) {
                    animatable.start();
                }
            }
            if (!z) {
                Animatable animatable2 = (Animatable) drawable;
                if (animatable2.isRunning()) {
                    animatable2.stop();
                }
            }
        }
        canvas.save();
        int verticalAlignment = getVerticalAlignment();
        if (verticalAlignment == 0) {
            i6 = i5 - drawable.getBounds().bottom;
        } else if (verticalAlignment != 1) {
            Paint.FontMetricsInt fontMetricsInt = paint.getFontMetricsInt();
            int i7 = fontMetricsInt.descent;
            i6 = ((i4 + i7) - ((i7 - fontMetricsInt.ascent) / 2)) - (drawable.getBounds().height() / 2);
        } else {
            i6 = (i4 - drawable.getBounds().bottom) + paint.getFontMetricsInt().descent;
        }
        canvas.translate(f, i6);
        drawable.draw(canvas);
        canvas.restore();
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence charSequence, int i, int i2, Paint.FontMetricsInt fontMetricsInt) {
        Intrinsics.h(paint, "paint");
        Intrinsics.h(charSequence, "text");
        Drawable drawable = (Drawable) this.c.get();
        if (drawable == null) {
            return 0;
        }
        Rect bounds = drawable.getBounds();
        Intrinsics.g(bounds, "getBounds(...)");
        if (fontMetricsInt != null) {
            Paint.FontMetricsInt fontMetricsInt2 = paint.getFontMetricsInt();
            int verticalAlignment = getVerticalAlignment();
            if (verticalAlignment == 0 || verticalAlignment == 1) {
                fontMetricsInt.ascent = fontMetricsInt2.ascent;
                fontMetricsInt.descent = fontMetricsInt2.descent;
                fontMetricsInt.top = fontMetricsInt2.top;
                fontMetricsInt.bottom = fontMetricsInt2.bottom;
            } else {
                int height = bounds.height() / 2;
                int i3 = (fontMetricsInt2.descent - fontMetricsInt2.ascent) / 4;
                int i4 = (-height) - i3;
                fontMetricsInt.ascent = i4;
                fontMetricsInt.top = i4;
                int i5 = height - i3;
                fontMetricsInt.bottom = i5;
                fontMetricsInt.descent = i5;
            }
        }
        return bounds.right + this.b;
    }

    public final void k() {
        this.h = false;
        Drawable drawable = (Drawable) this.c.get();
        if (drawable != null && !Intrinsics.c(drawable.getCallback(), this.i)) {
            drawable.setCallback(this.i);
        }
        l();
        j();
    }

    public final void m() {
        this.h = true;
        Runnable runnable = this.g;
        if (runnable != null) {
            this.f.removeCallbacks(runnable);
            this.g = null;
        }
        n();
        Animatable animatable = this.d;
        if (animatable != null) {
            animatable.stop();
        }
        Drawable drawable = (Drawable) this.c.get();
        if (drawable == null || !Intrinsics.c(drawable.getCallback(), this.i)) {
            return;
        }
        drawable.setCallback(null);
    }
}
