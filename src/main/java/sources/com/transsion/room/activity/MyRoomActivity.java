package com.transsion.room.activity;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.w;
import androidx.lifecycle.Lifecycle;
import com.transsion.baseui.activity.BaseNewActivity;
import com.transsion.gslb.BuildConfig;
import com.transsion.room.R$id;
import com.transsion.room.R$string;
import com.transsion.room.activity.MyRoomActivity;
import com.transsion.room.fragment.RoomsFragment;
import com.transsnet.flow.event.AppScopeVMlProvider;
import com.transsnet.flow.event.FlowEventBus;
import com.transsnet.flow.event.sync.event.JoinRoomEvent;
import com.transsnet.loginapi.bean.UserInfo;
import fp.f;
import ij.y;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.y0;
import qx.b;
import yg.l;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 ,2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001-B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0019\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0014¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0011\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0012\u0010\u0010J\u000f\u0010\u0013\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J)\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00152\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0014¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\bH\u0016¢\u0006\u0004\b\u001c\u0010\u0005J\u000f\u0010\u001d\u001a\u00020\bH\u0016¢\u0006\u0004\b\u001d\u0010\u0005J\u000f\u0010\u001e\u001a\u00020\bH\u0016¢\u0006\u0004\b\u001e\u0010\u0005J\u000f\u0010\u001f\u001a\u00020\bH\u0016¢\u0006\u0004\b\u001f\u0010\u0005J\u000f\u0010 \u001a\u00020\bH\u0016¢\u0006\u0004\b \u0010\u0005J\u000f\u0010!\u001a\u00020\u000bH\u0016¢\u0006\u0004\b!\u0010\rR\u0018\u0010%\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010$R\u0018\u0010(\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010+\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010*¨\u0006."}, d2 = {"Lcom/transsion/room/activity/MyRoomActivity;", "Lcom/transsion/baseui/activity/BaseNewActivity;", "Lfp/f;", "Lqx/b;", "<init>", "()V", "Landroid/os/Bundle;", "savedInstanceState", BuildConfig.FLAVOR, "onCreate", "(Landroid/os/Bundle;)V", BuildConfig.FLAVOR, "f0", "()Ljava/lang/String;", BuildConfig.FLAVOR, "isTranslucent", "()Z", "isStatusDark", "isChangeStatusBar", "D0", "()Lfp/f;", BuildConfig.FLAVOR, "requestCode", "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", "(IILandroid/content/Intent;)V", "retryLoadData", "l0", "m0", "k0", "p0", "getPageName", "Lcom/transsion/room/fragment/RoomsFragment;", "i", "Lcom/transsion/room/fragment/RoomsFragment;", "mFragment", "j", "Ljava/lang/String;", "mUserId", "k", "Z", "isSelf", "l", "a", "Room_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class MyRoomActivity extends BaseNewActivity<f> implements b {

    /* renamed from: i, reason: from kotlin metadata */
    private RoomsFragment mFragment;

    /* renamed from: j, reason: from kotlin metadata */
    private String mUserId = BuildConfig.FLAVOR;

    /* renamed from: k, reason: from kotlin metadata */
    private boolean isSelf;

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit E0(MyRoomActivity myRoomActivity, JoinRoomEvent joinRoomEvent) {
        RoomsFragment roomsFragment;
        Intrinsics.h(joinRoomEvent, "value");
        try {
            Result.Companion companion = Result.Companion;
            if (!joinRoomEvent.getJoin() && (roomsFragment = myRoomActivity.mFragment) != null) {
                roomsFragment.G0();
            }
            Result.constructor-impl(Unit.a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            Result.constructor-impl(ResultKt.a(th2));
        }
        return Unit.a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: D0, reason: merged with bridge method [inline-methods] */
    public f getViewBinding() {
        f c = f.c(getLayoutInflater());
        Intrinsics.g(c, "inflate(...)");
        return c;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public String f0() {
        String string = getString(R$string.str_room_title);
        Intrinsics.g(string, "getString(...)");
        return string;
    }

    public String getPageName() {
        return "myrooms";
    }

    public boolean isChangeStatusBar() {
        return true;
    }

    public boolean isStatusDark() {
        return !y.a.a();
    }

    public boolean isTranslucent() {
        return true;
    }

    public void k0() {
        Function1 function1 = new Function1() { // from class: dp.i
            public final Object invoke(Object obj) {
                Unit E0;
                E0 = MyRoomActivity.E0(MyRoomActivity.this, (JoinRoomEvent) obj);
                return E0;
            }
        };
        FlowEventBus applicationScopeViewModel = AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
        String name = JoinRoomEvent.class.getName();
        Intrinsics.g(name, "getName(...)");
        applicationScopeViewModel.observeEvent(this, name, Lifecycle.State.CREATED, y0.c().p(), false, function1);
    }

    public void l0() {
    }

    public void m0() {
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        RoomsFragment roomsFragment;
        super/*androidx.fragment.app.FragmentActivity*/.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 10086 && resultCode == -1 && (roomsFragment = this.mFragment) != null) {
            roomsFragment.G0();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onCreate(Bundle savedInstanceState) {
        Intent intent = getIntent();
        if (intent != null) {
            this.mUserId = intent.getStringExtra("userId");
            this.isSelf = intent.getBooleanExtra("isSelf", false);
        }
        super.onCreate(savedInstanceState);
    }

    public void onLogin(UserInfo userInfo) {
        b.a.a(this, userInfo);
    }

    public void onLogout() {
        b.a.b(this);
    }

    public void onUpdateUserInfo(UserInfo userInfo) {
        b.a.c(this, userInfo);
    }

    public void p0() {
        if (this.mFragment == null) {
            FragmentManager supportFragmentManager = getSupportFragmentManager();
            Intrinsics.g(supportFragmentManager, "getSupportFragmentManager(...)");
            w p = supportFragmentManager.p();
            Intrinsics.g(p, "beginTransaction()");
            RoomsFragment a = RoomsFragment.INSTANCE.a(this.mUserId, this.isSelf);
            p.s(R$id.flContent, a);
            this.mFragment = a;
            p.j();
        }
    }

    public void retryLoadData() {
        w0();
        if (!l.a.e()) {
            y0();
        } else {
            u0();
            p0();
        }
    }
}
