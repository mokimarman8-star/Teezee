package mx;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import com.transsnet.login.R$id;
import com.transsnet.login.R$layout;
import com.transsnet.login.phone.widget.LoginPwdEditText;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class c implements f4.a {
    private final LinearLayout a;
    public final AppCompatImageView b;
    public final AppCompatImageButton c;
    public final AppCompatImageView d;
    public final AppCompatButton e;
    public final AppCompatTextView f;
    public final AppCompatEditText g;
    public final LoginPwdEditText h;
    public final FrameLayout i;
    public final AppCompatTextView j;
    public final AppCompatTextView k;
    public final AppCompatTextView l;

    private c(LinearLayout linearLayout, AppCompatImageView appCompatImageView, AppCompatImageButton appCompatImageButton, AppCompatImageView appCompatImageView2, AppCompatButton appCompatButton, AppCompatTextView appCompatTextView, AppCompatEditText appCompatEditText, LoginPwdEditText loginPwdEditText, FrameLayout frameLayout, AppCompatTextView appCompatTextView2, AppCompatTextView appCompatTextView3, AppCompatTextView appCompatTextView4) {
        this.a = linearLayout;
        this.b = appCompatImageView;
        this.c = appCompatImageButton;
        this.d = appCompatImageView2;
        this.e = appCompatButton;
        this.f = appCompatTextView;
        this.g = appCompatEditText;
        this.h = loginPwdEditText;
        this.i = frameLayout;
        this.j = appCompatTextView2;
        this.k = appCompatTextView3;
        this.l = appCompatTextView4;
    }

    public static c a(View view) {
        AppCompatImageButton a;
        AppCompatImageView a2;
        AppCompatButton a3;
        AppCompatTextView a4;
        AppCompatEditText a5;
        AppCompatTextView a6;
        AppCompatTextView a7;
        AppCompatTextView a8;
        int i = R$id.btn_back;
        AppCompatImageView a9 = f4.b.a(view, i);
        if (a9 != null && (a = f4.b.a(view, (i = R$id.btn_clear))) != null && (a2 = f4.b.a(view, (i = R$id.btn_eye))) != null && (a3 = f4.b.a(view, (i = R$id.btn_login))) != null && (a4 = f4.b.a(view, (i = R$id.btn_phone_login))) != null && (a5 = f4.b.a(view, (i = R$id.et_mail))) != null) {
            i = R$id.et_pwd;
            LoginPwdEditText loginPwdEditText = (LoginPwdEditText) f4.b.a(view, i);
            if (loginPwdEditText != null) {
                i = R$id.ll_input;
                FrameLayout frameLayout = (FrameLayout) f4.b.a(view, i);
                if (frameLayout != null && (a6 = f4.b.a(view, (i = R$id.tv_forget_pwd))) != null && (a7 = f4.b.a(view, (i = R$id.tv_privacy))) != null && (a8 = f4.b.a(view, (i = R$id.tv_tips))) != null) {
                    return new c((LinearLayout) view, a9, a, a2, a3, a4, a5, loginPwdEditText, frameLayout, a6, a7, a8);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static c c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static c d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R$layout.login_activity_email_pwd, viewGroup, false);
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
