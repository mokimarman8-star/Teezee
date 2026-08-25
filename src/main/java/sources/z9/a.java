package z9;

import java.util.Collections;
import java.util.List;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public class a {
    public final int a;
    public final int b;
    public final List c;
    public final List d;
    public final List e;
    public final List f;

    public a(int i, int i2, List list, List list2, List list3, List list4) {
        this.a = i;
        this.b = i2;
        this.c = Collections.unmodifiableList(list);
        this.d = Collections.unmodifiableList(list2);
        this.e = Collections.unmodifiableList(list3);
        this.f = Collections.unmodifiableList(list4);
    }
}
