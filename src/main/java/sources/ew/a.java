package ew;

import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import com.noober.background.view.BLConstraintLayout;
import com.noober.background.view.BLView;
import com.transsion.videofloat.R$id;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class a implements f4.a {
    private final BLConstraintLayout a;
    public final AppCompatImageView b;
    public final AppCompatImageView c;
    public final AppCompatTextView d;
    public final AppCompatTextView e;
    public final BLView f;

    private a(BLConstraintLayout bLConstraintLayout, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, BLView bLView) {
        this.a = bLConstraintLayout;
        this.b = appCompatImageView;
        this.c = appCompatImageView2;
        this.d = appCompatTextView;
        this.e = appCompatTextView2;
        this.f = bLView;
    }

    public static a a(View view) {
        AppCompatImageView a;
        AppCompatTextView a2;
        AppCompatTextView a3;
        BLView a4;
        int i = R$id.iv_close;
        AppCompatImageView a5 = f4.b.a(view, i);
        if (a5 == null || (a = f4.b.a(view, (i = R$id.iv_icon))) == null || (a2 = f4.b.a(view, (i = R$id.tv_button))) == null || (a3 = f4.b.a(view, (i = R$id.tv_subtitle))) == null || (a4 = f4.b.a(view, (i = R$id.v_icon_bg))) == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }
        return new a((BLConstraintLayout) view, a5, a, a2, a3, a4);
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public BLConstraintLayout getRoot() {
        return this.a;
    }
}
