package bx;

import android.view.View;
import android.widget.ImageView;
import com.noober.background.view.BLFrameLayout;
import com.tn.lib.view.CircleProgressBar;
import com.transsnet.downloader.R;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class t0 implements f4.a {
    private final View a;
    public final BLFrameLayout b;
    public final ImageView c;
    public final CircleProgressBar d;

    private t0(View view, BLFrameLayout bLFrameLayout, ImageView imageView, CircleProgressBar circleProgressBar) {
        this.a = view;
        this.b = bLFrameLayout;
        this.c = imageView;
        this.d = circleProgressBar;
    }

    public static t0 a(View view) {
        CircleProgressBar a;
        int i = R.id.fl_guide_content;
        BLFrameLayout a2 = f4.b.a(view, i);
        if (a2 != null) {
            i = R.id.iv_guide_close;
            ImageView imageView = (ImageView) f4.b.a(view, i);
            if (imageView != null && (a = f4.b.a(view, (i = R.id.progress_bar_guide_close))) != null) {
                return new t0(view, a2, imageView, a);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public View getRoot() {
        return this.a;
    }
}
