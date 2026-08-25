package wn;

import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.transsion.postdetail.R$id;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class i0 implements f4.a {
    private final ConstraintLayout a;
    public final ConstraintLayout b;
    public final AppCompatTextView c;
    public final AppCompatTextView d;

    private i0(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2) {
        this.a = constraintLayout;
        this.b = constraintLayout2;
        this.c = appCompatTextView;
        this.d = appCompatTextView2;
    }

    public static i0 a(View view) {
        AppCompatTextView a;
        ConstraintLayout constraintLayout = (ConstraintLayout) view;
        int i = R$id.rating_name;
        AppCompatTextView a2 = f4.b.a(view, i);
        if (a2 == null || (a = f4.b.a(view, (i = R$id.tv_rating))) == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }
        return new i0(constraintLayout, constraintLayout, a2, a);
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.a;
    }
}
