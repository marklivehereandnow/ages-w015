/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.livehereandnow.ages.biz;

import com.livehereandnow.ages.jpa.GameLiveJpaController;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;

/**
 *
 * @author mark
 */
@ManagedBean
//@Singleton
@SessionScoped
//@RequestScoped
//@PersistenceContext

public class Biz {

    public Biz() {
        gf = new GameField();
        init();
    }

//    @PersistenceContext
    private EntityManager em;
    private GameField gf;
    /**
     * <p>
     * The transaction resource.</p>
     */
//    @Resource
//    private UserTransaction utx;

//    private String NOCARD = "http://2nd2go.org/ages/img/m1000.jpg";
    private String[] addr = new String[30];

    private String IMG_DIR = "http://2nd2go.org/ages/img/abcd/";
    private String imgSize = "d";
    private String sysMsg;
    private String username;
    private String player;

    private boolean notAllowNewGame;

    public String getSysMsg() {
        return sysMsg;
    }

    public void setSysMsg(String sysMsg) {
        this.sysMsg = sysMsg;
    }

    public String getImgSize() {
        return imgSize;
    }

    public boolean isNotAllowNewGame() {
        return notAllowNewGame;
    }

    public boolean isAllowed() {
        if (player.equalsIgnoreCase("max")) {
            return true;
        }
        if (player.equalsIgnoreCase("amy")) {
            return true;
        }
        return false;
    }

    public void setNotAllowNewGame(boolean notAllowNewGame) {
        this.notAllowNewGame = notAllowNewGame;
    }

    public String getCurrentPlayer() {
        return player;
    }

    public void setCheckedUsername(String checkedUsername) {
        this.player = checkedUsername;
    }
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void checkPassword() {
        player = "guest";
        System.out.println("checkPassword   ???checking user/pass: " + username + "/" + password);
        if (username.equalsIgnoreCase("max") && password.equals("123")) {
            player = "max";
        }
        if (username.equalsIgnoreCase("amy") && password.equals("321")) {
            player = "amy";
        }
        if (username.equalsIgnoreCase("guest")) {
            notAllowNewGame = true;
        } else {
            notAllowNewGame = false;

        }

//        username = "";
    }

    int removeCnt;

    private void init() {
        notAllowNewGame = true;
//        username = "guest";
//        password = "***";
//        player = "guest";

        System.out.println("...init");
        removeCnt = 0;
//        int p = 1000;
        for (int k = 0; k <= 13; k++) {
            addr[k] = IMG_DIR + "m" + (1000 + k) + ".jpg";
        }

        for (int k = 14; k <= 29; k++) {
            addr[k] = IMG_DIR + "m" + (1033 + k) + ".jpg";
        }

    }

    public String getPlayerOnHand(int player, int index) {
        int id = gf.getPlayer(player).get(index);
        return getImageById(id);
//        return "XXx";
    }

    public String getImageById(int id) {

        return IMG_DIR + getImgSize() + id + ".jpg";
    }

    public void doNewGame() {
        init();
//        gf=new GameField();
    }

    public String getCardRowImg(int k) {
        return getImageById(gf.getField().get(k));

    }

    public void setAddr(int k, String str) {
        removeCnt++;

        addr[k] = str;
    }

//    public void doStep1() {
//        System.out.println("...doStep1, remove first 3 cards");
//
//        if (!addr[1].equals(NOCARD)) {
//            removeCnt++;
//        }
//        if (!addr[2].equals(NOCARD)) {
//            removeCnt++;
//        }
//        if (!addr[3].equals(NOCARD)) {
//            removeCnt++;
//        }
//
//        addr[1] = "http://2nd2go.org/ages/img/m1000.jpg";
//        addr[2] = "http://2nd2go.org/ages/img/m1000.jpg";
//        addr[3] = "http://2nd2go.org/ages/img/m1000.jpg";
//
////        setAddr(1, "http://2nd2go.org/ages/img/p1000.jpg");
////        setAddr(2, "http://2nd2go.org/ages/img/p1000.jpg");
////        setAddr(3, "http://2nd2go.org/ages/img/p1000.jpg");
////      
//    }
//    public void doStep2() {
//        System.out.println("...doStep2, align left");
//// addr[4]= "http://2nd2go.org/ages/img/p1000.jpg";
//        //   removeCnt = 0;
//        for (int safe = 0; safe <= 12; safe++) {
//            for (int k = 1; k <= 12; k++) {
//                if (addr[k].equalsIgnoreCase(NOCARD)) {
//                    for (int m = k + 1; m <= 13; m++) {
//                        addr[m - 1] = addr[m];
//                    }
//                    addr[13] = NOCARD;
//                }
//            }
//        }
//
//    }
    public void doStep3() {
        System.out.println("...doStep3, refil");
        for (int k = 13 - removeCnt + 1; k <= 13; k++) {
            addr[k] = addr[k + removeCnt];
        }
    }

    public void doAAA(int k) {
        System.out.println(" doing on AAA");
        
    }

    public void doBBB(int k) {
        System.out.println(" doing on BBB");

    }

    public void actTakeCard(int k) {

        setSysMsg("...");
        if (!isAllowed()) {
//            System.out.println("...NOT PLAYER, NOT ALLOW TO TOUCH CARD ROW ");
            setSysMsg("...NOT PLAYER, NOT ALLOW TO TOUCH CARD ROW ");
//         FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "System Error",  "Please try again later.");

//        FacesContext.getCurrentInstance().addMessage(null, message);
            return;
        }
        System.out.println(player + ", take-card " + k);

        if (getCurrentPlayer().equals("max")) {

            int card = gf.getField().get(k);
            gf.getField().set(k, 1000);
//            List<Integer> list=gf.getP1();
//            list.add(list.size(), card);
//            gf.addPlayerCardCnt(1, 1);
//            gf.getP1().set(gf.getP1CardCnt(), card);
            
            System.out.println(""+gf.getP1());

        }

    
//        setAddr(k, "http://2nd2go.org/ages/img/m1000.jpg");
//        setAddr1("http://2nd2go.org/ages/img/p1000.jpg");
//        em=GameLiveJpaController.
////        
//        GameLiveController gameLiveController = new GameLiveController();
//        GameLive gameLive = gameLiveController.getGameLive(1);
//        gameLive.setCardRow("0,0,0");
////        gameLiveController.update();
//                GameLive gameLive = new GameLive(2, "1,2,3", "4", "5");
        try {
//            utx.begin();
//            em.persist(gameLive);
//            utx.commit();
//                return "login";
        } catch (Exception e) {
//            System.out.println(" NOT YET!!! "+e.toString());
//                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
//                                                        "Error creating user!",
//                                                        "Unexpected error when creating your account.  Please contact the system Administrator");
//                context.addMessage(null, message);
//                Logger.getAnonymousLogger().log(Level.SEVERE,
//                                                "Unable to create new user",
//                                                e);
//                return null;
        }

        System.out.println("   please check db...");
    }
}
