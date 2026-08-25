package qk;

import android.view.View;
import android.view.ViewStub;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.tabs.TabLayout;
import com.transsion.home.R;
import com.transsion.home.view.filter.expand.UGCFilterExpandView;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class i0 implements f4.a {
    private final ConstraintLayout a;
    public final UGCFilterExpandView b;
    public final ConstraintLayout c;
    public final ViewStub d;
    public final ViewStub e;
    public final ViewStub f;
    public final TabLayout g;

    private i0(ConstraintLayout constraintLayout, UGCFilterExpandView uGCFilterExpandView, ConstraintLayout constraintLayout2, ViewStub viewStub, ViewStub viewStub2, ViewStub viewStub3, TabLayout tabLayout) {
        this.a = constraintLayout;
        this.b = uGCFilterExpandView;
        this.c = constraintLayout2;
        this.d = viewStub;
        this.e = viewStub2;
        this.f = viewStub3;
        this.g = tabLayout;
    }

    public static i0 a(View view) {
        ConstraintLayout a;
        TabLayout a2;
        int i = R.id.filterExpand;
        UGCFilterExpandView uGCFilterExpandView = (UGCFilterExpandView) f4.b.a(view, i);
        if (uGCFilterExpandView != null && (a = f4.b.a(view, (i = R.id.ll_tab_movie))) != null) {
            i = R.id.loading_stub;
            ViewStub viewStub = (ViewStub) f4.b.a(view, i);
            if (viewStub != null) {
                i = R.id.no_network_stub;
                ViewStub viewStub2 = (ViewStub) f4.b.a(view, i);
                if (viewStub2 != null) {
                    i = R.id.no_result_stub;
                    ViewStub viewStub3 = (ViewStub) f4.b.a(view, i);
                    if (viewStub3 != null && (a2 = f4.b.a(view, (i = R.id.tab_movie))) != null) {
                        return new i0((ConstraintLayout) view, uGCFilterExpandView, a, viewStub, viewStub2, viewStub3, a2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.a;
    }
}
