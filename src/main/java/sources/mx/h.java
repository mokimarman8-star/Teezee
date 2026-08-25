package mx;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import com.transsnet.login.R$id;
import com.transsnet.login.R$layout;
import com.transsnet.login.phone.widget.LoginPwdEditText;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class h implements f4.a {
    private final LinearLayout a;
    public final AppCompatImageView b;
    public final AppCompatButton c;
    public final LoginPwdEditText d;
    public final l e;
    public final AppCompatTextView f;
    public final AppCompatTextView g;
    public final ViewStub h;

    private h(LinearLayout linearLayout, AppCompatImageView appCompatImageView, AppCompatButton appCompatButton, LoginPwdEditText loginPwdEditText, l lVar, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, ViewStub viewStub) {
        this.a = linearLayout;
        this.b = appCompatImageView;
        this.c = appCompatButton;
        this.d = loginPwdEditText;
        this.e = lVar;
        this.f = appCompatTextView;
        this.g = appCompatTextView2;
        this.h = viewStub;
    }

    public static h a(View view) {
        AppCompatButton a;
        View a2;
        AppCompatTextView a3;
        int i = R$id.btn_eye;
        AppCompatImageView a4 = f4.b.a(view, i);
        if (a4 != null && (a = f4.b.a(view, (i = R$id.btn_login))) != null) {
            i = R$id.et_pwd;
            LoginPwdEditText loginPwdEditText = (LoginPwdEditText) f4.b.a(view, i);
            if (loginPwdEditText != null && (a2 = f4.b.a(view, (i = R$id.title))) != null) {
                l a5 = l.a(a2);
                i = R$id.tv_tips;
                AppCompatTextView a6 = f4.b.a(view, i);
                if (a6 != null && (a3 = f4.b.a(view, (i = R$id.tv_welcome))) != null) {
                    i = R$id.vs_invitation_code;
                    ViewStub viewStub = (ViewStub) f4.b.a(view, i);
                    if (viewStub != null) {
                        return new h((LinearLayout) view, a4, a, loginPwdEditText, a5, a6, a3, viewStub);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static h c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static h d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R$layout.login_activity_phone_set_pwd, viewGroup, false);
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
