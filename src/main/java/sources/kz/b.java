package kz;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.StringCharacterIterator;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public abstract class b {
    private static boolean[] a = new boolean[128];
    private static char[] b = new char[128];
    private static char[] c = new char[128];
    private static char[] d = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    static {
        for (int i = 0; i < 32; i++) {
            a[i] = true;
            char[] cArr = b;
            char[] cArr2 = d;
            cArr[i] = cArr2[i >> 4];
            c[i] = cArr2[i & 15];
        }
        a[127] = true;
        b[127] = '7';
        c[127] = 'F';
        char[] cArr3 = {' ', '<', '>', '#', '%', '\"', '{', '}', '|', '\\', '^', '~', '[', ']', '`'};
        for (int i2 = 0; i2 < 15; i2++) {
            char c2 = cArr3[i2];
            a[c2] = true;
            char[] cArr4 = b;
            char[] cArr5 = d;
            cArr4[c2] = cArr5[c2 >> 4];
            c[c2] = cArr5[c2 & 15];
        }
    }

    public static String a(String str) {
        if (str.indexOf(37) == -1) {
            return str;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(str.length());
        StringCharacterIterator stringCharacterIterator = new StringCharacterIterator(str);
        for (char first = stringCharacterIterator.first(); first != 65535; first = stringCharacterIterator.next()) {
            if (first == '%') {
                char next = stringCharacterIterator.next();
                if (next != 65535) {
                    int digit = Character.digit(next, 16);
                    char next2 = stringCharacterIterator.next();
                    if (next2 != 65535) {
                        byteArrayOutputStream.write((char) ((digit << 4) + Character.digit(next2, 16)));
                    }
                }
            } else {
                byteArrayOutputStream.write(first);
            }
        }
        return byteArrayOutputStream.toString("UTF-8");
    }

    public static String b(String str) {
        char charAt;
        int length = str.length();
        StringBuffer stringBuffer = null;
        int i = 0;
        while (i < length && (charAt = str.charAt(i)) < 128) {
            if (a[charAt]) {
                if (stringBuffer == null) {
                    stringBuffer = new StringBuffer(str.substring(0, i));
                }
                stringBuffer.append('%');
                stringBuffer.append(b[charAt]);
                stringBuffer.append(c[charAt]);
            } else if (stringBuffer != null) {
                stringBuffer.append(charAt);
            }
            i++;
        }
        if (i < length) {
            if (stringBuffer == null) {
                stringBuffer = new StringBuffer(str.substring(0, i));
            }
            for (byte b2 : str.substring(i).getBytes("UTF-8")) {
                if (b2 < 0) {
                    int i2 = b2 + 256;
                    stringBuffer.append('%');
                    stringBuffer.append(d[i2 >> 4]);
                    stringBuffer.append(d[i2 & 15]);
                } else if (a[b2]) {
                    stringBuffer.append('%');
                    stringBuffer.append(b[b2]);
                    stringBuffer.append(c[b2]);
                } else {
                    stringBuffer.append((char) b2);
                }
            }
        }
        return stringBuffer == null ? str : stringBuffer.toString();
    }

    public static String c(String str) {
        return d(str);
    }

    static String d(String str) {
        URL url;
        try {
            url = new URL(str);
        } catch (MalformedURLException unused) {
            url = null;
        }
        if (url == null || !"file".equals(url.getProtocol())) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Can only handle valid file: URIs, not ");
            stringBuffer.append(str);
            throw new IllegalArgumentException(stringBuffer.toString());
        }
        StringBuffer stringBuffer2 = new StringBuffer(url.getHost());
        if (stringBuffer2.length() > 0) {
            char c2 = File.separatorChar;
            stringBuffer2.insert(0, c2).insert(0, c2);
        }
        String file = url.getFile();
        int indexOf = file.indexOf(63);
        if (indexOf >= 0) {
            file = file.substring(0, indexOf);
        }
        stringBuffer2.append(file);
        String replace = stringBuffer2.toString().replace('/', File.separatorChar);
        if (File.pathSeparatorChar == ';' && replace.startsWith("\\") && replace.length() > 2 && Character.isLetter(replace.charAt(1)) && replace.lastIndexOf(58) > -1) {
            replace = replace.substring(1);
        }
        try {
            String a2 = a(replace);
            String property = System.getProperty("user.dir");
            int indexOf2 = property.indexOf(":");
            if (indexOf2 <= 0 || !a2.startsWith(File.separator)) {
                return a2;
            }
            StringBuffer stringBuffer3 = new StringBuffer();
            stringBuffer3.append(property.substring(0, indexOf2 + 1));
            stringBuffer3.append(a2);
            return stringBuffer3.toString();
        } catch (UnsupportedEncodingException e) {
            StringBuffer stringBuffer4 = new StringBuffer();
            stringBuffer4.append("Could not convert URI ");
            stringBuffer4.append(replace);
            stringBuffer4.append(" to path: ");
            stringBuffer4.append(e.getMessage());
            throw new IllegalStateException(stringBuffer4.toString());
        }
    }
}
