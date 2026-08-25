package com.bumptech.glide.integration.webp.decoder;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public final class WebpFrameCacheStrategy {
    private int mCacheSize;
    private CacheControl mCacheStrategy;
    public static final WebpFrameCacheStrategy NONE = new Builder().noCache().build();
    public static final WebpFrameCacheStrategy AUTO = new Builder().cacheAuto().build();
    public static final WebpFrameCacheStrategy ALL = new Builder().cacheAll().build();

    public enum CacheControl {
        CACHE_NONE,
        CACHE_LIMITED,
        CACHE_AUTO,
        CACHE_ALL
    }

    private WebpFrameCacheStrategy(Builder builder) {
        this.mCacheStrategy = Builder.access$000(builder);
        this.mCacheSize = Builder.access$100(builder);
    }

    public boolean cacheAll() {
        return this.mCacheStrategy == CacheControl.CACHE_ALL;
    }

    public boolean cacheAuto() {
        return this.mCacheStrategy == CacheControl.CACHE_AUTO;
    }

    public CacheControl getCacheControl() {
        return this.mCacheStrategy;
    }

    public int getCacheSize() {
        return this.mCacheSize;
    }

    public boolean noCache() {
        return this.mCacheStrategy == CacheControl.CACHE_NONE;
    }
}
