package com.example.quizv8.model;

public class RankLeaderBoard {
    private long Rank;
    private LeaderBoard leaderBoard;

    public RankLeaderBoard() {
    }

    public RankLeaderBoard(long rank, LeaderBoard leaderBoard) {
        Rank = rank;
        this.leaderBoard = leaderBoard;
    }

    public long getRank() {
        return Rank;
    }

    public void setRank(long rank) {
        Rank = rank;
    }

    public LeaderBoard getLeaderBoard() {
        return leaderBoard;
    }

    public void setLeaderBoard(LeaderBoard leaderBoard) {
        this.leaderBoard = leaderBoard;
    }
}
