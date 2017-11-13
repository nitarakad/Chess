/**
* Represents the chess piece Knight, which extends Piece
*
* @author nitarakad
* @version 30
*/
public class Knight extends Piece {

    /**
    * Creates the chess piece Knight with a particular color, either black
    * or white
    */
    public Knight(Color c) {
        super(c);
    }

    /**
    * @return this knights's algebraic expression
    */
    @Override
    public String algebraicName() {
        return "N";
    }

    /**
    * figures out if this knight piece is black or white, then outputs its
    * designated FEN representation
    *
    * @return the FEN representation of the knight piece
    */
    @Override
    public String fenName() {
        if (getColor() == Color.WHITE) {
            return "N";
        } else {
            return "n";
        }
    }

    /**
    * Finds the moves of the knight from a particular square as if the
    * the knight was the only piece on the board
    *
    * @param square the position from which all the moves are being calculated
    * from
    *
    * @return a square array that has all of the squares where the knight can
    * go
    */
    @Override
    public Square[] movesFrom(Square square) {
        String theSquare = square.toString();
        char theFile = theSquare.charAt(0);
        char theRank = theSquare.charAt(1);

        Square[] theMovesInitial = {
            new Square((char) (theFile + 2), (char) (theRank + 1)),
            new Square((char) (theFile + 2), (char) (theRank - 1)),
            new Square((char) (theFile - 2), (char) (theRank + 1)),
            new Square((char) (theFile - 2), (char) (theRank - 1)),
            new Square((char) (theFile + 1), (char) (theRank + 2)),
            new Square((char) (theFile + 1), (char) (theRank - 2)),
            new Square((char) (theFile - 1), (char) (theRank + 2)),
            new Square((char) (theFile - 1), (char) (theRank - 2))};

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