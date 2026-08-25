package com.google.common.collect;

import java.util.Iterator;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
class Iterators$c extends o4 {
    final /* synthetic */ com.google.common.base.f b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    Iterators$c(Iterator it, com.google.common.base.f fVar) {
        super(it);
        this.b = fVar;
    }

    @Override // com.google.common.collect.o4
    Object a(Object obj) {
        return this.b.apply(obj);
    }
}
