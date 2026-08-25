package androidx.media3.exoplayer.hls;

import android.util.SparseArray;
import androidx.media3.common.util.p0;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class t {

    /* renamed from: a, reason: collision with root package name */
    private final SparseArray f10673a = new SparseArray();

    public p0 a(int i5) {
        p0 p0Var = (p0) this.f10673a.get(i5);
        if (p0Var != null) {
            return p0Var;
        }
        p0 p0Var2 = new p0(9223372036854775806L);
        this.f10673a.put(i5, p0Var2);
        return p0Var2;
    }

    public void b() {
        this.f10673a.clear();
    }
}
