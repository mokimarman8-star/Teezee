package no;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import com.transsion.gslb.BuildConfig;
import com.transsion.publish.api.VsMediaInfo;
import io.reactivex.rxjava3.core.k;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class c {
    private final Context a;
    private ContentResolver b;

    public c(Context context) {
        Intrinsics.h(context, "context");
        this.a = context;
        this.b = context.getContentResolver();
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x00eb, code lost:
    
        if (r3 != null) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x00ed, code lost:
    
        r3.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x00f9, code lost:
    
        r0 = r17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0102, code lost:
    
        r3 = new java.lang.StringBuilder();
        r3.append("size:");
        r3.append(r12);
        r3.append(",duration:");
        r3.append(r14);
        r3.append(",path:");
        r3.append(r4);
        r3.append(",thumbPath:");
        r3.append(r0);
        r6 = r10.getLong(7);
        r5 = r10.getLong(8);
        r3 = new com.transsion.publish.api.VsMediaInfo();
        r3.setVideoDuration(r14);
        r3.setVideoTitle(r11);
        r3.setVideoPath(r4);
        r3.setVideoSize(r12);
        r3.setImagePath(r0);
        r3.setHeight((int) r6);
        r3.setWidth((int) r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0156, code lost:
    
        if (r25.isDisposed() != false) goto L79;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0158, code lost:
    
        r25.onNext(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x015b, code lost:
    
        r0 = true;
        r3 = 3;
        r4 = 2;
        r5 = 1;
        r6 = 0;
        r7 = 4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0163, code lost:
    
        r10.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0166, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00ff, code lost:
    
        if (r3 == null) goto L45;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a(k kVar) {
        Cursor cursor;
        Cursor cursor2;
        int i = 3;
        int i2 = 2;
        int i3 = 1;
        int i4 = 0;
        int i5 = 4;
        Intrinsics.h(kVar, "emitter");
        String[] strArr = {"title", "_size", "duration", "_data", "_id", "date_added", "mime_type", "height", "width"};
        if (!Environment.getExternalStorageState().equals("mounted")) {
            return;
        }
        Cursor cursor3 = null;
        try {
            try {
                ContentResolver contentResolver = this.b;
                if (contentResolver != null) {
                    Uri uri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
                    StringCompanionObject stringCompanionObject = StringCompanionObject.a;
                    String format = String.format("%1$s IN (?, ?, ?) AND %2$s > %3$s AND %2$s < %4$s", Arrays.copyOf(new Object[]{"mime_type", "duration", 500, 6000000}, 4));
                    Intrinsics.g(format, "format(...)");
                    cursor = contentResolver.query(uri, strArr, format, new String[]{"video/mp4", "video/ext-mp4", "video/3gpp"}, "date_added DESC");
                } else {
                    cursor = null;
                }
                boolean z = false;
                while (cursor != null) {
                    try {
                        if (cursor.moveToNext() != i3) {
                            break;
                        }
                        String string = cursor.getString(i4);
                        Intrinsics.g(string, "getString(...)");
                        long j = cursor.getLong(i3);
                        long j2 = cursor.getLong(i2);
                        String string2 = cursor.getString(i);
                        Intrinsics.g(string2, "getString(...)");
                        String string3 = cursor.getString(i5);
                        Intrinsics.g(string3, "getString(...)");
                        String str = BuildConfig.FLAVOR;
                        try {
                            ContentResolver contentResolver2 = this.b;
                            cursor2 = contentResolver2 != null ? contentResolver2.query(MediaStore.Video.Thumbnails.EXTERNAL_CONTENT_URI, new String[]{"_data", "video_id"}, "video_id=?", new String[]{string3}, null) : null;
                            if (cursor2 != null) {
                                try {
                                    try {
                                        if (cursor2.moveToFirst() == i3) {
                                            String string4 = cursor2.getString(cursor2.getColumnIndexOrThrow("_data"));
                                            Intrinsics.g(string4, "getString(...)");
                                            str = string4;
                                        }
                                    } catch (Throwable th2) {
                                        th = th2;
                                        cursor3 = cursor2;
                                        if (cursor3 != null) {
                                            cursor3.close();
                                        }
                                        throw th;
                                    }
                                } catch (Exception e) {
                                    e = e;
                                    e.printStackTrace();
                                }
                            }
                        } catch (Exception e2) {
                            e = e2;
                            cursor2 = null;
                        } catch (Throwable th3) {
                            th = th3;
                        }
                    } catch (Exception e3) {
                        e = e3;
                        cursor3 = cursor;
                        e.printStackTrace();
                        if (cursor3 != null) {
                            cursor3.close();
                            return;
                        }
                        return;
                    } catch (Throwable th4) {
                        th = th4;
                        cursor3 = cursor;
                        if (cursor3 != null) {
                            cursor3.close();
                        }
                        throw th;
                    }
                }
                if (!z) {
                    kVar.onNext(new VsMediaInfo());
                }
                if (cursor != null) {
                    cursor.close();
                }
            } catch (Exception e4) {
                e = e4;
            }
        } catch (Throwable th5) {
            th = th5;
        }
    }
}
