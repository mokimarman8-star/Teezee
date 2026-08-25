package ph;

import com.transsion.ad.bidding.gemini.AbsBiddingBuyOutGemini;
import com.transsion.ad.bidding.splash.BiddingBuyOutSplashActivity;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public final class b extends AbsBiddingBuyOutGemini {
    @Override // com.transsion.ad.bidding.gemini.AbsBiddingBuyOutGemini
    public Class c() {
        return BiddingBuyOutSplashActivity.class;
    }

    @Override // com.transsion.ad.bidding.gemini.AbsBiddingBuyOutGemini
    public String e() {
        return "splash";
    }

    public String getLogTag() {
        return "ad_s";
    }
}
