package com.transsion.base.report.athena.sampler;

import android.text.TextUtils;
import com.blankj.utilcode.util.o;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import wf.a;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class EventConfig {
    public static final EventConfig a = new EventConfig();
    private static final String b = "[\n    {\n        \"eventExpr\":\"(event =='ad_trigger')\",\n        \"batchKey\":\"客户端采样因子A\",\n        \"samplingRate\":0\n    },\n    {\n       \"eventExpr\":\"(event =='ad_display')\",\n        \"batchKey\":\"客户端采样因子b\",\n        \"samplingRate\":10\n    },\n    {\n       \"eventExpr\":\"(event =='ad_click')\",\n        \"batchKey\":\"客户端采样因子b\",\n        \"samplingRate\":90\n    }\n]";
    private static volatile List c;
    private static final Set d;
    private static final Set e;

    static {
        Set newSetFromMap = Collections.newSetFromMap(new ConcurrentHashMap());
        Intrinsics.g(newSetFromMap, "newSetFromMap(...)");
        d = newSetFromMap;
        Set newSetFromMap2 = Collections.newSetFromMap(new ConcurrentHashMap());
        Intrinsics.g(newSetFromMap2, "newSetFromMap(...)");
        e = newSetFromMap2;
    }

    private EventConfig() {
    }

    private final void f(String str) {
        Object obj;
        try {
            Result.Companion companion = Result.Companion;
            c = (List) o.f().fromJson(str, new TypeToken<List<? extends EventStrategyBean>>() { // from class: com.transsion.base.report.athena.sampler.EventConfig$initEventStrategy$1$listType$1
            }.getType());
            obj = Result.constructor-impl(Unit.a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.a(th2));
        }
        Throwable th3 = Result.exceptionOrNull-impl(obj);
        if (th3 != null) {
            a.a.l(wf.a.a, "sampler", "EventConfig --> initEventStrategy() --> error = " + th3, false, 4, (Object) null);
            c = null;
        }
    }

    private final boolean g(String str) {
        if (str == null || StringsKt.q0(str)) {
            return false;
        }
        try {
            JsonElement parseString = JsonParser.parseString(str);
            Intrinsics.g(parseString, "parseString(...)");
            if (!parseString.isJsonObject()) {
                if (!parseString.isJsonArray()) {
                    return false;
                }
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public final void a(String str) {
        Intrinsics.h(str, "event");
        e.add(str);
    }

    public final void b(String str) {
        Intrinsics.h(str, "event");
        d.add(str);
    }

    public final Set c() {
        return CollectionsKt.W0(e);
    }

    public final Set d() {
        return CollectionsKt.W0(d);
    }

    public final List e() {
        return c;
    }

    public final void h(String str) {
        Intrinsics.h(str, "event");
        e.remove(str);
    }

    public final void i(String str) {
        Intrinsics.h(str, "event");
        d.remove(str);
    }

    public final void j(String str) {
        a.a aVar = wf.a.a;
        a.a.f(aVar, "sampler", "EventConfig --> saveEventStrategy() --> eventStrategy = " + str, false, 4, (Object) null);
        if (TextUtils.isEmpty(str)) {
            a.a.l(aVar, "sampler", "EventConfig --> saveEventStrategy() --> eventStrategy is empty!", false, 4, (Object) null);
        } else if (g(str)) {
            f(str);
        } else {
            a.a.l(aVar, "sampler", "EventConfig --> saveEventStrategy() --> eventStrategy is not json!", false, 4, (Object) null);
        }
    }
}
