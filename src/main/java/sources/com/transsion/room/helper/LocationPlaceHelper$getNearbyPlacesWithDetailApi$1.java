package com.transsion.room.helper;

import com.google.android.gms.maps.model.LatLng;
import com.google.android.libraries.places.api.net.FindCurrentPlaceRequest;
import com.transsion.gslb.BuildConfig;
import com.transsion.room.api.bean.LocationPlace;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.TimeoutCancellationException;
import kotlinx.coroutines.TimeoutKt;
import kotlinx.coroutines.n0;
import wf.a;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.room.helper.LocationPlaceHelper$getNearbyPlacesWithDetailApi$1", f = "LocationPlaceHelper.kt", l = {410}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class LocationPlaceHelper$getNearbyPlacesWithDetailApi$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<List<LocationPlace>, Unit> $callback;
    final /* synthetic */ LatLng $currentLatLng;
    final /* synthetic */ FindCurrentPlaceRequest $request;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    LocationPlaceHelper$getNearbyPlacesWithDetailApi$1(Function1<? super List<LocationPlace>, Unit> function1, FindCurrentPlaceRequest findCurrentPlaceRequest, LatLng latLng, Continuation<? super LocationPlaceHelper$getNearbyPlacesWithDetailApi$1> continuation) {
        super(2, continuation);
        this.$callback = function1;
        this.$request = findCurrentPlaceRequest;
        this.$currentLatLng = latLng;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LocationPlaceHelper$getNearbyPlacesWithDetailApi$1(this.$callback, this.$request, this.$currentLatLng, continuation);
    }

    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    public final Object invokeSuspend(Object obj) {
        Object f = IntrinsicsKt.f();
        int i = this.label;
        try {
            if (i == 0) {
                ResultKt.b(obj);
                LocationPlaceHelper$getNearbyPlacesWithDetailApi$1$result$1 locationPlaceHelper$getNearbyPlacesWithDetailApi$1$result$1 = new LocationPlaceHelper$getNearbyPlacesWithDetailApi$1$result$1(this.$request, this.$currentLatLng, null);
                this.label = 1;
                obj = TimeoutKt.c(10000L, locationPlaceHelper$getNearbyPlacesWithDetailApi$1$result$1, this);
                if (obj == f) {
                    return f;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            }
            this.$callback.invoke((List) obj);
        } catch (TimeoutCancellationException unused) {
            a.a.f(wf.a.a, "LocationP", "getNearbyPlaces request timed out", false, 4, (Object) null);
            this.$callback.invoke((Object) null);
        }
        return Unit.a;
    }
}
