package gm;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatEditText;
import com.transsion.baseui.widget.GradientBorderView;
import com.transsion.member.R$id;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class h implements f4.a {
    private final LinearLayout a;
    public final ImageView b;
    public final ImageView c;
    public final TextView d;
    public final TextView e;
    public final AppCompatEditText f;
    public final GradientBorderView g;

    private h(LinearLayout linearLayout, ImageView imageView, ImageView imageView2, TextView textView, TextView textView2, AppCompatEditText appCompatEditText, GradientBorderView gradientBorderView) {
        this.a = linearLayout;
        this.b = imageView;
        this.c = imageView2;
        this.d = textView;
        this.e = textView2;
        this.f = appCompatEditText;
        this.g = gradientBorderView;
    }

    public static h a(View view) {
        AppCompatEditText a;
        int i = R$id.promo_code_dialog_close;
        ImageView imageView = (ImageView) f4.b.a(view, i);
        if (imageView != null) {
            i = R$id.promo_code_input_clear_iv;
            ImageView imageView2 = (ImageView) f4.b.a(view, i);
            if (imageView2 != null) {
                i = R$id.promo_code_input_confirm;
                TextView textView = (TextView) f4.b.a(view, i);
                if (textView != null) {
                    i = R$id.promo_code_input_error_tips;
                    TextView textView2 = (TextView) f4.b.a(view, i);
                    if (textView2 != null && (a = f4.b.a(view, (i = R$id.promo_code_input_et))) != null) {
                        i = R$id.promo_code_title_layout;
                        GradientBorderView gradientBorderView = (GradientBorderView) f4.b.a(view, i);
                        if (gradientBorderView != null) {
                            return new h((LinearLayout) view, imageView, imageView2, textView, textView2, a, gradientBorderView);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.a;
    }
}
