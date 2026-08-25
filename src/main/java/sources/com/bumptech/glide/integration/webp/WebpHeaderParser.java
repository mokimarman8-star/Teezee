package com.bumptech.glide.integration.webp;

import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.resource.bitmap.RecyclableBufferedInputStream;
import com.bumptech.glide.util.Preconditions;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public class WebpHeaderParser {
    public static final int MAX_WEBP_HEADER_SIZE = 21;
    private static final int RIFF_HEADER = 1380533830;
    private static final String VP8X_WEBP_BASE64 = "UklGRkoAAABXRUJQVlA4WAoAAAAQAAAAAAAAAAAAQUxQSAwAAAARBxAR/Q9ERP8DAABWUDggGAAAABQBAJ0BKgEAAQAAAP4AAA3AAP7mtQAAAA==";
    private static final int WEBP_EXTENDED_ALPHA_FLAG = 16;
    private static final int WEBP_EXTENDED_ANIM_FLAG = 2;
    private static final int WEBP_HEADER = 1464156752;
    private static final int WEBP_LOSSLESS_ALPHA_FLAG = 8;
    private static final int WEBP_VP8L_HEADER = 1448097868;
    private static final int WEBP_VP8X_HEADER = 1448097880;
    private static final int WEBP_VP8_HEADER = 1448097824;
    public static final boolean sIsExtendedWebpSupported = isExtendedWebpSupported();

    public enum WebpImageType {
        WEBP_SIMPLE(false, false),
        WEBP_LOSSLESS(false, false),
        WEBP_LOSSLESS_WITH_ALPHA(true, false),
        WEBP_EXTENDED(false, false),
        WEBP_EXTENDED_WITH_ALPHA(true, false),
        WEBP_EXTENDED_ANIMATED(false, true),
        NONE_WEBP(false, false);

        private final boolean hasAlpha;
        private final boolean hasAnimation;

        WebpImageType(boolean z, boolean z2) {
            this.hasAlpha = z;
            this.hasAnimation = z2;
        }

        public boolean hasAlpha() {
            return this.hasAlpha;
        }

        public boolean hasAnimation() {
            return this.hasAnimation;
        }
    }

    private static WebpImageType getType(Reader reader) throws IOException {
        if ((((reader.getUInt16() << 16) & (-65536)) | (reader.getUInt16() & 65535)) != RIFF_HEADER) {
            return WebpImageType.NONE_WEBP;
        }
        reader.skip(4L);
        if ((((reader.getUInt16() << 16) & (-65536)) | (reader.getUInt16() & 65535)) != WEBP_HEADER) {
            return WebpImageType.NONE_WEBP;
        }
        int uInt16 = ((reader.getUInt16() << 16) & (-65536)) | (reader.getUInt16() & 65535);
        if (uInt16 == WEBP_VP8_HEADER) {
            return WebpImageType.WEBP_SIMPLE;
        }
        if (uInt16 == WEBP_VP8L_HEADER) {
            reader.skip(4L);
            return (reader.getByte() & 8) != 0 ? WebpImageType.WEBP_LOSSLESS_WITH_ALPHA : WebpImageType.WEBP_LOSSLESS;
        }
        if (uInt16 != WEBP_VP8X_HEADER) {
            return WebpImageType.NONE_WEBP;
        }
        reader.skip(4L);
        int i = reader.getByte();
        return (i & 2) != 0 ? WebpImageType.WEBP_EXTENDED_ANIMATED : (i & 16) != 0 ? WebpImageType.WEBP_EXTENDED_WITH_ALPHA : WebpImageType.WEBP_EXTENDED;
    }

    public static WebpImageType getType(InputStream inputStream, ArrayPool arrayPool) throws IOException {
        if (inputStream == null) {
            return WebpImageType.NONE_WEBP;
        }
        if (!inputStream.markSupported()) {
            inputStream = new RecyclableBufferedInputStream(inputStream, arrayPool);
        }
        inputStream.mark(21);
        try {
            return getType((Reader) new StreamReader((InputStream) Preconditions.checkNotNull(inputStream)));
        } finally {
            inputStream.reset();
        }
    }

    public static WebpImageType getType(ByteBuffer byteBuffer) throws IOException {
        return byteBuffer == null ? WebpImageType.NONE_WEBP : getType((Reader) new ByteBufferReader((ByteBuffer) Preconditions.checkNotNull(byteBuffer)));
    }

    public static WebpImageType getType(byte[] bArr) throws IOException {
        return getType(bArr, 0, bArr.length);
    }

    public static WebpImageType getType(byte[] bArr, int i, int i2) throws IOException {
        return getType((Reader) new ByteArrayReader(bArr, i, i2));
    }

    public static boolean isAnimatedWebpType(WebpImageType webpImageType) {
        return webpImageType == WebpImageType.WEBP_EXTENDED_ANIMATED;
    }

    public static boolean isExtendedWebpSupported() {
        return true;
    }

    public static boolean isNonSimpleWebpType(WebpImageType webpImageType) {
        return (webpImageType == WebpImageType.NONE_WEBP || webpImageType == WebpImageType.WEBP_SIMPLE) ? false : true;
    }

    public static boolean isStaticWebpType(WebpImageType webpImageType) {
        return webpImageType == WebpImageType.WEBP_SIMPLE || webpImageType == WebpImageType.WEBP_LOSSLESS || webpImageType == WebpImageType.WEBP_LOSSLESS_WITH_ALPHA || webpImageType == WebpImageType.WEBP_EXTENDED || webpImageType == WebpImageType.WEBP_EXTENDED_WITH_ALPHA;
    }
}
