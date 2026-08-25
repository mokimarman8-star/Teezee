package bx;

import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import com.transsnet.downloader.R;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class i implements f4.a {
    private final FrameLayout a;
    public final AppCompatImageView b;
    public final AppCompatTextView c;
    public final AppCompatTextView d;
    public final AppCompatTextView e;

    private i(FrameLayout frameLayout, AppCompatImageView appCompatImageView, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, AppCompatTextView appCompatTextView3) {
        this.a = frameLayout;
        this.b = appCompatImageView;
        this.c = appCompatTextView;
        this.d = appCompatTextView2;
        this.e = appCompatTextView3;
    }

    public static i a(View view) {
        AppCompatTextView a;
        AppCompatTextView a2;
        AppCompatTextView a3;
        int i = R.id.iv_navigation;
        AppCompatImageView a4 = f4.b.a(view, i);
        if (a4 == null || (a = f4.b.a(view, (i = R.id.tv_desc))) == null || (a2 = f4.b.a(view, (i = R.id.tv_positive))) == null || (a3 = f4.b.a(view, (i = R.id.tv_title))) == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }
        return new i((FrameLayout) view, a4, a, a2, a3);
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.a;
    }
}
