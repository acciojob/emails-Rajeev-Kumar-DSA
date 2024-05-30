package com.driver;

import org.apache.commons.lang3.tuple.Pair;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Workspace extends Gmail{

    private ArrayList<Meeting> calendar; // Stores all the meetings

    public Workspace(String emailId) {
        // The inboxCapacity is equal to the maximum value an integer can store.
        super(emailId, Integer.MAX_VALUE);
        this.calendar = new ArrayList<>();
    }

    public void addMeeting(Meeting meeting){
        //add the meeting to calendar
        // simply add the meeting details in list
        calendar.add(meeting);
    }

    public int findMaxMeetings(){
        // find the maximum number of meetings you can attend
        // 1. At a particular time, you can be present in at most one meeting
        // 2. If you want to attend a meeting, you must join it at its start time and leave at end time.
        // Example: If a meeting ends at 10:00 am, you cannot attend another meeting starting at 10:00 am
        int attendMeetingCount = 0;

        // here we can attend any one in schedule time
        // its releated to job scheduling problem
        // first I have to sort the start time or endtime. then I will check how much meeting without overlapping

        ArrayList<Pair<LocalTime, Integer>> endTimes = new ArrayList<>();
        for (int i=0; i<calendar.size(); i++){
            endTimes.add(Pair.of(calendar.get(i).getEndTime(), i));
        }

        Collections.sort(endTimes);

        LocalTime limitOfTime = endTimes.get(0).getLeft();

        if(!endTimes.isEmpty()){
            attendMeetingCount ++;
        }

        for (int i=1; i<endTimes.size(); i++){
            if(calendar.get(endTimes.get(i).getRight()).getStartTime().compareTo(limitOfTime) >= 0){
                attendMeetingCount ++;
                limitOfTime = endTimes.get(i).getLeft();
            }
        }


        return attendMeetingCount;
    }
}
