package com.transsion.search_pugc.speech;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.speech.RecognitionListener;
import android.speech.SpeechRecognizer;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.lifecycle.v;
import com.blankj.utilcode.util.Utils;
import com.transsion.baseui.R$style;
import com.transsion.baseui.dialog.BaseDialog;
import com.transsion.gslb.BuildConfig;
import com.transsion.search.R$layout;
import com.transsion.search.R$string;
import com.transsion.search_pugc.speech.SpeechRecognizerVolumeCircleView;
import com.transsion.wrapperad.R;
import java.util.ArrayList;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;

@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\u0003J\u000f\u0010\n\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\n\u0010\u0003J\u000f\u0010\u000b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000b\u0010\u0003J!\u0010\u0010\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0019\u0010\u0013\u001a\u00020\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\fH\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0015\u0010\u0003J\u000f\u0010\u0017\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0019\u0010\u001b\u001a\u00020\u00062\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ!\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u001d2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0016¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00020\u0006H\u0016¢\u0006\u0004\b!\u0010\u0003J\u0017\u0010$\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\"H\u0016¢\u0006\u0004\b$\u0010%J8\u0010*\u001a\u00020\u00002)\b\u0002\u0010)\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\f¢\u0006\f\b'\u0012\b\b(\u0012\u0004\b\b(\r\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010&¢\u0006\u0004\b*\u0010+R\u0018\u0010/\u001a\u0004\u0018\u00010,8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010.R\u0018\u00102\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u00101R\u0018\u00106\u001a\u0004\u0018\u0001038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u00105R7\u00109\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\f¢\u0006\f\b'\u0012\b\b(\u0012\u0004\b\b(\r\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b7\u00108R\u0018\u0010=\u001a\u0004\u0018\u00010:8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b;\u0010<R\u0016\u0010@\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b>\u0010?R\u0014\u0010D\u001a\u00020A8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bB\u0010CR\u001a\u0010J\u001a\u00020E8\u0016X\u0096\u0004¢\u0006\f\n\u0004\bF\u0010G\u001a\u0004\bH\u0010I¨\u0006K"}, d2 = {"Lcom/transsion/search_pugc/speech/SpeechRecognizerDialog;", "Lcom/transsion/baseui/dialog/BaseDialog;", "<init>", "()V", BuildConfig.FLAVOR, "timeout", BuildConfig.FLAVOR, "M0", "(J)V", "H0", "initView", "J0", BuildConfig.FLAVOR, "result", BuildConfig.FLAVOR, "isComplete", "P0", "(Ljava/lang/String;Z)V", "resultStr", "F0", "(Ljava/lang/String;)V", "D0", BuildConfig.FLAVOR, "C0", "()I", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onPause", "Landroid/content/DialogInterface;", "dialog", "onDismiss", "(Landroid/content/DialogInterface;)V", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "callback", "I0", "(Lkotlin/jvm/functions/Function1;)Lcom/transsion/search_pugc/speech/SpeechRecognizerDialog;", "Lcom/transsion/search_pugc/speech/c;", "c", "Lcom/transsion/search_pugc/speech/c;", "initializeStrategy", "d", "Ljava/lang/String;", "mPartialResults", "Lvp/b;", "e", "Lvp/b;", "bind", "f", "Lkotlin/jvm/functions/Function1;", "mCallback", "Landroid/speech/SpeechRecognizer;", "g", "Landroid/speech/SpeechRecognizer;", "mSpeechRecognizer", "h", "Z", "isWorking", "Landroid/os/Handler;", "i", "Landroid/os/Handler;", "mHandler", "Lqi/b;", "j", "Lqi/b;", "getLogViewConfig", "()Lqi/b;", "logViewConfig", "Search_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class SpeechRecognizerDialog extends BaseDialog {

    /* renamed from: c, reason: from kotlin metadata */
    private c initializeStrategy;

    /* renamed from: d, reason: from kotlin metadata */
    private String mPartialResults;

    /* renamed from: e, reason: from kotlin metadata */
    private vp.b bind;

    /* renamed from: f, reason: from kotlin metadata */
    private Function1 mCallback;

    /* renamed from: g, reason: from kotlin metadata */
    private SpeechRecognizer mSpeechRecognizer;

    /* renamed from: h, reason: from kotlin metadata */
    private boolean isWorking;

    /* renamed from: i, reason: from kotlin metadata */
    private final Handler mHandler;

    /* renamed from: j, reason: from kotlin metadata */
    private final qi.b logViewConfig;

    public static final class a implements RecognitionListener {
        a() {
        }

        @Override // android.speech.RecognitionListener
        public void onBeginningOfSpeech() {
            f.a.a(SpeechRecognizerDialog.this.getClassTag() + " --> onBeginningOfSpeech() --> 当开始说话时调用");
        }

        @Override // android.speech.RecognitionListener
        public void onBufferReceived(byte[] bArr) {
            f.a.a(SpeechRecognizerDialog.this.getClassTag() + " --> onBufferReceived() --> 当接收到音频数据时调用");
        }

        @Override // android.speech.RecognitionListener
        public void onEndOfSpeech() {
            f.a.a(SpeechRecognizerDialog.this.getClassTag() + " --> onEndOfSpeech() --> 当说话结束时调用");
        }

        @Override // android.speech.RecognitionListener
        public void onError(int i) {
            AppCompatTextView appCompatTextView;
            SpeechRecognizerVolumeCircleView speechRecognizerVolumeCircleView;
            if (!TextUtils.isEmpty(SpeechRecognizerDialog.this.mPartialResults)) {
                SpeechRecognizerDialog speechRecognizerDialog = SpeechRecognizerDialog.this;
                speechRecognizerDialog.F0(speechRecognizerDialog.mPartialResults);
                return;
            }
            SpeechRecognizerDialog.this.H0();
            e eVar = e.a;
            String a = eVar.a(i);
            f.a.a(SpeechRecognizerDialog.this.getClassTag() + " --> onError() --> 当发生错误时调用 --> error = " + i + " -- msg = " + a);
            SpeechRecognizerDialog.this.P0(a, true);
            if (SpeechRecognizerDialog.this.isWorking) {
                q.a.c(eVar.a(16), 16);
            } else {
                q.a.c(a, i);
            }
            vp.b bVar = SpeechRecognizerDialog.this.bind;
            if (bVar != null && (speechRecognizerVolumeCircleView = bVar.g) != null) {
                speechRecognizerVolumeCircleView.setMicState(SpeechRecognizerVolumeCircleView.MicState.NORMAL);
            }
            vp.b bVar2 = SpeechRecognizerDialog.this.bind;
            if (bVar2 == null || (appCompatTextView = bVar2.e) == null) {
                return;
            }
            appCompatTextView.setText(Utils.a().getResources().getString(R$string.search_sr_tap_microphone_try_again));
        }

        @Override // android.speech.RecognitionListener
        public void onEvent(int i, Bundle bundle) {
            f.a.a(SpeechRecognizerDialog.this.getClassTag() + " --> onEvent() --> 当发生其他事件时调用 --> eventType = " + i + " --> params = " + bundle);
        }

        @Override // android.speech.RecognitionListener
        public void onPartialResults(Bundle bundle) {
            ArrayList<String> stringArrayList;
            if (bundle == null || (stringArrayList = bundle.getStringArrayList("results_recognition")) == null) {
                return;
            }
            SpeechRecognizerDialog speechRecognizerDialog = SpeechRecognizerDialog.this;
            if (!stringArrayList.isEmpty()) {
                speechRecognizerDialog.mPartialResults = stringArrayList.get(0);
                String str = stringArrayList.get(0);
                Intrinsics.g(str, "get(...)");
                SpeechRecognizerDialog.Q0(speechRecognizerDialog, str, false, 2, null);
            }
            SpeechRecognizerDialog.N0(speechRecognizerDialog, 0L, 1, null);
        }

        @Override // android.speech.RecognitionListener
        public void onReadyForSpeech(Bundle bundle) {
            f.a.a(SpeechRecognizerDialog.this.getClassTag() + " --> onReadyForSpeech() --> 当语音识别准备好时调用 --> params = " + bundle);
            q.a.d();
            c cVar = SpeechRecognizerDialog.this.initializeStrategy;
            if (cVar != null) {
                cVar.i();
            }
        }

        @Override // android.speech.RecognitionListener
        public void onResults(Bundle bundle) {
            ArrayList<String> stringArrayList;
            if (bundle == null || (stringArrayList = bundle.getStringArrayList("results_recognition")) == null) {
                return;
            }
            SpeechRecognizerDialog speechRecognizerDialog = SpeechRecognizerDialog.this;
            if (stringArrayList.isEmpty()) {
                return;
            }
            String str = stringArrayList.get(0);
            Intrinsics.e(str);
            SpeechRecognizerDialog.Q0(speechRecognizerDialog, str, false, 2, null);
            f.a.a(speechRecognizerDialog.getClassTag() + " --> onResults() --> 当获得语音识别结果时调用 = " + str);
            speechRecognizerDialog.F0(str);
        }

        @Override // android.speech.RecognitionListener
        public void onRmsChanged(float f) {
        }
    }

    public SpeechRecognizerDialog() {
        super(R$layout.dialog_speech_recognizer_layout);
        this.mPartialResults = BuildConfig.FLAVOR;
        this.mHandler = new Handler(Looper.getMainLooper());
        this.logViewConfig = new qi.b("sr_dialog", false, 2, null);
    }

    private final int C0() {
        int i = Utils.a().getResources().getDisplayMetrics().heightPixels;
        return i - (i / 3);
    }

    private final void D0() {
        final SpeechRecognizerVolumeCircleView speechRecognizerVolumeCircleView;
        Unit unit;
        try {
            Result.Companion companion = Result.Companion;
            SpeechRecognizer speechRecognizer = this.mSpeechRecognizer;
            if (speechRecognizer != null) {
                speechRecognizer.cancel();
            }
            SpeechRecognizer speechRecognizer2 = this.mSpeechRecognizer;
            if (speechRecognizer2 != null) {
                speechRecognizer2.destroy();
                unit = Unit.a;
            } else {
                unit = null;
            }
            Result.constructor-impl(unit);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            Result.constructor-impl(ResultKt.a(th2));
        }
        c cVar = this.initializeStrategy;
        SpeechRecognizer e = cVar != null ? cVar.e(getContext()) : null;
        this.mSpeechRecognizer = e;
        if (e != null) {
            e.setRecognitionListener(new a());
        }
        vp.b bVar = this.bind;
        if (bVar == null || (speechRecognizerVolumeCircleView = bVar.g) == null) {
            return;
        }
        speechRecognizerVolumeCircleView.post(new Runnable() { // from class: com.transsion.search_pugc.speech.k
            @Override // java.lang.Runnable
            public final void run() {
                SpeechRecognizerDialog.E0(SpeechRecognizerDialog.this, speechRecognizerVolumeCircleView);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E0(SpeechRecognizerDialog speechRecognizerDialog, SpeechRecognizerVolumeCircleView speechRecognizerVolumeCircleView) {
        c cVar = speechRecognizerDialog.initializeStrategy;
        if (cVar != null) {
            cVar.k();
        }
        speechRecognizerVolumeCircleView.performClick();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void F0(String resultStr) {
        q.a.e();
        kotlinx.coroutines.i.d(v.a(this), (CoroutineContext) null, (CoroutineStart) null, new SpeechRecognizerDialog$onResult$1(this, resultStr, null), 3, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit G0(SpeechRecognizerDialog speechRecognizerDialog) {
        speechRecognizerDialog.isWorking = false;
        f.a.a(speechRecognizerDialog.getClassTag() + " --> onViewCreated() --> setCallback{} --> 重新获取语音识别对象 --> initSpeechRecognizer()");
        speechRecognizerDialog.D0();
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void H0() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    private final void J0() {
        SpeechRecognizerVolumeCircleView speechRecognizerVolumeCircleView;
        AppCompatImageView appCompatImageView;
        vp.b bVar = this.bind;
        if (bVar != null && (appCompatImageView = bVar.b) != null) {
            appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.search_pugc.speech.i
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SpeechRecognizerDialog.K0(SpeechRecognizerDialog.this, view);
                }
            });
        }
        vp.b bVar2 = this.bind;
        if (bVar2 == null || (speechRecognizerVolumeCircleView = bVar2.g) == null) {
            return;
        }
        speechRecognizerVolumeCircleView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.search_pugc.speech.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SpeechRecognizerDialog.L0(SpeechRecognizerDialog.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K0(SpeechRecognizerDialog speechRecognizerDialog, View view) {
        q.a.a();
        speechRecognizerDialog.dismissAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L0(SpeechRecognizerDialog speechRecognizerDialog, View view) {
        Unit unit;
        if (speechRecognizerDialog.isWorking) {
            SpeechRecognizer speechRecognizer = speechRecognizerDialog.mSpeechRecognizer;
            if (speechRecognizer != null) {
                speechRecognizer.stopListening();
            }
            speechRecognizerDialog.H0();
        } else {
            Intent intent = new Intent("android.speech.action.RECOGNIZE_SPEECH");
            intent.putExtra("android.speech.extra.LANGUAGE_MODEL", "free_form");
            intent.putExtra("android.speech.extra.LANGUAGE", Locale.getDefault().toLanguageTag());
            intent.putExtra("android.speech.extra.PARTIAL_RESULTS", true);
            try {
                Result.Companion companion = Result.Companion;
                SpeechRecognizer speechRecognizer2 = speechRecognizerDialog.mSpeechRecognizer;
                if (speechRecognizer2 != null) {
                    speechRecognizer2.startListening(intent);
                    unit = Unit.a;
                } else {
                    unit = null;
                }
                Result.constructor-impl(unit);
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.Companion;
                Result.constructor-impl(ResultKt.a(th2));
            }
            N0(speechRecognizerDialog, 0L, 1, null);
            speechRecognizerDialog.initView();
        }
        speechRecognizerDialog.isWorking = !speechRecognizerDialog.isWorking;
    }

    private final void M0(long timeout) {
        H0();
        this.mHandler.postDelayed(new Runnable() { // from class: com.transsion.search_pugc.speech.l
            @Override // java.lang.Runnable
            public final void run() {
                SpeechRecognizerDialog.O0(SpeechRecognizerDialog.this);
            }
        }, timeout);
    }

    static /* synthetic */ void N0(SpeechRecognizerDialog speechRecognizerDialog, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            j = 5000;
        }
        speechRecognizerDialog.M0(j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O0(SpeechRecognizerDialog speechRecognizerDialog) {
        SpeechRecognizer speechRecognizer = speechRecognizerDialog.mSpeechRecognizer;
        if (speechRecognizer != null) {
            speechRecognizer.stopListening();
        }
        f.a.a(speechRecognizerDialog.getClassTag() + " --> setSpeechTimeout() --> 语音识别超时");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void P0(String result, boolean isComplete) {
        vp.b bVar;
        AppCompatTextView appCompatTextView;
        if (isComplete) {
            this.isWorking = false;
        }
        if (TextUtils.isEmpty(result) || (bVar = this.bind) == null || (appCompatTextView = bVar.d) == null) {
            return;
        }
        appCompatTextView.setText(result);
    }

    static /* synthetic */ void Q0(SpeechRecognizerDialog speechRecognizerDialog, String str, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        speechRecognizerDialog.P0(str, z);
    }

    private final void initView() {
        SpeechRecognizerVolumeCircleView speechRecognizerVolumeCircleView;
        SpeechRecognizerVolumeCircleView speechRecognizerVolumeCircleView2;
        AppCompatTextView appCompatTextView;
        SpeechRecognizerVolumeCircleView speechRecognizerVolumeCircleView3;
        String string = Utils.a().getResources().getString(R$string.search_sr_speak_now);
        Intrinsics.g(string, "getString(...)");
        P0(string, false);
        vp.b bVar = this.bind;
        if (bVar != null && (speechRecognizerVolumeCircleView3 = bVar.g) != null) {
            speechRecognizerVolumeCircleView3.setMicState(SpeechRecognizerVolumeCircleView.MicState.ACTIVE);
        }
        vp.b bVar2 = this.bind;
        if (bVar2 != null && (appCompatTextView = bVar2.e) != null) {
            appCompatTextView.setText(Utils.a().getResources().getString(R$string.search_sr_tap_try_tip_avatar));
        }
        vp.b bVar3 = this.bind;
        if (bVar3 != null && (speechRecognizerVolumeCircleView2 = bVar3.g) != null) {
            speechRecognizerVolumeCircleView2.setActiveCircleColor(Utils.a().getResources().getColor(R.color.white_40));
        }
        vp.b bVar4 = this.bind;
        if (bVar4 == null || (speechRecognizerVolumeCircleView = bVar4.g) == null) {
            return;
        }
        speechRecognizerVolumeCircleView.setLoadingGradientColors(new int[]{Color.parseColor("#2166E5"), Color.parseColor("#1DD171")});
    }

    public final SpeechRecognizerDialog I0(Function1 callback) {
        this.mCallback = callback;
        return this;
    }

    @Override // com.transsion.baseui.dialog.BaseDialog, qi.a
    public qi.b getLogViewConfig() {
        return this.logViewConfig;
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(0, R$style.BottomDialogTheme);
        f.a.a(getClassTag() + " --> onCreate() --> 展示弹窗组件");
    }

    @Override // com.transsion.baseui.dialog.BaseDialog
    public void onDismiss(DialogInterface dialog) {
        Unit unit;
        Intrinsics.h(dialog, "dialog");
        super.onDismiss(dialog);
        try {
            Result.Companion companion = Result.Companion;
            SpeechRecognizer speechRecognizer = this.mSpeechRecognizer;
            if (speechRecognizer != null) {
                speechRecognizer.destroy();
                unit = Unit.a;
            } else {
                unit = null;
            }
            Result.constructor-impl(unit);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            Result.constructor-impl(ResultKt.a(th2));
        }
        Function1 function1 = this.mCallback;
        if (function1 != null) {
        }
        this.mCallback = null;
        f.a.a(getClassTag() + " --> onDismiss() --> 语音识别弹窗关闭 释放资源");
    }

    @Override // com.transsion.baseui.dialog.BaseDialog
    public void onPause() {
        super.onPause();
        SpeechRecognizer speechRecognizer = this.mSpeechRecognizer;
        if (speechRecognizer != null) {
            speechRecognizer.cancel();
        }
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        Window window;
        Intrinsics.h(view, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(view, savedInstanceState);
        Dialog dialog = getDialog();
        if (dialog != null) {
            dialog.setCancelable(false);
        }
        Dialog dialog2 = getDialog();
        if (dialog2 != null && (window = dialog2.getWindow()) != null) {
            window.setGravity(80);
            window.setDimAmount(0.5f);
            window.setBackgroundDrawable(null);
            window.setWindowAnimations(R$style.BaseBottomDialogAnimation);
            window.setLayout(-1, -2);
            WindowManager.LayoutParams attributes = window.getAttributes();
            if (attributes == null) {
                attributes = new WindowManager.LayoutParams();
            }
            attributes.height = C0();
        }
        this.bind = vp.b.a(view);
        initView();
        J0();
        c cVar = new c();
        this.initializeStrategy = cVar;
        cVar.j(new Function0() { // from class: com.transsion.search_pugc.speech.h
            public final Object invoke() {
                Unit G0;
                G0 = SpeechRecognizerDialog.G0(SpeechRecognizerDialog.this);
                return G0;
            }
        });
        D0();
        f.a.b(getClassTag() + " --> onViewCreated() --> 语音识别是否可用 = " + g.a.a());
    }
}
