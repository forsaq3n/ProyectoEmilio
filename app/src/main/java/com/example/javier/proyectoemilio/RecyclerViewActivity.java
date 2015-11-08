package com.example.javier.proyectoemilio;

/**
 * Created by javier on 10/24/2015.
 */

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import android.util.Base64;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.zip.Inflater;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.firebase.client.AuthData;
import com.firebase.client.*;

public class RecyclerViewActivity extends Activity {


    private RecyclerView rv;
    private ImageView editButton;
    private Context context;
    private Image avatar;
    private TextView userTextView;
    private static RVAdapter adapter;


    String  LabelTextEditor_ = "";
    private static List<Card> card;
    private Card cardData = new Card();
    private User userData = new User();
    private LikeData likes = new LikeData();

    User currentUser = new User();
    User user = new User();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.recyclerview_activity);
        Firebase.setAndroidContext(this);

        rv=(RecyclerView)findViewById(R.id.rv);
        editButton = (ImageView)findViewById(R.id.edit_button);
        userTextView = (TextView)findViewById(R.id.user);
        context =getBaseContext();

        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);
        rv.setHasFixedSize(true);
        card = new ArrayList<>();
        getCards();


        adapter = new RVAdapter(card);
        rv.setAdapter(adapter);



        a();;




       /* editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, EditActivity.class);

                startActivity(intent);
            }
        });*/
    }

 /*   private void initializeData(){
        idea = new ArrayList<>();
        //Idea(String date, String status, int photoId, String ownerID, String content)
        idea.add(new Idea("2015-08-21 10:42", "Votes 0 ", R.drawable.images," Emilio", "ffgjhgjhvkghdhdchcbvfxjhxcjfcxgf"));
        idea.add(new Idea("2015-08-21 10:42", "Votes 0 ", R.drawable.images, " Emilio", "ffgjhgjhvkghdhdchcbvfxjhxcjfcxgf"));
        idea.add(new Idea("2015-08-21 10:42", "Votes 0 ", R.drawable.images, " Emilio", "ffgjhgjhvkghdhdchcbvfxjhxcjfcxgf"));
        idea.add(new Idea("2015-08-21 10:42", "Votes 0 ", R.drawable.images, " Emilio", "ffgjhgjhvkghdhdchcbvfxjhxcjfcxgf"));
        idea.add(new Idea("2015-08-21 10:42", "Votes 0 ", R.drawable.images, " Emilio", "ffgjhgjhvkghdhdchcbvfxjhxcjfcxgf"));
        idea.add(new Idea("2015-08-21 10:42", "Votes 0 ", R.drawable.images, " Emilio", "ffgjhgjhvkghdhdchcbvfxjhxcjfcxgf"));
        idea.add(new Idea("2015-08-21 10:42", "Votes 0 ", R.drawable.images, " Emilio", "ffgjhgjhvkghdhdchcbvfxjhxcjfcxgf"));


    }
*/


    private int objectToInt(Object object){

        if (object == null)
            {
            return 0;
            }


            return Integer.valueOf(object.toString());

    }

    private boolean objectToBoolean(Object object){
        if (object == null)
        {
            return false;
        }
        return  (((Boolean) object).booleanValue());

    }

    private String  objectToString(Object object){
        if (object == null)
        {
            return "";
        }
        return  (((String ) object.toString()));

    }

    public void a ()
    {
        // *** STEP 1: Find Current User
         Users  users = new Users();

        String  userName = "emilio.mobile@gmail.com";
        String password = "00";

        users.authenticateUser(userName, password);

       //this.currentUser = users.findUser(userName, UIcontroller: self);

        Firebase ref ;

        int recordsFound = 0;

       //ards = [""];223332222

        ref =new  Firebase("https://dazzling-heat-8787.firebaseio.com/users");


        Query queryRef = ref.orderByValue();
        ChildEventListener childEventListener = queryRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot snapshot, String previousChildKey) {
                System.out.println("The " + snapshot.getKey() + " dinosaur's score is " + snapshot.getValue());
                //System.out.println(" spapppppppppppppppppppppp" + snapshot.getValue("userId");

                       Map < String, Object > newPost = (Map<String, Object>) snapshot.getValue();
             /*   System.out.println( " new postpppppp " + newPost);
               // {familyName=Coronado, cardKey=-K2V87cedm6O6glvU8dQ, userId=-Jtau9h05rjJ2Pb0iFT8, idKey=-K2V87cedm6O6glvU8dQ, dateUpdated=1446869502709, datePosted=1446869502709, cardScore=0, cardLikes=0, cardComments=0, position=CTO - Engineering, postText=lkm,.m,.m,.m., text=lkm,.m,.m,.m., name=Emilio, groupName=Marketing, dateLastComment=1446869502709, department=Management}
                System.out.println("idKey: " + newPost.get("idKey"));
                System.out.println("userId: " + newPost.get("userId"));
                System.out.println("familyName: " + newPost.get("familyName"));
                System.out.println("Author: " + newPost.get("name"));
                System.out.println("name: " + newPost.get("groupName"));
                System.out.println("position: " + newPost.get("position"));
                System.out.println("mail: " + newPost.get("mail"));
                System.out.println("likeValue: " + newPost.get("likeValue"));
                System.out.println("admin: " + newPost.get("admin"));
                System.out.println("karma: " + newPost.get("karma"));
                System.out.println("userIdeas: " + newPost.get("userIdeas"));
                System.out.println("userLikes: " + newPost.get("userLikes"));
                System.out.println("userPoints: " + newPost.get("userPoints"));

*/
                /*
                 newPost.get("idKey").toString(),
                        newPost.get("userId"),
                        newPost.get("familyName"),
                        newPost.get("name"),
                        newPost.get("groupName"),
                        newPost.get("position"),
                        newPost.get("department"),
                        newPost.get("postText"),
                        newPost.get("cardScore"),
                        newPost.get("cardComments"),
                        newPost.get("cardLikes"),
                        newPost.get("dateLastComment")

                 */


                user.userId_= newPost.get("userId").toString();
                user.name_= newPost.get("name").toString();
                user.familyName_=    objectToString(newPost.get("familyName"));
                user.groupName_=     objectToString(newPost.get("groupName"));
                user.department_=     objectToString(newPost.get("department"));
                user.position_ = objectToString(newPost.get("position"));
                user.email_=        objectToString(newPost.get("mail"));
                user.likeValue_=      objectToInt(newPost.get("likeValue"));
                user.karma_=       objectToInt(newPost.get("karma"));
                user.admin_=        objectToBoolean(newPost.get("admin"));
                user.userIdeas_=        objectToInt(newPost.get("userIdeas"));
                user.userComments_ =      objectToInt(newPost.get("userComments"));
                user.userLikes_=        objectToInt(newPost.get("userLikes"));
                user.userPoints_=       objectToInt(newPost.get("userPoints"));
                 user.dateMembership_=       "";
                 user.avatar_  =     "";
                userTextView.setText(user.name_+" ");
                //System.out.println("--------------- user points : " + user.userPoints_);
                //System.out.println("--------------- user points : " + user.userId_);

                Firebase avtarRef = new Firebase("https://dazzling-heat-8787.firebaseio.com/pictures/");

                //avtarRef.orderByValue();("userId").queryEqualToValue(userData.userId_).observeEventType(FEventType.Value, withBlock: { snapshot in
                final ValueEventListener userId = avtarRef.orderByChild("userId").equalTo(user.userId_).addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot snapshot) {
                       // System.out.println("userData.avatar_" + " - " + userData.avatar_);

                        for (DataSnapshot postSnapshot : snapshot.getChildren()) {
                            String avatar = postSnapshot.getValue().toString();
                            userData.avatar_ = avatar;
                           System.out.println("userData.avatar_ 2" + " - " + userData.avatar_);
                        }
                        editButton.setImageBitmap(decodeBase64(userData.avatar_));

                        System.out.println(snapshot.getValue());
                    }

                    @Override
                    public void onCancelled(FirebaseError firebaseError) {
                        System.out.println("The read failed: " + firebaseError.getMessage());
                    }


                });


            }


            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
            // ....
        });
    }

    public void getCards ()
    {
        // *** STEP 1: Find Current User
        //final Card  card = new Card();
        Users users1 = new Users();
        String  userName = "emilio.mobile@gmail.com";
        String password = "00";

        users1.authenticateUser(userName, password);

        //this.currentUser = users.findUser(userName, UIcontroller: self);

        Firebase ref ;

        int recordsFound = 0;

        //ards = [""];223332222

        ref =new  Firebase("https://dazzling-heat-8787.firebaseio.com/cards");


        Query queryRef = ref.orderByValue();
        ChildEventListener childEventListener = queryRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot snapshot, String previousChildKey) {
                System.out.println("snapshot  " + snapshot);
                 //System.out.println(" spapppppppppppppppppppppp" + snapshot.getValue("userId");
                Map < String, Object > newPost = (Map<String, Object>) snapshot.getValue();

                Card cardx= new Card();

                cardx.cardId_= objectToString(newPost.get("cardKey"));
                cardx.userId_= objectToString(newPost.get("userId"));
                cardx.familyName_=    objectToString(newPost.get("familyName"));
                cardx.familyName_=    objectToString(newPost.get("name"));
                cardx.groupName_=     objectToString(newPost.get("groupName"));
                cardx.department_=     objectToString(newPost.get("department"));
                cardx.position_ = objectToString(newPost.get("position"));
                cardx.datePosted_=        objectToString(newPost.get("datePosted"));
                cardx.dateUpdated_=      objectToString(newPost.get("dateUpdated"));
                cardx.text_ = objectToString(newPost.get("postText"));
                cardx.cardScore_=        objectToInt(newPost.get("cardScore"));
                cardx.cardComments_=        objectToInt(newPost.get("cardComments"));
                cardx.cardLikes_ = objectToInt(newPost.get("cardLikes"));
                cardx.dateLastComment_=       objectToString(newPost.get("dateLastComment"));

                if(snapshot != null && snapshot.getValue() != null) {

                    //Firebase - Converte a resposta em um objeto do tipo Chat
//                    Card model = snapshot.getValue(Card.class);


                    card.add(cardx);
                    rv.scrollToPosition(card.size() - 1);
                    adapter.notifyItemInserted(card.size() - 1);
                }



               // Card model = snapshot.getValue(Card.class);
                //card.add(model);
               // System.out.println("helllooooooooooooooooo" +card);
               // rv.scrollToPosition(card.size() - 1);
                //rv.notifyItemInserted(card.size() - 1);

/*
                user.userId_= newPost.get("userId").toString();
                user.name_= newPost.get("name").toString();
                user.familyName_=    objectToString(newPost.get("familyName"));
                user.groupName_=     objectToString(newPost.get("groupName"));
                user.department_=     objectToString(newPost.get("department"));
                user.position_ = objectToString(newPost.get("position"));
                user.email_=        objectToString(newPost.get("mail"));
                user.likeValue_=      objectToInt(newPost.get("likeValue"));
                user.karma_=       objectToInt(newPost.get("karma"));
                user.admin_=        objectToBoolean(newPost.get("admin"));
                user.userIdeas_=        objectToInt(newPost.get("userIdeas"));
                user.userComments_ =      objectToInt(newPost.get("userComments"));
                user.userLikes_=        objectToInt(newPost.get("userLikes"));
                user.userPoints_=       objectToInt(newPost.get("userPoints"));
                user.dateMembership_=       "";
                user.avatar_  =     "";
                userTextView.setText(user.name_+" ");
                System.out.println("--------------- user points : " + user.userPoints_);
                System.out.println("--------------- user points : " + user.userId_);
*/
                Firebase avtarRef = new Firebase("https://dazzling-heat-8787.firebaseio.com/pictures/");

                //avtarRef.orderByValue();("userId").queryEqualToValue(userData.userId_).observeEventType(FEventType.Value, withBlock: { snapshot in
                final ValueEventListener userId = avtarRef.orderByChild("userId").equalTo(user.userId_).addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot snapshot) {
                        Map < String, Object > newPost = (Map<String, Object>) snapshot.getValue();
                        System.out.println("avatarmap" + newPost);

                        System.out.println("---------1" + newPost);
                        System.out.println("---------2 " + snapshot.getValue());
                        System.out.println("---------3 " + snapshot.child(snapshot.getKey()));
                        System.out.println("---------4 " + snapshot.child(snapshot.getKey()));
                        System.out.println("avatarmap" + newPost);
                        userData.avatar_ = objectToString(newPost.get("facePicture"));
                        //cardx.dateLastComment_=       objectToString(newPost.get("dateLastComment"));
                        /*for (DataSnapshot postSnapshot : snapshot.getChildren()) {
                            String avatar = postSnapshot.getValue().toString();
                            userData.avatar_ = avatar;
                            System.out.println("userData.avatar_ 2" + " - " + userData.avatar_);
                        }*/
                        editButton.setImageBitmap(decodeBase64(userData.avatar_));

                        System.out.println("userData.avatar_ 2" + " - " + userData.avatar_);
                    }

                    @Override
                    public void onCancelled(FirebaseError firebaseError) {
                        System.out.println("The read failed: " + firebaseError.getMessage());
                    }


                });


            }


            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
            // ....
        });
    }

    public void authenticateUser(String userName, String password ){

        Firebase ref ;

        ref = new Firebase("https://dazzling-heat-8787.firebaseio.com/users");

        /*ref.authUser(userName, password,
                withCompletionBlock: { error, authData in

            if error != nil {
                // Error
            } else {
                // We are logged in
            }
        })*/
       
        ref.authWithPassword(userName, password,
                new Firebase.AuthResultHandler() {
                    @Override
                    public void onAuthenticated(AuthData authData) { /* ... */ }

                    @Override
                    public void onAuthenticationError(FirebaseError error) {
                        // Something went wrong :(
                        switch (error.getCode()) {
                            case FirebaseError.USER_DOES_NOT_EXIST:
                                // handle a non existing user
                                break;
                            case FirebaseError.INVALID_PASSWORD:
                                // handle an invalid password
                                break;
                            default:
                                // handle other errors
                                break;
                        }
                    }
                });
    }


    public static Bitmap decodeBase64(String input)
    {
        byte[] decodedByte = new byte[0];
        try {
            decodedByte = com.firebase.client.utilities.Base64.decode("/9j/4AAQSkZJRgABAQAASABIAAD/7QA4UGhvdG9zaG9wIDMuMAA4QklNBAQAAAAAAAA4QklNBCUAAAAAABDUHYzZjwCyBOmACZjs+EJ+/8AAEQgAZABkAwEiAAIRAQMRAf/EAB8AAAEFAQEBAQEBAAAAAAAAAAABAgMEBQYHCAkKC//EALUQAAIBAwMCBAMFBQQEAAABfQECAwAEEQUSITFBBhNRYQcicRQygZGhCCNCscEVUtHwJDNicoIJChYXGBkaJSYnKCkqNDU2Nzg5OkNERUZHSElKU1RVVldYWVpjZGVmZ2hpanN0dXZ3eHl6g4SFhoeIiYqSk5SVlpeYmZqio6Slpqeoqaqys7S1tre4ubrCw8TFxsfIycrS09TV1tfY2drh4uPk5ebn6Onq8fLz9PX29/j5+v/EAB8BAAMBAQEBAQEBAQEAAAAAAAABAgMEBQYHCAkKC//EALURAAIBAgQEAwQHBQQEAAECdwABAgMRBAUhMQYSQVEHYXETIjKBCBRCkaGxwQkjM1LwFWJy0QoWJDThJfEXGBkaJicoKSo1Njc4OTpDREVGR0hJSlNUVVZXWFlaY2RlZmdoaWpzdHV2d3h5eoKDhIWGh4iJipKTlJWWl5iZmqKjpKWmp6ipqrKztLW2t7i5usLDxMXGx8jJytLT1NXW19jZ2uLj5OXm5+jp6vLz9PX29/j5+v/bAEMAAgICAgICAwICAwUDAwMFBgUFBQUGCAYGBgYGCAoICAgICAgKCgoKCgoKCgwMDAwMDA4ODg4ODw8PDw8PDw8PD//bAEMBAgICBAQEBwQEBxALCQsQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEP/dAAQAB//aAAwDAQACEQMRAD8A/Tm58NalHo0fge9ni+wWclw7CwgNscyEMFEhleQbTnJRlByBjaBn0nw14fvvDWnW66XcvFYIMxJFlY0TPCeXwAFHGMY9KjSy1j7XPfX0aqkYLkjAOO/y+/oK1pNbVo/sNnaySMyJiTgIDnONpHzdOQRjB715EZNsr2aikY/iDw3pHjLQ9Q8N6hqVxp0jS/bEu4W2yQTsxPmKwxjG8KQeqnHQ15vL8ENV0zWbLVtIvn1R2itojcyzMCDEuxnVJGJRpPvPtOGPQAAKPXrbwzc3ibhdzI8DpL5ShBuAIEkR+U5jdVCcbdu5mzuIIg/4TXRtC1FodTuSqI6w7dowZpCPLTdnart0VSRuzxnBw5q+g4pX5rHoGh6fcWenxW17IJ7lFG9+mT7VfeJ2G5V4Feca948a31FbC2MVhFL+6EsrDzDLIAECZO0MDnCkPu4+h4PVfiRpi3Uun6v4gSzEAbO6Y2suYyRIxUBMICFAk3FWJKgZxlxpuWxbnY674i6Dc6po97FZ/url0WSJ8AjzYWDqpB4IJUA545PvXlnhDxbZ3cK6bqGYZ40PmbmzsYdckknacja5Jz0Y7sbvRtM8TPqNhLFpl69zbo2zzJFaRWJUNlJJAfMX5h8ysVByudykDy3xB8M21xk1KO5kttbhy/2q1YW0bSFTyEIlI+YcrnkHljyKtfyyMZJ3uj448d/Cf41eFtX1jSvhvcXN/wCGLqOYW9pHMPsyW1y0zXNqYe8u9iFl3BguADu5HsvhTWPFd14UuNV1bwdc6XJoNjAbaGKb7RNdxiEt5ZSONMOAANgDBXbGFKnHoNlpHxL8HTJJJbRa/aDy4zLZ7YbjywFy0ts5CHaEKL5cjEbshOSBb0b4u+C9ckurS5na1vrLctxE8ckE0RGCqmGZUnyVIPEZXOQGOK+ZrcORcnOnLTt+Vj0sPj1CElKN5O2uuny2d/Mpm9e80xp9T0530q68yN2lEkUgQEp+8hlSNgHIxzwRznaRn5H+LH7Feoa9m78A31oYopVnhtdQTb5X8RjSREfABwFJA4wCRjNfdt3rHg0W6peatEiypxG0ihmz2EZ+b8NtP1Ky1uCBZ9Gv7BEXedl7G+woq5A3RyLgABiSQ3Hbg5895PiIyXM7para679tPxPVy/PKmGcpUnvo1bRnyH8MP2TtA0rwskHjrw9pur6vJLJJLIsKSRx7z/q4yVUbQcnCqFBJAHFeh/8ADMXww/6EjTf/AAGjr6Fk8S3NuI4ooLGV1QCXF6EVZV4dVBjyVUjAJAJ9BUf/AAlmof8APnZf+DBf/jVe/DLXZFVOKcVKTfOz/9D92orOERFWUMz8GnXWixSBZ7RhBPEDhiu9Dx0ZMjIB5GCD74JBvom0gtXCeOfEKx28uiWMkZlZD5+WzsyAUjZRj7+RkEj5T/tZHBFLqaNnLa5rPi20tZXt7qBlc7AYUdFxgfNw+7HPRW3YzhlOGHKWs2mWkkV3BG0l2iEPI3/LR225ds5+bKk5H949tuO9uGAjS3umCxbDIioQ2Nw+UZySOg6nIFfHXxm+NekeGtPvtJ05JFEu63l1GGQRm12kiZxuXB2KGAKtuDAkDgE/P55ntHAUuetK13ZLq3bZev3HoZZldXFVOSkvXyXc6r4jfEbQ9DtbqFZ47nXIjHLDbk4xKG3IxJwBtK56nBxuBFfO0P7QfjnSNQVtBsLC5h1KWW5lR4Fto8zMzkoIiJGkDYO5i3mAseThq8dWHVVgvdY8QrHMbcA+dGw/fCIOxTAVuQ27bj51P3uoJ83m+ImkW8ltrVtB5ljYQbpLyOIPDEVHlbQQFjQA/d4IIGcdq/n7F8aZpjK7rUJOMVolFu3XfXV/Jbbdv0vB8PYWlDkklJ92v6sj78/4aVvv7JW5k0q33vwtws+6D7xAYrw2CBnqB33YxnrtF/aS8LXupSWl3am2gUKyusolkZJHVVbyQoYqAcuUL45xuAJH5haj8R9M1e6aHS7sJDbrIzyzIT5cMA8xJSiIMIQ3Jy44UgkspZdDt/El7430vx3cawkWnq3n3TlHVIVaNZIXx8kjEM2GWPcqqDljhge/CcW5zS9+vWtptKK1tfTa93te6b0B8OZfO8OTXyb/AK/rY/bbTdd0nV/MfSbyC9WJtrmGRZNpIyAdpODivPfiT8JvCfxK09LHXdOSeRG/d3Ibyri2Ug58pwjEjPPlt8hJ56DHwj8PfiBrfw+1d9QsblGtr6SVXtUBlQNuzGNheNgN3ynOGUs2ARjH6EfD34i6T8Q9JfUNNja3mtnEU8EhBaN9oPBH3kOSFbAzg8DBFfqXCfG9DMf3cvdqa6dHbs/6+Z8JnXD1TCvmWsO58DeJvgl8QvBmrG1g17UXtx88EsZkdCmcDID4DDoV7e4IJtWnhv4uX22yTXb8byAMW/ln/vsEEfXNfpHf3F7b2U9xp0QuLmJC0cRbaJGHITceF3dMngZzz0rpNFltNXtI7mCYbnRHZOCVDg4Pykgg4OCODg4NfcSva54NOOtmz89LT4IfECaBZbzUNSMz8tvlmLfiQrD9TVn/AIUZ42/5/wDUP+/k3/xFfpB/Z8WB+8P8qP7Pi/vmsGmdXs4n/9H9Kvhn8X9G0qyuLnxN4oima4/eLFJOJnZiSPlUEtng5wMc89K4TUf2kfAtlqlxBeve392xDu8MZ8lmkUSEqZnHAJKqDgqFAwF2lvB9O+DL2paD+0EmuoLaS4uZIUfyIVj+Ygy43NvUMowg555AIrM1v4C/FS7tbHVbYWcytGC8Y8wEhvnClZGiaM8ncN2c56dK8h0WoRtLT038jbnTk7o+oLH43Lr1vDc+F/Dl9fRuZMtcbbeH91syDMpdBlpET5mX5nUepX4w1C/1XRPEmq6N4j8gz6TE14YWljuDHfSEbcSRFlCqp4YMh/cgnoKp2EPxE8KeIn0vWLwpDp8LobOC1SbEk4BR5DHHLJtVW4/ec4UbtoKjkhZeI/DKDxJrhla9mO9ZLiaVZLiJotjNPJIS+4RgYSV2C/dBCqCn8/eI+bYXF1ZUKcpOcLpX5VFX0aTWu8U3du1z9I4WwNalD2jStJLvd/pszO8ea/");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return BitmapFactory.decodeByteArray(decodedByte, 0, decodedByte.length);
    }

    private static char[] map1 = new char[64];
    static
    {
        int i = 0;
        for (char c = 'A'; c <= 'Z'; c++)
            map1[i++] = c;
        for (char c = 'a'; c <= 'z'; c++)
            map1[i++] = c;
        for (char c = '0'; c <= '9'; c++)
            map1[i++] = c;
        map1[i++] = '+';
        map1[i++] = '/';
    }

    // Mapping table from Base64 characters to 6-bit nibbles.
    private static byte[] map2 = new byte[128];
    static
    {
        for (int i = 0; i < map2.length; i++)
            map2[i] = -1;
        for (int i = 0; i < 64; i++)
            map2[map1[i]] = (byte) i;
    }

    /**
     * Decodes a byte array from Base64 format.
     *
     * @param s
     *            a Base64 String to be decoded.
     * @return An array containing the decoded data bytes.
     * @throws IllegalArgumentException
     *             if the input is not valid Base64 encoded data.
     */


    public static byte[] decode(String s)
    {
        return decode(s.toCharArray());
    }

    /**
     * Decodes a byte array from Base64 format. No blanks or line breaks are
     * allowed within the Base64 encoded data.
     *
     * @param in
     *            a character array containing the Base64 encoded data.
     * @return An array containing the decoded data bytes.
     * @throws IllegalArgumentException
     *             if the input is not valid Base64 encoded data.
     */
    public static byte[] decode(char[] in)
    {
        int iLen = in.length;
        if (iLen % 4 != 0)
            throw new IllegalArgumentException(
                    "Length of Base64 encoded input string is not a multiple of 4.");
        while (iLen > 0 && in[iLen - 1] == '=')
            iLen--;
        int oLen = (iLen * 3) / 4;
        byte[] out = new byte[oLen];
        int ip = 0;
        int op = 0;
        while (ip < iLen)
        {
            int i0 = in[ip++];
            int i1 = in[ip++];
            int i2 = ip < iLen ? in[ip++] : 'A';
            int i3 = ip < iLen ? in[ip++] : 'A';
            if (i0 > 127 || i1 > 127 || i2 > 127 || i3 > 127)
                throw new IllegalArgumentException(
                        "Illegal character in Base64 encoded data.");
            int b0 = map2[i0];
            int b1 = map2[i1];
            int b2 = map2[i2];
            int b3 = map2[i3];
            if (b0 < 0 || b1 < 0 || b2 < 0 || b3 < 0)
                throw new IllegalArgumentException(
                        "Illegal character in Base64 encoded data.");
            int o0 = (b0 << 2) | (b1 >>> 4);
            int o1 = ((b1 & 0xf) << 4) | (b2 >>> 2);
            int o2 = ((b2 & 3) << 6) | b3;
            out[op++] = (byte) o0;
            if (op < oLen)
                out[op++] = (byte) o1;
            if (op < oLen)
                out[op++] = (byte) o2;
        }
        return out;
    }
}