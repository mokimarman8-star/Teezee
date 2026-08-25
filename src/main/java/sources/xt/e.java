package xt;

import android.view.View;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import com.google.android.material.imageview.ShapeableImageView;
import com.transsion.transfer.R$id;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class e implements f4.a {
    private final LinearLayout a;
    public final AppCompatImageView b;
    public final ShapeableImageView c;

    private e(LinearLayout linearLayout, AppCompatImageView appCompatImageView, ShapeableImageView shapeableImageView) {
        this.a = linearLayout;
        this.b = appCompatImageView;
        this.c = shapeableImageView;
    }

    public static e a(View view) {
        ShapeableImageView a;
        int i = R$id.ivClose;
        AppCompatImageView a2 = f4.b.a(view, i);
        if (a2 == null || (a = f4.b.a(view, (i = R$id.ivQrCode))) == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }
        return new e((LinearLayout) view, a2, a);
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.a;
    }
}
