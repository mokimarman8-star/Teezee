package bx;

import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.Group;
import androidx.recyclerview.widget.RecyclerView;
import com.noober.background.view.BLView;
import com.tn.lib.widget.TnTextView;
import com.transsnet.downloader.R;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class u0 implements f4.a {
    private final View a;
    public final Group b;
    public final AppCompatImageView c;
    public final RecyclerView d;
    public final TnTextView e;
    public final TnTextView f;
    public final BLView g;

    private u0(View view, Group group, AppCompatImageView appCompatImageView, RecyclerView recyclerView, TnTextView tnTextView, TnTextView tnTextView2, BLView bLView) {
        this.a = view;
        this.b = group;
        this.c = appCompatImageView;
        this.d = recyclerView;
        this.e = tnTextView;
        this.f = tnTextView2;
        this.g = bLView;
    }

    public static u0 a(View view) {
        AppCompatImageView a;
        RecyclerView a2;
        TnTextView a3;
        TnTextView a4;
        BLView a5;
        int i = R.id.group_refresh;
        Group a6 = f4.b.a(view, i);
        if (a6 == null || (a = f4.b.a(view, (i = R.id.iv_refresh_progress))) == null || (a2 = f4.b.a(view, (i = R.id.recycler_view))) == null || (a3 = f4.b.a(view, (i = R.id.tv_refresh))) == null || (a4 = f4.b.a(view, (i = R.id.tv_title))) == null || (a5 = f4.b.a(view, (i = R.id.v_refresh))) == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }
        return new u0(view, a6, a, a2, a3, a4, a5);
    }

    public View getRoot() {
        return this.a;
    }
}
