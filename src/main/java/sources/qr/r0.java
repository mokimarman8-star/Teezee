package qr;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import com.transsion.shorttv.R;
import com.transsion.shorttv.base.widget.TnTextView;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class r0 implements f4.a {
    private final View a;
    public final TnTextView b;
    public final AppCompatImageView c;
    public final AppCompatImageView d;
    public final TnTextView e;
    public final TnTextView f;
    public final TnTextView g;

    private r0(View view, TnTextView tnTextView, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, TnTextView tnTextView2, TnTextView tnTextView3, TnTextView tnTextView4) {
        this.a = view;
        this.b = tnTextView;
        this.c = appCompatImageView;
        this.d = appCompatImageView2;
        this.e = tnTextView2;
        this.f = tnTextView3;
        this.g = tnTextView4;
    }

    public static r0 a(View view) {
        AppCompatImageView a;
        AppCompatImageView a2;
        int i = R.id.go_to_setting;
        TnTextView tnTextView = (TnTextView) f4.b.a(view, i);
        if (tnTextView != null && (a = f4.b.a(view, (i = R.id.iv_back))) != null && (a2 = f4.b.a(view, (i = R.id.iv_no_connection))) != null) {
            i = R.id.no_connection_title;
            TnTextView tnTextView2 = (TnTextView) f4.b.a(view, i);
            if (tnTextView2 != null) {
                i = R.id.retry;
                TnTextView tnTextView3 = (TnTextView) f4.b.a(view, i);
                if (tnTextView3 != null) {
                    i = R.id.tv_title;
                    TnTextView tnTextView4 = (TnTextView) f4.b.a(view, i);
                    if (tnTextView4 != null) {
                        return new r0(view, tnTextView, a, a2, tnTextView2, tnTextView3, tnTextView4);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static r0 b(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        if (viewGroup == null) {
            throw new NullPointerException("parent");
        }
        layoutInflater.inflate(R.layout.short_tv_view_content_no_connection, viewGroup);
        return a(viewGroup);
    }

    public View getRoot() {
        return this.a;
    }
}
