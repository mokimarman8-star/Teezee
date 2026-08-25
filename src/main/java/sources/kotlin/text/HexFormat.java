package kotlin.text;

import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.ExperimentalStdlibApi;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.SinceKotlin;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import okhttp3.HttpUrl;

@SinceKotlin
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0013\b\u0007\u0018\u0000 \u00182\u00020\u0001:\u0004\u0019\u001a\u001b\u001cB!\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u001d"}, d2 = {"Lkotlin/text/HexFormat;", HttpUrl.FRAGMENT_ENCODE_SET, HttpUrl.FRAGMENT_ENCODE_SET, "upperCase", "Lkotlin/text/HexFormat$BytesHexFormat;", "bytes", "Lkotlin/text/HexFormat$NumberHexFormat;", "number", "<init>", "(ZLkotlin/text/HexFormat$BytesHexFormat;Lkotlin/text/HexFormat$NumberHexFormat;)V", HttpUrl.FRAGMENT_ENCODE_SET, "toString", "()Ljava/lang/String;", "a", "Z", "b", "()Z", "Lkotlin/text/HexFormat$BytesHexFormat;", "getBytes", "()Lkotlin/text/HexFormat$BytesHexFormat;", "c", "Lkotlin/text/HexFormat$NumberHexFormat;", "getNumber", "()Lkotlin/text/HexFormat$NumberHexFormat;", "d", "BytesHexFormat", "NumberHexFormat", "Builder", "Companion", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@ExperimentalStdlibApi
/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class HexFormat {

    /* renamed from: d, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final HexFormat e;
    private static final HexFormat f;

    /* renamed from: a, reason: from kotlin metadata */
    private final boolean upperCase;

    /* renamed from: b, reason: from kotlin metadata */
    private final BytesHexFormat bytes;

    /* renamed from: c, reason: from kotlin metadata */
    private final NumberHexFormat number;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B\t\b\u0001¢\u0006\u0004\b\u0002\u0010\u0003R\"\u0010\u000b\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\f"}, d2 = {"Lkotlin/text/HexFormat$Builder;", HttpUrl.FRAGMENT_ENCODE_SET, "<init>", "()V", HttpUrl.FRAGMENT_ENCODE_SET, "a", "Z", "getUpperCase", "()Z", "setUpperCase", "(Z)V", "upperCase", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
    public static final class Builder {

        /* renamed from: a, reason: from kotlin metadata */
        private boolean upperCase = HexFormat.INSTANCE.a().getUpperCase();

        @PublishedApi
        public Builder() {
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\r\u0018\u0000 (2\u00020\u0001:\u0002)*B9\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\f\u0010\rJ'\u0010\u0012\u001a\u00060\u000ej\u0002`\u000f2\n\u0010\u0010\u001a\u00060\u000ej\u0002`\u000f2\u0006\u0010\u0011\u001a\u00020\u0005H\u0000¢\u0006\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0015\u001a\u0004\b\u0018\u0010\u0017R\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\rR\u0017\u0010\u0007\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001a\u001a\u0004\b\u001c\u0010\rR\u0017\u0010\b\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001a\u001a\u0004\b\u0019\u0010\rR\u0017\u0010\t\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u001a\u001a\u0004\b\u001d\u0010\rR\u001a\u0010\"\u001a\u00020\u001e8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u001f\u001a\u0004\b \u0010!R\u001a\u0010$\u001a\u00020\u001e8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u001f\u001a\u0004\b#\u0010!R\u001a\u0010'\u001a\u00020\u001e8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b%\u0010\u001f\u001a\u0004\b&\u0010!¨\u0006+"}, d2 = {"Lkotlin/text/HexFormat$BytesHexFormat;", HttpUrl.FRAGMENT_ENCODE_SET, HttpUrl.FRAGMENT_ENCODE_SET, "bytesPerLine", "bytesPerGroup", HttpUrl.FRAGMENT_ENCODE_SET, "groupSeparator", "byteSeparator", "bytePrefix", "byteSuffix", "<init>", "(IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "sb", "indent", "b", "(Ljava/lang/StringBuilder;Ljava/lang/String;)Ljava/lang/StringBuilder;", "a", "I", "g", "()I", "f", "c", "Ljava/lang/String;", "h", "d", "e", HttpUrl.FRAGMENT_ENCODE_SET, "Z", "getNoLineAndGroupSeparator$kotlin_stdlib", "()Z", "noLineAndGroupSeparator", "getShortByteSeparatorNoPrefixAndSuffix$kotlin_stdlib", "shortByteSeparatorNoPrefixAndSuffix", "i", "getIgnoreCase$kotlin_stdlib", "ignoreCase", "j", "Builder", "Companion", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
    public static final class BytesHexFormat {

        /* renamed from: j, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final BytesHexFormat k = new BytesHexFormat(Integer.MAX_VALUE, Integer.MAX_VALUE, "  ", HttpUrl.FRAGMENT_ENCODE_SET, HttpUrl.FRAGMENT_ENCODE_SET, HttpUrl.FRAGMENT_ENCODE_SET);

        /* renamed from: a, reason: from kotlin metadata */
        private final int bytesPerLine;

        /* renamed from: b, reason: from kotlin metadata */
        private final int bytesPerGroup;

        /* renamed from: c, reason: from kotlin metadata */
        private final String groupSeparator;

        /* renamed from: d, reason: from kotlin metadata */
        private final String byteSeparator;

        /* renamed from: e, reason: from kotlin metadata */
        private final String bytePrefix;

        /* renamed from: f, reason: from kotlin metadata */
        private final String byteSuffix;

        /* renamed from: g, reason: from kotlin metadata */
        private final boolean noLineAndGroupSeparator;

        /* renamed from: h, reason: from kotlin metadata */
        private final boolean shortByteSeparatorNoPrefixAndSuffix;

        /* renamed from: i, reason: from kotlin metadata */
        private final boolean ignoreCase;

        @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u0014\u0018\u00002\u00020\u0001B\t\b\u0000¢\u0006\u0004\b\u0002\u0010\u0003R*\u0010\f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00048\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR*\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00048\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u0007\u001a\u0004\b\u000e\u0010\t\"\u0004\b\u000f\u0010\u000bR\"\u0010\u0018\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R*\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u0005\u001a\u00020\u00118\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u0013\u001a\u0004\b\u001a\u0010\u0015\"\u0004\b\u001b\u0010\u0017R*\u0010 \u001a\u00020\u00112\u0006\u0010\u0005\u001a\u00020\u00118\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u0013\u001a\u0004\b\u001e\u0010\u0015\"\u0004\b\u001f\u0010\u0017R*\u0010$\u001a\u00020\u00112\u0006\u0010\u0005\u001a\u00020\u00118\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b!\u0010\u0013\u001a\u0004\b\"\u0010\u0015\"\u0004\b#\u0010\u0017¨\u0006%"}, d2 = {"Lkotlin/text/HexFormat$BytesHexFormat$Builder;", HttpUrl.FRAGMENT_ENCODE_SET, "<init>", "()V", HttpUrl.FRAGMENT_ENCODE_SET, "value", "a", "I", "getBytesPerLine", "()I", "setBytesPerLine", "(I)V", "bytesPerLine", "b", "getBytesPerGroup", "setBytesPerGroup", "bytesPerGroup", HttpUrl.FRAGMENT_ENCODE_SET, "c", "Ljava/lang/String;", "getGroupSeparator", "()Ljava/lang/String;", "setGroupSeparator", "(Ljava/lang/String;)V", "groupSeparator", "d", "getByteSeparator", "setByteSeparator", "byteSeparator", "e", "getBytePrefix", "setBytePrefix", "bytePrefix", "f", "getByteSuffix", "setByteSuffix", "byteSuffix", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
        public static final class Builder {

            /* renamed from: a, reason: from kotlin metadata */
            private int bytesPerLine;

            /* renamed from: b, reason: from kotlin metadata */
            private int bytesPerGroup;

            /* renamed from: c, reason: from kotlin metadata */
            private String groupSeparator;

            /* renamed from: d, reason: from kotlin metadata */
            private String byteSeparator;

            /* renamed from: e, reason: from kotlin metadata */
            private String bytePrefix;

            /* renamed from: f, reason: from kotlin metadata */
            private String byteSuffix;

            public Builder() {
                Companion companion = BytesHexFormat.INSTANCE;
                this.bytesPerLine = companion.a().getBytesPerLine();
                this.bytesPerGroup = companion.a().getBytesPerGroup();
                this.groupSeparator = companion.a().getGroupSeparator();
                this.byteSeparator = companion.a().getByteSeparator();
                this.bytePrefix = companion.a().getBytePrefix();
                this.byteSuffix = companion.a().getByteSuffix();
            }
        }

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0005\u001a\u00020\u00048\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lkotlin/text/HexFormat$BytesHexFormat$Companion;", HttpUrl.FRAGMENT_ENCODE_SET, "<init>", "()V", "Lkotlin/text/HexFormat$BytesHexFormat;", "Default", "Lkotlin/text/HexFormat$BytesHexFormat;", "a", "()Lkotlin/text/HexFormat$BytesHexFormat;", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final BytesHexFormat a() {
                return BytesHexFormat.k;
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:19:0x005e, code lost:
        
            if (r4 != false) goto L23;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public BytesHexFormat(int i, int i2, String groupSeparator, String byteSeparator, String bytePrefix, String byteSuffix) {
            boolean b;
            boolean b2;
            boolean b3;
            boolean b4;
            Intrinsics.h(groupSeparator, "groupSeparator");
            Intrinsics.h(byteSeparator, "byteSeparator");
            Intrinsics.h(bytePrefix, "bytePrefix");
            Intrinsics.h(byteSuffix, "byteSuffix");
            this.bytesPerLine = i;
            this.bytesPerGroup = i2;
            this.groupSeparator = groupSeparator;
            this.byteSeparator = byteSeparator;
            this.bytePrefix = bytePrefix;
            this.byteSuffix = byteSuffix;
            boolean z = false;
            this.noLineAndGroupSeparator = i == Integer.MAX_VALUE && i2 == Integer.MAX_VALUE;
            this.shortByteSeparatorNoPrefixAndSuffix = bytePrefix.length() == 0 && byteSuffix.length() == 0 && byteSeparator.length() <= 1;
            b = HexFormatKt.b(groupSeparator);
            if (!b) {
                b2 = HexFormatKt.b(byteSeparator);
                if (!b2) {
                    b3 = HexFormatKt.b(bytePrefix);
                    if (!b3) {
                        b4 = HexFormatKt.b(byteSuffix);
                    }
                }
            }
            z = true;
            this.ignoreCase = z;
        }

        public final StringBuilder b(StringBuilder sb, String indent) {
            Intrinsics.h(sb, "sb");
            Intrinsics.h(indent, "indent");
            sb.append(indent);
            sb.append("bytesPerLine = ");
            sb.append(this.bytesPerLine);
            sb.append(",");
            sb.append('\n');
            sb.append(indent);
            sb.append("bytesPerGroup = ");
            sb.append(this.bytesPerGroup);
            sb.append(",");
            sb.append('\n');
            sb.append(indent);
            sb.append("groupSeparator = \"");
            sb.append(this.groupSeparator);
            sb.append("\",");
            sb.append('\n');
            sb.append(indent);
            sb.append("byteSeparator = \"");
            sb.append(this.byteSeparator);
            sb.append("\",");
            sb.append('\n');
            sb.append(indent);
            sb.append("bytePrefix = \"");
            sb.append(this.bytePrefix);
            sb.append("\",");
            sb.append('\n');
            sb.append(indent);
            sb.append("byteSuffix = \"");
            sb.append(this.byteSuffix);
            sb.append("\"");
            return sb;
        }

        /* renamed from: c, reason: from getter */
        public final String getBytePrefix() {
            return this.bytePrefix;
        }

        /* renamed from: d, reason: from getter */
        public final String getByteSeparator() {
            return this.byteSeparator;
        }

        /* renamed from: e, reason: from getter */
        public final String getByteSuffix() {
            return this.byteSuffix;
        }

        /* renamed from: f, reason: from getter */
        public final int getBytesPerGroup() {
            return this.bytesPerGroup;
        }

        /* renamed from: g, reason: from getter */
        public final int getBytesPerLine() {
            return this.bytesPerLine;
        }

        /* renamed from: h, reason: from getter */
        public final String getGroupSeparator() {
            return this.groupSeparator;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("BytesHexFormat(");
            sb.append('\n');
            b(sb, "    ").append('\n');
            sb.append(")");
            return sb.toString();
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lkotlin/text/HexFormat$Companion;", HttpUrl.FRAGMENT_ENCODE_SET, "<init>", "()V", "Lkotlin/text/HexFormat;", "Default", "Lkotlin/text/HexFormat;", "a", "()Lkotlin/text/HexFormat;", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final HexFormat a() {
            return HexFormat.e;
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u001b\u0018\u0000 &2\u00020\u0001:\u0002'(B)\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\fJ'\u0010\u0011\u001a\u00060\rj\u0002`\u000e2\n\u0010\u000f\u001a\u00060\rj\u0002`\u000e2\u0006\u0010\u0010\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\fR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0014\u001a\u0004\b\u0016\u0010\fR\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR \u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u0015\u0010\u001b\u0012\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u0017\u0010\u001cR\u001a\u0010 \u001a\u00020\u00058\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u0018\u001a\u0004\b\u001f\u0010\u001aR\u001a\u0010\"\u001a\u00020\u00058\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0018\u001a\u0004\b!\u0010\u001aR\u001a\u0010%\u001a\u00020\u00058\u0000X\u0080\u0004¢\u0006\f\n\u0004\b#\u0010\u0018\u001a\u0004\b$\u0010\u001a¨\u0006)"}, d2 = {"Lkotlin/text/HexFormat$NumberHexFormat;", HttpUrl.FRAGMENT_ENCODE_SET, HttpUrl.FRAGMENT_ENCODE_SET, "prefix", "suffix", HttpUrl.FRAGMENT_ENCODE_SET, "removeLeadingZeros", HttpUrl.FRAGMENT_ENCODE_SET, "minLength", "<init>", "(Ljava/lang/String;Ljava/lang/String;ZI)V", "toString", "()Ljava/lang/String;", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "sb", "indent", "b", "(Ljava/lang/StringBuilder;Ljava/lang/String;)Ljava/lang/StringBuilder;", "a", "Ljava/lang/String;", "d", "f", "c", "Z", "e", "()Z", "I", "()I", "getMinLength$annotations", "()V", "isDigitsOnly$kotlin_stdlib", "isDigitsOnly", "isDigitsOnlyAndNoPadding$kotlin_stdlib", "isDigitsOnlyAndNoPadding", "g", "getIgnoreCase$kotlin_stdlib", "ignoreCase", "h", "Builder", "Companion", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
    public static final class NumberHexFormat {

        /* renamed from: h, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final NumberHexFormat i = new NumberHexFormat(HttpUrl.FRAGMENT_ENCODE_SET, HttpUrl.FRAGMENT_ENCODE_SET, false, 1);

        /* renamed from: a, reason: from kotlin metadata */
        private final String prefix;

        /* renamed from: b, reason: from kotlin metadata */
        private final String suffix;

        /* renamed from: c, reason: from kotlin metadata */
        private final boolean removeLeadingZeros;

        /* renamed from: d, reason: from kotlin metadata */
        private final int minLength;

        /* renamed from: e, reason: from kotlin metadata */
        private final boolean isDigitsOnly;

        /* renamed from: f, reason: from kotlin metadata */
        private final boolean isDigitsOnlyAndNoPadding;

        /* renamed from: g, reason: from kotlin metadata */
        private final boolean ignoreCase;

        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\t\u0018\u00002\u00020\u0001B\t\b\u0000¢\u0006\u0004\b\u0002\u0010\u0003R*\u0010\f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00048\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR*\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00048\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u0007\u001a\u0004\b\u000e\u0010\t\"\u0004\b\u000f\u0010\u000bR\"\u0010\u0018\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R0\u0010!\u001a\u00020\u00192\u0006\u0010\u0005\u001a\u00020\u00198\u0006@FX\u0087\u000e¢\u0006\u0018\n\u0004\b\u001a\u0010\u001b\u0012\u0004\b \u0010\u0003\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f¨\u0006\""}, d2 = {"Lkotlin/text/HexFormat$NumberHexFormat$Builder;", HttpUrl.FRAGMENT_ENCODE_SET, "<init>", "()V", HttpUrl.FRAGMENT_ENCODE_SET, "value", "a", "Ljava/lang/String;", "getPrefix", "()Ljava/lang/String;", "setPrefix", "(Ljava/lang/String;)V", "prefix", "b", "getSuffix", "setSuffix", "suffix", HttpUrl.FRAGMENT_ENCODE_SET, "c", "Z", "getRemoveLeadingZeros", "()Z", "setRemoveLeadingZeros", "(Z)V", "removeLeadingZeros", HttpUrl.FRAGMENT_ENCODE_SET, "d", "I", "getMinLength", "()I", "setMinLength", "(I)V", "getMinLength$annotations", "minLength", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
        @SourceDebugExtension
        public static final class Builder {

            /* renamed from: a, reason: from kotlin metadata */
            private String prefix;

            /* renamed from: b, reason: from kotlin metadata */
            private String suffix;

            /* renamed from: c, reason: from kotlin metadata */
            private boolean removeLeadingZeros;

            /* renamed from: d, reason: from kotlin metadata */
            private int minLength;

            public Builder() {
                Companion companion = NumberHexFormat.INSTANCE;
                this.prefix = companion.a().getPrefix();
                this.suffix = companion.a().getSuffix();
                this.removeLeadingZeros = companion.a().getRemoveLeadingZeros();
                this.minLength = companion.a().getMinLength();
            }
        }

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0005\u001a\u00020\u00048\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lkotlin/text/HexFormat$NumberHexFormat$Companion;", HttpUrl.FRAGMENT_ENCODE_SET, "<init>", "()V", "Lkotlin/text/HexFormat$NumberHexFormat;", "Default", "Lkotlin/text/HexFormat$NumberHexFormat;", "a", "()Lkotlin/text/HexFormat$NumberHexFormat;", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final NumberHexFormat a() {
                return NumberHexFormat.i;
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:13:0x003b, code lost:
        
            if (r3 != false) goto L17;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public NumberHexFormat(String prefix, String suffix, boolean z, int i2) {
            boolean b;
            boolean b2;
            Intrinsics.h(prefix, "prefix");
            Intrinsics.h(suffix, "suffix");
            this.prefix = prefix;
            this.suffix = suffix;
            this.removeLeadingZeros = z;
            this.minLength = i2;
            boolean z2 = false;
            boolean z3 = prefix.length() == 0 && suffix.length() == 0;
            this.isDigitsOnly = z3;
            this.isDigitsOnlyAndNoPadding = z3 && i2 == 1;
            b = HexFormatKt.b(prefix);
            if (!b) {
                b2 = HexFormatKt.b(suffix);
            }
            z2 = true;
            this.ignoreCase = z2;
        }

        public final StringBuilder b(StringBuilder sb, String indent) {
            Intrinsics.h(sb, "sb");
            Intrinsics.h(indent, "indent");
            sb.append(indent);
            sb.append("prefix = \"");
            sb.append(this.prefix);
            sb.append("\",");
            sb.append('\n');
            sb.append(indent);
            sb.append("suffix = \"");
            sb.append(this.suffix);
            sb.append("\",");
            sb.append('\n');
            sb.append(indent);
            sb.append("removeLeadingZeros = ");
            sb.append(this.removeLeadingZeros);
            sb.append(',');
            sb.append('\n');
            sb.append(indent);
            sb.append("minLength = ");
            sb.append(this.minLength);
            return sb;
        }

        /* renamed from: c, reason: from getter */
        public final int getMinLength() {
            return this.minLength;
        }

        /* renamed from: d, reason: from getter */
        public final String getPrefix() {
            return this.prefix;
        }

        /* renamed from: e, reason: from getter */
        public final boolean getRemoveLeadingZeros() {
            return this.removeLeadingZeros;
        }

        /* renamed from: f, reason: from getter */
        public final String getSuffix() {
            return this.suffix;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("NumberHexFormat(");
            sb.append('\n');
            b(sb, "    ").append('\n');
            sb.append(")");
            return sb.toString();
        }
    }

    static {
        BytesHexFormat.Companion companion = BytesHexFormat.INSTANCE;
        BytesHexFormat a = companion.a();
        NumberHexFormat.Companion companion2 = NumberHexFormat.INSTANCE;
        e = new HexFormat(false, a, companion2.a());
        f = new HexFormat(true, companion.a(), companion2.a());
    }

    public HexFormat(boolean z, BytesHexFormat bytes, NumberHexFormat number) {
        Intrinsics.h(bytes, "bytes");
        Intrinsics.h(number, "number");
        this.upperCase = z;
        this.bytes = bytes;
        this.number = number;
    }

    /* renamed from: b, reason: from getter */
    public final boolean getUpperCase() {
        return this.upperCase;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("HexFormat(");
        sb.append('\n');
        sb.append("    upperCase = ");
        sb.append(this.upperCase);
        sb.append(",");
        sb.append('\n');
        sb.append("    bytes = BytesHexFormat(");
        sb.append('\n');
        this.bytes.b(sb, "        ").append('\n');
        sb.append("    ),");
        sb.append('\n');
        sb.append("    number = NumberHexFormat(");
        sb.append('\n');
        this.number.b(sb, "        ").append('\n');
        sb.append("    )");
        sb.append('\n');
        sb.append(")");
        return sb.toString();
    }
}
