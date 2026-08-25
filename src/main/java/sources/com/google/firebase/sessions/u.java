package com.google.firebase.sessions;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public final class u {
    private final EventType a;
    private final x b;
    private final b c;

    public u(EventType eventType, x xVar, b bVar) {
        Intrinsics.h(eventType, "eventType");
        Intrinsics.h(xVar, "sessionData");
        Intrinsics.h(bVar, "applicationInfo");
        this.a = eventType;
        this.b = xVar;
        this.c = bVar;
    }

    public final b a() {
        return this.c;
    }

    public final EventType b() {
        return this.a;
    }

    public final x c() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof u)) {
            return false;
        }
        u uVar = (u) obj;
        return this.a == uVar.a && Intrinsics.c(this.b, uVar.b) && Intrinsics.c(this.c, uVar.c);
    }

    public int hashCode() {
        return (((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
    }

    public String toString() {
        return "SessionEvent(eventType=" + this.a + ", sessionData=" + this.b + ", applicationInfo=" + this.c + ')';
    }
}
