package eq;

import com.transsion.search_pugc.bean.SecondTab;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class a {
    private SecondTab a;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public a() {
        this(r0, 1, r0);
        SecondTab secondTab = null;
    }

    public a(SecondTab secondTab) {
        this.a = secondTab;
    }

    public /* synthetic */ a(SecondTab secondTab, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : secondTab);
    }

    public final SecondTab a() {
        return this.a;
    }

    public final void b(SecondTab secondTab) {
        this.a = secondTab;
    }
}
