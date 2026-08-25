package xv;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.noober.background.view.BLTextView;
import com.transsion.videodetail.R$id;
import com.transsion.videodetail.R$layout;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class b implements f4.a {
    private final ConstraintLayout a;
    public final View b;
    public final FrameLayout c;
    public final AppCompatImageView d;
    public final ProgressBar e;
    public final RecyclerView f;
    public final AppCompatTextView g;
    public final BLTextView h;

    private b(ConstraintLayout constraintLayout, View view, FrameLayout frameLayout, AppCompatImageView appCompatImageView, ProgressBar progressBar, RecyclerView recyclerView, AppCompatTextView appCompatTextView, BLTextView bLTextView) {
        this.a = constraintLayout;
        this.b = view;
        this.c = frameLayout;
        this.d = appCompatImageView;
        this.e = progressBar;
        this.f = recyclerView;
        this.g = appCompatTextView;
        this.h = bLTextView;
    }

    public static b a(View view) {
        AppCompatImageView a;
        RecyclerView a2;
        AppCompatTextView a3;
        BLTextView a4;
        int i = R$id.divider;
        View a5 = f4.b.a(view, i);
        if (a5 != null) {
            i = R$id.fl_season_container;
            FrameLayout frameLayout = (FrameLayout) f4.b.a(view, i);
            if (frameLayout != null && (a = f4.b.a(view, (i = R$id.iv_close))) != null) {
                i = R$id.pb_loading;
                ProgressBar progressBar = (ProgressBar) f4.b.a(view, i);
                if (progressBar != null && (a2 = f4.b.a(view, (i = R$id.f7rv))) != null && (a3 = f4.b.a(view, (i = R$id.tv_all_episodes))) != null && (a4 = f4.b.a(view, (i = R$id.tv_title))) != null) {
                    return new b((ConstraintLayout) view, a5, frameLayout, a, progressBar, a2, a3, a4);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static b c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static b d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R$layout.fragment_all_episodes, viewGroup, false);
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
