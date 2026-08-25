package com.transsion.home.viewmodel;

import com.transsion.gslb.BuildConfig;
import com.transsion.home.bean.OperateItem;
import com.transsion.home.bean.SubOperateData;
import java.util.Comparator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.l2;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.r0;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.home.viewmodel.SubTabViewModel$fetchOperateData$1", f = "SubTabViewModel.kt", l = {72}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class SubTabViewModel$fetchOperateData$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $grade;
    final /* synthetic */ boolean $isRefresh;
    final /* synthetic */ Ref.ObjectRef<SubOperateData> $operateData;
    final /* synthetic */ int $tabId;
    int label;
    final /* synthetic */ SubTabViewModel this$0;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
    @DebugMetadata(c = "com.transsion.home.viewmodel.SubTabViewModel$fetchOperateData$1$1", f = "SubTabViewModel.kt", l = {76}, m = "invokeSuspend")
    @SourceDebugExtension
    /* renamed from: com.transsion.home.viewmodel.SubTabViewModel$fetchOperateData$1$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $grade;
        final /* synthetic */ boolean $isRefresh;
        final /* synthetic */ Ref.ObjectRef<SubOperateData> $operateData;
        final /* synthetic */ int $tabId;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ SubTabViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Ref.ObjectRef<SubOperateData> objectRef, SubTabViewModel subTabViewModel, int i, boolean z, String str, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$operateData = objectRef;
            this.this$0 = subTabViewModel;
            this.$tabId = i;
            this.$isRefresh = z;
            this.$grade = str;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$operateData, this.this$0, this.$tabId, this.$isRefresh, this.$grade, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
            return create(n0Var, continuation).invokeSuspend(Unit.a);
        }

        public final Object invokeSuspend(Object obj) {
            Ref.ObjectRef<SubOperateData> objectRef;
            List<OperateItem> items;
            List I0;
            Object f = IntrinsicsKt.f();
            int i = this.label;
            List<OperateItem> list = null;
            if (i == 0) {
                ResultKt.b(obj);
                r0 b = kotlinx.coroutines.i.b((n0) this.L$0, (CoroutineContext) null, (CoroutineStart) null, new SubTabViewModel$fetchOperateData$1$1$operationTask$1(this.this$0, this.$tabId, this.$grade, null), 3, (Object) null);
                Ref.ObjectRef<SubOperateData> objectRef2 = this.$operateData;
                this.L$0 = objectRef2;
                this.label = 1;
                obj = b.f(this);
                if (obj == f) {
                    return f;
                }
                objectRef = objectRef2;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                objectRef = (Ref.ObjectRef) this.L$0;
                ResultKt.b(obj);
            }
            objectRef.element = obj;
            Object obj2 = this.$operateData.element;
            SubOperateData subOperateData = (SubOperateData) obj2;
            if (subOperateData != null) {
                SubOperateData subOperateData2 = (SubOperateData) obj2;
                if (subOperateData2 != null && (items = subOperateData2.getItems()) != null && (I0 = CollectionsKt.I0(items, new Comparator() { // from class: com.transsion.home.viewmodel.SubTabViewModel$fetchOperateData$1$1$invokeSuspend$$inlined$sortedBy$1
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // java.util.Comparator
                    public final int compare(T t, T t2) {
                        return ComparisonsKt.d(((OperateItem) t).getPosition(), ((OperateItem) t2).getPosition());
                    }
                })) != null) {
                    list = CollectionsKt.U0(I0);
                }
                subOperateData.setItems(list);
            }
            this.this$0.u((SubOperateData) this.$operateData.element);
            this.this$0.v(this.$tabId, (SubOperateData) this.$operateData.element);
            if (this.$isRefresh) {
                this.this$0.q().n(this.$operateData.element);
                this.this$0.f = 1;
            } else {
                this.this$0.p().n(this.$operateData.element);
            }
            return Unit.a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SubTabViewModel$fetchOperateData$1(boolean z, SubTabViewModel subTabViewModel, Ref.ObjectRef<SubOperateData> objectRef, int i, String str, Continuation<? super SubTabViewModel$fetchOperateData$1> continuation) {
        super(2, continuation);
        this.$isRefresh = z;
        this.this$0 = subTabViewModel;
        this.$operateData = objectRef;
        this.$tabId = i;
        this.$grade = str;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SubTabViewModel$fetchOperateData$1(this.$isRefresh, this.this$0, this.$operateData, this.$tabId, this.$grade, continuation);
    }

    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    public final Object invokeSuspend(Object obj) {
        List<OperateItem> items;
        Object f = IntrinsicsKt.f();
        int i = this.label;
        try {
            if (i == 0) {
                ResultKt.b(obj);
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$operateData, this.this$0, this.$tabId, this.$isRefresh, this.$grade, null);
                this.label = 1;
                if (l2.c(anonymousClass1, this) == f) {
                    return f;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            }
        } catch (Exception e) {
            e.printStackTrace();
            wf.a.a.i("SubTabFragment", "exceptionHandler " + e.getMessage(), true);
            if (this.$isRefresh) {
                this.this$0.q().n((Object) null);
            } else {
                SubOperateData subOperateData = (SubOperateData) this.$operateData.element;
                if (((subOperateData == null || (items = subOperateData.getItems()) == null) ? 0 : items.size()) > 0) {
                    this.this$0.p().n(this.$operateData.element);
                } else {
                    this.this$0.p().n((Object) null);
                }
            }
        }
        return Unit.a;
    }
}
