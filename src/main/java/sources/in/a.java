package in;

import android.content.Context;
import androidx.media3.datasource.a;
import androidx.media3.datasource.b;
import androidx.media3.datasource.c;
import androidx.media3.datasource.cache.Cache;
import androidx.media3.datasource.cache.SimpleCache;
import androidx.media3.datasource.cache.a;
import androidx.media3.datasource.cache.q;
import androidx.media3.datasource.cronet.CronetDataSource;
import androidx.media3.datasource.cronet.CronetUtil;
import androidx.media3.exoplayer.b4;
import androidx.media3.exoplayer.offline.DownloadManager;
import com.transsion.player.exo.ORExoDecoderType;
import java.io.File;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.CookiePolicy;
import java.util.concurrent.Executors;
import org.chromium.net.CronetEngine;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public abstract class a {
    private static a.a a;
    private static a.a b;
    private static v1.a c;
    private static File d;
    private static Cache e;
    private static DownloadManager f;
    private static androidx.media3.exoplayer.offline.k g;

    /* renamed from: in.a$a, reason: collision with other inner class name */
    static /* synthetic */ class C0075a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[ORExoDecoderType.values().length];
            a = iArr;
            try {
                iArr[ORExoDecoderType.HARDWARE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[ORExoDecoderType.FFMPEG.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[ORExoDecoderType.AV1.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private static a.c a(a.a aVar, Cache cache) {
        return new a.c().h(cache).i(aVar);
    }

    public static b4 b(Context context, ORExoDecoderType oRExoDecoderType) {
        int i;
        int i2 = C0075a.a[oRExoDecoderType.ordinal()];
        if (i2 != 1) {
            i = 2;
            if (i2 != 2 && i2 != 3) {
                throw new IncompatibleClassChangeError();
            }
        } else {
            i = 1;
        }
        return new g(context.getApplicationContext(), oRExoDecoderType).o(true).p(i).l();
    }

    private static synchronized void c(Context context) {
        synchronized (a.class) {
            if (f == null) {
                DownloadManager downloadManager = new DownloadManager(context, new androidx.media3.exoplayer.offline.a(e(context)), new com.transsion.player.shorttv.preload.b(new a.c().h(f(context)).i(j(context)), Executors.newFixedThreadPool(6)));
                f = downloadManager;
                downloadManager.u();
            }
        }
    }

    public static synchronized a.a d(Context context) {
        a.a aVar;
        synchronized (a.class) {
            try {
                if (a == null) {
                    Context applicationContext = context.getApplicationContext();
                    a = a(new b.a(applicationContext, j(applicationContext)), f(applicationContext));
                }
                aVar = a;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return aVar;
    }

    private static synchronized v1.a e(Context context) {
        v1.a aVar;
        synchronized (a.class) {
            try {
                if (c == null) {
                    c = new v1.b(context);
                }
                aVar = c;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return aVar;
    }

    public static synchronized Cache f(Context context) {
        Cache cache;
        synchronized (a.class) {
            try {
                if (e == null) {
                    e = new SimpleCache(new File(g(context), "downloads"), new q(314572800L), e(context));
                }
                cache = e;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return cache;
    }

    private static synchronized File g(Context context) {
        File file;
        synchronized (a.class) {
            try {
                if (d == null) {
                    File externalFilesDir = context.getExternalFilesDir(null);
                    d = externalFilesDir;
                    if (externalFilesDir == null) {
                        d = context.getFilesDir();
                    }
                }
                file = d;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return file;
    }

    public static synchronized DownloadManager h(Context context) {
        DownloadManager downloadManager;
        synchronized (a.class) {
            c(context);
            downloadManager = f;
        }
        return downloadManager;
    }

    public static synchronized androidx.media3.exoplayer.offline.k i(Context context) {
        androidx.media3.exoplayer.offline.k kVar;
        synchronized (a.class) {
            try {
                if (g == null) {
                    g = new androidx.media3.exoplayer.offline.k(context, "download_channel");
                }
                kVar = g;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return kVar;
    }

    public static synchronized a.a j(Context context) {
        a.a aVar;
        synchronized (a.class) {
            try {
                if (b == null) {
                    CronetEngine a2 = CronetUtil.a(context.getApplicationContext());
                    if (a2 != null) {
                        b = new CronetDataSource.b(a2, Executors.newSingleThreadExecutor());
                    }
                    if (b == null) {
                        CookieManager cookieManager = new CookieManager();
                        cookieManager.setCookiePolicy(CookiePolicy.ACCEPT_ORIGINAL_SERVER);
                        CookieHandler.setDefault(cookieManager);
                        b = new c.b();
                    }
                }
                aVar = b;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return aVar;
    }
}
