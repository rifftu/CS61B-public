public class HorribleSteve {
    public static void main(String [] args) throws Exception {
        long i = 0;
        for (long j = 0; j < 500; j++) {

            if (!Flik.isSameNumber(i, j)) {
                throw new Exception(
                        String.format("i:%d not same as j:%d ??", i, j));
            }
            i++;
        }
        System.out.println("i is " + i);
    }
}
