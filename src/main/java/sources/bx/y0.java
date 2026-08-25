package bx;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.Space;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;
import com.noober.background.view.BLTextView;
import com.transsnet.downloader.R;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class y0 implements f4.a {
    private final View a;
    public final AppCompatImageView b;
    public final AppCompatTextView c;
    public final AppCompatTextView d;
    public final AppCompatTextView e;
    public final BLTextView f;
    public final LinearLayout g;
    public final RecyclerView h;
    public final BLTextView i;
    public final Space j;
    public final View k;

    private y0(View view, AppCompatImageView appCompatImageView, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, AppCompatTextView appCompatTextView3, BLTextView bLTextView, LinearLayout linearLayout, RecyclerView recyclerView, BLTextView bLTextView2, Space space, View view2) {
        this.a = view;
        this.b = appCompatImageView;
        this.c = appCompatTextView;
        this.d = appCompatTextView2;
        this.e = appCompatTextView3;
        this.f = bLTextView;
        this.g = linearLayout;
        this.h = recyclerView;
        this.i = bLTextView2;
        this.j = space;
        this.k = view2;
    }

    public static y0 a(View view) {
        AppCompatTextView a;
        AppCompatTextView a2;
        AppCompatTextView a3;
        BLTextView a4;
        RecyclerView a5;
        BLTextView a6;
        View a7;
        int i = R.id.innerIcon;
        AppCompatImageView a8 = f4.b.a(view, i);
        if (a8 != null && (a = f4.b.a(view, (i = R.id.innerTvInfo))) != null && (a2 = f4.b.a(view, (i = R.id.innerTvName))) != null && (a3 = f4.b.a(view, (i = R.id.innerTvTitle))) != null && (a4 = f4.b.a(view, (i = R.id.iv_seasons))) != null) {
            i = R.id.llLanguage;
            LinearLayout linearLayout = (LinearLayout) f4.b.a(view, i);
            if (linearLayout != null && (a5 = f4.b.a(view, (i = R.id.quality_recycler_view))) != null && (a6 = f4.b.a(view, (i = R.id.tvLanguage))) != null) {
                i = R.id.v_bottom_space;
                Space space = (Space) f4.b.a(view, i);
                if (space != null && (a7 = f4.b.a(view, (i = R.id.v_line))) != null) {
                    return new y0(view, a8, a, a2, a3, a4, linearLayout, a5, a6, space, a7);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public View getRoot() {
        return this.a;
    }
}
