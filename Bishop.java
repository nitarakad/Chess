/**
* Represents the chess piece Bishop, which extends Piece
*
* @author nitarakad
* @version 30
*/
public class Bishop extends Piece {

    /**
    * Creates the chess piece Bishop with a particular color, either black
    * or white
    */

    public Bishop(Color c) {
        super(c);
    }

    /**
    * @return this bishop's algebraic expression
    */
    @Override
    public String algebraicName() {
        return "B";
    }

    /**
    * figures out if this bishop piece is black or white, then outputs its
    * designated FEN representation
    *
    * @return the FEN representation of the bishop piece
    */
    @Override
    public String fenName() {
        if (getColor() == Color.WHITE) {
            return "B";
        } else {
            return "b";
        }
    }

    /**
    * Finds the moves of the bishop from a particular square as if the
    * the bishop was the only piece on the board
    *
    * @param square the position from which all the moves are being calculated
    * from
    *
    * @return a square array that has all of the squares where the bishop can
    * go
    */
    @Override
    public Square[] movesFrom(Square square) {
        String theSquare = square.toString();
        char file = theSquare.charAt(0);
        char rank = theSquare.charAt(1);
        char r = rank;
        char f = file;
        int countPP = 0;
        int countPM = 0;
        int countMP = 0;
        int countMM = 0;
        r++;
        f++;
        while (r <= 56 && f <= 104) {
            countPP++;
            r++;
            f++;
        }
        r = rank;
        f = file;
        r--;
        f--;
        while (r >= 49 && f >= 97) {
            countMM++;
            r--;
            f--;
        }
        r = rank;
        f = file;
        r++;
        f--;
        while (r <= 56 && f >= 97) {
            countMP++;
            r++;
            f--;
        }
        r = rank;
        f = file;
        r--;
        f++;
        while (r >= 49 && f <= 104) {
            countPM++;
            r--;
            f++;
        }

        Square[] movesPP = new Square[countPP];
        r = rank;
        f = file;
        for (int i = 0; i < countPP; i++) {
            r++;
            f++;
            movesPP[i] = new Square((char) f, (char) r);
        }

        Square[] movesMP = new Square[countMP];
        r = rank;
        f = file;
        for (int j = 0; j < countMP; j++) {
            r++;
            f--;
            movesMP[j] = new Square((char) f, (char) r);
        }

        Square[] movesPM = new Square[countPM];
        r = rank;
        f = file;
        for (int k = 0; k < countPM; k++) {
            r--;
            f++;
            movesPM[k] = new Square((char) f, (char) r);
        }

        Square[] movesMM = new Square[countMM];
        r = rank;
        f = file;
        for (int l = 0; l < countMM; l++) {
            r--;
            f--;
            movesMM[l] = new Square((char) f, (char) r);
        }

        int totalNumMoves = countPP + countMP + countPM + countMM;
        Square[] theMoves = new Square[totalNumMoves];
        int count = 0;
        for (int m = 0; m < countPP; m++) {
            theMoves[m] = movesPP[m];
            count++;
        }

        for (int n = 0; n < countMP; n++) {
            theMoves[count] = movesMP[n];
            count++;
        }

        for (int p = 0; p < countPM; p++) {
            theMoves[count] = movesPM[p];
            count++;
        }

        for (int q = 0; q < countMM; q++) {
            theMoves[count] = movesMM[q];
            count++;
        }

        return theMoves;



    }

}