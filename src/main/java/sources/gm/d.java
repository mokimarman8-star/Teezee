package gm;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.transsion.baseui.widget.GradientBorderView;
import com.transsion.member.R$id;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class d implements f4.a {
    private final GradientBorderView a;
    public final GradientBorderView b;
    public final LinearLayoutCompat c;
    public final AppCompatTextView d;
    public final ImageView e;
    public final TextView f;
    public final ImageView g;
    public final TextView h;

    private d(GradientBorderView gradientBorderView, GradientBorderView gradientBorderView2, LinearLayoutCompat linearLayoutCompat, AppCompatTextView appCompatTextView, ImageView imageView, TextView textView, ImageView imageView2, TextView textView2) {
        this.a = gradientBorderView;
        this.b = gradientBorderView2;
        this.c = linearLayoutCompat;
        this.d = appCompatTextView;
        this.e = imageView;
        this.f = textView;
        this.g = imageView2;
        this.h = textView2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static d a(View view) {
        AppCompatTextView a;
        GradientBorderView gradientBorderView = (GradientBorderView) view;
        int i = R$id.explore;
        LinearLayoutCompat a2 = f4.b.a(view, i);
        if (a2 != null && (a = f4.b.a(view, (i = R$id.explore_title))) != null) {
            i = R$id.iv_close;
            ImageView imageView = (ImageView) f4.b.a(view, i);
            if (imageView != null) {
                i = R$id.iv_detail;
                TextView textView = (TextView) f4.b.a(view, i);
                if (textView != null) {
                    i = R$id.iv_premium_mask;
                    ImageView imageView2 = (ImageView) f4.b.a(view, i);
                    if (imageView2 != null) {
                        i = R$id.iv_title;
                        TextView textView2 = (TextView) f4.b.a(view, i);
                        if (textView2 != null) {
                            return new d(gradientBorderView, gradientBorderView, a2, a, imageView, textView, imageView2, textView2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public GradientBorderView getRoot() {
        return this.a;
    }
}
