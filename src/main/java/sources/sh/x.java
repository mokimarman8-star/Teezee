package sh;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import com.transsion.ad.R$id;
import com.transsion.ad.R$layout;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public final class x implements f4.a {
    private final LinearLayout a;
    public final Button b;

    private x(LinearLayout linearLayout, Button button) {
        this.a = linearLayout;
        this.b = button;
    }

    public static x a(View view) {
        int i = R$id.btnLoadVideoAd;
        Button button = (Button) f4.b.a(view, i);
        if (button != null) {
            return new x((LinearLayout) view, button);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static x c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static x d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R$layout.activity_test_ad_video_layout, viewGroup, false);
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
