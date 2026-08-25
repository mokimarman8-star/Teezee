package vp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.transsion.search.R$id;
import com.transsion.search.R$layout;
import com.transsion.search_pugc.ad.SearchHotAdContainerView;
import net.lucode.hackware.magicindicator.MagicIndicator;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class n implements f4.a {
    private final NestedScrollView a;
    public final SearchHotAdContainerView b;
    public final ConstraintLayout c;
    public final RecyclerView d;
    public final AppCompatImageView e;
    public final ConstraintLayout f;
    public final CardView g;
    public final ProgressBar h;
    public final ConstraintLayout i;
    public final RecyclerView j;
    public final ConstraintLayout k;
    public final ImageView l;
    public final TextView m;
    public final View n;
    public final MagicIndicator o;
    public final ImageView p;
    public final RelativeLayout q;
    public final ViewPager2 r;
    public final NestedScrollView s;
    public final TextView t;
    public final TextView u;

    private n(NestedScrollView nestedScrollView, SearchHotAdContainerView searchHotAdContainerView, ConstraintLayout constraintLayout, RecyclerView recyclerView, AppCompatImageView appCompatImageView, ConstraintLayout constraintLayout2, CardView cardView, ProgressBar progressBar, ConstraintLayout constraintLayout3, RecyclerView recyclerView2, ConstraintLayout constraintLayout4, ImageView imageView, TextView textView, View view, MagicIndicator magicIndicator, ImageView imageView2, RelativeLayout relativeLayout, ViewPager2 viewPager2, NestedScrollView nestedScrollView2, TextView textView2, TextView textView3) {
        this.a = nestedScrollView;
        this.b = searchHotAdContainerView;
        this.c = constraintLayout;
        this.d = recyclerView;
        this.e = appCompatImageView;
        this.f = constraintLayout2;
        this.g = cardView;
        this.h = progressBar;
        this.i = constraintLayout3;
        this.j = recyclerView2;
        this.k = constraintLayout4;
        this.l = imageView;
        this.m = textView;
        this.n = view;
        this.o = magicIndicator;
        this.p = imageView2;
        this.q = relativeLayout;
        this.r = viewPager2;
        this.s = nestedScrollView2;
        this.t = textView2;
        this.u = textView3;
    }

    public static n a(View view) {
        ConstraintLayout a;
        RecyclerView a2;
        AppCompatImageView a3;
        ConstraintLayout a4;
        CardView a5;
        ConstraintLayout a6;
        RecyclerView a7;
        ConstraintLayout a8;
        View a9;
        MagicIndicator a10;
        ViewPager2 a11;
        int i = R$id.ad_container_view;
        SearchHotAdContainerView searchHotAdContainerView = (SearchHotAdContainerView) f4.b.a(view, i);
        if (searchHotAdContainerView != null && (a = f4.b.a(view, (i = R$id.empty_view))) != null && (a2 = f4.b.a(view, (i = R$id.everyone_search_rv))) != null && (a3 = f4.b.a(view, (i = R$id.iv_empty))) != null && (a4 = f4.b.a(view, (i = R$id.layout_history))) != null && (a5 = f4.b.a(view, (i = R$id.native_ad_container))) != null) {
            i = R$id.progress_bar;
            ProgressBar progressBar = (ProgressBar) f4.b.a(view, i);
            if (progressBar != null && (a6 = f4.b.a(view, (i = R$id.rl_tips))) != null && (a7 = f4.b.a(view, (i = R$id.rv_history))) != null && (a8 = f4.b.a(view, (i = R$id.search_hot_everyone_linear))) != null) {
                i = R$id.search_hot_everyone_title_image;
                ImageView imageView = (ImageView) f4.b.a(view, i);
                if (imageView != null) {
                    i = R$id.search_hot_everyone_title_text;
                    TextView textView = (TextView) f4.b.a(view, i);
                    if (textView != null && (a9 = f4.b.a(view, (i = R$id.search_hot_rank_indicator_linear))) != null && (a10 = f4.b.a(view, (i = R$id.search_hot_rank_magic_indicator))) != null) {
                        i = R$id.search_hot_rank_magic_indicator_image;
                        ImageView imageView2 = (ImageView) f4.b.a(view, i);
                        if (imageView2 != null) {
                            i = R$id.search_hot_rank_magic_indicator_ll;
                            RelativeLayout relativeLayout = (RelativeLayout) f4.b.a(view, i);
                            if (relativeLayout != null && (a11 = f4.b.a(view, (i = R$id.search_hot_rank_view_pager))) != null) {
                                NestedScrollView nestedScrollView = (NestedScrollView) view;
                                i = R$id.tv_clear;
                                TextView textView2 = (TextView) f4.b.a(view, i);
                                if (textView2 != null) {
                                    i = R$id.tv_refresh;
                                    TextView textView3 = (TextView) f4.b.a(view, i);
                                    if (textView3 != null) {
                                        return new n(nestedScrollView, searchHotAdContainerView, a, a2, a3, a4, a5, progressBar, a6, a7, a8, imageView, textView, a9, a10, imageView2, relativeLayout, a11, nestedScrollView, textView2, textView3);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static n c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static n d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R$layout.pugc_fragment_hot_search, viewGroup, false);
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
