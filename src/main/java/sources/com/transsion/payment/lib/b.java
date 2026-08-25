package com.transsion.payment.lib;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public interface b {

    public static final class a {
        public static /* synthetic */ void a(b bVar, Integer num, String str, boolean z, String str2, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: error");
            }
            if ((i & 1) != 0) {
                num = 0;
            }
            if ((i & 8) != 0) {
                str2 = null;
            }
            bVar.a(num, str, z, str2);
        }
    }

    void a(Integer num, String str, boolean z, String str2);

    void b(boolean z);

    void c(int i, String str, String str2);
}
