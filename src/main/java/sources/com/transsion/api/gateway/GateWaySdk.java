package com.transsion.api.gateway;

import android.content.Context;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import com.transsion.api.gateway.config.WorkMode;
import com.transsion.api.gateway.interceptor.GatewayInterceptor;
import com.transsion.api.gateway.utils.ContextUtils;
import com.transsion.api.gateway.utils.GatewayUtils;
import com.transsion.api.gateway.utils.SafeStringUtils;
import com.transsion.api.gateway.utils.ThreadManager;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import okhttp3.OkHttpClient;
import org.mvel2.ast.ASTNode;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public class GateWaySdk {
    public static boolean a;
    public static OkHttpClient b;
    public static boolean c;
    public static CopyOnWriteArrayList<String> d = new CopyOnWriteArrayList<>();
    public static CopyOnWriteArrayList<String> e = new CopyOnWriteArrayList<>();
    public static WorkMode f = WorkMode.MODE_ONLINE;

    public static class a implements Runnable {
        public final /* synthetic */ Context a;
        public final /* synthetic */ String b;

        public a(Context context, String str) {
            this.a = context;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            SafeStringUtils.getInstance(this.a).saveString(SafeStringUtils.SP_APPID, this.b);
        }
    }

    public static void a(Context context) {
        if (!c && isOkhttpIntegrated()) {
            c = true;
            try {
                context.registerReceiver(new com.transsion.api.gateway.receiver.a(), new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
            } catch (Exception e3) {
                GatewayUtils.L.e("registerReceiver fail, e:" + e3.getMessage());
            }
        }
    }

    public static List<String> getActivateSigHosts() {
        return d;
    }

    public static List<String> getActivateSigPaths() {
        return e;
    }

    public static String getHost() {
        int ordinal = f.ordinal();
        return (ordinal == 0 || ordinal == 1) ? "apigateway.tmctool.com" : "";
    }

    public static boolean getIsInited() {
        return a;
    }

    public static OkHttpClient getOkHttpClient() {
        if (b == null) {
            b = new OkHttpClient().newBuilder().addInterceptor(new GatewayInterceptor()).build();
        }
        return b;
    }

    public static String getSecret() {
        try {
            if (ContextUtils.getContext() == null) {
                return "";
            }
            ApplicationInfo applicationInfo = ContextUtils.getContext().getPackageManager().getApplicationInfo(ContextUtils.getContext().getPackageName(), ASTNode.ASSIGN);
            int ordinal = f.ordinal();
            return ordinal != 0 ? ordinal != 1 ? "" : applicationInfo.metaData.getString("gateway_secret_online") : applicationInfo.metaData.getString("gateway_secret_test");
        } catch (Exception e3) {
            GatewayUtils.L.e(e3);
            return "";
        }
    }

    public static WorkMode getWorkMode() {
        return f;
    }

    public static void init(Context context, String str) {
        ContextUtils.init(context);
        a(context);
        f = WorkMode.MODE_ONLINE;
        a = true;
    }

    public static void init(Context context, String str, WorkMode workMode) {
        ContextUtils.init(context);
        a(context);
        f = workMode;
        ThreadManager.executeInBackground(new a(context, str));
        ArrayList arrayList = new ArrayList();
        arrayList.add("/gateway/metric/add");
        arrayList.add("/gateway/sdk/v1/config");
        setActivateSignConfig(null, arrayList);
        a = true;
    }

    public static boolean isOkhttpIntegrated() {
        try {
            OkHttpClient.Companion companion = OkHttpClient.Companion;
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public static void setActivateSignConfig(List<String> list, List<String> list2) {
        if (list != null && list.size() > 0) {
            d.addAllAbsent(list);
        }
        if (list2 == null || list2.size() <= 0) {
            return;
        }
        e.addAllAbsent(list2);
    }

    public static void setOkHttpClient(OkHttpClient okHttpClient) {
        if (okHttpClient != null) {
            b = okHttpClient;
        }
    }
}
