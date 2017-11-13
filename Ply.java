import java.util.Optional;

/**
*
* Creates one player's move in chess (stored like half of a move)
*
* @author nitarakad
* @version 1
*/
public class Ply {
    private Piece piece;
    private Square from;
    private Square to;
    private Optional<String> comment;

    /**
    *
    * constructor method that takes in all fields an intializes them to the
    * corresponding variables
    *
    * @param piece of type Piece which is the piece that the user is currently
    * playing with
    * @param from of type Square where the piece initially starts at
    * @param to of type Square where the piece wants to go to
    * @param comment of type Optional, with a String paramater
    */
    public Ply(Piece piece, Square from, Square to, Optional<String> comment) {
        this.piece = piece;
        this.from = from;
        this.to = to;
        this.comment = comment;
    }

    /**
    *
    * @return the piece
    */
    public Piece getPiece() {
        return this.piece;
    }

    /**
    *
    * @return the Square from where it initally starts
    */
    public Square getFrom() {
        return this.from;
    }

    /**
    *
    * @return the Square to where it wants to go
    */
    public Square getTo() {
        return this.to;
    }

    /**
    *
    * @return the comment
    */
    public Optional<String> getComment() {
        return this.comment;
    }
}