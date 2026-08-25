package com.bykv.vk.openvk.preload.a.b.a.a;

import java.text.ParseException;
import java.text.ParsePosition;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public final class a {
    private static final TimeZone a = TimeZone.getTimeZone("UTC");

    private static int a(String str, int i) {
        while (i < str.length()) {
            char charAt = str.charAt(i);
            if (charAt < '0' || charAt > '9') {
                return i;
            }
            i++;
        }
        return str.length();
    }

    private static int a(String str, int i, int i2) throws NumberFormatException {
        int i3;
        int i4;
        if (i < 0 || i2 > str.length() || i > i2) {
            throw new NumberFormatException(str);
        }
        if (i < i2) {
            i4 = i + 1;
            int digit = Character.digit(str.charAt(i), 10);
            if (digit < 0) {
                throw new NumberFormatException("Invalid number: " + str.substring(i, i2));
            }
            i3 = -digit;
        } else {
            i3 = 0;
            i4 = i;
        }
        while (i4 < i2) {
            int i8 = i4 + 1;
            int digit2 = Character.digit(str.charAt(i4), 10);
            if (digit2 < 0) {
                throw new NumberFormatException("Invalid number: " + str.substring(i, i2));
            }
            i3 = (i3 * 10) - digit2;
            i4 = i8;
        }
        return -i3;
    }

    /* JADX WARN: Removed duplicated region for block: B:82:0x01be  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x01d9  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x01c0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Date a(String str, ParsePosition parsePosition) throws ParseException {
        String str2;
        String message;
        int i;
        int i2;
        int i3;
        int i4;
        int length;
        TimeZone timeZone;
        char charAt;
        try {
            int index = parsePosition.getIndex();
            int i8 = index + 4;
            int a2 = a(str, index, i8);
            if (a(str, i8, '-')) {
                i8 = index + 5;
            }
            int i9 = i8 + 2;
            int a3 = a(str, i8, i9);
            if (a(str, i9, '-')) {
                i9 = i8 + 3;
            }
            int i10 = i9 + 2;
            int a4 = a(str, i9, i10);
            boolean a8 = a(str, i10, 'T');
            if (!a8 && str.length() <= i10) {
                GregorianCalendar gregorianCalendar = new GregorianCalendar(a2, a3 - 1, a4);
                parsePosition.setIndex(i10);
                return gregorianCalendar.getTime();
            }
            if (a8) {
                int i11 = i9 + 5;
                int a9 = a(str, i9 + 3, i11);
                if (a(str, i11, ':')) {
                    i11 = i9 + 6;
                }
                int i12 = i11 + 2;
                int a10 = a(str, i11, i12);
                if (a(str, i12, ':')) {
                    i12 = i11 + 3;
                }
                if (str.length() <= i12 || (charAt = str.charAt(i12)) == 'Z' || charAt == '+' || charAt == '-') {
                    i2 = a10;
                    i3 = 0;
                    i4 = 0;
                    i10 = i12;
                    i = a9;
                } else {
                    int i13 = i12 + 2;
                    i4 = a(str, i12, i13);
                    if (i4 > 59 && i4 < 63) {
                        i4 = 59;
                    }
                    if (a(str, i13, '.')) {
                        int i14 = i12 + 3;
                        int a11 = a(str, i12 + 4);
                        int min = Math.min(a11, i12 + 6);
                        int a12 = a(str, i14, min);
                        int i15 = min - i14;
                        if (i15 == 1) {
                            a12 *= 100;
                        } else if (i15 == 2) {
                            a12 *= 10;
                        }
                        i = a9;
                        i10 = a11;
                        i2 = a10;
                        i3 = a12;
                    } else {
                        i = a9;
                        i10 = i13;
                        i2 = a10;
                        i3 = 0;
                    }
                }
            } else {
                i = 0;
                i2 = 0;
                i3 = 0;
                i4 = 0;
            }
            if (str.length() <= i10) {
                throw new IllegalArgumentException("No time zone indicator");
            }
            char charAt2 = str.charAt(i10);
            if (charAt2 == 'Z') {
                timeZone = a;
                length = i10 + 1;
            } else {
                if (charAt2 != '+' && charAt2 != '-') {
                    throw new IndexOutOfBoundsException("Invalid time zone indicator '" + charAt2 + "'");
                }
                String substring = str.substring(i10);
                if (substring.length() < 5) {
                    substring = substring + "00";
                }
                length = i10 + substring.length();
                if (!"+0000".equals(substring) && !"+00:00".equals(substring)) {
                    String concat = "GMT".concat(substring);
                    TimeZone timeZone2 = TimeZone.getTimeZone(concat);
                    String id = timeZone2.getID();
                    if (!id.equals(concat) && !id.replace(":", "").equals(concat)) {
                        throw new IndexOutOfBoundsException("Mismatching time zone indicator: " + concat + " given, resolves to " + timeZone2.getID());
                    }
                    timeZone = timeZone2;
                }
                timeZone = a;
            }
            GregorianCalendar gregorianCalendar2 = new GregorianCalendar(timeZone);
            gregorianCalendar2.setLenient(false);
            gregorianCalendar2.set(1, a2);
            gregorianCalendar2.set(2, a3 - 1);
            gregorianCalendar2.set(5, a4);
            gregorianCalendar2.set(11, i);
            gregorianCalendar2.set(12, i2);
            gregorianCalendar2.set(13, i4);
            gregorianCalendar2.set(14, i3);
            parsePosition.setIndex(length);
            return gregorianCalendar2.getTime();
        } catch (IllegalArgumentException e) {
            e = e;
            if (str == null) {
                str2 = null;
            } else {
                str2 = "\"" + str + '\"';
            }
            message = e.getMessage();
            if (message != null || message.isEmpty()) {
                message = "(" + e.getClass().getName() + ")";
            }
            ParseException parseException = new ParseException("Failed to parse date [" + str2 + "]: " + message, parsePosition.getIndex());
            parseException.initCause(e);
            throw parseException;
        } catch (IndexOutOfBoundsException e2) {
            e = e2;
            if (str == null) {
            }
            message = e.getMessage();
            if (message != null) {
            }
            message = "(" + e.getClass().getName() + ")";
            ParseException parseException2 = new ParseException("Failed to parse date [" + str2 + "]: " + message, parsePosition.getIndex());
            parseException2.initCause(e);
            throw parseException2;
        } catch (NumberFormatException e3) {
            e = e3;
            if (str == null) {
            }
            message = e.getMessage();
            if (message != null) {
            }
            message = "(" + e.getClass().getName() + ")";
            ParseException parseException22 = new ParseException("Failed to parse date [" + str2 + "]: " + message, parsePosition.getIndex());
            parseException22.initCause(e);
            throw parseException22;
        }
    }

    private static boolean a(String str, int i, char c) {
        return i < str.length() && str.charAt(i) == c;
    }
}
