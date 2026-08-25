package com.cloud.tmc.miniutils.util;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import androidx.annotation.Nullable;
import com.cloud.tmc.miniutils.util.Utils;
import java.io.File;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
class UtilsBridge {
    private static final String TAG = "UtilsBridge";
    private static Handler mainHandler = new Handler(Looper.getMainLooper());

    static final class FileHead {
        private LinkedHashMap<String, String> mFirst = new LinkedHashMap<>();
        private LinkedHashMap<String, String> mLast = new LinkedHashMap<>();
        private String mName;

        FileHead(String str) {
            this.mName = str;
        }

        private void append2Host(Map<String, String> map, String str, String str2) {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return;
            }
            int length = 19 - str.length();
            if (length > 0) {
                str = str + "                   ".substring(0, length);
            }
            map.put(str, str2);
        }

        private void append2Host(Map<String, String> map, Map<String, String> map2) {
            if (map2 == null || map2.isEmpty()) {
                return;
            }
            for (Map.Entry<String, String> entry : map2.entrySet()) {
                append2Host(map, entry.getKey(), entry.getValue());
            }
        }

        @Deprecated
        static Uri file2Uri(File file) {
            return UriUtils.file2Uri(file);
        }

        void addFirst(String str, String str2) {
            append2Host(this.mFirst, str, str2);
        }

        void append(String str, String str2) {
            append2Host(this.mLast, str, str2);
        }

        void append(Map<String, String> map) {
            append2Host(this.mLast, map);
        }

        public String getAppended() {
            StringBuilder sb = new StringBuilder();
            for (Map.Entry<String, String> entry : this.mLast.entrySet()) {
                sb.append(entry.getKey());
                sb.append(": ");
                sb.append(entry.getValue());
                sb.append("\n");
            }
            return sb.toString();
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            String str = "************* " + this.mName + " Head ****************\n";
            sb.append(str);
            for (Map.Entry<String, String> entry : this.mFirst.entrySet()) {
                sb.append(entry.getKey());
                sb.append(": ");
                sb.append(entry.getValue());
                sb.append("\n");
            }
            sb.append("Device Manufacturer: ");
            sb.append(Build.MANUFACTURER);
            sb.append("\n");
            sb.append("Device Model       : ");
            sb.append(Build.MODEL);
            sb.append("\n");
            sb.append("Android Version    : ");
            sb.append(Build.VERSION.RELEASE);
            sb.append("\n");
            sb.append("Android SDK        : ");
            sb.append(Build.VERSION.SDK_INT);
            sb.append("\n");
            sb.append("App VersionName    : ");
            sb.append(AppUtils.getAppVersionName());
            sb.append("\n");
            sb.append("App VersionCode    : ");
            sb.append(AppUtils.getAppVersionCode());
            sb.append("\n");
            sb.append(getAppended());
            sb.append(str);
            sb.append("\n");
            return sb.toString();
        }
    }

    UtilsBridge() {
    }

    static void addActivityLifecycleCallbacks(Activity activity, Utils.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        UtilsActivityLifecycleImpl.INSTANCE.addActivityLifecycleCallbacks(activity, activityLifecycleCallbacks);
    }

    static void addActivityLifecycleCallbacks(Utils.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        UtilsActivityLifecycleImpl.INSTANCE.addActivityLifecycleCallbacks(activityLifecycleCallbacks);
    }

    static void addOnAppStatusChangedListener(Utils.OnAppStatusChangedListener onAppStatusChangedListener) {
        UtilsActivityLifecycleImpl.INSTANCE.addOnAppStatusChangedListener(onAppStatusChangedListener);
    }

    static byte[] base64Decode(byte[] bArr) {
        return EncodeUtils.base64Decode(bArr);
    }

    static byte[] base64Encode(byte[] bArr) {
        return EncodeUtils.base64Encode(bArr);
    }

    static byte[] bitmap2Bytes(Bitmap bitmap) {
        return ImageUtils.bitmap2Bytes(bitmap);
    }

    static byte[] bitmap2Bytes(Bitmap bitmap, Bitmap.CompressFormat compressFormat, int i) {
        return ImageUtils.bitmap2Bytes(bitmap, compressFormat, i);
    }

    static Drawable bitmap2Drawable(Bitmap bitmap) {
        return ImageUtils.bitmap2Drawable(bitmap);
    }

    static String byte2FitMemorySize(long j) {
        return ConvertUtils.byte2FitMemorySize(j);
    }

    static Bitmap bytes2Bitmap(byte[] bArr) {
        return ImageUtils.bytes2Bitmap(bArr);
    }

    static Drawable bytes2Drawable(byte[] bArr) {
        return ImageUtils.bytes2Drawable(bArr);
    }

    static String bytes2HexString(byte[] bArr) {
        return ConvertUtils.bytes2HexString(bArr);
    }

    static boolean createFileByDeleteOldFile(File file) {
        return FileUtils.createFileByDeleteOldFile(file);
    }

    static boolean createOrExistsDir(File file) {
        return FileUtils.createOrExistsDir(file);
    }

    static boolean createOrExistsFile(File file) {
        return FileUtils.createOrExistsFile(file);
    }

    static boolean deleteAllInDir(File file) {
        return FileUtils.deleteAllInDir(file);
    }

    static int dp2px(float f) {
        return SizeUtils.dp2px(f);
    }

    static Bitmap drawable2Bitmap(Drawable drawable) {
        return ImageUtils.drawable2Bitmap(drawable);
    }

    static byte[] drawable2Bytes(Drawable drawable) {
        return ImageUtils.drawable2Bytes(drawable);
    }

    static byte[] drawable2Bytes(Drawable drawable, Bitmap.CompressFormat compressFormat, int i) {
        return ImageUtils.drawable2Bytes(drawable, compressFormat, i);
    }

    static boolean equals(CharSequence charSequence, CharSequence charSequence2) {
        return StringUtils.equals(charSequence, charSequence2);
    }

    static void finishAllActivities() {
        ActivityUtils.finishAllActivities();
    }

    static void fixSoftInputLeaks(Activity activity) {
        KeyboardUtils.fixSoftInputLeaks(activity);
    }

    static String format(@Nullable String str, Object... objArr) {
        return StringUtils.format(str, objArr);
    }

    static <T> T fromJson(String str, Type type) {
        return (T) GsonUtils.fromJson(str, type);
    }

    static Activity getActivityByContext(Context context) {
        return ActivityUtils.getActivityByContext(context);
    }

    static List<Activity> getActivityList() {
        return UtilsActivityLifecycleImpl.INSTANCE.getActivityList();
    }

    static int getAppScreenWidth() {
        return ScreenUtils.getAppScreenWidth();
    }

    static Application getApplicationByReflect() {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            return UtilsActivityLifecycleImpl.INSTANCE.getApplicationByReflect();
        }
        final AtomicReference atomicReference = new AtomicReference();
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        try {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.cloud.tmc.miniutils.util.n
                @Override // java.lang.Runnable
                public final void run() {
                    UtilsBridge.lambda$getApplicationByReflect$0(atomicReference, countDownLatch);
                }
            });
            if (countDownLatch.await(5000L, TimeUnit.MILLISECONDS)) {
                Log.e(TAG, "getApplicationByReflect: get app by reflection");
                return (Application) atomicReference.get();
            }
        } catch (InterruptedException e) {
            Log.e(TAG, "getApplicationByReflect: ", e);
            Thread.currentThread().interrupt();
        } catch (Throwable th) {
            Log.e(TAG, "getApplicationByReflect: ", th);
        }
        return (Application) atomicReference.get();
    }

    static Intent getDialIntent(String str) {
        return IntentUtils.getDialIntent(str);
    }

    static File getFileByPath(String str) {
        return FileUtils.getFileByPath(str);
    }

    static long getFsAvailableSize(String str) {
        return FileUtils.getFsAvailableSize(str);
    }

    static long getFsTotalSize(String str) {
        return FileUtils.getFsTotalSize(str);
    }

    static Intent getInstallAppIntent(Uri uri) {
        return IntentUtils.getInstallAppIntent(uri);
    }

    static Intent getInstallAppIntent(File file) {
        return IntentUtils.getInstallAppIntent(file);
    }

    static Intent getLaunchAppDetailsSettingsIntent(String str, boolean z) {
        return IntentUtils.getLaunchAppDetailsSettingsIntent(str, z);
    }

    static Intent getLaunchAppIntent(String str) {
        return IntentUtils.getLaunchAppIntent(str);
    }

    static String getLauncherActivity(String str) {
        return ActivityUtils.getLauncherActivity(str);
    }

    static int getNavBarHeight() {
        return BarUtils.getNavBarHeight();
    }

    static Intent getSendSmsIntent(String str, String str2) {
        return IntentUtils.getSendSmsIntent(str, str2);
    }

    static int getStatusBarHeight() {
        return BarUtils.getStatusBarHeight();
    }

    static String getString(int i) {
        return StringUtils.getString(i);
    }

    static String getString(int i, Object... objArr) {
        return StringUtils.getString(i, objArr);
    }

    static Activity getTopActivity() {
        return UtilsActivityLifecycleImpl.INSTANCE.getTopActivity();
    }

    static Intent getUninstallAppIntent(String str) {
        return IntentUtils.getUninstallAppIntent(str);
    }

    static byte[] hashTemplate(byte[] bArr, String str) {
        return EncryptUtils.hashTemplate(bArr, str);
    }

    static void init(Application application) {
        try {
            if (ProcessUtils.isMiniProcess()) {
                UtilsActivityLifecycleImpl.INSTANCE.init(application);
            }
        } catch (Throwable th) {
            Log.e(TAG, "init: " + th);
        }
    }

    static byte[] inputStream2Bytes(InputStream inputStream) {
        return ConvertUtils.inputStream2Bytes(inputStream);
    }

    static List<String> inputStream2Lines(InputStream inputStream, String str) {
        return ConvertUtils.inputStream2Lines(inputStream, str);
    }

    static boolean isActivityAlive(Activity activity) {
        return ActivityUtils.isActivityAlive(activity);
    }

    static boolean isAppDebug() {
        return AppUtils.isAppDebug();
    }

    @Deprecated
    static boolean isAppForeground() {
        return UtilsActivityLifecycleImpl.INSTANCE.isAppForeground();
    }

    static boolean isAppInstalled(String str) {
        return AppUtils.isAppInstalled(str);
    }

    static boolean isFileExists(File file) {
        return FileUtils.isFileExists(file);
    }

    static boolean isGranted(String... strArr) {
        return PermissionUtils.isGranted(strArr);
    }

    static boolean isGrantedDrawOverlays() {
        return PermissionUtils.isGrantedDrawOverlays();
    }

    static boolean isIntentAvailable(Intent intent) {
        return IntentUtils.isIntentAvailable(intent);
    }

    static boolean isLayoutRtl() {
        return ViewUtils.isLayoutRtl();
    }

    static boolean isSDCardEnableByEnvironment() {
        return SDCardUtils.isSDCardEnableByEnvironment();
    }

    static boolean isSpace(String str) {
        return StringUtils.isSpace(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$getApplicationByReflect$0(AtomicReference atomicReference, CountDownLatch countDownLatch) {
        atomicReference.set(UtilsActivityLifecycleImpl.INSTANCE.getApplicationByReflect());
        countDownLatch.countDown();
    }

    static View layoutId2View(int i) {
        return ViewUtils.layoutId2View(i);
    }

    static void notifySystemToScan(File file) {
        FileUtils.notifySystemToScan(file);
    }

    static int px2dp(float f) {
        return SizeUtils.px2dp(f);
    }

    static int px2sp(float f) {
        return SizeUtils.px2sp(f);
    }

    static void relaunchApp() {
        AppUtils.relaunchApp();
    }

    static void removeActivityLifecycleCallbacks(Activity activity) {
        UtilsActivityLifecycleImpl.INSTANCE.removeActivityLifecycleCallbacks(activity);
    }

    static void removeActivityLifecycleCallbacks(Activity activity, Utils.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        UtilsActivityLifecycleImpl.INSTANCE.removeActivityLifecycleCallbacks(activity, activityLifecycleCallbacks);
    }

    static void removeActivityLifecycleCallbacks(Utils.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        UtilsActivityLifecycleImpl.INSTANCE.removeActivityLifecycleCallbacks(activityLifecycleCallbacks);
    }

    static void removeOnAppStatusChangedListener(Utils.OnAppStatusChangedListener onAppStatusChangedListener) {
        UtilsActivityLifecycleImpl.INSTANCE.removeOnAppStatusChangedListener(onAppStatusChangedListener);
    }

    static void runOnUiThread(Runnable runnable) {
        mainHandler.post(runnable);
    }

    static void runOnUiThreadDelayed(Runnable runnable, long j) {
        mainHandler.postDelayed(runnable, j);
    }

    static int sp2px(float f) {
        return SizeUtils.sp2px(f);
    }

    static void startHomeActivity() {
        ActivityUtils.startHomeActivity();
    }

    static String toJson(Object obj) {
        return GsonUtils.toJson(obj);
    }

    static void unInit(Application application) {
        try {
            if (ProcessUtils.isMiniProcess()) {
                UtilsActivityLifecycleImpl.INSTANCE.unInit(application);
            }
        } catch (Throwable th) {
            Log.e(TAG, "unInit: " + th);
        }
    }

    static File uri2File(Uri uri) {
        return UriUtils.uri2File(uri);
    }

    static Bitmap view2Bitmap(View view) {
        return ImageUtils.view2Bitmap(view);
    }

    static boolean writeFileFromIS(String str, InputStream inputStream) {
        return FileIOUtils.writeFileFromIS(str, inputStream);
    }
}
