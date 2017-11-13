/**
* Represents the chess piece Queen, which extends Piece
*
* @author nitarakad
* @version 30
*/
public class Rook extends Piece {

    /**
    * Creates the chess piece Rook with a particular color, either black
    * or white
    */
    public Rook(Color c) {
        super(c);
    }

    /**
    * @return this rook's algebraic expression
    */
    @Override
    public String algebraicName() {
        return "R";
    }

    /**
    * figures out if this rook piece is black or white, then outputs its
    * designated FEN representation
    *
    * @return the FEN representation of the rook piece
    */
    @Override
    public String fenName() {
        if (getColor() == Color.WHITE) {
            return "R";
        } else {
            return "r";
        }
    }

    /**
    * Finds the moves of the rook from a particular square as if the
    * the rook was the only piece on the board
    *
    * @param square the position from which all the moves are being calculated
    * from
    *
    * @return a square array that has all of the squares where the rook can
    * go
    */
    @Override
    public Square[] movesFrom(Square square) {
        String theSquare = square.toString();
        char file = theSquare.charAt(0);
        char rank = theSquare.charAt(1);
        char r = rank;
        char f = file;
        int countUp = 0;
        int countDown = 0;
        int countRight = 0;
        int countLeft = 0;
        r++;
        while (r <= 56) {
            countUp++;
            r++;
        }
        r = rank;
        r--;
        while (r >= 49) {
            countDown++;
            r--;
        }
        r = rank;
        f++;
        while (f <= 104) {
            countRight++;
            f++;
        }
        f = file;
        f--;
        while (f >= 97) {
            countLeft++;
            f--;
        }
        f = file;

        Square[] movesUp = new Square[countUp];
        for (int i = 0; i < countUp; i++) {
            r++;
            movesUp[i] = new Square((char) f, (char) r);
        }
        r = rank;
        Square[] movesDown = new Square[countDown];
        for (int j = 0; j < countDown; j++) {
            r--;
            movesDown[j] = new Square((char) f, (char) r);
        }
        r = rank;
        Square[] movesRight = new Square[countRight];
        for (int k = 0; k < countRight; k++) {
            f++;
            movesRight[k] = new Square((char) f, (char) r);
        }
        f = file;
        Square[] movesLeft = new Square[countLeft];
        for (int l = 0; l < countLeft; l++) {
            f--;
            movesLeft[l] = new Square((char) f, (char) r);
        }
        f = file;

        int totalNumMoves = countUp + countDown + countRight + countLeft;
        Square[] theMoves = new Square[totalNumMoves];
        int count = 0;
        for (int m = 0; m < countUp; m++) {
            theMoves[count] = movesUp[m];
            count++;
        }
        for (int n = 0; n < countDown; n++) {
            theMoves[count] = movesDown[n];
            count++;
        }
        for (int p = 0; p < countRight; p++) {
            theMoves[count] = movesRight[p];
            count++;
        }
        for (int q = 0; q < countLeft; q++) {
            theMoves[count] = movesLeft[q];
            count++;
        }

        return theMoves;
    }

}