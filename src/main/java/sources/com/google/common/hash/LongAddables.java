package com.google.common.hash;

import com.google.common.base.q;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
abstract class LongAddables {
    private static final q a;

    private static final class PureJavaLongAddable extends AtomicLong implements h {
        private PureJavaLongAddable() {
        }

        /* synthetic */ PureJavaLongAddable(a aVar) {
            this();
        }

        @Override // com.google.common.hash.h
        public void add(long j) {
            getAndAdd(j);
        }

        @Override // com.google.common.hash.h
        public void increment() {
            getAndIncrement();
        }

        @Override // com.google.common.hash.h
        public long sum() {
            return get();
        }
    }

    class a implements q {
        a() {
        }

        @Override // com.google.common.base.q
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public h get() {
            return new LongAdder();
        }
    }

    class b implements q {
        b() {
        }

        @Override // com.google.common.base.q
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public h get() {
            return new PureJavaLongAddable(null);
        }
    }

    static {
        q bVar;
        try {
            new LongAdder();
            bVar = new a();
        } catch (Throwable unused) {
            bVar = new b();
        }
        a = bVar;
    }

    public static h a() {
        return (h) a.get();
    }
}
