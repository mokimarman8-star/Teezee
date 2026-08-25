package com.cloud.h5update.utils;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import com.cloud.h5update.TH5Update;
import com.cloud.tmc.integration.bridge.NativeRequestBridge;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public abstract class h {
    public static final a a;
    private static final String b;
    private static final String c;
    private static final String d;
    private static final String e;
    private static final String f;
    private static final String g;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final void f(Closeable... closeableArr) {
            for (Closeable closeable : closeableArr) {
                if (closeable != null) {
                    try {
                        closeable.close();
                    } catch (IOException unused) {
                    }
                }
            }
        }

        private final ContentResolver g() {
            ContentResolver contentResolver = TH5Update.c.c().getContentResolver();
            Intrinsics.g(contentResolver, "getContext().contentResolver");
            return contentResolver;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String i() {
            String absolutePath = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).getAbsolutePath();
            Intrinsics.g(absolutePath, "getExternalStoragePublic…            .absolutePath");
            return absolutePath;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String j() {
            String absolutePath = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getAbsolutePath();
            Intrinsics.g(absolutePath, "getExternalStoragePublic…            .absolutePath");
            return absolutePath;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String k() {
            String absolutePath = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).getAbsolutePath();
            Intrinsics.g(absolutePath, "getExternalStoragePublic…            .absolutePath");
            return absolutePath;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String l() {
            String absolutePath = Environment.getExternalStorageDirectory().getAbsolutePath();
            Intrinsics.g(absolutePath, "getExternalStorageDirectory().absolutePath");
            return absolutePath;
        }

        private final Uri o(Context context, File file) {
            try {
                String absolutePath = file.getAbsolutePath();
                Uri uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                Cursor query = context.getContentResolver().query(uri, new String[]{"_id"}, "_data=? ", new String[]{absolutePath}, null);
                if (query == null || !query.moveToFirst()) {
                    if (!file.exists()) {
                        return null;
                    }
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("_data", absolutePath);
                    return context.getContentResolver().insert(uri, contentValues);
                }
                int i = query.getInt(query.getColumnIndex("_id"));
                query.close();
                return Uri.withAppendedPath(uri, "" + i);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }

        private final Uri q(File file) {
            if (file == null) {
                return null;
            }
            return Uri.fromFile(file);
        }

        private final boolean s(String str) {
            File m = m(str);
            if (m == null) {
                return false;
            }
            if (m.exists()) {
                return true;
            }
            return t(str);
        }

        private final boolean t(String str) {
            if (Build.VERSION.SDK_INT >= 29) {
                try {
                    AssetFileDescriptor z = z(Uri.parse(str));
                    if (z == null) {
                        f(z);
                        return false;
                    }
                    f(z);
                    f(z);
                    return true;
                } catch (FileNotFoundException unused) {
                    f(null);
                } catch (Throwable th) {
                    f(null);
                    throw th;
                }
            }
            return false;
        }

        private final boolean v(File file) {
            if (file == null) {
                return false;
            }
            try {
                String canonicalPath = file.getCanonicalPath();
                Intrinsics.g(canonicalPath, "file.canonicalPath");
                return w(canonicalPath);
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
        }

        private final boolean w(String str) {
            return (y(str) || !StringsKt.W(str, h.b, false, 2, (Object) null) || StringsKt.W(str, h.d, false, 2, (Object) null)) ? false : true;
        }

        private final boolean x() {
            boolean isExternalStorageLegacy;
            if (Build.VERSION.SDK_INT >= 29) {
                isExternalStorageLegacy = Environment.isExternalStorageLegacy();
                if (!isExternalStorageLegacy) {
                    return true;
                }
            }
            return false;
        }

        private final boolean y(String str) {
            if (str == null) {
                return true;
            }
            int length = str.length();
            for (int i = 0; i < length; i++) {
                if (!Character.isWhitespace(str.charAt(i))) {
                    return false;
                }
            }
            return true;
        }

        public final void e(Closeable... closeableArr) {
            Intrinsics.h(closeableArr, "closeables");
            for (Closeable closeable : closeableArr) {
                if (closeable != null) {
                    try {
                        closeable.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        public final Uri h(Context context, File file) {
            Uri uri;
            Intrinsics.h(context, "context");
            Intrinsics.h(file, "file");
            try {
                String absolutePath = file.getAbsolutePath();
                uri = MediaStore.Downloads.EXTERNAL_CONTENT_URI;
                Intrinsics.g(uri, "EXTERNAL_CONTENT_URI");
                Cursor query = context.getContentResolver().query(uri, new String[]{"_id"}, "_data=? ", new String[]{absolutePath}, null);
                if (query == null || !query.moveToFirst()) {
                    if (!file.exists()) {
                        return null;
                    }
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("_data", absolutePath);
                    return context.getContentResolver().insert(uri, contentValues);
                }
                int i = query.getInt(query.getColumnIndex("_id"));
                query.close();
                return Uri.withAppendedPath(uri, "" + i);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }

        public final File m(String str) {
            if (str == null || StringsKt.q0(str) || y(str)) {
                return null;
            }
            return new File(str);
        }

        public final InputStream n(File file) {
            InputStream inputStream = null;
            try {
                if (x()) {
                    Uri p = p(file);
                    if (p == null) {
                        return null;
                    }
                    inputStream = g().openInputStream(p);
                } else {
                    inputStream = new FileInputStream(file);
                }
            } catch (Exception e) {
                rf.b.a.e(e);
            }
            return inputStream;
        }

        public final Uri p(File file) {
            if (file == null) {
                return null;
            }
            if (!x() || !v(file)) {
                return q(file);
            }
            String absolutePath = file.getAbsolutePath();
            Intrinsics.g(absolutePath, NativeRequestBridge.KEY_FILE_PATH);
            return StringsKt.W(absolutePath, h.e, false, 2, (Object) null) ? h(TH5Update.c.c(), file) : (StringsKt.W(absolutePath, h.f, false, 2, (Object) null) || StringsKt.W(absolutePath, h.g, false, 2, (Object) null)) ? o(TH5Update.c.c(), file) : q(file);
        }

        public final boolean r(File file) {
            if (file == null) {
                return false;
            }
            if (file.exists()) {
                return true;
            }
            return s(file.getAbsolutePath());
        }

        public final boolean u(String str, File file) {
            return str == null || StringsKt.q0(str) || StringsKt.H(str, i.a.b(file), true);
        }

        public final AssetFileDescriptor z(Uri uri) {
            ContentResolver g = g();
            Intrinsics.e(uri);
            return g.openAssetFileDescriptor(uri, "r");
        }
    }

    static {
        a aVar = new a(null);
        a = aVar;
        String l = aVar.l();
        b = l;
        String str = l + File.separator;
        c = str;
        d = str + "Android";
        e = aVar.j();
        f = aVar.k();
        g = aVar.i();
    }
}
