package com.transsion.player.shorttv.preload;

import androidx.media3.common.PriorityTaskManager;
import androidx.media3.common.t;
import androidx.media3.common.util.RunnableFutureTask;
import androidx.media3.common.util.a1;
import androidx.media3.datasource.cache.a;
import androidx.media3.datasource.cache.i;
import androidx.media3.exoplayer.offline.o;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import w1.h;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class VideoProgressiveDownloader implements androidx.media3.exoplayer.offline.o {
    private final Executor a;
    private final w1.h b;
    private final androidx.media3.datasource.cache.a c;
    private final androidx.media3.datasource.cache.i d;
    private final PriorityTaskManager e;
    private o.a f;
    private volatile RunnableFutureTask g;
    private volatile boolean h;

    public VideoProgressiveDownloader(t tVar, a.c cVar, Executor executor) {
        this.a = (Executor) androidx.media3.common.util.a.e(executor);
        androidx.media3.common.util.a.e(tVar.b);
        w1.h a = new h.b().i(tVar.b.a).f(tVar.b.e).b(4).a();
        this.b = a;
        androidx.media3.datasource.cache.a b = cVar.b();
        this.c = b;
        this.d = new androidx.media3.datasource.cache.i(b, a, (byte[]) null, new i.a() { // from class: com.transsion.player.shorttv.preload.r
            public final void a(long j, long j2, long j3) {
                VideoProgressiveDownloader.this.d(j, j2, j3);
            }
        });
        this.e = cVar.g();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(long j, long j2, long j3) {
        o.a aVar = this.f;
        if (aVar == null) {
            return;
        }
        aVar.onProgress(j, j2, (j == -1 || j == 0) ? -1.0f : (j2 * 100.0f) / j);
    }

    public void a(o.a aVar) {
        this.f = aVar;
        PriorityTaskManager priorityTaskManager = this.e;
        if (priorityTaskManager != null) {
            priorityTaskManager.a(-4000);
        }
        boolean z = false;
        while (!z) {
            try {
                if (this.h) {
                    break;
                }
                this.g = new RunnableFutureTask<Void, IOException>() { // from class: com.transsion.player.shorttv.preload.VideoProgressiveDownloader.1
                    protected void cancelWork() {
                        VideoProgressiveDownloader.this.d.b();
                    }

                    /* JADX INFO: Access modifiers changed from: protected */
                    public Void doWork() throws IOException {
                        VideoProgressiveDownloader.this.d.a();
                        return null;
                    }
                };
                PriorityTaskManager priorityTaskManager2 = this.e;
                if (priorityTaskManager2 != null) {
                    priorityTaskManager2.b(-4000);
                }
                this.a.execute(this.g);
                try {
                    this.g.get();
                    z = true;
                } catch (ExecutionException e) {
                    Throwable th2 = (Throwable) androidx.media3.common.util.a.e(e.getCause());
                    if (!(th2 instanceof PriorityTaskManager.PriorityTooLowException)) {
                        if (th2 instanceof IOException) {
                            throw ((IOException) th2);
                        }
                        a1.m1(th2);
                    }
                }
            } catch (Throwable th3) {
                ((RunnableFutureTask) androidx.media3.common.util.a.e(this.g)).blockUntilFinished();
                PriorityTaskManager priorityTaskManager3 = this.e;
                if (priorityTaskManager3 != null) {
                    priorityTaskManager3.d(-4000);
                }
                throw th3;
            }
        }
        ((RunnableFutureTask) androidx.media3.common.util.a.e(this.g)).blockUntilFinished();
        PriorityTaskManager priorityTaskManager4 = this.e;
        if (priorityTaskManager4 != null) {
            priorityTaskManager4.d(-4000);
        }
    }

    public void cancel() {
        this.h = true;
        RunnableFutureTask runnableFutureTask = this.g;
        if (runnableFutureTask != null) {
            runnableFutureTask.cancel(true);
        }
    }

    public void remove() {
    }
}
