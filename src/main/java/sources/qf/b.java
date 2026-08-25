package qf;

import android.content.Context;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Comparator;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public final class b {
    private static File b;
    private static File c;
    private static Context d;
    public static final b a = new b();
    private static AtomicBoolean e = new AtomicBoolean(false);
    private static final Comparator f = new Comparator() { // from class: qf.a
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            int c2;
            c2 = b.c((File) obj, (File) obj2);
            return c2;
        }
    };

    private b() {
    }

    private final boolean b(File file) {
        if (file == null || file.exists()) {
            return true;
        }
        return file.mkdir();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int c(File file, File file2) {
        return (int) (file2.lastModified() - file.lastModified());
    }

    private final File d(String str) {
        if (c == null) {
            Context context = d;
            c = context == null ? null : context.getCacheDir();
        }
        return new File(c, str);
    }

    private final File e(String str) {
        b(b);
        return new File(b, str);
    }

    public final synchronized File[] f() {
        File file = b;
        if (file == null) {
            return null;
        }
        File[] listFiles = file != null ? file.listFiles() : null;
        if (listFiles != null) {
            Arrays.sort(listFiles, f);
        }
        return listFiles;
    }

    public final void g(Context context) {
        if (context != null && e.compareAndSet(false, true)) {
            d = context;
            b = new File(context.getFilesDir(), "strategy");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00b8 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0063 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final synchronized void h(Serializable serializable, File file) {
        File file2;
        boolean z;
        FileOutputStream fileOutputStream;
        Intrinsics.h(file, "toFile");
        if (serializable == null) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        FileOutputStream fileOutputStream2 = null;
        boolean z2 = false;
        try {
            String uuid = UUID.randomUUID().toString();
            Intrinsics.g(uuid, "randomUUID().toString()");
            file2 = d(StringsKt.Q(uuid, "-", TtmlNode.ANONYMOUS_REGION_ID, false, 4, (Object) null));
        } catch (Exception e2) {
            e = e2;
            file2 = null;
        }
        try {
            file2.createNewFile();
            z = true;
            file2.setReadable(true);
            fileOutputStream = new FileOutputStream(file2);
            try {
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(new BufferedOutputStream(fileOutputStream));
                objectOutputStream.writeObject(serializable);
                objectOutputStream.flush();
                objectOutputStream.close();
            } catch (Exception e3) {
                e = e3;
                z = false;
            }
        } catch (Exception e4) {
            e = e4;
            z = false;
            e.printStackTrace();
            if (fileOutputStream2 != null) {
                try {
                    fileOutputStream2.close();
                } catch (IOException e5) {
                    e5.printStackTrace();
                }
            }
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            if (z) {
            }
            if (z) {
            }
            try {
                file2.delete();
            } catch (Exception e6) {
                rf.b.a.e(e6);
            }
        }
        try {
            fileOutputStream.close();
        } catch (Exception e7) {
            e = e7;
            fileOutputStream2 = fileOutputStream;
            e.printStackTrace();
            if (fileOutputStream2 != null) {
            }
            long currentTimeMillis22 = System.currentTimeMillis() - currentTimeMillis;
            if (z) {
            }
            if (z) {
            }
            file2.delete();
        }
        long currentTimeMillis222 = System.currentTimeMillis() - currentTimeMillis;
        if (z) {
            if (file2 != null) {
                z2 = file2.renameTo(file);
            }
            if (z2) {
                rf.b.a.g("persist end. file = " + file.getAbsoluteFile() + ", size = " + file.length() + ", cost= " + Long.valueOf(currentTimeMillis222));
            } else {
                rf.b.a.c("rename failed.");
            }
        }
        if ((z || !z2) && file2 != null) {
            file2.delete();
        }
    }

    public final synchronized void i(Serializable serializable, String str) {
        Intrinsics.h(serializable, "serializable");
        Intrinsics.h(str, "filename");
        h(serializable, e(str));
    }

    public final synchronized void j() {
        File[] f2;
        try {
            f2 = f();
        } finally {
        }
        if (f2 == null) {
            return;
        }
        int length = f2.length;
        int i = 1;
        int i2 = 0;
        while (i2 < length) {
            File file = f2[i2];
            i2++;
            if (!file.isDirectory()) {
                if (System.currentTimeMillis() - file.lastModified() > 259200000) {
                    rf.b.a.c(Intrinsics.q("delete expired file: ", file.getAbsoluteFile()));
                    file.delete();
                } else {
                    String name = file.getName();
                    Intrinsics.g(name, "file.name");
                    if (StringsKt.W(name, "WIFI", false, 2, (Object) null)) {
                        if (i > 10) {
                            rf.b.a.c("delete file: " + file.getAbsoluteFile() + " because max file num is 10");
                            file.delete();
                        }
                        i++;
                    }
                }
            }
        }
    }

    public final synchronized Object k(File file) {
        Object obj;
        Intrinsics.h(file, "file");
        FileInputStream fileInputStream = null;
        Object obj2 = null;
        if (!file.exists()) {
            return null;
        }
        long currentTimeMillis = System.currentTimeMillis();
        try {
            FileInputStream fileInputStream2 = new FileInputStream(file);
            try {
                ObjectInputStream objectInputStream = new ObjectInputStream(new BufferedInputStream(fileInputStream2));
                obj2 = objectInputStream.readObject();
                objectInputStream.close();
                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                rf.b.a.b("restore end. file = " + file.getAbsoluteFile() + ", size = " + file.length() + ", cost = " + currentTimeMillis2);
                fileInputStream2.close();
            } catch (Throwable th) {
                th = th;
                Object obj3 = obj2;
                fileInputStream = fileInputStream2;
                obj = obj3;
                th.printStackTrace();
                rf.b.a.c(Intrinsics.q("restore file fail. file = ", file.getAbsoluteFile()));
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                        obj2 = obj;
                        return obj2;
                    }
                }
                obj2 = obj;
                return obj2;
            }
        } catch (Throwable th2) {
            th = th2;
            obj = null;
        }
        return obj2;
    }

    public final synchronized Object l(String str) {
        Intrinsics.h(str, "filename");
        return k(e(str));
    }
}
