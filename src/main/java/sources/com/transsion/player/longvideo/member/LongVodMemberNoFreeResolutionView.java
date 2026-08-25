package com.transsion.player.longvideo.member;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import com.therouter.TheRouter;
import com.transsion.gslb.BuildConfig;
import com.transsion.memberapi.MemberCheckResult;
import com.transsion.memberapi.MemberSceneType;
import com.transsion.memberapi.MemberSource;
import com.transsion.memberapi.OpType;
import com.transsion.player.longvideo.R$id;
import com.transsion.player.longvideo.R$layout;
import com.transsion.player.longvideo.R$string;
import com.transsion.player.longvideo.member.LongVodMemberNoFreeResolutionView;
import im.a;
import im.b$a;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.y0;
import ni.f;
import wj.g;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u000e\u0010\rJ!\u0010\u0012\u001a\u00020\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0016\u001a\u00020\u000b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b\u0016\u0010\u0017R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010\u001c¨\u0006\u001d"}, d2 = {"Lcom/transsion/player/longvideo/member/LongVodMemberNoFreeResolutionView;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", BuildConfig.FLAVOR, "getClassTag", "()Ljava/lang/String;", BuildConfig.FLAVOR, "c", "()V", "d", "Lln/a;", "bean", "pageName", "showCover", "(Lln/a;Ljava/lang/String;)V", "Lim/c;", "listener", "setListener", "(Lim/c;)V", "a", "Ljava/lang/String;", "b", "Lln/a;", "Lim/c;", "LongVideo_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class LongVodMemberNoFreeResolutionView extends FrameLayout {

    /* renamed from: a, reason: from kotlin metadata */
    private String pageName;

    /* renamed from: b, reason: from kotlin metadata */
    private ln.a bean;

    /* renamed from: c, reason: from kotlin metadata */
    private im.c listener;

    public static final class a implements im.a {

        /* renamed from: com.transsion.player.longvideo.member.LongVodMemberNoFreeResolutionView$a$a, reason: collision with other inner class name */
        public static final class C0043a implements im.c {
            final /* synthetic */ LongVodMemberNoFreeResolutionView a;
            final /* synthetic */ AppCompatActivity b;

            /* renamed from: com.transsion.player.longvideo.member.LongVodMemberNoFreeResolutionView$a$a$a, reason: collision with other inner class name */
            public static final class C0044a implements nw.e {
                final /* synthetic */ LongVodMemberNoFreeResolutionView a;

                C0044a(LongVodMemberNoFreeResolutionView longVodMemberNoFreeResolutionView) {
                    this.a = longVodMemberNoFreeResolutionView;
                }

                public void a(boolean z) {
                    if (z) {
                        this.a.d();
                    }
                }
            }

            C0043a(LongVodMemberNoFreeResolutionView longVodMemberNoFreeResolutionView, AppCompatActivity appCompatActivity) {
                this.a = longVodMemberNoFreeResolutionView;
                this.b = appCompatActivity;
            }

            @Override // im.c
            public void a() {
                k.a.a(this.a.getClassTag() + " --> llUnlockBtn{} --> ka开通会员失败 --> 商业化逻辑");
                ResolutionMemberManager resolutionMemberManager = ResolutionMemberManager.a;
                FragmentManager supportFragmentManager = this.b.getSupportFragmentManager();
                Intrinsics.g(supportFragmentManager, "getSupportFragmentManager(...)");
                resolutionMemberManager.i(supportFragmentManager, MemberSource.SOURCE_STREAM_RESOLUTION_START_PLAY_ERROR, this.a.bean, this.a.pageName, new C0044a(this.a));
            }

            @Override // im.c
            public void onSuccess() {
                this.a.d();
                k.a.a(this.a.getClassTag() + " --> llUnlockBtn{} --> ka开通会员成功");
            }
        }

        public static final class b implements wj.g {
            final /* synthetic */ LongVodMemberNoFreeResolutionView a;

            b(LongVodMemberNoFreeResolutionView longVodMemberNoFreeResolutionView) {
                this.a = longVodMemberNoFreeResolutionView;
            }

            @Override // wj.g
            public void a(boolean z) {
                g.a.a(this, z);
            }

            @Override // wj.g
            public void onFail() {
                k.a.a(this.a.getClassTag() + " --> llUnlockBtn{} --> 三合一弹窗 失败");
            }

            @Override // wj.g
            public void onSuccess() {
                this.a.d();
                k.a.a(this.a.getClassTag() + " --> showTreasureDialog() --> 三合一弹窗 成功");
            }
        }

        a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit h(LongVodMemberNoFreeResolutionView longVodMemberNoFreeResolutionView, Object obj) {
            wj.h.a.a(longVodMemberNoFreeResolutionView.getClassTag() + " --> checkMemberRights() --> sceneType = MemberSceneType.SCENE_PREDL --> success");
            return Unit.a;
        }

        @Override // im.a
        public void a(MemberCheckResult memberCheckResult) {
            AppCompatActivity context = LongVodMemberNoFreeResolutionView.this.getContext();
            AppCompatActivity appCompatActivity = context instanceof AppCompatActivity ? context : null;
            if (appCompatActivity != null) {
                LongVodMemberNoFreeResolutionView longVodMemberNoFreeResolutionView = LongVodMemberNoFreeResolutionView.this;
                im.b bVar = (im.b) TheRouter.d(im.b.class, new Object[0]);
                if (bVar != null) {
                    b$a.c(bVar, appCompatActivity, MemberSource.SOURCE_STREAM_RESOLUTION_START_PLAY_ERROR, new C0043a(longVodMemberNoFreeResolutionView, appCompatActivity), false, null, 24, null);
                }
            }
        }

        @Override // im.a
        public void b(MemberCheckResult memberCheckResult) {
            a.C0074a.d(this, memberCheckResult);
        }

        @Override // im.a
        public void c(MemberCheckResult memberCheckResult) {
            a.C0074a.g(this, memberCheckResult);
            wj.f fVar = (wj.f) TheRouter.d(wj.f.class, new Object[0]);
            if (fVar != null) {
                fVar.b(BuildConfig.FLAVOR, memberCheckResult, new b(LongVodMemberNoFreeResolutionView.this));
            }
        }

        @Override // im.a
        public void d(MemberCheckResult memberCheckResult) {
            a.C0074a.e(this, memberCheckResult);
        }

        @Override // im.a
        public void e() {
            LongVodMemberNoFreeResolutionView.this.d();
            wj.h.a.a(LongVodMemberNoFreeResolutionView.this.getClassTag() + " --> checkMemberRights() --> passed() --> 会员权益通过验证 --> 继续下载任务");
            im.b bVar = (im.b) TheRouter.d(im.b.class, new Object[0]);
            if (bVar != null) {
                OpType opType = OpType.OP_DOWNLOAD;
                final LongVodMemberNoFreeResolutionView longVodMemberNoFreeResolutionView = LongVodMemberNoFreeResolutionView.this;
                bVar.n(opType, new Function1() { // from class: com.transsion.player.longvideo.member.b
                    public final Object invoke(Object obj) {
                        Unit h;
                        h = LongVodMemberNoFreeResolutionView.a.h(LongVodMemberNoFreeResolutionView.this, obj);
                        return h;
                    }
                });
            }
        }

        @Override // im.a
        public void f(MemberCheckResult memberCheckResult) {
            a.C0074a.a(this, memberCheckResult);
            wj.h.a.b(LongVodMemberNoFreeResolutionView.this.getClassTag() + " --> triggerDownload() --> showCheckMemberRights() --> notImplement() --> 当前类型没有实现");
        }

        @Override // im.a
        public void onFail(String str) {
            Intrinsics.h(str, "errorMsg");
            a.C0074a.b(this, str);
            wj.h.a.b(LongVodMemberNoFreeResolutionView.this.getClassTag() + " --> checkMemberRights() --> showCheckMemberRightsDialog() --> " + str);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    @JvmOverloads
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public LongVodMemberNoFreeResolutionView(Context context) {
        this(context, r0, 2, r0);
        Intrinsics.h(context, "context");
        AttributeSet attributeSet = null;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public LongVodMemberNoFreeResolutionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.h(context, "context");
        View inflate = LayoutInflater.from(context).inflate(R$layout.long_vod_member_no_free_resolution_view, (ViewGroup) this, false);
        addView(inflate);
        TextView textView = (TextView) inflate.findViewById(R$id.tvUnlockTip);
        if (textView != null) {
            String string = context.getString(R$string.long_vod_unlock_720p_up_quality_with_premium, r.a.j());
            Intrinsics.g(string, "getString(...)");
            textView.setText(string);
        }
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R$id.llUnlockBtn);
        if (linearLayout != null) {
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.player.longvideo.member.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    LongVodMemberNoFreeResolutionView.b(LongVodMemberNoFreeResolutionView.this, view);
                }
            });
        }
    }

    public /* synthetic */ LongVodMemberNoFreeResolutionView(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(LongVodMemberNoFreeResolutionView longVodMemberNoFreeResolutionView, View view) {
        wj.h.a.a(longVodMemberNoFreeResolutionView.getClassTag() + " --> llUnlockBtn{} --> 开通会员按钮点击");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("module_name", "clarity_unlock");
        ln.a aVar = longVodMemberNoFreeResolutionView.bean;
        linkedHashMap.put("subject_id", aVar != null ? aVar.o() : null);
        qi.h hVar = qi.h.a;
        String str = longVodMemberNoFreeResolutionView.pageName;
        if (str == null) {
            str = "vip_resolution";
        }
        hVar.o(str, linkedHashMap);
        longVodMemberNoFreeResolutionView.c();
    }

    private final void c() {
        wj.h.a.a(getClassTag() + " --> showDialog() --> 接口校验 --> sceneType = " + MemberSceneType.SCENE_PREDL);
        im.b bVar = (im.b) TheRouter.d(im.b.class, new Object[0]);
        if (bVar != null) {
            bVar.d(MemberSceneType.SCENE_START_RESOLUTION, 0, new a());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d() {
        kotlinx.coroutines.i.d(o0.a(y0.c()), (CoroutineContext) null, (CoroutineStart) null, new LongVodMemberNoFreeResolutionView$unlock$1(this, null), 3, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getClassTag() {
        String simpleName = LongVodMemberNoFreeResolutionView.class.getSimpleName();
        Intrinsics.g(simpleName, "getSimpleName(...)");
        return simpleName;
    }

    public final void setListener(im.c listener) {
        this.listener = listener;
    }

    public final void showCover(ln.a bean, String pageName) {
        setVisibility(0);
        this.bean = bean;
        this.pageName = pageName;
        ImageView imageView = (ImageView) findViewById(R$id.ivCover);
        if (imageView != null) {
            f.a aVar = ni.f.a;
            Context context = getContext();
            Intrinsics.g(context, "getContext(...)");
            aVar.m(context).g(bean != null ? bean.c() : null).k(true).a(6).d(imageView);
        }
    }
}
