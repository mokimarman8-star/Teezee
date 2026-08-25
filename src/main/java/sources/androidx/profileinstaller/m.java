package androidx.profileinstaller;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetFileDescriptor;
import android.os.Build;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Objects;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class m {

    /* renamed from: a, reason: collision with root package name */
    private static final androidx.concurrent.futures.b f12666a = androidx.concurrent.futures.b.y();

    /* renamed from: b, reason: collision with root package name */
    private static final Object f12667b = new Object();

    /* renamed from: c, reason: collision with root package name */
    private static c f12668c = null;

    private static class a {
        static PackageInfo a(PackageManager packageManager, Context context) {
            return packageManager.getPackageInfo(context.getPackageName(), PackageManager.PackageInfoFlags.of(0L));
        }
    }

    static class b {

        /* renamed from: a, reason: collision with root package name */
        final int f12669a;

        /* renamed from: b, reason: collision with root package name */
        final int f12670b;

        /* renamed from: c, reason: collision with root package name */
        final long f12671c;

        /* renamed from: d, reason: collision with root package name */
        final long f12672d;

        b(int i5, int i6, long j5, long j6) {
            this.f12669a = i5;
            this.f12670b = i6;
            this.f12671c = j5;
            this.f12672d = j6;
        }

        static b a(File file) {
            DataInputStream dataInputStream = new DataInputStream(new FileInputStream(file));
            try {
                b bVar = new b(dataInputStream.readInt(), dataInputStream.readInt(), dataInputStream.readLong(), dataInputStream.readLong());
                dataInputStream.close();
                return bVar;
            } catch (Throwable th) {
                try {
                    dataInputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        }

        void b(File file) {
            file.delete();
            DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(file));
            try {
                dataOutputStream.writeInt(this.f12669a);
                dataOutputStream.writeInt(this.f12670b);
                dataOutputStream.writeLong(this.f12671c);
                dataOutputStream.writeLong(this.f12672d);
                dataOutputStream.close();
            } catch (Throwable th) {
                try {
                    dataOutputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || !(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return this.f12670b == bVar.f12670b && this.f12671c == bVar.f12671c && this.f12669a == bVar.f12669a && this.f12672d == bVar.f12672d;
        }

        public int hashCode() {
            return Objects.hash(Integer.valueOf(this.f12670b), Long.valueOf(this.f12671c), Integer.valueOf(this.f12669a), Long.valueOf(this.f12672d));
        }
    }

    public static class c {

        /* renamed from: a, reason: collision with root package name */
        final int f12673a;

        /* renamed from: b, reason: collision with root package name */
        private final boolean f12674b;

        /* renamed from: c, reason: collision with root package name */
        private final boolean f12675c;

        /* renamed from: d, reason: collision with root package name */
        private final boolean f12676d;

        c(int i5, boolean z5, boolean z6, boolean z7) {
            this.f12673a = i5;
            this.f12675c = z6;
            this.f12674b = z5;
            this.f12676d = z7;
        }
    }

    private static long a(Context context) {
        PackageManager packageManager = context.getApplicationContext().getPackageManager();
        return Build.VERSION.SDK_INT >= 33 ? a.a(packageManager, context).lastUpdateTime : packageManager.getPackageInfo(context.getPackageName(), 0).lastUpdateTime;
    }

    private static c b(int i5, boolean z5, boolean z6, boolean z7) {
        c cVar = new c(i5, z5, z6, z7);
        f12668c = cVar;
        f12666a.u(cVar);
        return f12668c;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(20:23|(1:89)(1:27)|28|(1:88)(1:32)|33|34|35|(2:74|75)(1:37)|38|(8:45|(1:49)|(1:56)|57|(2:64|65)|61|62|63)|(1:71)(1:(1:73))|(1:49)|(3:51|54|56)|57|(1:59)|64|65|61|62|63) */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x00fc, code lost:
    
        r5 = 196608;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x00c8, code lost:
    
        r5 = 327680;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    static c c(Context context, boolean z5) {
        boolean z6;
        b a5;
        b bVar;
        int i5;
        c cVar;
        if (!z5 && (cVar = f12668c) != null) {
            return cVar;
        }
        synchronized (f12667b) {
            if (!z5) {
                c cVar2 = f12668c;
                if (cVar2 != null) {
                    return cVar2;
                }
            }
            int i6 = 0;
            try {
                AssetFileDescriptor openFd = context.getAssets().openFd("dexopt/baseline.prof");
                try {
                    z6 = openFd.getLength() > 0;
                    openFd.close();
                } finally {
                }
            } catch (IOException unused) {
                z6 = false;
            }
            int i7 = Build.VERSION.SDK_INT;
            if (i7 >= 28 && i7 != 30) {
                File file = new File(new File("/data/misc/profiles/ref/", context.getPackageName()), "primary.prof");
                long length = file.length();
                boolean z7 = file.exists() && length > 0;
                File file2 = new File(new File("/data/misc/profiles/cur/0/", context.getPackageName()), "primary.prof");
                long length2 = file2.length();
                boolean z8 = file2.exists() && length2 > 0;
                try {
                    long a6 = a(context);
                    File file3 = new File(context.getFilesDir(), "profileInstalled");
                    if (file3.exists()) {
                        try {
                            a5 = b.a(file3);
                        } catch (IOException unused2) {
                            return b(131072, z7, z8, z6);
                        }
                    } else {
                        a5 = null;
                    }
                    if (a5 != null && a5.f12671c == a6 && (i5 = a5.f12670b) != 2) {
                        i6 = i5;
                        if (z5 && z8 && i6 != 1) {
                            i6 = 2;
                        }
                        if (a5 != null && a5.f12670b == 2 && i6 == 1 && length < a5.f12672d) {
                            i6 = 3;
                        }
                        bVar = new b(1, i6, a6, length2);
                        if (a5 != null || !a5.equals(bVar)) {
                            bVar.b(file3);
                        }
                        return b(i6, z7, z8, z6);
                    }
                    if (z7) {
                        i6 = 1;
                    } else if (z8) {
                        i6 = 2;
                    }
                    if (z5) {
                        i6 = 2;
                    }
                    if (a5 != null) {
                        i6 = 3;
                    }
                    bVar = new b(1, i6, a6, length2);
                    if (a5 != null) {
                    }
                    bVar.b(file3);
                    return b(i6, z7, z8, z6);
                } catch (PackageManager.NameNotFoundException unused3) {
                    return b(65536, z7, z8, z6);
                }
            }
            return b(262144, false, false, z6);
        }
    }
}
