package com.transsion.postdetail.util;

import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class VideoSaver {
    public static final VideoSaver a = new VideoSaver();

    private VideoSaver() {
    }

    private final Object a(Context context, InputStream inputStream, String str, Continuation continuation) {
        try {
            File externalStoragePublicDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MOVIES);
            if (!externalStoragePublicDirectory.exists()) {
                externalStoragePublicDirectory.mkdirs();
            }
            File file = new File(externalStoragePublicDirectory, str);
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            try {
                ByteStreamsKt.b(inputStream, fileOutputStream, 0, 2, (Object) null);
                CloseableKt.a(fileOutputStream, (Throwable) null);
                c cVar = c.a;
                String absolutePath = file.getAbsolutePath();
                Intrinsics.g(absolutePath, "getAbsolutePath(...)");
                cVar.a(context, absolutePath);
                return Uri.fromFile(file);
            } finally {
            }
        } catch (Exception unused) {
            return null;
        }
    }

    private final Object b(Context context, InputStream inputStream, String str, Continuation continuation) {
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("_display_name", str);
            contentValues.put("mime_type", "video/mp4");
            contentValues.put("is_pending", Boxing.d(1));
            Uri insert = context.getContentResolver().insert(Build.VERSION.SDK_INT >= 29 ? MediaStore.Video.Media.getContentUri("external_primary") : MediaStore.Video.Media.EXTERNAL_CONTENT_URI, contentValues);
            if (insert != null) {
                OutputStream openOutputStream = context.getContentResolver().openOutputStream(insert);
                if (openOutputStream != null) {
                    try {
                        Boxing.e(ByteStreamsKt.b(inputStream, openOutputStream, 0, 2, (Object) null));
                        CloseableKt.a(openOutputStream, (Throwable) null);
                    } finally {
                    }
                }
                contentValues.clear();
                contentValues.put("is_pending", Boxing.d(0));
                Boxing.d(context.getContentResolver().update(insert, contentValues, null, null));
            }
            return insert;
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object c(Context context, String str, String str2, Continuation continuation) {
        VideoSaver$saveVideoToGallery$1 videoSaver$saveVideoToGallery$1;
        int i;
        try {
            if (continuation instanceof VideoSaver$saveVideoToGallery$1) {
                videoSaver$saveVideoToGallery$1 = (VideoSaver$saveVideoToGallery$1) continuation;
                int i2 = videoSaver$saveVideoToGallery$1.label;
                if ((i2 & Integer.MIN_VALUE) != 0) {
                    videoSaver$saveVideoToGallery$1.label = i2 - Integer.MIN_VALUE;
                    Object obj = videoSaver$saveVideoToGallery$1.result;
                    Object f = IntrinsicsKt.f();
                    i = videoSaver$saveVideoToGallery$1.label;
                    if (i == 0) {
                        if (i == 1) {
                            ResultKt.b(obj);
                            return (Uri) obj;
                        }
                        if (i != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.b(obj);
                        return (Uri) obj;
                    }
                    ResultKt.b(obj);
                    InputStream openStream = FirebasePerfUrlConnection.openStream(new URL(str));
                    Intrinsics.g(openStream, "openStream(...)");
                    if (Build.VERSION.SDK_INT >= 29) {
                        videoSaver$saveVideoToGallery$1.label = 1;
                        obj = b(context, openStream, str2, videoSaver$saveVideoToGallery$1);
                        if (obj == f) {
                            return f;
                        }
                        return (Uri) obj;
                    }
                    videoSaver$saveVideoToGallery$1.label = 2;
                    obj = a(context, openStream, str2, videoSaver$saveVideoToGallery$1);
                    if (obj == f) {
                        return f;
                    }
                    return (Uri) obj;
                }
            }
            if (i == 0) {
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        videoSaver$saveVideoToGallery$1 = new VideoSaver$saveVideoToGallery$1(this, continuation);
        Object obj2 = videoSaver$saveVideoToGallery$1.result;
        Object f2 = IntrinsicsKt.f();
        i = videoSaver$saveVideoToGallery$1.label;
    }
}
