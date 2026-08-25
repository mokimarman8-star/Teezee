package bx;

import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;
import com.noober.background.view.BLFrameLayout;
import com.transsnet.downloader.R;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class k1 implements f4.a {
    private final View a;
    public final BLFrameLayout b;
    public final AppCompatImageView c;
    public final RecyclerView d;
    public final AppCompatTextView e;
    public final View f;

    private k1(View view, BLFrameLayout bLFrameLayout, AppCompatImageView appCompatImageView, RecyclerView recyclerView, AppCompatTextView appCompatTextView, View view2) {
        this.a = view;
        this.b = bLFrameLayout;
        this.c = appCompatImageView;
        this.d = recyclerView;
        this.e = appCompatTextView;
        this.f = view2;
    }

    public static k1 a(View view) {
        AppCompatImageView a;
        RecyclerView a2;
        AppCompatTextView a3;
        View a4;
        int i = R.id.fl_content;
        BLFrameLayout a5 = f4.b.a(view, i);
        if (a5 == null || (a = f4.b.a(view, (i = R.id.iv_close))) == null || (a2 = f4.b.a(view, (i = R.id.recycler_view))) == null || (a3 = f4.b.a(view, (i = R.id.tv_title))) == null || (a4 = f4.b.a(view, (i = R.id.v_top_bg))) == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }
        return new k1(view, a5, a, a2, a3, a4);
    }

    public View getRoot() {
        return this.a;
    }
}
