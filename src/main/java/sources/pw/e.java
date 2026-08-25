package pw;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.transsion.wrapperad.R$id;
import com.transsion.wrapperad.R$layout;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class e implements f4.a {
    private final ConstraintLayout a;
    public final FrameLayout b;
    public final View c;
    public final ProgressBar d;
    public final AppCompatTextView e;

    private e(ConstraintLayout constraintLayout, FrameLayout frameLayout, View view, ProgressBar progressBar, AppCompatTextView appCompatTextView) {
        this.a = constraintLayout;
        this.b = frameLayout;
        this.c = view;
        this.d = progressBar;
        this.e = appCompatTextView;
    }

    public static e a(View view) {
        View a;
        AppCompatTextView a2;
        int i = R$id.cover_gradient;
        FrameLayout frameLayout = (FrameLayout) f4.b.a(view, i);
        if (frameLayout != null && (a = f4.b.a(view, (i = R$id.cover_transparent))) != null) {
            i = R$id.progressBar;
            ProgressBar progressBar = (ProgressBar) f4.b.a(view, i);
            if (progressBar != null && (a2 = f4.b.a(view, (i = R$id.pull_indicator))) != null) {
                return new e((ConstraintLayout) view, frameLayout, a, progressBar, a2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static e c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R$layout.second_floor_arc_cover_layout, viewGroup, false);
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
