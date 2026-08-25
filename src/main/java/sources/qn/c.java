package qn;

import com.google.common.collect.ImmutableList;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class c {
    private final ImmutableList a;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public c() {
        this(r0, 1, r0);
        ImmutableList immutableList = null;
    }

    public c(ImmutableList immutableList) {
        Intrinsics.h(immutableList, "groups");
        this.a = immutableList;
    }

    public /* synthetic */ c(ImmutableList immutableList, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? ImmutableList.of() : immutableList);
    }

    public final ImmutableList a() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof c) && Intrinsics.c(this.a, ((c) obj).a);
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public String toString() {
        return "TnTracks(groups=" + this.a + ")";
    }
}
