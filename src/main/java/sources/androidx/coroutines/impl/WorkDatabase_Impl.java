package androidx.coroutines.impl;

import androidx.room.InvalidationTracker;
import androidx.room.h0;
import j4.a0;
import j4.b;
import j4.c;
import j4.e;
import j4.f;
import j4.g;
import j4.h;
import j4.j;
import j4.k;
import j4.o;
import j4.p;
import j4.r;
import j4.s;
import j4.v;
import j4.w;
import j4.z;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import z3.e;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public final class WorkDatabase_Impl extends WorkDatabase {
    private volatile v q;
    private volatile b r;
    private volatile z s;
    private volatile j t;
    private volatile o u;
    private volatile r v;
    private volatile e w;
    private volatile g x;

    @Override // androidx.room.RoomDatabase
    public Set C() {
        return new HashSet();
    }

    @Override // androidx.room.RoomDatabase
    protected Map F() {
        HashMap hashMap = new HashMap();
        hashMap.put(v.class, w.J());
        hashMap.put(b.class, c.e());
        hashMap.put(z.class, a0.e());
        hashMap.put(j.class, k.h());
        hashMap.put(o.class, p.c());
        hashMap.put(r.class, s.d());
        hashMap.put(e.class, f.b());
        hashMap.put(g.class, h.d());
        return hashMap;
    }

    @Override // androidx.coroutines.impl.WorkDatabase
    public b h0() {
        b bVar;
        if (this.r != null) {
            return this.r;
        }
        synchronized (this) {
            try {
                if (this.r == null) {
                    this.r = new c(this);
                }
                bVar = this.r;
            } catch (Throwable th) {
                throw th;
            }
        }
        return bVar;
    }

    @Override // androidx.coroutines.impl.WorkDatabase
    public e i0() {
        e eVar;
        if (this.w != null) {
            return this.w;
        }
        synchronized (this) {
            try {
                if (this.w == null) {
                    this.w = new f(this);
                }
                eVar = this.w;
            } catch (Throwable th) {
                throw th;
            }
        }
        return eVar;
    }

    @Override // androidx.coroutines.impl.WorkDatabase
    public g j0() {
        g gVar;
        if (this.x != null) {
            return this.x;
        }
        synchronized (this) {
            try {
                if (this.x == null) {
                    this.x = new h(this);
                }
                gVar = this.x;
            } catch (Throwable th) {
                throw th;
            }
        }
        return gVar;
    }

    @Override // androidx.coroutines.impl.WorkDatabase
    public j k0() {
        j jVar;
        if (this.t != null) {
            return this.t;
        }
        synchronized (this) {
            try {
                if (this.t == null) {
                    this.t = new k(this);
                }
                jVar = this.t;
            } catch (Throwable th) {
                throw th;
            }
        }
        return jVar;
    }

    @Override // androidx.coroutines.impl.WorkDatabase
    public o l0() {
        o oVar;
        if (this.u != null) {
            return this.u;
        }
        synchronized (this) {
            try {
                if (this.u == null) {
                    this.u = new p(this);
                }
                oVar = this.u;
            } catch (Throwable th) {
                throw th;
            }
        }
        return oVar;
    }

    @Override // androidx.coroutines.impl.WorkDatabase
    public r m0() {
        r rVar;
        if (this.v != null) {
            return this.v;
        }
        synchronized (this) {
            try {
                if (this.v == null) {
                    this.v = new s(this);
                }
                rVar = this.v;
            } catch (Throwable th) {
                throw th;
            }
        }
        return rVar;
    }

    @Override // androidx.coroutines.impl.WorkDatabase
    public v n0() {
        v vVar;
        if (this.q != null) {
            return this.q;
        }
        synchronized (this) {
            try {
                if (this.q == null) {
                    this.q = new w(this);
                }
                vVar = this.q;
            } catch (Throwable th) {
                throw th;
            }
        }
        return vVar;
    }

    @Override // androidx.coroutines.impl.WorkDatabase
    public z o0() {
        z zVar;
        if (this.s != null) {
            return this.s;
        }
        synchronized (this) {
            try {
                if (this.s == null) {
                    this.s = new a0(this);
                }
                zVar = this.s;
            } catch (Throwable th) {
                throw th;
            }
        }
        return zVar;
    }

    @Override // androidx.room.RoomDatabase
    protected InvalidationTracker q() {
        return new InvalidationTracker(this, new HashMap(0), new HashMap(0), "Dependency", "WorkSpec", "WorkTag", "SystemIdInfo", "WorkName", "WorkProgress", "Preference");
    }

    @Override // androidx.room.RoomDatabase
    protected z3.e s(androidx.room.c cVar) {
        return cVar.c.a(e.b.a(cVar.a).d(cVar.b).c(new h0(cVar, new a(this, 16), "5181942b9ebc31ce68dacb56c16fd79f", "ae2044fb577e65ee8bb576ca48a2f06e")).b());
    }

    @Override // androidx.room.RoomDatabase
    public List v(Map map) {
        return Arrays.asList(new b0(), new c0());
    }
}
