package zo;

import androidx.lifecycle.u;
import com.transsion.rewardscenter.model.RewardsCenterModel;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.n0;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class a {
    private final u a;
    private final RewardsCenterModel b;
    private final WeakReference c;
    private final n0 d;

    public a(u uVar, RewardsCenterModel rewardsCenterModel, WeakReference weakReference, n0 n0Var) {
        Intrinsics.h(uVar, "owner");
        Intrinsics.h(rewardsCenterModel, "viewModel");
        Intrinsics.h(weakReference, "fragment");
        Intrinsics.h(n0Var, "scope");
        this.a = uVar;
        this.b = rewardsCenterModel;
        this.c = weakReference;
        this.d = n0Var;
    }

    public final WeakReference a() {
        return this.c;
    }

    public final n0 b() {
        return this.d;
    }

    public final RewardsCenterModel c() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return Intrinsics.c(this.a, aVar.a) && Intrinsics.c(this.b, aVar.b) && Intrinsics.c(this.c, aVar.c) && Intrinsics.c(this.d, aVar.d);
    }

    public int hashCode() {
        return (((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode();
    }

    public String toString() {
        return "TaskConfig(owner=" + this.a + ", viewModel=" + this.b + ", fragment=" + this.c + ", scope=" + this.d + ")";
    }
}
