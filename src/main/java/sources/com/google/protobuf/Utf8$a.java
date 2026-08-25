package com.google.protobuf;

/* JADX INFO: Access modifiers changed from: private */
/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public class Utf8$a {
    private Utf8$a() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void handleFourBytes(byte b, byte b2, byte b3, byte b4, char[] cArr, int i) throws InvalidProtocolBufferException {
        if (isNotTrailingByte(b2) || (((b << 28) + (b2 + 112)) >> 30) != 0 || isNotTrailingByte(b3) || isNotTrailingByte(b4)) {
            throw InvalidProtocolBufferException.invalidUtf8();
        }
        int trailingByteValue = ((b & 7) << 18) | (trailingByteValue(b2) << 12) | (trailingByteValue(b3) << 6) | trailingByteValue(b4);
        cArr[i] = highSurrogate(trailingByteValue);
        cArr[i + 1] = lowSurrogate(trailingByteValue);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void handleOneByte(byte b, char[] cArr, int i) {
        cArr[i] = (char) b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void handleThreeBytes(byte b, byte b2, byte b3, char[] cArr, int i) throws InvalidProtocolBufferException {
        if (isNotTrailingByte(b2) || ((b == -32 && b2 < -96) || ((b == -19 && b2 >= -96) || isNotTrailingByte(b3)))) {
            throw InvalidProtocolBufferException.invalidUtf8();
        }
        cArr[i] = (char) (((b & 15) << 12) | (trailingByteValue(b2) << 6) | trailingByteValue(b3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void handleTwoBytes(byte b, byte b2, char[] cArr, int i) throws InvalidProtocolBufferException {
        if (b < -62 || isNotTrailingByte(b2)) {
            throw InvalidProtocolBufferException.invalidUtf8();
        }
        cArr[i] = (char) (((b & 31) << 6) | trailingByteValue(b2));
    }

    private static char highSurrogate(int i) {
        return (char) ((i >>> 10) + 55232);
    }

    private static boolean isNotTrailingByte(byte b) {
        return b > -65;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isOneByte(byte b) {
        return b >= 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isThreeBytes(byte b) {
        return b < -16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isTwoBytes(byte b) {
        return b < -32;
    }

    private static char lowSurrogate(int i) {
        return (char) ((i & 1023) + 56320);
    }

    private static int trailingByteValue(byte b) {
        return b & 63;
    }
}
