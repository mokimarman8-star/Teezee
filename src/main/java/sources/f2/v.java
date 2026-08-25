package f2;

import java.util.Arrays;
import java.util.Random;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public interface v {

    public static class a implements v {

        /* renamed from: a, reason: collision with root package name */
        private final Random f15249a;

        /* renamed from: b, reason: collision with root package name */
        private final int[] f15250b;

        /* renamed from: c, reason: collision with root package name */
        private final int[] f15251c;

        public a(int i5) {
            this(i5, new Random());
        }

        private a(int i5, Random random) {
            this(b(i5, random), random);
        }

        private a(int[] iArr, Random random) {
            this.f15250b = iArr;
            this.f15249a = random;
            this.f15251c = new int[iArr.length];
            for (int i5 = 0; i5 < iArr.length; i5++) {
                this.f15251c[iArr[i5]] = i5;
            }
        }

        private static int[] b(int i5, Random random) {
            int[] iArr = new int[i5];
            int i6 = 0;
            while (i6 < i5) {
                int i7 = i6 + 1;
                int nextInt = random.nextInt(i7);
                iArr[i6] = iArr[nextInt];
                iArr[nextInt] = i6;
                i6 = i7;
            }
            return iArr;
        }

        @Override // f2.v
        public v a(int i5, int i6) {
            int i7 = i6 - i5;
            int[] iArr = new int[this.f15250b.length - i7];
            int i8 = 0;
            int i9 = 0;
            while (true) {
                int[] iArr2 = this.f15250b;
                if (i8 >= iArr2.length) {
                    return new a(iArr, new Random(this.f15249a.nextLong()));
                }
                int i10 = iArr2[i8];
                if (i10 < i5 || i10 >= i6) {
                    int i11 = i8 - i9;
                    if (i10 >= i5) {
                        i10 -= i7;
                    }
                    iArr[i11] = i10;
                } else {
                    i9++;
                }
                i8++;
            }
        }

        @Override // f2.v
        public v cloneAndClear() {
            return new a(0, new Random(this.f15249a.nextLong()));
        }

        @Override // f2.v
        public v cloneAndInsert(int i5, int i6) {
            int[] iArr = new int[i6];
            int[] iArr2 = new int[i6];
            int i7 = 0;
            int i8 = 0;
            while (i8 < i6) {
                iArr[i8] = this.f15249a.nextInt(this.f15250b.length + 1);
                int i9 = i8 + 1;
                int nextInt = this.f15249a.nextInt(i9);
                iArr2[i8] = iArr2[nextInt];
                iArr2[nextInt] = i8 + i5;
                i8 = i9;
            }
            Arrays.sort(iArr);
            int[] iArr3 = new int[this.f15250b.length + i6];
            int i10 = 0;
            int i11 = 0;
            while (true) {
                int[] iArr4 = this.f15250b;
                if (i7 >= iArr4.length + i6) {
                    return new a(iArr3, new Random(this.f15249a.nextLong()));
                }
                if (i10 >= i6 || i11 != iArr[i10]) {
                    int i12 = i11 + 1;
                    int i13 = iArr4[i11];
                    iArr3[i7] = i13;
                    if (i13 >= i5) {
                        iArr3[i7] = i13 + i6;
                    }
                    i11 = i12;
                } else {
                    iArr3[i7] = iArr2[i10];
                    i10++;
                }
                i7++;
            }
        }

        @Override // f2.v
        public int getFirstIndex() {
            int[] iArr = this.f15250b;
            if (iArr.length > 0) {
                return iArr[0];
            }
            return -1;
        }

        @Override // f2.v
        public int getLastIndex() {
            int[] iArr = this.f15250b;
            if (iArr.length > 0) {
                return iArr[iArr.length - 1];
            }
            return -1;
        }

        @Override // f2.v
        public int getLength() {
            return this.f15250b.length;
        }

        @Override // f2.v
        public int getNextIndex(int i5) {
            int i6 = this.f15251c[i5] + 1;
            int[] iArr = this.f15250b;
            if (i6 < iArr.length) {
                return iArr[i6];
            }
            return -1;
        }

        @Override // f2.v
        public int getPreviousIndex(int i5) {
            int i6 = this.f15251c[i5] - 1;
            if (i6 >= 0) {
                return this.f15250b[i6];
            }
            return -1;
        }
    }

    v a(int i5, int i6);

    v cloneAndClear();

    v cloneAndInsert(int i5, int i6);

    int getFirstIndex();

    int getLastIndex();

    int getLength();

    int getNextIndex(int i5);

    int getPreviousIndex(int i5);
}
