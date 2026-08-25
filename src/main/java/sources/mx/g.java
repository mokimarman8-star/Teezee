package mx;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.transsnet.login.R$id;
import com.transsnet.login.R$layout;
import com.transsnet.login.phone.widget.LoginPwdEditText;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class g implements f4.a {
    private final LinearLayout a;
    public final AppCompatImageView b;
    public final AppCompatImageButton c;
    public final AppCompatTextView d;
    public final AppCompatImageView e;
    public final AppCompatButton f;
    public final AppCompatEditText g;
    public final LoginPwdEditText h;
    public final AppCompatImageView i;
    public final ConstraintLayout j;
    public final AppCompatTextView k;
    public final AppCompatTextView l;
    public final AppCompatTextView m;
    public final AppCompatTextView n;
    public final View o;

    private g(LinearLayout linearLayout, AppCompatImageView appCompatImageView, AppCompatImageButton appCompatImageButton, AppCompatTextView appCompatTextView, AppCompatImageView appCompatImageView2, AppCompatButton appCompatButton, AppCompatEditText appCompatEditText, LoginPwdEditText loginPwdEditText, AppCompatImageView appCompatImageView3, ConstraintLayout constraintLayout, AppCompatTextView appCompatTextView2, AppCompatTextView appCompatTextView3, AppCompatTextView appCompatTextView4, AppCompatTextView appCompatTextView5, View view) {
        this.a = linearLayout;
        this.b = appCompatImageView;
        this.c = appCompatImageButton;
        this.d = appCompatTextView;
        this.e = appCompatImageView2;
        this.f = appCompatButton;
        this.g = appCompatEditText;
        this.h = loginPwdEditText;
        this.i = appCompatImageView3;
        this.j = constraintLayout;
        this.k = appCompatTextView2;
        this.l = appCompatTextView3;
        this.m = appCompatTextView4;
        this.n = appCompatTextView5;
        this.o = view;
    }

    public static g a(View view) {
        AppCompatImageButton a;
        AppCompatTextView a2;
        AppCompatImageView a3;
        AppCompatButton a4;
        AppCompatEditText a5;
        AppCompatImageView a6;
        ConstraintLayout a7;
        AppCompatTextView a8;
        AppCompatTextView a9;
        AppCompatTextView a10;
        AppCompatTextView a11;
        View a12;
        int i = R$id.btn_back;
        AppCompatImageView a13 = f4.b.a(view, i);
        if (a13 != null && (a = f4.b.a(view, (i = R$id.btn_clear))) != null && (a2 = f4.b.a(view, (i = R$id.btn_email))) != null && (a3 = f4.b.a(view, (i = R$id.btn_eye))) != null && (a4 = f4.b.a(view, (i = R$id.btn_login))) != null && (a5 = f4.b.a(view, (i = R$id.et_phone))) != null) {
            i = R$id.et_pwd;
            LoginPwdEditText loginPwdEditText = (LoginPwdEditText) f4.b.a(view, i);
            if (loginPwdEditText != null && (a6 = f4.b.a(view, (i = R$id.iv_arrow))) != null && (a7 = f4.b.a(view, (i = R$id.ll_input))) != null && (a8 = f4.b.a(view, (i = R$id.tv_forget_pwd))) != null && (a9 = f4.b.a(view, (i = R$id.tv_phone_country_code))) != null && (a10 = f4.b.a(view, (i = R$id.tv_privacy))) != null && (a11 = f4.b.a(view, (i = R$id.tv_tips))) != null && (a12 = f4.b.a(view, (i = R$id.v_line))) != null) {
                return new g((LinearLayout) view, a13, a, a2, a3, a4, a5, loginPwdEditText, a6, a7, a8, a9, a10, a11, a12);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static g c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static g d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R$layout.login_activity_phone_pwd, viewGroup, false);
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
