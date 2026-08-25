package lm;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.transsion.moviedetail.R$id;
import com.transsion.moviedetail.R$layout;
import com.transsion.moviedetail.view.CustomTextViewGroup;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class s implements f4.a {
    private final ConstraintLayout a;
    public final FrameLayout b;
    public final AppCompatImageView c;
    public final AppCompatImageView d;
    public final LinearLayout e;
    public final CustomTextViewGroup f;
    public final AppCompatTextView g;
    public final LinearLayoutCompat h;
    public final CustomTextViewGroup i;
    public final AppCompatImageView j;
    public final AppCompatTextView k;
    public final CustomTextViewGroup l;
    public final CustomTextViewGroup m;
    public final CustomTextViewGroup n;

    private s(ConstraintLayout constraintLayout, FrameLayout frameLayout, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, LinearLayout linearLayout, CustomTextViewGroup customTextViewGroup, AppCompatTextView appCompatTextView, LinearLayoutCompat linearLayoutCompat, CustomTextViewGroup customTextViewGroup2, AppCompatImageView appCompatImageView3, AppCompatTextView appCompatTextView2, CustomTextViewGroup customTextViewGroup3, CustomTextViewGroup customTextViewGroup4, CustomTextViewGroup customTextViewGroup5) {
        this.a = constraintLayout;
        this.b = frameLayout;
        this.c = appCompatImageView;
        this.d = appCompatImageView2;
        this.e = linearLayout;
        this.f = customTextViewGroup;
        this.g = appCompatTextView;
        this.h = linearLayoutCompat;
        this.i = customTextViewGroup2;
        this.j = appCompatImageView3;
        this.k = appCompatTextView2;
        this.l = customTextViewGroup3;
        this.m = customTextViewGroup4;
        this.n = customTextViewGroup5;
    }

    public static s a(View view) {
        AppCompatImageView a;
        AppCompatImageView a2;
        AppCompatTextView a3;
        LinearLayoutCompat a4;
        AppCompatImageView a5;
        AppCompatTextView a6;
        int i = R$id.extension_container;
        FrameLayout frameLayout = (FrameLayout) f4.b.a(view, i);
        if (frameLayout != null && (a = f4.b.a(view, (i = R$id.ivMovieContent))) != null && (a2 = f4.b.a(view, (i = R$id.iv_score))) != null) {
            i = R$id.ll_score;
            LinearLayout linearLayout = (LinearLayout) f4.b.a(view, i);
            if (linearLayout != null) {
                i = R$id.tv_country;
                CustomTextViewGroup customTextViewGroup = (CustomTextViewGroup) f4.b.a(view, i);
                if (customTextViewGroup != null && (a3 = f4.b.a(view, (i = R$id.tvMovieTitle))) != null && (a4 = f4.b.a(view, (i = R$id.tv_movie_title_container))) != null) {
                    i = R$id.tv_restrict;
                    CustomTextViewGroup customTextViewGroup2 = (CustomTextViewGroup) f4.b.a(view, i);
                    if (customTextViewGroup2 != null && (a5 = f4.b.a(view, (i = R$id.tv_right))) != null && (a6 = f4.b.a(view, (i = R$id.tv_score))) != null) {
                        i = R$id.tv_seasons;
                        CustomTextViewGroup customTextViewGroup3 = (CustomTextViewGroup) f4.b.a(view, i);
                        if (customTextViewGroup3 != null) {
                            i = R$id.tv_time;
                            CustomTextViewGroup customTextViewGroup4 = (CustomTextViewGroup) f4.b.a(view, i);
                            if (customTextViewGroup4 != null) {
                                i = R$id.tv_type;
                                CustomTextViewGroup customTextViewGroup5 = (CustomTextViewGroup) f4.b.a(view, i);
                                if (customTextViewGroup5 != null) {
                                    return new s((ConstraintLayout) view, frameLayout, a, a2, linearLayout, customTextViewGroup, a3, a4, customTextViewGroup2, a5, a6, customTextViewGroup3, customTextViewGroup4, customTextViewGroup5);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static s c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static s d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R$layout.fragment_subject_header, viewGroup, false);
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
