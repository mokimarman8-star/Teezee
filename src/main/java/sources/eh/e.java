package eh;

import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import com.tn.lib.widget.R$id;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class e implements f4.a {
    private final View a;
    public final AppCompatImageView b;

    private e(View view, AppCompatImageView appCompatImageView) {
        this.a = view;
        this.b = appCompatImageView;
    }

    public static e a(View view) {
        int i = R$id.iv_join;
        AppCompatImageView a = f4.b.a(view, i);
        if (a != null) {
            return new e(view, a);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public View getRoot() {
        return this.a;
    }
}
