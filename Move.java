/**
*
* Creates one turn of chess, which consists of a white turn and a black turn
*
* @author nitarakad
* @version 1
*/
public class Move {
    private Ply whitePly;
    private Ply blackPly;

    /**
    * constructor method that takes in all fields and intializes them to the
    * corresponding variables
    *
    * @param whitePly the move of the white piece
    * @param blackPly the move of the black piece
    */
    public Move(Ply whitePly, Ply blackPly) {
        this.whitePly = whitePly;
        this.blackPly = blackPly;
    }

    /**
    *
    * @return the white move
    */
    public Ply getWhitePly() {
        return this.whitePly;
    }

    /**
    *
    * @return the black move
    */
    public Ply getBlackPly() {
        return this.blackPly;
    }
}