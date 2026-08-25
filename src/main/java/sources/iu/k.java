package iu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentContainerView;
import androidx.recyclerview.widget.RecyclerView;
import com.transsion.ugcvideodetail.R$id;
import com.transsion.ugcvideodetail.R$layout;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class k implements f4.a {
    private final ConstraintLayout a;
    public final ConstraintLayout b;
    public final FragmentContainerView c;
    public final AppCompatImageView d;
    public final RecyclerView e;
    public final AppCompatTextView f;
    public final View g;

    private k(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, FragmentContainerView fragmentContainerView, AppCompatImageView appCompatImageView, RecyclerView recyclerView, AppCompatTextView appCompatTextView, View view) {
        this.a = constraintLayout;
        this.b = constraintLayout2;
        this.c = fragmentContainerView;
        this.d = appCompatImageView;
        this.e = recyclerView;
        this.f = appCompatTextView;
        this.g = view;
    }

    public static k a(View view) {
        AppCompatImageView a;
        RecyclerView a2;
        AppCompatTextView a3;
        View a4;
        ConstraintLayout constraintLayout = (ConstraintLayout) view;
        int i = R$id.fragmentContainer;
        FragmentContainerView a5 = f4.b.a(view, i);
        if (a5 == null || (a = f4.b.a(view, (i = R$id.ivClose))) == null || (a2 = f4.b.a(view, (i = R$id.rvTabs))) == null || (a3 = f4.b.a(view, (i = R$id.tvPageTitle))) == null || (a4 = f4.b.a(view, (i = R$id.vTitleLine))) == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }
        return new k(constraintLayout, constraintLayout, a5, a, a2, a3, a4);
    }

    public static k c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static k d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R$layout.fragment_ugc_video_detail_play_list_tab, viewGroup, false);
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
