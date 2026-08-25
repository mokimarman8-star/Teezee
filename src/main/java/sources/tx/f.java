package tx;

import java.io.File;
import kotlin.jvm.internal.Intrinsics;
import wf.a;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class f {
    public static final f a = new f();

    private f() {
    }

    public final String a(File soFile) {
        Intrinsics.h(soFile, "soFile");
        if (!soFile.exists() || !soFile.isFile()) {
            return "SO文件不存在: " + soFile.getAbsolutePath();
        }
        try {
            String absolutePath = soFile.getAbsolutePath();
            StringBuilder sb = new StringBuilder();
            sb.append("开始加载SO: ");
            sb.append(absolutePath);
            soFile.setReadable(true, false);
            soFile.setExecutable(true, false);
            soFile.setWritable(false);
            System.load(absolutePath);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("SO加载成功: ");
            sb2.append(absolutePath);
            return null;
        } catch (Exception e) {
            String str = "SO加载异常: " + e.getMessage();
            a.a.k(wf.a.a, "SoLoader", str, e, false, 8, (Object) null);
            return str;
        } catch (UnsatisfiedLinkError e2) {
            String str2 = "SO加载失败 (UnsatisfiedLinkError): " + e2.getMessage();
            a.a.k(wf.a.a, "SoLoader", str2, e2, false, 8, (Object) null);
            return str2;
        }
    }
}
