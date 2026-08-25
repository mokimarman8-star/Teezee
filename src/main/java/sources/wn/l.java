package wn;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import com.google.android.material.imageview.ShapeableImageView;
import com.transsion.postdetail.R$id;
import com.transsion.postdetail.R$layout;
import com.transsion.postdetail.ui.view.PostDetailOperationView;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class l implements f4.a {
    private final ConstraintLayout a;
    public final ConstraintLayout b;
    public final Group c;
    public final AppCompatTextView d;
    public final AppCompatTextView e;
    public final AppCompatImageView f;
    public final AppCompatTextView g;
    public final ShapeableImageView h;
    public final AppCompatTextView i;
    public final AppCompatImageView j;
    public final PostDetailOperationView k;
    public final AppCompatTextView l;
    public final AppCompatTextView m;

    private l(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, Group group, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, AppCompatImageView appCompatImageView, AppCompatTextView appCompatTextView3, ShapeableImageView shapeableImageView, AppCompatTextView appCompatTextView4, AppCompatImageView appCompatImageView2, PostDetailOperationView postDetailOperationView, AppCompatTextView appCompatTextView5, AppCompatTextView appCompatTextView6) {
        this.a = constraintLayout;
        this.b = constraintLayout2;
        this.c = group;
        this.d = appCompatTextView;
        this.e = appCompatTextView2;
        this.f = appCompatImageView;
        this.g = appCompatTextView3;
        this.h = shapeableImageView;
        this.i = appCompatTextView4;
        this.j = appCompatImageView2;
        this.k = postDetailOperationView;
        this.l = appCompatTextView5;
        this.m = appCompatTextView6;
    }

    public static l a(View view) {
        AppCompatTextView a;
        AppCompatTextView a2;
        AppCompatImageView a3;
        AppCompatTextView a4;
        ShapeableImageView a5;
        AppCompatTextView a6;
        AppCompatImageView a7;
        AppCompatTextView a8;
        AppCompatTextView a9;
        ConstraintLayout constraintLayout = (ConstraintLayout) view;
        int i = R$id.groupNoCommentYet;
        Group a10 = f4.b.a(view, i);
        if (a10 != null && (a = f4.b.a(view, (i = R$id.itemCommentContent))) != null && (a2 = f4.b.a(view, (i = R$id.itemCommentData))) != null && (a3 = f4.b.a(view, (i = R$id.itemCommentLikeIcon))) != null && (a4 = f4.b.a(view, (i = R$id.itemCommentReply))) != null && (a5 = f4.b.a(view, (i = R$id.itemCommentUserAvatar))) != null && (a6 = f4.b.a(view, (i = R$id.itemCommentUserName))) != null && (a7 = f4.b.a(view, (i = R$id.ivRight))) != null) {
            i = R$id.postDetailOperationView;
            PostDetailOperationView postDetailOperationView = (PostDetailOperationView) f4.b.a(view, i);
            if (postDetailOperationView != null && (a8 = f4.b.a(view, (i = R$id.tvComments))) != null && (a9 = f4.b.a(view, (i = R$id.tvNoCommentYet))) != null) {
                return new l(constraintLayout, constraintLayout, a10, a, a2, a3, a4, a5, a6, a7, postDetailOperationView, a8, a9);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static l c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static l d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R$layout.fragment_post_detail_comments_layout, viewGroup, false);
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
