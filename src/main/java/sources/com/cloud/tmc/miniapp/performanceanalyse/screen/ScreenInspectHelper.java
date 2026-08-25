package com.cloud.tmc.miniapp.performanceanalyse.screen;

import android.os.Bundle;
import com.cloud.tmc.integration.performanceanalyse.screen.IScreenInspectProxy;
import com.cloud.tmc.integration.structure.App;
import com.cloud.tmc.integration.structure.node.PageNode;
import com.cloud.tmc.kernel.bridge.RenderBridge;
import com.cloud.tmc.kernel.bridge.RenderCallContext;
import com.cloud.tmc.kernel.bridge.model.ProtocolData;
import com.cloud.tmc.kernel.constants.TmcConstants;
import com.cloud.tmc.kernel.minicover.NativeComponentConstants;
import com.cloud.tmc.kernel.proxy.TmcProxy;
import com.cloud.tmc.kernel.proxy.eventcenter.IEventCenter;
import com.cloud.tmc.kernel.proxy.eventcenter.IEventCenterFactory;
import com.cloud.tmc.kernel.proxy.eventcenter.IEventSubscriber;
import com.cloud.tmc.kernel.proxy.performanceanalyse.PerformanceAnalyseProxy;
import com.cloud.tmc.kernel.proxy.performanceanalyse.PointAnalyseType;
import com.cloud.tmc.kernel.render.IRender;
import com.cloud.tmc.kernel.utils.TraceLog;
import com.cloud.tmc.kernel.worker.JSI;
import com.cloud.tmc.kernel.worker.SendToWorkerCallback;
import com.cloud.tmc.launcherlib.LauncherMiniAppConfigHelper;
import com.cloud.tmc.miniapp.performanceanalyse.screen.OooOO0;
import com.cloud.tmc.offline.download.constants.OfflineConstantsKt;
import com.cloud.tmc.worker.WorkerCallContext;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.i;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.u0;
import kotlinx.coroutines.y0;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class ScreenInspectHelper implements IScreenInspectProxy {
    public IEventCenter OooO00o;
    public final ConcurrentHashMap<Object, com.cloud.tmc.miniapp.performanceanalyse.screen.OooO00o> OooO0O0 = new ConcurrentHashMap<>();
    public List<Integer> OooO0OO = new ArrayList();
    public long OooO0Oo = 1000;
    public float OooO0o0;

    public final class OooO00o implements OooOO0.OooO00o {
        public final com.cloud.tmc.miniapp.performanceanalyse.screen.OooO00o OooO00o;
        public final com.cloud.tmc.miniapp.performanceanalyse.screen.OooO0O0 OooO0O0;
        public final /* synthetic */ ScreenInspectHelper OooO0OO;

        public OooO00o(ScreenInspectHelper screenInspectHelper, com.cloud.tmc.miniapp.performanceanalyse.screen.OooO00o oooO00o, com.cloud.tmc.miniapp.performanceanalyse.screen.OooO0O0 oooO0O0) {
            Intrinsics.h(oooO00o, "appData");
            Intrinsics.h(oooO0O0, "pageData");
            this.OooO0OO = screenInspectHelper;
            this.OooO00o = oooO00o;
            this.OooO0O0 = oooO0O0;
        }

        @Override // com.cloud.tmc.miniapp.performanceanalyse.screen.OooOO0.OooO00o
        public void OooO00o() {
            com.cloud.tmc.miniapp.performanceanalyse.screen.OooO0O0 oooO0O0 = this.OooO0O0;
            if (oooO0O0.OooO0o0 == 2) {
                oooO0O0.OooO0oO = true;
                ScreenInspectHelper screenInspectHelper = this.OooO0OO;
                String str = this.OooO00o.OooO00o;
                boolean z = oooO0O0.OooO0oo;
                OooOO0 oooOO0 = oooO0O0.OooO0o;
                screenInspectHelper.OooO00o(str, 2, z, oooOO0 != null ? Long.valueOf(oooOO0.OooO00o()) : null);
            }
        }

        @Override // com.cloud.tmc.miniapp.performanceanalyse.screen.OooOO0.OooO00o
        public void OooO0O0() {
            OooOO0 oooOO0;
            com.cloud.tmc.miniapp.performanceanalyse.screen.OooO0O0 oooO0O0 = this.OooO0O0;
            if (oooO0O0.OooO0o0 != 3 || (oooOO0 = oooO0O0.OooO0o) == null) {
                return;
            }
            oooOO0.cancel();
        }

        @Override // com.cloud.tmc.miniapp.performanceanalyse.screen.OooOO0.OooO00o
        public void OooO0OO() {
            com.cloud.tmc.miniapp.performanceanalyse.screen.OooO0O0 oooO0O0 = this.OooO0O0;
            ScreenInspectHelper screenInspectHelper = this.OooO0OO;
            if (oooO0O0.OooO0o0 == 3) {
                OooOO0 oooOO0 = oooO0O0.OooO0o;
                if (oooOO0 != null) {
                    oooOO0.cancel();
                    return;
                }
                return;
            }
            if (oooO0O0.OooO00o != null) {
                int i = oooO0O0.OooO0O0;
                if (i == 0) {
                    oooO0O0.OooO0O0 = 1;
                    ScreenInspectHelper.access$connectRender(screenInspectHelper, this.OooO00o, oooO0O0);
                } else if (i == 1) {
                    IEventCenter iEventCenter = screenInspectHelper.OooO00o;
                    if (iEventCenter != null) {
                        iEventCenter.unregister("connectionRender", oooO0O0.OooO0OO);
                    }
                    ScreenInspectHelper.access$connectRender(screenInspectHelper, this.OooO00o, this.OooO0O0);
                }
            }
            com.cloud.tmc.miniapp.performanceanalyse.screen.OooO00o oooO00o = this.OooO00o;
            ScreenInspectHelper screenInspectHelper2 = this.OooO0OO;
            if (oooO00o.OooO0OO != null) {
                int i2 = oooO00o.OooO0Oo;
                if (i2 == 0) {
                    oooO00o.OooO0Oo = 1;
                    ScreenInspectHelper.access$connectWorker(screenInspectHelper2, oooO00o, this.OooO0O0);
                } else if (i2 == 1) {
                    IEventCenter iEventCenter2 = screenInspectHelper2.OooO00o;
                    if (iEventCenter2 != null) {
                        iEventCenter2.unregister("connectionRender", oooO00o.OooO0o0);
                    }
                    ScreenInspectHelper.access$connectWorker(screenInspectHelper2, this.OooO00o, this.OooO0O0);
                }
            }
            com.cloud.tmc.miniapp.performanceanalyse.screen.OooO0O0 oooO0O02 = this.OooO0O0;
            if (oooO0O02.OooO0O0 == 2 && this.OooO00o.OooO0Oo == 2) {
                ScreenInspectHelper.access$checkWhiteScreen(this.OooO0OO, oooO0O02);
            }
        }
    }

    @DebugMetadata(c = "com.cloud.tmc.miniapp.performanceanalyse.screen.ScreenInspectHelper$checkNow$1", f = "ScreenInspectHelper.kt", l = {321}, m = "invokeSuspend")
    public static final class OooO0O0 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
        public int OooO00o;
        public final /* synthetic */ App OooO0OO;
        public final /* synthetic */ String OooO0Oo;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OooO0O0(App app, String str, Continuation<? super OooO0O0> continuation) {
            super(2, continuation);
            this.OooO0OO = app;
            this.OooO0Oo = str;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ScreenInspectHelper.this.new OooO0O0(this.OooO0OO, this.OooO0Oo, continuation);
        }

        public Object invoke(Object obj, Object obj2) {
            return ScreenInspectHelper.this.new OooO0O0(this.OooO0OO, this.OooO0Oo, (Continuation) obj2).invokeSuspend(Unit.a);
        }

        public final Object invokeSuspend(Object obj) {
            ConcurrentHashMap<String, com.cloud.tmc.miniapp.performanceanalyse.screen.OooO0O0> concurrentHashMap;
            com.cloud.tmc.miniapp.performanceanalyse.screen.OooO0O0 oooO0O0;
            Object f = IntrinsicsKt.f();
            int i = this.OooO00o;
            if (i == 0) {
                ResultKt.b(obj);
                long j = ScreenInspectHelper.this.OooO0Oo > 0 ? ScreenInspectHelper.this.OooO0Oo : 0L;
                this.OooO00o = 1;
                if (u0.a(j, this) == f) {
                    return f;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            }
            com.cloud.tmc.miniapp.performanceanalyse.screen.OooO00o oooO00o = (com.cloud.tmc.miniapp.performanceanalyse.screen.OooO00o) ScreenInspectHelper.this.OooO0O0.get(this.OooO0OO.getAppId());
            if (oooO00o != null && (concurrentHashMap = oooO00o.OooO0O0) != null && (oooO0O0 = concurrentHashMap.get(this.OooO0Oo)) != null) {
                ScreenInspectHelper screenInspectHelper = ScreenInspectHelper.this;
                if (oooO0O0.OooO0oO) {
                    return Unit.a;
                }
                ScreenInspectHelper.access$checkWhiteScreen(screenInspectHelper, oooO0O0);
            }
            return Unit.a;
        }
    }

    public static final void access$checkWhiteScreen(ScreenInspectHelper screenInspectHelper, com.cloud.tmc.miniapp.performanceanalyse.screen.OooO0O0 oooO0O0) {
        IEventCenter iEventCenter;
        screenInspectHelper.getClass();
        int i = oooO0O0.OooO0o0;
        if (i == 3) {
            return;
        }
        if (i == 0 || i == 2) {
            oooO0O0.OooO0o0 = 1;
        } else if (i == 1 && (iEventCenter = screenInspectHelper.OooO00o) != null) {
            iEventCenter.unregister("renderStatus", oooO0O0.OooO0Oo);
        }
        IRender iRender = oooO0O0.OooO00o;
        OooO0OO oooO0OO = new OooO0OO(screenInspectHelper, oooO0O0, iRender != null ? iRender.getAppId() : null);
        oooO0O0.OooO0Oo = oooO0OO;
        IEventCenter iEventCenter2 = screenInspectHelper.OooO00o;
        if (iEventCenter2 != null) {
            iEventCenter2.register("renderStatus", oooO0OO);
        }
        IRender iRender2 = oooO0O0.OooO00o;
        if (iRender2 != null) {
            JsonObject jsonObject = new JsonObject();
            JsonObject jsonObject2 = new JsonObject();
            jsonObject.addProperty("abilityName", WorkerCallContext.ABILITY_DISPATCHEVENT);
            jsonObject.addProperty("callbackId", Long.valueOf(System.currentTimeMillis()));
            jsonObject2.addProperty("eventName", "checkWhiteScreen");
            jsonObject2.addProperty(NativeComponentConstants.KEY_COMPONENT_DATA_JSON, LauncherMiniAppConfigHelper.DEFATULT_TEST);
            jsonObject.add(NativeComponentConstants.KEY_COMPONENT_DATA_JSON, jsonObject2);
            RenderCallContext.Builder param = RenderCallContext.newBuilder(iRender2).action("message").type(RenderCallContext.TYPE_CALL).param(jsonObject);
            RenderBridge renderBridge = iRender2.getRenderBridge();
            if (renderBridge != null) {
                renderBridge.sendToRender(param.build(), null);
            }
        }
    }

    public static final void access$connectRender(ScreenInspectHelper screenInspectHelper, com.cloud.tmc.miniapp.performanceanalyse.screen.OooO00o oooO00o, com.cloud.tmc.miniapp.performanceanalyse.screen.OooO0O0 oooO0O0) {
        screenInspectHelper.getClass();
        OooO0o oooO0o = new OooO0o(oooO0O0, screenInspectHelper, oooO00o);
        oooO0O0.OooO0OO = oooO0o;
        IEventCenter iEventCenter = screenInspectHelper.OooO00o;
        if (iEventCenter != null) {
            iEventCenter.register("connectionRender", oooO0o);
        }
        IRender iRender = oooO0O0.OooO00o;
        if (iRender != null) {
            JsonObject jsonObject = new JsonObject();
            JsonObject jsonObject2 = new JsonObject();
            jsonObject.addProperty("abilityName", WorkerCallContext.ABILITY_DISPATCHEVENT);
            jsonObject.addProperty("callbackId", Long.valueOf(System.currentTimeMillis()));
            jsonObject2.addProperty("eventName", "connection");
            jsonObject2.addProperty(NativeComponentConstants.KEY_COMPONENT_DATA_JSON, LauncherMiniAppConfigHelper.DEFATULT_TEST);
            jsonObject.add(NativeComponentConstants.KEY_COMPONENT_DATA_JSON, jsonObject2);
            RenderCallContext.Builder param = RenderCallContext.newBuilder(iRender).action("message").type(RenderCallContext.TYPE_CALL).param(jsonObject);
            RenderBridge renderBridge = iRender.getRenderBridge();
            if (renderBridge != null) {
                renderBridge.sendToRender(param.build(), null);
            }
        }
    }

    public static final void access$connectWorker(ScreenInspectHelper screenInspectHelper, com.cloud.tmc.miniapp.performanceanalyse.screen.OooO00o oooO00o, com.cloud.tmc.miniapp.performanceanalyse.screen.OooO0O0 oooO0O0) {
        screenInspectHelper.getClass();
        OooO oooO = new OooO(oooO00o, screenInspectHelper, oooO0O0);
        oooO00o.OooO0o0 = oooO;
        IEventCenter iEventCenter = screenInspectHelper.OooO00o;
        if (iEventCenter != null) {
            iEventCenter.register("connectionWorker", oooO);
        }
        JSI jsi = oooO00o.OooO0OO;
        if (jsi != null) {
            HashMap<String, Object> hashMap = new HashMap<>();
            HashMap hashMap2 = new HashMap();
            JsonObject jsonObject = new JsonObject();
            hashMap2.put("eventName", "connection");
            jsonObject.addProperty("eventName", "connection");
            hashMap2.put(NativeComponentConstants.KEY_COMPONENT_DATA_JSON, LauncherMiniAppConfigHelper.DEFATULT_TEST);
            jsonObject.addProperty(NativeComponentConstants.KEY_COMPONENT_DATA_JSON, LauncherMiniAppConfigHelper.DEFATULT_TEST);
            hashMap.put("abilityName", WorkerCallContext.ABILITY_DISPATCHEVENT);
            hashMap.put(TmcConstants.EXTRA_SHARE_TARGET, "worker");
            hashMap.put("source", "native");
            hashMap.put("time", Long.valueOf(System.currentTimeMillis()));
            hashMap.put("callbackId", "");
            hashMap.put(NativeComponentConstants.KEY_COMPONENT_DATA_JSON, hashMap2);
            JsonObject asJsonObject = JsonParser.parseString(new Gson().toJson(new ProtocolData(WorkerCallContext.ABILITY_DISPATCHEVENT, "worker", "native", System.currentTimeMillis(), "", jsonObject))).getAsJsonObject();
            if (jsi.workerType() == 1) {
                jsi.sendJsonToWorker(hashMap, (SendToWorkerCallback) null);
            } else if (jsi.workerType() == 3) {
                jsi.sendJsonToWorker(asJsonObject, (SendToWorkerCallback) null);
            }
        }
    }

    public final void OooO00o(com.cloud.tmc.miniapp.performanceanalyse.screen.OooO0O0 oooO0O0) {
        IEventCenter iEventCenter;
        IEventCenter iEventCenter2;
        if (oooO0O0 != null) {
            oooO0O0.OooO00o = null;
            IEventSubscriber iEventSubscriber = oooO0O0.OooO0OO;
            if (iEventSubscriber != null && (iEventCenter2 = this.OooO00o) != null) {
                iEventCenter2.unregister("connectionRender", iEventSubscriber);
            }
            oooO0O0.OooO0OO = null;
            IEventSubscriber iEventSubscriber2 = oooO0O0.OooO0Oo;
            if (iEventSubscriber2 != null && (iEventCenter = this.OooO00o) != null) {
                iEventCenter.unregister("renderStatus", iEventSubscriber2);
            }
            oooO0O0.OooO0Oo = null;
            OooOO0 oooOO0 = oooO0O0.OooO0o;
            if (oooOO0 != null) {
                oooOO0.cancel();
            }
            oooO0O0.OooO0o = null;
        }
    }

    public final void OooO00o(String str, int i, boolean z, Long l) {
        Bundle bundle = new Bundle();
        bundle.putString("white_screen_onPageReady", String.valueOf(z));
        bundle.putString("white_screen", String.valueOf(i));
        bundle.putString("white_screen_stepMillis", String.valueOf(l));
        ((PerformanceAnalyseProxy) TmcProxy.get(PerformanceAnalyseProxy.class)).record(str, PointAnalyseType.POINT_CHECK_WHITESCREEN, "", bundle);
    }

    public void appDestroy(App app) {
        String appId = app != null ? app.getAppId() : null;
        if (appId == null || appId.length() == 0) {
            return;
        }
        com.cloud.tmc.miniapp.performanceanalyse.screen.OooO00o oooO00o = this.OooO0O0.get(appId);
        if (oooO00o != null) {
            oooO00o.OooO0OO = null;
            IEventCenter iEventCenter = this.OooO00o;
            if (iEventCenter != null) {
                iEventCenter.unregister("connectionWorker", oooO00o.OooO0o0);
            }
            oooO00o.OooO0o0 = null;
            Enumeration<String> keys = oooO00o.OooO0O0.keys();
            Intrinsics.g(keys, "pages.keys()");
            Iterator y = CollectionsKt.y(keys);
            while (y.hasNext()) {
                destroy(app, (String) y.next());
            }
            oooO00o.OooO0O0.clear();
        }
        this.OooO0O0.remove(appId);
    }

    public void checkNow(App app, String str) {
        ConcurrentHashMap<String, com.cloud.tmc.miniapp.performanceanalyse.screen.OooO0O0> concurrentHashMap;
        Intrinsics.h(app, OfflineConstantsKt.OFFLINE_DOWNLOAD_CHANNEL_MODE_APP);
        Intrinsics.h(str, "pageUrl");
        com.cloud.tmc.miniapp.performanceanalyse.screen.OooO00o oooO00o = this.OooO0O0.get(app.getAppId());
        com.cloud.tmc.miniapp.performanceanalyse.screen.OooO0O0 oooO0O0 = (oooO00o == null || (concurrentHashMap = oooO00o.OooO0O0) == null) ? null : concurrentHashMap.get(str);
        if (oooO0O0 != null) {
            oooO0O0.OooO0oo = true;
        }
        i.d(o0.a(y0.a()), (CoroutineContext) null, (CoroutineStart) null, new OooO0O0(app, str, null), 3, (Object) null);
    }

    public void destroy(App app, String str) {
        com.cloud.tmc.miniapp.performanceanalyse.screen.OooO00o oooO00o;
        ConcurrentHashMap<String, com.cloud.tmc.miniapp.performanceanalyse.screen.OooO0O0> concurrentHashMap;
        com.cloud.tmc.miniapp.performanceanalyse.screen.OooO0O0 oooO0O0;
        String appId = app != null ? app.getAppId() : null;
        if (appId == null || appId.length() == 0 || str == null || str.length() == 0 || (oooO00o = this.OooO0O0.get(appId)) == null || (concurrentHashMap = oooO00o.OooO0O0) == null || (oooO0O0 = concurrentHashMap.get(str)) == null) {
            return;
        }
        if (!oooO0O0.OooO0oO) {
            oooO0O0.OooO0oO = true;
            boolean z = oooO0O0.OooO0oo;
            OooOO0 oooOO0 = oooO0O0.OooO0o;
            OooO00o(appId, 1, z, oooOO0 != null ? Long.valueOf(oooOO0.OooO00o()) : null);
        }
        OooO00o(oooO0O0);
    }

    public void initConfig(float f, Long l, int[] iArr) {
        if (iArr != null) {
            this.OooO0OO.clear();
            this.OooO0OO.addAll(ArraysKt.f(iArr));
        }
        if (l != null) {
            this.OooO0Oo = l.longValue();
        }
        this.OooO0o0 = f;
    }

    public void registerRender(IRender iRender) {
        ConcurrentHashMap<String, com.cloud.tmc.miniapp.performanceanalyse.screen.OooO0O0> concurrentHashMap;
        Intrinsics.h(iRender, "render");
        if (!this.OooO0O0.containsKey(iRender.getAppId())) {
            TraceLog.i(OfflineConstantsKt.OFFLINE_TYPE_MINIAPP, "注册页面:" + iRender.getCurrentUri() + "的应用(" + iRender.getAppId() + ")不存在");
            return;
        }
        com.cloud.tmc.miniapp.performanceanalyse.screen.OooO00o oooO00o = this.OooO0O0.get(iRender.getAppId());
        if (oooO00o == null || (concurrentHashMap = oooO00o.OooO0O0) == null) {
            return;
        }
        PageNode page = iRender.getPage();
        PageNode pageNode = page instanceof PageNode ? page : null;
        com.cloud.tmc.miniapp.performanceanalyse.screen.OooO0O0 oooO0O0 = concurrentHashMap.get(pageNode != null ? pageNode.getPagePath() : null);
        if (oooO0O0 != null) {
            oooO0O0.OooO00o = iRender;
            oooO0O0.OooO0O0 = 0;
            oooO0O0.OooO0o0 = 0;
        }
    }

    public void registerWorker(App app, JSI jsi) {
        Intrinsics.h(jsi, "worker");
        String appId = app != null ? app.getAppId() : null;
        if (appId != null && appId.length() > 0 && this.OooO0O0.containsKey(appId)) {
            com.cloud.tmc.miniapp.performanceanalyse.screen.OooO00o oooO00o = this.OooO0O0.get(appId);
            if (oooO00o != null) {
                oooO00o.OooO0OO = jsi;
                oooO00o.OooO0Oo = 0;
                return;
            }
            return;
        }
        TraceLog.i(OfflineConstantsKt.OFFLINE_TYPE_MINIAPP, "注册worker id:" + jsi.getWorkerId() + "的应用(" + appId + ")不存在");
    }

    public void start(App app, String str) {
        long j;
        ConcurrentHashMap<String, com.cloud.tmc.miniapp.performanceanalyse.screen.OooO0O0> concurrentHashMap;
        com.cloud.tmc.miniapp.performanceanalyse.screen.OooO0O0 oooO0O0 = null;
        String appId = app != null ? app.getAppId() : null;
        double nextDouble = new SecureRandom().nextDouble();
        float f = this.OooO0o0;
        boolean z = f != 0.0f && nextDouble <= ((double) f);
        if (appId == null || appId.length() == 0 || str == null || str.length() == 0 || !z) {
            return;
        }
        this.OooO00o = ((IEventCenterFactory) TmcProxy.get(IEventCenterFactory.class)).getEventCenterInstance(app);
        if (this.OooO0O0.containsKey(appId)) {
            com.cloud.tmc.miniapp.performanceanalyse.screen.OooO00o oooO00o = this.OooO0O0.get(appId);
            if (oooO00o != null && (concurrentHashMap = oooO00o.OooO0O0) != null) {
                oooO0O0 = concurrentHashMap.get(str);
            }
            OooO00o(oooO0O0);
        } else {
            this.OooO0O0.put(appId, new com.cloud.tmc.miniapp.performanceanalyse.screen.OooO00o(appId, new ConcurrentHashMap(), null, 0, null));
        }
        if (this.OooO0OO.size() > 0) {
            List<Integer> list = this.OooO0OO;
            j = list.get(list.size() - 1).longValue() * 1000;
        } else {
            j = 0;
        }
        long j2 = (j >= 0 ? j : 0L) + 1000;
        com.cloud.tmc.miniapp.performanceanalyse.screen.OooO00o oooO00o2 = this.OooO0O0.get(appId);
        if (oooO00o2 != null) {
            ConcurrentHashMap<String, com.cloud.tmc.miniapp.performanceanalyse.screen.OooO0O0> concurrentHashMap2 = oooO00o2.OooO0O0;
            com.cloud.tmc.miniapp.performanceanalyse.screen.OooO0O0 oooO0O02 = new com.cloud.tmc.miniapp.performanceanalyse.screen.OooO0O0(null, 0, null, null, 0, null, false, false, 255);
            OooOO0 oooOO0 = new OooOO0(j2, 1000L, this.OooO0OO, new OooO00o(this, oooO00o2, oooO0O02));
            oooOO0.start();
            oooO0O02.OooO0o = oooOO0;
            Unit unit = Unit.a;
            concurrentHashMap2.put(str, oooO0O02);
        }
    }
}
