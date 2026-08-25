package com.tn.tranpay.helper;

import com.cloud.tmc.kernel.constants.TmcConstants;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.text.StringsKt;
import kotlinx.coroutines.i;
import kotlinx.coroutines.y0;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class IPHelper {
    private static String b;
    private static long c;
    public static final IPHelper a = new IPHelper();
    private static final List d = CollectionsKt.o(new String[]{"https://api.ipify.org", "https://ifconfig.me/ip", "https://icanhazip.com", "https://ipinfo.io/ip"});

    private IPHelper() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object h(String str, Continuation continuation) {
        return i.g(y0.b(), new IPHelper$fetchIPFromService$2(str, null), continuation);
    }

    public static /* synthetic */ Object j(IPHelper iPHelper, boolean z, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return iPHelper.i(z, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean k(String str) {
        List S0 = StringsKt.S0(str, new String[]{TmcConstants.EXTENSION_SEPARATOR}, false, 0, 6, (Object) null);
        if (S0.size() != 4) {
            return false;
        }
        List list = S0;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                try {
                    int parseInt = Integer.parseInt((String) it.next());
                    if (parseInt < 0 || parseInt >= 256) {
                        return false;
                    }
                } catch (NumberFormatException unused) {
                    return false;
                }
            }
        }
        return true;
    }

    public final Object i(boolean z, Continuation continuation) {
        return i.g(y0.b(), new IPHelper$getCurrentIP$2(z, null), continuation);
    }
}
