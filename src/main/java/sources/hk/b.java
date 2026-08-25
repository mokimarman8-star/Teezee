package hk;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatTextView;
import com.transsion.fission.R$id;
import com.transsion.fission.R$layout;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class b implements f4.a {
    private final LinearLayout a;
    public final AppCompatTextView b;

    private b(LinearLayout linearLayout, AppCompatTextView appCompatTextView) {
        this.a = linearLayout;
        this.b = appCompatTextView;
    }

    public static b a(View view) {
        int i = R$id.btn_ok;
        AppCompatTextView a = f4.b.a(view, i);
        if (a != null) {
            return new b((LinearLayout) view, a);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static b c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static b d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R$layout.fission_dialog_invite_code_help, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.a;
    }
}
