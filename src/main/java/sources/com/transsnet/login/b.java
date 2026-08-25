package com.transsnet.login;

import com.blankj.utilcode.util.ThreadUtils;
import com.transsnet.login.b;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class b {
    public static final a a = new a(null);

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(int i) {
            fh.b.a.d(i);
        }

        public final void b(final int i) {
            ThreadUtils.f().postDelayed(new Runnable() { // from class: com.transsnet.login.a
                @Override // java.lang.Runnable
                public final void run() {
                    b.a.c(i);
                }
            }, 500L);
        }
    }
}
