package xt;

import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.noober.background.view.BLTextView;
import com.transsion.transfer.R$id;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class f implements f4.a {
    private final ConstraintLayout a;
    public final AppCompatTextView b;
    public final BLTextView c;
    public final AppCompatTextView d;
    public final AppCompatTextView e;
    public final View f;

    private f(ConstraintLayout constraintLayout, AppCompatTextView appCompatTextView, BLTextView bLTextView, AppCompatTextView appCompatTextView2, AppCompatTextView appCompatTextView3, View view) {
        this.a = constraintLayout;
        this.b = appCompatTextView;
        this.c = bLTextView;
        this.d = appCompatTextView2;
        this.e = appCompatTextView3;
        this.f = view;
    }

    public static f a(View view) {
        BLTextView a;
        AppCompatTextView a2;
        AppCompatTextView a3;
        View a4;
        int i = R$id.btn_no;
        AppCompatTextView a5 = f4.b.a(view, i);
        if (a5 == null || (a = f4.b.a(view, (i = R$id.btn_yes))) == null || (a2 = f4.b.a(view, (i = R$id.tv_tips))) == null || (a3 = f4.b.a(view, (i = R$id.tv_title))) == null || (a4 = f4.b.a(view, (i = R$id.v_ling_1))) == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }
        return new f((ConstraintLayout) view, a5, a, a2, a3, a4);
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.a;
    }
}
