package com.cloud.hisavana.sdk.common.http;

import android.text.TextUtils;
import android.util.Log;
import c7.b;
import com.cloud.hisavana.net.HttpRequest;
import com.cloud.hisavana.net.RequestParams;
import com.cloud.hisavana.net.impl.StringCallback;
import com.cloud.hisavana.sdk.common.athena.AthenaTracker;
import com.cloud.hisavana.sdk.common.constant.TaErrorCode;
import com.cloud.hisavana.sdk.common.http.listener.CommonResponseListener;
import com.cloud.hisavana.sdk.common.http.listener.ResponseBaseListener;
import com.cloud.hisavana.sdk.data.bean.request.AdxImpBean;
import com.cloud.hisavana.sdk.f0;
import com.cloud.sdk.commonutil.util.c;
import com.cloud.sdk.commonutil.util.e;
import java.util.Locale;
import javax.net.ssl.SSLSocketFactory;
import okhttp3.Headers;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public class a extends d {
    private static String k;
    private static String l;
    private static boolean m;
    private String c = "0";
    private String d = "";
    private boolean e = false;
    private SSLSocketFactory f = null;
    private b g = null;
    private String h = "0";
    private String i = "1";
    private AdxImpBean j;

    /* renamed from: com.cloud.hisavana.sdk.common.http.a$a, reason: collision with other inner class name */
    class C0003a extends StringCallback {
        final /* synthetic */ String c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C0003a(boolean z, String str) {
            super(z);
            this.c = str;
        }

        @Override // com.cloud.hisavana.net.impl.StringCallback, com.cloud.hisavana.net.impl.HttpCallbackImpl
        public void l(Headers headers) {
            super.l(headers);
            if (headers != null) {
                for (int i = 0; i < headers.size(); i++) {
                    String name = headers.name(i);
                    if (!TextUtils.isEmpty(name) && name.toLowerCase(Locale.ROOT).contains("cloudcontrolversion")) {
                        String value = headers.value(i);
                        c.netLog("okhttp -> get new cloud control version from header,version: " + value);
                        if (!TextUtils.isEmpty(value) && !value.equals(a.k)) {
                            String unused = a.k = value;
                            boolean unused2 = a.m = true;
                            c.netLog("okhttp ->  cloud control version update");
                            l7.a.e().r("new_config_ver", value);
                        }
                        l7.a.e().q("last_req_config_time", System.currentTimeMillis());
                    }
                    if (!TextUtils.isEmpty(name) && name.toLowerCase(Locale.ROOT).contains("cloudcontrolofflineversion")) {
                        String value2 = headers.value(i);
                        c.netLog("okhttp -> get new hisavana cloud control version from header,version: " + value2);
                        if (!TextUtils.isEmpty(value2) && !value2.equals(a.l)) {
                            String unused3 = a.l = value2;
                            c.netLog("okhttp -> hisavana cloud control version update");
                            l7.a.e().r("new_hisavana_ver", value2);
                        }
                    }
                }
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:16:0x0078  */
        @Override // com.cloud.hisavana.net.impl.StringCallback
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void x(int r4, java.lang.String r5, java.lang.Throwable r6) {
            /*
                r3 = this;
                boolean r0 = com.cloud.hisavana.sdk.f0.g(r4, r5)
                if (r0 == 0) goto Lc
                com.cloud.hisavana.sdk.common.http.a r4 = com.cloud.hisavana.sdk.common.http.a.this
                com.cloud.hisavana.sdk.common.http.a.c(r4)
                return
            Lc:
                if (r6 == 0) goto L41
                boolean r0 = c7.b.l()
                if (r0 == 0) goto L41
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = r3.c
                r0.append(r1)
                java.lang.String r1 = " ----- error statusCode = "
                r0.append(r1)
                r0.append(r4)
                java.lang.String r1 = " ----- error message = "
                r0.append(r1)
                java.lang.String r1 = r6.getMessage()
                r0.append(r1)
                java.lang.String r1 = " ----- response = "
                r0.append(r1)
                r0.append(r5)
                java.lang.String r0 = r0.toString()
                com.cloud.sdk.commonutil.util.c.netLog(r0)
            L41:
                com.cloud.hisavana.sdk.common.http.a r0 = com.cloud.hisavana.sdk.common.http.a.this
                com.cloud.hisavana.sdk.common.http.listener.ResponseBaseListener r0 = r0.b
                if (r0 == 0) goto L96
                if (r5 == 0) goto L57
                org.json.JSONObject r0 = new org.json.JSONObject     // Catch: java.lang.Exception -> L55
                r0.<init>(r5)     // Catch: java.lang.Exception -> L55
                java.lang.String r1 = "code"
                int r0 = r0.optInt(r1)     // Catch: java.lang.Exception -> L55
                goto L76
            L55:
                r0 = move-exception
                goto L5d
            L57:
                java.lang.String r0 = "can't get code,response is null"
                com.cloud.sdk.commonutil.util.c.netLog(r0)     // Catch: java.lang.Exception -> L55
                goto L75
            L5d:
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = "getCode error "
                r1.append(r2)
                java.lang.String r0 = r0.getMessage()
                r1.append(r0)
                java.lang.String r0 = r1.toString()
                com.cloud.sdk.commonutil.util.c.netLog(r0)
            L75:
                r0 = 0
            L76:
                if (r0 != 0) goto L79
                r0 = r4
            L79:
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = "statusCode = "
                r1.append(r2)
                r1.append(r4)
                java.lang.String r4 = r1.toString()
                com.cloud.sdk.commonutil.util.c.netLog(r4)
                com.cloud.hisavana.sdk.common.http.a r4 = com.cloud.hisavana.sdk.common.http.a.this
                com.cloud.hisavana.sdk.common.http.listener.ResponseBaseListener r4 = r4.b
                com.cloud.hisavana.sdk.common.http.listener.CommonResponseListener r4 = (com.cloud.hisavana.sdk.common.http.listener.CommonResponseListener) r4
                r4.c(r0, r5, r6)
            L96:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.cloud.hisavana.sdk.common.http.a.C0003a.x(int, java.lang.String, java.lang.Throwable):void");
        }

        @Override // com.cloud.hisavana.net.impl.StringCallback
        public void y(int i, String str) {
            if (b.l()) {
                c.netLog(this.c + "\n ----- status code = " + i + "\n ----- response = " + str);
            }
            if (TextUtils.isEmpty(str)) {
                ResponseBaseListener responseBaseListener = ((d) a.this).b;
                if (responseBaseListener != null) {
                    ((CommonResponseListener) responseBaseListener).e(TaErrorCode.ERROR_RESPONSE_IS_NULL);
                }
                c.netLog("TextUtils.isEmpty(response) == true ,  response is null ");
                return;
            }
            ResponseBaseListener responseBaseListener2 = ((d) a.this).b;
            if (responseBaseListener2 != null) {
                ((CommonResponseListener) responseBaseListener2).i(i, str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        String a = this.g.a();
        if (TextUtils.isEmpty(a)) {
            ResponseBaseListener responseBaseListener = ((d) this).b;
            if (responseBaseListener != null) {
                ((CommonResponseListener) responseBaseListener).c(-1, "TextUtils.isEmpty(postBodyString) == true ", null);
            }
            c.netLog("sendRequestToServer() --> TextUtils.isEmpty(postBodyString) == true ");
            return;
        }
        AdxImpBean adxImpBean = this.j;
        if (adxImpBean != null) {
            adxImpBean.requestTs = Long.valueOf(System.currentTimeMillis());
            AthenaTracker.g0(this.j);
        }
        try {
            String str = "----- full url = " + this.d + "\n ----- postBodyString = " + a.trim();
            String k2 = l7.a.e().k("cloudControlVersion", (String) null);
            String k3 = l7.a.e().k("hisavanaCurrentCloudControlVersion", (String) null);
            if (TextUtils.isEmpty(this.d)) {
                return;
            }
            ResponseBaseListener responseBaseListener2 = ((d) this).b;
            boolean z = true;
            if (responseBaseListener2 != null) {
                ((CommonResponseListener) responseBaseListener2).f(1);
            }
            if (i7.a.c() == 0) {
                z = false;
            }
            f0.f(z);
            String c = f0.c("post", "", "application/json", this.d, a);
            RequestParams requestParams = new RequestParams();
            requestParams.i("x-tr-signature", c);
            requestParams.i("cloudControlVersion", k2);
            requestParams.i("cloudControlOfflineVersion", k3);
            requestParams.i("defaultAd", "2");
            requestParams.i("offlineAd", this.h);
            requestParams.i("Accept-Timezone", "UTC");
            requestParams.i("sdktype", this.i);
            requestParams.i("pkg", e.a().getPackageName());
            requestParams.n(a);
            HttpRequest.j(this.d, requestParams, new C0003a(false, str));
        } catch (Throwable th) {
            c.netLog("AdServerRequest --> " + Log.getStackTraceString(th));
            ResponseBaseListener responseBaseListener3 = ((d) this).b;
            if (responseBaseListener3 != null) {
                ((CommonResponseListener) responseBaseListener3).e(new TaErrorCode(-1, th.getMessage()));
            }
        }
    }

    protected void a() {
        i();
    }

    public a j(AdxImpBean adxImpBean) {
        this.j = adxImpBean;
        return this;
    }

    public a k(boolean z) {
        this.e = z;
        return this;
    }

    public a l(boolean z) {
        this.h = z ? "1" : "0";
        return this;
    }

    public a m(CommonResponseListener commonResponseListener) {
        ((d) this).b = commonResponseListener;
        return this;
    }

    public a n(String str) {
        this.c = str;
        return this;
    }

    public a o(b bVar) {
        this.g = bVar;
        return this;
    }

    public a p(String str) {
        this.i = str;
        return this;
    }

    public a q(String str) {
        this.d = str;
        return this;
    }
}
