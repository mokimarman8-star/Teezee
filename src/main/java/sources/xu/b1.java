package xu;

import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import com.google.android.material.imageview.ShapeableImageView;
import com.tn.lib.widget.TnTextView;
import com.transsion.usercenter.R$id;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class b1 implements f4.a {
    private final ConstraintLayout a;
    public final TnTextView b;
    public final ConstraintLayout c;
    public final Group d;
    public final ShapeableImageView e;
    public final ShapeableImageView f;
    public final ShapeableImageView g;
    public final ShapeableImageView h;
    public final AppCompatTextView i;
    public final TnTextView j;

    private b1(ConstraintLayout constraintLayout, TnTextView tnTextView, ConstraintLayout constraintLayout2, Group group, ShapeableImageView shapeableImageView, ShapeableImageView shapeableImageView2, ShapeableImageView shapeableImageView3, ShapeableImageView shapeableImageView4, AppCompatTextView appCompatTextView, TnTextView tnTextView2) {
        this.a = constraintLayout;
        this.b = tnTextView;
        this.c = constraintLayout2;
        this.d = group;
        this.e = shapeableImageView;
        this.f = shapeableImageView2;
        this.g = shapeableImageView3;
        this.h = shapeableImageView4;
        this.i = appCompatTextView;
        this.j = tnTextView2;
    }

    public static b1 a(View view) {
        ShapeableImageView a;
        ShapeableImageView a2;
        ShapeableImageView a3;
        ShapeableImageView a4;
        AppCompatTextView a5;
        TnTextView a6;
        int i = R$id.btnFind;
        TnTextView a7 = f4.b.a(view, i);
        if (a7 != null) {
            ConstraintLayout constraintLayout = (ConstraintLayout) view;
            i = R$id.groupPlaceholder;
            Group a8 = f4.b.a(view, i);
            if (a8 != null && (a = f4.b.a(view, (i = R$id.ivPlaceholder1))) != null && (a2 = f4.b.a(view, (i = R$id.ivPlaceholder2))) != null && (a3 = f4.b.a(view, (i = R$id.ivPlaceholder3))) != null && (a4 = f4.b.a(view, (i = R$id.ivPlaceholder4))) != null && (a5 = f4.b.a(view, (i = R$id.tvNumber))) != null && (a6 = f4.b.a(view, (i = R$id.tvTitle))) != null) {
                return new b1(constraintLayout, a7, constraintLayout, a8, a, a2, a3, a4, a5, a6);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.a;
    }
}
