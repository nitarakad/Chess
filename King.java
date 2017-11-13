/**
* Represents the chess piece King, which extends Piece
*
* @author nitarakad
* @version 30
*/
public class King extends Piece {

    /**
    * Creates the chess piece King with a particular color, either black
    * or white
    *
    *@param c the Color of the king
    */
    public King(Color c) {
        super(c);
    }

    /**
    * @return this kings's algebraic expression
    */
    @Override
    public String algebraicName() {
        return "K";
    }

    /**
    * figures out if this king piece is black or white, then outputs its
    * designated FEN representation
    *
    * @return the FEN representation of the king piece
    */
    @Override
    public String fenName() {
        if (getColor() == Color.WHITE) {
            return "K";
        } else {
            return "k";
        }
    }

    /**
    * Finds the moves of the king from a particular square as if the
    * the king was the only piece on the board
    *
    * @param square the position from which all the moves are being calculated
    * from
    *
    * @return a square array that has all of the squares where the king can
    * go
    */
    @Override
    public Square[] movesFrom(Square square) {

        String theSquare = square.toString();
        char theFile = theSquare.charAt(0);
        char theRank = theSquare.charAt(1);

        Square[] theMovesInitial = {new Square((char) (theFile + 1), theRank),
            new Square((char) (theFile + 1), (char) (theRank + 1)),
            new Square((char) (theFile + 1), (char) (theRank - 1)),
            new Square((char) (theFile - 1), (char) (theRank + 1)),
            new Square((char) (theFile - 1), (char) (theRank - 1)),
            new Square((char) (theFile - 1), theRank),
            new Square(theFile, (char) (theRank + 1)),
            new Square(theFile, (char) (theRank - 1))};

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