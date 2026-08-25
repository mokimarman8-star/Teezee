package qo;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public class a {
    public static Bitmap a(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
        for (int i = 90; byteArrayOutputStream.toByteArray().length / 1024 > 100 && i > 50; i -= 10) {
            byteArrayOutputStream.reset();
            bitmap.compress(Bitmap.CompressFormat.PNG, i, byteArrayOutputStream);
        }
        return BitmapFactory.decodeStream(new ByteArrayInputStream(byteArrayOutputStream.toByteArray()), null, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0038 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Bitmap b(String str) {
        int i;
        float f;
        Bitmap decodeFile;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        options.inJustDecodeBounds = false;
        int i2 = options.outWidth;
        int i3 = options.outHeight;
        if (i2 > i3 && i2 > 480.0f) {
            f = i2 / 480.0f;
        } else {
            if (i2 >= i3 || i3 <= 800.0f) {
                i = 1;
                options.inSampleSize = i > 0 ? i : 1;
                decodeFile = BitmapFactory.decodeFile(str, options);
                if (decodeFile != null) {
                    return null;
                }
                return a(decodeFile);
            }
            f = i3 / 800.0f;
        }
        i = (int) f;
        options.inSampleSize = i > 0 ? i : 1;
        decodeFile = BitmapFactory.decodeFile(str, options);
        if (decodeFile != null) {
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:36:0x001b -> B:10:0x002d). Please report as a decompilation issue!!! */
    public static void c(Bitmap bitmap, File file, int i) {
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                try {
                    fileOutputStream = new FileOutputStream(file);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (FileNotFoundException e2) {
                e = e2;
            }
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            try {
                bitmap.compress(Bitmap.CompressFormat.JPEG, i, fileOutputStream);
                try {
                    fileOutputStream.flush();
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
                fileOutputStream.close();
            } catch (FileNotFoundException e4) {
                e = e4;
                fileOutputStream2 = fileOutputStream;
                e.printStackTrace();
                if (fileOutputStream2 != null) {
                    fileOutputStream2.close();
                }
                bitmap.recycle();
            }
            bitmap.recycle();
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream2 = fileOutputStream;
            if (fileOutputStream2 != null) {
                try {
                    fileOutputStream2.close();
                } catch (IOException e5) {
                    e5.printStackTrace();
                }
            }
            throw th;
        }
    }
}
