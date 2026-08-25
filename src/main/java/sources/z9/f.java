package z9;

import com.google.android.exoplayer2.metadata.emsg.EventMessage;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class f {
    public final EventMessage[] a;
    public final long[] b;
    public final String c;
    public final String d;
    public final long e;

    public f(String str, String str2, long j, long[] jArr, EventMessage[] eventMessageArr) {
        this.c = str;
        this.d = str2;
        this.e = j;
        this.b = jArr;
        this.a = eventMessageArr;
    }

    public String a() {
        return this.c + "/" + this.d;
    }
}
