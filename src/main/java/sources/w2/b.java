package w2;

import androidx.media3.common.r;
import androidx.media3.common.v;
import androidx.media3.common.w;
import androidx.media3.common.x;
import com.google.common.primitives.Ints;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class b implements x.a {

    /* renamed from: a, reason: collision with root package name */
    public final String f18140a;

    /* renamed from: b, reason: collision with root package name */
    public final String f18141b;

    public b(String str, String str2) {
        this.f18140a = com.google.common.base.a.g(str);
        this.f18141b = str2;
    }

    @Override // androidx.media3.common.x.a
    public void a(v.b bVar) {
        String str = this.f18140a;
        str.hashCode();
        switch (str) {
            case "TOTALTRACKS":
                Integer p5 = Ints.p(this.f18141b);
                if (p5 != null) {
                    bVar.r0(p5);
                    break;
                }
                break;
            case "TOTALDISCS":
                Integer p6 = Ints.p(this.f18141b);
                if (p6 != null) {
                    bVar.q0(p6);
                    break;
                }
                break;
            case "TRACKNUMBER":
                Integer p7 = Ints.p(this.f18141b);
                if (p7 != null) {
                    bVar.s0(p7);
                    break;
                }
                break;
            case "ALBUM":
                bVar.P(this.f18141b);
                break;
            case "GENRE":
                bVar.c0(this.f18141b);
                break;
            case "TITLE":
                bVar.p0(this.f18141b);
                break;
            case "DESCRIPTION":
                bVar.W(this.f18141b);
                break;
            case "DISCNUMBER":
                Integer p8 = Ints.p(this.f18141b);
                if (p8 != null) {
                    bVar.X(p8);
                    break;
                }
                break;
            case "ALBUMARTIST":
                bVar.O(this.f18141b);
                break;
            case "ARTIST":
                bVar.Q(this.f18141b);
                break;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        return this.f18140a.equals(bVar.f18140a) && this.f18141b.equals(bVar.f18141b);
    }

    @Override // androidx.media3.common.x.a
    public /* synthetic */ byte[] getWrappedMetadataBytes() {
        return w.a(this);
    }

    @Override // androidx.media3.common.x.a
    public /* synthetic */ r getWrappedMetadataFormat() {
        return w.b(this);
    }

    public int hashCode() {
        return ((527 + this.f18140a.hashCode()) * 31) + this.f18141b.hashCode();
    }

    public String toString() {
        return "VC: " + this.f18140a + "=" + this.f18141b;
    }
}
