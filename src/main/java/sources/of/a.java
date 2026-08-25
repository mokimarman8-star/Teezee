package of;

import com.hisavana.common.tracking.TrackingKey;
import kotlin.jvm.internal.Intrinsics;
import of.b;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public final class a implements b.InterfaceC0193b {
    private final String c = "HttpLogger";

    @Override // of.b.InterfaceC0193b
    public void log(String str) {
        Intrinsics.h(str, TrackingKey.MESSAGE);
        Intrinsics.q("log: ->> ", str);
    }
}
