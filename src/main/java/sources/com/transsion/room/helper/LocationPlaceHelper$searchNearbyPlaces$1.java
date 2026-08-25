package com.transsion.room.helper;

import com.google.firebase.perf.network.FirebasePerfOkHttpClient;
import com.transsion.gslb.BuildConfig;
import com.transsion.room.api.bean.LocationPlace;
import ij.s;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.a2;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.y0;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.json.JSONArray;
import org.json.JSONObject;
import wf.a;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.room.helper.LocationPlaceHelper$searchNearbyPlaces$1", f = "LocationPlaceHelper.kt", l = {574, 578}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class LocationPlaceHelper$searchNearbyPlaces$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $apiKey;
    final /* synthetic */ Function1<List<LocationPlace>, Unit> $callback;
    final /* synthetic */ Double $curLat;
    final /* synthetic */ Double $curLon;
    final /* synthetic */ String $location;
    final /* synthetic */ int $radius;
    Object L$0;
    Object L$1;
    int label;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
    @DebugMetadata(c = "com.transsion.room.helper.LocationPlaceHelper$searchNearbyPlaces$1$1", f = "LocationPlaceHelper.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.transsion.room.helper.LocationPlaceHelper$searchNearbyPlaces$1$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<List<LocationPlace>, Unit> $callback;
        final /* synthetic */ List<LocationPlace> $list;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(Function1<? super List<LocationPlace>, Unit> function1, List<LocationPlace> list, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$callback = function1;
            this.$list = list;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$callback, this.$list, continuation);
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
            this.$callback.invoke(this.$list);
            return Unit.a;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
    @DebugMetadata(c = "com.transsion.room.helper.LocationPlaceHelper$searchNearbyPlaces$1$2", f = "LocationPlaceHelper.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.transsion.room.helper.LocationPlaceHelper$searchNearbyPlaces$1$2, reason: invalid class name */
    static final class AnonymousClass2 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<List<LocationPlace>, Unit> $callback;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass2(Function1<? super List<LocationPlace>, Unit> function1, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$callback = function1;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.$callback, continuation);
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
            this.$callback.invoke((Object) null);
            return Unit.a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    LocationPlaceHelper$searchNearbyPlaces$1(String str, int i, String str2, Double d, Double d2, Function1<? super List<LocationPlace>, Unit> function1, Continuation<? super LocationPlaceHelper$searchNearbyPlaces$1> continuation) {
        super(2, continuation);
        this.$location = str;
        this.$radius = i;
        this.$apiKey = str2;
        this.$curLat = d;
        this.$curLon = d2;
        this.$callback = function1;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LocationPlaceHelper$searchNearbyPlaces$1(this.$location, this.$radius, this.$apiKey, this.$curLat, this.$curLon, this.$callback, continuation);
    }

    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0240  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x024a  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x021e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x021f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Response response;
        String string;
        Response response2;
        Response response3;
        Response response4;
        a2 c;
        AnonymousClass2 anonymousClass2;
        Object f = IntrinsicsKt.f();
        int i = this.label;
        if (i == 0) {
            ResultKt.b(obj);
            String str = "https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=" + this.$location + "&radius=" + this.$radius + "&key=" + this.$apiKey;
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            OkHttpClient build = builder.connectTimeout(10000L, timeUnit).writeTimeout(10000L, timeUnit).readTimeout(10000L, timeUnit).build();
            Request build2 = new Request.Builder().url(str).build();
            a.a.f(wf.a.a, "LocationP", "searchNearbyPlaces url: " + str, false, 4, (Object) null);
            try {
                Response execute = FirebasePerfOkHttpClient.execute(build.newCall(build2));
                try {
                    try {
                        if (!execute.isSuccessful()) {
                            throw new IOException("Unexpected code " + execute);
                        }
                        ResponseBody body = execute.body();
                        if (body == null || (string = body.string()) == null) {
                            throw new IOException("Response null");
                        }
                        JSONArray jSONArray = new JSONObject(string).getJSONArray("results");
                        ArrayList arrayList = new ArrayList();
                        int length = jSONArray.length();
                        int i2 = 0;
                        while (i2 < length) {
                            try {
                                JSONObject jSONObject = jSONArray.getJSONObject(i2);
                                String string2 = jSONObject.getString("name");
                                String string3 = jSONObject.getString("vicinity");
                                JSONObject jSONObject2 = jSONObject.getJSONObject("geometry").getJSONObject("location");
                                double d = jSONObject2.getDouble("lat");
                                response2 = execute;
                                try {
                                    double d2 = jSONObject2.getDouble("lng");
                                    String a = s.a.a(this.$curLat.doubleValue(), this.$curLon.doubleValue(), d, d2);
                                    LocationPlace locationPlace = new LocationPlace(null, null, null, null, 15, null);
                                    locationPlace.setName(string2);
                                    locationPlace.setAddress(string3);
                                    locationPlace.setDistance(a);
                                    locationPlace.setLat(Boxing.b(d));
                                    locationPlace.setLon(Boxing.b(d2));
                                    a.a.v(wf.a.a, "LocationP", "====place list name: " + string2 + ", distance: " + a + ", address: " + string3 + ", lat:" + d + ", lng:" + d2 + ")", false, 4, (Object) null);
                                    Boxing.a(arrayList.add(locationPlace));
                                } catch (Throwable th2) {
                                    th = th2;
                                    try {
                                        a.a.l(wf.a.a, "LocationP", "place error2: " + th, false, 4, (Object) null);
                                        th.printStackTrace();
                                        i2++;
                                        execute = response2;
                                    } catch (Throwable th3) {
                                        th = th3;
                                        response = response2;
                                        c = y0.c();
                                        anonymousClass2 = new AnonymousClass2(this.$callback, null);
                                        this.L$0 = response;
                                        this.L$1 = th;
                                        this.label = 2;
                                        if (kotlinx.coroutines.i.g(c, anonymousClass2, this) != f) {
                                        }
                                    }
                                }
                            } catch (Throwable th4) {
                                th = th4;
                                response2 = execute;
                            }
                            i2++;
                            execute = response2;
                        }
                        response2 = execute;
                        a2 c2 = y0.c();
                        AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$callback, arrayList, null);
                        this.L$0 = response2;
                        this.label = 1;
                        if (kotlinx.coroutines.i.g(c2, anonymousClass1, this) == f) {
                            return f;
                        }
                        response3 = response2;
                    } catch (Throwable th5) {
                        th = th5;
                    }
                } catch (Throwable th6) {
                    th = th6;
                    response = execute;
                }
            } catch (Throwable th7) {
                th = th7;
                response = null;
            }
        } else {
            if (i != 1) {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                th = (Throwable) this.L$1;
                response4 = (Response) this.L$0;
                try {
                    ResultKt.b(obj);
                    a.a.l(wf.a.a, "LocationP", "place error: " + th, false, 4, (Object) null);
                    th.printStackTrace();
                    if (response4 != null) {
                        response4.close();
                    }
                    return Unit.a;
                } catch (Throwable th8) {
                    th = th8;
                    if (response4 != null) {
                    }
                    throw th;
                }
            }
            response3 = (Response) this.L$0;
            try {
                ResultKt.b(obj);
            } catch (Throwable th9) {
                th = th9;
                response = response3;
                try {
                    c = y0.c();
                    anonymousClass2 = new AnonymousClass2(this.$callback, null);
                    this.L$0 = response;
                    this.L$1 = th;
                    this.label = 2;
                    if (kotlinx.coroutines.i.g(c, anonymousClass2, this) != f) {
                        return f;
                    }
                    response4 = response;
                    a.a.l(wf.a.a, "LocationP", "place error: " + th, false, 4, (Object) null);
                    th.printStackTrace();
                    if (response4 != null) {
                    }
                    return Unit.a;
                } catch (Throwable th10) {
                    th = th10;
                    response4 = response;
                    if (response4 != null) {
                        response4.close();
                    }
                    throw th;
                }
            }
        }
        if (response3 != null) {
            response3.close();
        }
        return Unit.a;
    }
}
