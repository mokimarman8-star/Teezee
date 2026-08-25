package xu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.tn.lib.view.SwitchButton;
import com.tn.lib.view.TitleLayout;
import com.transsion.usercenter.R$id;
import com.transsion.usercenter.R$layout;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class y0 implements f4.a {
    private final ConstraintLayout a;
    public final SwitchButton b;
    public final TitleLayout c;
    public final View d;

    private y0(ConstraintLayout constraintLayout, SwitchButton switchButton, TitleLayout titleLayout, View view) {
        this.a = constraintLayout;
        this.b = switchButton;
        this.c = titleLayout;
        this.d = view;
    }

    public static y0 a(View view) {
        TitleLayout a;
        View a2;
        int i = R$id.switch_button;
        SwitchButton a3 = f4.b.a(view, i);
        if (a3 == null || (a = f4.b.a(view, (i = R$id.tool_bar))) == null || (a2 = f4.b.a(view, (i = R$id.v_notice_bg))) == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }
        return new y0((ConstraintLayout) view, a3, a, a2);
    }

    public static y0 c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static y0 d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R$layout.user_activity_setting_notice, viewGroup, false);
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
