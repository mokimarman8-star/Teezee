package lm;

import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.transsion.moviedetail.R$id;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class a0 implements f4.a {
    private final ConstraintLayout a;
    public final AppCompatImageView b;
    public final AppCompatTextView c;
    public final AppCompatTextView d;
    public final AppCompatTextView e;
    public final AppCompatTextView f;

    private a0(ConstraintLayout constraintLayout, AppCompatImageView appCompatImageView, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, AppCompatTextView appCompatTextView3, AppCompatTextView appCompatTextView4) {
        this.a = constraintLayout;
        this.b = appCompatImageView;
        this.c = appCompatTextView;
        this.d = appCompatTextView2;
        this.e = appCompatTextView3;
        this.f = appCompatTextView4;
    }

    public static a0 a(View view) {
        AppCompatTextView a;
        AppCompatTextView a2;
        AppCompatTextView a3;
        AppCompatTextView a4;
        int i = R$id.innerIcon;
        AppCompatImageView a5 = f4.b.a(view, i);
        if (a5 == null || (a = f4.b.a(view, (i = R$id.innerTvInfo))) == null || (a2 = f4.b.a(view, (i = R$id.innerTvName))) == null || (a3 = f4.b.a(view, (i = R$id.tvInfoContent))) == null || (a4 = f4.b.a(view, (i = R$id.tvInfoTitle))) == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }
        return new a0((ConstraintLayout) view, a5, a, a2, a3, a4);
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.a;
    }
}
