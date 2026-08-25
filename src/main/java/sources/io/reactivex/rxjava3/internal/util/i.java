package io.reactivex.rxjava3.internal.util;

import io.reactivex.rxjava3.core.o;
import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.operators.SpscArrayQueue;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public abstract class i {
    public static boolean a(boolean z, boolean z2, i00.c cVar, boolean z3, io.reactivex.rxjava3.operators.g gVar, h hVar) {
        if (hVar.cancelled()) {
            gVar.clear();
            return true;
        }
        if (!z) {
            return false;
        }
        if (z3) {
            if (!z2) {
                return false;
            }
            Throwable error = hVar.error();
            if (error != null) {
                cVar.onError(error);
            } else {
                cVar.onComplete();
            }
            return true;
        }
        Throwable error2 = hVar.error();
        if (error2 != null) {
            gVar.clear();
            cVar.onError(error2);
            return true;
        }
        if (!z2) {
            return false;
        }
        cVar.onComplete();
        return true;
    }

    public static boolean b(boolean z, boolean z2, o oVar, boolean z3, io.reactivex.rxjava3.operators.g gVar, io.reactivex.rxjava3.disposables.c cVar, e eVar) {
        if (eVar.cancelled()) {
            gVar.clear();
            cVar.dispose();
            return true;
        }
        if (!z) {
            return false;
        }
        if (z3) {
            if (!z2) {
                return false;
            }
            if (cVar != null) {
                cVar.dispose();
            }
            Throwable error = eVar.error();
            if (error != null) {
                oVar.onError(error);
            } else {
                oVar.onComplete();
            }
            return true;
        }
        Throwable error2 = eVar.error();
        if (error2 != null) {
            gVar.clear();
            if (cVar != null) {
                cVar.dispose();
            }
            oVar.onError(error2);
            return true;
        }
        if (!z2) {
            return false;
        }
        if (cVar != null) {
            cVar.dispose();
        }
        oVar.onComplete();
        return true;
    }

    public static io.reactivex.rxjava3.operators.g c(int i) {
        return i < 0 ? new io.reactivex.rxjava3.operators.h(-i) : new SpscArrayQueue(i);
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0033, code lost:
    
        r1 = r15.leave(-r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0038, code lost:
    
        if (r1 != 0) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x003a, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void d(io.reactivex.rxjava3.operators.f fVar, o oVar, boolean z, io.reactivex.rxjava3.disposables.c cVar, e eVar) {
        int i = 1;
        while (!b(eVar.done(), fVar.isEmpty(), oVar, z, fVar, cVar, eVar)) {
            while (true) {
                boolean done = eVar.done();
                Object poll = fVar.poll();
                boolean z2 = poll == null;
                if (b(done, z2, oVar, z, fVar, cVar, eVar)) {
                    return;
                }
                if (z2) {
                    break;
                } else {
                    eVar.accept(oVar, poll);
                }
            }
        }
    }

    public static void e(io.reactivex.rxjava3.operators.f fVar, i00.c cVar, boolean z, io.reactivex.rxjava3.disposables.c cVar2, h hVar) {
        int i = 1;
        while (true) {
            boolean done = hVar.done();
            Object poll = fVar.poll();
            boolean z2 = poll == null;
            if (a(done, z2, cVar, z, fVar, hVar)) {
                if (cVar2 != null) {
                    cVar2.dispose();
                    return;
                }
                return;
            } else if (z2) {
                i = hVar.leave(-i);
                if (i == 0) {
                    return;
                }
            } else {
                long requested = hVar.requested();
                if (requested == 0) {
                    fVar.clear();
                    if (cVar2 != null) {
                        cVar2.dispose();
                    }
                    cVar.onError(MissingBackpressureException.createDefault());
                    return;
                }
                if (hVar.accept(cVar, poll) && requested != Long.MAX_VALUE) {
                    hVar.produced(1L);
                }
            }
        }
    }

    public static void f(i00.d dVar, int i) {
        dVar.request(i < 0 ? Long.MAX_VALUE : i);
    }
}
