package h7;

import android.graphics.Color;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public final class f {
    public static final a d = new a(null);
    private final String a;
    private final int b;
    private final float c;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final f a(String str) {
            Intrinsics.h(str, "title");
            return new f(str, Color.parseColor("#92969E"), 14.0f);
        }

        public final f b(String str) {
            Intrinsics.h(str, "title");
            return new f(str, Color.parseColor("#191F2B"), 16.0f);
        }
    }

    public f(String str, int i, float f) {
        Intrinsics.h(str, "text");
        this.a = str;
        this.b = i;
        this.c = f;
    }

    public final int a() {
        return this.b;
    }

    public final String b() {
        return this.a;
    }

    public final float c() {
        return this.c;
    }
}
