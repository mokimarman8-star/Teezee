package com.transsion.rewardscenter.utils;

import com.tn.lib.net.bean.BaseDto;
import com.transsion.gslb.BuildConfig;
import com.transsion.rewardscenterapi.ClaimReceiverRequest;
import com.transsion.rewardscenterapi.PhoneInfo;
import java.util.List;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import org.json.JSONArray;
import org.json.JSONObject;
import xo.a;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class RewardsCenterApiHelper {
    public static final RewardsCenterApiHelper a = new RewardsCenterApiHelper();
    private static final Lazy b = LazyKt.b(new Function0() { // from class: com.transsion.rewardscenter.utils.g
        public final Object invoke() {
            xo.a h;
            h = RewardsCenterApiHelper.h();
            return h;
        }
    });
    public static final int c = 8;

    private RewardsCenterApiHelper() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final xo.a h() {
        return (xo.a) kg.c.e.a().h(xo.a.class);
    }

    private final RequestBody i(Function1 function1) {
        RequestBody.Companion companion = RequestBody.Companion;
        JSONObject jSONObject = new JSONObject();
        function1.invoke(jSONObject);
        String jSONObject2 = jSONObject.toString();
        Intrinsics.g(jSONObject2, "toString(...)");
        return companion.create(jSONObject2, MediaType.Companion.parse("application/json"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit k(JSONObject jSONObject) {
        Intrinsics.h(jSONObject, "$this$buildBody");
        jSONObject.put("gaid", tg.b.a.i());
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit m(String str, JSONObject jSONObject) {
        Intrinsics.h(jSONObject, "$this$buildBody");
        jSONObject.put("drawResultId", str);
        return Unit.a;
    }

    public static /* synthetic */ Object o(RewardsCenterApiHelper rewardsCenterApiHelper, Function2 function2, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            function2 = null;
        }
        return rewardsCenterApiHelper.n(function2, function1, continuation);
    }

    private final xo.a p() {
        return (xo.a) b.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit r(String str, JSONObject jSONObject) {
        Intrinsics.h(jSONObject, "$this$buildBody");
        jSONObject.put("activityId", str);
        jSONObject.put("num", 1);
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit t(String str, JSONObject jSONObject) {
        Intrinsics.h(jSONObject, "$this$buildBody");
        jSONObject.put("skuId", str);
        jSONObject.put("clientOrderId", UUID.randomUUID().toString());
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit v(String str, JSONObject jSONObject) {
        Intrinsics.h(jSONObject, "$this$buildBody");
        if (str == null) {
            str = BuildConfig.FLAVOR;
        }
        jSONObject.put("taskId", str);
        jSONObject.put("gaid", tg.b.a.i());
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit x(ClaimReceiverRequest claimReceiverRequest, JSONObject jSONObject) {
        Intrinsics.h(jSONObject, "$this$buildBody");
        Object drawResultId = claimReceiverRequest.getDrawResultId();
        Object obj = BuildConfig.FLAVOR;
        if (drawResultId == null) {
            drawResultId = BuildConfig.FLAVOR;
        }
        jSONObject.put("drawResultId", drawResultId);
        Object receiverName = claimReceiverRequest.getReceiverName();
        if (receiverName == null) {
            receiverName = BuildConfig.FLAVOR;
        }
        jSONObject.put("receiverName", receiverName);
        JSONArray jSONArray = new JSONArray();
        List<PhoneInfo> phone = claimReceiverRequest.getPhone();
        if (phone != null) {
            for (PhoneInfo phoneInfo : phone) {
                JSONObject jSONObject2 = new JSONObject();
                String countryNo = phoneInfo.getCountryNo();
                if (countryNo == null) {
                    countryNo = BuildConfig.FLAVOR;
                }
                jSONObject2.put("countryNo", countryNo);
                String number = phoneInfo.getNumber();
                if (number == null) {
                    number = BuildConfig.FLAVOR;
                }
                jSONObject2.put("number", number);
                String countryCode = phoneInfo.getCountryCode();
                if (countryCode == null) {
                    countryCode = BuildConfig.FLAVOR;
                }
                jSONObject2.put("countryCode", countryCode);
                jSONArray.put(jSONObject2);
            }
        }
        Unit unit = Unit.a;
        jSONObject.put("phone", jSONArray);
        Object address = claimReceiverRequest.getAddress();
        if (address != null) {
            obj = address;
        }
        jSONObject.put("address", obj);
        String email = claimReceiverRequest.getEmail();
        if (email != null && !StringsKt.q0(email)) {
            jSONObject.put("email", claimReceiverRequest.getEmail());
        }
        String postCode = claimReceiverRequest.getPostCode();
        if (postCode != null && !StringsKt.q0(postCode)) {
            jSONObject.put("postCode", claimReceiverRequest.getPostCode());
        }
        return Unit.a;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(15:0|1|(2:3|(12:5|6|7|8|(1:(2:11|12)(2:29|30))(3:31|32|(1:34))|13|14|(2:16|(1:18)(1:(1:20)))|21|(1:24)|25|26))|37|6|7|8|(0)(0)|13|14|(0)|21|(1:24)|25|26) */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0034, code lost:
    
        r10 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0067, code lost:
    
        r0 = kotlin.Result.Companion;
        r10 = kotlin.Result.constructor-impl(kotlin.ResultKt.a(r10));
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x003e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object j(Function2 function2, Function1 function1, Continuation continuation) {
        RewardsCenterApiHelper$checkDadaSetDefault$1 rewardsCenterApiHelper$checkDadaSetDefault$1;
        int i;
        Object obj;
        Throwable th2;
        if (continuation instanceof RewardsCenterApiHelper$checkDadaSetDefault$1) {
            rewardsCenterApiHelper$checkDadaSetDefault$1 = (RewardsCenterApiHelper$checkDadaSetDefault$1) continuation;
            int i2 = rewardsCenterApiHelper$checkDadaSetDefault$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                rewardsCenterApiHelper$checkDadaSetDefault$1.label = i2 - Integer.MIN_VALUE;
                RewardsCenterApiHelper$checkDadaSetDefault$1 rewardsCenterApiHelper$checkDadaSetDefault$12 = rewardsCenterApiHelper$checkDadaSetDefault$1;
                Object obj2 = rewardsCenterApiHelper$checkDadaSetDefault$12.result;
                Object f = IntrinsicsKt.f();
                i = rewardsCenterApiHelper$checkDadaSetDefault$12.label;
                if (i != 0) {
                    ResultKt.b(obj2);
                    RequestBody i3 = i(new Function1() { // from class: com.transsion.rewardscenter.utils.i
                        public final Object invoke(Object obj3) {
                            Unit k;
                            k = RewardsCenterApiHelper.k((JSONObject) obj3);
                            return k;
                        }
                    });
                    Result.Companion companion = Result.Companion;
                    xo.a p = p();
                    rewardsCenterApiHelper$checkDadaSetDefault$12.L$0 = function2;
                    rewardsCenterApiHelper$checkDadaSetDefault$12.L$1 = function1;
                    rewardsCenterApiHelper$checkDadaSetDefault$12.label = 1;
                    obj2 = a.C0103a.a(p, null, i3, rewardsCenterApiHelper$checkDadaSetDefault$12, 1, null);
                    if (obj2 == f) {
                        return f;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    function1 = (Function1) rewardsCenterApiHelper$checkDadaSetDefault$12.L$1;
                    function2 = (Function2) rewardsCenterApiHelper$checkDadaSetDefault$12.L$0;
                    ResultKt.b(obj2);
                }
                obj = Result.constructor-impl((BaseDto) obj2);
                if (Result.isSuccess-impl(obj)) {
                    BaseDto baseDto = (BaseDto) obj;
                    if (n.a(baseDto)) {
                        function1.invoke(baseDto.getData());
                    } else if (function2 != null) {
                        function2.invoke(baseDto.getCode(), baseDto.getMsg());
                    }
                }
                th2 = Result.exceptionOrNull-impl(obj);
                if (th2 != null && function2 != null) {
                    function2.invoke((Object) null, th2.getMessage());
                }
                return Unit.a;
            }
        }
        rewardsCenterApiHelper$checkDadaSetDefault$1 = new RewardsCenterApiHelper$checkDadaSetDefault$1(this, continuation);
        RewardsCenterApiHelper$checkDadaSetDefault$1 rewardsCenterApiHelper$checkDadaSetDefault$122 = rewardsCenterApiHelper$checkDadaSetDefault$1;
        Object obj22 = rewardsCenterApiHelper$checkDadaSetDefault$122.result;
        Object f2 = IntrinsicsKt.f();
        i = rewardsCenterApiHelper$checkDadaSetDefault$122.label;
        if (i != 0) {
        }
        obj = Result.constructor-impl((BaseDto) obj22);
        if (Result.isSuccess-impl(obj)) {
        }
        th2 = Result.exceptionOrNull-impl(obj);
        if (th2 != null) {
            function2.invoke((Object) null, th2.getMessage());
        }
        return Unit.a;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(15:0|1|(2:3|(12:5|6|7|8|(1:(2:11|12)(2:29|30))(3:31|32|(1:34))|13|14|(2:16|(1:18)(1:(1:20)))|21|(1:24)|25|26))|37|6|7|8|(0)(0)|13|14|(0)|21|(1:24)|25|26) */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0035, code lost:
    
        r8 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0068, code lost:
    
        r11 = kotlin.Result.Companion;
        r8 = kotlin.Result.constructor-impl(kotlin.ResultKt.a(r8));
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x003f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object l(final String str, Function2 function2, Function1 function1, Continuation continuation) {
        RewardsCenterApiHelper$claimReward$1 rewardsCenterApiHelper$claimReward$1;
        int i;
        Object obj;
        Throwable th2;
        if (continuation instanceof RewardsCenterApiHelper$claimReward$1) {
            rewardsCenterApiHelper$claimReward$1 = (RewardsCenterApiHelper$claimReward$1) continuation;
            int i2 = rewardsCenterApiHelper$claimReward$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                rewardsCenterApiHelper$claimReward$1.label = i2 - Integer.MIN_VALUE;
                RewardsCenterApiHelper$claimReward$1 rewardsCenterApiHelper$claimReward$12 = rewardsCenterApiHelper$claimReward$1;
                Object obj2 = rewardsCenterApiHelper$claimReward$12.result;
                Object f = IntrinsicsKt.f();
                i = rewardsCenterApiHelper$claimReward$12.label;
                if (i != 0) {
                    ResultKt.b(obj2);
                    RequestBody i3 = i(new Function1() { // from class: com.transsion.rewardscenter.utils.k
                        public final Object invoke(Object obj3) {
                            Unit m;
                            m = RewardsCenterApiHelper.m(str, (JSONObject) obj3);
                            return m;
                        }
                    });
                    Result.Companion companion = Result.Companion;
                    xo.a p = p();
                    rewardsCenterApiHelper$claimReward$12.L$0 = function2;
                    rewardsCenterApiHelper$claimReward$12.L$1 = function1;
                    rewardsCenterApiHelper$claimReward$12.label = 1;
                    obj2 = a.C0103a.b(p, null, i3, rewardsCenterApiHelper$claimReward$12, 1, null);
                    if (obj2 == f) {
                        return f;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    function1 = (Function1) rewardsCenterApiHelper$claimReward$12.L$1;
                    function2 = (Function2) rewardsCenterApiHelper$claimReward$12.L$0;
                    ResultKt.b(obj2);
                }
                obj = Result.constructor-impl((BaseDto) obj2);
                if (Result.isSuccess-impl(obj)) {
                    BaseDto baseDto = (BaseDto) obj;
                    if (n.a(baseDto)) {
                        function1.invoke(baseDto.getData());
                    } else if (function2 != null) {
                        function2.invoke(baseDto.getCode(), baseDto.getMsg());
                    }
                }
                th2 = Result.exceptionOrNull-impl(obj);
                if (th2 != null && function2 != null) {
                    function2.invoke((Object) null, th2.getMessage());
                }
                return Unit.a;
            }
        }
        rewardsCenterApiHelper$claimReward$1 = new RewardsCenterApiHelper$claimReward$1(this, continuation);
        RewardsCenterApiHelper$claimReward$1 rewardsCenterApiHelper$claimReward$122 = rewardsCenterApiHelper$claimReward$1;
        Object obj22 = rewardsCenterApiHelper$claimReward$122.result;
        Object f2 = IntrinsicsKt.f();
        i = rewardsCenterApiHelper$claimReward$122.label;
        if (i != 0) {
        }
        obj = Result.constructor-impl((BaseDto) obj22);
        if (Result.isSuccess-impl(obj)) {
        }
        th2 = Result.exceptionOrNull-impl(obj);
        if (th2 != null) {
            function2.invoke((Object) null, th2.getMessage());
        }
        return Unit.a;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(14:0|1|(2:3|(11:5|6|7|(1:(2:10|11)(2:28|29))(3:30|31|(1:33))|12|13|(2:15|(1:17)(1:(1:19)))|20|(1:23)|24|25))|36|6|7|(0)(0)|12|13|(0)|20|(1:23)|24|25) */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0033, code lost:
    
        r8 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x005a, code lost:
    
        r0 = kotlin.Result.Companion;
        r8 = kotlin.Result.constructor-impl(kotlin.ResultKt.a(r8));
     */
    /* JADX WARN: Removed duplicated region for block: B:15:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object n(Function2 function2, Function1 function1, Continuation continuation) {
        RewardsCenterApiHelper$fetchAdTaskInfo$1 rewardsCenterApiHelper$fetchAdTaskInfo$1;
        int i;
        Object obj;
        Throwable th2;
        if (continuation instanceof RewardsCenterApiHelper$fetchAdTaskInfo$1) {
            rewardsCenterApiHelper$fetchAdTaskInfo$1 = (RewardsCenterApiHelper$fetchAdTaskInfo$1) continuation;
            int i2 = rewardsCenterApiHelper$fetchAdTaskInfo$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                rewardsCenterApiHelper$fetchAdTaskInfo$1.label = i2 - Integer.MIN_VALUE;
                Object obj2 = rewardsCenterApiHelper$fetchAdTaskInfo$1.result;
                Object f = IntrinsicsKt.f();
                i = rewardsCenterApiHelper$fetchAdTaskInfo$1.label;
                if (i != 0) {
                    ResultKt.b(obj2);
                    Result.Companion companion = Result.Companion;
                    xo.a p = p();
                    rewardsCenterApiHelper$fetchAdTaskInfo$1.L$0 = function2;
                    rewardsCenterApiHelper$fetchAdTaskInfo$1.L$1 = function1;
                    rewardsCenterApiHelper$fetchAdTaskInfo$1.label = 1;
                    obj2 = a.C0103a.c(p, null, rewardsCenterApiHelper$fetchAdTaskInfo$1, 1, null);
                    if (obj2 == f) {
                        return f;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    function1 = (Function1) rewardsCenterApiHelper$fetchAdTaskInfo$1.L$1;
                    function2 = (Function2) rewardsCenterApiHelper$fetchAdTaskInfo$1.L$0;
                    ResultKt.b(obj2);
                }
                obj = Result.constructor-impl((BaseDto) obj2);
                if (Result.isSuccess-impl(obj)) {
                    BaseDto baseDto = (BaseDto) obj;
                    if (n.a(baseDto)) {
                        function1.invoke(baseDto.getData());
                    } else if (function2 != null) {
                        function2.invoke(baseDto.getCode(), baseDto.getMsg());
                    }
                }
                th2 = Result.exceptionOrNull-impl(obj);
                if (th2 != null && function2 != null) {
                    function2.invoke((Object) null, th2.getMessage());
                }
                return Unit.a;
            }
        }
        rewardsCenterApiHelper$fetchAdTaskInfo$1 = new RewardsCenterApiHelper$fetchAdTaskInfo$1(this, continuation);
        Object obj22 = rewardsCenterApiHelper$fetchAdTaskInfo$1.result;
        Object f2 = IntrinsicsKt.f();
        i = rewardsCenterApiHelper$fetchAdTaskInfo$1.label;
        if (i != 0) {
        }
        obj = Result.constructor-impl((BaseDto) obj22);
        if (Result.isSuccess-impl(obj)) {
        }
        th2 = Result.exceptionOrNull-impl(obj);
        if (th2 != null) {
            function2.invoke((Object) null, th2.getMessage());
        }
        return Unit.a;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(15:0|1|(2:3|(12:5|6|7|8|(1:(2:11|12)(2:29|30))(3:31|32|(1:34))|13|14|(2:16|(1:18)(1:(1:20)))|21|(1:24)|25|26))|37|6|7|8|(0)(0)|13|14|(0)|21|(1:24)|25|26) */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0035, code lost:
    
        r8 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0068, code lost:
    
        r11 = kotlin.Result.Companion;
        r8 = kotlin.Result.constructor-impl(kotlin.ResultKt.a(r8));
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x003f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object q(final String str, Function2 function2, Function1 function1, Continuation continuation) {
        RewardsCenterApiHelper$redeemLottery$1 rewardsCenterApiHelper$redeemLottery$1;
        int i;
        Object obj;
        Throwable th2;
        if (continuation instanceof RewardsCenterApiHelper$redeemLottery$1) {
            rewardsCenterApiHelper$redeemLottery$1 = (RewardsCenterApiHelper$redeemLottery$1) continuation;
            int i2 = rewardsCenterApiHelper$redeemLottery$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                rewardsCenterApiHelper$redeemLottery$1.label = i2 - Integer.MIN_VALUE;
                RewardsCenterApiHelper$redeemLottery$1 rewardsCenterApiHelper$redeemLottery$12 = rewardsCenterApiHelper$redeemLottery$1;
                Object obj2 = rewardsCenterApiHelper$redeemLottery$12.result;
                Object f = IntrinsicsKt.f();
                i = rewardsCenterApiHelper$redeemLottery$12.label;
                if (i != 0) {
                    ResultKt.b(obj2);
                    RequestBody i3 = i(new Function1() { // from class: com.transsion.rewardscenter.utils.m
                        public final Object invoke(Object obj3) {
                            Unit r;
                            r = RewardsCenterApiHelper.r(str, (JSONObject) obj3);
                            return r;
                        }
                    });
                    Result.Companion companion = Result.Companion;
                    xo.a p = p();
                    rewardsCenterApiHelper$redeemLottery$12.L$0 = function2;
                    rewardsCenterApiHelper$redeemLottery$12.L$1 = function1;
                    rewardsCenterApiHelper$redeemLottery$12.label = 1;
                    obj2 = a.C0103a.g(p, null, i3, rewardsCenterApiHelper$redeemLottery$12, 1, null);
                    if (obj2 == f) {
                        return f;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    function1 = (Function1) rewardsCenterApiHelper$redeemLottery$12.L$1;
                    function2 = (Function2) rewardsCenterApiHelper$redeemLottery$12.L$0;
                    ResultKt.b(obj2);
                }
                obj = Result.constructor-impl((BaseDto) obj2);
                if (Result.isSuccess-impl(obj)) {
                    BaseDto baseDto = (BaseDto) obj;
                    if (n.a(baseDto)) {
                        function1.invoke(baseDto.getData());
                    } else if (function2 != null) {
                        function2.invoke(baseDto.getCode(), baseDto.getMsg());
                    }
                }
                th2 = Result.exceptionOrNull-impl(obj);
                if (th2 != null && function2 != null) {
                    function2.invoke((Object) null, th2.getMessage());
                }
                return Unit.a;
            }
        }
        rewardsCenterApiHelper$redeemLottery$1 = new RewardsCenterApiHelper$redeemLottery$1(this, continuation);
        RewardsCenterApiHelper$redeemLottery$1 rewardsCenterApiHelper$redeemLottery$122 = rewardsCenterApiHelper$redeemLottery$1;
        Object obj22 = rewardsCenterApiHelper$redeemLottery$122.result;
        Object f2 = IntrinsicsKt.f();
        i = rewardsCenterApiHelper$redeemLottery$122.label;
        if (i != 0) {
        }
        obj = Result.constructor-impl((BaseDto) obj22);
        if (Result.isSuccess-impl(obj)) {
        }
        th2 = Result.exceptionOrNull-impl(obj);
        if (th2 != null) {
            function2.invoke((Object) null, th2.getMessage());
        }
        return Unit.a;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(15:0|1|(2:3|(12:5|6|7|8|(1:(2:11|12)(2:29|30))(3:31|32|(1:34))|13|14|(2:16|(1:18)(1:(1:20)))|21|(1:24)|25|26))|37|6|7|8|(0)(0)|13|14|(0)|21|(1:24)|25|26) */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0035, code lost:
    
        r8 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0068, code lost:
    
        r11 = kotlin.Result.Companion;
        r8 = kotlin.Result.constructor-impl(kotlin.ResultKt.a(r8));
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x003f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object s(final String str, Function2 function2, Function1 function1, Continuation continuation) {
        RewardsCenterApiHelper$redeemProduct$1 rewardsCenterApiHelper$redeemProduct$1;
        int i;
        Object obj;
        Throwable th2;
        if (continuation instanceof RewardsCenterApiHelper$redeemProduct$1) {
            rewardsCenterApiHelper$redeemProduct$1 = (RewardsCenterApiHelper$redeemProduct$1) continuation;
            int i2 = rewardsCenterApiHelper$redeemProduct$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                rewardsCenterApiHelper$redeemProduct$1.label = i2 - Integer.MIN_VALUE;
                RewardsCenterApiHelper$redeemProduct$1 rewardsCenterApiHelper$redeemProduct$12 = rewardsCenterApiHelper$redeemProduct$1;
                Object obj2 = rewardsCenterApiHelper$redeemProduct$12.result;
                Object f = IntrinsicsKt.f();
                i = rewardsCenterApiHelper$redeemProduct$12.label;
                if (i != 0) {
                    ResultKt.b(obj2);
                    RequestBody i3 = i(new Function1() { // from class: com.transsion.rewardscenter.utils.h
                        public final Object invoke(Object obj3) {
                            Unit t;
                            t = RewardsCenterApiHelper.t(str, (JSONObject) obj3);
                            return t;
                        }
                    });
                    Result.Companion companion = Result.Companion;
                    xo.a p = p();
                    rewardsCenterApiHelper$redeemProduct$12.L$0 = function2;
                    rewardsCenterApiHelper$redeemProduct$12.L$1 = function1;
                    rewardsCenterApiHelper$redeemProduct$12.label = 1;
                    obj2 = a.C0103a.h(p, null, i3, rewardsCenterApiHelper$redeemProduct$12, 1, null);
                    if (obj2 == f) {
                        return f;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    function1 = (Function1) rewardsCenterApiHelper$redeemProduct$12.L$1;
                    function2 = (Function2) rewardsCenterApiHelper$redeemProduct$12.L$0;
                    ResultKt.b(obj2);
                }
                obj = Result.constructor-impl((BaseDto) obj2);
                if (Result.isSuccess-impl(obj)) {
                    BaseDto baseDto = (BaseDto) obj;
                    if (n.a(baseDto)) {
                        function1.invoke(baseDto.getData());
                    } else if (function2 != null) {
                        function2.invoke(baseDto.getCode(), baseDto.getMsg());
                    }
                }
                th2 = Result.exceptionOrNull-impl(obj);
                if (th2 != null && function2 != null) {
                    function2.invoke((Object) null, th2.getMessage());
                }
                return Unit.a;
            }
        }
        rewardsCenterApiHelper$redeemProduct$1 = new RewardsCenterApiHelper$redeemProduct$1(this, continuation);
        RewardsCenterApiHelper$redeemProduct$1 rewardsCenterApiHelper$redeemProduct$122 = rewardsCenterApiHelper$redeemProduct$1;
        Object obj22 = rewardsCenterApiHelper$redeemProduct$122.result;
        Object f2 = IntrinsicsKt.f();
        i = rewardsCenterApiHelper$redeemProduct$122.label;
        if (i != 0) {
        }
        obj = Result.constructor-impl((BaseDto) obj22);
        if (Result.isSuccess-impl(obj)) {
        }
        th2 = Result.exceptionOrNull-impl(obj);
        if (th2 != null) {
            function2.invoke((Object) null, th2.getMessage());
        }
        return Unit.a;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(15:0|1|(2:3|(12:5|6|7|8|(1:(2:11|12)(2:27|28))(3:29|30|(1:32))|13|14|(2:16|(1:18)(1:19))|20|(1:22)|23|24))|35|6|7|8|(0)(0)|13|14|(0)|20|(0)|23|24) */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0035, code lost:
    
        r8 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0068, code lost:
    
        r11 = kotlin.Result.Companion;
        r8 = kotlin.Result.constructor-impl(kotlin.ResultKt.a(r8));
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x003f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object u(final String str, Function2 function2, Function1 function1, Continuation continuation) {
        RewardsCenterApiHelper$startClaim$1 rewardsCenterApiHelper$startClaim$1;
        int i;
        Object obj;
        Throwable th2;
        if (continuation instanceof RewardsCenterApiHelper$startClaim$1) {
            rewardsCenterApiHelper$startClaim$1 = (RewardsCenterApiHelper$startClaim$1) continuation;
            int i2 = rewardsCenterApiHelper$startClaim$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                rewardsCenterApiHelper$startClaim$1.label = i2 - Integer.MIN_VALUE;
                RewardsCenterApiHelper$startClaim$1 rewardsCenterApiHelper$startClaim$12 = rewardsCenterApiHelper$startClaim$1;
                Object obj2 = rewardsCenterApiHelper$startClaim$12.result;
                Object f = IntrinsicsKt.f();
                i = rewardsCenterApiHelper$startClaim$12.label;
                if (i != 0) {
                    ResultKt.b(obj2);
                    RequestBody i3 = i(new Function1() { // from class: com.transsion.rewardscenter.utils.j
                        public final Object invoke(Object obj3) {
                            Unit v;
                            v = RewardsCenterApiHelper.v(str, (JSONObject) obj3);
                            return v;
                        }
                    });
                    Result.Companion companion = Result.Companion;
                    xo.a p = p();
                    rewardsCenterApiHelper$startClaim$12.L$0 = function2;
                    rewardsCenterApiHelper$startClaim$12.L$1 = function1;
                    rewardsCenterApiHelper$startClaim$12.label = 1;
                    obj2 = a.C0103a.f(p, null, i3, rewardsCenterApiHelper$startClaim$12, 1, null);
                    if (obj2 == f) {
                        return f;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    function1 = (Function1) rewardsCenterApiHelper$startClaim$12.L$1;
                    function2 = (Function2) rewardsCenterApiHelper$startClaim$12.L$0;
                    ResultKt.b(obj2);
                }
                obj = Result.constructor-impl((BaseDto) obj2);
                if (Result.isSuccess-impl(obj)) {
                    BaseDto baseDto = (BaseDto) obj;
                    if (n.a(baseDto)) {
                        function1.invoke(baseDto.getData());
                    } else {
                        function2.invoke(baseDto.getCode(), baseDto.getMsg());
                    }
                }
                th2 = Result.exceptionOrNull-impl(obj);
                if (th2 != null) {
                    function2.invoke((Object) null, th2.getMessage());
                }
                return Unit.a;
            }
        }
        rewardsCenterApiHelper$startClaim$1 = new RewardsCenterApiHelper$startClaim$1(this, continuation);
        RewardsCenterApiHelper$startClaim$1 rewardsCenterApiHelper$startClaim$122 = rewardsCenterApiHelper$startClaim$1;
        Object obj22 = rewardsCenterApiHelper$startClaim$122.result;
        Object f2 = IntrinsicsKt.f();
        i = rewardsCenterApiHelper$startClaim$122.label;
        if (i != 0) {
        }
        obj = Result.constructor-impl((BaseDto) obj22);
        if (Result.isSuccess-impl(obj)) {
        }
        th2 = Result.exceptionOrNull-impl(obj);
        if (th2 != null) {
        }
        return Unit.a;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(15:0|1|(2:3|(12:5|6|7|8|(1:(2:11|12)(2:29|30))(3:31|32|(1:34))|13|14|(2:16|(1:18)(1:(1:20)))|21|(1:24)|25|26))|37|6|7|8|(0)(0)|13|14|(0)|21|(1:24)|25|26) */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0035, code lost:
    
        r8 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0068, code lost:
    
        r11 = kotlin.Result.Companion;
        r8 = kotlin.Result.constructor-impl(kotlin.ResultKt.a(r8));
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x003f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object w(final ClaimReceiverRequest claimReceiverRequest, Function2 function2, Function1 function1, Continuation continuation) {
        RewardsCenterApiHelper$submitClaimReceiverInfo$1 rewardsCenterApiHelper$submitClaimReceiverInfo$1;
        int i;
        Object obj;
        Throwable th2;
        if (continuation instanceof RewardsCenterApiHelper$submitClaimReceiverInfo$1) {
            rewardsCenterApiHelper$submitClaimReceiverInfo$1 = (RewardsCenterApiHelper$submitClaimReceiverInfo$1) continuation;
            int i2 = rewardsCenterApiHelper$submitClaimReceiverInfo$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                rewardsCenterApiHelper$submitClaimReceiverInfo$1.label = i2 - Integer.MIN_VALUE;
                RewardsCenterApiHelper$submitClaimReceiverInfo$1 rewardsCenterApiHelper$submitClaimReceiverInfo$12 = rewardsCenterApiHelper$submitClaimReceiverInfo$1;
                Object obj2 = rewardsCenterApiHelper$submitClaimReceiverInfo$12.result;
                Object f = IntrinsicsKt.f();
                i = rewardsCenterApiHelper$submitClaimReceiverInfo$12.label;
                if (i != 0) {
                    ResultKt.b(obj2);
                    RequestBody i3 = i(new Function1() { // from class: com.transsion.rewardscenter.utils.l
                        public final Object invoke(Object obj3) {
                            Unit x;
                            x = RewardsCenterApiHelper.x(ClaimReceiverRequest.this, (JSONObject) obj3);
                            return x;
                        }
                    });
                    Result.Companion companion = Result.Companion;
                    xo.a p = p();
                    rewardsCenterApiHelper$submitClaimReceiverInfo$12.L$0 = function2;
                    rewardsCenterApiHelper$submitClaimReceiverInfo$12.L$1 = function1;
                    rewardsCenterApiHelper$submitClaimReceiverInfo$12.label = 1;
                    obj2 = a.C0103a.i(p, null, i3, rewardsCenterApiHelper$submitClaimReceiverInfo$12, 1, null);
                    if (obj2 == f) {
                        return f;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    function1 = (Function1) rewardsCenterApiHelper$submitClaimReceiverInfo$12.L$1;
                    function2 = (Function2) rewardsCenterApiHelper$submitClaimReceiverInfo$12.L$0;
                    ResultKt.b(obj2);
                }
                obj = Result.constructor-impl((BaseDto) obj2);
                if (Result.isSuccess-impl(obj)) {
                    BaseDto baseDto = (BaseDto) obj;
                    if (n.a(baseDto)) {
                        function1.invoke(baseDto.getData());
                    } else if (function2 != null) {
                        function2.invoke(baseDto.getCode(), baseDto.getMsg());
                    }
                }
                th2 = Result.exceptionOrNull-impl(obj);
                if (th2 != null && function2 != null) {
                    function2.invoke((Object) null, th2.getMessage());
                }
                return Unit.a;
            }
        }
        rewardsCenterApiHelper$submitClaimReceiverInfo$1 = new RewardsCenterApiHelper$submitClaimReceiverInfo$1(this, continuation);
        RewardsCenterApiHelper$submitClaimReceiverInfo$1 rewardsCenterApiHelper$submitClaimReceiverInfo$122 = rewardsCenterApiHelper$submitClaimReceiverInfo$1;
        Object obj22 = rewardsCenterApiHelper$submitClaimReceiverInfo$122.result;
        Object f2 = IntrinsicsKt.f();
        i = rewardsCenterApiHelper$submitClaimReceiverInfo$122.label;
        if (i != 0) {
        }
        obj = Result.constructor-impl((BaseDto) obj22);
        if (Result.isSuccess-impl(obj)) {
        }
        th2 = Result.exceptionOrNull-impl(obj);
        if (th2 != null) {
            function2.invoke((Object) null, th2.getMessage());
        }
        return Unit.a;
    }
}
