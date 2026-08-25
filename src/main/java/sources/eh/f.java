package eh;

import android.view.View;
import android.widget.ProgressBar;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import com.tn.lib.widget.R$id;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class f implements f4.a {
    private final View a;
    public final AppCompatImageView b;
    public final ProgressBar c;
    public final AppCompatTextView d;

    private f(View view, AppCompatImageView appCompatImageView, ProgressBar progressBar, AppCompatTextView appCompatTextView) {
        this.a = view;
        this.b = appCompatImageView;
        this.c = progressBar;
        this.d = appCompatTextView;
    }

    public static f a(View view) {
        AppCompatTextView a;
        int i = R$id.iv_join;
        AppCompatImageView a2 = f4.b.a(view, i);
        if (a2 != null) {
            i = R$id.pb_loading;
            ProgressBar progressBar = (ProgressBar) f4.b.a(view, i);
            if (progressBar != null && (a = f4.b.a(view, (i = R$id.tv_join))) != null) {
                return new f(view, a2, progressBar, a);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public View getRoot() {
        return this.a;
    }
}
