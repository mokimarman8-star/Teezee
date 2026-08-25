package com.cloud.tmc.kernel.utils;

import android.os.Bundle;
import android.text.TextUtils;
import com.cloud.tmc.kernel.BuildConfig;
import com.cloud.tmc.kernel.constants.TmcConstants;
import com.cloud.tmc.kernel.log.TmcLogger;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J&\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\u0004H\u0002J\u001c\u0010\n\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/cloud/tmc/kernel/utils/KUrlUtils;", "", "()V", "TAG", "", "generateNewQueryString", "url", TmcConstants.EXTRA_START_PARAMS, "Landroid/os/Bundle;", "h5PathQuery", "generateShellUrl", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class KUrlUtils {
    public static final KUrlUtils INSTANCE = new KUrlUtils();
    private static final String TAG = "KUrlUtils";

    private KUrlUtils() {
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:41:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final String generateNewQueryString(String url, Bundle startParams, String h5PathQuery) {
        String str;
        String str2 = h5PathQuery;
        String string = startParams != null ? startParams.getString("query") : null;
        if (string == null) {
            string = "";
        }
        TmcLogger.d(TAG, "Query 参数：" + string);
        StringBuilder sb = new StringBuilder();
        sb.append("QueryCopy 参数：");
        sb.append(startParams != null ? startParams.getString(TmcConstants.EXTRA_QUERY_COPY) : null);
        TmcLogger.d(TAG, sb.toString());
        TmcLogger.d(TAG, "h5PathQuery 参数：" + str2);
        if (string.length() > 0 && h5PathQuery.length() > 0) {
            str2 = str2 + '&' + string;
        } else if (string.length() != 0 || h5PathQuery.length() <= 0) {
            str = string;
            TmcLogger.d(TAG, "组装后Query 参数：" + str);
            if (str.length() > 0) {
                return null;
            }
            if (startParams != null) {
                String string2 = startParams.getString("query");
                if (string2 == null) {
                    string2 = "";
                }
                startParams.putString(TmcConstants.EXTRA_QUERY_COPY, string2);
            }
            if (startParams != null) {
                startParams.remove("query");
            }
            List S0 = StringsKt.S0(str, new String[]{UrlUtils.AND_MARK}, false, 0, 6, (Object) null);
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            int size = S0.size();
            for (int i = 0; i < size; i++) {
                List S02 = StringsKt.S0((CharSequence) S0.get(i), new String[]{UrlUtils.EQUAL_MARK}, false, 0, 6, (Object) null);
                if (S02.size() == 2) {
                    linkedHashMap.put((String) S02.get(0), (String) S02.get(1));
                }
            }
            String addParams = UrlUtils.addParams(url, linkedHashMap, true);
            return UrlUtils.getQuery(addParams != null ? addParams : "");
        }
        str = str2;
        TmcLogger.d(TAG, "组装后Query 参数：" + str);
        if (str.length() > 0) {
        }
    }

    @JvmStatic
    public static final String generateShellUrl(String url, Bundle startParams) {
        StringBuilder sb;
        String str;
        try {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("原链接：");
            sb2.append(url);
            sb2.append(", startParams:");
            sb2.append(startParams != null ? Integer.valueOf(startParams.hashCode()) : null);
            TmcLogger.d(TAG, sb2.toString());
            String scheme = UrlUtils.getScheme(url);
            if (scheme == null) {
                scheme = "";
            }
            String host = UrlUtils.getHost(url);
            if (host == null) {
                host = "";
            }
            String path = UrlUtils.getPath(url);
            if (path == null) {
                path = "";
            }
            int port = UrlUtils.getPort(url);
            String query = UrlUtils.getQuery(url);
            if (query == null) {
                query = "";
            }
            TmcLogger.d(TAG, "originQuery ->" + query);
            if (scheme.length() != 0 && host.length() != 0 && path.length() != 0) {
                if (port != -1) {
                    sb = new StringBuilder(scheme + "://" + host + ':' + port);
                } else {
                    sb = new StringBuilder(scheme + "://" + host);
                }
                String string = startParams != null ? startParams.getString("h5Path") : null;
                if (string == null) {
                    string = "";
                }
                TmcLogger.d(TAG, "H5Path 真实地址：" + string);
                StringBuilder sb3 = new StringBuilder();
                sb3.append("H5PathCopy 真实地址：");
                sb3.append(startParams != null ? startParams.getString(TmcConstants.EXTRA_H5_PATH_COPY) : null);
                TmcLogger.d(TAG, sb3.toString());
                List S0 = StringsKt.S0(string, new String[]{UrlUtils.QUESTION_MARK}, false, 0, 6, (Object) null);
                if (S0.size() == 2) {
                    string = (String) S0.get(0);
                    str = (String) S0.get(1);
                } else {
                    str = "";
                }
                String generateNewQueryString = INSTANCE.generateNewQueryString(url, startParams, str);
                TmcLogger.d(TAG, "H5Path 解析后地址：" + string);
                if (string.length() > 0) {
                    if (startParams != null) {
                        String string2 = startParams.getString("h5Path");
                        if (string2 == null) {
                            string2 = "";
                        }
                        startParams.putString(TmcConstants.EXTRA_H5_PATH_COPY, string2);
                    }
                    if (startParams != null) {
                        startParams.remove("h5Path");
                    }
                    if (StringsKt.W(string, "/", false, 2, (Object) null)) {
                        sb.append(string);
                    } else {
                        sb.append('/' + string);
                    }
                } else {
                    TmcLogger.d(TAG, "originPath ->" + path);
                    if (StringsKt.W(path, "/", false, 2, (Object) null)) {
                        sb.append(path);
                    } else {
                        sb.append('/' + path);
                    }
                }
                if (generateNewQueryString != null) {
                    query = generateNewQueryString;
                }
                TmcLogger.d(TAG, "baseUrl->" + ((Object) sb));
                TmcLogger.d(TAG, "realQuery ->" + query);
                if (!TextUtils.isEmpty(query)) {
                    sb.append(UrlUtils.QUESTION_MARK);
                    sb.append(query);
                }
                String sb4 = sb.toString();
                Intrinsics.g(sb4, "baseUrl.toString()");
                TmcLogger.d(TAG, "新链接：" + sb4);
                return sb4;
            }
            TmcLogger.d(TAG, "原链接检查到 scheme: " + scheme + " and originHost: " + host + " and originPath: " + path + " 含有 empty 内容");
            return url == null ? "" : url;
        } catch (Throwable th) {
            TmcLogger.e(TAG, "Error generateShellUrl failed!", th);
            return url == null ? "" : url;
        }
    }
}
