package hk;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.tn.lib.view.TitleLayout;
import com.transsion.fission.R$id;
import com.transsion.fission.R$layout;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class a implements f4.a {
    private final ConstraintLayout a;
    public final AppCompatButton b;
    public final AppCompatEditText c;
    public final TitleLayout d;

    private a(ConstraintLayout constraintLayout, AppCompatButton appCompatButton, AppCompatEditText appCompatEditText, TitleLayout titleLayout) {
        this.a = constraintLayout;
        this.b = appCompatButton;
        this.c = appCompatEditText;
        this.d = titleLayout;
    }

    public static a a(View view) {
        AppCompatEditText a;
        TitleLayout a2;
        int i = R$id.btn_submit;
        AppCompatButton a3 = f4.b.a(view, i);
        if (a3 == null || (a = f4.b.a(view, (i = R$id.et_invitation_code))) == null || (a2 = f4.b.a(view, (i = R$id.tool_bar))) == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }
        return new a((ConstraintLayout) view, a3, a, a2);
    }

    public static a c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static a d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R$layout.fission_activity_invitation_code, viewGroup, false);
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
