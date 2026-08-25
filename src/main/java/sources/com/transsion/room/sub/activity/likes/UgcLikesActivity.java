package com.transsion.room.sub.activity.likes;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.widget.l;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.tn.lib.widget.R;
import com.transsion.baseui.activity.BaseActivity;
import com.transsion.gslb.BuildConfig;
import com.transsion.room.R$id;
import com.transsion.room.R$layout;
import com.transsion.room.R$string;
import com.transsion.room.sub.activity.likes.UgcLikesActivity;
import com.transsion.room.sub.adapter.likes.b;
import fp.d;
import ij.y;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001f\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u0010\u001a\u00020\t2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0014\u0010\u0013¨\u0006\u0015"}, d2 = {"Lcom/transsion/room/sub/activity/likes/UgcLikesActivity;", "Lcom/transsion/baseui/activity/BaseActivity;", "Lfp/d;", "<init>", "()V", "Lcom/google/android/material/tabs/TabLayout$Tab;", "tab", BuildConfig.FLAVOR, "isSelected", BuildConfig.FLAVOR, "h0", "(Lcom/google/android/material/tabs/TabLayout$Tab;Z)V", "e0", "()Lfp/d;", "Landroid/os/Bundle;", "savedInstanceState", "initView", "(Landroid/os/Bundle;)V", "isTranslucent", "()Z", "isStatusDark", "Room_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class UgcLikesActivity extends BaseActivity<d> {

    public static final class a implements TabLayout.OnTabSelectedListener {
        final /* synthetic */ ViewPager2 b;

        a(ViewPager2 viewPager2) {
            this.b = viewPager2;
        }

        public void onTabReselected(TabLayout.Tab tab) {
        }

        public void onTabSelected(TabLayout.Tab tab) {
            UgcLikesActivity ugcLikesActivity = UgcLikesActivity.this;
            Intrinsics.e(tab);
            ugcLikesActivity.h0(tab, true);
            this.b.setCurrentItem(tab.getPosition(), true);
        }

        public void onTabUnselected(TabLayout.Tab tab) {
            UgcLikesActivity ugcLikesActivity = UgcLikesActivity.this;
            Intrinsics.e(tab);
            ugcLikesActivity.h0(tab, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f0(b bVar, UgcLikesActivity ugcLikesActivity, TabLayout.Tab tab, int i) {
        Intrinsics.h(tab, "tab");
        tab.setText(bVar.h(i));
        ugcLikesActivity.h0(tab, i == 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g0(UgcLikesActivity ugcLikesActivity, View view) {
        ugcLikesActivity.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void h0(TabLayout.Tab tab, boolean isSelected) {
        View customView;
        TextView textView;
        if (tab.getCustomView() == null || (customView = tab.getCustomView()) == null || (textView = (TextView) customView.findViewById(R$id.tv_tab_title)) == null) {
            return;
        }
        textView.setTypeface(isSelected ? Typeface.create(Typeface.DEFAULT, 1) : Typeface.create(Typeface.DEFAULT, 0));
        l.p(textView, isSelected ? R.style.style_import_text : R.style.style_regular_text);
        textView.setTextSize(isSelected ? 16.0f : 14.0f);
        textView.setTextColor(androidx.core.content.b.getColor(this, isSelected ? R.color.white : R.color.white_80));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: e0, reason: merged with bridge method [inline-methods] */
    public d getViewBinding() {
        d c = d.c(getLayoutInflater());
        Intrinsics.g(c, "inflate(...)");
        return c;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void initView(Bundle savedInstanceState) {
        if (savedInstanceState == null) {
            final b bVar = new b(this);
            ((d) getMViewBinding()).h.setAdapter(bVar);
            ViewGroup viewGroup = ((d) getMViewBinding()).f;
            Intrinsics.g(viewGroup, "tabLayout");
            ViewPager2 viewPager2 = ((d) getMViewBinding()).h;
            Intrinsics.g(viewPager2, "viewPager2");
            new TabLayoutMediator(viewGroup, viewPager2, new TabLayoutMediator.TabConfigurationStrategy() { // from class: kp.a
                public final void onConfigureTab(TabLayout.Tab tab, int i) {
                    UgcLikesActivity.f0(com.transsion.room.sub.adapter.likes.b.this, this, tab, i);
                }
            }).attach();
            viewPager2.setCurrentItem(0, false);
            ((d) getMViewBinding()).d.setOnClickListener(new View.OnClickListener() { // from class: kp.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    UgcLikesActivity.g0(UgcLikesActivity.this, view);
                }
            });
            viewGroup.removeAllTabs();
            for (String str : CollectionsKt.o(new String[]{getString(R$string.play_hub), getString(R$string.buzz_box)})) {
                TabLayout.Tab newTab = viewGroup.newTab();
                Intrinsics.g(newTab, "newTab(...)");
                View inflate = LayoutInflater.from(this).inflate(R$layout.ugc_likes_item_tab_custom, viewGroup, false);
                ((TextView) inflate.findViewById(R$id.tv_tab_title)).setText(str);
                newTab.setCustomView(inflate);
                viewGroup.addTab(newTab);
            }
            TabLayout.Tab tabAt = viewGroup.getTabAt(0);
            if (tabAt != null) {
                tabAt.select();
                h0(tabAt, true);
            }
            ((d) getMViewBinding()).f.addOnTabSelectedListener(new a(viewPager2));
        }
    }

    public boolean isStatusDark() {
        return !y.a.a();
    }

    public boolean isTranslucent() {
        return true;
    }
}
