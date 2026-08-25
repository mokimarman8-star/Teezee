package iu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.transsion.ugcvideodetail.R$id;
import com.transsion.ugcvideodetail.R$layout;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class f implements f4.a {
    private final FrameLayout a;
    public final FrameLayout b;
    public final AppCompatImageView c;
    public final m d;
    public final ProgressBar e;
    public final RecyclerView f;

    private f(FrameLayout frameLayout, FrameLayout frameLayout2, AppCompatImageView appCompatImageView, m mVar, ProgressBar progressBar, RecyclerView recyclerView) {
        this.a = frameLayout;
        this.b = frameLayout2;
        this.c = appCompatImageView;
        this.d = mVar;
        this.e = progressBar;
        this.f = recyclerView;
    }

    public static f a(View view) {
        AppCompatImageView a;
        View a2;
        RecyclerView a3;
        int i = R$id.flUgcImmBack;
        FrameLayout frameLayout = (FrameLayout) f4.b.a(view, i);
        if (frameLayout != null && (a = f4.b.a(view, (i = R$id.ivUgcImmBack))) != null && (a2 = f4.b.a(view, (i = R$id.layoutImmDownloadingPop))) != null) {
            m a4 = m.a(a2);
            i = R$id.ugcImmPbLoading;
            ProgressBar progressBar = (ProgressBar) f4.b.a(view, i);
            if (progressBar != null && (a3 = f4.b.a(view, (i = R$id.ugcImmRecyclerView))) != null) {
                return new f((FrameLayout) view, frameLayout, a, a4, progressBar, a3);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static f c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static f d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R$layout.fragment_ugc_imm_video_detail, viewGroup, false);
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
