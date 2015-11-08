package com.example.javier.proyectoemilio;

/**
 * Created by javier on 10/24/2015.
 */

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.Query;
import com.firebase.client.ValueEventListener;

import java.util.List;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.CardViewHolder> {

    private  List<Card> cards;
    private Context mContext;

    public static class CardViewHolder extends RecyclerView.ViewHolder {

        CardView cv;

        List<Card> cards;
        static TextView cardId_;
        static TextView userId_;
        static TextView familyName_;
        static TextView name_;
        static TextView groupName_;
        static TextView department_ ;
        static TextView position_;
        static TextView datePosted_;
        static TextView text_;
        static TextView cardScore_;
        static TextView dateUpdated_;
        static TextView cardLikes_;
        static TextView cardCommentsTotal;
        static ImageView avatar_;
        //cardLikesArray_

        //cardComments2_

        CardViewHolder(View itemView) {
            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.cv);
            //cardId_ = (TextView)itemView.findViewById(R.id.idea_date);
            //userId_ = (TextView)itemView.findViewById(R.id.idea_date);
           // familyName_ = (TextView)itemView.findViewById(R.id.idea_date);
            name_ = (TextView)itemView.findViewById(R.id.cardUser);
            //groupName_ = (TextView)itemView.findViewById(R.id.idea_date);
            department_= (TextView)itemView.findViewById(R.id.cardUserDepartment);
            //position_ = (TextView)itemView.findViewById(R.id.idea_date);
            //datePosted_= (TextView)itemView.findViewById(R.id.idea_date);
            //dateUpdated_= (TextView)itemView.findViewById(R.id.idea_date);
            text_ = (TextView)itemView.findViewById(R.id.cardText);
            //cardScore_= (TextView)itemView.findViewById(R.id.idea_date);
            cardLikes_ = (TextView)itemView.findViewById(R.id.cardLikes);
            //cardCommentsTotal= (TextView)itemView.findViewById(R.id.cardLikes);
            avatar_ = (ImageView) itemView.findViewById(R.id.cardAvatar);



        }
    }



    RVAdapter(List<Card> cards){
        this.cards = cards;
        System.out.print(cards);
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public CardViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item, viewGroup, false);
        CardViewHolder pvh = new CardViewHolder(v);
       // getCards();

        return pvh;
    }

    @Override
    public void onBindViewHolder(CardViewHolder cardViewHolder, int i) {
        /*
         TextView idea_date;
        TextView idea_status;
        ImageView idea_owner_photo;
        TextView idea_owner;
        ImageView thumbs_up;
        /*
         */
        CardViewHolder.text_.setText(cards.get(i).text_);
        CardViewHolder.name_.setText(cards.get(i).name_);
        CardViewHolder.department_.setText(cards.get(i).department_);
       // CardViewHolder.cardLikes_.setText(cards.get(i).cardLikes_);
        //CardViewHolder.idea_content.setText(cards.get(i).text_);
        //CardViewHolder.avatar_.setImageResource(R.drawable.download);

    }

    @Override
    public int getItemCount() {
        /*String a = String.valueOf(idea.size());
        Log.e("-------------"," idea = "+ a);
        */
        return cards.size();
    }

    public void getCards ()
    {
        // *** STEP 1: Find Current User
        Card  users = new Card();
        Users users1 = new Users();
        String  userName = "emilio.mobile@gmail.com";
        String password = "00";

        users1.authenticateUser(userName, password);



        Firebase ref ;

        int recordsFound = 0;


        ref =new  Firebase("https://dazzling-heat-8787.firebaseio.com/cards");


        Query queryRef = ref.orderByValue();
        ChildEventListener childEventListener = queryRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot snapshot, String previousChildKey) {
                System.out.println("The " + snapshot.getKey() + " dinosaur's score is " + snapshot.getValue());
                //System.out.println(" spapppppppppppppppppppppp" + snapshot.getValue("userId");


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


}