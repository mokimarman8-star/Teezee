package mq;

import android.app.Application;
import android.text.TextUtils;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.b0;
import com.google.gson.JsonObject;
import com.transsion.share.bean.ShareBean;
import com.transsion.share.bean.ShareType;
import dg.d;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.MediaType;
import okhttp3.RequestBody;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class b extends androidx.lifecycle.b {
    private final String b;
    private final b0 c;
    private final b0 d;
    private final Lazy e;

    public static final class a extends dg.a {
        final /* synthetic */ ShareType e;

        a(ShareType shareType) {
            this.e = shareType;
        }

        public void a(String str, String str2) {
            b.this.c.q((Object) null);
        }

        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public void c(ShareBean shareBean) {
            if (shareBean != null) {
                shareBean.setShareType(this.e);
            }
            b.this.c.q(shareBean);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(Application application) {
        super(application);
        Intrinsics.h(application, "application");
        this.b = "ActionViewModel";
        this.c = new b0();
        this.d = new b0();
        this.e = LazyKt.b(new Function0() { // from class: mq.a
            public final Object invoke() {
                c e;
                e = b.e();
                return e;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final c e() {
        return (c) kg.c.e.a().h(c.class);
    }

    private final c f() {
        return (c) this.e.getValue();
    }

    public final LiveData g() {
        return this.c;
    }

    public final void h(ShareType shareType, String str, String str2, String str3, String str4) {
        Intrinsics.h(shareType, "shareType");
        Intrinsics.h(str, "postType");
        Intrinsics.h(str2, "subjectId");
        Intrinsics.h(str3, "uid");
        Intrinsics.h(str4, "scene");
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("uid", str3);
        jsonObject.addProperty("type", str);
        jsonObject.addProperty("scene", str4);
        jsonObject.addProperty("id", str2);
        RequestBody.Companion companion = RequestBody.Companion;
        String jsonElement = jsonObject.toString();
        Intrinsics.g(jsonElement, "toString(...)");
        f().a(gg.a.a.a(), companion.create(jsonElement, MediaType.Companion.parse("application/json"))).f(d.a.c()).subscribe(new a(shareType));
    }
}
