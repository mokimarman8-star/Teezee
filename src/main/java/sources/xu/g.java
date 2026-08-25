package xu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.recyclerview.widget.RecyclerView;
import com.transsion.usercenter.R$id;
import com.transsion.usercenter.R$layout;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class g implements f4.a {
    private final LinearLayout a;
    public final Button b;
    public final Button c;
    public final AppCompatEditText d;
    public final LinearLayout e;
    public final RecyclerView f;

    private g(LinearLayout linearLayout, Button button, Button button2, AppCompatEditText appCompatEditText, LinearLayout linearLayout2, RecyclerView recyclerView) {
        this.a = linearLayout;
        this.b = button;
        this.c = button2;
        this.d = appCompatEditText;
        this.e = linearLayout2;
        this.f = recyclerView;
    }

    public static g a(View view) {
        AppCompatEditText a;
        int i = R$id.btnCustomInformation;
        Button button = (Button) f4.b.a(view, i);
        if (button != null) {
            i = R$id.btnReset;
            Button button2 = (Button) f4.b.a(view, i);
            if (button2 != null && (a = f4.b.a(view, (i = R$id.f3et))) != null) {
                LinearLayout linearLayout = (LinearLayout) view;
                i = R$id.f5rv;
                RecyclerView a2 = f4.b.a(view, i);
                if (a2 != null) {
                    return new g(linearLayout, button, button2, a, linearLayout, a2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static g c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static g d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R$layout.activity_mcc, viewGroup, false);
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
