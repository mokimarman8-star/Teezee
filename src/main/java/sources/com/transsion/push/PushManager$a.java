package com.transsion.push;

import android.content.Context;
import android.os.Bundle;
import com.transsion.gslb.GslbSdk;
import com.transsion.push.utils.PushLogUtils;
import com.transsion.push.utils.ServiceUtils;
import java.util.Map;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
class PushManager$a implements GslbSdk.InitListener {
    final /* synthetic */ Context a;
    final /* synthetic */ PushManager b;

    PushManager$a(PushManager pushManager, Context context) {
        this.b = pushManager;
        this.a = context;
    }

    @Override // com.transsion.gslb.GslbSdk.InitListener
    public void onInitFail() {
        PushLogUtils.LOG.g("gslb sdk init fail");
    }

    @Override // com.transsion.gslb.GslbSdk.InitListener
    public void onInitSuccess(Map map) {
        PushLogUtils.LOG.g("gslb sdk init success");
        Bundle bundle = new Bundle();
        bundle.putString(PushConstants.EXTRA_PUSH_SERVICE_TYPE, PushConstants.PUSH_SERVICE_TYPE_FORCE_UPDATE);
        ServiceUtils.startJobThread(this.a.getApplicationContext(), bundle);
        PushLogUtils.LOG.g("gslb success, force update info to server");
    }
}
