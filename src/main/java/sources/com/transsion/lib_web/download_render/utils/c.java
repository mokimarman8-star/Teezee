package com.transsion.lib_web.download_render.utils;

import android.net.Uri;
import com.blankj.utilcode.util.Utils;
import com.transsion.gslb.BuildConfig;
import java.io.File;
import java.io.FileFilter;
import java.util.List;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class c {
    public static final c a = new c();

    private c() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean d(File file) {
        return file.isDirectory();
    }

    public final File b(String str, String str2, String str3, String str4) {
        int v0;
        Intrinsics.h(str, "url");
        Intrinsics.h(str2, "fileUrl");
        Intrinsics.h(str3, "fileMd5");
        File file = new File(Utils.a().getFilesDir(), "DownloadRender");
        if (!file.exists()) {
            file.mkdirs();
        }
        File file2 = new File(file, wg.a.a.a(str));
        if (!file2.exists()) {
            file2.mkdirs();
        }
        Uri parse = Uri.parse(str2);
        Intrinsics.g(parse, "parse(this)");
        String lastPathSegment = parse.getLastPathSegment();
        String str5 = BuildConfig.FLAVOR;
        if (lastPathSegment == null) {
            lastPathSegment = BuildConfig.FLAVOR;
        }
        int v02 = StringsKt.v0(lastPathSegment, ".", 0, false, 6, (Object) null);
        if (v02 != -1) {
            str5 = lastPathSegment.substring(v02, lastPathSegment.length());
            Intrinsics.g(str5, "substring(...)");
        }
        if (str5.length() == 0 && str4 != null && (v0 = StringsKt.v0(str4, "/", 0, false, 6, (Object) null)) != -1) {
            String substring = str4.substring(v0, str4.length());
            Intrinsics.g(substring, "substring(...)");
            str5 = StringsKt.Q(substring, "/", ".", false, 4, (Object) null);
        }
        return new File(file2, str3 + ((Object) str5));
    }

    public final List c(String str) {
        List G0;
        Intrinsics.h(str, "path");
        File file = new File(str);
        if (!file.exists() || !file.isDirectory()) {
            return CollectionsKt.l();
        }
        File[] listFiles = file.listFiles(new FileFilter() { // from class: com.transsion.lib_web.download_render.utils.b
            @Override // java.io.FileFilter
            public final boolean accept(File file2) {
                boolean d;
                d = c.d(file2);
                return d;
            }
        });
        return (listFiles == null || (G0 = ArraysKt.G0(listFiles)) == null) ? CollectionsKt.l() : G0;
    }
}
