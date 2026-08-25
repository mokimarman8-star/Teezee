package com.transsion.sdk.oneid;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import bz.g;
import bz.h;
import bz.i;
import bz.j;
import bz.l;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.hisavana.common.constant.ComConstants;
import com.transsion.gslb.GslbSdk;
import com.transsion.sdk.oneid.data.AppIdInfo;
import com.transsion.sdk.oneid.data.GroupFpInfo;
import com.transsion.sdk.oneid.data.GroupHashInfo;
import com.transsion.sdk.oneid.data.IdChangeInfo;
import com.transsion.sdk.oneid.data.OdIdInfo;
import com.transsion.sdk.oneid.data.UniqueIdInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONObject;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public class e implements Handler.Callback {
    private static volatile e n;
    private Handler a;
    private GroupFpInfo c;
    private GroupHashInfo d;
    private c g;
    private final Context j;
    private OdIdInfo k;
    private ConcurrentHashMap l;
    private HandlerThread b = null;
    private long e = 0;
    private long f = 0;
    private final ReentrantLock i = new ReentrantLock();
    private final AtomicBoolean m = new AtomicBoolean(false);
    private final List h = new CopyOnWriteArrayList();

    class a extends TypeToken<ConcurrentHashMap<Integer, AppIdInfo>> {
        a(e eVar) {
        }
    }

    class b extends TypeToken<ConcurrentHashMap<Integer, AppIdInfo>> {
        b(e eVar) {
        }
    }

    private e(Context context) {
        this.j = context;
        j();
        Handler handler = this.a;
        if (handler != null) {
            handler.sendEmptyMessage(200);
        }
    }

    public static e a(Context context) {
        if (n == null) {
            synchronized (e.class) {
                try {
                    if (n == null) {
                        n = new e(context);
                    }
                } finally {
                }
            }
        }
        return n;
    }

    private void c(int i, AppIdInfo appIdInfo) {
        if (com.transsion.sdk.oneid.b.q(this.j)) {
            com.transsion.sdk.oneid.b.i("onOdidRequestRetry");
            appIdInfo.retryTimes++;
            long j = appIdInfo.retryRequestDelay;
            if (j == 0) {
                appIdInfo.retryRequestDelay = 3000L;
            } else {
                appIdInfo.retryRequestDelay = Math.min((j * 2) + 1000, 600000L);
            }
            Message obtain = Message.obtain(this.a, 303);
            obtain.obj = appIdInfo;
            obtain.arg1 = i;
            this.a.sendMessageDelayed(obtain, appIdInfo.retryRequestDelay);
        }
    }

    private void d(Message message) {
        if (com.transsion.sdk.oneid.b.q(this.j)) {
            long j = this.e;
            if (j == 0) {
                this.e = 3000L;
            } else {
                this.e = Math.min((j * 2) + 1000, 600000L);
            }
            this.a.sendMessageDelayed(message, this.e);
        }
    }

    private void f(String str) {
        com.transsion.sdk.oneid.b.i("onFpPostComplete");
        this.f = System.currentTimeMillis();
        try {
            bz.b b2 = bz.b.b(this.j);
            b2.c("last_post_time", Long.valueOf(this.f / 1000).intValue());
            if (TextUtils.isEmpty(str)) {
                return;
            }
            b2.d("fp_hash", str);
        } catch (Exception e) {
            com.transsion.sdk.oneid.b.m(Log.getStackTraceString(e));
        }
    }

    private void g(String str, int i, AppIdInfo appIdInfo) {
        com.transsion.sdk.oneid.b.i("onOdidRequestComplete appId : " + i);
        try {
            JSONObject jSONObject = new JSONObject(str);
            jSONObject.optInt("code", 0);
            String optString = jSONObject.optString("msg", "");
            long optLong = jSONObject.optLong("time", 0L);
            appIdInfo.odid = jSONObject.optString("odid", "");
            appIdInfo.retryTimes = 0;
            appIdInfo.retryRequestDelay = 0L;
            appIdInfo.lastRequestTime = System.currentTimeMillis();
            long j = optLong * 1000;
            appIdInfo.waitTime = j;
            appIdInfo.msg = optString;
            bz.b b2 = bz.b.b(this.j);
            String json = new Gson().toJson(this.l, new b(this).getType());
            com.transsion.sdk.oneid.b.i("appIdInfoListJson : " + json);
            b2.g("appid_info_list", json);
            Message obtain = Message.obtain(this.a, 303);
            obtain.obj = appIdInfo;
            obtain.arg1 = i;
            this.a.sendMessageDelayed(obtain, j);
        } catch (Exception e) {
            com.transsion.sdk.oneid.b.m(Log.getStackTraceString(e));
        }
    }

    private void j() {
        Handler handler;
        if (this.i.tryLock()) {
            try {
                try {
                    handler = this.a;
                } catch (Exception e) {
                    com.transsion.sdk.oneid.b.m(Log.getStackTraceString(e));
                }
                if (handler != null && this.b != null) {
                    if (handler.hasMessages(201)) {
                        this.a.removeMessages(201);
                    }
                    this.i.unlock();
                }
                HandlerThread handlerThread = new HandlerThread("OneID Worker", 10);
                this.b = handlerThread;
                handlerThread.start();
                this.a = new Handler(this.b.getLooper(), this);
                this.i.unlock();
            } catch (Throwable th) {
                this.i.unlock();
                throw th;
            }
        }
    }

    private void k() {
        ConcurrentHashMap concurrentHashMap = this.l;
        if (concurrentHashMap == null || concurrentHashMap.isEmpty()) {
            String h = bz.b.b(this.j).h("appid_info_list");
            if (!TextUtils.isEmpty(h)) {
                com.transsion.sdk.oneid.b.i("AppId Records : " + h);
                try {
                    this.l = (ConcurrentHashMap) new Gson().fromJson(h, new a(this).getType());
                } catch (Exception e) {
                    com.transsion.sdk.oneid.b.m(Log.getStackTraceString(e));
                }
            }
            if (this.l == null) {
                this.l = new ConcurrentHashMap();
            }
        }
    }

    public void b(int i) {
        com.transsion.sdk.oneid.b.i("Check appId record : " + i);
        HandlerThread handlerThread = this.b;
        if (handlerThread == null || !handlerThread.isAlive()) {
            return;
        }
        Message obtain = Message.obtain(this.a, 304);
        obtain.obj = Integer.valueOf(i);
        if (this.m.get()) {
            this.a.sendMessage(obtain);
        } else {
            this.a.sendMessageDelayed(obtain, OneID.d * 1000);
        }
    }

    public void e(IdChangeInfo idChangeInfo) {
        IdChangeInfo idChangeInfo2;
        com.transsion.sdk.oneid.b.i("onFpIdChanged type = " + idChangeInfo.id_type);
        List list = this.h;
        if (list != null) {
            Iterator it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    idChangeInfo2 = null;
                    break;
                } else {
                    idChangeInfo2 = (IdChangeInfo) it.next();
                    if (idChangeInfo2.id_type.equals(idChangeInfo.id_type)) {
                        break;
                    }
                }
            }
            if (idChangeInfo2 != null) {
                this.h.remove(idChangeInfo2);
            }
            this.h.add(idChangeInfo);
        }
    }

    public String h() {
        try {
            GroupFpInfo groupFpInfo = this.c;
            return groupFpInfo != null ? groupFpInfo.vaid : "";
        } catch (Exception unused) {
            return "";
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        int i;
        GroupFpInfo groupFpInfo;
        int i2;
        long j;
        String str;
        try {
            i = message.what;
        } catch (Exception e) {
            com.transsion.sdk.oneid.b.m(Log.getStackTraceString(e));
        }
        if (i == 100) {
            com.transsion.sdk.oneid.b.i("-->WHAT_GET_PROP_RET");
            String string = message.getData().getString("oneid");
            if (!TextUtils.isEmpty(string) && !TextUtils.equals(string, "UNKNOWN") && (groupFpInfo = this.c) != null) {
                if (TextUtils.isEmpty(groupFpInfo.dids.tsid)) {
                    UniqueIdInfo uniqueIdInfo = this.c.dids;
                    uniqueIdInfo.tsid = string;
                    this.d.updateDidsHash(uniqueIdInfo);
                    this.k.tsid = string;
                    bz.b b2 = bz.b.b(this.j);
                    int intValue = Long.valueOf(System.currentTimeMillis() / 1000).intValue();
                    try {
                        b2.d("oneid", string);
                        b2.c("oneid_time", intValue);
                    } catch (Exception e3) {
                        com.transsion.sdk.oneid.b.m(Log.getStackTraceString(e3));
                    }
                } else if (!TextUtils.equals(this.c.dids.tsid, string)) {
                    e(new IdChangeInfo("tsid", this.c.dids.tsid, string));
                    UniqueIdInfo uniqueIdInfo2 = this.c.dids;
                    uniqueIdInfo2.tsid = string;
                    this.d.updateDidsHash(uniqueIdInfo2);
                    this.k.tsid = string;
                }
            }
            return false;
        }
        if (i == 200) {
            com.transsion.sdk.oneid.b.o();
            if (TextUtils.isEmpty(bz.b.b(this.j).h("one_id_first_launch")) && OneID.d > 0) {
                com.transsion.sdk.oneid.b.i("First launch delay " + OneID.d + " sec init");
                try {
                    Thread.sleep(OneID.d * 1000);
                } catch (InterruptedException unused) {
                }
                bz.b.b(this.j).g("one_id_first_launch", String.valueOf(System.currentTimeMillis()));
            }
            com.transsion.sdk.oneid.b.i("-->WHAT_INIT 2.0.2.1");
            String string2 = this.j.getResources().getString(R$string.oneid_process_name);
            if (TextUtils.isEmpty(string2)) {
                string2 = this.j.getPackageName();
            }
            if (!TextUtils.equals(string2, com.transsion.sdk.oneid.b.k(this.j))) {
                com.transsion.sdk.oneid.b.i("Only works in the main process");
                this.a.sendEmptyMessageDelayed(201, 1000L);
                return false;
            }
            try {
                if (this.g == null) {
                    this.g = new c();
                    this.j.registerReceiver(this.g, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"), null, this.a);
                }
            } catch (Exception e4) {
                com.transsion.sdk.oneid.b.m(Log.getStackTraceString(e4));
            }
            GslbSdk.init(this.j, new String[]{"ire-oneid.shalltry.com", "oneid-dev-sg.shalltry.com"}, (GslbSdk.InitListener) null);
            GroupFpInfo groupFpInfo2 = new GroupFpInfo(this.j, this);
            this.c = groupFpInfo2;
            this.d = new GroupHashInfo(groupFpInfo2);
            this.k = new OdIdInfo(this.c);
            com.transsion.sdk.oneid.b.i("--> new OdidInfo " + this.k);
            if (this.f == 0) {
                this.f = bz.b.b(this.j).a("last_post_time") * 1000;
            }
            long currentTimeMillis = System.currentTimeMillis();
            long j2 = this.f;
            if (currentTimeMillis >= j2 && currentTimeMillis - j2 < ComConstants.REQ_CLOUD_CONFIG_INTERVAL_IF_NEED) {
                com.transsion.sdk.oneid.b.i("Post time not yet reached");
                this.m.set(true);
                return false;
            }
            if (!this.a.hasMessages(300)) {
                Handler handler = this.a;
                if (GslbSdk.isInitSuccess(l.d().c())) {
                    i2 = 300;
                    j = 3000;
                } else {
                    i2 = 300;
                    j = 6000;
                }
                handler.sendEmptyMessageDelayed(i2, j);
            }
            this.m.set(true);
            return false;
        }
        if (i == 201) {
            com.transsion.sdk.oneid.b.i("-->WHAT_QUIT");
            if (this.i.tryLock()) {
                try {
                    HandlerThread handlerThread = this.b;
                    if (handlerThread != null) {
                        handlerThread.quit();
                        this.b = null;
                    }
                    this.i.unlock();
                } catch (Throwable th) {
                    this.i.unlock();
                    throw th;
                }
            }
            return false;
        }
        switch (i) {
            case 300:
                com.transsion.sdk.oneid.b.i("-->WHAT_POST_FP_HASH");
                this.a.removeMessages(300);
                if (OneID.c && com.transsion.sdk.oneid.b.p(this.j)) {
                    if (!GslbSdk.isInitSuccess(l.d().c())) {
                        com.transsion.sdk.oneid.b.i("GslbSdk new domain is not ready");
                        d(Message.obtain(this.a, 300));
                        return false;
                    }
                    try {
                        str = bz.b.b(this.j).f("fp_hash");
                    } catch (Exception unused2) {
                        str = "";
                    }
                    String g = com.transsion.sdk.oneid.b.g(this.d.toString());
                    com.transsion.sdk.oneid.b.i(str + " vs " + g);
                    if (TextUtils.equals(str, g)) {
                        f(null);
                    } else {
                        Message.obtain(this.a, 301, g).sendToTarget();
                    }
                    return false;
                }
                com.transsion.sdk.oneid.b.i("OneID disable or network unavailable");
                this.e = 0L;
                this.a.sendEmptyMessage(201);
                return false;
            case 301:
                com.transsion.sdk.oneid.b.i("-->WHAT_POST_FP_DATA");
                this.a.removeMessages(301);
                if (OneID.c && com.transsion.sdk.oneid.b.p(this.j)) {
                    String str2 = (String) message.obj;
                    i a2 = new g(this.c).a();
                    com.transsion.sdk.oneid.b.i("code = " + a2.a + " data = " + ((String) a2.b));
                    int i3 = a2.a;
                    if (i3 == 0) {
                        this.e = 0L;
                        try {
                            if (new JSONObject((String) a2.b).optInt("code", 0) == 0) {
                                if (this.h.isEmpty()) {
                                    f(str2);
                                } else {
                                    Message.obtain(this.a, 302, str2).sendToTarget();
                                }
                            }
                        } catch (Exception e5) {
                            com.transsion.sdk.oneid.b.m(Log.getStackTraceString(e5));
                        }
                    } else if (i3 != 4) {
                        d(Message.obtain(this.a, 301, str2));
                    }
                    return false;
                }
                com.transsion.sdk.oneid.b.i("OneID disable or network unavailable");
                this.e = 0L;
                this.a.sendEmptyMessage(201);
                return false;
            case 302:
                com.transsion.sdk.oneid.b.i("-->WHAT_POST_ID_CHANGE");
                this.a.removeMessages(302);
                String str3 = (String) message.obj;
                ArrayList arrayList = new ArrayList();
                for (IdChangeInfo idChangeInfo : this.h) {
                    if (!TextUtils.isEmpty(idChangeInfo.pre_id)) {
                        arrayList.add(idChangeInfo);
                    }
                }
                if (arrayList.size() > 0) {
                    try {
                        i a3 = new h(arrayList).a();
                        com.transsion.sdk.oneid.b.i("code = " + a3.a + " data = " + ((String) a3.b));
                        int i4 = a3.a;
                        if (i4 == 0) {
                            this.e = 0L;
                            try {
                                if (new JSONObject((String) a3.b).optInt("code", 0) == 0) {
                                    com.transsion.sdk.oneid.b.h(this.j, this.h);
                                    this.h.clear();
                                    f(str3);
                                }
                            } catch (Exception e6) {
                                com.transsion.sdk.oneid.b.m(Log.getStackTraceString(e6));
                            }
                        } else if (i4 != 4) {
                            d(Message.obtain(this.a, 302, str3));
                        }
                    } catch (Exception e7) {
                        com.transsion.sdk.oneid.b.m(Log.getStackTraceString(e7));
                    }
                } else {
                    if (this.h.size() > 0) {
                        com.transsion.sdk.oneid.b.h(this.j, this.h);
                        this.h.clear();
                    }
                    f(str3);
                }
                return false;
            case 303:
                com.transsion.sdk.oneid.b.i("-->WHAT_REQUEST_ODID");
                int i6 = message.arg1;
                AppIdInfo appIdInfo = (AppIdInfo) message.obj;
                this.a.removeMessages(303, appIdInfo);
                if (OneID.c && com.transsion.sdk.oneid.b.p(this.j)) {
                    OdIdInfo odIdInfo = this.k;
                    if (odIdInfo != null) {
                        odIdInfo.appid = i6;
                        com.transsion.sdk.oneid.b.i("--> mOdidInfo set appID :" + this.k.toString());
                        i a5 = new j(this.k).a();
                        com.transsion.sdk.oneid.b.i("code = " + a5.a + " data = " + ((String) a5.b));
                        int i7 = a5.a;
                        if (i7 == 0) {
                            g((String) a5.b, i6, appIdInfo);
                        } else if (i7 == 3) {
                            com.transsion.sdk.oneid.b.i("onOdidRequestGatewayError");
                            Message obtain = Message.obtain(this.a, 303);
                            obtain.obj = appIdInfo;
                            obtain.arg1 = i6;
                            this.a.sendMessageDelayed(obtain, 1000L);
                        } else if (i7 != 4) {
                            c(i6, appIdInfo);
                        }
                    }
                    return false;
                }
                com.transsion.sdk.oneid.b.i("OneID disable or network unavailable");
                this.a.sendEmptyMessage(201);
                return false;
            case 304:
                Integer num = (Integer) message.obj;
                int intValue2 = num.intValue();
                this.a.removeMessages(304, num);
                if (OneID.c && com.transsion.sdk.oneid.b.p(this.j)) {
                    k();
                    AppIdInfo appIdInfo2 = (AppIdInfo) this.l.get(num);
                    if (appIdInfo2 == null) {
                        appIdInfo2 = new AppIdInfo();
                        this.l.put(num, appIdInfo2);
                        OdIdInfo odIdInfo2 = this.k;
                        if (odIdInfo2 != null) {
                            odIdInfo2.appid = intValue2;
                        }
                    }
                    Message obtain2 = Message.obtain(this.a, 303);
                    obtain2.arg1 = intValue2;
                    obtain2.obj = appIdInfo2;
                    long currentTimeMillis2 = System.currentTimeMillis();
                    long j3 = GslbSdk.isInitSuccess(l.d().c()) ? 3000L : 6000L;
                    long j4 = appIdInfo2.lastRequestTime;
                    if (currentTimeMillis2 >= j4) {
                        long j5 = currentTimeMillis2 - j4;
                        long j6 = appIdInfo2.waitTime;
                        if (j5 < j6) {
                            j3 = Math.max((j4 + j6) - currentTimeMillis2, j3);
                        }
                    }
                    if (!this.a.hasMessages(303, appIdInfo2)) {
                        this.a.sendMessageDelayed(obtain2, j3);
                        com.transsion.sdk.oneid.b.i("Appid : " + intValue2 + " delay " + j3 + " ms refresh odid ");
                    }
                    return false;
                }
                com.transsion.sdk.oneid.b.i("OneID disable or network unavailable");
                this.a.sendEmptyMessage(201);
                return false;
            default:
                return false;
        }
        com.transsion.sdk.oneid.b.m(Log.getStackTraceString(e));
        return false;
    }

    public String i(int i) {
        AppIdInfo appIdInfo;
        String str;
        ConcurrentHashMap concurrentHashMap = this.l;
        return (concurrentHashMap == null || (appIdInfo = (AppIdInfo) concurrentHashMap.get(Integer.valueOf(i))) == null || (str = appIdInfo.odid) == null) ? "" : str;
    }

    public void l() {
        if (com.transsion.sdk.oneid.b.q(this.j)) {
            com.transsion.sdk.oneid.b.i("retry");
            long currentTimeMillis = System.currentTimeMillis();
            boolean z = OneID.c;
            if (z) {
                long j = this.f;
                if (currentTimeMillis < j || currentTimeMillis - j >= ComConstants.REQ_CLOUD_CONFIG_INTERVAL_IF_NEED) {
                    if (this.i.tryLock()) {
                        try {
                            if (this.b == null) {
                                j();
                            }
                        } finally {
                            this.i.unlock();
                        }
                    }
                    Handler handler = this.a;
                    if (handler != null) {
                        handler.removeCallbacksAndMessages(null);
                        this.a.sendEmptyMessage(200);
                        return;
                    }
                    return;
                }
            }
            com.transsion.sdk.oneid.b.i(z ? "Post time not yet reached" : "OneID disable");
        }
    }
}
