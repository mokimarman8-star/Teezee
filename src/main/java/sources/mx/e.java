package mx;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import com.transsnet.login.R$id;
import com.transsnet.login.R$layout;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class e implements f4.a {
    private final LinearLayout a;
    public final FrameLayout b;
    public final FrameLayout c;
    public final AppCompatImageView d;
    public final LinearLayout e;
    public final AppCompatTextView f;
    public final AppCompatTextView g;
    public final AppCompatTextView h;
    public final AppCompatTextView i;
    public final View j;

    private e(LinearLayout linearLayout, FrameLayout frameLayout, FrameLayout frameLayout2, AppCompatImageView appCompatImageView, LinearLayout linearLayout2, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, AppCompatTextView appCompatTextView3, AppCompatTextView appCompatTextView4, View view) {
        this.a = linearLayout;
        this.b = frameLayout;
        this.c = frameLayout2;
        this.d = appCompatImageView;
        this.e = linearLayout2;
        this.f = appCompatTextView;
        this.g = appCompatTextView2;
        this.h = appCompatTextView3;
        this.i = appCompatTextView4;
        this.j = view;
    }

    public static e a(View view) {
        AppCompatImageView a;
        AppCompatTextView a2;
        AppCompatTextView a3;
        AppCompatTextView a4;
        AppCompatTextView a5;
        View a6;
        int i = R$id.btn_email_login;
        FrameLayout frameLayout = (FrameLayout) f4.b.a(view, i);
        if (frameLayout != null) {
            i = R$id.btn_gp_login;
            FrameLayout frameLayout2 = (FrameLayout) f4.b.a(view, i);
            if (frameLayout2 != null && (a = f4.b.a(view, (i = R$id.ll_close))) != null) {
                i = R$id.rl_login;
                LinearLayout linearLayout = (LinearLayout) f4.b.a(view, i);
                if (linearLayout != null && (a2 = f4.b.a(view, (i = R$id.tv_email_login_text))) != null && (a3 = f4.b.a(view, (i = R$id.tv_log_in))) != null && (a4 = f4.b.a(view, (i = R$id.tv_privacy))) != null && (a5 = f4.b.a(view, (i = R$id.tv_title))) != null && (a6 = f4.b.a(view, (i = R$id.view_blank))) != null) {
                    return new e((LinearLayout) view, frameLayout, frameLayout2, a, linearLayout, a2, a3, a4, a5, a6);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static e c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static e d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R$layout.login_activity_like, viewGroup, false);
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
