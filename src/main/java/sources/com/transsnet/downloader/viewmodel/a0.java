package com.transsnet.downloader.viewmodel;

import android.app.Activity;
import android.app.Application;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.app.ActivityCompat;
import androidx.core.content.f;
import com.blankj.utilcode.util.Utils;
import com.transsion.baseui.util.TimeUtilKt;
import com.transsnet.downloader.R;
import com.vungle.ads.internal.signals.SignalManager;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.HttpUrl;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class a0 {
    public static final a0 a = new a0();
    private static final ContentResolver b = Utils.a().getContentResolver();

    private a0() {
    }

    private final boolean b(File file) {
        boolean z = true;
        if (file == null || file.exists()) {
            return true;
        }
        File parentFile = file.getParentFile();
        if (parentFile != null && !parentFile.exists()) {
            return b(parentFile);
        }
        if (!file.mkdirs() && !file.exists()) {
            z = false;
        }
        if (!z) {
            Log.e("FileUtil", "createFileDir fail " + file);
        }
        return z;
    }

    private final void c(File file) {
        b(file);
        if (file.exists() && file.isDirectory()) {
            file.delete();
        }
        if (file.exists()) {
            return;
        }
        try {
            if (file.createNewFile()) {
                return;
            }
            t("create file failure --> file.path = " + file.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private final File g(Context context) {
        File filesDir = Utils.a().getFilesDir();
        if (filesDir == null) {
            return null;
        }
        File file = new File(filesDir, "outside");
        if (file.mkdirs() || (file.exists() && file.isDirectory())) {
            return file;
        }
        return null;
    }

    private final File h(String str) {
        Application a2 = Utils.a();
        Intrinsics.g(a2, "getApp(...)");
        File g = g(a2);
        File file = new File(i(g != null ? g.getAbsolutePath() : null, str));
        c(file);
        return file;
    }

    private final String i(String str, String str2) {
        return str + File.separator + str2 + ".jpg";
    }

    private final String[] l() {
        return Build.VERSION.SDK_INT < 33 ? new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"} : new String[]{"android.permission.READ_MEDIA_VIDEO"};
    }

    private final boolean q(long j, String str) {
        Date date = new Date(j);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str);
        String format = simpleDateFormat.format(date);
        Intrinsics.g(format, "format(...)");
        String format2 = simpleDateFormat.format(new Date());
        Intrinsics.g(format2, "format(...)");
        return Intrinsics.c(format, format2);
    }

    private final boolean r(long j) {
        return q(j, "yyyy-MM-dd");
    }

    private final boolean s(long j) {
        Date k = com.blankj.utilcode.util.c0.k(com.blankj.utilcode.util.c0.h(j));
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date parse = simpleDateFormat.parse(simpleDateFormat.format(date));
        if (parse == null) {
            return false;
        }
        long time = parse.getTime() - k.getTime();
        return 1 <= time && time < SignalManager.TWENTY_FOUR_HOURS_MILLIS;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterative(DepthRegionTraversal.java:31)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visit(SwitchOverStringVisitor.java:60)
     */
    private final String v(String str) {
        int hashCode = str.hashCode();
        switch (hashCode) {
            case 1537:
                if (!str.equals("01")) {
                }
                break;
            case 1538:
                if (!str.equals("02")) {
                }
                break;
            case 1539:
                if (!str.equals("03")) {
                }
                break;
            case 1540:
                if (!str.equals("04")) {
                }
                break;
            case 1541:
                if (!str.equals("05")) {
                }
                break;
            case 1542:
                if (!str.equals("06")) {
                }
                break;
            case 1543:
                if (!str.equals("07")) {
                }
                break;
            case 1544:
                if (!str.equals("08")) {
                }
                break;
            case 1545:
                if (!str.equals("09")) {
                }
                break;
            default:
                switch (hashCode) {
                    case 1567:
                        if (!str.equals("10")) {
                        }
                        break;
                    case 1568:
                        if (!str.equals("11")) {
                        }
                        break;
                    case 1569:
                        if (!str.equals("12")) {
                        }
                        break;
                }
        }
        return str;
    }

    public final boolean a() {
        return (Build.VERSION.SDK_INT < 33 ? f.b(Utils.a(), "android.permission.WRITE_EXTERNAL_STORAGE") : androidx.core.content.b.checkSelfPermission(Utils.a(), "android.permission.READ_MEDIA_VIDEO")) == 0;
    }

    public final Bitmap d(String path) {
        Intrinsics.h(path, "path");
        if (TextUtils.isEmpty(path)) {
            return null;
        }
        return BitmapFactory.decodeFile(path);
    }

    public final long e(String filePath) {
        Intrinsics.h(filePath, "filePath");
        return com.blankj.utilcode.util.c0.a(new Date(new File(filePath).lastModified()));
    }

    public final long f(String path) {
        Intrinsics.h(path, "path");
        return new File(path).length();
    }

    public final String j(j0 video) {
        Intrinsics.h(video, "video");
        try {
            Application a2 = Utils.a();
            Intrinsics.g(a2, "getApp(...)");
            File g = g(a2);
            String absolutePath = g != null ? g.getAbsolutePath() : null;
            String e = video.e();
            if (e == null) {
                e = HttpUrl.FRAGMENT_ENCODE_SET;
            }
            File file = new File(i(absolutePath, k(e)));
            if (file.exists() && file.isFile()) {
                String absolutePath2 = file.getAbsolutePath();
                Intrinsics.g(absolutePath2, "getAbsolutePath(...)");
                return absolutePath2;
            }
        } catch (Exception e2) {
            t("getLocalVideoCover e = " + Log.getStackTraceString(e2));
        }
        return HttpUrl.FRAGMENT_ENCODE_SET;
    }

    public final String k(String filePath) {
        Intrinsics.h(filePath, "filePath");
        if (TextUtils.isEmpty(filePath)) {
            return HttpUrl.FRAGMENT_ENCODE_SET;
        }
        String name = new File(filePath).getName();
        Intrinsics.g(name, "getName(...)");
        return name;
    }

    public final Bitmap m(j0 video) {
        Intrinsics.h(video, "video");
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inDither = false;
        options.inPreferredConfig = Bitmap.Config.ARGB_8888;
        Bitmap thumbnail = MediaStore.Video.Thumbnails.getThumbnail(b, video.c(), 1, options);
        u("getVideoThumbnail --- name = " + video.d() + " ----  bitmap = " + thumbnail);
        return thumbnail;
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x00bc, code lost:
    
        if (r1 == null) goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final List n() {
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            try {
                cursor = b.query(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, null, null, null, "title");
                while (true) {
                    Intrinsics.e(cursor);
                    if (!cursor.moveToNext()) {
                        break;
                    }
                    String string = cursor.getString(cursor.getColumnIndexOrThrow("_data"));
                    if (o(string)) {
                        int i = cursor.getInt(cursor.getColumnIndexOrThrow("_id"));
                        String string2 = cursor.getString(cursor.getColumnIndexOrThrow("_display_name"));
                        String string3 = cursor.getString(cursor.getColumnIndexOrThrow("resolution"));
                        long j = cursor.getLong(cursor.getColumnIndexOrThrow("_size"));
                        long j2 = cursor.getLong(cursor.getColumnIndexOrThrow("duration"));
                        arrayList.add(new j0(i, string, string2, string3, Long.valueOf(j), Long.valueOf(cursor.getLong(cursor.getColumnIndexOrThrow("date_modified"))), Long.valueOf(j2), cursor.getInt(cursor.getColumnIndexOrThrow("width")), cursor.getInt(cursor.getColumnIndexOrThrow("height"))));
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                u("出问题了 --- " + Log.getStackTraceString(e));
            }
            cursor.close();
            return arrayList;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    public final boolean o(String str) {
        if (str != null) {
            return new File(str).exists();
        }
        return false;
    }

    public final boolean p(Activity activity) {
        Intrinsics.h(activity, "activity");
        com.transsion.baselib.report.launch.b bVar = com.transsion.baselib.report.launch.b.a;
        if (bVar.b().getBoolean("download_local_permission_first", true)) {
            bVar.b().putBoolean("download_local_permission_first", false);
            return false;
        }
        boolean z = false;
        for (String str : l()) {
            if (!ActivityCompat.j(activity, str)) {
                z = true;
            }
        }
        return z;
    }

    public final void t(String msg) {
        Intrinsics.h(msg, "msg");
    }

    public final void u(String msg) {
        Intrinsics.h(msg, "msg");
        Log.e("zxb_log_historical", msg);
    }

    public final String w(String str, Bitmap bm) {
        String absolutePath;
        Intrinsics.h(bm, "bm");
        String str2 = HttpUrl.FRAGMENT_ENCODE_SET;
        File h = h(str);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(h);
            bm.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
            absolutePath = h.getAbsolutePath();
            Intrinsics.g(absolutePath, "getAbsolutePath(...)");
        } catch (IOException e) {
            e = e;
        }
        try {
            t("the picture is save to your phone! --- coverPath = " + absolutePath);
            return absolutePath;
        } catch (IOException e2) {
            e = e2;
            str2 = absolutePath;
            e.printStackTrace();
            t("保存图片出现了异常 --- ex = " + Log.getStackTraceString(e));
            return str2;
        }
    }

    public final void x() {
        try {
            Intent intent = new Intent(Utils.a().getPackageName());
            intent.setFlags(268435456);
            intent.setComponent(new ComponentName("com.google.android.permissioncontroller", "com.android.permissioncontroller.permission.ui.ManagePermissionsActivity"));
            Utils.a().startActivity(intent);
        } catch (Exception e) {
            u("跳转应用权限设置界面失败 e = " + Log.getStackTraceString(e));
            y();
        }
    }

    public final void y() {
        Intent intent = new Intent();
        intent.addFlags(268435456);
        intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", Utils.a().getPackageName(), null));
        Utils.a().startActivity(intent);
    }

    public final String z(long j) {
        if (r(j)) {
            String string = Utils.a().getString(R.string.download_today);
            Intrinsics.g(string, "getString(...)");
            return string;
        }
        if (s(j)) {
            String string2 = Utils.a().getString(R.string.download_yesterday);
            Intrinsics.g(string2, "getString(...)");
            return string2;
        }
        String l = TimeUtilKt.l(j);
        if (l.length() != 5) {
            return l;
        }
        List S0 = StringsKt.S0(l, new String[]{"-"}, false, 0, 6, null);
        return v((String) S0.get(0)) + "." + S0.get(1);
    }
}
