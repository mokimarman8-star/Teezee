package com.transsion.moviedetailapi.bean;

import android.text.TextUtils;
import androidx.annotation.Keep;
import com.google.gson.annotations.SerializedName;
import com.transsion.ad.bidding.nativead.BiddingNativeManager;
import com.transsion.moviedetailapi.DownloadItem;
import com.transsion.moviedetailapi.PlayUrlType;
import com.transsion.moviedetailapi.SubjectType;
import ij.l;
import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.mvel2.ast.ASTNode;
import rm.a;

@Keep
@Metadata(d1 = {"\u0000\u0095\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0003\bÂ\u0001\b\u0017\u0018\u00002\u00020\u00012\u00020\u0002BÉ\u0005\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0019\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001b\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u001e\u0012\u0010\b\u0002\u0010\"\u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010 \u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010$\u0012\b\b\u0002\u0010&\u001a\u00020\u001b\u0012\b\b\u0002\u0010'\u001a\u00020\u001b\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010(\u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u0019\u0012\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010.\u001a\u00020\u001b\u0012\b\b\u0002\u0010/\u001a\u00020\u001b\u0012\n\b\u0002\u00101\u001a\u0004\u0018\u000100\u0012\n\b\u0002\u00103\u001a\u0004\u0018\u000102\u0012\b\b\u0002\u00104\u001a\u00020\u0005\u0012\b\b\u0002\u00105\u001a\u00020\u001b\u0012\b\b\u0002\u00106\u001a\u00020\u001b\u0012\b\b\u0002\u00107\u001a\u00020\u0019\u0012\n\b\u0002\u00108\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010:\u001a\n\u0012\u0004\u0012\u000209\u0018\u00010\u0010\u0012\b\b\u0002\u0010;\u001a\u00020\u0019\u0012\u0010\b\u0002\u0010<\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010 \u0012\b\b\u0002\u0010=\u001a\u00020\u0005\u0012\b\b\u0002\u0010>\u001a\u00020\u001b\u0012\n\b\u0002\u0010?\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010@\u001a\u00020\u0005\u0012\n\b\u0002\u0010B\u001a\u0004\u0018\u00010A\u0012\n\b\u0002\u0010C\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010E\u001a\n\u0012\u0004\u0012\u00020D\u0018\u00010 \u0012\n\b\u0002\u0010F\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010G\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010H\u001a\u00020\u0005\u0012\n\b\u0002\u0010I\u001a\u0004\u0018\u00010\u0019\u0012\n\b\u0002\u0010J\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010L\u001a\u0004\u0018\u00010K\u0012\n\b\u0002\u0010N\u001a\u0004\u0018\u00010M\u0012\n\b\u0002\u0010O\u001a\u0004\u0018\u00010\u001b¢\u0006\u0004\bP\u0010QJ\r\u0010R\u001a\u00020\u001b¢\u0006\u0004\bR\u0010SJ\r\u0010T\u001a\u00020\u001b¢\u0006\u0004\bT\u0010SJ\r\u0010U\u001a\u00020\u001b¢\u0006\u0004\bU\u0010SJ\r\u0010V\u001a\u00020\u0000¢\u0006\u0004\bV\u0010WJ\r\u0010X\u001a\u00020\u001b¢\u0006\u0004\bX\u0010SJ\r\u0010Y\u001a\u00020\u001b¢\u0006\u0004\bY\u0010SJ\r\u0010Z\u001a\u00020\u001b¢\u0006\u0004\bZ\u0010SJ\r\u0010[\u001a\u00020\u001b¢\u0006\u0004\b[\u0010SJ\u000f\u0010\\\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\\\u0010]J\u000f\u0010^\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b^\u0010]J\r\u0010_\u001a\u00020\u001b¢\u0006\u0004\b_\u0010SJ\r\u0010`\u001a\u00020\u001b¢\u0006\u0004\b`\u0010SJ\r\u0010a\u001a\u00020\u001b¢\u0006\u0004\ba\u0010SR$\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010b\u001a\u0004\bc\u0010]\"\u0004\bd\u0010eR$\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010f\u001a\u0004\bg\u0010h\"\u0004\bi\u0010jR$\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010b\u001a\u0004\bk\u0010]\"\u0004\bl\u0010eR$\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\b\u0010b\u001a\u0004\bm\u0010]\"\u0004\bn\u0010eR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010o\u001a\u0004\bp\u0010q\"\u0004\br\u0010sR$\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010b\u001a\u0004\bt\u0010]\"\u0004\bu\u0010eR$\u0010\f\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010b\u001a\u0004\bv\u0010]\"\u0004\bw\u0010eR$\u0010\r\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010b\u001a\u0004\bx\u0010]\"\u0004\by\u0010eR$\u0010\u000e\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010f\u001a\u0004\bz\u0010h\"\u0004\b{\u0010jR$\u0010\u000f\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010b\u001a\u0004\b|\u0010]\"\u0004\b}\u0010eR-\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0004\b\u0011\u0010~\u001a\u0005\b\u007f\u0010\u0080\u0001\"\u0006\b\u0081\u0001\u0010\u0082\u0001R&\u0010\u0012\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0004\b\u0012\u0010b\u001a\u0005\b\u0083\u0001\u0010]\"\u0005\b\u0084\u0001\u0010eR&\u0010\u0013\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0004\b\u0013\u0010b\u001a\u0005\b\u0085\u0001\u0010]\"\u0005\b\u0086\u0001\u0010eR&\u0010\u0014\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0004\b\u0014\u0010b\u001a\u0005\b\u0087\u0001\u0010]\"\u0005\b\u0088\u0001\u0010eR&\u0010\u0015\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0004\b\u0015\u0010b\u001a\u0005\b\u0089\u0001\u0010]\"\u0005\b\u008a\u0001\u0010eR&\u0010\u0016\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0004\b\u0016\u0010f\u001a\u0005\b\u008b\u0001\u0010h\"\u0005\b\u008c\u0001\u0010jR.\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0004\b\u0018\u0010~\u001a\u0006\b\u008d\u0001\u0010\u0080\u0001\"\u0006\b\u008e\u0001\u0010\u0082\u0001R)\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u0017\n\u0005\b\u001a\u0010\u008f\u0001\u001a\u0006\b\u0090\u0001\u0010\u0091\u0001\"\u0006\b\u0092\u0001\u0010\u0093\u0001R)\u0010\u001c\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006X\u0087\u000e¢\u0006\u0017\n\u0005\b\u001c\u0010\u0094\u0001\u001a\u0006\b\u0095\u0001\u0010\u0096\u0001\"\u0006\b\u0097\u0001\u0010\u0098\u0001R&\u0010\u001d\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0004\b\u001d\u0010b\u001a\u0005\b\u0099\u0001\u0010]\"\u0005\b\u009a\u0001\u0010eR1\u0010\u001f\u001a\u0004\u0018\u00010\u001e8\u0006@\u0006X\u0087\u000e¢\u0006\u001f\n\u0005\b\u001f\u0010\u009b\u0001\u0012\u0006\b \u0001\u0010¡\u0001\u001a\u0006\b\u009c\u0001\u0010\u009d\u0001\"\u0006\b\u009e\u0001\u0010\u009f\u0001R6\u0010\"\u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010 8\u0006@\u0006X\u0087\u000e¢\u0006\u001e\n\u0004\b\"\u0010~\u0012\u0006\b¤\u0001\u0010¡\u0001\u001a\u0006\b¢\u0001\u0010\u0080\u0001\"\u0006\b£\u0001\u0010\u0082\u0001R&\u0010#\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0004\b#\u0010o\u001a\u0005\b¥\u0001\u0010q\"\u0005\b¦\u0001\u0010sR)\u0010%\u001a\u0004\u0018\u00010$8\u0006@\u0006X\u0087\u000e¢\u0006\u0017\n\u0005\b%\u0010§\u0001\u001a\u0006\b¨\u0001\u0010©\u0001\"\u0006\bª\u0001\u0010«\u0001R&\u0010&\u001a\u00020\u001b8\u0006@\u0006X\u0086\u000e¢\u0006\u0016\n\u0005\b&\u0010¬\u0001\u001a\u0005\b\u00ad\u0001\u0010S\"\u0006\b®\u0001\u0010¯\u0001R&\u0010'\u001a\u00020\u001b8\u0006@\u0006X\u0086\u000e¢\u0006\u0016\n\u0005\b'\u0010¬\u0001\u001a\u0005\b°\u0001\u0010S\"\u0006\b±\u0001\u0010¯\u0001R)\u0010)\u001a\u0004\u0018\u00010(8\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0005\b)\u0010²\u0001\u001a\u0006\b³\u0001\u0010´\u0001\"\u0006\bµ\u0001\u0010¶\u0001R&\u0010*\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0004\b*\u0010b\u001a\u0005\b·\u0001\u0010]\"\u0005\b¸\u0001\u0010eR)\u0010+\u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u0017\n\u0005\b+\u0010\u008f\u0001\u001a\u0006\b¹\u0001\u0010\u0091\u0001\"\u0006\bº\u0001\u0010\u0093\u0001R&\u0010,\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0004\b,\u0010b\u001a\u0005\b»\u0001\u0010]\"\u0005\b¼\u0001\u0010eR&\u0010-\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0004\b-\u0010b\u001a\u0005\b½\u0001\u0010]\"\u0005\b¾\u0001\u0010eR&\u0010.\u001a\u00020\u001b8\u0006@\u0006X\u0086\u000e¢\u0006\u0016\n\u0005\b.\u0010¬\u0001\u001a\u0005\b¿\u0001\u0010S\"\u0006\bÀ\u0001\u0010¯\u0001R%\u0010/\u001a\u00020\u001b8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b/\u0010¬\u0001\u001a\u0004\b/\u0010S\"\u0006\bÁ\u0001\u0010¯\u0001R)\u00101\u001a\u0004\u0018\u0001008\u0006@\u0006X\u0087\u000e¢\u0006\u0017\n\u0005\b1\u0010Â\u0001\u001a\u0006\bÃ\u0001\u0010Ä\u0001\"\u0006\bÅ\u0001\u0010Æ\u0001R)\u00103\u001a\u0004\u0018\u0001028\u0006@\u0006X\u0087\u000e¢\u0006\u0017\n\u0005\b3\u0010Ç\u0001\u001a\u0006\bÈ\u0001\u0010É\u0001\"\u0006\bÊ\u0001\u0010Ë\u0001R'\u00104\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0017\n\u0005\b4\u0010Ì\u0001\u001a\u0006\bÍ\u0001\u0010Î\u0001\"\u0006\bÏ\u0001\u0010Ð\u0001R&\u00105\u001a\u00020\u001b8\u0006@\u0006X\u0086\u000e¢\u0006\u0016\n\u0005\b5\u0010¬\u0001\u001a\u0005\bÑ\u0001\u0010S\"\u0006\bÒ\u0001\u0010¯\u0001R&\u00106\u001a\u00020\u001b8\u0006@\u0006X\u0086\u000e¢\u0006\u0016\n\u0005\b6\u0010¬\u0001\u001a\u0005\bÓ\u0001\u0010S\"\u0006\bÔ\u0001\u0010¯\u0001R'\u00107\u001a\u00020\u00198\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0005\b7\u0010Õ\u0001\u001a\u0006\bÖ\u0001\u0010×\u0001\"\u0006\bØ\u0001\u0010Ù\u0001R&\u00108\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0014\n\u0004\b8\u0010b\u001a\u0005\bÚ\u0001\u0010]\"\u0005\bÛ\u0001\u0010eR.\u0010:\u001a\n\u0012\u0004\u0012\u000209\u0018\u00010\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0016\n\u0004\b:\u0010~\u001a\u0006\bÜ\u0001\u0010\u0080\u0001\"\u0006\bÝ\u0001\u0010\u0082\u0001R'\u0010;\u001a\u00020\u00198\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0005\b;\u0010Õ\u0001\u001a\u0006\bÞ\u0001\u0010×\u0001\"\u0006\bß\u0001\u0010Ù\u0001R.\u0010<\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010 8\u0006@\u0006X\u0086\u000e¢\u0006\u0016\n\u0004\b<\u0010~\u001a\u0006\bà\u0001\u0010\u0080\u0001\"\u0006\bá\u0001\u0010\u0082\u0001R'\u0010=\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0005\b=\u0010Ì\u0001\u001a\u0006\bâ\u0001\u0010Î\u0001\"\u0006\bã\u0001\u0010Ð\u0001R&\u0010>\u001a\u00020\u001b8\u0006@\u0006X\u0086\u000e¢\u0006\u0016\n\u0005\b>\u0010¬\u0001\u001a\u0005\bä\u0001\u0010S\"\u0006\bå\u0001\u0010¯\u0001R&\u0010?\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0014\n\u0004\b?\u0010f\u001a\u0005\bæ\u0001\u0010h\"\u0005\bç\u0001\u0010jR'\u0010@\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0005\b@\u0010Ì\u0001\u001a\u0006\bè\u0001\u0010Î\u0001\"\u0006\bé\u0001\u0010Ð\u0001R)\u0010B\u001a\u0004\u0018\u00010A8\u0006@\u0006X\u0087\u000e¢\u0006\u0017\n\u0005\bB\u0010ê\u0001\u001a\u0006\bë\u0001\u0010ì\u0001\"\u0006\bí\u0001\u0010î\u0001R&\u0010C\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0014\n\u0004\bC\u0010b\u001a\u0005\bï\u0001\u0010]\"\u0005\bð\u0001\u0010eR.\u0010E\u001a\n\u0012\u0004\u0012\u00020D\u0018\u00010 8\u0006@\u0006X\u0086\u000e¢\u0006\u0016\n\u0004\bE\u0010~\u001a\u0006\bñ\u0001\u0010\u0080\u0001\"\u0006\bò\u0001\u0010\u0082\u0001R&\u0010F\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0004\bF\u0010b\u001a\u0005\bó\u0001\u0010]\"\u0005\bô\u0001\u0010eR&\u0010G\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0014\n\u0004\bG\u0010b\u001a\u0005\bõ\u0001\u0010]\"\u0005\bö\u0001\u0010eR'\u0010H\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0005\bH\u0010Ì\u0001\u001a\u0006\b÷\u0001\u0010Î\u0001\"\u0006\bø\u0001\u0010Ð\u0001R)\u0010I\u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u0017\n\u0005\bI\u0010\u008f\u0001\u001a\u0006\bù\u0001\u0010\u0091\u0001\"\u0006\bú\u0001\u0010\u0093\u0001R&\u0010J\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0004\bJ\u0010f\u001a\u0005\bû\u0001\u0010h\"\u0005\bü\u0001\u0010jR)\u0010L\u001a\u0004\u0018\u00010K8\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0005\bL\u0010ý\u0001\u001a\u0006\bþ\u0001\u0010ÿ\u0001\"\u0006\b\u0080\u0002\u0010\u0081\u0002R)\u0010N\u001a\u0004\u0018\u00010M8\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0005\bN\u0010\u0082\u0002\u001a\u0006\b\u0083\u0002\u0010\u0084\u0002\"\u0006\b\u0085\u0002\u0010\u0086\u0002R(\u0010O\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006X\u0086\u000e¢\u0006\u0016\n\u0005\bO\u0010\u0094\u0001\u001a\u0005\bO\u0010\u0096\u0001\"\u0006\b\u0087\u0002\u0010\u0098\u0001R(\u0010\u0088\u0002\u001a\u00020\u001b8\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0006\b\u0088\u0002\u0010¬\u0001\u001a\u0005\b\u0088\u0002\u0010S\"\u0006\b\u0089\u0002\u0010¯\u0001R\u0016\u0010\u008c\u0002\u001a\u0004\u0018\u00010!8F¢\u0006\b\u001a\u0006\b\u008a\u0002\u0010\u008b\u0002R\u0014\u0010\u008e\u0002\u001a\u00020\u00198F¢\u0006\b\u001a\u0006\b\u008d\u0002\u0010×\u0001¨\u0006\u008f\u0002"}, d2 = {"Lcom/transsion/moviedetailapi/bean/Subject;", "Lrm/a;", "Ljava/io/Serializable;", "", "subjectId", "", "subjectType", "title", "countryName", "Lcom/transsion/moviedetailapi/bean/Cover;", "cover", "releaseDate", "description", "duration", "durationSeconds", "genre", "", "tags", "tag", "imdbRate", "language", "mySeeTime", "seenStatus", "Lcom/transsion/moviedetailapi/bean/Staff;", "staffList", "", "wantToSeeCount", "", "hasResource", "ops", "Lcom/transsion/moviedetailapi/bean/SubjectDl;", "download", "", "Lcom/transsion/moviedetailapi/bean/ResourceDetectors;", "resourceDetectors", "stills", "Lcom/transsion/moviedetailapi/bean/Trailer;", "trailer", "series", "correlation", "Lcom/transsion/ad/bidding/nativead/BiddingNativeManager;", "nonAdDelegate", "postTitle", "viewers", "contentRating", "category", "builtIn", "isCache", "Lcom/transsion/moviedetailapi/bean/ShortTVItem;", "shortTVFirstEp", "Lcom/transsion/moviedetailapi/bean/ShortTVFavInfo;", "shortTVFavInfo", "totalEpisode", "loadCoverSuccess", "coverCache", "loadCoverDuration", "aka", "Lcom/transsion/moviedetailapi/bean/ExplainBean;", "explains", "totalSize", "unlockedEps", "coinPerEp", "deleted", "seNum", "season", "Lcom/transsion/moviedetailapi/bean/SubjectGameInfo;", "gameInfo", "subtitles", "Lcom/transsion/moviedetailapi/bean/DubsInfo;", "dubs", "corner", "restrictLevel", "restrictKid", "appointmentCnt", "likeStatus", "Lcom/transsion/moviedetailapi/bean/LayoutStyle;", "style", "Lcom/transsion/moviedetailapi/bean/PlayUrl;", "playUrl", "isCam", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Lcom/transsion/moviedetailapi/bean/Cover;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/util/List;Ljava/lang/Long;Ljava/lang/Boolean;Ljava/lang/String;Lcom/transsion/moviedetailapi/bean/SubjectDl;Ljava/util/List;Lcom/transsion/moviedetailapi/bean/Cover;Lcom/transsion/moviedetailapi/bean/Trailer;ZZLcom/transsion/ad/bidding/nativead/BiddingNativeManager;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;ZZLcom/transsion/moviedetailapi/bean/ShortTVItem;Lcom/transsion/moviedetailapi/bean/ShortTVFavInfo;IZZJLjava/lang/String;Ljava/util/List;JLjava/util/List;IZLjava/lang/Integer;ILcom/transsion/moviedetailapi/bean/SubjectGameInfo;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;ILjava/lang/Long;Ljava/lang/Integer;Lcom/transsion/moviedetailapi/bean/LayoutStyle;Lcom/transsion/moviedetailapi/bean/PlayUrl;Ljava/lang/Boolean;)V", "isSeries", "()Z", "isEPType", "isShortTV", "copyData", "()Lcom/transsion/moviedetailapi/bean/Subject;", "isEduType", "isMusicType", "isTvType", "isMovieType", "currentDubLandCode", "()Ljava/lang/String;", "currentDubLandName", "isJumpBrowser", "isJumpWebview", "isFamilyModeIntercept", "Ljava/lang/String;", "getSubjectId", "setSubjectId", "(Ljava/lang/String;)V", "Ljava/lang/Integer;", "getSubjectType", "()Ljava/lang/Integer;", "setSubjectType", "(Ljava/lang/Integer;)V", "getTitle", "setTitle", "getCountryName", "setCountryName", "Lcom/transsion/moviedetailapi/bean/Cover;", "getCover", "()Lcom/transsion/moviedetailapi/bean/Cover;", "setCover", "(Lcom/transsion/moviedetailapi/bean/Cover;)V", "getReleaseDate", "setReleaseDate", "getDescription", "setDescription", "getDuration", "setDuration", "getDurationSeconds", "setDurationSeconds", "getGenre", "setGenre", "Ljava/util/List;", "getTags", "()Ljava/util/List;", "setTags", "(Ljava/util/List;)V", "getTag", "setTag", "getImdbRate", "setImdbRate", "getLanguage", "setLanguage", "getMySeeTime", "setMySeeTime", "getSeenStatus", "setSeenStatus", "getStaffList", "setStaffList", "Ljava/lang/Long;", "getWantToSeeCount", "()Ljava/lang/Long;", "setWantToSeeCount", "(Ljava/lang/Long;)V", "Ljava/lang/Boolean;", "getHasResource", "()Ljava/lang/Boolean;", "setHasResource", "(Ljava/lang/Boolean;)V", "getOps", "setOps", "Lcom/transsion/moviedetailapi/bean/SubjectDl;", "getDownload", "()Lcom/transsion/moviedetailapi/bean/SubjectDl;", "setDownload", "(Lcom/transsion/moviedetailapi/bean/SubjectDl;)V", "getDownload$annotations", "()V", "getResourceDetectors", "setResourceDetectors", "getResourceDetectors$annotations", "getStills", "setStills", "Lcom/transsion/moviedetailapi/bean/Trailer;", "getTrailer", "()Lcom/transsion/moviedetailapi/bean/Trailer;", "setTrailer", "(Lcom/transsion/moviedetailapi/bean/Trailer;)V", "Z", "getSeries", "setSeries", "(Z)V", "getCorrelation", "setCorrelation", "Lcom/transsion/ad/bidding/nativead/BiddingNativeManager;", "getNonAdDelegate", "()Lcom/transsion/ad/bidding/nativead/BiddingNativeManager;", "setNonAdDelegate", "(Lcom/transsion/ad/bidding/nativead/BiddingNativeManager;)V", "getPostTitle", "setPostTitle", "getViewers", "setViewers", "getContentRating", "setContentRating", "getCategory", "setCategory", "getBuiltIn", "setBuiltIn", "setCache", "Lcom/transsion/moviedetailapi/bean/ShortTVItem;", "getShortTVFirstEp", "()Lcom/transsion/moviedetailapi/bean/ShortTVItem;", "setShortTVFirstEp", "(Lcom/transsion/moviedetailapi/bean/ShortTVItem;)V", "Lcom/transsion/moviedetailapi/bean/ShortTVFavInfo;", "getShortTVFavInfo", "()Lcom/transsion/moviedetailapi/bean/ShortTVFavInfo;", "setShortTVFavInfo", "(Lcom/transsion/moviedetailapi/bean/ShortTVFavInfo;)V", "I", "getTotalEpisode", "()I", "setTotalEpisode", "(I)V", "getLoadCoverSuccess", "setLoadCoverSuccess", "getCoverCache", "setCoverCache", "J", "getLoadCoverDuration", "()J", "setLoadCoverDuration", "(J)V", "getAka", "setAka", "getExplains", "setExplains", "getTotalSize", "setTotalSize", "getUnlockedEps", "setUnlockedEps", "getCoinPerEp", "setCoinPerEp", "getDeleted", "setDeleted", "getSeNum", "setSeNum", "getSeason", "setSeason", "Lcom/transsion/moviedetailapi/bean/SubjectGameInfo;", "getGameInfo", "()Lcom/transsion/moviedetailapi/bean/SubjectGameInfo;", "setGameInfo", "(Lcom/transsion/moviedetailapi/bean/SubjectGameInfo;)V", "getSubtitles", "setSubtitles", "getDubs", "setDubs", "getCorner", "setCorner", "getRestrictLevel", "setRestrictLevel", "getRestrictKid", "setRestrictKid", "getAppointmentCnt", "setAppointmentCnt", "getLikeStatus", "setLikeStatus", "Lcom/transsion/moviedetailapi/bean/LayoutStyle;", "getStyle", "()Lcom/transsion/moviedetailapi/bean/LayoutStyle;", "setStyle", "(Lcom/transsion/moviedetailapi/bean/LayoutStyle;)V", "Lcom/transsion/moviedetailapi/bean/PlayUrl;", "getPlayUrl", "()Lcom/transsion/moviedetailapi/bean/PlayUrl;", "setPlayUrl", "(Lcom/transsion/moviedetailapi/bean/PlayUrl;)V", "setCam", "isRefreshViewOnly", "setRefreshViewOnly", "getResourceDetector", "()Lcom/transsion/moviedetailapi/bean/ResourceDetectors;", "resourceDetector", "getResourceAboutDuration", "resourceAboutDuration", "MovieDetailApi_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public class Subject extends a implements Serializable {
    private String aka;

    @SerializedName("appointmentCnt")
    private Long appointmentCnt;
    private boolean builtIn;

    @SerializedName("category")
    private String category;
    private int coinPerEp;

    @SerializedName("contentRating")
    private String contentRating;

    @SerializedName("corner")
    private String corner;
    private transient boolean correlation;

    @SerializedName("countryName")
    private String countryName;

    @SerializedName("cover")
    private Cover cover;
    private transient boolean coverCache;
    private transient boolean deleted;

    @SerializedName("description")
    private String description;

    @SerializedName("dl")
    private SubjectDl download;
    private List<DubsInfo> dubs;

    @SerializedName("duration")
    private String duration;

    @SerializedName(alternate = {"durationSeconds"}, value = "seconds")
    private Integer durationSeconds;
    private List<ExplainBean> explains;

    @SerializedName("relatedApp")
    private SubjectGameInfo gameInfo;

    @SerializedName("genre")
    private String genre;

    @SerializedName("hasResource")
    private Boolean hasResource;

    @SerializedName("imdbRatingValue")
    private String imdbRate;
    private boolean isCache;
    private Boolean isCam;
    private boolean isRefreshViewOnly;

    @SerializedName("language")
    private String language;

    @SerializedName("likeStatus")
    private Integer likeStatus;
    private transient long loadCoverDuration;
    private transient boolean loadCoverSuccess;

    @SerializedName("mySeeTime")
    private String mySeeTime;
    private transient BiddingNativeManager nonAdDelegate;

    @SerializedName("ops")
    private String ops;
    private PlayUrl playUrl;

    @SerializedName("postTitle")
    private String postTitle;

    @SerializedName("releaseDate")
    private String releaseDate;

    @SerializedName("resourceDetectors")
    private List<ResourceDetectors> resourceDetectors;
    private int restrictKid;
    private String restrictLevel;
    private Integer seNum;
    private int season;

    @SerializedName("seenStatus")
    private Integer seenStatus;
    private transient boolean series;

    @SerializedName("favInfo")
    private ShortTVFavInfo shortTVFavInfo;

    @SerializedName("firstEp")
    private ShortTVItem shortTVFirstEp;

    @SerializedName("staffList")
    private List<? extends Staff> staffList;

    @SerializedName("stills")
    private Cover stills;
    private LayoutStyle style;

    @SerializedName("subjectId")
    private String subjectId;

    @SerializedName("subjectType")
    private Integer subjectType;
    private String subtitles;

    @SerializedName("tag")
    private String tag;

    @SerializedName("tags")
    private List<String> tags;

    @SerializedName("title")
    private String title;

    @SerializedName(alternate = {"shortsEpisode"}, value = "totalEpisode")
    private int totalEpisode;
    private long totalSize;

    @SerializedName("trailer")
    private Trailer trailer;
    private List<Integer> unlockedEps;

    @SerializedName("viewers")
    private Long viewers;

    @SerializedName("wantToSeeCount")
    private Long wantToSeeCount;

    public Subject() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, false, null, null, null, null, null, false, false, null, null, 0, false, false, 0L, null, null, 0L, null, 0, false, null, 0, null, null, null, null, null, 0, null, null, null, null, null, -1, 67108863, null);
    }

    public Subject(String str, Integer num, String str2, String str3, Cover cover, String str4, String str5, String str6, Integer num2, String str7, List<String> list, String str8, String str9, String str10, String str11, Integer num3, List<? extends Staff> list2, Long l, Boolean bool, String str12, SubjectDl subjectDl, List<ResourceDetectors> list3, Cover cover2, Trailer trailer, boolean z, boolean z2, BiddingNativeManager biddingNativeManager, String str13, Long l2, String str14, String str15, boolean z3, boolean z4, ShortTVItem shortTVItem, ShortTVFavInfo shortTVFavInfo, int i, boolean z5, boolean z6, long j, String str16, List<ExplainBean> list4, long j2, List<Integer> list5, int i2, boolean z7, Integer num4, int i3, SubjectGameInfo subjectGameInfo, String str17, List<DubsInfo> list6, String str18, String str19, int i4, Long l3, Integer num5, LayoutStyle layoutStyle, PlayUrl playUrl, Boolean bool2) {
        this.subjectId = str;
        this.subjectType = num;
        this.title = str2;
        this.countryName = str3;
        this.cover = cover;
        this.releaseDate = str4;
        this.description = str5;
        this.duration = str6;
        this.durationSeconds = num2;
        this.genre = str7;
        this.tags = list;
        this.tag = str8;
        this.imdbRate = str9;
        this.language = str10;
        this.mySeeTime = str11;
        this.seenStatus = num3;
        this.staffList = list2;
        this.wantToSeeCount = l;
        this.hasResource = bool;
        this.ops = str12;
        this.download = subjectDl;
        this.resourceDetectors = list3;
        this.stills = cover2;
        this.trailer = trailer;
        this.series = z;
        this.correlation = z2;
        this.nonAdDelegate = biddingNativeManager;
        this.postTitle = str13;
        this.viewers = l2;
        this.contentRating = str14;
        this.category = str15;
        this.builtIn = z3;
        this.isCache = z4;
        this.shortTVFirstEp = shortTVItem;
        this.shortTVFavInfo = shortTVFavInfo;
        this.totalEpisode = i;
        this.loadCoverSuccess = z5;
        this.coverCache = z6;
        this.loadCoverDuration = j;
        this.aka = str16;
        this.explains = list4;
        this.totalSize = j2;
        this.unlockedEps = list5;
        this.coinPerEp = i2;
        this.deleted = z7;
        this.seNum = num4;
        this.season = i3;
        this.gameInfo = subjectGameInfo;
        this.subtitles = str17;
        this.dubs = list6;
        this.corner = str18;
        this.restrictLevel = str19;
        this.restrictKid = i4;
        this.appointmentCnt = l3;
        this.likeStatus = num5;
        this.style = layoutStyle;
        this.playUrl = playUrl;
        this.isCam = bool2;
    }

    public /* synthetic */ Subject(String str, Integer num, String str2, String str3, Cover cover, String str4, String str5, String str6, Integer num2, String str7, List list, String str8, String str9, String str10, String str11, Integer num3, List list2, Long l, Boolean bool, String str12, SubjectDl subjectDl, List list3, Cover cover2, Trailer trailer, boolean z, boolean z2, BiddingNativeManager biddingNativeManager, String str13, Long l2, String str14, String str15, boolean z3, boolean z4, ShortTVItem shortTVItem, ShortTVFavInfo shortTVFavInfo, int i, boolean z5, boolean z6, long j, String str16, List list4, long j2, List list5, int i2, boolean z7, Integer num4, int i3, SubjectGameInfo subjectGameInfo, String str17, List list6, String str18, String str19, int i4, Long l3, Integer num5, LayoutStyle layoutStyle, PlayUrl playUrl, Boolean bool2, int i6, int i7, DefaultConstructorMarker defaultConstructorMarker) {
        this((i6 & 1) != 0 ? null : str, (i6 & 2) != 0 ? 1 : num, (i6 & 4) != 0 ? null : str2, (i6 & 8) != 0 ? null : str3, (i6 & 16) != 0 ? null : cover, (i6 & 32) != 0 ? null : str4, (i6 & 64) != 0 ? null : str5, (i6 & ASTNode.ASSIGN) != 0 ? null : str6, (i6 & ASTNode.COLLECTION) != 0 ? 0 : num2, (i6 & ASTNode.THISREF) != 0 ? null : str7, (i6 & 1024) != 0 ? null : list, (i6 & ASTNode.BLOCK_IF) != 0 ? null : str8, (i6 & 4096) != 0 ? null : str9, (i6 & 8192) != 0 ? null : str10, (i6 & ASTNode.BLOCK_UNTIL) != 0 ? null : str11, (i6 & ASTNode.BLOCK_WHILE) != 0 ? 0 : num3, (i6 & ASTNode.BLOCK_DO) != 0 ? null : list2, (i6 & ASTNode.BLOCK_DO_UNTIL) != 0 ? 0L : l, (i6 & ASTNode.BLOCK_FOR) != 0 ? null : bool, (i6 & ASTNode.OPT_SUBTR) != 0 ? null : str12, (i6 & ASTNode.FQCN) != 0 ? null : subjectDl, (i6 & 2097152) != 0 ? null : list3, (i6 & ASTNode.STACKLANG) != 0 ? null : cover2, (i6 & 8388608) != 0 ? null : trailer, (i6 & 16777216) != 0 ? false : z, (i6 & ASTNode.PCTX_STORED) != 0 ? false : z2, (i6 & ASTNode.ARRAY_TYPE_LITERAL) != 0 ? null : biddingNativeManager, (i6 & ASTNode.NOJIT) != 0 ? null : str13, (i6 & ASTNode.DEOP) != 0 ? null : l2, (i6 & ASTNode.DISCARD) != 0 ? null : str14, (i6 & 1073741824) != 0 ? null : str15, (i6 & Integer.MIN_VALUE) != 0 ? false : z3, (i7 & 1) != 0 ? false : z4, (i7 & 2) != 0 ? null : shortTVItem, (i7 & 4) != 0 ? null : shortTVFavInfo, (i7 & 8) != 0 ? 0 : i, (i7 & 16) != 0 ? false : z5, (i7 & 32) != 0 ? false : z6, (i7 & 64) != 0 ? 0L : j, (i7 & ASTNode.ASSIGN) != 0 ? null : str16, (i7 & ASTNode.COLLECTION) != 0 ? null : list4, (i7 & ASTNode.THISREF) != 0 ? 0L : j2, (i7 & 1024) != 0 ? null : list5, (i7 & ASTNode.BLOCK_IF) != 0 ? -1 : i2, (i7 & 4096) != 0 ? false : z7, (i7 & 8192) != 0 ? 0 : num4, (i7 & ASTNode.BLOCK_UNTIL) != 0 ? 1 : i3, (i7 & ASTNode.BLOCK_WHILE) != 0 ? null : subjectGameInfo, (i7 & ASTNode.BLOCK_DO) != 0 ? null : str17, (i7 & ASTNode.BLOCK_DO_UNTIL) != 0 ? null : list6, (i7 & ASTNode.BLOCK_FOR) != 0 ? null : str18, (i7 & ASTNode.OPT_SUBTR) != 0 ? null : str19, (i7 & ASTNode.FQCN) != 0 ? 0 : i4, (i7 & 2097152) != 0 ? 0L : l3, (i7 & ASTNode.STACKLANG) != 0 ? 0 : num5, (i7 & 8388608) != 0 ? null : layoutStyle, (i7 & 16777216) != 0 ? null : playUrl, (i7 & ASTNode.PCTX_STORED) != 0 ? null : bool2);
    }

    @Deprecated
    public static /* synthetic */ void getDownload$annotations() {
    }

    private final String getFamilySearchText() {
        return (this.title + " " + this.genre + " " + this.category + " " + this.description).toLowerCase();
    }

    @Deprecated
    public static /* synthetic */ void getResourceDetectors$annotations() {
    }

    private final boolean hasExplicitKeyword() {
        String familySearchText = getFamilySearchText();
        if (familySearchText == null) {
            boolean contains = familySearchText.contains("porn");
            if (!contains) {
                return contains;
            }
            boolean contains2 = familySearchText.contains("porno");
            if (!contains2) {
                return contains2;
            }
            boolean contains3 = familySearchText.contains("xxx");
            if (!contains3) {
                return contains3;
            }
            boolean contains4 = familySearchText.contains("erotic");
            if (!contains4) {
                return contains4;
            }
            boolean contains5 = familySearchText.contains("nude");
            if (!contains5) {
                return contains5;
            }
            boolean contains6 = familySearchText.contains("naked");
            if (!contains6) {
                return contains6;
            }
            boolean contains7 = familySearchText.contains("hentai");
            if (!contains7) {
                return contains7;
            }
            boolean contains8 = familySearchText.contains("nsfw");
            if (!contains8) {
                return contains8;
            }
            boolean contains9 = familySearchText.contains("hardcore");
            if (!contains9) {
                return contains9;
            }
            boolean contains10 = familySearchText.contains("sexvideo");
            if (!contains10) {
                return contains10;
            }
            boolean contains11 = familySearchText.contains("sexfilm");
            if (!contains11) {
                return contains11;
            }
            boolean contains12 = familySearchText.contains("sex video");
            if (!contains12) {
                return contains12;
            }
            boolean contains13 = familySearchText.contains("sex film");
            if (!contains13) {
                return contains13;
            }
            boolean contains14 = familySearchText.contains("sex tape");
            if (!contains14) {
                return contains14;
            }
            boolean contains15 = familySearchText.contains("pornhub");
            if (!contains15) {
                return contains15;
            }
            boolean contains16 = familySearchText.contains("xvideos");
            if (!contains16) {
                return contains16;
            }
        }
        return false;
    }

    public final Subject copyData() {
        return new Subject(this.subjectId, this.subjectType, this.title, this.countryName, this.cover, this.releaseDate, this.description, this.duration, this.durationSeconds, this.genre, this.tags, null, this.imdbRate, this.language, this.mySeeTime, null, null, null, this.hasResource, this.ops, this.download, this.resourceDetectors, this.stills, this.trailer, false, false, null, null, null, null, null, this.builtIn, this.isCache, this.shortTVFirstEp, this.shortTVFavInfo, this.totalEpisode, false, false, 0L, null, null, this.totalSize, this.unlockedEps, this.coinPerEp, false, null, 0, null, null, null, null, null, 0, null, null, null, null, null, 2130937856, 67105264, null);
    }

    public final String currentDubLandCode() {
        Object obj;
        List<DubsInfo> list = this.dubs;
        if (list == null) {
            return null;
        }
        Iterator<T> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (Intrinsics.c(((DubsInfo) obj).getSubjectId(), this.subjectId)) {
                break;
            }
        }
        DubsInfo dubsInfo = (DubsInfo) obj;
        if (dubsInfo != null) {
            return dubsInfo.getLanCode();
        }
        return null;
    }

    public final String currentDubLandName() {
        Object obj;
        List<DubsInfo> list = this.dubs;
        if (list == null) {
            return null;
        }
        Iterator<T> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (Intrinsics.c(((DubsInfo) obj).getSubjectId(), this.subjectId)) {
                break;
            }
        }
        DubsInfo dubsInfo = (DubsInfo) obj;
        if (dubsInfo != null) {
            return dubsInfo.getLanName();
        }
        return null;
    }

    public final String getAka() {
        return this.aka;
    }

    public final Long getAppointmentCnt() {
        return this.appointmentCnt;
    }

    public final boolean getBuiltIn() {
        return this.builtIn;
    }

    public final String getCategory() {
        return this.category;
    }

    public final int getCoinPerEp() {
        return this.coinPerEp;
    }

    public final String getContentRating() {
        return this.contentRating;
    }

    public final String getCorner() {
        return this.corner;
    }

    public final boolean getCorrelation() {
        return this.correlation;
    }

    public final String getCountryName() {
        return this.countryName;
    }

    public final Cover getCover() {
        return this.cover;
    }

    public final boolean getCoverCache() {
        return this.coverCache;
    }

    public final boolean getDeleted() {
        return this.deleted;
    }

    public final String getDescription() {
        return this.description;
    }

    public final SubjectDl getDownload() {
        return this.download;
    }

    public final List<DubsInfo> getDubs() {
        return this.dubs;
    }

    public final String getDuration() {
        return this.duration;
    }

    public final Integer getDurationSeconds() {
        return this.durationSeconds;
    }

    public final List<ExplainBean> getExplains() {
        return this.explains;
    }

    public final SubjectGameInfo getGameInfo() {
        return this.gameInfo;
    }

    public final String getGenre() {
        return this.genre;
    }

    public final Boolean getHasResource() {
        return this.hasResource;
    }

    public final String getImdbRate() {
        return this.imdbRate;
    }

    public final String getLanguage() {
        return this.language;
    }

    public final Integer getLikeStatus() {
        return this.likeStatus;
    }

    public final long getLoadCoverDuration() {
        return this.loadCoverDuration;
    }

    public final boolean getLoadCoverSuccess() {
        return this.loadCoverSuccess;
    }

    public final String getMySeeTime() {
        return this.mySeeTime;
    }

    public final BiddingNativeManager getNonAdDelegate() {
        return this.nonAdDelegate;
    }

    public final String getOps() {
        return this.ops;
    }

    public final PlayUrl getPlayUrl() {
        return this.playUrl;
    }

    public final String getPostTitle() {
        return this.postTitle;
    }

    public final String getReleaseDate() {
        return this.releaseDate;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0073 A[ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long getResourceAboutDuration() {
        /*
            r8 = this;
            java.lang.Integer r0 = r8.durationSeconds
            r1 = 0
            if (r0 == 0) goto La
            int r0 = r0.intValue()
            goto Lb
        La:
            r0 = r1
        Lb:
            r2 = 1000(0x3e8, double:4.94E-321)
            if (r0 <= 0) goto L1a
            java.lang.Integer r0 = r8.durationSeconds
            if (r0 == 0) goto L17
            int r1 = r0.intValue()
        L17:
            long r0 = (long) r1
            long r0 = r0 * r2
            goto L75
        L1a:
            java.lang.String r0 = r8.duration
            r4 = 1
            if (r0 == 0) goto L2c
            int r0 = r0.length()
            if (r0 <= 0) goto L27
            r0 = r4
            goto L28
        L27:
            r0 = r1
        L28:
            if (r0 != r4) goto L2c
            r0 = r4
            goto L2d
        L2c:
            r0 = r1
        L2d:
            if (r0 == 0) goto L73
            java.lang.String r0 = "[^0-9]+"
            java.util.regex.Pattern r0 = java.util.regex.Pattern.compile(r0)
            java.lang.String r5 = r8.duration
            kotlin.jvm.internal.Intrinsics.e(r5)
            java.lang.CharSequence r5 = kotlin.text.StringsKt.n1(r5)
            java.lang.String r5 = r5.toString()
            java.lang.String[] r0 = r0.split(r5)
            int r5 = r0.length
            r6 = 2
            java.lang.String r7 = "get(...)"
            if (r5 != r6) goto L5f
            r1 = r0[r1]
            kotlin.jvm.internal.Intrinsics.g(r1, r7)
            int r1 = java.lang.Integer.parseInt(r1)
            r0 = r0[r4]
            kotlin.jvm.internal.Intrinsics.g(r0, r7)
            int r0 = java.lang.Integer.parseInt(r0)
            goto L6d
        L5f:
            int r5 = r0.length
            if (r5 != r4) goto L6c
            r0 = r0[r1]
            kotlin.jvm.internal.Intrinsics.g(r0, r7)
            int r0 = java.lang.Integer.parseInt(r0)
            goto L6d
        L6c:
            r0 = r1
        L6d:
            int r1 = r1 * 60
            int r1 = r1 + r0
            int r1 = r1 * 60
            goto L17
        L73:
            r0 = 0
        L75:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.moviedetailapi.bean.Subject.getResourceAboutDuration():long");
    }

    public final ResourceDetectors getResourceDetector() {
        ResourceDetectors resourceDetectors;
        List<DownloadItem> resolutionList;
        List<ResourceDetectors> list = this.resourceDetectors;
        if (list == null || list.isEmpty()) {
            boolean isSeries = isSeries();
            SubjectDl subjectDl = this.download;
            String resourceId = subjectDl != null ? subjectDl.getResourceId() : null;
            SubjectDl subjectDl2 = this.download;
            String url = subjectDl2 != null ? subjectDl2.getUrl() : null;
            SubjectDl subjectDl3 = this.download;
            Long size = subjectDl3 != null ? subjectDl3.getSize() : null;
            SubjectDl subjectDl4 = this.download;
            String sourceUrl = subjectDl4 != null ? subjectDl4.getSourceUrl() : null;
            SubjectDl subjectDl5 = this.download;
            String postId = subjectDl5 != null ? subjectDl5.getPostId() : null;
            SubjectDl subjectDl6 = this.download;
            return new ResourceDetectors(Integer.valueOf(isSeries ? 1 : 0), null, size, null, null, sourceUrl, url, null, resourceId, null, postId, subjectDl6 != null ? subjectDl6.getExtSubtitle() : null, null, null, 12954, null);
        }
        List<ResourceDetectors> list2 = this.resourceDetectors;
        ResourceDetectors resourceDetectors2 = list2 != null ? list2.get(0) : null;
        List<ResourceDetectors> list3 = this.resourceDetectors;
        if (list3 == null || (resourceDetectors = list3.get(0)) == null || (resolutionList = resourceDetectors.getResolutionList()) == null) {
            return resourceDetectors2;
        }
        for (DownloadItem downloadItem : resolutionList) {
            if (Intrinsics.c(downloadItem.getResourceId(), resourceDetectors2 != null ? resourceDetectors2.getResourceId() : null)) {
                resourceDetectors2 = new ResourceDetectors(resourceDetectors2 != null ? resourceDetectors2.getType() : null, null, downloadItem.getSize(), null, downloadItem.getUploadBy(), downloadItem.getSourceUrl(), downloadItem.getUrl(), null, downloadItem.getResourceId(), null, downloadItem.getPostId(), downloadItem.getExtSubtitle(), null, downloadItem.getResolution(), 4746, null);
            }
        }
        return resourceDetectors2;
    }

    public final List<ResourceDetectors> getResourceDetectors() {
        return this.resourceDetectors;
    }

    public final int getRestrictKid() {
        return this.restrictKid;
    }

    public final String getRestrictLevel() {
        return this.restrictLevel;
    }

    public final Integer getSeNum() {
        return this.seNum;
    }

    public final int getSeason() {
        return this.season;
    }

    public final Integer getSeenStatus() {
        return this.seenStatus;
    }

    public final boolean getSeries() {
        return this.series;
    }

    public final ShortTVFavInfo getShortTVFavInfo() {
        return this.shortTVFavInfo;
    }

    public final ShortTVItem getShortTVFirstEp() {
        return this.shortTVFirstEp;
    }

    public final List<Staff> getStaffList() {
        return this.staffList;
    }

    public final Cover getStills() {
        return this.stills;
    }

    public final LayoutStyle getStyle() {
        return this.style;
    }

    public final String getSubjectId() {
        return this.subjectId;
    }

    public final Integer getSubjectType() {
        return this.subjectType;
    }

    public final String getSubtitles() {
        return this.subtitles;
    }

    public final String getTag() {
        return this.tag;
    }

    public final List<String> getTags() {
        return this.tags;
    }

    public final String getTitle() {
        return this.title;
    }

    public final int getTotalEpisode() {
        return this.totalEpisode;
    }

    public final long getTotalSize() {
        return this.totalSize;
    }

    public final Trailer getTrailer() {
        return this.trailer;
    }

    public final List<Integer> getUnlockedEps() {
        return this.unlockedEps;
    }

    public final Long getViewers() {
        return this.viewers;
    }

    public final Long getWantToSeeCount() {
        return this.wantToSeeCount;
    }

    /* renamed from: isCache, reason: from getter */
    public final boolean getIsCache() {
        return this.isCache;
    }

    /* renamed from: isCam, reason: from getter */
    public final Boolean getIsCam() {
        return this.isCam;
    }

    public final boolean isEPType() {
        return isTvType() || isEduType();
    }

    public final boolean isEduType() {
        Integer num = this.subjectType;
        SubjectType subjectType = SubjectType.EDUCATION;
        return Intrinsics.c(num, subjectType != null ? Integer.valueOf(subjectType.getValue()) : null);
    }

    public final boolean isFamilyModeIntercept() {
        if (l.a()) {
            if (this.restrictKid == 1) {
                return true;
            }
            boolean hasExplicitKeyword = hasExplicitKeyword();
            if (!hasExplicitKeyword) {
                return hasExplicitKeyword;
            }
        }
        return false;
    }

    public final boolean isJumpBrowser() {
        PlayUrl playUrl = this.playUrl;
        String playUrl2 = playUrl != null ? playUrl.getPlayUrl() : null;
        if (playUrl2 == null || playUrl2.length() == 0) {
            return false;
        }
        PlayUrl playUrl3 = this.playUrl;
        return StringsKt.I(playUrl3 != null ? playUrl3.getUrlType() : null, PlayUrlType.WEB.getValue(), false, 2, (Object) null) && !isFamilyModeIntercept();
    }

    public final boolean isJumpWebview() {
        PlayUrl playUrl = this.playUrl;
        String playUrl2 = playUrl != null ? playUrl.getPlayUrl() : null;
        if (playUrl2 == null || playUrl2.length() == 0) {
            return false;
        }
        PlayUrl playUrl3 = this.playUrl;
        return StringsKt.I(playUrl3 != null ? playUrl3.getUrlType() : null, PlayUrlType.ANDROID.getValue(), false, 2, (Object) null) && !isFamilyModeIntercept();
    }

    public final boolean isMovieType() {
        Integer num = this.subjectType;
        SubjectType subjectType = SubjectType.MOVIE;
        return Intrinsics.c(num, subjectType != null ? Integer.valueOf(subjectType.getValue()) : null);
    }

    public final boolean isMusicType() {
        Integer num = this.subjectType;
        SubjectType subjectType = SubjectType.MUSIC;
        if (!Intrinsics.c(num, subjectType != null ? Integer.valueOf(subjectType.getValue()) : null)) {
            Integer num2 = this.subjectType;
            SubjectType subjectType2 = SubjectType.AUDIO;
            if (!Intrinsics.c(num2, subjectType2 != null ? Integer.valueOf(subjectType2.getValue()) : null)) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: isRefreshViewOnly, reason: from getter */
    public final boolean getIsRefreshViewOnly() {
        return this.isRefreshViewOnly;
    }

    public final boolean isSeries() {
        SubjectDl subjectDl;
        if (!this.series && (subjectDl = this.download) != null) {
            if (!TextUtils.isEmpty(subjectDl != null ? subjectDl.getUrl() : null)) {
                return false;
            }
        }
        return true;
    }

    public final boolean isShortTV() {
        Integer num = this.subjectType;
        SubjectType subjectType = SubjectType.SHORT_TV;
        return Intrinsics.c(num, subjectType != null ? Integer.valueOf(subjectType.getValue()) : null);
    }

    public final boolean isTvType() {
        Integer num = this.subjectType;
        SubjectType subjectType = SubjectType.TV;
        return Intrinsics.c(num, subjectType != null ? Integer.valueOf(subjectType.getValue()) : null);
    }

    public final void setAka(String str) {
        this.aka = str;
    }

    public final void setAppointmentCnt(Long l) {
        this.appointmentCnt = l;
    }

    public final void setBuiltIn(boolean z) {
        this.builtIn = z;
    }

    public final void setCache(boolean z) {
        this.isCache = z;
    }

    public final void setCam(Boolean bool) {
        this.isCam = bool;
    }

    public final void setCategory(String str) {
        this.category = str;
    }

    public final void setCoinPerEp(int i) {
        this.coinPerEp = i;
    }

    public final void setContentRating(String str) {
        this.contentRating = str;
    }

    public final void setCorner(String str) {
        this.corner = str;
    }

    public final void setCorrelation(boolean z) {
        this.correlation = z;
    }

    public final void setCountryName(String str) {
        this.countryName = str;
    }

    public final void setCover(Cover cover) {
        this.cover = cover;
    }

    public final void setCoverCache(boolean z) {
        this.coverCache = z;
    }

    public final void setDeleted(boolean z) {
        this.deleted = z;
    }

    public final void setDescription(String str) {
        this.description = str;
    }

    public final void setDownload(SubjectDl subjectDl) {
        this.download = subjectDl;
    }

    public final void setDubs(List<DubsInfo> list) {
        this.dubs = list;
    }

    public final void setDuration(String str) {
        this.duration = str;
    }

    public final void setDurationSeconds(Integer num) {
        this.durationSeconds = num;
    }

    public final void setExplains(List<ExplainBean> list) {
        this.explains = list;
    }

    public final void setGameInfo(SubjectGameInfo subjectGameInfo) {
        this.gameInfo = subjectGameInfo;
    }

    public final void setGenre(String str) {
        this.genre = str;
    }

    public final void setHasResource(Boolean bool) {
        this.hasResource = bool;
    }

    public final void setImdbRate(String str) {
        this.imdbRate = str;
    }

    public final void setLanguage(String str) {
        this.language = str;
    }

    public final void setLikeStatus(Integer num) {
        this.likeStatus = num;
    }

    public final void setLoadCoverDuration(long j) {
        this.loadCoverDuration = j;
    }

    public final void setLoadCoverSuccess(boolean z) {
        this.loadCoverSuccess = z;
    }

    public final void setMySeeTime(String str) {
        this.mySeeTime = str;
    }

    public final void setNonAdDelegate(BiddingNativeManager biddingNativeManager) {
        this.nonAdDelegate = biddingNativeManager;
    }

    public final void setOps(String str) {
        this.ops = str;
    }

    public final void setPlayUrl(PlayUrl playUrl) {
        this.playUrl = playUrl;
    }

    public final void setPostTitle(String str) {
        this.postTitle = str;
    }

    public final void setRefreshViewOnly(boolean z) {
        this.isRefreshViewOnly = z;
    }

    public final void setReleaseDate(String str) {
        this.releaseDate = str;
    }

    public final void setResourceDetectors(List<ResourceDetectors> list) {
        this.resourceDetectors = list;
    }

    public final void setRestrictKid(int i) {
        this.restrictKid = i;
    }

    public final void setRestrictLevel(String str) {
        this.restrictLevel = str;
    }

    public final void setSeNum(Integer num) {
        this.seNum = num;
    }

    public final void setSeason(int i) {
        this.season = i;
    }

    public final void setSeenStatus(Integer num) {
        this.seenStatus = num;
    }

    public final void setSeries(boolean z) {
        this.series = z;
    }

    public final void setShortTVFavInfo(ShortTVFavInfo shortTVFavInfo) {
        this.shortTVFavInfo = shortTVFavInfo;
    }

    public final void setShortTVFirstEp(ShortTVItem shortTVItem) {
        this.shortTVFirstEp = shortTVItem;
    }

    public final void setStaffList(List<? extends Staff> list) {
        this.staffList = list;
    }

    public final void setStills(Cover cover) {
        this.stills = cover;
    }

    public final void setStyle(LayoutStyle layoutStyle) {
        this.style = layoutStyle;
    }

    public final void setSubjectId(String str) {
        this.subjectId = str;
    }

    public final void setSubjectType(Integer num) {
        this.subjectType = num;
    }

    public final void setSubtitles(String str) {
        this.subtitles = str;
    }

    public final void setTag(String str) {
        this.tag = str;
    }

    public final void setTags(List<String> list) {
        this.tags = list;
    }

    public final void setTitle(String str) {
        this.title = str;
    }

    public final void setTotalEpisode(int i) {
        this.totalEpisode = i;
    }

    public final void setTotalSize(long j) {
        this.totalSize = j;
    }

    public final void setTrailer(Trailer trailer) {
        this.trailer = trailer;
    }

    public final void setUnlockedEps(List<Integer> list) {
        this.unlockedEps = list;
    }

    public final void setViewers(Long l) {
        this.viewers = l;
    }

    public final void setWantToSeeCount(Long l) {
        this.wantToSeeCount = l;
    }
}
