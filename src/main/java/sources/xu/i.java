package xu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.tn.lib.view.TitleLayout;
import com.transsion.usercenter.R$id;
import com.transsion.usercenter.R$layout;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class i implements f4.a {
    private final ConstraintLayout a;
    public final ImageView b;
    public final TitleLayout c;
    public final TextView d;
    public final TextView e;
    public final TextView f;

    private i(ConstraintLayout constraintLayout, ImageView imageView, TitleLayout titleLayout, TextView textView, TextView textView2, TextView textView3) {
        this.a = constraintLayout;
        this.b = imageView;
        this.c = titleLayout;
        this.d = textView;
        this.e = textView2;
        this.f = textView3;
    }

    public static i a(View view) {
        TitleLayout a;
        int i = R$id.ivLogo;
        ImageView imageView = (ImageView) f4.b.a(view, i);
        if (imageView != null && (a = f4.b.a(view, (i = R$id.titleLayout))) != null) {
            i = R$id.tvAgreement;
            TextView textView = (TextView) f4.b.a(view, i);
            if (textView != null) {
                i = R$id.tvAppName;
                TextView textView2 = (TextView) f4.b.a(view, i);
                if (textView2 != null) {
                    i = R$id.tvAppVersion;
                    TextView textView3 = (TextView) f4.b.a(view, i);
                    if (textView3 != null) {
                        return new i((ConstraintLayout) view, imageView, a, textView, textView2, textView3);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static i c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static i d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R$layout.activity_pro_file_setting_about_us, viewGroup, false);
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
