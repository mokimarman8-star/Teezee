package com.transsion.lib_web.download_render;

import com.blankj.utilcode.util.Utils;
import com.blankj.utilcode.util.o;
import com.google.gson.Gson;
import com.tencent.mmkv.MMKV;
import com.transsion.baselib.db.download.DownloadException;
import com.transsion.gslb.BuildConfig;
import com.transsion.lib_web.download_render.data.FileData;
import com.transsion.lib_web.download_render.data.FileOperateStatus;
import com.transsion.lib_web.download_render.data.PageData;
import com.transsion.lib_web.download_render.data.PageListData;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import pl.h;
import wg.a;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class c {
    public static final c a = new c();
    private static final Lazy b = LazyKt.b(new Function0() { // from class: com.transsion.lib_web.download_render.b
        public final Object invoke() {
            MMKV m;
            m = c.m();
            return m;
        }
    });
    private static final AtomicBoolean c = new AtomicBoolean(false);
    private static final PageListData d = new PageListData(null, new ArrayList(), new HashMap(), 1, null);

    private c() {
    }

    private final MMKV j() {
        Object value = b.getValue();
        Intrinsics.g(value, "getValue(...)");
        return (MMKV) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MMKV m() {
        return MMKV.I("web_file_download_with_render_page_list_data");
    }

    private final void n(PageData pageData) {
        String url = pageData.getUrl();
        if (url != null) {
            d.getLocalH5Pages().put(url, pageData);
        }
    }

    private final PageData q(String str) {
        PageData pageData;
        boolean z;
        String fileUrl;
        String str2 = null;
        try {
            PageData pageData2 = r15;
            PageData pageData3 = new PageData(null, null, null, null, null, new LinkedHashMap(), null, null, null, 479, null);
            MMKV I = MMKV.I("web_file_download_with_render_page_data_" + str);
            String[] a2 = I.a();
            boolean z2 = false;
            if (a2 == null) {
                a2 = new String[0];
            }
            String[] strArr = a2;
            if (strArr.length == 0) {
                return null;
            }
            int length = strArr.length;
            int i = 0;
            while (i < length) {
                String str3 = strArr[i];
                if (I.c(str3)) {
                    if (Intrinsics.c(str3, "pageUrl")) {
                        String string = I.getString("pageUrl", str2);
                        h.a.a("DR_FileDownloadDataManager", "<syncLocalPageData> url: " + string);
                        pageData = pageData2;
                        pageData.setUrl(string);
                    } else {
                        pageData = pageData2;
                        if (Intrinsics.c(str3, "pageVersion")) {
                            String string2 = I.getString("pageVersion", str2);
                            h.a.a("DR_FileDownloadDataManager", "<syncLocalPageData> versionCode: " + string2);
                            pageData.setVersionCode(string2);
                        } else {
                            if (Intrinsics.c(str3, "pageUpgradeTime")) {
                                long j = I.getLong("pageUpgradeTime", 0L);
                                h.a.a("DR_FileDownloadDataManager", "<syncLocalPageData> upgradeTime: " + j);
                                pageData.setUpgradeTime(Long.valueOf(j));
                            } else if (Intrinsics.c(str3, "pageUsedTime")) {
                                long j2 = I.getLong("pageUsedTime", 0L);
                                h.a.a("DR_FileDownloadDataManager", "<syncLocalPageData> usedTime: " + j2);
                                pageData.setUsedTime(Long.valueOf(j2));
                            } else if (Intrinsics.c(str3, "pageDownloadStatus")) {
                                z = false;
                                boolean z3 = I.getBoolean("pageDownloadStatus", false);
                                h.a.a("DR_FileDownloadDataManager", "<syncLocalPageData> downloadStatus: " + z3);
                                pageData.setDownloadStatus(Boolean.valueOf(z3));
                            } else {
                                z = false;
                                try {
                                    FileData fileData = (FileData) new Gson().fromJson(I.getString(str3, BuildConfig.FLAVOR), FileData.class);
                                    if (fileData != null && (fileUrl = fileData.getFileUrl()) != null) {
                                        pageData.getLocalFileMap().put(fileUrl, fileData);
                                    }
                                } catch (Throwable th2) {
                                    h.a.b("DR_FileDownloadDataManager", "<syncLocalPageData> getFile fail: " + th2);
                                }
                            }
                            z = false;
                        }
                    }
                    z = z2;
                } else {
                    z = z2;
                    pageData = pageData2;
                }
                i++;
                z2 = z;
                pageData2 = pageData;
                str2 = null;
            }
            PageData pageData4 = pageData2;
            try {
                n(pageData4);
                return pageData4;
            } catch (Throwable th3) {
                th = th3;
                h.a.b("DR_FileDownloadDataManager", "<syncLocalPageData> fail: " + th);
                return null;
            }
        } catch (Throwable th4) {
            th = th4;
            h.a.b("DR_FileDownloadDataManager", "<syncLocalPageData> fail: " + th);
            return null;
        }
    }

    public final void b(String str, String str2, FileData fileData) {
        FileData fileData2;
        Intrinsics.h(str, "url");
        Intrinsics.h(str2, "version");
        Intrinsics.h(fileData, "fileData");
        try {
            PageListData pageListData = d;
            if (!pageListData.getLocalH5Pages().containsKey(str)) {
                pageListData.getLocalH5Pages().put(str, new PageData(str, str2, null, null, null, null, null, null, null, DownloadException.EXCEPTION_IO_MALFORMED_URL, null));
            }
            String fileUrl = fileData.getFileUrl();
            if (fileUrl != null) {
                PageData pageData = pageListData.getLocalH5Pages().get(str);
                if (pageData != null) {
                    pageData.setVersionCode(str2);
                    fileData2 = fileData;
                    pageData.getLocalFileMap().put(fileUrl, fileData2);
                } else {
                    fileData2 = fileData;
                }
                a.a aVar = wg.a.a;
                MMKV.I("web_file_download_with_render_page_data_" + aVar.a(str)).putString(aVar.a(fileUrl), new Gson().toJson(fileData2));
            }
        } catch (Throwable th2) {
            h.a.b("DR_FileDownloadDataManager", "<addLocalFile> fail: " + th2);
        }
    }

    public final void c(String str, String str2) {
        Map<String, FileData> localFileMap;
        Intrinsics.h(str, "url");
        Intrinsics.h(str2, "fileUrl");
        try {
            PageData pageData = d.getLocalH5Pages().get(str);
            if (pageData != null && (localFileMap = pageData.getLocalFileMap()) != null) {
                localFileMap.remove(str2);
            }
            a.a aVar = wg.a.a;
            MMKV.I("web_file_download_with_render_page_data_" + aVar.a(str)).remove(aVar.a(str2));
        } catch (Throwable th2) {
            h.a.b("DR_FileDownloadDataManager", "<deleteLocalFile> fail: " + th2);
        }
    }

    public final void d(String str) {
        if (str == null || str.length() == 0) {
            return;
        }
        try {
            d.getLocalH5Pages().remove(str);
            String str2 = "web_file_download_with_render_page_data_" + wg.a.a.a(str);
            MMKV.I(str2).clearAll();
            String A = MMKV.A();
            File file = new File(A, str2);
            File file2 = new File(A, str2 + ".crc");
            if (file.exists()) {
                h.a.f("DR_FileDownloadDataManager", "<deleteLocalPageData> url:" + str + ", targetFile:" + file.getAbsolutePath());
                file.delete();
            }
            if (file2.exists()) {
                h.a.f("DR_FileDownloadDataManager", "<deleteLocalPageData> url:" + str + ", targetCRCFile:" + file2.getAbsolutePath());
                file2.delete();
            }
        } catch (Throwable th2) {
            h.a.b("DR_FileDownloadDataManager", "<deleteLocalPageData> url:" + str + ", fail: " + th2);
        }
    }

    public final FileData e(FileData fileData) {
        Intrinsics.h(fileData, "remoteFileData");
        String fileUrl = fileData.getFileUrl();
        String md5 = fileData.getMd5();
        Iterator<T> it = d.getLocalH5Pages().values().iterator();
        while (it.hasNext()) {
            for (Map.Entry<String, FileData> entry : ((PageData) it.next()).getLocalFileMap().entrySet()) {
                String key = entry.getKey();
                FileData value = entry.getValue();
                if (Intrinsics.c(fileUrl, key)) {
                    String fileLocalPath$lib_web_release = value.getFileLocalPath$lib_web_release();
                    if (fileLocalPath$lib_web_release == null) {
                        fileLocalPath$lib_web_release = BuildConfig.FLAVOR;
                    }
                    if (new File(fileLocalPath$lib_web_release).exists() && Intrinsics.c(md5, value.getMd5())) {
                        fileData.setFileCopyOriginLocalPath$lib_web_release(value.getFileLocalPath$lib_web_release());
                        fileData.setFileOperateStatus$lib_web_release(FileOperateStatus.COPY);
                        return fileData;
                    }
                }
            }
        }
        return null;
    }

    public final FileData f(String str) {
        Intrinsics.h(str, "fileUrl");
        Iterator<Map.Entry<String, PageData>> it = d.getLocalH5Pages().entrySet().iterator();
        FileData fileData = null;
        while (it.hasNext()) {
            PageData value = it.next().getValue();
            if (value.getLocalFileMap().containsKey(str)) {
                fileData = value.getLocalFileMap().get(str);
            }
        }
        return fileData;
    }

    public final PageData g(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        return d.getLocalH5Pages().get(str);
    }

    public final PageData h(String str) {
        Object obj;
        if (str == null || str.length() == 0) {
            return null;
        }
        String a2 = com.transsion.lib_web.download_render.utils.e.a.a(str);
        Iterator<T> it = d.getLocalH5Pages().entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (Intrinsics.c(com.transsion.lib_web.download_render.utils.e.a.a((String) ((Map.Entry) obj).getKey()), a2)) {
                break;
            }
        }
        Map.Entry entry = (Map.Entry) obj;
        if (entry != null) {
            return (PageData) entry.getValue();
        }
        return null;
    }

    public final String i(String str) {
        if (str != null && str.length() != 0) {
            MMKV I = MMKV.I("web_file_download_with_render_page_data_" + str);
            if (I.c("pageUrl")) {
                return I.getString("pageUrl", BuildConfig.FLAVOR);
            }
        }
        return null;
    }

    public final String k() {
        return j().getString("pageListVersion", (String) null);
    }

    public final PageListData l() {
        try {
            List<PageData> h5Pages = d.getH5Pages();
            if (h5Pages != null) {
                if (h5Pages.isEmpty()) {
                }
                return d;
            }
            String[] a2 = j().a();
            if (a2 == null) {
                a2 = new String[0];
            }
            PageListData pageListData = new PageListData(null, new ArrayList(), null, 5, null);
            for (String str : a2) {
                c cVar = a;
                if (cVar.j().c(str)) {
                    if (Intrinsics.c(str, "pageListVersion")) {
                        pageListData.setVersion(cVar.j().getString("pageListVersion", (String) null));
                    } else {
                        PageData pageData = (PageData) o.d(cVar.j().getString(str, BuildConfig.FLAVOR), PageData.class);
                        List<PageData> h5Pages2 = pageListData.getH5Pages();
                        if (h5Pages2 != null) {
                            Intrinsics.e(pageData);
                            h5Pages2.add(pageData);
                        }
                    }
                }
            }
            d.setH5Pages(pageListData.getH5Pages());
            return d;
        } catch (Throwable th2) {
            h.a.b("DR_FileDownloadDataManager", "<getRemotePageListData> fail: " + th2);
            return null;
        }
    }

    public final void o(PageData pageData) {
        int i;
        Intrinsics.h(pageData, "pageData");
        try {
            String url = pageData.getUrl();
            if (url == null) {
                return;
            }
            List<PageData> h5Pages = d.getH5Pages();
            if (h5Pages != null) {
                Iterator<PageData> it = h5Pages.iterator();
                i = 0;
                while (it.hasNext()) {
                    if (Intrinsics.c(it.next().getUrl(), url)) {
                        break;
                    } else {
                        i++;
                    }
                }
            }
            i = -1;
            if (i == -1) {
                j().remove(wg.a.a.a(url));
                return;
            }
            PageListData pageListData = d;
            List<PageData> h5Pages2 = pageListData.getH5Pages();
            PageData pageData2 = h5Pages2 != null ? h5Pages2.get(i) : null;
            if (Intrinsics.c(pageData2 != null ? pageData2.getVersionCode() : null, pageData.getVersionCode())) {
                List<PageData> h5Pages3 = pageListData.getH5Pages();
                if (h5Pages3 != null) {
                    h5Pages3.add(i, pageData);
                }
                j().putString(wg.a.a.a(url), o.j(pageData));
            }
        } catch (Throwable th2) {
            h.a.b("DR_FileDownloadDataManager", "<setRemotePageData> fail: " + th2);
        }
    }

    public final void p(PageListData pageListData) {
        Intrinsics.h(pageListData, "pageListData");
        try {
            String[] a2 = j().a();
            if (a2 == null) {
                a2 = new String[0];
            }
            PageListData pageListData2 = new PageListData(null, new ArrayList(), null, 5, null);
            for (String str : a2) {
                c cVar = a;
                if (cVar.j().c(str) && !Intrinsics.c(str, "pageListVersion")) {
                    PageData pageData = (PageData) o.d(cVar.j().getString(str, BuildConfig.FLAVOR), PageData.class);
                    List<PageData> h5Pages = pageListData2.getH5Pages();
                    if (h5Pages != null) {
                        Intrinsics.e(pageData);
                        h5Pages.add(pageData);
                    }
                }
            }
            List<PageData> h5Pages2 = pageListData.getH5Pages();
            if (h5Pages2 != null) {
                for (PageData pageData2 : h5Pages2) {
                    List<PageData> h5Pages3 = pageListData2.getH5Pages();
                    if (h5Pages3 != null) {
                        Iterator<T> it = h5Pages3.iterator();
                        while (true) {
                            if (it.hasNext()) {
                                PageData pageData3 = (PageData) it.next();
                                if (Intrinsics.c(pageData2.getUrl(), pageData3.getUrl()) && Intrinsics.c(pageData2.getVersionCode(), pageData3.getVersionCode())) {
                                    pageData2.setFiles(pageData3.getFiles());
                                    break;
                                }
                            }
                        }
                    }
                }
            }
            d.setH5Pages(pageListData.getH5Pages());
            j().clearAll();
            j().putString("pageListVersion", pageListData.getVersion());
            List<PageData> h5Pages4 = pageListData.getH5Pages();
            if (h5Pages4 != null) {
                for (PageData pageData4 : h5Pages4) {
                    String url = pageData4.getUrl();
                    if (url != null) {
                        a.j().putString(wg.a.a.a(url), o.j(pageData4));
                    }
                }
            }
        } catch (Throwable th2) {
            h.a.b("DR_FileDownloadDataManager", "<setRemotePageListData> fail: " + th2);
        }
    }

    public final void r() {
        if (c.compareAndSet(false, true)) {
            String absolutePath = new File(Utils.a().getFilesDir(), "DownloadRender").getAbsolutePath();
            com.transsion.lib_web.download_render.utils.c cVar = com.transsion.lib_web.download_render.utils.c.a;
            Intrinsics.e(absolutePath);
            for (File file : cVar.c(absolutePath)) {
                c cVar2 = a;
                String name = file.getName();
                Intrinsics.g(name, "getName(...)");
                cVar2.q(name);
            }
        }
    }

    public final void s(String str, boolean z) {
        Intrinsics.h(str, "url");
        try {
            PageData pageData = d.getLocalH5Pages().get(str);
            if (pageData != null) {
                pageData.setDownloadStatus(Boolean.valueOf(z));
            }
            MMKV.I("web_file_download_with_render_page_data_" + wg.a.a.a(str)).putBoolean("pageDownloadStatus", z);
        } catch (Throwable th2) {
            h.a.b("DR_FileDownloadDataManager", "<updateLocalPageDownloadStatus> fail: " + th2);
        }
    }

    public final void t(String str) {
        Intrinsics.h(str, "url");
        try {
            long currentTimeMillis = System.currentTimeMillis();
            PageData pageData = d.getLocalH5Pages().get(str);
            if (pageData != null) {
                pageData.setUpgradeTime(Long.valueOf(currentTimeMillis));
            }
            MMKV.I("web_file_download_with_render_page_data_" + wg.a.a.a(str)).putLong("pageUpgradeTime", currentTimeMillis);
        } catch (Throwable th2) {
            h.a.b("DR_FileDownloadDataManager", "<updateLocalPageUpgradeTime> fail: " + th2);
        }
    }

    public final void u(String str) {
        Intrinsics.h(str, "url");
        try {
            MMKV.I("web_file_download_with_render_page_data_" + wg.a.a.a(str)).putString("pageUrl", str);
        } catch (Throwable th2) {
            h.a.b("DR_FileDownloadDataManager", "<updateLocalPageUrl> fail: " + th2);
        }
    }

    public final void v(String str) {
        Intrinsics.h(str, "url");
        try {
            long currentTimeMillis = System.currentTimeMillis();
            PageData pageData = d.getLocalH5Pages().get(str);
            if (pageData != null) {
                pageData.setUsedTime(Long.valueOf(currentTimeMillis));
            }
            MMKV.I("web_file_download_with_render_page_data_" + wg.a.a.a(str)).putLong("pageUsedTime", currentTimeMillis);
        } catch (Throwable th2) {
            h.a.b("DR_FileDownloadDataManager", "<updateLocalPageUsedTime> fail: " + th2);
        }
    }

    public final void w(String str, String str2) {
        Intrinsics.h(str, "url");
        Intrinsics.h(str2, "versionCode");
        try {
            PageData pageData = d.getLocalH5Pages().get(str);
            if (pageData != null) {
                pageData.setVersionCode(str2);
            }
            MMKV.I("web_file_download_with_render_page_data_" + wg.a.a.a(str)).putString("pageVersion", str2);
        } catch (Throwable th2) {
            h.a.b("DR_FileDownloadDataManager", "<updateLocalPageVersion> fail: " + th2);
        }
    }
}
