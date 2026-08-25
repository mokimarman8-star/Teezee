package com.google.firebase.crashlytics.internal.common;

import java.io.File;
import java.io.IOException;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
class y {
    private final String a;
    private final xb.g b;

    public y(String str, xb.g gVar) {
        this.a = str;
        this.b = gVar;
    }

    private File b() {
        return this.b.g(this.a);
    }

    public boolean a() {
        try {
            return b().createNewFile();
        } catch (IOException e) {
            qb.g.f().e("Error creating marker: " + this.a, e);
            return false;
        }
    }

    public boolean c() {
        return b().exists();
    }

    public boolean d() {
        return b().delete();
    }
}
