package vv;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import com.transsion.version.update.RemoteVersionInfo;
import com.transsion.version.update.e;
import com.transsion.web.api.WebConstants;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.HttpUrl;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class a {
    private final boolean b(Context context, String str) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW", str != null ? Uri.parse(str) : null);
            intent.addFlags(268435456);
            if (context == null) {
                return true;
            }
            context.startActivity(intent);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x007c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean a(String fromPage, Context context, RemoteVersionInfo remoteVersionInfo) {
        boolean b;
        boolean z;
        Intent intent;
        PackageManager packageManager;
        Intrinsics.h(fromPage, "fromPage");
        ComponentName componentName = null;
        String appStoreUrl = remoteVersionInfo != null ? remoteVersionInfo.getAppStoreUrl() : null;
        String webDownloadUrl = remoteVersionInfo != null ? remoteVersionInfo.getWebDownloadUrl() : null;
        boolean z2 = true;
        try {
            intent = new Intent("android.intent.action.VIEW", appStoreUrl != null ? Uri.parse(appStoreUrl) : null);
            intent.addFlags(268435456);
            if (context != null && (packageManager = context.getPackageManager()) != null) {
                componentName = intent.resolveActivity(packageManager);
            }
        } catch (Exception e) {
            e.printStackTrace();
            b = b(context, webDownloadUrl);
        }
        if (componentName == null) {
            b = b(context, webDownloadUrl);
            z2 = b;
            z = true;
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("action", "jump");
            if (appStoreUrl == null) {
            }
            linkedHashMap.put("store_uri", appStoreUrl);
            if (webDownloadUrl == null) {
            }
            linkedHashMap.put("web_uri", webDownloadUrl);
            linkedHashMap.put("action_result", String.valueOf(z2));
            linkedHashMap.put("type", z ? "store" : "web");
            linkedHashMap.put(WebConstants.PAGE_FROM, fromPage);
            linkedHashMap.put("dialog_type", "mb");
            e.a.b(linkedHashMap);
            return z2;
        }
        context.startActivity(intent);
        z = false;
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        linkedHashMap2.put("action", "jump");
        if (appStoreUrl == null) {
            appStoreUrl = HttpUrl.FRAGMENT_ENCODE_SET;
        }
        linkedHashMap2.put("store_uri", appStoreUrl);
        if (webDownloadUrl == null) {
            webDownloadUrl = HttpUrl.FRAGMENT_ENCODE_SET;
        }
        linkedHashMap2.put("web_uri", webDownloadUrl);
        linkedHashMap2.put("action_result", String.valueOf(z2));
        linkedHashMap2.put("type", z ? "store" : "web");
        linkedHashMap2.put(WebConstants.PAGE_FROM, fromPage);
        linkedHashMap2.put("dialog_type", "mb");
        e.a.b(linkedHashMap2);
        return z2;
    }
}
