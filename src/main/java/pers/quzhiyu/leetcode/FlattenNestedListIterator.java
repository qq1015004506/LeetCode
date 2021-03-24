package pers.quzhiyu.leetcode;

import pers.quzhiyu.helper.NestedInteger;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class NestedIterator implements Iterator<Integer> {
    List<Integer> nested = new ArrayList<>();
    int cnt = 0;
    public NestedIterator(List<NestedInteger> nestedList) {
        for (int i = 0; i < nestedList.size(); i++) {
            helper(nestedList.get(i),nested);
        }
    }

    void helper(NestedInteger obj,List<Integer> nested) {
        if(obj.isInteger()) {
            nested.add(obj.getInteger());
        }else {
            List<NestedInteger> list = obj.getList();
            for (int i = 0; i < list.size(); i++) {
                helper(list.get(i),nested);
            }
        }
    }

    @Override
    public Integer next() {
        return nested.get(cnt);
    }

    @Override
    public boolean hasNext() {
        return cnt < nested.size();
    }
}

public class FlattenNestedListIterator {
}
