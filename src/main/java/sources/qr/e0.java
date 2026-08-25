package qr;

import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.imageview.ShapeableImageView;
import com.transsion.shorttv.R;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class e0 implements f4.a {
    private final ConstraintLayout a;
    public final ShapeableImageView b;
    public final AppCompatImageView c;
    public final AppCompatTextView d;

    private e0(ConstraintLayout constraintLayout, ShapeableImageView shapeableImageView, AppCompatImageView appCompatImageView, AppCompatTextView appCompatTextView) {
        this.a = constraintLayout;
        this.b = shapeableImageView;
        this.c = appCompatImageView;
        this.d = appCompatTextView;
    }

    public static e0 a(View view) {
        AppCompatImageView a;
        AppCompatTextView a2;
        int i = R.id.iv_cover;
        ShapeableImageView a3 = f4.b.a(view, i);
        if (a3 == null || (a = f4.b.a(view, (i = R.id.iv_play))) == null || (a2 = f4.b.a(view, (i = R.id.tv_title))) == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }
        return new e0((ConstraintLayout) view, a3, a, a2);
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.a;
    }
}
