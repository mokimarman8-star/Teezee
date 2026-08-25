package com.google.common.util.concurrent;

/* JADX INFO: Access modifiers changed from: private */
/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public final class AbstractFuture$f extends AbstractFuture$b {
    private AbstractFuture$f() {
        super();
    }

    @Override // com.google.common.util.concurrent.AbstractFuture$b
    boolean a(AbstractFuture abstractFuture, AbstractFuture$d abstractFuture$d, AbstractFuture$d abstractFuture$d2) {
        synchronized (abstractFuture) {
            try {
                if (AbstractFuture.access$700(abstractFuture) != abstractFuture$d) {
                    return false;
                }
                AbstractFuture.access$702(abstractFuture, abstractFuture$d2);
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.google.common.util.concurrent.AbstractFuture$b
    boolean b(AbstractFuture abstractFuture, Object obj, Object obj2) {
        synchronized (abstractFuture) {
            try {
                if (AbstractFuture.access$300(abstractFuture) != obj) {
                    return false;
                }
                AbstractFuture.access$302(abstractFuture, obj2);
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.google.common.util.concurrent.AbstractFuture$b
    boolean c(AbstractFuture abstractFuture, AbstractFuture$j abstractFuture$j, AbstractFuture$j abstractFuture$j2) {
        synchronized (abstractFuture) {
            try {
                if (AbstractFuture.access$800(abstractFuture) != abstractFuture$j) {
                    return false;
                }
                AbstractFuture.access$802(abstractFuture, abstractFuture$j2);
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.google.common.util.concurrent.AbstractFuture$b
    AbstractFuture$d d(AbstractFuture abstractFuture, AbstractFuture$d abstractFuture$d) {
        AbstractFuture$d access$700;
        synchronized (abstractFuture) {
            try {
                access$700 = AbstractFuture.access$700(abstractFuture);
                if (access$700 != abstractFuture$d) {
                    AbstractFuture.access$702(abstractFuture, abstractFuture$d);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return access$700;
    }

    @Override // com.google.common.util.concurrent.AbstractFuture$b
    AbstractFuture$j e(AbstractFuture abstractFuture, AbstractFuture$j abstractFuture$j) {
        AbstractFuture$j access$800;
        synchronized (abstractFuture) {
            try {
                access$800 = AbstractFuture.access$800(abstractFuture);
                if (access$800 != abstractFuture$j) {
                    AbstractFuture.access$802(abstractFuture, abstractFuture$j);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return access$800;
    }

    @Override // com.google.common.util.concurrent.AbstractFuture$b
    void f(AbstractFuture$j abstractFuture$j, AbstractFuture$j abstractFuture$j2) {
        abstractFuture$j.b = abstractFuture$j2;
    }

    @Override // com.google.common.util.concurrent.AbstractFuture$b
    void g(AbstractFuture$j abstractFuture$j, Thread thread) {
        abstractFuture$j.a = thread;
    }
}
