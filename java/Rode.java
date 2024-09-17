import java.util.List;

public class Rode {
    public static void main(String[] args) {
        // Inmutable String
        String name = new String("John Doe");
        System.out.println(name);
        System.out.println(name.hashCode());
        System.out.println(name.charAt(1));

        // Mutable String
        StringBuffer myName = new StringBuffer("Tun Tun Win");
        myName.append(" is a developer");
        System.out.println(myName.capacity());


        // ----
        List<String> list = List.of("That", "is", "the", "way", "to", "build", "a", "sentence");
        StringBuilder sb = new StringBuilder();
        for (String item : list) {
            sb.append(item).append(" ");
        }
        String s = sb.toString();
        System.out.println(s);
    }
}