package xu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.tn.lib.view.TitleLayout;
import com.transsion.usercenter.R$id;
import com.transsion.usercenter.R$layout;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class v0 implements f4.a {
    private final ConstraintLayout a;
    public final AppCompatImageView b;
    public final TitleLayout c;
    public final AppCompatTextView d;
    public final AppCompatTextView e;

    private v0(ConstraintLayout constraintLayout, AppCompatImageView appCompatImageView, TitleLayout titleLayout, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2) {
        this.a = constraintLayout;
        this.b = appCompatImageView;
        this.c = titleLayout;
        this.d = appCompatTextView;
        this.e = appCompatTextView2;
    }

    public static v0 a(View view) {
        TitleLayout a;
        AppCompatTextView a2;
        AppCompatTextView a3;
        int i = R$id.iv_logo;
        AppCompatImageView a4 = f4.b.a(view, i);
        if (a4 == null || (a = f4.b.a(view, (i = R$id.toolbar))) == null || (a2 = f4.b.a(view, (i = R$id.tv_privacy))) == null || (a3 = f4.b.a(view, (i = R$id.tv_version))) == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }
        return new v0((ConstraintLayout) view, a4, a, a2, a3);
    }

    public static v0 c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static v0 d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R$layout.user_activity_setting_about_us, viewGroup, false);
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
