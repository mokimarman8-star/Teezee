package lo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.transsion.publish.R$id;
import com.transsion.publish.R$layout;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class j implements f4.a {
    private final ConstraintLayout a;
    public final AppCompatTextView b;
    public final AppCompatTextView c;
    public final View d;

    private j(ConstraintLayout constraintLayout, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, View view) {
        this.a = constraintLayout;
        this.b = appCompatTextView;
        this.c = appCompatTextView2;
        this.d = view;
    }

    public static j a(View view) {
        AppCompatTextView a;
        View a2;
        int i = R$id.tv_tips;
        AppCompatTextView a3 = f4.b.a(view, i);
        if (a3 == null || (a = f4.b.a(view, (i = R$id.tv_title))) == null || (a2 = f4.b.a(view, (i = R$id.v_line))) == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }
        return new j((ConstraintLayout) view, a3, a, a2);
    }

    public static j c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R$layout.item_select_location, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.a;
    }
}
