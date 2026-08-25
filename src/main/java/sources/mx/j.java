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
import com.transsnet.login.R$id;
import com.transsnet.login.R$layout;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class j implements f4.a {
    private final LinearLayout a;
    public final AppCompatImageView b;
    public final AppCompatImageButton c;
    public final AppCompatButton d;
    public final AppCompatButton e;
    public final AppCompatEditText f;
    public final LinearLayout g;
    public final AppCompatTextView h;
    public final AppCompatTextView i;
    public final AppCompatTextView j;

    private j(LinearLayout linearLayout, AppCompatImageView appCompatImageView, AppCompatImageButton appCompatImageButton, AppCompatButton appCompatButton, AppCompatButton appCompatButton2, AppCompatEditText appCompatEditText, LinearLayout linearLayout2, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, AppCompatTextView appCompatTextView3) {
        this.a = linearLayout;
        this.b = appCompatImageView;
        this.c = appCompatImageButton;
        this.d = appCompatButton;
        this.e = appCompatButton2;
        this.f = appCompatEditText;
        this.g = linearLayout2;
        this.h = appCompatTextView;
        this.i = appCompatTextView2;
        this.j = appCompatTextView3;
    }

    public static j a(View view) {
        AppCompatImageButton a;
        AppCompatButton a2;
        AppCompatButton a3;
        AppCompatEditText a4;
        AppCompatTextView a5;
        AppCompatTextView a6;
        AppCompatTextView a7;
        int i = R$id.btn_back;
        AppCompatImageView a8 = f4.b.a(view, i);
        if (a8 != null && (a = f4.b.a(view, (i = R$id.btn_clear))) != null && (a2 = f4.b.a(view, (i = R$id.btn_email))) != null && (a3 = f4.b.a(view, (i = R$id.btn_login))) != null && (a4 = f4.b.a(view, (i = R$id.et_phone))) != null) {
            i = R$id.ll_input;
            LinearLayout linearLayout = (LinearLayout) f4.b.a(view, i);
            if (linearLayout != null && (a5 = f4.b.a(view, (i = R$id.tv_phone_country_code))) != null && (a6 = f4.b.a(view, (i = R$id.tv_privacy))) != null && (a7 = f4.b.a(view, (i = R$id.tv_tips))) != null) {
                return new j((LinearLayout) view, a8, a, a2, a3, a4, linearLayout, a5, a6, a7);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static j c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static j d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R$layout.login_fragment_phone, viewGroup, false);
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
