package com.amazonaws.services.s3.internal;

import com.amazonaws.Request;
import com.amazonaws.util.StringUtils;
import com.cloud.config.utils.ConstantsKt;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class RestUtils {
    private static final List a = Arrays.asList("acl", "torrent", "logging", "location", "policy", "requestPayment", "versioning", "versions", "versionId", "notification", "uploadId", "uploads", "partNumber", "website", "delete", "lifecycle", "tagging", "cors", "restore", "replication", "accelerate", "inventory", "analytics", "metrics", "response-cache-control", "response-content-disposition", "response-content-encoding", "response-content-language", "response-content-type", "response-expires");

    public static String a(String str, String str2, Request request, String str3, Collection collection) {
        StringBuilder sb = new StringBuilder();
        sb.append(str + "\n");
        Map headers = request.getHeaders();
        TreeMap treeMap = new TreeMap();
        if (headers != null && headers.size() > 0) {
            for (Map.Entry entry : headers.entrySet()) {
                String str4 = (String) entry.getKey();
                String str5 = (String) entry.getValue();
                if (str4 != null) {
                    String b = StringUtils.b(str4);
                    if ("content-type".equals(b) || ConstantsKt.CONTENT_MD5.equals(b) || "date".equals(b) || b.startsWith("x-amz-")) {
                        treeMap.put(b, str5);
                    }
                }
            }
        }
        if (treeMap.containsKey("x-amz-date")) {
            treeMap.put("date", "");
        }
        if (str3 != null) {
            treeMap.put("date", str3);
        }
        if (!treeMap.containsKey("content-type")) {
            treeMap.put("content-type", "");
        }
        if (!treeMap.containsKey(ConstantsKt.CONTENT_MD5)) {
            treeMap.put(ConstantsKt.CONTENT_MD5, "");
        }
        for (Map.Entry entry2 : request.getParameters().entrySet()) {
            if (((String) entry2.getKey()).startsWith("x-amz-")) {
                treeMap.put(entry2.getKey(), entry2.getValue());
            }
        }
        for (Map.Entry entry3 : treeMap.entrySet()) {
            String str6 = (String) entry3.getKey();
            String str7 = (String) entry3.getValue();
            if (str6.startsWith("x-amz-")) {
                sb.append(str6);
                sb.append(':');
                if (str7 != null) {
                    sb.append(str7);
                }
            } else if (str7 != null) {
                sb.append(str7);
            }
            sb.append("\n");
        }
        sb.append(str2);
        String[] strArr = (String[]) request.getParameters().keySet().toArray(new String[request.getParameters().size()]);
        Arrays.sort(strArr);
        char c = '?';
        for (String str8 : strArr) {
            if (a.contains(str8) || (collection != null && collection.contains(str8))) {
                if (sb.length() == 0) {
                    sb.append(c);
                }
                sb.append(str8);
                String str9 = (String) request.getParameters().get(str8);
                if (str9 != null) {
                    sb.append("=");
                    sb.append(str9);
                }
                c = '&';
            }
        }
        return sb.toString();
    }
}
