package qr;

import android.view.View;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.transsion.shorttv.R;
import com.transsion.shorttv.base.widget.TnTextView;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class g0 implements f4.a {
    private final LinearLayoutCompat a;
    public final TnTextView b;
    public final TnTextView c;
    public final TnTextView d;

    private g0(LinearLayoutCompat linearLayoutCompat, TnTextView tnTextView, TnTextView tnTextView2, TnTextView tnTextView3) {
        this.a = linearLayoutCompat;
        this.b = tnTextView;
        this.c = tnTextView2;
        this.d = tnTextView3;
    }

    public static g0 a(View view) {
        int i = R.id.iv_all;
        TnTextView tnTextView = (TnTextView) f4.b.a(view, i);
        if (tnTextView != null) {
            i = R.id.iv_hottest;
            TnTextView tnTextView2 = (TnTextView) f4.b.a(view, i);
            if (tnTextView2 != null) {
                i = R.id.iv_latest;
                TnTextView tnTextView3 = (TnTextView) f4.b.a(view, i);
                if (tnTextView3 != null) {
                    return new g0((LinearLayoutCompat) view, tnTextView, tnTextView2, tnTextView3);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayoutCompat getRoot() {
        return this.a;
    }
}
