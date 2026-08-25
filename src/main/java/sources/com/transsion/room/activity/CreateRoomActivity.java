package com.transsion.room.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import androidx.activity.result.ActivityResult;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.core.widget.NestedScrollView;
import androidx.lifecycle.c0;
import com.blankj.utilcode.util.ThreadUtils;
import com.blankj.utilcode.util.a0;
import com.google.android.material.imageview.ShapeableImageView;
import com.therouter.TheRouter;
import com.therouter.router.Navigator;
import com.tn.lib.widget.R;
import com.tn.lib.widget.toast.core.h;
import com.transsion.baseui.activity.BaseActivity;
import com.transsion.flow.bean.RoomItem;
import com.transsion.flow.bean.RoomNet;
import com.transsion.gslb.BuildConfig;
import com.transsion.room.R$drawable;
import com.transsion.room.R$string;
import com.transsion.room.activity.CreateRoomActivity;
import com.transsion.room.bean.CheckNameBean;
import com.transsion.upload.bean.UploadFileType;
import com.transsion.upload.bean.UploadTstTokenStorageType;
import f.j;
import fp.a;
import ij.y;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import ni.f;
import wf.a;
import yg.l;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0013\u0018\u0000 M2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001eB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0004J\u0017\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u000b\u0010\u0004J\u000f\u0010\f\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\f\u0010\u0004J\u0017\u0010\u000e\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u000e\u0010\nJ\u000f\u0010\u000f\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u000f\u0010\u0004J\u000f\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0013\u0010\u0012J\u0019\u0010\u0016\u001a\u00020\u00052\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001b\u001a\u00020\u001aH\u0016¢\u0006\u0004\b\u001b\u0010\u001cR\u0014\u0010 \u001a\u00020\u001d8\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0014\u0010\"\u001a\u00020\u001d8\u0002X\u0082D¢\u0006\u0006\n\u0004\b!\u0010\u001fR\u0016\u0010%\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010$R\u001e\u0010*\u001a\n\u0012\u0004\u0012\u00020'\u0018\u00010&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010)R\u001d\u00100\u001a\u0004\u0018\u00010+8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/R\u001b\u00105\u001a\u0002018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b2\u0010-\u001a\u0004\b3\u00104R\u0018\u00108\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u00107R\u0018\u0010:\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b9\u00107R\u0018\u0010>\u001a\u0004\u0018\u00010;8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b<\u0010=R\u0018\u0010A\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b?\u0010@R\u0018\u0010C\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bB\u00107R$\u0010H\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bD\u00107\u001a\u0004\bE\u0010F\"\u0004\bG\u0010\nR$\u0010L\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bI\u00107\u001a\u0004\bJ\u0010F\"\u0004\bK\u0010\n¨\u0006N"}, d2 = {"Lcom/transsion/room/activity/CreateRoomActivity;", "Lcom/transsion/baseui/activity/BaseActivity;", "Lfp/a;", "<init>", "()V", BuildConfig.FLAVOR, "u0", BuildConfig.FLAVOR, "groupId", "t0", "(Ljava/lang/String;)V", "initView", "n0", "path", "C0", "p0", BuildConfig.FLAVOR, "isTranslucent", "()Z", "isStatusDark", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "s0", "()Lfp/a;", "Lqi/b;", "newLogViewConfig", "()Lqi/b;", BuildConfig.FLAVOR, "a", "I", "TITLE_MAX", "b", "DESC_MAX", "c", "Z", "nameExist", "Landroidx/activity/result/b;", "Landroid/content/Intent;", "d", "Landroidx/activity/result/b;", "photoLaunch", "Ljo/a;", "e", "Lkotlin/Lazy;", "q0", "()Ljo/a;", "publishApi", "Lcom/transsion/room/viewmodel/d;", "f", "r0", "()Lcom/transsion/room/viewmodel/d;", "roomCreateModel", "g", "Ljava/lang/String;", "avatorUrl", "h", "bucket", "Lcom/transsion/moviedetailapi/bean/RoomItem;", "i", "Lcom/transsion/moviedetailapi/bean/RoomItem;", "roomItem", "j", "Ljava/lang/Boolean;", "FROM_EDIT", "k", "currentGroupId", "l", "getName", "()Ljava/lang/String;", "setName", "name", "m", "getDesc", "setDesc", "desc", "n", "Room_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class CreateRoomActivity extends BaseActivity<a> {
    private static final String o = "field_from";

    /* renamed from: c, reason: from kotlin metadata */
    private boolean nameExist;

    /* renamed from: d, reason: from kotlin metadata */
    private androidx.activity.result.b photoLaunch;

    /* renamed from: i, reason: from kotlin metadata */
    private RoomItem roomItem;

    /* renamed from: k, reason: from kotlin metadata */
    private String currentGroupId;

    /* renamed from: l, reason: from kotlin metadata */
    private String name;

    /* renamed from: m, reason: from kotlin metadata */
    private String desc;

    /* renamed from: a, reason: from kotlin metadata */
    private final int TITLE_MAX = 50;

    /* renamed from: b, reason: from kotlin metadata */
    private final int DESC_MAX = 1000;

    /* renamed from: e, reason: from kotlin metadata */
    private final Lazy publishApi = LazyKt.b(new Function0() { // from class: dp.a
        public final Object invoke() {
            jo.a A0;
            A0 = CreateRoomActivity.A0();
            return A0;
        }
    });

    /* renamed from: f, reason: from kotlin metadata */
    private final Lazy roomCreateModel = LazyKt.b(new Function0() { // from class: dp.b
        public final Object invoke() {
            com.transsion.room.viewmodel.d B0;
            B0 = CreateRoomActivity.B0();
            return B0;
        }
    });

    /* renamed from: g, reason: from kotlin metadata */
    private String avatorUrl = BuildConfig.FLAVOR;

    /* renamed from: h, reason: from kotlin metadata */
    private String bucket = BuildConfig.FLAVOR;

    /* renamed from: j, reason: from kotlin metadata */
    private Boolean FROM_EDIT = Boolean.FALSE;

    public static final class b implements TextWatcher {
        b() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            CreateRoomActivity.this.n0();
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    public static final class c implements TextWatcher {
        c() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Integer valueOf = editable != null ? Integer.valueOf(editable.length()) : null;
            if (valueOf == null || valueOf.intValue() < CreateRoomActivity.this.DESC_MAX) {
                return;
            }
            h.a.l(CreateRoomActivity.this.getString(R$string.str_community_desc_limit));
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    static final class d implements c0, FunctionAdapter {
        private final /* synthetic */ Function1 a;

        d(Function1 function1) {
            Intrinsics.h(function1, "function");
            this.a = function1;
        }

        public final Function a() {
            return this.a;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof c0) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.c(a(), ((FunctionAdapter) obj).a());
            }
            return false;
        }

        public final int hashCode() {
            return a().hashCode();
        }

        public final /* synthetic */ void onChanged(Object obj) {
            this.a.invoke(obj);
        }
    }

    public static final class e implements uu.a {
        e() {
        }

        public void a(String str, long j, long j2) {
            Intrinsics.h(str, "localFilePath");
        }

        public void b(String str, String str2, String str3) {
            Intrinsics.h(str, "localFilePath");
            Intrinsics.h(str2, "url");
            Intrinsics.h(str3, "bucket");
            CreateRoomActivity.this.avatorUrl = str2;
            CreateRoomActivity.this.bucket = str3;
            CreateRoomActivity.this.n0();
        }

        public void c(String str, String str2, String str3, UploadTstTokenStorageType uploadTstTokenStorageType) {
            a.a.g(wf.a.a, "uploadKey: " + str + "; clientMessage:" + str2 + "; serviceMessage: " + str3, false, 2, (Object) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final jo.a A0() {
        return (jo.a) TheRouter.d(jo.a.class, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final com.transsion.room.viewmodel.d B0() {
        return new com.transsion.room.viewmodel.d();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void C0(String path) {
        f.b c2 = f.a.m(this).g(path).i(R$drawable.ic_avatar_default).m(a0.a(96.0f)).c(a0.a(96.0f));
        ShapeableImageView shapeableImageView = ((fp.a) getMViewBinding()).d;
        Intrinsics.g(shapeableImageView, "ivAvatar");
        c2.d(shapeableImageView);
        uu.c.a.f(path, UploadFileType.OBJECT_NAME_IMAGE, true, new e());
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void initView() {
        String avatar;
        Bundle extras = getIntent().getExtras();
        RoomItem roomItem = extras != null ? (RoomItem) extras.getParcelable("field_key") : null;
        this.roomItem = roomItem;
        this.currentGroupId = roomItem != null ? roomItem.getGroupId() : null;
        RoomItem roomItem2 = this.roomItem;
        if (roomItem2 != null && (avatar = roomItem2.getAvatar()) != null) {
            f.b c2 = f.a.m(this).g(avatar).i(R$drawable.ic_avatar_default).m(a0.a(96.0f)).c(a0.a(96.0f));
            ShapeableImageView shapeableImageView = ((fp.a) getMViewBinding()).d;
            Intrinsics.g(shapeableImageView, "ivAvatar");
            c2.d(shapeableImageView);
            this.avatorUrl = avatar;
        }
        AppCompatEditText appCompatEditText = ((fp.a) getMViewBinding()).c;
        RoomItem roomItem3 = this.roomItem;
        appCompatEditText.setText(roomItem3 != null ? roomItem3.getName() : null);
        AppCompatEditText appCompatEditText2 = ((fp.a) getMViewBinding()).b;
        RoomItem roomItem4 = this.roomItem;
        appCompatEditText2.setText(roomItem4 != null ? roomItem4.getDescription() : null);
        if (this.roomItem != null) {
            this.FROM_EDIT = Boolean.TRUE;
            ((fp.a) getMViewBinding()).f.setEnabled(true);
        }
        this.photoLaunch = registerForActivityResult(new j(), new androidx.activity.result.a() { // from class: dp.e
            public final void a(Object obj) {
                CreateRoomActivity.y0(CreateRoomActivity.this, (ActivityResult) obj);
            }
        });
        ((fp.a) getMViewBinding()).d.setOnClickListener(new View.OnClickListener() { // from class: dp.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CreateRoomActivity.z0(CreateRoomActivity.this, view);
            }
        });
        ((fp.a) getMViewBinding()).c.setFilters(new InputFilter[]{new InputFilter.LengthFilter(this.TITLE_MAX)});
        ((fp.a) getMViewBinding()).b.setFilters(new InputFilter[]{new InputFilter.LengthFilter(this.DESC_MAX)});
        ((fp.a) getMViewBinding()).c.addTextChangedListener(new b());
        ((fp.a) getMViewBinding()).b.addTextChangedListener(new c());
        ((fp.a) getMViewBinding()).f.setOnClickListener(new View.OnClickListener() { // from class: dp.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CreateRoomActivity.x0(CreateRoomActivity.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n0() {
        ThreadUtils.j(new Runnable() { // from class: dp.h
            @Override // java.lang.Runnable
            public final void run() {
                CreateRoomActivity.o0(CreateRoomActivity.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void o0(CreateRoomActivity createRoomActivity) {
        Editable text = ((fp.a) createRoomActivity.getMViewBinding()).c.getText();
        int length = String.valueOf(text != null ? StringsKt.n1(text) : null).length();
        if (length <= 0 || TextUtils.isEmpty(createRoomActivity.avatorUrl)) {
            ((fp.a) createRoomActivity.getMViewBinding()).f.setEnabled(false);
            return;
        }
        ((fp.a) createRoomActivity.getMViewBinding()).f.setEnabled(true);
        if (length >= createRoomActivity.TITLE_MAX) {
            h.a.l(createRoomActivity.getString(R$string.str_community_title_limit));
        }
    }

    private final void p0() {
        boolean c2 = Intrinsics.c(this.FROM_EDIT, Boolean.TRUE);
        String str = BuildConfig.FLAVOR;
        if (!c2) {
            String str2 = this.name;
            if (str2 != null) {
                com.transsion.room.viewmodel.d r0 = r0();
                String valueOf = String.valueOf(this.avatorUrl);
                String str3 = this.desc;
                if (str3 != null) {
                    str = str3;
                }
                r0.g(str2, valueOf, str, this.bucket);
                return;
            }
            return;
        }
        RoomItem roomItem = this.roomItem;
        String groupId = roomItem != null ? roomItem.getGroupId() : null;
        this.currentGroupId = groupId;
        String str4 = this.name;
        if (str4 == null || groupId == null) {
            return;
        }
        com.transsion.room.viewmodel.d r02 = r0();
        String valueOf2 = String.valueOf(this.avatorUrl);
        String str5 = this.desc;
        r02.o(groupId, str4, valueOf2, str5 == null ? BuildConfig.FLAVOR : str5, this.bucket);
    }

    private final jo.a q0() {
        return (jo.a) this.publishApi.getValue();
    }

    private final com.transsion.room.viewmodel.d r0() {
        return (com.transsion.room.viewmodel.d) this.roomCreateModel.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void t0(String groupId) {
        Navigator.x(TheRouter.c("/room/detail").K("id", groupId), this, (mf.c) null, 2, (Object) null);
    }

    private final void u0() {
        r0().j().j(this, new d(new Function1() { // from class: dp.c
            public final Object invoke(Object obj) {
                Unit v0;
                v0 = CreateRoomActivity.v0(CreateRoomActivity.this, (RoomNet) obj);
                return v0;
            }
        }));
        r0().h().j(this, new d(new Function1() { // from class: dp.d
            public final Object invoke(Object obj) {
                Unit w0;
                w0 = CreateRoomActivity.w0(CreateRoomActivity.this, (CheckNameBean) obj);
                return w0;
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit v0(CreateRoomActivity createRoomActivity, RoomNet roomNet) {
        if (roomNet != null) {
            qi.b logViewConfig = createRoomActivity.getLogViewConfig();
            if (logViewConfig != null) {
                logViewConfig.k(true);
            }
            if (Intrinsics.c(roomNet.getGroupId(), "update")) {
                createRoomActivity.setResult(-1);
                createRoomActivity.finish();
            } else {
                String groupId = roomNet.getGroupId();
                if (groupId != null) {
                    createRoomActivity.t0(groupId);
                    createRoomActivity.setResult(-1);
                    createRoomActivity.finish();
                }
            }
        }
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit w0(CreateRoomActivity createRoomActivity, CheckNameBean checkNameBean) {
        if (checkNameBean != null) {
            boolean isExist = checkNameBean.isExist();
            createRoomActivity.nameExist = isExist;
            if (!isExist || TextUtils.equals(checkNameBean.getGroupId(), createRoomActivity.currentGroupId)) {
                createRoomActivity.p0();
            } else {
                fh.b.a.e(createRoomActivity.getString(R$string.str_rooms_duplicate));
            }
        }
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void x0(CreateRoomActivity createRoomActivity, View view) {
        if (!com.transsion.baseui.util.c.a.a(view.getId(), 2000L) && ((fp.a) createRoomActivity.getMViewBinding()).f.isEnabled()) {
            Editable text = ((fp.a) createRoomActivity.getMViewBinding()).c.getText();
            createRoomActivity.name = String.valueOf(text != null ? StringsKt.n1(text) : null);
            Editable text2 = ((fp.a) createRoomActivity.getMViewBinding()).b.getText();
            createRoomActivity.desc = String.valueOf(text2 != null ? StringsKt.n1(text2) : null);
            if (!l.a.e()) {
                h.a.l(createRoomActivity.getString(R.string.no_network_toast));
                return;
            }
            String str = createRoomActivity.name;
            if (str != null) {
                createRoomActivity.r0().e(str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y0(CreateRoomActivity createRoomActivity, ActivityResult activityResult) {
        Intrinsics.h(activityResult, "it");
        if (activityResult.getResultCode() != -1) {
            a.a.f(wf.a.a, "photoLaunch", "fail", false, 4, (Object) null);
            return;
        }
        Intent data = activityResult.getData();
        String stringExtra = data != null ? data.getStringExtra("clip_result") : null;
        a.a.f(wf.a.a, "photoLaunch", "result:" + stringExtra, false, 4, (Object) null);
        if (stringExtra != null) {
            createRoomActivity.C0(stringExtra);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void z0(CreateRoomActivity createRoomActivity, View view) {
        Intent h;
        androidx.activity.result.b bVar;
        jo.a q0 = createRoomActivity.q0();
        if (q0 == null || (h = q0.h(createRoomActivity)) == null || (bVar = createRoomActivity.photoLaunch) == null) {
            return;
        }
        bVar.a(h);
    }

    public boolean isStatusDark() {
        return !y.a.a();
    }

    public boolean isTranslucent() {
        return true;
    }

    public qi.b newLogViewConfig() {
        return new qi.b("createaroom", false, 2, null);
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        NestedScrollView root = ((fp.a) getMViewBinding()).getRoot();
        Intrinsics.g(root, "getRoot(...)");
        uf.c.e(root);
        initView();
        u0();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: s0, reason: merged with bridge method [inline-methods] */
    public fp.a getViewBinding() {
        fp.a c2 = fp.a.c(getLayoutInflater());
        Intrinsics.g(c2, "inflate(...)");
        return c2;
    }
}
