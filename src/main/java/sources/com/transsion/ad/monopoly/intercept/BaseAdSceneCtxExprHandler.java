package com.transsion.ad.monopoly.intercept;

import android.text.TextUtils;
import com.transsion.ad.db.plan.MbAdDbPlans;
import com.transsion.ad.monopoly.model.AdPlansHitResponse;
import com.transsion.gslb.BuildConfig;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.mvel2.d;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public abstract class BaseAdSceneCtxExprHandler extends a {
    /* JADX WARN: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    static /* synthetic */ Object g(BaseAdSceneCtxExprHandler baseAdSceneCtxExprHandler, String str, MbAdDbPlans mbAdDbPlans, Map map, Continuation continuation) {
        BaseAdSceneCtxExprHandler$doHandle$1 baseAdSceneCtxExprHandler$doHandle$1;
        int i;
        boolean l;
        AdPlansHitResponse adPlansHitResponse;
        AdPlansHitResponse adPlansHitResponse2;
        AdPlansHitResponse adPlansHitResponse3;
        BaseAdSceneCtxExprHandler baseAdSceneCtxExprHandler2 = baseAdSceneCtxExprHandler;
        if (continuation instanceof BaseAdSceneCtxExprHandler$doHandle$1) {
            baseAdSceneCtxExprHandler$doHandle$1 = (BaseAdSceneCtxExprHandler$doHandle$1) continuation;
            int i2 = baseAdSceneCtxExprHandler$doHandle$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                baseAdSceneCtxExprHandler$doHandle$1.label = i2 - Integer.MIN_VALUE;
                Object obj = baseAdSceneCtxExprHandler$doHandle$1.result;
                Object f = IntrinsicsKt.f();
                i = baseAdSceneCtxExprHandler$doHandle$1.label;
                if (i == 0) {
                    if (i == 1) {
                        baseAdSceneCtxExprHandler2 = (BaseAdSceneCtxExprHandler) baseAdSceneCtxExprHandler$doHandle$1.L$0;
                        ResultKt.b(obj);
                        adPlansHitResponse = (AdPlansHitResponse) obj;
                        if (adPlansHitResponse != null) {
                            return adPlansHitResponse;
                        }
                        return baseAdSceneCtxExprHandler2.e();
                    }
                    if (i == 2) {
                        baseAdSceneCtxExprHandler2 = (BaseAdSceneCtxExprHandler) baseAdSceneCtxExprHandler$doHandle$1.L$0;
                        ResultKt.b(obj);
                        adPlansHitResponse2 = (AdPlansHitResponse) obj;
                        if (adPlansHitResponse2 != null) {
                            return adPlansHitResponse2;
                        }
                        return baseAdSceneCtxExprHandler2.e();
                    }
                    if (i != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    baseAdSceneCtxExprHandler2 = (BaseAdSceneCtxExprHandler) baseAdSceneCtxExprHandler$doHandle$1.L$0;
                    ResultKt.b(obj);
                    adPlansHitResponse3 = (AdPlansHitResponse) obj;
                    if (adPlansHitResponse3 != null) {
                        return adPlansHitResponse3;
                    }
                    return baseAdSceneCtxExprHandler2.e();
                }
                ResultKt.b(obj);
                if (map.isEmpty()) {
                    a c = baseAdSceneCtxExprHandler.c();
                    if (c != null) {
                        baseAdSceneCtxExprHandler$doHandle$1.L$0 = baseAdSceneCtxExprHandler2;
                        baseAdSceneCtxExprHandler$doHandle$1.label = 1;
                        obj = c.b(str, mbAdDbPlans, map, baseAdSceneCtxExprHandler$doHandle$1);
                        if (obj == f) {
                            return f;
                        }
                        adPlansHitResponse = (AdPlansHitResponse) obj;
                        if (adPlansHitResponse != null) {
                        }
                    }
                    return baseAdSceneCtxExprHandler2.e();
                }
                String h = baseAdSceneCtxExprHandler.h(str, mbAdDbPlans, map);
                if (h == null) {
                    h = BuildConfig.FLAVOR;
                }
                if (TextUtils.isEmpty(h)) {
                    a c2 = baseAdSceneCtxExprHandler.c();
                    if (c2 != null) {
                        baseAdSceneCtxExprHandler$doHandle$1.L$0 = baseAdSceneCtxExprHandler2;
                        baseAdSceneCtxExprHandler$doHandle$1.label = 2;
                        obj = c2.b(str, mbAdDbPlans, map, baseAdSceneCtxExprHandler$doHandle$1);
                        if (obj == f) {
                            return f;
                        }
                        adPlansHitResponse2 = (AdPlansHitResponse) obj;
                        if (adPlansHitResponse2 != null) {
                        }
                    }
                    return baseAdSceneCtxExprHandler2.e();
                }
                Object obj2 = map.get("genre");
                String str2 = obj2 instanceof String ? (String) obj2 : null;
                if (TextUtils.isEmpty(str2) || ((str2 == null || !StringsKt.c0(str2, ", ", false, 2, (Object) null)) && (str2 == null || !StringsKt.c0(str2, ",", false, 2, (Object) null)))) {
                    l = baseAdSceneCtxExprHandler2.l(h, map);
                } else {
                    List<String> S0 = StringsKt.S0(StringsKt.Q(str2, " ", BuildConfig.FLAVOR, false, 4, (Object) null), new String[]{","}, false, 0, 6, (Object) null);
                    Ref.BooleanRef booleanRef = new Ref.BooleanRef();
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    for (String str3 : S0) {
                        linkedHashMap.putAll(map);
                        linkedHashMap.put("genre", str3);
                        if (baseAdSceneCtxExprHandler2.l(h, linkedHashMap)) {
                            booleanRef.element = true;
                        }
                    }
                    l = booleanRef.element;
                }
                if (!baseAdSceneCtxExprHandler2.k(l)) {
                    return new AdPlansHitResponse(false, l ? baseAdSceneCtxExprHandler.i() : baseAdSceneCtxExprHandler.j());
                }
                a c3 = baseAdSceneCtxExprHandler.c();
                if (c3 != null) {
                    baseAdSceneCtxExprHandler$doHandle$1.L$0 = baseAdSceneCtxExprHandler2;
                    baseAdSceneCtxExprHandler$doHandle$1.label = 3;
                    obj = c3.b(str, mbAdDbPlans, map, baseAdSceneCtxExprHandler$doHandle$1);
                    if (obj == f) {
                        return f;
                    }
                    adPlansHitResponse3 = (AdPlansHitResponse) obj;
                    if (adPlansHitResponse3 != null) {
                    }
                }
                return baseAdSceneCtxExprHandler2.e();
            }
        }
        baseAdSceneCtxExprHandler$doHandle$1 = new BaseAdSceneCtxExprHandler$doHandle$1(baseAdSceneCtxExprHandler2, continuation);
        Object obj3 = baseAdSceneCtxExprHandler$doHandle$1.result;
        Object f2 = IntrinsicsKt.f();
        i = baseAdSceneCtxExprHandler$doHandle$1.label;
        if (i == 0) {
        }
    }

    private final boolean l(String str, Map map) {
        Object obj;
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        try {
            Result.Companion companion = Result.Companion;
            Map w = MapsKt.w(map);
            Iterator it = Regex.findAll$default(new Regex("\\b([a-zA-Z_][a-zA-Z0-9_]*)\\b"), str, 0, 2, (Object) null).iterator();
            while (it.hasNext()) {
                String str2 = (String) ((MatchResult) it.next()).a().get(1);
                if (!w.containsKey(str2)) {
                    w.put(str2, null);
                }
            }
            Object n = d.n(str, w);
            Intrinsics.f(n, "null cannot be cast to non-null type kotlin.Boolean");
            Boolean bool = (Boolean) n;
            bool.booleanValue();
            obj = Result.constructor-impl(bool);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.a(th2));
        }
        Throwable th3 = Result.exceptionOrNull-impl(obj);
        if (th3 != null) {
            wf.a.a.i("sampler", "Eval --> safeEval() --> it = " + th3 + " --> rule = " + str + " --> safeVars = " + map, true);
            obj = Boolean.FALSE;
        }
        return ((Boolean) obj).booleanValue();
    }

    @Override // com.transsion.ad.monopoly.intercept.a
    public Object b(String str, MbAdDbPlans mbAdDbPlans, Map map, Continuation continuation) {
        return g(this, str, mbAdDbPlans, map, continuation);
    }

    public abstract String h(String str, MbAdDbPlans mbAdDbPlans, Map map);

    public abstract String i();

    public abstract String j();

    public abstract boolean k(boolean z);
}
