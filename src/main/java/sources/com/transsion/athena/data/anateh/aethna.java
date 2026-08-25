package com.transsion.athena.data.anateh;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.util.LongSparseArray;
import android.util.SparseArray;
import com.transsion.athena.config.data.model.ehanat;
import com.transsion.athena.data.AppIdData;
import com.transsion.athena.data.Track;
import com.transsion.athena.data.anateh.anehat;
import com.transsion.athena.hatnea.anateh;
import com.transsion.athena.hatnea.taaneh;
import com.transsion.ga.i;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public class aethna {

    @SuppressLint({"StaticFieldLeak"})
    private static volatile aethna a;
    private Context b;
    private anehat c;
    private String d;

    public interface athena {
        void a(anateh anatehVar);
    }

    private aethna(Context context) {
        try {
            this.b = context;
            this.c = anehat.a(context);
            this.d = context.getFilesDir().getPath();
        } catch (Exception e) {
            com.transsion.athena.taaneh.aethna.a(e);
        }
    }

    public static aethna a(Context context) {
        if (a == null) {
            synchronized (aethna.class) {
                try {
                    if (a == null) {
                        a = new aethna(context);
                    }
                } finally {
                }
            }
        }
        return a;
    }

    public int a(int i, enatha<String> enathaVar) {
        try {
            return this.c.a(anehat.athena.a, i, enathaVar);
        } catch (com.transsion.ga.anateh e) {
            int i2 = com.transsion.ga.anateh.a;
            i.a().c(e);
            return -1;
        }
    }

    public int a(Track track) {
        int i = 1;
        if (track.getTrackFlag() != 1 && track.getTrackFlag() != 2) {
            i = 0;
        }
        try {
            return this.c.a(anehat.athena.a, track, i);
        } catch (com.transsion.ga.anateh e) {
            int i2 = com.transsion.ga.anateh.a;
            i.a().c(e);
            return 0;
        }
    }

    public int a(ArrayList<Track> arrayList, enatha<LongSparseArray<Integer>> enathaVar) {
        try {
            return this.c.b(anehat.athena.a, arrayList, enathaVar);
        } catch (com.transsion.ga.anateh e) {
            int i = com.transsion.ga.anateh.a;
            i.a().c(e);
            return 0;
        }
    }

    public synchronized com.transsion.athena.data.anehat a(long j, long j2, String str, int i, int i2) {
        try {
        } catch (com.transsion.ga.anateh e) {
            int i3 = com.transsion.ga.anateh.a;
            i.a().c(e);
            return null;
        }
        return this.c.a(anehat.athena.a, j, j2, str, i, i2);
    }

    public synchronized void a() {
        this.c.a();
        try {
            Context context = this.b;
            StringBuilder sb = new StringBuilder();
            sb.append(this.d);
            String str = File.separator;
            sb.append(str);
            sb.append(ehanat.k);
            com.transsion.athena.taaneh.athena.a(context, sb.toString());
            com.transsion.athena.taaneh.athena.a(this.b, this.d + str + ehanat.l);
        } catch (Exception e) {
            com.transsion.athena.taaneh.aethna.b(Log.getStackTraceString(e));
        }
    }

    public synchronized void a(long j, athena athenaVar) {
        try {
            String str = this.d + File.separator + ehanat.k;
            if (new File(str).exists()) {
                for (File file : com.transsion.athena.taaneh.athena.a(str, j)) {
                    if (!file.getName().contains("upload")) {
                        if (!file.getName().startsWith("f_")) {
                            if (file.getName().startsWith("r_")) {
                            }
                        }
                        File file2 = new File(file.getPath() + "upload" + System.currentTimeMillis());
                        file = !file.renameTo(file2) ? null : file2;
                    }
                    if (file != null) {
                        athenaVar.a(new taaneh(j, file, com.transsion.athena.aethna.athena.c().a(j)));
                    }
                }
            }
            String str2 = this.d + File.separator + ehanat.l;
            if (new File(str2).exists()) {
                try {
                    com.transsion.athena.taaneh.athena.a(this.b, str2);
                } catch (Exception e) {
                    com.transsion.athena.taaneh.aethna.b(Log.getStackTraceString(e));
                }
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public synchronized void a(com.transsion.athena.config.data.model.athena athenaVar, boolean z) {
        try {
            this.c.a(anehat.athena.d, athenaVar, z);
        } catch (com.transsion.ga.anateh e) {
            int i = com.transsion.ga.anateh.a;
            i.a().c(e);
        }
    }

    public void a(AppIdData appIdData) {
        try {
            this.c.a(anehat.athena.d, appIdData);
        } catch (com.transsion.ga.anateh e) {
            int i = com.transsion.ga.anateh.a;
            i.a().c(e);
        }
    }

    public void a(enatha<SparseArray<com.transsion.athena.config.data.model.athena>> enathaVar) {
        try {
            this.c.a(enathaVar);
        } catch (com.transsion.ga.anateh e) {
            int i = com.transsion.ga.anateh.a;
            i.a().c(e);
        }
    }

    public synchronized void a(String str, long j) {
        try {
            this.c.a(anehat.athena.a, str, j);
        } catch (com.transsion.ga.anateh e) {
            int i = com.transsion.ga.anateh.a;
            i.a().c(e);
        }
    }

    public synchronized void a(List<AppIdData> list) {
        try {
            this.c.a(anehat.athena.d, list);
        } catch (com.transsion.ga.anateh e) {
            int i = com.transsion.ga.anateh.a;
            i.a().c(e);
        }
    }

    public synchronized void a(List<AppIdData> list, int i) {
        try {
            this.c.a(anehat.athena.d, list, i);
        } catch (com.transsion.ga.anateh e) {
            int i2 = com.transsion.ga.anateh.a;
            i.a().c(e);
        }
    }

    public synchronized void a(List<AppIdData> list, long j, String str, enatha<SparseArray<com.transsion.athena.data.enatha>> enathaVar) {
        try {
            this.c.a(anehat.athena.a, list, j, str, enathaVar);
        } catch (com.transsion.ga.anateh e) {
            int i = com.transsion.ga.anateh.a;
            i.a().c(e);
        }
    }

    public synchronized void a(List<AppIdData> list, String str) {
        try {
            this.c.a(anehat.athena.a, list, str);
        } catch (com.transsion.ga.anateh e) {
            int i = com.transsion.ga.anateh.a;
            i.a().c(e);
        }
    }

    public synchronized void a(List<Long> list, boolean z, enatha<String> enathaVar) {
        if (z) {
            try {
                String str = this.d + File.separator + ehanat.k;
                if (new File(str).exists()) {
                    for (File file : com.transsion.athena.taaneh.athena.a(str)) {
                        String name = file.getName();
                        if (!name.startsWith("f_") && !name.startsWith("r_")) {
                            com.transsion.athena.taaneh.aethna.a("cleanupEvents deleteFile " + name + " " + com.transsion.athena.taaneh.athena.b(this.b, file));
                        }
                        if (list.contains(Long.valueOf(Long.parseLong(name.substring(2, name.indexOf(45)))))) {
                            com.transsion.athena.taaneh.aethna.a("cleanupEvents deleteFile " + name + " " + com.transsion.athena.taaneh.athena.b(this.b, file));
                        }
                    }
                }
                String str2 = this.d + File.separator + ehanat.l;
                if (new File(str2).exists()) {
                    try {
                        com.transsion.athena.taaneh.athena.a(this.b, str2);
                    } catch (Exception e) {
                        com.transsion.athena.taaneh.aethna.b(Log.getStackTraceString(e));
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        try {
            this.c.a(anehat.athena.a, list, enathaVar);
        } catch (com.transsion.ga.anateh e2) {
            int i = com.transsion.ga.anateh.a;
            i.a().c(e2);
        }
    }

    public synchronized boolean a(int i) {
        try {
        } catch (com.transsion.ga.anateh e) {
            int i2 = com.transsion.ga.anateh.a;
            i.a().c(e);
            return false;
        }
        return this.c.a(anehat.athena.a, i);
    }

    public void b() {
        this.c.a(true);
    }

    public List<AppIdData> c() {
        try {
            return this.c.a(anehat.athena.d);
        } catch (com.transsion.ga.anateh e) {
            int i = com.transsion.ga.anateh.a;
            i.a().c(e);
            return null;
        }
    }
}
