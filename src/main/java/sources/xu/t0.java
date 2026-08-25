package xu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.tn.lib.view.TitleLayout;
import com.transsion.usercenter.R$id;
import com.transsion.usercenter.R$layout;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class t0 implements f4.a {
    private final ConstraintLayout a;
    public final ScrollView b;
    public final TitleLayout c;
    public final AppCompatTextView d;
    public final AppCompatTextView e;

    private t0(ConstraintLayout constraintLayout, ScrollView scrollView, TitleLayout titleLayout, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2) {
        this.a = constraintLayout;
        this.b = scrollView;
        this.c = titleLayout;
        this.d = appCompatTextView;
        this.e = appCompatTextView2;
    }

    public static t0 a(View view) {
        TitleLayout a;
        AppCompatTextView a2;
        AppCompatTextView a3;
        int i = R$id.scrollView;
        ScrollView scrollView = (ScrollView) f4.b.a(view, i);
        if (scrollView == null || (a = f4.b.a(view, (i = R$id.titleLayout))) == null || (a2 = f4.b.a(view, (i = R$id.tvMessage))) == null || (a3 = f4.b.a(view, (i = R$id.tvPostTime))) == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }
        return new t0((ConstraintLayout) view, scrollView, a, a2, a3);
    }

    public static t0 c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static t0 d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R$layout.user_activity_detail, viewGroup, false);
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
