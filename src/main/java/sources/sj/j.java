package sj;

import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import com.google.android.material.imageview.ShapeableImageView;
import com.transsion.commercialization.R$id;
import com.transsion.commercialization.pslink.PsLinkDownLoadButton;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class j implements f4.a {
    private final View a;
    public final ShapeableImageView b;
    public final AppCompatTextView c;
    public final AppCompatTextView d;
    public final PsLinkDownLoadButton e;
    public final AppCompatTextView f;
    public final AppCompatTextView g;
    public final AppCompatTextView h;
    public final View i;

    private j(View view, ShapeableImageView shapeableImageView, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, PsLinkDownLoadButton psLinkDownLoadButton, AppCompatTextView appCompatTextView3, AppCompatTextView appCompatTextView4, AppCompatTextView appCompatTextView5, View view2) {
        this.a = view;
        this.b = shapeableImageView;
        this.c = appCompatTextView;
        this.d = appCompatTextView2;
        this.e = psLinkDownLoadButton;
        this.f = appCompatTextView3;
        this.g = appCompatTextView4;
        this.h = appCompatTextView5;
        this.i = view2;
    }

    public static j a(View view) {
        AppCompatTextView a;
        AppCompatTextView a2;
        AppCompatTextView a3;
        AppCompatTextView a4;
        AppCompatTextView a5;
        View a6;
        int i = R$id.iv_cover;
        ShapeableImageView a7 = f4.b.a(view, i);
        if (a7 != null && (a = f4.b.a(view, (i = R$id.tv_aha_btn))) != null && (a2 = f4.b.a(view, (i = R$id.tv_category))) != null) {
            i = R$id.tv_ps_btn;
            PsLinkDownLoadButton psLinkDownLoadButton = (PsLinkDownLoadButton) f4.b.a(view, i);
            if (psLinkDownLoadButton != null && (a3 = f4.b.a(view, (i = R$id.tv_size))) != null && (a4 = f4.b.a(view, (i = R$id.tv_star))) != null && (a5 = f4.b.a(view, (i = R$id.tv_title))) != null && (a6 = f4.b.a(view, (i = R$id.v_line))) != null) {
                return new j(view, a7, a, a2, psLinkDownLoadButton, a3, a4, a5, a6);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public View getRoot() {
        return this.a;
    }
}
