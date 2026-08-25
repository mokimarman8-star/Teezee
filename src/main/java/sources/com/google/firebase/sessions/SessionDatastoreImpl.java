package com.google.firebase.sessions;

import android.content.Context;
import android.util.Log;
import androidx.datastore.core.CorruptionException;
import androidx.datastore.preferences.PreferenceDataStoreDelegateKt;
import androidx.datastore.preferences.core.c;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference2Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.o0;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public final class SessionDatastoreImpl implements s {
    private static final a f = new a(null);
    private static final ReadOnlyProperty g = PreferenceDataStoreDelegateKt.b(r.a.a(), new j1.b(new Function1<CorruptionException, androidx.datastore.preferences.core.c>() { // from class: com.google.firebase.sessions.SessionDatastoreImpl$Companion$dataStore$2
        public final androidx.datastore.preferences.core.c invoke(CorruptionException corruptionException) {
            Intrinsics.h(corruptionException, "ex");
            Log.w("FirebaseSessionsRepo", "CorruptionException in sessions DataStore in " + q.a.e() + '.', corruptionException);
            return androidx.datastore.preferences.core.d.a();
        }
    }), (Function1) null, (n0) null, 12, (Object) null);
    private final Context b;
    private final CoroutineContext c;
    private final AtomicReference d;
    private final kotlinx.coroutines.flow.a e;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", TtmlNode.ANONYMOUS_REGION_ID, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {1, 8, 0})
    @DebugMetadata(c = "com.google.firebase.sessions.SessionDatastoreImpl$1", f = "SessionDatastore.kt", l = {82}, m = "invokeSuspend")
    /* renamed from: com.google.firebase.sessions.SessionDatastoreImpl$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
        int label;

        /* renamed from: com.google.firebase.sessions.SessionDatastoreImpl$1$a */
        static final class a implements kotlinx.coroutines.flow.b {
            final /* synthetic */ SessionDatastoreImpl a;

            a(SessionDatastoreImpl sessionDatastoreImpl) {
                this.a = sessionDatastoreImpl;
            }

            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Object emit(i iVar, Continuation continuation) {
                this.a.d.set(iVar);
                return Unit.a;
            }
        }

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return SessionDatastoreImpl.this.new AnonymousClass1(continuation);
        }

        public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
            return create(n0Var, continuation).invokeSuspend(Unit.a);
        }

        public final Object invokeSuspend(Object obj) {
            Object f = IntrinsicsKt.f();
            int i = this.label;
            if (i == 0) {
                ResultKt.b(obj);
                kotlinx.coroutines.flow.a aVar = SessionDatastoreImpl.this.e;
                a aVar2 = new a(SessionDatastoreImpl.this);
                this.label = 1;
                if (aVar.a(aVar2, this) == f) {
                    return f;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            }
            return Unit.a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static final class a {
        static final /* synthetic */ KProperty[] a = {Reflection.j(new PropertyReference2Impl(a.class, "dataStore", "getDataStore(Landroid/content/Context;)Landroidx/datastore/core/DataStore;", 0))};

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final androidx.datastore.core.g b(Context context) {
            return (androidx.datastore.core.g) SessionDatastoreImpl.g.a(context, a[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static final class b {
        public static final b a = new b();
        private static final c.a b = androidx.datastore.preferences.core.f.g("session_id");

        private b() {
        }

        public final c.a a() {
            return b;
        }
    }

    public SessionDatastoreImpl(Context context, CoroutineContext coroutineContext) {
        Intrinsics.h(context, "context");
        Intrinsics.h(coroutineContext, "backgroundDispatcher");
        this.b = context;
        this.c = coroutineContext;
        this.d = new AtomicReference();
        final kotlinx.coroutines.flow.a e = kotlinx.coroutines.flow.c.e(f.b(context).getData(), new SessionDatastoreImpl$firebaseSessionDataFlow$1(null));
        this.e = new kotlinx.coroutines.flow.a() { // from class: com.google.firebase.sessions.SessionDatastoreImpl$special$$inlined$map$1

            /* renamed from: com.google.firebase.sessions.SessionDatastoreImpl$special$$inlined$map$1$2, reason: invalid class name */
            public static final class AnonymousClass2 implements kotlinx.coroutines.flow.b {
                final /* synthetic */ kotlinx.coroutines.flow.b a;
                final /* synthetic */ SessionDatastoreImpl b;

                @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
                @DebugMetadata(c = "com.google.firebase.sessions.SessionDatastoreImpl$special$$inlined$map$1$2", f = "SessionDatastore.kt", l = {223}, m = "emit")
                @SourceDebugExtension
                /* renamed from: com.google.firebase.sessions.SessionDatastoreImpl$special$$inlined$map$1$2$1, reason: invalid class name */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    Object L$0;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(kotlinx.coroutines.flow.b bVar, SessionDatastoreImpl sessionDatastoreImpl) {
                    this.a = bVar;
                    this.b = sessionDatastoreImpl;
                }

                /* JADX WARN: Removed duplicated region for block: B:15:0x0031  */
                /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final Object emit(Object obj, Continuation continuation) {
                    AnonymousClass1 anonymousClass1;
                    int i;
                    i i2;
                    if (continuation instanceof AnonymousClass1) {
                        anonymousClass1 = (AnonymousClass1) continuation;
                        int i3 = anonymousClass1.label;
                        if ((i3 & Integer.MIN_VALUE) != 0) {
                            anonymousClass1.label = i3 - Integer.MIN_VALUE;
                            Object obj2 = anonymousClass1.result;
                            Object f = IntrinsicsKt.f();
                            i = anonymousClass1.label;
                            if (i != 0) {
                                ResultKt.b(obj2);
                                kotlinx.coroutines.flow.b bVar = this.a;
                                i2 = this.b.i((androidx.datastore.preferences.core.c) obj);
                                anonymousClass1.label = 1;
                                if (bVar.emit(i2, anonymousClass1) == f) {
                                    return f;
                                }
                            } else {
                                if (i != 1) {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                ResultKt.b(obj2);
                            }
                            return Unit.a;
                        }
                    }
                    anonymousClass1 = new AnonymousClass1(continuation);
                    Object obj22 = anonymousClass1.result;
                    Object f2 = IntrinsicsKt.f();
                    i = anonymousClass1.label;
                    if (i != 0) {
                    }
                    return Unit.a;
                }
            }

            public Object a(kotlinx.coroutines.flow.b bVar, Continuation continuation) {
                Object a2 = e.a(new AnonymousClass2(bVar, this), continuation);
                return a2 == IntrinsicsKt.f() ? a2 : Unit.a;
            }
        };
        kotlinx.coroutines.i.d(o0.a(coroutineContext), (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1(null), 3, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final i i(androidx.datastore.preferences.core.c cVar) {
        return new i((String) cVar.b(b.a.a()));
    }

    @Override // com.google.firebase.sessions.s
    public String a() {
        i iVar = (i) this.d.get();
        if (iVar != null) {
            return iVar.a();
        }
        return null;
    }

    @Override // com.google.firebase.sessions.s
    public void b(String str) {
        Intrinsics.h(str, "sessionId");
        kotlinx.coroutines.i.d(o0.a(this.c), (CoroutineContext) null, (CoroutineStart) null, new SessionDatastoreImpl$updateSessionId$1(this, str, null), 3, (Object) null);
    }
}
