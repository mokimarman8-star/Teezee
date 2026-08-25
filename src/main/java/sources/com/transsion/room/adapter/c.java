package com.transsion.room.adapter;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import com.therouter.TheRouter;
import com.transsion.baseui.fragment.EmptyFragment;
import com.transsion.moviedetailapi.PostRankType;
import com.transsion.moviedetailapi.g;
import com.transsion.room.viewmodel.RoomHotViewModel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class c extends FragmentStateAdapter {
    private final String a;
    private final Lazy b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(String str, Fragment fragment) {
        super(fragment);
        Intrinsics.h(fragment, "fragment");
        this.a = str;
        this.b = LazyKt.b(new Function0() { // from class: com.transsion.room.adapter.b
            public final Object invoke() {
                g i;
                i = c.i();
                return i;
            }
        });
    }

    private final g h() {
        return (g) this.b.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final g i() {
        return (g) TheRouter.d(g.class, new Object[0]);
    }

    public Fragment createFragment(int i) {
        Bundle bundle = new Bundle();
        PostRankType postRankType = i == 0 ? PostRankType.POST_RANK_TYPE_HOT : PostRankType.POST_RANK_TYPE_NEW;
        bundle.putString("subject_id", this.a);
        bundle.putSerializable("rank_type", postRankType);
        g h = h();
        Fragment e = h != null ? h.e(bundle, RoomHotViewModel.class) : null;
        return e == null ? new EmptyFragment() : e;
    }

    public int getItemCount() {
        return 2;
    }
}
