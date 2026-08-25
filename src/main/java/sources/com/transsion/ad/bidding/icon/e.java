package com.transsion.ad.bidding.icon;

import com.hisavana.common.bean.TAdErrorCode;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import com.transsion.ad.bidding.base.BiddingIntermediateMaterialBean;
import com.transsion.ad.ps.distribute.PSDistributionRequestManager;
import com.transsion.ad.ps.model.RecommendInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public final class e extends oh.a {
    private oh.a d;
    private boolean e;

    public static /* synthetic */ Object A(e eVar, int i, String str, String str2, Continuation continuation, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        if ((i2 & 4) != 0) {
            str2 = TtmlNode.ANONYMOUS_REGION_ID;
        }
        return eVar.z(i, str, str2, continuation);
    }

    private final int y(String str) {
        return com.transsion.ad.scene.a.a.n(str, 10);
    }

    public final void B(boolean z) {
        this.e = z;
    }

    public final void C(oh.a aVar) {
        this.d = aVar;
    }

    @Override // oh.a
    public void e(TAdErrorCode tAdErrorCode, BiddingIntermediateMaterialBean biddingIntermediateMaterialBean) {
        super.e(tAdErrorCode, biddingIntermediateMaterialBean);
        oh.a aVar = this.d;
        if (aVar != null) {
            aVar.e(tAdErrorCode, biddingIntermediateMaterialBean);
        }
    }

    @Override // oh.a
    public void v(List list) {
        super.v(list);
        if (this.e) {
            ArrayList arrayList = new ArrayList();
            if (list != null) {
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    RecommendInfo recommendInfo = (RecommendInfo) it.next();
                    if (!zh.b.a.c(recommendInfo.getPackageName())) {
                        arrayList.add(recommendInfo);
                    }
                }
            }
            list = arrayList;
        }
        oh.a aVar = this.d;
        if (aVar != null) {
            aVar.v(list);
        }
    }

    public final void x() {
        this.d = null;
    }

    public final Object z(int i, String str, String str2, Continuation continuation) {
        Object d = PSDistributionRequestManager.a.d(i, y(str), str, str2, this, continuation);
        return d == IntrinsicsKt.f() ? d : Unit.a;
    }
}
