package sh;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import com.transsion.ad.R$id;
import com.transsion.ad.R$layout;
import com.transsion.ad.view.native_ad.NativeWrapperAdView;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public final class o implements f4.a {
    private final LinearLayout a;
    public final Button b;
    public final NativeWrapperAdView c;

    private o(LinearLayout linearLayout, Button button, NativeWrapperAdView nativeWrapperAdView) {
        this.a = linearLayout;
        this.b = button;
        this.c = nativeWrapperAdView;
    }

    public static o a(View view) {
        NativeWrapperAdView a;
        int i = R$id.btnLoadNativeAd;
        Button button = (Button) f4.b.a(view, i);
        if (button == null || (a = f4.b.a(view, (i = R$id.nativeView))) == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }
        return new o((LinearLayout) view, button, a);
    }

    public static o c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static o d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R$layout.activity_test_ad_native_layout, viewGroup, false);
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
