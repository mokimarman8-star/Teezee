package com.transsion.gslb;

import android.text.TextUtils;
import android.util.Log;
import com.transsion.gslb.GslbSdk;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public class DomainManager {
    public static final String BLANK_DOMAIN = "blank";
    public static volatile DomainManager INSTANCE;
    public String filePath;
    public long lastSyncTime;
    public String sp_name = "gslb_";
    public String lastGaid = BuildConfig.FLAVOR;
    public String countryCode = BuildConfig.FLAVOR;
    public long firstSyncTryTime = 0;
    public long syncTimes = 0;
    public final long SYNC_TRY_TIMES = 4;
    public final String SEPARATOR = "&";
    public Map<String, String> domainMap = new ConcurrentHashMap();
    public List<ListenerBean> listenerBeans = new ArrayList();
    public long syncInterval = 86400000;

    public DomainManager() {
        this.sp_name += Utils.getCurProcessName(GslbSdk.getContext());
        this.filePath = GslbSdk.getContext().getFilesDir().getPath() + File.separator + this.sp_name;
        read();
        if (this.domainMap.size() == 0) {
            this.domainMap.put("dsu.shalltry.com", BLANK_DOMAIN);
            this.domainMap.put("dsc.shalltry.com", BLANK_DOMAIN);
            this.domainMap.put("api.twibida.com", BLANK_DOMAIN);
        }
        checkSync();
    }

    public static DomainManager getInstance() {
        if (INSTANCE == null) {
            synchronized (DomainManager.class) {
                try {
                    if (INSTANCE == null) {
                        INSTANCE = new DomainManager();
                    }
                } finally {
                }
            }
        }
        return INSTANCE;
    }

    private boolean isDomain(String str) {
        return (TextUtils.isEmpty(str) || str.equals(BLANK_DOMAIN)) ? false : true;
    }

    private void read() {
        String[] split = Utils.bufferRead(new File(this.filePath)).split("&");
        if (split.length < 4) {
            return;
        }
        try {
            this.domainMap = Utils.stringToMap(split[0]);
            this.lastGaid = split[1];
            this.syncInterval = Long.parseLong(split[2]);
            this.lastSyncTime = Long.parseLong(split[3]);
            this.countryCode = split[4];
        } catch (Throwable unused) {
        }
    }

    private void write() {
        Utils.bufferSave(this.filePath, Utils.mapToString(this.domainMap) + "&" + this.lastGaid + "&" + this.syncInterval + "&" + this.lastSyncTime + "&" + this.countryCode);
    }

    public void addListener(ListenerBean listenerBean) {
        GslbSdk.ResultListener resultListener;
        GslbSdk.GetDomainListener getDomainListener;
        GslbSdk.ResultListener resultListener2;
        GslbSdk.GetDomainListener getDomainListener2;
        GslbSdk.InitListener initListener;
        GslbSdk.GslbInitListener gslbInitListener;
        GslbSdk.InitListener initListener2;
        GslbSdk.GslbInitListener gslbInitListener2;
        if (listenerBean.domains == null) {
            String str = listenerBean.url;
            if (str != null && listenerBean.resultListener != null) {
                String domain = Utils.getDomain(str);
                String str2 = this.domainMap.get(domain);
                if (!isDomain(str2)) {
                    this.listenerBeans.add(listenerBean);
                    return;
                }
                boolean z = listenerBean.isNewDomainListener;
                if (z && (getDomainListener2 = listenerBean.gslbDomainListener) != null) {
                    getDomainListener2.onGslbSuccess(listenerBean.url.replace(domain, str2));
                    return;
                } else {
                    if (z || (resultListener2 = listenerBean.resultListener) == null) {
                        return;
                    }
                    resultListener2.onGslbSuccess(listenerBean.url.replace(domain, str2));
                    return;
                }
            }
            if (str == null || listenerBean.gslbDomainListener == null) {
                return;
            }
            String domain2 = Utils.getDomain(str);
            String str3 = this.domainMap.get(domain2);
            if (!isDomain(str3)) {
                this.listenerBeans.add(listenerBean);
                return;
            }
            boolean z2 = listenerBean.isNewDomainListener;
            if (z2 && (getDomainListener = listenerBean.gslbDomainListener) != null) {
                getDomainListener.onGslbSuccess(listenerBean.url.replace(domain2, str3));
                return;
            } else {
                if (z2 || (resultListener = listenerBean.resultListener) == null) {
                    return;
                }
                resultListener.onGslbSuccess(listenerBean.url.replace(domain2, str3));
                return;
            }
        }
        boolean z3 = true;
        int i = 0;
        boolean z4 = false;
        boolean z5 = false;
        while (true) {
            String[] strArr = listenerBean.domains;
            if (i >= strArr.length) {
                break;
            }
            strArr[i] = Utils.getDomain(strArr[i]);
            if (!TextUtils.isEmpty(listenerBean.domains[i])) {
                String str4 = this.domainMap.get(listenerBean.domains[i]);
                if (str4 == null) {
                    this.domainMap.put(listenerBean.domains[i], BLANK_DOMAIN);
                    z4 = true;
                } else if (!isDomain(str4)) {
                    z5 = true;
                }
                z3 = false;
            }
            i++;
        }
        if (z3) {
            boolean z6 = listenerBean.isNewInitListener;
            if (z6 && (gslbInitListener2 = listenerBean.gslbInitListener) != null) {
                gslbInitListener2.onInitFail("all domains are empty");
            } else if (!z6 && (initListener2 = listenerBean.initListener) != null) {
                initListener2.onInitFail();
            }
        } else if (z4) {
            write();
        } else if (!z5 && !TextUtils.isEmpty(getCountry())) {
            boolean z7 = listenerBean.isNewInitListener;
            if (z7 && (gslbInitListener = listenerBean.gslbInitListener) != null) {
                gslbInitListener.onInitSuccess(new HashMap(this.domainMap));
                return;
            } else {
                if (z7 || (initListener = listenerBean.initListener) == null) {
                    return;
                }
                initListener.onInitSuccess(new HashMap(this.domainMap));
                return;
            }
        }
        this.listenerBeans.add(listenerBean);
    }

    public void checkAllListener() {
        for (ListenerBean listenerBean : this.listenerBeans) {
            if (listenerBean.domains != null) {
                boolean z = false;
                int i = 0;
                while (true) {
                    String[] strArr = listenerBean.domains;
                    if (i >= strArr.length) {
                        break;
                    }
                    if (this.domainMap.containsKey(strArr[i]) && !isDomain(this.domainMap.get(listenerBean.domains[i]))) {
                        z = true;
                        break;
                    }
                    i++;
                }
                GslbSdk.InitListener initListener = listenerBean.initListener;
                if (initListener != null) {
                    if (z) {
                        initListener.onInitFail();
                    } else {
                        initListener.onInitSuccess(new HashMap(this.domainMap));
                    }
                }
            } else {
                String str = listenerBean.url;
                if (str != null && listenerBean.resultListener != null) {
                    String domain = Utils.getDomain(str);
                    String str2 = this.domainMap.get(domain);
                    if (isDomain(str2)) {
                        listenerBean.resultListener.onGslbSuccess(listenerBean.url.replace(domain, str2));
                    } else {
                        listenerBean.resultListener.onGslbFail();
                    }
                }
            }
        }
        this.listenerBeans.clear();
    }

    public void checkSync() {
        Worker worker;
        long currentTimeMillis = System.currentTimeMillis();
        if (Math.abs(this.firstSyncTryTime - currentTimeMillis) > 86400000) {
            this.syncTimes = 0L;
        }
        long j = this.lastSyncTime;
        if (j <= 0 || Math.abs(currentTimeMillis - j) <= this.syncInterval) {
            return;
        }
        long j2 = this.syncTimes;
        if (j2 == 0) {
            this.firstSyncTryTime = currentTimeMillis;
        }
        if (j2 < 4 && (worker = GslbSdk.getWorker()) != null) {
            worker.syncData();
        }
        this.syncTimes++;
    }

    public List<String> getAllDomains() {
        ArrayList arrayList = new ArrayList();
        Iterator<Map.Entry<String, String>> it = this.domainMap.entrySet().iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getKey());
        }
        return arrayList;
    }

    public List<String> getBlankDomains() {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, String> entry : this.domainMap.entrySet()) {
            if (!isDomain(entry.getValue())) {
                arrayList.add(entry.getKey());
            }
        }
        return arrayList;
    }

    public String getCountry() {
        return this.countryCode;
    }

    public String getDomain(String str) {
        String str2 = this.domainMap.get(str);
        checkSync();
        return str2;
    }

    public String getLastGaid() {
        return this.lastGaid;
    }

    public void mergeResult(Map<String, String> map, boolean z) {
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (!isDomain(this.domainMap.get(entry.getKey())) || z) {
                this.domainMap.put(entry.getKey(), entry.getValue());
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:133:0x0189, code lost:
    
        if (r2.isNewDomainListener == false) goto L154;
     */
    /* JADX WARN: Code restructure failed: missing block: B:135:0x018b, code lost:
    
        r2 = r2.gslbDomainListener;
     */
    /* JADX WARN: Code restructure failed: missing block: B:136:0x018d, code lost:
    
        if (r2 == null) goto L155;
     */
    /* JADX WARN: Code restructure failed: missing block: B:138:0x018f, code lost:
    
        r2.onGslbFail("get domain exception " + r0.toString());
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x00f1, code lost:
    
        if (r1.isNewDomainListener == false) goto L118;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00f5, code lost:
    
        if (r1.gslbDomainListener == null) goto L119;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00f7, code lost:
    
        r2 = com.transsion.gslb.Utils.getDomain(r2);
        r3 = r10.domainMap.get(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0107, code lost:
    
        if (isDomain(r3) == false) goto L114;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0116, code lost:
    
        r1.gslbDomainListener.onGslbFail("the mapping result is empty for " + r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0109, code lost:
    
        r1.gslbDomainListener.onGslbSuccess(r1.url.replace(r2, r3));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void notifyListener() {
        GslbSdk.ResultListener resultListener;
        GslbSdk.GslbInitListener gslbInitListener;
        GslbSdk.InitListener initListener;
        try {
            Iterator<ListenerBean> it = this.listenerBeans.iterator();
            while (it.hasNext()) {
                ListenerBean next = it.next();
                boolean z = next.isNewInitListener;
                int i = 0;
                if (!z && next.initListener != null) {
                    String[] strArr = next.domains;
                    int length = strArr.length;
                    boolean z2 = false;
                    while (i < length) {
                        String str = strArr[i];
                        if (!TextUtils.isEmpty(str) && !isDomain(this.domainMap.get(str))) {
                            z2 = true;
                        }
                        i++;
                    }
                    if (z2) {
                        next.initListener.onInitFail();
                    } else if (!TextUtils.isEmpty(getCountry())) {
                        next.initListener.onInitSuccess(new HashMap(this.domainMap));
                    }
                } else if (!z || next.gslbInitListener == null) {
                    String str2 = next.url;
                    if (str2 != null && !next.isNewDomainListener && next.resultListener != null) {
                        String domain = Utils.getDomain(str2);
                        String str3 = this.domainMap.get(domain);
                        if (isDomain(str3)) {
                            next.resultListener.onGslbSuccess(next.url.replace(domain, str3));
                        } else {
                            next.resultListener.onGslbFail();
                        }
                    }
                } else {
                    String[] strArr2 = next.domains;
                    int length2 = strArr2.length;
                    String str4 = BuildConfig.FLAVOR;
                    boolean z3 = false;
                    while (i < length2) {
                        String str5 = strArr2[i];
                        if (!TextUtils.isEmpty(str5) && !isDomain(this.domainMap.get(str5))) {
                            z3 = true;
                            str4 = str5;
                        }
                        i++;
                    }
                    if (z3) {
                        next.gslbInitListener.onInitFail("domain map not found for " + str4);
                    } else if (!TextUtils.isEmpty(getCountry())) {
                        next.gslbInitListener.onInitSuccess(new HashMap(this.domainMap));
                    }
                }
            }
            this.listenerBeans.clear();
        } catch (Exception e) {
            e.printStackTrace();
            Iterator<ListenerBean> it2 = this.listenerBeans.iterator();
            while (it2.hasNext()) {
                ListenerBean next2 = it2.next();
                boolean z4 = next2.isNewInitListener;
                if (!z4 && (initListener = next2.initListener) != null) {
                    initListener.onInitFail();
                } else if (!z4 || (gslbInitListener = next2.gslbInitListener) == null) {
                    String str6 = next2.url;
                    if (str6 != null && !next2.isNewDomainListener && (resultListener = next2.resultListener) != null) {
                        resultListener.onGslbFail();
                    }
                } else {
                    gslbInitListener.onInitFail("get domain exception " + e.toString());
                }
            }
            this.listenerBeans.clear();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0043, code lost:
    
        if (r2.isNewDomainListener == false) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0045, code lost:
    
        r2 = r2.gslbDomainListener;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0047, code lost:
    
        if (r2 == null) goto L78;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0049, code lost:
    
        r2.onGslbFail("no network");
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x00af, code lost:
    
        if (r2.isNewDomainListener == false) goto L99;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x00b1, code lost:
    
        r2 = r2.gslbDomainListener;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x00b3, code lost:
    
        if (r2 == null) goto L100;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x00b5, code lost:
    
        r2.onGslbFail("get domain exception " + r0.toString());
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void notifyNoNetwork() {
        GslbSdk.ResultListener resultListener;
        GslbSdk.GslbInitListener gslbInitListener;
        GslbSdk.InitListener initListener;
        GslbSdk.ResultListener resultListener2;
        try {
            ArrayList arrayList = new ArrayList();
            Iterator<ListenerBean> it = this.listenerBeans.iterator();
            while (it.hasNext()) {
                ListenerBean next = it.next();
                boolean z = next.isNewInitListener;
                if (!z && next.initListener != null) {
                    arrayList.add(next);
                } else if (!z || next.gslbInitListener == null) {
                    String str = next.url;
                    if (str != null && !next.isNewDomainListener && (resultListener2 = next.resultListener) != null) {
                        resultListener2.onGslbFail();
                    }
                } else {
                    arrayList.add(next);
                }
            }
            this.listenerBeans.clear();
            this.listenerBeans.addAll(arrayList);
        } catch (Exception e) {
            e.printStackTrace();
            Iterator<ListenerBean> it2 = this.listenerBeans.iterator();
            while (it2.hasNext()) {
                ListenerBean next2 = it2.next();
                boolean z2 = next2.isNewInitListener;
                if (!z2 && (initListener = next2.initListener) != null) {
                    initListener.onInitFail();
                } else if (!z2 || (gslbInitListener = next2.gslbInitListener) == null) {
                    String str2 = next2.url;
                    if (str2 != null && !next2.isNewDomainListener && (resultListener = next2.resultListener) != null) {
                        resultListener.onGslbFail();
                    }
                } else {
                    gslbInitListener.onInitFail("get domain exception " + e.toString());
                }
            }
            this.listenerBeans.clear();
        }
    }

    public void reset() {
        this.domainMap.clear();
        this.domainMap.put("dsu.shalltry.com", BLANK_DOMAIN);
        this.domainMap.put("dsc.shalltry.com", BLANK_DOMAIN);
        this.domainMap.put("api.twibida.com", BLANK_DOMAIN);
    }

    public boolean reset(String str) {
        try {
            this.domainMap.remove(str);
            return true;
        } catch (Exception e) {
            Utils.LOG.i("reset exception" + e.toString());
            return false;
        }
    }

    public void setCountryCode(String str) {
        this.countryCode = str;
    }

    public void setLastGaid(String str) {
        this.lastGaid = str;
    }

    public void setSyncInterval(long j) {
        this.syncInterval = j;
        if (j < 86400000) {
            this.syncInterval = 86400000L;
        }
        this.lastSyncTime = System.currentTimeMillis();
    }

    public boolean updateNetData(String str, String str2) {
        boolean z;
        String str3;
        setLastGaid(str2);
        try {
            JSONObject jSONObject = new JSONObject(str);
            int i = jSONObject.getInt("code");
            String string = jSONObject.getString("message");
            if (i != 200) {
                Utils.LOG.i("error message is " + string);
                return false;
            }
            HashMap hashMap = new HashMap(4);
            long j = 86400000;
            try {
                JSONObject jSONObject2 = jSONObject.getJSONObject("data");
                JSONObject jSONObject3 = jSONObject2.getJSONObject("domainPairs");
                z = jSONObject2.getBoolean("overrideFlag");
                try {
                    j = jSONObject2.getInt("expireTime");
                    Iterator<String> keys = jSONObject3.keys();
                    while (keys.hasNext()) {
                        String valueOf = String.valueOf(keys.next());
                        hashMap.put(valueOf, jSONObject3.getString(valueOf));
                    }
                    str3 = jSONObject2.getString("country");
                } catch (Exception e) {
                    e = e;
                    Utils.LOG.i(Log.getStackTraceString(e));
                    str3 = BuildConfig.FLAVOR;
                    mergeResult(hashMap, z);
                    setSyncInterval(j);
                    setCountryCode(str3);
                    write();
                    return true;
                }
            } catch (Exception e2) {
                e = e2;
                z = false;
            }
            mergeResult(hashMap, z);
            setSyncInterval(j);
            setCountryCode(str3);
            write();
            return true;
        } catch (JSONException e3) {
            e3.printStackTrace();
            return false;
        }
    }
}
