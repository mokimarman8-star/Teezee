package androidx.core.app;

import android.app.Activity;
import android.content.pm.PackageManager;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
class ActivityCompat$1 implements Runnable {
    final /* synthetic */ Activity val$activity;
    final /* synthetic */ String[] val$permissionsArray;
    final /* synthetic */ int val$requestCode;

    ActivityCompat$1(String[] strArr, Activity activity, int i5) {
        this.val$permissionsArray = strArr;
        this.val$activity = activity;
        this.val$requestCode = i5;
    }

    @Override // java.lang.Runnable
    public void run() {
        int[] iArr = new int[this.val$permissionsArray.length];
        PackageManager packageManager = this.val$activity.getPackageManager();
        String packageName = this.val$activity.getPackageName();
        int length = this.val$permissionsArray.length;
        for (int i5 = 0; i5 < length; i5++) {
            iArr[i5] = packageManager.checkPermission(this.val$permissionsArray[i5], packageName);
        }
        ((ActivityCompat$e) this.val$activity).onRequestPermissionsResult(this.val$requestCode, this.val$permissionsArray, iArr);
    }
}
