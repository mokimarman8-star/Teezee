package sh;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.transsion.ad.R$id;
import com.transsion.ad.R$layout;
import com.transsion.ad.view.AdTagView;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public final class e implements f4.a {
    private final ConstraintLayout a;
    public final AdTagView b;
    public final ConstraintLayout c;
    public final FrameLayout d;
    public final FrameLayout e;
    public final FrameLayout f;
    public final AppCompatTextView g;

    private e(ConstraintLayout constraintLayout, AdTagView adTagView, ConstraintLayout constraintLayout2, FrameLayout frameLayout, FrameLayout frameLayout2, FrameLayout frameLayout3, AppCompatTextView appCompatTextView) {
        this.a = constraintLayout;
        this.b = adTagView;
        this.c = constraintLayout2;
        this.d = frameLayout;
        this.e = frameLayout2;
        this.f = frameLayout3;
        this.g = appCompatTextView;
    }

    public static e a(View view) {
        AppCompatTextView a;
        int i = R$id.adIcon;
        AdTagView a2 = f4.b.a(view, i);
        if (a2 != null) {
            ConstraintLayout constraintLayout = (ConstraintLayout) view;
            i = R$id.container;
            FrameLayout frameLayout = (FrameLayout) f4.b.a(view, i);
            if (frameLayout != null) {
                i = R$id.flVolumeContainer;
                FrameLayout frameLayout2 = (FrameLayout) f4.b.a(view, i);
                if (frameLayout2 != null) {
                    i = R$id.movieBoxLayout;
                    FrameLayout frameLayout3 = (FrameLayout) f4.b.a(view, i);
                    if (frameLayout3 != null && (a = f4.b.a(view, (i = R$id.tvCountDown))) != null) {
                        return new e(constraintLayout, a2, constraintLayout, frameLayout, frameLayout2, frameLayout3, a);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static e c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static e d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R$layout.activity_bidding_buy_out_splash, viewGroup, false);
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
