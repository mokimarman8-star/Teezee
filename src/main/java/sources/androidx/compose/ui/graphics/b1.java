package androidx.compose.ui.graphics;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class b1 {
    public static final long b(float f5, float f6, float f7, float f8, float[] fArr, int i5) {
        float f9 = (f6 - f5) * 3.0f;
        float f10 = (f7 - f6) * 3.0f;
        float f11 = (f8 - f7) * 3.0f;
        int f12 = f(f9, f10, f11, fArr, i5);
        float f13 = (f10 - f9) * 2.0f;
        int g5 = f12 + g((-f13) / (((f11 - f10) * 2.0f) - f13), fArr, i5 + f12);
        float min = Math.min(f5, f8);
        float max = Math.max(f5, f8);
        for (int i6 = 0; i6 < g5; i6++) {
            float d5 = d(f5, f6, f7, f8, fArr[i6]);
            min = Math.min(min, d5);
            max = Math.max(max, d5);
        }
        return androidx.collection.h.a(min, max);
    }

    public static final float c(float f5, float f6, float f7) {
        return ((((((f5 - f6) + 0.33333334f) * f7) + (f6 - (2.0f * f5))) * f7) + f5) * 3.0f * f7;
    }

    private static final float d(float f5, float f6, float f7, float f8, float f9) {
        float f10 = (f8 + ((f6 - f7) * 3.0f)) - f5;
        return (((((f10 * f9) + (((f7 - (2.0f * f6)) + f5) * 3.0f)) * f9) + ((f6 - f5) * 3.0f)) * f9) + f5;
    }

    public static final float e(float f5, float f6, float f7, float f8) {
        double d5 = f5;
        double d6 = ((d5 - (f6 * 2.0d)) + f7) * 3.0d;
        double d7 = (f6 - f5) * 3.0d;
        double d8 = (-f5) + ((f6 - f7) * 3.0d) + f8;
        if (Math.abs(d8 - 0.0d) < 1.0E-7d) {
            if (Math.abs(d6 - 0.0d) < 1.0E-7d) {
                if (Math.abs(d7 - 0.0d) < 1.0E-7d) {
                    return Float.NaN;
                }
                float f9 = (float) ((-d5) / d7);
                if (f9 < 0.0f) {
                    if (f9 >= -8.34465E-7f) {
                        return 0.0f;
                    }
                } else {
                    if (f9 <= 1.0f) {
                        return f9;
                    }
                    if (f9 <= 1.0000008f) {
                        return 1.0f;
                    }
                }
                return Float.NaN;
            }
            double sqrt = Math.sqrt((d7 * d7) - ((4.0d * d6) * d5));
            double d9 = d6 * 2.0d;
            float f10 = (float) ((sqrt - d7) / d9);
            if (f10 < 0.0f) {
                if (f10 >= -8.34465E-7f) {
                    f10 = 0.0f;
                }
                f10 = Float.NaN;
            } else if (f10 > 1.0f) {
                if (f10 <= 1.0000008f) {
                    f10 = 1.0f;
                }
                f10 = Float.NaN;
            }
            if (!Float.isNaN(f10)) {
                return f10;
            }
            float f11 = (float) (((-d7) - sqrt) / d9);
            if (f11 < 0.0f) {
                if (f11 >= -8.34465E-7f) {
                    return 0.0f;
                }
            } else {
                if (f11 <= 1.0f) {
                    return f11;
                }
                if (f11 <= 1.0000008f) {
                    return 1.0f;
                }
            }
            return Float.NaN;
        }
        double d10 = d6 / d8;
        double d11 = d7 / d8;
        double d12 = d5 / d8;
        double d13 = ((d11 * 3.0d) - (d10 * d10)) / 9.0d;
        double d14 = (((((2.0d * d10) * d10) * d10) - ((9.0d * d10) * d11)) + (d12 * 27.0d)) / 54.0d;
        double d15 = d13 * d13 * d13;
        double d16 = (d14 * d14) + d15;
        double d17 = d10 / 3.0d;
        if (d16 >= 0.0d) {
            if (d16 != 0.0d) {
                double sqrt2 = Math.sqrt(d16);
                float a5 = (float) ((q0.b.a((float) ((-d14) + sqrt2)) - q0.b.a((float) (d14 + sqrt2))) - d17);
                if (a5 < 0.0f) {
                    if (a5 >= -8.34465E-7f) {
                        return 0.0f;
                    }
                } else {
                    if (a5 <= 1.0f) {
                        return a5;
                    }
                    if (a5 <= 1.0000008f) {
                        return 1.0f;
                    }
                }
                return Float.NaN;
            }
            float f12 = -q0.b.a((float) d14);
            float f13 = (float) d17;
            float f14 = (2.0f * f12) - f13;
            if (f14 < 0.0f) {
                if (f14 >= -8.34465E-7f) {
                    f14 = 0.0f;
                }
                f14 = Float.NaN;
            } else if (f14 > 1.0f) {
                if (f14 <= 1.0000008f) {
                    f14 = 1.0f;
                }
                f14 = Float.NaN;
            }
            if (!Float.isNaN(f14)) {
                return f14;
            }
            float f15 = (-f12) - f13;
            if (f15 < 0.0f) {
                if (f15 >= -8.34465E-7f) {
                    return 0.0f;
                }
            } else {
                if (f15 <= 1.0f) {
                    return f15;
                }
                if (f15 <= 1.0000008f) {
                    return 1.0f;
                }
            }
            return Float.NaN;
        }
        double sqrt3 = Math.sqrt(-d15);
        double d18 = (-d14) / sqrt3;
        if (d18 < -1.0d) {
            d18 = -1.0d;
        }
        if (d18 > 1.0d) {
            d18 = 1.0d;
        }
        double acos = Math.acos(d18);
        double a6 = q0.b.a((float) sqrt3) * 2.0f;
        float cos = (float) ((Math.cos(acos / 3.0d) * a6) - d17);
        if (cos < 0.0f) {
            if (cos >= -8.34465E-7f) {
                cos = 0.0f;
            }
            cos = Float.NaN;
        } else if (cos > 1.0f) {
            if (cos <= 1.0000008f) {
                cos = 1.0f;
            }
            cos = Float.NaN;
        }
        if (!Float.isNaN(cos)) {
            return cos;
        }
        float cos2 = (float) ((Math.cos((6.283185307179586d + acos) / 3.0d) * a6) - d17);
        if (cos2 < 0.0f) {
            if (cos2 >= -8.34465E-7f) {
                cos2 = 0.0f;
            }
            cos2 = Float.NaN;
        } else if (cos2 > 1.0f) {
            if (cos2 <= 1.0000008f) {
                cos2 = 1.0f;
            }
            cos2 = Float.NaN;
        }
        if (!Float.isNaN(cos2)) {
            return cos2;
        }
        float cos3 = (float) ((a6 * Math.cos((acos + 12.566370614359172d) / 3.0d)) - d17);
        if (cos3 < 0.0f) {
            if (cos3 >= -8.34465E-7f) {
                return 0.0f;
            }
        } else {
            if (cos3 <= 1.0f) {
                return cos3;
            }
            if (cos3 <= 1.0000008f) {
                return 1.0f;
            }
        }
        return Float.NaN;
    }

    private static final int f(float f5, float f6, float f7, float[] fArr, int i5) {
        double d5 = f5;
        double d6 = f6;
        double d7 = f7;
        double d8 = d6 * 2.0d;
        double d9 = (d5 - d8) + d7;
        if (d9 == 0.0d) {
            if (d6 == d7) {
                return 0;
            }
            return g((float) ((d8 - d7) / (d8 - (d7 * 2.0d))), fArr, i5);
        }
        double d10 = -Math.sqrt((d6 * d6) - (d7 * d5));
        double d11 = (-d5) + d6;
        int g5 = g((float) ((-(d10 + d11)) / d9), fArr, i5);
        int g6 = g5 + g((float) ((d10 - d11) / d9), fArr, i5 + g5);
        if (g6 > 1) {
            float f8 = fArr[i5];
            int i6 = i5 + 1;
            float f9 = fArr[i6];
            if (f8 > f9) {
                fArr[i5] = f9;
                fArr[i6] = f8;
            } else if (f8 == f9) {
                return g6 - 1;
            }
        }
        return g6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x001c, code lost:
    
        if (r3 <= 1.0000008f) goto L6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x000b, code lost:
    
        if (r3 >= (-8.34465E-7f)) goto L6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x000d, code lost:
    
        r3 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x000f, code lost:
    
        r3 = Float.NaN;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final int g(float f5, float[] fArr, int i5) {
        float f6 = 0.0f;
        if (f5 >= 0.0f) {
            f6 = 1.0f;
            if (f5 > 1.0f) {
            }
        }
        fArr[i5] = f5;
        return !Float.isNaN(f5) ? 1 : 0;
    }
}
