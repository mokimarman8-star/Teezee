package xm;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.transsion.payment.lib.R$id;
import com.transsion.payment.lib.R$layout;
import eh.g;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class b implements f4.a {
    private final LinearLayoutCompat a;
    public final FrameLayout b;
    public final AppCompatImageView c;
    public final AppCompatImageView d;
    public final AppCompatImageView e;
    public final ProgressBar f;
    public final LinearLayoutCompat g;
    public final ConstraintLayout h;
    public final AppCompatTextView i;
    public final g j;

    private b(LinearLayoutCompat linearLayoutCompat, FrameLayout frameLayout, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, AppCompatImageView appCompatImageView3, ProgressBar progressBar, LinearLayoutCompat linearLayoutCompat2, ConstraintLayout constraintLayout, AppCompatTextView appCompatTextView, g gVar) {
        this.a = linearLayoutCompat;
        this.b = frameLayout;
        this.c = appCompatImageView;
        this.d = appCompatImageView2;
        this.e = appCompatImageView3;
        this.f = progressBar;
        this.g = linearLayoutCompat2;
        this.h = constraintLayout;
        this.i = appCompatTextView;
        this.j = gVar;
    }

    public static b a(View view) {
        AppCompatImageView a;
        AppCompatImageView a2;
        AppCompatImageView a3;
        AppCompatTextView a4;
        View a5;
        int i = R$id.fl_web;
        FrameLayout frameLayout = (FrameLayout) f4.b.a(view, i);
        if (frameLayout != null && (a = f4.b.a(view, (i = R$id.iv_back))) != null && (a2 = f4.b.a(view, (i = R$id.iv_close))) != null && (a3 = f4.b.a(view, (i = R$id.iv_right))) != null) {
            i = R$id.progress;
            ProgressBar progressBar = (ProgressBar) f4.b.a(view, i);
            if (progressBar != null) {
                LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) view;
                i = R$id.tool_bar;
                ConstraintLayout a6 = f4.b.a(view, i);
                if (a6 != null && (a4 = f4.b.a(view, (i = R$id.tv_titleText))) != null && (a5 = f4.b.a(view, (i = R$id.web_pay_include_loading))) != null) {
                    return new b(linearLayoutCompat, frameLayout, a, a2, a3, progressBar, linearLayoutCompat, a6, a4, g.a(a5));
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static b c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static b d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R$layout.fragment_web_pay, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayoutCompat getRoot() {
        return this.a;
    }
}
