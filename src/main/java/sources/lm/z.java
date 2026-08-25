package lm;

import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.transsion.moviedetail.R$id;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class z implements f4.a {
    private final ConstraintLayout a;
    public final ImageView b;
    public final AppCompatTextView c;

    private z(ConstraintLayout constraintLayout, ImageView imageView, AppCompatTextView appCompatTextView) {
        this.a = constraintLayout;
        this.b = imageView;
        this.c = appCompatTextView;
    }

    public static z a(View view) {
        AppCompatTextView a;
        int i = R$id.closeWatchTv;
        ImageView imageView = (ImageView) f4.b.a(view, i);
        if (imageView == null || (a = f4.b.a(view, (i = R$id.goWatchTv))) == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }
        return new z((ConstraintLayout) view, imageView, a);
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.a;
    }
}
