package sh;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.transsion.ad.R$id;
import com.transsion.ad.R$layout;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public final class y implements f4.a {
    private final FrameLayout a;
    public final View b;
    public final View c;

    private y(FrameLayout frameLayout, View view, View view2) {
        this.a = frameLayout;
        this.b = view;
        this.c = view2;
    }

    public static y a(View view) {
        View a;
        int i = R$id.viewBottom;
        View a2 = f4.b.a(view, i);
        if (a2 == null || (a = f4.b.a(view, (i = R$id.viewTop))) == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }
        return new y((FrameLayout) view, a2, a);
    }

    public static y c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static y d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R$layout.activity_test_view_measure_layout, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.a;
    }
}
