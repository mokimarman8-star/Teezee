package wn;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.tn.lib.widget.TnTextView;
import com.transsion.postdetail.R$id;
import com.transsion.postdetail.R$layout;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class r implements f4.a {
    private final FrameLayout a;
    public final AppCompatImageView b;
    public final ProgressBar c;
    public final RecyclerView d;
    public final ConstraintLayout e;
    public final TnTextView f;

    private r(FrameLayout frameLayout, AppCompatImageView appCompatImageView, ProgressBar progressBar, RecyclerView recyclerView, ConstraintLayout constraintLayout, TnTextView tnTextView) {
        this.a = frameLayout;
        this.b = appCompatImageView;
        this.c = progressBar;
        this.d = recyclerView;
        this.e = constraintLayout;
        this.f = tnTextView;
    }

    public static r a(View view) {
        RecyclerView a;
        ConstraintLayout a2;
        TnTextView a3;
        int i = R$id.iv_back;
        AppCompatImageView a4 = f4.b.a(view, i);
        if (a4 != null) {
            i = R$id.pb_loading;
            ProgressBar progressBar = (ProgressBar) f4.b.a(view, i);
            if (progressBar != null && (a = f4.b.a(view, (i = R$id.recycler_view))) != null && (a2 = f4.b.a(view, (i = R$id.tool_bar))) != null && (a3 = f4.b.a(view, (i = R$id.tv_title))) != null) {
                return new r((FrameLayout) view, a4, progressBar, a, a2, a3);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static r c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static r d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R$layout.fragment_short_tv_immersion_video_detail, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.a;
    }
}
