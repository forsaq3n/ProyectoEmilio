package com.example.javier.proyectoemilio;

/**
 * Created by javier on 11/1/2015.
 */
//
//  Message.swift
//  FireChat-Swift
//
//  Created by Katherine Fang on 8/20/14.
//  Copyright (c) 2014 Firebase. All rights reserved.
//

import java.util.ArrayList;



public class Card { //, JSQMessageData

       String cardId_;
       String userId_;
       String familyName_;
       String name_;
       String groupName_;
       String department_;
       String position_;
       String datePosted_;
       String dateUpdated_;
       String text_;
       int cardScore_;
       int cardComments_;
       int cardLikes_;
       int cardLikesTotal_;
       ArrayList<LikeData> cardLikesArray_ ;
       int cardCommentsTotal;
       ArrayList<LikeData>  cardComments2_;
       String avatar_;
       String dateLastComment_;

    public Card() {

    }

    // public Card(String idKey, Object userId, Object familyName, Object name, Object groupName, Object position, Object department, Object postText, Object cardScore, Object cardComments, Object cardLikes, Object dateLastComment) {
   // }


    //cardData.modified = "アイデア作成";
       //cardData.lastCommentModified = "まだ...";
       //cardData.liked  = [];
       //cardData.ideaLiked  = "NaN";


       //convenience init(text: String?, sender: String?) {
       //    self.init(text: text, sender: sender, imageUrl: nil)
       //}

       public void Card()
       {
           cardId_ = "";
           userId_ = "";
           familyName_ = "";
           name_ = "";
           groupName_ = "";
           department_ = "";
           position_ = "";
           datePosted_ = "";
           dateUpdated_ = "";
           text_ = "";
           cardScore_ = 0;
           cardComments_ = 0;
           cardLikes_ = 0;
           dateLastComment_ = "";
           cardLikesTotal_ = 0;
           //cardLikesArray_ =[];
           cardCommentsTotal = 0;
           //cardComments2_ =[];
           avatar_ = "";
       }


        public  Card(
               String cardId,
               String userId,
               String familyName,
               String name,
               String groupName,
               String department,
               String position,
               String datePosted,
               String dateUpdated,
               String text,
               int cardScore,
               int cardComments,
               int cardLikes,
               String dateLastComment,
               ArrayList<LikeData> cardLikesArray,
               int cardCommentsTotal,
                ArrayList<LikeData> cardComments2
       ) {

           this.cardId_ = cardId;
           this.userId_ = userId;
           this.familyName_ = familyName;
           this.name_ = name;
           this.groupName_ = groupName;
           this.department_ = department;
           this.position_ = position;
           this.datePosted_ = datePosted;
           this.dateUpdated_ = dateUpdated;
           this.text_ = text;
           this.cardScore_ = cardScore;
           this.cardComments_ = cardComments;
           this.cardLikes_ = cardLikes;
           this.dateLastComment_ = dateLastComment;
           this.cardLikesArray_ = cardLikesArray;
           this.cardCommentsTotal = cardCommentsTotal;
           this.cardComments2_ = cardComments2;
       }

        public String cardId() {
            return cardId_;
        }

        public String userId() {
            return userId_;
        }

        public String familyName() {
            return familyName_;
        }

        public String name() {
            return name_;
        }

        public String groupName() {
            return groupName_;
        }

        public String department() {
            return department_;
        }

        public String position() {
            return position_;
        }

        public String datePosted() {
            return datePosted_;
        }

        public String dateUpdated() {
            return dateUpdated_;
        }

        public int cardScore() {
            return cardScore_;
        }

        public int cardComments() {
            return cardComments_;
        }

        public int getLikes() {
            return cardLikes_;
        }

        public void setCardScore(int score) {
            this.cardScore_ = score;
        }

        public void setLikes(int totalLikes) {
            this.cardLikes_ = totalLikes;
        }



}





