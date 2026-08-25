package rl;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.transsion.lib_web.R$id;
import com.transsion.lib_web.R$layout;
import f4.b;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class a implements f4.a {
    private final ConstraintLayout a;
    public final AppCompatImageView b;
    public final AppCompatImageView c;
    public final AppCompatImageView d;
    public final LinearLayoutCompat e;
    public final ProgressBar f;
    public final View g;
    public final AppCompatTextView h;
    public final FrameLayout i;

    private a(ConstraintLayout constraintLayout, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, AppCompatImageView appCompatImageView3, LinearLayoutCompat linearLayoutCompat, ProgressBar progressBar, View view, AppCompatTextView appCompatTextView, FrameLayout frameLayout) {
        this.a = constraintLayout;
        this.b = appCompatImageView;
        this.c = appCompatImageView2;
        this.d = appCompatImageView3;
        this.e = linearLayoutCompat;
        this.f = progressBar;
        this.g = view;
        this.h = appCompatTextView;
        this.i = frameLayout;
    }

    public static a a(View view) {
        AppCompatImageView a;
        AppCompatImageView a2;
        LinearLayoutCompat a3;
        View a4;
        AppCompatTextView a5;
        int i = R$id.ivBack;
        AppCompatImageView a6 = b.a(view, i);
        if (a6 != null && (a = b.a(view, (i = R$id.ivClose))) != null && (a2 = b.a(view, (i = R$id.ivRight))) != null && (a3 = b.a(view, (i = R$id.llToolBar))) != null) {
            i = R$id.progressBar;
            ProgressBar progressBar = (ProgressBar) b.a(view, i);
            if (progressBar != null && (a4 = b.a(view, (i = R$id.subWebHeaderBg))) != null && (a5 = b.a(view, (i = R$id.tvTitle))) != null) {
                i = R$id.webContainer;
                FrameLayout frameLayout = (FrameLayout) b.a(view, i);
                if (frameLayout != null) {
                    return new a((ConstraintLayout) view, a6, a, a2, a3, progressBar, a4, a5, frameLayout);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static a c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static a d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R$layout.lib_web_web_fragment_layout, viewGroup, false);
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
