package com.amazonaws.util;

import com.amazonaws.internal.config.HostRegexToRegionMapping;
import com.amazonaws.internal.config.InternalConfig;
import java.net.URI;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class AwsHostNameUtils {
    private static final Pattern a = Pattern.compile("^(?:.+\\.)?s3[.-]([a-z0-9-]+)$");

    public static String a(String str, String str2) {
        if (str == null) {
            throw new IllegalArgumentException("hostname cannot be null");
        }
        String b = b(str);
        if (b != null) {
            return b;
        }
        if (str.endsWith(".amazonaws.com")) {
            return d(str.substring(0, str.length() - 14));
        }
        if (str.endsWith(".amazonaws.com.cn")) {
            return d(str.substring(0, str.length() - 17));
        }
        if (str2 == null) {
            return "us-east-1";
        }
        Matcher matcher = Pattern.compile("^(?:.+\\.)?" + Pattern.quote(str2) + "[.-]([a-z0-9-]+)\\.").matcher(str);
        return matcher.find() ? matcher.group(1) : "us-east-1";
    }

    private static String b(String str) {
        for (HostRegexToRegionMapping hostRegexToRegionMapping : InternalConfig.Factory.a().g()) {
            if (str.matches(hostRegexToRegionMapping.a())) {
                return hostRegexToRegionMapping.b();
            }
        }
        return null;
    }

    public static String c(URI uri) {
        String host = uri.getHost();
        if (host.endsWith(".amazonaws.com")) {
            String substring = host.substring(0, host.indexOf(".amazonaws.com"));
            return (substring.endsWith(".s3") || a.matcher(substring).matches()) ? "s3" : substring.indexOf(46) == -1 ? substring : substring.substring(0, substring.indexOf(46));
        }
        throw new IllegalArgumentException("Cannot parse a service name from an unrecognized endpoint (" + host + ").");
    }

    private static String d(String str) {
        Matcher matcher = a.matcher(str);
        if (matcher.matches()) {
            return matcher.group(1);
        }
        int lastIndexOf = str.lastIndexOf(46);
        if (lastIndexOf == -1) {
            return "us-east-1";
        }
        String substring = str.substring(lastIndexOf + 1);
        return "us-gov".equals(substring) ? "us-gov-west-1" : substring;
    }
}
