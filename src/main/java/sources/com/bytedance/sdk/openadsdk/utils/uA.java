package com.bytedance.sdk.openadsdk.utils;

import android.content.Context;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.util.regex.Pattern;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class uA {

    /* renamed from: com.bytedance.sdk.openadsdk.utils.uA$1, reason: invalid class name */
    static class AnonymousClass1 implements FilenameFilter {
        private final Pattern Sj = Pattern.compile("^cpu[0-9]+$");

        AnonymousClass1() {
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return this.Sj.matcher(str).matches();
        }
    }

    public static int Sj() {
        return Math.max(Runtime.getRuntime().availableProcessors(), 0);
    }

    public static int Sj(int i) {
        BufferedReader bufferedReader;
        Throwable th;
        BufferedReader bufferedReader2;
        int parseInt;
        int i2 = 0;
        FileReader fileReader = null;
        BufferedReader bufferedReader3 = null;
        while (true) {
            i--;
            if (i < 0) {
                return i2;
            }
            try {
                FileReader fileReader2 = new FileReader("/sys/devices/system/cpu/cpu" + i + "/cpufreq/cpuinfo_max_freq");
                try {
                    bufferedReader2 = new BufferedReader(fileReader2);
                } catch (Throwable th2) {
                    BufferedReader bufferedReader4 = bufferedReader3;
                    th = th2;
                    fileReader = fileReader2;
                    bufferedReader = bufferedReader4;
                }
                try {
                    String readLine = bufferedReader2.readLine();
                    if (!TextUtils.isEmpty(readLine) && (parseInt = Integer.parseInt(readLine)) > i2) {
                        i2 = parseInt;
                    }
                    try {
                        bufferedReader2.close();
                        fileReader2.close();
                    } catch (Exception unused) {
                    }
                    bufferedReader3 = bufferedReader2;
                    fileReader = fileReader2;
                } catch (Throwable th3) {
                    th = th3;
                    bufferedReader = bufferedReader2;
                    fileReader = fileReader2;
                    try {
                        com.bytedance.sdk.component.utils.sU.sP("CpuUtils", th.getMessage());
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (Exception unused2) {
                                bufferedReader3 = bufferedReader;
                            }
                        }
                        bufferedReader3 = bufferedReader;
                    } finally {
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (Exception unused3) {
                            }
                        }
                        if (fileReader != null) {
                            fileReader.close();
                        }
                    }
                }
            } catch (Throwable th4) {
                bufferedReader = bufferedReader3;
                th = th4;
            }
        }
    }

    public static int Sj(Context context) {
        return com.bytedance.sdk.openadsdk.core.TKC.Sj(context).sP("cpu_count", 0);
    }

    public static int TKC(Context context) {
        return com.bytedance.sdk.openadsdk.core.TKC.Sj(context).sP("cpu_min_frequency", 0);
    }

    public static int sP(int i) {
        BufferedReader bufferedReader;
        Throwable th;
        BufferedReader bufferedReader2;
        int parseInt;
        int i2 = 0;
        FileReader fileReader = null;
        BufferedReader bufferedReader3 = null;
        while (true) {
            i--;
            if (i < 0) {
                return i2;
            }
            try {
                FileReader fileReader2 = new FileReader("/sys/devices/system/cpu/cpu" + i + "/cpufreq/cpuinfo_min_freq");
                try {
                    bufferedReader2 = new BufferedReader(fileReader2);
                } catch (Throwable th2) {
                    BufferedReader bufferedReader4 = bufferedReader3;
                    th = th2;
                    fileReader = fileReader2;
                    bufferedReader = bufferedReader4;
                }
                try {
                    String readLine = bufferedReader2.readLine();
                    if (!TextUtils.isEmpty(readLine) && ((parseInt = Integer.parseInt(readLine)) < i2 || i2 == 0)) {
                        i2 = parseInt;
                    }
                    try {
                        bufferedReader2.close();
                        fileReader2.close();
                    } catch (Exception unused) {
                    }
                    bufferedReader3 = bufferedReader2;
                    fileReader = fileReader2;
                } catch (Throwable th3) {
                    th = th3;
                    bufferedReader = bufferedReader2;
                    fileReader = fileReader2;
                    try {
                        com.bytedance.sdk.component.utils.sU.sP("CpuUtils", th.getMessage());
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (Exception unused2) {
                                bufferedReader3 = bufferedReader;
                            }
                        }
                        bufferedReader3 = bufferedReader;
                    } finally {
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (Exception unused3) {
                            }
                        }
                        if (fileReader != null) {
                            fileReader.close();
                        }
                    }
                }
            } catch (Throwable th4) {
                bufferedReader = bufferedReader3;
                th = th4;
            }
        }
    }

    public static int sP(Context context) {
        return com.bytedance.sdk.openadsdk.core.TKC.Sj(context).sP("cpu_max_frequency", 0);
    }
}
