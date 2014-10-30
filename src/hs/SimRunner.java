package hs;

import java.util.ArrayList;

/**
 * Created by Dave on 10/29/2014.
 */
public class SimRunner
{
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
    public static final int DRUID = 1;
    public static final int HUNTER = 2;
    public static final int MAGE = 3;
    public static final int PALADIN = 4;
    public static final int PRIEST = 5;
    public static final int ROGUE = 6;
    public static final int SHAMAN = 7;
    public static final int WARLOCK = 8;
    public static final int WARRIOR = 9;
    public static final int DEF = 10;


    public static void main(String args[])
    {
        ArrayList<Player> playerList = new ArrayList<Player>();
        LadderSim sim = new LadderSim(WARLOCK,65,true);
        playerList.add(sim.simulateWithEnemyTypes(1000));
        System.out.println("done");

    }
}
