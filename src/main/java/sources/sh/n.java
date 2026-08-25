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
public final class n implements f4.a {
    private final LinearLayout a;
    public final Button b;
    public final NativeWrapperAdView c;
    public final NativeWrapperAdView d;
    public final NativeWrapperAdView e;

    private n(LinearLayout linearLayout, Button button, NativeWrapperAdView nativeWrapperAdView, NativeWrapperAdView nativeWrapperAdView2, NativeWrapperAdView nativeWrapperAdView3) {
        this.a = linearLayout;
        this.b = button;
        this.c = nativeWrapperAdView;
        this.d = nativeWrapperAdView2;
        this.e = nativeWrapperAdView3;
    }

    public static n a(View view) {
        NativeWrapperAdView a;
        NativeWrapperAdView a2;
        NativeWrapperAdView a3;
        int i = R$id.btnLoadNativeAd;
        Button button = (Button) f4.b.a(view, i);
        if (button == null || (a = f4.b.a(view, (i = R$id.nativeView1))) == null || (a2 = f4.b.a(view, (i = R$id.nativeView2))) == null || (a3 = f4.b.a(view, (i = R$id.nativeView3))) == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }
        return new n((LinearLayout) view, button, a, a2, a3);
    }

    public static n c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static n d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R$layout.activity_test_ad_multiple_layout, viewGroup, false);
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
