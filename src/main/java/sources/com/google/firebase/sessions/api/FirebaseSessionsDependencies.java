package com.google.firebase.sessions.api;

import com.google.firebase.sessions.api.SessionSubscriber;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.ResultKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.sync.a;
import kotlinx.coroutines.sync.g;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public final class FirebaseSessionsDependencies {
    public static final FirebaseSessionsDependencies a = new FirebaseSessionsDependencies();
    private static final Map b = Collections.synchronizedMap(new LinkedHashMap());

    private static final class a {
        private final kotlinx.coroutines.sync.a a;
        private SessionSubscriber b;

        public a(kotlinx.coroutines.sync.a aVar, SessionSubscriber sessionSubscriber) {
            Intrinsics.h(aVar, "mutex");
            this.a = aVar;
            this.b = sessionSubscriber;
        }

        public /* synthetic */ a(kotlinx.coroutines.sync.a aVar, SessionSubscriber sessionSubscriber, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(aVar, (i & 2) != 0 ? null : sessionSubscriber);
        }

        public final kotlinx.coroutines.sync.a a() {
            return this.a;
        }

        public final SessionSubscriber b() {
            return this.b;
        }

        public final void c(SessionSubscriber sessionSubscriber) {
            this.b = sessionSubscriber;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return Intrinsics.c(this.a, aVar.a) && Intrinsics.c(this.b, aVar.b);
        }

        public int hashCode() {
            int hashCode = this.a.hashCode() * 31;
            SessionSubscriber sessionSubscriber = this.b;
            return hashCode + (sessionSubscriber == null ? 0 : sessionSubscriber.hashCode());
        }

        public String toString() {
            return "Dependency(mutex=" + this.a + ", subscriber=" + this.b + ')';
        }
    }

    private FirebaseSessionsDependencies() {
    }

    public static final void a(SessionSubscriber.Name name) {
        Intrinsics.h(name, "subscriberName");
        if (name == SessionSubscriber.Name.PERFORMANCE) {
            throw new IllegalArgumentException("Incompatible versions of Firebase Perf and Firebase Sessions.\nA safe combination would be:\n  firebase-sessions:1.1.0\n  firebase-crashlytics:18.5.0\n  firebase-perf:20.5.0\nFor more information contact Firebase Support.");
        }
        Map map = b;
        if (map.containsKey(name)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Dependency ");
            sb2.append(name);
            sb2.append(" already added.");
            return;
        }
        Intrinsics.g(map, "dependencies");
        SessionSubscriber sessionSubscriber = null;
        map.put(name, new a(g.a(true), sessionSubscriber, 2, sessionSubscriber));
        StringBuilder sb3 = new StringBuilder();
        sb3.append("Dependency to ");
        sb3.append(name);
        sb3.append(" added.");
    }

    private final a b(SessionSubscriber.Name name) {
        Map map = b;
        Intrinsics.g(map, "dependencies");
        Object obj = map.get(name);
        if (obj != null) {
            Intrinsics.g(obj, "dependencies.getOrElse(s…load time.\"\n      )\n    }");
            return (a) obj;
        }
        throw new IllegalStateException("Cannot get dependency " + name + ". Dependencies should be added at class load time.");
    }

    public static final void e(SessionSubscriber sessionSubscriber) {
        Intrinsics.h(sessionSubscriber, "subscriber");
        SessionSubscriber.Name b2 = sessionSubscriber.b();
        a b3 = a.b(b2);
        if (b3.b() != null) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Subscriber ");
            sb2.append(b2);
            sb2.append(" already registered.");
            return;
        }
        b3.c(sessionSubscriber);
        StringBuilder sb3 = new StringBuilder();
        sb3.append("Subscriber ");
        sb3.append(b2);
        sb3.append(" registered.");
        a.a.c(b3.a(), (Object) null, 1, (Object) null);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00b5 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x00a1 -> B:10:0x00a2). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object c(Continuation continuation) {
        FirebaseSessionsDependencies$getRegisteredSubscribers$1 firebaseSessionsDependencies$getRegisteredSubscribers$1;
        int i;
        Iterator it;
        Map map;
        if (continuation instanceof FirebaseSessionsDependencies$getRegisteredSubscribers$1) {
            firebaseSessionsDependencies$getRegisteredSubscribers$1 = (FirebaseSessionsDependencies$getRegisteredSubscribers$1) continuation;
            int i2 = firebaseSessionsDependencies$getRegisteredSubscribers$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                firebaseSessionsDependencies$getRegisteredSubscribers$1.label = i2 - Integer.MIN_VALUE;
                Object obj = firebaseSessionsDependencies$getRegisteredSubscribers$1.result;
                Object f = IntrinsicsKt.f();
                i = firebaseSessionsDependencies$getRegisteredSubscribers$1.label;
                if (i != 0) {
                    ResultKt.b(obj);
                    Map map2 = b;
                    Intrinsics.g(map2, "dependencies");
                    LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt.e(map2.size()));
                    it = map2.entrySet().iterator();
                    map = linkedHashMap;
                    if (it.hasNext()) {
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    Object key = firebaseSessionsDependencies$getRegisteredSubscribers$1.L$5;
                    map = (Map) firebaseSessionsDependencies$getRegisteredSubscribers$1.L$4;
                    kotlinx.coroutines.sync.a a2 = (kotlinx.coroutines.sync.a) firebaseSessionsDependencies$getRegisteredSubscribers$1.L$3;
                    SessionSubscriber.Name name = (SessionSubscriber.Name) firebaseSessionsDependencies$getRegisteredSubscribers$1.L$2;
                    it = (Iterator) firebaseSessionsDependencies$getRegisteredSubscribers$1.L$1;
                    Map map3 = (Map) firebaseSessionsDependencies$getRegisteredSubscribers$1.L$0;
                    ResultKt.b(obj);
                    try {
                        SessionSubscriber d = a.d(name);
                        a2.unlock((Object) null);
                        map.put(key, d);
                        map = map3;
                        if (it.hasNext()) {
                            Map.Entry entry = (Map.Entry) it.next();
                            key = entry.getKey();
                            name = (SessionSubscriber.Name) entry.getKey();
                            a2 = ((a) entry.getValue()).a();
                            firebaseSessionsDependencies$getRegisteredSubscribers$1.L$0 = map;
                            firebaseSessionsDependencies$getRegisteredSubscribers$1.L$1 = it;
                            firebaseSessionsDependencies$getRegisteredSubscribers$1.L$2 = name;
                            firebaseSessionsDependencies$getRegisteredSubscribers$1.L$3 = a2;
                            firebaseSessionsDependencies$getRegisteredSubscribers$1.L$4 = map;
                            firebaseSessionsDependencies$getRegisteredSubscribers$1.L$5 = key;
                            firebaseSessionsDependencies$getRegisteredSubscribers$1.label = 1;
                            if (a2.f((Object) null, firebaseSessionsDependencies$getRegisteredSubscribers$1) == f) {
                                return f;
                            }
                            map3 = map;
                            SessionSubscriber d2 = a.d(name);
                            a2.unlock((Object) null);
                            map.put(key, d2);
                            map = map3;
                            if (it.hasNext()) {
                                return map;
                            }
                        }
                    } catch (Throwable th) {
                        a2.unlock((Object) null);
                        throw th;
                    }
                }
            }
        }
        firebaseSessionsDependencies$getRegisteredSubscribers$1 = new FirebaseSessionsDependencies$getRegisteredSubscribers$1(this, continuation);
        Object obj2 = firebaseSessionsDependencies$getRegisteredSubscribers$1.result;
        Object f2 = IntrinsicsKt.f();
        i = firebaseSessionsDependencies$getRegisteredSubscribers$1.label;
        if (i != 0) {
        }
    }

    public final SessionSubscriber d(SessionSubscriber.Name name) {
        Intrinsics.h(name, "subscriberName");
        SessionSubscriber b2 = b(name).b();
        if (b2 != null) {
            return b2;
        }
        throw new IllegalStateException("Subscriber " + name + " has not been registered.");
    }
}
