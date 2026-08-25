package tu;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public abstract class e {
    public static final ThreadPoolExecutor a;

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        a = new ThreadPoolExecutor(availableProcessors + 1, (availableProcessors * 2) + 1, 1L, TimeUnit.SECONDS, new LinkedBlockingQueue());
    }
}
