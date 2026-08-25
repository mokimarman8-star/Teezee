package vp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.transsion.search.R$id;
import com.transsion.search.R$layout;
import com.transsion.search.ad.SearchHotAdContainerView;
import net.lucode.hackware.magicindicator.MagicIndicator;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class c implements f4.a {
    private final NestedScrollView a;
    public final SearchHotAdContainerView b;
    public final RecyclerView c;
    public final CardView d;
    public final ProgressBar e;
    public final ConstraintLayout f;
    public final RecyclerView g;
    public final ConstraintLayout h;
    public final ImageView i;
    public final TextView j;
    public final View k;
    public final MagicIndicator l;
    public final ImageView m;
    public final RelativeLayout n;
    public final ViewPager2 o;
    public final NestedScrollView p;
    public final TextView q;

    private c(NestedScrollView nestedScrollView, SearchHotAdContainerView searchHotAdContainerView, RecyclerView recyclerView, CardView cardView, ProgressBar progressBar, ConstraintLayout constraintLayout, RecyclerView recyclerView2, ConstraintLayout constraintLayout2, ImageView imageView, TextView textView, View view, MagicIndicator magicIndicator, ImageView imageView2, RelativeLayout relativeLayout, ViewPager2 viewPager2, NestedScrollView nestedScrollView2, TextView textView2) {
        this.a = nestedScrollView;
        this.b = searchHotAdContainerView;
        this.c = recyclerView;
        this.d = cardView;
        this.e = progressBar;
        this.f = constraintLayout;
        this.g = recyclerView2;
        this.h = constraintLayout2;
        this.i = imageView;
        this.j = textView;
        this.k = view;
        this.l = magicIndicator;
        this.m = imageView2;
        this.n = relativeLayout;
        this.o = viewPager2;
        this.p = nestedScrollView2;
        this.q = textView2;
    }

    public static c a(View view) {
        RecyclerView a;
        CardView a2;
        ConstraintLayout a3;
        RecyclerView a4;
        ConstraintLayout a5;
        View a6;
        MagicIndicator a7;
        ViewPager2 a8;
        int i = R$id.ad_container_view;
        SearchHotAdContainerView searchHotAdContainerView = (SearchHotAdContainerView) f4.b.a(view, i);
        if (searchHotAdContainerView != null && (a = f4.b.a(view, (i = R$id.everyone_search_rv))) != null && (a2 = f4.b.a(view, (i = R$id.native_ad_container))) != null) {
            i = R$id.progress_bar;
            ProgressBar progressBar = (ProgressBar) f4.b.a(view, i);
            if (progressBar != null && (a3 = f4.b.a(view, (i = R$id.rl_tips))) != null && (a4 = f4.b.a(view, (i = R$id.rv_history))) != null && (a5 = f4.b.a(view, (i = R$id.search_hot_everyone_linear))) != null) {
                i = R$id.search_hot_everyone_title_image;
                ImageView imageView = (ImageView) f4.b.a(view, i);
                if (imageView != null) {
                    i = R$id.search_hot_everyone_title_text;
                    TextView textView = (TextView) f4.b.a(view, i);
                    if (textView != null && (a6 = f4.b.a(view, (i = R$id.search_hot_rank_indicator_linear))) != null && (a7 = f4.b.a(view, (i = R$id.search_hot_rank_magic_indicator))) != null) {
                        i = R$id.search_hot_rank_magic_indicator_image;
                        ImageView imageView2 = (ImageView) f4.b.a(view, i);
                        if (imageView2 != null) {
                            i = R$id.search_hot_rank_magic_indicator_ll;
                            RelativeLayout relativeLayout = (RelativeLayout) f4.b.a(view, i);
                            if (relativeLayout != null && (a8 = f4.b.a(view, (i = R$id.search_hot_rank_view_pager))) != null) {
                                NestedScrollView nestedScrollView = (NestedScrollView) view;
                                i = R$id.tv_clear;
                                TextView textView2 = (TextView) f4.b.a(view, i);
                                if (textView2 != null) {
                                    return new c(nestedScrollView, searchHotAdContainerView, a, a2, progressBar, a3, a4, a5, imageView, textView, a6, a7, imageView2, relativeLayout, a8, nestedScrollView, textView2);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static c c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static c d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R$layout.fragment_hot_search, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public NestedScrollView getRoot() {
        return this.a;
    }
}
