package qr;

import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.transsion.shorttv.R;
import com.transsion.shorttv.base.widget.TnTextView;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class u implements f4.a {
    private final View a;
    public final AppCompatImageView b;
    public final LinearLayoutCompat c;
    public final TnTextView d;

    private u(View view, AppCompatImageView appCompatImageView, LinearLayoutCompat linearLayoutCompat, TnTextView tnTextView) {
        this.a = view;
        this.b = appCompatImageView;
        this.c = linearLayoutCompat;
        this.d = tnTextView;
    }

    public static u a(View view) {
        LinearLayoutCompat a;
        int i = R.id.iv_icon;
        AppCompatImageView a2 = f4.b.a(view, i);
        if (a2 != null && (a = f4.b.a(view, (i = R.id.ll_download_inner))) != null) {
            i = R.id.short_tv_tips;
            TnTextView tnTextView = (TnTextView) f4.b.a(view, i);
            if (tnTextView != null) {
                return new u(view, a2, a, tnTextView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public View getRoot() {
        return this.a;
    }
}
