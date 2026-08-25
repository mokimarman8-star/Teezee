package qr;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import com.transsion.shorttv.R;
import com.transsion.shorttv_pugc.base.widget.TnTextView;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class k implements f4.a {
    private final View a;
    public final TnTextView b;
    public final AppCompatImageView c;
    public final AppCompatImageView d;
    public final TnTextView e;
    public final TnTextView f;
    public final TnTextView g;

    private k(View view, TnTextView tnTextView, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, TnTextView tnTextView2, TnTextView tnTextView3, TnTextView tnTextView4) {
        this.a = view;
        this.b = tnTextView;
        this.c = appCompatImageView;
        this.d = appCompatImageView2;
        this.e = tnTextView2;
        this.f = tnTextView3;
        this.g = tnTextView4;
    }

    public static k a(View view) {
        AppCompatImageView a;
        AppCompatImageView a2;
        TnTextView a3;
        TnTextView a4;
        TnTextView a5;
        int i = R.id.go_to_setting;
        TnTextView a6 = f4.b.a(view, i);
        if (a6 == null || (a = f4.b.a(view, (i = R.id.iv_back))) == null || (a2 = f4.b.a(view, (i = R.id.iv_no_connection))) == null || (a3 = f4.b.a(view, (i = R.id.no_connection_title))) == null || (a4 = f4.b.a(view, (i = R.id.retry))) == null || (a5 = f4.b.a(view, (i = R.id.tv_title))) == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }
        return new k(view, a6, a, a2, a3, a4, a5);
    }

    public static k b(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        if (viewGroup == null) {
            throw new NullPointerException("parent");
        }
        layoutInflater.inflate(R.layout.pugc_short_tv_view_content_no_connection, viewGroup);
        return a(viewGroup);
    }

    public View getRoot() {
        return this.a;
    }
}
