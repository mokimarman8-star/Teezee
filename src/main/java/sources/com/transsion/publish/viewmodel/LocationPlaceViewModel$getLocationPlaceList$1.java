package com.transsion.publish.viewmodel;

import androidx.lifecycle.b0;
import com.tn.lib.net.bean.BaseDto;
import com.transsion.gslb.BuildConfig;
import com.transsion.publish.api.bean.LocationPlaceBean;
import com.transsion.room.api.bean.LocationPlace;
import ij.s;
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
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.y0;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.publish.viewmodel.LocationPlaceViewModel$getLocationPlaceList$1", f = "LocationPlaceViewModel.kt", l = {67}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class LocationPlaceViewModel$getLocationPlaceList$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ Double $lat;
    final /* synthetic */ Double $lon;
    int label;
    final /* synthetic */ LocationPlaceViewModel this$0;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lkotlinx/coroutines/flow/b;", "Lcom/transsion/publish/api/bean/LocationPlaceBean;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/flow/b;)V"}, k = 3, mv = {2, 1, 0})
    @DebugMetadata(c = "com.transsion.publish.viewmodel.LocationPlaceViewModel$getLocationPlaceList$1$1", f = "LocationPlaceViewModel.kt", l = {50, 52, 62}, m = "invokeSuspend")
    @SourceDebugExtension
    /* renamed from: com.transsion.publish.viewmodel.LocationPlaceViewModel$getLocationPlaceList$1$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<kotlinx.coroutines.flow.b, Continuation<? super Unit>, Object> {
        final /* synthetic */ Double $lat;
        final /* synthetic */ Double $lon;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ LocationPlaceViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(LocationPlaceViewModel locationPlaceViewModel, Double d, Double d2, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = locationPlaceViewModel;
            this.$lat = d;
            this.$lon = d2;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, this.$lat, this.$lon, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        public final Object invoke(kotlinx.coroutines.flow.b bVar, Continuation<? super Unit> continuation) {
            return create(bVar, continuation).invokeSuspend(Unit.a);
        }

        public final Object invokeSuspend(Object obj) {
            kotlinx.coroutines.flow.b bVar;
            po.a n;
            Object a;
            LocationPlaceBean locationPlaceBean;
            List<LocationPlace> items;
            Object f = IntrinsicsKt.f();
            int i = this.label;
            if (i == 0) {
                ResultKt.b(obj);
                bVar = (kotlinx.coroutines.flow.b) this.L$0;
                n = this.this$0.n();
                String a2 = gg.a.a.a();
                Double d = this.$lat;
                Double d2 = this.$lon;
                this.L$0 = bVar;
                this.label = 1;
                a = n.a(a2, d, d2, this);
                if (a == f) {
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
                a = obj;
            }
            BaseDto baseDto = (BaseDto) a;
            if (Intrinsics.c(baseDto.getCode(), "0")) {
                if (this.$lat != null && this.$lon != null && (locationPlaceBean = (LocationPlaceBean) baseDto.getData()) != null && (items = locationPlaceBean.getItems()) != null) {
                    Double d3 = this.$lat;
                    Double d4 = this.$lon;
                    for (LocationPlace locationPlace : items) {
                        if (locationPlace.getLat() != null && locationPlace.getLon() != null) {
                            s sVar = s.a;
                            double doubleValue = d3.doubleValue();
                            double doubleValue2 = d4.doubleValue();
                            Double lat = locationPlace.getLat();
                            Intrinsics.e(lat);
                            double doubleValue3 = lat.doubleValue();
                            Double lon = locationPlace.getLon();
                            Intrinsics.e(lon);
                            locationPlace.setDistance(sVar.a(doubleValue, doubleValue2, doubleValue3, lon.doubleValue()));
                        }
                    }
                }
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

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u0004*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lkotlinx/coroutines/flow/b;", "Lcom/transsion/publish/api/bean/LocationPlaceBean;", BuildConfig.FLAVOR, "it", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/flow/b;Ljava/lang/Throwable;)V"}, k = 3, mv = {2, 1, 0})
    @DebugMetadata(c = "com.transsion.publish.viewmodel.LocationPlaceViewModel$getLocationPlaceList$1$2", f = "LocationPlaceViewModel.kt", l = {66}, m = "invokeSuspend")
    /* renamed from: com.transsion.publish.viewmodel.LocationPlaceViewModel$getLocationPlaceList$1$2, reason: invalid class name */
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
        final /* synthetic */ LocationPlaceViewModel a;

        a(LocationPlaceViewModel locationPlaceViewModel) {
            this.a = locationPlaceViewModel;
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object emit(LocationPlaceBean locationPlaceBean, Continuation continuation) {
            b0 b0Var;
            b0Var = this.a.c;
            b0Var.n(locationPlaceBean != null ? locationPlaceBean.getItems() : null);
            return Unit.a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LocationPlaceViewModel$getLocationPlaceList$1(LocationPlaceViewModel locationPlaceViewModel, Double d, Double d2, Continuation<? super LocationPlaceViewModel$getLocationPlaceList$1> continuation) {
        super(2, continuation);
        this.this$0 = locationPlaceViewModel;
        this.$lat = d;
        this.$lon = d2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LocationPlaceViewModel$getLocationPlaceList$1(this.this$0, this.$lat, this.$lon, continuation);
    }

    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    public final Object invokeSuspend(Object obj) {
        Object f = IntrinsicsKt.f();
        int i = this.label;
        if (i == 0) {
            ResultKt.b(obj);
            kotlinx.coroutines.flow.a e = kotlinx.coroutines.flow.c.e(kotlinx.coroutines.flow.c.t(kotlinx.coroutines.flow.c.r(new AnonymousClass1(this.this$0, this.$lat, this.$lon, null)), y0.b()), new AnonymousClass2(null));
            a aVar = new a(this.this$0);
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
