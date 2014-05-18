/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.livehereandnow.ages.biz;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mark
 */
@Entity
@Table(name = "GAME_LIVE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GameLive.findAll", query = "SELECT g FROM GameLive g"),
    @NamedQuery(name = "GameLive.findById", query = "SELECT g FROM GameLive g WHERE g.id = :id"),
    @NamedQuery(name = "GameLive.findByCardRow", query = "SELECT g FROM GameLive g WHERE g.cardRow = :cardRow"),
    @NamedQuery(name = "GameLive.findByP1Hand", query = "SELECT g FROM GameLive g WHERE g.p1Hand = :p1Hand"),
    @NamedQuery(name = "GameLive.findByP2Hand", query = "SELECT g FROM GameLive g WHERE g.p2Hand = :p2Hand")})
public class GameLive implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 120)
    @Column(name = "CARD_ROW")
    private String cardRow;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 120)
    @Column(name = "P1_HAND")
    private String p1Hand;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 120)
    @Column(name = "P2_HAND")
    private String p2Hand;

    public GameLive() {
    }

    public GameLive(Integer id) {
        this.id = id;
    }

    public GameLive(Integer id, String cardRow, String p1Hand, String p2Hand) {
        this.id = id;
        this.cardRow = cardRow;
        this.p1Hand = p1Hand;
        this.p2Hand = p2Hand;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCardRow() {
        return cardRow;
    }

    public void setCardRow(String cardRow) {
        this.cardRow = cardRow;
    }

    public String getP1Hand() {
        return p1Hand;
    }

    public void setP1Hand(String p1Hand) {
        this.p1Hand = p1Hand;
    }

    public String getP2Hand() {
        return p2Hand;
    }

    public void setP2Hand(String p2Hand) {
        this.p2Hand = p2Hand;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GameLive)) {
            return false;
        }
        GameLive other = (GameLive) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.livehereandnow.ages.biz.GameLive[ id=" + id + " ]";
    }
    
}
