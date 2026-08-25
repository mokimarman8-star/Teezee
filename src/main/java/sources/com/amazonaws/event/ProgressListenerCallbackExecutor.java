package com.amazonaws.event;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class ProgressListenerCallbackExecutor {
    static ExecutorService b = b();
    private final ProgressListener a;

    /* renamed from: com.amazonaws.event.ProgressListenerCallbackExecutor$1, reason: invalid class name */
    final class AnonymousClass1 implements Runnable {
        final /* synthetic */ ProgressListener val$listener;
        final /* synthetic */ ProgressEvent val$progressEvent;

        AnonymousClass1(ProgressListener progressListener, ProgressEvent progressEvent) {
            this.val$listener = progressListener;
            this.val$progressEvent = progressEvent;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.val$listener.a(this.val$progressEvent);
        }
    }

    public ProgressListenerCallbackExecutor() {
        this.a = null;
    }

    public ProgressListenerCallbackExecutor(ProgressListener progressListener) {
        this.a = progressListener;
    }

    static ExecutorService b() {
        return Executors.newSingleThreadExecutor(new ThreadFactory() { // from class: com.amazonaws.event.ProgressListenerCallbackExecutor.3
            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                Thread thread = new Thread(runnable);
                thread.setName("android-sdk-progress-listener-callback-thread");
                thread.setDaemon(true);
                return thread;
            }
        });
    }

    public static ProgressListenerCallbackExecutor d(ProgressListener progressListener) {
        if (progressListener == null) {
            return null;
        }
        return new ProgressListenerCallbackExecutor(progressListener);
    }

    public void c(final ProgressEvent progressEvent) {
        if (this.a == null) {
            return;
        }
        b.submit(new Runnable() { // from class: com.amazonaws.event.ProgressListenerCallbackExecutor.2
            @Override // java.lang.Runnable
            public void run() {
                ProgressListenerCallbackExecutor.this.a.a(progressEvent);
            }
        });
    }
}
