package lm;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.transsion.moviedetail.R$id;
import com.transsion.moviedetail.R$layout;
import com.transsion.moviedetail.view.CustomTextViewGroup;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class q implements f4.a {
    private final ConstraintLayout a;
    public final FrameLayout b;
    public final AppCompatImageView c;
    public final LinearLayout d;
    public final CustomTextViewGroup e;
    public final AppCompatTextView f;
    public final CustomTextViewGroup g;
    public final CustomTextViewGroup h;
    public final AppCompatTextView i;
    public final AppCompatTextView j;
    public final CustomTextViewGroup k;
    public final View l;

    private q(ConstraintLayout constraintLayout, FrameLayout frameLayout, AppCompatImageView appCompatImageView, LinearLayout linearLayout, CustomTextViewGroup customTextViewGroup, AppCompatTextView appCompatTextView, CustomTextViewGroup customTextViewGroup2, CustomTextViewGroup customTextViewGroup3, AppCompatTextView appCompatTextView2, AppCompatTextView appCompatTextView3, CustomTextViewGroup customTextViewGroup4, View view) {
        this.a = constraintLayout;
        this.b = frameLayout;
        this.c = appCompatImageView;
        this.d = linearLayout;
        this.e = customTextViewGroup;
        this.f = appCompatTextView;
        this.g = customTextViewGroup2;
        this.h = customTextViewGroup3;
        this.i = appCompatTextView2;
        this.j = appCompatTextView3;
        this.k = customTextViewGroup4;
        this.l = view;
    }

    public static q a(View view) {
        AppCompatImageView a;
        AppCompatTextView a2;
        AppCompatTextView a3;
        AppCompatTextView a4;
        View a5;
        int i = R$id.extension_container;
        FrameLayout frameLayout = (FrameLayout) f4.b.a(view, i);
        if (frameLayout != null && (a = f4.b.a(view, (i = R$id.ivMovieContent))) != null) {
            i = R$id.ll_score;
            LinearLayout linearLayout = (LinearLayout) f4.b.a(view, i);
            if (linearLayout != null) {
                i = R$id.tv_category;
                CustomTextViewGroup customTextViewGroup = (CustomTextViewGroup) f4.b.a(view, i);
                if (customTextViewGroup != null && (a2 = f4.b.a(view, (i = R$id.tvDes))) != null) {
                    i = R$id.tv_duration;
                    CustomTextViewGroup customTextViewGroup2 = (CustomTextViewGroup) f4.b.a(view, i);
                    if (customTextViewGroup2 != null) {
                        i = R$id.tv_genre;
                        CustomTextViewGroup customTextViewGroup3 = (CustomTextViewGroup) f4.b.a(view, i);
                        if (customTextViewGroup3 != null && (a3 = f4.b.a(view, (i = R$id.tvMovieInfo))) != null && (a4 = f4.b.a(view, (i = R$id.tvMovieTitle))) != null) {
                            i = R$id.tv_students;
                            CustomTextViewGroup customTextViewGroup4 = (CustomTextViewGroup) f4.b.a(view, i);
                            if (customTextViewGroup4 != null && (a5 = f4.b.a(view, (i = R$id.v_detail_hot_zone))) != null) {
                                return new q((ConstraintLayout) view, frameLayout, a, linearLayout, customTextViewGroup, a2, customTextViewGroup2, customTextViewGroup3, a3, a4, customTextViewGroup4, a5);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static q c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static q d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R$layout.fragment_subject_edu_header, viewGroup, false);
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
