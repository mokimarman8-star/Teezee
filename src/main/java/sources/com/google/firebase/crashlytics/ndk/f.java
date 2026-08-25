package com.google.firebase.crashlytics.ndk;

import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$a;
import java.io.File;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
final class f {
    public final c a;
    public final File b;
    public final File c;
    public final File d;
    public final File e;
    public final File f;
    public final File g;

    static final class b {
        private c a;
        private File b;
        private File c;
        private File d;
        private File e;
        private File f;
        private File g;

        b() {
        }

        b h(File file) {
            this.e = file;
            return this;
        }

        f i() {
            return new f(this);
        }

        b j(File file) {
            this.f = file;
            return this;
        }

        b k(File file) {
            this.c = file;
            return this;
        }

        b l(c cVar) {
            this.a = cVar;
            return this;
        }

        b m(File file) {
            this.g = file;
            return this;
        }

        b n(File file) {
            this.d = file;
            return this;
        }
    }

    static final class c {
        public final File a;
        public final CrashlyticsReport$a b;

        c(File file, CrashlyticsReport$a crashlyticsReport$a) {
            this.a = file;
            this.b = crashlyticsReport$a;
        }

        boolean a() {
            File file = this.a;
            return (file != null && file.exists()) || this.b != null;
        }
    }

    private f(b bVar) {
        this.a = bVar.a;
        this.b = bVar.b;
        this.c = bVar.c;
        this.d = bVar.d;
        this.e = bVar.e;
        this.f = bVar.f;
        this.g = bVar.g;
    }
}
