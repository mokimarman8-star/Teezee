package xu;

import android.view.View;
import android.widget.EditText;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.textfield.TextInputLayout;
import com.transsion.usercenter.R$id;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class o implements f4.a {
    private final ConstraintLayout a;
    public final AppCompatTextView b;
    public final AppCompatTextView c;
    public final EditText d;
    public final TextInputLayout e;
    public final AppCompatTextView f;

    private o(ConstraintLayout constraintLayout, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, EditText editText, TextInputLayout textInputLayout, AppCompatTextView appCompatTextView3) {
        this.a = constraintLayout;
        this.b = appCompatTextView;
        this.c = appCompatTextView2;
        this.d = editText;
        this.e = textInputLayout;
        this.f = appCompatTextView3;
    }

    public static o a(View view) {
        AppCompatTextView a;
        TextInputLayout a2;
        AppCompatTextView a3;
        int i = R$id.btn_cancel;
        AppCompatTextView a4 = f4.b.a(view, i);
        if (a4 != null && (a = f4.b.a(view, (i = R$id.btn_ok))) != null) {
            i = R$id.et_pwd;
            EditText editText = (EditText) f4.b.a(view, i);
            if (editText != null && (a2 = f4.b.a(view, (i = R$id.til_pwd))) != null && (a3 = f4.b.a(view, (i = R$id.tv_title))) != null) {
                return new o((ConstraintLayout) view, a4, a, editText, a2, a3);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.a;
    }
}
