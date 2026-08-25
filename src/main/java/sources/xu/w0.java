package xu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.tn.lib.view.TitleLayout;
import com.tn.lib.widget.TnButton;
import com.transsion.usercenter.R$id;
import com.transsion.usercenter.R$layout;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class w0 implements f4.a {
    private final LinearLayout a;
    public final TnButton b;
    public final TextView c;
    public final RecyclerView d;
    public final TitleLayout e;

    private w0(LinearLayout linearLayout, TnButton tnButton, TextView textView, RecyclerView recyclerView, TitleLayout titleLayout) {
        this.a = linearLayout;
        this.b = tnButton;
        this.c = textView;
        this.d = recyclerView;
        this.e = titleLayout;
    }

    public static w0 a(View view) {
        RecyclerView a;
        TitleLayout a2;
        int i = R$id.btn_login;
        TnButton a3 = f4.b.a(view, i);
        if (a3 != null) {
            i = R$id.deviceInfoTv;
            TextView textView = (TextView) f4.b.a(view, i);
            if (textView != null && (a = f4.b.a(view, (i = R$id.f5rv))) != null && (a2 = f4.b.a(view, (i = R$id.tool_bar))) != null) {
                return new w0((LinearLayout) view, a3, textView, a, a2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static w0 c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static w0 d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R$layout.user_activity_setting, viewGroup, false);
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
