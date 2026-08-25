package xu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.tn.lib.view.TitleLayout;
import com.transsion.usercenter.R$id;
import com.transsion.usercenter.R$layout;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class a1 implements f4.a {
    private final ConstraintLayout a;
    public final View b;
    public final AppCompatImageView c;
    public final AppCompatTextView d;
    public final AppCompatTextView e;
    public final AppCompatTextView f;
    public final AppCompatImageView g;
    public final AppCompatTextView h;
    public final AppCompatTextView i;
    public final TitleLayout j;

    private a1(ConstraintLayout constraintLayout, View view, AppCompatImageView appCompatImageView, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, AppCompatTextView appCompatTextView3, AppCompatImageView appCompatImageView2, AppCompatTextView appCompatTextView4, AppCompatTextView appCompatTextView5, TitleLayout titleLayout) {
        this.a = constraintLayout;
        this.b = view;
        this.c = appCompatImageView;
        this.d = appCompatTextView;
        this.e = appCompatTextView2;
        this.f = appCompatTextView3;
        this.g = appCompatImageView2;
        this.h = appCompatTextView4;
        this.i = appCompatTextView5;
        this.j = titleLayout;
    }

    public static a1 a(View view) {
        AppCompatImageView a;
        AppCompatTextView a2;
        AppCompatTextView a3;
        AppCompatTextView a4;
        AppCompatImageView a5;
        AppCompatTextView a6;
        AppCompatTextView a7;
        TitleLayout a8;
        int i = R$id.bgView;
        View a9 = f4.b.a(view, i);
        if (a9 == null || (a = f4.b.a(view, (i = R$id.downloadIV))) == null || (a2 = f4.b.a(view, (i = R$id.downloadTip))) == null || (a3 = f4.b.a(view, (i = R$id.downloadTv))) == null || (a4 = f4.b.a(view, (i = R$id.restartTV))) == null || (a5 = f4.b.a(view, (i = R$id.streamIV))) == null || (a6 = f4.b.a(view, (i = R$id.streamTip))) == null || (a7 = f4.b.a(view, (i = R$id.streamTv))) == null || (a8 = f4.b.a(view, (i = R$id.titleLayout))) == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }
        return new a1((ConstraintLayout) view, a9, a, a2, a3, a4, a5, a6, a7, a8);
    }

    public static a1 c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static a1 d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R$layout.user_activity_setting_watch, viewGroup, false);
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
