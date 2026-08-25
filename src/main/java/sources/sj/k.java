package sj;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.transsion.ad.view.GradientTextView;
import com.transsion.ad.view.native_ad.NativeWrapperAdView;
import com.transsion.commercialization.R$id;
import com.transsion.commercialization.R$layout;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class k implements f4.a {
    private final ConstraintLayout a;
    public final AppCompatImageView b;
    public final LinearLayout c;
    public final NativeWrapperAdView d;
    public final TextView e;
    public final GradientTextView f;

    private k(ConstraintLayout constraintLayout, AppCompatImageView appCompatImageView, LinearLayout linearLayout, NativeWrapperAdView nativeWrapperAdView, TextView textView, GradientTextView gradientTextView) {
        this.a = constraintLayout;
        this.b = appCompatImageView;
        this.c = linearLayout;
        this.d = nativeWrapperAdView;
        this.e = textView;
        this.f = gradientTextView;
    }

    public static k a(View view) {
        int i = R$id.ivRefresh;
        AppCompatImageView a = f4.b.a(view, i);
        if (a != null) {
            i = R$id.llChange;
            LinearLayout linearLayout = (LinearLayout) f4.b.a(view, i);
            if (linearLayout != null) {
                i = R$id.nativeWrapperAdView;
                NativeWrapperAdView nativeWrapperAdView = (NativeWrapperAdView) f4.b.a(view, i);
                if (nativeWrapperAdView != null) {
                    i = R$id.tvInstall;
                    TextView textView = (TextView) f4.b.a(view, i);
                    if (textView != null) {
                        i = R$id.tvTryMore;
                        GradientTextView gradientTextView = (GradientTextView) f4.b.a(view, i);
                        if (gradientTextView != null) {
                            return new k((ConstraintLayout) view, a, linearLayout, nativeWrapperAdView, textView, gradientTextView);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static k c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R$layout.view_treasure_ad_layout, viewGroup, false);
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
