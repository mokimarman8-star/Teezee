package org.apache.tools.ant.taskdefs;

import java.net.URL;
import java.util.Enumeration;
import java.util.NoSuchElementException;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
class d implements Enumeration {
    private boolean a = true;
    private final /* synthetic */ URL b;
    private final /* synthetic */ e c;

    d(e eVar, URL url) {
        this.c = eVar;
        this.b = url;
    }

    @Override // java.util.Enumeration
    public boolean hasMoreElements() {
        return this.a;
    }

    @Override // java.util.Enumeration
    public Object nextElement() {
        if (!this.a) {
            throw new NoSuchElementException();
        }
        this.a = false;
        return this.b;
    }
}
