package sh;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ScrollView;
import com.transsion.ad.R$id;
import com.transsion.ad.R$layout;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public final class h implements f4.a {
    private final ScrollView a;
    public final Button b;
    public final Button c;
    public final Button d;
    public final Button e;
    public final Button f;
    public final Button g;
    public final Button h;
    public final Button i;
    public final Button j;
    public final Button k;
    public final Button l;

    private h(ScrollView scrollView, Button button, Button button2, Button button3, Button button4, Button button5, Button button6, Button button7, Button button8, Button button9, Button button10, Button button11) {
        this.a = scrollView;
        this.b = button;
        this.c = button2;
        this.d = button3;
        this.e = button4;
        this.f = button5;
        this.g = button6;
        this.h = button7;
        this.i = button8;
        this.j = button9;
        this.k = button10;
        this.l = button11;
    }

    public static h a(View view) {
        int i = R$id.btnIconAd;
        Button button = (Button) f4.b.a(view, i);
        if (button != null) {
            i = R$id.btnIrregularAd;
            Button button2 = (Button) f4.b.a(view, i);
            if (button2 != null) {
                i = R$id.btnLoadBannerAd;
                Button button3 = (Button) f4.b.a(view, i);
                if (button3 != null) {
                    i = R$id.btnLoadInterstitialAd;
                    Button button4 = (Button) f4.b.a(view, i);
                    if (button4 != null) {
                        i = R$id.btnLoadNativeAd;
                        Button button5 = (Button) f4.b.a(view, i);
                        if (button5 != null) {
                            i = R$id.btnLoadNativeAdMultipleFetch;
                            Button button6 = (Button) f4.b.a(view, i);
                            if (button6 != null) {
                                i = R$id.btnLoadNativeListAd;
                                Button button7 = (Button) f4.b.a(view, i);
                                if (button7 != null) {
                                    i = R$id.btnLoadSSPNativeAdFetch;
                                    Button button8 = (Button) f4.b.a(view, i);
                                    if (button8 != null) {
                                        i = R$id.btnLoadSplashAd;
                                        Button button9 = (Button) f4.b.a(view, i);
                                        if (button9 != null) {
                                            i = R$id.btnLoadVideoAd;
                                            Button button10 = (Button) f4.b.a(view, i);
                                            if (button10 != null) {
                                                i = R$id.btnViewMeasure;
                                                Button button11 = (Button) f4.b.a(view, i);
                                                if (button11 != null) {
                                                    return new h((ScrollView) view, button, button2, button3, button4, button5, button6, button7, button8, button9, button10, button11);
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static h c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static h d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R$layout.activity_test_ad_a_example_layout, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ScrollView getRoot() {
        return this.a;
    }
}
