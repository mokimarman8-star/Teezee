package wl;

import com.transsion.lib_web.download_render.data.FileData;
import com.transsion.lib_web.download_render.data.FileOperateStatus;
import java.io.File;
import java.util.List;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.Intrinsics;
import pl.h;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class a implements d {
    private final String a;
    private final String b;
    private final List c;
    private final String d;

    public a(String str, String str2, List list) {
        Intrinsics.h(str, "url");
        Intrinsics.h(str2, "version");
        Intrinsics.h(list, "files");
        this.a = str;
        this.b = str2;
        this.c = list;
        this.d = "DR_FileOperateCopy";
    }

    public String a() {
        return this.d;
    }

    @Override // wl.d
    public void invoke() {
        String fileUrl;
        File parentFile;
        for (FileData fileData : this.c) {
            String md5 = fileData.getMd5();
            if (md5 != null && (fileUrl = fileData.getFileUrl()) != null) {
                String fileCopyOriginLocalPath$lib_web_release = fileData.getFileCopyOriginLocalPath$lib_web_release();
                String absolutePath = com.transsion.lib_web.download_render.utils.c.a.b(this.a, fileUrl, md5, fileData.getMimeType()).getAbsolutePath();
                if (fileCopyOriginLocalPath$lib_web_release != null && fileCopyOriginLocalPath$lib_web_release.length() > 0 && new File(fileCopyOriginLocalPath$lib_web_release).exists()) {
                    Intrinsics.e(absolutePath);
                    if (absolutePath.length() > 0) {
                        File file = new File(fileCopyOriginLocalPath$lib_web_release);
                        File file2 = new File(absolutePath);
                        File parentFile2 = file2.getParentFile();
                        if (parentFile2 != null && !parentFile2.exists() && (parentFile = file2.getParentFile()) != null) {
                            parentFile.mkdirs();
                        }
                        try {
                            FilesKt.u(file, file2, true, 0, 4, (Object) null);
                            fileData.setFileOperateStatus$lib_web_release(FileOperateStatus.NONE);
                            fileData.setFileLocalPath$lib_web_release(file2.getAbsolutePath());
                            com.transsion.lib_web.download_render.c.a.b(this.a, this.b, fileData);
                            h.a.a(a(), "<FileOperateCopy> copy src:" + file.getAbsoluteFile() + " to dst:" + file2.getAbsoluteFile() + " success, dst:" + file2.getAbsolutePath());
                        } catch (Throwable th2) {
                            h.a.f(a(), "<FileOperateCopy> copy src:" + file.getAbsoluteFile() + " to dst:" + file2.getAbsoluteFile() + " fail, msg:" + th2);
                        }
                    }
                }
                h.a.f(a(), "<FileOperateCopy> copy src:" + fileCopyOriginLocalPath$lib_web_release + " to dst:" + absolutePath + " fail!");
            }
        }
    }
}
