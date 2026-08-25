package com.bumptech.glide.gifdecoder;

import android.graphics.Bitmap;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.gifdecoder.GifDecoder;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.Iterator;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class StandardGifDecoder implements GifDecoder {
    private static final int BYTES_PER_INTEGER = 4;
    private static final int COLOR_TRANSPARENT_BLACK = 0;
    private static final int INITIAL_FRAME_POINTER = -1;
    private static final int MASK_INT_LOWEST_BYTE = 255;
    private static final int MAX_STACK_SIZE = 4096;
    private static final int NULL_CODE = -1;
    private static final String TAG = "StandardGifDecoder";
    private int[] act;

    @NonNull
    private Bitmap.Config bitmapConfig;
    private final GifDecoder.BitmapProvider bitmapProvider;
    private byte[] block;
    private int downsampledHeight;
    private int downsampledWidth;
    private int framePointer;
    private GifHeader header;

    @Nullable
    private Boolean isFirstFrameTransparent;
    private byte[] mainPixels;
    private int[] mainScratch;
    private GifHeaderParser parser;
    private final int[] pct;
    private byte[] pixelStack;
    private short[] prefix;
    private Bitmap previousImage;
    private ByteBuffer rawData;
    private int sampleSize;
    private boolean savePrevious;
    private int status;
    private byte[] suffix;

    public StandardGifDecoder(@NonNull GifDecoder.BitmapProvider bitmapProvider) {
        this.pct = new int[256];
        this.bitmapConfig = Bitmap.Config.ARGB_8888;
        this.bitmapProvider = bitmapProvider;
        this.header = new GifHeader();
    }

    public StandardGifDecoder(@NonNull GifDecoder.BitmapProvider bitmapProvider, GifHeader gifHeader, ByteBuffer byteBuffer) {
        this(bitmapProvider, gifHeader, byteBuffer, 1);
    }

    public StandardGifDecoder(@NonNull GifDecoder.BitmapProvider bitmapProvider, GifHeader gifHeader, ByteBuffer byteBuffer, int i) {
        this(bitmapProvider);
        setData(gifHeader, byteBuffer, i);
    }

    private int averageColorsNear(int i, int i2, int i3) {
        int i4 = 0;
        int i8 = 0;
        int i9 = 0;
        int i10 = 0;
        int i11 = 0;
        for (int i12 = i; i12 < this.sampleSize + i; i12++) {
            byte[] bArr = this.mainPixels;
            if (i12 >= bArr.length || i12 >= i2) {
                break;
            }
            int i13 = this.act[bArr[i12] & 255];
            if (i13 != 0) {
                i4 += (i13 >> 24) & MASK_INT_LOWEST_BYTE;
                i8 += (i13 >> 16) & MASK_INT_LOWEST_BYTE;
                i9 += (i13 >> 8) & MASK_INT_LOWEST_BYTE;
                i10 += i13 & MASK_INT_LOWEST_BYTE;
                i11++;
            }
        }
        int i14 = i + i3;
        for (int i15 = i14; i15 < this.sampleSize + i14; i15++) {
            byte[] bArr2 = this.mainPixels;
            if (i15 >= bArr2.length || i15 >= i2) {
                break;
            }
            int i16 = this.act[bArr2[i15] & 255];
            if (i16 != 0) {
                i4 += (i16 >> 24) & MASK_INT_LOWEST_BYTE;
                i8 += (i16 >> 16) & MASK_INT_LOWEST_BYTE;
                i9 += (i16 >> 8) & MASK_INT_LOWEST_BYTE;
                i10 += i16 & MASK_INT_LOWEST_BYTE;
                i11++;
            }
        }
        if (i11 == 0) {
            return 0;
        }
        return ((i4 / i11) << 24) | ((i8 / i11) << 16) | ((i9 / i11) << 8) | (i10 / i11);
    }

    private void copyCopyIntoScratchRobust(GifFrame gifFrame) {
        int i;
        int i2;
        int i3;
        int i4;
        int i8;
        int[] iArr = this.mainScratch;
        int i9 = gifFrame.ih;
        int i10 = this.sampleSize;
        int i11 = i9 / i10;
        int i12 = gifFrame.iy / i10;
        int i13 = gifFrame.iw / i10;
        int i14 = gifFrame.ix / i10;
        boolean z = this.framePointer == 0;
        int i15 = this.downsampledWidth;
        int i16 = this.downsampledHeight;
        byte[] bArr = this.mainPixels;
        int[] iArr2 = this.act;
        Boolean bool = this.isFirstFrameTransparent;
        int i17 = 8;
        int i18 = 0;
        int i19 = 0;
        int i20 = 1;
        while (i19 < i11) {
            Boolean bool2 = bool;
            if (gifFrame.interlace) {
                if (i18 >= i11) {
                    int i21 = i20 + 1;
                    i = i11;
                    if (i21 == 2) {
                        i18 = 4;
                    } else if (i21 == 3) {
                        i17 = 4;
                        i20 = i21;
                        i18 = 2;
                    } else if (i21 == 4) {
                        i20 = i21;
                        i18 = 1;
                        i17 = 2;
                    }
                    i20 = i21;
                } else {
                    i = i11;
                }
                i2 = i18 + i17;
            } else {
                i = i11;
                i2 = i18;
                i18 = i19;
            }
            int i22 = i18 + i12;
            boolean z2 = i10 == 1;
            if (i22 < i16) {
                int i23 = i22 * i15;
                int i24 = i23 + i14;
                int i25 = i24 + i13;
                int i26 = i23 + i15;
                if (i26 < i25) {
                    i25 = i26;
                }
                i3 = i2;
                int i27 = i19 * i10 * gifFrame.iw;
                if (z2) {
                    int i28 = i24;
                    while (i28 < i25) {
                        int i29 = i12;
                        int i30 = iArr2[bArr[i27] & 255];
                        if (i30 != 0) {
                            iArr[i28] = i30;
                        } else if (z && bool2 == null) {
                            bool2 = Boolean.TRUE;
                        }
                        i27 += i10;
                        i28++;
                        i12 = i29;
                    }
                } else {
                    i8 = i12;
                    int i31 = ((i25 - i24) * i10) + i27;
                    int i32 = i24;
                    while (true) {
                        i4 = i13;
                        if (i32 >= i25) {
                            break;
                        }
                        int averageColorsNear = averageColorsNear(i27, i31, gifFrame.iw);
                        if (averageColorsNear != 0) {
                            iArr[i32] = averageColorsNear;
                        } else if (z && bool2 == null) {
                            bool2 = Boolean.TRUE;
                        }
                        i27 += i10;
                        i32++;
                        i13 = i4;
                    }
                    bool = bool2;
                    i19++;
                    i12 = i8;
                    i11 = i;
                    i13 = i4;
                    i18 = i3;
                }
            } else {
                i3 = i2;
            }
            i8 = i12;
            i4 = i13;
            bool = bool2;
            i19++;
            i12 = i8;
            i11 = i;
            i13 = i4;
            i18 = i3;
        }
        Boolean bool3 = bool;
        if (this.isFirstFrameTransparent == null) {
            this.isFirstFrameTransparent = Boolean.valueOf(bool3 == null ? false : bool3.booleanValue());
        }
    }

    private void copyIntoScratchFast(GifFrame gifFrame) {
        GifFrame gifFrame2 = gifFrame;
        int[] iArr = this.mainScratch;
        int i = gifFrame2.ih;
        int i2 = gifFrame2.iy;
        int i3 = gifFrame2.iw;
        int i4 = gifFrame2.ix;
        boolean z = this.framePointer == 0;
        int i8 = this.downsampledWidth;
        byte[] bArr = this.mainPixels;
        int[] iArr2 = this.act;
        int i9 = 0;
        byte b = -1;
        while (i9 < i) {
            int i10 = (i9 + i2) * i8;
            int i11 = i10 + i4;
            int i12 = i11 + i3;
            int i13 = i10 + i8;
            if (i13 < i12) {
                i12 = i13;
            }
            int i14 = gifFrame2.iw * i9;
            int i15 = i11;
            while (i15 < i12) {
                byte b2 = bArr[i14];
                int i16 = i;
                int i17 = b2 & 255;
                if (i17 != b) {
                    int i18 = iArr2[i17];
                    if (i18 != 0) {
                        iArr[i15] = i18;
                    } else {
                        b = b2;
                    }
                }
                i14++;
                i15++;
                i = i16;
            }
            i9++;
            gifFrame2 = gifFrame;
        }
        Boolean bool = this.isFirstFrameTransparent;
        this.isFirstFrameTransparent = Boolean.valueOf((bool != null && bool.booleanValue()) || (this.isFirstFrameTransparent == null && z && b != -1));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v11 */
    /* JADX WARN: Type inference failed for: r7v12 */
    /* JADX WARN: Type inference failed for: r7v15, types: [short] */
    /* JADX WARN: Type inference failed for: r7v17 */
    private void decodeBitmapData(GifFrame gifFrame) {
        int i;
        int i2;
        short s;
        StandardGifDecoder standardGifDecoder = this;
        if (gifFrame != null) {
            standardGifDecoder.rawData.position(gifFrame.bufferFrameStart);
        }
        if (gifFrame == null) {
            GifHeader gifHeader = standardGifDecoder.header;
            i = gifHeader.width;
            i2 = gifHeader.height;
        } else {
            i = gifFrame.iw;
            i2 = gifFrame.ih;
        }
        int i3 = i * i2;
        byte[] bArr = standardGifDecoder.mainPixels;
        if (bArr == null || bArr.length < i3) {
            standardGifDecoder.mainPixels = standardGifDecoder.bitmapProvider.obtainByteArray(i3);
        }
        byte[] bArr2 = standardGifDecoder.mainPixels;
        if (standardGifDecoder.prefix == null) {
            standardGifDecoder.prefix = new short[MAX_STACK_SIZE];
        }
        short[] sArr = standardGifDecoder.prefix;
        if (standardGifDecoder.suffix == null) {
            standardGifDecoder.suffix = new byte[MAX_STACK_SIZE];
        }
        byte[] bArr3 = standardGifDecoder.suffix;
        if (standardGifDecoder.pixelStack == null) {
            standardGifDecoder.pixelStack = new byte[4097];
        }
        byte[] bArr4 = standardGifDecoder.pixelStack;
        int readByte = readByte();
        int i4 = 1 << readByte;
        int i8 = i4 + 1;
        int i9 = i4 + 2;
        int i10 = readByte + 1;
        int i11 = (1 << i10) - 1;
        int i12 = 0;
        for (int i13 = 0; i13 < i4; i13++) {
            sArr[i13] = 0;
            bArr3[i13] = (byte) i13;
        }
        byte[] bArr5 = standardGifDecoder.block;
        int i14 = i10;
        int i15 = i9;
        int i16 = i11;
        int i17 = 0;
        int i18 = 0;
        int i19 = 0;
        int i20 = 0;
        int i21 = 0;
        int i22 = 0;
        int i23 = 0;
        int i24 = -1;
        while (true) {
            if (i12 >= i3) {
                break;
            }
            if (i17 == 0) {
                i17 = readBlock();
                if (i17 <= 0) {
                    standardGifDecoder.status = 3;
                    break;
                }
                i18 = 0;
            }
            i20 += (bArr5[i18] & 255) << i19;
            i18++;
            i17--;
            int i25 = i19 + 8;
            int i26 = i15;
            int i27 = i24;
            int i28 = i14;
            int i29 = i10;
            int i30 = i23;
            while (true) {
                if (i25 < i28) {
                    i15 = i26;
                    i14 = i28;
                    i19 = i25;
                    i23 = i30;
                    i10 = i29;
                    i24 = i27;
                    break;
                }
                int i31 = i9;
                int i32 = i20 & i16;
                i20 >>= i28;
                i25 -= i28;
                if (i32 == i4) {
                    i16 = i11;
                    i28 = i29;
                    i26 = i31;
                    i9 = i26;
                    i27 = -1;
                } else {
                    if (i32 == i8) {
                        i19 = i25;
                        i23 = i30;
                        i15 = i26;
                        i10 = i29;
                        i9 = i31;
                        i24 = i27;
                        i14 = i28;
                        break;
                    }
                    if (i27 == -1) {
                        bArr2[i21] = bArr3[i32];
                        i21++;
                        i12++;
                        i27 = i32;
                        i30 = i27;
                        i9 = i31;
                        i25 = i25;
                    } else {
                        if (i32 >= i26) {
                            bArr4[i22] = (byte) i30;
                            i22++;
                            s = i27;
                        } else {
                            s = i32;
                        }
                        while (s >= i4) {
                            bArr4[i22] = bArr3[s];
                            i22++;
                            s = sArr[s];
                        }
                        i30 = bArr3[s] & 255;
                        byte b = (byte) i30;
                        bArr2[i21] = b;
                        while (true) {
                            i21++;
                            i12++;
                            if (i22 <= 0) {
                                break;
                            }
                            i22--;
                            bArr2[i21] = bArr4[i22];
                        }
                        byte[] bArr6 = bArr4;
                        if (i26 < MAX_STACK_SIZE) {
                            sArr[i26] = (short) i27;
                            bArr3[i26] = b;
                            i26++;
                            if ((i26 & i16) == 0 && i26 < MAX_STACK_SIZE) {
                                i28++;
                                i16 += i26;
                            }
                        }
                        i27 = i32;
                        i9 = i31;
                        i25 = i25;
                        bArr4 = bArr6;
                    }
                }
            }
            standardGifDecoder = this;
        }
        Arrays.fill(bArr2, i21, i3, (byte) 0);
    }

    @NonNull
    private GifHeaderParser getHeaderParser() {
        if (this.parser == null) {
            this.parser = new GifHeaderParser();
        }
        return this.parser;
    }

    private Bitmap getNextBitmap() {
        Boolean bool = this.isFirstFrameTransparent;
        Bitmap obtain = this.bitmapProvider.obtain(this.downsampledWidth, this.downsampledHeight, (bool == null || bool.booleanValue()) ? Bitmap.Config.ARGB_8888 : this.bitmapConfig);
        obtain.setHasAlpha(true);
        return obtain;
    }

    private int readBlock() {
        int readByte = readByte();
        if (readByte <= 0) {
            return readByte;
        }
        ByteBuffer byteBuffer = this.rawData;
        byteBuffer.get(this.block, 0, Math.min(readByte, byteBuffer.remaining()));
        return readByte;
    }

    private int readByte() {
        return this.rawData.get() & 255;
    }

    private Bitmap setPixels(GifFrame gifFrame, GifFrame gifFrame2) {
        int i;
        int i2;
        Bitmap bitmap;
        int[] iArr = this.mainScratch;
        int i3 = 0;
        if (gifFrame2 == null) {
            Bitmap bitmap2 = this.previousImage;
            if (bitmap2 != null) {
                this.bitmapProvider.release(bitmap2);
            }
            this.previousImage = null;
            Arrays.fill(iArr, 0);
        }
        if (gifFrame2 != null && gifFrame2.dispose == 3 && this.previousImage == null) {
            Arrays.fill(iArr, 0);
        }
        if (gifFrame2 != null && (i2 = gifFrame2.dispose) > 0) {
            if (i2 == 2) {
                if (!gifFrame.transparency) {
                    GifHeader gifHeader = this.header;
                    int i4 = gifHeader.bgColor;
                    if (gifFrame.lct == null || gifHeader.bgIndex != gifFrame.transIndex) {
                        i3 = i4;
                    }
                }
                int i8 = gifFrame2.ih;
                int i9 = this.sampleSize;
                int i10 = i8 / i9;
                int i11 = gifFrame2.iy / i9;
                int i12 = gifFrame2.iw / i9;
                int i13 = gifFrame2.ix / i9;
                int i14 = this.downsampledWidth;
                int i15 = (i11 * i14) + i13;
                int i16 = (i10 * i14) + i15;
                while (i15 < i16) {
                    int i17 = i15 + i12;
                    for (int i18 = i15; i18 < i17; i18++) {
                        iArr[i18] = i3;
                    }
                    i15 += this.downsampledWidth;
                }
            } else if (i2 == 3 && (bitmap = this.previousImage) != null) {
                int i19 = this.downsampledWidth;
                bitmap.getPixels(iArr, 0, i19, 0, 0, i19, this.downsampledHeight);
            }
        }
        decodeBitmapData(gifFrame);
        if (gifFrame.interlace || this.sampleSize != 1) {
            copyCopyIntoScratchRobust(gifFrame);
        } else {
            copyIntoScratchFast(gifFrame);
        }
        if (this.savePrevious && ((i = gifFrame.dispose) == 0 || i == 1)) {
            if (this.previousImage == null) {
                this.previousImage = getNextBitmap();
            }
            Bitmap bitmap3 = this.previousImage;
            int i20 = this.downsampledWidth;
            bitmap3.setPixels(iArr, 0, i20, 0, 0, i20, this.downsampledHeight);
        }
        Bitmap nextBitmap = getNextBitmap();
        int i21 = this.downsampledWidth;
        nextBitmap.setPixels(iArr, 0, i21, 0, 0, i21, this.downsampledHeight);
        return nextBitmap;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public void advance() {
        this.framePointer = (this.framePointer + 1) % this.header.frameCount;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public void clear() {
        this.header = null;
        byte[] bArr = this.mainPixels;
        if (bArr != null) {
            this.bitmapProvider.release(bArr);
        }
        int[] iArr = this.mainScratch;
        if (iArr != null) {
            this.bitmapProvider.release(iArr);
        }
        Bitmap bitmap = this.previousImage;
        if (bitmap != null) {
            this.bitmapProvider.release(bitmap);
        }
        this.previousImage = null;
        this.rawData = null;
        this.isFirstFrameTransparent = null;
        byte[] bArr2 = this.block;
        if (bArr2 != null) {
            this.bitmapProvider.release(bArr2);
        }
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public int getByteSize() {
        return this.rawData.limit() + this.mainPixels.length + (this.mainScratch.length * 4);
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public int getCurrentFrameIndex() {
        return this.framePointer;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    @NonNull
    public ByteBuffer getData() {
        return this.rawData;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public int getDelay(int i) {
        if (i >= 0) {
            GifHeader gifHeader = this.header;
            if (i < gifHeader.frameCount) {
                return gifHeader.frames.get(i).delay;
            }
        }
        return -1;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public int getFrameCount() {
        return this.header.frameCount;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public int getHeight() {
        return this.header.height;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    @Deprecated
    public int getLoopCount() {
        int i = this.header.loopCount;
        if (i == -1) {
            return 1;
        }
        return i;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public int getNetscapeLoopCount() {
        return this.header.loopCount;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public int getNextDelay() {
        int i;
        if (this.header.frameCount <= 0 || (i = this.framePointer) < 0) {
            return 0;
        }
        return getDelay(i);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0047 A[Catch: all -> 0x000e, TryCatch #0 {all -> 0x000e, blocks: (B:3:0x0001, B:5:0x0009, B:8:0x0036, B:13:0x0040, B:15:0x0047, B:16:0x0051, B:18:0x0062, B:19:0x006e, B:22:0x0077, B:24:0x007b, B:26:0x0083, B:27:0x0092, B:31:0x0096, B:33:0x009a, B:35:0x00ac, B:37:0x00b0, B:38:0x00b4, B:41:0x0073, B:43:0x00ba, B:45:0x00c2, B:48:0x0011, B:50:0x0019, B:51:0x0034), top: B:2:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0062 A[Catch: all -> 0x000e, TryCatch #0 {all -> 0x000e, blocks: (B:3:0x0001, B:5:0x0009, B:8:0x0036, B:13:0x0040, B:15:0x0047, B:16:0x0051, B:18:0x0062, B:19:0x006e, B:22:0x0077, B:24:0x007b, B:26:0x0083, B:27:0x0092, B:31:0x0096, B:33:0x009a, B:35:0x00ac, B:37:0x00b0, B:38:0x00b4, B:41:0x0073, B:43:0x00ba, B:45:0x00c2, B:48:0x0011, B:50:0x0019, B:51:0x0034), top: B:2:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x007b A[Catch: all -> 0x000e, TryCatch #0 {all -> 0x000e, blocks: (B:3:0x0001, B:5:0x0009, B:8:0x0036, B:13:0x0040, B:15:0x0047, B:16:0x0051, B:18:0x0062, B:19:0x006e, B:22:0x0077, B:24:0x007b, B:26:0x0083, B:27:0x0092, B:31:0x0096, B:33:0x009a, B:35:0x00ac, B:37:0x00b0, B:38:0x00b4, B:41:0x0073, B:43:0x00ba, B:45:0x00c2, B:48:0x0011, B:50:0x0019, B:51:0x0034), top: B:2:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0096 A[Catch: all -> 0x000e, TRY_ENTER, TryCatch #0 {all -> 0x000e, blocks: (B:3:0x0001, B:5:0x0009, B:8:0x0036, B:13:0x0040, B:15:0x0047, B:16:0x0051, B:18:0x0062, B:19:0x006e, B:22:0x0077, B:24:0x007b, B:26:0x0083, B:27:0x0092, B:31:0x0096, B:33:0x009a, B:35:0x00ac, B:37:0x00b0, B:38:0x00b4, B:41:0x0073, B:43:0x00ba, B:45:0x00c2, B:48:0x0011, B:50:0x0019, B:51:0x0034), top: B:2:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0073 A[Catch: all -> 0x000e, TryCatch #0 {all -> 0x000e, blocks: (B:3:0x0001, B:5:0x0009, B:8:0x0036, B:13:0x0040, B:15:0x0047, B:16:0x0051, B:18:0x0062, B:19:0x006e, B:22:0x0077, B:24:0x007b, B:26:0x0083, B:27:0x0092, B:31:0x0096, B:33:0x009a, B:35:0x00ac, B:37:0x00b0, B:38:0x00b4, B:41:0x0073, B:43:0x00ba, B:45:0x00c2, B:48:0x0011, B:50:0x0019, B:51:0x0034), top: B:2:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00c2 A[Catch: all -> 0x000e, TRY_LEAVE, TryCatch #0 {all -> 0x000e, blocks: (B:3:0x0001, B:5:0x0009, B:8:0x0036, B:13:0x0040, B:15:0x0047, B:16:0x0051, B:18:0x0062, B:19:0x006e, B:22:0x0077, B:24:0x007b, B:26:0x0083, B:27:0x0092, B:31:0x0096, B:33:0x009a, B:35:0x00ac, B:37:0x00b0, B:38:0x00b4, B:41:0x0073, B:43:0x00ba, B:45:0x00c2, B:48:0x0011, B:50:0x0019, B:51:0x0034), top: B:2:0x0001 }] */
    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized Bitmap getNextFrame() {
        int i;
        int[] iArr;
        try {
            if (this.header.frameCount > 0) {
                if (this.framePointer < 0) {
                }
                i = this.status;
                if (i != 1 && i != 2) {
                    this.status = 0;
                    if (this.block == null) {
                        this.block = this.bitmapProvider.obtainByteArray(MASK_INT_LOWEST_BYTE);
                    }
                    GifFrame gifFrame = this.header.frames.get(this.framePointer);
                    int i2 = this.framePointer - 1;
                    GifFrame gifFrame2 = i2 < 0 ? this.header.frames.get(i2) : null;
                    iArr = gifFrame.lct;
                    if (iArr != null) {
                        iArr = this.header.gct;
                    }
                    this.act = iArr;
                    if (iArr != null) {
                        if (Log.isLoggable(TAG, 3)) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("No valid color table found for frame #");
                            sb.append(this.framePointer);
                        }
                        this.status = 1;
                        return null;
                    }
                    if (gifFrame.transparency) {
                        System.arraycopy(iArr, 0, this.pct, 0, iArr.length);
                        int[] iArr2 = this.pct;
                        this.act = iArr2;
                        iArr2[gifFrame.transIndex] = 0;
                        if (gifFrame.dispose == 2 && this.framePointer == 0) {
                            this.isFirstFrameTransparent = Boolean.TRUE;
                        }
                    }
                    return setPixels(gifFrame, gifFrame2);
                }
                if (Log.isLoggable(TAG, 3)) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Unable to decode frame, status=");
                    sb2.append(this.status);
                }
                return null;
            }
            if (Log.isLoggable(TAG, 3)) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("Unable to decode frame, frameCount=");
                sb3.append(this.header.frameCount);
                sb3.append(", framePointer=");
                sb3.append(this.framePointer);
            }
            this.status = 1;
            i = this.status;
            if (i != 1) {
                this.status = 0;
                if (this.block == null) {
                }
                GifFrame gifFrame3 = this.header.frames.get(this.framePointer);
                int i22 = this.framePointer - 1;
                if (i22 < 0) {
                }
                iArr = gifFrame3.lct;
                if (iArr != null) {
                }
                this.act = iArr;
                if (iArr != null) {
                }
            }
            if (Log.isLoggable(TAG, 3)) {
            }
            return null;
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public int getStatus() {
        return this.status;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public int getTotalIterationCount() {
        int i = this.header.loopCount;
        if (i == -1) {
            return 1;
        }
        if (i == 0) {
            return 0;
        }
        return i + 1;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public int getWidth() {
        return this.header.width;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public int read(@Nullable InputStream inputStream, int i) {
        if (inputStream != null) {
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(i > 0 ? i + MAX_STACK_SIZE : 16384);
                byte[] bArr = new byte[16384];
                while (true) {
                    int read = inputStream.read(bArr, 0, 16384);
                    if (read == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, read);
                }
                byteArrayOutputStream.flush();
                read(byteArrayOutputStream.toByteArray());
            } catch (IOException e) {
                Log.w(TAG, "Error reading data from stream", e);
            }
        } else {
            this.status = 2;
        }
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e2) {
                Log.w(TAG, "Error closing stream", e2);
            }
        }
        return this.status;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public synchronized int read(@Nullable byte[] bArr) {
        try {
            GifHeader parseHeader = getHeaderParser().setData(bArr).parseHeader();
            this.header = parseHeader;
            if (bArr != null) {
                setData(parseHeader, bArr);
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.status;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public void resetFrameIndex() {
        this.framePointer = -1;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public synchronized void setData(@NonNull GifHeader gifHeader, @NonNull ByteBuffer byteBuffer) {
        setData(gifHeader, byteBuffer, 1);
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public synchronized void setData(@NonNull GifHeader gifHeader, @NonNull ByteBuffer byteBuffer, int i) {
        try {
            if (i <= 0) {
                throw new IllegalArgumentException("Sample size must be >=0, not: " + i);
            }
            int highestOneBit = Integer.highestOneBit(i);
            this.status = 0;
            this.header = gifHeader;
            this.framePointer = -1;
            ByteBuffer asReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
            this.rawData = asReadOnlyBuffer;
            asReadOnlyBuffer.position(0);
            this.rawData.order(ByteOrder.LITTLE_ENDIAN);
            this.savePrevious = false;
            Iterator<GifFrame> it = gifHeader.frames.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if (it.next().dispose == 3) {
                    this.savePrevious = true;
                    break;
                }
            }
            this.sampleSize = highestOneBit;
            int i2 = gifHeader.width;
            this.downsampledWidth = i2 / highestOneBit;
            int i3 = gifHeader.height;
            this.downsampledHeight = i3 / highestOneBit;
            this.mainPixels = this.bitmapProvider.obtainByteArray(i2 * i3);
            this.mainScratch = this.bitmapProvider.obtainIntArray(this.downsampledWidth * this.downsampledHeight);
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public synchronized void setData(@NonNull GifHeader gifHeader, @NonNull byte[] bArr) {
        setData(gifHeader, ByteBuffer.wrap(bArr));
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public void setDefaultBitmapConfig(@NonNull Bitmap.Config config) {
        Bitmap.Config config2;
        Bitmap.Config config3 = Bitmap.Config.ARGB_8888;
        if (config == config3 || config == (config2 = Bitmap.Config.RGB_565)) {
            this.bitmapConfig = config;
            return;
        }
        throw new IllegalArgumentException("Unsupported format: " + config + ", must be one of " + config3 + " or " + config2);
    }
}
