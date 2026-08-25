package bx;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager2.widget.ViewPager2;
import com.transsnet.downloader.R;
import net.lucode.hackware.magicindicator.MagicIndicator;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class r0 implements f4.a {
    private final ConstraintLayout a;
    public final MagicIndicator b;
    public final View c;
    public final ViewPager2 d;

    private r0(ConstraintLayout constraintLayout, MagicIndicator magicIndicator, View view, ViewPager2 viewPager2) {
        this.a = constraintLayout;
        this.b = magicIndicator;
        this.c = view;
        this.d = viewPager2;
    }

    public static r0 a(View view) {
        View a;
        ViewPager2 a2;
        int i = R.id.magic_indicator;
        MagicIndicator a3 = f4.b.a(view, i);
        if (a3 == null || (a = f4.b.a(view, (i = R.id.view_divider))) == null || (a2 = f4.b.a(view, (i = R.id.view_pager))) == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }
        return new r0((ConstraintLayout) view, a3, a, a2);
    }

    public static r0 c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static r0 d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_ugc_my_downloads, viewGroup, false);
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
