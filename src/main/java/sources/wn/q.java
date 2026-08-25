package wn;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.viewpager2.widget.ViewPager2;
import com.transsion.postdetail.R$id;
import com.transsion.postdetail.R$layout;
import net.lucode.hackware.magicindicator.MagicIndicator;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class q implements f4.a {
    private final FrameLayout a;
    public final MagicIndicator b;
    public final ViewPager2 c;

    private q(FrameLayout frameLayout, MagicIndicator magicIndicator, ViewPager2 viewPager2) {
        this.a = frameLayout;
        this.b = magicIndicator;
        this.c = viewPager2;
    }

    public static q a(View view) {
        ViewPager2 a;
        int i = R$id.magic_indicator;
        MagicIndicator a2 = f4.b.a(view, i);
        if (a2 == null || (a = f4.b.a(view, (i = R$id.view_pager))) == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }
        return new q((FrameLayout) view, a2, a);
    }

    public static q c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static q d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R$layout.fragment_short_tv_home, viewGroup, false);
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
