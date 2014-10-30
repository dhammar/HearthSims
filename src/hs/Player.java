package hs;

/**
 * Created by Dave on 10/29/2014.
 */
public class Player {

    private int winsToLegend = 0;
    private int gamesToLegend = 0;
    private int rank;
    private int stars;
    private int streak;
    private int winPct;
    private int starSlots;
    private int wins = 0;
    private int losses = 0;
    private int gold = 0;
    private boolean dep;
    private int highestRank = 25;

    public Player(int winPct, int startRank, boolean depreciate)
    {
        this.winPct = winPct;
        rank = startRank;
        starSlots = this.getStarSlots(rank);
        stars = 0;
        streak = 0;
        dep = depreciate;
    }

    public Player(int winPct, boolean depreciate)
    {
        this.winPct = winPct;
        rank = 25;
        dep = depreciate;
    }

    public Player()
    {
        dep = false;
        rank = 25;
        stars = 0;
        winPct = 50;
    }

    public void wonGame(boolean won)
    {
        if(won)
        {
            wins++;
            if(rank != 0)
                addStars();
            streak++;
            if(wins % 3 == 0)
                gold += 10;
        }
        else
        {
            losses++;
            if(rank != 0)
                removeStars();
            streak = 0;
        }

    }

    public boolean onStreak()
    {
        if(streak >= 2 && rank > 5 )
            return true;
        return false;
    }


    private void addStars()
    {
        starSlots = this.getStarSlots(rank);
        if(onStreak())
        {
            stars += 2;
            if(stars == starSlots+1)
            {
                rank--;
                if(rank < highestRank)
                    highestRank = rank;
                stars = 1;
            }
            else if(stars == starSlots +2)
            {
                rank--;
                if(rank < highestRank)
                    highestRank = rank;
                stars = 2;
            }
        }
        else
        {
            stars ++;
            if(stars == starSlots)
            {
                rank--;
                if(rank == 0 && gamesToLegend == 0) {
                    gamesToLegend = wins + losses;
                    winsToLegend = wins;
                }
                if(rank < 0)
                    rank = 0;
                if(rank < highestRank)
                    highestRank = rank;
                stars = 1;
            }
        }
    }

    private void removeStars()
    {
        stars--;
        if(stars < 0)
        {
            if(rank < 20) {
                rank++;
                stars = 2;
            }
            else
                stars = 0;
        }

    }

    public int getStarSlots(int rank)
    {
        if(rank > 20)
            return 2;
        else if(rank > 15 && rank < 21)
            return 3;
        else if(rank > 10 && rank < 16)
            return 4;
        else if(rank == 0)
            return 0;
        return 5;
    }

    public int getGold()
    {
        return gold;
    }

    public int getWinRate()
    {
        if(dep)
            return winPct + depreciateWinRate();
        return winPct;
    }

    public int getRank()
    {
        return rank;
    }

    public int getHighestRank()
    {
        return highestRank;
    }


    public int depreciateWinRate()
    {
        if (rank < 21 && rank >= 17)
            return -1;
        else if (rank < 17 && rank > 14)
            return -5;
        else if (rank <= 14 && rank > 10)
            return -8;
        else if (rank < 5)
            return -12;
        return 0;
    }

    public int getGamesToLegend()
    {
        return gamesToLegend;
    }

    public int getWinsToLegend()
    {
        return winsToLegend;
    }

    public int getGamesPlayed()
    {
        return wins+losses;
    }


}
