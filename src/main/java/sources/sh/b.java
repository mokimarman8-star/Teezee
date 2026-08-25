package sh;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import com.transsion.ad.R$id;
import com.transsion.ad.R$layout;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public final class b implements f4.a {
    private final LinearLayout a;
    public final AppCompatImageView b;
    public final FrameLayout c;

    private b(LinearLayout linearLayout, AppCompatImageView appCompatImageView, FrameLayout frameLayout) {
        this.a = linearLayout;
        this.b = appCompatImageView;
        this.c = frameLayout;
    }

    public static b a(View view) {
        int i = R$id.ivClose;
        AppCompatImageView a = f4.b.a(view, i);
        if (a != null) {
            i = R$id.mediaContain;
            FrameLayout frameLayout = (FrameLayout) f4.b.a(view, i);
            if (frameLayout != null) {
                return new b((LinearLayout) view, a, frameLayout);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static b c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static b d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R$layout.activity_bidding_buy_out_interstitial_action_layout, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.a;
    }
}
