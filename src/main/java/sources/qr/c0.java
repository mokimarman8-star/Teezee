package qr;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import androidx.recyclerview.widget.RecyclerView;
import com.transsion.shorttv.R;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class c0 implements f4.a {
    private final FrameLayout a;
    public final ProgressBar b;
    public final RecyclerView c;

    private c0(FrameLayout frameLayout, ProgressBar progressBar, RecyclerView recyclerView) {
        this.a = frameLayout;
        this.b = progressBar;
        this.c = recyclerView;
    }

    public static c0 a(View view) {
        RecyclerView a;
        int i = R.id.pb_loading;
        ProgressBar progressBar = (ProgressBar) f4.b.a(view, i);
        if (progressBar == null || (a = f4.b.a(view, (i = R.id.recycler_view))) == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }
        return new c0((FrameLayout) view, progressBar, a);
    }

    public static c0 c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static c0 d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.short_tv_fragment_short_tv_detail, viewGroup, false);
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
