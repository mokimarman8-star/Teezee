package l9;

import i9.a;
import i9.m;
import i9.s;
import i9.v;
import java.util.Objects;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
final class b extends i9.a {

    /* renamed from: l9.b$b, reason: collision with other inner class name */
    private static final class C0055b implements a.f {
        private final v a;
        private final int b;
        private final s.a c;

        private C0055b(v vVar, int i) {
            this.a = vVar;
            this.b = i;
            this.c = new s.a();
        }

        private long c(m mVar) {
            while (mVar.getPeekPosition() < mVar.getLength() - 6 && !s.h(mVar, this.a, this.b, this.c)) {
                mVar.advancePeekPosition(1);
            }
            if (mVar.getPeekPosition() < mVar.getLength() - 6) {
                return this.c.a;
            }
            mVar.advancePeekPosition((int) (mVar.getLength() - mVar.getPeekPosition()));
            return this.a.j;
        }

        @Override // i9.a.f
        public /* synthetic */ void a() {
            i9.b.a(this);
        }

        @Override // i9.a.f
        public a.e b(m mVar, long j) {
            long position = mVar.getPosition();
            long c = c(mVar);
            long peekPosition = mVar.getPeekPosition();
            mVar.advancePeekPosition(Math.max(6, this.a.c));
            long c2 = c(mVar);
            return (c > j || c2 <= j) ? c2 <= j ? a.e.f(c2, mVar.getPeekPosition()) : a.e.d(c, position) : a.e.e(peekPosition);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(final v vVar, int i, long j, long j2) {
        super(new a.d() { // from class: l9.a
            @Override // i9.a.d
            public final long a(long j3) {
                return v.this.i(j3);
            }
        }, new C0055b(vVar, i), vVar.f(), 0L, vVar.j, j, j2, vVar.d(), Math.max(6, vVar.c));
        Objects.requireNonNull(vVar);
    }
}
