package com.google.firebase.crashlytics.internal.common;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
class j {
    private static final FilenameFilter d = new FilenameFilter() { // from class: com.google.firebase.crashlytics.internal.common.h
        @Override // java.io.FilenameFilter
        public final boolean accept(File file, String str) {
            boolean d2;
            d2 = j.d(file, str);
            return d2;
        }
    };
    private static final Comparator e = new Comparator() { // from class: com.google.firebase.crashlytics.internal.common.i
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            int e2;
            e2 = j.e((File) obj, (File) obj2);
            return e2;
        }
    };
    private final xb.g a;
    private String b = null;
    private String c = null;

    j(xb.g gVar) {
        this.a = gVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean d(File file, String str) {
        return str.startsWith("aqs.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int e(File file, File file2) {
        return Long.compare(file2.lastModified(), file.lastModified());
    }

    private static void f(xb.g gVar, String str, String str2) {
        if (str == null || str2 == null) {
            return;
        }
        try {
            gVar.q(str, "aqs." + str2).createNewFile();
        } catch (IOException e2) {
            qb.g.f().l("Failed to persist App Quality Sessions session id.", e2);
        }
    }

    static String g(xb.g gVar, String str) {
        List r = gVar.r(str, d);
        if (!r.isEmpty()) {
            return ((File) Collections.min(r, e)).getName().substring(4);
        }
        qb.g.f().k("Unable to read App Quality Sessions session id.");
        return null;
    }

    public synchronized String c(String str) {
        if (Objects.equals(this.b, str)) {
            return this.c;
        }
        return g(this.a, str);
    }

    public synchronized void h(String str) {
        if (!Objects.equals(this.c, str)) {
            f(this.a, this.b, str);
            this.c = str;
        }
    }

    public synchronized void i(String str) {
        if (!Objects.equals(this.b, str)) {
            f(this.a, str, this.c);
            this.b = str;
        }
    }
}
