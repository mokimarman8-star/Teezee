package bs;

import android.view.View;
import com.transsion.shorttv.bean.OperateItem;
import com.transsion.shorttv.bean.Subject;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class a {
    public static final C0001a g = new C0001a(null);
    private final int a;
    private final View b;
    private final Subject c;
    private final OperateItem d;
    private final int e;
    private final boolean f;

    /* renamed from: bs.a$a, reason: collision with other inner class name */
    public static final class C0001a {
        private C0001a() {
        }

        public /* synthetic */ C0001a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public a(int i, View view, Subject subject, OperateItem operateItem, int i2, boolean z) {
        this.a = i;
        this.b = view;
        this.c = subject;
        this.d = operateItem;
        this.e = i2;
        this.f = z;
    }

    public /* synthetic */ a(int i, View view, Subject subject, OperateItem operateItem, int i2, boolean z, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, (i3 & 2) != 0 ? null : view, (i3 & 4) != 0 ? null : subject, (i3 & 8) == 0 ? operateItem : null, (i3 & 16) != 0 ? 0 : i2, (i3 & 32) == 0 ? z : false);
    }

    public final OperateItem a() {
        return this.d;
    }

    public final Subject b() {
        return this.c;
    }

    public final int c() {
        return this.e;
    }

    public final int d() {
        return this.a;
    }

    public final View e() {
        return this.b;
    }

    public final boolean f() {
        return this.f;
    }
}
