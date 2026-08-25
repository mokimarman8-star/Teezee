package com.transsion.publish.view;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.activity.ComponentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.u;
import com.therouter.TheRouter;
import com.transsion.baseui.util.c;
import com.transsion.gslb.BuildConfig;
import com.transsion.publish.R$drawable;
import com.transsion.publish.R$id;
import com.transsion.publish.R$layout;
import com.transsion.publish.bean.PublishResult;
import com.transsion.publish.view.PublishStateView;
import com.transsnet.flow.event.AppScopeVMlProvider;
import com.transsnet.flow.event.FlowEventBus;
import jo.a;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.y0;
import wf.a;
import yg.l;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0004\u0010\bB%\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0001\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0004\u0010\u000bJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\r\u0010\u0005J\u000f\u0010\u000e\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0010\u0010\u0005Je\u0010\u001c\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\t2\b\b\u0002\u0010\u0013\u001a\u00020\u00122\b\b\u0002\u0010\u0014\u001a\u00020\u00122\b\b\u0002\u0010\u0015\u001a\u00020\u00122\b\b\u0002\u0010\u0016\u001a\u00020\u00122\b\b\u0002\u0010\u0017\u001a\u00020\u00122\b\b\u0002\u0010\u0018\u001a\u00020\u00122\b\b\u0002\u0010\u0019\u001a\u00020\u00122\b\b\u0002\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010 \u001a\u00020\f2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e¢\u0006\u0004\b \u0010!J\u0015\u0010#\u001a\u00020\f2\u0006\u0010\"\u001a\u00020\t¢\u0006\u0004\b#\u0010$J\u0015\u0010&\u001a\u00020\f2\u0006\u0010%\u001a\u00020\t¢\u0006\u0004\b&\u0010$R\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010(R\u0014\u0010+\u001a\u00020\u00128\u0002X\u0082D¢\u0006\u0006\n\u0004\b)\u0010*R\u0018\u0010/\u001a\u0004\u0018\u00010,8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010.R\u0018\u00103\u001a\u0004\u0018\u0001008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b1\u00102R\u0018\u00107\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b5\u00106R\u0018\u0010;\u001a\u0004\u0018\u0001088\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010\u0011\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b<\u0010=R\u0016\u0010\u0013\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b>\u0010*R\u0016\u0010\u0014\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b?\u0010*R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b@\u0010*R\u0016\u0010\u0016\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010*R\u0016\u0010\u0018\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bA\u0010*R\u0016\u0010\u0017\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010*R\u0016\u0010\u0019\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bB\u0010*R\u0016\u0010\u001b\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bC\u0010DR\u0018\u0010G\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bE\u0010FR\u001d\u0010L\u001a\u0004\u0018\u00010H8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010I\u001a\u0004\bJ\u0010K¨\u0006M"}, d2 = {"Lcom/transsion/publish/view/PublishStateView;", "Lcom/transsion/publish/view/BaseFloatView;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", BuildConfig.FLAVOR, "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BuildConfig.FLAVOR, "o", "q", "()V", "u", "sourceType", BuildConfig.FLAVOR, "subjectId", "cover", "title", "description", "groupId", "groupName", "groupImage", BuildConfig.FLAVOR, "showIcTxt", "publishSource", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "Lcom/transsion/publish/bean/PublishResult;", "eventBean", "showFloatView", "(Lcom/transsion/publish/bean/PublishResult;)V", "resource", "setImageResource", "(I)V", "color", "setProgressColor", "e", "Lcom/transsion/publish/bean/PublishResult;", "f", "Ljava/lang/String;", "TAG", "Lcom/transsion/publish/view/CircleProgressBar;", "g", "Lcom/transsion/publish/view/CircleProgressBar;", "progressBar", "Landroid/widget/ImageView;", "h", "Landroid/widget/ImageView;", "ivBg", "Landroid/widget/TextView;", "i", "Landroid/widget/TextView;", "icTxt", "Landroid/widget/RelativeLayout;", "j", "Landroid/widget/RelativeLayout;", "layout", "k", "I", "l", "m", "n", "p", "r", "s", "Z", "t", "Ljava/lang/Integer;", "ivBgResource", "Ljo/a;", "Lkotlin/Lazy;", "getPublishedApi", "()Ljo/a;", "publishedApi", "Publish_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class PublishStateView extends BaseFloatView {

    /* renamed from: e, reason: from kotlin metadata */
    private PublishResult eventBean;

    /* renamed from: f, reason: from kotlin metadata */
    private final String TAG;

    /* renamed from: g, reason: from kotlin metadata */
    private CircleProgressBar progressBar;

    /* renamed from: h, reason: from kotlin metadata */
    private ImageView ivBg;

    /* renamed from: i, reason: from kotlin metadata */
    private TextView icTxt;

    /* renamed from: j, reason: from kotlin metadata */
    private RelativeLayout layout;

    /* renamed from: k, reason: from kotlin metadata */
    private int sourceType;

    /* renamed from: l, reason: from kotlin metadata */
    private String subjectId;

    /* renamed from: m, reason: from kotlin metadata */
    private String cover;

    /* renamed from: n, reason: from kotlin metadata */
    private String title;

    /* renamed from: o, reason: from kotlin metadata */
    private String description;

    /* renamed from: p, reason: from kotlin metadata */
    private String groupName;

    /* renamed from: q, reason: from kotlin metadata */
    private String groupId;

    /* renamed from: r, reason: from kotlin metadata */
    private String groupImage;

    /* renamed from: s, reason: from kotlin metadata */
    private boolean showIcTxt;

    /* renamed from: t, reason: from kotlin metadata */
    private Integer ivBgResource;

    /* renamed from: u, reason: from kotlin metadata */
    private final Lazy publishedApi;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PublishStateView(Context context) {
        super(context);
        Intrinsics.h(context, "context");
        this.TAG = "TNPublish";
        this.sourceType = 2;
        this.subjectId = BuildConfig.FLAVOR;
        this.cover = BuildConfig.FLAVOR;
        this.title = BuildConfig.FLAVOR;
        this.description = BuildConfig.FLAVOR;
        this.groupName = BuildConfig.FLAVOR;
        this.groupId = BuildConfig.FLAVOR;
        this.groupImage = BuildConfig.FLAVOR;
        this.showIcTxt = true;
        this.publishedApi = LazyKt.b(new Function0() { // from class: ro.k
            public final Object invoke() {
                jo.a s;
                s = PublishStateView.s();
                return s;
            }
        });
        o(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PublishStateView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.h(context, "context");
        this.TAG = "TNPublish";
        this.sourceType = 2;
        this.subjectId = BuildConfig.FLAVOR;
        this.cover = BuildConfig.FLAVOR;
        this.title = BuildConfig.FLAVOR;
        this.description = BuildConfig.FLAVOR;
        this.groupName = BuildConfig.FLAVOR;
        this.groupId = BuildConfig.FLAVOR;
        this.groupImage = BuildConfig.FLAVOR;
        this.showIcTxt = true;
        this.publishedApi = LazyKt.b(new Function0() { // from class: ro.k
            public final Object invoke() {
                jo.a s;
                s = PublishStateView.s();
                return s;
            }
        });
        o(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PublishStateView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.h(context, "context");
        this.TAG = "TNPublish";
        this.sourceType = 2;
        this.subjectId = BuildConfig.FLAVOR;
        this.cover = BuildConfig.FLAVOR;
        this.title = BuildConfig.FLAVOR;
        this.description = BuildConfig.FLAVOR;
        this.groupName = BuildConfig.FLAVOR;
        this.groupId = BuildConfig.FLAVOR;
        this.groupImage = BuildConfig.FLAVOR;
        this.showIcTxt = true;
        this.publishedApi = LazyKt.b(new Function0() { // from class: ro.k
            public final Object invoke() {
                jo.a s;
                s = PublishStateView.s();
                return s;
            }
        });
        o(context);
    }

    private final a getPublishedApi() {
        return (a) this.publishedApi.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void o(final Context context) {
        LayoutInflater.from(context).inflate(R$layout.view_publish_state, (ViewGroup) this);
        this.progressBar = (CircleProgressBar) findViewById(R$id.circles_bar);
        this.ivBg = (ImageView) findViewById(R$id.iv_btn);
        TextView textView = (TextView) findViewById(R$id.tvContent);
        this.icTxt = textView;
        if (textView != null) {
            textView.setVisibility(this.showIcTxt ? 0 : 8);
        }
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R$id.rl_layout);
        this.layout = relativeLayout;
        if (relativeLayout != null) {
            relativeLayout.setOnClickListener(new View.OnClickListener() { // from class: ro.m
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PublishStateView.p(PublishStateView.this, context, view);
                }
            });
        }
        q();
        CircleProgressBar circleProgressBar = this.progressBar;
        if (circleProgressBar != null) {
            circleProgressBar.setProgress(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(PublishStateView publishStateView, Context context, View view) {
        a publishedApi;
        if (c.a.a(R$id.rl_layout, 2000L)) {
            return;
        }
        a publishedApi2 = publishStateView.getPublishedApi();
        if (publishedApi2 != null && publishedApi2.d() && l.a.e() && (publishedApi = publishStateView.getPublishedApi()) != null && !publishedApi.f()) {
            publishStateView.u(context);
            return;
        }
        a publishedApi3 = publishStateView.getPublishedApi();
        if (publishedApi3 != null) {
            publishedApi3.c();
        }
        int i = publishStateView.sourceType;
        if (i == 2) {
            a publishedApi4 = publishStateView.getPublishedApi();
            if (publishedApi4 != null) {
                publishedApi4.b(context);
            }
            a.a.f(wf.a.a, publishStateView.TAG, "click type_post_publish", false, 4, (Object) null);
            return;
        }
        if (i == 1) {
            jo.a publishedApi5 = publishStateView.getPublishedApi();
            if (publishedApi5 != null) {
                publishedApi5.g(context, publishStateView.subjectId, publishStateView.cover, publishStateView.title, publishStateView.description, publishStateView.sourceType);
            }
            a.a.f(wf.a.a, publishStateView.TAG, "click type_star_publish", false, 4, (Object) null);
            return;
        }
        if (i == 3) {
            jo.a publishedApi6 = publishStateView.getPublishedApi();
            if (publishedApi6 != null) {
                publishedApi6.e(context, publishStateView.subjectId, publishStateView.cover, publishStateView.title, publishStateView.description, publishStateView.sourceType);
            }
            com.transsion.baselib.helper.a.a.h("subjectdetail", "post", (r16 & 4) != 0 ? BuildConfig.FLAVOR : null, (r16 & 8) != 0 ? BuildConfig.FLAVOR : null, (r16 & 16) != 0 ? BuildConfig.FLAVOR : null, (r16 & 32) != 0 ? null : null);
            a.a.f(wf.a.a, publishStateView.TAG, "click type_post_detail", false, 4, (Object) null);
            return;
        }
        if (i == 4) {
            jo.a publishedApi7 = publishStateView.getPublishedApi();
            if (publishedApi7 != null) {
                publishedApi7.a(context, publishStateView.groupId, publishStateView.groupName, publishStateView.groupImage);
            }
            com.transsion.baselib.helper.a.a.h("roomdetail", "post", (r16 & 4) != 0 ? BuildConfig.FLAVOR : null, (r16 & 8) != 0 ? BuildConfig.FLAVOR : null, (r16 & 16) != 0 ? BuildConfig.FLAVOR : null, (r16 & 32) != 0 ? null : null);
            a.a.f(wf.a.a, publishStateView.TAG, "click type_room_detail", false, 4, (Object) null);
        }
    }

    public static /* synthetic */ void publishSource$default(PublishStateView publishStateView, int i, String str, String str2, String str3, String str4, String str5, String str6, String str7, boolean z, int i2, Object obj) {
        int i3 = i2 & 2;
        String str8 = BuildConfig.FLAVOR;
        String str9 = i3 != 0 ? BuildConfig.FLAVOR : str;
        String str10 = (i2 & 4) != 0 ? BuildConfig.FLAVOR : str2;
        String str11 = (i2 & 8) != 0 ? BuildConfig.FLAVOR : str3;
        String str12 = (i2 & 16) != 0 ? BuildConfig.FLAVOR : str4;
        String str13 = (i2 & 32) != 0 ? BuildConfig.FLAVOR : str5;
        String str14 = (i2 & 64) != 0 ? BuildConfig.FLAVOR : str6;
        if ((i2 & 128) == 0) {
            str8 = str7;
        }
        publishStateView.publishSource(i, str9, str10, str11, str12, str13, str14, str8, (i2 & 256) != 0 ? false : z);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void q() {
        u context = getContext();
        if (context instanceof ComponentActivity) {
            Function1 function1 = new Function1() { // from class: ro.n
                public final Object invoke(Object obj) {
                    Unit r;
                    r = PublishStateView.r(PublishStateView.this, (PublishResult) obj);
                    return r;
                }
            };
            FlowEventBus applicationScopeViewModel = AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
            String name = PublishResult.class.getName();
            Intrinsics.g(name, "getName(...)");
            applicationScopeViewModel.observeEvent(context, name, Lifecycle.State.CREATED, y0.c().p(), false, function1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit r(PublishStateView publishStateView, PublishResult publishResult) {
        Intrinsics.h(publishResult, "it");
        publishStateView.showFloatView(publishResult);
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final jo.a s() {
        return (jo.a) TheRouter.d(jo.a.class, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void t(PublishStateView publishStateView) {
        Context context = publishStateView.getContext();
        Intrinsics.g(context, "getContext(...)");
        publishStateView.u(context);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [android.view.View, com.transsion.publish.view.BaseFloatView, com.transsion.publish.view.UploadView] */
    private final void u(Context context) {
        ?? uploadView = new UploadView(context);
        if (!uploadView.getIsShow()) {
            uploadView.setVisibility(0);
            uploadView.setAlpha(1.0f);
            Activity b = com.blankj.utilcode.util.a.b();
            if (b == null || b.isFinishing() || b.isDestroyed()) {
                b = com.blankj.utilcode.util.a.b();
            }
            if (b == null || b.isFinishing() || b.isDestroyed()) {
                return;
            } else {
                uploadView.show(b);
            }
        }
        uploadView.showFloatView(this.eventBean);
    }

    public final void publishSource(int sourceType, String subjectId, String cover, String title, String description, String groupId, String groupName, String groupImage, boolean showIcTxt) {
        Intrinsics.h(subjectId, "subjectId");
        Intrinsics.h(cover, "cover");
        Intrinsics.h(title, "title");
        Intrinsics.h(description, "description");
        Intrinsics.h(groupId, "groupId");
        Intrinsics.h(groupName, "groupName");
        Intrinsics.h(groupImage, "groupImage");
        this.sourceType = sourceType;
        this.subjectId = subjectId;
        this.cover = cover;
        this.title = title;
        this.description = description;
        this.groupId = groupId;
        this.groupName = groupName;
        this.groupImage = groupImage;
        this.showIcTxt = showIcTxt;
        TextView textView = this.icTxt;
        if (textView != null) {
            textView.setVisibility(showIcTxt ? 0 : 8);
        }
    }

    public final void setImageResource(int resource) {
        this.ivBgResource = Integer.valueOf(resource);
        ImageView imageView = this.ivBg;
        if (imageView != null) {
            imageView.setImageResource(resource);
        }
    }

    public final void setProgressColor(int color) {
        CircleProgressBar circleProgressBar = this.progressBar;
        if (circleProgressBar != null) {
            circleProgressBar.setRingColor(color);
        }
    }

    public final void showFloatView(PublishResult eventBean) {
        CircleProgressBar circleProgressBar;
        this.eventBean = eventBean;
        Integer valueOf = eventBean != null ? Integer.valueOf(eventBean.getState()) : null;
        if (valueOf != null && valueOf.intValue() == 2) {
            CircleProgressBar circleProgressBar2 = this.progressBar;
            if (circleProgressBar2 != null) {
                circleProgressBar2.setVisibility(8);
            }
            ImageView imageView = this.ivBg;
            if (imageView != null) {
                Integer num = this.ivBgResource;
                imageView.setImageResource(num != null ? num.intValue() : R$drawable.ic_floating_state_comm);
                return;
            }
            return;
        }
        if (valueOf != null && valueOf.intValue() == 1) {
            CircleProgressBar circleProgressBar3 = this.progressBar;
            if (circleProgressBar3 != null) {
                circleProgressBar3.setVisibility(8);
            }
            CircleProgressBar circleProgressBar4 = this.progressBar;
            if (circleProgressBar4 != null) {
                circleProgressBar4.setProgress(0);
            }
            ImageView imageView2 = this.ivBg;
            if (imageView2 != null) {
                Integer num2 = this.ivBgResource;
                imageView2.setImageResource(num2 != null ? num2.intValue() : R$drawable.ic_floating_state_comm);
                return;
            }
            return;
        }
        if (valueOf != null && valueOf.intValue() == 0) {
            CircleProgressBar circleProgressBar5 = this.progressBar;
            if (circleProgressBar5 == null || circleProgressBar5.getVisibility() != 0) {
                CircleProgressBar circleProgressBar6 = this.progressBar;
                if (circleProgressBar6 != null) {
                    circleProgressBar6.setVisibility(0);
                }
                CircleProgressBar circleProgressBar7 = this.progressBar;
                if (circleProgressBar7 != null) {
                    circleProgressBar7.setProgress(0);
                }
            }
            ImageView imageView3 = this.ivBg;
            if (imageView3 != null) {
                Integer num3 = this.ivBgResource;
                imageView3.setImageResource(num3 != null ? num3.intValue() : R$drawable.ic_floating_state_ing);
            }
            ImageView imageView4 = this.ivBg;
            if (imageView4 != null) {
                imageView4.postDelayed(new Runnable() { // from class: ro.l
                    @Override // java.lang.Runnable
                    public final void run() {
                        PublishStateView.t(PublishStateView.this);
                    }
                }, 1500L);
                return;
            }
            return;
        }
        if (valueOf == null || valueOf.intValue() != 3) {
            if (valueOf != null && valueOf.intValue() == 4) {
                CircleProgressBar circleProgressBar8 = this.progressBar;
                if (circleProgressBar8 != null) {
                    circleProgressBar8.setVisibility(8);
                }
                ImageView imageView5 = this.ivBg;
                if (imageView5 != null) {
                    Integer num4 = this.ivBgResource;
                    imageView5.setImageResource(num4 != null ? num4.intValue() : R$drawable.ic_floating_state_comm);
                    return;
                }
                return;
            }
            return;
        }
        CircleProgressBar circleProgressBar9 = this.progressBar;
        if ((circleProgressBar9 == null || circleProgressBar9.getVisibility() != 0) && (circleProgressBar = this.progressBar) != null) {
            circleProgressBar.setVisibility(0);
        }
        CircleProgressBar circleProgressBar10 = this.progressBar;
        if (circleProgressBar10 != null) {
            circleProgressBar10.setProgress(eventBean.getProgress());
        }
        ImageView imageView6 = this.ivBg;
        if (imageView6 != null) {
            Integer num5 = this.ivBgResource;
            imageView6.setImageResource(num5 != null ? num5.intValue() : R$drawable.ic_floating_state_ing);
        }
    }
}
