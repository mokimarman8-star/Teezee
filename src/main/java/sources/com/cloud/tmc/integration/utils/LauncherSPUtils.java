package com.cloud.tmc.integration.utils;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.cloud.tmc.integration.BuildConfig;
import com.cloud.tmc.integration.event.EventConstants;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.miniutils.util.Utils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J*\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0001H\u0002J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0004H\u0002J\b\u0010\u0010\u001a\u00020\u0004H\u0002J&\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0012J&\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0004J&\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0012J&\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0019"}, d2 = {"Lcom/cloud/tmc/integration/utils/LauncherSPUtils;", "", "()V", "REPLACE_STR", "", "TAG", "getTAG", "()Ljava/lang/String;", "buildUri", "Landroid/net/Uri;", EventConstants.KEY_ACTION, "spName", "key", "value", "checkStr", "str", "getAuthorStr", "getBoolean", "", "context", "Landroid/content/Context;", "defaultValue", "getString", "putBoolean", "putSting", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public final class LauncherSPUtils {
    private static final String REPLACE_STR = "_spPH_";
    public static final LauncherSPUtils INSTANCE = new LauncherSPUtils();
    private static final String TAG = "SelectLanguageUtils";

    private LauncherSPUtils() {
    }

    private final Uri buildUri(String action, String spName, String key, Object value) {
        TmcLogger.d(TAG, getAuthorStr());
        String str = "content://" + getAuthorStr() + ".spProvider/";
        String checkStr = checkStr(spName);
        String checkStr2 = checkStr(key);
        StringBuilder sb = new StringBuilder();
        sb.append(value);
        return Uri.parse(str + action + "/" + checkStr + "/" + checkStr2 + "/" + checkStr(sb.toString()));
    }

    private final String checkStr(String str) {
        return new Regex("/").replace(str, REPLACE_STR);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0045, code lost:
    
        if (r0.equals("com.transsion.hilauncher.upgrade") == false) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x001c, code lost:
    
        if (r0.equals("com.transsion.hilauncher") == false) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:?, code lost:
    
        return "com.transsion.xlauncher.library.hios";
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final String getAuthorStr() {
        String packageName = Utils.getApp().getPackageName();
        if (packageName != null) {
            switch (packageName.hashCode()) {
                case -1863309634:
                    if (packageName.equals("com.transsion.itel.launcher")) {
                        return "com.transsion.xlauncher.library.itel";
                    }
                    break;
                case -1766538675:
                    break;
                case -221831106:
                    if (packageName.equals("com.transsion.XOSLauncher")) {
                        return "com.transsion.xlauncher.library.xos";
                    }
                    break;
                case 310235112:
                    if (packageName.equals("com.transsion.walauncher")) {
                        return "com.transsion.xlauncher.library.quick";
                    }
                    break;
                case 1323871340:
                    if (packageName.equals("com.transsion.XOSLauncher.upgrade")) {
                        return "com.transsion.xlauncher.library.xos";
                    }
                    break;
                case 1683203871:
                    break;
            }
        }
        return "";
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x004e, code lost:
    
        if (r0 == null) goto L18;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean getBoolean(Context context, String spName, String key, boolean defaultValue) {
        int columnIndex;
        Intrinsics.h(context, "context");
        Intrinsics.h(spName, "spName");
        Intrinsics.h(key, "key");
        Cursor cursor = null;
        try {
            Uri buildUri = buildUri("boolean", spName, key, Boolean.valueOf(defaultValue));
            ContentResolver contentResolver = context.getContentResolver();
            Intrinsics.e(buildUri);
            cursor = contentResolver.query(buildUri, null, null, null, null);
        } catch (Throwable th) {
            try {
                TmcLogger.e(TAG, th);
            } catch (Throwable th2) {
                if (cursor != null) {
                    cursor.close();
                }
                throw th2;
            }
        }
        if (cursor == null) {
            return defaultValue;
        }
        if (cursor.moveToNext() && (columnIndex = cursor.getColumnIndex("SPCOLUMNNAME")) >= 0) {
            defaultValue = Boolean.parseBoolean(cursor.getString(columnIndex));
        }
        cursor.close();
        return defaultValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0059, code lost:
    
        return r12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0056, code lost:
    
        if (r0 == null) goto L20;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String getString(Context context, String spName, String key, String defaultValue) {
        int columnIndex;
        Intrinsics.h(context, "context");
        Intrinsics.h(spName, "spName");
        Intrinsics.h(key, "key");
        Intrinsics.h(defaultValue, "defaultValue");
        try {
            Uri buildUri = buildUri("string", spName, key, defaultValue);
            ContentResolver contentResolver = context.getContentResolver();
            Intrinsics.g(contentResolver, "context.contentResolver");
            r0 = buildUri != null ? contentResolver.query(buildUri, null, null, null, null) : null;
            if (r0 != null && r0.moveToNext() && (columnIndex = r0.getColumnIndex("SPCOLUMNNAME")) >= 0) {
                String string = r0.getString(columnIndex);
                Intrinsics.g(string, "it.getString(index)");
                defaultValue = string;
            }
        } catch (Throwable th) {
            try {
                TmcLogger.e(TAG, th);
            } finally {
                if (r0 != null) {
                    r0.close();
                }
            }
        }
    }

    public final String getTAG() {
        return TAG;
    }

    public final boolean putBoolean(Context context, String spName, String key, boolean value) {
        Intrinsics.h(context, "context");
        Intrinsics.h(spName, "spName");
        Intrinsics.h(key, "key");
        try {
            Uri buildUri = buildUri("boolean", spName, key, Boolean.valueOf(value));
            ContentResolver contentResolver = context.getContentResolver();
            ContentValues contentValues = new ContentValues();
            contentValues.put(key, Boolean.valueOf(value));
            if (buildUri == null) {
                return true;
            }
            contentResolver.insert(buildUri, contentValues);
            return true;
        } catch (Throwable th) {
            TmcLogger.e(TAG, th);
            return false;
        }
    }

    public final boolean putSting(Context context, String spName, String key, String value) {
        Intrinsics.h(context, "context");
        Intrinsics.h(spName, "spName");
        Intrinsics.h(key, "key");
        Intrinsics.h(value, "value");
        try {
            Uri buildUri = buildUri("string", spName, key, value);
            ContentResolver contentResolver = context.getContentResolver();
            ContentValues contentValues = new ContentValues();
            contentValues.put(key, value);
            if (buildUri == null) {
                return true;
            }
            contentResolver.insert(buildUri, contentValues);
            return true;
        } catch (Throwable th) {
            TmcLogger.e(TAG, th);
            return false;
        }
    }
}
