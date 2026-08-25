package androidx.coroutines;

import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import z3.h;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class f extends l0 {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(RoomDatabase roomDatabase) {
        super(roomDatabase);
        Intrinsics.h(roomDatabase, "database");
    }

    protected abstract void j(h hVar, Object obj);

    public final int k(Object obj) {
        h b5 = b();
        try {
            j(b5, obj);
            return b5.F();
        } finally {
            h(b5);
        }
    }

    public final int l(Iterable iterable) {
        Intrinsics.h(iterable, "entities");
        h b5 = b();
        try {
            Iterator it = iterable.iterator();
            int i5 = 0;
            while (it.hasNext()) {
                j(b5, it.next());
                i5 += b5.F();
            }
            return i5;
        } finally {
            h(b5);
        }
    }
}
