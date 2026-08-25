package com.transsion.home.adapter;

import android.content.Context;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import androidx.viewpager2.widget.ViewPager2;
import com.blankj.utilcode.util.a0;
import com.blankj.utilcode.util.i;
import com.tn.lib.view.GradientLinePagerIndicator;
import com.tn.lib.widget.R;
import com.transsion.baseui.widget.CustomPagerTitleView;
import kotlin.jvm.internal.Intrinsics;
import net.lucode.hackware.magicindicator.MagicIndicator;
import qk.h;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class d extends xy.a {
    private final h b;

    public static final class a extends com.transsion.baseui.util.f {
        final /* synthetic */ int f;

        a(int i) {
            this.f = i;
        }

        @Override // com.transsion.baseui.util.f
        public void c(View view) {
        }

        @Override // com.transsion.baseui.util.f
        public void d(View view) {
            MagicIndicator magicIndicator;
            ViewPager2 viewPager2;
            h hVar = d.this.b;
            if (hVar != null && (viewPager2 = hVar.k) != null) {
                viewPager2.setCurrentItem(this.f, true);
            }
            h hVar2 = d.this.b;
            if (hVar2 == null || (magicIndicator = hVar2.h) == null) {
                return;
            }
            magicIndicator.onPageScrolled(this.f, 0.0f, 0);
        }
    }

    public d(h hVar) {
        this.b = hVar;
    }

    public int a() {
        return 2;
    }

    public xy.c b(Context context) {
        Intrinsics.h(context, "context");
        GradientLinePagerIndicator gradientLinePagerIndicator = new GradientLinePagerIndicator(context);
        gradientLinePagerIndicator.setMode(2);
        gradientLinePagerIndicator.setLineHeight(i.e(3.0f));
        gradientLinePagerIndicator.setLineWidth(i.e(24.0f));
        gradientLinePagerIndicator.setRoundRadius(i.e(1.5f));
        gradientLinePagerIndicator.setStartInterpolator(new AccelerateInterpolator());
        gradientLinePagerIndicator.setEndInterpolator(new DecelerateInterpolator(2.0f));
        int color = androidx.core.content.b.getColor(context, R.color.transparent);
        gradientLinePagerIndicator.setColors(color, color, color);
        return gradientLinePagerIndicator;
    }

    public xy.d c(Context context, int i) {
        Intrinsics.h(context, "context");
        CustomPagerTitleView customPagerTitleView = new CustomPagerTitleView(context, 17, a0.a(10.0f));
        customPagerTitleView.setText(i != 0 ? i != 1 ? "default" : context.getResources().getString(com.transsion.home.R.string.music_tab_liked_music) : context.getResources().getString(com.transsion.home.R.string.music_tab_discover));
        customPagerTitleView.setTextSize(18.0f);
        customPagerTitleView.setOnClickListener(new a(i));
        return customPagerTitleView;
    }
}
