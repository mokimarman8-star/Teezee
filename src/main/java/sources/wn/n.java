package wn;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.appbar.AppBarLayout;
import com.tn.lib.view.TitleLayout;
import com.transsion.postdetail.R$id;
import com.transsion.postdetail.R$layout;
import com.transsion.postdetail.ui.view.PostDetailItemView;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class n implements f4.a {
    private final ConstraintLayout a;
    public final AppBarLayout b;
    public final ConstraintLayout c;
    public final FrameLayout d;
    public final PostDetailItemView e;
    public final TitleLayout f;
    public final AppCompatTextView g;
    public final AppCompatTextView h;
    public final View i;

    private n(ConstraintLayout constraintLayout, AppBarLayout appBarLayout, ConstraintLayout constraintLayout2, FrameLayout frameLayout, PostDetailItemView postDetailItemView, TitleLayout titleLayout, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, View view) {
        this.a = constraintLayout;
        this.b = appBarLayout;
        this.c = constraintLayout2;
        this.d = frameLayout;
        this.e = postDetailItemView;
        this.f = titleLayout;
        this.g = appCompatTextView;
        this.h = appCompatTextView2;
        this.i = view;
    }

    public static n a(View view) {
        TitleLayout a;
        AppCompatTextView a2;
        AppCompatTextView a3;
        View a4;
        int i = R$id.app_bar_layout;
        AppBarLayout a5 = f4.b.a(view, i);
        if (a5 != null) {
            ConstraintLayout constraintLayout = (ConstraintLayout) view;
            i = R$id.fl_comment_container;
            FrameLayout frameLayout = (FrameLayout) f4.b.a(view, i);
            if (frameLayout != null) {
                i = R$id.postDetailItem;
                PostDetailItemView postDetailItemView = (PostDetailItemView) f4.b.a(view, i);
                if (postDetailItemView != null && (a = f4.b.a(view, (i = R$id.titleLayout))) != null && (a2 = f4.b.a(view, (i = R$id.tv_comment))) != null && (a3 = f4.b.a(view, (i = R$id.tv_comment_num))) != null && (a4 = f4.b.a(view, (i = R$id.v_bottom))) != null) {
                    return new n(constraintLayout, a5, constraintLayout, frameLayout, postDetailItemView, a, a2, a3, a4);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static n c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static n d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R$layout.fragment_post_detail_layout, viewGroup, false);
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
