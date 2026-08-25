package qr;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.transsion.shorttv.R;
import com.transsion.shorttv.ui.widget.ShortTVBannerView;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class q0 implements f4.a {
    private final ConstraintLayout a;
    public final ShortTVBannerView b;
    public final ConstraintLayout c;
    public final View d;
    public final View e;
    public final View f;

    private q0(ConstraintLayout constraintLayout, ShortTVBannerView shortTVBannerView, ConstraintLayout constraintLayout2, View view, View view2, View view3) {
        this.a = constraintLayout;
        this.b = shortTVBannerView;
        this.c = constraintLayout2;
        this.d = view;
        this.e = view2;
        this.f = view3;
    }

    public static q0 a(View view) {
        View a;
        View a2;
        int i = R.id.banner;
        ShortTVBannerView a3 = f4.b.a(view, i);
        if (a3 != null) {
            ConstraintLayout constraintLayout = (ConstraintLayout) view;
            i = R.id.v_banner_bg;
            View a4 = f4.b.a(view, i);
            if (a4 != null && (a = f4.b.a(view, (i = R.id.v_bar_space))) != null && (a2 = f4.b.a(view, (i = R.id.v_top_space))) != null) {
                return new q0(constraintLayout, a3, constraintLayout, a4, a, a2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static q0 c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static q0 d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.short_tv_view_banner, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.a;
    }
}
