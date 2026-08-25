package androidx.emoji2.text;

import android.os.Build;
import androidx.annotation.NonNull;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
abstract class g {

    private static class a {
        @NonNull
        static Set<int[]> a() {
            return b.a();
        }
    }

    private static class b {
        static Set a() {
            try {
                Object invoke = Class.forName("android.text.EmojiConsistency").getMethod("getEmojiConsistencySet", null).invoke(null, null);
                if (invoke == null) {
                    return Collections.emptySet();
                }
                Set set = (Set) invoke;
                Iterator it = set.iterator();
                while (it.hasNext()) {
                    if (!(it.next() instanceof int[])) {
                        return Collections.emptySet();
                    }
                }
                return set;
            } catch (Throwable unused) {
                return Collections.emptySet();
            }
        }
    }

    static Set a() {
        return Build.VERSION.SDK_INT >= 34 ? a.a() : b.a();
    }
}
