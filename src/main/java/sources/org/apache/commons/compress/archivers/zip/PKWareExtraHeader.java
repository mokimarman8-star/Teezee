package org.apache.commons.compress.archivers.zip;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipException;
import okhttp3.internal.http2.Settings;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public abstract class PKWareExtraHeader implements t {
    private final ZipShort a;
    private byte[] b;
    private byte[] c;

    public enum EncryptionAlgorithm {
        DES(26113),
        RC2pre52(26114),
        TripleDES168(26115),
        TripleDES192(26121),
        AES128(26126),
        AES192(26127),
        AES256(26128),
        RC2(26370),
        RC4(26625),
        UNKNOWN(Settings.DEFAULT_INITIAL_WINDOW_SIZE);

        private static final Map<Integer, EncryptionAlgorithm> codeToEnum;
        private final int code;

        static {
            HashMap hashMap = new HashMap();
            for (EncryptionAlgorithm encryptionAlgorithm : values()) {
                hashMap.put(Integer.valueOf(encryptionAlgorithm.getCode()), encryptionAlgorithm);
            }
            codeToEnum = Collections.unmodifiableMap(hashMap);
        }

        EncryptionAlgorithm(int i) {
            this.code = i;
        }

        public static EncryptionAlgorithm getAlgorithmByCode(int i) {
            return codeToEnum.get(Integer.valueOf(i));
        }

        public int getCode() {
            return this.code;
        }
    }

    public enum HashAlgorithm {
        NONE(0),
        CRC32(1),
        MD5(32771),
        SHA1(32772),
        RIPEND160(32775),
        SHA256(32780),
        SHA384(32781),
        SHA512(32782);

        private static final Map<Integer, HashAlgorithm> codeToEnum;
        private final int code;

        static {
            HashMap hashMap = new HashMap();
            for (HashAlgorithm hashAlgorithm : values()) {
                hashMap.put(Integer.valueOf(hashAlgorithm.getCode()), hashAlgorithm);
            }
            codeToEnum = Collections.unmodifiableMap(hashMap);
        }

        HashAlgorithm(int i) {
            this.code = i;
        }

        public static HashAlgorithm getAlgorithmByCode(int i) {
            return codeToEnum.get(Integer.valueOf(i));
        }

        public int getCode() {
            return this.code;
        }
    }

    protected PKWareExtraHeader(ZipShort zipShort) {
        this.a = zipShort;
    }

    protected final void a(int i, int i2) {
        if (i2 >= i) {
            return;
        }
        throw new ZipException(getClass().getName() + " is too short, only " + i2 + " bytes, expected at least " + i);
    }

    public void b(byte[] bArr) {
        this.c = u.c(bArr);
    }

    public void c(byte[] bArr) {
        this.b = u.c(bArr);
    }

    @Override // org.apache.commons.compress.archivers.zip.t
    public ZipShort getHeaderId() {
        return this.a;
    }

    @Override // org.apache.commons.compress.archivers.zip.t
    public void parseFromCentralDirectoryData(byte[] bArr, int i, int i2) {
        byte[] copyOfRange = Arrays.copyOfRange(bArr, i, i2 + i);
        b(copyOfRange);
        if (this.b == null) {
            c(copyOfRange);
        }
    }

    @Override // org.apache.commons.compress.archivers.zip.t
    public void parseFromLocalFileData(byte[] bArr, int i, int i2) {
        c(Arrays.copyOfRange(bArr, i, i2 + i));
    }
}
