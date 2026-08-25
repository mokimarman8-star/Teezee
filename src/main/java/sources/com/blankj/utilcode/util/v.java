package com.blankj.utilcode.util;

import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public abstract class v {
    private static final String[] a = {"huawei"};
    private static final String[] b = {"vivo"};
    private static final String[] c = {"xiaomi"};
    private static final String[] d = {"oppo"};
    private static final String[] e = {"leeco", "letv"};
    private static final String[] f = {"360", "qiku"};
    private static final String[] g = {"zte"};
    private static final String[] h = {"oneplus"};
    private static final String[] i = {"nubia"};
    private static final String[] j = {"coolpad", "yulong"};
    private static final String[] k = {"lg", "lge"};
    private static final String[] l = {"google"};
    private static final String[] m = {"samsung"};
    private static final String[] n = {"meizu"};
    private static final String[] o = {"lenovo"};
    private static final String[] p = {"smartisan", "deltainno"};
    private static final String[] q = {"htc"};
    private static final String[] r = {"sony"};
    private static final String[] s = {"gionee", "amigo"};
    private static final String[] t = {"motorola"};
    private static a u = null;

    public static class a {
        private String a;
        private String b;

        public String toString() {
            return "RomInfo{name=" + this.a + ", version=" + this.b + "}";
        }
    }

    private static String a() {
        try {
            String str = Build.BRAND;
            return !TextUtils.isEmpty(str) ? str.toLowerCase() : "unknown";
        } catch (Throwable unused) {
            return "unknown";
        }
    }

    private static String b() {
        try {
            String str = Build.MANUFACTURER;
            return !TextUtils.isEmpty(str) ? str.toLowerCase() : "unknown";
        } catch (Throwable unused) {
            return "unknown";
        }
    }

    public static a c() {
        a aVar = u;
        if (aVar != null) {
            return aVar;
        }
        u = new a();
        String a2 = a();
        String b2 = b();
        String[] strArr = a;
        if (i(a2, b2, strArr)) {
            u.a = strArr[0];
            String d2 = d("ro.build.version.emui");
            String[] split = d2.split("_");
            if (split.length > 1) {
                u.b = split[1];
            } else {
                u.b = d2;
            }
            return u;
        }
        String[] strArr2 = b;
        if (i(a2, b2, strArr2)) {
            u.a = strArr2[0];
            u.b = d("ro.vivo.os.build.display.id");
            return u;
        }
        String[] strArr3 = c;
        if (i(a2, b2, strArr3)) {
            u.a = strArr3[0];
            u.b = d("ro.build.version.incremental");
            return u;
        }
        String[] strArr4 = d;
        if (i(a2, b2, strArr4)) {
            u.a = strArr4[0];
            u.b = d("ro.build.version.opporom");
            return u;
        }
        String[] strArr5 = e;
        if (i(a2, b2, strArr5)) {
            u.a = strArr5[0];
            u.b = d("ro.letv.release.version");
            return u;
        }
        String[] strArr6 = f;
        if (i(a2, b2, strArr6)) {
            u.a = strArr6[0];
            u.b = d("ro.build.uiversion");
            return u;
        }
        String[] strArr7 = g;
        if (i(a2, b2, strArr7)) {
            u.a = strArr7[0];
            u.b = d("ro.build.MiFavor_version");
            return u;
        }
        String[] strArr8 = h;
        if (i(a2, b2, strArr8)) {
            u.a = strArr8[0];
            u.b = d("ro.rom.version");
            return u;
        }
        String[] strArr9 = i;
        if (i(a2, b2, strArr9)) {
            u.a = strArr9[0];
            u.b = d("ro.build.rom.id");
            return u;
        }
        String[] strArr10 = j;
        if (i(a2, b2, strArr10)) {
            u.a = strArr10[0];
        } else {
            String[] strArr11 = k;
            if (i(a2, b2, strArr11)) {
                u.a = strArr11[0];
            } else {
                String[] strArr12 = l;
                if (i(a2, b2, strArr12)) {
                    u.a = strArr12[0];
                } else {
                    String[] strArr13 = m;
                    if (i(a2, b2, strArr13)) {
                        u.a = strArr13[0];
                    } else {
                        String[] strArr14 = n;
                        if (i(a2, b2, strArr14)) {
                            u.a = strArr14[0];
                        } else {
                            String[] strArr15 = o;
                            if (i(a2, b2, strArr15)) {
                                u.a = strArr15[0];
                            } else {
                                String[] strArr16 = p;
                                if (i(a2, b2, strArr16)) {
                                    u.a = strArr16[0];
                                } else {
                                    String[] strArr17 = q;
                                    if (i(a2, b2, strArr17)) {
                                        u.a = strArr17[0];
                                    } else {
                                        String[] strArr18 = r;
                                        if (i(a2, b2, strArr18)) {
                                            u.a = strArr18[0];
                                        } else {
                                            String[] strArr19 = s;
                                            if (i(a2, b2, strArr19)) {
                                                u.a = strArr19[0];
                                            } else {
                                                String[] strArr20 = t;
                                                if (i(a2, b2, strArr20)) {
                                                    u.a = strArr20[0];
                                                } else {
                                                    u.a = b2;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        u.b = d("");
        return u;
    }

    private static String d(String str) {
        String e2 = !TextUtils.isEmpty(str) ? e(str) : "";
        if (TextUtils.isEmpty(e2) || e2.equals("unknown")) {
            try {
                String str2 = Build.DISPLAY;
                if (!TextUtils.isEmpty(str2)) {
                    e2 = str2.toLowerCase();
                }
            } catch (Throwable unused) {
            }
        }
        return TextUtils.isEmpty(e2) ? "unknown" : e2;
    }

    private static String e(String str) {
        String g2 = g(str);
        if (!TextUtils.isEmpty(g2)) {
            return g2;
        }
        String h2 = h(str);
        return (TextUtils.isEmpty(h2) && Build.VERSION.SDK_INT < 28) ? f(str) : h2;
    }

    private static String f(String str) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod("get", String.class, String.class).invoke(cls, str, "");
        } catch (Exception unused) {
            return "";
        }
    }

    private static String g(String str) {
        BufferedReader bufferedReader;
        String readLine;
        BufferedReader bufferedReader2 = null;
        try {
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop " + str).getInputStream()), 1024);
            } catch (IOException unused) {
                return "";
            }
        } catch (IOException unused2) {
        } catch (Throwable th) {
            th = th;
        }
        try {
            readLine = bufferedReader.readLine();
        } catch (IOException unused3) {
            bufferedReader2 = bufferedReader;
            if (bufferedReader2 == null) {
                return "";
            }
            bufferedReader2.close();
            return "";
        } catch (Throwable th2) {
            th = th2;
            bufferedReader2 = bufferedReader;
            if (bufferedReader2 != null) {
                try {
                    bufferedReader2.close();
                } catch (IOException unused4) {
                }
            }
            throw th;
        }
        if (readLine != null) {
            try {
                bufferedReader.close();
            } catch (IOException unused5) {
            }
            return readLine;
        }
        bufferedReader.close();
        return "";
    }

    private static String h(String str) {
        try {
            Properties properties = new Properties();
            properties.load(new FileInputStream(new File(Environment.getRootDirectory(), "build.prop")));
            return properties.getProperty(str, "");
        } catch (Exception unused) {
            return "";
        }
    }

    private static boolean i(String str, String str2, String... strArr) {
        for (String str3 : strArr) {
            if (str.contains(str3) || str2.contains(str3)) {
                return true;
            }
        }
        return false;
    }

    public static boolean j() {
        return m[0].equals(c().a);
    }
}
