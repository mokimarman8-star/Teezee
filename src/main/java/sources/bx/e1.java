package bx;

import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.transsnet.downloader.R;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class e1 implements f4.a {
    private final ConstraintLayout a;
    public final AppCompatTextView b;
    public final AppCompatTextView c;
    public final AppCompatTextView d;

    private e1(ConstraintLayout constraintLayout, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, AppCompatTextView appCompatTextView3) {
        this.a = constraintLayout;
        this.b = appCompatTextView;
        this.c = appCompatTextView2;
        this.d = appCompatTextView3;
    }

    public static e1 a(View view) {
        AppCompatTextView a;
        AppCompatTextView a2;
        int i = R.id.tvHideTxt;
        AppCompatTextView a3 = f4.b.a(view, i);
        if (a3 == null || (a = f4.b.a(view, (i = R.id.tvInfoContent))) == null || (a2 = f4.b.a(view, (i = R.id.tvInfoTitle))) == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }
        return new e1((ConstraintLayout) view, a3, a, a2);
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.a;
    }
}
