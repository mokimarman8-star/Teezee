package androidx.window.flow;

import android.graphics.Rect;
import androidx.window.core.b;
import androidx.window.layout.r;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u0000 *2\u00020\u0001:\u0002+,B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0096\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0015R\u001a\u0010\u0005\u001a\u00020\u00048\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0007\u001a\u00020\u00068\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001f\u001a\u00020\u001c8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u0014\u0010 \u001a\u00020\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b \u0010!R\u0014\u0010%\u001a\u00020\"8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b#\u0010$R\u0014\u0010)\u001a\u00020&8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b'\u0010(¨\u0006-"}, d2 = {"Landroidx/window/layout/HardwareFoldingFeature;", "Landroidx/window/layout/r;", "Landroidx/window/core/b;", "featureBounds", "Landroidx/window/layout/HardwareFoldingFeature$Type;", "type", "Landroidx/window/layout/r$c;", "state", "<init>", "(Landroidx/window/core/b;Landroidx/window/layout/HardwareFoldingFeature$Type;Landroidx/window/layout/r$c;)V", "", "toString", "()Ljava/lang/String;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "Landroidx/window/core/b;", "Landroidx/window/layout/HardwareFoldingFeature$Type;", "getType$window_release", "()Landroidx/window/layout/HardwareFoldingFeature$Type;", "Landroidx/window/layout/r$c;", "getState", "()Landroidx/window/layout/r$c;", "Landroid/graphics/Rect;", "getBounds", "()Landroid/graphics/Rect;", "bounds", "isSeparating", "()Z", "Landroidx/window/layout/r$a;", "getOcclusionType", "()Landroidx/window/layout/r$a;", "occlusionType", "Landroidx/window/layout/r$b;", "getOrientation", "()Landroidx/window/layout/r$b;", "orientation", "Companion", "a", "Type", "window_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public final class HardwareFoldingFeature implements r {
    public static final a Companion = new a((DefaultConstructorMarker) null);
    private final b featureBounds;
    private final r.c state;
    private final Type type;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0000\u0018\u0000 \t2\u00020\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\b¨\u0006\u000b"}, d2 = {"Landroidx/window/layout/HardwareFoldingFeature$Type;", "", "", "description", "<init>", "(Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "Ljava/lang/String;", "Companion", "a", "window_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Type {
        public static final a Companion = new a((DefaultConstructorMarker) null);
        private static final Type FOLD = new Type("FOLD");
        private static final Type HINGE = new Type("HINGE");
        private final String description;

        private Type(String str) {
            this.description = str;
        }

        /* renamed from: toString, reason: from getter */
        public String getDescription() {
            return this.description;
        }
    }

    public HardwareFoldingFeature(b bVar, Type type, r.c cVar) {
        Intrinsics.h(bVar, "featureBounds");
        Intrinsics.h(type, "type");
        Intrinsics.h(cVar, "state");
        this.featureBounds = bVar;
        this.type = type;
        this.state = cVar;
        Companion.a(bVar);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!Intrinsics.c(HardwareFoldingFeature.class, other == null ? null : other.getClass())) {
            return false;
        }
        if (other == null) {
            throw new NullPointerException("null cannot be cast to non-null type androidx.window.layout.HardwareFoldingFeature");
        }
        HardwareFoldingFeature hardwareFoldingFeature = (HardwareFoldingFeature) other;
        return Intrinsics.c(this.featureBounds, hardwareFoldingFeature.featureBounds) && Intrinsics.c(this.type, hardwareFoldingFeature.type) && Intrinsics.c(getState(), hardwareFoldingFeature.getState());
    }

    public Rect getBounds() {
        return this.featureBounds.f();
    }

    public r.a getOcclusionType() {
        return (this.featureBounds.d() == 0 || this.featureBounds.a() == 0) ? r.a.c : r.a.d;
    }

    public r.b getOrientation() {
        return this.featureBounds.d() > this.featureBounds.a() ? r.b.d : r.b.c;
    }

    public r.c getState() {
        return this.state;
    }

    /* renamed from: getType$window_release, reason: from getter */
    public final Type getType() {
        return this.type;
    }

    public int hashCode() {
        return (((this.featureBounds.hashCode() * 31) + this.type.hashCode()) * 31) + getState().hashCode();
    }

    public boolean isSeparating() {
        Type type = this.type;
        Type.a aVar = Type.Companion;
        if (Intrinsics.c(type, aVar.b())) {
            return true;
        }
        return Intrinsics.c(this.type, aVar.a()) && Intrinsics.c(getState(), r.c.d);
    }

    public String toString() {
        return ((Object) HardwareFoldingFeature.class.getSimpleName()) + " { " + this.featureBounds + ", type=" + this.type + ", state=" + getState() + " }";
    }
}
