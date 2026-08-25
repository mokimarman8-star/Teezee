package wn;

import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.imageview.ShapeableImageView;
import com.noober.background.view.BLLinearLayout;
import com.noober.background.view.BLTextView;
import com.transsion.postdetail.R$id;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class x implements f4.a {
    private final View a;
    public final AppCompatImageView b;
    public final AppCompatTextView c;
    public final AppCompatTextView d;
    public final ShapeableImageView e;
    public final BLLinearLayout f;
    public final BLLinearLayout g;
    public final RecyclerView h;
    public final AppCompatTextView i;
    public final BLTextView j;

    private x(View view, AppCompatImageView appCompatImageView, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, ShapeableImageView shapeableImageView, BLLinearLayout bLLinearLayout, BLLinearLayout bLLinearLayout2, RecyclerView recyclerView, AppCompatTextView appCompatTextView3, BLTextView bLTextView) {
        this.a = view;
        this.b = appCompatImageView;
        this.c = appCompatTextView;
        this.d = appCompatTextView2;
        this.e = shapeableImageView;
        this.f = bLLinearLayout;
        this.g = bLLinearLayout2;
        this.h = recyclerView;
        this.i = appCompatTextView3;
        this.j = bLTextView;
    }

    public static x a(View view) {
        AppCompatTextView a;
        AppCompatTextView a2;
        ShapeableImageView a3;
        BLLinearLayout a4;
        BLLinearLayout a5;
        RecyclerView a6;
        AppCompatTextView a7;
        BLTextView a8;
        int i = R$id.innerIcon;
        AppCompatImageView a9 = f4.b.a(view, i);
        if (a9 == null || (a = f4.b.a(view, (i = R$id.innerTvInfo))) == null || (a2 = f4.b.a(view, (i = R$id.innerTvName))) == null || (a3 = f4.b.a(view, (i = R$id.iv_cover))) == null || (a4 = f4.b.a(view, (i = R$id.ll_detail))) == null || (a5 = f4.b.a(view, (i = R$id.ll_download))) == null || (a6 = f4.b.a(view, (i = R$id.recycler_view_ep))) == null || (a7 = f4.b.a(view, (i = R$id.tv_ep_title))) == null || (a8 = f4.b.a(view, (i = R$id.tv_more))) == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }
        return new x(view, a9, a, a2, a3, a4, a5, a6, a7, a8);
    }

    public View getRoot() {
        return this.a;
    }
}
