package org.mvel2.templates.res;

import f00.d;
import g00.c;
import java.io.Serializable;
import org.mvel2.integration.VariableResolverFactory;
import org.mvel2.util.m;

/* loaded from: /home/user/Teezee-git/app_source/classes8.dex */
public abstract class Node implements Serializable {
    protected int begin;
    protected int cEnd;
    protected int cStart;
    protected char[] contents;
    protected int end;
    protected String name;
    public Node next;
    protected Node terminus;

    public Node() {
    }

    public Node(int i, String str, char[] cArr, int i2, int i3) {
        this.begin = i;
        this.cStart = i2;
        this.cEnd = i3 - 1;
        this.end = i3;
        this.name = str;
        this.contents = cArr;
    }

    public Node(int i, String str, char[] cArr, int i2, int i3, Node node) {
        this.name = str;
        this.begin = i;
        this.cStart = i2;
        this.cEnd = i3 - 1;
        this.end = i3;
        this.contents = cArr;
        this.next = node;
    }

    public void calculateContents(char[] cArr) {
        int i = this.cStart;
        this.contents = m.K0(cArr, i, this.end - i);
    }

    public abstract boolean demarcate(Node node, char[] cArr);

    public abstract Object eval(d dVar, c cVar, Object obj, VariableResolverFactory variableResolverFactory);

    public int getBegin() {
        return this.begin;
    }

    public int getCEnd() {
        return this.cEnd;
    }

    public int getCStart() {
        return this.cStart;
    }

    public char[] getContents() {
        return this.contents;
    }

    public int getEnd() {
        return this.end;
    }

    public int getLength() {
        return this.end - this.begin;
    }

    public String getName() {
        return this.name;
    }

    public Node getNext() {
        return this.next;
    }

    public Node getTerminus() {
        return this.terminus;
    }

    public boolean isOpenNode() {
        return false;
    }

    public void setBegin(int i) {
        this.begin = i;
    }

    public void setCEnd(int i) {
        this.cEnd = i;
    }

    public void setCStart(int i) {
        this.cStart = i;
    }

    public void setContents(char[] cArr) {
        this.contents = cArr;
    }

    public void setEnd(int i) {
        this.end = i;
    }

    public void setName(String str) {
        this.name = str;
    }

    public Node setNext(Node node) {
        this.next = node;
        return node;
    }

    public void setTerminus(Node node) {
        this.terminus = node;
    }
}
