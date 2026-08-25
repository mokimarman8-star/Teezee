package qk;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager2.widget.ViewPager2;
import com.tn.lib.view.TitleLayout;
import com.transsion.home.R;
import net.lucode.hackware.magicindicator.MagicIndicator;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class c implements f4.a {
    private final ConstraintLayout a;
    public final MagicIndicator b;
    public final TitleLayout c;
    public final ViewPager2 d;

    private c(ConstraintLayout constraintLayout, MagicIndicator magicIndicator, TitleLayout titleLayout, ViewPager2 viewPager2) {
        this.a = constraintLayout;
        this.b = magicIndicator;
        this.c = titleLayout;
        this.d = viewPager2;
    }

    public static c a(View view) {
        TitleLayout a;
        ViewPager2 a2;
        int i = R.id.magic_indicator;
        MagicIndicator a3 = f4.b.a(view, i);
        if (a3 == null || (a = f4.b.a(view, (i = R.id.tool_bar))) == null || (a2 = f4.b.a(view, (i = R.id.view_pager))) == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }
        return new c((ConstraintLayout) view, a3, a, a2);
    }

    public static c c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static c d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.activity_movie_filter, viewGroup, false);
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
