package com.blankj.utilcode.util;

import com.bumptech.glide.load.Key;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public abstract class z {
    private static final String a = System.getProperty("line.separator");

    public static class a {
        public int a;
        public String b;
        public String c;

        public a(int i, String str, String str2) {
            this.a = i;
            this.b = str;
            this.c = str2;
        }

        public String toString() {
            return "result: " + this.a + "\nsuccessMsg: " + this.b + "\nerrorMsg: " + this.c;
        }
    }

    public static a a(String str, boolean z) {
        return b(new String[]{str}, z, true);
    }

    public static a b(String[] strArr, boolean z, boolean z2) {
        return c(strArr, null, z, z2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:101:0x011e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0176  */
    /* JADX WARN: Removed duplicated region for block: B:114:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:115:0x016c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0162 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0158 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0132 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0128 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r10v1 */
    /* JADX WARN: Type inference failed for: r10v11 */
    /* JADX WARN: Type inference failed for: r10v15 */
    /* JADX WARN: Type inference failed for: r10v16 */
    /* JADX WARN: Type inference failed for: r10v2 */
    /* JADX WARN: Type inference failed for: r10v6 */
    /* JADX WARN: Type inference failed for: r10v9 */
    /* JADX WARN: Type inference failed for: r11v11 */
    /* JADX WARN: Type inference failed for: r11v12 */
    /* JADX WARN: Type inference failed for: r11v3, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r11v9, types: [java.lang.StringBuilder] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static a c(String[] strArr, String[] strArr2, boolean z, boolean z2) {
        Process process;
        BufferedReader bufferedReader;
        ?? r10;
        BufferedReader bufferedReader2;
        BufferedReader bufferedReader3;
        StringBuilder sb;
        ?? r11;
        Object obj;
        ?? sb2;
        int i = -1;
        if (strArr == null || strArr.length == 0) {
            return new a(-1, "", "");
        }
        DataOutputStream dataOutputStream = null;
        BufferedReader bufferedReader4 = null;
        dataOutputStream = null;
        try {
            process = Runtime.getRuntime().exec(z ? "su" : "sh", strArr2, (File) null);
            try {
                DataOutputStream dataOutputStream2 = new DataOutputStream(process.getOutputStream());
                try {
                    try {
                        for (String str : strArr) {
                            if (str != null) {
                                dataOutputStream2.write(str.getBytes());
                                dataOutputStream2.writeBytes(a);
                                dataOutputStream2.flush();
                            }
                        }
                        dataOutputStream2.writeBytes("exit" + a);
                        dataOutputStream2.flush();
                        i = process.waitFor();
                        if (z2) {
                            sb = new StringBuilder();
                            try {
                                sb2 = new StringBuilder();
                                try {
                                    bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream(), Key.STRING_CHARSET_NAME));
                                    try {
                                        bufferedReader2 = new BufferedReader(new InputStreamReader(process.getErrorStream(), Key.STRING_CHARSET_NAME));
                                    } catch (Exception e) {
                                        e = e;
                                        bufferedReader2 = null;
                                    } catch (Throwable th) {
                                        th = th;
                                        bufferedReader2 = null;
                                    }
                                } catch (Exception e2) {
                                    e = e2;
                                    bufferedReader = null;
                                    bufferedReader2 = null;
                                }
                            } catch (Exception e3) {
                                bufferedReader = null;
                                bufferedReader2 = null;
                                dataOutputStream = dataOutputStream2;
                                r10 = sb;
                                e = e3;
                                bufferedReader3 = null;
                            }
                            try {
                                String readLine = bufferedReader.readLine();
                                if (readLine != null) {
                                    sb.append(readLine);
                                    while (true) {
                                        String readLine2 = bufferedReader.readLine();
                                        if (readLine2 == null) {
                                            break;
                                        }
                                        sb.append(a);
                                        sb.append(readLine2);
                                    }
                                }
                                String readLine3 = bufferedReader2.readLine();
                                if (readLine3 != null) {
                                    sb2.append(readLine3);
                                    while (true) {
                                        String readLine4 = bufferedReader2.readLine();
                                        if (readLine4 == null) {
                                            break;
                                        }
                                        sb2.append(a);
                                        sb2.append(readLine4);
                                    }
                                }
                                bufferedReader4 = bufferedReader;
                                obj = sb2;
                            } catch (Exception e4) {
                                e = e4;
                                dataOutputStream = dataOutputStream2;
                                r10 = sb;
                                e = e;
                                bufferedReader3 = sb2;
                                try {
                                    e.printStackTrace();
                                    if (dataOutputStream != null) {
                                    }
                                    if (bufferedReader != null) {
                                    }
                                    if (bufferedReader2 != null) {
                                    }
                                    if (process != null) {
                                    }
                                    sb = r10;
                                    r11 = bufferedReader3;
                                    return new a(i, sb == null ? "" : sb.toString(), r11 != 0 ? r11.toString() : "");
                                } catch (Throwable th2) {
                                    th = th2;
                                    if (dataOutputStream != null) {
                                        try {
                                            dataOutputStream.close();
                                        } catch (IOException e8) {
                                            e8.printStackTrace();
                                        }
                                    }
                                    if (bufferedReader != null) {
                                        try {
                                            bufferedReader.close();
                                        } catch (IOException e9) {
                                            e9.printStackTrace();
                                        }
                                    }
                                    if (bufferedReader2 != null) {
                                        try {
                                            bufferedReader2.close();
                                        } catch (IOException e10) {
                                            e10.printStackTrace();
                                        }
                                    }
                                    if (process == null) {
                                        throw th;
                                    }
                                    process.destroy();
                                    throw th;
                                }
                            } catch (Throwable th3) {
                                th = th3;
                                dataOutputStream = dataOutputStream2;
                                if (dataOutputStream != null) {
                                }
                                if (bufferedReader != null) {
                                }
                                if (bufferedReader2 != null) {
                                }
                                if (process == null) {
                                }
                            }
                        } else {
                            sb = null;
                            obj = null;
                            bufferedReader2 = null;
                        }
                        try {
                            dataOutputStream2.close();
                        } catch (IOException e11) {
                            e11.printStackTrace();
                        }
                        if (bufferedReader4 != null) {
                            try {
                                bufferedReader4.close();
                            } catch (IOException e12) {
                                e12.printStackTrace();
                            }
                        }
                        if (bufferedReader2 != null) {
                            try {
                                bufferedReader2.close();
                            } catch (IOException e13) {
                                e13.printStackTrace();
                            }
                        }
                        process.destroy();
                        r11 = obj;
                    } catch (Exception e14) {
                        e = e14;
                        bufferedReader3 = null;
                        bufferedReader = null;
                        bufferedReader2 = null;
                        dataOutputStream = dataOutputStream2;
                        r10 = null;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    bufferedReader = null;
                    bufferedReader2 = null;
                }
            } catch (Exception e15) {
                e = e15;
                r10 = null;
                BufferedReader bufferedReader5 = r10;
                bufferedReader = bufferedReader5;
                bufferedReader2 = bufferedReader;
                bufferedReader3 = bufferedReader5;
                e.printStackTrace();
                if (dataOutputStream != null) {
                    try {
                        dataOutputStream.close();
                    } catch (IOException e16) {
                        e16.printStackTrace();
                    }
                }
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e17) {
                        e17.printStackTrace();
                    }
                }
                if (bufferedReader2 != null) {
                    try {
                        bufferedReader2.close();
                    } catch (IOException e18) {
                        e18.printStackTrace();
                    }
                }
                if (process != null) {
                    process.destroy();
                }
                sb = r10;
                r11 = bufferedReader3;
                return new a(i, sb == null ? "" : sb.toString(), r11 != 0 ? r11.toString() : "");
            } catch (Throwable th5) {
                th = th5;
                bufferedReader = null;
                bufferedReader2 = bufferedReader;
                if (dataOutputStream != null) {
                }
                if (bufferedReader != null) {
                }
                if (bufferedReader2 != null) {
                }
                if (process == null) {
                }
            }
        } catch (Exception e19) {
            e = e19;
            process = null;
            r10 = null;
        } catch (Throwable th6) {
            th = th6;
            process = null;
            bufferedReader = null;
        }
        return new a(i, sb == null ? "" : sb.toString(), r11 != 0 ? r11.toString() : "");
    }
}
