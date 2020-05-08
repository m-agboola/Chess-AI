import javax.swing.*;
public class AlphaBetaChess {
    static String chessBoard[][]={
            {"r","k","b","q","a","b","k","r"},
            {"p","p","p","p","p","p","p","p"},
            {" "," "," "," "," "," "," "," "},
            {" "," "," "," "," "," "," "," "},
            {" "," "," "," "," "," "," "," "},
            {" ","R"," "," "," "," "," "," "},
            {"P","P","P","P","P","P","P","P"},
            {"R","K","B","Q","A","B","K","R"}};

    static int kingPositionC, getKingPositionL;

    public static void main(String[] args) {
//       JFrame f = new JFrame("My Title Goes Here!");
//        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        UserInterface ui = new UserInterface();
//        f.add(ui);
//        f.setSize(500, 500);
//        f.setVisible(true);
        System.out.print(possibleMoves());

    }

    public static String possibleMoves() {
        String list = "";
        for (int i = 0; i < 64; i++) {
            switch (chessBoard[i/8][i%8]) {
                case "P": list += possibleP(i);
                    break;
                case "R": list += possibleR(i);
                    break;
                case "K": list += possibleK(i);
                    break;
                case "B": list += possibleB(i);
                    break;
                case "Q": list += possibleQ(i);
                    break;
                case "A": list += possibleA(i);
                    break;
            }

        }
        return list;
    }

    public static String possibleP(int i) {
        String list = "";
        return list;
    }
    public static String possibleR(int i) {
        String list = "", oldPiece;
        int r = i/8, c = i % 8;
        int temp = 1;
        for (int j=-1; j<=1; j += 2) {
            try {
                while (" ".equals(chessBoard[r][c + temp * j])) {
                    oldPiece = chessBoard[r][c + temp * j];
                    chessBoard[r][c] = " ";
                    chessBoard[r][c + temp * j] = "R";
                    if (kingSafe()) {
                        list = list + r + c + r + (c + temp * j) + oldPiece;
                    }
                    chessBoard[r][c] = "R";
                    chessBoard[r][c + temp * j] = oldPiece;
                    temp++;
                }
                if (Character.isLowerCase(chessBoard[r][c + temp * j].charAt(0))) {
                    oldPiece = chessBoard[r][c + temp * j];
                    chessBoard[r][c] = " ";
                    chessBoard[r][c + temp * j] = "R";
                    if (kingSafe()) {
                        list = list + r + c + r + (c + temp * j) + oldPiece;
                    }
                    chessBoard[r][c] = "R";
                    chessBoard[r][c + temp * j] = oldPiece;
                }
            } catch (Exception e) {
            }
            temp = 1;
            try {
                while (" ".equals(chessBoard[r + temp * j][c])) {
                    oldPiece = chessBoard[r+ temp * j][c];
                    chessBoard[r][c] = " ";
                    chessBoard[r+ temp * j][c] = "R";
                    if (kingSafe()) {
                        list = list + r + c + (r + temp * j) + c + oldPiece;
                    }
                    chessBoard[r][c] = "R";
                    chessBoard[r+ temp * j][c] = oldPiece;
                    temp++;
                }
                if (Character.isLowerCase(chessBoard[r+ temp * j][c].charAt(0))) {
                    oldPiece = chessBoard[r+ temp * j][c];
                    chessBoard[r][c] = " ";
                    chessBoard[r+ temp * j][c] = "R";
                    if (kingSafe()) {
                        list = list + r + c + (r + temp * j) + c + oldPiece;
                    }
                    chessBoard[r][c] = "R";
                    chessBoard[r+ temp * j][c] = oldPiece;
                }
            } catch (Exception e) {
            }
            temp = 1;
        }

        return list;
    }
    public static String possibleK(int i) {
        String list = "";
        return list;
    }
    public static String possibleB(int i) {
        String list = "", oldPiece;
        int r = i/8, c = i % 8;
        int temp = 1;
        for (int j=-1; j <=1; j+=2) {
            for (int k=-1; k <=1; k+=2) {
                try {
                    while (" ".equals(chessBoard[r + temp * j][c + temp * k])) {
                        oldPiece = chessBoard[r + temp * j][c + temp * k];
                        chessBoard[r][c] = " ";
                        chessBoard[r + temp * j][c + temp * k] = "B";
                        if (kingSafe()) {
                            list = list + r + c + (r + temp * j) + (c + temp * k) + oldPiece;
                        }
                        chessBoard[r][c] = "B";
                        chessBoard[r + temp * j][c + temp * k] = oldPiece;
                        temp++;
                    }
                    if (Character.isLowerCase(chessBoard[r + temp * j][c + temp * k].charAt(0))) {
                        oldPiece = chessBoard[r + temp * j][c + temp * k];
                        chessBoard[r][c] = " ";
                        chessBoard[r + temp * j][c + temp * k] = "B";
                        if (kingSafe()) {
                            list = list + r + c + (r + temp * j) + (c + temp * k) + oldPiece;
                        }
                        chessBoard[r][c] = "B";
                        chessBoard[r + temp * j][c + temp * k] = oldPiece;
                    }
                } catch (Exception e) {
                }
                temp = 1;
            }

        }

        return list;
        }
    public static String possibleQ(int i) {
        String list = "", oldPiece;
        int r = i/8, c = i % 8;
        int temp = 1;
        for (int j=-1; j <=1; j++) {
            for (int k=-1; k <=1; k++) {
                if (j != 0 || k != 0) {
                    try {
                        while (" ".equals(chessBoard[r + temp * j][c + temp * k])) {
                            oldPiece = chessBoard[r + temp * j][c + temp * k];
                            chessBoard[r][c] = " ";
                            chessBoard[r + temp * j][c + temp * k] = "Q";
                            if (kingSafe()) {
                                list = list + r + c + (r + temp * j) + (c + temp * k) + oldPiece;
                            }
                            chessBoard[r][c] = "Q";
                            chessBoard[r + temp * j][c + temp * k] = oldPiece;
                            temp++;
                        }
                        if (Character.isLowerCase(chessBoard[r + temp * j][c + temp * k].charAt(0))) {
                            oldPiece = chessBoard[r + temp * j][c + temp * k];
                            chessBoard[r][c] = " ";
                            chessBoard[r + temp * j][c + temp * k] = "Q";
                            if (kingSafe()) {
                                list = list + r + c + (r + temp * j) + (c + temp * k) + oldPiece;
                            }
                            chessBoard[r][c] = "Q";
                            chessBoard[r + temp * j][c + temp * k] = oldPiece;
                        }
                    } catch (Exception e) {
                    }
                    temp = 1;
                }

            }
        }

        return list;
    }
    public static String possibleA(int i) {
        String list = "", oldPiece;
        int r = i/8, c = i % 8;
        for (int j = 0; j < 9; j++) {
            if (j != 4) {
                try {
                    if (Character.isLowerCase(chessBoard[r-1+j/3][c-1+j%3].charAt(0)) || " ".equals(chessBoard[r-1+j/3][c-1+j%3])) {
                        oldPiece = chessBoard[r-1+j/3][c-1+j%3];
                        chessBoard[r][c] = " ";
                        chessBoard[r-1+j/3][c-1+j%3] = "A";
                        int kingTemp = kingPositionC;
                        kingPositionC = i + (j/3) * 8 + j%3 - 9;
                        if (kingSafe()) {
                            list = list + r + c + (r-1+j/3) + (c-1+j%3) + oldPiece;
                        }
                        chessBoard[r][c] = "A";
                        chessBoard[r-1+j/3][c-1+j%3] = oldPiece;
                        kingPositionC = kingTemp;
                    }
                } catch (Exception e) {}
            }
        }
        // need to add castling later
        return list;
    }

    public static boolean kingSafe ( ) {
        return true;
    }

}
