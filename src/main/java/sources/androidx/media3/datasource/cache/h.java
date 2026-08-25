package androidx.media3.datasource.cache;

import java.io.File;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class h implements Comparable {

    /* renamed from: a, reason: collision with root package name */
    public final String f9494a;

    /* renamed from: b, reason: collision with root package name */
    public final long f9495b;

    /* renamed from: c, reason: collision with root package name */
    public final long f9496c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f9497d;

    /* renamed from: e, reason: collision with root package name */
    public final File f9498e;

    /* renamed from: f, reason: collision with root package name */
    public final long f9499f;

    public h(String str, long j5, long j6, long j7, File file) {
        this.f9494a = str;
        this.f9495b = j5;
        this.f9496c = j6;
        this.f9497d = file != null;
        this.f9498e = file;
        this.f9499f = j7;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(h hVar) {
        if (!this.f9494a.equals(hVar.f9494a)) {
            return this.f9494a.compareTo(hVar.f9494a);
        }
        long j5 = this.f9495b - hVar.f9495b;
        if (j5 == 0) {
            return 0;
        }
        return j5 < 0 ? -1 : 1;
    }

    public boolean b() {
        return !this.f9497d;
    }

    public boolean d() {
        return this.f9496c == -1;
    }

    public String toString() {
        return "[" + this.f9495b + ", " + this.f9496c + "]";
    }
}
