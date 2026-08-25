package kotlinx.coroutines.channels;

import kotlinx.coroutines.internal.a0;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public interface d extends s, r {
    public static final a n1 = a.a;

    public static final class a {
        static final /* synthetic */ a a = new a();
        private static final int b = a0.b("kotlinx.coroutines.channels.defaultBuffer", 64, 1, 2147483646);

        private a() {
        }

        public final int a() {
            return b;
        }
    }
}
