package com.juniverse.music;

import java.util.concurrent.TimeUnit;
import javax.sound.midi.Soundbank;
import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Synthesizer;

import java.util.logging.Logger;
import java.util.logging.Level;
/**
 * Reproduce notas MIDI con el sintetizador de software de Java.
 *
 * @author linux
 */
public class Music implements AutoCloseable {
    private static final Logger LOGGER = AppLogger.get(Music.class);


    private final Synthesizer midiSynth;

    /**
     * Abre el sintetizador y carga el primer instrumento disponible.
     * @throws MidiUnavailableException si no hay sintetizador
     */
    public Music() throws MidiUnavailableException {
        this.midiSynth = MidiSystem.getSynthesizer();
        this.midiSynth.open();
        // El instrumento se carga una sola vez (antes se recargaba en cada nota).
        // getDefaultSoundbank() puede ser null; en ese caso se usa el sonido por defecto del sintetizador.
        Soundbank soundbank = this.midiSynth.getDefaultSoundbank();
        if (soundbank != null && soundbank.getInstruments().length > 0) {
            this.midiSynth.loadInstrument(soundbank.getInstruments()[0]);
        }
    }

    /**
     * Cierra el sintetizador.
     * @throws Exception si falla el cierre
     */
    @Override
    public void close() throws Exception {
        if (midiSynth != null) {
            midiSynth.close();
        }
    }

    /**
     * Toca una nota y espera a que termine.
     * @param noteNumber número de nota MIDI (60 = do central)
     * @param duration duración en milisegundos
     * @throws MidiUnavailableException si el sintetizador no está disponible
     */
    public void sound(int noteNumber, int duration) throws MidiUnavailableException {
        MidiChannel[] mChannels = midiSynth.getChannels();
        mChannels[0].noteOn(noteNumber, 100);
        delay(duration);
        mChannels[0].noteOff(noteNumber, 0);
    }

    /**
     * Espera la duración de la nota más la latencia del sintetizador.
     * @param duration duración en milisegundos
     */
    private void delay(int duration) {
        try {
            Thread.sleep(duration);
            Thread.sleep(TimeUnit.MICROSECONDS.toMillis(midiSynth.getLatency()));
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt(); // conserva la señal de interrupción
            LOGGER.log(Level.SEVERE, ex.getMessage(), ex);
        }
    }
}
