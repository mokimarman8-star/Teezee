package com.hisavana.mediation.bridge.holder;

import android.view.ViewGroup;
import android.view.ViewParent;
import com.hisavana.mediation.ad.TBannerView;
import com.hisavana.mediation.bridge.listener.BridgeListener;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B/\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\b\u0010\u0010\u001a\u00020\u000eH\u0016¨\u0006\u0011"}, d2 = {"Lcom/hisavana/mediation/bridge/holder/JsBannerAdHolder;", "Lcom/hisavana/mediation/bridge/holder/JsAdHolder;", "Lcom/hisavana/mediation/ad/TBannerView;", "ad", "callbackId", TtmlNode.ANONYMOUS_REGION_ID, "codeSeatId", "adType", TtmlNode.ANONYMOUS_REGION_ID, "bridgeListener", "Lcom/hisavana/mediation/bridge/listener/BridgeListener;", "<init>", "(Lcom/hisavana/mediation/ad/TBannerView;Ljava/lang/String;Ljava/lang/String;ILcom/hisavana/mediation/bridge/listener/BridgeListener;)V", "loadAd", TtmlNode.ANONYMOUS_REGION_ID, "showAd", "release", "mediation_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public final class JsBannerAdHolder extends JsAdHolder<TBannerView> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JsBannerAdHolder(TBannerView tBannerView, String str, String str2, int i, BridgeListener bridgeListener) {
        super(tBannerView, str, str2, i, bridgeListener);
        Intrinsics.h(tBannerView, "ad");
        Intrinsics.h(str, "callbackId");
        Intrinsics.h(str2, "codeSeatId");
        Intrinsics.h(bridgeListener, "bridgeListener");
        tBannerView.setRequestBody(a());
    }

    @Override // com.hisavana.mediation.bridge.holder.JsAdHolder
    public void loadAd() {
        getAd().loadAd();
    }

    @Override // com.hisavana.mediation.bridge.holder.JsAdHolder
    public void release() {
        super.release();
        if (getAd().getParent() instanceof ViewGroup) {
            ViewParent parent = getAd().getParent();
            Intrinsics.f(parent, "null cannot be cast to non-null type android.view.ViewGroup");
            ((ViewGroup) parent).removeView(getAd());
        }
        getAd().destroy();
    }

    @Override // com.hisavana.mediation.bridge.holder.JsAdHolder
    public void showAd() {
        if (getAd().getParent() != null) {
            return;
        }
        getBridgeListener().showBanner(this);
    }
}
