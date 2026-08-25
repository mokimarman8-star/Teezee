package eh;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Space;
import androidx.appcompat.widget.AppCompatTextView;
import com.tn.lib.widget.R$id;
import com.tn.lib.widget.R$layout;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class d implements f4.a {
    private final View a;
    public final AppCompatTextView b;
    public final ProgressBar c;
    public final AppCompatTextView d;
    public final Space e;
    public final AppCompatTextView f;

    private d(View view, AppCompatTextView appCompatTextView, ProgressBar progressBar, AppCompatTextView appCompatTextView2, Space space, AppCompatTextView appCompatTextView3) {
        this.a = view;
        this.b = appCompatTextView;
        this.c = progressBar;
        this.d = appCompatTextView2;
        this.e = space;
        this.f = appCompatTextView3;
    }

    public static d a(View view) {
        AppCompatTextView a;
        AppCompatTextView a2;
        int i = R$id.go_to_setting;
        AppCompatTextView a3 = f4.b.a(view, i);
        if (a3 != null) {
            i = R$id.progress_bar;
            ProgressBar progressBar = (ProgressBar) f4.b.a(view, i);
            if (progressBar != null && (a = f4.b.a(view, (i = R$id.retry))) != null) {
                i = R$id.space;
                Space space = (Space) f4.b.a(view, i);
                if (space != null && (a2 = f4.b.a(view, (i = R$id.tv_title))) != null) {
                    return new d(view, a3, progressBar, a, space, a2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static d b(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        if (viewGroup == null) {
            throw new NullPointerException("parent");
        }
        layoutInflater.inflate(R$layout.view_no_network, viewGroup);
        return a(viewGroup);
    }

    public View getRoot() {
        return this.a;
    }
}
