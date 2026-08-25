package wn;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.transsion.postdetail.R$id;
import com.transsion.postdetail.R$layout;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class n0 implements f4.a {
    private final ConstraintLayout a;
    public final AppCompatImageView b;
    public final AppCompatImageView c;
    public final AppCompatImageView d;
    public final AppCompatImageView e;
    public final AppCompatTextView f;
    public final AppCompatTextView g;
    public final View h;
    public final View i;
    public final View j;
    public final View k;

    private n0(ConstraintLayout constraintLayout, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, AppCompatImageView appCompatImageView3, AppCompatImageView appCompatImageView4, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, View view, View view2, View view3, View view4) {
        this.a = constraintLayout;
        this.b = appCompatImageView;
        this.c = appCompatImageView2;
        this.d = appCompatImageView3;
        this.e = appCompatImageView4;
        this.f = appCompatTextView;
        this.g = appCompatTextView2;
        this.h = view;
        this.i = view2;
        this.j = view3;
        this.k = view4;
    }

    public static n0 a(View view) {
        AppCompatImageView a;
        AppCompatImageView a2;
        AppCompatImageView a3;
        AppCompatTextView a4;
        AppCompatTextView a5;
        View a6;
        View a7;
        View a8;
        View a9;
        int i = R$id.ivComment;
        AppCompatImageView a10 = f4.b.a(view, i);
        if (a10 == null || (a = f4.b.a(view, (i = R$id.ivDownload))) == null || (a2 = f4.b.a(view, (i = R$id.ivLike))) == null || (a3 = f4.b.a(view, (i = R$id.ivShare))) == null || (a4 = f4.b.a(view, (i = R$id.tvComment))) == null || (a5 = f4.b.a(view, (i = R$id.tvLike))) == null || (a6 = f4.b.a(view, (i = R$id.viewComment))) == null || (a7 = f4.b.a(view, (i = R$id.viewDownload))) == null || (a8 = f4.b.a(view, (i = R$id.viewLike))) == null || (a9 = f4.b.a(view, (i = R$id.viewShare))) == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }
        return new n0((ConstraintLayout) view, a10, a, a2, a3, a4, a5, a6, a7, a8, a9);
    }

    public static n0 c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static n0 d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R$layout.view_post_detail_operation_new_layout, viewGroup, false);
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
