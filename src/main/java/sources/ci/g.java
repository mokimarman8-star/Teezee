package ci;

import android.view.View;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class g implements View.OnClickListener {
    public static final a c = new a(null);
    private final long a;
    private final Function1 b;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public g(long j, Function1 function1) {
        Intrinsics.h(function1, "onDebounceClick");
        this.a = j;
        this.b = function1;
    }

    public /* synthetic */ g(long j, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 1000L : j, function1);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            Object tag = view.getTag(-1001);
            Long l = tag instanceof Long ? (Long) tag : null;
            long longValue = l != null ? l.longValue() : 0L;
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - longValue > this.a) {
                view.setTag(-1001, Long.valueOf(currentTimeMillis));
                this.b.invoke(view);
            }
        }
    }
}
