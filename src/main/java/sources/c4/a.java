package c4;

import android.util.Log;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class a {

    /* renamed from: e, reason: collision with root package name */
    private static final C0128a f14298e = new C0128a(null);

    /* renamed from: f, reason: collision with root package name */
    private static final Map f14299f = new HashMap();

    /* renamed from: a, reason: collision with root package name */
    private final boolean f14300a;

    /* renamed from: b, reason: collision with root package name */
    private final File f14301b;

    /* renamed from: c, reason: collision with root package name */
    private final Lock f14302c;

    /* renamed from: d, reason: collision with root package name */
    private FileChannel f14303d;

    /* renamed from: c4.a$a, reason: collision with other inner class name */
    private static final class C0128a {
        private C0128a() {
        }

        public /* synthetic */ C0128a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Lock b(String str) {
            Lock lock;
            synchronized (a.f14299f) {
                try {
                    Map map = a.f14299f;
                    Object obj = map.get(str);
                    if (obj == null) {
                        obj = new ReentrantLock();
                        map.put(str, obj);
                    }
                    lock = (Lock) obj;
                } catch (Throwable th) {
                    throw th;
                }
            }
            return lock;
        }
    }

    public a(String str, File file, boolean z5) {
        File file2;
        Intrinsics.h(str, "name");
        this.f14300a = z5;
        if (file != null) {
            file2 = new File(file, str + ".lck");
        } else {
            file2 = null;
        }
        this.f14301b = file2;
        this.f14302c = f14298e.b(str);
    }

    public static /* synthetic */ void c(a aVar, boolean z5, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            z5 = aVar.f14300a;
        }
        aVar.b(z5);
    }

    public final void b(boolean z5) {
        this.f14302c.lock();
        if (z5) {
            try {
                File file = this.f14301b;
                if (file == null) {
                    throw new IOException("No lock directory was provided.");
                }
                File parentFile = file.getParentFile();
                if (parentFile != null) {
                    parentFile.mkdirs();
                }
                FileChannel channel = new FileOutputStream(this.f14301b).getChannel();
                channel.lock();
                this.f14303d = channel;
            } catch (IOException e5) {
                this.f14303d = null;
                Log.w("SupportSQLiteLock", "Unable to grab file lock.", e5);
            }
        }
    }

    public final void d() {
        try {
            FileChannel fileChannel = this.f14303d;
            if (fileChannel != null) {
                fileChannel.close();
            }
        } catch (IOException unused) {
        }
        this.f14302c.unlock();
    }
}
