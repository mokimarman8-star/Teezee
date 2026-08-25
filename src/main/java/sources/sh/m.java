package sh;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import com.transsion.ad.R$id;
import com.transsion.ad.R$layout;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public final class m implements f4.a {
    private final LinearLayout a;
    public final Button b;
    public final Button c;
    public final Button d;
    public final Button e;
    public final Button f;
    public final Button g;
    public final Button h;
    public final Button i;

    private m(LinearLayout linearLayout, Button button, Button button2, Button button3, Button button4, Button button5, Button button6, Button button7, Button button8) {
        this.a = linearLayout;
        this.b = button;
        this.c = button2;
        this.d = button3;
        this.e = button4;
        this.f = button5;
        this.g = button6;
        this.h = button7;
        this.i = button8;
    }

    public static m a(View view) {
        int i = R$id.btnAdExample;
        Button button = (Button) f4.b.a(view, i);
        if (button != null) {
            i = R$id.btnAdPlanConfig;
            Button button2 = (Button) f4.b.a(view, i);
            if (button2 != null) {
                i = R$id.btnGlobalSwitchConfig;
                Button button3 = (Button) f4.b.a(view, i);
                if (button3 != null) {
                    i = R$id.btnNonHitLog;
                    Button button4 = (Button) f4.b.a(view, i);
                    if (button4 != null) {
                        i = R$id.btnOtherConfig;
                        Button button5 = (Button) f4.b.a(view, i);
                        if (button5 != null) {
                            i = R$id.btnPsOfferConfig;
                            Button button6 = (Button) f4.b.a(view, i);
                            if (button6 != null) {
                                i = R$id.btnResetVersion;
                                Button button7 = (Button) f4.b.a(view, i);
                                if (button7 != null) {
                                    i = R$id.btnSceneConfig;
                                    Button button8 = (Button) f4.b.a(view, i);
                                    if (button8 != null) {
                                        return new m((LinearLayout) view, button, button2, button3, button4, button5, button6, button7, button8);
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

    public static m c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static m d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R$layout.activity_test_ad_layout, viewGroup, false);
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
