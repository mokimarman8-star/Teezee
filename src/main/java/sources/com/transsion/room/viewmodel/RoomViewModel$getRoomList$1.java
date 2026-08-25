package com.transsion.room.viewmodel;

import android.location.Address;
import androidx.lifecycle.b0;
import com.tn.lib.net.bean.BaseDto;
import com.transsion.flow.bean.RoomBean;
import com.transsion.gslb.BuildConfig;
import com.transsion.room.api.bean.RoomGeo;
import com.transsion.room.api.bean.RoomRequestEntity;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.y0;
import okhttp3.MediaType;
import okhttp3.RequestBody;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.room.viewmodel.RoomViewModel$getRoomList$1", f = "RoomViewModel.kt", l = {270}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class RoomViewModel$getRoomList$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ Address $address;
    final /* synthetic */ int $cid;
    final /* synthetic */ boolean $isRefresh;
    final /* synthetic */ Double $lat;
    final /* synthetic */ Double $lon;
    final /* synthetic */ String $page;
    final /* synthetic */ int $perPage;
    int label;
    final /* synthetic */ RoomViewModel this$0;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lkotlinx/coroutines/flow/b;", "Lcom/transsion/moviedetailapi/bean/RoomBean;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/flow/b;)V"}, k = 3, mv = {2, 1, 0})
    @DebugMetadata(c = "com.transsion.room.viewmodel.RoomViewModel$getRoomList$1$1", f = "RoomViewModel.kt", l = {261, 263, 265}, m = "invokeSuspend")
    /* renamed from: com.transsion.room.viewmodel.RoomViewModel$getRoomList$1$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<kotlinx.coroutines.flow.b, Continuation<? super Unit>, Object> {
        final /* synthetic */ Address $address;
        final /* synthetic */ int $cid;
        final /* synthetic */ Double $lat;
        final /* synthetic */ Double $lon;
        final /* synthetic */ String $page;
        final /* synthetic */ int $perPage;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ RoomViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Double d, Double d2, Address address, String str, int i, int i2, RoomViewModel roomViewModel, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$lon = d;
            this.$lat = d2;
            this.$address = address;
            this.$page = str;
            this.$perPage = i;
            this.$cid = i2;
            this.this$0 = roomViewModel;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$lon, this.$lat, this.$address, this.$page, this.$perPage, this.$cid, this.this$0, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        public final Object invoke(kotlinx.coroutines.flow.b bVar, Continuation<? super Unit> continuation) {
            return create(bVar, continuation).invokeSuspend(Unit.a);
        }

        public final Object invokeSuspend(Object obj) {
            kotlinx.coroutines.flow.b bVar;
            RoomGeo roomGeo;
            ip.a K;
            Object l;
            Object f = IntrinsicsKt.f();
            int i = this.label;
            if (i == 0) {
                ResultKt.b(obj);
                bVar = (kotlinx.coroutines.flow.b) this.L$0;
                if (this.$lon == null || this.$lat == null) {
                    roomGeo = null;
                } else {
                    double doubleValue = this.$lon.doubleValue();
                    double doubleValue2 = this.$lat.doubleValue();
                    Address address = this.$address;
                    String countryCode = address != null ? address.getCountryCode() : null;
                    Address address2 = this.$address;
                    String adminArea = address2 != null ? address2.getAdminArea() : null;
                    Address address3 = this.$address;
                    roomGeo = new RoomGeo(doubleValue, doubleValue2, countryCode, adminArea, address3 != null ? address3.getLocality() : null, null, null, 96, null);
                }
                RequestBody.Companion companion = RequestBody.Companion;
                String j = com.blankj.utilcode.util.o.j(new RoomRequestEntity(this.$page, this.$perPage, 0, Boxing.d(this.$cid), roomGeo, null, 32, null));
                Intrinsics.g(j, "toJson(...)");
                RequestBody create = companion.create(j, MediaType.Companion.parse("application/json"));
                K = this.this$0.K();
                String a = gg.a.a.a();
                this.L$0 = bVar;
                this.label = 1;
                l = K.l(a, create, this);
                if (l == f) {
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
                l = obj;
            }
            BaseDto baseDto = (BaseDto) l;
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

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u0004*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lkotlinx/coroutines/flow/b;", "Lcom/transsion/moviedetailapi/bean/RoomBean;", BuildConfig.FLAVOR, "it", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/flow/b;Ljava/lang/Throwable;)V"}, k = 3, mv = {2, 1, 0})
    @DebugMetadata(c = "com.transsion.room.viewmodel.RoomViewModel$getRoomList$1$2", f = "RoomViewModel.kt", l = {269}, m = "invokeSuspend")
    /* renamed from: com.transsion.room.viewmodel.RoomViewModel$getRoomList$1$2, reason: invalid class name */
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
        final /* synthetic */ boolean a;
        final /* synthetic */ RoomViewModel b;

        a(boolean z, RoomViewModel roomViewModel) {
            this.a = z;
            this.b = roomViewModel;
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object emit(RoomBean roomBean, Continuation continuation) {
            b0 b0Var;
            if (roomBean != null) {
                roomBean.setRefresh(this.a);
            }
            b0Var = this.b.i;
            b0Var.n(roomBean);
            return Unit.a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    RoomViewModel$getRoomList$1(Double d, Double d2, Address address, String str, int i, int i2, RoomViewModel roomViewModel, boolean z, Continuation<? super RoomViewModel$getRoomList$1> continuation) {
        super(2, continuation);
        this.$lon = d;
        this.$lat = d2;
        this.$address = address;
        this.$page = str;
        this.$perPage = i;
        this.$cid = i2;
        this.this$0 = roomViewModel;
        this.$isRefresh = z;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new RoomViewModel$getRoomList$1(this.$lon, this.$lat, this.$address, this.$page, this.$perPage, this.$cid, this.this$0, this.$isRefresh, continuation);
    }

    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    public final Object invokeSuspend(Object obj) {
        Object f = IntrinsicsKt.f();
        int i = this.label;
        if (i == 0) {
            ResultKt.b(obj);
            kotlinx.coroutines.flow.a e = kotlinx.coroutines.flow.c.e(kotlinx.coroutines.flow.c.t(kotlinx.coroutines.flow.c.r(new AnonymousClass1(this.$lon, this.$lat, this.$address, this.$page, this.$perPage, this.$cid, this.this$0, null)), y0.b()), new AnonymousClass2(null));
            a aVar = new a(this.$isRefresh, this.this$0);
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
