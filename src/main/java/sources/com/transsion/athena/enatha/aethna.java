package com.transsion.athena.enatha;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.transsion.athena.config.data.model.ehanat;
import com.transsion.athena.data.AppIdData;
import com.transsion.athena.data.TrackData;
import com.transsion.gslb.BuildConfig;
import com.transsion.push.PushConstants;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public class aethna extends athena implements Handler.Callback {

    @SuppressLint({"StaticFieldLeak"})
    private static volatile aethna c;
    private int d;
    private int e;
    private long f;

    private aethna(Context context) {
        super(context);
        this.d = 0;
        this.f = 0L;
        HandlerThread handlerThread = new HandlerThread("Athena-LiteWorker", 10);
        handlerThread.start();
        Handler handler = new Handler(handlerThread.getLooper(), this);
        this.b = handler;
        handler.sendEmptyMessage(303);
    }

    public static aethna a(Context context) {
        if (c == null) {
            synchronized (aethna.class) {
                try {
                    if (c == null) {
                        c = new aethna(context);
                    }
                } finally {
                }
            }
        }
        return c;
    }

    private void a(int i, String str) {
        if (this.d != 1) {
            com.transsion.athena.taaneh.aethna.a("Failed to connect to DCS service");
            return;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put(PushConstants.PROVIDER_FIELD_APP_ID, Integer.valueOf(i));
        if (TextUtils.isEmpty(str)) {
            contentValues.put("baseInfo", AppIdData.a(this.a, i).b);
        } else {
            contentValues.put("baseInfo", str);
        }
        this.a.getContentResolver().insert(Uri.parse("content://com.transsion.dataservice.provider/bind"), contentValues);
    }

    private void a(com.transsion.athena.data.aethna aethnaVar) {
        if (this.d != 1) {
            com.transsion.athena.taaneh.aethna.a("Failed to connect to DCS service");
            return;
        }
        Cursor query = this.a.getContentResolver().query(Uri.parse("content://com.transsion.dataservice.provider/property"), null, "prop_key = ?", new String[]{aethnaVar.a}, null);
        if (query != null) {
            if (query.moveToNext()) {
                query.getString(0);
                android.support.v4.media.session.c.a(aethnaVar.b.get());
            }
            query.close();
        }
    }

    private void a(String str) {
        if (this.d == 1) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("trackObject", str);
            this.a.getContentResolver().insert(Uri.parse("content://com.transsion.dataservice.provider/track"), contentValues);
            return;
        }
        com.transsion.athena.taaneh.aethna.a("Failed to connect to DCS service");
        long j = this.f + 1;
        this.f = j;
        long j2 = 20;
        if (j % j2 == 0 && j / j2 <= 5 && com.transsion.athena.taaneh.anehat.c(this.a)) {
            f();
        }
    }

    private void a(JSONObject jSONObject, String str, Object obj) throws JSONException {
        try {
            jSONObject.getString(str);
        } catch (JSONException unused) {
            jSONObject.put(str, obj);
        }
    }

    private void f() {
        Cursor query = this.a.getContentResolver().query(Uri.parse("content://com.transsion.dataservice.provider/authorize"), null, "pkg = ?", new String[]{com.transsion.athena.taaneh.athena.h(this.a)}, null);
        if (query != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("DCS authorize ");
            sb.append(query.getCount() == 1 ? "enable" : "disable");
            com.transsion.athena.taaneh.aethna.a(sb.toString());
            if (query.getCount() == 1) {
                this.d = 1;
            } else {
                this.d = 2;
            }
            query.close();
        }
    }

    @Override // com.transsion.athena.enatha.athena
    public void a(Message message, long j) {
        Handler handler = this.b;
        if (handler != null) {
            handler.sendMessageDelayed(message, j);
        }
    }

    @Override // com.transsion.athena.enatha.athena
    public void a(Runnable runnable) {
        Handler handler = this.b;
        if (handler != null) {
            handler.post(runnable);
        }
    }

    @Override // com.transsion.athena.enatha.athena
    public void a(Runnable runnable, long j) {
        Handler handler = this.b;
        if (handler != null) {
            handler.postDelayed(runnable, j);
        }
    }

    @Override // com.transsion.athena.enatha.athena
    public void a(String str, TrackData trackData, long j) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("event", str);
            jSONObject.put("tid", j);
            jSONObject.put("type", trackData.d());
            JSONObject a = trackData.a();
            String str2 = ehanat.h;
            a(a, "_apkg", com.transsion.athena.taaneh.athena.h(this.a));
            a(a, "_avn", com.transsion.athena.taaneh.athena.j(this.a));
            a(a, "_avc", Integer.valueOf(com.transsion.athena.taaneh.athena.i(this.a)));
            a(a, "_atutp", Short.valueOf(ehanat.c()));
            String b = ehanat.b();
            if (b == null) {
                b = BuildConfig.FLAVOR;
            }
            a(a, "_atuid", b);
            a(a, "_achannel", ehanat.g());
            a(a, "_ainstallchnl", TextUtils.isEmpty(com.transsion.athena.taaneh.athena.e(this.a)) ? " " : com.transsion.athena.taaneh.athena.e(this.a));
            jSONObject.put("_eparam", a);
        } catch (JSONException e) {
            com.transsion.athena.taaneh.aethna.b(Log.getStackTraceString(e));
        }
        String jSONObject2 = jSONObject.toString();
        int i = this.e;
        if (i < 5000) {
            this.e = i + 1;
            Message obtainMessage = this.b.obtainMessage(302);
            obtainMessage.obj = jSONObject2;
            this.b.sendMessage(obtainMessage);
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        try {
            int i = message.what;
            if (i == 302) {
                this.e--;
                a((String) message.obj);
                return false;
            }
            if (i != 303) {
                if (i == 400) {
                    a(message.arg1, (String) message.obj);
                    return false;
                }
                if (i != 405) {
                    return false;
                }
                a((com.transsion.athena.data.aethna) message.obj);
                return false;
            }
            com.transsion.athena.taaneh.aethna.a.m().r(ehanat.q());
            com.transsion.athena.taaneh.aethna.c("Athena SDK Version is 3.1.1.4");
            com.transsion.athena.taaneh.aethna.c("Athena is in Lite mode");
            if (com.transsion.athena.data.athena.b() == 0) {
                com.transsion.athena.taaneh.anehat.a("HostAppId must be set up in LiteMode");
            }
            f();
            return false;
        } catch (Exception e) {
            com.transsion.athena.taaneh.aethna.b(Log.getStackTraceString(e));
            return false;
        }
    }
}
