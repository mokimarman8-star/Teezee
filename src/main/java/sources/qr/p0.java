package qr;

import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import com.google.android.material.imageview.ShapeableImageView;
import com.transsion.shorttv.R;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class p0 implements f4.a {
    private final View a;
    public final ShapeableImageView b;
    public final AppCompatTextView c;
    public final AppCompatTextView d;

    private p0(View view, ShapeableImageView shapeableImageView, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2) {
        this.a = view;
        this.b = shapeableImageView;
        this.c = appCompatTextView;
        this.d = appCompatTextView2;
    }

    public static p0 a(View view) {
        AppCompatTextView a;
        AppCompatTextView a2;
        int i = R.id.ivAdAvatar;
        ShapeableImageView a3 = f4.b.a(view, i);
        if (a3 == null || (a = f4.b.a(view, (i = R.id.tvBtn))) == null || (a2 = f4.b.a(view, (i = R.id.tvDes))) == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }
        return new p0(view, a3, a, a2);
    }

    public View getRoot() {
        return this.a;
    }
}
