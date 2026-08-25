package mx;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatTextView;
import com.transsnet.login.R$id;
import com.transsnet.login.R$layout;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class f implements f4.a {
    private final LinearLayout a;
    public final AppCompatButton b;
    public final AppCompatTextView c;
    public final AppCompatEditText d;
    public final FrameLayout e;
    public final l f;
    public final AppCompatTextView g;
    public final AppCompatTextView h;

    private f(LinearLayout linearLayout, AppCompatButton appCompatButton, AppCompatTextView appCompatTextView, AppCompatEditText appCompatEditText, FrameLayout frameLayout, l lVar, AppCompatTextView appCompatTextView2, AppCompatTextView appCompatTextView3) {
        this.a = linearLayout;
        this.b = appCompatButton;
        this.c = appCompatTextView;
        this.d = appCompatEditText;
        this.e = frameLayout;
        this.f = lVar;
        this.g = appCompatTextView2;
        this.h = appCompatTextView3;
    }

    public static f a(View view) {
        AppCompatTextView a;
        AppCompatEditText a2;
        View a3;
        AppCompatTextView a4;
        int i = R$id.btn_login;
        AppCompatButton a5 = f4.b.a(view, i);
        if (a5 != null && (a = f4.b.a(view, (i = R$id.btn_resend))) != null && (a2 = f4.b.a(view, (i = R$id.et_code))) != null) {
            i = R$id.ll_input;
            FrameLayout frameLayout = (FrameLayout) f4.b.a(view, i);
            if (frameLayout != null && (a3 = f4.b.a(view, (i = R$id.title))) != null) {
                l a6 = l.a(a3);
                i = R$id.tv_code_tips;
                AppCompatTextView a7 = f4.b.a(view, i);
                if (a7 != null && (a4 = f4.b.a(view, (i = R$id.tv_tips))) != null) {
                    return new f((LinearLayout) view, a5, a, a2, frameLayout, a6, a7, a4);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static f c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static f d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R$layout.login_activity_phone_code, viewGroup, false);
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
