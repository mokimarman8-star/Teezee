package com.cloud.tmc.miniapp.ipc.helper;

import android.os.Bundle;
import com.cloud.tmc.miniapp.protocol.IIpcMiniProtocolMainChannel;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class OooO0O0 extends Lambda implements Function2<IIpcMiniProtocolMainChannel, String, Unit> {
    public final /* synthetic */ String OooO00o;
    public final /* synthetic */ String OooO0O0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OooO0O0(String str, String str2) {
        super(2);
        this.OooO00o = str;
        this.OooO0O0 = str2;
    }

    public Object invoke(Object obj, Object obj2) {
        IIpcMiniProtocolMainChannel iIpcMiniProtocolMainChannel = (IIpcMiniProtocolMainChannel) obj;
        if (iIpcMiniProtocolMainChannel != null) {
            String str = this.OooO00o;
            Bundle bundle = new Bundle();
            bundle.putString("sdkVersion", this.OooO0O0);
            Unit unit = Unit.a;
            iIpcMiniProtocolMainChannel.onMiniAppAbility("typeMiniAppVersion", str, bundle);
        }
        return Unit.a;
    }
}
