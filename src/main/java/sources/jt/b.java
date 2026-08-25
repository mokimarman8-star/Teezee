package jt;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.transsion.subtitle.R$id;
import com.transsion.subtitle.R$layout;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class b implements f4.a {
    private final FrameLayout a;
    public final FrameLayout b;
    public final LinearLayoutCompat c;
    public final RecyclerView d;
    public final ProgressBar e;

    private b(FrameLayout frameLayout, FrameLayout frameLayout2, LinearLayoutCompat linearLayoutCompat, RecyclerView recyclerView, ProgressBar progressBar) {
        this.a = frameLayout;
        this.b = frameLayout2;
        this.c = linearLayoutCompat;
        this.d = recyclerView;
        this.e = progressBar;
    }

    public static b a(View view) {
        RecyclerView a;
        FrameLayout frameLayout = (FrameLayout) view;
        int i = R$id.ll_loading;
        LinearLayoutCompat a2 = f4.b.a(view, i);
        if (a2 != null && (a = f4.b.a(view, (i = R$id.recycler_view))) != null) {
            i = R$id.view_load;
            ProgressBar progressBar = (ProgressBar) f4.b.a(view, i);
            if (progressBar != null) {
                return new b(frameLayout, frameLayout, a2, a, progressBar);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static b c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static b d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R$layout.dialog_subtitle_search_result_list, viewGroup, false);
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
