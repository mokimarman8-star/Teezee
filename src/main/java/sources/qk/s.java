package qk;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.compose.ui.platform.ComposeView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.tn.lib.view.TitleLayout;
import com.transsion.home.R;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class s implements f4.a {
    private final ConstraintLayout a;
    public final ComposeView b;
    public final FrameLayout c;
    public final ConstraintLayout d;
    public final TitleLayout e;

    private s(ConstraintLayout constraintLayout, ComposeView composeView, FrameLayout frameLayout, ConstraintLayout constraintLayout2, TitleLayout titleLayout) {
        this.a = constraintLayout;
        this.b = composeView;
        this.c = frameLayout;
        this.d = constraintLayout2;
        this.e = titleLayout;
    }

    public static s a(View view) {
        ConstraintLayout a;
        TitleLayout a2;
        int i = R.id.rank_all_category_container;
        ComposeView a3 = f4.b.a(view, i);
        if (a3 != null) {
            i = R.id.rank_all_error;
            FrameLayout frameLayout = (FrameLayout) f4.b.a(view, i);
            if (frameLayout != null && (a = f4.b.a(view, (i = R.id.rank_all_loading_frame))) != null && (a2 = f4.b.a(view, (i = R.id.rank_all_title))) != null) {
                return new s((ConstraintLayout) view, a3, frameLayout, a, a2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static s c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static s d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_rank_all, viewGroup, false);
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
