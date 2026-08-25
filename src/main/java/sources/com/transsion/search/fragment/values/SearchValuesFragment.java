package com.transsion.search.fragment.values;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.lifecycle.b0;
import androidx.lifecycle.c0;
import com.google.gson.JsonObject;
import com.transsion.baselib.helper.a;
import com.transsion.baseui.R;
import com.transsion.baseui.fragment.PageStatusFragment;
import com.transsion.baseui.widget.ResourcesRequestView;
import com.transsion.gslb.BuildConfig;
import com.transsion.publish.model.PostEntity;
import com.transsion.push.notification.permission.NoticePermissionFrom;
import com.transsion.search.R$id;
import com.transsion.search.R$layout;
import com.transsion.search.R$string;
import com.transsion.search.fragment.SearchSubjectFragment;
import com.transsion.search.fragment.values.SearchValuesFragment;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import jj.g;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import vo.e;
import vp.k;
import wf.a;
import yg.l;

@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 Q2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001-B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J!\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u0011\u001a\u00020\t2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0014\u0010\u0012J\u000f\u0010\u0015\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0017\u0010\u0016J\u000f\u0010\u0018\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0018\u0010\u0016J\u0017\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\tH\u0016¢\u0006\u0004\b\u001f\u0010\u0004J\u000f\u0010 \u001a\u00020\tH\u0016¢\u0006\u0004\b \u0010\u0004J\u000f\u0010!\u001a\u00020\tH\u0016¢\u0006\u0004\b!\u0010\u0004J\u000f\u0010\"\u001a\u00020\tH\u0016¢\u0006\u0004\b\"\u0010\u0004J\u000f\u0010#\u001a\u00020\u0005H\u0016¢\u0006\u0004\b#\u0010\u001eJ\u0017\u0010%\u001a\u00020\f2\u0006\u0010$\u001a\u00020\u0007H\u0016¢\u0006\u0004\b%\u0010&J\r\u0010'\u001a\u00020\u0005¢\u0006\u0004\b'\u0010\u001eJ\u000f\u0010)\u001a\u00020(H\u0016¢\u0006\u0004\b)\u0010*R\u001e\u0010/\u001a\n\u0012\u0004\u0012\u00020,\u0018\u00010+8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00102\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u00101R\u0018\u00104\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b3\u00101R\u0016\u00108\u001a\u0002058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u00107R\u001a\u0010<\u001a\b\u0012\u0004\u0012\u00020:098\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b;\u0010.R\u0018\u0010?\u001a\u0004\u0018\u0001058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b=\u0010>R\u0018\u0010C\u001a\u0004\u0018\u00010@8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bA\u0010BR\u001b\u0010I\u001a\u00020D8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bE\u0010F\u001a\u0004\bG\u0010HR\u001f\u0010P\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010K0J8\u0006¢\u0006\f\n\u0004\bL\u0010M\u001a\u0004\bN\u0010O¨\u0006R"}, d2 = {"Lcom/transsion/search/fragment/values/SearchValuesFragment;", "Lcom/transsion/baseui/fragment/PageStatusFragment;", "Lvp/k;", "<init>", "()V", BuildConfig.FLAVOR, "keyword", BuildConfig.FLAVOR, "before", BuildConfig.FLAVOR, "w0", "(Ljava/lang/String;Z)V", "Landroid/view/View;", "t0", "()Landroid/view/View;", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "outState", "onSaveInstanceState", "isShowPageStateLayoutTitle", "()Z", "isAudioShowNoNetworkLayout", "isMonitorNetworkState", "Landroid/view/LayoutInflater;", "inflater", "r0", "(Landroid/view/LayoutInflater;)Lvp/k;", "getPageStateLayoutTitle", "()Ljava/lang/String;", "initViewData", "initViewModel", "initListener", "retryLoadData", "getEmptyDescText", "isShowTitleLayout", "getEmptyView", "(Z)Landroid/view/View;", "o0", "Lqi/b;", "newLogViewConfig", "()Lqi/b;", BuildConfig.FLAVOR, "Lcom/transsion/search/bean/VerticalRank;", "a", "Ljava/util/List;", "mVerticalRanks", "b", "Ljava/lang/String;", "mKeyWord", "c", "mCopyKeyWord", BuildConfig.FLAVOR, "d", "I", "mType", BuildConfig.FLAVOR, "Lcom/transsion/search/bean/SearchValuesRelatedCollectionEntity;", "e", "collectionList", "f", "Ljava/lang/Integer;", "count", "Lcom/transsion/baseui/widget/ResourcesRequestView;", "g", "Lcom/transsion/baseui/widget/ResourcesRequestView;", "requestView", "Lcq/a;", "h", "Lkotlin/Lazy;", "q0", "()Lcq/a;", "service", "Landroidx/lifecycle/b0;", "Lcom/transsion/publish/model/PostEntity;", "i", "Landroidx/lifecycle/b0;", "p0", "()Landroidx/lifecycle/b0;", "postRequestResult", "j", "Search_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class SearchValuesFragment extends PageStatusFragment<k> {

    /* renamed from: j, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static String k = BuildConfig.FLAVOR;

    /* renamed from: a, reason: from kotlin metadata */
    private List mVerticalRanks;

    /* renamed from: f, reason: from kotlin metadata */
    private Integer count;

    /* renamed from: g, reason: from kotlin metadata */
    private ResourcesRequestView requestView;

    /* renamed from: b, reason: from kotlin metadata */
    private String mKeyWord = BuildConfig.FLAVOR;

    /* renamed from: c, reason: from kotlin metadata */
    private String mCopyKeyWord = BuildConfig.FLAVOR;

    /* renamed from: d, reason: from kotlin metadata */
    private int mType = 1;

    /* renamed from: e, reason: from kotlin metadata */
    private final List collectionList = new ArrayList();

    /* renamed from: h, reason: from kotlin metadata */
    private final Lazy service = LazyKt.b(new Function0() { // from class: bq.c
        public final Object invoke() {
            cq.a y0;
            y0 = SearchValuesFragment.y0();
            return y0;
        }
    });

    /* renamed from: i, reason: from kotlin metadata */
    private final b0 postRequestResult = new b0();

    /* renamed from: com.transsion.search.fragment.values.SearchValuesFragment$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String a() {
            return SearchValuesFragment.k;
        }

        public final void b(String str, String str2, String str3, String str4, int i, int i2, String str5, String str6) {
            HashMap hashMap = new HashMap();
            if (str2 == null) {
                str2 = BuildConfig.FLAVOR;
            }
            hashMap.put("subject_id", str2);
            if (str == null) {
                str = BuildConfig.FLAVOR;
            }
            hashMap.put("group_id", str);
            hashMap.put("sequence", String.valueOf(i));
            if (str4 == null) {
                str4 = BuildConfig.FLAVOR;
            }
            hashMap.put("ops", str4);
            if (str3 == null) {
                str3 = BuildConfig.FLAVOR;
            }
            hashMap.put("staff_id", str3);
            hashMap.put("type", String.valueOf(i2));
            if (str5 != null && str5.length() > 0) {
                hashMap.put("trid", str5);
            }
            if (str6 != null && str6.length() > 0) {
                hashMap.put("season", str6.toString());
            }
            a.a.f("searchresult", hashMap);
        }

        public final void d(String str, String str2, String str3, String str4, int i, int i2) {
            HashMap hashMap = new HashMap();
            if (str2 == null) {
                str2 = BuildConfig.FLAVOR;
            }
            hashMap.put("subject_id", str2);
            if (str == null) {
                str = BuildConfig.FLAVOR;
            }
            hashMap.put("group_id", str);
            hashMap.put("sequence", String.valueOf(i));
            if (str4 == null) {
                str4 = BuildConfig.FLAVOR;
            }
            hashMap.put("ops", str4);
            if (str3 == null) {
                str3 = BuildConfig.FLAVOR;
            }
            hashMap.put("staff_id", str3);
            hashMap.put("type", String.valueOf(i2));
            if (a().length() > 0) {
                hashMap.put("trid", a());
            }
            a.a.a("searchresult", hashMap);
        }
    }

    public static final class b extends dg.a {
        b() {
        }

        public void a(String str, String str2) {
            a.a.l(wf.a.a, "search", "SearchValuesFragment --> postRequestResource --> failed to post request resources " + str2, false, 4, (Object) null);
            SearchValuesFragment.this.getPostRequestResult().n((Object) null);
        }

        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public void c(PostEntity postEntity) {
            if (postEntity != null) {
                SearchValuesFragment.this.getPostRequestResult().n(postEntity);
            }
        }
    }

    static final class c implements c0, FunctionAdapter {
        private final /* synthetic */ Function1 a;

        c(Function1 function1) {
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

    private final cq.a q0() {
        return (cq.a) this.service.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit s0(SearchValuesFragment searchValuesFragment, PostEntity postEntity) {
        a.a aVar = wf.a.a;
        a.a.g(aVar, "Post request succeed " + postEntity + ", " + (postEntity != null ? postEntity.getCount() : null), false, 2, (Object) null);
        if (postEntity != null && searchValuesFragment.count == null) {
            a.a.g(aVar, "count changed " + postEntity.getCount(), false, 2, (Object) null);
            int count = postEntity.getCount();
            if (count == null) {
                count = 0;
            }
            searchValuesFragment.count = count;
            ResourcesRequestView resourcesRequestView = searchValuesFragment.requestView;
            if (resourcesRequestView != null) {
                Integer count2 = postEntity.getCount();
                resourcesRequestView.setCount(count2 != null ? count2.intValue() : 0, false);
            }
        }
        return Unit.a;
    }

    private final View t0() {
        String str;
        AppCompatTextView appCompatTextView;
        if (!l.a.e()) {
            View inflate = getLayoutInflater().inflate(R$layout.view_search_no_network, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(R$id.tv_empty_tips);
            ImageView imageView = (ImageView) inflate.findViewById(R$id.iv_tips);
            AppCompatTextView findViewById = inflate.findViewById(R$id.tv_retry);
            textView.setText(R.string.base_net_err);
            imageView.setImageResource(com.tn.lib.widget.R.mipmap.ic_no_network);
            findViewById.setVisibility(0);
            findViewById.setOnClickListener(new View.OnClickListener() { // from class: bq.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SearchValuesFragment.v0(SearchValuesFragment.this, view);
                }
            });
            Intrinsics.e(inflate);
            return inflate;
        }
        View inflate2 = getLayoutInflater().inflate(R$layout.view_search_empty, (ViewGroup) null);
        final ResourcesRequestView resourcesRequestView = (ResourcesRequestView) inflate2.findViewById(R$id.resources_request);
        this.requestView = resourcesRequestView;
        if (this.mKeyWord.length() > 10) {
            String substring = this.mKeyWord.substring(0, 10);
            Intrinsics.g(substring, "substring(...)");
            str = substring + "...";
        } else {
            str = this.mKeyWord;
        }
        String string = getString(R$string.search_value_no_result, new Object[]{str});
        Intrinsics.g(string, "getString(...)");
        resourcesRequestView.set(string);
        resourcesRequestView.setGray(true);
        w0(this.mKeyWord, true);
        g mViewBinding = resourcesRequestView.getMViewBinding();
        if (mViewBinding != null && (appCompatTextView = mViewBinding.e) != null) {
            appCompatTextView.setOnClickListener(new View.OnClickListener() { // from class: bq.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SearchValuesFragment.u0(SearchValuesFragment.this, resourcesRequestView, view);
                }
            });
        }
        Intrinsics.e(inflate2);
        return inflate2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u0(SearchValuesFragment searchValuesFragment, ResourcesRequestView resourcesRequestView, View view) {
        e.a.e(searchValuesFragment, NoticePermissionFrom.DETAIL_NO_RES);
        x0(searchValuesFragment, searchValuesFragment.mKeyWord, false, 2, null);
        Integer num = searchValuesFragment.count;
        if (num != null) {
            Intrinsics.e(num);
            Integer valueOf = Integer.valueOf(num.intValue() + 1);
            searchValuesFragment.count = valueOf;
            Intrinsics.e(valueOf);
            ResourcesRequestView.setCount$default(resourcesRequestView, valueOf.intValue(), false, 2, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v0(SearchValuesFragment searchValuesFragment, View view) {
        searchValuesFragment.retryLoadData();
    }

    private final void w0(String keyword, boolean before) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("q", keyword);
        jsonObject.addProperty("before", Boolean.valueOf(before));
        this.count = before ? null : this.count;
        RequestBody.Companion companion = RequestBody.Companion;
        String jsonElement = jsonObject.toString();
        Intrinsics.g(jsonElement, "toString(...)");
        q0().f(gg.a.a.a(), companion.create(jsonElement, MediaType.Companion.parse("application/json"))).E(ey.a.c()).subscribe(new b());
    }

    static /* synthetic */ void x0(SearchValuesFragment searchValuesFragment, String str, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        searchValuesFragment.w0(str, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final cq.a y0() {
        return (cq.a) kg.c.e.a().h(cq.a.class);
    }

    public String getEmptyDescText() {
        Context context = getContext();
        return (context != null ? context.getString(R$string.user_works_empty) : null) + " \"" + this.mKeyWord + "\"";
    }

    public View getEmptyView(boolean isShowTitleLayout) {
        return t0();
    }

    public String getPageStateLayoutTitle() {
        return BuildConfig.FLAVOR;
    }

    public void initListener() {
        this.postRequestResult.j(this, new c(new Function1() { // from class: bq.d
            public final Object invoke(Object obj) {
                Unit s0;
                s0 = SearchValuesFragment.s0(SearchValuesFragment.this, (PostEntity) obj);
                return s0;
            }
        }));
    }

    public void initViewData() {
    }

    public void initViewModel() {
    }

    public boolean isAudioShowNoNetworkLayout() {
        return false;
    }

    public boolean isMonitorNetworkState() {
        return true;
    }

    public boolean isShowPageStateLayoutTitle() {
        return false;
    }

    public qi.b newLogViewConfig() {
        return new qi.b("searchresult", false, 2, null);
    }

    public final String o0() {
        String string = up.c.a.b().getString("mCopyKeyWord", BuildConfig.FLAVOR);
        return string == null ? BuildConfig.FLAVOR : string;
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            this.mCopyKeyWord = savedInstanceState.getString("mCopyKeyWord");
        }
    }

    public void onSaveInstanceState(Bundle outState) {
        Intrinsics.h(outState, "outState");
        super/*androidx.fragment.app.Fragment*/.onSaveInstanceState(outState);
        if (this.mKeyWord.length() < 30) {
            outState.putString("mCopyKeyWord", this.mKeyWord);
        }
    }

    /* renamed from: p0, reason: from getter */
    public final b0 getPostRequestResult() {
        return this.postRequestResult;
    }

    /* renamed from: r0, reason: merged with bridge method [inline-methods] */
    public k getViewBinding(LayoutInflater inflater) {
        Intrinsics.h(inflater, "inflater");
        k c2 = k.c(inflater);
        Intrinsics.g(c2, "inflate(...)");
        return c2;
    }

    public void retryLoadData() {
        if (this.mVerticalRanks == null) {
            SearchSubjectFragment parentFragment = getParentFragment();
            SearchSubjectFragment searchSubjectFragment = parentFragment instanceof SearchSubjectFragment ? parentFragment : null;
            if (searchSubjectFragment != null) {
                searchSubjectFragment.B0(BuildConfig.FLAVOR);
            }
        }
    }
}
