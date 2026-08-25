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
public final class b implements f4.a {
    private final LinearLayout a;
    public final AppCompatImageButton b;
    public final AppCompatButton c;
    public final AppCompatImageView d;
    public final AppCompatEditText e;
    public final LinearLayout f;
    public final l g;
    public final AppCompatTextView h;
    public final AppCompatTextView i;

    private b(LinearLayout linearLayout, AppCompatImageButton appCompatImageButton, AppCompatButton appCompatButton, AppCompatImageView appCompatImageView, AppCompatEditText appCompatEditText, LinearLayout linearLayout2, l lVar, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2) {
        this.a = linearLayout;
        this.b = appCompatImageButton;
        this.c = appCompatButton;
        this.d = appCompatImageView;
        this.e = appCompatEditText;
        this.f = linearLayout2;
        this.g = lVar;
        this.h = appCompatTextView;
        this.i = appCompatTextView2;
    }

    public static b a(View view) {
        AppCompatButton a;
        AppCompatImageView a2;
        AppCompatEditText a3;
        View a4;
        AppCompatTextView a5;
        int i = R$id.btn_clear;
        AppCompatImageButton a6 = f4.b.a(view, i);
        if (a6 != null && (a = f4.b.a(view, (i = R$id.btn_next))) != null && (a2 = f4.b.a(view, (i = R$id.btn_phone_login))) != null && (a3 = f4.b.a(view, (i = R$id.et_email))) != null) {
            i = R$id.ll_phone_login_entry;
            LinearLayout linearLayout = (LinearLayout) f4.b.a(view, i);
            if (linearLayout != null && (a4 = f4.b.a(view, (i = R$id.title))) != null) {
                l a7 = l.a(a4);
                i = R$id.tv_privacy;
                AppCompatTextView a8 = f4.b.a(view, i);
                if (a8 != null && (a5 = f4.b.a(view, (i = R$id.tv_tips))) != null) {
                    return new b((LinearLayout) view, a6, a, a2, a3, linearLayout, a7, a8, a5);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static b c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static b d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R$layout.login_activity_email, viewGroup, false);
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
