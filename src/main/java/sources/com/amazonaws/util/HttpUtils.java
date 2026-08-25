package com.amazonaws.util;

import com.amazonaws.Request;
import com.amazonaws.http.HttpMethodName;
import com.bumptech.glide.load.Key;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLEncoder;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class HttpUtils {
    private static final Pattern a = Pattern.compile(Pattern.quote("+") + "|" + Pattern.quote("*") + "|" + Pattern.quote("%7E") + "|" + Pattern.quote("%2F"));
    private static final Pattern b;

    static {
        StringBuilder sb = new StringBuilder();
        sb.append(Pattern.quote("%2A"));
        sb.append("|");
        sb.append(Pattern.quote("%2B"));
        sb.append("|");
        b = Pattern.compile(sb.toString());
    }

    public static String a(String str, String str2) {
        return b(str, str2, false);
    }

    public static String b(String str, String str2, boolean z) {
        if (str2 == null || str2.length() <= 0) {
            if (str.endsWith("/")) {
                return str;
            }
            return str + "/";
        }
        if (str2.startsWith("/")) {
            if (str.endsWith("/")) {
                str = str.substring(0, str.length() - 1);
            }
        } else if (!str.endsWith("/")) {
            str = str + "/";
        }
        String e = e(str2, true);
        if (z) {
            e = e.replace("//", "/%2F");
        }
        return str + e;
    }

    public static String c(Request request) {
        if (request.getParameters().isEmpty()) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        try {
            boolean z = true;
            for (Map.Entry entry : request.getParameters().entrySet()) {
                String encode = URLEncoder.encode((String) entry.getKey(), Key.STRING_CHARSET_NAME);
                String str = (String) entry.getValue();
                String encode2 = str == null ? "" : URLEncoder.encode(str, Key.STRING_CHARSET_NAME);
                if (z) {
                    z = false;
                } else {
                    sb.append("&");
                }
                sb.append(encode);
                sb.append("=");
                sb.append(encode2);
            }
            return sb.toString();
        } catch (UnsupportedEncodingException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static boolean d(URI uri) {
        String b2 = StringUtils.b(uri.getScheme());
        int port = uri.getPort();
        if (port <= 0) {
            return false;
        }
        if ("http".equals(b2) && port == 80) {
            return false;
        }
        return ("https".equals(b2) && port == 443) ? false : true;
    }

    public static String e(String str, boolean z) {
        if (str == null) {
            return "";
        }
        try {
            String encode = URLEncoder.encode(str, Key.STRING_CHARSET_NAME);
            Matcher matcher = a.matcher(encode);
            StringBuffer stringBuffer = new StringBuffer(encode.length());
            while (matcher.find()) {
                String group = matcher.group(0);
                if ("+".equals(group)) {
                    group = "%20";
                } else if ("*".equals(group)) {
                    group = "%2A";
                } else if ("%7E".equals(group)) {
                    group = "~";
                } else if (z && "%2F".equals(group)) {
                    group = "/";
                }
                matcher.appendReplacement(stringBuffer, group);
            }
            matcher.appendTail(stringBuffer);
            return stringBuffer.toString();
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean f(Request request) {
        return HttpMethodName.POST.equals(request.m()) && (request.getContent() == null);
    }
}
