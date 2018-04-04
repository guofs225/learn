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
        tempTxList.add("����ʫ");
        tempTxList.add("������");
        tempTxList.add("ss");
        tempTxList.add("��ο��");
        tempTxList.add("������");
        tempTxList.add("������");
        tempTxList.add("����V");
        tempTxList.add("Ȩ��");
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
