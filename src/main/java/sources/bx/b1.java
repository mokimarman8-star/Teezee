package bx;

import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.transsion.baseui.widget.GradientTextView;
import com.transsnet.downloader.R;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class b1 implements f4.a {
    private final ConstraintLayout a;
    public final AppCompatTextView b;
    public final GradientTextView c;

    private b1(ConstraintLayout constraintLayout, AppCompatTextView appCompatTextView, GradientTextView gradientTextView) {
        this.a = constraintLayout;
        this.b = appCompatTextView;
        this.c = gradientTextView;
    }

    public static b1 a(View view) {
        GradientTextView a;
        int i = R.id.tv_title;
        AppCompatTextView a2 = f4.b.a(view, i);
        if (a2 == null || (a = f4.b.a(view, (i = R.id.tv_transfer))) == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }
        return new b1((ConstraintLayout) view, a2, a);
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.a;
    }
}
