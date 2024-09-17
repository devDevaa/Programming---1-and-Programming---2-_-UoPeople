import textio.TextIO;

public class RowsofChars {
    public static void main(String[] args) {
        String inputLine;  // Line of text input by user.
        TextIO.put("Enter a line of text: ");
        inputLine = TextIO.getln();
        TextIO.putln();
        printRowsFromString( inputLine );
    }


    /**
     * For each character in str, write a line of output
     * containing 25 copies of that character.
     */
    private static void printRowsFromString( String str ) {
        int i;  // Loop-control variable for counting off the chars.
        for ( i = 0; i < str.length(); i++ ) {
            printRow( str.charAt(i), 25 );
        }
    }


    /**
     * Write one line of output containing N copies of the
     * character ch.  If N is less than or equal to 0, an empty line is output.
     */
    private static void printRow( char ch, int N ) {
        int i;  // Loop-control variable for counting off the copies.
        for ( i = 1; i <= N; i++ ) {
            System.out.print( ch );
        }
        System.out.println();
    }
}
