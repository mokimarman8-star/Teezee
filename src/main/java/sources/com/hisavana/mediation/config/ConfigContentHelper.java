package com.hisavana.mediation.config;

import android.text.TextUtils;
import android.util.Log;
import com.cloud.sdk.commonutil.util.HSScopeHelper;
import com.hisavana.common.bean.Network;
import com.hisavana.common.constant.ComConstants;
import com.hisavana.common.utils.AdLogUtil;
import com.hisavana.common.utils.MediaLogUtil;
import com.hisavana.mediation.bean.CloudControlConfig;
import ee.e;
import ee.f;
import ee.g;
import ee.j;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public class ConfigContentHelper {
    public final j a;
    public final g b;

    public static class a {
        public static final ConfigContentHelper a = new ConfigContentHelper();
    }

    public ConfigContentHelper() {
        this.b = g.d();
        if (TextUtils.equals(TAdManager.getAhaChannel(), ComConstants.AHA_CHANNEL)) {
            this.a = f.d();
        } else {
            this.a = e.d();
        }
    }

    public static ConfigContentHelper g() {
        return a.a;
    }

    public void b() {
        this.b.b();
    }

    public void c() {
        this.b.b();
        this.a.a();
    }

    public List d() {
        return this.a.c();
    }

    public CloudControlConfig.CodeSeat e(String str) {
        if (TextUtils.isEmpty(str)) {
            MediaLogUtil.e("ConfigContentHelper", "getConfig,codeSeatId is empty");
            AdLogUtil.Log().e("ConfigContentHelper", "getConfig,codeSeatId is empty");
            return null;
        }
        MediaLogUtil.d("ConfigContentHelper", "getConfig " + str);
        try {
            CloudControlConfig.CodeSeat a2 = this.b.a(str);
            if (a2 == null) {
                HSScopeHelper.a.g(new 1(this));
            }
            if (a2 != null || !TextUtils.equals(TAdManager.getAhaChannel(), ComConstants.AHA_CHANNEL)) {
                return a2;
            }
            Network network = new Network();
            CloudControlConfig.CodeSeat codeSeat = new CloudControlConfig.CodeSeat();
            ArrayList arrayList = new ArrayList();
            codeSeat.setNetworks(arrayList);
            arrayList.add(network);
            codeSeat.setCodeSeatId(str);
            network.setCodeSeatId(str);
            network.setPrice(Double.valueOf(0.0d));
            network.setSource(1);
            AdLogUtil.Log().d("ConfigContentHelper", "aha channel return default config");
            return codeSeat;
        } catch (Exception e) {
            AdLogUtil.Log().e("ConfigContentHelper", "ex " + Log.getStackTraceString(e));
            MediaLogUtil.d("ConfigContentHelper", "getConfig,codeSeatId " + str + ",codeSeat is null");
            return null;
        }
    }

    public long f() {
        return this.a.b();
    }

    public void h() {
        AdLogUtil.Log().d("ConfigContentHelper", "getConfig from database");
        this.b.c(this.a.c());
    }

    public boolean i(List list) {
        AdLogUtil.Log().d("ConfigContentHelper", "insert ");
        List<CloudControlConfig.CodeSeat> d = d();
        if (d != null && !d.isEmpty()) {
            for (CloudControlConfig.CodeSeat codeSeat : d) {
                if (codeSeat != null) {
                    Iterator it = list.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        CloudControlConfig.CodeSeat codeSeat2 = (CloudControlConfig.CodeSeat) it.next();
                        if (codeSeat2 != null && TextUtils.equals(codeSeat.getCodeSeatId(), codeSeat2.getCodeSeatId())) {
                            codeSeat2.setCurrentHourZeroClock(codeSeat.getCurrentHourZeroClock());
                            codeSeat2.setLastShowTime(codeSeat.getLastShowTime());
                            codeSeat2.setCurrentHourShowTimes(codeSeat.getCurrentHourShowTimes());
                            codeSeat2.setTodayZeroClock(codeSeat.getTodayZeroClock());
                            codeSeat2.setTodayShowTimes(codeSeat.getTodayShowTimes());
                            break;
                        }
                    }
                }
            }
        }
        this.b.c(list);
        return this.a.a(list);
    }

    public void j(CloudControlConfig.CodeSeat codeSeat) {
        AdLogUtil.Log().d("ConfigContentHelper", "updateConfig " + codeSeat);
        HSScopeHelper.a.g(new 2(this, codeSeat));
    }
}
