package sh;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.transsion.ad.R$id;
import com.transsion.ad.R$layout;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public final class i implements f4.a {
    private final LinearLayout a;
    public final Button b;
    public final FrameLayout c;

    private i(LinearLayout linearLayout, Button button, FrameLayout frameLayout) {
        this.a = linearLayout;
        this.b = button;
        this.c = frameLayout;
    }

    public static i a(View view) {
        int i = R$id.btnLoadBannerAd;
        Button button = (Button) f4.b.a(view, i);
        if (button != null) {
            i = R$id.flBannerContainer;
            FrameLayout frameLayout = (FrameLayout) f4.b.a(view, i);
            if (frameLayout != null) {
                return new i((LinearLayout) view, button, frameLayout);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static i c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static i d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R$layout.activity_test_ad_banner_layout, viewGroup, false);
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
