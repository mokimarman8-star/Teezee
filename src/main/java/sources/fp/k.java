package fp;

import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.transsion.room.R$id;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class k implements f4.a {
    private final ConstraintLayout a;
    public final View b;
    public final AppCompatImageView c;
    public final AppCompatImageView d;
    public final AppCompatTextView e;
    public final AppCompatTextView f;
    public final AppCompatTextView g;

    private k(ConstraintLayout constraintLayout, View view, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, AppCompatTextView appCompatTextView3) {
        this.a = constraintLayout;
        this.b = view;
        this.c = appCompatImageView;
        this.d = appCompatImageView2;
        this.e = appCompatTextView;
        this.f = appCompatTextView2;
        this.g = appCompatTextView3;
    }

    public static k a(View view) {
        AppCompatImageView a;
        AppCompatImageView a2;
        AppCompatTextView a3;
        AppCompatTextView a4;
        AppCompatTextView a5;
        int i = R$id.btn_top;
        View a6 = f4.b.a(view, i);
        if (a6 == null || (a = f4.b.a(view, (i = R$id.iv_back))) == null || (a2 = f4.b.a(view, (i = R$id.iv_icon))) == null || (a3 = f4.b.a(view, (i = R$id.tvAdWatchAVideo))) == null || (a4 = f4.b.a(view, (i = R$id.tv_tips))) == null || (a5 = f4.b.a(view, (i = R$id.tv_title))) == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }
        return new k((ConstraintLayout) view, a6, a, a2, a3, a4, a5);
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.a;
    }
}
