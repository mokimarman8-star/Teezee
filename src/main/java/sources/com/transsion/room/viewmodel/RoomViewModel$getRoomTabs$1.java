package com.transsion.room.viewmodel;

import androidx.lifecycle.b0;
import com.tn.lib.net.bean.BaseDto;
import com.transsion.flow.bean.RoomTabBean;
import com.transsion.flow.bean.RoomTabItem;
import com.transsion.gslb.BuildConfig;
import com.transsion.push.bean.MsgStyle;
import ip.a;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.y0;
import wf.a;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.room.viewmodel.RoomViewModel$getRoomTabs$1", f = "RoomViewModel.kt", l = {296}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class RoomViewModel$getRoomTabs$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ RoomViewModel this$0;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lkotlinx/coroutines/flow/b;", "Lcom/transsion/moviedetailapi/bean/RoomTabBean;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/flow/b;)V"}, k = 3, mv = {2, 1, 0})
    @DebugMetadata(c = "com.transsion.room.viewmodel.RoomViewModel$getRoomTabs$1$1", f = "RoomViewModel.kt", l = {287, 289, 291}, m = "invokeSuspend")
    /* renamed from: com.transsion.room.viewmodel.RoomViewModel$getRoomTabs$1$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<kotlinx.coroutines.flow.b, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $savedVersion;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ RoomViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(RoomViewModel roomViewModel, String str, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = roomViewModel;
            this.$savedVersion = str;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, this.$savedVersion, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        public final Object invoke(kotlinx.coroutines.flow.b bVar, Continuation<? super Unit> continuation) {
            return create(bVar, continuation).invokeSuspend(Unit.a);
        }

        public final Object invokeSuspend(Object obj) {
            kotlinx.coroutines.flow.b bVar;
            ip.a K;
            Object f = IntrinsicsKt.f();
            int i = this.label;
            if (i == 0) {
                ResultKt.b(obj);
                bVar = (kotlinx.coroutines.flow.b) this.L$0;
                K = this.this$0.K();
                String str = this.$savedVersion;
                this.L$0 = bVar;
                this.label = 1;
                obj = a.C0077a.c(K, null, str, this, 1, null);
                if (obj == f) {
                    return f;
                }
            } else {
                if (i != 1) {
                    if (i != 2 && i != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.b(obj);
                    return Unit.a;
                }
                bVar = (kotlinx.coroutines.flow.b) this.L$0;
                ResultKt.b(obj);
            }
            BaseDto baseDto = (BaseDto) obj;
            if (Intrinsics.c(baseDto.getCode(), "0")) {
                Object data = baseDto.getData();
                this.L$0 = null;
                this.label = 3;
                if (bVar.emit(data, this) == f) {
                    return f;
                }
            } else {
                this.L$0 = null;
                this.label = 2;
                if (bVar.emit((Object) null, this) == f) {
                    return f;
                }
            }
            return Unit.a;
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u0004*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lkotlinx/coroutines/flow/b;", "Lcom/transsion/moviedetailapi/bean/RoomTabBean;", BuildConfig.FLAVOR, "it", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/flow/b;Ljava/lang/Throwable;)V"}, k = 3, mv = {2, 1, 0})
    @DebugMetadata(c = "com.transsion.room.viewmodel.RoomViewModel$getRoomTabs$1$2", f = "RoomViewModel.kt", l = {295}, m = "invokeSuspend")
    /* renamed from: com.transsion.room.viewmodel.RoomViewModel$getRoomTabs$1$2, reason: invalid class name */
    static final class AnonymousClass2 extends SuspendLambda implements Function3<kotlinx.coroutines.flow.b, Throwable, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(3, continuation);
        }

        public final Object invoke(kotlinx.coroutines.flow.b bVar, Throwable th2, Continuation<? super Unit> continuation) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(continuation);
            anonymousClass2.L$0 = bVar;
            return anonymousClass2.invokeSuspend(Unit.a);
        }

        public final Object invokeSuspend(Object obj) {
            Object f = IntrinsicsKt.f();
            int i = this.label;
            if (i == 0) {
                ResultKt.b(obj);
                kotlinx.coroutines.flow.b bVar = (kotlinx.coroutines.flow.b) this.L$0;
                this.label = 1;
                if (bVar.emit((Object) null, this) == f) {
                    return f;
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

    static final class a implements kotlinx.coroutines.flow.b {
        final /* synthetic */ RoomViewModel a;
        final /* synthetic */ String b;

        a(RoomViewModel roomViewModel, String str) {
            this.a = roomViewModel;
            this.b = str;
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object emit(RoomTabBean roomTabBean, Continuation continuation) {
            String str;
            b0 b0Var;
            List<RoomTabItem> items;
            if (roomTabBean != null && (items = roomTabBean.getItems()) != null && !items.isEmpty()) {
                this.a.P(roomTabBean);
            }
            String version = roomTabBean != null ? roomTabBean.getVersion() : null;
            if (version != null && version.length() != 0) {
                if (roomTabBean == null || (str = roomTabBean.getVersion()) == null) {
                    str = MsgStyle.CUSTOM_LEFT_PIC;
                }
                if (!Intrinsics.c(str, this.b)) {
                    a.a.f(wf.a.a, "RoomViewModel", "getRoomTabs update tab， savedVersion:" + this.b + ", newVersion:" + (roomTabBean != null ? roomTabBean.getVersion() : null) + " ", false, 4, (Object) null);
                    b0Var = this.a.d;
                    b0Var.n(roomTabBean);
                    return Unit.a;
                }
            }
            wf.a.a.c("RoomViewModel", "getRoomTabs version same, version:" + (roomTabBean != null ? roomTabBean.getVersion() : null), true);
            return Unit.a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    RoomViewModel$getRoomTabs$1(RoomViewModel roomViewModel, Continuation<? super RoomViewModel$getRoomTabs$1> continuation) {
        super(2, continuation);
        this.this$0 = roomViewModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new RoomViewModel$getRoomTabs$1(this.this$0, continuation);
    }

    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    public final Object invokeSuspend(Object obj) {
        Object f = IntrinsicsKt.f();
        int i = this.label;
        if (i == 0) {
            ResultKt.b(obj);
            String string = com.transsion.baselib.report.launch.b.a.b().getString("k_room_tab_cache_version", "2493811379");
            String str = string != null ? string : "2493811379";
            a.a.f(wf.a.a, "RoomViewModel", "getRoomTabs savedVersion：" + str, false, 4, (Object) null);
            kotlinx.coroutines.flow.a e = kotlinx.coroutines.flow.c.e(kotlinx.coroutines.flow.c.t(kotlinx.coroutines.flow.c.r(new AnonymousClass1(this.this$0, str, null)), y0.b()), new AnonymousClass2(null));
            a aVar = new a(this.this$0, str);
            this.label = 1;
            if (e.a(aVar, this) == f) {
                return f;
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
