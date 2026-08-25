package w3;

import java.io.File;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    private final String f18149a;

    /* renamed from: b, reason: collision with root package name */
    private FileChannel f18150b;

    public c(String str) {
        Intrinsics.h(str, "filename");
        this.f18149a = str + ".lck";
    }

    public final void a() {
        if (this.f18150b != null) {
            return;
        }
        try {
            File file = new File(this.f18149a);
            File parentFile = file.getParentFile();
            if (parentFile != null) {
                parentFile.mkdirs();
            }
            FileChannel channel = new FileOutputStream(file).getChannel();
            this.f18150b = channel;
            if (channel != null) {
                channel.lock();
            }
        } catch (Throwable th) {
            FileChannel fileChannel = this.f18150b;
            if (fileChannel != null) {
                fileChannel.close();
            }
            this.f18150b = null;
            throw new IllegalStateException("Unable to lock file: '" + this.f18149a + "'.", th);
        }
    }

    public final void b() {
        FileChannel fileChannel = this.f18150b;
        if (fileChannel == null) {
            return;
        }
        try {
            fileChannel.close();
        } finally {
            this.f18150b = null;
        }
    }
}
