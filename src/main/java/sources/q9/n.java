package q9;

import com.google.android.exoplayer2.util.d0;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
abstract class n {
    private static final int[] a = {1769172845, 1769172786, 1769172787, 1769172788, 1769172789, 1769172790, 1769172793, 1635148593, 1752589105, 1751479857, 1635135537, 1836069937, 1836069938, 862401121, 862401122, 862417462, 862417718, 862414134, 862414646, 1295275552, 1295270176, 1714714144, 1801741417, 1295275600, 1903435808, 1297305174, 1684175153, 1769172332, 1885955686};

    private static boolean a(int i, boolean z) {
        if ((i >>> 8) == 3368816) {
            return true;
        }
        if (i == 1751476579 && z) {
            return true;
        }
        for (int i2 : a) {
            if (i2 == i) {
                return true;
            }
        }
        return false;
    }

    public static boolean b(i9.m mVar) {
        return c(mVar, true, false);
    }

    private static boolean c(i9.m mVar, boolean z, boolean z2) {
        boolean z3;
        boolean z4;
        boolean z5;
        int i;
        boolean z6;
        boolean z10;
        long length = mVar.getLength();
        long j = -1;
        int i2 = (length > (-1L) ? 1 : (length == (-1L) ? 0 : -1));
        long j2 = 4096;
        if (i2 != 0 && length <= 4096) {
            j2 = length;
        }
        int i3 = (int) j2;
        d0 d0Var = new d0(64);
        boolean z11 = false;
        int i4 = 0;
        boolean z12 = false;
        while (i4 < i3) {
            d0Var.L(8);
            if (!mVar.peekFully(d0Var.d(), z11 ? 1 : 0, 8, true)) {
                break;
            }
            long F = d0Var.F();
            int n = d0Var.n();
            if (F == 1) {
                mVar.peekFully(d0Var.d(), 8, 8);
                d0Var.O(16);
                i = 16;
                F = d0Var.w();
            } else {
                if (F == 0) {
                    long length2 = mVar.getLength();
                    if (length2 != j) {
                        F = (length2 - mVar.getPeekPosition()) + 8;
                    }
                }
                i = 8;
            }
            long j3 = i;
            if (F < j3) {
                return z11;
            }
            i4 += i;
            if (n == 1836019574) {
                i3 += (int) F;
                if (i2 != 0 && i3 > length) {
                    i3 = (int) length;
                }
            } else {
                if (n == 1836019558 || n == 1836475768) {
                    z3 = z11 ? 1 : 0;
                    z4 = true;
                    z5 = true;
                    break;
                }
                int i5 = i2;
                if ((i4 + F) - j3 >= i3) {
                    z3 = false;
                    z4 = true;
                    break;
                }
                int i6 = (int) (F - j3);
                i4 += i6;
                if (n != 1718909296) {
                    z6 = false;
                    z12 = z12;
                    if (i6 != 0) {
                        mVar.advancePeekPosition(i6);
                        z12 = z12;
                    }
                } else {
                    if (i6 < 8) {
                        return false;
                    }
                    d0Var.L(i6);
                    mVar.peekFully(d0Var.d(), 0, i6);
                    int i7 = i6 / 4;
                    int i10 = 0;
                    while (true) {
                        if (i10 >= i7) {
                            z10 = z12;
                            break;
                        }
                        if (i10 == 1) {
                            d0Var.Q(4);
                        } else if (a(d0Var.n(), z2)) {
                            z10 = true;
                            break;
                        }
                        i10++;
                    }
                    if (!z10) {
                        return false;
                    }
                    z6 = false;
                    z12 = z10;
                }
                z11 = z6;
                i2 = i5;
            }
            j = -1;
            z12 = z12;
        }
        z3 = z11 ? 1 : 0;
        z4 = true;
        z5 = z3;
        return (z12 && z == z5) ? z4 : z3;
    }

    public static boolean d(i9.m mVar, boolean z) {
        return c(mVar, false, z);
    }
}
