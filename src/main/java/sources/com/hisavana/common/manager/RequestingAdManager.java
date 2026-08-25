package com.hisavana.common.manager;

import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.hisavana.common.base.BaseBanner;
import com.hisavana.common.base.LogSwitch;
import com.hisavana.common.interfacz.Iad;
import com.hisavana.common.utils.AdLogUtil;
import com.hisavana.common.utils.AdUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public class RequestingAdManager<T extends Iad> {
    private static final int REQUEST_CONTINUOUS_TIME = 4000;
    private static final String TAG = "RequestingAdManager";
    private final Map<String, List<T>> requestingAdMap = new HashMap();

    private static class SingletonHolder {
        private static final RequestingAdManager INSTANCE = new RequestingAdManager();

        private SingletonHolder() {
        }
    }

    public static RequestingAdManager getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public boolean addRequest(T t) {
        if (AdUtil.requestStatusOff() || t == null) {
            return false;
        }
        if (LogSwitch.isDebug) {
            AdLogUtil.Log().d(TAG, "start-----------------------addRequest,placementid: " + t.getPlacementId() + "----------------------->");
            StringBuffer stringBuffer = new StringBuffer();
            Iterator<Map.Entry<String, List<T>>> it = this.requestingAdMap.entrySet().iterator();
            stringBuffer.append("[");
            while (it.hasNext()) {
                for (T t2 : it.next().getValue()) {
                    if (t2 != null) {
                        stringBuffer.append("{");
                        stringBuffer.append(t2.getAdUnit());
                        stringBuffer.append(",");
                        stringBuffer.append(t2.getPlacementId());
                        stringBuffer.append(",");
                        stringBuffer.append(SystemClock.uptimeMillis() - t2.getRequestTime());
                        stringBuffer.append("}");
                        stringBuffer.append(",");
                    }
                }
            }
            stringBuffer.append("]");
            AdLogUtil.Log().e(TAG, "current request list: " + stringBuffer.toString());
            AdLogUtil.Log().e(TAG, "end--------------------addRequest->");
        }
        t.setRequestTime(SystemClock.uptimeMillis());
        List<T> list = this.requestingAdMap.get(t.getAdUnit());
        if (list == null) {
            list = new ArrayList<>();
        }
        list.add(t);
        this.requestingAdMap.put(t.getAdUnit(), list);
        return true;
    }

    public void destroyFoldAd(String str) {
        List<T> list;
        AdLogUtil.Log().d(TAG, "destroyFoldAd " + str);
        if (this.requestingAdMap.isEmpty() || (list = this.requestingAdMap.get(str)) == null) {
            return;
        }
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            try {
                T next = it.next();
                if ((next instanceof BaseBanner) && ((BaseBanner) next).destroyFoldAd()) {
                    it.remove();
                }
            } catch (Exception e) {
                AdLogUtil.Log().e(TAG, "destroyFoldAd error:" + Log.getStackTraceString(e));
                return;
            }
        }
    }

    public T getRequest(String str, String str2) {
        if (LogSwitch.isDebug) {
            StringBuffer stringBuffer = new StringBuffer();
            Iterator<Map.Entry<String, List<T>>> it = this.requestingAdMap.entrySet().iterator();
            stringBuffer.append("[");
            while (it.hasNext()) {
                for (T t : it.next().getValue()) {
                    if (t != null) {
                        stringBuffer.append("{");
                        stringBuffer.append(t.getAdUnit());
                        stringBuffer.append(",");
                        stringBuffer.append(t.getPlacementId());
                        stringBuffer.append(",");
                        stringBuffer.append(SystemClock.uptimeMillis() - t.getRequestTime());
                        stringBuffer.append("}");
                        stringBuffer.append(",");
                    }
                }
            }
            stringBuffer.append("]");
            AdLogUtil.Log().e(TAG, "currently is requesting list: " + ((Object) stringBuffer));
        }
        List<T> list = this.requestingAdMap.get(str);
        if (list == null) {
            return null;
        }
        for (T t2 : list) {
            if (t2 != null && t2.getNetwork() != null && TextUtils.equals(t2.getNetwork().getCodeSeatId(), str2) && SystemClock.uptimeMillis() - t2.getRequestTime() <= 4000) {
                return t2;
            }
        }
        return null;
    }

    public boolean removeRequest(T t) {
        List<T> list;
        if (AdUtil.requestStatusOff() || t == null || (list = this.requestingAdMap.get(t.getAdUnit())) == null) {
            return false;
        }
        AdLogUtil.Log().e(TAG, "RequestingAdManager remove placementid: " + t.getPlacementId());
        return list.remove(t);
    }
}
