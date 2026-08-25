package yo;

import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.imageview.ShapeableImageView;
import com.transsion.rewardscenter.R$id;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class h implements f4.a {
    private final ConstraintLayout a;
    public final AppCompatImageView b;
    public final ShapeableImageView c;
    public final ConstraintLayout d;
    public final AppCompatTextView e;
    public final AppCompatTextView f;
    public final AppCompatTextView g;

    private h(ConstraintLayout constraintLayout, AppCompatImageView appCompatImageView, ShapeableImageView shapeableImageView, ConstraintLayout constraintLayout2, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, AppCompatTextView appCompatTextView3) {
        this.a = constraintLayout;
        this.b = appCompatImageView;
        this.c = shapeableImageView;
        this.d = constraintLayout2;
        this.e = appCompatTextView;
        this.f = appCompatTextView2;
        this.g = appCompatTextView3;
    }

    public static h a(View view) {
        ShapeableImageView a;
        AppCompatTextView a2;
        AppCompatTextView a3;
        int i = R$id.ic_points;
        AppCompatImageView a4 = f4.b.a(view, i);
        if (a4 != null && (a = f4.b.a(view, (i = R$id.iv_avatar))) != null) {
            ConstraintLayout constraintLayout = (ConstraintLayout) view;
            i = R$id.tv_earn;
            AppCompatTextView a5 = f4.b.a(view, i);
            if (a5 != null && (a2 = f4.b.a(view, (i = R$id.tv_name))) != null && (a3 = f4.b.a(view, (i = R$id.tv_points))) != null) {
                return new h(constraintLayout, a4, a, constraintLayout, a5, a2, a3);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.a;
    }
}
