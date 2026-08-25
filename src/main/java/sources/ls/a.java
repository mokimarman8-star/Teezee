package ls;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public abstract class a {
    public static final boolean a(Context context) {
        Intrinsics.h(context, "<this>");
        return (context.getResources().getConfiguration().screenLayout & 15) >= 3;
    }
}
