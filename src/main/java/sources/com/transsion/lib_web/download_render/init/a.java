package com.transsion.lib_web.download_render.init;

import cm.f;
import com.blankj.utilcode.util.Utils;
import com.blankj.utilcode.util.o;
import com.transsion.gslb.BuildConfig;
import com.transsion.gslb.NetResponse;
import com.transsion.lib_web.download_render.data.PageData;
import com.transsion.lib_web.download_render.data.PageListData;
import com.transsion.lib_web.download_render.data.config.ConfigData;
import com.transsion.mb.config.manager.ConfigBean;
import java.io.File;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import pl.h;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class a implements c {
    public static final C0035a a = new C0035a(null);
    private static long b = 104857600;
    private static long c = 2592000000L;
    private static long d = 2592000000L;

    /* renamed from: com.transsion.lib_web.download_render.init.a$a, reason: collision with other inner class name */
    public static final class C0035a {
        private C0035a() {
        }

        public /* synthetic */ C0035a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private final void a(Map map) {
        String str;
        String path;
        long currentTimeMillis = System.currentTimeMillis();
        long j = 0;
        Object obj = null;
        for (Map.Entry entry : map.entrySet()) {
            j += ((FileInfo) entry.getValue()).getSize();
            if (currentTimeMillis > ((FileInfo) entry.getValue()).getUsedTime()) {
                currentTimeMillis = ((FileInfo) entry.getValue()).getUsedTime();
                obj = entry.getValue();
            }
        }
        if (j > b) {
            FileInfo fileInfo = (FileInfo) obj;
            h.a.a("DR_", "<cacheSizeCheck> deleteFile url: " + (fileInfo != null ? fileInfo.getUrl() : null));
            String str2 = BuildConfig.FLAVOR;
            if (fileInfo == null || (str = fileInfo.getUrl()) == null) {
                str = BuildConfig.FLAVOR;
            }
            if (fileInfo != null && (path = fileInfo.getPath()) != null) {
                str2 = path;
            }
            b(str, new File(str2));
            com.transsion.lib_web.download_render.c.a.d(fileInfo != null ? fileInfo.getUrl() : null);
            TypeIntrinsics.d(map).remove(fileInfo != null ? fileInfo.getUrl() : null);
            a(map);
        }
    }

    private final void b(String str, File file) {
        if (file.exists()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                for (File file2 : listFiles) {
                    if (file2.isDirectory()) {
                        Intrinsics.e(file2);
                        b(str, file2);
                        file2.delete();
                    } else {
                        String absolutePath = file2.getAbsolutePath();
                        file2.delete();
                        Intrinsics.e(absolutePath);
                        int o0 = StringsKt.o0(absolutePath, "https:", 0, false, 6, (Object) null);
                        if (o0 != -1) {
                            String substring = absolutePath.substring(o0, absolutePath.length());
                            Intrinsics.g(substring, "substring(...)");
                            com.transsion.lib_web.download_render.c.a.c(str, StringsKt.Q(substring, "https:/", "https://", false, 4, (Object) null));
                        }
                    }
                }
            }
            file.delete();
        }
    }

    private final long c(File file) {
        long length;
        long j = 0;
        if (!file.exists()) {
            return 0L;
        }
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    Intrinsics.e(file2);
                    length = c(file2);
                } else {
                    length = file2.length();
                }
                j += length;
            }
        }
        return j;
    }

    private final void d(Map map) {
        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            if (System.currentTimeMillis() - ((FileInfo) entry.getValue()).getUsedTime() > c && System.currentTimeMillis() - ((FileInfo) entry.getValue()).getUpgradeTime() > d) {
                h.a.a("DR_", "<validTimeCheck> deleteFile url: " + ((FileInfo) entry.getValue()).getUrl());
                b(((FileInfo) entry.getValue()).getUrl(), new File(((FileInfo) entry.getValue()).getPath()));
                com.transsion.lib_web.download_render.c.a.d(((FileInfo) entry.getValue()).getUrl());
                it.remove();
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0026, code lost:
    
        if (r9 == null) goto L11;
     */
    @Override // com.transsion.lib_web.download_render.init.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void invoke() {
        List<PageData> l;
        Long upgradeTime;
        Long usedTime;
        String str;
        String value;
        try {
            ConfigBean d2 = f.d(f.c.a(), "dr_config", false, 2, (Object) null);
            if (d2 != null && (value = d2.getValue()) != null) {
                str = StringsKt.q0(value) ? null : value;
            }
            str = NetResponse.EMPTY_RESPONSE;
            ConfigData configData = (ConfigData) o.d(str, ConfigData.class);
            b = RangesKt.f(configData.getMaxCacheSize(), 0L);
            c = RangesKt.f(configData.getMaxUsedTime(), 0L);
            d = RangesKt.f(configData.getMaxUpgradeTime(), 0L);
            h.a.a("DR_Config", "config:" + str + ", maxCacheSize:" + b + ", maxUsedTime:" + c + ", maxUpgradeTime:" + d);
        } catch (Throwable unused) {
        }
        try {
            com.transsion.lib_web.download_render.utils.c cVar = com.transsion.lib_web.download_render.utils.c.a;
            String absolutePath = new File(Utils.a().getFilesDir(), "DownloadRender").getAbsolutePath();
            Intrinsics.g(absolutePath, "getAbsolutePath(...)");
            List<File> c2 = cVar.c(absolutePath);
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (File file : c2) {
                long c3 = c(new File(Utils.a().getFilesDir(), "DownloadRender"));
                com.transsion.lib_web.download_render.c cVar2 = com.transsion.lib_web.download_render.c.a;
                String i = cVar2.i(file.getName());
                if (i == null) {
                    i = String.valueOf(System.currentTimeMillis());
                }
                PageData g = cVar2.g(i);
                long longValue = (g == null || (usedTime = g.getUsedTime()) == null) ? 0L : usedTime.longValue();
                long longValue2 = (g == null || (upgradeTime = g.getUpgradeTime()) == null) ? 0L : upgradeTime.longValue();
                String absolutePath2 = file.getAbsolutePath();
                Intrinsics.g(absolutePath2, "getAbsolutePath(...)");
                linkedHashMap.put(i, new FileInfo(i, c3, longValue, longValue2, absolutePath2));
            }
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            PageListData l2 = com.transsion.lib_web.download_render.c.a.l();
            if (l2 == null || (l = l2.getH5Pages()) == null) {
                l = CollectionsKt.l();
            }
            for (Map.Entry entry : linkedHashMap.entrySet()) {
                Iterator<T> it = l.iterator();
                boolean z = false;
                while (it.hasNext()) {
                    if (Intrinsics.c(((PageData) it.next()).getUrl(), ((FileInfo) entry.getValue()).getUrl())) {
                        z = true;
                    }
                }
                if (!z) {
                    linkedHashMap2.put(entry.getKey(), entry.getValue());
                }
            }
            a(linkedHashMap2);
            d(linkedHashMap2);
        } catch (Throwable th2) {
            h.a.b("DR_", "<DiskSpaceCheckTask> fail:" + th2);
        }
    }
}
