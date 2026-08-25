package com.google.firebase.sessions.settings;

import android.util.Log;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.TsExtractor;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", TtmlNode.ANONYMOUS_REGION_ID, "it", "Lorg/json/JSONObject;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.google.firebase.sessions.settings.RemoteSettings$updateSettings$2$1", f = "RemoteSettings.kt", l = {125, 128, 131, 133, TsExtractor.TS_STREAM_TYPE_SPLICE_INFO, 136}, m = "invokeSuspend")
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
final class RemoteSettings$updateSettings$2$1 extends SuspendLambda implements Function2<JSONObject, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ RemoteSettings this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    RemoteSettings$updateSettings$2$1(RemoteSettings remoteSettings, Continuation<? super RemoteSettings$updateSettings$2$1> continuation) {
        super(2, continuation);
        this.this$0 = remoteSettings;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        RemoteSettings$updateSettings$2$1 remoteSettings$updateSettings$2$1 = new RemoteSettings$updateSettings$2$1(this.this$0, continuation);
        remoteSettings$updateSettings$2$1.L$0 = obj;
        return remoteSettings$updateSettings$2$1;
    }

    public final Object invoke(JSONObject jSONObject, Continuation<? super Unit> continuation) {
        return create(jSONObject, continuation).invokeSuspend(Unit.a);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x018e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0151  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00ec  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Ref.ObjectRef objectRef;
        Boolean bool;
        Ref.ObjectRef objectRef2;
        Ref.ObjectRef objectRef3;
        SettingsCache f;
        Ref.ObjectRef objectRef4;
        Ref.ObjectRef objectRef5;
        SettingsCache f2;
        SettingsCache f3;
        Unit unit;
        SettingsCache f4;
        SettingsCache f5;
        SettingsCache f6;
        Long e;
        Object f7 = IntrinsicsKt.f();
        switch (this.label) {
            case 0:
                ResultKt.b(obj);
                JSONObject jSONObject = (JSONObject) this.L$0;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Fetched settings: ");
                sb2.append(jSONObject);
                Ref.ObjectRef objectRef6 = new Ref.ObjectRef();
                objectRef = new Ref.ObjectRef();
                Ref.ObjectRef objectRef7 = new Ref.ObjectRef();
                if (jSONObject.has("app_quality")) {
                    Object obj2 = jSONObject.get("app_quality");
                    Intrinsics.f(obj2, "null cannot be cast to non-null type org.json.JSONObject");
                    JSONObject jSONObject2 = (JSONObject) obj2;
                    try {
                        bool = jSONObject2.has("sessions_enabled") ? (Boolean) jSONObject2.get("sessions_enabled") : null;
                    } catch (JSONException e2) {
                        e = e2;
                        bool = null;
                    }
                    try {
                        if (jSONObject2.has("sampling_rate")) {
                            objectRef6.element = (Double) jSONObject2.get("sampling_rate");
                        }
                        if (jSONObject2.has("session_timeout_seconds")) {
                            objectRef.element = (Integer) jSONObject2.get("session_timeout_seconds");
                        }
                        if (jSONObject2.has("cache_duration")) {
                            objectRef7.element = (Integer) jSONObject2.get("cache_duration");
                        }
                    } catch (JSONException e3) {
                        e = e3;
                        Log.e("SessionConfigFetcher", "Error parsing the configs remotely fetched: ", e);
                        if (bool == null) {
                        }
                    }
                } else {
                    bool = null;
                }
                if (bool == null) {
                    f = this.this$0.f();
                    this.L$0 = objectRef6;
                    this.L$1 = objectRef;
                    this.L$2 = objectRef7;
                    this.label = 1;
                    if (f.n(bool, this) == f7) {
                        return f7;
                    }
                    objectRef4 = objectRef6;
                    objectRef5 = objectRef;
                    objectRef3 = objectRef7;
                    objectRef = objectRef5;
                    objectRef2 = objectRef4;
                    if (((Integer) objectRef.element) != null) {
                        f2 = this.this$0.f();
                        Integer num = (Integer) objectRef.element;
                        this.L$0 = objectRef2;
                        this.L$1 = objectRef3;
                        this.L$2 = null;
                        this.label = 2;
                        if (f2.m(num, this) == f7) {
                            return f7;
                        }
                    }
                    if (((Double) objectRef2.element) != null) {
                        f3 = this.this$0.f();
                        Double d = (Double) objectRef2.element;
                        this.L$0 = objectRef3;
                        this.L$1 = null;
                        this.L$2 = null;
                        this.label = 3;
                        if (f3.i(d, this) == f7) {
                            return f7;
                        }
                    }
                    if (((Integer) objectRef3.element) == null) {
                        unit = null;
                        if (unit == null) {
                        }
                        f6 = this.this$0.f();
                        e = Boxing.e(System.currentTimeMillis());
                        this.L$0 = null;
                        this.L$1 = null;
                        this.L$2 = null;
                        this.label = 6;
                        if (f6.k(e, this) == f7) {
                        }
                        return Unit.a;
                    }
                    f4 = this.this$0.f();
                    Integer num2 = (Integer) objectRef3.element;
                    this.L$0 = null;
                    this.L$1 = null;
                    this.L$2 = null;
                    this.label = 4;
                    if (f4.j(num2, this) == f7) {
                        return f7;
                    }
                    unit = Unit.a;
                    if (unit == null) {
                        f5 = this.this$0.f();
                        Integer d2 = Boxing.d(86400);
                        this.L$0 = null;
                        this.L$1 = null;
                        this.L$2 = null;
                        this.label = 5;
                        if (f5.j(d2, this) == f7) {
                            return f7;
                        }
                    }
                    f6 = this.this$0.f();
                    e = Boxing.e(System.currentTimeMillis());
                    this.L$0 = null;
                    this.L$1 = null;
                    this.L$2 = null;
                    this.label = 6;
                    if (f6.k(e, this) == f7) {
                        return f7;
                    }
                    return Unit.a;
                }
                objectRef2 = objectRef6;
                objectRef3 = objectRef7;
                if (((Integer) objectRef.element) != null) {
                }
                if (((Double) objectRef2.element) != null) {
                }
                if (((Integer) objectRef3.element) == null) {
                }
            case 1:
                objectRef3 = (Ref.ObjectRef) this.L$2;
                objectRef5 = (Ref.ObjectRef) this.L$1;
                objectRef4 = (Ref.ObjectRef) this.L$0;
                ResultKt.b(obj);
                objectRef = objectRef5;
                objectRef2 = objectRef4;
                if (((Integer) objectRef.element) != null) {
                }
                if (((Double) objectRef2.element) != null) {
                }
                if (((Integer) objectRef3.element) == null) {
                }
                break;
            case 2:
                objectRef3 = (Ref.ObjectRef) this.L$1;
                objectRef2 = (Ref.ObjectRef) this.L$0;
                ResultKt.b(obj);
                if (((Double) objectRef2.element) != null) {
                }
                if (((Integer) objectRef3.element) == null) {
                }
                break;
            case 3:
                objectRef3 = (Ref.ObjectRef) this.L$0;
                ResultKt.b(obj);
                if (((Integer) objectRef3.element) == null) {
                }
                break;
            case 4:
                ResultKt.b(obj);
                unit = Unit.a;
                if (unit == null) {
                }
                f6 = this.this$0.f();
                e = Boxing.e(System.currentTimeMillis());
                this.L$0 = null;
                this.L$1 = null;
                this.L$2 = null;
                this.label = 6;
                if (f6.k(e, this) == f7) {
                }
                return Unit.a;
            case 5:
                ResultKt.b(obj);
                f6 = this.this$0.f();
                e = Boxing.e(System.currentTimeMillis());
                this.L$0 = null;
                this.L$1 = null;
                this.L$2 = null;
                this.label = 6;
                if (f6.k(e, this) == f7) {
                }
                return Unit.a;
            case 6:
                ResultKt.b(obj);
                return Unit.a;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
