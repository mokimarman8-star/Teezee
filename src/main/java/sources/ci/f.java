package ci;

import android.content.Context;
import android.util.Log;
import com.blankj.utilcode.util.Utils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import kotlin.io.ByteStreamsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class f {
    public static final f a = new f();

    private f() {
    }

    public final boolean a(Context context, String str, File file) {
        Intrinsics.h(context, "context");
        Intrinsics.h(str, "assetFileName");
        Intrinsics.h(file, "destinationFile");
        try {
            InputStream open = context.getAssets().open(str);
            Intrinsics.g(open, "open(...)");
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            ByteStreamsKt.b(open, fileOutputStream, 0, 2, (Object) null);
            open.close();
            fileOutputStream.close();
            return true;
        } catch (IOException e) {
            xh.a.c(xh.a.a, "AssetsUtil --> copyAssetFile() --> 复制失败 --> e = " + Log.getStackTraceString(e), 6, false, 4, null);
            return false;
        }
    }

    public final String b(String str) {
        Intrinsics.h(str, "fileName");
        BufferedReader bufferedReader = null;
        try {
            BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(Utils.a().getResources().getAssets().open(str)));
            try {
                Ref.ObjectRef objectRef = new Ref.ObjectRef();
                StringBuilder sb = new StringBuilder();
                while (true) {
                    String readLine = bufferedReader2.readLine();
                    objectRef.element = readLine;
                    if (readLine == null) {
                        bufferedReader2.close();
                        String sb2 = sb.toString();
                        Intrinsics.g(sb2, "toString(...)");
                        bufferedReader2.close();
                        return sb2;
                    }
                    sb.append(readLine);
                }
            } catch (Throwable th2) {
                th = th2;
                bufferedReader = bufferedReader2;
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }
}
