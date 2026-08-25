package com.hisavana.common.mock;

import com.cloud.sdk.commonutil.util.Preconditions;
import com.hisavana.common.base.LogSwitch;
import com.hisavana.common.bean.Network;
import com.hisavana.common.constant.ComConstants;
import com.hisavana.common.interfacz.ICacheAd;
import java.util.Iterator;
import java.util.List;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public class RecordTestInfo {
    public static int LOG_CODE1 = 1;
    public static int LOG_CODE10 = 10;
    public static int LOG_CODE11 = 11;
    public static int LOG_CODE12 = 12;
    public static int LOG_CODE2 = 2;
    public static int LOG_CODE3 = 3;
    public static int LOG_CODE4 = 4;
    public static int LOG_CODE5 = 5;
    public static int LOG_CODE6 = 6;
    public static int LOG_CODE7 = 7;
    public static int LOG_CODE8 = 8;
    public static int LOG_CODE9 = 9;
    private static LogListener logListener;
    public static StringBuilder stringBuilder = new StringBuilder();

    public static void LogMsg(String str, int i) {
        if (logListener != null) {
            Preconditions.d(new 1(str, i));
        }
    }

    public static void destroy() {
        logListener = null;
    }

    public static <T extends ICacheAd> String getLogMsg(Network network) {
        if (logListener == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        if (network != null) {
            sb.append(network.getCodeSeatId());
            sb.append(" price:");
            sb.append(network.getPrice());
        }
        return sb.toString();
    }

    public static <T extends ICacheAd> String getLogMsg(T t) {
        if (logListener == null || !LogSwitch.isDebug || t == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(ComConstants.transferSourceToStr(t.getAdSource()));
        int adSource = t.getAdSource();
        if (adSource == 1 || adSource == 17) {
            sb.append("-");
            sb.append(t.getMediatorSourceName());
            sb.append(", priceCoefficient:");
            sb.append(t.getNetwork().getShowPriceCoefficient());
        }
        sb.append(", price:");
        sb.append(t.getEcpmPrice());
        sb.append(", isInternalAd:");
        sb.append(t.isInternalAd());
        sb.append(", cacheTime:");
        sb.append(t.getValidTimeLimit() / 60000);
        return sb.toString();
    }

    public static <T extends ICacheAd> String getLogMsg(List<T> list) {
        if (logListener == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        if (list != null) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                sb.append(getLogMsg(it.next()));
                sb.append("\n");
            }
        }
        return sb.toString();
    }

    public static void record(String str) {
        if (stringBuilder == null || !ComConstants.AUTOMATIC_TEST_STATUS.booleanValue()) {
            return;
        }
        stringBuilder.append(str);
        stringBuilder.append("\n");
    }

    public static void setLogListener(LogListener logListener2) {
        logListener = logListener2;
    }
}
