package k2;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class i0 {

    /* renamed from: a, reason: collision with root package name */
    private static final String[] f16204a = {"audio/mpeg-L1", "audio/mpeg-L2", "audio/mpeg"};

    /* renamed from: b, reason: collision with root package name */
    private static final int[] f16205b = {44100, 48000, 32000};

    /* renamed from: c, reason: collision with root package name */
    private static final int[] f16206c = {32000, 64000, 96000, 128000, 160000, 192000, 224000, 256000, 288000, 320000, 352000, 384000, 416000, 448000};

    /* renamed from: d, reason: collision with root package name */
    private static final int[] f16207d = {32000, 48000, 56000, 64000, 80000, 96000, 112000, 128000, 144000, 160000, 176000, 192000, 224000, 256000};

    /* renamed from: e, reason: collision with root package name */
    private static final int[] f16208e = {32000, 48000, 56000, 64000, 80000, 96000, 112000, 128000, 160000, 192000, 224000, 256000, 320000, 384000};

    /* renamed from: f, reason: collision with root package name */
    private static final int[] f16209f = {32000, 40000, 48000, 56000, 64000, 80000, 96000, 112000, 128000, 160000, 192000, 224000, 256000, 320000};

    /* renamed from: g, reason: collision with root package name */
    private static final int[] f16210g = {8000, 16000, 24000, 32000, 40000, 48000, 56000, 64000, 80000, 96000, 112000, 128000, 144000, 160000};

    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public int f16211a;

        /* renamed from: b, reason: collision with root package name */
        public String f16212b;

        /* renamed from: c, reason: collision with root package name */
        public int f16213c;

        /* renamed from: d, reason: collision with root package name */
        public int f16214d;

        /* renamed from: e, reason: collision with root package name */
        public int f16215e;

        /* renamed from: f, reason: collision with root package name */
        public int f16216f;

        /* renamed from: g, reason: collision with root package name */
        public int f16217g;

        public a() {
        }

        public a(a aVar) {
            this.f16211a = aVar.f16211a;
            this.f16212b = aVar.f16212b;
            this.f16213c = aVar.f16213c;
            this.f16214d = aVar.f16214d;
            this.f16215e = aVar.f16215e;
            this.f16216f = aVar.f16216f;
            this.f16217g = aVar.f16217g;
        }

        public boolean a(int i5) {
            int i6;
            int i7;
            int i8;
            int i9;
            if (!i0.l(i5) || (i6 = (i5 >>> 19) & 3) == 1 || (i7 = (i5 >>> 17) & 3) == 0 || (i8 = (i5 >>> 12) & 15) == 0 || i8 == 15 || (i9 = (i5 >>> 10) & 3) == 3) {
                return false;
            }
            this.f16211a = i6;
            this.f16212b = i0.f16204a[3 - i7];
            int i10 = i0.f16205b[i9];
            this.f16214d = i10;
            if (i6 == 2) {
                this.f16214d = i10 / 2;
            } else if (i6 == 0) {
                this.f16214d = i10 / 4;
            }
            int i11 = (i5 >>> 9) & 1;
            this.f16217g = i0.k(i6, i7);
            if (i7 == 3) {
                int i12 = i6 == 3 ? i0.f16206c[i8 - 1] : i0.f16207d[i8 - 1];
                this.f16216f = i12;
                this.f16213c = (((i12 * 12) / this.f16214d) + i11) * 4;
            } else {
                if (i6 == 3) {
                    int i13 = i7 == 2 ? i0.f16208e[i8 - 1] : i0.f16209f[i8 - 1];
                    this.f16216f = i13;
                    this.f16213c = ((i13 * 144) / this.f16214d) + i11;
                } else {
                    int i14 = i0.f16210g[i8 - 1];
                    this.f16216f = i14;
                    this.f16213c = (((i7 == 1 ? 72 : 144) * i14) / this.f16214d) + i11;
                }
            }
            this.f16215e = ((i5 >> 6) & 3) == 3 ? 1 : 2;
            return true;
        }
    }

    public static int j(int i5) {
        int i6;
        int i7;
        int i8;
        int i9;
        if (!l(i5) || (i6 = (i5 >>> 19) & 3) == 1 || (i7 = (i5 >>> 17) & 3) == 0 || (i8 = (i5 >>> 12) & 15) == 0 || i8 == 15 || (i9 = (i5 >>> 10) & 3) == 3) {
            return -1;
        }
        int i10 = f16205b[i9];
        if (i6 == 2) {
            i10 /= 2;
        } else if (i6 == 0) {
            i10 /= 4;
        }
        int i11 = (i5 >>> 9) & 1;
        if (i7 == 3) {
            return ((((i6 == 3 ? f16206c[i8 - 1] : f16207d[i8 - 1]) * 12) / i10) + i11) * 4;
        }
        int i12 = i6 == 3 ? i7 == 2 ? f16208e[i8 - 1] : f16209f[i8 - 1] : f16210g[i8 - 1];
        if (i6 == 3) {
            return ((i12 * 144) / i10) + i11;
        }
        return (((i7 == 1 ? 72 : 144) * i12) / i10) + i11;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int k(int i5, int i6) {
        if (i6 == 1) {
            return i5 == 3 ? 1152 : 576;
        }
        if (i6 == 2) {
            return 1152;
        }
        if (i6 == 3) {
            return 384;
        }
        throw new IllegalArgumentException();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean l(int i5) {
        return (i5 & (-2097152)) == -2097152;
    }

    public static int m(int i5) {
        int i6;
        int i7;
        if (!l(i5) || (i6 = (i5 >>> 19) & 3) == 1 || (i7 = (i5 >>> 17) & 3) == 0) {
            return -1;
        }
        int i8 = (i5 >>> 12) & 15;
        int i9 = (i5 >>> 10) & 3;
        if (i8 == 0 || i8 == 15 || i9 == 3) {
            return -1;
        }
        return k(i6, i7);
    }
}
