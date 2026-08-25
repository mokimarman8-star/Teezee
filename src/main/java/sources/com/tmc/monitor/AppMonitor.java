package com.tmc.monitor;

import android.os.Bundle;
import android.text.TextUtils;
import com.tmc.network.NetworkConfig;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import pf.b;
import pf.c;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public class AppMonitor {
    private static Set b = new CopyOnWriteArraySet();
    private static Map c = new ConcurrentHashMap();
    private static Map d = new ConcurrentHashMap();
    private int a;

    private static class a {
        private static AppMonitor a = new AppMonitor();
    }

    private AppMonitor() {
        this.a = 3755;
        NetworkConfig networkConfig = NetworkConfig.INSTANCE;
        if (networkConfig.getAppMonitorId() != -1) {
            this.a = networkConfig.getAppMonitorId();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(c cVar) {
        List<Field> list;
        try {
            Class<?> cls = cVar.getClass();
            if (!b.contains(cls)) {
                e(cls);
            }
            b bVar = (b) cls.getAnnotation(b.class);
            if (bVar == null) {
                return;
            }
            String id2 = bVar.id();
            String name = bVar.name();
            if (TextUtils.isEmpty(id2) || (list = (List) c.get(cls)) == null) {
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString("object_id", id2);
            bundle.putString("object_name", name);
            for (Field field : list) {
                String str = (String) d.get(field);
                Class<?> type = field.getType();
                if (type.isAssignableFrom(Integer.TYPE)) {
                    bundle.putInt(str, field.getInt(cVar));
                } else if (type.isAssignableFrom(Long.TYPE)) {
                    bundle.putLong(str, field.getLong(cVar));
                } else if (type.isAssignableFrom(Boolean.TYPE)) {
                    bundle.putBoolean(str, field.getBoolean(cVar));
                } else if (type.isAssignableFrom(Character.TYPE)) {
                    bundle.putChar(str, field.getChar(cVar));
                } else if (type.isAssignableFrom(Byte.TYPE)) {
                    bundle.putByte(str, field.getByte(cVar));
                } else if (type.isAssignableFrom(Short.TYPE)) {
                    bundle.putShort(str, field.getShort(cVar));
                } else if (type.isAssignableFrom(Float.TYPE)) {
                    bundle.putFloat(str, field.getFloat(cVar));
                } else if (type.isAssignableFrom(Double.TYPE)) {
                    bundle.putDouble(str, field.getDouble(cVar));
                } else if (type.isAssignableFrom(String.class)) {
                    bundle.putString(str, (String) field.get(cVar));
                } else {
                    rf.b.a.c(" error type = " + type + ", fieldName = " + str);
                }
            }
            rf.b.a.c(" Bundle data = " + bundle.toString());
            new hi.a("network", this.a).c(bundle, (Bundle) null).b();
        } catch (Throwable th) {
            rf.b.a.e(th);
        }
    }

    public static AppMonitor d() {
        return a.a;
    }

    private void e(Class cls) {
        if (cls != null) {
            try {
                if (b.contains(cls) || ((b) cls.getAnnotation(b.class)) == null) {
                    return;
                }
                Field[] declaredFields = cls.getDeclaredFields();
                ArrayList arrayList = new ArrayList();
                for (Field field : declaredFields) {
                    if (((pf.a) field.getAnnotation(pf.a.class)) != null) {
                        field.setAccessible(true);
                        arrayList.add(field);
                        d.put(field, field.getName());
                    }
                }
                c.put(cls, arrayList);
                b.add(cls);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void c(final c cVar) {
        if (cVar != null) {
            try {
                NetworkConfig networkConfig = NetworkConfig.INSTANCE;
                if (networkConfig.isNetworkMonitorEnable()) {
                    if (((int) (Math.random() * 1000.0d)) <= networkConfig.getAppMonitorRandom()) {
                        rf.c.c.a().a(new Runnable() { // from class: com.tmc.monitor.AppMonitor.1
                            @Override // java.lang.Runnable
                            public void run() {
                                AppMonitor.this.b(cVar);
                            }
                        });
                        return;
                    }
                    rf.b.a.c("abort report. data = " + cVar.toString());
                }
            } catch (Throwable th) {
                rf.b.a.e(th);
            }
        }
    }
}
