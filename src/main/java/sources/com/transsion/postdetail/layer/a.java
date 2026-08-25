package com.transsion.postdetail.layer;

import android.view.View;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.moviedetailapi.bean.PostSubjectItem;
import com.transsion.player.orplayer.PlayError;
import com.transsion.player.orplayer.e;
import com.transsion.player.orplayer.f;
import com.transsion.player.ui.ORPlayerView;
import com.transsion.postdetail.layer.listener.LayerFlag;
import com.transsion.postdetail.layer.local.LocalUiType;
import com.transsion.publish.view.ObservableScrollView;
import com.transsion.subtitle.VideoSubtitleControl;
import com.transsion.videofloat.bean.FloatActionType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import wf.a;
import zn.d;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class a {
    private final String a = "LayerManager";
    private final List b = new ArrayList();

    /* renamed from: com.transsion.postdetail.layer.a$a, reason: collision with other inner class name */
    public /* synthetic */ class C0050a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[LayerFlag.values().length];
            try {
                iArr[LayerFlag.SET_PLAYER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[LayerFlag.SET_PARAMS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[LayerFlag.SET_MANAGER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[LayerFlag.INIT_PLAY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[LayerFlag.RENDER_FIRST_FRAME.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[LayerFlag.COMPLETION.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[LayerFlag.VIDEO_SIZE_CHANGED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[LayerFlag.LOADING_BEGIN.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[LayerFlag.LOADING_END.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr[LayerFlag.VIDEO_START.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr[LayerFlag.VIDEO_PAUSE.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr[LayerFlag.PROGRESS.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr[LayerFlag.PLAY_ERROR.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                iArr[LayerFlag.LOOPING_START.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                iArr[LayerFlag.PLAYER_RESET.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                iArr[LayerFlag.INIT_VIEW.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                iArr[LayerFlag.INIT_VIEW_TYPE.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                iArr[LayerFlag.INIT_DATA.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                iArr[LayerFlag.ADD_SURFACE.ordinal()] = 19;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                iArr[LayerFlag.SCREEN_ORIENTATION_CHANGED.ordinal()] = 20;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                iArr[LayerFlag.LOCAL_UI_CHANGED.ordinal()] = 21;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                iArr[LayerFlag.LAYER_EVENT.ordinal()] = 22;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                iArr[LayerFlag.UPDATE_DATA.ordinal()] = 23;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                iArr[LayerFlag.UPDATE_DOWNLOAD_DATA.ordinal()] = 24;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                iArr[LayerFlag.UPDATE_TITLE.ordinal()] = 25;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                iArr[LayerFlag.BACK_PRESSED.ordinal()] = 26;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                iArr[LayerFlag.FRAGMENT_RESUME.ordinal()] = 27;
            } catch (NoSuchFieldError unused27) {
            }
            try {
                iArr[LayerFlag.FRAGMENT_PAUSE.ordinal()] = 28;
            } catch (NoSuchFieldError unused28) {
            }
            try {
                iArr[LayerFlag.FRAGMENT_STOP.ordinal()] = 29;
            } catch (NoSuchFieldError unused29) {
            }
            try {
                iArr[LayerFlag.RELEASE_PLAYER.ordinal()] = 30;
            } catch (NoSuchFieldError unused30) {
            }
            try {
                iArr[LayerFlag.FRAGMENT_DESTROY.ordinal()] = 31;
            } catch (NoSuchFieldError unused31) {
            }
            try {
                iArr[LayerFlag.BOTTOM_CONTROL.ordinal()] = 32;
            } catch (NoSuchFieldError unused32) {
            }
            try {
                iArr[LayerFlag.SUBTITLE_CONTROL.ordinal()] = 33;
            } catch (NoSuchFieldError unused33) {
            }
            try {
                iArr[LayerFlag.DOWNLOAD_PROGRESS.ordinal()] = 34;
            } catch (NoSuchFieldError unused34) {
            }
            try {
                iArr[LayerFlag.DOWNLOAD_SPEED.ordinal()] = 35;
            } catch (NoSuchFieldError unused35) {
            }
            try {
                iArr[LayerFlag.DOWNLOAD_CALLBACK.ordinal()] = 36;
            } catch (NoSuchFieldError unused36) {
            }
            try {
                iArr[LayerFlag.SHOW_TOAST.ordinal()] = 37;
            } catch (NoSuchFieldError unused37) {
            }
            try {
                iArr[LayerFlag.REMOVE_TOAST.ordinal()] = 38;
            } catch (NoSuchFieldError unused38) {
            }
            try {
                iArr[LayerFlag.NETWORK_CHANGE.ordinal()] = 39;
            } catch (NoSuchFieldError unused39) {
            }
            try {
                iArr[LayerFlag.PLAYER_TIMEOUT_TIPS.ordinal()] = 40;
            } catch (NoSuchFieldError unused40) {
            }
            try {
                iArr[LayerFlag.REQUEST_FORYOU.ordinal()] = 41;
            } catch (NoSuchFieldError unused41) {
            }
            try {
                iArr[LayerFlag.SERIES_INIT.ordinal()] = 42;
            } catch (NoSuchFieldError unused42) {
            }
            try {
                iArr[LayerFlag.SERIES_EVENT.ordinal()] = 43;
            } catch (NoSuchFieldError unused43) {
            }
            try {
                iArr[LayerFlag.SERIES_PLAY.ordinal()] = 44;
            } catch (NoSuchFieldError unused44) {
            }
            try {
                iArr[LayerFlag.SERIES_LOCAL2NET.ordinal()] = 45;
            } catch (NoSuchFieldError unused45) {
            }
            try {
                iArr[LayerFlag.UPDATE_SPEED.ordinal()] = 46;
            } catch (NoSuchFieldError unused46) {
            }
            try {
                iArr[LayerFlag.UPDATE_ROTATION.ordinal()] = 47;
            } catch (NoSuchFieldError unused47) {
            }
            try {
                iArr[LayerFlag.SHOW_FLOAT_2_WINDOW.ordinal()] = 48;
            } catch (NoSuchFieldError unused48) {
            }
            try {
                iArr[LayerFlag.INTO_PIP.ordinal()] = 49;
            } catch (NoSuchFieldError unused49) {
            }
            try {
                iArr[LayerFlag.PLAYER_FOREGROUND.ordinal()] = 50;
            } catch (NoSuchFieldError unused50) {
            }
            a = iArr;
        }
    }

    public static final class b implements zn.a {
        final /* synthetic */ LayerFlag b;
        final /* synthetic */ Object[] c;

        b(LayerFlag layerFlag, Object[] objArr) {
            this.b = layerFlag;
            this.c = objArr;
        }

        @Override // zn.a
        public boolean a(Object obj) {
            Intrinsics.h(obj, "data");
            return obj instanceof BaseLayer;
        }

        @Override // zn.a
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void b(BaseLayer baseLayer) {
            Intrinsics.h(baseLayer, "listener");
            a aVar = a.this;
            LayerFlag layerFlag = this.b;
            Object[] objArr = this.c;
            aVar.i(baseLayer, layerFlag, Arrays.copyOf(objArr, objArr.length));
        }
    }

    public static final class c implements zn.a {
        final /* synthetic */ LayerFlag b;
        final /* synthetic */ Object[] c;

        c(LayerFlag layerFlag, Object[] objArr) {
            this.b = layerFlag;
            this.c = objArr;
        }

        @Override // zn.a
        public boolean a(Object obj) {
            Intrinsics.h(obj, "data");
            return obj instanceof e;
        }

        @Override // zn.a
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void b(e eVar) {
            Intrinsics.h(eVar, "listener");
            a aVar = a.this;
            LayerFlag layerFlag = this.b;
            Object[] objArr = this.c;
            aVar.k(eVar, layerFlag, Arrays.copyOf(objArr, objArr.length));
        }
    }

    public static final class d implements zn.a {
        final /* synthetic */ LayerFlag b;
        final /* synthetic */ Object[] c;

        d(LayerFlag layerFlag, Object[] objArr) {
            this.b = layerFlag;
            this.c = objArr;
        }

        @Override // zn.a
        public boolean a(Object obj) {
            Intrinsics.h(obj, "data");
            return obj instanceof zn.d;
        }

        @Override // zn.a
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void b(zn.d dVar) {
            Intrinsics.h(dVar, "listener");
            a aVar = a.this;
            LayerFlag layerFlag = this.b;
            Object[] objArr = this.c;
            aVar.j(dVar, layerFlag, Arrays.copyOf(objArr, objArr.length));
        }
    }

    private final void f(zn.a aVar) {
        if (this.b.isEmpty()) {
            return;
        }
        List list = this.b;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (aVar.a((BaseLayer) obj)) {
                arrayList.add(obj);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            try {
                aVar.b((BaseLayer) it.next());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i(BaseLayer baseLayer, LayerFlag layerFlag, Object... objArr) {
        int i = C0050a.a[layerFlag.ordinal()];
        if (i == 1) {
            if (objArr.length == 2) {
                Object obj = objArr[0];
                Intrinsics.f(obj, "null cannot be cast to non-null type com.transsion.player.orplayer.ORPlayer");
                Object obj2 = objArr[1];
                Intrinsics.f(obj2, "null cannot be cast to non-null type com.transsion.player.ui.ORPlayerView");
                baseLayer.M((f) obj, (ORPlayerView) obj2);
                return;
            }
            return;
        }
        if (i != 2) {
            if (i == 3 && objArr.length == 1) {
                Object obj3 = objArr[0];
                Intrinsics.f(obj3, "null cannot be cast to non-null type com.transsion.postdetail.layer.LayerManager");
                baseLayer.L((a) obj3);
                return;
            }
            return;
        }
        if (objArr.length == 2) {
            Object obj4 = objArr[0];
            Intrinsics.f(obj4, "null cannot be cast to non-null type kotlin.String");
            Object obj5 = objArr[1];
            Intrinsics.f(obj5, "null cannot be cast to non-null type com.transsion.moviedetailapi.bean.PostSubjectItem");
            baseLayer.N((String) obj4, (PostSubjectItem) obj5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j(zn.d dVar, LayerFlag layerFlag, Object... objArr) {
        Object U;
        Object U2;
        Object U3;
        switch (C0050a.a[layerFlag.ordinal()]) {
            case ObservableScrollView.SCROLL_DOWN /* 16 */:
                if (objArr.length == 2) {
                    Object obj = objArr[0];
                    Intrinsics.f(obj, "null cannot be cast to non-null type android.view.View");
                    Object obj2 = objArr[1];
                    Intrinsics.f(obj2, "null cannot be cast to non-null type kotlin.Boolean");
                    dVar.z((View) obj, ((Boolean) obj2).booleanValue());
                    break;
                }
                break;
            case 17:
                if (objArr.length == 2) {
                    Object obj3 = objArr[0];
                    Intrinsics.f(obj3, "null cannot be cast to non-null type android.view.View");
                    Object obj4 = objArr[1];
                    Intrinsics.f(obj4, "null cannot be cast to non-null type com.transsion.postdetail.layer.local.LocalUiType");
                    dVar.s((View) obj3, (LocalUiType) obj4);
                    break;
                }
                break;
            case 18:
                if (objArr.length == 5) {
                    Object obj5 = objArr[0];
                    Intrinsics.f(obj5, "null cannot be cast to non-null type kotlin.String");
                    Object obj6 = objArr[1];
                    Intrinsics.f(obj6, "null cannot be cast to non-null type kotlin.String");
                    Object obj7 = objArr[2];
                    Intrinsics.f(obj7, "null cannot be cast to non-null type kotlin.String");
                    Object obj8 = objArr[3];
                    Intrinsics.f(obj8, "null cannot be cast to non-null type kotlin.Boolean");
                    boolean booleanValue = ((Boolean) obj8).booleanValue();
                    Object obj9 = objArr[4];
                    Intrinsics.f(obj9, "null cannot be cast to non-null type kotlin.Boolean");
                    dVar.q((String) obj5, (String) obj6, (String) obj7, booleanValue, ((Boolean) obj9).booleanValue());
                    break;
                }
                break;
            case 19:
                if (objArr.length == 2) {
                    Object obj10 = objArr[0];
                    Intrinsics.f(obj10, "null cannot be cast to non-null type kotlin.Int");
                    int intValue = ((Integer) obj10).intValue();
                    Object obj11 = objArr[1];
                    Intrinsics.f(obj11, "null cannot be cast to non-null type kotlin.Int");
                    dVar.r(intValue, ((Integer) obj11).intValue());
                    break;
                }
                break;
            case 20:
                if (objArr.length == 1) {
                    Object obj12 = objArr[0];
                    Intrinsics.f(obj12, "null cannot be cast to non-null type com.transsion.postdetail.layer.local.LocalUiType");
                    dVar.m((LocalUiType) obj12);
                    break;
                }
                break;
            case 21:
                if (objArr.length == 1) {
                    Object obj13 = objArr[0];
                    Intrinsics.f(obj13, "null cannot be cast to non-null type com.transsion.postdetail.layer.local.LocalUiType");
                    dVar.a((LocalUiType) obj13);
                    break;
                }
                break;
            case 22:
                if (objArr.length == 1) {
                    Object obj14 = objArr[0];
                    Intrinsics.f(obj14, "null cannot be cast to non-null type com.transsion.postdetail.layer.listener.LayerEvent");
                    dVar.n((zn.b) obj14);
                    break;
                }
                break;
            case 23:
                if (objArr.length == 1) {
                    Object obj15 = objArr[0];
                    Intrinsics.f(obj15, "null cannot be cast to non-null type com.transsion.moviedetailapi.bean.PostSubjectItem");
                    dVar.x((PostSubjectItem) obj15);
                    break;
                }
                break;
            case 24:
                if (objArr.length == 3) {
                    Object obj16 = objArr[0];
                    Intrinsics.f(obj16, "null cannot be cast to non-null type com.transsion.baselib.db.download.DownloadBean");
                    Object obj17 = objArr[1];
                    Intrinsics.f(obj17, "null cannot be cast to non-null type kotlin.String");
                    Object obj18 = objArr[2];
                    Intrinsics.f(obj18, "null cannot be cast to non-null type kotlin.Boolean");
                    dVar.k((DownloadBean) obj16, (String) obj17, ((Boolean) obj18).booleanValue());
                    break;
                }
                break;
            case 25:
                if (objArr.length == 1) {
                    Object obj19 = objArr[0];
                    Intrinsics.f(obj19, "null cannot be cast to non-null type kotlin.String");
                    dVar.updateTitle((String) obj19);
                    break;
                }
                break;
            case 26:
                if (dVar.isVisible()) {
                    dVar.onBackPressed();
                    break;
                }
                break;
            case 27:
                if (dVar.isVisible()) {
                    dVar.onViewResume();
                    break;
                }
                break;
            case 28:
                if (dVar.isVisible()) {
                    dVar.onViewPause();
                    break;
                }
                break;
            case 29:
                if (dVar.isVisible()) {
                    dVar.o();
                    break;
                }
                break;
            case 30:
                if (dVar.isVisible()) {
                    dVar.A();
                    break;
                }
                break;
            case 31:
                dVar.c();
                break;
            case 32:
                if (objArr.length == 2) {
                    Object obj20 = objArr[0];
                    Intrinsics.f(obj20, "null cannot be cast to non-null type kotlin.Boolean");
                    boolean booleanValue2 = ((Boolean) obj20).booleanValue();
                    Object obj21 = objArr[1];
                    Intrinsics.f(obj21, "null cannot be cast to non-null type kotlin.Boolean");
                    dVar.b(booleanValue2, ((Boolean) obj21).booleanValue());
                    break;
                }
                break;
            case 33:
                if (objArr.length == 1) {
                    Object obj22 = objArr[0];
                    Intrinsics.f(obj22, "null cannot be cast to non-null type com.transsion.subtitle.VideoSubtitleControl");
                    dVar.B((VideoSubtitleControl) obj22);
                    break;
                }
                break;
            case 34:
                if (objArr.length == 1) {
                    Object obj23 = objArr[0];
                    Intrinsics.f(obj23, "null cannot be cast to non-null type kotlin.collections.MutableMap<kotlin.Int, kotlin.Int>");
                    dVar.l(TypeIntrinsics.d(obj23));
                    break;
                }
                break;
            case 35:
                if (objArr.length == 1) {
                    Object obj24 = objArr[0];
                    Intrinsics.f(obj24, "null cannot be cast to non-null type kotlin.String");
                    dVar.y((String) obj24);
                    break;
                }
                break;
            case 36:
                if (objArr.length == 1) {
                    Object obj25 = objArr[0];
                    Intrinsics.f(obj25, "null cannot be cast to non-null type com.transsion.baselib.db.download.DownloadBean");
                    dVar.D((DownloadBean) obj25);
                    break;
                }
                break;
            case 37:
                if (objArr.length != 1) {
                    if (objArr.length == 2) {
                        Object obj26 = objArr[0];
                        Intrinsics.f(obj26, "null cannot be cast to non-null type kotlin.String");
                        Object obj27 = objArr[1];
                        Intrinsics.f(obj27, "null cannot be cast to non-null type kotlin.Long");
                        dVar.i((String) obj26, ((Long) obj27).longValue());
                        break;
                    }
                } else {
                    Object obj28 = objArr[0];
                    Intrinsics.f(obj28, "null cannot be cast to non-null type kotlin.String");
                    d.a.l(dVar, (String) obj28, 0L, 2, null);
                    break;
                }
                break;
            case 38:
                dVar.t();
                break;
            case 39:
                if (objArr.length == 1) {
                    Object obj29 = objArr[0];
                    Intrinsics.f(obj29, "null cannot be cast to non-null type kotlin.Boolean");
                    dVar.w(((Boolean) obj29).booleanValue());
                    break;
                }
                break;
            case 40:
                dVar.g();
                break;
            case 41:
                if (objArr.length == 2) {
                    Object obj30 = objArr[0];
                    Intrinsics.f(obj30, "null cannot be cast to non-null type kotlin.Boolean");
                    boolean booleanValue3 = ((Boolean) obj30).booleanValue();
                    Object obj31 = objArr[1];
                    Intrinsics.f(obj31, "null cannot be cast to non-null type kotlin.String");
                    dVar.f(booleanValue3, (String) obj31);
                    break;
                }
                break;
            case 42:
                if (objArr.length == 2) {
                    Object obj32 = objArr[0];
                    Intrinsics.f(obj32, "null cannot be cast to non-null type kotlin.String");
                    Object obj33 = objArr[1];
                    Intrinsics.f(obj33, "null cannot be cast to non-null type kotlin.String");
                    dVar.h((String) obj32, (String) obj33);
                    break;
                }
                break;
            case 43:
                if (objArr.length == 1) {
                    Object obj34 = objArr[0];
                    Intrinsics.f(obj34, "null cannot be cast to non-null type com.transsion.postdetail.layer.listener.SeriesEvent");
                    dVar.E((zn.c) obj34);
                    break;
                }
                break;
            case 44:
                if (dVar.isVisible() && objArr.length == 2) {
                    Object obj35 = objArr[0];
                    Intrinsics.f(obj35, "null cannot be cast to non-null type kotlin.String");
                    Object obj36 = objArr[1];
                    Intrinsics.f(obj36, "null cannot be cast to non-null type kotlin.String");
                    dVar.v((String) obj35, (String) obj36);
                    break;
                }
                break;
            case 45:
                dVar.d();
                break;
            case 46:
                Object U4 = ArraysKt.U(objArr);
                if (U4 != null && (U4 instanceof Float)) {
                    dVar.p(((Number) U4).floatValue());
                    break;
                }
                break;
            case 47:
                Object U5 = ArraysKt.U(objArr);
                if (U5 != null && (U5 instanceof Integer)) {
                    dVar.C(((Number) U5).intValue());
                    break;
                }
                break;
            case 48:
                if (dVar.isVisible() && (U = ArraysKt.U(objArr)) != null && (U instanceof FloatActionType)) {
                    dVar.e((FloatActionType) U);
                    break;
                }
                break;
            case 49:
                if (dVar.isVisible() && (U2 = ArraysKt.U(objArr)) != null && (U2 instanceof Boolean)) {
                    dVar.u(((Boolean) U2).booleanValue());
                    break;
                }
                break;
            case 50:
                if (dVar.isVisible() && (U3 = ArraysKt.U(objArr)) != null && (U3 instanceof Boolean)) {
                    dVar.j(((Boolean) U3).booleanValue());
                    break;
                }
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k(e eVar, LayerFlag layerFlag, Object... objArr) {
        switch (C0050a.a[layerFlag.ordinal()]) {
            case 4:
                eVar.initPlayer();
                break;
            case 5:
                eVar.onRenderFirstFrame();
                break;
            case 6:
                e.a.f(eVar, null, 1, null);
                break;
            case 7:
                if (objArr.length == 2) {
                    Object obj = objArr[0];
                    Intrinsics.f(obj, "null cannot be cast to non-null type kotlin.Int");
                    int intValue = ((Integer) obj).intValue();
                    Object obj2 = objArr[1];
                    Intrinsics.f(obj2, "null cannot be cast to non-null type kotlin.Int");
                    eVar.onVideoSizeChanged(intValue, ((Integer) obj2).intValue());
                    break;
                }
                break;
            case 8:
                e.a.j(eVar, null, 1, null);
                break;
            case 9:
                e.a.l(eVar, null, 1, null);
                break;
            case DownloadBean.STATUS_SERIES /* 10 */:
                e.a.J(eVar, null, 1, null);
                break;
            case DownloadBean.STATUS_TITLE /* 11 */:
                e.a.G(eVar, null, 1, null);
                break;
            case 12:
                if (objArr.length == 1) {
                    Object obj3 = objArr[0];
                    Intrinsics.f(obj3, "null cannot be cast to non-null type kotlin.Long");
                    e.a.z(eVar, ((Long) obj3).longValue(), null, 2, null);
                    break;
                }
                break;
            case 13:
                if (objArr.length == 1) {
                    Object obj4 = objArr[0];
                    Intrinsics.f(obj4, "null cannot be cast to non-null type com.transsion.player.orplayer.PlayError");
                    e.a.r(eVar, (PlayError) obj4, null, 2, null);
                    break;
                }
                break;
            case DownloadBean.STATUS_ALL_EP_BTN /* 14 */:
                eVar.onLoopingStart();
                break;
            case 15:
                eVar.onPlayerReset();
                break;
        }
    }

    public final void d(BaseLayer baseLayer) {
        Intrinsics.h(baseLayer, "layer");
        if (!this.b.contains(baseLayer)) {
            this.b.add(baseLayer);
            return;
        }
        a.a.f(wf.a.a, this.a, baseLayer + " is already add", false, 4, (Object) null);
    }

    public final void e(LayerFlag layerFlag, Object... objArr) {
        Intrinsics.h(layerFlag, "flag");
        Intrinsics.h(objArr, "params");
        f(new b(layerFlag, objArr));
    }

    public final void g(LayerFlag layerFlag, Object... objArr) {
        Intrinsics.h(layerFlag, "flag");
        Intrinsics.h(objArr, "params");
        f(new c(layerFlag, objArr));
    }

    public final void h(LayerFlag layerFlag, Object... objArr) {
        Intrinsics.h(layerFlag, "flag");
        Intrinsics.h(objArr, "params");
        f(new d(layerFlag, objArr));
    }
}
