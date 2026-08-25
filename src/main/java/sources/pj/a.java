package pj;

import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.style.ClickableSpan;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class a implements View.OnTouchListener {
    private Spannable a;

    public a(Spannable spannable) {
        this.a = spannable;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        Intrinsics.h(view, "textView");
        Intrinsics.h(motionEvent, "event");
        int action = motionEvent.getAction();
        if (!(view instanceof TextView)) {
            return false;
        }
        if (action == 0 || action == 1) {
            float x = motionEvent.getX();
            float totalPaddingLeft = (x - r4.getTotalPaddingLeft()) + view.getScrollX();
            float y = (motionEvent.getY() - r4.getTotalPaddingTop()) + view.getScrollY();
            Layout layout = ((TextView) view).getLayout();
            Intrinsics.g(layout, "getLayout(...)");
            int offsetForHorizontal = layout.getOffsetForHorizontal(layout.getLineForVertical((int) y), totalPaddingLeft);
            Spannable spannable = this.a;
            ClickableSpan[] clickableSpanArr = spannable != null ? (ClickableSpan[]) spannable.getSpans(offsetForHorizontal, offsetForHorizontal, ClickableSpan.class) : null;
            if (!(clickableSpanArr.length == 0)) {
                if (action == 0) {
                    Spannable spannable2 = this.a;
                    if (spannable2 != null) {
                        int spanStart = spannable2.getSpanStart(clickableSpanArr[0]);
                        Spannable spannable3 = this.a;
                        if (spannable3 != null) {
                            try {
                                Selection.setSelection(this.a, spanStart, spannable3.getSpanEnd(clickableSpanArr[0]));
                            } catch (Throwable unused) {
                            }
                        }
                    }
                } else if (action == 1) {
                    clickableSpanArr[0].onClick(view);
                }
                return true;
            }
            Selection.removeSelection(this.a);
        }
        return false;
    }
}
