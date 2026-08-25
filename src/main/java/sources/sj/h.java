package sj;

import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.imageview.ShapeableImageView;
import com.transsion.commercialization.R$id;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class h implements f4.a {
    private final ConstraintLayout a;
    public final ShapeableImageView b;
    public final ConstraintLayout c;
    public final TextView d;
    public final TextView e;
    public final TextView f;

    private h(ConstraintLayout constraintLayout, ShapeableImageView shapeableImageView, ConstraintLayout constraintLayout2, TextView textView, TextView textView2, TextView textView3) {
        this.a = constraintLayout;
        this.b = shapeableImageView;
        this.c = constraintLayout2;
        this.d = textView;
        this.e = textView2;
        this.f = textView3;
    }

    public static h a(View view) {
        int i = R$id.ivAdIcon;
        ShapeableImageView a = f4.b.a(view, i);
        if (a != null) {
            ConstraintLayout constraintLayout = (ConstraintLayout) view;
            i = R$id.tvAdDesc;
            TextView textView = (TextView) f4.b.a(view, i);
            if (textView != null) {
                i = R$id.tvAdTitle;
                TextView textView2 = (TextView) f4.b.a(view, i);
                if (textView2 != null) {
                    i = R$id.tvWatch;
                    TextView textView3 = (TextView) f4.b.a(view, i);
                    if (textView3 != null) {
                        return new h(constraintLayout, a, constraintLayout, textView, textView2, textView3);
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
