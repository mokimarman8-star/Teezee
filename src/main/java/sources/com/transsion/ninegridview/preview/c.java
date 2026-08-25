package com.transsion.ninegridview.preview;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import com.transsion.moviedetailapi.bean.Image;
import com.transsion.ninegridview.preview.GifImagePreviewFragment;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class c extends FragmentStateAdapter {
    private List a;
    private Boolean b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(FragmentActivity fragmentActivity) {
        super(fragmentActivity);
        Intrinsics.h(fragmentActivity, "activity");
        this.b = Boolean.FALSE;
    }

    public Fragment createFragment(int i) {
        GifImagePreviewFragment.Companion companion = GifImagePreviewFragment.INSTANCE;
        Boolean bool = this.b;
        List list = this.a;
        return companion.a(bool, list != null ? (Image) list.get(i) : null, i);
    }

    public final void g(Boolean bool) {
        this.b = bool;
    }

    public int getItemCount() {
        List list = this.a;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public final void h(List list) {
        this.a = list;
    }
}
