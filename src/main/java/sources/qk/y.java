package qk;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.tn.lib.view.TitleLayout;
import com.tn.lib.widget.TnTextView;
import com.transsion.home.R;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class y implements f4.a {
    private final ConstraintLayout a;
    public final View b;
    public final View c;
    public final RecyclerView d;
    public final FrameLayout e;
    public final FrameLayout f;
    public final ImageView g;
    public final ConstraintLayout h;
    public final TitleLayout i;
    public final TnTextView j;

    private y(ConstraintLayout constraintLayout, View view, View view2, RecyclerView recyclerView, FrameLayout frameLayout, FrameLayout frameLayout2, ImageView imageView, ConstraintLayout constraintLayout2, TitleLayout titleLayout, TnTextView tnTextView) {
        this.a = constraintLayout;
        this.b = view;
        this.c = view2;
        this.d = recyclerView;
        this.e = frameLayout;
        this.f = frameLayout2;
        this.g = imageView;
        this.h = constraintLayout2;
        this.i = titleLayout;
        this.j = tnTextView;
    }

    public static y a(View view) {
        View a;
        RecyclerView a2;
        ConstraintLayout a3;
        TitleLayout a4;
        TnTextView a5;
        int i = R.id.film_list_color_mask;
        View a6 = f4.b.a(view, i);
        if (a6 != null && (a = f4.b.a(view, (i = R.id.film_list_gradient))) != null && (a2 = f4.b.a(view, (i = R.id.ranking_category_recycler))) != null) {
            i = R.id.ranking_error;
            FrameLayout frameLayout = (FrameLayout) f4.b.a(view, i);
            if (frameLayout != null) {
                i = R.id.ranking_list_container;
                FrameLayout frameLayout2 = (FrameLayout) f4.b.a(view, i);
                if (frameLayout2 != null) {
                    i = R.id.ranking_list_cover;
                    ImageView imageView = (ImageView) f4.b.a(view, i);
                    if (imageView != null && (a3 = f4.b.a(view, (i = R.id.ranking_loading_frame))) != null && (a4 = f4.b.a(view, (i = R.id.ranking_title))) != null && (a5 = f4.b.a(view, (i = R.id.tv_titleText))) != null) {
                        return new y((ConstraintLayout) view, a6, a, a2, frameLayout, frameLayout2, imageView, a3, a4, a5);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static y c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static y d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_ugc_ranking, viewGroup, false);
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
