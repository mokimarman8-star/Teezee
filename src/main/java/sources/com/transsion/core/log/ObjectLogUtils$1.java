package com.transsion.core.log;

import android.util.Log;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
class ObjectLogUtils$1 implements Runnable {
    final /* synthetic */ ObjectLogUtils this$0;
    final /* synthetic */ String val$content;
    final /* synthetic */ String val$fullPath;
    final /* synthetic */ String val$tag;

    ObjectLogUtils$1(ObjectLogUtils objectLogUtils, String str, String str2, String str3) {
        this.this$0 = objectLogUtils;
        this.val$fullPath = str;
        this.val$content = str2;
        this.val$tag = str3;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0061 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:33:0x002c -> B:8:0x005e). Please report as a decompilation issue!!! */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        Throwable th2;
        BufferedWriter bufferedWriter;
        IOException e;
        BufferedWriter bufferedWriter2 = null;
        try {
            try {
                try {
                    bufferedWriter = new BufferedWriter(new FileWriter(this.val$fullPath, true));
                    try {
                        bufferedWriter.write(this.val$content);
                        StringBuilder sb = new StringBuilder();
                        sb.append("log to ");
                        sb.append(this.val$fullPath);
                        sb.append(" success!");
                        bufferedWriter.close();
                    } catch (IOException e2) {
                        e = e2;
                        e.printStackTrace();
                        Log.e(this.val$tag, "log to " + this.val$fullPath + " failed!");
                        if (bufferedWriter != null) {
                            bufferedWriter.close();
                        }
                    }
                } catch (Throwable th3) {
                    th2 = th3;
                    bufferedWriter2 = bufferedWriter;
                    if (bufferedWriter2 != null) {
                        try {
                            bufferedWriter2.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                    }
                    throw th2;
                }
            } catch (IOException e4) {
                bufferedWriter = null;
                e = e4;
            } catch (Throwable th4) {
                th2 = th4;
                if (bufferedWriter2 != null) {
                }
                throw th2;
            }
        } catch (IOException e5) {
            e5.printStackTrace();
        }
    }
}
