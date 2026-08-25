package u1;

import android.text.Spannable;
import android.text.style.RelativeSizeSpan;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class g {
    public static void a(Spannable spannable, float f5, int i5, int i6, int i7) {
        for (RelativeSizeSpan relativeSizeSpan : (RelativeSizeSpan[]) spannable.getSpans(i5, i6, RelativeSizeSpan.class)) {
            if (spannable.getSpanStart(relativeSizeSpan) <= i5 && spannable.getSpanEnd(relativeSizeSpan) >= i6) {
                f5 *= relativeSizeSpan.getSizeChange();
            }
            c(spannable, relativeSizeSpan, i5, i6, i7);
        }
        spannable.setSpan(new RelativeSizeSpan(f5), i5, i6, i7);
    }

    public static void b(Spannable spannable, Object obj, int i5, int i6, int i7) {
        for (Object obj2 : spannable.getSpans(i5, i6, obj.getClass())) {
            c(spannable, obj2, i5, i6, i7);
        }
        spannable.setSpan(obj, i5, i6, i7);
    }

    private static void c(Spannable spannable, Object obj, int i5, int i6, int i7) {
        if (spannable.getSpanStart(obj) == i5 && spannable.getSpanEnd(obj) == i6 && spannable.getSpanFlags(obj) == i7) {
            spannable.removeSpan(obj);
        }
    }
}
