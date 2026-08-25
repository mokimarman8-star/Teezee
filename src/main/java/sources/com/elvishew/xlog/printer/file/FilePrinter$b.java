package com.elvishew.xlog.printer.file;

import h8.a;
import j8.b;
import t7.c;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public class FilePrinter$b {
    String a;
    b b;
    a c;
    i8.a d;
    c e;
    k8.b f;

    public FilePrinter$b(String str) {
        this.a = str;
    }

    private void e() {
        if (this.b == null) {
            this.b = d8.a.e();
        }
        if (this.c == null) {
            this.c = d8.a.b();
        }
        if (this.d == null) {
            this.d = d8.a.d();
        }
        if (this.e == null) {
            this.e = d8.a.g();
        }
        if (this.f == null) {
            this.f = d8.a.m();
        }
    }

    public FilePrinter$b a(h8.b bVar) {
        if (!(bVar instanceof a)) {
            bVar = new e8.a(bVar);
        }
        a aVar = (a) bVar;
        this.c = aVar;
        e8.b.b(aVar);
        return this;
    }

    public FilePrinter b() {
        e();
        return new FilePrinter(this);
    }

    public FilePrinter$b c(i8.a aVar) {
        this.d = aVar;
        return this;
    }

    public FilePrinter$b d(b bVar) {
        this.b = bVar;
        return this;
    }

    public FilePrinter$b f(c cVar) {
        this.e = cVar;
        return this;
    }
}
