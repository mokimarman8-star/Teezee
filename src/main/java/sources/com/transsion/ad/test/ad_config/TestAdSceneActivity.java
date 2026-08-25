package com.transsion.ad.test.ad_config;

import android.os.Bundle;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.o;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.transsion.ad.R;
import com.transsion.ad.test.TestBaseActivity;
import com.transsion.gslb.BuildConfig;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.i;
import sh.v;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0010B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0006\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0014¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\r\u0010\u000eR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0013"}, d2 = {"Lcom/transsion/ad/test/ad_config/TestAdSceneActivity;", "Lcom/transsion/ad/test/TestBaseActivity;", "<init>", "()V", BuildConfig.FLAVOR, "json", "Q", "(Ljava/lang/String;)Ljava/lang/String;", "Landroid/os/Bundle;", "savedInstanceState", BuildConfig.FLAVOR, "onCreate", "(Landroid/os/Bundle;)V", "getLogTag", "()Ljava/lang/String;", "Lsh/v;", "a", "Lsh/v;", "binding", "lib_ad_gpRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class TestAdSceneActivity extends TestBaseActivity {

    /* renamed from: a, reason: from kotlin metadata */
    private v binding;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J!\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002H\u0014¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/transsion/ad/test/ad_config/TestAdSceneActivity$a;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/google/gson/JsonObject;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "<init>", "()V", "holder", "item", BuildConfig.FLAVOR, "B1", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;Lcom/google/gson/JsonObject;)V", "lib_ad_gpRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class a extends BaseQuickAdapter {
        public a() {
            super(R.layout.test_item_ad_plan_layout, (List) null, 2, (DefaultConstructorMarker) null);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: B1, reason: merged with bridge method [inline-methods] */
        public void F(BaseViewHolder holder, JsonObject item) {
            String str;
            Intrinsics.h(holder, "holder");
            if (item == null || (str = new GsonBuilder().setPrettyPrinting().create().toJson(item)) == null) {
                str = BuildConfig.FLAVOR;
            }
            holder.setText(R.id.tvConfig, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String Q(String json) {
        Gson create = new GsonBuilder().setPrettyPrinting().create();
        try {
            String json2 = create.toJson(create.fromJson(json, Object.class));
            Intrinsics.g(json2, "toJson(...)");
            return json2;
        } catch (Exception e) {
            e.printStackTrace();
            return "Invalid JSON String";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R(TestAdSceneActivity testAdSceneActivity, View view) {
        i.d(androidx.lifecycle.v.a(testAdSceneActivity), (CoroutineContext) null, (CoroutineStart) null, new TestAdSceneActivity$onCreate$1$1(testAdSceneActivity, null), 3, (Object) null);
    }

    @Override // xh.b
    public String getLogTag() {
        return "ad_";
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onCreate(Bundle savedInstanceState) {
        super/*androidx.fragment.app.FragmentActivity*/.onCreate(savedInstanceState);
        v c = v.c(getLayoutInflater());
        this.binding = c;
        if (c == null) {
            Intrinsics.y("binding");
            c = null;
        }
        setContentView(c.b());
        v vVar = this.binding;
        if (vVar == null) {
            Intrinsics.y("binding");
            vVar = null;
        }
        vVar.b.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.ad.test.ad_config.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TestAdSceneActivity.R(TestAdSceneActivity.this, view);
            }
        });
        com.transsion.ad.scene.d dVar = com.transsion.ad.scene.d.a;
        String str = "版本号 " + dVar.d();
        v vVar2 = this.binding;
        if (vVar2 == null) {
            Intrinsics.y("binding");
            vVar2 = null;
        }
        vVar2.d.setText(str);
        a aVar = new a();
        v vVar3 = this.binding;
        if (vVar3 == null) {
            Intrinsics.y("binding");
            vVar3 = null;
        }
        RecyclerView recyclerView = vVar3.c;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(aVar);
        JsonArray<JsonElement> jsonArray = (JsonArray) o.d(dVar.c(), JsonArray.class);
        ArrayList arrayList = new ArrayList();
        if (jsonArray != null) {
            for (JsonElement jsonElement : jsonArray) {
                arrayList.add(jsonElement != null ? jsonElement.getAsJsonObject() : null);
            }
        }
        aVar.n1(arrayList);
    }
}
