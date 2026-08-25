package c7;

import com.cloud.hisavana.sdk.b4;
import com.cloud.sdk.commonutil.util.HSScopeHelper;
import com.cloud.sdk.commonutil.util.e;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public final class b$b {
    private boolean c;
    private boolean a = false;
    private boolean b = false;
    private int d = 200;
    private boolean e = false;
    private boolean f = false;

    /* JADX WARN: Type inference failed for: r0v0, types: [c7.b$a] */
    public b$a c() {
        return new Object(this) { // from class: c7.b$a
            private boolean a;
            private boolean b;
            private boolean c;
            private int d;
            private boolean e;

            {
                boolean z;
                boolean z2;
                boolean z3;
                int i;
                boolean z4;
                boolean z7;
                this.c = false;
                this.e = false;
                z = this.a;
                this.a = z;
                z2 = this.b;
                this.b = z2;
                z3 = this.c;
                this.c = z3;
                i = this.d;
                this.d = i;
                z4 = this.e;
                this.e = z4;
                z7 = this.f;
                HSScopeHelper.b = z7;
            }
        };
    }

    public b$b h(String str) {
        b.b = str;
        return this;
    }

    public b$b i(boolean z) {
        this.a = z;
        this.b = z;
        e.j(z);
        b4.b().setLogSwitch(this.a);
        com.cloud.sdk.commonutil.util.c.NET_LOG.m().q(this.a);
        return this;
    }

    public b$b j(int i) {
        this.d = i;
        return this;
    }

    public b$b k(boolean z) {
        b.f(z);
        return this;
    }

    public b$b l(long j) {
        b.b().set(j);
        return this;
    }

    public b$b m(boolean z) {
        b.d(z);
        return this;
    }

    public b$b n(boolean z) {
        this.e = z;
        return this;
    }

    public b$b o(boolean z) {
        this.c = z;
        return this;
    }
}
