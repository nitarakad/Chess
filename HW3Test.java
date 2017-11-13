public class HW3Test {
    public static void main(String[] args) throws InvalidSquareException {
        try {
            String invalidSquare = "a7";
            new Square('a');
            //System.out.println("No InvalidSquareException for invalid square: "
              //      + invalidSquare);
        } catch (InvalidSquareException e) {
            System.out.println("No InvalidSquareException for invalid square: "
                    + e.getMessage());
        }

        Square s = new Square("g7");
        boolean fileTrue = s.getFile() == 'f';
        System.out.println(fileTrue);
        boolean rankTrue = s.getRank() == '7';
        System.out.println(rankTrue);
        Square s2 = new Square('e', '4');
        boolean itIs = "e4".equals(s2.toString());
        System.out.println(itIs);

    }
}