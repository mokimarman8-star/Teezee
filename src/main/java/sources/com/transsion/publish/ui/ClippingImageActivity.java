package com.transsion.publish.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import com.bumptech.glide.Glide;
import com.transsion.baseui.activity.BaseActivity;
import com.transsion.gslb.BuildConfig;
import com.transsion.publish.api.PhotoEntity;
import com.transsion.publish.view.clip.ClipImageView;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import wf.a;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0007\u0018\u0000 C2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001*B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\u0005J\u000f\u0010\b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\b\u0010\u0005J\u0019\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000e\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0019\u0010\u001a\u001a\u00020\u00062\b\u0010\u0019\u001a\u0004\u0018\u00010\u0011H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u0019\u0010\u001e\u001a\u00020\u00062\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0014¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u00020\u0002H\u0016¢\u0006\u0004\b \u0010!J\u000f\u0010#\u001a\u00020\"H\u0016¢\u0006\u0004\b#\u0010$J\u000f\u0010%\u001a\u00020\"H\u0016¢\u0006\u0004\b%\u0010$J\u000f\u0010&\u001a\u00020\"H\u0016¢\u0006\u0004\b&\u0010$J\u000f\u0010(\u001a\u00020'H\u0016¢\u0006\u0004\b(\u0010)R\u0018\u0010,\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010+R\u0018\u00100\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00102\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b1\u0010+R\u0016\u00106\u001a\u0002038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u00105R\u0016\u00108\u001a\u0002038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b7\u00105R\u0016\u0010:\u001a\u0002038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b9\u00105R\u0016\u0010<\u001a\u0002038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b;\u00105R\u0016\u0010@\u001a\u00020=8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b>\u0010?R\u0016\u0010B\u001a\u0002038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bA\u00105¨\u0006D"}, d2 = {"Lcom/transsion/publish/ui/ClippingImageActivity;", "Lcom/transsion/baseui/activity/BaseActivity;", "Llo/a;", BuildConfig.FLAVOR, "<init>", "()V", BuildConfig.FLAVOR, "initView", "initData", "Lcom/transsion/publish/view/clip/ClipImageView;", "clipImageView", "Ljava/io/File;", "k0", "(Lcom/transsion/publish/view/clip/ClipImageView;)Ljava/io/File;", "r0", "(Lcom/transsion/publish/view/clip/ClipImageView;)V", "imageView", BuildConfig.FLAVOR, "uri", "o0", "(Lcom/transsion/publish/view/clip/ClipImageView;Ljava/lang/String;)V", "Landroid/content/Context;", "context", "p0", "(Landroid/content/Context;)V", "path", "q0", "(Ljava/lang/String;)V", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "l0", "()Llo/a;", BuildConfig.FLAVOR, "isTranslucent", "()Z", "isStatusDark", "isChangeStatusBar", "Lqi/b;", "newLogViewConfig", "()Lqi/b;", "a", "Ljava/lang/String;", "CROP_CACHE", "Lio/reactivex/rxjava3/disposables/c;", "b", "Lio/reactivex/rxjava3/disposables/c;", "disposable", "c", "TAG", BuildConfig.FLAVOR, "d", "I", "width", "e", "height", "f", "cropWidth", "g", "cropHeight", BuildConfig.FLAVOR, "h", "J", "cropSize", "i", "source", "j", "Publish_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class ClippingImageActivity extends BaseActivity<lo.a> {

    /* renamed from: j, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: from kotlin metadata */
    private String CROP_CACHE;

    /* renamed from: b, reason: from kotlin metadata */
    private io.reactivex.rxjava3.disposables.c disposable;

    /* renamed from: c, reason: from kotlin metadata */
    private String TAG = "ClipHandler";

    /* renamed from: d, reason: from kotlin metadata */
    private int width;

    /* renamed from: e, reason: from kotlin metadata */
    private int height;

    /* renamed from: f, reason: from kotlin metadata */
    private int cropWidth;

    /* renamed from: g, reason: from kotlin metadata */
    private int cropHeight;

    /* renamed from: h, reason: from kotlin metadata */
    private long cropSize;

    /* renamed from: i, reason: from kotlin metadata */
    private int source;

    /* renamed from: com.transsion.publish.ui.ClippingImageActivity$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void b(Companion companion, Activity activity, String str, int i, androidx.activity.result.b bVar, int i2, Object obj) {
            if ((i2 & 8) != 0) {
                bVar = null;
            }
            companion.a(activity, str, i, bVar);
        }

        public final void a(Activity activity, String str, int i, androidx.activity.result.b bVar) {
            Intrinsics.h(activity, "context");
            Intrinsics.h(str, "uri");
            Intent intent = new Intent(activity, (Class<?>) ClippingImageActivity.class);
            intent.putExtra("uri", str);
            intent.putExtra("source", i);
            if (bVar != null) {
                bVar.a(intent);
            } else {
                activity.startActivityForResult(intent, 10002);
            }
        }
    }

    public static final class b implements io.reactivex.rxjava3.core.o {
        b() {
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(File file) {
            Intrinsics.h(file, "file");
            a.a.f(wf.a.a, ClippingImageActivity.this.TAG, "onNext e:" + file.getAbsolutePath(), false, 4, (Object) null);
            Intent intent = new Intent();
            PhotoEntity photoEntity = new PhotoEntity();
            photoEntity.setWidth(ClippingImageActivity.this.cropWidth);
            photoEntity.setHeight(ClippingImageActivity.this.cropHeight);
            photoEntity.setLocalPath(file.getAbsolutePath());
            photoEntity.setImageSize(ClippingImageActivity.this.cropSize);
            intent.putExtra("clip_result", photoEntity);
            ClippingImageActivity.this.setResult(10003, intent);
            ClippingImageActivity.this.finish();
        }

        public void onComplete() {
            ProgressBar progressBar = ((lo.a) ClippingImageActivity.this.getMViewBinding()).d;
            Intrinsics.g(progressBar, "clipLoading");
            uf.c.g(progressBar);
            io.reactivex.rxjava3.disposables.c cVar = ClippingImageActivity.this.disposable;
            if (cVar != null) {
                cVar.dispose();
            }
        }

        public void onError(Throwable th2) {
            Intrinsics.h(th2, "e");
            ProgressBar progressBar = ((lo.a) ClippingImageActivity.this.getMViewBinding()).d;
            Intrinsics.g(progressBar, "clipLoading");
            uf.c.g(progressBar);
            a.a.f(wf.a.a, ClippingImageActivity.this.TAG, "onError e:" + th2, false, 4, (Object) null);
        }

        public void onSubscribe(io.reactivex.rxjava3.disposables.c cVar) {
            Intrinsics.h(cVar, "d");
            ClippingImageActivity.this.disposable = cVar;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void initData() {
        this.source = getIntent().getIntExtra("source", 0);
        String stringExtra = getIntent().getStringExtra("uri");
        ((lo.a) getMViewBinding()).e.setStart(0);
        if (stringExtra != null) {
            ClipImageView clipImageView = ((lo.a) getMViewBinding()).f;
            Intrinsics.g(clipImageView, "srcPic");
            o0(clipImageView, stringExtra);
        }
        ((lo.a) getMViewBinding()).b.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.publish.ui.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ClippingImageActivity.m0(ClippingImageActivity.this, view);
            }
        });
        ((lo.a) getMViewBinding()).g.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.publish.ui.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ClippingImageActivity.n0(ClippingImageActivity.this, view);
            }
        });
        int i = this.source;
        if (i == 0 || 5 == i) {
            this.width = com.blankj.utilcode.util.y.b() - 2;
            this.height = qo.g.a.a(this, 202.0f);
            ((lo.a) getMViewBinding()).e.setSizeNeedChange(false);
            ((lo.a) getMViewBinding()).e.setStartWH(this.width, this.height);
            ((lo.a) getMViewBinding()).e.setSizeNeedChange(false);
            ((lo.a) getMViewBinding()).f.setCropWH(this.width, this.height);
        } else {
            ((lo.a) getMViewBinding()).e.setStart(1);
        }
        qi.b logViewConfig = getLogViewConfig();
        if (logViewConfig != null) {
            logViewConfig.k(true);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void initView() {
        p0(this);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(17:2|3|(14:8|9|(1:13)|14|(2:67|68)|(1:17)(1:66)|18|(1:20)(1:65)|21|54|55|56|57|58)|70|9|(2:11|13)|14|(0)|(0)(0)|18|(0)(0)|21|54|55|56|57|58) */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00d6, code lost:
    
        r11 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00d7, code lost:
    
        r11.printStackTrace();
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x00ce, code lost:
    
        r11 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x00cf, code lost:
    
        r11.printStackTrace();
     */
    /* JADX WARN: Removed duplicated region for block: B:17:0x009c A[Catch: all -> 0x0095, IOException -> 0x0098, TryCatch #2 {IOException -> 0x0098, blocks: (B:68:0x008d, B:17:0x009c, B:18:0x00a6, B:20:0x00b1, B:21:0x00bb), top: B:67:0x008d }] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00b1 A[Catch: all -> 0x0095, IOException -> 0x0098, TryCatch #2 {IOException -> 0x0098, blocks: (B:68:0x008d, B:17:0x009c, B:18:0x00a6, B:20:0x00b1, B:21:0x00bb), top: B:67:0x008d }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00f3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x008d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final File k0(ClipImageView clipImageView) {
        FileOutputStream fileOutputStream;
        Bitmap clip;
        File file;
        FileOutputStream fileOutputStream2 = null;
        try {
            int i = this.source;
            if (i != 0 && 5 != i) {
                clip = ((lo.a) getMViewBinding()).f.clip();
                file = new File(this.CROP_CACHE);
                String str = System.currentTimeMillis() + "temp_crop.png";
                if (!file.exists() && !file.mkdirs()) {
                    a.a.f(wf.a.a, this.TAG, "cropImage, mkdirs failed, file is " + file.getAbsolutePath(), false, 4, (Object) null);
                }
                File file2 = new File(file, str);
                fileOutputStream = new FileOutputStream(file2);
                if (clip != null) {
                    try {
                        try {
                            clip.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
                        } catch (IOException e) {
                            e = e;
                            e.printStackTrace();
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.flush();
                                } catch (IOException e2) {
                                    e2.printStackTrace();
                                }
                                try {
                                    fileOutputStream.close();
                                } catch (IOException e3) {
                                    e3.printStackTrace();
                                }
                            }
                            return null;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        fileOutputStream2 = fileOutputStream;
                        if (fileOutputStream2 != null) {
                            try {
                                fileOutputStream2.flush();
                            } catch (IOException e4) {
                                e4.printStackTrace();
                            }
                            try {
                                fileOutputStream2.close();
                            } catch (IOException e5) {
                                e5.printStackTrace();
                            }
                        }
                        throw th;
                    }
                }
                Integer valueOf = clip == null ? Integer.valueOf(clip.getWidth()) : null;
                Intrinsics.e(valueOf);
                this.cropWidth = valueOf.intValue();
                Integer valueOf2 = clip == null ? Integer.valueOf(clip.getHeight()) : null;
                Intrinsics.e(valueOf2);
                this.cropHeight = valueOf2.intValue();
                this.cropSize = this.cropWidth * r0;
                fileOutputStream.flush();
                fileOutputStream.close();
                return file2;
            }
            Rect rect = ((lo.a) getMViewBinding()).e.rect();
            Intrinsics.g(rect, "rect(...)");
            clip = ((lo.a) getMViewBinding()).f.clip(rect);
            file = new File(this.CROP_CACHE);
            String str2 = System.currentTimeMillis() + "temp_crop.png";
            if (!file.exists()) {
                a.a.f(wf.a.a, this.TAG, "cropImage, mkdirs failed, file is " + file.getAbsolutePath(), false, 4, (Object) null);
            }
            File file22 = new File(file, str2);
            fileOutputStream = new FileOutputStream(file22);
            if (clip != null) {
            }
            if (clip == null) {
            }
            Intrinsics.e(valueOf);
            this.cropWidth = valueOf.intValue();
            if (clip == null) {
            }
            Intrinsics.e(valueOf2);
            this.cropHeight = valueOf2.intValue();
            this.cropSize = this.cropWidth * r0;
            fileOutputStream.flush();
            fileOutputStream.close();
            return file22;
        } catch (IOException e6) {
            e = e6;
            fileOutputStream = null;
        } catch (Throwable th3) {
            th = th3;
            if (fileOutputStream2 != null) {
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m0(ClippingImageActivity clippingImageActivity, View view) {
        clippingImageActivity.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n0(ClippingImageActivity clippingImageActivity, View view) {
        ProgressBar progressBar = ((lo.a) clippingImageActivity.getMViewBinding()).d;
        Intrinsics.g(progressBar, "clipLoading");
        uf.c.k(progressBar);
        ClipImageView clipImageView = ((lo.a) clippingImageActivity.getMViewBinding()).f;
        Intrinsics.g(clipImageView, "srcPic");
        clippingImageActivity.r0(clipImageView);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void o0(ClipImageView imageView, String uri) {
        Glide.with(imageView).load(Uri.fromFile(new File(uri))).into(imageView);
    }

    private final void p0(Context context) {
        String str;
        String str2 = this.CROP_CACHE;
        if (str2 == null || (str2 != null && StringsKt.W(str2, "/data/user/", false, 2, (Object) null))) {
            File a = qo.e.a(context);
            if (a != null) {
                str = a.getAbsolutePath() + "/crop/";
            } else {
                str = context.getCacheDir().getAbsolutePath() + "/crop/";
            }
            this.CROP_CACHE = str;
        }
        q0(this.CROP_CACHE);
    }

    private final void q0(String path) {
        if (path == null) {
            return;
        }
        com.blankj.utilcode.util.n.b(path);
    }

    private final void r0(final ClipImageView clipImageView) {
        io.reactivex.rxjava3.core.j.g(new io.reactivex.rxjava3.core.l() { // from class: com.transsion.publish.ui.c
            public final void a(io.reactivex.rxjava3.core.k kVar) {
                ClippingImageActivity.s0(ClippingImageActivity.this, clipImageView, kVar);
            }
        }).v(io.reactivex.rxjava3.android.schedulers.b.c()).E(ey.a.c()).subscribe(new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s0(ClippingImageActivity clippingImageActivity, ClipImageView clipImageView, io.reactivex.rxjava3.core.k kVar) {
        Intrinsics.h(kVar, "emitter");
        a.a.f(wf.a.a, clippingImageActivity.TAG, "start....", false, 4, (Object) null);
        File k0 = clippingImageActivity.k0(clipImageView);
        if (kVar.isDisposed() || k0 == null) {
            return;
        }
        kVar.onNext(k0);
    }

    public boolean isChangeStatusBar() {
        return false;
    }

    public boolean isStatusDark() {
        return true;
    }

    public boolean isTranslucent() {
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: l0, reason: merged with bridge method [inline-methods] */
    public lo.a getViewBinding() {
        lo.a c = lo.a.c(getLayoutInflater());
        Intrinsics.g(c, "inflate(...)");
        return c;
    }

    public qi.b newLogViewConfig() {
        return new qi.b("clipping_image", false, 2, null);
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        initData();
    }
}
