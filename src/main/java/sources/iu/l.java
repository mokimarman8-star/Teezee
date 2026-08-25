package iu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.transsion.ugcvideodetail.R$id;
import com.transsion.ugcvideodetail.R$layout;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class l implements f4.a {
    private final ConstraintLayout a;
    public final ProgressBar b;
    public final RecyclerView c;

    private l(ConstraintLayout constraintLayout, ProgressBar progressBar, RecyclerView recyclerView) {
        this.a = constraintLayout;
        this.b = progressBar;
        this.c = recyclerView;
    }

    public static l a(View view) {
        RecyclerView a;
        int i = R$id.progressBar;
        ProgressBar progressBar = (ProgressBar) f4.b.a(view, i);
        if (progressBar == null || (a = f4.b.a(view, (i = R$id.recyclerView))) == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }
        return new l((ConstraintLayout) view, progressBar, a);
    }

    public static l c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static l d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R$layout.fragment_ugc_video_detail_play_list_tab_content, viewGroup, false);
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
