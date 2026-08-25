package qr;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;
import com.noober.background.view.BLConstraintLayout;
import com.transsion.shorttv.R;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class c implements f4.a {
    private final BLConstraintLayout a;
    public final FrameLayout b;
    public final AppCompatImageView c;
    public final ProgressBar d;
    public final RecyclerView e;
    public final AppCompatTextView f;
    public final View g;

    private c(BLConstraintLayout bLConstraintLayout, FrameLayout frameLayout, AppCompatImageView appCompatImageView, ProgressBar progressBar, RecyclerView recyclerView, AppCompatTextView appCompatTextView, View view) {
        this.a = bLConstraintLayout;
        this.b = frameLayout;
        this.c = appCompatImageView;
        this.d = progressBar;
        this.e = recyclerView;
        this.f = appCompatTextView;
        this.g = view;
    }

    public static c a(View view) {
        AppCompatImageView a;
        RecyclerView a2;
        AppCompatTextView a3;
        View a4;
        int i = R.id.content_container;
        FrameLayout frameLayout = (FrameLayout) f4.b.a(view, i);
        if (frameLayout != null && (a = f4.b.a(view, (i = R.id.iv_close))) != null) {
            i = R.id.pb_loading;
            ProgressBar progressBar = (ProgressBar) f4.b.a(view, i);
            if (progressBar != null && (a2 = f4.b.a(view, (i = R.id.tabs_rv))) != null && (a3 = f4.b.a(view, (i = R.id.tv_title))) != null && (a4 = f4.b.a(view, (i = R.id.view_line))) != null) {
                return new c((BLConstraintLayout) view, frameLayout, a, progressBar, a2, a3, a4);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public BLConstraintLayout getRoot() {
        return this.a;
    }
}
