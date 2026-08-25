package qk;

import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.transsion.home.R;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class a0 implements f4.a {
    private final ConstraintLayout a;
    public final AppCompatTextView b;
    public final ConstraintLayout c;

    private a0(ConstraintLayout constraintLayout, AppCompatTextView appCompatTextView, ConstraintLayout constraintLayout2) {
        this.a = constraintLayout;
        this.b = appCompatTextView;
        this.c = constraintLayout2;
    }

    public static a0 a(View view) {
        int i = R.id.filter_name_1;
        AppCompatTextView a = f4.b.a(view, i);
        if (a == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }
        ConstraintLayout constraintLayout = (ConstraintLayout) view;
        return new a0(constraintLayout, a, constraintLayout);
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.a;
    }
}
