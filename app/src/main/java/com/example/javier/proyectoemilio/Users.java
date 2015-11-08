package com.example.javier.proyectoemilio;

/**
 * Created by javier on 11/2/2015.
 */

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.firebase.client.AuthData;
import com.firebase.client.*;
public class Users {




  //  var uiController = IDEAMainViewController()

    public void addUser( User userData) {
      /*
        var ref : Firebase
        // Check if cardId exist //
        ref = Firebase(url:"https://dazzling-heat-8787.firebaseio.com/comments");

        ref.queryOrderedByChild("idKey").queryEqualToValue(card.cardId_).observeEventType(FEventType.ChildAdded, withBlock: { snapshot in
            //likeRef.queryOrderedByKey().observeEventType(FEventType.ChildAdded, withBlock: { snapshot in

            //likeRef.queryOrderedByChild("height").observeEventType(.ChildAdded, withBlock: { snapshot in
            //     if let height = snapshot.value["height"] as? Double {
            //         println("\(snapshot.key) was \(height) meters tall")
            //     }
            // })

            print("\(snapshot.childrenCount) was \(snapshot.childrenCount)")

            let idKey = snapshot.value["idKey"] as? String
            print("\(snapshot.key) was \(idKey)")

            var likeData = LikeData()

            /*
            let date = NSDate()
            let calendar = NSCalendar.currentCalendar()
            let components = calendar.components(.CalendarUnitHour | .CalendarUnitMinute, fromDate: date)
            let hour = components.hour
            let minutes = components.minute

            func printTimestamp() {
            let timestamp = NSDateFormatter.localizedStringFromDate(NSDate(), dateStyle: .MediumStyle, timeStyle: .ShortStyle)
            println(timestamp)
            }
            printTimestamp() // Prints "Sep 9, 2014, 4:30 AM"

        LikeData likeData = new LikeData();
        likeData.userId = userData.userId_;
                likeData.userName = userData.name_;
                likeData.userFamilyName = userData.familyName_;
                //likeData.date =  calendar; // Firebase.ServerValue.TIMESTAMP;
                likeData.points = userData.userPoints_;

                card.cardLikes2_?.append(likeData)

        card.setLikesTotal(Double((card.cardLikes2_?.count)!))

        var score = Double(0)

        for like in card.cardLikes2_! {
                score += like.points
        }

        card.setCardScore(Double(score))
        ref = Firebase(url:"https://dazzling-heat-8787.firebaseio.com/comments/"+card.cardId_!);

        ref.updateChildValues([
                "cardLikes": card.cardLikesTotal_!,
                "cardScore": card.cardScore_!
        ])
    })*/
    }


    // Remove a like from a card

    public void removeUser( User userData ) {
        /*
        var ref : Firebase

        // Find the Index in the Likes Array

        for ( var i = 0; i < card.cardLikes2_?.count; i++){
            if (card.cardLikes2_?[i].userId == userData.userId_){
                card.cardLikes2_?.removeAtIndex(i)
            }
        }

        card.setLikesTotal(Double((card.cardLikes2_?.count)!))

        var score = Double(0)

        for like in card.cardLikes2_! {
            score += like.points
        }

        card.setCardScore(Double(score))

        ref = Firebase(url:"https://dazzling-heat-8787.firebaseio.com/comments/"+card.cardId_!);

        // if card still exist update the card

        ref.updateChildValues([
            "cardLikes": card.cardLikesTotal_!,
            "cardScore": card.cardScore_!
            ])
        */
    }

    //  func application(application: UIApplication!, performFetchWithCompletionHandler completionHandler: ((UIBackgroundFetchResult) -> Void)!) {
    //      loadShows(completionHandler)
    //  }

    //  func loadShows(completionHandler: ((UIBackgroundFetchResult) -> Void)!) {
    //....
    //DO IT
    //....

    //     completionHandler(UIBackgroundFetchResult.NewData)
    //     println("Background Fetch Complete")
    // }


    // Return if the user like this card
    /*
    func findUser(userMail: String, UIcontroller: IDEAMainViewController) -> User {

        var ref : Firebase
        var userData = User()

        uiController = UIcontroller // for callback

        ref = Firebase(url: "https://dazzling-heat-8787.firebaseio.com/users")

        ref.queryOrderedByChild("mail").queryEqualToValue(userMail).observeSingleEventOfType(FEventType.ChildAdded, withBlock: { snapshot in

        print("USER FOUND: \(snapshot.childrenCount) was \(snapshot.childrenCount)")

        let userId = snapshot.value["userId"] as? String
        let familyName = snapshot.value["familyName"] as? String
        let name = snapshot.value["name"] as? String
        let groupName = snapshot.value["groupName"] as? String
        let position = snapshot.value["position"] as? String
        let department = snapshot.value["department"] as? String
        let mail = snapshot.value["mail"] as? String
        let likeValue = snapshot.value["likeValue"] as? Int
        let admin = snapshot.value["admin"] as? Bool
        let karma = snapshot.value["karma"] as? Int
        let userIdeas = snapshot.value["userIdeas"] as? Int
        //let userComments = 0 // snapshot.value["userComments"] as? Double
        let userLikes = snapshot.value["userLikes"] as? Int
        let userPoints = snapshot.value["userPoints"] as? Int
        let dateMembership = "" // snapshot.value["dateMembership"] as? String

        userData = User(
        userId : userId,
        name : name,
        familyName : familyName,
        groupName : groupName,
        department : department,
        position : position,
        email : mail,
        likeValue : likeValue,
        karma : karma,
        admin : admin,
        userIdeas : userIdeas,
        userComments : 0,
        userLikes : userLikes,
        userPoints : userPoints,
        dateMembership : dateMembership,
        avatar : "" )

        var mref : Firebase

        mref = Firebase(url: "https://dazzling-heat-8787.firebaseio.com/pictures/");

        mref.queryOrderedByChild("userId").queryEqualToValue(userData.userId_).observeEventType(FEventType.Value, withBlock: { snapshot in

        print("USER PICTURE FOUND: \(snapshot.value)")

        for child in snapshot.children{
        let childSnapshot = snapshot.childSnapshotForPath(child.key)
        let avatar = childSnapshot.value["facePicture"] as? String
        userData.avatar_ = avatar
        }

        //let avatar = snapshot.value["facePicture"] as? String
        print(userData.avatar_)

        self.uiController.userDataReady(userData);
        })
        })

        //

        ref = Firebase(url: "https://dazzling-heat-8787.firebaseio.com/users")

        ref.queryOrderedByChild("mail").queryEqualToValue(userMail).observeEventType(FEventType.ChildChanged, withBlock: { snapshot in

        print("USER FOUND: \(snapshot.childrenCount) was \(snapshot.childrenCount)")

        let userId = snapshot.value["userId"] as? String
        let familyName = snapshot.value["familyName"] as? String
        let name = snapshot.value["name"] as? String
        let groupName = snapshot.value["groupName"] as? String
        let position = snapshot.value["position"] as? String
        let department = snapshot.value["department"] as? String
        let mail = snapshot.value["mail"] as? String
        let likeValue = snapshot.value["likeValue"] as? Int
        let admin = snapshot.value["admin"] as? Bool
        let karma = snapshot.value["karma"] as? Int
        let userIdeas = snapshot.value["userIdeas"] as? Int
        //let userComments = 0 // snapshot.value["userComments"] as? Double
        let userLikes = snapshot.value["userLikes"] as? Int
        let userPoints = snapshot.value["userPoints"] as? Int
        let dateMembership = "" // snapshot.value["dateMembership"] as? String

        userData = User(
        userId : userId,
        name : name,
        familyName : familyName,
        groupName : groupName,
        department : department,
        position : position,
        email : mail,
        likeValue : likeValue,
        karma : karma,
        admin : admin,
        userIdeas : userIdeas,
        userComments : 0,
        userLikes : userLikes,
        userPoints : userPoints,
        dateMembership : dateMembership,
        avatar : "" )

        var mref : Firebase

        mref = Firebase(url: "https://dazzling-heat-8787.firebaseio.com/pictures/");

        mref.queryOrderedByChild("userId").queryEqualToValue(userData.userId_).observeEventType(FEventType.Value, withBlock: { snapshot in

        print("USER PICTURE FOUND: \(snapshot.value)")

        for child in snapshot.children{
        let childSnapshot = snapshot.childSnapshotForPath(child.key)
        let avatar = childSnapshot.value["facePicture"] as? String
        userData.avatar_ = avatar
        }

        //let avatar = snapshot.value["facePicture"] as? String
        print(userData.avatar_)

        self.uiController.userDataReady(userData);
        })
        })


        return userData;
        }
    */
    /*
        // Return the list of users that like this card

        func findUsers(userData: User) -> Array<LikeData>{

        var ref : Firebase
        var likesData: Array<LikeData>
var recordsFound = 0

        likesData = []

        ref = Firebase(url:"https://dazzling-heat-8787.firebaseio.com/users/"+userData.userId_!);

        ref.queryOrderedByKey().observeEventType(FEventType.ChildAdded, withBlock: { snapshot in

        print("\(snapshot.childrenCount) was \(snapshot.childrenCount)")

        let userId = snapshot.value["userId"] as? String
        let userName = snapshot.value["userName"] as? String
        let familyName = snapshot.value["familyName"] as? String
        let userPoints = snapshot.value["userPoints"] as? Int


        print("\(snapshot.key) was \(userId)")

        var likeData = LikeData()

        likeData.userId = userId!
        likeData.userName = userName!
        likeData.userFamilyName = familyName!
        likeData.date =  "Today"; // Firebase.ServerValue.TIMESTAMP;
        likeData.points = userPoints!

        likesData.append(likeData)
        recordsFound++
        })

        print("Likes Found: was \(recordsFound)")

        return likesData;
        }

        */

        public void authenticateUser( String userName , String password ) {

            Firebase ref;

            ref = new Firebase("https://dazzling-heat-8787.firebaseio.com/users");

       /* ref. .authUser(userName, password: password,
        withCompletionBlock: { error, authData in

        if error != nil {
        // Error
        } else {
        // We are logged in
        }
        })*/


// Create a handler to handle the result of the authentication
            Firebase.AuthResultHandler authResultHandler = new Firebase.AuthResultHandler() {
                @Override
                public void onAuthenticated(AuthData authData) {
                    // Authenticated successfully with payload authData
                }

                @Override
                public void onAuthenticationError(FirebaseError firebaseError) {
                    // Authenticated failed with error firebaseError
                }
            };

// Or with an email/password combination
            ref.authWithPassword("jenny@example.com", "correcthorsebatterystaple", authResultHandler);

        }

        /*func unAuthenticate(){

        }

        func sendPassword(){

        }

        func changePicture(){

        }

        func changePassword(){

        }*/


       public User  userDataReady(User userData ) {

        return userData;

        /*
        func setupAvatarImage(name: String, imageUrl: String?, incoming: Bool) {
            if let stringUrl = imageUrl {
                if let url = NSURL(string: stringUrl) {
                    if let data = NSData(contentsOfURL: url) {
                        let image = UIImage(data: data)
                        let diameter = incoming ? UInt(collectionView.collectionViewLayout.incomingAvatarViewSize.width) : UInt(collectionView.collectionViewLayout.outgoingAvatarViewSize.width)
                        let avatarImage = JSQMessagesAvatarFactory.avatarWithImage(image, diameter: diameter)
                        avatars[name] = avatarImage
                        return
                    }
                }
            }
        */
        }

        }

/*
getLikes: function(card, scope){

var ref = new Firebase('https://dazzling-heat-8787.firebaseio.com/cards/'+card.idKey);

var likesArray = $firebaseArray(ref.child("liked"));

likesArray.$loaded().then(function () {

scope.$emit("LikeDataArrived", likesArray);

});

return likesArray;
},
*/
