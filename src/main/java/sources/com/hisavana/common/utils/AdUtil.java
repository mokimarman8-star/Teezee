package com.hisavana.common.utils;

import android.content.Context;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.cloud.hisavana.sdk.common.util.m0;
import com.cloud.hisavana.sdk.data.bean.response.ConfigTotalDTO;
import com.cloud.hisavana.sdk.internal.helper.InternalConfigHelper;
import com.cloud.sdk.commonutil.util.e;
import com.hisavana.common.bean.Network;
import com.hisavana.common.bean.TAdNativeInfo;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import java.math.BigDecimal;
import l7.a;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public class AdUtil {
    public static boolean checkAppInstalled(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            if (!TextUtils.isEmpty(str)) {
                PackageManager packageManager = context.getPackageManager();
                if (TextUtils.isEmpty(str)) {
                    str = TtmlNode.ANONYMOUS_REGION_ID;
                }
                if (packageManager.getPackageInfo(str, 0) != null) {
                    return true;
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    public static int getNetworkType(Network network) {
        if (network == null || network.getAdt() == -1) {
            return 0;
        }
        int intValue = network.getBiddingType().intValue();
        if (intValue == 1) {
            return isQueryPriceNetwork(network.getSource().intValue()) ? 3 : 1;
        }
        if (intValue == 2) {
            return 2;
        }
        if (isQueryPriceNetwork(network.getSource().intValue())) {
            return 3;
        }
        return isBiddingNetwork(network.getSource().intValue()) ? 1 : 2;
    }

    public static boolean isAdmobNetwork(int i) {
        return i == 1;
    }

    private static boolean isBiddingNetwork(int i) {
        return i == 6 || i == 0 || i == 14 || i == 16 || i == 5 || i == 8 || i == 17;
    }

    public static boolean isBiddingNetwork(Network network) {
        return 1 == getNetworkType(network);
    }

    public static boolean isDebuggable() {
        try {
            return (e.a().getApplicationInfo().flags & 2) != 0;
        } catch (Exception unused) {
            return false;
        }
    }

    private static boolean isQueryPriceNetwork(int i) {
        return i == 9 || i == 2;
    }

    public static boolean isQueryPriceNetwork(Network network) {
        return 3 == getNetworkType(network);
    }

    public static boolean isWaterFall(Network network) {
        return 2 == getNetworkType(network);
    }

    public static boolean isZero(@NonNull BigDecimal bigDecimal) {
        return bigDecimal.compareTo(new BigDecimal(MBridgeConstans.ENDCARD_URL_TYPE_PL)) == 0;
    }

    public static void overwriteAdmobNetworkPrice(@NonNull Network network) {
        overwriteAdmobNetworkPrice(network, TtmlNode.ANONYMOUS_REGION_ID);
    }

    public static void overwriteAdmobNetworkPrice(@NonNull Network network, String str) {
        if (isAdmobNetwork(network.getSource().intValue())) {
            BigDecimal showPriceCoefficient = network.getShowPriceCoefficient();
            AdLogUtil.Log().w("ad_flow", ">>>>> priceCoefficient: " + showPriceCoefficient.doubleValue() + " | codeSeatId: " + network.getCodeSeatId());
            if (isZero(showPriceCoefficient)) {
                return;
            }
            long i = a.e().i(network.getCodeSeatId(), 0L);
            if (i > 0) {
                double tempPrice = network.getTempPrice();
                BigDecimal valueOf = BigDecimal.valueOf(i / 1000.0d);
                double doubleValue = m0.a(valueOf.multiply(showPriceCoefficient).multiply(BigDecimal.valueOf(100L))).doubleValue();
                if (doubleValue > tempPrice) {
                    network.setPrice(Double.valueOf(doubleValue));
                }
                AdLogUtil.Log().w("ad_flow", ">>>>> valueMicros: " + i + " | valueDollar :" + valueOf + " | price :" + doubleValue + " | formerPrice: " + tempPrice + " | nowPrice: " + network.getPrice());
            }
        }
    }

    public static void release(TAdNativeInfo tAdNativeInfo) {
        if (tAdNativeInfo != null) {
            tAdNativeInfo.release();
        }
    }

    public static boolean requestStatusOff() {
        ConfigTotalDTO.ExtInfo extInfo = InternalConfigHelper.getExtInfo();
        if (extInfo == null) {
            return true;
        }
        return extInfo.getRequestStatusOff();
    }
}
