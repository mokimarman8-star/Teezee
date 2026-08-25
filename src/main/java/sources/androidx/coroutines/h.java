package androidx.coroutines;

import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class h extends l0 {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(RoomDatabase roomDatabase) {
        super(roomDatabase);
        Intrinsics.h(roomDatabase, "database");
    }

    protected abstract void j(z3.h hVar, Object obj);

    public final void k(Iterable iterable) {
        Intrinsics.h(iterable, "entities");
        z3.h b5 = b();
        try {
            Iterator it = iterable.iterator();
            while (it.hasNext()) {
                j(b5, it.next());
                b5.R();
            }
        } finally {
            h(b5);
        }
    }

    public final void l(Object obj) {
        z3.h b5 = b();
        try {
            j(b5, obj);
            b5.R();
        } finally {
            h(b5);
        }
    }

    public final long m(Object obj) {
        z3.h b5 = b();
        try {
            j(b5, obj);
            return b5.R();
        } finally {
            h(b5);
        }
    }
}
