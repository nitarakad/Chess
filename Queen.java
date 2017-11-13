/**
* Represents the chess piece Queen, which extends Piece
*
* @author nitarakad
* @version 30
*/
public class Queen extends Piece {

    /**
    * Creates the chess piece Queen with a particular color, either black
    * or white
    *
    * @param c the color of the queen
    */
    public Queen(Color c) {
        super(c);
    }

    /**
    * @return this queen's algebraic expression
    */
    @Override
    public String algebraicName() {
        return "Q";
    }

    /**
    * figures out if this queen piece is black or white, then outputs its
    * designated FEN representation
    *
    * @return the FEN representation of the queen piece
    */
    @Override
    public String fenName() {
        if (getColor() == Color.WHITE) {
            return "Q";
        } else {
            return "q";
        }
    }

    /**
    * Finds the moves of the queen from a particular square as if the
    * the queen was the only piece on the board
    *
    * @param square the position from which all the moves are being calculated
    * from
    *
    * @return a square array that has all of the squares where the queen can
    * go
    */
    @Override
    public Square[] movesFrom(Square square) {
        String theSquare = square.toString();

        Square[] allPieces = {new Square("a1"), new Square("a2"),
            new Square("a3"), new Square("a4"), new Square("a5"),
            new Square("a6"), new Square("a7"), new Square("a8"),
            new Square("b1"), new Square("b2"), new Square("b3"),
            new Square("b4"), new Square("b5"), new Square("b6"),
            new Square("b7"), new Square("b8"), new Square("c1"),
            new Square("c2"), new Square("c3"), new Square("c4"),
            new Square("c5"), new Square("c6"), new Square("c7"),
            new Square("c8"), new Square("d1"), new Square("d2"),
            new Square("d3"), new Square("d4"), new Square("d5"),
            new Square("d6"), new Square("d7"), new Square("d8"),
            new Square("e1"), new Square("e2"), new Square("e3"),
            new Square("e4"), new Square("e5"), new Square("e6"),
            new Square("e7"), new Square("e8"), new Square("f1"),
            new Square("f2"), new Square("f3"), new Square("f4"),
            new Square("f5"), new Square("f6"), new Square("f7"),
            new Square("f8"), new Square("g1"), new Square("g2"),
            new Square("g3"), new Square("g4"), new Square("g5"),
            new Square("g6"), new Square("g7"), new Square("g8"),
            new Square("h1"), new Square("h2"), new Square("h3"),
            new Square("h4"), new Square("h5"), new Square("h6"),
            new Square("h7"), new Square("h8")};

        Square[] theMoves = new Square[63];
        int count = 0;
        for (int i = 0; i < allPieces.length; i++) {
            if (!allPieces[i].toString().equals(theSquare)) {
                theMoves[count] = allPieces[i];
                count++;
            }

        }

        return theMoves;
    }

}