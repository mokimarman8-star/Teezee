package com.google.common.collect;

/* JADX INFO: Access modifiers changed from: private */
/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public final class Iterators$d extends a {
    static final s4 d = new Iterators$d(new Object[0], 0);
    private final Object[] c;

    Iterators$d(Object[] objArr, int i) {
        super(objArr.length, i);
        this.c = objArr;
    }

    @Override // com.google.common.collect.a
    protected Object a(int i) {
        return this.c[i];
    }
}
