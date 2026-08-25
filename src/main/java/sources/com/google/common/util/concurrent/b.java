package com.google.common.util.concurrent;

import com.google.common.util.concurrent.ListenerCallQueue;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public abstract class b {
    private static final ListenerCallQueue.a a = new a();
    private static final ListenerCallQueue.a b = new C0018b();
    private static final ListenerCallQueue.a c;
    private static final ListenerCallQueue.a d;
    private static final ListenerCallQueue.a e;
    private static final ListenerCallQueue.a f;
    private static final ListenerCallQueue.a g;
    private static final ListenerCallQueue.a h;

    class a implements ListenerCallQueue.a {
        a() {
        }

        @Override // com.google.common.util.concurrent.ListenerCallQueue.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void call(x xVar) {
            xVar.b();
        }

        public String toString() {
            return "starting()";
        }
    }

    /* renamed from: com.google.common.util.concurrent.b$b, reason: collision with other inner class name */
    class C0018b implements ListenerCallQueue.a {
        C0018b() {
        }

        @Override // com.google.common.util.concurrent.ListenerCallQueue.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void call(x xVar) {
            xVar.a();
        }

        public String toString() {
            return "running()";
        }
    }

    class c implements ListenerCallQueue.a {
        final /* synthetic */ Service$State a;

        c(Service$State service$State) {
            this.a = service$State;
        }

        @Override // com.google.common.util.concurrent.ListenerCallQueue.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void call(x xVar) {
            xVar.d(this.a);
        }

        public String toString() {
            return "terminated({from = " + this.a + "})";
        }
    }

    class d implements ListenerCallQueue.a {
        final /* synthetic */ Service$State a;

        d(Service$State service$State) {
            this.a = service$State;
        }

        @Override // com.google.common.util.concurrent.ListenerCallQueue.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void call(x xVar) {
            xVar.c(this.a);
        }

        public String toString() {
            return "stopping({from = " + this.a + "})";
        }
    }

    static {
        Service$State service$State = Service$State.STARTING;
        c = a(service$State);
        Service$State service$State2 = Service$State.RUNNING;
        d = a(service$State2);
        e = b(Service$State.NEW);
        f = b(service$State);
        g = b(service$State2);
        h = b(Service$State.STOPPING);
    }

    private static ListenerCallQueue.a a(Service$State service$State) {
        return new d(service$State);
    }

    private static ListenerCallQueue.a b(Service$State service$State) {
        return new c(service$State);
    }
}
