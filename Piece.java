/**
* Represents a general piece on a chess board
*
* @author nitarakad
* @version 30
*/
public abstract class Piece {

    private Color color;

    /**
    * Creates the general chess piece with a particular color
    *
    * @param c the color of the piece
    */
    public Piece(Color c) {
        color = c;
    }

    /**
    * @return the color of the general chess piece
    */
    public Color getColor() {
        return color;
    }

    /**
    * @return this piece's algebraic expression
    */
    public abstract String algebraicName();

    /**
    * figures out if this piece is black or white, then outputs its
    * designated FEN representation
    *
    * @return the FEN representation of the piece
    */
    public abstract String fenName();

    /**
    * Finds the moves of the piece from a particular square as if the
    * the piece was the only piece on the board
    *
    * @param square the position from which all the moves are being calculated
    * from
    *
    * @return a square array that has all of the squares where the piece can
    * go
    */
    public abstract Square[] movesFrom(Square square);
}
