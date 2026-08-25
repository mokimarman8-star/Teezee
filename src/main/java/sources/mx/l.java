package mx;

import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.transsnet.login.R$id;
import com.transsnet.login.widget.LoginProgressBar;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class l implements f4.a {
    private final ConstraintLayout a;
    public final AppCompatImageView b;
    public final LoginProgressBar c;
    public final AppCompatTextView d;
    public final AppCompatTextView e;

    private l(ConstraintLayout constraintLayout, AppCompatImageView appCompatImageView, LoginProgressBar loginProgressBar, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2) {
        this.a = constraintLayout;
        this.b = appCompatImageView;
        this.c = loginProgressBar;
        this.d = appCompatTextView;
        this.e = appCompatTextView2;
    }

    public static l a(View view) {
        AppCompatTextView a;
        AppCompatTextView a2;
        int i = R$id.btn_back;
        AppCompatImageView a3 = f4.b.a(view, i);
        if (a3 != null) {
            i = R$id.progress;
            LoginProgressBar loginProgressBar = (LoginProgressBar) f4.b.a(view, i);
            if (loginProgressBar != null && (a = f4.b.a(view, (i = R$id.tv_progress))) != null && (a2 = f4.b.a(view, (i = R$id.tv_title))) != null) {
                return new l((ConstraintLayout) view, a3, loginProgressBar, a, a2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.a;
    }
}
