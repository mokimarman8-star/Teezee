package lm;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.transsion.moviedetail.R$id;
import com.transsion.moviedetail.R$layout;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class r implements f4.a {
    private final ConstraintLayout a;
    public final FrameLayout b;
    public final AppCompatImageView c;
    public final AppCompatTextView d;
    public final AppCompatTextView e;
    public final AppCompatTextView f;
    public final View g;
    public final View h;

    private r(ConstraintLayout constraintLayout, FrameLayout frameLayout, AppCompatImageView appCompatImageView, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, AppCompatTextView appCompatTextView3, View view, View view2) {
        this.a = constraintLayout;
        this.b = frameLayout;
        this.c = appCompatImageView;
        this.d = appCompatTextView;
        this.e = appCompatTextView2;
        this.f = appCompatTextView3;
        this.g = view;
        this.h = view2;
    }

    public static r a(View view) {
        AppCompatImageView a;
        AppCompatTextView a2;
        AppCompatTextView a3;
        AppCompatTextView a4;
        View a5;
        View a6;
        int i = R$id.extension_container;
        FrameLayout frameLayout = (FrameLayout) f4.b.a(view, i);
        if (frameLayout == null || (a = f4.b.a(view, (i = R$id.ivCollection))) == null || (a2 = f4.b.a(view, (i = R$id.tvMovieInfo))) == null || (a3 = f4.b.a(view, (i = R$id.tvMovieTitle))) == null || (a4 = f4.b.a(view, (i = R$id.tvTag))) == null || (a5 = f4.b.a(view, (i = R$id.v_detail_hot_zone))) == null || (a6 = f4.b.a(view, (i = R$id.v_line))) == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }
        return new r((ConstraintLayout) view, frameLayout, a, a2, a3, a4, a5, a6);
    }

    public static r c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static r d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R$layout.fragment_subject_edu_music_header, viewGroup, false);
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
