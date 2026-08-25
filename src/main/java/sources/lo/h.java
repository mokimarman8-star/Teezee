package lo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.tn.lib.view.LoadingAnimView;
import com.tn.lib.view.bubbleview.BubbleTextView;
import com.transsion.publish.R$id;
import com.transsion.publish.R$layout;
import com.transsion.publish.view.ObservableScrollView;
import com.transsion.publish.view.operation.OperationBarView;
import com.transsion.publish.view.operation.OperationVerticalBarView;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class h implements f4.a {
    private final RelativeLayout a;
    public final BubbleTextView b;
    public final EditText c;
    public final EditText d;
    public final FrameLayout e;
    public final FrameLayout f;
    public final ImageView g;
    public final ImageView h;
    public final RelativeLayout i;
    public final LinearLayout j;
    public final LoadingAnimView k;
    public final OperationVerticalBarView l;
    public final OperationBarView m;
    public final RatingBar n;
    public final RelativeLayout o;
    public final RelativeLayout p;
    public final RelativeLayout q;
    public final RecyclerView r;
    public final RecyclerView s;
    public final ObservableScrollView t;
    public final TextView u;
    public final TextView v;
    public final TextView w;
    public final View x;

    private h(RelativeLayout relativeLayout, BubbleTextView bubbleTextView, EditText editText, EditText editText2, FrameLayout frameLayout, FrameLayout frameLayout2, ImageView imageView, ImageView imageView2, RelativeLayout relativeLayout2, LinearLayout linearLayout, LoadingAnimView loadingAnimView, OperationVerticalBarView operationVerticalBarView, OperationBarView operationBarView, RatingBar ratingBar, RelativeLayout relativeLayout3, RelativeLayout relativeLayout4, RelativeLayout relativeLayout5, RecyclerView recyclerView, RecyclerView recyclerView2, ObservableScrollView observableScrollView, TextView textView, TextView textView2, TextView textView3, View view) {
        this.a = relativeLayout;
        this.b = bubbleTextView;
        this.c = editText;
        this.d = editText2;
        this.e = frameLayout;
        this.f = frameLayout2;
        this.g = imageView;
        this.h = imageView2;
        this.i = relativeLayout2;
        this.j = linearLayout;
        this.k = loadingAnimView;
        this.l = operationVerticalBarView;
        this.m = operationBarView;
        this.n = ratingBar;
        this.o = relativeLayout3;
        this.p = relativeLayout4;
        this.q = relativeLayout5;
        this.r = recyclerView;
        this.s = recyclerView2;
        this.t = observableScrollView;
        this.u = textView;
        this.v = textView2;
        this.w = textView3;
        this.x = view;
    }

    public static h a(View view) {
        LoadingAnimView a;
        RecyclerView a2;
        RecyclerView a3;
        View a4;
        int i = R$id.activity_tip;
        BubbleTextView a5 = f4.b.a(view, i);
        if (a5 != null) {
            i = R$id.et_des;
            EditText editText = (EditText) f4.b.a(view, i);
            if (editText != null) {
                i = R$id.et_title;
                EditText editText2 = (EditText) f4.b.a(view, i);
                if (editText2 != null) {
                    i = R$id.fl_top;
                    FrameLayout frameLayout = (FrameLayout) f4.b.a(view, i);
                    if (frameLayout != null) {
                        i = R$id.fr_title;
                        FrameLayout frameLayout2 = (FrameLayout) f4.b.a(view, i);
                        if (frameLayout2 != null) {
                            i = R$id.iv_cover;
                            ImageView imageView = (ImageView) f4.b.a(view, i);
                            if (imageView != null) {
                                i = R$id.iv_cover_ic;
                                ImageView imageView2 = (ImageView) f4.b.a(view, i);
                                if (imageView2 != null) {
                                    i = R$id.ll_list;
                                    RelativeLayout relativeLayout = (RelativeLayout) f4.b.a(view, i);
                                    if (relativeLayout != null) {
                                        i = R$id.ll_top;
                                        LinearLayout linearLayout = (LinearLayout) f4.b.a(view, i);
                                        if (linearLayout != null && (a = f4.b.a(view, (i = R$id.loading_view))) != null) {
                                            i = R$id.oper_vertical_view;
                                            OperationVerticalBarView operationVerticalBarView = (OperationVerticalBarView) f4.b.a(view, i);
                                            if (operationVerticalBarView != null) {
                                                i = R$id.oper_view;
                                                OperationBarView operationBarView = (OperationBarView) f4.b.a(view, i);
                                                if (operationBarView != null) {
                                                    i = R$id.rb_star;
                                                    RatingBar ratingBar = (RatingBar) f4.b.a(view, i);
                                                    if (ratingBar != null) {
                                                        i = R$id.rl_add_cover;
                                                        RelativeLayout relativeLayout2 = (RelativeLayout) f4.b.a(view, i);
                                                        if (relativeLayout2 != null) {
                                                            RelativeLayout relativeLayout3 = (RelativeLayout) view;
                                                            i = R$id.rl_star;
                                                            RelativeLayout relativeLayout4 = (RelativeLayout) f4.b.a(view, i);
                                                            if (relativeLayout4 != null && (a2 = f4.b.a(view, (i = R$id.rv_link))) != null && (a3 = f4.b.a(view, (i = R$id.rv_select))) != null) {
                                                                i = R$id.scrollView;
                                                                ObservableScrollView observableScrollView = (ObservableScrollView) f4.b.a(view, i);
                                                                if (observableScrollView != null) {
                                                                    i = R$id.tv_click_stars;
                                                                    TextView textView = (TextView) f4.b.a(view, i);
                                                                    if (textView != null) {
                                                                        i = R$id.tv_star_tips;
                                                                        TextView textView2 = (TextView) f4.b.a(view, i);
                                                                        if (textView2 != null) {
                                                                            i = R$id.tv_title_tips;
                                                                            TextView textView3 = (TextView) f4.b.a(view, i);
                                                                            if (textView3 != null && (a4 = f4.b.a(view, (i = R$id.view_line2))) != null) {
                                                                                return new h(relativeLayout3, a5, editText, editText2, frameLayout, frameLayout2, imageView, imageView2, relativeLayout, linearLayout, a, operationVerticalBarView, operationBarView, ratingBar, relativeLayout2, relativeLayout3, relativeLayout4, a2, a3, observableScrollView, textView, textView2, textView3, a4);
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
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

    public static h c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static h d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R$layout.fragment_film_review, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public RelativeLayout getRoot() {
        return this.a;
    }
}
