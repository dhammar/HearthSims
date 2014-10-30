package hs;

import java.util.Random;

/**
 * Created by Dave on 10/29/2014.
 */
public class LadderSim {

   /*
    *  1 = Druid
    *  2 = Hunter
    *  3 = Mage
    *  4 = Paladin
    *  5 = Priest
    *  6 = Rogue
    *  7 = Shaman
    *  8 = Warlock
    *  9 = Warrior
    *  10 = default
    */
    private int playerType;
    private Player player;
    private int sims;
    private Random rand;
    private boolean dep;

    /**
     * Constructor making use of specific class type for players - makes use of other AI.
     * Account for winrate at starting rank chosen. (default = 25)
     * @param playerType
     * @param playerWinRate
     * @param depreciating
     */
    public LadderSim(int playerType, int playerWinRate, boolean depreciating)
    {
        dep = depreciating;
        this.playerType = playerType;
        this.player = new Player(playerWinRate, depreciating);
        rand = new Random();
       // this.sims = sims;
    }

    /**
     * Constructor specifying no specific class type - does not make use of other classes
     * @param playerWinRate
     * @param depreciating
     */
    public LadderSim(int playerWinRate, boolean depreciating)
    {
        dep = depreciating;
        this.playerType = 10;
        this.player = new Player(playerWinRate, depreciating);
        rand = new Random();

    }





    public Player simulateWithEnemyTypes(int games)
    {
        // TODO - implement stats for random opponents - need data

        for(int i = 0; i < games; i++)
        {
            int enemy = rand.nextInt(8)+1;
            int game = rand.nextInt(99)+1;
            if(game <= player.getWinRate() + RateAdjuster.adjustedWinRate(playerType, enemy))
                player.wonGame(true);
            else
                player.wonGame(false);
        }
        return player;
    }

    public Player simulate(int games)
    {
        for(int i = 0; i < games; i++)
        {
            int game = rand.nextInt(99)+1;
            if(game <= player.getWinRate())
                player.wonGame(true);
            else
                player.wonGame(false);
        }
        return player;
    }





}
