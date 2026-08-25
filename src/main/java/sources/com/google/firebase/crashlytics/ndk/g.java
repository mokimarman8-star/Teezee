package com.google.firebase.crashlytics.ndk;

import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$a;
import com.google.firebase.crashlytics.ndk.f;
import java.io.File;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
class g implements qb.h {
    private final f a;

    g(f fVar) {
        this.a = fVar;
    }

    @Override // qb.h
    public File a() {
        return this.a.f;
    }

    @Override // qb.h
    public CrashlyticsReport$a b() {
        f.c cVar = this.a.a;
        if (cVar != null) {
            return cVar.b;
        }
        return null;
    }

    @Override // qb.h
    public File c() {
        return this.a.a.a;
    }

    @Override // qb.h
    public File d() {
        return this.a.c;
    }

    @Override // qb.h
    public File e() {
        return this.a.e;
    }

    @Override // qb.h
    public File f() {
        return this.a.g;
    }

    @Override // qb.h
    public File g() {
        return this.a.d;
    }
}
