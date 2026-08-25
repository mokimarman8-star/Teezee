package com.transsion.postdetail.ui.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.fragment.app.w;
import com.therouter.TheRouter;
import com.transsion.baselib.report.k;
import com.transsion.baseui.R$color;
import com.transsion.baseui.activity.BaseActivity;
import com.transsion.gslb.BuildConfig;
import com.transsion.postdetail.R$id;
import com.transsion.postdetail.ui.fragment.LocalVideoDetailFragment;
import com.transsion.subtitle.dialog.SubtitleMainDialog2;
import cw.e;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import wf.a;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 B2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001 B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\u0005J\u000f\u0010\b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\b\u0010\u0005J\u0019\u0010\u000b\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0014¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0010H\u0014¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0016\u0010\u000fJ\u000f\u0010\u0017\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0017\u0010\u000fJ\u000f\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u001b\u0010\u0005J\u000f\u0010\u001c\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u001c\u0010\u0005J\u000f\u0010\u001d\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u001d\u0010\u0005J\u000f\u0010\u001e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u001e\u0010\u000fR\u0018\u0010\"\u001a\u0004\u0018\u00010\u001f8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b \u0010!R\u0018\u0010$\u001a\u0004\u0018\u00010\u001f8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b#\u0010!R\u0018\u0010&\u001a\u0004\u0018\u00010\u001f8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b%\u0010!R\u0018\u0010(\u001a\u0004\u0018\u00010\u001f8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b'\u0010!R\u0018\u0010*\u001a\u0004\u0018\u00010\u001f8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b)\u0010!R\u0018\u0010,\u001a\u0004\u0018\u00010\u001f8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b+\u0010!R\u0018\u0010.\u001a\u0004\u0018\u00010\u001f8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b-\u0010!R\u0018\u00100\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010/R\u0018\u00102\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b1\u0010/R\u0018\u00104\u001a\u0004\u0018\u00010\u001f8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b3\u0010!R\u0018\u00107\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b5\u00106R\u0018\u00109\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b8\u00106R\u0018\u0010;\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b:\u00106R\u0018\u0010=\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b<\u00106R\u0018\u0010A\u001a\u0004\u0018\u00010>8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b?\u0010@¨\u0006C"}, d2 = {"Lcom/transsion/postdetail/ui/activity/LocalVideoDetailActivity;", "Lcom/transsion/baseui/activity/BaseActivity;", "Lwn/b;", "Lcom/transsion/videofloat/manager/c;", "<init>", "()V", BuildConfig.FLAVOR, "d0", "f0", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", BuildConfig.FLAVOR, "isAttach", "()Z", "Landroid/content/Intent;", "intent", "onNewIntent", "(Landroid/content/Intent;)V", "c0", "()Lwn/b;", "isTranslucent", "isStatusDark", BuildConfig.FLAVOR, "statusColor", "()I", "onBackPressed", "onPause", "h", "isMusicFloatingAttach", BuildConfig.FLAVOR, "a", "Ljava/lang/String;", "path", "b", "url", "c", "proxyUrl", "d", "name", "e", "resourceId", "f", "postId", "g", "subjectId", "Ljava/lang/Boolean;", "completed", "i", "isSeries", "j", "pageFrom", "k", "Ljava/lang/Integer;", "videoHeight", "l", "videoWidth", "m", "parentPosition", "n", "position", "Lcom/transsion/postdetail/ui/fragment/LocalVideoDetailFragment;", "o", "Lcom/transsion/postdetail/ui/fragment/LocalVideoDetailFragment;", "fragment", "p", "PostDetail_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class LocalVideoDetailActivity extends BaseActivity<wn.b> implements com.transsion.videofloat.manager.c {

    /* renamed from: a, reason: from kotlin metadata */
    public String path;

    /* renamed from: b, reason: from kotlin metadata */
    public String url;

    /* renamed from: c, reason: from kotlin metadata */
    public String proxyUrl;

    /* renamed from: d, reason: from kotlin metadata */
    public String name;

    /* renamed from: e, reason: from kotlin metadata */
    public String resourceId;

    /* renamed from: f, reason: from kotlin metadata */
    public String postId;

    /* renamed from: g, reason: from kotlin metadata */
    public String subjectId;

    /* renamed from: j, reason: from kotlin metadata */
    public String pageFrom;

    /* renamed from: o, reason: from kotlin metadata */
    private LocalVideoDetailFragment fragment;

    /* renamed from: h, reason: from kotlin metadata */
    public Boolean completed = Boolean.TRUE;

    /* renamed from: i, reason: from kotlin metadata */
    public Boolean isSeries = Boolean.FALSE;

    /* renamed from: k, reason: from kotlin metadata */
    public Integer videoHeight = 0;

    /* renamed from: l, reason: from kotlin metadata */
    public Integer videoWidth = 0;

    /* renamed from: m, reason: from kotlin metadata */
    public Integer parentPosition = -1;

    /* renamed from: n, reason: from kotlin metadata */
    public Integer position = -1;

    /* JADX WARN: Multi-variable type inference failed */
    private final void d0() {
        Uri data = getIntent().getData();
        Intent intent = getIntent();
        String type = intent != null ? intent.getType() : null;
        if ((type == null || !StringsKt.W(type, "video/", false, 2, (Object) null)) && (type == null || !StringsKt.W(type, "audio/", false, 2, (Object) null))) {
            return;
        }
        if (StringsKt.W(String.valueOf(data), "http", false, 2, (Object) null)) {
            this.url = String.valueOf(data);
        } else {
            this.path = String.valueOf(data);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e0() {
        im.b bVar = (im.b) TheRouter.d(im.b.class, new Object[0]);
        if (bVar != null) {
            bVar.w(0.0f);
        }
    }

    private final void f0() {
        LocalVideoDetailFragment localVideoDetailFragment = this.fragment;
        if (localVideoDetailFragment != null) {
            localVideoDetailFragment.m3();
        }
        this.fragment = LocalVideoDetailFragment.INSTANCE.a(this.path, this.url, this.name, this.resourceId, this.postId, this.subjectId, this.proxyUrl, this.completed, this.isSeries, this.pageFrom, this.videoHeight, this.videoWidth, this.parentPosition, this.position);
        w p = getSupportFragmentManager().p();
        int i = R$id.container;
        LocalVideoDetailFragment localVideoDetailFragment2 = this.fragment;
        Intrinsics.e(localVideoDetailFragment2);
        p.s(i, localVideoDetailFragment2).j();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: c0, reason: merged with bridge method [inline-methods] */
    public wn.b getViewBinding() {
        wn.b c = wn.b.c(getLayoutInflater());
        Intrinsics.g(c, "inflate(...)");
        return c;
    }

    public void h() {
        LocalVideoDetailFragment localVideoDetailFragment = this.fragment;
        if (localVideoDetailFragment != null) {
            localVideoDetailFragment.m3();
        }
    }

    public boolean isAttach() {
        return false;
    }

    public boolean isMusicFloatingAttach() {
        return false;
    }

    public boolean isStatusDark() {
        return false;
    }

    public boolean isTranslucent() {
        return false;
    }

    public void onBackPressed() {
        ep.b bVar = (ep.b) TheRouter.d(ep.b.class, new Object[0]);
        if (bVar != null) {
            bVar.e();
        }
        super/*androidx.activity.ComponentActivity*/.onBackPressed();
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onCreate(Bundle savedInstanceState) {
        TheRouter.l(this);
        super.onCreate(savedInstanceState);
        a.a aVar = wf.a.a;
        a.a.f(aVar, "LocalVideoDetail", "LocalVideoDetailActivity onCreate", false, 4, (Object) null);
        a.a.f(aVar, "VideoFloat", "LocalVideoDetailActivity onCreate, " + (savedInstanceState == null), false, 4, (Object) null);
        ep.b bVar = (ep.b) TheRouter.d(ep.b.class, new Object[0]);
        if (bVar != null) {
            bVar.h();
        }
        ep.b bVar2 = (ep.b) TheRouter.d(ep.b.class, new Object[0]);
        if (bVar2 != null) {
            bVar2.c();
        }
        d0();
        k.a.w(1, this);
        if (savedInstanceState == null) {
            f0();
        }
        ((wn.b) getMViewBinding()).getRoot().post(new Runnable() { // from class: com.transsion.postdetail.ui.activity.a
            @Override // java.lang.Runnable
            public final void run() {
                LocalVideoDetailActivity.e0();
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onNewIntent(Intent intent) {
        Intrinsics.h(intent, "intent");
        super/*androidx.activity.ComponentActivity*/.onNewIntent(intent);
        boolean c = Intrinsics.c(this.subjectId, intent.getStringExtra("extra_subject_id"));
        String stringExtra = intent.getStringExtra("extra_page_from");
        setIntent(intent);
        TheRouter.l(this);
        d0();
        if (Intrinsics.c(stringExtra, "media_notification")) {
            LocalVideoDetailFragment localVideoDetailFragment = this.fragment;
            if (localVideoDetailFragment != null) {
                localVideoDetailFragment.e3();
                return;
            }
            return;
        }
        a.a.f(wf.a.a, "LocalVideoDetail", "LocalVideoDetailActivity onNewIntent,isCurrentSubject = " + c, false, 4, (Object) null);
        if (c) {
            LocalVideoDetailFragment localVideoDetailFragment2 = this.fragment;
            if (localVideoDetailFragment2 != null) {
                localVideoDetailFragment2.W1(this.subjectId, this.resourceId);
                return;
            }
            return;
        }
        try {
            Result.Companion companion = Result.Companion;
            SubtitleMainDialog2 k0 = getSupportFragmentManager().k0("fragment_subtitle_main_dialog");
            if (k0 != null && (k0 instanceof SubtitleMainDialog2)) {
                k0.dismissAllowingStateLoss();
            }
            Result.constructor-impl(Unit.a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            Result.constructor-impl(ResultKt.a(th2));
        }
        f0();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onPause() {
        super.onPause();
        if (isFinishing()) {
            LocalVideoDetailFragment localVideoDetailFragment = this.fragment;
            if (localVideoDetailFragment != null) {
                localVideoDetailFragment.m3();
            }
            e.a.b().j(this);
        }
    }

    public int statusColor() {
        return R$color.base_color_black;
    }
}
