package com.transsion.push.bean;

import androidx.collection.s;
import com.google.gson.annotations.SerializedName;
import com.transsion.baselib.db.download.DownloadException;
import com.transsion.gslb.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000'\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0003\b\u0080\u0001\n\u0002\u0010\u000b\n\u0002\b0\b\u0086\b\u0018\u00002\u00020\u0001BÙ\u0003\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\f\u001a\u00020\u0005\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010 \u001a\u00020\u0005\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010&\u001a\u00020\u0005\u0012\b\b\u0002\u0010'\u001a\u00020\u0003\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b.\u0010/J\b\u0010\u0087\u0001\u001a\u00030\u0088\u0001J\b\u0010\u0089\u0001\u001a\u00030\u0088\u0001J\n\u0010\u008a\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u008b\u0001\u001a\u00020\u0005HÆ\u0003J\f\u0010\u008c\u0001\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\f\u0010\u008d\u0001\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\n\u0010\u008e\u0001\u001a\u00020\u0005HÆ\u0003J\n\u0010\u008f\u0001\u001a\u00020\u0005HÆ\u0003J\n\u0010\u0090\u0001\u001a\u00020\u0005HÆ\u0003J\n\u0010\u0091\u0001\u001a\u00020\u0005HÆ\u0003J\f\u0010\u0092\u0001\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\f\u0010\u0093\u0001\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\f\u0010\u0094\u0001\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\n\u0010\u0095\u0001\u001a\u00020\u0005HÆ\u0003J\n\u0010\u0096\u0001\u001a\u00020\u0005HÆ\u0003J\f\u0010\u0097\u0001\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\f\u0010\u0098\u0001\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\f\u0010\u0099\u0001\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\f\u0010\u009a\u0001\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\f\u0010\u009b\u0001\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\f\u0010\u009c\u0001\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\f\u0010\u009d\u0001\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\f\u0010\u009e\u0001\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\n\u0010\u009f\u0001\u001a\u00020\u0005HÆ\u0003J\f\u0010 \u0001\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\f\u0010¡\u0001\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\f\u0010¢\u0001\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\n\u0010£\u0001\u001a\u00020\u0005HÆ\u0003J\f\u0010¤\u0001\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\n\u0010¥\u0001\u001a\u00020\u0005HÆ\u0003J\f\u0010¦\u0001\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\f\u0010§\u0001\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\f\u0010¨\u0001\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\f\u0010©\u0001\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\f\u0010ª\u0001\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\n\u0010«\u0001\u001a\u00020\u0005HÆ\u0003J\n\u0010¬\u0001\u001a\u00020\u0003HÆ\u0003J\f\u0010\u00ad\u0001\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\f\u0010®\u0001\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\f\u0010¯\u0001\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\f\u0010°\u0001\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\f\u0010±\u0001\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\f\u0010²\u0001\u001a\u0004\u0018\u00010\u0007HÆ\u0003JÜ\u0003\u0010³\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\u0010\u001a\u00020\u00052\b\b\u0002\u0010\u0011\u001a\u00020\u00052\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\u001a\u001a\u00020\u00052\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\u001e\u001a\u00020\u00052\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010 \u001a\u00020\u00052\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010&\u001a\u00020\u00052\b\b\u0002\u0010'\u001a\u00020\u00032\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0016\u0010´\u0001\u001a\u00030\u0088\u00012\t\u0010µ\u0001\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\n\u0010¶\u0001\u001a\u00020\u0005HÖ\u0001J\n\u0010·\u0001\u001a\u00020\u0007HÖ\u0001R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00105\"\u0004\b6\u00107R \u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R \u0010\b\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u00109\"\u0004\b=\u0010;R\u001e\u0010\t\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u00105\"\u0004\b?\u00107R\u001e\u0010\n\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u00105\"\u0004\bA\u00107R\u001e\u0010\u000b\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u00105\"\u0004\bC\u00107R\u001e\u0010\f\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u00105\"\u0004\bE\u00107R \u0010\r\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u00109\"\u0004\bG\u0010;R \u0010\u000e\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u00109\"\u0004\bI\u0010;R \u0010\u000f\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u00109\"\u0004\bK\u0010;R\u001e\u0010\u0010\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u00105\"\u0004\bM\u00107R\u001e\u0010\u0011\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u00105\"\u0004\bO\u00107R \u0010\u0012\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bP\u00109\"\u0004\bQ\u0010;R \u0010\u0013\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bR\u00109\"\u0004\bS\u0010;R \u0010\u0014\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bT\u00109\"\u0004\bU\u0010;R \u0010\u0015\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bV\u00109\"\u0004\bW\u0010;R \u0010\u0016\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bX\u00109\"\u0004\bY\u0010;R \u0010\u0017\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bZ\u00109\"\u0004\b[\u0010;R \u0010\u0018\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\\\u00109\"\u0004\b]\u0010;R \u0010\u0019\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b^\u00109\"\u0004\b_\u0010;R\u001e\u0010\u001a\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b`\u00105\"\u0004\ba\u00107R \u0010\u001b\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bb\u00109\"\u0004\bc\u0010;R \u0010\u001c\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bd\u00109\"\u0004\be\u0010;R \u0010\u001d\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bf\u00109\"\u0004\bg\u0010;R\u001e\u0010\u001e\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bh\u00105\"\u0004\bi\u00107R \u0010\u001f\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bj\u00109\"\u0004\bk\u0010;R\u001e\u0010 \u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bl\u00105\"\u0004\bm\u00107R \u0010!\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bn\u00109\"\u0004\bo\u0010;R \u0010\"\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bp\u00109\"\u0004\bq\u0010;R \u0010#\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\br\u00109\"\u0004\bs\u0010;R \u0010$\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bt\u00109\"\u0004\bu\u0010;R \u0010%\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bv\u00109\"\u0004\bw\u0010;R\u001e\u0010&\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u00105\"\u0004\bx\u00107R\u001e\u0010'\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\by\u00101\"\u0004\bz\u00103R \u0010(\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b{\u00109\"\u0004\b|\u0010;R \u0010)\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b}\u00109\"\u0004\b~\u0010;R!\u0010*\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000f\n\u0000\u001a\u0004\b\u007f\u00109\"\u0005\b\u0080\u0001\u0010;R\"\u0010+\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0081\u0001\u00109\"\u0005\b\u0082\u0001\u0010;R\"\u0010,\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0083\u0001\u00109\"\u0005\b\u0084\u0001\u0010;R\"\u0010-\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0085\u0001\u00109\"\u0005\b\u0086\u0001\u0010;¨\u0006¸\u0001"}, d2 = {"Lcom/transsion/push/bean/TPushData;", BuildConfig.FLAVOR, "messageId", BuildConfig.FLAVOR, "type", BuildConfig.FLAVOR, "styleType", BuildConfig.FLAVOR, "pkgId", "priority", "sdkShow", "msgTtl", "ignoreExpire", "packageName", "rpkg", "timeStamp", "notiType", "notiExType", "notiTitle", "notiDes", "notiImg", "notiIcon", "notiBtn", "notiImgEx", "notiTitleEx", "notiTxtEx", "notiOpenType", "notiOpenContent", "transData", "notiSmallIcon", "displayPolicy", "appName", "layoutStyleId", "channelId", "channelName", "iconColor", "impUrlList", "clickUrlList", "isHeadsUp", "retraceMsgId", "groupId", "groupMaxCount", "notiExtensionBtn", "notiOptionalIcon", "notiBtnTxtColor", "notiBtnBgColor", "<init>", "(JILjava/lang/String;Ljava/lang/String;IIIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getMessageId", "()J", "setMessageId", "(J)V", "getType", "()I", "setType", "(I)V", "getStyleType", "()Ljava/lang/String;", "setStyleType", "(Ljava/lang/String;)V", "getPkgId", "setPkgId", "getPriority", "setPriority", "getSdkShow", "setSdkShow", "getMsgTtl", "setMsgTtl", "getIgnoreExpire", "setIgnoreExpire", "getPackageName", "setPackageName", "getRpkg", "setRpkg", "getTimeStamp", "setTimeStamp", "getNotiType", "setNotiType", "getNotiExType", "setNotiExType", "getNotiTitle", "setNotiTitle", "getNotiDes", "setNotiDes", "getNotiImg", "setNotiImg", "getNotiIcon", "setNotiIcon", "getNotiBtn", "setNotiBtn", "getNotiImgEx", "setNotiImgEx", "getNotiTitleEx", "setNotiTitleEx", "getNotiTxtEx", "setNotiTxtEx", "getNotiOpenType", "setNotiOpenType", "getNotiOpenContent", "setNotiOpenContent", "getTransData", "setTransData", "getNotiSmallIcon", "setNotiSmallIcon", "getDisplayPolicy", "setDisplayPolicy", "getAppName", "setAppName", "getLayoutStyleId", "setLayoutStyleId", "getChannelId", "setChannelId", "getChannelName", "setChannelName", "getIconColor", "setIconColor", "getImpUrlList", "setImpUrlList", "getClickUrlList", "setClickUrlList", "setHeadsUp", "getRetraceMsgId", "setRetraceMsgId", "getGroupId", "setGroupId", "getGroupMaxCount", "setGroupMaxCount", "getNotiExtensionBtn", "setNotiExtensionBtn", "getNotiOptionalIcon", "setNotiOptionalIcon", "getNotiBtnTxtColor", "setNotiBtnTxtColor", "getNotiBtnBgColor", "setNotiBtnBgColor", "isNotifyType", BuildConfig.FLAVOR, "isVerticalType", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component30", "component31", "component32", "component33", "component34", "component35", "component36", "component37", "component38", "component39", "component40", "component41", "copy", "equals", "other", "hashCode", "toString", "push_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final /* data */ class TPushData {

    @SerializedName(PushMessageKey.KEY_APP_NAME)
    private String appName;

    @SerializedName(PushMessageKey.KEY_APP_CHANNEL_ID)
    private String channelId;

    @SerializedName(PushMessageKey.KEY_APP_CHANNEL_NAME)
    private String channelName;

    @SerializedName(PushMessageKey.KEY_NOTI_CLICK_URLS)
    private String clickUrlList;

    @SerializedName(PushMessageKey.KEY_DISPLAY_POLICY)
    private int displayPolicy;

    @SerializedName(PushMessageKey.KEY_APP_GROUP_ID)
    private String groupId;

    @SerializedName(PushMessageKey.KEY_APP_GROUP_MAX_COUNT)
    private String groupMaxCount;

    @SerializedName(PushMessageKey.KEY_NOTI_SMALL_ICON_COLOR)
    private String iconColor;

    @SerializedName(PushMessageKey.KEY_NOTI_IGNORE_EXPIRE)
    private int ignoreExpire;

    @SerializedName(PushMessageKey.KEY_NOTI_IMP_URLS)
    private String impUrlList;

    @SerializedName(PushMessageKey.KEY_NOTI_IS_HEADSUP)
    private int isHeadsUp;

    @SerializedName(PushMessageKey.KEY_APP_LAYOUT_STYLE_ID)
    private int layoutStyleId;

    @SerializedName(PushMessageKey.KEY_TCM_MSG_ID)
    private long messageId;

    @SerializedName(PushMessageKey.KEY_TCM_MSG_TTL)
    private int msgTtl;

    @SerializedName(PushMessageKey.KEY_NOTI_BTN)
    private String notiBtn;

    @SerializedName(PushMessageKey.KEY_NOTI_BTN_BG_COLOR)
    private String notiBtnBgColor;

    @SerializedName(PushMessageKey.KEY_NOTI_BTN_WORD_COLOR)
    private String notiBtnTxtColor;

    @SerializedName(PushMessageKey.KEY_NOTI_DESC)
    private String notiDes;

    @SerializedName(PushMessageKey.KEY_NOTI_EX_TYPE)
    private int notiExType;

    @SerializedName(PushMessageKey.KEY_NOTI_BTN_EX)
    private String notiExtensionBtn;

    @SerializedName(PushMessageKey.KEY_NOTI_ICON)
    private String notiIcon;

    @SerializedName(PushMessageKey.KEY_NOTI_IMG)
    private String notiImg;

    @SerializedName(PushMessageKey.KEY_NOTI_IMG_EX)
    private String notiImgEx;

    @SerializedName(PushMessageKey.KEY_NOTI_OPEN_CONTENT)
    private String notiOpenContent;

    @SerializedName(PushMessageKey.KEY_NOTI_OPEN_TYPE)
    private int notiOpenType;

    @SerializedName(PushMessageKey.KEY_NOTI_OPTIONAL_ICON)
    private String notiOptionalIcon;

    @SerializedName(PushMessageKey.KEY_NOTI_SMALL_ICON)
    private String notiSmallIcon;

    @SerializedName(PushMessageKey.KEY_NOTI_TITLE)
    private String notiTitle;

    @SerializedName(PushMessageKey.KEY_NOTI_TITLE_EX)
    private String notiTitleEx;

    @SerializedName(PushMessageKey.KEY_NOTI_TXT_EX)
    private String notiTxtEx;

    @SerializedName(PushMessageKey.KEY_NOTI_TYPE)
    private int notiType;

    @SerializedName(PushMessageKey.KEY_TCM_MSG_PKGNAME)
    private String packageName;

    @SerializedName(PushMessageKey.KEY_TCM_MSG_PKG)
    private String pkgId;

    @SerializedName(PushMessageKey.KEY_TCM_MSG_PRIORITY)
    private int priority;

    @SerializedName(PushMessageKey.KEY_NOTI_RETRACE_MSG_ID)
    private long retraceMsgId;

    @SerializedName(PushMessageKey.KEY_TCM_MSG_RPKG)
    private String rpkg;

    @SerializedName(PushMessageKey.KEY_TCM_MSG_SDKSHOW)
    private int sdkShow;

    @SerializedName("style_type")
    private String styleType;

    @SerializedName(PushMessageKey.KEY_TCM_MSG_TIMESTAMP)
    private String timeStamp;

    @SerializedName("trans_data")
    private String transData;

    @SerializedName(PushMessageKey.KEY_TCM_MSG_TYPE)
    private int type;

    public TPushData() {
        this(0L, 0, null, null, 0, 0, 0, 0, null, null, null, 0, 0, null, null, null, null, null, null, null, null, 0, null, null, null, 0, null, 0, null, null, null, null, null, 0, 0L, null, null, null, null, null, null, -1, DownloadException.EXCEPTION_IO_SSL_KEY, null);
    }

    public TPushData(long j, int i, String str, String str2, int i2, int i3, int i4, int i5, String str3, String str4, String str5, int i6, int i7, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, int i8, String str14, String str15, String str16, int i9, String str17, int i10, String str18, String str19, String str20, String str21, String str22, int i11, long j2, String str23, String str24, String str25, String str26, String str27, String str28) {
        this.messageId = j;
        this.type = i;
        this.styleType = str;
        this.pkgId = str2;
        this.priority = i2;
        this.sdkShow = i3;
        this.msgTtl = i4;
        this.ignoreExpire = i5;
        this.packageName = str3;
        this.rpkg = str4;
        this.timeStamp = str5;
        this.notiType = i6;
        this.notiExType = i7;
        this.notiTitle = str6;
        this.notiDes = str7;
        this.notiImg = str8;
        this.notiIcon = str9;
        this.notiBtn = str10;
        this.notiImgEx = str11;
        this.notiTitleEx = str12;
        this.notiTxtEx = str13;
        this.notiOpenType = i8;
        this.notiOpenContent = str14;
        this.transData = str15;
        this.notiSmallIcon = str16;
        this.displayPolicy = i9;
        this.appName = str17;
        this.layoutStyleId = i10;
        this.channelId = str18;
        this.channelName = str19;
        this.iconColor = str20;
        this.impUrlList = str21;
        this.clickUrlList = str22;
        this.isHeadsUp = i11;
        this.retraceMsgId = j2;
        this.groupId = str23;
        this.groupMaxCount = str24;
        this.notiExtensionBtn = str25;
        this.notiOptionalIcon = str26;
        this.notiBtnTxtColor = str27;
        this.notiBtnBgColor = str28;
    }

    public /* synthetic */ TPushData(long j, int i, String str, String str2, int i2, int i3, int i4, int i5, String str3, String str4, String str5, int i6, int i7, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, int i8, String str14, String str15, String str16, int i9, String str17, int i10, String str18, String str19, String str20, String str21, String str22, int i11, long j2, String str23, String str24, String str25, String str26, String str27, String str28, int i12, int i13, DefaultConstructorMarker defaultConstructorMarker) {
        this((i12 & 1) != 0 ? 0L : j, (i12 & 2) != 0 ? 0 : i, (i12 & 4) != 0 ? MsgStyle.STYLE_HOR_TYPE : str, (i12 & 8) != 0 ? null : str2, (i12 & 16) != 0 ? 0 : i2, (i12 & 32) != 0 ? 0 : i3, (i12 & 64) != 0 ? 0 : i4, (i12 & 128) != 0 ? 0 : i5, (i12 & 256) != 0 ? null : str3, (i12 & DownloadException.EXCEPTION_IO_SSL_PEER_UNVERIFIED) != 0 ? null : str4, (i12 & 1024) != 0 ? null : str5, (i12 & 2048) != 0 ? 1 : i6, (i12 & 4096) != 0 ? 0 : i7, (i12 & 8192) != 0 ? null : str6, (i12 & 16384) != 0 ? null : str7, (i12 & 32768) != 0 ? null : str8, (i12 & 65536) != 0 ? null : str9, (i12 & 131072) != 0 ? null : str10, (i12 & 262144) != 0 ? null : str11, (i12 & 524288) != 0 ? null : str12, (i12 & 1048576) != 0 ? null : str13, (i12 & 2097152) != 0 ? 0 : i8, (i12 & 4194304) != 0 ? null : str14, (i12 & 8388608) != 0 ? null : str15, (i12 & 16777216) != 0 ? null : str16, (i12 & 33554432) != 0 ? 0 : i9, (i12 & 67108864) != 0 ? null : str17, (i12 & 134217728) != 0 ? 0 : i10, (i12 & 268435456) != 0 ? null : str18, (i12 & 536870912) != 0 ? null : str19, (i12 & 1073741824) != 0 ? null : str20, (i12 & Integer.MIN_VALUE) != 0 ? null : str21, (i13 & 1) != 0 ? null : str22, (i13 & 2) != 0 ? 0 : i11, (i13 & 4) != 0 ? 0L : j2, (i13 & 8) != 0 ? null : str23, (i13 & 16) != 0 ? null : str24, (i13 & 32) != 0 ? null : str25, (i13 & 64) != 0 ? null : str26, (i13 & 128) != 0 ? null : str27, (i13 & 256) != 0 ? null : str28);
    }

    /* renamed from: component1, reason: from getter */
    public final long getMessageId() {
        return this.messageId;
    }

    /* renamed from: component10, reason: from getter */
    public final String getRpkg() {
        return this.rpkg;
    }

    /* renamed from: component11, reason: from getter */
    public final String getTimeStamp() {
        return this.timeStamp;
    }

    /* renamed from: component12, reason: from getter */
    public final int getNotiType() {
        return this.notiType;
    }

    /* renamed from: component13, reason: from getter */
    public final int getNotiExType() {
        return this.notiExType;
    }

    /* renamed from: component14, reason: from getter */
    public final String getNotiTitle() {
        return this.notiTitle;
    }

    /* renamed from: component15, reason: from getter */
    public final String getNotiDes() {
        return this.notiDes;
    }

    /* renamed from: component16, reason: from getter */
    public final String getNotiImg() {
        return this.notiImg;
    }

    /* renamed from: component17, reason: from getter */
    public final String getNotiIcon() {
        return this.notiIcon;
    }

    /* renamed from: component18, reason: from getter */
    public final String getNotiBtn() {
        return this.notiBtn;
    }

    /* renamed from: component19, reason: from getter */
    public final String getNotiImgEx() {
        return this.notiImgEx;
    }

    /* renamed from: component2, reason: from getter */
    public final int getType() {
        return this.type;
    }

    /* renamed from: component20, reason: from getter */
    public final String getNotiTitleEx() {
        return this.notiTitleEx;
    }

    /* renamed from: component21, reason: from getter */
    public final String getNotiTxtEx() {
        return this.notiTxtEx;
    }

    /* renamed from: component22, reason: from getter */
    public final int getNotiOpenType() {
        return this.notiOpenType;
    }

    /* renamed from: component23, reason: from getter */
    public final String getNotiOpenContent() {
        return this.notiOpenContent;
    }

    /* renamed from: component24, reason: from getter */
    public final String getTransData() {
        return this.transData;
    }

    /* renamed from: component25, reason: from getter */
    public final String getNotiSmallIcon() {
        return this.notiSmallIcon;
    }

    /* renamed from: component26, reason: from getter */
    public final int getDisplayPolicy() {
        return this.displayPolicy;
    }

    /* renamed from: component27, reason: from getter */
    public final String getAppName() {
        return this.appName;
    }

    /* renamed from: component28, reason: from getter */
    public final int getLayoutStyleId() {
        return this.layoutStyleId;
    }

    /* renamed from: component29, reason: from getter */
    public final String getChannelId() {
        return this.channelId;
    }

    /* renamed from: component3, reason: from getter */
    public final String getStyleType() {
        return this.styleType;
    }

    /* renamed from: component30, reason: from getter */
    public final String getChannelName() {
        return this.channelName;
    }

    /* renamed from: component31, reason: from getter */
    public final String getIconColor() {
        return this.iconColor;
    }

    /* renamed from: component32, reason: from getter */
    public final String getImpUrlList() {
        return this.impUrlList;
    }

    /* renamed from: component33, reason: from getter */
    public final String getClickUrlList() {
        return this.clickUrlList;
    }

    /* renamed from: component34, reason: from getter */
    public final int getIsHeadsUp() {
        return this.isHeadsUp;
    }

    /* renamed from: component35, reason: from getter */
    public final long getRetraceMsgId() {
        return this.retraceMsgId;
    }

    /* renamed from: component36, reason: from getter */
    public final String getGroupId() {
        return this.groupId;
    }

    /* renamed from: component37, reason: from getter */
    public final String getGroupMaxCount() {
        return this.groupMaxCount;
    }

    /* renamed from: component38, reason: from getter */
    public final String getNotiExtensionBtn() {
        return this.notiExtensionBtn;
    }

    /* renamed from: component39, reason: from getter */
    public final String getNotiOptionalIcon() {
        return this.notiOptionalIcon;
    }

    /* renamed from: component4, reason: from getter */
    public final String getPkgId() {
        return this.pkgId;
    }

    /* renamed from: component40, reason: from getter */
    public final String getNotiBtnTxtColor() {
        return this.notiBtnTxtColor;
    }

    /* renamed from: component41, reason: from getter */
    public final String getNotiBtnBgColor() {
        return this.notiBtnBgColor;
    }

    /* renamed from: component5, reason: from getter */
    public final int getPriority() {
        return this.priority;
    }

    /* renamed from: component6, reason: from getter */
    public final int getSdkShow() {
        return this.sdkShow;
    }

    /* renamed from: component7, reason: from getter */
    public final int getMsgTtl() {
        return this.msgTtl;
    }

    /* renamed from: component8, reason: from getter */
    public final int getIgnoreExpire() {
        return this.ignoreExpire;
    }

    /* renamed from: component9, reason: from getter */
    public final String getPackageName() {
        return this.packageName;
    }

    public final TPushData copy(long messageId, int type, String styleType, String pkgId, int priority, int sdkShow, int msgTtl, int ignoreExpire, String packageName, String rpkg, String timeStamp, int notiType, int notiExType, String notiTitle, String notiDes, String notiImg, String notiIcon, String notiBtn, String notiImgEx, String notiTitleEx, String notiTxtEx, int notiOpenType, String notiOpenContent, String transData, String notiSmallIcon, int displayPolicy, String appName, int layoutStyleId, String channelId, String channelName, String iconColor, String impUrlList, String clickUrlList, int isHeadsUp, long retraceMsgId, String groupId, String groupMaxCount, String notiExtensionBtn, String notiOptionalIcon, String notiBtnTxtColor, String notiBtnBgColor) {
        return new TPushData(messageId, type, styleType, pkgId, priority, sdkShow, msgTtl, ignoreExpire, packageName, rpkg, timeStamp, notiType, notiExType, notiTitle, notiDes, notiImg, notiIcon, notiBtn, notiImgEx, notiTitleEx, notiTxtEx, notiOpenType, notiOpenContent, transData, notiSmallIcon, displayPolicy, appName, layoutStyleId, channelId, channelName, iconColor, impUrlList, clickUrlList, isHeadsUp, retraceMsgId, groupId, groupMaxCount, notiExtensionBtn, notiOptionalIcon, notiBtnTxtColor, notiBtnBgColor);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TPushData)) {
            return false;
        }
        TPushData tPushData = (TPushData) other;
        return this.messageId == tPushData.messageId && this.type == tPushData.type && Intrinsics.c(this.styleType, tPushData.styleType) && Intrinsics.c(this.pkgId, tPushData.pkgId) && this.priority == tPushData.priority && this.sdkShow == tPushData.sdkShow && this.msgTtl == tPushData.msgTtl && this.ignoreExpire == tPushData.ignoreExpire && Intrinsics.c(this.packageName, tPushData.packageName) && Intrinsics.c(this.rpkg, tPushData.rpkg) && Intrinsics.c(this.timeStamp, tPushData.timeStamp) && this.notiType == tPushData.notiType && this.notiExType == tPushData.notiExType && Intrinsics.c(this.notiTitle, tPushData.notiTitle) && Intrinsics.c(this.notiDes, tPushData.notiDes) && Intrinsics.c(this.notiImg, tPushData.notiImg) && Intrinsics.c(this.notiIcon, tPushData.notiIcon) && Intrinsics.c(this.notiBtn, tPushData.notiBtn) && Intrinsics.c(this.notiImgEx, tPushData.notiImgEx) && Intrinsics.c(this.notiTitleEx, tPushData.notiTitleEx) && Intrinsics.c(this.notiTxtEx, tPushData.notiTxtEx) && this.notiOpenType == tPushData.notiOpenType && Intrinsics.c(this.notiOpenContent, tPushData.notiOpenContent) && Intrinsics.c(this.transData, tPushData.transData) && Intrinsics.c(this.notiSmallIcon, tPushData.notiSmallIcon) && this.displayPolicy == tPushData.displayPolicy && Intrinsics.c(this.appName, tPushData.appName) && this.layoutStyleId == tPushData.layoutStyleId && Intrinsics.c(this.channelId, tPushData.channelId) && Intrinsics.c(this.channelName, tPushData.channelName) && Intrinsics.c(this.iconColor, tPushData.iconColor) && Intrinsics.c(this.impUrlList, tPushData.impUrlList) && Intrinsics.c(this.clickUrlList, tPushData.clickUrlList) && this.isHeadsUp == tPushData.isHeadsUp && this.retraceMsgId == tPushData.retraceMsgId && Intrinsics.c(this.groupId, tPushData.groupId) && Intrinsics.c(this.groupMaxCount, tPushData.groupMaxCount) && Intrinsics.c(this.notiExtensionBtn, tPushData.notiExtensionBtn) && Intrinsics.c(this.notiOptionalIcon, tPushData.notiOptionalIcon) && Intrinsics.c(this.notiBtnTxtColor, tPushData.notiBtnTxtColor) && Intrinsics.c(this.notiBtnBgColor, tPushData.notiBtnBgColor);
    }

    public final String getAppName() {
        return this.appName;
    }

    public final String getChannelId() {
        return this.channelId;
    }

    public final String getChannelName() {
        return this.channelName;
    }

    public final String getClickUrlList() {
        return this.clickUrlList;
    }

    public final int getDisplayPolicy() {
        return this.displayPolicy;
    }

    public final String getGroupId() {
        return this.groupId;
    }

    public final String getGroupMaxCount() {
        return this.groupMaxCount;
    }

    public final String getIconColor() {
        return this.iconColor;
    }

    public final int getIgnoreExpire() {
        return this.ignoreExpire;
    }

    public final String getImpUrlList() {
        return this.impUrlList;
    }

    public final int getLayoutStyleId() {
        return this.layoutStyleId;
    }

    public final long getMessageId() {
        return this.messageId;
    }

    public final int getMsgTtl() {
        return this.msgTtl;
    }

    public final String getNotiBtn() {
        return this.notiBtn;
    }

    public final String getNotiBtnBgColor() {
        return this.notiBtnBgColor;
    }

    public final String getNotiBtnTxtColor() {
        return this.notiBtnTxtColor;
    }

    public final String getNotiDes() {
        return this.notiDes;
    }

    public final int getNotiExType() {
        return this.notiExType;
    }

    public final String getNotiExtensionBtn() {
        return this.notiExtensionBtn;
    }

    public final String getNotiIcon() {
        return this.notiIcon;
    }

    public final String getNotiImg() {
        return this.notiImg;
    }

    public final String getNotiImgEx() {
        return this.notiImgEx;
    }

    public final String getNotiOpenContent() {
        return this.notiOpenContent;
    }

    public final int getNotiOpenType() {
        return this.notiOpenType;
    }

    public final String getNotiOptionalIcon() {
        return this.notiOptionalIcon;
    }

    public final String getNotiSmallIcon() {
        return this.notiSmallIcon;
    }

    public final String getNotiTitle() {
        return this.notiTitle;
    }

    public final String getNotiTitleEx() {
        return this.notiTitleEx;
    }

    public final String getNotiTxtEx() {
        return this.notiTxtEx;
    }

    public final int getNotiType() {
        return this.notiType;
    }

    public final String getPackageName() {
        return this.packageName;
    }

    public final String getPkgId() {
        return this.pkgId;
    }

    public final int getPriority() {
        return this.priority;
    }

    public final long getRetraceMsgId() {
        return this.retraceMsgId;
    }

    public final String getRpkg() {
        return this.rpkg;
    }

    public final int getSdkShow() {
        return this.sdkShow;
    }

    public final String getStyleType() {
        return this.styleType;
    }

    public final String getTimeStamp() {
        return this.timeStamp;
    }

    public final String getTransData() {
        return this.transData;
    }

    public final int getType() {
        return this.type;
    }

    public int hashCode() {
        int a = ((s.a(this.messageId) * 31) + this.type) * 31;
        String str = this.styleType;
        int hashCode = (a + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.pkgId;
        int hashCode2 = (((((((((hashCode + (str2 == null ? 0 : str2.hashCode())) * 31) + this.priority) * 31) + this.sdkShow) * 31) + this.msgTtl) * 31) + this.ignoreExpire) * 31;
        String str3 = this.packageName;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.rpkg;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.timeStamp;
        int hashCode5 = (((((hashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31) + this.notiType) * 31) + this.notiExType) * 31;
        String str6 = this.notiTitle;
        int hashCode6 = (hashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.notiDes;
        int hashCode7 = (hashCode6 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.notiImg;
        int hashCode8 = (hashCode7 + (str8 == null ? 0 : str8.hashCode())) * 31;
        String str9 = this.notiIcon;
        int hashCode9 = (hashCode8 + (str9 == null ? 0 : str9.hashCode())) * 31;
        String str10 = this.notiBtn;
        int hashCode10 = (hashCode9 + (str10 == null ? 0 : str10.hashCode())) * 31;
        String str11 = this.notiImgEx;
        int hashCode11 = (hashCode10 + (str11 == null ? 0 : str11.hashCode())) * 31;
        String str12 = this.notiTitleEx;
        int hashCode12 = (hashCode11 + (str12 == null ? 0 : str12.hashCode())) * 31;
        String str13 = this.notiTxtEx;
        int hashCode13 = (((hashCode12 + (str13 == null ? 0 : str13.hashCode())) * 31) + this.notiOpenType) * 31;
        String str14 = this.notiOpenContent;
        int hashCode14 = (hashCode13 + (str14 == null ? 0 : str14.hashCode())) * 31;
        String str15 = this.transData;
        int hashCode15 = (hashCode14 + (str15 == null ? 0 : str15.hashCode())) * 31;
        String str16 = this.notiSmallIcon;
        int hashCode16 = (((hashCode15 + (str16 == null ? 0 : str16.hashCode())) * 31) + this.displayPolicy) * 31;
        String str17 = this.appName;
        int hashCode17 = (((hashCode16 + (str17 == null ? 0 : str17.hashCode())) * 31) + this.layoutStyleId) * 31;
        String str18 = this.channelId;
        int hashCode18 = (hashCode17 + (str18 == null ? 0 : str18.hashCode())) * 31;
        String str19 = this.channelName;
        int hashCode19 = (hashCode18 + (str19 == null ? 0 : str19.hashCode())) * 31;
        String str20 = this.iconColor;
        int hashCode20 = (hashCode19 + (str20 == null ? 0 : str20.hashCode())) * 31;
        String str21 = this.impUrlList;
        int hashCode21 = (hashCode20 + (str21 == null ? 0 : str21.hashCode())) * 31;
        String str22 = this.clickUrlList;
        int hashCode22 = (((((hashCode21 + (str22 == null ? 0 : str22.hashCode())) * 31) + this.isHeadsUp) * 31) + s.a(this.retraceMsgId)) * 31;
        String str23 = this.groupId;
        int hashCode23 = (hashCode22 + (str23 == null ? 0 : str23.hashCode())) * 31;
        String str24 = this.groupMaxCount;
        int hashCode24 = (hashCode23 + (str24 == null ? 0 : str24.hashCode())) * 31;
        String str25 = this.notiExtensionBtn;
        int hashCode25 = (hashCode24 + (str25 == null ? 0 : str25.hashCode())) * 31;
        String str26 = this.notiOptionalIcon;
        int hashCode26 = (hashCode25 + (str26 == null ? 0 : str26.hashCode())) * 31;
        String str27 = this.notiBtnTxtColor;
        int hashCode27 = (hashCode26 + (str27 == null ? 0 : str27.hashCode())) * 31;
        String str28 = this.notiBtnBgColor;
        return hashCode27 + (str28 != null ? str28.hashCode() : 0);
    }

    public final int isHeadsUp() {
        return this.isHeadsUp;
    }

    public final boolean isNotifyType() {
        return this.notiType == 3;
    }

    public final boolean isVerticalType() {
        return Intrinsics.c(this.styleType, MsgStyle.STYLE_VERTICAL_TYPE);
    }

    public final void setAppName(String str) {
        this.appName = str;
    }

    public final void setChannelId(String str) {
        this.channelId = str;
    }

    public final void setChannelName(String str) {
        this.channelName = str;
    }

    public final void setClickUrlList(String str) {
        this.clickUrlList = str;
    }

    public final void setDisplayPolicy(int i) {
        this.displayPolicy = i;
    }

    public final void setGroupId(String str) {
        this.groupId = str;
    }

    public final void setGroupMaxCount(String str) {
        this.groupMaxCount = str;
    }

    public final void setHeadsUp(int i) {
        this.isHeadsUp = i;
    }

    public final void setIconColor(String str) {
        this.iconColor = str;
    }

    public final void setIgnoreExpire(int i) {
        this.ignoreExpire = i;
    }

    public final void setImpUrlList(String str) {
        this.impUrlList = str;
    }

    public final void setLayoutStyleId(int i) {
        this.layoutStyleId = i;
    }

    public final void setMessageId(long j) {
        this.messageId = j;
    }

    public final void setMsgTtl(int i) {
        this.msgTtl = i;
    }

    public final void setNotiBtn(String str) {
        this.notiBtn = str;
    }

    public final void setNotiBtnBgColor(String str) {
        this.notiBtnBgColor = str;
    }

    public final void setNotiBtnTxtColor(String str) {
        this.notiBtnTxtColor = str;
    }

    public final void setNotiDes(String str) {
        this.notiDes = str;
    }

    public final void setNotiExType(int i) {
        this.notiExType = i;
    }

    public final void setNotiExtensionBtn(String str) {
        this.notiExtensionBtn = str;
    }

    public final void setNotiIcon(String str) {
        this.notiIcon = str;
    }

    public final void setNotiImg(String str) {
        this.notiImg = str;
    }

    public final void setNotiImgEx(String str) {
        this.notiImgEx = str;
    }

    public final void setNotiOpenContent(String str) {
        this.notiOpenContent = str;
    }

    public final void setNotiOpenType(int i) {
        this.notiOpenType = i;
    }

    public final void setNotiOptionalIcon(String str) {
        this.notiOptionalIcon = str;
    }

    public final void setNotiSmallIcon(String str) {
        this.notiSmallIcon = str;
    }

    public final void setNotiTitle(String str) {
        this.notiTitle = str;
    }

    public final void setNotiTitleEx(String str) {
        this.notiTitleEx = str;
    }

    public final void setNotiTxtEx(String str) {
        this.notiTxtEx = str;
    }

    public final void setNotiType(int i) {
        this.notiType = i;
    }

    public final void setPackageName(String str) {
        this.packageName = str;
    }

    public final void setPkgId(String str) {
        this.pkgId = str;
    }

    public final void setPriority(int i) {
        this.priority = i;
    }

    public final void setRetraceMsgId(long j) {
        this.retraceMsgId = j;
    }

    public final void setRpkg(String str) {
        this.rpkg = str;
    }

    public final void setSdkShow(int i) {
        this.sdkShow = i;
    }

    public final void setStyleType(String str) {
        this.styleType = str;
    }

    public final void setTimeStamp(String str) {
        this.timeStamp = str;
    }

    public final void setTransData(String str) {
        this.transData = str;
    }

    public final void setType(int i) {
        this.type = i;
    }

    public String toString() {
        return "TPushData(messageId=" + this.messageId + ", type=" + this.type + ", styleType=" + this.styleType + ", pkgId=" + this.pkgId + ", priority=" + this.priority + ", sdkShow=" + this.sdkShow + ", msgTtl=" + this.msgTtl + ", ignoreExpire=" + this.ignoreExpire + ", packageName=" + this.packageName + ", rpkg=" + this.rpkg + ", timeStamp=" + this.timeStamp + ", notiType=" + this.notiType + ", notiExType=" + this.notiExType + ", notiTitle=" + this.notiTitle + ", notiDes=" + this.notiDes + ", notiImg=" + this.notiImg + ", notiIcon=" + this.notiIcon + ", notiBtn=" + this.notiBtn + ", notiImgEx=" + this.notiImgEx + ", notiTitleEx=" + this.notiTitleEx + ", notiTxtEx=" + this.notiTxtEx + ", notiOpenType=" + this.notiOpenType + ", notiOpenContent=" + this.notiOpenContent + ", transData=" + this.transData + ", notiSmallIcon=" + this.notiSmallIcon + ", displayPolicy=" + this.displayPolicy + ", appName=" + this.appName + ", layoutStyleId=" + this.layoutStyleId + ", channelId=" + this.channelId + ", channelName=" + this.channelName + ", iconColor=" + this.iconColor + ", impUrlList=" + this.impUrlList + ", clickUrlList=" + this.clickUrlList + ", isHeadsUp=" + this.isHeadsUp + ", retraceMsgId=" + this.retraceMsgId + ", groupId=" + this.groupId + ", groupMaxCount=" + this.groupMaxCount + ", notiExtensionBtn=" + this.notiExtensionBtn + ", notiOptionalIcon=" + this.notiOptionalIcon + ", notiBtnTxtColor=" + this.notiBtnTxtColor + ", notiBtnBgColor=" + this.notiBtnBgColor + ")";
    }
}
