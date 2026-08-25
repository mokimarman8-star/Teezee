package com.google.protobuf;

import com.google.protobuf.Utf8;
import java.nio.ByteBuffer;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
final class Utf8$c extends Utf8$b {
    Utf8$c() {
    }

    private static int partialIsValidUtf8(byte[] bArr, int i, int i2) {
        while (i < i2 && bArr[i] >= 0) {
            i++;
        }
        if (i >= i2) {
            return 0;
        }
        return partialIsValidUtf8NonAscii(bArr, i, i2);
    }

    private static int partialIsValidUtf8NonAscii(byte[] bArr, int i, int i2) {
        while (i < i2) {
            int i3 = i + 1;
            byte b = bArr[i];
            if (b < 0) {
                if (b < -32) {
                    if (i3 >= i2) {
                        return b;
                    }
                    if (b >= -62) {
                        i += 2;
                        if (bArr[i3] > -65) {
                        }
                    }
                    return -1;
                }
                if (b >= -16) {
                    if (i3 >= i2 - 2) {
                        return Utf8.access$1100(bArr, i3, i2);
                    }
                    int i4 = i + 2;
                    byte b2 = bArr[i3];
                    if (b2 <= -65 && (((b << 28) + (b2 + 112)) >> 30) == 0) {
                        int i5 = i + 3;
                        if (bArr[i4] <= -65) {
                            i += 4;
                            if (bArr[i5] > -65) {
                            }
                        }
                    }
                    return -1;
                }
                if (i3 >= i2 - 1) {
                    return Utf8.access$1100(bArr, i3, i2);
                }
                int i6 = i + 2;
                byte b3 = bArr[i3];
                if (b3 <= -65 && ((b != -32 || b3 >= -96) && (b != -19 || b3 < -96))) {
                    i += 3;
                    if (bArr[i6] > -65) {
                    }
                }
                return -1;
            }
            i = i3;
        }
        return 0;
    }

    @Override // com.google.protobuf.Utf8$b
    String decodeUtf8(byte[] bArr, int i, int i2) throws InvalidProtocolBufferException {
        boolean isOneByte;
        boolean isOneByte2;
        boolean isTwoBytes;
        boolean isThreeBytes;
        boolean isOneByte3;
        if ((i | i2 | ((bArr.length - i) - i2)) < 0) {
            throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", Integer.valueOf(bArr.length), Integer.valueOf(i), Integer.valueOf(i2)));
        }
        int i3 = i + i2;
        char[] cArr = new char[i2];
        int i4 = 0;
        while (i < i3) {
            byte b = bArr[i];
            isOneByte3 = Utf8$a.isOneByte(b);
            if (!isOneByte3) {
                break;
            }
            i++;
            Utf8$a.handleOneByte(b, cArr, i4);
            i4++;
        }
        int i5 = i4;
        while (i < i3) {
            int i6 = i + 1;
            byte b2 = bArr[i];
            isOneByte = Utf8$a.isOneByte(b2);
            if (isOneByte) {
                int i7 = i5 + 1;
                Utf8$a.handleOneByte(b2, cArr, i5);
                while (i6 < i3) {
                    byte b3 = bArr[i6];
                    isOneByte2 = Utf8$a.isOneByte(b3);
                    if (!isOneByte2) {
                        break;
                    }
                    i6++;
                    Utf8$a.handleOneByte(b3, cArr, i7);
                    i7++;
                }
                i5 = i7;
                i = i6;
            } else {
                isTwoBytes = Utf8$a.isTwoBytes(b2);
                if (!isTwoBytes) {
                    isThreeBytes = Utf8$a.isThreeBytes(b2);
                    if (isThreeBytes) {
                        if (i6 >= i3 - 1) {
                            throw InvalidProtocolBufferException.invalidUtf8();
                        }
                        int i8 = i + 2;
                        i += 3;
                        Utf8$a.handleThreeBytes(b2, bArr[i6], bArr[i8], cArr, i5);
                        i5++;
                    } else {
                        if (i6 >= i3 - 2) {
                            throw InvalidProtocolBufferException.invalidUtf8();
                        }
                        byte b4 = bArr[i6];
                        int i9 = i + 3;
                        byte b5 = bArr[i + 2];
                        i += 4;
                        Utf8$a.handleFourBytes(b2, b4, b5, bArr[i9], cArr, i5);
                        i5 += 2;
                    }
                } else {
                    if (i6 >= i3) {
                        throw InvalidProtocolBufferException.invalidUtf8();
                    }
                    i += 2;
                    Utf8$a.handleTwoBytes(b2, bArr[i6], cArr, i5);
                    i5++;
                }
            }
        }
        return new String(cArr, 0, i5);
    }

    @Override // com.google.protobuf.Utf8$b
    String decodeUtf8Direct(ByteBuffer byteBuffer, int i, int i2) throws InvalidProtocolBufferException {
        return decodeUtf8Default(byteBuffer, i, i2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x001d, code lost:
    
        return r10 + r0;
     */
    @Override // com.google.protobuf.Utf8$b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    int encodeUtf8(CharSequence charSequence, byte[] bArr, int i, int i2) {
        int i3;
        int i4;
        char charAt;
        int length = charSequence.length();
        int i5 = i2 + i;
        int i6 = 0;
        while (i6 < length && (i4 = i6 + i) < i5 && (charAt = charSequence.charAt(i6)) < 128) {
            bArr[i4] = (byte) charAt;
            i6++;
        }
        int i7 = i + i6;
        while (i6 < length) {
            char charAt2 = charSequence.charAt(i6);
            if (charAt2 < 128 && i7 < i5) {
                bArr[i7] = (byte) charAt2;
                i7++;
            } else if (charAt2 < 2048 && i7 <= i5 - 2) {
                int i8 = i7 + 1;
                bArr[i7] = (byte) ((charAt2 >>> 6) | 960);
                i7 += 2;
                bArr[i8] = (byte) ((charAt2 & '?') | 128);
            } else {
                if ((charAt2 >= 55296 && 57343 >= charAt2) || i7 > i5 - 3) {
                    if (i7 > i5 - 4) {
                        if (55296 <= charAt2 && charAt2 <= 57343 && ((i3 = i6 + 1) == charSequence.length() || !Character.isSurrogatePair(charAt2, charSequence.charAt(i3)))) {
                            throw new Utf8.UnpairedSurrogateException(i6, length);
                        }
                        throw new ArrayIndexOutOfBoundsException("Failed writing " + charAt2 + " at index " + i7);
                    }
                    int i9 = i6 + 1;
                    if (i9 != charSequence.length()) {
                        char charAt3 = charSequence.charAt(i9);
                        if (Character.isSurrogatePair(charAt2, charAt3)) {
                            int codePoint = Character.toCodePoint(charAt2, charAt3);
                            bArr[i7] = (byte) ((codePoint >>> 18) | 240);
                            bArr[i7 + 1] = (byte) (((codePoint >>> 12) & 63) | 128);
                            int i10 = i7 + 3;
                            bArr[i7 + 2] = (byte) (((codePoint >>> 6) & 63) | 128);
                            i7 += 4;
                            bArr[i10] = (byte) ((codePoint & 63) | 128);
                            i6 = i9;
                        } else {
                            i6 = i9;
                        }
                    }
                    throw new Utf8.UnpairedSurrogateException(i6 - 1, length);
                }
                bArr[i7] = (byte) ((charAt2 >>> '\f') | 480);
                int i11 = i7 + 2;
                bArr[i7 + 1] = (byte) (((charAt2 >>> 6) & 63) | 128);
                i7 += 3;
                bArr[i11] = (byte) ((charAt2 & '?') | 128);
            }
            i6++;
        }
        return i7;
    }

    @Override // com.google.protobuf.Utf8$b
    void encodeUtf8Direct(CharSequence charSequence, ByteBuffer byteBuffer) {
        encodeUtf8Default(charSequence, byteBuffer);
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0015, code lost:
    
        if (r8[r9] > (-65)) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0046, code lost:
    
        if (r8[r9] > (-65)) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0083, code lost:
    
        if (r8[r7] > (-65)) goto L53;
     */
    @Override // com.google.protobuf.Utf8$b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    int partialIsValidUtf8(int i, byte[] bArr, int i2, int i3) {
        byte b;
        int i4;
        int i5;
        if (i != 0) {
            if (i2 >= i3) {
                return i;
            }
            byte b2 = (byte) i;
            if (b2 < -32) {
                if (b2 >= -62) {
                    i5 = i2 + 1;
                }
                return -1;
            }
            if (b2 < -16) {
                byte b3 = (byte) (~(i >> 8));
                if (b3 == 0) {
                    int i6 = i2 + 1;
                    byte b4 = bArr[i2];
                    if (i6 >= i3) {
                        return Utf8.access$000(b2, b4);
                    }
                    i2 = i6;
                    b3 = b4;
                }
                if (b3 <= -65 && ((b2 != -32 || b3 >= -96) && (b2 != -19 || b3 < -96))) {
                    i5 = i2 + 1;
                }
                return -1;
            }
            byte b5 = (byte) (~(i >> 8));
            if (b5 == 0) {
                i4 = i2 + 1;
                b5 = bArr[i2];
                if (i4 >= i3) {
                    return Utf8.access$000(b2, b5);
                }
                b = 0;
            } else {
                b = (byte) (i >> 16);
                i4 = i2;
            }
            if (b == 0) {
                int i7 = i4 + 1;
                byte b6 = bArr[i4];
                if (i7 >= i3) {
                    return Utf8.access$100(b2, b5, b6);
                }
                b = b6;
                i4 = i7;
            }
            if (b5 <= -65 && (((b2 << 28) + (b5 + 112)) >> 30) == 0 && b <= -65) {
                i2 = i4 + 1;
            }
            return -1;
            i2 = i5;
        }
        return partialIsValidUtf8(bArr, i2, i3);
    }

    @Override // com.google.protobuf.Utf8$b
    int partialIsValidUtf8Direct(int i, ByteBuffer byteBuffer, int i2, int i3) {
        return partialIsValidUtf8Default(i, byteBuffer, i2, i3);
    }
}
