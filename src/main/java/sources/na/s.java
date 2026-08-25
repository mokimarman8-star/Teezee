package na;

import com.google.android.exoplayer2.l3;
import com.google.android.exoplayer2.p1;
import com.google.android.exoplayer2.source.o;
import java.util.List;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public interface s extends v {

    public static final class a {
        public final v9.w a;
        public final int[] b;
        public final int c;

        public a(v9.w wVar, int... iArr) {
            this(wVar, iArr, 0);
        }

        public a(v9.w wVar, int[] iArr, int i) {
            if (iArr.length == 0) {
                com.google.android.exoplayer2.util.s.d("ETSDefinition", "Empty tracks are not allowed", new IllegalArgumentException());
            }
            this.a = wVar;
            this.b = iArr;
            this.c = i;
        }
    }

    public interface b {
        s[] a(a[] aVarArr, com.google.android.exoplayer2.upstream.e eVar, o.b bVar, l3 l3Var);
    }

    void a();

    void b(boolean z);

    boolean blacklist(int i, long j);

    void c();

    boolean d(int i, long j);

    void disable();

    boolean e(long j, x9.f fVar, List list);

    void enable();

    int evaluateQueueSize(long j, List list);

    void f(long j, long j2, long j3, List list, x9.o[] oVarArr);

    p1 getSelectedFormat();

    int getSelectedIndex();

    int getSelectedIndexInTrackGroup();

    Object getSelectionData();

    int getSelectionReason();

    void onPlaybackSpeed(float f);
}
