package jj;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.noober.background.view.BLTextView;
import com.transsion.baseui.R;
import com.transsion.baseui.widget.DrawableCenterTextView;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class g implements f4.a {
    private final FrameLayout a;
    public final TextView b;
    public final BLTextView c;
    public final TextView d;
    public final DrawableCenterTextView e;
    public final TextView f;

    private g(FrameLayout frameLayout, TextView textView, BLTextView bLTextView, TextView textView2, DrawableCenterTextView drawableCenterTextView, TextView textView3) {
        this.a = frameLayout;
        this.b = textView;
        this.c = bLTextView;
        this.d = textView2;
        this.e = drawableCenterTextView;
        this.f = textView3;
    }

    public static g a(View view) {
        BLTextView a;
        int i = R.id.card_detail;
        TextView textView = (TextView) f4.b.a(view, i);
        if (textView != null && (a = f4.b.a(view, (i = R.id.card_tip))) != null) {
            i = R.id.card_title;
            TextView textView2 = (TextView) f4.b.a(view, i);
            if (textView2 != null) {
                i = R.id.iv_centerView;
                DrawableCenterTextView drawableCenterTextView = (DrawableCenterTextView) f4.b.a(view, i);
                if (drawableCenterTextView != null) {
                    i = R.id.numText;
                    TextView textView3 = (TextView) f4.b.a(view, i);
                    if (textView3 != null) {
                        return new g((FrameLayout) view, textView, a, textView2, drawableCenterTextView, textView3);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.a;
    }
}
