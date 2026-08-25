package bx;

import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.transsnet.downloader.R;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class g implements f4.a {
    private final ConstraintLayout a;
    public final TextView b;
    public final View c;
    public final AppCompatImageView d;
    public final AppCompatImageView e;
    public final AppCompatImageView f;
    public final AppCompatImageView g;
    public final AppCompatTextView h;
    public final AppCompatTextView i;

    private g(ConstraintLayout constraintLayout, TextView textView, View view, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, AppCompatImageView appCompatImageView3, AppCompatImageView appCompatImageView4, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2) {
        this.a = constraintLayout;
        this.b = textView;
        this.c = view;
        this.d = appCompatImageView;
        this.e = appCompatImageView2;
        this.f = appCompatImageView3;
        this.g = appCompatImageView4;
        this.h = appCompatTextView;
        this.i = appCompatTextView2;
    }

    public static g a(View view) {
        View a;
        AppCompatImageView a2;
        AppCompatImageView a3;
        AppCompatImageView a4;
        AppCompatImageView a5;
        AppCompatTextView a6;
        AppCompatTextView a7;
        int i = R.id.btn_bottom;
        TextView textView = (TextView) f4.b.a(view, i);
        if (textView == null || (a = f4.b.a(view, (i = R.id.btn_top))) == null || (a2 = f4.b.a(view, (i = R.id.ivAdIcon))) == null || (a3 = f4.b.a(view, (i = R.id.ivAdLoading))) == null || (a4 = f4.b.a(view, (i = R.id.iv_back))) == null || (a5 = f4.b.a(view, (i = R.id.iv_icon))) == null || (a6 = f4.b.a(view, (i = R.id.tvAdWatchAVideo))) == null || (a7 = f4.b.a(view, (i = R.id.tv_tips))) == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }
        return new g((ConstraintLayout) view, textView, a, a2, a3, a4, a5, a6, a7);
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.a;
    }
}
