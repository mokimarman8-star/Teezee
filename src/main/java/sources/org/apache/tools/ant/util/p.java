package org.apache.tools.ant.util;

import okhttp3.internal.ws.RealWebSocket;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public abstract class p {
    public static final String a = System.getProperty("line.separator");

    public static long a(String str) {
        long j;
        char charAt = str.charAt(0);
        int i = 1;
        long j2 = 1;
        if (charAt == '+') {
            str = str.substring(1);
        } else if (charAt == '-') {
            str = str.substring(1);
            j2 = -1;
        }
        char charAt2 = str.charAt(str.length() - 1);
        if (!Character.isDigit(charAt2)) {
            if (charAt2 == 'G') {
                j = 1073741824;
            } else if (charAt2 == 'K') {
                j = RealWebSocket.DEFAULT_MINIMUM_DEFLATE_SIZE;
            } else if (charAt2 == 'M') {
                j = 1048576;
            } else if (charAt2 == 'P') {
                j = 1125899906842624L;
            } else if (charAt2 != 'T') {
                i = 0;
                str = str.substring(0, str.length() - i);
            } else {
                j = 1099511627776L;
            }
            j2 *= j;
            str = str.substring(0, str.length() - i);
        }
        return j2 * Long.parseLong(str);
    }
}
