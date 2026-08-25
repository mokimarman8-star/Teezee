package com.transsion.moviedetail.viewmodel;

import android.app.Application;
import android.os.Bundle;
import androidx.lifecycle.b0;
import androidx.lifecycle.u0;
import com.transsion.flow.p002enum.PostListSource;
import com.transsion.flow.p002enum.ProfileSubSource;
import com.transsion.moviedetailapi.AbsSubjectListViewModel;
import com.transsion.moviedetailapi.PostRankType;
import com.transsion.push.bean.MsgStyle;
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
public final class HotViewModel extends AbsSubjectListViewModel {
    private final Lazy k;
    private String l;
    private String m;
    private String n;
    private int o;
    private final b0 p;
    private final Lazy q;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HotViewModel(Application application) {
        super(application);
        Intrinsics.h(application, "application");
        this.k = LazyKt.a(LazyThreadSafetyMode.NONE, new Function0() { // from class: com.transsion.moviedetail.viewmodel.a
            public final Object invoke() {
                om.a j0;
                j0 = HotViewModel.j0();
                return j0;
            }
        });
        this.n = "0";
        this.p = new b0();
        this.q = LazyKt.b(new Function0() { // from class: com.transsion.moviedetail.viewmodel.b
            public final Object invoke() {
                com.transsion.usercenter.profile.b h0;
                h0 = HotViewModel.h0();
                return h0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.transsion.usercenter.profile.b Y() {
        return (com.transsion.usercenter.profile.b) this.q.getValue();
    }

    private final void a0(String str, String str2, int i, String str3, boolean z) {
        kotlinx.coroutines.i.d(u0.a(this), (CoroutineContext) null, (CoroutineStart) null, new HotViewModel$getPostSubject$1(this, str, str2, i, str3, z, null), 3, (Object) null);
    }

    public static /* synthetic */ void c0(HotViewModel hotViewModel, String str, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = MsgStyle.CUSTOM_LEFT_PIC;
        }
        if ((i2 & 2) != 0) {
            i = 3;
        }
        hotViewModel.b0(str, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final om.a e0() {
        return (om.a) this.k.getValue();
    }

    private final void g0(String str) {
        kotlinx.coroutines.i.d(u0.a(this), (CoroutineContext) null, (CoroutineStart) null, new HotViewModel$loadNewSubject$1(this, str, null), 3, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final com.transsion.usercenter.profile.b h0() {
        return (com.transsion.usercenter.profile.b) kg.c.e.a().h(com.transsion.usercenter.profile.b.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit i0(HotViewModel hotViewModel, PublishEvent publishEvent) {
        Intrinsics.h(publishEvent, "it");
        hotViewModel.g0(publishEvent.getPostId());
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final om.a j0() {
        return (om.a) kg.c.e.a().h(om.a.class);
    }

    public PostListSource A() {
        return PostListSource.SUBJECT;
    }

    public ProfileSubSource B() {
        return ProfileSubSource.COMMENTS;
    }

    public void E(boolean z) {
        a0(this.l, this.n, X(), t().getValue(), z);
    }

    public void F(Bundle bundle) {
        if (bundle != null) {
            this.l = bundle.getString("subject_id");
            this.m = bundle.getString("ops");
            PostRankType serializable = bundle.getSerializable("rank_type");
            Intrinsics.f(serializable, "null cannot be cast to non-null type com.transsion.moviedetailapi.PostRankType");
            M(serializable);
        }
        kotlinx.coroutines.i.d(u0.a(this), (CoroutineContext) null, (CoroutineStart) null, new HotViewModel$onCreate$$inlined$observeEvent$1(false, new Function1() { // from class: com.transsion.moviedetail.viewmodel.c
            public final Object invoke(Object obj) {
                Unit i0;
                i0 = HotViewModel.i0(HotViewModel.this, (PublishEvent) obj);
                return i0;
            }
        }, null), 3, (Object) null);
    }

    public int X() {
        return this.o;
    }

    public final String Z() {
        return this.m;
    }

    public final void b0(String str, int i) {
        Intrinsics.h(str, "page");
        kotlinx.coroutines.i.d(u0.a(this), (CoroutineContext) null, (CoroutineStart) null, new HotViewModel$getRecommendRooms$1(this, str, i, null), 3, (Object) null);
    }

    public final b0 d0() {
        return this.p;
    }

    public final String f0() {
        return this.l;
    }

    public void k0(int i) {
        this.o = i;
    }

    public String w(int i) {
        return i == PostRankType.POST_RANK_TYPE_NEW.ordinal() ? "subjectdetail_new" : "subjectdetail_hot";
    }
}
