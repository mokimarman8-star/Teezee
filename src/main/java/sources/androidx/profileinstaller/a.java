package androidx.profileinstaller;

import android.content.Context;
import android.os.Build;
import java.io.File;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
abstract class a {

    /* renamed from: androidx.profileinstaller.a$a, reason: collision with other inner class name */
    private static class C0092a {
        static File a(Context context) {
            return context.getCodeCacheDir();
        }
    }

    private static class b {
        static Context a(Context context) {
            Context createDeviceProtectedStorageContext;
            createDeviceProtectedStorageContext = context.createDeviceProtectedStorageContext();
            return createDeviceProtectedStorageContext;
        }
    }

    static boolean a(File file) {
        if (!file.isDirectory()) {
            file.delete();
            return true;
        }
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            return false;
        }
        boolean z5 = true;
        for (File file2 : listFiles) {
            z5 = a(file2) && z5;
        }
        return z5;
    }

    static void b(Context context, ProfileInstallReceiver$a profileInstallReceiver$a) {
        int i5 = Build.VERSION.SDK_INT;
        if (a(i5 >= 34 ? b.a(context).getCacheDir() : i5 >= 24 ? C0092a.a(b.a(context)) : i5 == 23 ? C0092a.a(context) : context.getCacheDir())) {
            profileInstallReceiver$a.a(14, null);
        } else {
            profileInstallReceiver$a.a(15, null);
        }
    }
}
