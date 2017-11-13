public class hw2Test {

    public static void main(String[] args) {
        Piece knight = new Knight(Color.BLACK);
        Knight newPiece = new Piece(Color.BLACK);
        assert knight.algebraicName().equals("N");
        //System.out.println(knight.algebraicName().equals("N"));
        assert knight.fenName().equals("n");
        //System.out.println(knight.fenName().equals("n"));
        //System.out.println((new Square("a6")).equals(new Square("a6")));
        //System.out.println(knight.getColor());
        //Square[] attackedSquares = knight.movesFrom(new Square("g6"));

        Piece pawn = new Pawn(Color.WHITE);
        Square[] squares = pawn.movesFrom(new Square("b8"));
        for (int i = 0; i < squares.length; i++) {
            System.out.println(squares[i].toString());
        }
        //test that attackedSquares contains e8, g8, etc.
        Square a1 = new Square("a1");
        Square otherA1 = new Square('a', '1');
        Square h8 = new Square("h8");
        assert a1.equals(otherA1);
        //System.out.println(a1.equals(otherA1));
        assert !a1.equals(h8);
        //System.out.println(!a1.equals(h8));
    }

}