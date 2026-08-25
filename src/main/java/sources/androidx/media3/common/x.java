package androidx.media3.common;

import androidx.media3.common.util.a1;
import androidx.media3.common.v;
import com.google.common.primitives.Longs;
import java.util.Arrays;
import java.util.List;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class x {

    /* renamed from: a, reason: collision with root package name */
    private final a[] f9233a;

    /* renamed from: b, reason: collision with root package name */
    public final long f9234b;

    public interface a {
        void a(v.b bVar);

        byte[] getWrappedMetadataBytes();

        r getWrappedMetadataFormat();
    }

    public x(long j5, List list) {
        this(j5, (a[]) list.toArray(new a[0]));
    }

    public x(long j5, a... aVarArr) {
        this.f9234b = j5;
        this.f9233a = aVarArr;
    }

    public x(List list) {
        this((a[]) list.toArray(new a[0]));
    }

    public x(a... aVarArr) {
        this(-9223372036854775807L, aVarArr);
    }

    public x a(a... aVarArr) {
        return aVarArr.length == 0 ? this : new x(this.f9234b, (a[]) a1.W0(this.f9233a, aVarArr));
    }

    public x b(x xVar) {
        return xVar == null ? this : a(xVar.f9233a);
    }

    public x c(long j5) {
        return this.f9234b == j5 ? this : new x(j5, this.f9233a);
    }

    public a d(int i5) {
        return this.f9233a[i5];
    }

    public int e() {
        return this.f9233a.length;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || x.class != obj.getClass()) {
            return false;
        }
        x xVar = (x) obj;
        return Arrays.equals(this.f9233a, xVar.f9233a) && this.f9234b == xVar.f9234b;
    }

    public int hashCode() {
        return (Arrays.hashCode(this.f9233a) * 31) + Longs.e(this.f9234b);
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append("entries=");
        sb.append(Arrays.toString(this.f9233a));
        if (this.f9234b == -9223372036854775807L) {
            str = "";
        } else {
            str = ", presentationTimeUs=" + this.f9234b;
        }
        sb.append(str);
        return sb.toString();
    }
}
