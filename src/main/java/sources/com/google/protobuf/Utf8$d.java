package com.google.protobuf;

import com.google.protobuf.Utf8;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Arrays;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
final class Utf8$d extends Utf8$b {
    Utf8$d() {
    }

    static boolean isAvailable() {
        return s1.hasUnsafeArrayOperations() && s1.hasUnsafeByteBufferOperations();
    }

    /* JADX WARN: Code restructure failed: missing block: B:69:0x0039, code lost:
    
        return -1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static int partialIsValidUtf8(long j, int i) {
        int unsafeEstimateConsecutiveAscii = unsafeEstimateConsecutiveAscii(j, i);
        long j2 = j + unsafeEstimateConsecutiveAscii;
        int i2 = i - unsafeEstimateConsecutiveAscii;
        while (true) {
            byte b = 0;
            while (true) {
                if (i2 <= 0) {
                    break;
                }
                long j3 = j2 + 1;
                b = s1.getByte(j2);
                if (b < 0) {
                    j2 = j3;
                    break;
                }
                i2--;
                j2 = j3;
            }
            if (i2 != 0) {
                int i3 = i2 - 1;
                if (b >= -32) {
                    if (b >= -16) {
                        if (i3 >= 3) {
                            i2 -= 4;
                            long j4 = 1 + j2;
                            byte b2 = s1.getByte(j2);
                            if (b2 > -65 || (((b << 28) + (b2 + 112)) >> 30) != 0) {
                                break;
                            }
                            long j5 = 2 + j2;
                            if (s1.getByte(j4) > -65) {
                                break;
                            }
                            j2 += 3;
                            if (s1.getByte(j5) > -65) {
                                break;
                            }
                        } else {
                            return unsafeIncompleteStateFor(j2, b, i3);
                        }
                    } else if (i3 >= 2) {
                        i2 -= 3;
                        long j6 = 1 + j2;
                        byte b3 = s1.getByte(j2);
                        if (b3 > -65 || ((b == -32 && b3 < -96) || (b == -19 && b3 >= -96))) {
                            break;
                        }
                        j2 += 2;
                        if (s1.getByte(j6) > -65) {
                            break;
                        }
                    } else {
                        return unsafeIncompleteStateFor(j2, b, i3);
                    }
                } else if (i3 != 0) {
                    i2 -= 2;
                    if (b < -62) {
                        break;
                    }
                    long j7 = 1 + j2;
                    if (s1.getByte(j2) > -65) {
                        break;
                    }
                    j2 = j7;
                } else {
                    return b;
                }
            } else {
                return 0;
            }
        }
        return -1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:69:0x0039, code lost:
    
        return -1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static int partialIsValidUtf8(byte[] bArr, long j, int i) {
        int unsafeEstimateConsecutiveAscii = unsafeEstimateConsecutiveAscii(bArr, j, i);
        int i2 = i - unsafeEstimateConsecutiveAscii;
        long j2 = j + unsafeEstimateConsecutiveAscii;
        while (true) {
            byte b = 0;
            while (true) {
                if (i2 <= 0) {
                    break;
                }
                long j3 = j2 + 1;
                b = s1.getByte(bArr, j2);
                if (b < 0) {
                    j2 = j3;
                    break;
                }
                i2--;
                j2 = j3;
            }
            if (i2 != 0) {
                int i3 = i2 - 1;
                if (b >= -32) {
                    if (b >= -16) {
                        if (i3 >= 3) {
                            i2 -= 4;
                            long j4 = 1 + j2;
                            byte b2 = s1.getByte(bArr, j2);
                            if (b2 > -65 || (((b << 28) + (b2 + 112)) >> 30) != 0) {
                                break;
                            }
                            long j5 = 2 + j2;
                            if (s1.getByte(bArr, j4) > -65) {
                                break;
                            }
                            j2 += 3;
                            if (s1.getByte(bArr, j5) > -65) {
                                break;
                            }
                        } else {
                            return unsafeIncompleteStateFor(bArr, b, j2, i3);
                        }
                    } else if (i3 >= 2) {
                        i2 -= 3;
                        long j6 = 1 + j2;
                        byte b3 = s1.getByte(bArr, j2);
                        if (b3 > -65 || ((b == -32 && b3 < -96) || (b == -19 && b3 >= -96))) {
                            break;
                        }
                        j2 += 2;
                        if (s1.getByte(bArr, j6) > -65) {
                            break;
                        }
                    } else {
                        return unsafeIncompleteStateFor(bArr, b, j2, i3);
                    }
                } else if (i3 != 0) {
                    i2 -= 2;
                    if (b < -62) {
                        break;
                    }
                    long j7 = 1 + j2;
                    if (s1.getByte(bArr, j2) > -65) {
                        break;
                    }
                    j2 = j7;
                } else {
                    return b;
                }
            } else {
                return 0;
            }
        }
        return -1;
    }

    private static int unsafeEstimateConsecutiveAscii(long j, int i) {
        if (i < 16) {
            return 0;
        }
        int i2 = (int) ((-j) & 7);
        int i3 = i2;
        while (i3 > 0) {
            long j2 = 1 + j;
            if (s1.getByte(j) < 0) {
                return i2 - i3;
            }
            i3--;
            j = j2;
        }
        int i4 = i - i2;
        while (i4 >= 8 && (s1.getLong(j) & (-9187201950435737472L)) == 0) {
            j += 8;
            i4 -= 8;
        }
        return i - i4;
    }

    private static int unsafeEstimateConsecutiveAscii(byte[] bArr, long j, int i) {
        int i2 = 0;
        if (i < 16) {
            return 0;
        }
        int i3 = 8 - (((int) j) & 7);
        while (i2 < i3) {
            long j2 = 1 + j;
            if (s1.getByte(bArr, j) < 0) {
                return i2;
            }
            i2++;
            j = j2;
        }
        while (true) {
            int i4 = i2 + 8;
            if (i4 > i || (s1.getLong((Object) bArr, s1.BYTE_ARRAY_BASE_OFFSET + j) & (-9187201950435737472L)) != 0) {
                break;
            }
            j += 8;
            i2 = i4;
        }
        while (i2 < i) {
            long j3 = j + 1;
            if (s1.getByte(bArr, j) < 0) {
                return i2;
            }
            i2++;
            j = j3;
        }
        return i;
    }

    private static int unsafeIncompleteStateFor(long j, int i, int i2) {
        if (i2 == 0) {
            return Utf8.access$1200(i);
        }
        if (i2 == 1) {
            return Utf8.access$000(i, s1.getByte(j));
        }
        if (i2 == 2) {
            return Utf8.access$100(i, s1.getByte(j), s1.getByte(j + 1));
        }
        throw new AssertionError();
    }

    private static int unsafeIncompleteStateFor(byte[] bArr, int i, long j, int i2) {
        if (i2 == 0) {
            return Utf8.access$1200(i);
        }
        if (i2 == 1) {
            return Utf8.access$000(i, s1.getByte(bArr, j));
        }
        if (i2 == 2) {
            return Utf8.access$100(i, s1.getByte(bArr, j), s1.getByte(bArr, j + 1));
        }
        throw new AssertionError();
    }

    @Override // com.google.protobuf.Utf8$b
    String decodeUtf8(byte[] bArr, int i, int i2) throws InvalidProtocolBufferException {
        Charset charset = y.UTF_8;
        String str = new String(bArr, i, i2, charset);
        if (str.contains("�") && !Arrays.equals(str.getBytes(charset), Arrays.copyOfRange(bArr, i, i2 + i))) {
            throw InvalidProtocolBufferException.invalidUtf8();
        }
        return str;
    }

    @Override // com.google.protobuf.Utf8$b
    String decodeUtf8Direct(ByteBuffer byteBuffer, int i, int i2) throws InvalidProtocolBufferException {
        boolean isOneByte;
        boolean isOneByte2;
        boolean isTwoBytes;
        boolean isThreeBytes;
        boolean isOneByte3;
        if ((i | i2 | ((byteBuffer.limit() - i) - i2)) < 0) {
            throw new ArrayIndexOutOfBoundsException(String.format("buffer limit=%d, index=%d, limit=%d", Integer.valueOf(byteBuffer.limit()), Integer.valueOf(i), Integer.valueOf(i2)));
        }
        long addressOffset = s1.addressOffset(byteBuffer) + i;
        long j = i2 + addressOffset;
        char[] cArr = new char[i2];
        int i3 = 0;
        while (addressOffset < j) {
            byte b = s1.getByte(addressOffset);
            isOneByte3 = Utf8$a.isOneByte(b);
            if (!isOneByte3) {
                break;
            }
            addressOffset++;
            Utf8$a.handleOneByte(b, cArr, i3);
            i3++;
        }
        while (addressOffset < j) {
            long j2 = addressOffset + 1;
            byte b2 = s1.getByte(addressOffset);
            isOneByte = Utf8$a.isOneByte(b2);
            if (isOneByte) {
                int i4 = i3 + 1;
                Utf8$a.handleOneByte(b2, cArr, i3);
                while (j2 < j) {
                    byte b3 = s1.getByte(j2);
                    isOneByte2 = Utf8$a.isOneByte(b3);
                    if (!isOneByte2) {
                        break;
                    }
                    j2++;
                    Utf8$a.handleOneByte(b3, cArr, i4);
                    i4++;
                }
                i3 = i4;
                addressOffset = j2;
            } else {
                isTwoBytes = Utf8$a.isTwoBytes(b2);
                if (!isTwoBytes) {
                    isThreeBytes = Utf8$a.isThreeBytes(b2);
                    if (isThreeBytes) {
                        if (j2 >= j - 1) {
                            throw InvalidProtocolBufferException.invalidUtf8();
                        }
                        long j3 = 2 + addressOffset;
                        addressOffset += 3;
                        Utf8$a.handleThreeBytes(b2, s1.getByte(j2), s1.getByte(j3), cArr, i3);
                        i3++;
                    } else {
                        if (j2 >= j - 2) {
                            throw InvalidProtocolBufferException.invalidUtf8();
                        }
                        byte b4 = s1.getByte(j2);
                        long j4 = addressOffset + 3;
                        byte b5 = s1.getByte(2 + addressOffset);
                        addressOffset += 4;
                        Utf8$a.handleFourBytes(b2, b4, b5, s1.getByte(j4), cArr, i3);
                        i3 += 2;
                    }
                } else {
                    if (j2 >= j) {
                        throw InvalidProtocolBufferException.invalidUtf8();
                    }
                    addressOffset += 2;
                    Utf8$a.handleTwoBytes(b2, s1.getByte(j2), cArr, i3);
                    i3++;
                }
            }
        }
        return new String(cArr, 0, i3);
    }

    @Override // com.google.protobuf.Utf8$b
    int encodeUtf8(CharSequence charSequence, byte[] bArr, int i, int i2) {
        long j;
        String str;
        String str2;
        int i3;
        long j2;
        long j3;
        char charAt;
        long j4 = i;
        long j5 = i2 + j4;
        int length = charSequence.length();
        String str3 = " at index ";
        String str4 = "Failed writing ";
        if (length > i2 || bArr.length - i2 < i) {
            throw new ArrayIndexOutOfBoundsException("Failed writing " + charSequence.charAt(length - 1) + " at index " + (i + i2));
        }
        int i4 = 0;
        while (true) {
            j = 1;
            if (i4 >= length || (charAt = charSequence.charAt(i4)) >= 128) {
                break;
            }
            s1.putByte(bArr, j4, (byte) charAt);
            i4++;
            j4 = 1 + j4;
        }
        if (i4 == length) {
            return (int) j4;
        }
        while (i4 < length) {
            char charAt2 = charSequence.charAt(i4);
            if (charAt2 >= 128 || j4 >= j5) {
                if (charAt2 >= 2048 || j4 > j5 - 2) {
                    str = str3;
                    str2 = str4;
                    if ((charAt2 >= 55296 && 57343 >= charAt2) || j4 > j5 - 3) {
                        if (j4 > j5 - 4) {
                            if (55296 <= charAt2 && charAt2 <= 57343 && ((i3 = i4 + 1) == length || !Character.isSurrogatePair(charAt2, charSequence.charAt(i3)))) {
                                throw new Utf8.UnpairedSurrogateException(i4, length);
                            }
                            throw new ArrayIndexOutOfBoundsException(str2 + charAt2 + str + j4);
                        }
                        int i5 = i4 + 1;
                        if (i5 != length) {
                            char charAt3 = charSequence.charAt(i5);
                            if (Character.isSurrogatePair(charAt2, charAt3)) {
                                int codePoint = Character.toCodePoint(charAt2, charAt3);
                                j2 = 1;
                                s1.putByte(bArr, j4, (byte) ((codePoint >>> 18) | 240));
                                j3 = j5;
                                s1.putByte(bArr, j4 + 1, (byte) (((codePoint >>> 12) & 63) | 128));
                                long j6 = j4 + 3;
                                s1.putByte(bArr, j4 + 2, (byte) (((codePoint >>> 6) & 63) | 128));
                                j4 += 4;
                                s1.putByte(bArr, j6, (byte) ((codePoint & 63) | 128));
                                i4 = i5;
                            } else {
                                i4 = i5;
                            }
                        }
                        throw new Utf8.UnpairedSurrogateException(i4 - 1, length);
                    }
                    s1.putByte(bArr, j4, (byte) ((charAt2 >>> '\f') | 480));
                    long j7 = j4 + 2;
                    s1.putByte(bArr, j4 + 1, (byte) (((charAt2 >>> 6) & 63) | 128));
                    j4 += 3;
                    s1.putByte(bArr, j7, (byte) ((charAt2 & '?') | 128));
                } else {
                    str = str3;
                    str2 = str4;
                    long j8 = j4 + j;
                    s1.putByte(bArr, j4, (byte) ((charAt2 >>> 6) | 960));
                    j4 += 2;
                    s1.putByte(bArr, j8, (byte) ((charAt2 & '?') | 128));
                }
                j3 = j5;
                j2 = 1;
            } else {
                s1.putByte(bArr, j4, (byte) charAt2);
                j3 = j5;
                str2 = str4;
                j2 = j;
                j4 += j;
                str = str3;
            }
            i4++;
            str3 = str;
            str4 = str2;
            j = j2;
            j5 = j3;
        }
        return (int) j4;
    }

    @Override // com.google.protobuf.Utf8$b
    void encodeUtf8Direct(CharSequence charSequence, ByteBuffer byteBuffer) {
        long j;
        char c;
        long j2;
        int i;
        int i2;
        char c2;
        char charAt;
        long addressOffset = s1.addressOffset(byteBuffer);
        long position = byteBuffer.position() + addressOffset;
        long limit = byteBuffer.limit() + addressOffset;
        int length = charSequence.length();
        if (length > limit - position) {
            throw new ArrayIndexOutOfBoundsException("Failed writing " + charSequence.charAt(length - 1) + " at index " + byteBuffer.limit());
        }
        int i3 = 0;
        while (true) {
            j = 1;
            c = 128;
            if (i3 >= length || (charAt = charSequence.charAt(i3)) >= 128) {
                break;
            }
            s1.putByte(position, (byte) charAt);
            i3++;
            position = 1 + position;
        }
        if (i3 == length) {
            e0.position(byteBuffer, (int) (position - addressOffset));
            return;
        }
        while (i3 < length) {
            char charAt2 = charSequence.charAt(i3);
            if (charAt2 >= c || position >= limit) {
                if (charAt2 >= 2048 || position > limit - 2) {
                    j2 = addressOffset;
                    if ((charAt2 >= 55296 && 57343 >= charAt2) || position > limit - 3) {
                        if (position > limit - 4) {
                            if (55296 <= charAt2 && charAt2 <= 57343 && ((i = i3 + 1) == length || !Character.isSurrogatePair(charAt2, charSequence.charAt(i)))) {
                                throw new Utf8.UnpairedSurrogateException(i3, length);
                            }
                            throw new ArrayIndexOutOfBoundsException("Failed writing " + charAt2 + " at index " + position);
                        }
                        i2 = i3 + 1;
                        if (i2 != length) {
                            char charAt3 = charSequence.charAt(i2);
                            if (Character.isSurrogatePair(charAt2, charAt3)) {
                                int codePoint = Character.toCodePoint(charAt2, charAt3);
                                s1.putByte(position, (byte) ((codePoint >>> 18) | 240));
                                c2 = 128;
                                s1.putByte(position + 1, (byte) (((codePoint >>> 12) & 63) | 128));
                                long j3 = position + 3;
                                s1.putByte(position + 2, (byte) (((codePoint >>> 6) & 63) | 128));
                                position += 4;
                                s1.putByte(j3, (byte) ((codePoint & 63) | 128));
                            } else {
                                i3 = i2;
                            }
                        }
                        throw new Utf8.UnpairedSurrogateException(i3 - 1, length);
                    }
                    long j4 = position + j;
                    s1.putByte(position, (byte) ((charAt2 >>> '\f') | 480));
                    long j5 = position + 2;
                    s1.putByte(j4, (byte) (((charAt2 >>> 6) & 63) | 128));
                    position += 3;
                    s1.putByte(j5, (byte) ((charAt2 & '?') | 128));
                } else {
                    j2 = addressOffset;
                    long j6 = position + j;
                    s1.putByte(position, (byte) ((charAt2 >>> 6) | 960));
                    position += 2;
                    s1.putByte(j6, (byte) ((charAt2 & '?') | 128));
                }
                i2 = i3;
                c2 = 128;
            } else {
                s1.putByte(position, (byte) charAt2);
                j2 = addressOffset;
                i2 = i3;
                c2 = c;
                position += j;
            }
            c = c2;
            addressOffset = j2;
            j = 1;
            i3 = i2 + 1;
        }
        e0.position(byteBuffer, (int) (position - addressOffset));
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x0059, code lost:
    
        if (com.google.protobuf.s1.getByte(r13, r1) > (-65)) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x009e, code lost:
    
        if (com.google.protobuf.s1.getByte(r13, r1) > (-65)) goto L59;
     */
    @Override // com.google.protobuf.Utf8$b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    int partialIsValidUtf8(int i, byte[] bArr, int i2, int i3) {
        long j;
        byte b = 0;
        if ((i2 | i3 | (bArr.length - i3)) < 0) {
            throw new ArrayIndexOutOfBoundsException(String.format("Array length=%d, index=%d, limit=%d", Integer.valueOf(bArr.length), Integer.valueOf(i2), Integer.valueOf(i3)));
        }
        long j2 = i2;
        long j3 = i3;
        if (i != 0) {
            if (j2 >= j3) {
                return i;
            }
            byte b2 = (byte) i;
            if (b2 < -32) {
                if (b2 >= -62) {
                    long j4 = 1 + j2;
                    if (s1.getByte(bArr, j2) <= -65) {
                        j2 = j4;
                    }
                }
                return -1;
            }
            if (b2 < -16) {
                byte b3 = (byte) (~(i >> 8));
                if (b3 == 0) {
                    long j5 = j2 + 1;
                    b3 = s1.getByte(bArr, j2);
                    if (j5 >= j3) {
                        return Utf8.access$000(b2, b3);
                    }
                    j2 = j5;
                }
                if (b3 <= -65 && ((b2 != -32 || b3 >= -96) && (b2 != -19 || b3 < -96))) {
                    j = j2 + 1;
                }
                return -1;
            }
            byte b4 = (byte) (~(i >> 8));
            if (b4 == 0) {
                long j6 = j2 + 1;
                b4 = s1.getByte(bArr, j2);
                if (j6 >= j3) {
                    return Utf8.access$000(b2, b4);
                }
                j2 = j6;
            } else {
                b = (byte) (i >> 16);
            }
            if (b == 0) {
                long j7 = j2 + 1;
                b = s1.getByte(bArr, j2);
                if (j7 >= j3) {
                    return Utf8.access$100(b2, b4, b);
                }
                j2 = j7;
            }
            if (b4 <= -65 && (((b2 << 28) + (b4 + 112)) >> 30) == 0 && b <= -65) {
                j = j2 + 1;
            }
            return -1;
            j2 = j;
        }
        return partialIsValidUtf8(bArr, j2, (int) (j3 - j2));
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x002e, code lost:
    
        if (com.google.protobuf.s1.getByte(r1) > (-65)) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0062, code lost:
    
        if (com.google.protobuf.s1.getByte(r1) > (-65)) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00a3, code lost:
    
        if (com.google.protobuf.s1.getByte(r1) > (-65)) goto L57;
     */
    @Override // com.google.protobuf.Utf8$b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    int partialIsValidUtf8Direct(int i, ByteBuffer byteBuffer, int i2, int i3) {
        long j;
        byte b = 0;
        if ((i2 | i3 | (byteBuffer.limit() - i3)) < 0) {
            throw new ArrayIndexOutOfBoundsException(String.format("buffer limit=%d, index=%d, limit=%d", Integer.valueOf(byteBuffer.limit()), Integer.valueOf(i2), Integer.valueOf(i3)));
        }
        long addressOffset = s1.addressOffset(byteBuffer) + i2;
        long j2 = (i3 - i2) + addressOffset;
        if (i != 0) {
            if (addressOffset >= j2) {
                return i;
            }
            byte b2 = (byte) i;
            if (b2 < -32) {
                if (b2 >= -62) {
                    j = 1 + addressOffset;
                }
                return -1;
            }
            if (b2 < -16) {
                byte b3 = (byte) (~(i >> 8));
                if (b3 == 0) {
                    long j3 = addressOffset + 1;
                    b3 = s1.getByte(addressOffset);
                    if (j3 >= j2) {
                        return Utf8.access$000(b2, b3);
                    }
                    addressOffset = j3;
                }
                if (b3 <= -65 && ((b2 != -32 || b3 >= -96) && (b2 != -19 || b3 < -96))) {
                    j = 1 + addressOffset;
                }
                return -1;
            }
            byte b4 = (byte) (~(i >> 8));
            if (b4 == 0) {
                long j4 = addressOffset + 1;
                b4 = s1.getByte(addressOffset);
                if (j4 >= j2) {
                    return Utf8.access$000(b2, b4);
                }
                addressOffset = j4;
            } else {
                b = (byte) (i >> 16);
            }
            if (b == 0) {
                long j5 = addressOffset + 1;
                b = s1.getByte(addressOffset);
                if (j5 >= j2) {
                    return Utf8.access$100(b2, b4, b);
                }
                addressOffset = j5;
            }
            if (b4 <= -65 && (((b2 << 28) + (b4 + 112)) >> 30) == 0 && b <= -65) {
                j = 1 + addressOffset;
            }
            return -1;
            addressOffset = j;
        }
        return partialIsValidUtf8(addressOffset, (int) (j2 - addressOffset));
    }
}
