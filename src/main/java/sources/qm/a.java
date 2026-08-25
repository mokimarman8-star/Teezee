package qm;

import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class a {
    private final int a;
    private int b;
    private List c;

    public a(int i, int i2) {
        this.a = i;
        this.b = i2;
    }

    public /* synthetic */ a(int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, (i3 & 2) != 0 ? 0 : i2);
    }

    public final int a() {
        return this.b;
    }

    public final List b() {
        return this.c;
    }

    public final int c() {
        return this.a;
    }

    public final boolean d() {
        return this.a > this.b;
    }

    public final void e(int i) {
        this.b = i;
    }

    public final void f(List list) {
        this.c = list;
    }
}
