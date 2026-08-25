package com.transsion.baselib.db.download;

import android.net.Uri;
import android.os.Environment;
import androidx.annotation.Keep;
import com.blankj.utilcode.util.Utils;
import com.blankj.utilcode.util.c0;
import com.hisavana.common.interfacz.TAdListener;
import com.hisavana.common.interfacz.TAdditionalListener;
import com.transsion.baselib.db.download.DownloadException;
import com.transsion.gslb.BuildConfig;
import com.transsion.player.orplayer.e;
import com.transsion.search.bean.HotRankItem;
import ij.g;
import ij.i;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import p6.a;
import ui.i1;
import ui.m0;

@Keep
@Metadata(d1 = {"\u0000y\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b#\n\u0002\u0010\u000b\n\u0002\b$\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0003\b¾\u0001\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\bb\b\u0017\u0018\u0000 Ë\u00032\u00020\u00012\u00020\u0002:\u0002Ì\u0003B\u0081\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\u000f\u001a\u00020\b\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0014\u001a\u00020\b\u0012\b\b\u0002\u0010\u0015\u001a\u00020\b\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0010\u0012\b\b\u0002\u0010 \u001a\u00020\u0010\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010%\u001a\u00020\b\u0012\b\b\u0002\u0010&\u001a\u00020\u0010\u0012\b\b\u0002\u0010'\u001a\u00020\u0010\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010*\u001a\u00020\b\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010-\u001a\u00020\b\u0012\b\b\u0002\u0010.\u001a\u00020\u0010\u0012\b\b\u0002\u0010/\u001a\u00020\b\u0012\n\b\u0002\u00100\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u00101\u001a\u00020\u0010\u0012\n\b\u0002\u00102\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u00103\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u00105\u001a\u000204\u0012\b\b\u0002\u00106\u001a\u000204\u0012\b\b\u0002\u00107\u001a\u00020\u0010\u0012\n\b\u0002\u00108\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u00109\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010:\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010;\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010<\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010=\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010>\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010?\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010@\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010A\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010B\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010C\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010D\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010E\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010F\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010G\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010H\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010I\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010J\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010K\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010L\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010M\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010N\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010O\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010P\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010Q\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010R\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010S\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010T\u001a\u000204\u0012\n\b\u0002\u0010U\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010V\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\bW\u0010XJ\u001a\u0010[\u001a\u0002042\b\u0010Z\u001a\u0004\u0018\u00010YH\u0096\u0002¢\u0006\u0004\b[\u0010\\J\u000f\u0010]\u001a\u00020\u0010H\u0016¢\u0006\u0004\b]\u0010^J\r\u0010_\u001a\u000204¢\u0006\u0004\b_\u0010`J\u0015\u0010b\u001a\u00020a2\u0006\u0010\u0011\u001a\u000204¢\u0006\u0004\bb\u0010cJ\u0017\u0010e\u001a\u00020\u00032\b\b\u0002\u0010d\u001a\u000204¢\u0006\u0004\be\u0010fJ\u0011\u0010g\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\bg\u0010hJ\u0011\u0010i\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\bi\u0010hJ\u0011\u0010j\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\bj\u0010hJ\u0011\u0010k\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\bk\u0010hJ\u0011\u0010l\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\bl\u0010hJ\u0011\u0010m\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\bm\u0010nJ\u0011\u0010o\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\bo\u0010hJ\u0011\u0010p\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\bp\u0010hJ\u0011\u0010q\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\bq\u0010hJ\u0011\u0010r\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\br\u0010hJ\u000f\u0010s\u001a\u00020\u0010H\u0016¢\u0006\u0004\bs\u0010^J\u000f\u0010t\u001a\u000204H\u0016¢\u0006\u0004\bt\u0010`J\u0017\u0010v\u001a\u00020a2\u0006\u0010u\u001a\u000204H\u0016¢\u0006\u0004\bv\u0010cR\"\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010w\u001a\u0004\bx\u0010h\"\u0004\by\u0010zR$\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010w\u001a\u0004\b{\u0010h\"\u0004\b|\u0010zR$\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010w\u001a\u0004\b}\u0010h\"\u0004\b~\u0010zR%\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0013\n\u0004\b\u0007\u0010w\u001a\u0004\b\u007f\u0010h\"\u0005\b\u0080\u0001\u0010zR(\u0010\t\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0016\n\u0005\b\t\u0010\u0081\u0001\u001a\u0005\b\u0082\u0001\u0010n\"\u0006\b\u0083\u0001\u0010\u0084\u0001R&\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0014\n\u0004\b\n\u0010w\u001a\u0005\b\u0085\u0001\u0010h\"\u0005\b\u0086\u0001\u0010zR&\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0014\n\u0004\b\u000b\u0010w\u001a\u0005\b\u0087\u0001\u0010h\"\u0005\b\u0088\u0001\u0010zR&\u0010\f\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0014\n\u0004\b\f\u0010w\u001a\u0005\b\u0089\u0001\u0010h\"\u0005\b\u008a\u0001\u0010zR(\u0010\r\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0016\n\u0005\b\r\u0010\u0081\u0001\u001a\u0005\b\u008b\u0001\u0010n\"\u0006\b\u008c\u0001\u0010\u0084\u0001R(\u0010\u000e\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0016\n\u0005\b\u000e\u0010\u0081\u0001\u001a\u0005\b\u008d\u0001\u0010n\"\u0006\b\u008e\u0001\u0010\u0084\u0001R'\u0010\u000f\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0005\b\u000f\u0010\u008f\u0001\u001a\u0006\b\u0090\u0001\u0010\u0091\u0001\"\u0006\b\u0092\u0001\u0010\u0093\u0001R%\u0010\u0011\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u0011\u0010\u0094\u0001\u001a\u0005\b\u0095\u0001\u0010^\"\u0005\bb\u0010\u0096\u0001R&\u0010\u0012\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0016\n\u0005\b\u0012\u0010\u0094\u0001\u001a\u0005\b\u0097\u0001\u0010^\"\u0006\b\u0098\u0001\u0010\u0096\u0001R&\u0010\u0013\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0016\n\u0005\b\u0013\u0010\u0094\u0001\u001a\u0005\b\u0099\u0001\u0010^\"\u0006\b\u009a\u0001\u0010\u0096\u0001R'\u0010\u0014\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0005\b\u0014\u0010\u008f\u0001\u001a\u0006\b\u009b\u0001\u0010\u0091\u0001\"\u0006\b\u009c\u0001\u0010\u0093\u0001R'\u0010\u0015\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0005\b\u0015\u0010\u008f\u0001\u001a\u0006\b\u009d\u0001\u0010\u0091\u0001\"\u0006\b\u009e\u0001\u0010\u0093\u0001R%\u0010\u0016\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u0016\u0010\u0094\u0001\u001a\u0004\b\u0016\u0010^\"\u0006\b\u009f\u0001\u0010\u0096\u0001R&\u0010\u0017\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0005\b\u0017\u0010\u0094\u0001\u001a\u0005\b \u0001\u0010^\"\u0006\b¡\u0001\u0010\u0096\u0001R&\u0010\u0018\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0016\n\u0005\b\u0018\u0010\u0094\u0001\u001a\u0005\b¢\u0001\u0010^\"\u0006\b£\u0001\u0010\u0096\u0001R&\u0010\u0019\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0016\n\u0005\b\u0019\u0010\u0094\u0001\u001a\u0005\b¤\u0001\u0010^\"\u0006\b¥\u0001\u0010\u0096\u0001R&\u0010\u001a\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0016\n\u0005\b\u001a\u0010\u0094\u0001\u001a\u0005\b¦\u0001\u0010^\"\u0006\b§\u0001\u0010\u0096\u0001R&\u0010\u001b\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0016\n\u0005\b\u001b\u0010\u0094\u0001\u001a\u0005\b¨\u0001\u0010^\"\u0006\b©\u0001\u0010\u0096\u0001R&\u0010\u001c\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0016\n\u0005\b\u001c\u0010\u0094\u0001\u001a\u0005\bª\u0001\u0010^\"\u0006\b«\u0001\u0010\u0096\u0001R&\u0010\u001d\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0016\n\u0005\b\u001d\u0010\u0094\u0001\u001a\u0005\b¬\u0001\u0010^\"\u0006\b\u00ad\u0001\u0010\u0096\u0001R&\u0010\u001e\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0016\n\u0005\b\u001e\u0010\u0094\u0001\u001a\u0005\b®\u0001\u0010^\"\u0006\b¯\u0001\u0010\u0096\u0001R&\u0010\u001f\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0016\n\u0005\b\u001f\u0010\u0094\u0001\u001a\u0005\b°\u0001\u0010^\"\u0006\b±\u0001\u0010\u0096\u0001R&\u0010 \u001a\u00020\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0016\n\u0005\b \u0010\u0094\u0001\u001a\u0005\b²\u0001\u0010^\"\u0006\b³\u0001\u0010\u0096\u0001R&\u0010!\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0014\n\u0004\b!\u0010w\u001a\u0005\b´\u0001\u0010h\"\u0005\bµ\u0001\u0010zR&\u0010\"\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0014\n\u0004\b\"\u0010w\u001a\u0005\b¶\u0001\u0010h\"\u0005\b·\u0001\u0010zR&\u0010#\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0014\n\u0004\b#\u0010w\u001a\u0005\b¸\u0001\u0010h\"\u0005\b¹\u0001\u0010zR&\u0010$\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0014\n\u0004\b$\u0010w\u001a\u0005\bº\u0001\u0010h\"\u0005\b»\u0001\u0010zR'\u0010%\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0005\b%\u0010\u008f\u0001\u001a\u0006\b¼\u0001\u0010\u0091\u0001\"\u0006\b½\u0001\u0010\u0093\u0001R&\u0010&\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0016\n\u0005\b&\u0010\u0094\u0001\u001a\u0005\b¾\u0001\u0010^\"\u0006\b¿\u0001\u0010\u0096\u0001R&\u0010'\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0016\n\u0005\b'\u0010\u0094\u0001\u001a\u0005\bÀ\u0001\u0010^\"\u0006\bÁ\u0001\u0010\u0096\u0001R&\u0010(\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0014\n\u0004\b(\u0010w\u001a\u0005\bÂ\u0001\u0010h\"\u0005\bÃ\u0001\u0010zR&\u0010)\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0014\n\u0004\b)\u0010w\u001a\u0005\bÄ\u0001\u0010h\"\u0005\bÅ\u0001\u0010zR'\u0010*\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0005\b*\u0010\u008f\u0001\u001a\u0006\bÆ\u0001\u0010\u0091\u0001\"\u0006\bÇ\u0001\u0010\u0093\u0001R&\u0010+\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0014\n\u0004\b+\u0010w\u001a\u0005\bÈ\u0001\u0010h\"\u0005\bÉ\u0001\u0010zR&\u0010,\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0014\n\u0004\b,\u0010w\u001a\u0005\bÊ\u0001\u0010h\"\u0005\bË\u0001\u0010zR'\u0010-\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0005\b-\u0010\u008f\u0001\u001a\u0006\bÌ\u0001\u0010\u0091\u0001\"\u0006\bÍ\u0001\u0010\u0093\u0001R&\u0010.\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0016\n\u0005\b.\u0010\u0094\u0001\u001a\u0005\bÎ\u0001\u0010^\"\u0006\bÏ\u0001\u0010\u0096\u0001R'\u0010/\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0005\b/\u0010\u008f\u0001\u001a\u0006\bÐ\u0001\u0010\u0091\u0001\"\u0006\bÑ\u0001\u0010\u0093\u0001R&\u00100\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0014\n\u0004\b0\u0010w\u001a\u0005\bÒ\u0001\u0010h\"\u0005\bÓ\u0001\u0010zR&\u00101\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0016\n\u0005\b1\u0010\u0094\u0001\u001a\u0005\bÔ\u0001\u0010^\"\u0006\bÕ\u0001\u0010\u0096\u0001R&\u00102\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0014\n\u0004\b2\u0010w\u001a\u0005\bÖ\u0001\u0010h\"\u0005\b×\u0001\u0010zR&\u00103\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0014\n\u0004\b3\u0010w\u001a\u0005\bØ\u0001\u0010h\"\u0005\bÙ\u0001\u0010zR$\u00105\u001a\u0002048\u0006@\u0006X\u0086\u000e¢\u0006\u0014\n\u0005\b5\u0010Ú\u0001\u001a\u0004\b5\u0010`\"\u0005\bÛ\u0001\u0010cR$\u00106\u001a\u0002048\u0006@\u0006X\u0086\u000e¢\u0006\u0014\n\u0005\b6\u0010Ú\u0001\u001a\u0004\b6\u0010`\"\u0005\bÜ\u0001\u0010cR&\u00107\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0016\n\u0005\b7\u0010\u0094\u0001\u001a\u0005\bÝ\u0001\u0010^\"\u0006\bÞ\u0001\u0010\u0096\u0001R&\u00108\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0014\n\u0004\b8\u0010w\u001a\u0005\bß\u0001\u0010h\"\u0005\bà\u0001\u0010zR)\u00109\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0005\b9\u0010á\u0001\u001a\u0006\bâ\u0001\u0010ã\u0001\"\u0006\bä\u0001\u0010å\u0001R&\u0010:\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0014\n\u0004\b:\u0010w\u001a\u0005\bæ\u0001\u0010h\"\u0005\bç\u0001\u0010zR&\u0010;\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0014\n\u0004\b;\u0010w\u001a\u0005\bè\u0001\u0010h\"\u0005\bé\u0001\u0010zR&\u0010<\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0014\n\u0004\b<\u0010w\u001a\u0005\bê\u0001\u0010h\"\u0005\bë\u0001\u0010zR&\u0010=\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0014\n\u0004\b=\u0010w\u001a\u0005\bì\u0001\u0010h\"\u0005\bí\u0001\u0010zR&\u0010>\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0014\n\u0004\b>\u0010w\u001a\u0005\bî\u0001\u0010h\"\u0005\bï\u0001\u0010zR&\u0010?\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0014\n\u0004\b?\u0010w\u001a\u0005\bð\u0001\u0010h\"\u0005\bñ\u0001\u0010zR)\u0010@\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0005\b@\u0010á\u0001\u001a\u0006\bò\u0001\u0010ã\u0001\"\u0006\bó\u0001\u0010å\u0001R&\u0010A\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0014\n\u0004\bA\u0010w\u001a\u0005\bô\u0001\u0010h\"\u0005\bõ\u0001\u0010zR&\u0010B\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0014\n\u0004\bB\u0010w\u001a\u0005\bö\u0001\u0010h\"\u0005\b÷\u0001\u0010zR(\u0010C\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0016\n\u0005\bC\u0010\u0081\u0001\u001a\u0005\bø\u0001\u0010n\"\u0006\bù\u0001\u0010\u0084\u0001R(\u0010D\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0016\n\u0005\bD\u0010\u0081\u0001\u001a\u0005\bú\u0001\u0010n\"\u0006\bû\u0001\u0010\u0084\u0001R&\u0010E\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0014\n\u0004\bE\u0010w\u001a\u0005\bü\u0001\u0010h\"\u0005\bý\u0001\u0010zR&\u0010F\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0014\n\u0004\bF\u0010w\u001a\u0005\bþ\u0001\u0010h\"\u0005\bÿ\u0001\u0010zR&\u0010G\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0014\n\u0004\bG\u0010w\u001a\u0005\b\u0080\u0002\u0010h\"\u0005\b\u0081\u0002\u0010zR&\u0010H\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0014\n\u0004\bH\u0010w\u001a\u0005\b\u0082\u0002\u0010h\"\u0005\b\u0083\u0002\u0010zR&\u0010I\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0014\n\u0004\bI\u0010w\u001a\u0005\b\u0084\u0002\u0010h\"\u0005\b\u0085\u0002\u0010zR)\u0010J\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0005\bJ\u0010á\u0001\u001a\u0006\b\u0086\u0002\u0010ã\u0001\"\u0006\b\u0087\u0002\u0010å\u0001R&\u0010K\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0014\n\u0004\bK\u0010w\u001a\u0005\b\u0088\u0002\u0010h\"\u0005\b\u0089\u0002\u0010zR)\u0010L\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0005\bL\u0010á\u0001\u001a\u0006\b\u008a\u0002\u0010ã\u0001\"\u0006\b\u008b\u0002\u0010å\u0001R)\u0010M\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0005\bM\u0010á\u0001\u001a\u0006\b\u008c\u0002\u0010ã\u0001\"\u0006\b\u008d\u0002\u0010å\u0001R)\u0010N\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0005\bN\u0010á\u0001\u001a\u0006\b\u008e\u0002\u0010ã\u0001\"\u0006\b\u008f\u0002\u0010å\u0001R)\u0010O\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0005\bO\u0010á\u0001\u001a\u0006\b\u0090\u0002\u0010ã\u0001\"\u0006\b\u0091\u0002\u0010å\u0001R&\u0010P\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0014\n\u0004\bP\u0010w\u001a\u0005\b\u0092\u0002\u0010h\"\u0005\b\u0093\u0002\u0010zR&\u0010Q\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0014\n\u0004\bQ\u0010w\u001a\u0005\b\u0094\u0002\u0010h\"\u0005\b\u0095\u0002\u0010zR&\u0010R\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0014\n\u0004\bR\u0010w\u001a\u0005\b\u0096\u0002\u0010h\"\u0005\b\u0097\u0002\u0010zR&\u0010S\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0014\n\u0004\bS\u0010w\u001a\u0005\b\u0098\u0002\u0010h\"\u0005\b\u0099\u0002\u0010zR%\u0010T\u001a\u0002048\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\bT\u0010Ú\u0001\u001a\u0005\b\u009a\u0002\u0010`\"\u0005\b\u009b\u0002\u0010cR&\u0010U\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0014\n\u0004\bU\u0010w\u001a\u0005\b\u009c\u0002\u0010h\"\u0005\b\u009d\u0002\u0010zR&\u0010V\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0014\n\u0004\bV\u0010w\u001a\u0005\b\u009e\u0002\u0010h\"\u0005\b\u009f\u0002\u0010zR,\u0010¡\u0002\u001a\u0005\u0018\u00010 \u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0006\b¡\u0002\u0010¢\u0002\u001a\u0006\b£\u0002\u0010¤\u0002\"\u0006\b¥\u0002\u0010¦\u0002R1\u0010©\u0002\u001a\n\u0012\u0005\u0012\u00030¨\u00020§\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0006\b©\u0002\u0010ª\u0002\u001a\u0006\b«\u0002\u0010¬\u0002\"\u0006\b\u00ad\u0002\u0010®\u0002R,\u0010°\u0002\u001a\u0005\u0018\u00010¯\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0006\b°\u0002\u0010±\u0002\u001a\u0006\b²\u0002\u0010³\u0002\"\u0006\b´\u0002\u0010µ\u0002R'\u0010¶\u0002\u001a\u0002048\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0006\b¶\u0002\u0010Ú\u0001\u001a\u0005\b¶\u0002\u0010`\"\u0005\b·\u0002\u0010cR(\u0010¸\u0002\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0017\n\u0006\b¸\u0002\u0010\u0094\u0001\u001a\u0005\b¹\u0002\u0010^\"\u0006\bº\u0002\u0010\u0096\u0001R'\u0010»\u0002\u001a\u0002048\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0006\b»\u0002\u0010Ú\u0001\u001a\u0005\b»\u0002\u0010`\"\u0005\b¼\u0002\u0010cR(\u0010½\u0002\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0017\n\u0006\b½\u0002\u0010\u0094\u0001\u001a\u0005\b¾\u0002\u0010^\"\u0006\b¿\u0002\u0010\u0096\u0001R(\u0010À\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\bÀ\u0002\u0010w\u001a\u0005\bÁ\u0002\u0010h\"\u0005\bÂ\u0002\u0010zR)\u0010Ã\u0002\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0006\bÃ\u0002\u0010\u008f\u0001\u001a\u0006\bÄ\u0002\u0010\u0091\u0001\"\u0006\bÅ\u0002\u0010\u0093\u0001R'\u0010Æ\u0002\u001a\u0002048\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0006\bÆ\u0002\u0010Ú\u0001\u001a\u0005\bÆ\u0002\u0010`\"\u0005\bÇ\u0002\u0010cR(\u0010È\u0002\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0017\n\u0006\bÈ\u0002\u0010\u0094\u0001\u001a\u0005\bÉ\u0002\u0010^\"\u0006\bÊ\u0002\u0010\u0096\u0001R,\u0010Ì\u0002\u001a\u0005\u0018\u00010Ë\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0006\bÌ\u0002\u0010Í\u0002\u001a\u0006\bÎ\u0002\u0010Ï\u0002\"\u0006\bÐ\u0002\u0010Ñ\u0002R(\u0010Ò\u0002\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0017\n\u0006\bÒ\u0002\u0010\u0094\u0001\u001a\u0005\bÓ\u0002\u0010^\"\u0006\bÔ\u0002\u0010\u0096\u0001R(\u0010Õ\u0002\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0017\n\u0006\bÕ\u0002\u0010\u0094\u0001\u001a\u0005\bÖ\u0002\u0010^\"\u0006\b×\u0002\u0010\u0096\u0001R(\u0010Ø\u0002\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0017\n\u0006\bØ\u0002\u0010\u0094\u0001\u001a\u0005\bÙ\u0002\u0010^\"\u0006\bÚ\u0002\u0010\u0096\u0001R1\u0010Ü\u0002\u001a\n\u0012\u0005\u0012\u00030Û\u00020§\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0006\bÜ\u0002\u0010ª\u0002\u001a\u0006\bÝ\u0002\u0010¬\u0002\"\u0006\bÞ\u0002\u0010®\u0002R'\u0010ß\u0002\u001a\u0002048\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0006\bß\u0002\u0010Ú\u0001\u001a\u0005\bß\u0002\u0010`\"\u0005\bà\u0002\u0010cR0\u0010á\u0002\u001a\t\u0012\u0004\u0012\u00020\u00000§\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0006\bá\u0002\u0010ª\u0002\u001a\u0006\bâ\u0002\u0010¬\u0002\"\u0006\bã\u0002\u0010®\u0002R,\u0010å\u0002\u001a\u0005\u0018\u00010ä\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0006\bå\u0002\u0010æ\u0002\u001a\u0006\bç\u0002\u0010è\u0002\"\u0006\bé\u0002\u0010ê\u0002R,\u0010ì\u0002\u001a\u0005\u0018\u00010ë\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0006\bì\u0002\u0010í\u0002\u001a\u0006\bî\u0002\u0010ï\u0002\"\u0006\bð\u0002\u0010ñ\u0002R$\u0010u\u001a\u0002048\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0005\bu\u0010Ú\u0001\u001a\u0004\bu\u0010`\"\u0005\bò\u0002\u0010cR)\u0010ó\u0002\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0006\bó\u0002\u0010\u008f\u0001\u001a\u0006\bô\u0002\u0010\u0091\u0001\"\u0006\bõ\u0002\u0010\u0093\u0001R)\u0010ö\u0002\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0006\bö\u0002\u0010\u008f\u0001\u001a\u0006\b÷\u0002\u0010\u0091\u0001\"\u0006\bø\u0002\u0010\u0093\u0001R'\u0010ù\u0002\u001a\u0002048\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0006\bù\u0002\u0010Ú\u0001\u001a\u0005\bú\u0002\u0010`\"\u0005\bû\u0002\u0010cR0\u0010ü\u0002\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u001f\n\u0006\bü\u0002\u0010\u0094\u0001\u0012\u0006\bÿ\u0002\u0010\u0080\u0003\u001a\u0005\bý\u0002\u0010^\"\u0006\bþ\u0002\u0010\u0096\u0001R'\u0010\u0081\u0003\u001a\u0002048\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0006\b\u0081\u0003\u0010Ú\u0001\u001a\u0005\b\u0081\u0003\u0010`\"\u0005\b\u0082\u0003\u0010cR'\u0010\u0083\u0003\u001a\u0002048\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0006\b\u0083\u0003\u0010Ú\u0001\u001a\u0005\b\u0083\u0003\u0010`\"\u0005\b\u0084\u0003\u0010cR(\u0010\u0085\u0003\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0017\n\u0006\b\u0085\u0003\u0010\u0094\u0001\u001a\u0005\b\u0086\u0003\u0010^\"\u0006\b\u0087\u0003\u0010\u0096\u0001R(\u0010\u0088\u0003\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0017\n\u0006\b\u0088\u0003\u0010\u0094\u0001\u001a\u0005\b\u0089\u0003\u0010^\"\u0006\b\u008a\u0003\u0010\u0096\u0001R'\u0010\u008b\u0003\u001a\u0002048\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0006\b\u008b\u0003\u0010Ú\u0001\u001a\u0005\b\u008b\u0003\u0010`\"\u0005\b\u008c\u0003\u0010cR'\u0010\u008d\u0003\u001a\u0002048\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0006\b\u008d\u0003\u0010Ú\u0001\u001a\u0005\b\u008d\u0003\u0010`\"\u0005\b\u008e\u0003\u0010cR+\u0010\u008f\u0003\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0006\b\u008f\u0003\u0010á\u0001\u001a\u0006\b\u0090\u0003\u0010ã\u0001\"\u0006\b\u0091\u0003\u0010å\u0001R'\u0010\u0092\u0003\u001a\u0002048\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0006\b\u0092\u0003\u0010Ú\u0001\u001a\u0005\b\u0092\u0003\u0010`\"\u0005\b\u0093\u0003\u0010cR&\u0010\u0094\u0003\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b\u0094\u0003\u0010w\u001a\u0005\b\u0095\u0003\u0010h\"\u0005\b\u0096\u0003\u0010zR'\u0010\u0097\u0003\u001a\u0002048\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0006\b\u0097\u0003\u0010Ú\u0001\u001a\u0005\b\u0097\u0003\u0010`\"\u0005\b\u0098\u0003\u0010cR'\u0010\u0099\u0003\u001a\u0002048\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0006\b\u0099\u0003\u0010Ú\u0001\u001a\u0005\b\u0099\u0003\u0010`\"\u0005\b\u009a\u0003\u0010cR(\u0010\u009b\u0003\u001a\u00020\u00108\u0016@\u0016X\u0097\u000e¢\u0006\u0017\n\u0006\b\u009b\u0003\u0010\u0094\u0001\u001a\u0005\b\u009c\u0003\u0010^\"\u0006\b\u009d\u0003\u0010\u0096\u0001R\u001a\u0010\u009e\u0003\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0083\u000e¢\u0006\u0007\n\u0005\b\u009e\u0003\u0010wR\u001a\u0010\u009f\u0003\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0083\u000e¢\u0006\u0007\n\u0005\b\u009f\u0003\u0010wR\u001a\u0010 \u0003\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0083\u000e¢\u0006\u0007\n\u0005\b \u0003\u0010wR\u001a\u0010¡\u0003\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0083\u000e¢\u0006\u0007\n\u0005\b¡\u0003\u0010wR\u0013\u0010¢\u0003\u001a\u0002048F¢\u0006\u0007\u001a\u0005\b¢\u0003\u0010`R\u0013\u0010£\u0003\u001a\u0002048F¢\u0006\u0007\u001a\u0005\b£\u0003\u0010`R\u0013\u0010¤\u0003\u001a\u0002048F¢\u0006\u0007\u001a\u0005\b¤\u0003\u0010`R\u0013\u0010¥\u0003\u001a\u0002048F¢\u0006\u0007\u001a\u0005\b¥\u0003\u0010`R\u0013\u0010¦\u0003\u001a\u0002048F¢\u0006\u0007\u001a\u0005\b¦\u0003\u0010`R\u0013\u0010§\u0003\u001a\u0002048F¢\u0006\u0007\u001a\u0005\b§\u0003\u0010`R\u0013\u0010¨\u0003\u001a\u0002048F¢\u0006\u0007\u001a\u0005\b¨\u0003\u0010`R\u0013\u0010©\u0003\u001a\u0002048F¢\u0006\u0007\u001a\u0005\b©\u0003\u0010`R\u0013\u0010ª\u0003\u001a\u0002048F¢\u0006\u0007\u001a\u0005\bª\u0003\u0010`R\u0013\u0010¬\u0003\u001a\u0002048F¢\u0006\u0007\u001a\u0005\b«\u0003\u0010`R\u0013\u0010\u00ad\u0003\u001a\u0002048F¢\u0006\u0007\u001a\u0005\b\u00ad\u0003\u0010`R\u0013\u0010®\u0003\u001a\u0002048F¢\u0006\u0007\u001a\u0005\b®\u0003\u0010`R\u0013\u0010¯\u0003\u001a\u0002048F¢\u0006\u0007\u001a\u0005\b¯\u0003\u0010`R\u0013\u0010±\u0003\u001a\u00020\u00038F¢\u0006\u0007\u001a\u0005\b°\u0003\u0010hR\u0013\u0010³\u0003\u001a\u00020\u00038F¢\u0006\u0007\u001a\u0005\b²\u0003\u0010hR\u0013\u0010µ\u0003\u001a\u00020\u00038F¢\u0006\u0007\u001a\u0005\b´\u0003\u0010hR\u0013\u0010·\u0003\u001a\u00020\u00038F¢\u0006\u0007\u001a\u0005\b¶\u0003\u0010hR\u0013\u0010¹\u0003\u001a\u00020\u00038F¢\u0006\u0007\u001a\u0005\b¸\u0003\u0010hR\u0013\u0010»\u0003\u001a\u00020\u00038F¢\u0006\u0007\u001a\u0005\bº\u0003\u0010hR\u0013\u0010¼\u0003\u001a\u0002048F¢\u0006\u0007\u001a\u0005\b¼\u0003\u0010`R\u0013\u0010½\u0003\u001a\u0002048F¢\u0006\u0007\u001a\u0005\b½\u0003\u0010`R\u0013\u0010¾\u0003\u001a\u0002048F¢\u0006\u0007\u001a\u0005\b¾\u0003\u0010`R\u0013\u0010¿\u0003\u001a\u0002048F¢\u0006\u0007\u001a\u0005\b¿\u0003\u0010`R\u0013\u0010À\u0003\u001a\u0002048F¢\u0006\u0007\u001a\u0005\bÀ\u0003\u0010`R\u0013\u0010Á\u0003\u001a\u0002048F¢\u0006\u0007\u001a\u0005\bÁ\u0003\u0010`R\u0013\u0010Â\u0003\u001a\u0002048F¢\u0006\u0007\u001a\u0005\bÂ\u0003\u0010`R\u0013\u0010Ã\u0003\u001a\u0002048F¢\u0006\u0007\u001a\u0005\bÃ\u0003\u0010`R\u0013\u0010Ä\u0003\u001a\u0002048F¢\u0006\u0007\u001a\u0005\bÄ\u0003\u0010`R\u0013\u0010Å\u0003\u001a\u0002048F¢\u0006\u0007\u001a\u0005\bÅ\u0003\u0010`R\u0013\u0010Ç\u0003\u001a\u00020\u00038F¢\u0006\u0007\u001a\u0005\bÆ\u0003\u0010hR\u0013\u0010É\u0003\u001a\u00020\u00038F¢\u0006\u0007\u001a\u0005\bÈ\u0003\u0010hR\u0013\u0010Ê\u0003\u001a\u0002048F¢\u0006\u0007\u001a\u0005\bÊ\u0003\u0010`¨\u0006Í\u0003"}, d2 = {"Lcom/transsion/baselib/db/download/DownloadBean;", "Lp6/a;", "Lui/i1;", BuildConfig.FLAVOR, "url", "resourceId", "name", "cover", BuildConfig.FLAVOR, "size", "postId", "sizeFormat", "path", "duration", "updateTimeStamp", "progress", BuildConfig.FLAVOR, "supportRanges", "status", "type", "readProgress", "createAt", "isRead", "epse", "ep", "se", "resolution", "resourcePosition", "multiresolution", "videoWidth", "videoHeight", "downloadErrorCount", "subtitleStarted", "subjectId", "pageFrom", "lastPageFrom", "subjectName", "lastPlayTimeStamp", "fileType", "totalEpisode", "uploadBy", "sourceUrl", "urlCreateAt", "subtitleSelectId", "taskId", "sessionTime", "reportStatus", "downloadHeaderSize", "rootPath", "rootPathType", "thumbnail", "averageHueLight", BuildConfig.FLAVOR, "isTransferFailed", "isClosedTransferFailed", "subjectType", "genre", "subjectDurationSeconds", "currentDubLanName", "currentDubLanCode", "ops", "restrictLevel", "releaseDate", "countryName", "seNum", "subtitles", "imdbRate", "lastAdStartTimeStamp", "lastAdEndTimeStamp", "subtitleIdType", "ugcVideoCollectionId", "ugcVideoId", "ugcVideoName", "ugcVideoCollectionName", "ugcVideoPosition", "ugcVideoType", "ugcCateLev1Id", "ugcCateLev2Id", "ugcCateLev3Id", "ugcCateLev4Id", "ugcVideoTrackId", "ugcVideoParentVideoId", "ugcVideoParentTrackId", "ugcVideoEpTitle", "ugcVideoIsVertical", "originData", "kidId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;JIIIJJIIIIIIIIIIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JIILjava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;JIJLjava/lang/String;ILjava/lang/String;Ljava/lang/String;ZZILjava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;)V", BuildConfig.FLAVOR, "o", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "isSupportRanges", "()Z", BuildConfig.FLAVOR, "setSupportRanges", "(Z)V", "showSe", "getEpTitleName", "(Z)Ljava/lang/String;", "videoCoverUrl", "()Ljava/lang/String;", "videoThumbnail", "videoTitle", "videoEpTitle", "videoCorner", "videoDuration", "()Ljava/lang/Long;", "videoResourceId", "videoUGCId", "videoUGCType", "videoUGCWatchNum", "videoUGCPosition", "isVideoPlaying", "isPlaying", "setVideoIsPlaying", "Ljava/lang/String;", "getUrl", "setUrl", "(Ljava/lang/String;)V", "getResourceId", "setResourceId", "getName", "setName", "getCover", "setCover", "Ljava/lang/Long;", "getSize", "setSize", "(Ljava/lang/Long;)V", "getPostId", "setPostId", "getSizeFormat", "setSizeFormat", "getPath", "setPath", "getDuration", "setDuration", "getUpdateTimeStamp", "setUpdateTimeStamp", "J", "getProgress", "()J", "setProgress", "(J)V", "I", "getSupportRanges", "(I)V", "getStatus", "setStatus", "getType", "setType", "getReadProgress", "setReadProgress", "getCreateAt", "setCreateAt", "setRead", "getEpse", "setEpse", "getEp", "setEp", "getSe", "setSe", "getResolution", "setResolution", "getResourcePosition", "setResourcePosition", "getMultiresolution", "setMultiresolution", "getVideoWidth", "setVideoWidth", "getVideoHeight", "setVideoHeight", "getDownloadErrorCount", "setDownloadErrorCount", "getSubtitleStarted", "setSubtitleStarted", "getSubjectId", "setSubjectId", "getPageFrom", "setPageFrom", "getLastPageFrom", "setLastPageFrom", "getSubjectName", "setSubjectName", "getLastPlayTimeStamp", "setLastPlayTimeStamp", "getFileType", "setFileType", "getTotalEpisode", "setTotalEpisode", "getUploadBy", "setUploadBy", "getSourceUrl", "setSourceUrl", "getUrlCreateAt", "setUrlCreateAt", "getSubtitleSelectId", "setSubtitleSelectId", "getTaskId", "setTaskId", "getSessionTime", "setSessionTime", "getReportStatus", "setReportStatus", "getDownloadHeaderSize", "setDownloadHeaderSize", "getRootPath", "setRootPath", "getRootPathType", "setRootPathType", "getThumbnail", "setThumbnail", "getAverageHueLight", "setAverageHueLight", "Z", "setTransferFailed", "setClosedTransferFailed", "getSubjectType", "setSubjectType", "getGenre", "setGenre", "Ljava/lang/Integer;", "getSubjectDurationSeconds", "()Ljava/lang/Integer;", "setSubjectDurationSeconds", "(Ljava/lang/Integer;)V", "getCurrentDubLanName", "setCurrentDubLanName", "getCurrentDubLanCode", "setCurrentDubLanCode", "getOps", "setOps", "getRestrictLevel", "setRestrictLevel", "getReleaseDate", "setReleaseDate", "getCountryName", "setCountryName", "getSeNum", "setSeNum", "getSubtitles", "setSubtitles", "getImdbRate", "setImdbRate", "getLastAdStartTimeStamp", "setLastAdStartTimeStamp", "getLastAdEndTimeStamp", "setLastAdEndTimeStamp", "getSubtitleIdType", "setSubtitleIdType", "getUgcVideoCollectionId", "setUgcVideoCollectionId", "getUgcVideoId", "setUgcVideoId", "getUgcVideoName", "setUgcVideoName", "getUgcVideoCollectionName", "setUgcVideoCollectionName", "getUgcVideoPosition", "setUgcVideoPosition", "getUgcVideoType", "setUgcVideoType", "getUgcCateLev1Id", "setUgcCateLev1Id", "getUgcCateLev2Id", "setUgcCateLev2Id", "getUgcCateLev3Id", "setUgcCateLev3Id", "getUgcCateLev4Id", "setUgcCateLev4Id", "getUgcVideoTrackId", "setUgcVideoTrackId", "getUgcVideoParentVideoId", "setUgcVideoParentVideoId", "getUgcVideoParentTrackId", "setUgcVideoParentTrackId", "getUgcVideoEpTitle", "setUgcVideoEpTitle", "getUgcVideoIsVertical", "setUgcVideoIsVertical", "getOriginData", "setOriginData", "getKidId", "setKidId", "Lui/m0;", "downloadListener", "Lui/m0;", "getDownloadListener", "()Lui/m0;", "setDownloadListener", "(Lui/m0;)V", BuildConfig.FLAVOR, "Lcom/transsion/baselib/db/download/DownloadRange;", "downloadRanges", "Ljava/util/List;", "getDownloadRanges", "()Ljava/util/List;", "setDownloadRanges", "(Ljava/util/List;)V", "Lcom/transsion/baselib/db/download/DownloadException;", "exception", "Lcom/transsion/baselib/db/download/DownloadException;", "getException", "()Lcom/transsion/baselib/db/download/DownloadException;", "setException", "(Lcom/transsion/baselib/db/download/DownloadException;)V", "isMore", "setMore", "count", "getCount", "setCount", "isCheck", "setCheck", "index", "getIndex", "setIndex", "groupId", "getGroupId", "setGroupId", "lastProgress", "getLastProgress", "setLastProgress", "isStartRequested", "setStartRequested", "audioStatus", "getAudioStatus", "setAudioStatus", "Lcom/transsion/player/orplayer/e;", "audioListener", "Lcom/transsion/player/orplayer/e;", "getAudioListener", "()Lcom/transsion/player/orplayer/e;", "setAudioListener", "(Lcom/transsion/player/orplayer/e;)V", "errorCount", "getErrorCount", "setErrorCount", "restartDownloadCount", "getRestartDownloadCount", "setRestartDownloadCount", "requestNewSourceCount", "getRequestNewSourceCount", "setRequestNewSourceCount", "Lcom/transsion/baselib/db/download/SubtitleBean;", "subtitleList", "getSubtitleList", "setSubtitleList", "isPreDownload", "setPreDownload", "seriesList", "getSeriesList", "setSeriesList", "Lcom/hisavana/common/interfacz/TAdListener;", "adProvide", "Lcom/hisavana/common/interfacz/TAdListener;", "getAdProvide", "()Lcom/hisavana/common/interfacz/TAdListener;", "setAdProvide", "(Lcom/hisavana/common/interfacz/TAdListener;)V", "Lcom/hisavana/common/interfacz/TAdditionalListener;", "wrapNativeManager", "Lcom/hisavana/common/interfacz/TAdditionalListener;", "getWrapNativeManager", "()Lcom/hisavana/common/interfacz/TAdditionalListener;", "setWrapNativeManager", "(Lcom/hisavana/common/interfacz/TAdditionalListener;)V", "setPlaying", "currentOffset", "getCurrentOffset", "setCurrentOffset", "currentDownloadSpeed", "getCurrentDownloadSpeed", "setCurrentDownloadSpeed", "reDownload", "getReDownload", "setReDownload", "preStatus", "getPreStatus", "setPreStatus", "getPreStatus$annotations", "()V", "isDownloadingPlay", "setDownloadingPlay", "isQuitDPRestart", "setQuitDPRestart", "preErrorCode", "getPreErrorCode", "setPreErrorCode", "position", "getPosition", "setPosition", "isStream", "setStream", "isStreamVideoDetail", "setStreamVideoDetail", "requireMemberType", "getRequireMemberType", "setRequireMemberType", "isAutoPause", "setAutoPause", "playingUrl", "getPlayingUrl", "setPlayingUrl", "isSeriesAllCheck", "setSeriesAllCheck", "isFroYouList", "setFroYouList", "itemType", "getItemType", "setItemType", "titleNameLocal", "titleNameReLocal", "epNameLocal", "totalTitleNameLocal", "isUnable", "isSeries", "isSeriesCollection", "isMultiresolution", "isPause", "isVideo", "isCompleted", "isRemoved", "isDownloading", "getCanPlay", "canPlay", "isOutside", "isInnerRes", "isInnerSubjectRes", "getTitleName", "titleName", "getTitleNameAppendResolution", "titleNameAppendResolution", "getEpName", "epName", "getTotalTitleName", "totalTitleName", "getFileName", "fileName", "getPostIdNotNull", "postIdNotNull", "isFileExist", "isAllFileExist", "isSaved", "isCNDError", "is4xxError", "isNoNetError", "isMusic", "isShotTV", "isShorts", "isDownloadInSDCard", "getSubtitleResId", "subtitleResId", "getCreateAtFormat", "createAtFormat", "isUGCVideo", "Companion", "a", "BaseLib_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public class DownloadBean implements a, i1 {
    public static final int AUDIO = 1;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int DOWNLOAD_ERROR_MAX_COUNT = 15;
    public static final int INNER = 1;
    public static final int MOVIE = 2;
    public static final int OUTSIDE = 2;
    public static final int PATH_TYPE_ALBUM = 3;
    public static final int PATH_TYPE_BM_INNER = 1;
    public static final int PATH_TYPE_SDCARD = 2;
    public static final int POST = 9;
    public static final int READ = 2;
    public static final int SERVER_AUDIO = 4;
    public static final int SERVER_EDUCATION = 5;
    public static final int SERVER_MOVIE = 1;
    public static final int SERVER_MUSIC = 6;
    public static final int SERVER_SHORT_TV = 7;
    public static final int SERVER_TV = 2;
    public static final int SERVER_VSHOW = 3;
    public static final int SHORT_TV = 8;
    public static final int STATUS_AD_ITEM = 13;
    public static final int STATUS_ALL_EP_BTN = 14;
    public static final int STATUS_COMPLETED = 5;
    public static final int STATUS_COMPLETED_REMOVED = 57;
    public static final int STATUS_DOWNLOADING = 2;
    public static final int STATUS_ERROR = 6;
    public static final int STATUS_HIDE_MORE = 12;
    public static final int STATUS_NONE = 0;
    public static final int STATUS_PATH = 15;
    public static final int STATUS_PAUSED = 4;
    public static final int STATUS_PREPARE_DOWNLOAD = 1;
    public static final int STATUS_REMOVED = 7;
    public static final int STATUS_SERIES = 10;
    public static final int STATUS_TITLE = 11;
    public static final int STATUS_WAIT = 3;
    public static final int TRANSFER_RECEIVED = 3;
    public static final int TV = 3;
    public static final int TYPE_EDUCATION = 5;
    public static final int TYPE_MUSIC = 6;
    public static final int TYPE_STREAM = 7;
    public static final int UNREAD = 1;
    private TAdListener adProvide;
    private e audioListener;
    private int audioStatus;
    private String averageHueLight;
    private int count;
    private String countryName;
    private String cover;
    private long createAt;
    private long currentDownloadSpeed;
    private String currentDubLanCode;
    private String currentDubLanName;
    private long currentOffset;
    private int downloadErrorCount;
    private long downloadHeaderSize;
    private m0 downloadListener;
    private List<DownloadRange> downloadRanges;
    private Long duration;
    private int ep;
    private String epNameLocal;
    private int epse;
    private int errorCount;
    private DownloadException exception;
    private int fileType;
    private String genre;
    private String groupId;
    private String imdbRate;
    private int index;
    private boolean isAutoPause;
    private boolean isCheck;
    private boolean isClosedTransferFailed;
    private boolean isDownloadingPlay;
    private boolean isFroYouList;
    private boolean isMore;
    private boolean isPlaying;
    private boolean isPreDownload;
    private boolean isQuitDPRestart;
    private int isRead;
    private boolean isSeriesAllCheck;
    private boolean isStartRequested;
    private boolean isStream;
    private boolean isStreamVideoDetail;
    private boolean isTransferFailed;
    private int itemType;
    private String kidId;
    private Long lastAdEndTimeStamp;
    private Long lastAdStartTimeStamp;
    private String lastPageFrom;
    private long lastPlayTimeStamp;
    private long lastProgress;
    private int multiresolution;
    private String name;
    private String ops;
    private String originData;
    private String pageFrom;
    private String path;
    private String playingUrl;
    private int position;
    private String postId;
    private int preErrorCode;
    private int preStatus;
    private volatile long progress;
    private boolean reDownload;
    private long readProgress;
    private String releaseDate;
    private int reportStatus;
    private int requestNewSourceCount;
    private Integer requireMemberType;
    private int resolution;
    private String resourceId;
    private int resourcePosition;
    private int restartDownloadCount;
    private String restrictLevel;
    private String rootPath;
    private int rootPathType;
    private int se;
    private Integer seNum;
    private List<DownloadBean> seriesList;
    private long sessionTime;
    private Long size;
    private String sizeFormat;
    private String sourceUrl;
    private int status;
    private Integer subjectDurationSeconds;
    private String subjectId;
    private String subjectName;
    private int subjectType;
    private String subtitleIdType;
    private List<SubtitleBean> subtitleList;
    private String subtitleSelectId;
    private int subtitleStarted;
    private String subtitles;
    private int supportRanges;
    private String taskId;
    private String thumbnail;
    private String titleNameLocal;
    private String titleNameReLocal;
    private int totalEpisode;
    private String totalTitleNameLocal;
    private int type;
    private Integer ugcCateLev1Id;
    private Integer ugcCateLev2Id;
    private Integer ugcCateLev3Id;
    private Integer ugcCateLev4Id;
    private String ugcVideoCollectionId;
    private String ugcVideoCollectionName;
    private String ugcVideoEpTitle;
    private String ugcVideoId;
    private boolean ugcVideoIsVertical;
    private String ugcVideoName;
    private String ugcVideoParentTrackId;
    private String ugcVideoParentVideoId;
    private Integer ugcVideoPosition;
    private String ugcVideoTrackId;
    private String ugcVideoType;
    private Long updateTimeStamp;
    private String uploadBy;
    private String url;
    private long urlCreateAt;
    private int videoHeight;
    private int videoWidth;
    private TAdditionalListener wrapNativeManager;

    /* renamed from: com.transsion.baselib.db.download.DownloadBean$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a(Integer num) {
            int i = 2;
            if (num != null && num.intValue() == 2) {
                return 1;
            }
            if (num == null || num.intValue() != 3) {
                if (num != null && num.intValue() == 1) {
                    return 4;
                }
                if (num != null && num.intValue() == 5) {
                    return 5;
                }
                if (num == null) {
                    return 1;
                }
                i = 6;
                if (num.intValue() != 6) {
                    return 1;
                }
            }
            return i;
        }

        public final boolean b(int i) {
            return i == 2 || i == 3 || i == 5 || i == 6;
        }

        /* JADX WARN: Code restructure failed: missing block: B:20:0x002c, code lost:
        
            if (r6.intValue() == 5) goto L23;
         */
        /* JADX WARN: Code restructure failed: missing block: B:22:?, code lost:
        
            return r3;
         */
        /* JADX WARN: Code restructure failed: missing block: B:25:0x0038, code lost:
        
            if (r6.intValue() == 6) goto L23;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final int c(Integer num) {
            if (num != null && num.intValue() == 1) {
                return 2;
            }
            if (num == null || num.intValue() != 2) {
                if (num != null && num.intValue() == 4) {
                    return 1;
                }
                int i = num != null ? 5 : 6;
                if (num != null) {
                }
                if (num == null || num.intValue() != 7) {
                    return 2;
                }
            }
            return 3;
        }
    }

    public DownloadBean(String str, String str2, String str3, String str4, Long l, String str5, String str6, String str7, Long l2, Long l3, long j, int i, int i2, int i3, long j2, long j3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14, String str8, String str9, String str10, String str11, long j4, int i15, int i16, String str12, String str13, long j5, String str14, String str15, long j6, int i17, long j7, String str16, int i18, String str17, String str18, boolean z, boolean z2, int i19, String str19, Integer num, String str20, String str21, String str22, String str23, String str24, String str25, Integer num2, String str26, String str27, Long l4, Long l5, String str28, String str29, String str30, String str31, String str32, Integer num3, String str33, Integer num4, Integer num5, Integer num6, Integer num7, String str34, String str35, String str36, String str37, boolean z3, String str38, String str39) {
        Intrinsics.h(str, "url");
        this.url = str;
        this.resourceId = str2;
        this.name = str3;
        this.cover = str4;
        this.size = l;
        this.postId = str5;
        this.sizeFormat = str6;
        this.path = str7;
        this.duration = l2;
        this.updateTimeStamp = l3;
        this.progress = j;
        this.supportRanges = i;
        this.status = i2;
        this.type = i3;
        this.readProgress = j2;
        this.createAt = j3;
        this.isRead = i4;
        this.epse = i5;
        this.ep = i6;
        this.se = i7;
        this.resolution = i8;
        this.resourcePosition = i9;
        this.multiresolution = i10;
        this.videoWidth = i11;
        this.videoHeight = i12;
        this.downloadErrorCount = i13;
        this.subtitleStarted = i14;
        this.subjectId = str8;
        this.pageFrom = str9;
        this.lastPageFrom = str10;
        this.subjectName = str11;
        this.lastPlayTimeStamp = j4;
        this.fileType = i15;
        this.totalEpisode = i16;
        this.uploadBy = str12;
        this.sourceUrl = str13;
        this.urlCreateAt = j5;
        this.subtitleSelectId = str14;
        this.taskId = str15;
        this.sessionTime = j6;
        this.reportStatus = i17;
        this.downloadHeaderSize = j7;
        this.rootPath = str16;
        this.rootPathType = i18;
        this.thumbnail = str17;
        this.averageHueLight = str18;
        this.isTransferFailed = z;
        this.isClosedTransferFailed = z2;
        this.subjectType = i19;
        this.genre = str19;
        this.subjectDurationSeconds = num;
        this.currentDubLanName = str20;
        this.currentDubLanCode = str21;
        this.ops = str22;
        this.restrictLevel = str23;
        this.releaseDate = str24;
        this.countryName = str25;
        this.seNum = num2;
        this.subtitles = str26;
        this.imdbRate = str27;
        this.lastAdStartTimeStamp = l4;
        this.lastAdEndTimeStamp = l5;
        this.subtitleIdType = str28;
        this.ugcVideoCollectionId = str29;
        this.ugcVideoId = str30;
        this.ugcVideoName = str31;
        this.ugcVideoCollectionName = str32;
        this.ugcVideoPosition = num3;
        this.ugcVideoType = str33;
        this.ugcCateLev1Id = num4;
        this.ugcCateLev2Id = num5;
        this.ugcCateLev3Id = num6;
        this.ugcCateLev4Id = num7;
        this.ugcVideoTrackId = str34;
        this.ugcVideoParentVideoId = str35;
        this.ugcVideoParentTrackId = str36;
        this.ugcVideoEpTitle = str37;
        this.ugcVideoIsVertical = z3;
        this.originData = str38;
        this.kidId = str39;
        this.downloadRanges = new CopyOnWriteArrayList();
        this.groupId = BuildConfig.FLAVOR;
        this.subtitleList = new CopyOnWriteArrayList();
        this.seriesList = new ArrayList();
        this.preErrorCode = -1;
        this.requireMemberType = 0;
        this.playingUrl = BuildConfig.FLAVOR;
        this.isSeriesAllCheck = true;
        this.itemType = this.status;
    }

    public /* synthetic */ DownloadBean(String str, String str2, String str3, String str4, Long l, String str5, String str6, String str7, Long l2, Long l3, long j, int i, int i2, int i3, long j2, long j3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14, String str8, String str9, String str10, String str11, long j4, int i15, int i16, String str12, String str13, long j5, String str14, String str15, long j6, int i17, long j7, String str16, int i18, String str17, String str18, boolean z, boolean z2, int i19, String str19, Integer num, String str20, String str21, String str22, String str23, String str24, String str25, Integer num2, String str26, String str27, Long l4, Long l5, String str28, String str29, String str30, String str31, String str32, Integer num3, String str33, Integer num4, Integer num5, Integer num6, Integer num7, String str34, String str35, String str36, String str37, boolean z3, String str38, String str39, int i20, int i21, int i22, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, str4, l, (i20 & 32) != 0 ? BuildConfig.FLAVOR : str5, (i20 & 64) != 0 ? BuildConfig.FLAVOR : str6, (i20 & 128) != 0 ? BuildConfig.FLAVOR : str7, (i20 & 256) != 0 ? 0L : l2, (i20 & DownloadException.EXCEPTION_IO_SSL_PEER_UNVERIFIED) != 0 ? Long.valueOf(System.currentTimeMillis()) : l3, (i20 & 1024) != 0 ? 0L : j, (i20 & 2048) != 0 ? 0 : i, (i20 & 4096) != 0 ? 0 : i2, (i20 & 8192) != 0 ? 2 : i3, (i20 & 16384) != 0 ? 0L : j2, (i20 & 32768) != 0 ? System.currentTimeMillis() : j3, (i20 & 65536) != 0 ? 1 : i4, (i20 & 131072) != 0 ? 0 : i5, (i20 & 262144) != 0 ? 0 : i6, (i20 & 524288) != 0 ? 0 : i7, (i20 & 1048576) != 0 ? 0 : i8, (i20 & 2097152) != 0 ? 0 : i9, (i20 & 4194304) != 0 ? 0 : i10, (i20 & 8388608) != 0 ? 0 : i11, (i20 & 16777216) != 0 ? 0 : i12, (i20 & 33554432) != 0 ? 0 : i13, (i20 & 67108864) != 0 ? 0 : i14, (i20 & 134217728) != 0 ? BuildConfig.FLAVOR : str8, (i20 & 268435456) != 0 ? BuildConfig.FLAVOR : str9, (i20 & 536870912) != 0 ? BuildConfig.FLAVOR : str10, (i20 & 1073741824) != 0 ? BuildConfig.FLAVOR : str11, (i20 & Integer.MIN_VALUE) != 0 ? 0L : j4, (i21 & 1) != 0 ? 1 : i15, (i21 & 2) != 0 ? 1 : i16, (i21 & 4) != 0 ? BuildConfig.FLAVOR : str12, (i21 & 8) != 0 ? BuildConfig.FLAVOR : str13, (i21 & 16) != 0 ? 0L : j5, (i21 & 32) != 0 ? BuildConfig.FLAVOR : str14, (i21 & 64) != 0 ? BuildConfig.FLAVOR : str15, (i21 & 128) != 0 ? 0L : j6, (i21 & 256) != 0 ? 0 : i17, (i21 & DownloadException.EXCEPTION_IO_SSL_PEER_UNVERIFIED) != 0 ? 0L : j7, (i21 & 1024) != 0 ? BuildConfig.FLAVOR : str16, (i21 & 2048) != 0 ? 1 : i18, (i21 & 4096) != 0 ? BuildConfig.FLAVOR : str17, (i21 & 8192) != 0 ? null : str18, (i21 & 16384) != 0 ? false : z, (i21 & 32768) != 0 ? false : z2, (i21 & 65536) != 0 ? 1 : i19, (i21 & 131072) != 0 ? null : str19, (i21 & 262144) != 0 ? 0 : num, (i21 & 524288) != 0 ? null : str20, (i21 & 1048576) != 0 ? null : str21, (2097152 & i21) == 0 ? str22 : BuildConfig.FLAVOR, (4194304 & i21) != 0 ? null : str23, (8388608 & i21) != 0 ? null : str24, (16777216 & i21) != 0 ? null : str25, (33554432 & i21) != 0 ? 0 : num2, (67108864 & i21) != 0 ? null : str26, (134217728 & i21) != 0 ? null : str27, (268435456 & i21) != 0 ? null : l4, (536870912 & i21) != 0 ? null : l5, (1073741824 & i21) != 0 ? null : str28, (i21 & Integer.MIN_VALUE) != 0 ? null : str29, (i22 & 1) != 0 ? null : str30, (i22 & 2) != 0 ? null : str31, (i22 & 4) != 0 ? null : str32, (i22 & 8) != 0 ? null : num3, (i22 & 16) != 0 ? null : str33, (i22 & 32) != 0 ? null : num4, (i22 & 64) != 0 ? null : num5, (i22 & 128) != 0 ? null : num6, (i22 & 256) != 0 ? null : num7, (i22 & DownloadException.EXCEPTION_IO_SSL_PEER_UNVERIFIED) != 0 ? null : str34, (i22 & 1024) != 0 ? null : str35, (i22 & 2048) != 0 ? null : str36, (i22 & 4096) != 0 ? null : str37, (i22 & 8192) != 0 ? false : z3, (i22 & 16384) != 0 ? null : str38, (i22 & 32768) != 0 ? null : str39);
    }

    public static /* synthetic */ String getEpTitleName$default(DownloadBean downloadBean, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getEpTitleName");
        }
        if ((i & 1) != 0) {
            z = true;
        }
        return downloadBean.getEpTitleName(z);
    }

    public static /* synthetic */ void getPreStatus$annotations() {
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || !Intrinsics.c(getClass(), o.getClass())) {
            return false;
        }
        return StringsKt.I(this.resourceId, ((DownloadBean) o).resourceId, false, 2, (Object) null);
    }

    public final TAdListener getAdProvide() {
        return this.adProvide;
    }

    public final e getAudioListener() {
        return this.audioListener;
    }

    public final int getAudioStatus() {
        return this.audioStatus;
    }

    public final String getAverageHueLight() {
        return this.averageHueLight;
    }

    public final boolean getCanPlay() {
        int i = this.status;
        return (i == 0 || i == 7) ? false : true;
    }

    public final int getCount() {
        return this.count;
    }

    public final String getCountryName() {
        return this.countryName;
    }

    public final String getCover() {
        return this.cover;
    }

    public final long getCreateAt() {
        return this.createAt;
    }

    public final String getCreateAtFormat() {
        String h = c0.h(this.createAt);
        Intrinsics.g(h, "millis2String(...)");
        return h;
    }

    public final long getCurrentDownloadSpeed() {
        return this.currentDownloadSpeed;
    }

    public final String getCurrentDubLanCode() {
        return this.currentDubLanCode;
    }

    public final String getCurrentDubLanName() {
        return this.currentDubLanName;
    }

    public final long getCurrentOffset() {
        return this.currentOffset;
    }

    public final int getDownloadErrorCount() {
        return this.downloadErrorCount;
    }

    public final long getDownloadHeaderSize() {
        return this.downloadHeaderSize;
    }

    public final m0 getDownloadListener() {
        return this.downloadListener;
    }

    public final List<DownloadRange> getDownloadRanges() {
        return this.downloadRanges;
    }

    public final Long getDuration() {
        return this.duration;
    }

    public final int getEp() {
        return this.ep;
    }

    public final String getEpName() {
        String str = this.ugcVideoId;
        if (str != null && str.length() != 0) {
            return BuildConfig.FLAVOR;
        }
        String str2 = this.epNameLocal;
        if (str2 != null && str2.length() > 0) {
            String str3 = this.epNameLocal;
            Intrinsics.e(str3);
            return str3;
        }
        if (!isSeries() || this.status == 10) {
            return BuildConfig.FLAVOR;
        }
        int i = this.ep;
        if (i > 0) {
            String b = i.b(i, this.se, Integer.valueOf(this.type));
            this.epNameLocal = b;
            Intrinsics.e(b);
            return b;
        }
        String c = i.c(this.epse, isVideo());
        this.epNameLocal = c;
        Intrinsics.e(c);
        return c;
    }

    public final String getEpTitleName(boolean showSe) {
        if (this.subjectType == 5) {
            return "Lesson " + this.ep + i.d(this.name);
        }
        if (showSe) {
            return getEpName() + i.d(this.name);
        }
        return i.a(this.ep) + i.d(this.name);
    }

    public final int getEpse() {
        return this.epse;
    }

    public final int getErrorCount() {
        return this.errorCount;
    }

    public final DownloadException getException() {
        return this.exception;
    }

    public final String getFileName() {
        String str;
        String str2;
        String str3;
        String str4;
        boolean isSeries = isSeries();
        String str5 = BuildConfig.FLAVOR;
        if ((isSeries || this.status == 10) && (str = this.subjectName) != null && str.length() > 0) {
            String str6 = this.subjectName;
            if (str6 == null) {
                str6 = BuildConfig.FLAVOR;
            }
            int i = this.resolution;
            if (i > 0) {
                str2 = "_" + i + "P";
            } else {
                str2 = BuildConfig.FLAVOR;
            }
            str3 = str6 + str2;
        } else if (this.resolution <= 0 || (str4 = this.subjectName) == null || str4.length() <= 0) {
            str3 = this.name;
            if (str3 == null) {
                str3 = BuildConfig.FLAVOR;
            }
        } else {
            str3 = this.subjectName + "_" + this.resolution + "P";
        }
        if (getEpName().length() > 0) {
            str5 = " " + getEpName();
        }
        return StringsKt.Q(str3 + str5, " ", "_", false, 4, (Object) null);
    }

    public final int getFileType() {
        return this.fileType;
    }

    public final String getGenre() {
        return this.genre;
    }

    public final String getGroupId() {
        return this.groupId;
    }

    public final String getImdbRate() {
        return this.imdbRate;
    }

    public final int getIndex() {
        return this.index;
    }

    public int getItemType() {
        return this.itemType;
    }

    public final String getKidId() {
        return this.kidId;
    }

    public final Long getLastAdEndTimeStamp() {
        return this.lastAdEndTimeStamp;
    }

    public final Long getLastAdStartTimeStamp() {
        return this.lastAdStartTimeStamp;
    }

    public final String getLastPageFrom() {
        return this.lastPageFrom;
    }

    public final long getLastPlayTimeStamp() {
        return this.lastPlayTimeStamp;
    }

    public final long getLastProgress() {
        return this.lastProgress;
    }

    public final int getMultiresolution() {
        return this.multiresolution;
    }

    public final String getName() {
        return this.name;
    }

    public final String getOps() {
        return this.ops;
    }

    public final String getOriginData() {
        return this.originData;
    }

    public final String getPageFrom() {
        return this.pageFrom;
    }

    public final String getPath() {
        return this.path;
    }

    public final String getPlayingUrl() {
        return this.playingUrl;
    }

    public final int getPosition() {
        return this.position;
    }

    public final String getPostId() {
        return this.postId;
    }

    public final String getPostIdNotNull() {
        String str = this.postId;
        if (str != null) {
            return str;
        }
        String str2 = this.resourceId;
        return str2 == null ? String.valueOf(this.url.hashCode()) : str2;
    }

    public final int getPreErrorCode() {
        return this.preErrorCode;
    }

    public final int getPreStatus() {
        return this.preStatus;
    }

    public final long getProgress() {
        return this.progress;
    }

    public final boolean getReDownload() {
        return this.reDownload;
    }

    public final long getReadProgress() {
        return this.readProgress;
    }

    public final String getReleaseDate() {
        return this.releaseDate;
    }

    public final int getReportStatus() {
        return this.reportStatus;
    }

    public final int getRequestNewSourceCount() {
        return this.requestNewSourceCount;
    }

    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    public final Integer getRequireMemberType() {
        return 0;
    }

    public final int getResolution() {
        return this.resolution;
    }

    public final String getResourceId() {
        return this.resourceId;
    }

    public final int getResourcePosition() {
        return this.resourcePosition;
    }

    public final int getRestartDownloadCount() {
        return this.restartDownloadCount;
    }

    public final String getRestrictLevel() {
        return this.restrictLevel;
    }

    public final String getRootPath() {
        return this.rootPath;
    }

    public final int getRootPathType() {
        return this.rootPathType;
    }

    public final int getSe() {
        return this.se;
    }

    public final Integer getSeNum() {
        return this.seNum;
    }

    public final List<DownloadBean> getSeriesList() {
        return this.seriesList;
    }

    public final long getSessionTime() {
        return this.sessionTime;
    }

    public final Long getSize() {
        return this.size;
    }

    public final String getSizeFormat() {
        return this.sizeFormat;
    }

    public final String getSourceUrl() {
        return this.sourceUrl;
    }

    public final int getStatus() {
        return this.status;
    }

    public final Integer getSubjectDurationSeconds() {
        return this.subjectDurationSeconds;
    }

    public final String getSubjectId() {
        return this.subjectId;
    }

    public final String getSubjectName() {
        return this.subjectName;
    }

    public final int getSubjectType() {
        return this.subjectType;
    }

    public final String getSubtitleIdType() {
        return this.subtitleIdType;
    }

    public final List<SubtitleBean> getSubtitleList() {
        return this.subtitleList;
    }

    public final String getSubtitleResId() {
        if (isUGCVideo()) {
            return this.ugcVideoId + "_" + this.subtitleIdType;
        }
        return this.subjectId + "_" + this.se + "_" + this.ep + "_en_" + (this.isStream ? 2 : 1);
    }

    public final String getSubtitleSelectId() {
        return this.subtitleSelectId;
    }

    public final int getSubtitleStarted() {
        return this.subtitleStarted;
    }

    public final String getSubtitles() {
        return this.subtitles;
    }

    public final int getSupportRanges() {
        return this.supportRanges;
    }

    public final String getTaskId() {
        return this.taskId;
    }

    public final String getThumbnail() {
        return this.thumbnail;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x002e, code lost:
    
        if (r0 == null) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0030, code lost:
    
        r0 = com.transsion.gslb.BuildConfig.FLAVOR;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x003e, code lost:
    
        if (r0 == null) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0042, code lost:
    
        if (r0 == null) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0083, code lost:
    
        if (r0 == null) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0088, code lost:
    
        if (r0 == null) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String getTitleName() {
        String str;
        String str2;
        String str3;
        String str4;
        String str5 = this.titleNameLocal;
        if (str5 != null && str5.length() > 0) {
            str = this.titleNameLocal;
            if (str == null) {
                return BuildConfig.FLAVOR;
            }
        } else if (isUGCVideo()) {
            if (this.status != 10 || (str4 = this.ugcVideoCollectionName) == null || str4.length() == 0) {
                str = this.ugcVideoName;
                if (str != null) {
                    if (StringsKt.q0(str)) {
                        str = null;
                    }
                }
                str = this.name;
            } else {
                str = this.ugcVideoCollectionName;
            }
        } else if (isSeries() || (this.status == 10 && (str3 = this.subjectName) != null && str3.length() > 0)) {
            str = this.subjectName;
        } else {
            if (this.resolution <= 0 || (str2 = this.subjectName) == null || str2.length() <= 0) {
                str = this.name;
            } else {
                str = this.resolution + "P " + this.subjectName;
            }
            this.titleNameLocal = str;
            if (str == null) {
                return BuildConfig.FLAVOR;
            }
        }
        return str;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x002e, code lost:
    
        if (r0 == null) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0030, code lost:
    
        r0 = com.transsion.gslb.BuildConfig.FLAVOR;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x003f, code lost:
    
        if (r0 == null) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0043, code lost:
    
        if (r0 == null) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0084, code lost:
    
        if (r0 == null) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String getTitleNameAppendResolution() {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6 = this.titleNameReLocal;
        if (str6 != null && str6.length() > 0) {
            str2 = this.titleNameReLocal;
            if (str2 == null) {
                return BuildConfig.FLAVOR;
            }
        } else if (!isUGCVideo()) {
            if (isSeries() || (this.status == 10 && (str4 = this.subjectName) != null && str4.length() > 0)) {
                String str7 = this.subjectName;
                if (str7 == null) {
                    str7 = BuildConfig.FLAVOR;
                }
                int i = this.resolution;
                if (i > 0) {
                    str = " " + i + "P";
                } else {
                    str = BuildConfig.FLAVOR;
                }
                str2 = str7 + str;
            } else if (this.resolution <= 0 || (str3 = this.subjectName) == null || str3.length() <= 0) {
                str2 = this.name;
            } else {
                str2 = this.resolution + "P " + this.subjectName;
            }
            this.titleNameReLocal = str2;
            if (str2 == null) {
                return BuildConfig.FLAVOR;
            }
        } else if (this.status != 10 || (str5 = this.ugcVideoCollectionName) == null || str5.length() == 0) {
            str2 = this.ugcVideoName;
            if (str2 != null) {
                if (StringsKt.q0(str2)) {
                    str2 = null;
                }
            }
            str2 = this.name;
        } else {
            str2 = this.ugcVideoCollectionName;
        }
        return str2;
    }

    public final int getTotalEpisode() {
        return this.totalEpisode;
    }

    public final String getTotalTitleName() {
        String str = this.totalTitleNameLocal;
        if (str != null && str.length() > 0) {
            String str2 = this.totalTitleNameLocal;
            Intrinsics.e(str2);
            return str2;
        }
        String str3 = getTitleName() + " " + getEpName();
        this.totalTitleNameLocal = str3;
        Intrinsics.e(str3);
        return str3;
    }

    public final int getType() {
        return this.type;
    }

    public final Integer getUgcCateLev1Id() {
        return this.ugcCateLev1Id;
    }

    public final Integer getUgcCateLev2Id() {
        return this.ugcCateLev2Id;
    }

    public final Integer getUgcCateLev3Id() {
        return this.ugcCateLev3Id;
    }

    public final Integer getUgcCateLev4Id() {
        return this.ugcCateLev4Id;
    }

    public final String getUgcVideoCollectionId() {
        return this.ugcVideoCollectionId;
    }

    public final String getUgcVideoCollectionName() {
        return this.ugcVideoCollectionName;
    }

    public final String getUgcVideoEpTitle() {
        return this.ugcVideoEpTitle;
    }

    public final String getUgcVideoId() {
        return this.ugcVideoId;
    }

    public final boolean getUgcVideoIsVertical() {
        return this.ugcVideoIsVertical;
    }

    public final String getUgcVideoName() {
        return this.ugcVideoName;
    }

    public final String getUgcVideoParentTrackId() {
        return this.ugcVideoParentTrackId;
    }

    public final String getUgcVideoParentVideoId() {
        return this.ugcVideoParentVideoId;
    }

    public final Integer getUgcVideoPosition() {
        return this.ugcVideoPosition;
    }

    public final String getUgcVideoTrackId() {
        return this.ugcVideoTrackId;
    }

    public final String getUgcVideoType() {
        return this.ugcVideoType;
    }

    public final Long getUpdateTimeStamp() {
        return this.updateTimeStamp;
    }

    public final String getUploadBy() {
        return this.uploadBy;
    }

    public final String getUrl() {
        return this.url;
    }

    public final long getUrlCreateAt() {
        return this.urlCreateAt;
    }

    public final int getVideoHeight() {
        return this.videoHeight;
    }

    public final int getVideoWidth() {
        return this.videoWidth;
    }

    public final TAdditionalListener getWrapNativeManager() {
        return this.wrapNativeManager;
    }

    public int hashCode() {
        String str = this.resourceId;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public final boolean is4xxError() {
        DownloadException downloadException = this.exception;
        int responseCode = downloadException != null ? downloadException.getResponseCode() : 0;
        return 400 <= responseCode && responseCode < 500;
    }

    public final boolean isAllFileExist() {
        if (this.status != 10) {
            return isFileExist();
        }
        Iterator<DownloadBean> it = this.seriesList.iterator();
        while (it.hasNext()) {
            if (it.next().isFileExist()) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: isAutoPause, reason: from getter */
    public final boolean getIsAutoPause() {
        return this.isAutoPause;
    }

    public final boolean isCNDError() {
        DownloadException.Companion companion = DownloadException.INSTANCE;
        DownloadException downloadException = this.exception;
        if (!companion.c(downloadException != null ? downloadException.getCode() : 0)) {
            DownloadException downloadException2 = this.exception;
            int responseCode = downloadException2 != null ? downloadException2.getResponseCode() : 0;
            if (500 > responseCode || responseCode >= 600) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: isCheck, reason: from getter */
    public final boolean getIsCheck() {
        return this.isCheck;
    }

    /* renamed from: isClosedTransferFailed, reason: from getter */
    public final boolean getIsClosedTransferFailed() {
        return this.isClosedTransferFailed;
    }

    public final boolean isCompleted() {
        return this.status == 5;
    }

    public final boolean isDownloadInSDCard() {
        return this.rootPathType == 2;
    }

    public final boolean isDownloading() {
        int i = this.status;
        return i == 1 || i == 2;
    }

    /* renamed from: isDownloadingPlay, reason: from getter */
    public final boolean getIsDownloadingPlay() {
        return this.isDownloadingPlay;
    }

    public final boolean isFileExist() {
        String str = this.path;
        if (str == null || str.length() == 0) {
            return false;
        }
        String str2 = this.path;
        Intrinsics.e(str2);
        if (StringsKt.W(str2, "content", false, 2, (Object) null)) {
            k1.a g = k1.a.g(Utils.a(), Uri.parse(this.path));
            if (g != null) {
                return g.e();
            }
        } else {
            String str3 = this.path;
            Intrinsics.e(str3);
            File file = new File(str3);
            if (!file.exists() || file.length() <= 0) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: isFroYouList, reason: from getter */
    public final boolean getIsFroYouList() {
        return this.isFroYouList;
    }

    public final boolean isInnerRes() {
        return this.fileType == 1;
    }

    public final boolean isInnerSubjectRes() {
        if (this.fileType == 1) {
            String str = this.resourceId;
            if ((str != null ? StringsKt.x(str) : null) != null) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: isMore, reason: from getter */
    public final boolean getIsMore() {
        return this.isMore;
    }

    public final boolean isMultiresolution() {
        return this.multiresolution > 0;
    }

    public final boolean isMusic() {
        String str = this.ugcVideoId;
        return (str == null || str.length() == 0) ? this.type == 6 : Intrinsics.c(this.ugcVideoType, HotRankItem.CATE_MUSIC);
    }

    public final boolean isNoNetError() {
        DownloadException downloadException = this.exception;
        return Intrinsics.c(downloadException != null ? downloadException.getMessage() : null, DownloadException.EXCEPTION_MESSAGE_NO_NET);
    }

    public final boolean isOutside() {
        return this.fileType == 2;
    }

    public final boolean isPause() {
        int i = this.status;
        return i == 4 || i == 6 || i == 7 || i == 3;
    }

    /* renamed from: isPlaying, reason: from getter */
    public final boolean getIsPlaying() {
        return this.isPlaying;
    }

    /* renamed from: isPreDownload, reason: from getter */
    public final boolean getIsPreDownload() {
        return this.isPreDownload;
    }

    /* renamed from: isQuitDPRestart, reason: from getter */
    public final boolean getIsQuitDPRestart() {
        return this.isQuitDPRestart;
    }

    /* renamed from: isRead, reason: from getter */
    public final int getIsRead() {
        return this.isRead;
    }

    public final boolean isRemoved() {
        return this.status == 7;
    }

    public final boolean isSaved() {
        String str;
        String str2 = this.path;
        if (str2 == null || str2.length() == 0) {
            return false;
        }
        String str3 = this.path;
        if (str3 == null || (str = StringsKt.f1(str3, "/", (String) null, 2, (Object) null)) == null) {
            str = BuildConfig.FLAVOR;
        }
        File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).getAbsolutePath() + File.separatorChar + "MovieBox", str);
        return file.exists() && file.length() > 0;
    }

    public final boolean isSeries() {
        return this.epse > 0 || this.ep > 0 || this.totalEpisode > 1;
    }

    /* renamed from: isSeriesAllCheck, reason: from getter */
    public final boolean getIsSeriesAllCheck() {
        return this.isSeriesAllCheck;
    }

    public final boolean isSeriesCollection() {
        return this.status == 10;
    }

    public final boolean isShorts() {
        return this.type == 9;
    }

    public final boolean isShotTV() {
        return this.subjectType == 7 || Intrinsics.c(this.ugcVideoType, "ShortTV");
    }

    /* renamed from: isStartRequested, reason: from getter */
    public final boolean getIsStartRequested() {
        return this.isStartRequested;
    }

    /* renamed from: isStream, reason: from getter */
    public final boolean getIsStream() {
        return this.isStream;
    }

    /* renamed from: isStreamVideoDetail, reason: from getter */
    public final boolean getIsStreamVideoDetail() {
        return this.isStreamVideoDetail;
    }

    public final boolean isSupportRanges() {
        return this.supportRanges == 0;
    }

    /* renamed from: isTransferFailed, reason: from getter */
    public final boolean getIsTransferFailed() {
        return this.isTransferFailed;
    }

    public final boolean isUGCVideo() {
        String str = this.ugcVideoId;
        return !(str == null || str.length() == 0) || (g.a.b() && !isInnerRes());
    }

    public final boolean isUnable() {
        int i = this.status;
        return (i == 0 || i == 7) ? false : true;
    }

    public final boolean isVideo() {
        return INSTANCE.b(this.type);
    }

    @Override // ui.i1
    public boolean isVideoPlaying() {
        return this.isPlaying;
    }

    public final void setAdProvide(TAdListener tAdListener) {
        this.adProvide = tAdListener;
    }

    public final void setAudioListener(e eVar) {
        this.audioListener = eVar;
    }

    public final void setAudioStatus(int i) {
        this.audioStatus = i;
    }

    public final void setAutoPause(boolean z) {
        this.isAutoPause = z;
    }

    public final void setAverageHueLight(String str) {
        this.averageHueLight = str;
    }

    public final void setCheck(boolean z) {
        this.isCheck = z;
    }

    public final void setClosedTransferFailed(boolean z) {
        this.isClosedTransferFailed = z;
    }

    public final void setCount(int i) {
        this.count = i;
    }

    public final void setCountryName(String str) {
        this.countryName = str;
    }

    public final void setCover(String str) {
        this.cover = str;
    }

    public final void setCreateAt(long j) {
        this.createAt = j;
    }

    public final void setCurrentDownloadSpeed(long j) {
        this.currentDownloadSpeed = j;
    }

    public final void setCurrentDubLanCode(String str) {
        this.currentDubLanCode = str;
    }

    public final void setCurrentDubLanName(String str) {
        this.currentDubLanName = str;
    }

    public final void setCurrentOffset(long j) {
        this.currentOffset = j;
    }

    public final void setDownloadErrorCount(int i) {
        this.downloadErrorCount = i;
    }

    public final void setDownloadHeaderSize(long j) {
        this.downloadHeaderSize = j;
    }

    public final void setDownloadListener(m0 m0Var) {
        this.downloadListener = m0Var;
    }

    public final void setDownloadRanges(List<DownloadRange> list) {
        Intrinsics.h(list, "<set-?>");
        this.downloadRanges = list;
    }

    public final void setDownloadingPlay(boolean z) {
        this.isDownloadingPlay = z;
    }

    public final void setDuration(Long l) {
        this.duration = l;
    }

    public final void setEp(int i) {
        this.ep = i;
    }

    public final void setEpse(int i) {
        this.epse = i;
    }

    public final void setErrorCount(int i) {
        this.errorCount = i;
    }

    public final void setException(DownloadException downloadException) {
        this.exception = downloadException;
    }

    public final void setFileType(int i) {
        this.fileType = i;
    }

    public final void setFroYouList(boolean z) {
        this.isFroYouList = z;
    }

    public final void setGenre(String str) {
        this.genre = str;
    }

    public final void setGroupId(String str) {
        this.groupId = str;
    }

    public final void setImdbRate(String str) {
        this.imdbRate = str;
    }

    public final void setIndex(int i) {
        this.index = i;
    }

    public void setItemType(int i) {
        this.itemType = i;
    }

    public final void setKidId(String str) {
        this.kidId = str;
    }

    public final void setLastAdEndTimeStamp(Long l) {
        this.lastAdEndTimeStamp = l;
    }

    public final void setLastAdStartTimeStamp(Long l) {
        this.lastAdStartTimeStamp = l;
    }

    public final void setLastPageFrom(String str) {
        this.lastPageFrom = str;
    }

    public final void setLastPlayTimeStamp(long j) {
        this.lastPlayTimeStamp = j;
    }

    public final void setLastProgress(long j) {
        this.lastProgress = j;
    }

    public final void setMore(boolean z) {
        this.isMore = z;
    }

    public final void setMultiresolution(int i) {
        this.multiresolution = i;
    }

    public final void setName(String str) {
        this.name = str;
    }

    public final void setOps(String str) {
        this.ops = str;
    }

    public final void setOriginData(String str) {
        this.originData = str;
    }

    public final void setPageFrom(String str) {
        this.pageFrom = str;
    }

    public final void setPath(String str) {
        this.path = str;
    }

    public final void setPlaying(boolean z) {
        this.isPlaying = z;
    }

    public final void setPlayingUrl(String str) {
        Intrinsics.h(str, "<set-?>");
        this.playingUrl = str;
    }

    public final void setPosition(int i) {
        this.position = i;
    }

    public final void setPostId(String str) {
        this.postId = str;
    }

    public final void setPreDownload(boolean z) {
        this.isPreDownload = z;
    }

    public final void setPreErrorCode(int i) {
        this.preErrorCode = i;
    }

    public final void setPreStatus(int i) {
        this.preStatus = i;
    }

    public final void setProgress(long j) {
        this.progress = j;
    }

    public final void setQuitDPRestart(boolean z) {
        this.isQuitDPRestart = z;
    }

    public final void setReDownload(boolean z) {
        this.reDownload = z;
    }

    public final void setRead(int i) {
        this.isRead = i;
    }

    public final void setReadProgress(long j) {
        this.readProgress = j;
    }

    public final void setReleaseDate(String str) {
        this.releaseDate = str;
    }

    public final void setReportStatus(int i) {
        this.reportStatus = i;
    }

    public final void setRequestNewSourceCount(int i) {
        this.requestNewSourceCount = i;
    }

    public final void setRequireMemberType(Integer num) {
        this.requireMemberType = num;
    }

    public final void setResolution(int i) {
        this.resolution = i;
    }

    public final void setResourceId(String str) {
        this.resourceId = str;
    }

    public final void setResourcePosition(int i) {
        this.resourcePosition = i;
    }

    public final void setRestartDownloadCount(int i) {
        this.restartDownloadCount = i;
    }

    public final void setRestrictLevel(String str) {
        this.restrictLevel = str;
    }

    public final void setRootPath(String str) {
        this.rootPath = str;
    }

    public final void setRootPathType(int i) {
        this.rootPathType = i;
    }

    public final void setSe(int i) {
        this.se = i;
    }

    public final void setSeNum(Integer num) {
        this.seNum = num;
    }

    public final void setSeriesAllCheck(boolean z) {
        this.isSeriesAllCheck = z;
    }

    public final void setSeriesList(List<DownloadBean> list) {
        Intrinsics.h(list, "<set-?>");
        this.seriesList = list;
    }

    public final void setSessionTime(long j) {
        this.sessionTime = j;
    }

    public final void setSize(Long l) {
        this.size = l;
    }

    public final void setSizeFormat(String str) {
        this.sizeFormat = str;
    }

    public final void setSourceUrl(String str) {
        this.sourceUrl = str;
    }

    public final void setStartRequested(boolean z) {
        this.isStartRequested = z;
    }

    public final void setStatus(int i) {
        this.status = i;
    }

    public final void setStream(boolean z) {
        this.isStream = z;
    }

    public final void setStreamVideoDetail(boolean z) {
        this.isStreamVideoDetail = z;
    }

    public final void setSubjectDurationSeconds(Integer num) {
        this.subjectDurationSeconds = num;
    }

    public final void setSubjectId(String str) {
        this.subjectId = str;
    }

    public final void setSubjectName(String str) {
        this.subjectName = str;
    }

    public final void setSubjectType(int i) {
        this.subjectType = i;
    }

    public final void setSubtitleIdType(String str) {
        this.subtitleIdType = str;
    }

    public final void setSubtitleList(List<SubtitleBean> list) {
        Intrinsics.h(list, "<set-?>");
        this.subtitleList = list;
    }

    public final void setSubtitleSelectId(String str) {
        this.subtitleSelectId = str;
    }

    public final void setSubtitleStarted(int i) {
        this.subtitleStarted = i;
    }

    public final void setSubtitles(String str) {
        this.subtitles = str;
    }

    public final void setSupportRanges(int i) {
        this.supportRanges = i;
    }

    public final void setSupportRanges(boolean supportRanges) {
        this.supportRanges = !supportRanges ? 1 : 0;
    }

    public final void setTaskId(String str) {
        this.taskId = str;
    }

    public final void setThumbnail(String str) {
        this.thumbnail = str;
    }

    public final void setTotalEpisode(int i) {
        this.totalEpisode = i;
    }

    public final void setTransferFailed(boolean z) {
        this.isTransferFailed = z;
    }

    public final void setType(int i) {
        this.type = i;
    }

    public final void setUgcCateLev1Id(Integer num) {
        this.ugcCateLev1Id = num;
    }

    public final void setUgcCateLev2Id(Integer num) {
        this.ugcCateLev2Id = num;
    }

    public final void setUgcCateLev3Id(Integer num) {
        this.ugcCateLev3Id = num;
    }

    public final void setUgcCateLev4Id(Integer num) {
        this.ugcCateLev4Id = num;
    }

    public final void setUgcVideoCollectionId(String str) {
        this.ugcVideoCollectionId = str;
    }

    public final void setUgcVideoCollectionName(String str) {
        this.ugcVideoCollectionName = str;
    }

    public final void setUgcVideoEpTitle(String str) {
        this.ugcVideoEpTitle = str;
    }

    public final void setUgcVideoId(String str) {
        this.ugcVideoId = str;
    }

    public final void setUgcVideoIsVertical(boolean z) {
        this.ugcVideoIsVertical = z;
    }

    public final void setUgcVideoName(String str) {
        this.ugcVideoName = str;
    }

    public final void setUgcVideoParentTrackId(String str) {
        this.ugcVideoParentTrackId = str;
    }

    public final void setUgcVideoParentVideoId(String str) {
        this.ugcVideoParentVideoId = str;
    }

    public final void setUgcVideoPosition(Integer num) {
        this.ugcVideoPosition = num;
    }

    public final void setUgcVideoTrackId(String str) {
        this.ugcVideoTrackId = str;
    }

    public final void setUgcVideoType(String str) {
        this.ugcVideoType = str;
    }

    public final void setUpdateTimeStamp(Long l) {
        this.updateTimeStamp = l;
    }

    public final void setUploadBy(String str) {
        this.uploadBy = str;
    }

    public final void setUrl(String str) {
        Intrinsics.h(str, "<set-?>");
        this.url = str;
    }

    public final void setUrlCreateAt(long j) {
        this.urlCreateAt = j;
    }

    public final void setVideoHeight(int i) {
        this.videoHeight = i;
    }

    @Override // ui.i1
    public void setVideoIsPlaying(boolean isPlaying) {
        this.isPlaying = isPlaying;
    }

    public final void setVideoWidth(int i) {
        this.videoWidth = i;
    }

    public final void setWrapNativeManager(TAdditionalListener tAdditionalListener) {
        this.wrapNativeManager = tAdditionalListener;
    }

    @Override // ui.i1
    public String videoCorner() {
        return null;
    }

    @Override // ui.i1
    public String videoCoverUrl() {
        return this.cover;
    }

    @Override // ui.i1
    public Long videoDuration() {
        Long l = this.duration;
        if (l != null) {
            return Long.valueOf(l.longValue() / 1000);
        }
        return null;
    }

    @Override // ui.i1
    public String videoEpTitle() {
        return this.ugcVideoEpTitle;
    }

    @Override // ui.i1
    public String videoResourceId() {
        return this.resourceId;
    }

    @Override // ui.i1
    public String videoThumbnail() {
        return this.thumbnail;
    }

    @Override // ui.i1
    public String videoTitle() {
        return getTitleName();
    }

    @Override // ui.i1
    public String videoUGCId() {
        String str = this.ugcVideoId;
        return str == null ? this.resourceId : str;
    }

    @Override // ui.i1
    public int videoUGCPosition() {
        Integer num = this.ugcVideoPosition;
        if (num != null) {
            return num.intValue();
        }
        return 1;
    }

    @Override // ui.i1
    public String videoUGCType() {
        return this.ugcVideoType;
    }

    @Override // ui.i1
    public String videoUGCWatchNum() {
        return null;
    }
}
