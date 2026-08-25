package com.transsion.room.helper;

import android.location.Address;
import com.transsion.gslb.BuildConfig;
import com.transsion.room.api.bean.LocationPlace;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.a2;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.y0;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.room.helper.LocationPlaceHelper$startRealTimeUpdates$1$onLocationResult$1$1", f = "LocationPlaceHelper.kt", l = {222}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class LocationPlaceHelper$startRealTimeUpdates$1$onLocationResult$1$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<LocationPlace, Unit> $callback;
    final /* synthetic */ double $latitude;
    final /* synthetic */ double $longitude;
    int label;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
    @DebugMetadata(c = "com.transsion.room.helper.LocationPlaceHelper$startRealTimeUpdates$1$onLocationResult$1$1$1", f = "LocationPlaceHelper.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.transsion.room.helper.LocationPlaceHelper$startRealTimeUpdates$1$onLocationResult$1$1$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<LocationPlace, Unit> $callback;
        final /* synthetic */ LocationPlace $data;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(Function1<? super LocationPlace, Unit> function1, LocationPlace locationPlace, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$callback = function1;
            this.$data = locationPlace;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$callback, this.$data, continuation);
        }

        public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
            return create(n0Var, continuation).invokeSuspend(Unit.a);
        }

        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.f();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            this.$callback.invoke(this.$data);
            return Unit.a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    LocationPlaceHelper$startRealTimeUpdates$1$onLocationResult$1$1(double d, double d2, Function1<? super LocationPlace, Unit> function1, Continuation<? super LocationPlaceHelper$startRealTimeUpdates$1$onLocationResult$1$1> continuation) {
        super(2, continuation);
        this.$latitude = d;
        this.$longitude = d2;
        this.$callback = function1;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LocationPlaceHelper$startRealTimeUpdates$1$onLocationResult$1$1(this.$latitude, this.$longitude, this.$callback, continuation);
    }

    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    public final Object invokeSuspend(Object obj) {
        Address m;
        LocationPlace l;
        Object f = IntrinsicsKt.f();
        int i = this.label;
        if (i == 0) {
            ResultKt.b(obj);
            LocationPlaceHelper locationPlaceHelper = LocationPlaceHelper.a;
            m = locationPlaceHelper.m(this.$latitude, this.$longitude);
            wf.a.a.c("LocationP", "Location--update--------------2 success " + this.$longitude + ", :" + this.$latitude + ", address:" + m, true);
            l = locationPlaceHelper.l(this.$latitude, this.$longitude, m);
            a2 c = y0.c();
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$callback, l, null);
            this.label = 1;
            if (kotlinx.coroutines.i.g(c, anonymousClass1, this) == f) {
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
