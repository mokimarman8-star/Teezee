package xv;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.transsion.videodetail.R$id;
import com.transsion.videodetail.R$layout;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class c implements f4.a {
    private final ConstraintLayout a;
    public final View b;
    public final AppCompatImageView c;
    public final ProgressBar d;
    public final RecyclerView e;
    public final AppCompatTextView f;

    private c(ConstraintLayout constraintLayout, View view, AppCompatImageView appCompatImageView, ProgressBar progressBar, RecyclerView recyclerView, AppCompatTextView appCompatTextView) {
        this.a = constraintLayout;
        this.b = view;
        this.c = appCompatImageView;
        this.d = progressBar;
        this.e = recyclerView;
        this.f = appCompatTextView;
    }

    public static c a(View view) {
        AppCompatImageView a;
        RecyclerView a2;
        AppCompatTextView a3;
        int i = R$id.divider;
        View a4 = f4.b.a(view, i);
        if (a4 != null && (a = f4.b.a(view, (i = R$id.iv_close))) != null) {
            i = R$id.pb_loading;
            ProgressBar progressBar = (ProgressBar) f4.b.a(view, i);
            if (progressBar != null && (a2 = f4.b.a(view, (i = R$id.f7rv))) != null && (a3 = f4.b.a(view, (i = R$id.tv_title))) != null) {
                return new c((ConstraintLayout) view, a4, a, progressBar, a2, a3);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static c c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static c d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R$layout.fragment_audio_track, viewGroup, false);
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
