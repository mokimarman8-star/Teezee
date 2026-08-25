package okio.internal;

import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import okhttp3.HttpUrl;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0012\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\u001e\u0010\u0003\u001a\u00020\u0002*\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005¨\u0006\u0007"}, d2 = {"commonAsUtf8ToByteArray", HttpUrl.FRAGMENT_ENCODE_SET, HttpUrl.FRAGMENT_ENCODE_SET, "commonToUtf8String", "beginIndex", HttpUrl.FRAGMENT_ENCODE_SET, "endIndex", "okio"}, k = 2, mv = {1, 9, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class _Utf8Kt {
    public static final byte[] commonAsUtf8ToByteArray(String str) {
        int i;
        char charAt;
        Intrinsics.h(str, "<this>");
        byte[] bArr = new byte[str.length() * 4];
        int length = str.length();
        int i2 = 0;
        while (i2 < length) {
            char charAt2 = str.charAt(i2);
            if (Intrinsics.j(charAt2, 128) >= 0) {
                int length2 = str.length();
                int i3 = i2;
                while (i2 < length2) {
                    char charAt3 = str.charAt(i2);
                    if (Intrinsics.j(charAt3, 128) < 0) {
                        int i4 = i3 + 1;
                        bArr[i3] = (byte) charAt3;
                        i2++;
                        while (true) {
                            i3 = i4;
                            if (i2 < length2 && Intrinsics.j(str.charAt(i2), 128) < 0) {
                                i4 = i3 + 1;
                                bArr[i3] = (byte) str.charAt(i2);
                                i2++;
                            }
                        }
                    } else {
                        if (Intrinsics.j(charAt3, 2048) < 0) {
                            bArr[i3] = (byte) ((charAt3 >> 6) | 192);
                            i3 += 2;
                            bArr[i3 + 1] = (byte) ((charAt3 & '?') | 128);
                        } else if (55296 > charAt3 || charAt3 >= 57344) {
                            bArr[i3] = (byte) ((charAt3 >> '\f') | 224);
                            bArr[i3 + 1] = (byte) (((charAt3 >> 6) & 63) | 128);
                            i3 += 3;
                            bArr[i3 + 2] = (byte) ((charAt3 & '?') | 128);
                        } else if (Intrinsics.j(charAt3, 56319) > 0 || length2 <= (i = i2 + 1) || 56320 > (charAt = str.charAt(i)) || charAt >= 57344) {
                            bArr[i3] = 63;
                            i2++;
                            i3++;
                        } else {
                            int charAt4 = ((charAt3 << '\n') + str.charAt(i)) - 56613888;
                            bArr[i3] = (byte) ((charAt4 >> 18) | 240);
                            bArr[i3 + 1] = (byte) (((charAt4 >> 12) & 63) | 128);
                            bArr[i3 + 2] = (byte) (((charAt4 >> 6) & 63) | 128);
                            i3 += 4;
                            bArr[i3 + 3] = (byte) ((charAt4 & 63) | 128);
                            i2 += 2;
                        }
                        i2++;
                    }
                }
                byte[] copyOf = Arrays.copyOf(bArr, i3);
                Intrinsics.g(copyOf, "copyOf(this, newSize)");
                return copyOf;
            }
            bArr[i2] = (byte) charAt2;
            i2++;
        }
        byte[] copyOf2 = Arrays.copyOf(bArr, str.length());
        Intrinsics.g(copyOf2, "copyOf(this, newSize)");
        return copyOf2;
    }

    public static final String commonToUtf8String(byte[] bArr, int i, int i2) {
        byte b;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9 = i;
        int i10 = 3;
        Intrinsics.h(bArr, "<this>");
        if (i9 < 0 || i2 > bArr.length || i9 > i2) {
            throw new ArrayIndexOutOfBoundsException("size=" + bArr.length + " beginIndex=" + i9 + " endIndex=" + i2);
        }
        char[] cArr = new char[i2 - i9];
        int i11 = 0;
        while (i9 < i2) {
            byte b2 = bArr[i9];
            if (b2 >= 0) {
                int i12 = i11 + 1;
                cArr[i11] = (char) b2;
                i9++;
                while (true) {
                    i11 = i12;
                    if (i9 < i2 && (b = bArr[i9]) >= 0) {
                        i9++;
                        i12 = i11 + 1;
                        cArr[i11] = (char) b;
                    }
                }
            } else if ((b2 >> 5) == -2) {
                int i13 = i9 + 1;
                if (i2 <= i13) {
                    i3 = i11 + 1;
                    cArr[i11] = (char) 65533;
                } else {
                    byte b3 = bArr[i13];
                    if ((b3 & 192) == 128) {
                        int i14 = (b2 << 6) ^ (b3 ^ 3968);
                        if (i14 < 128) {
                            i3 = i11 + 1;
                            cArr[i11] = (char) 65533;
                        } else {
                            i3 = i11 + 1;
                            cArr[i11] = (char) i14;
                        }
                        Unit unit = Unit.a;
                        i4 = 2;
                        i11 = i3;
                        i9 += i4;
                    } else {
                        i3 = i11 + 1;
                        cArr[i11] = (char) 65533;
                    }
                }
                Unit unit2 = Unit.a;
                i4 = 1;
                i11 = i3;
                i9 += i4;
            } else if ((b2 >> 4) == -2) {
                int i15 = i9 + 2;
                if (i2 <= i15) {
                    int i16 = i11 + 1;
                    cArr[i11] = (char) 65533;
                    Unit unit3 = Unit.a;
                    int i17 = i9 + 1;
                    i6 = (i2 <= i17 || (bArr[i17] & 192) != 128) ? 1 : 2;
                    i11 = i16;
                } else {
                    byte b4 = bArr[i9 + 1];
                    if ((b4 & 192) == 128) {
                        byte b5 = bArr[i15];
                        if ((b5 & 192) == 128) {
                            int i18 = ((b5 ^ (-123008)) ^ (b4 << 6)) ^ (b2 << 12);
                            if (i18 < 2048) {
                                i5 = i11 + 1;
                                cArr[i11] = (char) 65533;
                            } else if (55296 > i18 || i18 >= 57344) {
                                char c = (char) i18;
                                i5 = i11 + 1;
                                cArr[i11] = c;
                            } else {
                                i5 = i11 + 1;
                                cArr[i11] = (char) 65533;
                            }
                            Unit unit4 = Unit.a;
                            i6 = i10;
                        } else {
                            i5 = i11 + 1;
                            cArr[i11] = (char) 65533;
                            Unit unit5 = Unit.a;
                            i6 = 2;
                        }
                    } else {
                        i5 = i11 + 1;
                        cArr[i11] = (char) 65533;
                        Unit unit6 = Unit.a;
                        i6 = 1;
                    }
                    i11 = i5;
                }
                i9 += i6;
            } else {
                if ((b2 >> 3) == -2) {
                    int i19 = i9 + 3;
                    if (i2 <= i19) {
                        i7 = i11 + 1;
                        cArr[i11] = 65533;
                        Unit unit7 = Unit.a;
                        int i20 = i9 + 1;
                        if (i2 > i20 && (bArr[i20] & 192) == 128) {
                            int i21 = i9 + 2;
                            if (i2 > i21 && (bArr[i21] & 192) == 128) {
                                i11 = i7;
                                i9 += i10;
                            }
                            i11 = i7;
                            i10 = 2;
                            i9 += i10;
                        }
                        i11 = i7;
                        i10 = 1;
                        i9 += i10;
                    } else {
                        byte b6 = bArr[i9 + 1];
                        if ((b6 & 192) == 128) {
                            byte b7 = bArr[i9 + 2];
                            if ((b7 & 192) == 128) {
                                byte b8 = bArr[i19];
                                if ((b8 & 192) == 128) {
                                    int i22 = (((b8 ^ 3678080) ^ (b7 << 6)) ^ (b6 << 12)) ^ (b2 << 18);
                                    if (i22 > 1114111) {
                                        i8 = i11 + 1;
                                        cArr[i11] = 65533;
                                    } else if (55296 <= i22 && i22 < 57344) {
                                        i8 = i11 + 1;
                                        cArr[i11] = 65533;
                                    } else if (i22 < 65536) {
                                        i8 = i11 + 1;
                                        cArr[i11] = 65533;
                                    } else if (i22 != 65533) {
                                        cArr[i11] = (char) ((i22 >>> 10) + 55232);
                                        cArr[i11 + 1] = (char) ((i22 & 1023) + 56320);
                                        i8 = i11 + 2;
                                    } else {
                                        i8 = i11 + 1;
                                        cArr[i11] = 65533;
                                    }
                                    Unit unit8 = Unit.a;
                                    i11 = i8;
                                    i10 = 4;
                                } else {
                                    cArr[i11] = 65533;
                                    Unit unit9 = Unit.a;
                                    i11++;
                                    i10 = 3;
                                }
                                i9 += i10;
                            } else {
                                i7 = i11 + 1;
                                cArr[i11] = 65533;
                                Unit unit10 = Unit.a;
                                i11 = i7;
                                i10 = 2;
                                i9 += i10;
                            }
                        } else {
                            i7 = i11 + 1;
                            cArr[i11] = 65533;
                            Unit unit11 = Unit.a;
                            i11 = i7;
                            i10 = 1;
                            i9 += i10;
                        }
                    }
                } else {
                    cArr[i11] = 65533;
                    i9++;
                    i11++;
                }
                i10 = 3;
            }
        }
        return StringsKt.C(cArr, 0, i11);
    }

    public static /* synthetic */ String commonToUtf8String$default(byte[] bArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = bArr.length;
        }
        return commonToUtf8String(bArr, i, i2);
    }
}
