package androidx.compose.foundation.lazy.layout;

import androidx.compose.foundation.lazy.layout.b;
import kotlin.jvm.functions.Function1;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class j {

    public interface a {
        Function1 getKey();

        Function1 getType();
    }

    public final Object b(int i5) {
        b.a aVar = c().get(i5);
        return ((a) aVar.c()).getType().invoke(Integer.valueOf(i5 - aVar.b()));
    }

    public abstract b c();

    public final int d() {
        return c().getSize();
    }

    public final Object e(int i5) {
        Object invoke;
        b.a aVar = c().get(i5);
        int b5 = i5 - aVar.b();
        Function1 key = ((a) aVar.c()).getKey();
        return (key == null || (invoke = key.invoke(Integer.valueOf(b5))) == null) ? b0.a(i5) : invoke;
    }
}
