package vp;

import android.view.View;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.imageview.ShapeableImageView;
import com.tn.lib.view.CornerTextView;
import com.transsion.search.R$id;
import com.transsnet.downloader.widget.DownloadView;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class m implements f4.a {
    private final View a;
    public final ShapeableImageView b;
    public final CornerTextView c;
    public final View d;
    public final DownloadView e;
    public final RecyclerView f;
    public final LinearLayout g;
    public final AppCompatTextView h;
    public final AppCompatTextView i;
    public final AppCompatTextView j;

    private m(View view, ShapeableImageView shapeableImageView, CornerTextView cornerTextView, View view2, DownloadView downloadView, RecyclerView recyclerView, LinearLayout linearLayout, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, AppCompatTextView appCompatTextView3) {
        this.a = view;
        this.b = shapeableImageView;
        this.c = cornerTextView;
        this.d = view2;
        this.e = downloadView;
        this.f = recyclerView;
        this.g = linearLayout;
        this.h = appCompatTextView;
        this.i = appCompatTextView2;
        this.j = appCompatTextView3;
    }

    public static m a(View view) {
        CornerTextView a;
        View a2;
        DownloadView a3;
        RecyclerView a4;
        AppCompatTextView a5;
        AppCompatTextView a6;
        AppCompatTextView a7;
        int i = R$id.ivCover;
        ShapeableImageView a8 = f4.b.a(view, i);
        if (a8 != null && (a = f4.b.a(view, (i = R$id.ivSearchCorner))) != null && (a2 = f4.b.a(view, (i = R$id.line))) != null && (a3 = f4.b.a(view, (i = R$id.llDownload))) != null && (a4 = f4.b.a(view, (i = R$id.rvSeasons))) != null) {
            i = R$id.tagContentLL;
            LinearLayout linearLayout = (LinearLayout) f4.b.a(view, i);
            if (linearLayout != null && (a5 = f4.b.a(view, (i = R$id.tvSubject))) != null && (a6 = f4.b.a(view, (i = R$id.tvSubjectScore))) != null && (a7 = f4.b.a(view, (i = R$id.tvSubjectYear))) != null) {
                return new m(view, a8, a, a2, a3, a4, linearLayout, a5, a6, a7);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public View getRoot() {
        return this.a;
    }
}
