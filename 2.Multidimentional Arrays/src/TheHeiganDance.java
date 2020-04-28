import java.util.Scanner;

public class TheHeiganDance {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int playerPoints = 18500;
        double heiganPoints = 3000000;
        double damage = Double.parseDouble(scanner.nextLine());
        int[] player = {7, 7};
        String[][] matrix = new String[15][15];
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                if (i == 7 && j == 7) {
                    matrix[i][j] = "player";
                } else {
                    matrix[i][j] = "available";
                }
            }
        }
        boolean secondRound = false;
        boolean heiganIsDead = false;
        boolean playerIsDead = false;
        String killSpell = "";
        while (!heiganIsDead&&!playerIsDead) {
            heiganPoints -= damage;
            if (secondRound) {
                playerPoints -= 3500;
                secondRound = false;
                if (playerPoints<=0){
                    playerIsDead = true;
                    killSpell = "Plague Cloud";
                    break;
                }
            }
            if (heiganPoints <= 0) {
                heiganIsDead=true;
                continue;
            }
            String[] input = scanner.nextLine().split(" ");
            String spell = input[0];
            int row = Integer.parseInt(input[1]);
            int col = Integer.parseInt(input[2]);
            int playerRow = player[0];
            int playerCol = player[1];
            for (int i = row - 1; i <= row + 1; i++) {
                if (i < 0 || i >= 15) {
                    continue;
                }
                for (int j = col - 1; j <= col + 1; j++) {
                    if (j < 0 || j >= 15) {
                        continue;
                    }
                    matrix[i][j] = "damaged";
                }
            }
            if (matrix[playerRow][playerCol].equals("damaged")) {
                if (playerRow - 1 >= 0 && !matrix[playerRow - 1][playerCol].equals("damaged")) {
                    player[0] = playerRow - 1;
                } else if (playerCol + 1 < 15 && !matrix[playerRow][playerCol + 1].equals("damaged")) {
                    player[1] = playerCol + 1;
                } else if (playerRow + 1 < 15 && !matrix[playerRow + 1][playerCol].equals("damaged")) {
                    player[0] = playerRow + 1;
                } else if (playerCol - 1 >= 0 && !matrix[playerRow][playerCol - 1].equals("damaged")) {
                    player[1] = playerCol - 1;
                } else {
                    if (spell.equals("Cloud")) {
                        playerPoints -= 3500;
                        secondRound = true;
                        if (playerPoints<=0){
                            killSpell = "Plague Cloud";
                            playerIsDead = true;
                            continue;
                        }
                    } else {
                        playerPoints -= 6000;
                        if (playerPoints<=0){
                            killSpell = "Eruption";
                            playerIsDead = true;
                            continue;
                        }
                    }

                }
            }
            for (int i = row - 1; i <= row + 1; i++) {
                if (i < 0 || i >= 15) {
                    continue;
                }
                for (int j = col - 1; j <= col + 1; j++) {
                    if (j < 0 || j >= 15) {
                        continue;
                    }
                    if (matrix[i][j].equals("damaged")){
                        matrix[i][j] = "available";
                    }
                }
            }
        }
        if (heiganPoints<=0){
            heiganIsDead = true;
        }
        if (heiganIsDead){
            if (playerIsDead){
                System.out.printf("Heigan: Defeated!%nPlayer: Killed by %s%nFinal position: %d, %d",killSpell,player[0],player[1]);
            }else {
                System.out.printf("Heigan: Defeated!%nPlayer: %d%nFinal position: %d, %d",playerPoints,player[0],player[1]);
            }
        }else {
            System.out.printf("Heigan: %.2f%nPlayer: Killed by %s%nFinal position: %d, %d",heiganPoints,killSpell,player[0],player[1]);
        }
    }
}
