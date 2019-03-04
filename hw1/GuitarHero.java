import es.datastructur.synthesizer.GuitarString;

public class GuitarHero {
    private static GuitarString[] stringArray = new GuitarString[37];
    private static final double CONCERT_A = 440.0;
    private static final double CONCERT_C = CONCERT_A * Math.pow(2, 3.0 / 12.0);

    public static void main(String[] args) {

        String keyboard = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";

        for (int i = 0; i < stringArray.length; i++) {
            stringArray[i] = new GuitarString(440 * Math.pow(2., ((i - 24) / 12)));
        }

        while (true) {

            /* check if the user has typed a key; if so, process it */
            if (StdDraw.hasNextKeyTyped()) {
                char key = StdDraw.nextKeyTyped();
                if (keyboard.contains(Character.toString(key))) {
                    int i = keyboard.indexOf(key);
                    stringArray[i].pluck();
                }

            }

            /* compute the superposition of samples */
            double sample = 0.;
            for (GuitarString string : stringArray) {
                sample += string.sample();
            }

            /* play the sample on standard audio */
            StdAudio.play(sample);

            /* advance the simulation of each guitar string by one step */
            for (GuitarString string : stringArray) {
                string.tic();
            }
        }
    }
}
