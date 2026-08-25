package com.google.protobuf;

import com.google.protobuf.Utf8;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.PsExtractor;
import java.nio.ByteBuffer;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
abstract class Utf8$b {
    Utf8$b() {
    }

    private static int partialIsValidUtf8(ByteBuffer byteBuffer, int i, int i2) {
        int access$200 = i + Utf8.access$200(byteBuffer, i, i2);
        while (access$200 < i2) {
            int i3 = access$200 + 1;
            byte b = byteBuffer.get(access$200);
            if (b >= 0) {
                access$200 = i3;
            } else if (b < -32) {
                if (i3 >= i2) {
                    return b;
                }
                if (b < -62 || byteBuffer.get(i3) > -65) {
                    return -1;
                }
                access$200 += 2;
            } else {
                if (b >= -16) {
                    if (i3 >= i2 - 2) {
                        return Utf8.access$300(byteBuffer, b, i3, i2 - i3);
                    }
                    int i4 = access$200 + 2;
                    byte b2 = byteBuffer.get(i3);
                    if (b2 <= -65 && (((b << 28) + (b2 + 112)) >> 30) == 0) {
                        int i5 = access$200 + 3;
                        if (byteBuffer.get(i4) <= -65) {
                            access$200 += 4;
                            if (byteBuffer.get(i5) > -65) {
                            }
                        }
                    }
                    return -1;
                }
                if (i3 >= i2 - 1) {
                    return Utf8.access$300(byteBuffer, b, i3, i2 - i3);
                }
                int i6 = access$200 + 2;
                byte b3 = byteBuffer.get(i3);
                if (b3 > -65 || ((b == -32 && b3 < -96) || ((b == -19 && b3 >= -96) || byteBuffer.get(i6) > -65))) {
                    return -1;
                }
                access$200 += 3;
            }
        }
        return 0;
    }

    final String decodeUtf8(ByteBuffer byteBuffer, int i, int i2) throws InvalidProtocolBufferException {
        if (byteBuffer.hasArray()) {
            return decodeUtf8(byteBuffer.array(), byteBuffer.arrayOffset() + i, i2);
        }
        return byteBuffer.isDirect() ? decodeUtf8Direct(byteBuffer, i, i2) : decodeUtf8Default(byteBuffer, i, i2);
    }

    abstract String decodeUtf8(byte[] bArr, int i, int i2) throws InvalidProtocolBufferException;

    final String decodeUtf8Default(ByteBuffer byteBuffer, int i, int i2) throws InvalidProtocolBufferException {
        boolean isOneByte;
        boolean isOneByte2;
        boolean isTwoBytes;
        boolean isThreeBytes;
        boolean isOneByte3;
        if ((i | i2 | ((byteBuffer.limit() - i) - i2)) < 0) {
            throw new ArrayIndexOutOfBoundsException(String.format("buffer limit=%d, index=%d, limit=%d", Integer.valueOf(byteBuffer.limit()), Integer.valueOf(i), Integer.valueOf(i2)));
        }
        int i3 = i + i2;
        char[] cArr = new char[i2];
        int i4 = 0;
        while (i < i3) {
            byte b = byteBuffer.get(i);
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
            byte b2 = byteBuffer.get(i);
            isOneByte = Utf8$a.isOneByte(b2);
            if (isOneByte) {
                int i7 = i5 + 1;
                Utf8$a.handleOneByte(b2, cArr, i5);
                while (i6 < i3) {
                    byte b3 = byteBuffer.get(i6);
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
                        Utf8$a.handleThreeBytes(b2, byteBuffer.get(i6), byteBuffer.get(i8), cArr, i5);
                        i5++;
                    } else {
                        if (i6 >= i3 - 2) {
                            throw InvalidProtocolBufferException.invalidUtf8();
                        }
                        byte b4 = byteBuffer.get(i6);
                        int i9 = i + 3;
                        byte b5 = byteBuffer.get(i + 2);
                        i += 4;
                        Utf8$a.handleFourBytes(b2, b4, b5, byteBuffer.get(i9), cArr, i5);
                        i5 += 2;
                    }
                } else {
                    if (i6 >= i3) {
                        throw InvalidProtocolBufferException.invalidUtf8();
                    }
                    i += 2;
                    Utf8$a.handleTwoBytes(b2, byteBuffer.get(i6), cArr, i5);
                    i5++;
                }
            }
        }
        return new String(cArr, 0, i5);
    }

    abstract String decodeUtf8Direct(ByteBuffer byteBuffer, int i, int i2) throws InvalidProtocolBufferException;

    abstract int encodeUtf8(CharSequence charSequence, byte[] bArr, int i, int i2);

    final void encodeUtf8(CharSequence charSequence, ByteBuffer byteBuffer) {
        if (byteBuffer.hasArray()) {
            int arrayOffset = byteBuffer.arrayOffset();
            e0.position(byteBuffer, Utf8.encode(charSequence, byteBuffer.array(), byteBuffer.position() + arrayOffset, byteBuffer.remaining()) - arrayOffset);
        } else if (byteBuffer.isDirect()) {
            encodeUtf8Direct(charSequence, byteBuffer);
        } else {
            encodeUtf8Default(charSequence, byteBuffer);
        }
    }

    final void encodeUtf8Default(CharSequence charSequence, ByteBuffer byteBuffer) {
        int i;
        int length = charSequence.length();
        int position = byteBuffer.position();
        int i2 = 0;
        while (i2 < length) {
            try {
                char charAt = charSequence.charAt(i2);
                if (charAt >= 128) {
                    break;
                }
                byteBuffer.put(position + i2, (byte) charAt);
                i2++;
            } catch (IndexOutOfBoundsException unused) {
                throw new ArrayIndexOutOfBoundsException("Failed writing " + charSequence.charAt(i2) + " at index " + (byteBuffer.position() + Math.max(i2, (position - byteBuffer.position()) + 1)));
            }
        }
        if (i2 == length) {
            e0.position(byteBuffer, position + i2);
            return;
        }
        position += i2;
        while (i2 < length) {
            char charAt2 = charSequence.charAt(i2);
            if (charAt2 < 128) {
                byteBuffer.put(position, (byte) charAt2);
            } else if (charAt2 < 2048) {
                int i3 = position + 1;
                try {
                    byteBuffer.put(position, (byte) ((charAt2 >>> 6) | PsExtractor.AUDIO_STREAM));
                    byteBuffer.put(i3, (byte) ((charAt2 & '?') | 128));
                    position = i3;
                } catch (IndexOutOfBoundsException unused2) {
                    position = i3;
                    throw new ArrayIndexOutOfBoundsException("Failed writing " + charSequence.charAt(i2) + " at index " + (byteBuffer.position() + Math.max(i2, (position - byteBuffer.position()) + 1)));
                }
            } else {
                if (charAt2 >= 55296 && 57343 >= charAt2) {
                    int i4 = i2 + 1;
                    if (i4 != length) {
                        try {
                            char charAt3 = charSequence.charAt(i4);
                            if (Character.isSurrogatePair(charAt2, charAt3)) {
                                int codePoint = Character.toCodePoint(charAt2, charAt3);
                                int i5 = position + 1;
                                try {
                                    byteBuffer.put(position, (byte) ((codePoint >>> 18) | 240));
                                    i = position + 2;
                                } catch (IndexOutOfBoundsException unused3) {
                                    position = i5;
                                    i2 = i4;
                                    throw new ArrayIndexOutOfBoundsException("Failed writing " + charSequence.charAt(i2) + " at index " + (byteBuffer.position() + Math.max(i2, (position - byteBuffer.position()) + 1)));
                                }
                                try {
                                    byteBuffer.put(i5, (byte) (((codePoint >>> 12) & 63) | 128));
                                    position += 3;
                                    byteBuffer.put(i, (byte) (((codePoint >>> 6) & 63) | 128));
                                    byteBuffer.put(position, (byte) ((codePoint & 63) | 128));
                                    i2 = i4;
                                } catch (IndexOutOfBoundsException unused4) {
                                    i2 = i4;
                                    position = i;
                                    throw new ArrayIndexOutOfBoundsException("Failed writing " + charSequence.charAt(i2) + " at index " + (byteBuffer.position() + Math.max(i2, (position - byteBuffer.position()) + 1)));
                                }
                            } else {
                                i2 = i4;
                            }
                        } catch (IndexOutOfBoundsException unused5) {
                        }
                    }
                    throw new Utf8.UnpairedSurrogateException(i2, length);
                }
                int i6 = position + 1;
                byteBuffer.put(position, (byte) ((charAt2 >>> '\f') | 224));
                position += 2;
                byteBuffer.put(i6, (byte) (((charAt2 >>> 6) & 63) | 128));
                byteBuffer.put(position, (byte) ((charAt2 & '?') | 128));
            }
            i2++;
            position++;
        }
        e0.position(byteBuffer, position);
    }

    abstract void encodeUtf8Direct(CharSequence charSequence, ByteBuffer byteBuffer);

    final boolean isValidUtf8(ByteBuffer byteBuffer, int i, int i2) {
        return partialIsValidUtf8(0, byteBuffer, i, i2) == 0;
    }

    final boolean isValidUtf8(byte[] bArr, int i, int i2) {
        return partialIsValidUtf8(0, bArr, i, i2) == 0;
    }

    final int partialIsValidUtf8(int i, ByteBuffer byteBuffer, int i2, int i3) {
        if (!byteBuffer.hasArray()) {
            return byteBuffer.isDirect() ? partialIsValidUtf8Direct(i, byteBuffer, i2, i3) : partialIsValidUtf8Default(i, byteBuffer, i2, i3);
        }
        int arrayOffset = byteBuffer.arrayOffset();
        return partialIsValidUtf8(i, byteBuffer.array(), i2 + arrayOffset, arrayOffset + i3);
    }

    abstract int partialIsValidUtf8(int i, byte[] bArr, int i2, int i3);

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0017, code lost:
    
        if (r8.get(r9) > (-65)) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x004c, code lost:
    
        if (r8.get(r9) > (-65)) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x008f, code lost:
    
        if (r8.get(r7) > (-65)) goto L53;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    final int partialIsValidUtf8Default(int i, ByteBuffer byteBuffer, int i2, int i3) {
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
                    byte b4 = byteBuffer.get(i2);
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
                b5 = byteBuffer.get(i2);
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
                byte b6 = byteBuffer.get(i4);
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
        return partialIsValidUtf8(byteBuffer, i2, i3);
    }

    abstract int partialIsValidUtf8Direct(int i, ByteBuffer byteBuffer, int i2, int i3);
}
