package l5;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public final class d {
    public static final a a = new a(null);
    private static final Pattern b = Pattern.compile("\\{(\\d+)\\}\\{(\\d+)\\}(.*)");
    private static final Pattern c = Pattern.compile("(\\d+):(\\d+):(\\d+)[:\\.](\\d+)");

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private final int a(String str) {
        Matcher matcher = c.matcher(str);
        if (!matcher.matches()) {
            return 0;
        }
        String group = matcher.group(1);
        int parseInt = group != null ? Integer.parseInt(group) : 0;
        String group2 = matcher.group(2);
        int parseInt2 = group2 != null ? Integer.parseInt(group2) : 0;
        String group3 = matcher.group(3);
        int parseInt3 = group3 != null ? Integer.parseInt(group3) : 0;
        String group4 = matcher.group(4);
        return ((group4 != null ? Integer.parseInt(group4) : 0) * 10) + (parseInt3 * 1000) + (parseInt2 * 60000) + (parseInt * 3600000);
    }

    private final void c(BufferedReader bufferedReader, String str, m5.d dVar) {
        m5.b bVar = new m5.b();
        while (str != null && str.length() != 0) {
            int length = str.length() - 1;
            int i = 0;
            boolean z = false;
            while (i <= length) {
                boolean z2 = Intrinsics.j(str.charAt(!z ? i : length), 32) <= 0;
                if (z) {
                    if (!z2) {
                        break;
                    } else {
                        length--;
                    }
                } else if (z2) {
                    i++;
                } else {
                    z = true;
                }
            }
            Matcher matcher = b.matcher(str.subSequence(i, length + 1).toString());
            try {
                if (matcher.matches()) {
                    String group = matcher.group(1);
                    long j = 23976;
                    long parseInt = ((group != null ? Integer.parseInt(group) : 0) * 1000000) / j;
                    m5.c cVar = new m5.c("", "");
                    cVar.a = (int) parseInt;
                    bVar.b = cVar;
                    m5.c cVar2 = new m5.c("", "");
                    cVar2.a = (int) (((matcher.group(2) != null ? Integer.parseInt(r3) : 0) * 1000000) / j);
                    bVar.c = cVar2;
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            try {
                if (matcher.matches()) {
                    bVar.d = matcher.group(3);
                }
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
            int i2 = bVar.b.a;
            while (dVar.i.containsKey(Integer.valueOf(i2))) {
                i2++;
            }
            TreeMap treeMap = dVar.i;
            Intrinsics.g(treeMap, "tto.captions");
            treeMap.put(Integer.valueOf(i2), bVar);
            try {
                str = bufferedReader.readLine();
            } catch (Throwable unused) {
                str = "";
            }
            bVar = new m5.b();
        }
        dVar.m = true;
    }

    private final void d(BufferedReader bufferedReader, String str, m5.d dVar) {
        m5.b bVar = new m5.b();
        while (str != null && !StringsKt.W(str, "[COLF]", false, 2, (Object) null)) {
            str = bufferedReader.readLine();
        }
        while (str != null && str.length() != 0) {
            String readLine = bufferedReader.readLine();
            if (readLine != null) {
                int length = readLine.length() - 1;
                int i = 0;
                boolean z = false;
                while (i <= length) {
                    boolean z2 = Intrinsics.j(readLine.charAt(!z ? i : length), 32) <= 0;
                    if (z) {
                        if (!z2) {
                            break;
                        } else {
                            length--;
                        }
                    } else if (z2) {
                        i++;
                    } else {
                        z = true;
                    }
                }
                str = readLine.subSequence(i, length + 1).toString();
            } else {
                str = null;
            }
            if (str != null) {
                try {
                    List S0 = StringsKt.S0(str, new String[]{","}, false, 0, 6, (Object) null);
                    if (S0 != null) {
                        String str2 = (String) S0.get(0);
                        String str3 = (String) S0.get(1);
                        int a2 = a(str2);
                        int a3 = a(str3);
                        m5.c cVar = new m5.c("", "");
                        cVar.a = a2;
                        bVar.b = cVar;
                        m5.c cVar2 = new m5.c("", "");
                        cVar2.a = a3;
                        bVar.c = cVar2;
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            try {
                String readLine2 = bufferedReader.readLine();
                if (readLine2 != null) {
                    int length2 = readLine2.length() - 1;
                    int i2 = 0;
                    boolean z3 = false;
                    while (i2 <= length2) {
                        boolean z4 = Intrinsics.j(readLine2.charAt(!z3 ? i2 : length2), 32) <= 0;
                        if (z3) {
                            if (!z4) {
                                break;
                            } else {
                                length2--;
                            }
                        } else if (z4) {
                            i2++;
                        } else {
                            z3 = true;
                        }
                    }
                    str = readLine2.subSequence(i2, length2 + 1).toString();
                } else {
                    str = null;
                }
                bVar.d = str;
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
            try {
                bufferedReader.readLine();
            } catch (Throwable unused) {
            }
            int i3 = bVar.b.a;
            while (dVar.i.containsKey(Integer.valueOf(i3))) {
                i3++;
            }
            TreeMap treeMap = dVar.i;
            Intrinsics.g(treeMap, "tto.captions");
            treeMap.put(Integer.valueOf(i3), bVar);
            bVar = new m5.b();
        }
        dVar.m = true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0091, code lost:
    
        if (r12 == null) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0094, code lost:
    
        return r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public m5.d b(String str, String str2, InputStream inputStream) {
        String str3;
        Intrinsics.h(str2, "unicode");
        m5.d dVar = new m5.d();
        BufferedReader bufferedReader = new BufferedReader(str2.length() > 0 ? new InputStreamReader(inputStream, str2) : new InputStreamReader(inputStream));
        dVar.e = str;
        String readLine = bufferedReader.readLine();
        if (readLine != null) {
            int length = readLine.length() - 1;
            int i = 0;
            boolean z = false;
            while (i <= length) {
                boolean z2 = Intrinsics.j(readLine.charAt(!z ? i : length), 32) <= 0;
                if (z) {
                    if (!z2) {
                        break;
                    }
                    length--;
                } else if (z2) {
                    i++;
                } else {
                    z = true;
                }
            }
            str3 = readLine.subSequence(i, length + 1).toString();
        } else {
            str3 = null;
        }
        if (str3 != null) {
            try {
                if (StringsKt.W(str3, "{", false, 2, (Object) null)) {
                    c(bufferedReader, str3, dVar);
                }
            } catch (Throwable th) {
                try {
                    th.printStackTrace();
                } finally {
                    if (inputStream != null) {
                        inputStream.close();
                    }
                }
            }
        }
        if (str3 != null && StringsKt.W(str3, "[INFORMATION]", false, 2, (Object) null)) {
            d(bufferedReader, str3, dVar);
        }
    }
}
