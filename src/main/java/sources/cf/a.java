package cf;

import android.os.Build;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import gf.h;
import gf.o0;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public final class a {
    private FragmentActivity a;
    private Fragment b;

    public a(FragmentActivity fragmentActivity) {
        Intrinsics.h(fragmentActivity, "activity");
        this.a = fragmentActivity;
    }

    public final h a(List list) {
        int i;
        Intrinsics.h(list, "permissions");
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        LinkedHashSet linkedHashSet2 = new LinkedHashSet();
        int i2 = Build.VERSION.SDK_INT;
        FragmentActivity fragmentActivity = this.a;
        if (fragmentActivity != null) {
            Intrinsics.e(fragmentActivity);
            i = fragmentActivity.getApplicationInfo().targetSdkVersion;
        } else {
            Fragment fragment = this.b;
            Intrinsics.e(fragment);
            i = fragment.requireContext().getApplicationInfo().targetSdkVersion;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            if (ff.b.a().contains(str)) {
                linkedHashSet2.add(str);
            } else {
                linkedHashSet.add(str);
            }
        }
        if (linkedHashSet2.contains("android.permission.ACCESS_BACKGROUND_LOCATION") && (i2 == 29 || (i2 == 30 && i < 30))) {
            linkedHashSet2.remove("android.permission.ACCESS_BACKGROUND_LOCATION");
            linkedHashSet.add("android.permission.ACCESS_BACKGROUND_LOCATION");
        }
        if (linkedHashSet2.contains("android.permission.POST_NOTIFICATIONS") && i2 >= 33 && i >= 33) {
            linkedHashSet2.remove("android.permission.POST_NOTIFICATIONS");
            linkedHashSet.add("android.permission.POST_NOTIFICATIONS");
        }
        return new o0(this.a, this.b, linkedHashSet, linkedHashSet2);
    }

    public final h b(String... strArr) {
        Intrinsics.h(strArr, "permissions");
        return a(CollectionsKt.o(Arrays.copyOf(strArr, strArr.length)));
    }
}
