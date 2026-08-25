package androidx.coroutines;

import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class ObservedTableStates {

    /* renamed from: a, reason: collision with root package name */
    private final ReentrantLock f13038a = new ReentrantLock();

    /* renamed from: b, reason: collision with root package name */
    private final long[] f13039b;

    /* renamed from: c, reason: collision with root package name */
    private final boolean[] f13040c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f13041d;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Landroidx/room/ObservedTableStates$ObserveOp;", "", "<init>", "(Ljava/lang/String;I)V", "NO_OP", "ADD", "REMOVE", "room-runtime_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class ObserveOp {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ ObserveOp[] $VALUES;
        public static final ObserveOp NO_OP = new ObserveOp("NO_OP", 0);
        public static final ObserveOp ADD = new ObserveOp("ADD", 1);
        public static final ObserveOp REMOVE = new ObserveOp("REMOVE", 2);

        private static final /* synthetic */ ObserveOp[] $values() {
            return new ObserveOp[]{NO_OP, ADD, REMOVE};
        }

        static {
            ObserveOp[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.a($values);
        }

        private ObserveOp(String str, int i5) {
        }

        public static EnumEntries<ObserveOp> getEntries() {
            return $ENTRIES;
        }

        public static ObserveOp valueOf(String str) {
            return (ObserveOp) Enum.valueOf(ObserveOp.class, str);
        }

        public static ObserveOp[] values() {
            return (ObserveOp[]) $VALUES.clone();
        }
    }

    public ObservedTableStates(int i5) {
        this.f13039b = new long[i5];
        this.f13040c = new boolean[i5];
    }

    public final void a() {
        ReentrantLock reentrantLock = this.f13038a;
        reentrantLock.lock();
        try {
            this.f13041d = true;
            Unit unit = Unit.a;
        } finally {
            reentrantLock.unlock();
        }
    }

    public final ObserveOp[] b() {
        ObserveOp observeOp;
        ReentrantLock reentrantLock = this.f13038a;
        reentrantLock.lock();
        try {
            if (!this.f13041d) {
                reentrantLock.unlock();
                return null;
            }
            this.f13041d = false;
            int length = this.f13039b.length;
            ObserveOp[] observeOpArr = new ObserveOp[length];
            int i5 = 0;
            boolean z5 = false;
            while (i5 < length) {
                boolean z6 = true;
                boolean z7 = this.f13039b[i5] > 0;
                boolean[] zArr = this.f13040c;
                if (z7 != zArr[i5]) {
                    zArr[i5] = z7;
                    observeOp = z7 ? ObserveOp.ADD : ObserveOp.REMOVE;
                } else {
                    z6 = z5;
                    observeOp = ObserveOp.NO_OP;
                }
                observeOpArr[i5] = observeOp;
                i5++;
                z5 = z6;
            }
            ObserveOp[] observeOpArr2 = z5 ? observeOpArr : null;
            reentrantLock.unlock();
            return observeOpArr2;
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public final boolean c(int[] iArr) {
        Intrinsics.h(iArr, "tableIds");
        ReentrantLock reentrantLock = this.f13038a;
        reentrantLock.lock();
        try {
            boolean z5 = false;
            for (int i5 : iArr) {
                long[] jArr = this.f13039b;
                long j5 = jArr[i5];
                jArr[i5] = 1 + j5;
                if (j5 == 0) {
                    z5 = true;
                    this.f13041d = true;
                }
            }
            return z5;
        } finally {
            reentrantLock.unlock();
        }
    }

    public final boolean d(int[] iArr) {
        Intrinsics.h(iArr, "tableIds");
        ReentrantLock reentrantLock = this.f13038a;
        reentrantLock.lock();
        try {
            boolean z5 = false;
            for (int i5 : iArr) {
                long[] jArr = this.f13039b;
                long j5 = jArr[i5];
                jArr[i5] = j5 - 1;
                if (j5 == 1) {
                    z5 = true;
                    this.f13041d = true;
                }
            }
            return z5;
        } finally {
            reentrantLock.unlock();
        }
    }

    public final void e() {
        ReentrantLock reentrantLock = this.f13038a;
        reentrantLock.lock();
        try {
            ArraysKt.z(this.f13040c, false, 0, 0, 6, (Object) null);
            this.f13041d = true;
            Unit unit = Unit.a;
        } finally {
            reentrantLock.unlock();
        }
    }
}
