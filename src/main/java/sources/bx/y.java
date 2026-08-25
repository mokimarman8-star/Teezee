package bx;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.airbnb.lottie.LottieAnimationView;
import com.transsnet.downloader.R;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class y implements f4.a {
    private final ConstraintLayout a;
    public final LottieAnimationView b;
    public final ProgressBar c;
    public final AppCompatTextView d;
    public final AppCompatTextView e;

    private y(ConstraintLayout constraintLayout, LottieAnimationView lottieAnimationView, ProgressBar progressBar, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2) {
        this.a = constraintLayout;
        this.b = lottieAnimationView;
        this.c = progressBar;
        this.d = appCompatTextView;
        this.e = appCompatTextView2;
    }

    public static y a(View view) {
        AppCompatTextView a;
        AppCompatTextView a2;
        int i = R.id.lav_download_analyzing;
        LottieAnimationView a3 = f4.b.a(view, i);
        if (a3 != null) {
            i = R.id.progress_bar;
            ProgressBar progressBar = (ProgressBar) f4.b.a(view, i);
            if (progressBar != null && (a = f4.b.a(view, (i = R.id.tv_download_analyzing))) != null && (a2 = f4.b.a(view, (i = R.id.tv_title))) != null) {
                return new y((ConstraintLayout) view, a3, progressBar, a, a2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static y c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static y d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_download_res_ana, viewGroup, false);
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
