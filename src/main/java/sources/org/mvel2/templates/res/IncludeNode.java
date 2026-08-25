package org.mvel2.templates.res;

import g00.c;
import g00.d;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.mvel2.integration.VariableResolverFactory;
import org.mvel2.templates.TemplateError;

/* loaded from: /home/user/Teezee-git/app_source/classes8.dex */
public class IncludeNode extends Node {
    int includeOffset;
    int includeStart;
    int preOffset;
    int preStart;

    public IncludeNode(int i, String str, char[] cArr, int i2, int i3) {
        this.begin = i;
        this.name = str;
        this.contents = cArr;
        this.cStart = i2;
        this.cEnd = i3 - 1;
        this.end = i3;
        int a = d.a(cArr, 0);
        int i4 = this.cStart;
        this.includeStart = i4;
        this.includeOffset = a - i4;
        int i6 = a + 1;
        this.preStart = i6;
        this.preOffset = this.cEnd - i6;
    }

    public static String readInFile(f00.d dVar, String str) {
        File file = new File(String.valueOf(dVar.i().k()) + "/" + str);
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
            dVar.i().q(file.getParent());
            byte[] bArr = new byte[10];
            StringBuilder sb = new StringBuilder();
            while (true) {
                int read = bufferedInputStream.read(bArr);
                if (read == -1) {
                    bufferedInputStream.close();
                    fileInputStream.close();
                    dVar.i().n();
                    return sb.toString();
                }
                for (int i = 0; i < read; i++) {
                    sb.append((char) bArr[i]);
                }
            }
        } catch (FileNotFoundException unused) {
            throw new TemplateError("cannot include template '" + str + "': file not found.");
        } catch (IOException e) {
            throw new TemplateError("unknown I/O exception while including '" + str + "' (stacktrace nested)", e);
        }
    }

    @Override // org.mvel2.templates.res.Node
    public boolean demarcate(Node node, char[] cArr) {
        return false;
    }

    @Override // org.mvel2.templates.res.Node
    public Object eval(f00.d dVar, c cVar, Object obj, VariableResolverFactory variableResolverFactory) {
        String str = (String) org.mvel2.d.p(this.contents, this.includeStart, this.includeOffset, obj, variableResolverFactory, String.class);
        int i = this.preOffset;
        if (i != 0) {
            org.mvel2.d.o(this.contents, this.preStart, i, obj, variableResolverFactory);
        }
        Node node = this.next;
        return node != null ? node.eval(dVar, cVar.append(String.valueOf(f00.d.a(readInFile(dVar, str), obj, variableResolverFactory))), obj, variableResolverFactory) : cVar.append(String.valueOf(org.mvel2.d.l(readInFile(dVar, str), obj, variableResolverFactory)));
    }
}
