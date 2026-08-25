package qz;

import android.os.ParcelFileDescriptor;
import java.io.File;
import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import org.chromium.net.UploadDataProvider;
import org.chromium.net.UploadDataSink;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public abstract class a {

    /* renamed from: qz.a$a, reason: collision with other inner class name */
    class C0098a implements d {
        final /* synthetic */ File a;

        C0098a(File file) {
            this.a = file;
        }

        @Override // qz.a.d
        public FileChannel a() {
            return new FileInputStream(this.a).getChannel();
        }
    }

    class b implements d {
        final /* synthetic */ ParcelFileDescriptor a;

        b(ParcelFileDescriptor parcelFileDescriptor) {
            this.a = parcelFileDescriptor;
        }

        @Override // qz.a.d
        public FileChannel a() {
            if (this.a.getStatSize() != -1) {
                return new ParcelFileDescriptor.AutoCloseInputStream(this.a).getChannel();
            }
            this.a.close();
            throw new IllegalArgumentException("Not a file: " + this.a);
        }
    }

    private static final class c extends UploadDataProvider {
        private final ByteBuffer a;

        private c(ByteBuffer byteBuffer) {
            this.a = byteBuffer;
        }

        public long getLength() {
            return this.a.limit();
        }

        public void read(UploadDataSink uploadDataSink, ByteBuffer byteBuffer) {
            if (!byteBuffer.hasRemaining()) {
                throw new IllegalStateException("Cronet passed a buffer with no bytes remaining");
            }
            if (byteBuffer.remaining() >= this.a.remaining()) {
                byteBuffer.put(this.a);
            } else {
                int limit = this.a.limit();
                ByteBuffer byteBuffer2 = this.a;
                byteBuffer.put(this.a);
            }
            uploadDataSink.onReadSucceeded(false);
        }

        public void rewind(UploadDataSink uploadDataSink) {
            uploadDataSink.onRewindSucceeded();
        }
    }

    private interface d {
        FileChannel a();
    }

    private static final class e extends UploadDataProvider {
        private volatile FileChannel a;
        private final d b;
        private final Object c;

        private e(d dVar) {
            this.c = new Object();
            this.b = dVar;
        }

        private FileChannel d() {
            if (this.a == null) {
                synchronized (this.c) {
                    try {
                        if (this.a == null) {
                            this.a = this.b.a();
                        }
                    } finally {
                    }
                }
            }
            return this.a;
        }

        public void close() {
            FileChannel fileChannel = this.a;
            if (fileChannel != null) {
                fileChannel.close();
            }
        }

        public long getLength() {
            return d().size();
        }

        public void read(UploadDataSink uploadDataSink, ByteBuffer byteBuffer) {
            if (!byteBuffer.hasRemaining()) {
                throw new IllegalStateException("Cronet passed a buffer with no bytes remaining");
            }
            FileChannel d = d();
            int i = 0;
            while (i == 0) {
                int read = d.read(byteBuffer);
                if (read == -1) {
                    break;
                } else {
                    i += read;
                }
            }
            uploadDataSink.onReadSucceeded(false);
        }

        public void rewind(UploadDataSink uploadDataSink) {
            d().position(0L);
            uploadDataSink.onRewindSucceeded();
        }
    }

    public static UploadDataProvider a(ParcelFileDescriptor parcelFileDescriptor) {
        return new e(new b(parcelFileDescriptor));
    }

    public static UploadDataProvider b(File file) {
        return new e(new C0098a(file));
    }

    public static UploadDataProvider c(ByteBuffer byteBuffer) {
        return new c(byteBuffer.slice());
    }

    public static UploadDataProvider d(byte[] bArr) {
        return e(bArr, 0, bArr.length);
    }

    public static UploadDataProvider e(byte[] bArr, int i, int i2) {
        return new c(ByteBuffer.wrap(bArr, i, i2).slice());
    }
}
