package kotlin.io;

import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.io.File;
import java.util.ArrayDeque;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.AbstractIterator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import okhttp3.HttpUrl;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010(\n\u0002\b\u0010\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u001f\u001d&B\u008b\u0001\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\u0014\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0012\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t\u0018\u00010\u0006\u00128\u0010\u0011\u001a4\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\t\u0018\u00010\u000b\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015B\u001b\b\u0010\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0014\u0010\u0016J\u0016\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00020\u0017H\u0096\u0002¢\u0006\u0004\b\u0018\u0010\u0019J'\u0010\u001b\u001a\u00020\u00002\u0018\u0010\u001a\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\t0\u000b¢\u0006\u0004\b\u001b\u0010\u001cR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\"\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\"\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t\u0018\u00010\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010\"RF\u0010\u0011\u001a4\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\t\u0018\u00010\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010$R\u0014\u0010\u0013\u001a\u00020\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010%¨\u0006'"}, d2 = {"Lkotlin/io/FileTreeWalk;", "Lkotlin/sequences/Sequence;", "Ljava/io/File;", "start", "Lkotlin/io/FileWalkDirection;", "direction", "Lkotlin/Function1;", HttpUrl.FRAGMENT_ENCODE_SET, "onEnter", HttpUrl.FRAGMENT_ENCODE_SET, "onLeave", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "f", "Ljava/io/IOException;", "e", "onFail", HttpUrl.FRAGMENT_ENCODE_SET, "maxDepth", "<init>", "(Ljava/io/File;Lkotlin/io/FileWalkDirection;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;I)V", "(Ljava/io/File;Lkotlin/io/FileWalkDirection;)V", HttpUrl.FRAGMENT_ENCODE_SET, "iterator", "()Ljava/util/Iterator;", "function", "h", "(Lkotlin/jvm/functions/Function2;)Lkotlin/io/FileTreeWalk;", "a", "Ljava/io/File;", "b", "Lkotlin/io/FileWalkDirection;", "c", "Lkotlin/jvm/functions/Function1;", "d", "Lkotlin/jvm/functions/Function2;", "I", "FileTreeWalkIterator", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class FileTreeWalk implements Sequence<File> {

    /* renamed from: a, reason: from kotlin metadata */
    private final File start;

    /* renamed from: b, reason: from kotlin metadata */
    private final FileWalkDirection direction;

    /* renamed from: c, reason: from kotlin metadata */
    private final Function1 onEnter;

    /* renamed from: d, reason: from kotlin metadata */
    private final Function1 onLeave;

    /* renamed from: e, reason: from kotlin metadata */
    private final Function2 onFail;

    /* renamed from: f, reason: from kotlin metadata */
    private final int maxDepth;

    private final class FileTreeWalkIterator extends AbstractIterator {
        private final ArrayDeque c;

        @Metadata(k = 3, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] a;

            static {
                int[] iArr = new int[FileWalkDirection.values().length];
                try {
                    iArr[FileWalkDirection.TOP_DOWN.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[FileWalkDirection.BOTTOM_UP.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                a = iArr;
            }
        }

        private final class a extends a {
            private boolean b;
            private File[] c;
            private int d;
            private boolean e;
            final /* synthetic */ FileTreeWalkIterator f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(FileTreeWalkIterator fileTreeWalkIterator, File rootDir) {
                super(rootDir);
                Intrinsics.h(rootDir, "rootDir");
                this.f = fileTreeWalkIterator;
            }

            @Override // kotlin.io.FileTreeWalk.b
            public File b() {
                if (!this.e && this.c == null) {
                    Function1 function1 = FileTreeWalk.this.onEnter;
                    if (function1 != null && !((Boolean) function1.invoke(a())).booleanValue()) {
                        return null;
                    }
                    File[] listFiles = a().listFiles();
                    this.c = listFiles;
                    if (listFiles == null) {
                        Function2 function2 = FileTreeWalk.this.onFail;
                        if (function2 != null) {
                            function2.invoke(a(), new AccessDeniedException(a(), null, "Cannot list files in a directory", 2, null));
                        }
                        this.e = true;
                    }
                }
                File[] fileArr = this.c;
                if (fileArr != null) {
                    int i = this.d;
                    Intrinsics.e(fileArr);
                    if (i < fileArr.length) {
                        File[] fileArr2 = this.c;
                        Intrinsics.e(fileArr2);
                        int i2 = this.d;
                        this.d = i2 + 1;
                        return fileArr2[i2];
                    }
                }
                if (!this.b) {
                    this.b = true;
                    return a();
                }
                Function1 function12 = FileTreeWalk.this.onLeave;
                if (function12 != null) {
                    function12.invoke(a());
                }
                return null;
            }
        }

        private final class b extends b {
            private boolean b;
            final /* synthetic */ FileTreeWalkIterator c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(FileTreeWalkIterator fileTreeWalkIterator, File rootFile) {
                super(rootFile);
                Intrinsics.h(rootFile, "rootFile");
                this.c = fileTreeWalkIterator;
            }

            @Override // kotlin.io.FileTreeWalk.b
            public File b() {
                if (this.b) {
                    return null;
                }
                this.b = true;
                return a();
            }
        }

        private final class c extends a {
            private boolean b;
            private File[] c;
            private int d;
            final /* synthetic */ FileTreeWalkIterator e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public c(FileTreeWalkIterator fileTreeWalkIterator, File rootDir) {
                super(rootDir);
                Intrinsics.h(rootDir, "rootDir");
                this.e = fileTreeWalkIterator;
            }

            /* JADX WARN: Code restructure failed: missing block: B:29:0x007f, code lost:
            
                if (r0.length == 0) goto L31;
             */
            @Override // kotlin.io.FileTreeWalk.b
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public File b() {
                Function2 function2;
                if (!this.b) {
                    Function1 function1 = FileTreeWalk.this.onEnter;
                    if (function1 != null && !((Boolean) function1.invoke(a())).booleanValue()) {
                        return null;
                    }
                    this.b = true;
                    return a();
                }
                File[] fileArr = this.c;
                if (fileArr != null) {
                    int i = this.d;
                    Intrinsics.e(fileArr);
                    if (i >= fileArr.length) {
                        Function1 function12 = FileTreeWalk.this.onLeave;
                        if (function12 != null) {
                            function12.invoke(a());
                        }
                        return null;
                    }
                }
                if (this.c == null) {
                    File[] listFiles = a().listFiles();
                    this.c = listFiles;
                    if (listFiles == null && (function2 = FileTreeWalk.this.onFail) != null) {
                        function2.invoke(a(), new AccessDeniedException(a(), null, "Cannot list files in a directory", 2, null));
                    }
                    File[] fileArr2 = this.c;
                    if (fileArr2 != null) {
                        Intrinsics.e(fileArr2);
                    }
                    Function1 function13 = FileTreeWalk.this.onLeave;
                    if (function13 != null) {
                        function13.invoke(a());
                    }
                    return null;
                }
                File[] fileArr3 = this.c;
                Intrinsics.e(fileArr3);
                int i2 = this.d;
                this.d = i2 + 1;
                return fileArr3[i2];
            }
        }

        public FileTreeWalkIterator() {
            ArrayDeque arrayDeque = new ArrayDeque();
            this.c = arrayDeque;
            if (FileTreeWalk.this.start.isDirectory()) {
                arrayDeque.push(h(FileTreeWalk.this.start));
            } else if (FileTreeWalk.this.start.isFile()) {
                arrayDeque.push(new b(this, FileTreeWalk.this.start));
            } else {
                c();
            }
        }

        private final a h(File file) {
            int i = WhenMappings.a[FileTreeWalk.this.direction.ordinal()];
            if (i == 1) {
                return new c(this, file);
            }
            if (i == 2) {
                return new a(this, file);
            }
            throw new NoWhenBranchMatchedException();
        }

        private final File i() {
            File b2;
            while (true) {
                b bVar = (b) this.c.peek();
                if (bVar == null) {
                    return null;
                }
                b2 = bVar.b();
                if (b2 == null) {
                    this.c.pop();
                } else {
                    if (Intrinsics.c(b2, bVar.a()) || !b2.isDirectory() || this.c.size() >= FileTreeWalk.this.maxDepth) {
                        break;
                    }
                    this.c.push(h(b2));
                }
            }
            return b2;
        }

        @Override // kotlin.collections.AbstractIterator
        protected void a() {
            File i = i();
            if (i != null) {
                e(i);
            } else {
                c();
            }
        }
    }

    private static abstract class a extends b {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(File rootDir) {
            super(rootDir);
            Intrinsics.h(rootDir, "rootDir");
        }
    }

    private static abstract class b {
        private final File a;

        public b(File root) {
            Intrinsics.h(root, "root");
            this.a = root;
        }

        public final File a() {
            return this.a;
        }

        public abstract File b();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FileTreeWalk(File start, FileWalkDirection direction) {
        this(start, direction, null, null, null, 0, 32, null);
        Intrinsics.h(start, "start");
        Intrinsics.h(direction, "direction");
    }

    private FileTreeWalk(File file, FileWalkDirection fileWalkDirection, Function1 function1, Function1 function12, Function2 function2, int i) {
        this.start = file;
        this.direction = fileWalkDirection;
        this.onEnter = function1;
        this.onLeave = function12;
        this.onFail = function2;
        this.maxDepth = i;
    }

    /* synthetic */ FileTreeWalk(File file, FileWalkDirection fileWalkDirection, Function1 function1, Function1 function12, Function2 function2, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(file, (i2 & 2) != 0 ? FileWalkDirection.TOP_DOWN : fileWalkDirection, function1, function12, function2, (i2 & 32) != 0 ? Integer.MAX_VALUE : i);
    }

    public final FileTreeWalk h(Function2 function) {
        Intrinsics.h(function, "function");
        return new FileTreeWalk(this.start, this.direction, this.onEnter, this.onLeave, function, this.maxDepth);
    }

    @Override // kotlin.sequences.Sequence
    /* renamed from: iterator */
    public Iterator getA() {
        return new FileTreeWalkIterator();
    }
}
