package androidx.datastore.preferences;

import android.content.Context;
import java.io.File;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class a {
    public static final File a(Context context, String str) {
        Intrinsics.h(context, "<this>");
        Intrinsics.h(str, "name");
        return i1.a.a(context, str + ".preferences_pb");
    }
}
