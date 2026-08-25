package com.squareup.okhttp.internal.http;

import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import com.squareup.okhttp.Protocol;
import java.net.ProtocolException;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public final class m {
    public final Protocol a;
    public final int b;
    public final String c;

    public m(Protocol protocol, int i, String str) {
        this.a = protocol;
        this.b = i;
        this.c = str;
    }

    public static m a(String str) {
        Protocol protocol;
        int i;
        String str2;
        if (str.startsWith("HTTP/1.")) {
            i = 9;
            if (str.length() < 9 || str.charAt(8) != ' ') {
                throw new ProtocolException("Unexpected status line: " + str);
            }
            int charAt = str.charAt(7) - '0';
            if (charAt == 0) {
                protocol = Protocol.HTTP_1_0;
            } else {
                if (charAt != 1) {
                    throw new ProtocolException("Unexpected status line: " + str);
                }
                protocol = Protocol.HTTP_1_1;
            }
        } else {
            if (!str.startsWith("ICY ")) {
                throw new ProtocolException("Unexpected status line: " + str);
            }
            protocol = Protocol.HTTP_1_0;
            i = 4;
        }
        int i2 = i + 3;
        if (str.length() < i2) {
            throw new ProtocolException("Unexpected status line: " + str);
        }
        try {
            int parseInt = Integer.parseInt(str.substring(i, i2));
            if (str.length() <= i2) {
                str2 = TtmlNode.ANONYMOUS_REGION_ID;
            } else {
                if (str.charAt(i2) != ' ') {
                    throw new ProtocolException("Unexpected status line: " + str);
                }
                str2 = str.substring(i + 4);
            }
            return new m(protocol, parseInt, str2);
        } catch (NumberFormatException unused) {
            throw new ProtocolException("Unexpected status line: " + str);
        }
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.a == Protocol.HTTP_1_0 ? "HTTP/1.0" : "HTTP/1.1");
        sb2.append(' ');
        sb2.append(this.b);
        if (this.c != null) {
            sb2.append(' ');
            sb2.append(this.c);
        }
        return sb2.toString();
    }
}
