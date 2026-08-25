package rt;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import androidx.lifecycle.u;
import com.transsion.transfer.wifi.ui.WifiConnectActivity;
import com.transsion.transfer.wifi.ui.WifiCreateActivity;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class a implements bu.a {
    @Override // bu.a
    public void a(u ctx) {
        Intrinsics.h(ctx, "ctx");
        Activity activity = (Activity) ctx;
        Intent intent = new Intent(activity, (Class<?>) WifiCreateActivity.class);
        intent.addFlags(268435456);
        activity.startActivity(intent);
    }

    @Override // bu.a
    public void b(u ctx) {
        Intrinsics.h(ctx, "ctx");
        Activity activity = (Activity) ctx;
        Intent intent = new Intent(activity, (Class<?>) WifiConnectActivity.class);
        if (ctx instanceof Application) {
            intent.addFlags(268435456);
        }
        activity.startActivity(intent);
    }
}
