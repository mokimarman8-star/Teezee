package dm;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.tn.lib.view.TitleLayout;
import com.transsion.mbwidget.R$id;
import com.transsion.mbwidget.R$layout;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class a implements f4.a {
    private final LinearLayout a;
    public final TitleLayout b;

    private a(LinearLayout linearLayout, TitleLayout titleLayout) {
        this.a = linearLayout;
        this.b = titleLayout;
    }

    public static a a(View view) {
        int i = R$id.mTitleLayout;
        TitleLayout a = f4.b.a(view, i);
        if (a != null) {
            return new a((LinearLayout) view, a);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static a c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static a d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R$layout.activity_widget_guide, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.a;
    }
}
