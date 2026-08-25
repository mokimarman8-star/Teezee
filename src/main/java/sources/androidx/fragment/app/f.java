package androidx.fragment.app;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class f {
    public Fragment b(Context context, String str, Bundle bundle) {
        return Fragment.instantiate(context, str, bundle);
    }

    public abstract View c(int i5);

    public abstract boolean d();
}
