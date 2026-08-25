package xu;

import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.transsion.baseui.widget.EditTextWithClear;
import com.transsion.usercenter.R$id;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class a0 implements f4.a {
    private final ConstraintLayout a;
    public final AppCompatTextView b;
    public final EditTextWithClear c;
    public final AppCompatTextView d;

    private a0(ConstraintLayout constraintLayout, AppCompatTextView appCompatTextView, EditTextWithClear editTextWithClear, AppCompatTextView appCompatTextView2) {
        this.a = constraintLayout;
        this.b = appCompatTextView;
        this.c = editTextWithClear;
        this.d = appCompatTextView2;
    }

    public static a0 a(View view) {
        EditTextWithClear a;
        AppCompatTextView a2;
        int i = R$id.btn_ok;
        AppCompatTextView a3 = f4.b.a(view, i);
        if (a3 == null || (a = f4.b.a(view, (i = R$id.et_web))) == null || (a2 = f4.b.a(view, (i = R$id.tv_title))) == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }
        return new a0((ConstraintLayout) view, a3, a, a2);
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.a;
    }
}
