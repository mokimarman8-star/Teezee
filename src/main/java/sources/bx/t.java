package bx;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;
import com.transsnet.downloader.R;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class t implements f4.a {
    private final FrameLayout a;
    public final RecyclerView b;
    public final FrameLayout c;
    public final AppCompatTextView d;
    public final AppCompatTextView e;
    public final AppCompatTextView f;

    private t(FrameLayout frameLayout, RecyclerView recyclerView, FrameLayout frameLayout2, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, AppCompatTextView appCompatTextView3) {
        this.a = frameLayout;
        this.b = recyclerView;
        this.c = frameLayout2;
        this.d = appCompatTextView;
        this.e = appCompatTextView2;
        this.f = appCompatTextView3;
    }

    public static t a(View view) {
        AppCompatTextView a;
        AppCompatTextView a2;
        int i = R.id.appRv;
        RecyclerView a3 = f4.b.a(view, i);
        if (a3 != null) {
            FrameLayout frameLayout = (FrameLayout) view;
            i = R.id.tvApp;
            AppCompatTextView a4 = f4.b.a(view, i);
            if (a4 != null && (a = f4.b.a(view, (i = R.id.tvAppNum))) != null && (a2 = f4.b.a(view, (i = R.id.tvTitle))) != null) {
                return new t(frameLayout, a3, frameLayout, a4, a, a2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static t c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static t d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_app_download_ad_layout, viewGroup, false);
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
