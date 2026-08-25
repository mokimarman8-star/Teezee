package xb;

import android.content.Context;
import com.google.firebase.crashlytics.internal.common.CommonUtils;
import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import qb.j;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public class g {
    final String a;
    private final File b;
    private final File c;
    private final File d;
    private final File e;
    private final File f;
    private final File g;

    public g(Context context) {
        String str;
        String d = j.a.e(context).d();
        this.a = d;
        File filesDir = context.getFilesDir();
        this.b = filesDir;
        if (y()) {
            str = ".crashlytics.v3" + File.separator + x(d);
        } else {
            str = ".com.google.firebase.crashlytics.files.v1";
        }
        File t = t(new File(filesDir, str));
        this.c = t;
        this.d = t(new File(t, "open-sessions"));
        this.e = t(new File(t, "reports"));
        this.f = t(new File(t, "priority-reports"));
        this.g = t(new File(t, "native-reports"));
    }

    private void b(String str) {
        File file = new File(this.b, str);
        if (file.exists() && v(file)) {
            qb.g.f().b("Deleted previous Crashlytics file system: " + file.getPath());
        }
    }

    private void c(final String str) {
        String[] list;
        if (!this.b.exists() || (list = this.b.list(new FilenameFilter() { // from class: xb.f
            @Override // java.io.FilenameFilter
            public final boolean accept(File file, String str2) {
                boolean s;
                s = g.s(str, file, str2);
                return s;
            }
        })) == null) {
            return;
        }
        for (String str2 : list) {
            b(str2);
        }
    }

    private File p(String str) {
        return u(new File(this.d, str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean s(String str, File file, String str2) {
        return str2.startsWith(str);
    }

    private static synchronized File t(File file) {
        synchronized (g.class) {
            try {
                if (file.exists()) {
                    if (file.isDirectory()) {
                        return file;
                    }
                    qb.g.f().b("Unexpected non-directory file: " + file + "; deleting file and creating new directory.");
                    file.delete();
                }
                if (!file.mkdirs()) {
                    qb.g.f().d("Could not create Crashlytics-specific directory: " + file);
                }
                return file;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private static File u(File file) {
        file.mkdirs();
        return file;
    }

    static boolean v(File file) {
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File file2 : listFiles) {
                v(file2);
            }
        }
        return file.delete();
    }

    private static List w(Object[] objArr) {
        return objArr == null ? Collections.emptyList() : Arrays.asList(objArr);
    }

    static String x(String str) {
        return str.length() > 40 ? CommonUtils.z(str) : str.replaceAll("[^a-zA-Z0-9.]", "_");
    }

    private boolean y() {
        return !this.a.isEmpty();
    }

    public void d() {
        b(".com.google.firebase.crashlytics");
        b(".com.google.firebase.crashlytics-ndk");
        if (y()) {
            b(".com.google.firebase.crashlytics.files.v1");
            c(".com.google.firebase.crashlytics.files.v2" + File.pathSeparator);
        }
    }

    public boolean e(String str) {
        return v(new File(this.d, str));
    }

    public List f() {
        return w(this.d.list());
    }

    public File g(String str) {
        return new File(this.c, str);
    }

    public List h(FilenameFilter filenameFilter) {
        return w(this.c.listFiles(filenameFilter));
    }

    public File i(String str) {
        return new File(this.g, str);
    }

    public List j() {
        return w(this.g.listFiles());
    }

    public File k(String str) {
        return u(new File(p(str), "native"));
    }

    public File l(String str) {
        return new File(this.f, str);
    }

    public List m() {
        return w(this.f.listFiles());
    }

    public File n(String str) {
        return new File(this.e, str);
    }

    public List o() {
        return w(this.e.listFiles());
    }

    public File q(String str, String str2) {
        return new File(p(str), str2);
    }

    public List r(String str, FilenameFilter filenameFilter) {
        return w(p(str).listFiles(filenameFilter));
    }
}
