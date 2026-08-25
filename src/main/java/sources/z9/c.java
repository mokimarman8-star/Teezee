package z9;

import android.net.Uri;
import com.google.android.exoplayer2.offline.StreamKey;
import com.google.android.exoplayer2.util.p0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public class c implements com.google.android.exoplayer2.offline.c {
    public final long a;
    public final long b;
    public final long c;
    public final boolean d;
    public final long e;
    public final long f;
    public final long g;
    public final long h;
    public final o i;
    public final l j;
    public final Uri k;
    public final h l;
    private final List m;

    public c(long j, long j2, long j3, boolean z, long j4, long j5, long j6, long j7, h hVar, o oVar, l lVar, Uri uri, List list) {
        this.a = j;
        this.b = j2;
        this.c = j3;
        this.d = z;
        this.e = j4;
        this.f = j5;
        this.g = j6;
        this.h = j7;
        this.l = hVar;
        this.i = oVar;
        this.k = uri;
        this.j = lVar;
        this.m = list == null ? Collections.emptyList() : list;
    }

    private static ArrayList b(List list, LinkedList linkedList) {
        StreamKey streamKey = (StreamKey) linkedList.poll();
        int i = streamKey.periodIndex;
        ArrayList arrayList = new ArrayList();
        do {
            int i2 = streamKey.groupIndex;
            a aVar = (a) list.get(i2);
            List list2 = aVar.c;
            ArrayList arrayList2 = new ArrayList();
            do {
                arrayList2.add((j) list2.get(streamKey.streamIndex));
                streamKey = (StreamKey) linkedList.poll();
                if (streamKey.periodIndex != i) {
                    break;
                }
            } while (streamKey.groupIndex == i2);
            arrayList.add(new a(aVar.a, aVar.b, arrayList2, aVar.d, aVar.e, aVar.f));
        } while (streamKey.periodIndex == i);
        linkedList.addFirst(streamKey);
        return arrayList;
    }

    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final c copy(List list) {
        LinkedList linkedList = new LinkedList(list);
        Collections.sort(linkedList);
        linkedList.add(new StreamKey(-1, -1, -1));
        ArrayList arrayList = new ArrayList();
        long j = 0;
        int i = 0;
        while (true) {
            if (i >= d()) {
                break;
            }
            if (((StreamKey) linkedList.peek()).periodIndex != i) {
                long e = e(i);
                if (e != -9223372036854775807L) {
                    j += e;
                }
            } else {
                g c = c(i);
                arrayList.add(new g(c.a, c.b - j, b(c.c, linkedList), c.d));
            }
            i++;
        }
        long j2 = this.b;
        return new c(this.a, j2 != -9223372036854775807L ? j2 - j : -9223372036854775807L, this.c, this.d, this.e, this.f, this.g, this.h, this.l, this.i, this.j, this.k, arrayList);
    }

    public final g c(int i) {
        return (g) this.m.get(i);
    }

    public final int d() {
        return this.m.size();
    }

    public final long e(int i) {
        long j;
        long j2;
        if (i == this.m.size() - 1) {
            j = this.b;
            if (j == -9223372036854775807L) {
                return -9223372036854775807L;
            }
            j2 = ((g) this.m.get(i)).b;
        } else {
            j = ((g) this.m.get(i + 1)).b;
            j2 = ((g) this.m.get(i)).b;
        }
        return j - j2;
    }

    public final long f(int i) {
        return p0.B0(e(i));
    }
}
