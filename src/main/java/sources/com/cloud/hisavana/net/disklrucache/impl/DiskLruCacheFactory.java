package com.cloud.hisavana.net.disklrucache.impl;

import com.cloud.hisavana.net.disklrucache.impl.IDiskCache;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class DiskLruCacheFactory implements IDiskCache.Factory {
    private final long a;
    private final int b;

    public DiskLruCacheFactory(long j, int i) {
        this.a = j;
        this.b = i;
    }

    public IDiskCache a() {
        return new DiskCacheImpl(null, this.a, this.b);
    }
}
