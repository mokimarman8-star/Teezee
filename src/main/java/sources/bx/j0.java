package bx;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;
import com.noober.background.view.BLConstraintLayout;
import com.transsnet.downloader.R;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class j0 implements f4.a {
    private final FrameLayout a;
    public final BLConstraintLayout b;
    public final View c;
    public final FrameLayout d;
    public final AppCompatImageView e;
    public final RecyclerView f;
    public final AppCompatTextView g;
    public final AppCompatTextView h;

    private j0(FrameLayout frameLayout, BLConstraintLayout bLConstraintLayout, View view, FrameLayout frameLayout2, AppCompatImageView appCompatImageView, RecyclerView recyclerView, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2) {
        this.a = frameLayout;
        this.b = bLConstraintLayout;
        this.c = view;
        this.d = frameLayout2;
        this.e = appCompatImageView;
        this.f = recyclerView;
        this.g = appCompatTextView;
        this.h = appCompatTextView2;
    }

    public static j0 a(View view) {
        View a;
        RecyclerView a2;
        AppCompatTextView a3;
        AppCompatTextView a4;
        int i = R.id.cl_content;
        BLConstraintLayout a5 = f4.b.a(view, i);
        if (a5 != null && (a = f4.b.a(view, (i = R.id.divider))) != null) {
            FrameLayout frameLayout = (FrameLayout) view;
            i = R.id.iv_close;
            AppCompatImageView a6 = f4.b.a(view, i);
            if (a6 != null && (a2 = f4.b.a(view, (i = R.id.rv))) != null && (a3 = f4.b.a(view, (i = R.id.tv_all_episodes))) != null && (a4 = f4.b.a(view, (i = R.id.tv_title))) != null) {
                return new j0(frameLayout, a5, a, frameLayout, a6, a2, a3, a4);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static j0 c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static j0 d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_seasons, viewGroup, false);
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
