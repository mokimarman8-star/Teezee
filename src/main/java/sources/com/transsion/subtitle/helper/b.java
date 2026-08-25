package com.transsion.subtitle.helper;

import com.blankj.utilcode.util.o;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import com.transsion.subtitle.bean.OpenSubtitleData;
import com.transsion.subtitle.bean.OpenSubtitleDownloadInfo;
import com.transsion.subtitle.bean.OpenSubtitleResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeoutException;
import javax.net.ssl.SSLHandshakeException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.Regex;
import okhttp3.HttpUrl;
import rc.e;
import wf.a;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class b {
    public static final b a = new b();

    private b() {
    }

    private final String a(String str) {
        int hashCode = str.hashCode();
        return hashCode != 3588 ? hashCode != 3886 ? (hashCode == 100341365 && str.equals("in_id")) ? "id" : str : !str.equals("zh") ? str : "zh-cn" : !str.equals("pt") ? str : "pt-pt";
    }

    private final String c(InputStream inputStream) {
        try {
            try {
                try {
                    InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
                    char[] cArr = new char[512];
                    StringBuffer stringBuffer = new StringBuffer();
                    Ref.IntRef intRef = new Ref.IntRef();
                    while (true) {
                        int read = inputStreamReader.read(cArr);
                        intRef.element = read;
                        if (read == -1) {
                            break;
                        }
                        stringBuffer.append(cArr, 0, read);
                    }
                    String stringBuffer2 = stringBuffer.toString();
                    try {
                        inputStream.close();
                    } catch (Exception unused) {
                    }
                    return stringBuffer2;
                } catch (Throwable th) {
                    try {
                        inputStream.close();
                    } catch (Exception unused2) {
                    }
                    throw th;
                }
            } catch (IOException e) {
                e.printStackTrace();
                try {
                    inputStream.close();
                    return null;
                } catch (Exception unused3) {
                    return null;
                }
            }
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
            inputStream.close();
            return null;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterative(DepthRegionTraversal.java:31)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visit(SwitchOverStringVisitor.java:60)
     */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00a2 A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String b(String lan) {
        Intrinsics.h(lan, "lan");
        switch (lan.hashCode()) {
            case 3121:
                return !lan.equals("ar") ? HttpUrl.FRAGMENT_ENCODE_SET : "عربي";
            case 3148:
                if (lan.equals("bn")) {
                    return "বাংলা";
                }
                break;
            case 3241:
                if (lan.equals("en")) {
                    return "English";
                }
                break;
            case 3276:
                if (lan.equals("fr")) {
                    return "Français";
                }
                break;
            case 3329:
                if (lan.equals("hi")) {
                    return "हिन्दी";
                }
                break;
            case 3355:
                if (lan.equals("id")) {
                    return "Indonesia";
                }
                break;
            case 3651:
                if (lan.equals("ru")) {
                    return "Русский";
                }
                break;
            case 3684:
                if (lan.equals("sw")) {
                    return "Swahili";
                }
                break;
            case 3741:
                if (lan.equals("ur")) {
                    return "اردو";
                }
                break;
            case 101385:
                if (lan.equals("fil")) {
                    return "Filipino";
                }
                break;
            case 106936941:
                if (lan.equals("pt-pt")) {
                    return "Português";
                }
                break;
            case 115814250:
                if (lan.equals("zh-cn")) {
                    return "中文(简体)";
                }
                break;
        }
    }

    public final Object d(String str, Continuation continuation) {
        String str2;
        try {
            a.a aVar = wf.a.a;
            com.transsion.baselib.report.a aVar2 = com.transsion.baselib.report.a.a;
            aVar.w(aVar2.a(), "Subtitle new api download info start:" + str + " ", true);
            URLConnection uRLConnection = (URLConnection) FirebasePerfUrlConnection.instrument(new URL("https://vip-api.opensubtitles.com/api/v1/download").openConnection());
            Intrinsics.f(uRLConnection, "null cannot be cast to non-null type java.net.HttpURLConnection");
            HttpURLConnection httpURLConnection = (HttpURLConnection) uRLConnection;
            httpURLConnection.setConnectTimeout(15000);
            httpURLConnection.setReadTimeout(15000);
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setRequestProperty("User-Agent", "player2024");
            httpURLConnection.setRequestProperty("Api-Key", "ZRN9QpqcTxje5UH3bV1RuugwitxkqB53");
            httpURLConnection.setRequestProperty("Content-Type", "application/json");
            httpURLConnection.setRequestProperty("Accept", "application/json");
            httpURLConnection.getDoOutput();
            OutputStream outputStream = httpURLConnection.getOutputStream();
            try {
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, StandardCharsets.UTF_8);
                outputStreamWriter.write("{\"file_id\":" + str + "}");
                outputStreamWriter.flush();
                Unit unit = Unit.a;
                CloseableKt.a(outputStream, null);
                InputStream inputStream = httpURLConnection.getInputStream();
                Intrinsics.g(inputStream, "getInputStream(...)");
                if (httpURLConnection.getResponseCode() == 200) {
                    aVar.c(aVar2.a(), "Subtitle new api, download info success ", true);
                    str2 = c(inputStream);
                } else {
                    aVar.w(aVar2.a(), "Subtitle new api download info fail ", true);
                    str2 = null;
                }
                return (OpenSubtitleDownloadInfo) o.d(str2, OpenSubtitleDownloadInfo.class);
            } finally {
            }
        } catch (Throwable th) {
            com.google.firebase.perf.metrics.h e = e.c().e("https://vip-api.opensubtitles.com/api/v1/download", "GET");
            Intrinsics.g(e, "newHttpMetric(...)");
            e.a(th instanceof SSLHandshakeException ? 87 : th instanceof ProtocolException ? 86 : th instanceof IOException ? 88 : th instanceof TimeoutException ? 85 : 89);
            th.printStackTrace();
            wf.a.a.c(com.transsion.baselib.report.a.a.a(), "Subtitle new api download info fail: " + th + " ", true);
            return null;
        }
    }

    public final Object e(String str, String str2, Integer num, Integer num2, Continuation continuation) {
        String str3;
        String str4;
        List<OpenSubtitleData> data;
        Regex regex = new Regex("[\\\\/:#*?\"<>|&,]");
        String str5 = HttpUrl.FRAGMENT_ENCODE_SET;
        String lowerCase = regex.replace(str, HttpUrl.FRAGMENT_ENCODE_SET).toLowerCase(Locale.ROOT);
        Intrinsics.g(lowerCase, "toLowerCase(...)");
        String a2 = a(str2);
        if (num == null && num2 == null) {
            str3 = "https://vip-api.opensubtitles.com/api/v1/subtitles?query=" + lowerCase + "&languages=" + a2;
        } else {
            str3 = "https://vip-api.opensubtitles.com/api/v1/subtitles?query=" + lowerCase + "&languages=" + a2 + "&season_number=" + num + "&episode_number=" + num2;
        }
        try {
            a.a aVar = wf.a.a;
            com.transsion.baselib.report.a aVar2 = com.transsion.baselib.report.a.a;
            aVar.c(aVar2.a(), "new api getSubtitleInfo url:" + str3, true);
            URLConnection uRLConnection = (URLConnection) FirebasePerfUrlConnection.instrument(new URL(str3).openConnection());
            Intrinsics.f(uRLConnection, "null cannot be cast to non-null type java.net.HttpURLConnection");
            HttpURLConnection httpURLConnection = (HttpURLConnection) uRLConnection;
            httpURLConnection.setConnectTimeout(15000);
            httpURLConnection.setReadTimeout(15000);
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setRequestProperty("User-Agent", "player2024");
            httpURLConnection.setRequestProperty("Api-Key", "ZRN9QpqcTxje5UH3bV1RuugwitxkqB53");
            httpURLConnection.connect();
            InputStream inputStream = httpURLConnection.getInputStream();
            Intrinsics.g(inputStream, "getInputStream(...)");
            if (httpURLConnection.getResponseCode() == 200) {
                aVar.c(aVar2.a(), "Subtitle new api success ", true);
                str4 = c(inputStream);
            } else {
                aVar.w(aVar2.a(), "Subtitle new api fail ", true);
                str4 = null;
            }
            OpenSubtitleResponse openSubtitleResponse = (OpenSubtitleResponse) o.d(str4, OpenSubtitleResponse.class);
            if (openSubtitleResponse != null && (data = openSubtitleResponse.getData()) != null && !data.isEmpty()) {
                return CollectionsKt.U0(openSubtitleResponse.getData());
            }
            f(3, "data is null");
            return null;
        } catch (Throwable th) {
            String message = th.getMessage();
            if (message != null) {
                str5 = message;
            }
            f(3, str5);
            th.printStackTrace();
            com.google.firebase.perf.metrics.h e = e.c().e(str3, "GET");
            Intrinsics.g(e, "newHttpMetric(...)");
            e.a(th instanceof SSLHandshakeException ? 87 : th instanceof ProtocolException ? 86 : th instanceof IOException ? 88 : th instanceof TimeoutException ? 85 : 89);
            wf.a.a.i(com.transsion.baselib.report.a.a.a(), "new api getSubtitleInfo FAIL :" + th, true);
            return null;
        }
    }

    public final void f(int i, String msg) {
        Intrinsics.h(msg, "msg");
        HashMap hashMap = new HashMap();
        hashMap.put("from", String.valueOf(i));
        hashMap.put("error_msg", msg);
        qi.h.a.q("subtitle_search", "app_perf", hashMap);
    }
}
