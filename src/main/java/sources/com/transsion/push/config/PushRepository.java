package com.transsion.push.config;

import android.text.TextUtils;
import android.util.Base64;
import com.transsion.core.utils.f;
import com.transsion.crypto.TCrypterSdk;
import com.transsion.gslb.GslbSdk;
import com.transsion.json.b;
import com.transsion.push.IClientIdListener;
import com.transsion.push.ITopicListener;
import com.transsion.push.PushManager;
import com.transsion.push.bean.ConfigInfo;
import com.transsion.push.bean.SelfDestroyInfo;
import com.transsion.push.tracker.Tracker;
import com.transsion.push.utils.FirebaseUtils;
import com.transsion.push.utils.PushLogUtils;
import com.transsion.push.utils.PushUtils;
import com.transsion.push.utils.ThreadManager;
import com.transsion.push.utils.g0;
import com.transsion.push.utils.k0;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import yj.a;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public final class PushRepository implements IDataSource {
    private static PushRepository e = null;
    private static long f = -1;
    private static long g = -1;
    private f a;
    private a b;
    private ConfigInfo.Config c;
    private String d;

    private PushRepository() {
        try {
            this.a = f.e("sp_push");
        } catch (Exception unused) {
        }
        this.b = new a();
    }

    private void c() {
        int intValue = ((Integer) getSpValue("retry_count", 0)).intValue();
        int c = g0.c();
        PushLogUtils.LOG.g("Reporting Failure, Retry Reporting,retryCount：" + intValue + ", max retryCount：" + c);
        if (intValue < c) {
            putSpValue("retry_count", Integer.valueOf(intValue + 1));
            saveReportTime(System.currentTimeMillis() + g0.d());
        } else {
            PushLogUtils.LOG.g("More than the maximum number of retries");
            saveReportTime(System.currentTimeMillis() + g0.b());
            putSpValue("retry_count", 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(IClientIdListener iClientIdListener) {
        if (this.b != null) {
            ThreadManager.executeInBackground(new 4(this, iClientIdListener));
            return;
        }
        if (iClientIdListener != null) {
            iClientIdListener.onFail("mRemoteDataSource is null");
        }
        PushLogUtils.LOG.z("mRemoteDataSource is null");
    }

    public static synchronized PushRepository getInstance() {
        PushRepository pushRepository;
        synchronized (PushRepository.class) {
            try {
                if (e == null) {
                    e = new PushRepository();
                }
                pushRepository = e;
            } catch (Throwable th) {
                throw th;
            }
        }
        return pushRepository;
    }

    @Override // com.transsion.push.config.IDataSource
    public void getClientId(IClientIdListener iClientIdListener) {
        PushLogUtils.LOG.g("get client id");
        String str = (String) getSpValue("push_client_id", "");
        if (!TextUtils.isEmpty(str) && iClientIdListener != null) {
            iClientIdListener.onSuccess(str);
        } else if (TextUtils.isEmpty((CharSequence) getSpValue("push_token", ""))) {
            FirebaseUtils.d(new a(this, iClientIdListener));
        } else {
            d(iClientIdListener);
        }
    }

    @Override // com.transsion.push.config.IDataSource
    public ConfigInfo.Config getConfig() {
        ConfigInfo.Config config = this.c;
        if (config != null) {
            return config;
        }
        f fVar = this.a;
        if (fVar == null) {
            return null;
        }
        String j = fVar.j("push_config", (String) null);
        if (TextUtils.isEmpty(j)) {
            return null;
        }
        try {
            return (ConfigInfo.Config) b.a(new String(Base64.decode(j, 0)), ConfigInfo.Config.class);
        } catch (Exception e3) {
            PushLogUtils.LOG.i("get config fail, e:" + e3.getMessage());
            return null;
        }
    }

    public long getLastTpmsReportTime() {
        long currentTimeMillis = System.currentTimeMillis() - 1;
        long j = g;
        if (j > 0) {
            return j;
        }
        f fVar = this.a;
        if (fVar == null) {
            return currentTimeMillis;
        }
        g = fVar.h("report_tpms_active_time", 0L);
        PushLogUtils.LOG.g("sLocalTpmsReportTime" + g);
        if (g <= 0) {
            this.a.o("report_tpms_active_time", currentTimeMillis);
            g = currentTimeMillis;
        }
        return g;
    }

    @Override // com.transsion.push.config.IDataSource
    public long getReportTime() {
        long currentTimeMillis = System.currentTimeMillis() - 1;
        long j = f;
        if (j > 0) {
            return j;
        }
        f fVar = this.a;
        if (fVar == null) {
            return currentTimeMillis;
        }
        long h = fVar.h("report_active_time", 0L);
        f = h;
        if (h <= 0) {
            this.a.o("report_active_time", currentTimeMillis);
            f = currentTimeMillis;
        }
        return f;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.transsion.push.config.IDataSource
    public <T> T getSpValue(String str, T t) {
        f fVar = this.a;
        if (fVar == null) {
            return t;
        }
        try {
            if (t instanceof String) {
                return (T) fVar.j(str, (String) t);
            }
            if (t instanceof Boolean) {
                return (T) Boolean.valueOf(fVar.c(str, ((Boolean) t).booleanValue()));
            }
            if (t instanceof Integer) {
                return (T) Integer.valueOf(fVar.f(str, ((Integer) t).intValue()));
            }
            if (t instanceof Long) {
                return (T) Long.valueOf(fVar.h(str, ((Long) t).longValue()));
            }
            if (t instanceof Float) {
                return (T) Float.valueOf(fVar.d(str, ((Float) t).floatValue()));
            }
            if (t instanceof Set) {
                return (T) fVar.k(str, new HashSet());
            }
            PushLogUtils.LOG.i("Type of " + t.getClass().getSimpleName() + " is not supported.");
            return t;
        } catch (ClassCastException e3) {
            PushLogUtils.LOG.i("Type of default value is not match with value stored." + System.lineSeparator() + e3.getMessage());
            return t;
        }
    }

    @Override // com.transsion.push.config.IDataSource
    public ConfigInfo.Whitelist getWhiteList() {
        if (!TextUtils.isEmpty(this.d)) {
            try {
                return (ConfigInfo.Whitelist) b.a(this.d, ConfigInfo.Whitelist.class);
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
        try {
            String a = TCrypterSdk.a(a.a(), "push_white_list");
            if (TextUtils.isEmpty(a)) {
                return null;
            }
            this.d = a;
            return (ConfigInfo.Whitelist) b.a(a, ConfigInfo.Whitelist.class);
        } catch (Exception e4) {
            PushLogUtils.LOG.i("get white list fail, e:" + e4.getMessage());
            return null;
        }
    }

    @Override // com.transsion.push.config.IDataSource
    public boolean isReported() {
        f fVar = this.a;
        if (fVar == null) {
            return false;
        }
        try {
            return fVar.b("report_active_success");
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // com.transsion.push.config.IDataSource
    public void putSpValue(String str, Object obj) {
        f fVar = this.a;
        if (fVar == null) {
            return;
        }
        try {
            if (obj instanceof String) {
                fVar.p(str, (String) obj);
            } else if (obj instanceof Boolean) {
                fVar.l(str, ((Boolean) obj).booleanValue());
            } else if (obj instanceof Integer) {
                fVar.n(str, ((Integer) obj).intValue());
            } else if (obj instanceof Long) {
                fVar.o(str, ((Long) obj).longValue());
            } else if (obj instanceof Float) {
                fVar.m(str, ((Float) obj).floatValue());
            } else if (obj instanceof Set) {
                fVar.q(str, (Set) obj);
            }
        } catch (Exception e3) {
            PushLogUtils.LOG.i("put sp, Type of default value is not match with value stored." + System.lineSeparator() + e3.getMessage());
        }
    }

    @Override // com.transsion.push.config.IDataSource
    public void removeSpValue(String str) {
        try {
            f fVar = this.a;
            if (fVar != null) {
                fVar.r(str);
            }
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    @Override // com.transsion.push.config.IDataSource
    public void saveConfig(ConfigInfo.Config config) {
        f fVar;
        if (config == null || (fVar = this.a) == null) {
            return;
        }
        try {
            this.c = config;
            fVar.p("push_config", new String(Base64.encode(b.b(config).getBytes(), 0)));
        } catch (Exception e3) {
            PushLogUtils.LOG.i("save config fail, e:" + e3.getMessage());
        }
    }

    @Override // com.transsion.push.config.IDataSource
    public void saveReportTime(long j) {
        if (this.a == null) {
            return;
        }
        PushLogUtils.LOG.g("Update reporting time，reportTime:" + j);
        f = j;
        this.a.o("report_active_time", j);
    }

    public void saveTpmsReportTime(long j) {
        if (this.a == null) {
            return;
        }
        PushLogUtils.LOG.g("Update reporting time，reportTime:" + j);
        g = j;
        this.a.o("report_tpms_active_time", j);
    }

    @Override // com.transsion.push.config.IDataSource
    public void saveWhiteList(ConfigInfo.Whitelist whitelist) {
        List<ConfigInfo.Apps> list;
        if (whitelist == null || (list = whitelist.apps) == null || list.size() == 0) {
            return;
        }
        try {
            if (TextUtils.isEmpty(this.d)) {
                this.d = b.b(whitelist);
                TCrypterSdk.c(a.a(), "push_white_list", this.d);
                return;
            }
            List<ConfigInfo.Apps> list2 = ((ConfigInfo.Whitelist) b.a(this.d, ConfigInfo.Whitelist.class)).apps;
            for (ConfigInfo.Apps apps : whitelist.apps) {
                if (!list2.contains(apps)) {
                    list2.add(apps);
                }
            }
            ConfigInfo.Whitelist whitelist2 = new ConfigInfo.Whitelist();
            whitelist2.version = whitelist.version;
            whitelist2.apps = new ArrayList(list2);
            this.d = b.b(whitelist2);
            TCrypterSdk.c(a.a(), "push_white_list", this.d);
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    @Override // com.transsion.push.config.IDataSource
    public void subscribeToTopic(String str, ITopicListener iTopicListener) {
        if (TextUtils.isEmpty(str)) {
            if (iTopicListener != null) {
                iTopicListener.onFail("subscribe topic is empty");
                PushLogUtils.LOG.i("subscribe topic is empty");
                return;
            }
            return;
        }
        if (!TextUtils.isEmpty((CharSequence) getInstance().getSpValue("push_client_id", ""))) {
            ThreadManager.executeInBackground(new 1(this, str, iTopicListener));
        } else if (iTopicListener != null) {
            iTopicListener.onFail("subscribe clientId is empty");
            PushLogUtils.LOG.i("subscribe clientId is empty");
        }
    }

    @Override // com.transsion.push.config.IDataSource
    public void syncActive() {
        ConfigInfo.Whitelist whitelist;
        ConfigInfo.Config config;
        if (TextUtils.isEmpty((CharSequence) getSpValue("push_token", ""))) {
            PushLogUtils.LOG.z("Token is empty");
            return;
        }
        if (this.b == null) {
            PushLogUtils.LOG.z("mRemoteDataSource is null");
            return;
        }
        if (!PushManager.getInstance().getDebug() && !PushManager.getInstance().getTestEnv() && !GslbSdk.isInitSuccess("https://api.twibida.com/tcm/v2/instance/")) {
            GslbSdk.getDomain("https://api.twibida.com/tcm/v2/instance/", true);
        }
        ConfigInfo f2 = this.b.f();
        if (f2 == null) {
            PushLogUtils.LOG.g("syncActive onFail");
            if (TextUtils.isEmpty((CharSequence) getSpValue("push_client_id", ""))) {
                return;
            }
            c();
            return;
        }
        putSpValue("retry_count", 0);
        PushLogUtils.LOG.g("get config response data: " + f2.toString());
        putSpValue("push_is_next_with_app", Boolean.valueOf(f2.nextWithApp));
        putSpValue("push_is_report_detail", Boolean.valueOf(f2.nextWithDetail));
        putSpValue("push_client_id", f2.clientId);
        putSpValue("push_start_point_report", Boolean.valueOf(f2.startPointReport));
        k0.f(f2.destroyAppIds, f2.syncInfoInterval);
        PushUtils.w();
        if (f2.configRefresh && (config = f2.config) != null && config.version > 0) {
            saveConfig(config);
            putSpValue("push_self_destroying", Integer.valueOf(f2.config.destroy));
        }
        if (f2.whitelistRefresh && (whitelist = f2.whitelist) != null && whitelist.version > 0) {
            saveWhiteList(whitelist);
        }
        saveReportTime(System.currentTimeMillis() + g0.b());
        putSpValue("report_active_success", Boolean.TRUE);
    }

    @Override // com.transsion.push.config.IDataSource
    public void syncSelfDestroying() {
        if (this.b == null) {
            PushLogUtils.LOG.z("mRemoteDataSource is null");
            return;
        }
        if (!PushManager.getInstance().getDebug() && !PushManager.getInstance().getTestEnv() && !GslbSdk.isInitSuccess("https://api.twibida.com/tcm/v2/instance/")) {
            PushLogUtils.LOG.z("gslb not inited");
            return;
        }
        Tracker.getInstance().trackReport();
        SelfDestroyInfo e3 = this.b.e();
        if (e3 == null) {
            PushLogUtils.LOG.i("sync self-destroying fail");
            putSpValue("push_self_destroying_time", Long.valueOf(System.currentTimeMillis() + g0.e()));
            return;
        }
        PushLogUtils.LOG.g("get self-destroying response data: " + e3.toString());
        putSpValue("push_self_destroying", Integer.valueOf(e3.destroy));
        putSpValue("push_self_destroying_interval", Integer.valueOf(e3.interval));
        putSpValue("push_self_destroying_time", Long.valueOf(System.currentTimeMillis() + g0.e()));
    }

    @Override // com.transsion.push.config.IDataSource
    public void unsubscribeFromTopic(String str, ITopicListener iTopicListener) {
        if (TextUtils.isEmpty(str)) {
            if (iTopicListener != null) {
                iTopicListener.onFail("unsubscribe topic is empty");
                PushLogUtils.LOG.i("unsubscribe topic is empty");
                return;
            }
            return;
        }
        if (!TextUtils.isEmpty((CharSequence) getInstance().getSpValue("push_client_id", ""))) {
            ThreadManager.executeInBackground(new 2(this, str, iTopicListener));
        } else if (iTopicListener != null) {
            iTopicListener.onFail("unsubscribe clientId is empty");
            PushLogUtils.LOG.i("unsubscribe clientId is empty");
        }
    }

    @Override // com.transsion.push.config.IDataSource
    public void updateNewToken(String str) {
        putSpValue("push_token", str);
        putSpValue("push_is_report_detail", Boolean.TRUE);
        putSpValue("report_active_success", Boolean.FALSE);
    }
}
