package v2;

import androidx.media3.common.r;
import androidx.media3.common.v;
import androidx.media3.common.w;
import androidx.media3.common.x;
import java.util.Arrays;
import java.util.Objects;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class a implements x.a {

    /* renamed from: g, reason: collision with root package name */
    private static final r f18061g = new r.b().u0("application/id3").N();

    /* renamed from: h, reason: collision with root package name */
    private static final r f18062h = new r.b().u0("application/x-scte35").N();

    /* renamed from: a, reason: collision with root package name */
    public final String f18063a;

    /* renamed from: b, reason: collision with root package name */
    public final String f18064b;

    /* renamed from: c, reason: collision with root package name */
    public final long f18065c;

    /* renamed from: d, reason: collision with root package name */
    public final long f18066d;

    /* renamed from: e, reason: collision with root package name */
    public final byte[] f18067e;

    /* renamed from: f, reason: collision with root package name */
    private int f18068f;

    public a(String str, String str2, long j5, long j6, byte[] bArr) {
        this.f18063a = str;
        this.f18064b = str2;
        this.f18065c = j5;
        this.f18066d = j6;
        this.f18067e = bArr;
    }

    @Override // androidx.media3.common.x.a
    public /* synthetic */ void a(v.b bVar) {
        w.c(this, bVar);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || a.class != obj.getClass()) {
            return false;
        }
        a aVar = (a) obj;
        return this.f18065c == aVar.f18065c && this.f18066d == aVar.f18066d && Objects.equals(this.f18063a, aVar.f18063a) && Objects.equals(this.f18064b, aVar.f18064b) && Arrays.equals(this.f18067e, aVar.f18067e);
    }

    @Override // androidx.media3.common.x.a
    public byte[] getWrappedMetadataBytes() {
        if (getWrappedMetadataFormat() != null) {
            return this.f18067e;
        }
        return null;
    }

    @Override // androidx.media3.common.x.a
    public r getWrappedMetadataFormat() {
        String str = this.f18063a;
        str.hashCode();
        switch (str) {
            case "urn:scte:scte35:2014:bin":
                return f18062h;
            case "https://aomedia.org/emsg/ID3":
            case "https://developer.apple.com/streaming/emsg-id3":
                return f18061g;
            default:
                return null;
        }
    }

    public int hashCode() {
        if (this.f18068f == 0) {
            String str = this.f18063a;
            int hashCode = (527 + (str != null ? str.hashCode() : 0)) * 31;
            String str2 = this.f18064b;
            int hashCode2 = str2 != null ? str2.hashCode() : 0;
            long j5 = this.f18065c;
            int i5 = (((hashCode + hashCode2) * 31) + ((int) (j5 ^ (j5 >>> 32)))) * 31;
            long j6 = this.f18066d;
            this.f18068f = ((i5 + ((int) (j6 ^ (j6 >>> 32)))) * 31) + Arrays.hashCode(this.f18067e);
        }
        return this.f18068f;
    }

    public String toString() {
        return "EMSG: scheme=" + this.f18063a + ", id=" + this.f18066d + ", durationMs=" + this.f18065c + ", value=" + this.f18064b;
    }
}
