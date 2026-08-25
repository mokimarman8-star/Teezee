package com.cloud.hisavana.net.disklrucache.impl;

import com.cloud.hisavana.net.disklrucache.impl.IDiskCache;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class DiskCacheProvider implements IDiskCache.Provider {
    private volatile IDiskCache a;
    private volatile IDiskCache b;
    private volatile IDiskCache c;

    private IDiskCache a(long j) {
        if (this.c == null) {
            synchronized (this) {
                try {
                    if (this.c == null) {
                        this.c = new DiskLruCacheFactory(j, 4).a();
                    }
                } finally {
                }
            }
        }
        return this.c;
    }

    private IDiskCache c(long j) {
        if (this.a == null) {
            synchronized (this) {
                try {
                    if (this.a == null) {
                        this.a = new DiskLruCacheFactory(j, 1).a();
                    }
                } finally {
                }
            }
        }
        return this.a;
    }

    private IDiskCache d(long j) {
        if (this.b == null) {
            synchronized (this) {
                try {
                    if (this.b == null) {
                        this.b = new DiskLruCacheFactory(j, 3).a();
                    }
                } finally {
                }
            }
        }
        return this.b;
    }

    public IDiskCache b(long j, int i) {
        return i != 3 ? i != 4 ? c(j) : a(j) : d(j);
    }
}
