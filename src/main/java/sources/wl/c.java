package wl;

import com.transsion.gslb.BuildConfig;
import com.transsion.lib_web.download_render.FileDownloadTaskManager;
import com.transsion.lib_web.download_render.data.FileData;
import com.transsion.lib_web.download_render.data.FileOperateStatus;
import com.transsion.lib_web.download_render.utils.e;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import pl.h;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class c implements d {
    private final String a;
    private final String b;
    private final List c;
    private final Function4 d;
    private final String e;

    public c(String str, String str2, List list, Function4 function4) {
        Intrinsics.h(str, "url");
        Intrinsics.h(str2, "version");
        Intrinsics.h(list, "files");
        Intrinsics.h(function4, "callback");
        this.a = str;
        this.b = str2;
        this.c = list;
        this.d = function4;
        this.e = "DR_FileOperateDownload";
    }

    public String a() {
        return this.e;
    }

    @Override // wl.d
    public void invoke() {
        Iterator it;
        String md5;
        File parentFile;
        Iterator it2 = this.c.iterator();
        int i = 0;
        String str = BuildConfig.FLAVOR;
        long j = 0;
        while (it2.hasNext()) {
            FileData fileData = (FileData) it2.next();
            String i2 = FileDownloadTaskManager.a.i();
            if (i2 == null) {
                i2 = BuildConfig.FLAVOR;
            }
            e eVar = e.a;
            if (Intrinsics.c(eVar.a(i2), eVar.a(this.a))) {
                h.a.f(a(), "<FileOperateDownload> current webview is loading:" + ((Object) i2) + ", downloading:" + this.a + ", are the same, so intercept!");
                this.d.invoke(Boolean.TRUE, i2, Integer.valueOf(i), Long.valueOf(j));
                return;
            }
            String fileUrl = fileData.getFileUrl();
            if (fileUrl == null || (md5 = fileData.getMd5()) == null) {
                it = it2;
            } else {
                try {
                    Response execute = com.transsion.lib_web.zip.loader.b.a.d().newCall(new Request.Builder().url(fileUrl).build()).execute();
                    try {
                        if (!execute.isSuccessful()) {
                            throw new IOException("Unexpected code " + execute);
                        }
                        File b = com.transsion.lib_web.download_render.utils.c.a.b(this.a, fileUrl, md5, fileData.getMimeType());
                        File parentFile2 = b.getParentFile();
                        if (parentFile2 != null && !parentFile2.exists() && (parentFile = b.getParentFile()) != null) {
                            parentFile.mkdirs();
                        }
                        ResponseBody body = execute.body();
                        InputStream byteStream = body != null ? body.byteStream() : null;
                        try {
                            FileOutputStream fileOutputStream = new FileOutputStream(b);
                            if (byteStream != null) {
                                it = it2;
                                try {
                                    try {
                                        ByteStreamsKt.b(byteStream, fileOutputStream, 0, 2, (Object) null);
                                    } catch (Throwable th2) {
                                        th = th2;
                                        Throwable th3 = th;
                                        try {
                                            throw th3;
                                        } catch (Throwable th4) {
                                            CloseableKt.a(byteStream, th3);
                                            throw th4;
                                        }
                                    }
                                } finally {
                                }
                            } else {
                                it = it2;
                            }
                            CloseableKt.a(fileOutputStream, (Throwable) null);
                            try {
                                CloseableKt.a(byteStream, (Throwable) null);
                                fileData.setFileOperateStatus$lib_web_release(FileOperateStatus.NONE);
                                fileData.setFileLocalPath$lib_web_release(b.getAbsolutePath());
                                com.transsion.lib_web.download_render.c.a.b(this.a, this.b, fileData);
                                i++;
                                Long size = fileData.getSize();
                                j += size != null ? size.longValue() : 0L;
                                h.a.a(a(), "<FileOperateDownload> download: " + fileUrl + " success, dst:" + b.getAbsolutePath());
                                Unit unit = Unit.a;
                                try {
                                    CloseableKt.a(execute, (Throwable) null);
                                } catch (Throwable th5) {
                                    th = th5;
                                    h.a.f(a(), "<FileOperateDownload> download: " + fileUrl + " fail, msg:" + th);
                                    str = i2;
                                    it2 = it;
                                }
                            } catch (Throwable th6) {
                                th = th6;
                                Throwable th7 = th;
                                try {
                                    throw th7;
                                } catch (Throwable th8) {
                                    CloseableKt.a(execute, th7);
                                    throw th8;
                                }
                            }
                        } catch (Throwable th9) {
                            th = th9;
                            it = it2;
                        }
                    } catch (Throwable th10) {
                        th = th10;
                        it = it2;
                    }
                } catch (Throwable th11) {
                    th = th11;
                    it = it2;
                }
            }
            str = i2;
            it2 = it;
        }
        this.d.invoke(Boolean.FALSE, str, Integer.valueOf(i), Long.valueOf(j));
    }
}
