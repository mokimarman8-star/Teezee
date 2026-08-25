package jn;

import android.content.Context;
import android.view.ViewGroup;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public interface n {
    public static final a a = a.a;

    public static final class a {
        static final /* synthetic */ a a = new a();

        private a() {
        }

        public final n a(Context context, ViewGroup viewGroup) {
            Intrinsics.h(context, "context");
            return new m(context, viewGroup);
        }
    }

    void a(float f, float f2);

    float b();

    int c();

    void d(float f, float f2, int i);

    void e(com.transsion.player.orplayer.f fVar);

    void f(boolean z);

    void g();
}
