package com.juniverse.music;

/**
 * Toca el "Himno de la Alegría" (Beethoven) nota por nota.
 *
 * @author linux
 */
public class PlayMusic {

    private final static int RE_GRAVE = 50;
    private final static int SOL = 55;
    private final static int LA = 57;
    private final static int SI = 59;
    private final static int DO = 60;
    private final static int RE_AGUDO = 62;

    private final static int BLANCA = 1000;
    private final static int NEGRA = 500;
    private final static int CORCHEA = 250;

    /**
     * Toca la melodía completa.
     * @param args no se usan
     */
    public static void main(String[] args) {

        try {
            //Himno de la Alegria
            try (Music music = new Music()) {
                music.sound(SI, BLANCA);
                music.sound(DO, NEGRA);
                music.sound(RE_AGUDO, NEGRA);
                music.sound(RE_AGUDO, NEGRA);
                music.sound(DO, NEGRA);
                music.sound(SI, NEGRA);
                music.sound(LA, NEGRA);
                music.sound(SOL, NEGRA);
                music.sound(SOL, NEGRA);
                music.sound(LA, NEGRA);
                music.sound(SI, NEGRA);
                music.sound(SI, NEGRA);
                music.sound(LA, NEGRA);
                music.sound(LA, NEGRA);
                music.sound(SI, BLANCA);
                music.sound(DO, NEGRA);
                music.sound(RE_AGUDO, NEGRA);
                music.sound(RE_AGUDO, NEGRA);
                music.sound(DO, NEGRA);
                music.sound(SI, NEGRA);
                music.sound(LA, NEGRA);
                music.sound(SOL, NEGRA);
                music.sound(SOL, NEGRA);
                music.sound(LA, NEGRA);
                music.sound(SI, NEGRA);
                music.sound(LA, BLANCA);
                music.sound(SOL, CORCHEA);
                music.sound(SOL, BLANCA);
                music.sound(LA, BLANCA);
                music.sound(SI, NEGRA);
                music.sound(SOL, NEGRA);
                music.sound(LA, NEGRA);
                music.sound(SI, CORCHEA);
                music.sound(DO, CORCHEA);
                music.sound(SI, NEGRA);
                music.sound(SOL, NEGRA);
                music.sound(LA, NEGRA);
                music.sound(SI, CORCHEA);
                music.sound(DO, CORCHEA);
                music.sound(SI, NEGRA);
                music.sound(LA, NEGRA);
                music.sound(SOL, NEGRA);
                music.sound(LA, NEGRA);
                music.sound(RE_GRAVE, BLANCA);
                music.sound(SI, BLANCA);
                music.sound(DO, NEGRA);
                music.sound(RE_AGUDO, NEGRA);
                music.sound(RE_AGUDO, NEGRA);
                music.sound(DO, NEGRA);
                music.sound(SI, NEGRA);
                music.sound(LA, NEGRA);
                music.sound(SOL, NEGRA);
                music.sound(SOL, NEGRA);
                music.sound(LA, NEGRA);
                music.sound(SI, NEGRA);
                music.sound(LA, BLANCA);
                music.sound(SOL, CORCHEA);
                music.sound(SOL, BLANCA);
            }
        } catch (Exception ex) {
            ex.printStackTrace(System.err);
        }
    }
}
