package fp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;
import com.transsion.room.R$id;
import com.transsion.room.R$layout;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class d implements f4.a {
    private final ConstraintLayout a;
    public final View b;
    public final View c;
    public final AppCompatImageView d;
    public final ConstraintLayout e;
    public final TabLayout f;
    public final AppCompatTextView g;
    public final ViewPager2 h;

    private d(ConstraintLayout constraintLayout, View view, View view2, AppCompatImageView appCompatImageView, ConstraintLayout constraintLayout2, TabLayout tabLayout, AppCompatTextView appCompatTextView, ViewPager2 viewPager2) {
        this.a = constraintLayout;
        this.b = view;
        this.c = view2;
        this.d = appCompatImageView;
        this.e = constraintLayout2;
        this.f = tabLayout;
        this.g = appCompatTextView;
        this.h = viewPager2;
    }

    public static d a(View view) {
        View a;
        AppCompatImageView a2;
        ConstraintLayout a3;
        TabLayout a4;
        AppCompatTextView a5;
        ViewPager2 a6;
        int i = R$id.divider_line;
        View a7 = f4.b.a(view, i);
        if (a7 == null || (a = f4.b.a(view, (i = R$id.divider_line_1))) == null || (a2 = f4.b.a(view, (i = R$id.iv_back))) == null || (a3 = f4.b.a(view, (i = R$id.mTitleLayout))) == null || (a4 = f4.b.a(view, (i = R$id.tabLayout))) == null || (a5 = f4.b.a(view, (i = R$id.tv_title))) == null || (a6 = f4.b.a(view, (i = R$id.viewPager2))) == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }
        return new d((ConstraintLayout) view, a7, a, a2, a3, a4, a5, a6);
    }

    public static d c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static d d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R$layout.activity_likes_viewpager, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.a;
    }
}
