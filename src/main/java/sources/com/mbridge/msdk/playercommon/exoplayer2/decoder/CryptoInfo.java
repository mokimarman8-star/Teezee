package com.mbridge.msdk.playercommon.exoplayer2.decoder;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import androidx.media3.decoder.d;
import androidx.media3.decoder.e;
import androidx.media3.decoder.f;
import com.mbridge.msdk.playercommon.exoplayer2.RendererCapabilities;
import com.mbridge.msdk.playercommon.exoplayer2.util.Util;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public final class CryptoInfo {
    public int clearBlocks;
    public int encryptedBlocks;
    private final MediaCodec.CryptoInfo frameworkCryptoInfo;
    public byte[] iv;
    public byte[] key;
    public int mode;
    public int[] numBytesOfClearData;
    public int[] numBytesOfEncryptedData;
    public int numSubSamples;
    private final PatternHolderV24 patternHolder;

    @TargetApi(RendererCapabilities.ADAPTIVE_SUPPORT_MASK)
    private static final class PatternHolderV24 {
        private final MediaCodec.CryptoInfo frameworkCryptoInfo;
        private final MediaCodec.CryptoInfo.Pattern pattern;

        private PatternHolderV24(MediaCodec.CryptoInfo cryptoInfo) {
            this.frameworkCryptoInfo = cryptoInfo;
            this.pattern = d.a(0, 0);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void set(int i, int i2) {
            e.a(this.pattern, i, i2);
            f.a(this.frameworkCryptoInfo, this.pattern);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CryptoInfo() {
        int i = Util.SDK_INT;
        Object[] objArr = 0;
        MediaCodec.CryptoInfo newFrameworkCryptoInfoV16 = i >= 16 ? newFrameworkCryptoInfoV16() : null;
        this.frameworkCryptoInfo = newFrameworkCryptoInfoV16;
        this.patternHolder = i >= 24 ? new PatternHolderV24(newFrameworkCryptoInfoV16) : null;
    }

    @TargetApi(16)
    private MediaCodec.CryptoInfo newFrameworkCryptoInfoV16() {
        return new MediaCodec.CryptoInfo();
    }

    @TargetApi(16)
    private void updateFrameworkCryptoInfoV16() {
        MediaCodec.CryptoInfo cryptoInfo = this.frameworkCryptoInfo;
        cryptoInfo.numSubSamples = this.numSubSamples;
        cryptoInfo.numBytesOfClearData = this.numBytesOfClearData;
        cryptoInfo.numBytesOfEncryptedData = this.numBytesOfEncryptedData;
        cryptoInfo.key = this.key;
        cryptoInfo.iv = this.iv;
        cryptoInfo.mode = this.mode;
        if (Util.SDK_INT >= 24) {
            this.patternHolder.set(this.encryptedBlocks, this.clearBlocks);
        }
    }

    @TargetApi(16)
    public MediaCodec.CryptoInfo getFrameworkCryptoInfoV16() {
        return this.frameworkCryptoInfo;
    }

    public void set(int i, int[] iArr, int[] iArr2, byte[] bArr, byte[] bArr2, int i2, int i3, int i4) {
        this.numSubSamples = i;
        this.numBytesOfClearData = iArr;
        this.numBytesOfEncryptedData = iArr2;
        this.key = bArr;
        this.iv = bArr2;
        this.mode = i2;
        this.encryptedBlocks = i3;
        this.clearBlocks = i4;
        if (Util.SDK_INT >= 16) {
            updateFrameworkCryptoInfoV16();
        }
    }
}
