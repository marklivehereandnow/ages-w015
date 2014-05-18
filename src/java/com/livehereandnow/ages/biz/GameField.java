/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.livehereandnow.ages.biz;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mark
 */
public class GameField {

    List<Integer> field;
    List<Integer> p1;
    List<Integer> p2;
    int p1CardCnt=0;
    int p2CardCnt=0;

    
    public void addPlayerCardCnt(int player, int val) {
        switch (player){
            case 1:
                p1CardCnt+=val;
            case 2:
                p2CardCnt+=val;
                
        }
        
    }
    public int getPlayerCardCnt(int player) {
        switch (player){
            case 1:
               return p1CardCnt;
            case 2:
               return  p2CardCnt;
                
        }
        return -1;
        
    }
public int getP1CardCnt() {
        return p1CardCnt;
    }

    public void setP1CardCnt(int p1CardCnt) {
        this.p1CardCnt = p1CardCnt;
    }

    public int getP2CardCnt() {
        return p2CardCnt;
    }

    public void setP2CardCnt(int p2CardCnt) {
        this.p2CardCnt = p2CardCnt;
    }
    
    public List<Integer> getField() {
        return field;
    }

    public List<Integer> getPlayer(int p) {
        if (p == 1) {
            return p1;
        }
        if (p == 2) {
            return p2;
        }

        return null;
    }

    public List<Integer> getP1() {
        return p1;
    }

    public List<Integer> getP2() {
        return p2;
    }

    public GameField() {
        field = new ArrayList<>();
        p1 = new ArrayList<>();
        p2 = new ArrayList<>();

        for (int k = 1001; k <= 1013; k++) {
            field.add(k);
        }

//        p1.add(1105);
//        p2.add(1249);
        
        for (int index = 0; index < 7; index++) {

            p1.add(1000);
            p2.add(1000);

        }

    }

}
