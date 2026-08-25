package ee;

import android.util.Log;
import com.hisavana.common.bean.Network;
import com.hisavana.common.utils.AdLogUtil;
import com.hisavana.common.utils.AdUtil;
import com.hisavana.mediation.bean.CloudControlConfig;
import com.hisavana.mediation.config.ConfigContentHelper;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import java.util.List;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public abstract class h {
    public static CloudControlConfig.CodeSeat a(String str) {
        return b(str, TtmlNode.ANONYMOUS_REGION_ID, false);
    }

    public static CloudControlConfig.CodeSeat b(String str, String str2, boolean z) {
        CloudControlConfig.CodeSeat codeSeat = null;
        try {
            codeSeat = ConfigContentHelper.g().e(str);
        } catch (Exception e) {
            AdLogUtil.Log().e("ConfigUtil", "getConfigByAdUnit " + Log.getStackTraceString(e));
        }
        if (codeSeat == null) {
            return codeSeat;
        }
        List<Network> networks = codeSeat.getNetworks();
        if (networks != null && !networks.isEmpty()) {
            for (Network network : networks) {
                network.setAdt(codeSeat.getCodeSeatType().intValue());
                if (network.getSource().intValue() != 1 && !AdUtil.isQueryPriceNetwork(network)) {
                    network.setPrice(Double.valueOf(network.getTempPrice()));
                }
                if (z) {
                    AdUtil.overwriteAdmobNetworkPrice(network, str2);
                }
            }
        }
        return codeSeat;
    }
}
