package com.example.javier.proyectoemilio;

/**
 * Created by javier on 11/1/2015.
 */
public class User {

        String  userKey_;
        String  userId_;
        String familyName_;
        String name_;
        String groupName_;
        String department_;
        String position_;
        String email_;
        int likeValue_;
        int karma_;
        boolean admin_;
        int userIdeas_;
        int userComments_;
        int userLikes_;
        int userPoints_;
        String dateMembership_;
        String avatar_;



    public  User(
                //String idKey,
                String userId,
                String name,
                String familyName,
                String groupName,
                String department,
                String position,
                String email,
                int likeValue,
                int karma,
                boolean admin,
                int userIdeas,
                int userComments,
                int userLikes,
                int userPoints,
                String dateMembership,
                String avatar
        ) {

            //this.userKey_ = userKey;
            this.userId_ = userId;
            this.familyName_ = familyName  ;
            this.name_ = name  ;
            this.groupName_ = groupName  ;
            this.department_ = department  ;
            this.position_ = position  ;
            this.email_ = email  ;
            this.likeValue_ = likeValue  ;
            this.karma_ = karma  ;
            this.admin_ = admin  ;
            this.userIdeas_ = userIdeas  ;
            this.userComments_ = userComments  ;
            this.userLikes_ = userLikes  ;
            this.userPoints_ = userPoints  ;
            this.dateMembership_ = dateMembership  ;
            this.avatar_ = avatar  ;
        }

    public User() {

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

        public String email() {
            return email_;
        }

        public int likeValue() {
            return likeValue_;
        }

        public int karma() {
            return likeValue_;
        }

        public boolean admin() {
            return admin_;
        }

        public int userIdeas() {
            return likeValue_;
        }

        public int userComments() {
            return userComments_;
        }

        public int userLikes() {
            return userLikes_;
        }

        public int userPoints() {
            return userPoints_;
        }
}

