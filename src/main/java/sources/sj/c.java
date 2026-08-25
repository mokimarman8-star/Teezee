package sj;

import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.Guideline;
import com.google.android.material.imageview.ShapeableImageView;
import com.transsion.commercialization.R$id;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class c implements f4.a {
    private final View a;
    public final Guideline b;
    public final ShapeableImageView c;
    public final AppCompatImageView d;
    public final Barrier e;
    public final Barrier f;
    public final Guideline g;

    private c(View view, Guideline guideline, ShapeableImageView shapeableImageView, AppCompatImageView appCompatImageView, Barrier barrier, Barrier barrier2, Guideline guideline2) {
        this.a = view;
        this.b = guideline;
        this.c = shapeableImageView;
        this.d = appCompatImageView;
        this.e = barrier;
        this.f = barrier2;
        this.g = guideline2;
    }

    public static c a(View view) {
        AppCompatImageView a;
        Guideline a2 = f4.b.a(view, R$id.bottomGuideline);
        int i = R$id.iv;
        ShapeableImageView a3 = f4.b.a(view, i);
        if (a3 == null || (a = f4.b.a(view, (i = R$id.ivClose))) == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }
        return new c(view, a2, a3, a, f4.b.a(view, R$id.leftBarrier), f4.b.a(view, R$id.rightBarrier), f4.b.a(view, R$id.topGuideline));
    }

    public View getRoot() {
        return this.a;
    }
}
