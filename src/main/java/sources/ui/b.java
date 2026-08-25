package ui;

import android.os.Environment;
import com.blankj.utilcode.util.Utils;
import com.transsion.mb.config.manager.ConfigBean;
import java.io.File;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.text.StringsKt;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class b {
    public static final a a = new a(null);
    private static final String b;
    private static final String c;
    private static final String d;
    private static final File e;
    private static final String f;
    private static final String g;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String a() {
            return b.d;
        }

        public final String b() {
            return b.b;
        }

        public final File c() {
            return b.e;
        }

        public final int d() {
            Integer v;
            ConfigBean c = cm.f.c.a().c("download_buffer_size", true);
            String value = c != null ? c.getValue() : null;
            if (value == null || value.length() == 0 || (v = StringsKt.v(value)) == null) {
                return 8192;
            }
            return v.intValue();
        }

        public final String e() {
            return b.g;
        }

        public final String f() {
            return b.c;
        }
    }

    static {
        String str = Environment.DIRECTORY_DCIM;
        String str2 = File.separator;
        b = str + str2 + "Teezee";
        c = Environment.DIRECTORY_DOWNLOADS + str2 + "Teezee";
        String absolutePath = Environment.getExternalStorageDirectory().getAbsolutePath();
        char c2 = File.separatorChar;
        d = absolutePath + c2 + Environment.DIRECTORY_DCIM + str2 + "Teezee";
        Utils.a();
        File externalStoragePublicDirectory = Environment.getExternalStoragePublicDirectory("Teezee");
        if (externalStoragePublicDirectory == null) {
            externalStoragePublicDirectory = Utils.a().getFilesDir();
        }
        e = externalStoragePublicDirectory;
        f = Environment.getExternalStorageDirectory().getAbsolutePath() + c2 + "OneRoom";
        g = (externalStoragePublicDirectory != null ? externalStoragePublicDirectory.getAbsolutePath() : null) + c2 + "d";
    }
}
