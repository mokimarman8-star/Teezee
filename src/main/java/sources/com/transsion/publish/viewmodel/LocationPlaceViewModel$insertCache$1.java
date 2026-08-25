package com.transsion.publish.viewmodel;

import com.transsion.baselib.db.place.PlaceDBBean;
import com.transsion.baselib.db.place.PlaceDao;
import com.transsion.gslb.BuildConfig;
import com.transsion.room.api.bean.LocationPlace;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.n0;
import wf.a;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.publish.viewmodel.LocationPlaceViewModel$insertCache$1", f = "LocationPlaceViewModel.kt", l = {127}, m = "invokeSuspend")
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class LocationPlaceViewModel$insertCache$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<LocationPlace> $list;
    int label;
    final /* synthetic */ LocationPlaceViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LocationPlaceViewModel$insertCache$1(List<LocationPlace> list, LocationPlaceViewModel locationPlaceViewModel, Continuation<? super LocationPlaceViewModel$insertCache$1> continuation) {
        super(2, continuation);
        this.$list = list;
        this.this$0 = locationPlaceViewModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LocationPlaceViewModel$insertCache$1(this.$list, this.this$0, continuation);
    }

    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    public final Object invokeSuspend(Object obj) {
        PlaceDao m;
        Object f = IntrinsicsKt.f();
        int i = this.label;
        if (i == 0) {
            ResultKt.b(obj);
            ArrayList arrayList = new ArrayList();
            for (LocationPlace locationPlace : this.$list) {
                Double lat = locationPlace.getLat();
                double doubleValue = lat != null ? lat.doubleValue() : 0.0d;
                Double lon = locationPlace.getLon();
                PlaceDBBean placeDBBean = new PlaceDBBean(doubleValue, lon != null ? lon.doubleValue() : 0.0d, locationPlace.getName(), locationPlace.getAddress(), locationPlace.getDistance());
                a.a.f(wf.a.a, "SelectLocation", "insertCache latitude:" + placeDBBean.getLatitude() + ", longitude:" + placeDBBean.getLongitude() + ", name:" + placeDBBean.getName(), false, 4, (Object) null);
                arrayList.add(placeDBBean);
            }
            m = this.this$0.m();
            this.label = 1;
            if (m.c(arrayList, this) == f) {
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
