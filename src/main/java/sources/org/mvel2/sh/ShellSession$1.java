package org.mvel2.sh;

import f00.d;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Map;
import org.mvel2.sh.a;

/* loaded from: /home/user/Teezee-git/app_source/classes8.dex */
class ShellSession$1 implements Runnable {
    final /* synthetic */ a this$0;
    final /* synthetic */ InputStream val$inStream;
    final /* synthetic */ a.C0009a val$runState;
    final /* synthetic */ PrintStream val$sysPrintStream;

    ShellSession$1(a aVar, InputStream inputStream, PrintStream printStream, a.C0009a c0009a) {
        this.this$0 = aVar;
        this.val$inStream = inputStream;
        this.val$sysPrintStream = printStream;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean z;
        PrintStream printStream;
        int i;
        int i2;
        Map map;
        Map map2;
        PrintStream printStream2;
        String str;
        byte[] bArr = new byte[25];
        while (true) {
            try {
                int read = this.val$inStream.read(bArr);
                if (read <= 0) {
                    break;
                }
                for (int i3 = 0; i3 < read; i3++) {
                    this.val$sysPrintStream.print((char) bArr[i3]);
                }
                this.val$sysPrintStream.flush();
            } catch (Exception unused) {
                this.val$sysPrintStream.flush();
                z = this.this$0.g;
                if (z) {
                    printStream = this.this$0.i;
                    PrintStream append = printStream.append((CharSequence) ">");
                    a aVar = this.this$0;
                    i = aVar.h;
                    i2 = this.this$0.f;
                    append.append((CharSequence) aVar.j((i - 1) + (i2 * 4)));
                    return;
                }
                a aVar2 = this.this$0;
                map = aVar2.c;
                String str2 = (String) map.get("$PROMPT");
                map2 = this.this$0.b;
                aVar2.h = aVar2.j = String.valueOf(d.b(str2, map2)).length();
                printStream2 = this.this$0.i;
                str = this.this$0.j;
                printStream2.append((CharSequence) str);
                return;
            }
        }
        throw null;
    }
}
