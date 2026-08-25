package aa;

import java.util.Collections;
import java.util.List;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public abstract class d implements com.google.android.exoplayer2.offline.c {
    public final String a;
    public final List b;
    public final boolean c;

    protected d(String str, List list, boolean z) {
        this.a = str;
        this.b = Collections.unmodifiableList(list);
        this.c = z;
    }
}
