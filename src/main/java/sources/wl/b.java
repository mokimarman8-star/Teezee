package wl;

import com.transsion.gslb.BuildConfig;
import com.transsion.lib_web.download_render.data.FileData;
import java.io.File;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import pl.h;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class b implements d {
    private final String a;
    private final String b;
    private final List c;
    private final String d;

    public b(String str, String str2, List list) {
        Intrinsics.h(str, "url");
        Intrinsics.h(str2, "version");
        Intrinsics.h(list, "files");
        this.a = str;
        this.b = str2;
        this.c = list;
        this.d = "DR_FileOperateDelete";
    }

    public String a() {
        return this.d;
    }

    @Override // wl.d
    public void invoke() {
        for (FileData fileData : this.c) {
            String fileLocalPath$lib_web_release = fileData.getFileLocalPath$lib_web_release();
            if (fileLocalPath$lib_web_release != null) {
                try {
                    File file = new File(fileLocalPath$lib_web_release);
                    if (file.exists()) {
                        file.delete();
                    }
                    com.transsion.lib_web.download_render.c cVar = com.transsion.lib_web.download_render.c.a;
                    String str = this.a;
                    String fileUrl = fileData.getFileUrl();
                    if (fileUrl == null) {
                        fileUrl = BuildConfig.FLAVOR;
                    }
                    cVar.c(str, fileUrl);
                    h.a.a(a(), "<FileOperateDelete> delete path: " + fileLocalPath$lib_web_release + " success!");
                } catch (Throwable th2) {
                    h.a.f(a(), "<FileOperateDelete> delete path: " + fileLocalPath$lib_web_release + " fail, msg:" + th2);
                }
            }
        }
    }
}
