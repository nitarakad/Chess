import java.util.Iterator;
import java.util.Collection;
import java.util.Set;
import java.util.NoSuchElementException;

/**
*
* Represents the squares of a chessboard as a set, so Set is implemented
*
* @author nitarakad
* @version 1
*/
public class SquareSet implements Set<Square> {

    //private int size = 0;
    private Square[] allSquares;
    private int lastIndex;
    private int size;

    /**
    *
    * Initializes a set of Squares by creating an empty Square array of length
    * 10. This array is the backing array of the set.
    */
    public SquareSet() {
        this.allSquares = new Square[64];
        this.lastIndex = 0;
    }

    /**
    *
    * Initializes a set of Squares by creating a Square array with the contents
    * of the Collection in the parameters
    *
    * @param s a collection of wildcard type who's contents are stored in the
    * backing Square array allSquares
    */
    public SquareSet(Collection<?> s) {
        //allSquares = new Square[s.size()];
        allSquares = new Square[64];
        Object[] collectionToArray = s.toArray();
        for (int i = 0; i < collectionToArray.length; i++) {
            if (collectionToArray[i] != null) {
                this.add((Square) collectionToArray[i]);
            }
        }
        this.lastIndex = collectionToArray.length - 1;
        //this.addAll(s);

        //this.size = allSquares.length;
    }

    /**
    *
    * adds in a Square into the set
    * throws an InvalidSquareException if the Square that wants to be added
    * is not a valid square (the file is not in between a and g and the rank
    * is not in between 1 and 8)
    *
    * @param s the Square that wants to be added to the set
    *
    * @return a boolean; returns true if the Square inputed can be added (it
    * is not already in the set) and false if it can't be added (it is already
    * in the set)
    */
    @Override
    public boolean add(Square s) throws NullPointerException {
        if (null == s) {
            throw new NullPointerException("Square is null");
        }

        if (s.getFile() > 104 || s.getFile() < 97
            || s.getRank() > 56 || s.getRank() < 49) {
            throw new InvalidSquareException(s.toString());
        }

        for (int i = 0; i < allSquares.length; i++) {
            if (s.equals(allSquares[i])) {
                return false;
            }
        }
        for (int i = 0; i < allSquares.length; i++) {
            if (allSquares[i] == null) {
                allSquares[i] = s;
                lastIndex++;
                return true;
            }
        }
        return false;
    }

    /**
    *
    * checks if the set contains a particular object
    *
    * @param o an object that is being checked if it is in the set
    *
    * @return a boolean; returns true if the object is contained in the set
    * and false if it isn't
    */
    @Override
    public boolean contains(Object o) {

        if (!(o instanceof Square)) {
            return false;
        }

        for (int i = 0; i < lastIndex; i++) {
            if (allSquares[i] != null && allSquares[i].equals(o)) {
                return true;
            }
        }
        return false;
    }

    /**
    *
    * checks if every element in the collection is contained in the set
    *
    * @param s a collection of wildcard type
    *
    * @return a boolean; returns true if the entire collection is contained
    * in the set and false if it isn't
    */
    @Override
    public boolean containsAll(Collection<?> s) {
        Object[] toArray = s.toArray();

        int count = 0;

        for (int i = 0; i < toArray.length; i++) {
            for (int j = 0; j < allSquares.length; j++) {
                if (toArray[i].equals(allSquares[j])) {
                    count++;
                }
            }
        }

        if (count == s.size()) {
            return true;
        }

        return false;
    }

    /**
    *
    * checks if an object is equal to this Square Set
    *
    * @param o an object that is being checked if it is equal to
    *
    * @return a boolean true of the o is equal to this object and false
    *if it isn't
    */
    @Override
    public boolean equals(Object o) {

        if (o == null) {
            return false;
        } else if (!(o instanceof Set)) {
            return false;
        } else {
            Set that = (Set) o;
            if (size() != that.size()) {
                return false;
            }

            for (Object s: that) {
                if (!(s instanceof Square)) {
                    return false;
                }

                if (!contains(s)) {
                    return false;
                }
            }

            return true;
        }
    }

    /**
    *
    * calculates a unique hashcode for each SquareSet
    *
    * @return an integer that is the hashcode value
    */
    @Override
    public int hashCode() {
        int result = 0;

        for (int i = 0; i < lastIndex; i++) {
            result += allSquares[i].toString().hashCode();
        }

        return result;
    }

    @Override
    /**
    *
    * checks if the Square Set is empty
    *
    * @return a boolean true if the set is empty and false if it isn't
    */
    public boolean isEmpty() {
        for (int i = 0; i < allSquares.length; i++) {
            if (allSquares[i] != null) {
                return false;
            }
        }
        return true;
    }

    /**
    *
    * @return an iterator of type Square
    */
    @Override
    public Iterator<Square> iterator() {
        return new SquareSetIterator();
    }

    /**
    * determines the size of the square set
    *
    * @return the size (length) of the square set
    */
    @Override
    public int size() {
        int sizeOf = 0;
        for (int i = 0; i < allSquares.length; i++) {
            if (allSquares[i] != null) {
                sizeOf++;
            }
        }

        return sizeOf;
    }

    /**
    *
    * @return an array that contains all of the elements in this set
    */
    @Override
    public Object[] toArray() {
        int noNullCount = 0;
        for (int i = 0; i < allSquares.length; i++) {
            if (allSquares[i] != null) {
                noNullCount++;
            }
        }

        Square[] noNullArray = new Square[noNullCount];
        for (int j = 0; j < noNullArray.length; j++) {
            noNullArray[j] = allSquares[j];
        }

        return noNullArray;
    }

    /**
    * determines the array that needs to be returned based on the specified
    * array in the parameter
    *
    * @param a an array of type T (which needs to store the elements of the
    * set)
    *
    * @return an array that contains all of the elements in this set
    */
    @Override
    @SuppressWarnings("unchecked")
    public <T> T[] toArray(T[] a) {
        int noNullCount = 0;
        for (int i = 0; i < allSquares.length; i++) {
            if (allSquares[i] != null) {
                noNullCount++;
            }
        }

        Square[] noNullArray = new Square[noNullCount];
        for (int j = 0; j < noNullArray.length; j++) {
            noNullArray[j] = allSquares[j];
        }

        T[] resultArray;
        if (a.length < noNullArray.length) {
            try {
                resultArray = (T[]) new Square[noNullArray.length];
                for (int i = 0; i < resultArray.length; i++) {
                    resultArray[i] = (T) noNullArray[i];
                }
            } catch (ClassCastException e) {
                throw new ArrayStoreException();
            }
        } else {
            resultArray = a;
            for (int i = 0; i < noNullArray.length; i++) {
                try {
                    resultArray[i] = (T) noNullArray[i];
                } catch (ClassCastException e) {
                    throw new ArrayStoreException();
                }
            }
        }

        return resultArray;
    }

    /**
    *
    * adds all of the elements in the collection parameter to the set only
    * if none of the values are already in the set
    *
    * @param c a collection of wildcard elements that extend Square
    *
    * @return a boolean true if the set was changed (false if
    * not)
    */
    @Override
    public boolean addAll(Collection<? extends Square> c) {
        Object[] toArray = c.toArray();
        boolean added = true;
        int count = 0;
        int didAdd = 0;
        while (count < toArray.length) {
            added = this.add((Square) toArray[count]);
            if (added) {
                lastIndex++;
                didAdd++;
            }
            count++;
        }

        if (didAdd > 0) {
            return true;
        }

        return false;

    }

    /**
    * removes an object from the set
    *
    * @param o an object that needs to be removed from the set
    *
    * @return true if the object was removed from the set (false if not)
    */
    @Override
    public boolean remove(Object o) {
        int theIndex = 0;

        if (!(this.contains(o))) {
            return false;
        } else {
            for (int i = 0; i < lastIndex; i++) {
                if (allSquares[i].equals(o)) {
                    theIndex = i;
                    break;
                }
            }

            for (int j = theIndex; j < allSquares.length - 1; j++) {
                allSquares[j] = allSquares[j + 1];
            }

            allSquares[63] = null;

            lastIndex--;

            return true;
        }
    }

    /**
    *
    * clears the set (not being implemented)
    */
    @Override
    public void clear() {
        throw new UnsupportedOperationException();
    }

    /**
    *
    * removes a specified collection of wildcard elements from the set (not
    * being implemented)
    *
    * @param c a collection of type wildcard
    *
    * @return a boolean true if all of the elements in the collection were
    * removed from the set (false if not)
    */
    @Override
    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    /**
    *
    * retains only the elements in the collection parameter in the set
    *
    * @param c a collection of type wildcard
    *
    * @return a boolean true if the set was changed and false if not
    */
    @Override
    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    /**
    *
    * Creates an iterator for a Square Set
    *
    * @author nitarakad
    *
    * @version 1
    */
    private class SquareSetIterator implements Iterator<Square> {

        private int cursor;

        public SquareSetIterator() {
            this.cursor = 0;
        }

        /**
        *
        * determines if the set has another value after the current
        *
        * @return a boolean true if there is a next element and false if not
        */
        public boolean hasNext() {
            return cursor < lastIndex;
        }

        /**
        *
        * @return the next element of the set
        */
        public Square next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Square answer = allSquares[cursor++];
            return answer;
        }
    }
}



