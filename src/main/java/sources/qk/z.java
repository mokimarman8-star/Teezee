package qk;

import android.view.View;
import android.view.ViewStub;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.tabs.TabLayout;
import com.transsion.home.R;
import com.transsion.home.view.filter.expand.FilterExpandView;
import com.transsion.home.view.filter.expand.TabExpandView;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class z implements f4.a {
    private final ConstraintLayout a;
    public final TabExpandView b;
    public final FilterExpandView c;
    public final ConstraintLayout d;
    public final ViewStub e;
    public final ViewStub f;
    public final ViewStub g;
    public final TabLayout h;

    private z(ConstraintLayout constraintLayout, TabExpandView tabExpandView, FilterExpandView filterExpandView, ConstraintLayout constraintLayout2, ViewStub viewStub, ViewStub viewStub2, ViewStub viewStub3, TabLayout tabLayout) {
        this.a = constraintLayout;
        this.b = tabExpandView;
        this.c = filterExpandView;
        this.d = constraintLayout2;
        this.e = viewStub;
        this.f = viewStub2;
        this.g = viewStub3;
        this.h = tabLayout;
    }

    public static z a(View view) {
        ConstraintLayout a;
        TabLayout a2;
        int i = R.id.channelExpand;
        TabExpandView tabExpandView = (TabExpandView) f4.b.a(view, i);
        if (tabExpandView != null) {
            i = R.id.filterExpand;
            FilterExpandView filterExpandView = (FilterExpandView) f4.b.a(view, i);
            if (filterExpandView != null && (a = f4.b.a(view, (i = R.id.ll_tab_movie))) != null) {
                i = R.id.loading_stub;
                ViewStub viewStub = (ViewStub) f4.b.a(view, i);
                if (viewStub != null) {
                    i = R.id.no_network_stub;
                    ViewStub viewStub2 = (ViewStub) f4.b.a(view, i);
                    if (viewStub2 != null) {
                        i = R.id.no_result_stub;
                        ViewStub viewStub3 = (ViewStub) f4.b.a(view, i);
                        if (viewStub3 != null && (a2 = f4.b.a(view, (i = R.id.tab_movie))) != null) {
                            return new z((ConstraintLayout) view, tabExpandView, filterExpandView, a, viewStub, viewStub2, viewStub3, a2);
                        }
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
