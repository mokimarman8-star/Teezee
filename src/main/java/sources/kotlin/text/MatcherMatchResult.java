package kotlin.text;

import java.util.List;
import java.util.regex.Matcher;
import kotlin.collections.AbstractList;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import okhttp3.HttpUrl;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
final class MatcherMatchResult implements MatchResult {
    private final Matcher a;
    private final CharSequence b;
    private final MatchGroupCollection c;
    private List d;

    public MatcherMatchResult(Matcher matcher, CharSequence input) {
        Intrinsics.h(matcher, "matcher");
        Intrinsics.h(input, "input");
        this.a = matcher;
        this.b = input;
        this.c = new MatcherMatchResult$groups$1(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final java.util.regex.MatchResult e() {
        return this.a;
    }

    @Override // kotlin.text.MatchResult
    public List a() {
        if (this.d == null) {
            this.d = new AbstractList<String>() { // from class: kotlin.text.MatcherMatchResult$groupValues$1
                @Override // java.util.List, java.util.Collection
                public final /* bridge */ boolean contains(Object obj) {
                    if (obj instanceof String) {
                        return e((String) obj);
                    }
                    return false;
                }

                public /* bridge */ boolean e(String str) {
                    return super.contains(str);
                }

                @Override // kotlin.collections.AbstractList, java.util.List
                /* renamed from: f, reason: merged with bridge method [inline-methods] */
                public String get(int index) {
                    java.util.regex.MatchResult e;
                    e = MatcherMatchResult.this.e();
                    String group = e.group(index);
                    return group == null ? HttpUrl.FRAGMENT_ENCODE_SET : group;
                }

                public int getSize() {
                    java.util.regex.MatchResult e;
                    e = MatcherMatchResult.this.e();
                    return e.groupCount() + 1;
                }

                public /* bridge */ int i(String str) {
                    return super.indexOf(str);
                }

                @Override // kotlin.collections.AbstractList, java.util.List
                public final /* bridge */ int indexOf(Object obj) {
                    if (obj instanceof String) {
                        return i((String) obj);
                    }
                    return -1;
                }

                public /* bridge */ int j(String str) {
                    return super.lastIndexOf(str);
                }

                @Override // kotlin.collections.AbstractList, java.util.List
                public final /* bridge */ int lastIndexOf(Object obj) {
                    if (obj instanceof String) {
                        return j((String) obj);
                    }
                    return -1;
                }
            };
        }
        List list = this.d;
        Intrinsics.e(list);
        return list;
    }

    @Override // kotlin.text.MatchResult
    public IntRange b() {
        IntRange h;
        h = RegexKt.h(e());
        return h;
    }

    @Override // kotlin.text.MatchResult
    public MatchGroupCollection c() {
        return this.c;
    }

    @Override // kotlin.text.MatchResult
    public MatchResult next() {
        MatchResult f;
        int end = e().end() + (e().end() == e().start() ? 1 : 0);
        if (end > this.b.length()) {
            return null;
        }
        Matcher matcher = this.a.pattern().matcher(this.b);
        Intrinsics.g(matcher, "matcher(...)");
        f = RegexKt.f(matcher, end, this.b);
        return f;
    }
}
