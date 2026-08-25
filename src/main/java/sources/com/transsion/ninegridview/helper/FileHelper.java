package com.transsion.ninegridview.helper;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.lifecycle.v;
import com.blankj.utilcode.util.Utils;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import java.util.concurrent.CancellationException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.a2;
import kotlinx.coroutines.i;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.t1;
import kotlinx.coroutines.y0;
import wf.a;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class FileHelper {
    public static final FileHelper a = new FileHelper();
    private static final String b = Environment.DIRECTORY_PICTURES;
    private static final int c = 100;
    private static t1 d;

    public static final class a {
        private File a;

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public a() {
            this(r0, 1, r0);
            File file = null;
        }

        public a(File file) {
            this.a = file;
        }

        public /* synthetic */ a(File file, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : file);
        }

        public final File a() {
            return this.a;
        }

        public final void b(File file) {
            this.a = file;
        }
    }

    private FileHelper() {
    }

    private final void d(AppCompatActivity appCompatActivity, Function0 function0) {
        if (Build.VERSION.SDK_INT >= 29) {
            function0.invoke();
        } else if (androidx.core.content.b.checkSelfPermission(appCompatActivity, "android.permission.WRITE_EXTERNAL_STORAGE") == 0 && androidx.core.content.b.checkSelfPermission(appCompatActivity, "android.permission.READ_EXTERNAL_STORAGE") == 0) {
            function0.invoke();
        } else {
            q(appCompatActivity);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x002b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object e(File file, Context context, String str, String str2, boolean z, Continuation continuation) {
        FileHelper$copyToAlbum$1 fileHelper$copyToAlbum$1;
        int i;
        Closeable closeable;
        Throwable th2;
        if (continuation instanceof FileHelper$copyToAlbum$1) {
            fileHelper$copyToAlbum$1 = (FileHelper$copyToAlbum$1) continuation;
            int i2 = fileHelper$copyToAlbum$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                fileHelper$copyToAlbum$1.label = i2 - Integer.MIN_VALUE;
                FileHelper$copyToAlbum$1 fileHelper$copyToAlbum$12 = fileHelper$copyToAlbum$1;
                Object obj = fileHelper$copyToAlbum$12.result;
                Object f = IntrinsicsKt.f();
                i = fileHelper$copyToAlbum$12.label;
                if (i != 0) {
                    ResultKt.b(obj);
                    try {
                        if (file.canRead() && file.exists()) {
                            FileInputStream fileInputStream = new FileInputStream(file);
                            try {
                                FileHelper fileHelper = a;
                                fileHelper$copyToAlbum$12.L$0 = fileInputStream;
                                fileHelper$copyToAlbum$12.label = 1;
                                Object u = fileHelper.u(fileInputStream, context, str, str2, z, fileHelper$copyToAlbum$12);
                                if (u == f) {
                                    return f;
                                }
                                closeable = fileInputStream;
                                obj = u;
                            } catch (Throwable th3) {
                                th = th3;
                                closeable = fileInputStream;
                                th2 = th;
                                throw th2;
                            }
                        }
                        a.a.f(wf.a.a, "FileHelper", "check: read file error: " + file, false, 4, (Object) null);
                        return null;
                    } catch (Exception e) {
                        e.printStackTrace();
                        return null;
                    }
                }
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                closeable = (Closeable) fileHelper$copyToAlbum$12.L$0;
                try {
                    ResultKt.b(obj);
                } catch (Throwable th4) {
                    th = th4;
                    th2 = th;
                    try {
                        throw th2;
                    } catch (Throwable th5) {
                        CloseableKt.a(closeable, th2);
                        throw th5;
                    }
                }
                Uri uri = (Uri) obj;
                CloseableKt.a(closeable, (Throwable) null);
                return uri;
            }
        }
        fileHelper$copyToAlbum$1 = new FileHelper$copyToAlbum$1(this, continuation);
        FileHelper$copyToAlbum$1 fileHelper$copyToAlbum$122 = fileHelper$copyToAlbum$1;
        Object obj2 = fileHelper$copyToAlbum$122.result;
        Object f2 = IntrinsicsKt.f();
        i = fileHelper$copyToAlbum$122.label;
        if (i != 0) {
        }
        Uri uri2 = (Uri) obj2;
        CloseableKt.a(closeable, (Throwable) null);
        return uri2;
    }

    public static /* synthetic */ void g(FileHelper fileHelper, File file, Context context, String str, String str2, boolean z, int i, Object obj) {
        if ((i & 16) != 0) {
            z = true;
        }
        fileHelper.f(file, context, str, str2, z);
    }

    private final void h(Uri uri, Context context, ContentResolver contentResolver, File file) {
        ContentValues contentValues = new ContentValues();
        if (Build.VERSION.SDK_INT >= 29) {
            contentValues.put("is_pending", (Integer) 0);
            contentResolver.update(uri, contentValues, null, null);
        } else {
            if (file != null) {
                contentValues.put("_size", Long.valueOf(file.length()));
            }
            contentResolver.update(uri, contentValues, null, null);
            context.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", uri));
        }
    }

    private final Bitmap.CompressFormat i(String str) {
        String lowerCase = str.toLowerCase(Locale.ROOT);
        Intrinsics.g(lowerCase, "toLowerCase(...)");
        return StringsKt.G(lowerCase, ".png", false, 2, (Object) null) ? Bitmap.CompressFormat.PNG : (StringsKt.G(lowerCase, ".jpg", false, 2, (Object) null) || StringsKt.G(lowerCase, ".jpeg", false, 2, (Object) null)) ? Bitmap.CompressFormat.JPEG : StringsKt.G(lowerCase, ".webp", false, 2, (Object) null) ? Build.VERSION.SDK_INT >= 30 ? com.cloud.tmc.integration.utils.compress.a.a() : Bitmap.CompressFormat.WEBP : Bitmap.CompressFormat.PNG;
    }

    private final String k(String str) {
        String lowerCase = str.toLowerCase(Locale.ROOT);
        Intrinsics.g(lowerCase, "toLowerCase(...)");
        if (StringsKt.G(lowerCase, ".png", false, 2, (Object) null)) {
            return "image/png";
        }
        if (StringsKt.G(lowerCase, ".jpg", false, 2, (Object) null) || StringsKt.G(lowerCase, ".jpeg", false, 2, (Object) null)) {
            return "image/jpeg";
        }
        if (StringsKt.G(lowerCase, ".webp", false, 2, (Object) null)) {
            return "image/webp";
        }
        if (StringsKt.G(lowerCase, ".gif", false, 2, (Object) null)) {
            return "image/gif";
        }
        return null;
    }

    private final OutputStream o(Uri uri, ContentResolver contentResolver) {
        try {
            return contentResolver.openOutputStream(uri);
        } catch (FileNotFoundException e) {
            a.a.f(wf.a.a, "FileHelper", "save: open stream error: " + e, false, 4, (Object) null);
            return null;
        }
    }

    private final Uri p(ContentResolver contentResolver, String str) {
        if (Build.VERSION.SDK_INT >= 29) {
            return null;
        }
        File file = new File(str);
        if (file.canRead() && file.exists()) {
            a.a.v(wf.a.a, "FileHelper", "query: path: " + str + " exists", false, 4, (Object) null);
            return Uri.fromFile(file);
        }
        Uri uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
        Cursor query = contentResolver.query(uri, new String[]{"_id", "_data"}, "_data == ?", new String[]{str}, null);
        if (query != null) {
            try {
                if (query.moveToNext()) {
                    Uri withAppendedId = ContentUris.withAppendedId(uri, query.getLong(query.getColumnIndexOrThrow("_id")));
                    Intrinsics.g(withAppendedId, "withAppendedId(...)");
                    a.a.v(wf.a.a, "FileHelper", "query: path: " + str + " exists uri: " + withAppendedId, false, 4, (Object) null);
                    CloseableKt.a(query, (Throwable) null);
                    return withAppendedId;
                }
                Unit unit = Unit.a;
                CloseableKt.a(query, (Throwable) null);
            } finally {
            }
        }
        return null;
    }

    private final void q(AppCompatActivity appCompatActivity) {
        ActivityCompat.g(appCompatActivity, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE"}, c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit s(AppCompatActivity appCompatActivity, String str, Bitmap bitmap, Function2 function2) {
        t1 t1Var = d;
        if (t1Var != null) {
            t1.a.b(t1Var, (CancellationException) null, 1, (Object) null);
        }
        d = i.d(v.a(appCompatActivity), y0.b(), (CoroutineStart) null, new FileHelper$saveBitmapToPicture$1$1(str, bitmap, appCompatActivity, function2, null), 2, (Object) null);
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0028  */
    /* JADX WARN: Type inference failed for: r4v0, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v1, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r4v13 */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v5 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object u(InputStream inputStream, Context context, String str, String str2, boolean z, Continuation continuation) {
        FileHelper$saveToAlbum$1 fileHelper$saveToAlbum$1;
        int i;
        Throwable th2;
        Uri uri;
        Closeable closeable;
        Closeable closeable2 = inputStream;
        try {
            if (continuation instanceof FileHelper$saveToAlbum$1) {
                fileHelper$saveToAlbum$1 = (FileHelper$saveToAlbum$1) continuation;
                int i2 = fileHelper$saveToAlbum$1.label;
                if ((i2 & Integer.MIN_VALUE) != 0) {
                    fileHelper$saveToAlbum$1.label = i2 - Integer.MIN_VALUE;
                    Object obj = fileHelper$saveToAlbum$1.result;
                    ?? f = IntrinsicsKt.f();
                    i = fileHelper$saveToAlbum$1.label;
                    int i3 = 1;
                    File file = null;
                    if (i != 0) {
                        ResultKt.b(obj);
                        ContentResolver contentResolver = context.getContentResolver();
                        a aVar = new a(file, i3, file);
                        Intrinsics.e(contentResolver);
                        Uri n = n(contentResolver, str, str2, aVar);
                        if (n == null) {
                            a.a.f(wf.a.a, "FileHelper", "insert: error: uri == null", false, 4, (Object) null);
                            return null;
                        }
                        OutputStream o = o(n, contentResolver);
                        if (o == null) {
                            return null;
                        }
                        try {
                            ByteStreamsKt.b(inputStream, o, 0, 2, (Object) null);
                            a.h(n, context, contentResolver, aVar.a());
                            a2 c2 = y0.c();
                            FileHelper$saveToAlbum$2$1$1 fileHelper$saveToAlbum$2$1$1 = new FileHelper$saveToAlbum$2$1$1(z, null);
                            fileHelper$saveToAlbum$1.L$0 = n;
                            fileHelper$saveToAlbum$1.L$1 = o;
                            fileHelper$saveToAlbum$1.L$2 = closeable2;
                            fileHelper$saveToAlbum$1.label = 1;
                            if (i.g(c2, fileHelper$saveToAlbum$2$1$1, fileHelper$saveToAlbum$1) == f) {
                                return f;
                            }
                            uri = n;
                            closeable = o;
                        } catch (Throwable th3) {
                            th2 = th3;
                            f = o;
                            throw th2;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        closeable2 = (Closeable) fileHelper$saveToAlbum$1.L$2;
                        closeable = (Closeable) fileHelper$saveToAlbum$1.L$1;
                        uri = (Uri) fileHelper$saveToAlbum$1.L$0;
                        try {
                            ResultKt.b(obj);
                            closeable = closeable;
                        } catch (Throwable th4) {
                            th2 = th4;
                            f = closeable;
                            try {
                                throw th2;
                            } catch (Throwable th5) {
                                CloseableKt.a(closeable2, th2);
                                throw th5;
                            }
                        }
                    }
                    Unit unit = Unit.a;
                    CloseableKt.a(closeable2, (Throwable) null);
                    CloseableKt.a(closeable, (Throwable) null);
                    return uri;
                }
            }
            if (i != 0) {
            }
            Unit unit2 = Unit.a;
            CloseableKt.a(closeable2, (Throwable) null);
            CloseableKt.a(closeable, (Throwable) null);
            return uri;
        } finally {
        }
        fileHelper$saveToAlbum$1 = new FileHelper$saveToAlbum$1(this, continuation);
        Object obj2 = fileHelper$saveToAlbum$1.result;
        ?? f2 = IntrinsicsKt.f();
        i = fileHelper$saveToAlbum$1.label;
        int i32 = 1;
        File file2 = null;
    }

    public static /* synthetic */ Uri v(FileHelper fileHelper, Bitmap bitmap, Context context, String str, String str2, int i, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            str2 = "MovieBox";
        }
        String str3 = str2;
        if ((i2 & 8) != 0) {
            i = 75;
        }
        return fileHelper.t(bitmap, context, str, str3, i);
    }

    public final void f(File file, Context context, String str, String str2, boolean z) {
        Intrinsics.h(file, "file");
        Intrinsics.h(context, "context");
        Intrinsics.h(str, "fileName");
        try {
            Result.Companion companion = Result.Companion;
            Result.constructor-impl(i.d(o0.a(y0.b()), (CoroutineContext) null, (CoroutineStart) null, new FileHelper$copyToAlbumAsync$1$1(this, file, context, str, str2, z, null), 3, (Object) null));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            Result.constructor-impl(ResultKt.a(th2));
        }
    }

    public final String j(String str) {
        List l;
        List l2;
        if (str == null) {
            return System.currentTimeMillis() + ".jpg";
        }
        int i = Utils.a().getApplicationInfo().uid;
        List split = new Regex("[?]").split(str, 0);
        if (!split.isEmpty()) {
            ListIterator listIterator = split.listIterator(split.size());
            while (listIterator.hasPrevious()) {
                if (((String) listIterator.previous()).length() != 0) {
                    l = CollectionsKt.K0(split, listIterator.nextIndex() + 1);
                    break;
                }
            }
        }
        l = CollectionsKt.l();
        String[] strArr = (String[]) l.toArray(new String[0]);
        if (!(strArr.length == 0)) {
            List split2 = new Regex("/").split(strArr[0], 0);
            if (!split2.isEmpty()) {
                ListIterator listIterator2 = split2.listIterator(split2.size());
                while (listIterator2.hasPrevious()) {
                    if (((String) listIterator2.previous()).length() != 0) {
                        l2 = CollectionsKt.K0(split2, listIterator2.nextIndex() + 1);
                        break;
                    }
                }
            }
            l2 = CollectionsKt.l();
            String[] strArr2 = (String[]) l2.toArray(new String[0]);
            if (!(strArr2.length == 0)) {
                return i + "_" + strArr2[strArr2.length - 1];
            }
        }
        return System.currentTimeMillis() + ".jpg";
    }

    public final int l() {
        return c;
    }

    public final File m(String str) {
        Intrinsics.h(str, "fileName");
        return new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), "MovieBox" + File.separator + str);
    }

    public final Uri n(ContentResolver contentResolver, String str, String str2, a aVar) {
        Uri uri;
        String str3;
        Intrinsics.h(contentResolver, "<this>");
        Intrinsics.h(str, "fileName");
        ContentValues contentValues = new ContentValues();
        String k = a.k(str);
        if (k != null) {
            contentValues.put("mime_type", k);
        }
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        contentValues.put("date_added", Long.valueOf(currentTimeMillis));
        contentValues.put("date_modified", Long.valueOf(currentTimeMillis));
        int i = 1;
        if (Build.VERSION.SDK_INT >= 29) {
            if (str2 != null) {
                str3 = b + "/" + str2;
            } else {
                str3 = b;
            }
            contentValues.put("_display_name", str);
            contentValues.put("relative_path", str3);
            contentValues.put("is_pending", (Integer) 1);
            uri = MediaStore.Images.Media.getContentUri("external_primary");
            Intrinsics.g(uri, "getContentUri(...)");
        } else {
            File externalStoragePublicDirectory = Environment.getExternalStoragePublicDirectory(b);
            if (str2 != null) {
                externalStoragePublicDirectory = new File(externalStoragePublicDirectory, str2);
            }
            if (!externalStoragePublicDirectory.exists() && !externalStoragePublicDirectory.mkdirs()) {
                a.a.f(wf.a.a, "FileHelper", "save: error: can't create Pictures directory", false, 4, (Object) null);
                return null;
            }
            File file = new File(externalStoragePublicDirectory, str);
            String x = FilesKt.x(file);
            String w = FilesKt.w(file);
            String absolutePath = file.getAbsolutePath();
            Intrinsics.g(absolutePath, "getAbsolutePath(...)");
            Uri p = p(contentResolver, absolutePath);
            while (p != null) {
                int i2 = i + 1;
                File file2 = new File(externalStoragePublicDirectory, x + "(" + i + ")." + w);
                String absolutePath2 = file2.getAbsolutePath();
                Intrinsics.g(absolutePath2, "getAbsolutePath(...)");
                Uri p2 = p(contentResolver, absolutePath2);
                i = i2;
                file = file2;
                p = p2;
            }
            contentValues.put("_display_name", file.getName());
            String absolutePath3 = file.getAbsolutePath();
            a.a.v(wf.a.a, "FileHelper", "save file: " + absolutePath3, false, 4, (Object) null);
            contentValues.put("_data", absolutePath3);
            if (aVar != null) {
                aVar.b(file);
            }
            uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
            Intrinsics.g(uri, "EXTERNAL_CONTENT_URI");
        }
        try {
            return contentResolver.insert(uri, contentValues);
        } catch (Throwable unused) {
            return null;
        }
    }

    public final void r(final AppCompatActivity appCompatActivity, final Bitmap bitmap, final String str, final Function2 function2) {
        Intrinsics.h(appCompatActivity, "activity");
        Intrinsics.h(str, "fileName");
        if (bitmap == null) {
            return;
        }
        d(appCompatActivity, new Function0() { // from class: com.transsion.ninegridview.helper.a
            public final Object invoke() {
                Unit s;
                s = FileHelper.s(appCompatActivity, str, bitmap, function2);
                return s;
            }
        });
    }

    public final Uri t(Bitmap bitmap, Context context, String str, String str2, int i) {
        Intrinsics.h(bitmap, "<this>");
        Intrinsics.h(context, "context");
        Intrinsics.h(str, "fileName");
        Intrinsics.h(str2, "relativePath");
        ContentResolver contentResolver = context.getContentResolver();
        File file = null;
        a aVar = new a(file, 1, file);
        Intrinsics.e(contentResolver);
        Uri n = n(contentResolver, str, str2, aVar);
        if (n == null) {
            a.a.f(wf.a.a, "FileHelper", "insert: error: uri == null", false, 4, (Object) null);
            return null;
        }
        OutputStream o = o(n, contentResolver);
        if (o == null) {
            return null;
        }
        try {
            FileHelper fileHelper = a;
            bitmap.compress(fileHelper.i(str), i, o);
            fileHelper.h(n, context, contentResolver, aVar.a());
            Unit unit = Unit.a;
            CloseableKt.a(o, (Throwable) null);
            return n;
        } finally {
        }
    }
}
