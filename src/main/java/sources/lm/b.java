package lm;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import com.transsion.moviedetail.R$id;
import com.transsion.moviedetail.R$layout;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class b implements f4.a {
    private final ConstraintLayout a;
    public final AppCompatImageView b;
    public final AppCompatImageView c;
    public final AppCompatImageView d;
    public final AppCompatImageView e;
    public final LinearLayout f;
    public final RecyclerView g;
    public final NestedScrollView h;
    public final ConstraintLayout i;
    public final AppCompatTextView j;
    public final AppCompatTextView k;
    public final TextView l;

    private b(ConstraintLayout constraintLayout, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, AppCompatImageView appCompatImageView3, AppCompatImageView appCompatImageView4, LinearLayout linearLayout, RecyclerView recyclerView, NestedScrollView nestedScrollView, ConstraintLayout constraintLayout2, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, TextView textView) {
        this.a = constraintLayout;
        this.b = appCompatImageView;
        this.c = appCompatImageView2;
        this.d = appCompatImageView3;
        this.e = appCompatImageView4;
        this.f = linearLayout;
        this.g = recyclerView;
        this.h = nestedScrollView;
        this.i = constraintLayout2;
        this.j = appCompatTextView;
        this.k = appCompatTextView2;
        this.l = textView;
    }

    public static b a(View view) {
        AppCompatImageView a;
        AppCompatImageView a2;
        AppCompatImageView a3;
        RecyclerView a4;
        NestedScrollView a5;
        ConstraintLayout a6;
        AppCompatTextView a7;
        AppCompatTextView a8;
        int i = R$id.ivBack;
        AppCompatImageView a9 = f4.b.a(view, i);
        if (a9 != null && (a = f4.b.a(view, (i = R$id.ivCover))) != null && (a2 = f4.b.a(view, (i = R$id.ivDownload))) != null && (a3 = f4.b.a(view, (i = R$id.ivShare))) != null) {
            i = R$id.llContent;
            LinearLayout linearLayout = (LinearLayout) f4.b.a(view, i);
            if (linearLayout != null && (a4 = f4.b.a(view, (i = R$id.rvStaff))) != null && (a5 = f4.b.a(view, (i = R$id.scrollView))) != null && (a6 = f4.b.a(view, (i = R$id.topLayout))) != null && (a7 = f4.b.a(view, (i = R$id.tvMovieDesc))) != null && (a8 = f4.b.a(view, (i = R$id.tvMovieName))) != null) {
                i = R$id.tvStaffTitle;
                TextView textView = (TextView) f4.b.a(view, i);
                if (textView != null) {
                    return new b((ConstraintLayout) view, a9, a, a2, a3, linearLayout, a4, a5, a6, a7, a8, textView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static b c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static b d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R$layout.activity_movie_poster_detail, viewGroup, false);
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
