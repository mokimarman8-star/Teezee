package jj;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import com.transsion.baseui.R;
import com.transsion.baseui.music.RoundedCornerLayout;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class f implements f4.a {
    private final FrameLayout a;
    public final AppCompatImageView b;
    public final AppCompatImageView c;
    public final AppCompatImageView d;
    public final AppCompatImageView e;
    public final ProgressBar f;
    public final RoundedCornerLayout g;
    public final RoundedCornerLayout h;
    public final AppCompatTextView i;
    public final AppCompatTextView j;

    private f(FrameLayout frameLayout, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, AppCompatImageView appCompatImageView3, AppCompatImageView appCompatImageView4, ProgressBar progressBar, RoundedCornerLayout roundedCornerLayout, RoundedCornerLayout roundedCornerLayout2, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2) {
        this.a = frameLayout;
        this.b = appCompatImageView;
        this.c = appCompatImageView2;
        this.d = appCompatImageView3;
        this.e = appCompatImageView4;
        this.f = progressBar;
        this.g = roundedCornerLayout;
        this.h = roundedCornerLayout2;
        this.i = appCompatTextView;
        this.j = appCompatTextView2;
    }

    public static f a(View view) {
        AppCompatImageView a;
        AppCompatImageView a2;
        AppCompatImageView a3;
        AppCompatTextView a4;
        AppCompatTextView a5;
        int i = R.id.ivClose;
        AppCompatImageView a6 = f4.b.a(view, i);
        if (a6 != null && (a = f4.b.a(view, (i = R.id.ivCover))) != null && (a2 = f4.b.a(view, (i = R.id.ivCoverBg))) != null && (a3 = f4.b.a(view, (i = R.id.ivPlayPause))) != null) {
            i = R.id.progress;
            ProgressBar progressBar = (ProgressBar) f4.b.a(view, i);
            if (progressBar != null) {
                i = R.id.roundExpand;
                RoundedCornerLayout roundedCornerLayout = (RoundedCornerLayout) f4.b.a(view, i);
                if (roundedCornerLayout != null) {
                    i = R.id.roundFold;
                    RoundedCornerLayout roundedCornerLayout2 = (RoundedCornerLayout) f4.b.a(view, i);
                    if (roundedCornerLayout2 != null && (a4 = f4.b.a(view, (i = R.id.tvDescription))) != null && (a5 = f4.b.a(view, (i = R.id.tvTitle))) != null) {
                        return new f((FrameLayout) view, a6, a, a2, a3, progressBar, roundedCornerLayout, roundedCornerLayout2, a4, a5);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.a;
    }
}
