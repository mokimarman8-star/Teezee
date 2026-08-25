package xu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.transsion.baseui.widget.EditTextWithClear;
import com.transsion.usercenter.R$id;
import com.transsion.usercenter.R$layout;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class x implements f4.a {
    private final ConstraintLayout a;
    public final AppCompatTextView b;
    public final AppCompatTextView c;
    public final EditTextWithClear d;
    public final EditTextWithClear e;
    public final EditTextWithClear f;
    public final EditTextWithClear g;
    public final AppCompatTextView h;
    public final AppCompatTextView i;
    public final AppCompatTextView j;
    public final AppCompatTextView k;

    private x(ConstraintLayout constraintLayout, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, EditTextWithClear editTextWithClear, EditTextWithClear editTextWithClear2, EditTextWithClear editTextWithClear3, EditTextWithClear editTextWithClear4, AppCompatTextView appCompatTextView3, AppCompatTextView appCompatTextView4, AppCompatTextView appCompatTextView5, AppCompatTextView appCompatTextView6) {
        this.a = constraintLayout;
        this.b = appCompatTextView;
        this.c = appCompatTextView2;
        this.d = editTextWithClear;
        this.e = editTextWithClear2;
        this.f = editTextWithClear3;
        this.g = editTextWithClear4;
        this.h = appCompatTextView3;
        this.i = appCompatTextView4;
        this.j = appCompatTextView5;
        this.k = appCompatTextView6;
    }

    public static x a(View view) {
        AppCompatTextView a;
        EditTextWithClear a2;
        EditTextWithClear a3;
        EditTextWithClear a4;
        EditTextWithClear a5;
        AppCompatTextView a6;
        AppCompatTextView a7;
        AppCompatTextView a8;
        AppCompatTextView a9;
        int i = R$id.btn_ok;
        AppCompatTextView a10 = f4.b.a(view, i);
        if (a10 == null || (a = f4.b.a(view, (i = R$id.btn_rest))) == null || (a2 = f4.b.a(view, (i = R$id.et_address))) == null || (a3 = f4.b.a(view, (i = R$id.et_lat))) == null || (a4 = f4.b.a(view, (i = R$id.et_lon))) == null || (a5 = f4.b.a(view, (i = R$id.et_name))) == null || (a6 = f4.b.a(view, (i = R$id.tv_address))) == null || (a7 = f4.b.a(view, (i = R$id.tv_lat))) == null || (a8 = f4.b.a(view, (i = R$id.tv_lon))) == null || (a9 = f4.b.a(view, (i = R$id.tv_name))) == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }
        return new x((ConstraintLayout) view, a10, a, a2, a3, a4, a5, a6, a7, a8, a9);
    }

    public static x c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R$layout.dialog_lab_location, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.a;
    }
}
