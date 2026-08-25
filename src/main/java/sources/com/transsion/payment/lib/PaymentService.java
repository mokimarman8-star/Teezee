package com.transsion.payment.lib;

import com.google.gson.JsonObject;
import com.tn.lib.net.bean.BaseDto;
import com.transsion.gslb.BuildConfig;
import com.transsion.payment.lib.bean.HttpErrorBodyBean;
import java.util.Map;
import kotlin.KotlinNothingValueException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import org.json.JSONObject;
import retrofit2.HttpException;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class PaymentService {
    private final Lazy a = LazyKt.b(new Function0() { // from class: com.transsion.payment.lib.g
        public final Object invoke() {
            a f;
            f = PaymentService.f();
            return f;
        }
    });

    private final String b() {
        String simpleName = PaymentService.class.getSimpleName();
        Intrinsics.g(simpleName, "getSimpleName(...)");
        return simpleName;
    }

    private final a c() {
        return (a) this.a.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final a f() {
        return (a) kg.c.e.a().h(a.class);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object d(Continuation continuation) {
        PaymentService$getSkuList$1 paymentService$getSkuList$1;
        int i;
        try {
            if (continuation instanceof PaymentService$getSkuList$1) {
                paymentService$getSkuList$1 = (PaymentService$getSkuList$1) continuation;
                int i2 = paymentService$getSkuList$1.label;
                if ((i2 & Integer.MIN_VALUE) != 0) {
                    paymentService$getSkuList$1.label = i2 - Integer.MIN_VALUE;
                    Object obj = paymentService$getSkuList$1.result;
                    Object f = IntrinsicsKt.f();
                    i = paymentService$getSkuList$1.label;
                    if (i != 0) {
                        ResultKt.b(obj);
                        Result.Companion companion = Result.Companion;
                        a c = c();
                        String a = gg.a.a.a();
                        paymentService$getSkuList$1.label = 1;
                        obj = c.e(a, paymentService$getSkuList$1);
                        if (obj == f) {
                            return f;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.b(obj);
                    }
                    return obj;
                }
            }
            if (i != 0) {
            }
            return obj;
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            HttpException httpException = Result.exceptionOrNull-impl(Result.constructor-impl(ResultKt.a(th2)));
            if (httpException == null) {
                throw new KotlinNothingValueException();
            }
            if (!(httpException instanceof HttpException)) {
                d.a.b(b() + " --> getSkuList() --> error = " + httpException.getMessage());
                return null;
            }
            HttpException httpException2 = httpException;
            d.a.b(b() + " --> getSkuList() --> code = " + httpException2.code() + " -- message = " + httpException2.message());
            return new BaseDto(String.valueOf(httpException.getMessage()), String.valueOf(httpException2.code()), (Object) null, BuildConfig.FLAVOR);
        }
        paymentService$getSkuList$1 = new PaymentService$getSkuList$1(this, continuation);
        Object obj2 = paymentService$getSkuList$1.result;
        Object f2 = IntrinsicsKt.f();
        i = paymentService$getSkuList$1.label;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object e(String str, Continuation continuation) {
        PaymentService$orderCheck4Paynicorn$1 paymentService$orderCheck4Paynicorn$1;
        int i;
        String str2;
        String str3;
        String reason;
        try {
            if (continuation instanceof PaymentService$orderCheck4Paynicorn$1) {
                paymentService$orderCheck4Paynicorn$1 = (PaymentService$orderCheck4Paynicorn$1) continuation;
                int i2 = paymentService$orderCheck4Paynicorn$1.label;
                if ((i2 & Integer.MIN_VALUE) != 0) {
                    paymentService$orderCheck4Paynicorn$1.label = i2 - Integer.MIN_VALUE;
                    Object obj = paymentService$orderCheck4Paynicorn$1.result;
                    Object f = IntrinsicsKt.f();
                    i = paymentService$orderCheck4Paynicorn$1.label;
                    if (i != 0) {
                        ResultKt.b(obj);
                        Result.Companion companion = Result.Companion;
                        JsonObject jsonObject = new JsonObject();
                        jsonObject.addProperty("tradingOrderId", str);
                        RequestBody.Companion companion2 = RequestBody.Companion;
                        String jsonElement = jsonObject.toString();
                        Intrinsics.g(jsonElement, "toString(...)");
                        RequestBody create = companion2.create(jsonElement, MediaType.Companion.parse("application/json"));
                        a c = c();
                        String a = gg.a.a.a();
                        paymentService$orderCheck4Paynicorn$1.label = 1;
                        obj = c.a(a, create, paymentService$orderCheck4Paynicorn$1);
                        if (obj == f) {
                            return f;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.b(obj);
                    }
                    return (BaseDto) obj;
                }
            }
            if (i != 0) {
            }
            return (BaseDto) obj;
        } catch (Throwable th2) {
            Result.Companion companion3 = Result.Companion;
            HttpException httpException = Result.exceptionOrNull-impl(Result.constructor-impl(ResultKt.a(th2)));
            if (httpException == null) {
                throw new KotlinNothingValueException();
            }
            if (!(httpException instanceof HttpException)) {
                d.a.b(b() + " --> orderCheck4Paynicorn() --> it = " + httpException);
                return null;
            }
            HttpErrorBodyBean a2 = HttpErrorBodyBean.INSTANCE.a(httpException);
            String str4 = BuildConfig.FLAVOR;
            if (a2 == null || (str2 = a2.getMessage()) == null) {
                str2 = BuildConfig.FLAVOR;
            }
            if (a2 == null || (str3 = a2.getCode()) == null) {
                str3 = BuildConfig.FLAVOR;
            }
            if (a2 != null && (reason = a2.getReason()) != null) {
                str4 = reason;
            }
            return new BaseDto(str2, str3, (Object) null, str4);
        }
        paymentService$orderCheck4Paynicorn$1 = new PaymentService$orderCheck4Paynicorn$1(this, continuation);
        Object obj2 = paymentService$orderCheck4Paynicorn$1.result;
        Object f2 = IntrinsicsKt.f();
        i = paymentService$orderCheck4Paynicorn$1.label;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object g(String str, String str2, String str3, String str4, Continuation continuation) {
        PaymentService$paymentOrderCheck$1 paymentService$paymentOrderCheck$1;
        int i;
        try {
            if (continuation instanceof PaymentService$paymentOrderCheck$1) {
                paymentService$paymentOrderCheck$1 = (PaymentService$paymentOrderCheck$1) continuation;
                int i2 = paymentService$paymentOrderCheck$1.label;
                if ((i2 & Integer.MIN_VALUE) != 0) {
                    paymentService$paymentOrderCheck$1.label = i2 - Integer.MIN_VALUE;
                    Object obj = paymentService$paymentOrderCheck$1.result;
                    Object f = IntrinsicsKt.f();
                    i = paymentService$paymentOrderCheck$1.label;
                    if (i != 0) {
                        ResultKt.b(obj);
                        Result.Companion companion = Result.Companion;
                        JsonObject jsonObject = new JsonObject();
                        jsonObject.addProperty("skuId", str);
                        jsonObject.addProperty("purchaseToken", str2);
                        jsonObject.addProperty("tradingOrderId", str3);
                        jsonObject.addProperty("gpOrderId", str4);
                        RequestBody.Companion companion2 = RequestBody.Companion;
                        String jsonElement = jsonObject.toString();
                        Intrinsics.g(jsonElement, "toString(...)");
                        RequestBody create = companion2.create(jsonElement, MediaType.Companion.parse("application/json"));
                        a c = c();
                        String a = gg.a.a.a();
                        paymentService$paymentOrderCheck$1.label = 1;
                        obj = c.c(a, create, paymentService$paymentOrderCheck$1);
                        if (obj == f) {
                            return f;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.b(obj);
                    }
                    return (BaseDto) obj;
                }
            }
            if (i != 0) {
            }
            return (BaseDto) obj;
        } catch (Throwable th2) {
            Result.Companion companion3 = Result.Companion;
            HttpException httpException = Result.exceptionOrNull-impl(Result.constructor-impl(ResultKt.a(th2)));
            if (httpException == null) {
                throw new KotlinNothingValueException();
            }
            if (!(httpException instanceof HttpException)) {
                d.a.b(b() + " --> paymentOrderCheck() --> error = " + httpException.getMessage());
                return null;
            }
            HttpException httpException2 = httpException;
            d.a.b(b() + " --> paymentOrderCheck() --> code = " + httpException2.code() + " -- message = " + httpException2.message());
            return new BaseDto(String.valueOf(httpException.getMessage()), String.valueOf(httpException2.code()), (Object) null, BuildConfig.FLAVOR);
        }
        paymentService$paymentOrderCheck$1 = new PaymentService$paymentOrderCheck$1(this, continuation);
        Object obj2 = paymentService$paymentOrderCheck$1.result;
        Object f2 = IntrinsicsKt.f();
        i = paymentService$paymentOrderCheck$1.label;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object h(String str, String str2, Map map, Continuation continuation) {
        PaymentService$paymentOrderCreate4Gp$1 paymentService$paymentOrderCreate4Gp$1;
        int i;
        try {
            if (continuation instanceof PaymentService$paymentOrderCreate4Gp$1) {
                paymentService$paymentOrderCreate4Gp$1 = (PaymentService$paymentOrderCreate4Gp$1) continuation;
                int i2 = paymentService$paymentOrderCreate4Gp$1.label;
                if ((i2 & Integer.MIN_VALUE) != 0) {
                    paymentService$paymentOrderCreate4Gp$1.label = i2 - Integer.MIN_VALUE;
                    Object obj = paymentService$paymentOrderCreate4Gp$1.result;
                    Object f = IntrinsicsKt.f();
                    i = paymentService$paymentOrderCreate4Gp$1.label;
                    if (i != 0) {
                        ResultKt.b(obj);
                        Result.Companion companion = Result.Companion;
                        JsonObject jsonObject = new JsonObject();
                        jsonObject.addProperty("skuId", str);
                        jsonObject.addProperty("cpFrontPage", str2);
                        if (map != null) {
                            String jSONObject = new JSONObject(map).toString();
                            Intrinsics.g(jSONObject, "toString(...)");
                            jsonObject.addProperty("ext", jSONObject);
                        }
                        RequestBody.Companion companion2 = RequestBody.Companion;
                        String jsonElement = jsonObject.toString();
                        Intrinsics.g(jsonElement, "toString(...)");
                        RequestBody create = companion2.create(jsonElement, MediaType.Companion.parse("application/json"));
                        a c = c();
                        String a = gg.a.a.a();
                        paymentService$paymentOrderCreate4Gp$1.label = 1;
                        obj = c.b(a, create, paymentService$paymentOrderCreate4Gp$1);
                        if (obj == f) {
                            return f;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.b(obj);
                    }
                    return (BaseDto) obj;
                }
            }
            if (i != 0) {
            }
            return (BaseDto) obj;
        } catch (Throwable th2) {
            Result.Companion companion3 = Result.Companion;
            HttpException httpException = Result.exceptionOrNull-impl(Result.constructor-impl(ResultKt.a(th2)));
            if (httpException == null) {
                throw new KotlinNothingValueException();
            }
            if (!(httpException instanceof HttpException)) {
                d.a.b(b() + " --> paymentOrderCreate4Gp() --> error = " + httpException.getMessage());
                return null;
            }
            HttpException httpException2 = httpException;
            d.a.b(b() + " --> paymentOrderCreate4Gp() --> code = " + httpException2.code() + " -- message = " + httpException2.message());
            return new BaseDto(String.valueOf(httpException.getMessage()), String.valueOf(httpException2.code()), (Object) null, BuildConfig.FLAVOR);
        }
        paymentService$paymentOrderCreate4Gp$1 = new PaymentService$paymentOrderCreate4Gp$1(this, continuation);
        Object obj2 = paymentService$paymentOrderCreate4Gp$1.result;
        Object f2 = IntrinsicsKt.f();
        i = paymentService$paymentOrderCreate4Gp$1.label;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object i(String str, String str2, Map map, Continuation continuation) {
        PaymentService$paymentOrderCreate4Paynicorn$1 paymentService$paymentOrderCreate4Paynicorn$1;
        int i;
        try {
            if (continuation instanceof PaymentService$paymentOrderCreate4Paynicorn$1) {
                paymentService$paymentOrderCreate4Paynicorn$1 = (PaymentService$paymentOrderCreate4Paynicorn$1) continuation;
                int i2 = paymentService$paymentOrderCreate4Paynicorn$1.label;
                if ((i2 & Integer.MIN_VALUE) != 0) {
                    paymentService$paymentOrderCreate4Paynicorn$1.label = i2 - Integer.MIN_VALUE;
                    Object obj = paymentService$paymentOrderCreate4Paynicorn$1.result;
                    Object f = IntrinsicsKt.f();
                    i = paymentService$paymentOrderCreate4Paynicorn$1.label;
                    if (i != 0) {
                        ResultKt.b(obj);
                        Result.Companion companion = Result.Companion;
                        JsonObject jsonObject = new JsonObject();
                        jsonObject.addProperty("skuId", str);
                        jsonObject.addProperty("cpFrontPage", str2);
                        if (map != null) {
                            String jSONObject = new JSONObject(map).toString();
                            Intrinsics.g(jSONObject, "toString(...)");
                            jsonObject.addProperty("ext", jSONObject);
                        }
                        RequestBody.Companion companion2 = RequestBody.Companion;
                        String jsonElement = jsonObject.toString();
                        Intrinsics.g(jsonElement, "toString(...)");
                        RequestBody create = companion2.create(jsonElement, MediaType.Companion.parse("application/json"));
                        a c = c();
                        String a = gg.a.a.a();
                        paymentService$paymentOrderCreate4Paynicorn$1.label = 1;
                        obj = c.d(a, create, paymentService$paymentOrderCreate4Paynicorn$1);
                        if (obj == f) {
                            return f;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.b(obj);
                    }
                    return (BaseDto) obj;
                }
            }
            if (i != 0) {
            }
            return (BaseDto) obj;
        } catch (Throwable th2) {
            Result.Companion companion3 = Result.Companion;
            HttpException httpException = Result.exceptionOrNull-impl(Result.constructor-impl(ResultKt.a(th2)));
            if (httpException == null) {
                throw new KotlinNothingValueException();
            }
            if (!(httpException instanceof HttpException)) {
                d.a.b(b() + " --> paymentOrderCreate4Paynicorn() --> error = " + httpException.getMessage());
                return null;
            }
            HttpException httpException2 = httpException;
            d.a.b(b() + " --> paymentOrderCreate4Paynicorn() --> code = " + httpException2.code() + " -- message = " + httpException2.message());
            return new BaseDto(String.valueOf(httpException.getMessage()), String.valueOf(httpException2.code()), (Object) null, BuildConfig.FLAVOR);
        }
        paymentService$paymentOrderCreate4Paynicorn$1 = new PaymentService$paymentOrderCreate4Paynicorn$1(this, continuation);
        Object obj2 = paymentService$paymentOrderCreate4Paynicorn$1.result;
        Object f2 = IntrinsicsKt.f();
        i = paymentService$paymentOrderCreate4Paynicorn$1.label;
    }
}
