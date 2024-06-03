package com.driver;

import java.util.ArrayList;
import java.util.Date;

public class Gmail extends Email {

    int inboxCapacity; //maximum number of mails inbox can store
    //Inbox: Stores mails. Each mail has date (Date), sender (String), message (String). It is guaranteed that message is distinct for all mails.
    private ArrayList<MessageRecord> Inbox;
    //Trash: Stores mails. Each mail has date (Date), sender (String), message (String)
    private ArrayList<MessageRecord> Trash;
    public Gmail(String emailId, int inboxCapacity) {
        super(emailId);
        // initialize the list with new keyword
        this.inboxCapacity = inboxCapacity;
        this.Inbox = new ArrayList<>();
        this.Trash = new ArrayList<>();
    }

    public void receiveMail(Date date, String sender, String message){
        // If the inbox is full, move the oldest mail in the inbox to trash and add the new mail to inbox.
        // It is guaranteed that:
        // 1. Each mail in the inbox is distinct.
        // 2. The mails are received in non-decreasing order. This means that the date of a new mail is greater than equal to the dates of mails received already.

        // when my Inbox will be full
        if(Inbox.size() >= inboxCapacity){
            // here I have to oldest mail in trast list
            // oldest means remove from 0th index mail, before removing the list I have to keep the mail data
            MessageRecord oldMessage = Inbox.get(0);
            Inbox.remove(0);
            Trash.add(oldMessage);
        }

        // receive new mail in Inbox
        Inbox.add(new MessageRecord(date, sender, message));

    }

    public void deleteMail(String message){
        // Each message is distinct
        // If the given message is found in any mail in the inbox, move the mail to trash, else do nothing

        // here I want to delete the message in inbox list, move in trash list
        // first I have to check the given message is present in list or not
        int foundIndex = Integer.MIN_VALUE;
        for(int i=0; i<Inbox.size(); i++){
            if(message.equals(Inbox.get(i).getMessage())){
                // update the index
                foundIndex = i;
                break;
            }
        }

        // after getting the index. that particular index message remove from Inbox
        if(foundIndex != Integer.MIN_VALUE){
            MessageRecord messageRecord = Inbox.get(foundIndex);
            // remove from Inbox
            Inbox.remove(foundIndex);
            // add in Trash list
            Trash.add(messageRecord);
        }else {
            return;
        }
    }

    public String findLatestMessage(){
        // If the inbox is empty, return null
        // Else, return the message of the latest mail present in the inbox

        // simply check Inbox is empty or not.
        if (Inbox.isEmpty()){
            return null;
        }else {
            // I have to return the latest mail(means lastIndex mail)
            return Inbox.get(Inbox.size()-1).getMessage();   /// return only message thing
        }
    }

    public String findOldestMessage(){
        // If the inbox is empty, return null
        // Else, return the message of the oldest mail present in the inbox


        // check Inbox is empty or not
        if (Inbox.isEmpty()){
            return null;
        }else {
            // have to return 0th index message. because its a oldest mail
            return Inbox.get(0).getMessage();
        }
    }

    public int findMailsBetweenDates(Date start, Date end){
        //find number of mails in the inbox which are received between given dates
        //It is guaranteed that start date <= end date

        // use loop travel from 0 to lastIndex, then I will check data is in given range or not
        int countMail = 0;
        for(MessageRecord currentMessageRecord : Inbox){
            // now I will check for currentMessage, date is given range or not
            if ((currentMessageRecord.getDate().compareTo(start) >= 0)  &&
                    (currentMessageRecord.getDate().compareTo(end)>=0)){
                countMail ++;
            }
        }
        return countMail;

    }

    public int getInboxSize(){
        // Return number of mails in inbox
        return Inbox.size();
    }

    public int getTrashSize(){
        // Return number of mails in Trash
        return Trash.size();
    }

    public void emptyTrash(){
        // clear all mails in the trash
        Trash.clear();
    }

    public int getInboxCapacity() {
        // Return the maximum number of mails that can be stored in the inbox

        // whatever is given capacity that will be my maximumNumber of capacity
        return inboxCapacity;
    }
}
