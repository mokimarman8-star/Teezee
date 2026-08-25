package androidx.compose.ui.graphics;

import android.graphics.Shader;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class k1 {

    public static final class a extends y4 {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Shader f3460e;

        a(Shader shader) {
            this.f3460e = shader;
        }

        @Override // androidx.compose.ui.graphics.y4
        public Shader b(long j5) {
            return this.f3460e;
        }
    }

    public static final y4 a(Shader shader) {
        return new a(shader);
    }
}
