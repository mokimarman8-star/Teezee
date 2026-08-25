package mx;

import android.view.View;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.transsnet.login.R$id;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class k implements f4.a {
    private final ConstraintLayout a;
    public final AppCompatEditText b;
    public final AppCompatImageView c;
    public final View d;
    public final AppCompatTextView e;
    public final AppCompatTextView f;

    private k(ConstraintLayout constraintLayout, AppCompatEditText appCompatEditText, AppCompatImageView appCompatImageView, View view, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2) {
        this.a = constraintLayout;
        this.b = appCompatEditText;
        this.c = appCompatImageView;
        this.d = view;
        this.e = appCompatTextView;
        this.f = appCompatTextView2;
    }

    public static k a(View view) {
        AppCompatImageView a;
        View a2;
        AppCompatTextView a3;
        AppCompatTextView a4;
        int i = R$id.et_code;
        AppCompatEditText a5 = f4.b.a(view, i);
        if (a5 == null || (a = f4.b.a(view, (i = R$id.iv_help))) == null || (a2 = f4.b.a(view, (i = R$id.line))) == null || (a3 = f4.b.a(view, (i = R$id.tv_hava_invitation_code))) == null || (a4 = f4.b.a(view, (i = R$id.tv_tips))) == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }
        return new k((ConstraintLayout) view, a5, a, a2, a3, a4);
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.a;
    }
}
