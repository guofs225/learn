package com.guofs.test.merkleTrees;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: GuoFangshi
 * @Date: 2018/4/4 15:20
 */
public class TestMain {
    public static void main(String[] args) {
        List<String> tempTxList = new ArrayList<>();
        tempTxList.add("郭芳诗");
        tempTxList.add("申诉书");
        tempTxList.add("ss");
        tempTxList.add("安慰我");
        tempTxList.add("发发发");
        tempTxList.add("互联网");
        tempTxList.add("爱我V");
        tempTxList.add("权威");
//        tempTxList.add("a");
//        tempTxList.add("b");
//        tempTxList.add("c");
//        tempTxList.add("d");
//        tempTxList.add("e");
        MerkleTrees merkleTrees = new MerkleTrees(tempTxList);
        merkleTrees.merkle_tree();
        System.out.println("root: " + merkleTrees.getRoot());
    }
}
