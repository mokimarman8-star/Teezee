package k0;

import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Build;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class l0 {
    private static final void a(Rect rect, Rect rect2) {
        rect.right += rect2.width();
        rect.top = Math.min(rect.top, rect2.top);
        rect.bottom = Math.max(rect.bottom, rect2.bottom);
    }

    private static final void b(Paint paint, CharSequence charSequence, int i5, int i6, Rect rect) {
        if (Build.VERSION.SDK_INT >= 29) {
            k0.a(paint, charSequence, i5, i6, rect);
        } else {
            paint.getTextBounds(charSequence.toString(), i5, i6, rect);
        }
    }

    public static final Rect c(TextPaint textPaint, CharSequence charSequence, int i5, int i6) {
        if (charSequence instanceof Spanned) {
            Spanned spanned = (Spanned) charSequence;
            if (m0.b(spanned, MetricAffectingSpan.class, i5, i6)) {
                Rect rect = new Rect();
                Rect rect2 = new Rect();
                TextPaint textPaint2 = new TextPaint();
                while (i5 < i6) {
                    int nextSpanTransition = spanned.nextSpanTransition(i5, i6, MetricAffectingSpan.class);
                    MetricAffectingSpan[] metricAffectingSpanArr = (MetricAffectingSpan[]) spanned.getSpans(i5, nextSpanTransition, MetricAffectingSpan.class);
                    textPaint2.set(textPaint);
                    for (MetricAffectingSpan metricAffectingSpan : metricAffectingSpanArr) {
                        if (spanned.getSpanStart(metricAffectingSpan) != spanned.getSpanEnd(metricAffectingSpan)) {
                            metricAffectingSpan.updateMeasureState(textPaint2);
                        }
                    }
                    b(textPaint2, charSequence, i5, nextSpanTransition, rect2);
                    a(rect, rect2);
                    i5 = nextSpanTransition;
                }
                return rect;
            }
        }
        return d(textPaint, charSequence, i5, i6);
    }

    public static final Rect d(Paint paint, CharSequence charSequence, int i5, int i6) {
        Rect rect = new Rect();
        b(paint, charSequence, i5, i6, rect);
        return rect;
    }
}
