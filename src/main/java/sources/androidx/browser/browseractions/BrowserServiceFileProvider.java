package androidx.browser.browseractions;

import android.content.ContentResolver;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import androidx.core.content.FileProvider;
import java.io.FileNotFoundException;
import java.io.IOException;

@Deprecated
/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class BrowserServiceFileProvider extends FileProvider {

    /* renamed from: a, reason: collision with root package name */
    static Object f1152a = new Object();

    /* renamed from: androidx.browser.browseractions.BrowserServiceFileProvider$1, reason: invalid class name */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ ContentResolver val$resolver;
        final /* synthetic */ androidx.concurrent.futures.b val$result;
        final /* synthetic */ Uri val$uri;

        AnonymousClass1(ContentResolver contentResolver, Uri uri, androidx.concurrent.futures.b bVar) {
            this.val$resolver = contentResolver;
            this.val$uri = uri;
            this.val$result = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                ParcelFileDescriptor openFileDescriptor = this.val$resolver.openFileDescriptor(this.val$uri, "r");
                if (openFileDescriptor == null) {
                    this.val$result.v(new FileNotFoundException());
                    return;
                }
                Bitmap decodeFileDescriptor = BitmapFactory.decodeFileDescriptor(openFileDescriptor.getFileDescriptor());
                openFileDescriptor.close();
                if (decodeFileDescriptor == null) {
                    this.val$result.v(new IOException("File could not be decoded."));
                } else {
                    this.val$result.u(decodeFileDescriptor);
                }
            } catch (IOException e5) {
                this.val$result.v(e5);
            }
        }
    }
}
