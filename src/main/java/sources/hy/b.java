package hy;

import java.io.InputStream;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public class b implements Comparable {
    private int a;
    private byte[] b;
    private int c;
    private InputStream d;
    private String e;
    private String f;

    b(a aVar, h hVar, int i) {
        this.b = null;
        this.d = null;
        this.a = i;
        InputStream inputStream = aVar.g;
        if (inputStream == null) {
            this.b = aVar.e;
            this.c = aVar.f;
        }
        this.d = inputStream;
        this.e = hVar.b();
        this.f = hVar.a();
    }

    b(a aVar, h hVar, int i, String str, String str2) {
        this.b = null;
        this.d = null;
        this.a = i;
        InputStream inputStream = aVar.g;
        if (inputStream == null) {
            this.b = aVar.e;
            this.c = aVar.f;
        }
        this.d = inputStream;
        this.e = str;
        this.f = str2;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(b bVar) {
        int i = this.a;
        int i2 = bVar.a;
        if (i > i2) {
            return 1;
        }
        return i < i2 ? -1 : 0;
    }

    public String getName() {
        return this.e;
    }
}
