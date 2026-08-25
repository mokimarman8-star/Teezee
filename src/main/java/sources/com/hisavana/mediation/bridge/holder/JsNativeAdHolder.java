package com.hisavana.mediation.bridge.holder;

import b7.c;
import com.hisavana.mediation.bridge.listener.BridgeListener;
import com.hisavana.mediation.bridge.listener.BridgeSspAdListener;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B/\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0010\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0011\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/hisavana/mediation/bridge/holder/JsNativeAdHolder;", "Lcom/hisavana/mediation/bridge/holder/JsAdHolder;", "Lb7/c;", "ad", TtmlNode.ANONYMOUS_REGION_ID, "callbackId", "codeSeatId", TtmlNode.ANONYMOUS_REGION_ID, "adType", "Lcom/hisavana/mediation/bridge/listener/BridgeListener;", "bridgeListener", "<init>", "(Lb7/c;Ljava/lang/String;Ljava/lang/String;ILcom/hisavana/mediation/bridge/listener/BridgeListener;)V", TtmlNode.ANONYMOUS_REGION_ID, "loadAd", "()V", "showAd", "release", "mediation_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public final class JsNativeAdHolder extends JsAdHolder<c> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JsNativeAdHolder(c cVar, String str, String str2, int i, BridgeListener bridgeListener) {
        super(cVar, str, str2, i, bridgeListener);
        Intrinsics.h(cVar, "ad");
        Intrinsics.h(str, "callbackId");
        Intrinsics.h(str2, "codeSeatId");
        Intrinsics.h(bridgeListener, "bridgeListener");
        cVar.p(new BridgeSspAdListener(this));
    }

    @Override // com.hisavana.mediation.bridge.holder.JsAdHolder
    public void loadAd() {
        getAd().v();
    }

    @Override // com.hisavana.mediation.bridge.holder.JsAdHolder
    public void release() {
        super.release();
        getAd().c();
    }

    @Override // com.hisavana.mediation.bridge.holder.JsAdHolder
    public void showAd() {
    }
}
