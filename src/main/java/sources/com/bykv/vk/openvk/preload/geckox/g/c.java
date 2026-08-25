package com.bykv.vk.openvk.preload.geckox.g;

import android.os.Process;
import android.util.Pair;
import com.bykv.vk.openvk.preload.geckox.utils.FileLock;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public final class c {
    private static final Map<String, Pair<FileLock, AtomicLong>> a = new HashMap();

    public static void a(String str) throws Exception {
        Map<String, Pair<FileLock, AtomicLong>> map = a;
        synchronized (map) {
            try {
                Pair<FileLock, AtomicLong> pair = map.get(str);
                if (pair == null) {
                    Pair<FileLock, AtomicLong> pair2 = new Pair<>(FileLock.a(str, Process.myPid()), new AtomicLong(0L));
                    map.put(str, pair2);
                    pair = pair2;
                }
                ((AtomicLong) pair.second).incrementAndGet();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void b(String str) throws Exception {
        Map<String, Pair<FileLock, AtomicLong>> map = a;
        synchronized (map) {
            try {
                Pair<FileLock, AtomicLong> pair = map.get(str);
                if (pair == null) {
                    throw new RuntimeException("using.lock illegal state");
                }
                long decrementAndGet = ((AtomicLong) pair.second).decrementAndGet();
                if (decrementAndGet < 0) {
                    throw new RuntimeException("using.lock count illegal");
                }
                if (decrementAndGet == 0) {
                    ((FileLock) pair.first).a();
                    map.remove(str);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void c(String str) throws Exception {
        Map<String, Pair<FileLock, AtomicLong>> map = a;
        synchronized (map) {
            try {
                FileLock b = FileLock.b(str);
                if (b == null) {
                    return;
                }
                Pair<FileLock, AtomicLong> pair = map.get(str);
                if (pair != null && ((AtomicLong) pair.second).get() != 0) {
                    b.a();
                    FileLock.a(str, Process.myPid());
                    return;
                }
                File parentFile = new File(str).getParentFile();
                final File file = new File(parentFile.getAbsolutePath() + "--pending-delete");
                if (parentFile.renameTo(file)) {
                    b.a();
                    b.b();
                    com.bykv.vk.openvk.preload.geckox.utils.c.a().execute(new Runnable() { // from class: com.bykv.vk.openvk.preload.geckox.g.c.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            com.bykv.vk.openvk.preload.geckox.utils.b.a(file);
                        }
                    });
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
