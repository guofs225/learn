package com.guofs.test.merkleTrees;

import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: GuoFangshi
 * @Date: 2018/4/4 13:41
 */
public class MerkleTrees {

    /** 交易集合 */
    List<String> txList;
    /** Merkle Root */
    String root;

    public MerkleTrees(List<String> txList) {
        this.txList = txList;
        root = "";
    }

    public void merkle_tree() {
        List<String> tempTxList = new ArrayList<>();
        for (int i = 0; i < this.txList.size(); i++){
            tempTxList.add(this.txList.get(i));
        }
        List<String> newTxList = getNewTxList(tempTxList);
        while (newTxList.size() != 1) {
            newTxList = getNewTxList(newTxList);
        }
        this.root = newTxList.get(0);
    }

    /**
     * return Node Hash List.
     * @param tempTxList
     * @return
     */
    private List<String> getNewTxList(List<String> tempTxList) {
        List<String> newTxList = new ArrayList<>();
        int index = 0;
        while (index < tempTxList.size()) {
            // left
            String left = tempTxList.get(index);
            index++;

            // right
            String right = "";
            if (index != tempTxList.size()) {
                right = tempTxList.get(index);
            }

            // sha2 hex value
            String sha2HexValue = getSHA2HexValue(left + right);
            newTxList.add(sha2HexValue);
            index++;
        }
        return newTxList;
    }

    /**
     * Return hex string
     * @param str
     * @return
     */
    public String getSHA2HexValue(String str) {
        byte[] cipher_byte;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            cipher_byte = md.digest(str.getBytes());
            StringBuilder sb = new StringBuilder(2 * cipher_byte.length);
            for (byte b: cipher_byte) {
                sb.append(String.format("%02x", b&0xff));
            }
            return sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    public String getRoot() {
        return this.root;
    }
}
