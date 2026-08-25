package com.bumptech.glide.integration.webp.decoder;

import com.bumptech.glide.integration.webp.decoder.WebpFrameCacheStrategy;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public final class WebpFrameCacheStrategy$Builder {
    private WebpFrameCacheStrategy.CacheControl cacheControl;
    private int cacheSize;

    public WebpFrameCacheStrategy build() {
        return new WebpFrameCacheStrategy(this, (WebpFrameCacheStrategy$1) null);
    }

    public WebpFrameCacheStrategy$Builder cacheAll() {
        this.cacheControl = WebpFrameCacheStrategy.CacheControl.CACHE_ALL;
        return this;
    }

    public WebpFrameCacheStrategy$Builder cacheAuto() {
        this.cacheControl = WebpFrameCacheStrategy.CacheControl.CACHE_AUTO;
        return this;
    }

    public WebpFrameCacheStrategy$Builder cacheControl(WebpFrameCacheStrategy.CacheControl cacheControl) {
        this.cacheControl = cacheControl;
        return this;
    }

    public WebpFrameCacheStrategy$Builder cacheLimited() {
        this.cacheControl = WebpFrameCacheStrategy.CacheControl.CACHE_LIMITED;
        return this;
    }

    public WebpFrameCacheStrategy$Builder cacheSize(int i) {
        this.cacheSize = i;
        if (i == 0) {
            this.cacheControl = WebpFrameCacheStrategy.CacheControl.CACHE_NONE;
        } else if (i == Integer.MAX_VALUE) {
            this.cacheControl = WebpFrameCacheStrategy.CacheControl.CACHE_ALL;
        } else {
            this.cacheControl = WebpFrameCacheStrategy.CacheControl.CACHE_LIMITED;
        }
        return this;
    }

    public WebpFrameCacheStrategy$Builder noCache() {
        this.cacheControl = WebpFrameCacheStrategy.CacheControl.CACHE_NONE;
        return this;
    }
}
