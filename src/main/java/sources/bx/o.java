package bx;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.viewpager2.widget.ViewPager2;
import com.tn.lib.view.indicator.CircleIndicator;
import com.transsnet.downloader.R;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class o implements f4.a {
    private final LinearLayout a;
    public final TextView b;
    public final ViewPager2 c;
    public final CircleIndicator d;
    public final AppCompatImageView e;
    public final TextView f;
    public final TextView g;

    private o(LinearLayout linearLayout, TextView textView, ViewPager2 viewPager2, CircleIndicator circleIndicator, AppCompatImageView appCompatImageView, TextView textView2, TextView textView3) {
        this.a = linearLayout;
        this.b = textView;
        this.c = viewPager2;
        this.d = circleIndicator;
        this.e = appCompatImageView;
        this.f = textView2;
        this.g = textView3;
    }

    public static o a(View view) {
        ViewPager2 a;
        CircleIndicator a2;
        AppCompatImageView a3;
        int i = R.id.guide_desc;
        TextView textView = (TextView) f4.b.a(view, i);
        if (textView != null && (a = f4.b.a(view, (i = R.id.guide_pager))) != null && (a2 = f4.b.a(view, (i = R.id.indicator))) != null && (a3 = f4.b.a(view, (i = R.id.ivClose))) != null) {
            i = R.id.next;
            TextView textView2 = (TextView) f4.b.a(view, i);
            if (textView2 != null) {
                i = R.id.title;
                TextView textView3 = (TextView) f4.b.a(view, i);
                if (textView3 != null) {
                    return new o((LinearLayout) view, textView, a, a2, a3, textView2, textView3);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.a;
    }
}
