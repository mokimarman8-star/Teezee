package sh;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import com.transsion.ad.R$id;
import com.transsion.ad.R$layout;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public final class w implements f4.a {
    private final LinearLayout a;
    public final Button b;

    private w(LinearLayout linearLayout, Button button) {
        this.a = linearLayout;
        this.b = button;
    }

    public static w a(View view) {
        int i = R$id.btnLoadSplashAd;
        Button button = (Button) f4.b.a(view, i);
        if (button != null) {
            return new w((LinearLayout) view, button);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static w c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static w d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R$layout.activity_test_ad_splash_layout, viewGroup, false);
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
