package bx;

import android.view.View;
import android.widget.ImageView;
import com.tn.lib.view.CircleProgressBar;
import com.transsnet.downloader.R;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class a1 implements f4.a {
    private final View a;
    public final ImageView b;
    public final CircleProgressBar c;

    private a1(View view, ImageView imageView, CircleProgressBar circleProgressBar) {
        this.a = view;
        this.b = imageView;
        this.c = circleProgressBar;
    }

    public static a1 a(View view) {
        CircleProgressBar a;
        int i = R.id.iv_close;
        ImageView imageView = (ImageView) f4.b.a(view, i);
        if (imageView == null || (a = f4.b.a(view, (i = R.id.progress_bar_close))) == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }
        return new a1(view, imageView, a);
    }

    public View getRoot() {
        return this.a;
    }
}
