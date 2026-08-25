package xt;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewpager2.widget.ViewPager2;
import com.tn.lib.view.TitleLayout;
import com.transsion.transfer.R$id;
import com.transsion.transfer.R$layout;
import net.lucode.hackware.magicindicator.MagicIndicator;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class b implements f4.a {
    private final ConstraintLayout a;
    public final LinearLayout b;
    public final CoordinatorLayout c;
    public final LinearLayout d;
    public final FrameLayout e;
    public final MagicIndicator f;
    public final TextView g;
    public final TitleLayout h;
    public final TextView i;
    public final TextView j;
    public final AppCompatImageView k;
    public final ImageView l;
    public final ViewPager2 m;

    private b(ConstraintLayout constraintLayout, LinearLayout linearLayout, CoordinatorLayout coordinatorLayout, LinearLayout linearLayout2, FrameLayout frameLayout, MagicIndicator magicIndicator, TextView textView, TitleLayout titleLayout, TextView textView2, TextView textView3, AppCompatImageView appCompatImageView, ImageView imageView, ViewPager2 viewPager2) {
        this.a = constraintLayout;
        this.b = linearLayout;
        this.c = coordinatorLayout;
        this.d = linearLayout2;
        this.e = frameLayout;
        this.f = magicIndicator;
        this.g = textView;
        this.h = titleLayout;
        this.i = textView2;
        this.j = textView3;
        this.k = appCompatImageView;
        this.l = imageView;
        this.m = viewPager2;
    }

    public static b a(View view) {
        CoordinatorLayout a;
        MagicIndicator a2;
        TitleLayout a3;
        AppCompatImageView a4;
        ViewPager2 a5;
        int i = R$id.bottom_layout;
        LinearLayout linearLayout = (LinearLayout) f4.b.a(view, i);
        if (linearLayout != null && (a = f4.b.a(view, (i = R$id.cl_root))) != null) {
            i = R$id.connect_info_layout;
            LinearLayout linearLayout2 = (LinearLayout) f4.b.a(view, i);
            if (linearLayout2 != null) {
                i = R$id.fl_select_page_container;
                FrameLayout frameLayout = (FrameLayout) f4.b.a(view, i);
                if (frameLayout != null && (a2 = f4.b.a(view, (i = R$id.magic_indicator))) != null) {
                    i = R$id.sendMore;
                    TextView textView = (TextView) f4.b.a(view, i);
                    if (textView != null && (a3 = f4.b.a(view, (i = R$id.tool_bar))) != null) {
                        i = R$id.transfer_connect_state;
                        TextView textView2 = (TextView) f4.b.a(view, i);
                        if (textView2 != null) {
                            i = R$id.transfer_connected_devicename;
                            TextView textView3 = (TextView) f4.b.a(view, i);
                            if (textView3 != null && (a4 = f4.b.a(view, (i = R$id.transfer_connected_state_image))) != null) {
                                i = R$id.v_top_bg;
                                ImageView imageView = (ImageView) f4.b.a(view, i);
                                if (imageView != null && (a5 = f4.b.a(view, (i = R$id.view_pager))) != null) {
                                    return new b((ConstraintLayout) view, linearLayout, a, linearLayout2, frameLayout, a2, textView, a3, textView2, textView3, a4, imageView, a5);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static b c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static b d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R$layout.activity_transfer_status, viewGroup, false);
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
