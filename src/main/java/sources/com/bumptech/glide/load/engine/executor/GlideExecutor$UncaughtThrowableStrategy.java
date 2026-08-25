package com.bumptech.glide.load.engine.executor;

import android.util.Log;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public interface GlideExecutor$UncaughtThrowableStrategy {
    public static final GlideExecutor$UncaughtThrowableStrategy DEFAULT;
    public static final GlideExecutor$UncaughtThrowableStrategy IGNORE = new GlideExecutor$UncaughtThrowableStrategy() { // from class: com.bumptech.glide.load.engine.executor.GlideExecutor$UncaughtThrowableStrategy.1
        @Override // com.bumptech.glide.load.engine.executor.GlideExecutor$UncaughtThrowableStrategy
        public void handle(Throwable th) {
        }
    };
    public static final GlideExecutor$UncaughtThrowableStrategy LOG;
    public static final GlideExecutor$UncaughtThrowableStrategy THROW;

    static {
        GlideExecutor$UncaughtThrowableStrategy glideExecutor$UncaughtThrowableStrategy = new GlideExecutor$UncaughtThrowableStrategy() { // from class: com.bumptech.glide.load.engine.executor.GlideExecutor$UncaughtThrowableStrategy.2
            @Override // com.bumptech.glide.load.engine.executor.GlideExecutor$UncaughtThrowableStrategy
            public void handle(Throwable th) {
                if (th == null || !Log.isLoggable("GlideExecutor", 6)) {
                    return;
                }
                Log.e("GlideExecutor", "Request threw uncaught throwable", th);
            }
        };
        LOG = glideExecutor$UncaughtThrowableStrategy;
        THROW = new GlideExecutor$UncaughtThrowableStrategy() { // from class: com.bumptech.glide.load.engine.executor.GlideExecutor$UncaughtThrowableStrategy.3
            @Override // com.bumptech.glide.load.engine.executor.GlideExecutor$UncaughtThrowableStrategy
            public void handle(Throwable th) {
                if (th != null) {
                    throw new RuntimeException("Request threw uncaught throwable", th);
                }
            }
        };
        DEFAULT = glideExecutor$UncaughtThrowableStrategy;
    }

    void handle(Throwable th);
}
