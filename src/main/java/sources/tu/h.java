package tu;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class h {
    public final i a(Context context) {
        Intrinsics.h(context, "context");
        i iVar = i.c;
        if (iVar == null) {
            synchronized (this) {
                iVar = i.c;
                if (iVar == null) {
                    Context applicationContext = context.getApplicationContext();
                    Intrinsics.g(applicationContext, "getApplicationContext(...)");
                    iVar = new i(applicationContext);
                    i.c = iVar;
                }
            }
        }
        return iVar;
    }
}
