package androidx.compose.ui.text.input;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class w implements j0 {

    /* renamed from: b, reason: collision with root package name */
    private final char f5276b;

    public w() {
        this((char) 0, 1, null);
    }

    public w(char c5) {
        this.f5276b = c5;
    }

    public /* synthetic */ w(char c5, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this((i5 & 1) != 0 ? (char) 8226 : c5);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof w) && this.f5276b == ((w) obj).f5276b;
    }

    public int hashCode() {
        return this.f5276b;
    }
}
