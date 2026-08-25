package f;

import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import f.a;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public class c extends f.a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f15184a = new a(null);

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final List a(Intent intent) {
            Intrinsics.h(intent, "<this>");
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            Uri data = intent.getData();
            if (data != null) {
                linkedHashSet.add(data);
            }
            ClipData clipData = intent.getClipData();
            if (clipData == null && linkedHashSet.isEmpty()) {
                return CollectionsKt.l();
            }
            if (clipData != null) {
                int itemCount = clipData.getItemCount();
                for (int i5 = 0; i5 < itemCount; i5++) {
                    Uri uri = clipData.getItemAt(i5).getUri();
                    if (uri != null) {
                        linkedHashSet.add(uri);
                    }
                }
            }
            return new ArrayList(linkedHashSet);
        }
    }

    @Override // f.a
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public Intent a(Context context, String str) {
        Intrinsics.h(context, "context");
        Intrinsics.h(str, "input");
        Intent putExtra = new Intent("android.intent.action.GET_CONTENT").addCategory("android.intent.category.OPENABLE").setType(str).putExtra("android.intent.extra.ALLOW_MULTIPLE", true);
        Intrinsics.g(putExtra, "Intent(Intent.ACTION_GET…TRA_ALLOW_MULTIPLE, true)");
        return putExtra;
    }

    @Override // f.a
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public final a.C0141a b(Context context, String str) {
        Intrinsics.h(context, "context");
        Intrinsics.h(str, "input");
        return null;
    }

    @Override // f.a
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public final List c(int i5, Intent intent) {
        List a5;
        if (i5 != -1) {
            intent = null;
        }
        return (intent == null || (a5 = f15184a.a(intent)) == null) ? CollectionsKt.l() : a5;
    }
}
