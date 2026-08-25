package na;

import android.os.Bundle;
import com.google.android.exoplayer2.k;
import com.google.common.collect.ImmutableList;
import com.google.common.primitives.Ints;
import java.util.Collections;
import java.util.List;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class x implements com.google.android.exoplayer2.k {
    public static final k.a c = new k.a() { // from class: na.w
        public final com.google.android.exoplayer2.k a(Bundle bundle) {
            x d;
            d = x.d(bundle);
            return d;
        }
    };
    public final v9.w a;
    public final ImmutableList b;

    public x(v9.w wVar, List list) {
        if (!list.isEmpty() && (((Integer) Collections.min(list)).intValue() < 0 || ((Integer) Collections.max(list)).intValue() >= wVar.a)) {
            throw new IndexOutOfBoundsException();
        }
        this.a = wVar;
        this.b = ImmutableList.copyOf(list);
    }

    private static String c(int i) {
        return Integer.toString(i, 36);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ x d(Bundle bundle) {
        return new x((v9.w) v9.w.f.a((Bundle) com.google.android.exoplayer2.util.a.e(bundle.getBundle(c(0)))), Ints.c((int[]) com.google.android.exoplayer2.util.a.e(bundle.getIntArray(c(1)))));
    }

    public int b() {
        return this.a.c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || x.class != obj.getClass()) {
            return false;
        }
        x xVar = (x) obj;
        return this.a.equals(xVar.a) && this.b.equals(xVar.b);
    }

    public int hashCode() {
        return this.a.hashCode() + (this.b.hashCode() * 31);
    }

    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putBundle(c(0), this.a.toBundle());
        bundle.putIntArray(c(1), Ints.o(this.b));
        return bundle;
    }
}
