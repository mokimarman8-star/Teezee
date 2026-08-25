package wn;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.transsion.postdetail.R$id;
import com.transsion.postdetail.R$layout;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class h implements f4.a {
    private final LinearLayoutCompat a;
    public final View b;
    public final RecyclerView c;
    public final LinearLayout d;
    public final AppCompatTextView e;
    public final AppCompatTextView f;
    public final ProgressBar g;

    private h(LinearLayoutCompat linearLayoutCompat, View view, RecyclerView recyclerView, LinearLayout linearLayout, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, ProgressBar progressBar) {
        this.a = linearLayoutCompat;
        this.b = view;
        this.c = recyclerView;
        this.d = linearLayout;
        this.e = appCompatTextView;
        this.f = appCompatTextView2;
        this.g = progressBar;
    }

    public static h a(View view) {
        RecyclerView a;
        AppCompatTextView a2;
        AppCompatTextView a3;
        int i = R$id.comment_input_bg;
        View a4 = f4.b.a(view, i);
        if (a4 != null && (a = f4.b.a(view, (i = R$id.comment_list))) != null) {
            i = R$id.ll_loading;
            LinearLayout linearLayout = (LinearLayout) f4.b.a(view, i);
            if (linearLayout != null && (a2 = f4.b.a(view, (i = R$id.tv_comment))) != null && (a3 = f4.b.a(view, (i = R$id.tv_loading))) != null) {
                i = R$id.view_load;
                ProgressBar progressBar = (ProgressBar) f4.b.a(view, i);
                if (progressBar != null) {
                    return new h((LinearLayoutCompat) view, a4, a, linearLayout, a2, a3, progressBar);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static h c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static h d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R$layout.fragment_comment, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayoutCompat getRoot() {
        return this.a;
    }
}
