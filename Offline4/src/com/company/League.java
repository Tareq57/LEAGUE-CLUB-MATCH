package com.company;


import java.sql.Array;
import java.util.Arrays;

public class League {
    private Match[] matches;
    private int matchCount;
    private int clubCount;
    // add your variables here, if required
    private String name;
    private Club[] club;

    public Match[] getMatches() {
        return matches;
    }

    public void setMatches(Match[] matches) {
        this.matches = matches;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public void setMatchCount(int matchCount) {
        this.matchCount = matchCount;
    }

    public int getClubCount() {
        return clubCount;
    }

    public void setClubCount(int clubCount) {
        this.clubCount = clubCount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Club[] getClub() {
        return club;
    }

    public void setClub(Club[] club) {
        this.club = club;
    }

    public League() {
        // assume a league can have at most 5 clubs, add code for initialization accordingly
        //complete
        clubCount = 0;
        matchCount = 0;
        club=new Club[5];
    }

    public void printLeagueInfo(){
        System.out.println("League : " + name);
        printClubs();
    }

    public void printClubs(){
        System.out.println("Clubs:");
        // print the name of the clubs of this league, each one on a line
        //complete
        for(int i=0;i<clubCount;i++)
        {
            System.out.println(club[i].getName());
        }
    }

    public void scheduleMatches(){
        matchCount = (clubCount*(clubCount-1));
        matches = new Match[matchCount+10];
        int  cnt=0;
        for (int i=0; i<clubCount; i++){
            for (int j=0; j<clubCount; j++){
                // check the constructor of the Match class and add your code here
                // note that there will be two matches between club A and club B
                // in the first match, club A will play as the home team and in the second match, as the away team
                //complete
                if(i==j)
                    continue;
               matches[cnt++]= new Match(matchCount,club[i],club[j]);

            }
        }
    }

    public void simulateMatches(){
        for (int i=0; i<matchCount; i++){
            matches[i].play();
        }
    }

    public void showStandings(){
        // sort the clubs in descending order of points
        // note that, the sequence in which clubs were added to the league, should be unchanged
        // check the given sample output for clarification
        // (carefully observe the output of showStandings() followed by printLeagueInfo() method calls
        // you can use additional arrays if needed
        Club[] temporary=new Club[clubCount];
        for(int i=0;i<clubCount;i++)
            temporary[i]=club[i];
        Club temp;
        for(int i=0; i < clubCount; i++){
            for(int j=1; j < (clubCount-i); j++){
                if(temporary[j-1].getPoint() < temporary[j].getPoint()){
                    //swap elements
                    temp = temporary[j-1];
                    temporary[j-1] = temporary[j];
                    temporary[j] = temp;
                }

            }
        }
        System.out.println("Sl. - Club - Points");
        // print the clubs in descending order of points
        for(int i=0;i<clubCount;i++)
        {
            System.out.println(Integer.toString(i+1)+". "+temporary[i].getName()+" "+temporary[i].getPoint());
        }
    }
    // add your methods here, if required
    public void addClub(Club club) {
        this.club[clubCount++]=club;
    }

    public void printMatches() {
        System.out.println("Matches:");
        for(int i=0;i<matchCount;i++)
        {
            matches[i].showResult();
        }
    }

    public void removeClub(Club club) {
        int check=0;
        for(int i=0;i<clubCount;i++)
        {
            if(club.getId()==this.club[i].getId())
            {
                check++;
            }
            this.club[i-check]=this.club[i];
        }
        clubCount--;
    }
}

