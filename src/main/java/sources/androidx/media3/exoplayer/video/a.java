package androidx.media3.exoplayer.video;

import androidx.media3.container.ObuParser;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
final class a {

    /* renamed from: a, reason: collision with root package name */
    private ObuParser.d f11749a;

    a() {
    }

    private boolean a(ObuParser.c cVar, boolean z5) {
        ObuParser.d dVar;
        int i5 = cVar.f9246a;
        if (i5 == 2 || i5 == 15) {
            return true;
        }
        if (i5 == 3 && !z5) {
            return false;
        }
        if ((i5 != 6 && i5 != 3) || (dVar = this.f11749a) == null) {
            return false;
        }
        ObuParser.b b5 = ObuParser.b.b(dVar, cVar);
        return (b5 == null || b5.a()) ? false : true;
    }

    private void e(List list) {
        for (int i5 = 0; i5 < list.size(); i5++) {
            if (((ObuParser.c) list.get(i5)).f9246a == 1) {
                this.f11749a = ObuParser.d.a((ObuParser.c) list.get(i5));
            }
        }
    }

    public void b(ByteBuffer byteBuffer) {
        e(ObuParser.e(byteBuffer));
    }

    public void c() {
        this.f11749a = null;
    }

    public int d(ByteBuffer byteBuffer, boolean z5) {
        List e5 = ObuParser.e(byteBuffer);
        e(e5);
        int size = e5.size() - 1;
        int i5 = 0;
        while (size >= 0 && a((ObuParser.c) e5.get(size), z5)) {
            if (((ObuParser.c) e5.get(size)).f9246a == 6 || ((ObuParser.c) e5.get(size)).f9246a == 3) {
                i5++;
            }
            size--;
        }
        return (i5 > 1 || size + 1 >= 8) ? byteBuffer.limit() : size >= 0 ? ((ObuParser.c) e5.get(size)).f9247b.limit() : byteBuffer.position();
    }
}
