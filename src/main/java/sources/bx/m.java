package bx;

import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.noober.background.view.BLTextView;
import com.transsnet.downloader.R;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class m implements f4.a {
    private final ConstraintLayout a;
    public final BLTextView b;
    public final View c;
    public final AppCompatImageView d;
    public final AppCompatTextView e;

    private m(ConstraintLayout constraintLayout, BLTextView bLTextView, View view, AppCompatImageView appCompatImageView, AppCompatTextView appCompatTextView) {
        this.a = constraintLayout;
        this.b = bLTextView;
        this.c = view;
        this.d = appCompatImageView;
        this.e = appCompatTextView;
    }

    public static m a(View view) {
        View a;
        AppCompatImageView a2;
        AppCompatTextView a3;
        int i = R.id.btn_bottom;
        BLTextView a4 = f4.b.a(view, i);
        if (a4 == null || (a = f4.b.a(view, (i = R.id.btn_top))) == null || (a2 = f4.b.a(view, (i = R.id.iv_close))) == null || (a3 = f4.b.a(view, (i = R.id.tv_tips))) == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }
        return new m((ConstraintLayout) view, a4, a, a2, a3);
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.a;
    }
}
