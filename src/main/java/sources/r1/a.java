package r1;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class a {

    /* renamed from: f, reason: collision with root package name */
    private static final Object f17170f = new Object();

    /* renamed from: g, reason: collision with root package name */
    private static a f17171g;

    /* renamed from: a, reason: collision with root package name */
    private final Context f17172a;

    /* renamed from: b, reason: collision with root package name */
    private final HashMap f17173b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    private final HashMap f17174c = new HashMap();

    /* renamed from: d, reason: collision with root package name */
    private final ArrayList f17175d = new ArrayList();

    /* renamed from: e, reason: collision with root package name */
    private final Handler f17176e;

    /* renamed from: r1.a$a, reason: collision with other inner class name */
    class HandlerC0171a extends Handler {
        HandlerC0171a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 1) {
                super.handleMessage(message);
            } else {
                a.this.a();
            }
        }
    }

    private static final class b {

        /* renamed from: a, reason: collision with root package name */
        final Intent f17178a;

        /* renamed from: b, reason: collision with root package name */
        final ArrayList f17179b;

        b(Intent intent, ArrayList arrayList) {
            this.f17178a = intent;
            this.f17179b = arrayList;
        }
    }

    private static final class c {

        /* renamed from: a, reason: collision with root package name */
        final IntentFilter f17180a;

        /* renamed from: b, reason: collision with root package name */
        final BroadcastReceiver f17181b;

        /* renamed from: c, reason: collision with root package name */
        boolean f17182c;

        /* renamed from: d, reason: collision with root package name */
        boolean f17183d;

        c(IntentFilter intentFilter, BroadcastReceiver broadcastReceiver) {
            this.f17180a = intentFilter;
            this.f17181b = broadcastReceiver;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(128);
            sb.append("Receiver{");
            sb.append(this.f17181b);
            sb.append(" filter=");
            sb.append(this.f17180a);
            if (this.f17183d) {
                sb.append(" DEAD");
            }
            sb.append("}");
            return sb.toString();
        }
    }

    private a(Context context) {
        this.f17172a = context;
        this.f17176e = new HandlerC0171a(context.getMainLooper());
    }

    public static a b(Context context) {
        a aVar;
        synchronized (f17170f) {
            try {
                if (f17171g == null) {
                    f17171g = new a(context.getApplicationContext());
                }
                aVar = f17171g;
            } catch (Throwable th) {
                throw th;
            }
        }
        return aVar;
    }

    void a() {
        int size;
        b[] bVarArr;
        while (true) {
            synchronized (this.f17173b) {
                try {
                    size = this.f17175d.size();
                    if (size <= 0) {
                        return;
                    }
                    bVarArr = new b[size];
                    this.f17175d.toArray(bVarArr);
                    this.f17175d.clear();
                } catch (Throwable th) {
                    throw th;
                }
            }
            for (int i5 = 0; i5 < size; i5++) {
                b bVar = bVarArr[i5];
                int size2 = bVar.f17179b.size();
                for (int i6 = 0; i6 < size2; i6++) {
                    c cVar = (c) bVar.f17179b.get(i6);
                    if (!cVar.f17183d) {
                        cVar.f17181b.onReceive(this.f17172a, bVar.f17178a);
                    }
                }
            }
        }
    }

    public void c(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        synchronized (this.f17173b) {
            try {
                c cVar = new c(intentFilter, broadcastReceiver);
                ArrayList arrayList = (ArrayList) this.f17173b.get(broadcastReceiver);
                if (arrayList == null) {
                    arrayList = new ArrayList(1);
                    this.f17173b.put(broadcastReceiver, arrayList);
                }
                arrayList.add(cVar);
                for (int i5 = 0; i5 < intentFilter.countActions(); i5++) {
                    String action = intentFilter.getAction(i5);
                    ArrayList arrayList2 = (ArrayList) this.f17174c.get(action);
                    if (arrayList2 == null) {
                        arrayList2 = new ArrayList(1);
                        this.f17174c.put(action, arrayList2);
                    }
                    arrayList2.add(cVar);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public boolean d(Intent intent) {
        int i5;
        String str;
        ArrayList arrayList;
        ArrayList arrayList2;
        String str2;
        synchronized (this.f17173b) {
            try {
                String action = intent.getAction();
                String resolveTypeIfNeeded = intent.resolveTypeIfNeeded(this.f17172a.getContentResolver());
                Uri data = intent.getData();
                String scheme = intent.getScheme();
                Set<String> categories = intent.getCategories();
                boolean z5 = (intent.getFlags() & 8) != 0;
                if (z5) {
                    Log.v("LocalBroadcastManager", "Resolving type " + resolveTypeIfNeeded + " scheme " + scheme + " of intent " + intent);
                }
                ArrayList arrayList3 = (ArrayList) this.f17174c.get(intent.getAction());
                if (arrayList3 != null) {
                    if (z5) {
                        Log.v("LocalBroadcastManager", "Action list: " + arrayList3);
                    }
                    ArrayList arrayList4 = null;
                    int i6 = 0;
                    while (i6 < arrayList3.size()) {
                        c cVar = (c) arrayList3.get(i6);
                        if (z5) {
                            Log.v("LocalBroadcastManager", "Matching against filter " + cVar.f17180a);
                        }
                        if (cVar.f17182c) {
                            if (z5) {
                                Log.v("LocalBroadcastManager", "  Filter's target already added");
                            }
                            i5 = i6;
                            arrayList2 = arrayList3;
                            str = action;
                            str2 = resolveTypeIfNeeded;
                            arrayList = arrayList4;
                        } else {
                            i5 = i6;
                            str = action;
                            arrayList = arrayList4;
                            arrayList2 = arrayList3;
                            str2 = resolveTypeIfNeeded;
                            int match = cVar.f17180a.match(action, resolveTypeIfNeeded, scheme, data, categories, "LocalBroadcastManager");
                            if (match >= 0) {
                                if (z5) {
                                    Log.v("LocalBroadcastManager", "  Filter matched!  match=0x" + Integer.toHexString(match));
                                }
                                arrayList4 = arrayList == null ? new ArrayList() : arrayList;
                                arrayList4.add(cVar);
                                cVar.f17182c = true;
                                i6 = i5 + 1;
                                action = str;
                                arrayList3 = arrayList2;
                                resolveTypeIfNeeded = str2;
                            } else if (z5) {
                                Log.v("LocalBroadcastManager", "  Filter did not match: " + (match != -4 ? match != -3 ? match != -2 ? match != -1 ? "unknown reason" : "type" : "data" : "action" : "category"));
                            }
                        }
                        arrayList4 = arrayList;
                        i6 = i5 + 1;
                        action = str;
                        arrayList3 = arrayList2;
                        resolveTypeIfNeeded = str2;
                    }
                    ArrayList arrayList5 = arrayList4;
                    if (arrayList5 != null) {
                        for (int i7 = 0; i7 < arrayList5.size(); i7++) {
                            ((c) arrayList5.get(i7)).f17182c = false;
                        }
                        this.f17175d.add(new b(intent, arrayList5));
                        if (!this.f17176e.hasMessages(1)) {
                            this.f17176e.sendEmptyMessage(1);
                        }
                        return true;
                    }
                }
                return false;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void e(BroadcastReceiver broadcastReceiver) {
        synchronized (this.f17173b) {
            try {
                ArrayList arrayList = (ArrayList) this.f17173b.remove(broadcastReceiver);
                if (arrayList == null) {
                    return;
                }
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    c cVar = (c) arrayList.get(size);
                    cVar.f17183d = true;
                    for (int i5 = 0; i5 < cVar.f17180a.countActions(); i5++) {
                        String action = cVar.f17180a.getAction(i5);
                        ArrayList arrayList2 = (ArrayList) this.f17174c.get(action);
                        if (arrayList2 != null) {
                            for (int size2 = arrayList2.size() - 1; size2 >= 0; size2--) {
                                c cVar2 = (c) arrayList2.get(size2);
                                if (cVar2.f17181b == broadcastReceiver) {
                                    cVar2.f17183d = true;
                                    arrayList2.remove(size2);
                                }
                            }
                            if (arrayList2.size() <= 0) {
                                this.f17174c.remove(action);
                            }
                        }
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
