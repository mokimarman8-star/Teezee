package d0;

import android.view.KeyEvent;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    private final KeyEvent f14889a;

    private /* synthetic */ b(KeyEvent keyEvent) {
        this.f14889a = keyEvent;
    }

    public static final /* synthetic */ b a(KeyEvent keyEvent) {
        return new b(keyEvent);
    }

    public static KeyEvent b(KeyEvent keyEvent) {
        return keyEvent;
    }

    public static boolean c(KeyEvent keyEvent, Object obj) {
        return (obj instanceof b) && Intrinsics.c(keyEvent, ((b) obj).f());
    }

    public static int d(KeyEvent keyEvent) {
        return keyEvent.hashCode();
    }

    public static String e(KeyEvent keyEvent) {
        return "KeyEvent(nativeKeyEvent=" + keyEvent + ')';
    }

    public boolean equals(Object obj) {
        return c(this.f14889a, obj);
    }

    public final /* synthetic */ KeyEvent f() {
        return this.f14889a;
    }

    public int hashCode() {
        return d(this.f14889a);
    }

    public String toString() {
        return e(this.f14889a);
    }
}
