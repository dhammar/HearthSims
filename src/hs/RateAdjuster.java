package hs;

/**
 * Created by Dave on 10/29/2014.
 * All stats based on the September (S5)report found at http://hearthstats.net/sept
 * Win rate differences are rounded to the nearest integer.
 *
 */
public class RateAdjuster {
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

    /**
     *
     * @param playerType player's type
     * @param type opfor's type
     * @return Differential between playerType's winrate and type's winrate
     */
    public static int adjustedWinRate(int playerType, int type) {
        if (playerType != 10) {
            if (playerType == type) {
                return 0;
            } else if (playerType == 1) // druid
            {
                if (type == 2) {
                    return -2;
                }
                if (type == 3) {
                    return -1;
                }
                if (type == 4) {
                    return 1;
                }
                if (type == 5) {
                    return -2;
                }
                if (type == 6) {
                    return 9;
                }
                if (type == 7) {
                    return -2;
                }
                if (type == 8) {
                    return -3;
                }
                if (type == 9) {
                    return 2;
                }

            } else if (playerType == 2) // hunter
            {
                if (type == 1) {
                    return 2;
                }
                if (type == 3) {
                    return 9;
                }
                if (type == 4) {
                    return 5;
                }
                if (type == 5) {
                    return 2;
                }
                if (type == 6) {
                    return 3;
                }
                if (type == 7) {
                    return 8;
                }
                if (type == 8) {
                    return 6;
                }
                if (type == 9) {
                    return 0;
                }

            } else if (playerType == 3) // mage
            {
                if (type == 1) {
                    return 1;
                }
                if (type == 2) {
                    return -9;
                }
                if (type == 4) {
                    return 4;
                }
                if (type == 5) {
                    return 1;
                }
                if (type == 6) {
                    return 7;
                }
                if (type == 7) {
                    return -3;
                }
                if (type == 8) {
                    return -6;
                }
                if (type == 9) {
                    return -2;
                }

            } else if (playerType == 4) // paladin
            {
                if (type == 2) {
                    return -5;
                }
                if (type == 3) {
                    return -5;
                }
                if (type == 1) {
                    return -2;
                }
                if (type == 5) {
                    return -3;
                }
                if (type == 6) {
                    return 0;
                }
                if (type == 7) {
                    return -3;
                }
                if (type == 8) {
                    return -3;
                }
                if (type == 9) {
                    return -1;
                }

            } else if (playerType == 5) // priest
            {
                if (type == 2) {
                    return -2;
                }
                if (type == 3) {
                    return -1;
                }
                if (type == 4) {
                    return 3;
                }
                if (type == 1) {
                    return 2;
                }
                if (type == 6) {
                    return -2;
                }
                if (type == 7) {
                    return 4;
                }
                if (type == 8) {
                    return -5;
                }
                if (type == 9) {
                    return 0;
                }

            } else if (playerType == 6) // rogue
            {
                if (type == 2) {
                    return -3;
                }
                if (type == 3) {
                    return -7;
                }
                if (type == 4) {
                    return 0;
                }
                if (type == 5) {
                    return 2;
                }
                if (type == 1) {
                    return -9;
                }
                if (type == 7) {
                    return -2;
                }
                if (type == 8) {
                    return -7;
                }
                if (type == 9) {
                    return -7;
                }

            } else if (playerType == 7) // shaman
            {
                if (type == 2) {
                    return -8;
                }
                if (type == 3) {
                    return 2;
                }
                if (type == 4) {
                    return 3;
                }
                if (type == 5) {
                    return -4;
                }
                if (type == 6) {
                    return 2;
                }
                if (type == 1) {
                    return 2;
                }
                if (type == 8) {
                    return -3;
                }
                if (type == 9) {
                    return 7;
                }

            } else if (playerType == 8) //warlock
            {
                if (type == 2) {
                    return -6;
                }
                if (type == 3) {
                    return 6;
                }
                if (type == 4) {
                    return 3;
                }
                if (type == 5) {
                    return 5;
                }
                if (type == 6) {
                    return 7;
                }
                if (type == 7) {
                    return 3;
                }
                if (type == 1) {
                    return 3;
                }
                if (type == 9) {
                    return 3;
                }

            } else if (playerType == 9) // warrior
            {
                if (type == 2) {
                    return 0;
                }
                if (type == 3) {
                    return 2;
                }
                if (type == 4) {
                    return 1;
                }
                if (type == 5) {
                    return 0;
                }
                if (type == 6) {
                    return 7;
                }
                if (type == 7) {
                    return -7;
                }
                if (type == 8) {
                    return -3;
                }
                if (type == 1) {
                    return -2;
                }

            }
        }
        return 0;
    }
}
