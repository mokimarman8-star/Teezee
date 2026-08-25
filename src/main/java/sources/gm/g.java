package gm;

import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.transsion.member.R$id;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class g implements f4.a {
    private final ConstraintLayout a;
    public final TextView b;
    public final ConstraintLayout c;
    public final AppCompatImageView d;
    public final AppCompatImageView e;
    public final TextView f;
    public final TextView g;

    private g(ConstraintLayout constraintLayout, TextView textView, ConstraintLayout constraintLayout2, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, TextView textView2, TextView textView3) {
        this.a = constraintLayout;
        this.b = textView;
        this.c = constraintLayout2;
        this.d = appCompatImageView;
        this.e = appCompatImageView2;
        this.f = textView2;
        this.g = textView3;
    }

    public static g a(View view) {
        AppCompatImageView a;
        int i = R$id.btnClaim;
        TextView textView = (TextView) f4.b.a(view, i);
        if (textView != null) {
            ConstraintLayout constraintLayout = (ConstraintLayout) view;
            i = R$id.ivClose;
            AppCompatImageView a2 = f4.b.a(view, i);
            if (a2 != null && (a = f4.b.a(view, (i = R$id.ivIcon))) != null) {
                i = R$id.tvSubTitle;
                TextView textView2 = (TextView) f4.b.a(view, i);
                if (textView2 != null) {
                    i = R$id.tvTitle;
                    TextView textView3 = (TextView) f4.b.a(view, i);
                    if (textView3 != null) {
                        return new g(constraintLayout, textView, constraintLayout, a2, a, textView2, textView3);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.a;
    }
}
