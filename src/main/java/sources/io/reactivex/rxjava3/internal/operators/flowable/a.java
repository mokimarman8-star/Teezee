package io.reactivex.rxjava3.internal.operators.flowable;

import java.util.Objects;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
abstract class a extends io.reactivex.rxjava3.core.e {
    protected final io.reactivex.rxjava3.core.e b;

    a(io.reactivex.rxjava3.core.e eVar) {
        Objects.requireNonNull(eVar, "source is null");
        this.b = eVar;
    }
}
