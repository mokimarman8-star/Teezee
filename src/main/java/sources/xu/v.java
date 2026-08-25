package xu;

import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.transsion.usercenter.R$id;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class v implements f4.a {
    private final ConstraintLayout a;
    public final AppCompatTextView b;
    public final AppCompatTextView c;
    public final AppCompatTextView d;
    public final AppCompatTextView e;

    private v(ConstraintLayout constraintLayout, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, AppCompatTextView appCompatTextView3, AppCompatTextView appCompatTextView4) {
        this.a = constraintLayout;
        this.b = appCompatTextView;
        this.c = appCompatTextView2;
        this.d = appCompatTextView3;
        this.e = appCompatTextView4;
    }

    public static v a(View view) {
        AppCompatTextView a;
        AppCompatTextView a2;
        AppCompatTextView a3;
        int i = R$id.btn_cancel;
        AppCompatTextView a4 = f4.b.a(view, i);
        if (a4 == null || (a = f4.b.a(view, (i = R$id.btn_copy))) == null || (a2 = f4.b.a(view, (i = R$id.tv_tips))) == null || (a3 = f4.b.a(view, (i = R$id.tv_title))) == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }
        return new v((ConstraintLayout) view, a4, a, a2, a3);
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.a;
    }
}
