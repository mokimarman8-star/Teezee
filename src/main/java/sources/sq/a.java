package sq;

import android.content.Context;
import com.transsion.ad.bidding.base.r;
import kotlin.jvm.internal.Intrinsics;
import wq.t;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class a {
    public static final a a = new a();

    private a() {
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0021, code lost:
    
        if (r4.equals("VideoForYouListScene") == false) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:?, code lost:
    
        return new wq.a(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0039, code lost:
    
        if (r4.equals("ShortTvListScene") == false) goto L22;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final r a(Context context, String str) {
        Intrinsics.h(context, "context");
        if (str != null) {
            int hashCode = str.hashCode();
            if (hashCode != -400527312) {
                if (hashCode != -58164131) {
                    if (hashCode == 1548392125) {
                    }
                } else if (str.equals("ShortTvDiscoverMostTrendingScene")) {
                    return new t(context);
                }
            }
        }
        return null;
    }
}
