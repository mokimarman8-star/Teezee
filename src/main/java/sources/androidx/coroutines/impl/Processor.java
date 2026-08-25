package androidx.coroutines.impl;

import android.content.Context;
import android.os.PowerManager;
import androidx.annotation.NonNull;
import androidx.core.content.b;
import androidx.coroutines.impl.WorkerWrapper;
import androidx.work.WorkerParameters;
import androidx.work.e;
import androidx.work.impl.foreground.SystemForegroundDispatcher;
import androidx.work.impl.foreground.a;
import androidx.work.impl.utils.s;
import androidx.work.j;
import com.google.common.util.concurrent.r;
import j4.m;
import j4.u;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import k4.c;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public class Processor implements e, a {
    private static final String m = j.i("Processor");
    private Context b;
    private androidx.work.a c;
    private c d;
    private WorkDatabase e;
    private List i;
    private Map g = new HashMap();
    private Map f = new HashMap();
    private Set j = new HashSet();
    private final List k = new ArrayList();
    private PowerManager.WakeLock a = null;
    private final Object l = new Object();
    private Map h = new HashMap();

    private static class FutureListener implements Runnable {

        @NonNull
        private e mExecutionListener;

        @NonNull
        private r mFuture;

        @NonNull
        private final m mWorkGenerationalId;

        FutureListener(@NonNull e eVar, @NonNull m mVar, @NonNull r rVar) {
            this.mExecutionListener = eVar;
            this.mWorkGenerationalId = mVar;
            this.mFuture = rVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z;
            try {
                z = ((Boolean) this.mFuture.get()).booleanValue();
            } catch (InterruptedException | ExecutionException unused) {
                z = true;
            }
            this.mExecutionListener.d(this.mWorkGenerationalId, z);
        }
    }

    public Processor(Context context, androidx.work.a aVar, c cVar, WorkDatabase workDatabase, List list) {
        this.b = context;
        this.c = aVar;
        this.d = cVar;
        this.e = workDatabase;
        this.i = list;
    }

    private static boolean i(String str, WorkerWrapper workerWrapper) {
        if (workerWrapper == null) {
            j.e().a(m, "WorkerWrapper could not be found for " + str);
            return false;
        }
        workerWrapper.interrupt();
        j.e().a(m, "WorkerWrapper interrupted for " + str);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ u m(ArrayList arrayList, String str) {
        arrayList.addAll(this.e.o0().b(str));
        return this.e.n0().j(str);
    }

    private void o(m mVar, boolean z) {
        this.d.a().execute(new q(this, mVar, z));
    }

    private void s() {
        synchronized (this.l) {
            try {
                if (this.f.isEmpty()) {
                    try {
                        this.b.startService(SystemForegroundDispatcher.g(this.b));
                    } catch (Throwable th) {
                        j.e().d(m, "Unable to stop foreground service", th);
                    }
                    PowerManager.WakeLock wakeLock = this.a;
                    if (wakeLock != null) {
                        wakeLock.release();
                        this.a = null;
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public void a(String str) {
        synchronized (this.l) {
            this.f.remove(str);
            s();
        }
    }

    public boolean b(String str) {
        boolean containsKey;
        synchronized (this.l) {
            containsKey = this.f.containsKey(str);
        }
        return containsKey;
    }

    public void c(String str, e eVar) {
        synchronized (this.l) {
            try {
                j.e().f(m, "Moving WorkSpec (" + str + ") to the foreground");
                WorkerWrapper workerWrapper = (WorkerWrapper) this.g.remove(str);
                if (workerWrapper != null) {
                    if (this.a == null) {
                        PowerManager.WakeLock b = s.b(this.b, "ProcessorForegroundLck");
                        this.a = b;
                        b.acquire();
                    }
                    this.f.put(str, workerWrapper);
                    b.startForegroundService(this.b, SystemForegroundDispatcher.e(this.b, workerWrapper.getWorkGenerationalId(), eVar));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public void l(m mVar, boolean z) {
        synchronized (this.l) {
            try {
                WorkerWrapper workerWrapper = (WorkerWrapper) this.g.get(mVar.b());
                if (workerWrapper != null && mVar.equals(workerWrapper.getWorkGenerationalId())) {
                    this.g.remove(mVar.b());
                }
                j.e().a(m, getClass().getSimpleName() + " " + mVar.b() + " executed; reschedule = " + z);
                Iterator it = this.k.iterator();
                while (it.hasNext()) {
                    ((e) it.next()).d(mVar, z);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void g(e eVar) {
        synchronized (this.l) {
            this.k.add(eVar);
        }
    }

    public u h(String str) {
        synchronized (this.l) {
            try {
                WorkerWrapper workerWrapper = (WorkerWrapper) this.f.get(str);
                if (workerWrapper == null) {
                    workerWrapper = (WorkerWrapper) this.g.get(str);
                }
                if (workerWrapper == null) {
                    return null;
                }
                return workerWrapper.getWorkSpec();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public boolean j(String str) {
        boolean contains;
        synchronized (this.l) {
            contains = this.j.contains(str);
        }
        return contains;
    }

    public boolean k(String str) {
        boolean z;
        synchronized (this.l) {
            try {
                z = this.g.containsKey(str) || this.f.containsKey(str);
            } finally {
            }
        }
        return z;
    }

    public void n(e eVar) {
        synchronized (this.l) {
            this.k.remove(eVar);
        }
    }

    public boolean p(u uVar) {
        return q(uVar, null);
    }

    public boolean q(u uVar, WorkerParameters.a aVar) {
        m a = uVar.a();
        String b = a.b();
        ArrayList arrayList = new ArrayList();
        u uVar2 = (u) this.e.Y(new p(this, arrayList, b));
        if (uVar2 == null) {
            j.e().k(m, "Didn't find WorkSpec for id " + a);
            o(a, false);
            return false;
        }
        synchronized (this.l) {
            try {
                if (k(b)) {
                    Set set = (Set) this.h.get(b);
                    if (((u) set.iterator().next()).a().a() == a.a()) {
                        set.add(uVar);
                        j.e().a(m, "Work " + a + " is already enqueued for processing");
                    } else {
                        o(a, false);
                    }
                    return false;
                }
                if (uVar2.f() != a.a()) {
                    o(a, false);
                    return false;
                }
                WorkerWrapper b2 = new WorkerWrapper.a(this.b, this.c, this.d, this, this.e, uVar2, arrayList).d(this.i).c(aVar).b();
                r future = b2.getFuture();
                future.addListener(new FutureListener(this, uVar.a(), future), this.d.a());
                this.g.put(b, b2);
                HashSet hashSet = new HashSet();
                hashSet.add(uVar);
                this.h.put(b, hashSet);
                this.d.b().execute(b2);
                j.e().a(m, getClass().getSimpleName() + ": processing " + a);
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public boolean r(String str) {
        WorkerWrapper workerWrapper;
        boolean z;
        synchronized (this.l) {
            try {
                j.e().a(m, "Processor cancelling " + str);
                this.j.add(str);
                workerWrapper = (WorkerWrapper) this.f.remove(str);
                z = workerWrapper != null;
                if (workerWrapper == null) {
                    workerWrapper = (WorkerWrapper) this.g.remove(str);
                }
                if (workerWrapper != null) {
                    this.h.remove(str);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        boolean i = i(str, workerWrapper);
        if (z) {
            s();
        }
        return i;
    }

    public boolean t(u uVar) {
        WorkerWrapper workerWrapper;
        String b = uVar.a().b();
        synchronized (this.l) {
            try {
                j.e().a(m, "Processor stopping foreground work " + b);
                workerWrapper = (WorkerWrapper) this.f.remove(b);
                if (workerWrapper != null) {
                    this.h.remove(b);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return i(b, workerWrapper);
    }

    public boolean u(u uVar) {
        String b = uVar.a().b();
        synchronized (this.l) {
            try {
                WorkerWrapper workerWrapper = (WorkerWrapper) this.g.remove(b);
                if (workerWrapper == null) {
                    j.e().a(m, "WorkerWrapper could not be found for " + b);
                    return false;
                }
                Set set = (Set) this.h.get(b);
                if (set != null && set.contains(uVar)) {
                    j.e().a(m, "Processor stopping background work " + b);
                    this.h.remove(b);
                    return i(b, workerWrapper);
                }
                return false;
            } finally {
            }
        }
    }
}
