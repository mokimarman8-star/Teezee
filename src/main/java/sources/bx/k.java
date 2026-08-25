package bx;

import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatTextView;
import com.tn.lib.view.CircleProgressBar;
import com.transsnet.downloader.R;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class k implements f4.a {
    private final FrameLayout a;
    public final CircleProgressBar b;
    public final AppCompatTextView c;
    public final AppCompatTextView d;
    public final View e;

    private k(FrameLayout frameLayout, CircleProgressBar circleProgressBar, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, View view) {
        this.a = frameLayout;
        this.b = circleProgressBar;
        this.c = appCompatTextView;
        this.d = appCompatTextView2;
        this.e = view;
    }

    public static k a(View view) {
        AppCompatTextView a;
        AppCompatTextView a2;
        View a3;
        int i = R.id.progress_bar;
        CircleProgressBar a4 = f4.b.a(view, i);
        if (a4 == null || (a = f4.b.a(view, (i = R.id.tv_progress))) == null || (a2 = f4.b.a(view, (i = R.id.tv_tips))) == null || (a3 = f4.b.a(view, (i = R.id.v_bg))) == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }
        return new k((FrameLayout) view, a4, a, a2, a3);
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.a;
    }
}
