package com.bumptech.glide.util.pool;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.util.f;
import androidx.core.util.g;
import androidx.core.util.h;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public final class FactoryPools {
    private static final int DEFAULT_POOL_SIZE = 20;
    private static final Resetter<Object> EMPTY_RESETTER = new Resetter<Object>() { // from class: com.bumptech.glide.util.pool.FactoryPools.1
        @Override // com.bumptech.glide.util.pool.FactoryPools.Resetter
        public void reset(@NonNull Object obj) {
        }
    };
    private static final String TAG = "FactoryPools";

    public interface Factory<T> {
        T create();
    }

    private static final class FactoryPool<T> implements f {
        private final Factory<T> factory;
        private final f pool;
        private final Resetter<T> resetter;

        FactoryPool(@NonNull f fVar, @NonNull Factory<T> factory, @NonNull Resetter<T> resetter) {
            this.pool = fVar;
            this.factory = factory;
            this.resetter = resetter;
        }

        public T acquire() {
            T t = (T) this.pool.acquire();
            if (t == null) {
                t = this.factory.create();
                if (Log.isLoggable(FactoryPools.TAG, 2)) {
                    Log.v(FactoryPools.TAG, "Created new " + t.getClass());
                }
            }
            if (t instanceof Poolable) {
                t.getVerifier().setRecycled(false);
            }
            return (T) t;
        }

        public boolean release(@NonNull T t) {
            if (t instanceof Poolable) {
                ((Poolable) t).getVerifier().setRecycled(true);
            }
            this.resetter.reset(t);
            return this.pool.release(t);
        }
    }

    public interface Poolable {
        @NonNull
        StateVerifier getVerifier();
    }

    public interface Resetter<T> {
        void reset(@NonNull T t);
    }

    private FactoryPools() {
    }

    @NonNull
    private static <T extends Poolable> f build(@NonNull f fVar, @NonNull Factory<T> factory) {
        return build(fVar, factory, emptyResetter());
    }

    @NonNull
    private static <T> f build(@NonNull f fVar, @NonNull Factory<T> factory, @NonNull Resetter<T> resetter) {
        return new FactoryPool(fVar, factory, resetter);
    }

    @NonNull
    private static <T> Resetter<T> emptyResetter() {
        return (Resetter<T>) EMPTY_RESETTER;
    }

    @NonNull
    public static <T extends Poolable> f simple(int i, @NonNull Factory<T> factory) {
        return build(new g(i), factory);
    }

    @NonNull
    public static <T extends Poolable> f threadSafe(int i, @NonNull Factory<T> factory) {
        return build(new h(i), factory);
    }

    @NonNull
    public static <T extends Poolable> f threadSafe(int i, @NonNull Factory<T> factory, @NonNull Resetter<T> resetter) {
        return build(new h(i), factory, resetter);
    }

    @NonNull
    public static <T> f threadSafeList() {
        return threadSafeList(20);
    }

    @NonNull
    public static <T> f threadSafeList(int i) {
        return build(new h(i), new Factory<List<T>>() { // from class: com.bumptech.glide.util.pool.FactoryPools.2
            @Override // com.bumptech.glide.util.pool.FactoryPools.Factory
            @NonNull
            public List<T> create() {
                return new ArrayList();
            }
        }, new Resetter<List<T>>() { // from class: com.bumptech.glide.util.pool.FactoryPools.3
            @Override // com.bumptech.glide.util.pool.FactoryPools.Resetter
            public void reset(@NonNull List<T> list) {
                list.clear();
            }
        });
    }
}
