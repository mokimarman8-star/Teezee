package qk;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.tn.lib.view.RoundedArrowImageView;
import com.transsion.home.R;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class g implements f4.a {
    private final ConstraintLayout a;
    public final ConstraintLayout b;
    public final AppCompatImageView c;
    public final RoundedArrowImageView d;
    public final ConstraintLayout e;

    private g(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, AppCompatImageView appCompatImageView, RoundedArrowImageView roundedArrowImageView, ConstraintLayout constraintLayout3) {
        this.a = constraintLayout;
        this.b = constraintLayout2;
        this.c = appCompatImageView;
        this.d = roundedArrowImageView;
        this.e = constraintLayout3;
    }

    public static g a(View view) {
        AppCompatImageView a;
        RoundedArrowImageView a2;
        ConstraintLayout a3;
        int i = R.id.bubble_container;
        ConstraintLayout a4 = f4.b.a(view, i);
        if (a4 == null || (a = f4.b.a(view, (i = R.id.iv_ges))) == null || (a2 = f4.b.a(view, (i = R.id.iv_rounded))) == null || (a3 = f4.b.a(view, (i = R.id.iv_search_container))) == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }
        return new g((ConstraintLayout) view, a4, a, a2, a3);
    }

    public static g c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static g d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.dialog_search_guide, viewGroup, false);
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
