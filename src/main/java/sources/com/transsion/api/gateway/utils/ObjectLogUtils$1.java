package com.transsion.api.gateway.utils;

import android.util.Log;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public class ObjectLogUtils$1 implements Runnable {
    public final /* synthetic */ ObjectLogUtils this$0;
    public final /* synthetic */ String val$content;
    public final /* synthetic */ String val$fullPath;
    public final /* synthetic */ String val$tag;

    public ObjectLogUtils$1(ObjectLogUtils objectLogUtils, String str, String str2, String str3) {
        this.this$0 = objectLogUtils;
        this.val$fullPath = str;
        this.val$content = str2;
        this.val$tag = str3;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0062 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        BufferedWriter bufferedWriter;
        IOException e;
        BufferedWriter bufferedWriter2 = null;
        try {
            try {
                bufferedWriter = new BufferedWriter(new FileWriter(this.val$fullPath, true));
                try {
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
                } catch (Throwable th2) {
                    th = th2;
                    bufferedWriter2 = bufferedWriter;
                    if (bufferedWriter2 != null) {
                        try {
                            bufferedWriter2.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (IOException e4) {
                e4.printStackTrace();
            }
        } catch (IOException e5) {
            bufferedWriter = null;
            e = e5;
        } catch (Throwable th3) {
            th = th3;
            if (bufferedWriter2 != null) {
            }
            throw th;
        }
    }
}
