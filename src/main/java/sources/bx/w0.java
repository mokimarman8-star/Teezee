package bx;

import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.transsnet.downloader.R;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class w0 implements f4.a {
    private final ConstraintLayout a;
    public final AppCompatTextView b;

    private w0(ConstraintLayout constraintLayout, AppCompatTextView appCompatTextView) {
        this.a = constraintLayout;
        this.b = appCompatTextView;
    }

    public static w0 a(View view) {
        int i = R.id.iv_premium;
        AppCompatTextView a = f4.b.a(view, i);
        if (a != null) {
            return new w0((ConstraintLayout) view, a);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.a;
    }
}
