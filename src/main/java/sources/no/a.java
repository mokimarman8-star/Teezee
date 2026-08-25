package no;

import android.content.ContentResolver;
import android.content.Context;
import android.os.Environment;
import android.provider.MediaStore;
import com.transsion.gslb.BuildConfig;
import com.transsion.publish.api.AudioEntity;
import io.reactivex.rxjava3.core.k;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class a {
    private final Context a;
    private ContentResolver b;

    public a(Context context) {
        Intrinsics.h(context, "context");
        this.a = context;
        this.b = context.getContentResolver();
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x00ed  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a(k kVar) {
        Intrinsics.h(kVar, "emitter");
        if (Environment.getExternalStorageState().equals("mounted")) {
            try {
                String[] strArr = {"_id", "_data", "_size", "mime_type", "title", "artist", "duration"};
                try {
                    try {
                        ContentResolver contentResolver = this.b;
                        r2 = contentResolver != null ? contentResolver.query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, strArr, null, null, "date_added DESC") : null;
                        boolean z = false;
                        while (r2 != null && r2.moveToNext()) {
                            String string = r2.getString(r2.getColumnIndex("title"));
                            Intrinsics.g(string, "getString(...)");
                            String string2 = r2.getString(r2.getColumnIndex("_data"));
                            Intrinsics.g(string2, "getString(...)");
                            long j = r2.getLong(r2.getColumnIndex("_size"));
                            String string3 = r2.getString(r2.getColumnIndex("artist"));
                            Intrinsics.g(string3, "getString(...)");
                            long j2 = r2.getLong(r2.getColumnIndexOrThrow("duration"));
                            AudioEntity audioEntity = new AudioEntity();
                            audioEntity.setImageTitle(string);
                            audioEntity.setLocalPath(string2);
                            audioEntity.setSize(j);
                            audioEntity.setThumbPath(BuildConfig.FLAVOR);
                            audioEntity.setArtist(string3);
                            audioEntity.setDuration(Long.valueOf(j2));
                            StringBuilder sb = new StringBuilder();
                            sb.append("size:");
                            sb.append(j);
                            sb.append(",path:");
                            sb.append(string2);
                            sb.append(",duration:");
                            sb.append(j2);
                            if (kVar.isDisposed()) {
                                r2.close();
                                return;
                            } else {
                                kVar.onNext(audioEntity);
                                z = true;
                            }
                        }
                        if (!z) {
                            kVar.onNext(new AudioEntity());
                        }
                        if (r2 == null) {
                            return;
                        }
                    } catch (Exception e) {
                        e = e;
                        e.printStackTrace();
                        if (r2 == null) {
                            return;
                        }
                        r2.close();
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (r2 != null) {
                        r2.close();
                    }
                    throw th;
                }
            } catch (Exception e2) {
                e = e2;
            } catch (Throwable th3) {
                th = th3;
                if (r2 != null) {
                }
                throw th;
            }
            r2.close();
        }
    }
}
