package io.reactivex.rxjava3.internal.operators.flowable;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public enum FlowableInternalHelper$RequestMax implements yx.f {
    INSTANCE;

    @Override // yx.f
    public void accept(i00.d dVar) {
        dVar.request(Long.MAX_VALUE);
    }
}
