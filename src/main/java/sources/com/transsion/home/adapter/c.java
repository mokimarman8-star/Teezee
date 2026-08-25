package com.transsion.home.adapter;

import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;
import com.transsion.home.fragment.tab.SubTabFragment;
import com.transsion.videodetail.music.ui.MusicTabLikedFragment;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class c extends FragmentStateAdapter {
    private final ViewPager2 a;
    private final int b;
    private final String c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(ViewPager2 viewPager2, int i, String str, Fragment fragment) {
        super(fragment);
        Intrinsics.h(fragment, "fragment");
        this.a = viewPager2;
        this.b = i;
        this.c = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit h(c cVar) {
        ViewPager2 viewPager2 = cVar.a;
        if (viewPager2 != null) {
            viewPager2.setCurrentItem(0);
        }
        return Unit.a;
    }

    public Fragment createFragment(int i) {
        if (i == 0) {
            return SubTabFragment.INSTANCE.b(this.b, this.c);
        }
        if (i != 1) {
            return new MusicTabLikedFragment();
        }
        MusicTabLikedFragment musicTabLikedFragment = new MusicTabLikedFragment();
        musicTabLikedFragment.m1(new Function0() { // from class: com.transsion.home.adapter.b
            public final Object invoke() {
                Unit h;
                h = c.h(c.this);
                return h;
            }
        });
        return musicTabLikedFragment;
    }

    public int getItemCount() {
        return 2;
    }
}
