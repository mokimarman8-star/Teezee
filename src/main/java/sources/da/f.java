package da;

import android.os.Bundle;
import com.google.android.exoplayer2.k;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class f implements com.google.android.exoplayer2.k {
    public static final f b = new f(ImmutableList.of());
    public static final k.a c = new k.a() { // from class: da.e
        public final com.google.android.exoplayer2.k a(Bundle bundle) {
            f c2;
            c2 = f.c(bundle);
            return c2;
        }
    };
    public final ImmutableList a;

    public f(List list) {
        this.a = ImmutableList.copyOf(list);
    }

    private static ImmutableList b(List list) {
        ImmutableList.a builder = ImmutableList.builder();
        for (int i = 0; i < list.size(); i++) {
            if (((b) list.get(i)).d == null) {
                builder.j((b) list.get(i));
            }
        }
        return builder.n();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final f c(Bundle bundle) {
        ArrayList parcelableArrayList = bundle.getParcelableArrayList(d(0));
        return new f(parcelableArrayList == null ? ImmutableList.of() : com.google.android.exoplayer2.util.d.b(b.s, parcelableArrayList));
    }

    private static String d(int i) {
        return Integer.toString(i, 36);
    }

    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList(d(0), com.google.android.exoplayer2.util.d.d(b(this.a)));
        return bundle;
    }
}
