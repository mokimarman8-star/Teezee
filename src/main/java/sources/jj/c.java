package jj;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.transsion.baseui.R;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class c implements f4.a {
    private final ConstraintLayout a;
    public final AppCompatImageView b;
    public final LinearLayoutCompat c;

    private c(ConstraintLayout constraintLayout, AppCompatImageView appCompatImageView, LinearLayoutCompat linearLayoutCompat) {
        this.a = constraintLayout;
        this.b = appCompatImageView;
        this.c = linearLayoutCompat;
    }

    public static c a(View view) {
        LinearLayoutCompat a;
        int i = R.id.ivBack;
        AppCompatImageView a2 = f4.b.a(view, i);
        if (a2 == null || (a = f4.b.a(view, (i = R.id.toolbar_d))) == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }
        return new c((ConstraintLayout) view, a2, a);
    }

    public static c c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static c d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.default_list_loading_view, viewGroup, false);
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
