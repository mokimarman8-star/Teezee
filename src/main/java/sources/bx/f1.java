package bx;

import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import com.transsnet.downloader.R;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class f1 implements f4.a {
    private final View a;
    public final AppCompatImageView b;
    public final ImageView c;
    public final AppCompatTextView d;
    public final View e;

    private f1(View view, AppCompatImageView appCompatImageView, ImageView imageView, AppCompatTextView appCompatTextView, View view2) {
        this.a = view;
        this.b = appCompatImageView;
        this.c = imageView;
        this.d = appCompatTextView;
        this.e = view2;
    }

    public static f1 a(View view) {
        AppCompatTextView a;
        View a2;
        int i = R.id.iv_download_fail;
        AppCompatImageView a3 = f4.b.a(view, i);
        if (a3 != null) {
            i = R.id.iv_download_icon;
            ImageView imageView = (ImageView) f4.b.a(view, i);
            if (imageView != null && (a = f4.b.a(view, (i = R.id.tv_download_status))) != null && (a2 = f4.b.a(view, (i = R.id.v_download_tips))) != null) {
                return new f1(view, a3, imageView, a, a2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public View getRoot() {
        return this.a;
    }
}
