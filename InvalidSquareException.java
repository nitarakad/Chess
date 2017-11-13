/**
* Represents the exception where an invalid square is created, which extends
* the Exception class
*
* @author nitarakad
* @version 2
*/
public class InvalidSquareException extends RuntimeException {

    //CHECKED EXCEPTION: The user is passing something in incorrectly, so
    //the code isn't the thing that is incorrect. This exception can be fixed
    //by the user and is a checked exception.
    //AS OF HW4 THIS EXCEPTION HAS BEEN CHANGED TO AN UNCHECKED EXCPETION
    //BECAUSE IT NEEDS TO ME THROWN IN AN IMPLEMENTED METHOD IN SQUARESET
    //AND IT CAN'T BE IMPLEMENTED WITHOUT IT BEING CHECKED

    /**
    * Creates an InvalidSquareException with a string parameter that will
    * be outputed if the exception is thrown
    * Calls the constructor in the Exception class to be executed
    *
    * @param message a String that denotes what is going to be outputed
    * if the exception is thrown
    */
    public InvalidSquareException(String message) {
        super(message);
    }

}