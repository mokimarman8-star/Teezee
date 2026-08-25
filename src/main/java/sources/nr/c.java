package nr;

import com.transsion.ad.bidding.nativead.BiddingNativeManager;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class c extends k {
    private BiddingNativeManager a;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public c() {
        this(r0, 1, r0);
        BiddingNativeManager biddingNativeManager = null;
    }

    public c(BiddingNativeManager biddingNativeManager) {
        super(null);
        this.a = biddingNativeManager;
    }

    public /* synthetic */ c(BiddingNativeManager biddingNativeManager, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : biddingNativeManager);
    }

    public final BiddingNativeManager a() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof c) && Intrinsics.c(this.a, ((c) obj).a);
    }

    public int hashCode() {
        BiddingNativeManager biddingNativeManager = this.a;
        if (biddingNativeManager == null) {
            return 0;
        }
        return biddingNativeManager.hashCode();
    }

    public String toString() {
        return "ShortTvAdItem(nonAdDelegate=" + this.a + ")";
    }
}
