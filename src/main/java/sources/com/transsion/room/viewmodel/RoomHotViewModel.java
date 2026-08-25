package com.transsion.room.viewmodel;

import android.app.Application;
import android.os.Bundle;
import androidx.lifecycle.u0;
import com.transsion.flow.p002enum.PostListSource;
import com.transsion.moviedetailapi.AbsSubjectListViewModel;
import com.transsion.moviedetailapi.PostRankType;
import com.transsnet.flow.event.sync.event.PublishEvent;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class RoomHotViewModel extends AbsSubjectListViewModel {
    private int k;
    private final Lazy l;
    private String m;
    private String n;
    private final Lazy o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RoomHotViewModel(Application application) {
        super(application);
        Intrinsics.h(application, "application");
        this.k = 10;
        this.l = LazyKt.a(LazyThreadSafetyMode.NONE, new Function0() { // from class: com.transsion.room.viewmodel.j
            public final Object invoke() {
                ip.a d0;
                d0 = RoomHotViewModel.d0();
                return d0;
            }
        });
        this.n = "0";
        this.o = LazyKt.b(new Function0() { // from class: com.transsion.room.viewmodel.k
            public final Object invoke() {
                com.transsion.usercenter.profile.b b0;
                b0 = RoomHotViewModel.b0();
                return b0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.transsion.usercenter.profile.b X() {
        return (com.transsion.usercenter.profile.b) this.o.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ip.a Z() {
        return (ip.a) this.l.getValue();
    }

    private final void a0(String str) {
        kotlinx.coroutines.i.d(u0.a(this), (CoroutineContext) null, (CoroutineStart) null, new RoomHotViewModel$loadNewSubject$1(this, str, null), 3, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final com.transsion.usercenter.profile.b b0() {
        return (com.transsion.usercenter.profile.b) kg.c.e.a().h(com.transsion.usercenter.profile.b.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit c0(RoomHotViewModel roomHotViewModel, PublishEvent publishEvent) {
        Intrinsics.h(publishEvent, "it");
        roomHotViewModel.a0(publishEvent.getPostId());
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ip.a d0() {
        return (ip.a) kg.c.e.a().h(ip.a.class);
    }

    public PostListSource A() {
        return PostListSource.ROOM;
    }

    public void E(boolean z) {
        Y(this.m, this.n, W(), t().getValue(), z);
    }

    public void F(Bundle bundle) {
        if (bundle != null) {
            this.m = bundle.getString("subject_id");
            PostRankType serializable = bundle.getSerializable("rank_type");
            Intrinsics.f(serializable, "null cannot be cast to non-null type com.transsion.moviedetailapi.PostRankType");
            M(serializable);
        }
        kotlinx.coroutines.i.d(u0.a(this), (CoroutineContext) null, (CoroutineStart) null, new RoomHotViewModel$onCreate$$inlined$observeEvent$1(false, new Function1() { // from class: com.transsion.room.viewmodel.l
            public final Object invoke(Object obj) {
                Unit c0;
                c0 = RoomHotViewModel.c0(RoomHotViewModel.this, (PublishEvent) obj);
                return c0;
            }
        }, null), 3, (Object) null);
    }

    public int W() {
        return this.k;
    }

    public final void Y(String str, String str2, int i, String str3, boolean z) {
        Intrinsics.h(str2, "page");
        Intrinsics.h(str3, "sortType");
        kotlinx.coroutines.i.d(u0.a(this), (CoroutineContext) null, (CoroutineStart) null, new RoomHotViewModel$getPostSubject$1(this, str, str2, i, str3, z, null), 3, (Object) null);
    }

    public void e0(int i) {
        this.k = i;
    }

    public String w(int i) {
        return i == PostRankType.POST_RANK_TYPE_NEW.ordinal() ? "roomdetail_new" : "roomdetail_hot";
    }
}
