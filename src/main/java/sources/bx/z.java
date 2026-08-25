package bx;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;
import com.transsnet.downloader.R;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class z implements f4.a {
    private final FrameLayout a;
    public final LinearLayout b;
    public final LinearLayout c;
    public final RecyclerView d;
    public final AppCompatTextView e;
    public final AppCompatTextView f;
    public final AppCompatTextView g;
    public final ProgressBar h;

    private z(FrameLayout frameLayout, LinearLayout linearLayout, LinearLayout linearLayout2, RecyclerView recyclerView, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, AppCompatTextView appCompatTextView3, ProgressBar progressBar) {
        this.a = frameLayout;
        this.b = linearLayout;
        this.c = linearLayout2;
        this.d = recyclerView;
        this.e = appCompatTextView;
        this.f = appCompatTextView2;
        this.g = appCompatTextView3;
        this.h = progressBar;
    }

    public static z a(View view) {
        RecyclerView a;
        AppCompatTextView a2;
        AppCompatTextView a3;
        AppCompatTextView a4;
        int i = R.id.ll_loading;
        LinearLayout linearLayout = (LinearLayout) f4.b.a(view, i);
        if (linearLayout != null) {
            i = R.id.ll_not_net;
            LinearLayout linearLayout2 = (LinearLayout) f4.b.a(view, i);
            if (linearLayout2 != null && (a = f4.b.a(view, (i = R.id.recycler_view))) != null && (a2 = f4.b.a(view, (i = R.id.tv_loading))) != null && (a3 = f4.b.a(view, (i = R.id.tv_no_network_content))) != null && (a4 = f4.b.a(view, (i = R.id.tv_retry))) != null) {
                i = R.id.view_load;
                ProgressBar progressBar = (ProgressBar) f4.b.a(view, i);
                if (progressBar != null) {
                    return new z((FrameLayout) view, linearLayout, linearLayout2, a, a2, a3, a4, progressBar);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static z c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static z d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_download_res_group, viewGroup, false);
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
