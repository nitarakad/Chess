/**
* Represents the chess piece Pawn, which extends Piece
*
* @author nitarakad
* @version 30
*/
public class Pawn extends Piece {

    /**
    * Creates the chess piece Pawn with a particular color, either black
    * or white
    */
    public Pawn(Color c) {
        super(c);
    }

    /**
    * @return this pawn's algebraic expression
    */
    @Override
    public String algebraicName() {
        return "";
    }

    /**
    * figures out if this pawn piece is black or white, then outputs its
    * designated FEN representation
    *
    * @return the FEN representation of the pawn piece
    */
    @Override
    public String fenName() {
        if (getColor() == Color.WHITE) {
            return "";
        } else {
            return "";
        }
    }

    /**
    * Finds the moves of the pawn from a particular square as if the
    * the pawn was the only piece on the board
    *
    * @param square the position from which all the moves are being calculated
    * from
    *
    * @return a square array that has all of the squares where the pawn can
    * go
    */
    @Override
    public Square[] movesFrom(Square square) {
        String theSquare = square.toString();
        char theFile = theSquare.charAt(0);
        char theRank = theSquare.charAt(1);
        Square[] theMovesInitial;
        if (getColor() == Color.WHITE) {
            if (theRank == '2') {
                theMovesInitial = new Square[]
                {new Square(theFile, (char) (theRank + 1)),
                    new Square(theFile, (char) (theRank + 2))};
            } else {
                theMovesInitial = new Square[]
                {new Square(theFile, (char) (theRank + 1))};
            }
        } else {
            if (theRank == '7') {
                theMovesInitial = new Square[]
                {new Square(theFile, (char) (theRank - 1)),
                    new Square(theFile, (char) (theRank - 2))};
            } else {
                theMovesInitial = new Square[]
                {new Square(theFile, (char) (theRank - 1))};
            }
        }

        int numNotExists = 0;
        for (int i = 0; i < theMovesInitial.length; i++) {
            if (theMovesInitial[i].toString().charAt(0) > 104
                || theMovesInitial[i].toString().charAt(0) < 97
                || theMovesInitial[i].toString().charAt(1) > 56
                || theMovesInitial[i].toString().charAt(1) < 49) {
                numNotExists++;
            }
        }

        Square[] theMovesActual
                = new Square[theMovesInitial.length - numNotExists];

        int count = 0;
        for (int j = 0; j < theMovesInitial.length; j++) {
            if (theMovesInitial[j].toString().charAt(0) <= 104
                && theMovesInitial[j].toString().charAt(0) >= 97
                && theMovesInitial[j].toString().charAt(1) <= 56
                && theMovesInitial[j].toString().charAt(1) >= 49) {
                theMovesActual[count] = theMovesInitial[j];
                count++;
            }
        }

        return theMovesActual;
    }

}