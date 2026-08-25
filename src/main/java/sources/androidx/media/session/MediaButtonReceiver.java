package androidx.media.session;

import android.app.ForegroundServiceStartNotAllowedException;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.media.MediaBrowserCompat;
import android.support.v4.media.session.PlaybackStateCompat;
import android.util.Log;
import android.view.KeyEvent;
import androidx.core.content.b;
import java.util.List;
import org.mvel2.ast.ASTNode;
import s1.a;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public class MediaButtonReceiver extends BroadcastReceiver {
    public static PendingIntent a(Context context, long j) {
        ComponentName c = c(context);
        if (c != null) {
            return b(context, c, j);
        }
        Log.w("MediaButtonReceiver", "A unique media button receiver could not be found in the given context, so couldn't build a pending intent.");
        return null;
    }

    public static PendingIntent b(Context context, ComponentName componentName, long j) {
        if (componentName == null) {
            Log.w("MediaButtonReceiver", "The component name of media button receiver should be provided.");
            return null;
        }
        int keyCode = PlaybackStateCompat.toKeyCode(j);
        if (keyCode == 0) {
            Log.w("MediaButtonReceiver", "Cannot build a media button pending intent with the given action: " + j);
            return null;
        }
        Intent intent = new Intent("android.intent.action.MEDIA_BUTTON");
        intent.setComponent(componentName);
        intent.putExtra("android.intent.extra.KEY_EVENT", new KeyEvent(0, keyCode));
        int i = Build.VERSION.SDK_INT;
        intent.addFlags(ASTNode.DEOP);
        return PendingIntent.getBroadcast(context, keyCode, intent, i >= 31 ? ASTNode.PCTX_STORED : 0);
    }

    public static ComponentName c(Context context) {
        Intent intent = new Intent("android.intent.action.MEDIA_BUTTON");
        intent.setPackage(context.getPackageName());
        List<ResolveInfo> queryBroadcastReceivers = context.getPackageManager().queryBroadcastReceivers(intent, 0);
        if (queryBroadcastReceivers.size() == 1) {
            ActivityInfo activityInfo = queryBroadcastReceivers.get(0).activityInfo;
            return new ComponentName(activityInfo.packageName, activityInfo.name);
        }
        if (queryBroadcastReceivers.size() <= 1) {
            return null;
        }
        Log.w("MediaButtonReceiver", "More than one BroadcastReceiver that handles android.intent.action.MEDIA_BUTTON was found, returning null.");
        return null;
    }

    private static ComponentName d(Context context, String str) {
        PackageManager packageManager = context.getPackageManager();
        Intent intent = new Intent(str);
        intent.setPackage(context.getPackageName());
        List<ResolveInfo> queryIntentServices = packageManager.queryIntentServices(intent, 0);
        if (queryIntentServices.size() == 1) {
            ServiceInfo serviceInfo = queryIntentServices.get(0).serviceInfo;
            return new ComponentName(serviceInfo.packageName, serviceInfo.name);
        }
        if (queryIntentServices.isEmpty()) {
            return null;
        }
        throw new IllegalStateException("Expected 1 service that handles " + str + ", found " + queryIntentServices.size());
    }

    protected void e(Intent intent, ForegroundServiceStartNotAllowedException foregroundServiceStartNotAllowedException) {
        Log.e("MediaButtonReceiver", "caught exception when trying to start a foreground service from the background: " + a.a(foregroundServiceStartNotAllowedException));
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent == null || !"android.intent.action.MEDIA_BUTTON".equals(intent.getAction()) || !intent.hasExtra("android.intent.extra.KEY_EVENT")) {
            StringBuilder sb = new StringBuilder();
            sb.append("Ignore unsupported intent: ");
            sb.append(intent);
            return;
        }
        ComponentName d = d(context, "android.intent.action.MEDIA_BUTTON");
        if (d != null) {
            intent.setComponent(d);
            try {
                b.startForegroundService(context, intent);
                return;
            } catch (IllegalStateException e) {
                if (Build.VERSION.SDK_INT < 31 || !a.b(e)) {
                    throw e;
                }
                e(intent, a.a(e));
                return;
            }
        }
        ComponentName d2 = d(context, "android.media.browse.MediaBrowserService");
        if (d2 == null) {
            throw new IllegalStateException("Could not find any Service that handles android.intent.action.MEDIA_BUTTON or implements a media browser service.");
        }
        BroadcastReceiver.PendingResult goAsync = goAsync();
        Context applicationContext = context.getApplicationContext();
        b bVar = new b(applicationContext, intent, goAsync);
        MediaBrowserCompat mediaBrowserCompat = new MediaBrowserCompat(applicationContext, d2, bVar, (Bundle) null);
        bVar.f(mediaBrowserCompat);
        mediaBrowserCompat.a();
    }
}
