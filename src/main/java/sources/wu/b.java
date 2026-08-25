package wu;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.apache.tools.zip.ZipEntry;
import org.apache.tools.zip.ZipOutputStream;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class b {
    public static final b a = new b();

    private b() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:30:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r10v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.io.BufferedInputStream] */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.io.FileInputStream, java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v7, types: [java.lang.String] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void b(File file, String str, ZipOutputStream zipOutputStream, Function1 function1) {
        File[] fileArr;
        BufferedInputStream bufferedInputStream;
        int i;
        ?? fileInputStream;
        if (file.isDirectory()) {
            fileArr = file.listFiles();
            Intrinsics.g(fileArr, "parentFile.listFiles()");
        } else {
            fileArr = new File[0];
            fileArr[0] = file;
        }
        ?? r10 = fileArr;
        byte[] bArr = new byte[1024];
        InputStream inputStream = null;
        try {
            int length = r10.length;
            InputStream inputStream2 = null;
            bufferedInputStream = null;
            int i2 = 0;
            while (i2 < length) {
                try {
                    ?? r2 = r10[i2];
                    if (r2.isDirectory()) {
                        String path = r2.getPath();
                        Intrinsics.g(path, "it.path");
                        String substring = path.substring(str.length() + 1);
                        Intrinsics.g(substring, "this as java.lang.String).substring(startIndex)");
                        zipOutputStream.putNextEntry(new ZipEntry(substring + "/"));
                        fileInputStream = str;
                        i = i2;
                        c(a, r2, fileInputStream, zipOutputStream, null, 8, null);
                    } else {
                        i = i2;
                        String path2 = r2.getPath();
                        Intrinsics.g(path2, "it.path");
                        String substring2 = path2.substring(str.length() + 1);
                        Intrinsics.g(substring2, "this as java.lang.String).substring(startIndex)");
                        fileInputStream = new FileInputStream((File) r2);
                        try {
                            r2 = new BufferedInputStream(fileInputStream);
                        } catch (IOException e) {
                            e = e;
                            inputStream = fileInputStream;
                            if (function1 != null) {
                                function1.invoke(Boolean.FALSE);
                            }
                            e.printStackTrace();
                            if (inputStream != null) {
                                inputStream.close();
                            }
                            if (bufferedInputStream == null) {
                                bufferedInputStream.close();
                                return;
                            }
                            return;
                        }
                        try {
                            zipOutputStream.putNextEntry(new ZipEntry(substring2));
                            while (true) {
                                int read = r2.read(bArr, 0, 1024);
                                if (read == -1) {
                                    break;
                                } else {
                                    zipOutputStream.write(bArr, 0, read);
                                }
                            }
                            fileInputStream.close();
                            r2.close();
                            bufferedInputStream = r2;
                            inputStream2 = fileInputStream;
                        } catch (IOException e2) {
                            e = e2;
                            bufferedInputStream = r2;
                            inputStream = fileInputStream;
                            if (function1 != null) {
                            }
                            e.printStackTrace();
                            if (inputStream != null) {
                            }
                            if (bufferedInputStream == null) {
                            }
                        }
                    }
                    i2 = i + 1;
                } catch (IOException e3) {
                    e = e3;
                    inputStream = inputStream2;
                }
            }
            if (function1 != null) {
                function1.invoke(Boolean.TRUE);
            }
        } catch (IOException e4) {
            e = e4;
            bufferedInputStream = null;
        }
    }

    static /* synthetic */ void c(b bVar, File file, String str, ZipOutputStream zipOutputStream, Function1 function1, int i, Object obj) {
        if ((i & 8) != 0) {
            function1 = null;
        }
        bVar.b(file, str, zipOutputStream, function1);
    }

    public final void a(String str, String zipFilePath, Function1 function1) {
        BufferedOutputStream bufferedOutputStream;
        FileOutputStream fileOutputStream;
        ZipOutputStream zipOutputStream;
        Intrinsics.h(zipFilePath, "zipFilePath");
        if (str == null) {
            return;
        }
        ZipOutputStream zipOutputStream2 = null;
        try {
            fileOutputStream = new FileOutputStream(zipFilePath);
            try {
                bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
                try {
                    zipOutputStream = new ZipOutputStream(bufferedOutputStream);
                } catch (IOException e) {
                    e = e;
                }
                try {
                    zipOutputStream.setEncoding("GBK");
                    File file = new File(str);
                    String basePath = file.isDirectory() ? file.getPath() : file.getParent();
                    Intrinsics.g(basePath, "basePath");
                    b(file, basePath, zipOutputStream, function1);
                    zipOutputStream.closeEntry();
                    zipOutputStream.close();
                    bufferedOutputStream.close();
                    fileOutputStream.close();
                } catch (IOException e2) {
                    e = e2;
                    zipOutputStream2 = zipOutputStream;
                    e.printStackTrace();
                    if (zipOutputStream2 != null) {
                        zipOutputStream2.closeEntry();
                    }
                    if (zipOutputStream2 != null) {
                        zipOutputStream2.close();
                    }
                    if (bufferedOutputStream != null) {
                        bufferedOutputStream.close();
                    }
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    if (function1 != null) {
                        function1.invoke(Boolean.FALSE);
                    }
                }
            } catch (IOException e3) {
                e = e3;
                bufferedOutputStream = null;
            }
        } catch (IOException e4) {
            e = e4;
            bufferedOutputStream = null;
            fileOutputStream = null;
        }
    }
}
