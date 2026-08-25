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
public final class u implements f4.a {
    private final FrameLayout a;
    public final BLConstraintLayout b;
    public final FrameLayout c;
    public final AppCompatImageView d;
    public final RecyclerView e;
    public final AppCompatTextView f;

    private u(FrameLayout frameLayout, BLConstraintLayout bLConstraintLayout, FrameLayout frameLayout2, AppCompatImageView appCompatImageView, RecyclerView recyclerView, AppCompatTextView appCompatTextView) {
        this.a = frameLayout;
        this.b = bLConstraintLayout;
        this.c = frameLayout2;
        this.d = appCompatImageView;
        this.e = recyclerView;
        this.f = appCompatTextView;
    }

    public static u a(View view) {
        RecyclerView a;
        AppCompatTextView a2;
        int i = R.id.cl_content;
        BLConstraintLayout a3 = f4.b.a(view, i);
        if (a3 != null) {
            FrameLayout frameLayout = (FrameLayout) view;
            i = R.id.iv_close;
            AppCompatImageView a4 = f4.b.a(view, i);
            if (a4 != null && (a = f4.b.a(view, (i = R.id.rv))) != null && (a2 = f4.b.a(view, (i = R.id.tv_title))) != null) {
                return new u(frameLayout, a3, frameLayout, a4, a, a2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static u c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static u d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_download_audio_track, viewGroup, false);
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
