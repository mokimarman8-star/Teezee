package io;

import kotlin.jvm.functions.Function0;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public interface c {

    public static final class a {
        public static /* synthetic */ void a(c cVar, Function0 function0, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: doRefresh");
            }
            if ((i & 1) != 0) {
                function0 = null;
            }
            cVar.doRefresh(function0);
        }
    }

    void doRefresh(Function0 function0);
}
