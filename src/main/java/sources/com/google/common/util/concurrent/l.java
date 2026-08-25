package com.google.common.util.concurrent;

import java.util.concurrent.Executor;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public abstract class l extends k implements r {

    public static abstract class a extends l {
        private final r a;

        protected a(r rVar) {
            this.a = (r) com.google.common.base.m.o(rVar);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.util.concurrent.k
        /* renamed from: m, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
        public final r l() {
            return this.a;
        }
    }

    protected l() {
    }

    @Override // com.google.common.util.concurrent.r
    public void addListener(Runnable runnable, Executor executor) {
        delegate().addListener(runnable, executor);
    }

    /* renamed from: m */
    protected abstract r delegate();
}
