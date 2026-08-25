package no;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.os.Environment;
import android.provider.MediaStore;
import com.transsion.gslb.BuildConfig;
import com.transsion.publish.api.PhotoEntity;
import io.reactivex.rxjava3.core.k;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class b {
    private final Context a;
    private ContentResolver b;

    public b(Context context) {
        Intrinsics.h(context, "context");
        this.a = context;
        this.b = context.getContentResolver();
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x00da, code lost:
    
        if (r5 != null) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x00dc, code lost:
    
        r5.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x00ee, code lost:
    
        wf.a.a.f(wf.a.a, "SelectVideoManager", "size:" + r10 + ",path:" + r9 + ",thumbPath:" + r13, false, 4, (java.lang.Object) null);
        r0 = new com.transsion.publish.api.PhotoEntity();
        r0.setImageTitle(r7);
        r0.setLocalPath(r9);
        r0.setImageSize((long) r10);
        r0.setThumbPath(r13);
        r0.setHeight(r12);
        r0.setWidth(r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0138, code lost:
    
        if (r21.isDisposed() != false) goto L78;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x013a, code lost:
    
        r21.onNext(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x013d, code lost:
    
        r0 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0140, code lost:
    
        r6.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0143, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00eb, code lost:
    
        if (r5 == null) goto L46;
     */
    /* JADX WARN: Removed duplicated region for block: B:68:0x016e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a(k kVar) {
        Cursor cursor;
        Cursor cursor2;
        Intrinsics.h(kVar, "emitter");
        if (!Environment.getExternalStorageState().equals("mounted")) {
            return;
        }
        try {
            String[] strArr = {"_id", "_data", "_size", "mime_type", "height", "width", "_display_name"};
            ContentResolver contentResolver = this.b;
            Cursor query = contentResolver != null ? contentResolver.query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, strArr, "mime_type=? or mime_type=? or mime_type=? or mime_type =?", new String[]{"image/jpeg", "image/png", "image/gif", "image/webp"}, "date_added DESC") : null;
            boolean z = false;
            while (query != null) {
                try {
                    if (!query.moveToNext()) {
                        break;
                    }
                    String string = query.getString(query.getColumnIndex("_display_name"));
                    Intrinsics.g(string, "getString(...)");
                    String string2 = query.getString(query.getColumnIndex("_data"));
                    Intrinsics.g(string2, "getString(...)");
                    int i = query.getInt(query.getColumnIndex("_size")) / 1024;
                    int i2 = query.getInt(query.getColumnIndex("width"));
                    int i3 = query.getInt(query.getColumnIndex("height"));
                    String string3 = query.getString(query.getColumnIndex("_id"));
                    String str = BuildConfig.FLAVOR;
                    try {
                        ContentResolver contentResolver2 = this.b;
                        cursor2 = contentResolver2 != null ? contentResolver2.query(MediaStore.Images.Thumbnails.EXTERNAL_CONTENT_URI, new String[]{"_data", "image_id"}, "image_id=?", new String[]{string3}, null) : null;
                        if (cursor2 != null) {
                            try {
                                try {
                                    if (cursor2.moveToFirst()) {
                                        String string4 = cursor2.getString(cursor2.getColumnIndexOrThrow("_data"));
                                        Intrinsics.g(string4, "getString(...)");
                                        str = string4;
                                    }
                                } catch (Throwable th2) {
                                    th = th2;
                                    if (cursor2 != null) {
                                        cursor2.close();
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
                        cursor2 = null;
                    }
                } catch (Exception e3) {
                    e = e3;
                    cursor = query;
                    try {
                        e.printStackTrace();
                        kVar.onNext(new PhotoEntity());
                        if (cursor != null) {
                            cursor.close();
                            return;
                        }
                        return;
                    } catch (Throwable th4) {
                        th = th4;
                        if (cursor != null) {
                            cursor.close();
                        }
                        throw th;
                    }
                } catch (Throwable th5) {
                    th = th5;
                    cursor = query;
                    if (cursor != null) {
                    }
                    throw th;
                }
            }
            if (!z) {
                kVar.onNext(new PhotoEntity());
            }
            if (query != null) {
                query.close();
            }
        } catch (Exception e4) {
            e = e4;
            cursor = null;
        } catch (Throwable th6) {
            th = th6;
            cursor = null;
        }
    }
}
