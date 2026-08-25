package com.google.firebase.sessions;

import android.util.Log;
import com.google.firebase.sessions.settings.SessionsSettings;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.o0;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public final class SessionFirelogPublisherImpl implements w {
    public static final a g = new a(null);
    private static final double h = Math.random();
    private final com.google.firebase.f b;
    private final lc.e c;
    private final SessionsSettings d;
    private final g e;
    private final CoroutineContext f;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public SessionFirelogPublisherImpl(com.google.firebase.f fVar, lc.e eVar, SessionsSettings sessionsSettings, g gVar, CoroutineContext coroutineContext) {
        Intrinsics.h(fVar, "firebaseApp");
        Intrinsics.h(eVar, "firebaseInstallations");
        Intrinsics.h(sessionsSettings, "sessionSettings");
        Intrinsics.h(gVar, "eventGDTLogger");
        Intrinsics.h(coroutineContext, "backgroundDispatcher");
        this.b = fVar;
        this.c = eVar;
        this.d = sessionsSettings;
        this.e = gVar;
        this.f = coroutineContext;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g(u uVar) {
        try {
            this.e.a(uVar);
        } catch (RuntimeException e) {
            Log.e("SessionFirelogPublisher", "Error logging Session Start event to DataTransport: ", e);
        }
    }

    private final boolean h() {
        return h <= this.d.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object i(Continuation continuation) {
        SessionFirelogPublisherImpl$shouldLogSession$1 sessionFirelogPublisherImpl$shouldLogSession$1;
        int i;
        SessionFirelogPublisherImpl sessionFirelogPublisherImpl;
        if (continuation instanceof SessionFirelogPublisherImpl$shouldLogSession$1) {
            sessionFirelogPublisherImpl$shouldLogSession$1 = (SessionFirelogPublisherImpl$shouldLogSession$1) continuation;
            int i2 = sessionFirelogPublisherImpl$shouldLogSession$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                sessionFirelogPublisherImpl$shouldLogSession$1.label = i2 - Integer.MIN_VALUE;
                Object obj = sessionFirelogPublisherImpl$shouldLogSession$1.result;
                Object f = IntrinsicsKt.f();
                i = sessionFirelogPublisherImpl$shouldLogSession$1.label;
                if (i != 0) {
                    ResultKt.b(obj);
                    SessionsSettings sessionsSettings = this.d;
                    sessionFirelogPublisherImpl$shouldLogSession$1.L$0 = this;
                    sessionFirelogPublisherImpl$shouldLogSession$1.label = 1;
                    if (sessionsSettings.g(sessionFirelogPublisherImpl$shouldLogSession$1) == f) {
                        return f;
                    }
                    sessionFirelogPublisherImpl = this;
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    sessionFirelogPublisherImpl = (SessionFirelogPublisherImpl) sessionFirelogPublisherImpl$shouldLogSession$1.L$0;
                    ResultKt.b(obj);
                }
                if (!sessionFirelogPublisherImpl.d.d() && sessionFirelogPublisherImpl.h()) {
                }
                return Boxing.a(false);
            }
        }
        sessionFirelogPublisherImpl$shouldLogSession$1 = new SessionFirelogPublisherImpl$shouldLogSession$1(this, continuation);
        Object obj2 = sessionFirelogPublisherImpl$shouldLogSession$1.result;
        Object f2 = IntrinsicsKt.f();
        i = sessionFirelogPublisherImpl$shouldLogSession$1.label;
        if (i != 0) {
        }
        return !sessionFirelogPublisherImpl.d.d() ? Boxing.a(false) : Boxing.a(true);
    }

    @Override // com.google.firebase.sessions.w
    public void a(t tVar) {
        Intrinsics.h(tVar, "sessionDetails");
        kotlinx.coroutines.i.d(o0.a(this.f), (CoroutineContext) null, (CoroutineStart) null, new SessionFirelogPublisherImpl$logSession$1(this, tVar, null), 3, (Object) null);
    }
}
