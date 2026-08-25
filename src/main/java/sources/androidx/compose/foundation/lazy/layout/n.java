package androidx.compose.foundation.lazy.layout;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class n {
    public static final int a(m mVar, Object obj, int i5) {
        int a5;
        return (obj == null || mVar.getItemCount() == 0 || (i5 < mVar.getItemCount() && Intrinsics.c(obj, mVar.b(i5))) || (a5 = mVar.a(obj)) == -1) ? i5 : a5;
    }
}
