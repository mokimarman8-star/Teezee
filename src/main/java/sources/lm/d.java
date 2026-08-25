package lm;

import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.noober.background.view.BLLinearLayout;
import com.noober.background.view.BLTextView;
import com.tn.lib.view.MaxHeightNestedScrollView;
import com.transsion.moviedetail.R$id;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class d implements f4.a {
    private final BLLinearLayout a;
    public final ImageView b;
    public final LinearLayoutCompat c;
    public final MaxHeightNestedScrollView d;
    public final BLTextView e;
    public final BLTextView f;
    public final AppCompatTextView g;
    public final AppCompatTextView h;

    private d(BLLinearLayout bLLinearLayout, ImageView imageView, LinearLayoutCompat linearLayoutCompat, MaxHeightNestedScrollView maxHeightNestedScrollView, BLTextView bLTextView, BLTextView bLTextView2, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2) {
        this.a = bLLinearLayout;
        this.b = imageView;
        this.c = linearLayoutCompat;
        this.d = maxHeightNestedScrollView;
        this.e = bLTextView;
        this.f = bLTextView2;
        this.g = appCompatTextView;
        this.h = appCompatTextView2;
    }

    public static d a(View view) {
        LinearLayoutCompat a;
        MaxHeightNestedScrollView a2;
        BLTextView a3;
        BLTextView a4;
        AppCompatTextView a5;
        AppCompatTextView a6;
        int i = R$id.iv_select;
        ImageView imageView = (ImageView) f4.b.a(view, i);
        if (imageView == null || (a = f4.b.a(view, (i = R$id.ll_select))) == null || (a2 = f4.b.a(view, (i = R$id.ns_tips))) == null || (a3 = f4.b.a(view, (i = R$id.tv_back))) == null || (a4 = f4.b.a(view, (i = R$id.tv_confirm))) == null || (a5 = f4.b.a(view, (i = R$id.tv_tips))) == null || (a6 = f4.b.a(view, (i = R$id.tv_title))) == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }
        return new d((BLLinearLayout) view, imageView, a, a2, a3, a4, a5, a6);
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public BLLinearLayout getRoot() {
        return this.a;
    }
}
