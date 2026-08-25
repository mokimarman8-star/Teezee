package sh;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.hisavana.mediation.ad.TSplashView;
import com.transsion.ad.R$id;
import com.transsion.ad.R$layout;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public final class g implements f4.a {
    private final ConstraintLayout a;
    public final TSplashView b;

    private g(ConstraintLayout constraintLayout, TSplashView tSplashView) {
        this.a = constraintLayout;
        this.b = tSplashView;
    }

    public static g a(View view) {
        int i = R$id.splash_ad;
        TSplashView tSplashView = (TSplashView) f4.b.a(view, i);
        if (tSplashView != null) {
            return new g((ConstraintLayout) view, tSplashView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static g c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static g d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R$layout.activity_bidding_hisavana_splash, viewGroup, false);
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
