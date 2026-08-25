package xu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.transsion.usercenter.R$id;
import com.transsion.usercenter.R$layout;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class d0 implements f4.a {
    private final ConstraintLayout a;
    public final View b;
    public final View c;
    public final AppCompatCheckBox d;
    public final AppCompatTextView e;

    private d0(ConstraintLayout constraintLayout, View view, View view2, AppCompatCheckBox appCompatCheckBox, AppCompatTextView appCompatTextView) {
        this.a = constraintLayout;
        this.b = view;
        this.c = view2;
        this.d = appCompatCheckBox;
        this.e = appCompatTextView;
    }

    public static d0 a(View view) {
        View a;
        AppCompatCheckBox a2;
        AppCompatTextView a3;
        int i = R$id.bgView;
        View a4 = f4.b.a(view, i);
        if (a4 == null || (a = f4.b.a(view, (i = R$id.divider))) == null || (a2 = f4.b.a(view, (i = R$id.radioButton))) == null || (a3 = f4.b.a(view, (i = R$id.textView))) == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }
        return new d0((ConstraintLayout) view, a4, a, a2, a3);
    }

    public static d0 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R$layout.feedback_option_list_cell, viewGroup, false);
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
