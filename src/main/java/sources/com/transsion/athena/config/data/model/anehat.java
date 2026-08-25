package com.transsion.athena.config.data.model;

import android.content.Context;
import android.os.Build;
import android.os.PowerManager;
import android.util.Log;
import androidx.core.util.j;
import com.transsion.api.gateway.utils.EncoderUtil;
import com.transsion.core.log.ObjectLogUtils;
import com.transsion.gslb.BuildConfig;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Collection;
import java.util.Iterator;
import java.util.Locale;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public class anehat {
    public static <E> int a(Collection<E> collection, j jVar) {
        int i = 0;
        if (a((Collection<?>) collection)) {
            return 0;
        }
        Iterator<E> it = collection.iterator();
        while (it.hasNext()) {
            if (jVar.a(it.next())) {
                i++;
            }
        }
        return i;
    }

    public static Boolean a(Context context, String str, boolean z) throws IllegalArgumentException {
        try {
            Class<?> loadClass = context.getClassLoader().loadClass("android.os.SystemProperties");
            return (Boolean) loadClass.getMethod("getBoolean", String.class, Boolean.TYPE).invoke(loadClass, str, Boolean.valueOf(z));
        } catch (IllegalArgumentException e) {
            throw e;
        } catch (Exception unused) {
            return Boolean.valueOf(z);
        }
    }

    public static Long a(Context context, String str, long j) throws IllegalArgumentException {
        try {
            Class<?> loadClass = context.getClassLoader().loadClass("android.os.SystemProperties");
            return (Long) loadClass.getMethod("getLong", String.class, Long.TYPE).invoke(loadClass, str, Long.valueOf(j));
        } catch (IllegalArgumentException e) {
            throw e;
        } catch (Exception unused) {
            return Long.valueOf(j);
        }
    }

    public static String a(InputStream inputStream) {
        try {
            StringBuilder sb = new StringBuilder();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    bufferedReader.close();
                    inputStream.close();
                    return sb.toString();
                }
                sb.append(readLine);
            }
        } catch (IOException e) {
            ObjectLogUtils objectLogUtils = com.transsion.athena.taaneh.aethna.a;
            com.transsion.athena.taaneh.aethna.b(Log.getStackTraceString(e));
            return null;
        }
    }

    public static String a(Collection<? extends Object> collection, String str) {
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        for (Object obj : collection) {
            if (z) {
                z = false;
            } else {
                sb.append(str);
            }
            sb.append(obj.toString());
        }
        return sb.toString();
    }

    public static String a(byte[] bArr) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(EncoderUtil.ALGORITHM_MD5);
            messageDigest.update(bArr);
            byte[] digest = messageDigest.digest();
            StringBuilder sb = new StringBuilder();
            for (byte b : digest) {
                int i = b & 255;
                if (Integer.toHexString(i).length() == 1) {
                    sb.append("0");
                    sb.append(Integer.toHexString(i));
                } else {
                    sb.append(Integer.toHexString(i));
                }
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException unused) {
            return BuildConfig.FLAVOR;
        }
    }

    public static JSONObject a(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("model", Build.MODEL);
            jSONObject.put("brand", Build.BRAND);
            jSONObject.put("appver", String.valueOf(com.transsion.athena.taaneh.athena.i(context)));
            jSONObject.put("anver", Build.VERSION.RELEASE);
            jSONObject.put("apppkg", com.transsion.athena.taaneh.athena.h(context));
            jSONObject.put("gaid", com.transsion.athena.taaneh.anehat.a());
            jSONObject.put("mcc", com.transsion.athena.taaneh.athena.f(context));
            jSONObject.put("lang", Locale.getDefault().getLanguage());
            jSONObject.put("installer", com.transsion.athena.taaneh.athena.e(context));
        } catch (Exception e) {
            com.transsion.athena.taaneh.aethna.b(Log.getStackTraceString(e));
        }
        return jSONObject;
    }

    public static void a(StringBuilder sb, Object obj) {
        if (sb.length() == 0) {
            sb.append(obj);
        } else {
            sb.append(",");
            sb.append(obj);
        }
    }

    public static void a(JSONObject jSONObject, JSONObject jSONObject2) throws JSONException {
        if (jSONObject == null || jSONObject2 == null) {
            return;
        }
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            Object obj = jSONObject.get(next);
            if (!next.contains("&")) {
                jSONObject2.put(next, obj);
            } else if (!jSONObject2.has(next)) {
                jSONObject2.put(next, obj);
            } else if (next.endsWith("&add")) {
                jSONObject2.put(next, Long.parseLong(obj.toString()) + jSONObject2.getLong(next));
            } else if (next.endsWith("&append")) {
                Object obj2 = jSONObject2.get(next);
                if (obj2 instanceof JSONArray) {
                    ((JSONArray) obj2).put(obj);
                } else {
                    obj2 = new JSONArray().put(obj2).put(obj);
                }
                jSONObject2.put(next, obj2);
            }
        }
    }

    public static boolean a(Collection<?> collection) {
        return collection == null || collection.isEmpty();
    }

    public static byte[] a(String str) {
        if (str.length() < 1) {
            return null;
        }
        byte[] bArr = new byte[str.length() / 2];
        for (int i = 0; i < str.length() / 2; i++) {
            int i2 = i * 2;
            int i3 = i2 + 1;
            bArr[i] = (byte) ((Integer.parseInt(str.substring(i2, i3), 16) * 16) + Integer.parseInt(str.substring(i3, i2 + 2), 16));
        }
        return bArr;
    }

    public static int b(Context context) {
        StringBuilder sb = new StringBuilder();
        try {
            String e = com.transsion.athena.taaneh.athena.e(context);
            sb.append(Build.MODEL);
            sb.append(Build.BRAND);
            sb.append(com.transsion.athena.taaneh.athena.i(context));
            sb.append(Build.VERSION.RELEASE);
            sb.append(com.transsion.athena.taaneh.athena.h(context));
            sb.append(com.transsion.athena.taaneh.athena.f(context));
            sb.append(Locale.getDefault().getLanguage());
            if (e == null) {
                e = BuildConfig.FLAVOR;
            }
            sb.append(e);
        } catch (Exception e2) {
            com.transsion.athena.taaneh.aethna.b(Log.getStackTraceString(e2));
        }
        return sb.toString().hashCode();
    }

    public static boolean b(Collection<?> collection) {
        return (collection == null || collection.isEmpty()) ? false : true;
    }

    public static byte[] b(byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.close();
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            byteArrayOutputStream.reset();
            return byteArray;
        } catch (Exception e) {
            ObjectLogUtils objectLogUtils = com.transsion.athena.taaneh.aethna.a;
            com.transsion.athena.taaneh.aethna.b(Log.getStackTraceString(e));
            return null;
        }
    }

    public static String c(byte[] bArr) {
        if (bArr == null) {
            return BuildConfig.FLAVOR;
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (byte b : bArr) {
            String hexString = Integer.toHexString(b & 255);
            if (hexString.length() == 1) {
                hexString = '0' + hexString;
            }
            stringBuffer.append(hexString.toUpperCase());
        }
        return stringBuffer.toString();
    }

    public static boolean c(Context context) {
        try {
            PowerManager powerManager = (PowerManager) context.getSystemService("power");
            if (powerManager != null) {
                return powerManager.isScreenOn();
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    /* JADX WARN: Not initialized variable reg: 2, insn: 0x0027: MOVE (r0 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]), block:B:37:0x0027 */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0065 A[Catch: Exception -> 0x0069, TRY_LEAVE, TryCatch #2 {Exception -> 0x0069, blocks: (B:39:0x0060, B:41:0x0065), top: B:38:0x0060 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static byte[] d(byte[] bArr) {
        GZIPInputStream gZIPInputStream;
        GZIPInputStream gZIPInputStream2;
        GZIPInputStream gZIPInputStream3 = null;
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            try {
                gZIPInputStream = new GZIPInputStream(new ByteArrayInputStream(bArr));
                try {
                    byte[] bArr2 = new byte[1024];
                    while (true) {
                        int read = gZIPInputStream.read(bArr2);
                        if (read < 0) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr2, 0, read);
                    }
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    try {
                        byteArrayOutputStream.close();
                        gZIPInputStream.close();
                    } catch (Exception e) {
                        ObjectLogUtils objectLogUtils = com.transsion.athena.taaneh.aethna.a;
                        com.transsion.athena.taaneh.aethna.b(Log.getStackTraceString(e));
                    }
                    return byteArray;
                } catch (Exception e2) {
                    e = e2;
                    ObjectLogUtils objectLogUtils2 = com.transsion.athena.taaneh.aethna.a;
                    com.transsion.athena.taaneh.aethna.b(Log.getStackTraceString(e));
                    try {
                        byteArrayOutputStream.close();
                        if (gZIPInputStream != null) {
                            gZIPInputStream.close();
                        }
                    } catch (Exception e3) {
                        com.transsion.athena.taaneh.aethna.b(Log.getStackTraceString(e3));
                    }
                    return null;
                }
            } catch (Throwable th2) {
                th = th2;
                gZIPInputStream3 = gZIPInputStream2;
                try {
                    byteArrayOutputStream.close();
                    if (gZIPInputStream3 != null) {
                        gZIPInputStream3.close();
                    }
                } catch (Exception e4) {
                    ObjectLogUtils objectLogUtils3 = com.transsion.athena.taaneh.aethna.a;
                    com.transsion.athena.taaneh.aethna.b(Log.getStackTraceString(e4));
                }
                throw th;
            }
        } catch (Exception e5) {
            e = e5;
            gZIPInputStream = null;
        } catch (Throwable th3) {
            th = th3;
            byteArrayOutputStream.close();
            if (gZIPInputStream3 != null) {
            }
            throw th;
        }
    }
}
