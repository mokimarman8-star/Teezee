package lm;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.helper.widget.Flow;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.transsion.moviedetail.R$id;
import com.transsion.moviedetail.R$layout;
import com.transsion.moviedetail.view.CustomTextViewGroup;
import com.transsion.moviedetail.view.InfoExtendView;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class e implements f4.a {
    private final ConstraintLayout a;
    public final Flow b;
    public final InfoExtendView c;
    public final AppCompatImageView d;
    public final LinearLayout e;
    public final CustomTextViewGroup f;
    public final AppCompatImageView g;
    public final CustomTextViewGroup h;
    public final CustomTextViewGroup i;
    public final LinearLayoutCompat j;
    public final AppCompatTextView k;
    public final CustomTextViewGroup l;

    private e(ConstraintLayout constraintLayout, Flow flow, InfoExtendView infoExtendView, AppCompatImageView appCompatImageView, LinearLayout linearLayout, CustomTextViewGroup customTextViewGroup, AppCompatImageView appCompatImageView2, CustomTextViewGroup customTextViewGroup2, CustomTextViewGroup customTextViewGroup3, LinearLayoutCompat linearLayoutCompat, AppCompatTextView appCompatTextView, CustomTextViewGroup customTextViewGroup4) {
        this.a = constraintLayout;
        this.b = flow;
        this.c = infoExtendView;
        this.d = appCompatImageView;
        this.e = linearLayout;
        this.f = customTextViewGroup;
        this.g = appCompatImageView2;
        this.h = customTextViewGroup2;
        this.i = customTextViewGroup3;
        this.j = linearLayoutCompat;
        this.k = appCompatTextView;
        this.l = customTextViewGroup4;
    }

    public static e a(View view) {
        AppCompatImageView a;
        AppCompatImageView a2;
        LinearLayoutCompat a3;
        AppCompatTextView a4;
        int i = R$id.flow;
        Flow a5 = f4.b.a(view, i);
        if (a5 != null) {
            i = R$id.infoExtendView;
            InfoExtendView infoExtendView = (InfoExtendView) f4.b.a(view, i);
            if (infoExtendView != null && (a = f4.b.a(view, (i = R$id.ivMovieContent))) != null) {
                i = R$id.ll_score;
                LinearLayout linearLayout = (LinearLayout) f4.b.a(view, i);
                if (linearLayout != null) {
                    i = R$id.tv_category;
                    CustomTextViewGroup customTextViewGroup = (CustomTextViewGroup) f4.b.a(view, i);
                    if (customTextViewGroup != null && (a2 = f4.b.a(view, (i = R$id.tv_close))) != null) {
                        i = R$id.tv_duration;
                        CustomTextViewGroup customTextViewGroup2 = (CustomTextViewGroup) f4.b.a(view, i);
                        if (customTextViewGroup2 != null) {
                            i = R$id.tv_genre;
                            CustomTextViewGroup customTextViewGroup3 = (CustomTextViewGroup) f4.b.a(view, i);
                            if (customTextViewGroup3 != null && (a3 = f4.b.a(view, (i = R$id.tv_header_toolbar))) != null && (a4 = f4.b.a(view, (i = R$id.tvMovieTitle))) != null) {
                                i = R$id.tv_students;
                                CustomTextViewGroup customTextViewGroup4 = (CustomTextViewGroup) f4.b.a(view, i);
                                if (customTextViewGroup4 != null) {
                                    return new e((ConstraintLayout) view, a5, infoExtendView, a, linearLayout, customTextViewGroup, a2, customTextViewGroup2, customTextViewGroup3, a3, a4, customTextViewGroup4);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static e c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static e d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R$layout.fragment_edu_info_dialog, viewGroup, false);
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
