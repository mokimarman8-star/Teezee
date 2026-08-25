package mn;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.transsion.ad.view.GradientTextView;
import com.transsion.ad.view.native_ad.NativeWrapperAdView;
import com.transsion.player.longvideo.R$id;
import com.transsion.player.longvideo.R$layout;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class o implements f4.a {
    private final ConstraintLayout a;
    public final AppCompatImageView b;
    public final AppCompatImageView c;
    public final LinearLayout d;
    public final LinearLayout e;
    public final FrameLayout f;
    public final LinearLayout g;
    public final NativeWrapperAdView h;
    public final GradientTextView i;
    public final GradientTextView j;
    public final GradientTextView k;

    private o(ConstraintLayout constraintLayout, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, LinearLayout linearLayout, LinearLayout linearLayout2, FrameLayout frameLayout, LinearLayout linearLayout3, NativeWrapperAdView nativeWrapperAdView, GradientTextView gradientTextView, GradientTextView gradientTextView2, GradientTextView gradientTextView3) {
        this.a = constraintLayout;
        this.b = appCompatImageView;
        this.c = appCompatImageView2;
        this.d = linearLayout;
        this.e = linearLayout2;
        this.f = frameLayout;
        this.g = linearLayout3;
        this.h = nativeWrapperAdView;
        this.i = gradientTextView;
        this.j = gradientTextView2;
        this.k = gradientTextView3;
    }

    public static o a(View view) {
        AppCompatImageView a;
        int i = R$id.ivRefresh;
        AppCompatImageView a2 = f4.b.a(view, i);
        if (a2 != null && (a = f4.b.a(view, (i = R$id.ivRefreshV))) != null) {
            i = R$id.llBtnH;
            LinearLayout linearLayout = (LinearLayout) f4.b.a(view, i);
            if (linearLayout != null) {
                i = R$id.llBtnV;
                LinearLayout linearLayout2 = (LinearLayout) f4.b.a(view, i);
                if (linearLayout2 != null) {
                    i = R$id.llChange;
                    FrameLayout frameLayout = (FrameLayout) f4.b.a(view, i);
                    if (frameLayout != null) {
                        i = R$id.llChangeV;
                        LinearLayout linearLayout3 = (LinearLayout) f4.b.a(view, i);
                        if (linearLayout3 != null) {
                            i = R$id.nativeWrapperAdView;
                            NativeWrapperAdView nativeWrapperAdView = (NativeWrapperAdView) f4.b.a(view, i);
                            if (nativeWrapperAdView != null) {
                                i = R$id.tvInstall;
                                GradientTextView gradientTextView = (GradientTextView) f4.b.a(view, i);
                                if (gradientTextView != null) {
                                    i = R$id.tvInstallV;
                                    GradientTextView gradientTextView2 = (GradientTextView) f4.b.a(view, i);
                                    if (gradientTextView2 != null) {
                                        i = R$id.tvTryMore;
                                        GradientTextView gradientTextView3 = (GradientTextView) f4.b.a(view, i);
                                        if (gradientTextView3 != null) {
                                            return new o((ConstraintLayout) view, a2, a, linearLayout, linearLayout2, frameLayout, linearLayout3, nativeWrapperAdView, gradientTextView, gradientTextView2, gradientTextView3);
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

    public static o c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R$layout.view_resolution_ad_layout, viewGroup, false);
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
