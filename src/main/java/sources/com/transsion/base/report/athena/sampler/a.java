package com.transsion.base.report.athena.sampler;

import android.os.Bundle;
import android.text.TextUtils;
import com.transsion.gslb.BuildConfig;
import com.transsion.gslb.NetResponse;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import org.json.JSONObject;
import org.mvel2.d;
import wf.a;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class a {
    public static final a a = new a();

    private a() {
    }

    private final boolean b(String str, Map map) {
        Object obj;
        if (TextUtils.isEmpty(str)) {
            return false;
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

    public final Triple a(String str, Bundle bundle) {
        Object obj;
        Triple triple;
        Intrinsics.h(str, "event");
        Intrinsics.h(bundle, "bundle");
        try {
            Result.Companion companion = Result.Companion;
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            String string = bundle.getString("ext");
            if (string == null) {
                string = NetResponse.EMPTY_RESPONSE;
            }
            JSONObject jSONObject = new JSONObject(string);
            Iterator<String> keys = jSONObject.keys();
            Intrinsics.g(keys, "keys(...)");
            while (keys.hasNext()) {
                String next = keys.next();
                linkedHashMap.put(next, jSONObject.optString(next));
            }
            String string2 = bundle.getString("page_name");
            if (string2 == null) {
                string2 = BuildConfig.FLAVOR;
            }
            linkedHashMap.put("page_name", string2);
            linkedHashMap.put("event", str);
            List<EventStrategyBean> e = EventConfig.a.e();
            if (e != null) {
                for (EventStrategyBean eventStrategyBean : e) {
                    if (!TextUtils.isEmpty(eventStrategyBean.getEventExpr())) {
                        String eventExpr = eventStrategyBean.getEventExpr();
                        if (eventExpr == null) {
                            eventExpr = BuildConfig.FLAVOR;
                        }
                        if (b(eventExpr, linkedHashMap)) {
                            triple = new Triple(Boolean.TRUE, eventStrategyBean.getSamplingRate(), eventStrategyBean.getBatchKey());
                            break;
                        }
                        a.a.f(wf.a.a, "sampler", "Eval --> eval() --> 没有命中 继续下一个表达式判断 --> eventExpr = " + eventStrategyBean.getEventExpr() + " --> contextVars = " + linkedHashMap, false, 4, (Object) null);
                    }
                }
            }
            triple = new Triple(Boolean.FALSE, 100, "没有命中，返回默认值");
            obj = Result.constructor-impl(triple);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.a(th2));
        }
        if (Result.exceptionOrNull-impl(obj) != null) {
            obj = new Triple(Boolean.FALSE, 100, "没有命中，返回默认值");
        }
        return (Triple) obj;
    }
}
