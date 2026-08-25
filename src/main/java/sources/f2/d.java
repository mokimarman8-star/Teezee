package f2;

import androidx.media3.exoplayer.source.f0;
import androidx.media3.exoplayer.v2;
import com.google.common.collect.ImmutableList;
import java.util.List;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class d implements f0 {

    /* renamed from: a, reason: collision with root package name */
    private final ImmutableList f15205a;

    /* renamed from: b, reason: collision with root package name */
    private long f15206b;

    private static final class a implements f0 {

        /* renamed from: a, reason: collision with root package name */
        private final f0 f15207a;

        /* renamed from: b, reason: collision with root package name */
        private final ImmutableList f15208b;

        public a(f0 f0Var, List list) {
            this.f15207a = f0Var;
            this.f15208b = ImmutableList.copyOf(list);
        }

        @Override // androidx.media3.exoplayer.source.f0
        public boolean a(v2 v2Var) {
            return this.f15207a.a(v2Var);
        }

        public ImmutableList c() {
            return this.f15208b;
        }

        @Override // androidx.media3.exoplayer.source.f0
        public long getBufferedPositionUs() {
            return this.f15207a.getBufferedPositionUs();
        }

        @Override // androidx.media3.exoplayer.source.f0
        public long getNextLoadPositionUs() {
            return this.f15207a.getNextLoadPositionUs();
        }

        @Override // androidx.media3.exoplayer.source.f0
        public boolean isLoading() {
            return this.f15207a.isLoading();
        }

        @Override // androidx.media3.exoplayer.source.f0
        public void reevaluateBuffer(long j5) {
            this.f15207a.reevaluateBuffer(j5);
        }
    }

    public d(List list, List list2) {
        ImmutableList.a builder = ImmutableList.builder();
        androidx.media3.common.util.a.a(list.size() == list2.size());
        for (int i5 = 0; i5 < list.size(); i5++) {
            builder.j(new a((f0) list.get(i5), (List) list2.get(i5)));
        }
        this.f15205a = builder.n();
        this.f15206b = -9223372036854775807L;
    }

    @Override // androidx.media3.exoplayer.source.f0
    public boolean a(v2 v2Var) {
        boolean z5;
        boolean z6 = false;
        do {
            long nextLoadPositionUs = getNextLoadPositionUs();
            if (nextLoadPositionUs == Long.MIN_VALUE) {
                break;
            }
            z5 = false;
            for (int i5 = 0; i5 < this.f15205a.size(); i5++) {
                long nextLoadPositionUs2 = ((a) this.f15205a.get(i5)).getNextLoadPositionUs();
                boolean z7 = nextLoadPositionUs2 != Long.MIN_VALUE && nextLoadPositionUs2 <= v2Var.f11725a;
                if (nextLoadPositionUs2 == nextLoadPositionUs || z7) {
                    z5 |= ((a) this.f15205a.get(i5)).a(v2Var);
                }
            }
            z6 |= z5;
        } while (z5);
        return z6;
    }

    @Override // androidx.media3.exoplayer.source.f0
    public long getBufferedPositionUs() {
        long j5 = Long.MAX_VALUE;
        long j6 = Long.MAX_VALUE;
        for (int i5 = 0; i5 < this.f15205a.size(); i5++) {
            a aVar = (a) this.f15205a.get(i5);
            long bufferedPositionUs = aVar.getBufferedPositionUs();
            if ((aVar.c().contains(1) || aVar.c().contains(2) || aVar.c().contains(4)) && bufferedPositionUs != Long.MIN_VALUE) {
                j5 = Math.min(j5, bufferedPositionUs);
            }
            if (bufferedPositionUs != Long.MIN_VALUE) {
                j6 = Math.min(j6, bufferedPositionUs);
            }
        }
        if (j5 != Long.MAX_VALUE) {
            this.f15206b = j5;
            return j5;
        }
        if (j6 == Long.MAX_VALUE) {
            return Long.MIN_VALUE;
        }
        long j7 = this.f15206b;
        return j7 != -9223372036854775807L ? j7 : j6;
    }

    @Override // androidx.media3.exoplayer.source.f0
    public long getNextLoadPositionUs() {
        long j5 = Long.MAX_VALUE;
        for (int i5 = 0; i5 < this.f15205a.size(); i5++) {
            long nextLoadPositionUs = ((a) this.f15205a.get(i5)).getNextLoadPositionUs();
            if (nextLoadPositionUs != Long.MIN_VALUE) {
                j5 = Math.min(j5, nextLoadPositionUs);
            }
        }
        if (j5 == Long.MAX_VALUE) {
            return Long.MIN_VALUE;
        }
        return j5;
    }

    @Override // androidx.media3.exoplayer.source.f0
    public boolean isLoading() {
        for (int i5 = 0; i5 < this.f15205a.size(); i5++) {
            if (((a) this.f15205a.get(i5)).isLoading()) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.media3.exoplayer.source.f0
    public void reevaluateBuffer(long j5) {
        for (int i5 = 0; i5 < this.f15205a.size(); i5++) {
            ((a) this.f15205a.get(i5)).reevaluateBuffer(j5);
        }
    }
}
