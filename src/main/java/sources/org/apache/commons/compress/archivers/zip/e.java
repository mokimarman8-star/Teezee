package org.apache.commons.compress.archivers.zip;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CodingErrorAction;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
class e implements r {
    private static final byte[] c = {63};
    private static final String d = String.valueOf('?');
    private static final char[] e = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    private final Charset a;
    private final boolean b;

    e(Charset charset, boolean z) {
        this.a = charset;
        this.b = z;
    }

    private CharsetDecoder b() {
        if (this.b) {
            CharsetDecoder newDecoder = this.a.newDecoder();
            CodingErrorAction codingErrorAction = CodingErrorAction.REPLACE;
            return newDecoder.onMalformedInput(codingErrorAction).onUnmappableCharacter(codingErrorAction).replaceWith(d);
        }
        CharsetDecoder newDecoder2 = this.a.newDecoder();
        CodingErrorAction codingErrorAction2 = CodingErrorAction.REPORT;
        return newDecoder2.onMalformedInput(codingErrorAction2).onUnmappableCharacter(codingErrorAction2);
    }

    @Override // org.apache.commons.compress.archivers.zip.r
    public String a(byte[] bArr) {
        return b().decode(ByteBuffer.wrap(bArr)).toString();
    }
}
