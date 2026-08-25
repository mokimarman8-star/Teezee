package ft;

import android.content.Context;
import android.content.Intent;
import com.transsion.subroom.deeplink.DeepLinkHandler;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public final class a implements to.a {
    @Override // to.a
    public Intent a(Context context) {
        Intrinsics.h(context, "context");
        return new Intent(context, (Class<?>) DeepLinkHandler.class);
    }
}
