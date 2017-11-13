import java.util.List;
import java.util.ArrayList;
import java.util.function.Predicate;

/**
*
* Creates a chess game with a sequences of moves (the sequences is a list
*
* @author nitarakad
* @version 1
*/
public class ChessGame {
    private List<Move> moves;

    /**
    * constructor method that takes in all fields and initializes them to the
    * corresponding variables
    *
    * @param moves the sequence of moves of the chess pieces
    */
    public ChessGame(List<Move> moves) {
        this.moves = moves;
    }

    /**
    * @return the nth move
    */
    public Move getMove(int n) {
        return moves.get(n);
    }

    /**
    *
    * creates and returns a list that is filterd by the inputed predicates
    *
    * @param filter the predicted being used to filter the list
    *
    * @return the filtered list
    */
    public List<Move> filter(Predicate<Move> filter) {
        List<Move> filteredMoves = new ArrayList<Move>();
        for (Move m : moves) {
            if (filter.test(m)) {
                filteredMoves.add(m);
            }
        }
        return filteredMoves;

    }

    /**
    *
    * creates a list of moves with comments (if either or both Ply has a
    * comment)
    * uses a lambda expression
    *
    * @return the list of moves with comments
    */
    public List<Move> getMovesWithComment() {
        List<Move> theMoves = this.filter((Move m) -> {
                if (m.getWhitePly().getComment().isPresent()
                    || m.getBlackPly().getComment().isPresent()) {
                    return true;
                }
                return false;
            });
        return theMoves;
    }

    /**
    *
    * creates a list of moves without comments (neither Ply has comments)
    * uses an anonymous inner class
    *
    * @return the list of moves without comments
    */
    public List<Move> getMovesWithoutComment() {
        List<Move> theMoves = this.filter(new Predicate<Move>() {
            public boolean test(Move m) {
                if (!m.getWhitePly().getComment().isPresent()
                    && !m.getBlackPly().getComment().isPresent()) {
                    return true;
                }

                return false;
            }
        });

        return theMoves;
    }

    public List<Move> getMovesWithPieces(Piece p) {
        List<Move> theMoves = this.filter(new PiecePredicate());
        return theMoves;
    }

    public List<Move> getMoves() {
        return this.moves;
    }

    private class PiecePredicate implements Predicate<Move> {
        public boolean test(Move m) {
            if (m.getWhitePly().getPiece().algebraicName().equals(
                m.getBlackPly().getPiece().algebraicName())) {
                return true;
            }

            return false;
        }
    }
}