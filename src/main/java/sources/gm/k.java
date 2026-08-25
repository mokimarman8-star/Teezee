package gm;

import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.transsion.member.R$id;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class k implements f4.a {
    private final ConstraintLayout a;
    public final AppCompatImageView b;
    public final AppCompatTextView c;

    private k(ConstraintLayout constraintLayout, AppCompatImageView appCompatImageView, AppCompatTextView appCompatTextView) {
        this.a = constraintLayout;
        this.b = appCompatImageView;
        this.c = appCompatTextView;
    }

    public static k a(View view) {
        AppCompatTextView a;
        int i = R$id.iv_points_img;
        AppCompatImageView a2 = f4.b.a(view, i);
        if (a2 == null || (a = f4.b.a(view, (i = R$id.iv_points_text))) == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }
        return new k((ConstraintLayout) view, a2, a);
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.a;
    }
}
