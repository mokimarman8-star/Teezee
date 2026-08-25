package qk;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewpager2.widget.ViewPager2;
import com.transsion.home.R;
import net.lucode.hackware.magicindicator.MagicIndicator;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class n implements f4.a {
    private final LinearLayout a;
    public final View b;
    public final MagicIndicator c;
    public final ViewPager2 d;

    private n(LinearLayout linearLayout, View view, MagicIndicator magicIndicator, ViewPager2 viewPager2) {
        this.a = linearLayout;
        this.b = view;
        this.c = magicIndicator;
        this.d = viewPager2;
    }

    public static n a(View view) {
        MagicIndicator a;
        ViewPager2 a2;
        int i = R.id.hashtag_divider_view;
        View a3 = f4.b.a(view, i);
        if (a3 == null || (a = f4.b.a(view, (i = R.id.hashtag_magic_indicator))) == null || (a2 = f4.b.a(view, (i = R.id.hashtag_viewpager))) == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }
        return new n((LinearLayout) view, a3, a, a2);
    }

    public static n c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static n d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_hashtag, viewGroup, false);
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
