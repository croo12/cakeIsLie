package com.swea.typeB.textProgram;

import java.util.ArrayList;
import java.util.List;

class UserSolution_ex {

    private int W;
    private int[][] cntOfAlphabet;

    private List<Character> memo;
    private int cursor;
    private int size;

    void init(int H, int W, char[] mStr) {
        this.W = W;
        cntOfAlphabet = new int[H][26];
        memo = new ArrayList<>();
        cursor = 0;
        size = 0;

        for (char cur : mStr) {
            if (cur == '\0') {
                break;
            }

            memo.add(cur);
            cntOfAlphabet[size / W][cur - 'a']++;
            size++;
        }
    }

    void insert(char mChar) {
        memo.add(cursor, mChar);

        int curRow = cursor / W;
        cntOfAlphabet[curRow][mChar - 'a']++;

        for (int lastRow = size / W, i = curRow + 1; i <= lastRow; i++) {
            char movedChar = memo.get(i * W);
            cntOfAlphabet[i - 1][movedChar - 'a']--;
            cntOfAlphabet[i][movedChar - 'a']++;
        }

        cursor++;
        size++;
    }

    char moveCursor(int mRow, int mCol) {
        cursor = (mRow - 1) * W + (mCol - 1);

        if (cursor < size) {
            return memo.get(cursor);
        }

        cursor = size;
        return '$';
    }

    int countCharacter(char mChar) {
        int cnt = 0;
        int nextRow = 1 + cursor / W;

        for (int len = Math.min(nextRow * W, size),  i = cursor; i < len; i++) {
            if (memo.get(i) == mChar) {
                cnt++;
            }
        }

        for (int lastRow = (size - 1) / W, i = nextRow; i <= lastRow ; i++) {
            cnt += cntOfAlphabet[i][mChar - 'a'];
        }

        return cnt;
    }

}