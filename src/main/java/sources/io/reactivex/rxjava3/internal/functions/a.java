package io.reactivex.rxjava3.internal.functions;

import java.util.Objects;
import yx.d;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public abstract class a {
    static final d a = new C0066a();

    /* renamed from: io.reactivex.rxjava3.internal.functions.a$a, reason: collision with other inner class name */
    static final class C0066a implements d {
        C0066a() {
        }

        @Override // yx.d
        public boolean a(Object obj, Object obj2) {
            return Objects.equals(obj, obj2);
        }
    }

    public static int a(int i, String str) {
        if (i > 0) {
            return i;
        }
        throw new IllegalArgumentException(str + " > 0 required but it was " + i);
    }
}
