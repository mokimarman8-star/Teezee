package org.mvel2.templates.res;

import f00.b;
import g00.c;
import g00.d;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import org.mvel2.ParserContext;
import org.mvel2.integration.VariableResolverFactory;
import org.mvel2.templates.CompiledTemplate;

/* loaded from: /home/user/Teezee-git/app_source/classes8.dex */
public class CompiledIncludeNode extends Node {
    private CompiledTemplate cFileCache;
    private Serializable cIncludeExpression;
    private Serializable cPreExpression;
    private ParserContext context;
    private long fileDateStamp;

    public CompiledIncludeNode(int i, String str, char[] cArr, int i2, int i3, ParserContext parserContext) {
        this.begin = i;
        this.name = str;
        this.contents = cArr;
        this.cStart = i2;
        this.cEnd = i3 - 1;
        this.end = i3;
        this.context = parserContext;
        int a = d.a(cArr, i2);
        char[] cArr2 = this.contents;
        int i4 = this.cStart;
        this.cIncludeExpression = org.mvel2.d.e(cArr2, i4, a - i4, parserContext);
        char[] cArr3 = this.contents;
        if (a != cArr3.length) {
            int i6 = a + 1;
            this.cPreExpression = org.mvel2.d.e(cArr3, i6, this.cEnd - i6, parserContext);
        }
    }

    private static FileInputStream openInputStream(File file) throws IOException {
        if (file == null) {
            throw new FileNotFoundException("file parameter is null");
        }
        if (!file.exists()) {
            throw new FileNotFoundException("File '" + file + "' does not exist");
        }
        if (file.isDirectory()) {
            throw new IOException("File '" + file + "' exists but is a directory");
        }
        if (file.canRead()) {
            return new FileInputStream(file);
        }
        throw new IOException("File '" + file + "' cannot be read");
    }

    private String readFile(f00.d dVar, String str, Object obj, VariableResolverFactory variableResolverFactory) {
        File file = new File(String.valueOf(dVar.i().k()) + "/" + str);
        long j = this.fileDateStamp;
        if (j == 0 || j != file.lastModified()) {
            this.fileDateStamp = file.lastModified();
            this.cFileCache = b.g(readInFile(dVar, file), this.context);
        }
        return String.valueOf(f00.d.e(this.cFileCache, obj, variableResolverFactory));
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x00fd A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00db A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String readInFile(f00.d r9, java.io.File r10) {
        /*
            Method dump skipped, instructions count: 286
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mvel2.templates.res.CompiledIncludeNode.readInFile(f00.d, java.io.File):java.lang.String");
    }

    @Override // org.mvel2.templates.res.Node
    public boolean demarcate(Node node, char[] cArr) {
        return false;
    }

    @Override // org.mvel2.templates.res.Node
    public Object eval(f00.d dVar, c cVar, Object obj, VariableResolverFactory variableResolverFactory) {
        String str = (String) org.mvel2.d.s(this.cIncludeExpression, obj, variableResolverFactory, String.class);
        Serializable serializable = this.cPreExpression;
        if (serializable != null) {
            org.mvel2.d.r(serializable, obj, variableResolverFactory);
        }
        Node node = this.next;
        return node != null ? node.eval(dVar, cVar.append(String.valueOf(f00.d.a(readFile(dVar, str, obj, variableResolverFactory), obj, variableResolverFactory))), obj, variableResolverFactory) : cVar.append(String.valueOf(org.mvel2.d.l(readFile(dVar, str, obj, variableResolverFactory), obj, variableResolverFactory)));
    }
}
