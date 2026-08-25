package xu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.tn.lib.view.TitleLayout;
import com.transsion.usercenter.R$id;
import com.transsion.usercenter.R$layout;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class j implements f4.a {
    private final RelativeLayout a;
    public final FrameLayout b;
    public final ProgressBar c;
    public final TitleLayout d;

    private j(RelativeLayout relativeLayout, FrameLayout frameLayout, ProgressBar progressBar, TitleLayout titleLayout) {
        this.a = relativeLayout;
        this.b = frameLayout;
        this.c = progressBar;
        this.d = titleLayout;
    }

    public static j a(View view) {
        TitleLayout a;
        int i = R$id.fl_content;
        FrameLayout frameLayout = (FrameLayout) f4.b.a(view, i);
        if (frameLayout != null) {
            i = R$id.load_view;
            ProgressBar progressBar = (ProgressBar) f4.b.a(view, i);
            if (progressBar != null && (a = f4.b.a(view, (i = R$id.toolbar))) != null) {
                return new j((RelativeLayout) view, frameLayout, progressBar, a);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static j c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static j d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R$layout.activity_profile_center_edit, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public RelativeLayout getRoot() {
        return this.a;
    }
}
