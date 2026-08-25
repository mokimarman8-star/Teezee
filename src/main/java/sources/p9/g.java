package p9;

import i9.b0;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
interface g extends b0 {

    public static class a extends b0.b implements g {
        public a() {
            super(-9223372036854775807L);
        }

        @Override // p9.g
        public long a() {
            return -1L;
        }

        @Override // p9.g
        public long getTimeUs(long j) {
            return 0L;
        }
    }

    long a();

    long getTimeUs(long j);
}
