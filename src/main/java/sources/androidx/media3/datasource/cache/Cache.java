package androidx.media3.datasource.cache;

import java.io.File;
import java.io.IOException;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public interface Cache {

    public static class CacheException extends IOException {
        public CacheException(String str) {
            super(str);
        }

        public CacheException(String str, Throwable th) {
            super(str, th);
        }

        public CacheException(Throwable th) {
            super(th);
        }
    }

    public interface a {
        void b(Cache cache, h hVar, h hVar2);

        void c(Cache cache, h hVar);

        void e(Cache cache, h hVar);
    }

    long a(String str, long j5, long j6);

    h b(String str, long j5, long j6);

    h c(String str, long j5, long j6);

    void d(File file, long j5);

    void e(String str);

    void f(h hVar);

    void g(h hVar);

    long getCachedLength(String str, long j5, long j6);

    m getContentMetadata(String str);

    void h(String str, n nVar);

    File startFile(String str, long j5, long j6);
}
