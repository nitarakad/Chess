/**
* Represents a square on the chess board
*
* @author nitarakad
* @version 2
*/
public class Square {

    private char file;
    private char rank;


    /**
    * Creates a chess board square with a particular file and rank. If the
    * file inputed is not in between the values of a and h or if the rank
    * inputed is not in between the values of 1 and 8, the exception
    * InvalidSquareException is thrown
    *
    * @param file the column of the square, represented as a char, letters
    * a - h
    * @param rank the row of the square, reperesented as a char, numbers 1-8
    */
    public Square(char file, char rank) throws InvalidSquareException {
        String asAString = Character.toString(file) + Character.toString(rank);
        if (file > 104 || file < 97 || rank > 56 || rank < 49) {
            throw new InvalidSquareException(asAString);
        }

        this.file = file;
        this.rank = rank;
    }

    /**
    * Creates a chess board square with a String that contains only the file and
    * rank of the square
    *
    * @param name a string that contains only the file and rank of the square
    */
    public Square(String name) throws InvalidSquareException {
        this(name.charAt(0), name.charAt(1));
    }


    /**
    * makes a string of the file and rank
    *
    * @return a string containing the file and the rank
    */
    @Override
    public String toString() {
        String full = Character.toString(file) + Character.toString(rank);
        return full;
    }

    /**
    * determines whether one square is equal to another square
    *
    * @param s a square on the chessboard that is being checked if it is equal
    * to this square
    *
    * @return a boolean true if the parameter is equal to this square and false
    * if not
    */
    @Override
    public boolean equals(Object s) {

        /*String thisFull = Character.toString(file) + Character.toString(rank);
        if (thisFull.equals(s.toString())) {
            return true;
        }

        return false;*/

        if (this == s) {
            return true;
        }

        if (null == s) {
            return false;
        }

        if (!(s instanceof Square)) {
            return false;
        }

        Square newS = (Square) s;

        return this.toString().equals(newS.toString());

    }

    /**
    * getter method that returns the file of the square
    *
    * @return the file of the square
    */
    public char getFile() {
        return this.file;
    }

    /**
    * getter method that returns the rank of the square
    *
    * @return the rank of the square
    */
    public char getRank() {
        return this.rank;
    }

    /**
    *
    * gives the hashcode of a Square
    *
    * @return the hashcode of a Square
    */
    @Override
    public int hashCode() {
        return this.toString().hashCode();
    }

}