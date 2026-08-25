package com.transsion.moviedetail.fragment;

import com.hisavana.common.bean.TAdErrorCode;
import com.transsion.ad.bidding.base.AbsAdBidding;
import com.transsion.ad.bidding.base.BiddingIntermediateMaterialBean;
import com.transsion.ad.bidding.nativead.BiddingListManager;
import com.transsion.ad.bidding.nativead.BiddingNativeManager;
import com.transsion.gslb.BuildConfig;
import com.transsion.moviedetailapi.bean.PostSubjectItem;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineStart;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.moviedetail.fragment.SubjectListFragment$insertLast$1", f = "SubjectListFragment.kt", l = {}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class SubjectListFragment$insertLast$1 extends SuspendLambda implements Function2<kotlinx.coroutines.n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<PostSubjectItem> $dataList;
    int label;
    final /* synthetic */ SubjectListFragment this$0;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
    @DebugMetadata(c = "com.transsion.moviedetail.fragment.SubjectListFragment$insertLast$1$2", f = "SubjectListFragment.kt", l = {1174}, m = "invokeSuspend")
    /* renamed from: com.transsion.moviedetail.fragment.SubjectListFragment$insertLast$1$2, reason: invalid class name */
    static final class AnonymousClass2 extends SuspendLambda implements Function2<kotlinx.coroutines.n0, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ SubjectListFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(SubjectListFragment subjectListFragment, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.this$0 = subjectListFragment;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.this$0, continuation);
        }

        public final Object invoke(kotlinx.coroutines.n0 n0Var, Continuation<? super Unit> continuation) {
            return create(n0Var, continuation).invokeSuspend(Unit.a);
        }

        public final Object invokeSuspend(Object obj) {
            BiddingNativeManager biddingNativeManager;
            Object f = IntrinsicsKt.f();
            int i = this.label;
            if (i == 0) {
                ResultKt.b(obj);
                biddingNativeManager = this.this$0.nativeManager;
                if (biddingNativeManager != null) {
                    this.label = 1;
                    if (AbsAdBidding.t0(biddingNativeManager, 0, false, this, 3, (Object) null) == f) {
                        return f;
                    }
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            }
            return Unit.a;
        }
    }

    public static final class a extends oh.a {
        final /* synthetic */ SubjectListFragment d;
        final /* synthetic */ List e;

        a(SubjectListFragment subjectListFragment, List list) {
            this.d = subjectListFragment;
            this.e = list;
        }

        public void i(TAdErrorCode tAdErrorCode) {
            super.i(tAdErrorCode);
        }

        public void j(BiddingIntermediateMaterialBean biddingIntermediateMaterialBean) {
            BiddingNativeManager biddingNativeManager;
            BiddingListManager biddingListManager;
            BiddingListManager biddingListManager2;
            Function2 r;
            super.j(biddingIntermediateMaterialBean);
            biddingNativeManager = this.d.nativeManager;
            if (biddingNativeManager != null) {
                SubjectListFragment subjectListFragment = this.d;
                List list = this.e;
                biddingListManager = subjectListFragment.middleListManager;
                if (biddingListManager != null && (r = biddingListManager.r()) != null) {
                }
                biddingListManager2 = subjectListFragment.middleListManager;
                if (biddingListManager2 != null) {
                    biddingListManager2.D((Function2) null);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SubjectListFragment$insertLast$1(SubjectListFragment subjectListFragment, List<PostSubjectItem> list, Continuation<? super SubjectListFragment$insertLast$1> continuation) {
        super(2, continuation);
        this.this$0 = subjectListFragment;
        this.$dataList = list;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SubjectListFragment$insertLast$1(this.this$0, this.$dataList, continuation);
    }

    public final Object invoke(kotlinx.coroutines.n0 n0Var, Continuation<? super Unit> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    public final Object invokeSuspend(Object obj) {
        BiddingNativeManager biddingNativeManager;
        BiddingNativeManager biddingNativeManager2;
        IntrinsicsKt.f();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        this.this$0.nativeManager = new BiddingNativeManager();
        biddingNativeManager = this.this$0.nativeManager;
        if (biddingNativeManager != null) {
            biddingNativeManager.L0("SubjectDetailRecommendScene");
        }
        biddingNativeManager2 = this.this$0.nativeManager;
        if (biddingNativeManager2 != null) {
            biddingNativeManager2.K0(new a(this.this$0, this.$dataList));
        }
        kotlinx.coroutines.i.d(androidx.lifecycle.v.a(this.this$0), (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass2(this.this$0, null), 3, (Object) null);
        return Unit.a;
    }
}
