package l5;

import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class b {
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0154, code lost:
    
        r1.m = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0156, code lost:
    
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0151, code lost:
    
        if (r13 != null) goto L49;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public m5.d a(String str, String str2, InputStream inputStream) {
        boolean z;
        m5.d dVar = new m5.d();
        m5.b bVar = new m5.b();
        BufferedReader bufferedReader = TextUtils.isEmpty(str2) ? new BufferedReader(new InputStreamReader(inputStream)) : new BufferedReader(new InputStreamReader(inputStream, str2));
        dVar.e = str;
        int i = 0;
        for (String readLine = bufferedReader.readLine(); readLine != null; readLine = bufferedReader.readLine()) {
            try {
                String trim = readLine.trim();
                int i2 = i + 1;
                if (!trim.isEmpty()) {
                    i2 = i + 2;
                    try {
                        trim = bufferedReader.readLine().trim();
                        String substring = trim.substring(0, 12);
                        String substring2 = trim.substring(trim.length() - 12, trim.length());
                        bVar.b = new m5.c("hh:mm:ss,ms", substring);
                        bVar.c = new m5.c("hh:mm:ss,ms", substring2);
                        z = true;
                    } catch (Exception unused) {
                        dVar.j += "incorrect time format at line " + i2;
                        z = false;
                    }
                    if (z) {
                        int i3 = i + 3;
                        String readLine2 = bufferedReader.readLine();
                        trim = readLine2 != null ? readLine2.trim() : "";
                        String str3 = "";
                        while (!trim.isEmpty()) {
                            str3 = str3 + trim + "<br />";
                            String readLine3 = bufferedReader.readLine();
                            if (readLine3 != null) {
                                trim = readLine3.trim();
                                i3++;
                            } else {
                                trim = "";
                            }
                        }
                        if (str3.endsWith("<br />")) {
                            str3 = str3.substring(0, str3.length() - 6);
                        }
                        bVar.d = str3;
                        int i4 = bVar.b.a;
                        while (dVar.i.containsKey(Integer.valueOf(i4))) {
                            i4++;
                        }
                        if (i4 != bVar.b.a) {
                            dVar.j += "caption with same start time found...\n\n";
                        }
                        dVar.i.put(Integer.valueOf(i4), bVar);
                        i2 = i3;
                    }
                    while (!trim.isEmpty()) {
                        trim = bufferedReader.readLine().trim();
                        i2++;
                    }
                    bVar = new m5.b();
                }
                i = i2;
            } catch (Throwable th) {
                try {
                    dVar.j += "unexpected end of file, maybe last caption is not complete.\n\n";
                    th.printStackTrace();
                } finally {
                    if (inputStream != null) {
                        inputStream.close();
                    }
                }
            }
        }
    }
}
