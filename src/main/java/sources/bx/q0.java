package bx;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewpager2.widget.ViewPager2;
import com.transsnet.downloader.R;
import net.lucode.hackware.magicindicator.MagicIndicator;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class q0 implements f4.a {
    private final LinearLayout a;
    public final MagicIndicator b;
    public final ViewPager2 c;

    private q0(LinearLayout linearLayout, MagicIndicator magicIndicator, ViewPager2 viewPager2) {
        this.a = linearLayout;
        this.b = magicIndicator;
        this.c = viewPager2;
    }

    public static q0 a(View view) {
        ViewPager2 a;
        int i = R.id.magic_indicator;
        MagicIndicator a2 = f4.b.a(view, i);
        if (a2 == null || (a = f4.b.a(view, (i = R.id.view_pager))) == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }
        return new q0((LinearLayout) view, a2, a);
    }

    public static q0 c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static q0 d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_ugc_my_downloaded_tab, viewGroup, false);
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
