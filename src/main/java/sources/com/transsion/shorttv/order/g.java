package com.transsion.shorttv.order;

import com.google.gson.JsonObject;
import com.transsion.gslb.BuildConfig;
import com.transsion.shorttv.order.a;
import com.transsion.shorttv.order.bean.CreatePaynicornOrderReqBean;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import org.json.JSONObject;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class g {
    public static final g a = new g();
    private static final Lazy b = LazyKt.b(new Function0() { // from class: com.transsion.shorttv.order.f
        public final Object invoke() {
            a e;
            e = g.e();
            return e;
        }
    });

    private g() {
    }

    private final a d() {
        return (a) b.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final a e() {
        return (a) kg.c.e.a().h(a.class);
    }

    public final Object b(CreatePaynicornOrderReqBean createPaynicornOrderReqBean, Continuation continuation) {
        Map<String, String> extStrJson;
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("project_name", createPaynicornOrderReqBean != null ? createPaynicornOrderReqBean.getProjectName() : null);
        jsonObject.addProperty("sku_id", createPaynicornOrderReqBean != null ? createPaynicornOrderReqBean.getSkuId() : null);
        jsonObject.addProperty("user_id", createPaynicornOrderReqBean != null ? createPaynicornOrderReqBean.getUserId() : null);
        jsonObject.addProperty("cp_front_page", createPaynicornOrderReqBean != null ? createPaynicornOrderReqBean.getCpFrontPage() : null);
        if (createPaynicornOrderReqBean != null && (extStrJson = createPaynicornOrderReqBean.getExtStrJson()) != null) {
            String jSONObject = new JSONObject(extStrJson).toString();
            Intrinsics.g(jSONObject, "toString(...)");
            jsonObject.addProperty("ext", jSONObject);
        }
        RequestBody.Companion companion = RequestBody.Companion;
        String jsonElement = jsonObject.toString();
        Intrinsics.g(jsonElement, "toString(...)");
        return a.C0062a.a(d(), null, companion.create(jsonElement, MediaType.Companion.parse("application/json")), e.a.a(createPaynicornOrderReqBean != null ? Boxing.a(createPaynicornOrderReqBean.isDebug()) : null), continuation, 1, null);
    }

    public final Object c(String str, String str2, boolean z, Continuation continuation) {
        return a.C0062a.b(d(), null, str == null ? BuildConfig.FLAVOR : str, str2 == null ? BuildConfig.FLAVOR : str2, e.a.a(Boxing.a(z)), continuation, 1, null);
    }
}
