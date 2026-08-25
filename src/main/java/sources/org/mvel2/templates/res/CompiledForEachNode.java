package org.mvel2.templates.res;

import g00.a;
import g00.b;
import g00.c;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.mvel2.CompileException;
import org.mvel2.ParserContext;
import org.mvel2.d;
import org.mvel2.integration.VariableResolverFactory;
import org.mvel2.integration.impl.MapVariableResolverFactory;
import org.mvel2.templates.TemplateRuntimeError;
import org.mvel2.util.m;

/* loaded from: /home/user/Teezee-git/app_source/classes8.dex */
public class CompiledForEachNode extends Node {
    private Serializable cSepExpr;
    private Serializable[] ce;
    private ParserContext context;
    private String[] item;
    public Node nestedNode;
    private char[] sepExpr;

    public CompiledForEachNode(int i, String str, char[] cArr, int i2, int i3, ParserContext parserContext) {
        super(i, str, cArr, i2, i3);
        this.context = parserContext;
        configure();
    }

    private void configure() {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int i = this.cStart;
        int i2 = i;
        while (true) {
            int i3 = this.cEnd;
            if (i >= i3) {
                if (i2 < i3) {
                    if (arrayList2.size() != arrayList.size() - 1) {
                        throw new CompileException("expected character ':' in foreach tag", this.contents, this.cEnd);
                    }
                    arrayList2.add(m.x(this.contents, i2, this.cEnd - i2));
                }
                this.item = new String[arrayList.size()];
                Iterator it = arrayList.iterator();
                int i4 = 0;
                int i6 = 0;
                while (it.hasNext()) {
                    this.item[i6] = (String) it.next();
                    i6++;
                }
                int size = arrayList2.size();
                String[] strArr = new String[size];
                this.ce = new Serializable[size];
                Iterator it2 = arrayList2.iterator();
                while (it2.hasNext()) {
                    String str = (String) it2.next();
                    Serializable[] serializableArr = this.ce;
                    strArr[i4] = str;
                    serializableArr[i4] = d.d(str, this.context);
                    i4++;
                }
                return;
            }
            char[] cArr = this.contents;
            char c = cArr[i];
            if (c != '\"') {
                if (c != ',') {
                    if (c == ':') {
                        arrayList.add(m.x(cArr, i2, i - i2));
                    } else if (c != '[' && c != '{' && c != '\'' && c != '(') {
                        i++;
                    }
                } else {
                    if (arrayList2.size() != arrayList.size() - 1) {
                        throw new CompileException("unexpected character ',' in foreach tag", this.contents, this.cStart + i);
                    }
                    arrayList2.add(m.x(this.contents, i2, i - i2));
                }
                i2 = i + 1;
                i++;
            }
            i = m.c(cArr, i, c);
            i++;
        }
    }

    @Override // org.mvel2.templates.res.Node
    public boolean demarcate(Node node, char[] cArr) {
        this.nestedNode = this.next;
        this.next = this.terminus;
        char[] contents = node.getContents();
        this.sepExpr = contents;
        if (contents.length == 0) {
            this.sepExpr = null;
            return false;
        }
        this.cSepExpr = d.f(contents, this.context);
        return false;
    }

    @Override // org.mvel2.templates.res.Node
    public Object eval(f00.d dVar, c cVar, Object obj, VariableResolverFactory variableResolverFactory) {
        int length = this.item.length;
        Iterator[] itArr = new Iterator[length];
        for (int i = 0; i < length; i++) {
            Object r = d.r(this.ce[i], obj, variableResolverFactory);
            if (r instanceof Iterable) {
                itArr[i] = ((Iterable) r).iterator();
            } else if (r instanceof Object[]) {
                itArr[i] = new a((Object[]) r);
            } else {
                if (!(r instanceof Integer)) {
                    throw new TemplateRuntimeError("cannot iterate object type: " + r.getClass().getName());
                }
                itArr[i] = new b(((Integer) r).intValue());
            }
        }
        HashMap hashMap = new HashMap();
        MapVariableResolverFactory mapVariableResolverFactory = new MapVariableResolverFactory(hashMap, variableResolverFactory);
        int i2 = length;
        while (true) {
            for (int i3 = 0; i3 < length; i3++) {
                if (itArr[i3].hasNext()) {
                    hashMap.put(this.item[i3], itArr[i3].next());
                } else {
                    i2--;
                    hashMap.put(this.item[i3], "");
                }
            }
            if (i2 == 0) {
                break;
            }
            this.nestedNode.eval(dVar, cVar, obj, mapVariableResolverFactory);
            if (this.sepExpr != null) {
                int i4 = 0;
                while (true) {
                    if (i4 >= length) {
                        break;
                    }
                    if (itArr[i4].hasNext()) {
                        cVar.append(String.valueOf(d.r(this.cSepExpr, obj, variableResolverFactory)));
                        break;
                    }
                    i4++;
                }
            }
        }
        Node node = this.next;
        if (node != null) {
            return node.eval(dVar, cVar, obj, variableResolverFactory);
        }
        return null;
    }

    public Node getNestedNode() {
        return this.nestedNode;
    }

    public void setNestedNode(Node node) {
        this.nestedNode = node;
    }
}
