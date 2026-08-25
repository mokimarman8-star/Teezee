package jj;

import android.view.View;
import android.widget.ProgressBar;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.transsion.baseui.R;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class e implements f4.a {
    private final ConstraintLayout a;
    public final ConstraintLayout b;
    public final AppCompatImageView c;
    public final AppCompatImageView d;
    public final AppCompatImageView e;
    public final ProgressBar f;

    private e(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, AppCompatImageView appCompatImageView3, ProgressBar progressBar) {
        this.a = constraintLayout;
        this.b = constraintLayout2;
        this.c = appCompatImageView;
        this.d = appCompatImageView2;
        this.e = appCompatImageView3;
        this.f = progressBar;
    }

    public static e a(View view) {
        AppCompatImageView a;
        AppCompatImageView a2;
        ConstraintLayout constraintLayout = (ConstraintLayout) view;
        int i = R.id.ivBackward;
        AppCompatImageView a3 = f4.b.a(view, i);
        if (a3 != null && (a = f4.b.a(view, (i = R.id.ivCenterPause))) != null && (a2 = f4.b.a(view, (i = R.id.ivForward))) != null) {
            i = R.id.progressBar;
            ProgressBar progressBar = (ProgressBar) f4.b.a(view, i);
            if (progressBar != null) {
                return new e(constraintLayout, constraintLayout, a3, a, a2, progressBar);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.a;
    }
}
