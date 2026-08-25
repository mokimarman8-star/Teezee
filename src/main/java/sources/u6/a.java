package u6;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public abstract class a {
    public static final View a(ViewGroup viewGroup, int i) {
        Intrinsics.h(viewGroup, "<this>");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(i, viewGroup, false);
        Intrinsics.g(inflate, "from(this.context).infla…layoutResId, this, false)");
        return inflate;
    }
}
