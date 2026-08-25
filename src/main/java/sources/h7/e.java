package h7;

import android.graphics.Color;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public final class e {
    public static final a e = new a(null);
    private final String a;
    private final int b;
    private final float c;
    private Function0 d;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final e a(String str, Function0 function0) {
            Intrinsics.h(str, "title");
            return new e(str, Color.parseColor("#FF007AFF"), 16.0f, function0);
        }
    }

    public e(String str, int i, float f, Function0 function0) {
        Intrinsics.h(str, "title");
        this.a = str;
        this.b = i;
        this.c = f;
        this.d = function0;
    }

    public final Function0 a() {
        return this.d;
    }

    public final int b() {
        return this.b;
    }

    public final float c() {
        return this.c;
    }

    public final String d() {
        return this.a;
    }

    public final void e(Function0 function0) {
        this.d = function0;
    }
}
