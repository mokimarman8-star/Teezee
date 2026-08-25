package kl;

import android.util.Log;
import fl.k;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public abstract class c {
    private static final InterfaceC0080c a = new e();

    public interface a {
        Object create();
    }

    public interface b {
        k getVerifier();
    }

    /* renamed from: kl.c$c, reason: collision with other inner class name */
    public interface InterfaceC0080c {
        void reset(Object obj);
    }

    private static final class d implements f {
        private final a a;
        private final InterfaceC0080c b;
        private final f c;

        d(f fVar, a aVar, InterfaceC0080c interfaceC0080c) {
            this.c = fVar;
            this.a = aVar;
            this.b = interfaceC0080c;
        }

        @Override // kl.f
        public Object acquire() {
            Object acquire = this.c.acquire();
            if (acquire == null) {
                acquire = this.a.create();
                if (Log.isLoggable("FactoryPools", 2)) {
                    Log.v("FactoryPools", "Created new " + acquire.getClass());
                }
            }
            if (acquire instanceof b) {
                ((b) acquire).getVerifier().a(false);
            }
            return acquire;
        }

        @Override // kl.f
        public boolean release(Object obj) {
            if (obj instanceof b) {
                ((b) obj).getVerifier().a(true);
            }
            this.b.reset(obj);
            return this.c.release(obj);
        }
    }

    static class e implements InterfaceC0080c {
        e() {
        }

        @Override // kl.c.InterfaceC0080c
        public void reset(Object obj) {
        }
    }

    private static f a(f fVar, a aVar) {
        return b(fVar, aVar, a);
    }

    private static f b(f fVar, a aVar, InterfaceC0080c interfaceC0080c) {
        return new d(fVar, aVar, interfaceC0080c);
    }

    public static f c(int i, a aVar) {
        return a(new h(i), aVar);
    }
}
