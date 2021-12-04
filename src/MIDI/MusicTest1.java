import javax.sound.midi.MidiSystem;

/**
 * Purpose: use a sequencer, the sequencer is the object that taks all the MIDI data and sends it to the 
 * right instrument. It's the thing that plays the music. Here, it's like a playback device. 
 */

import javax.sound.midi.*;

public class MusicTest1 {
    public void play() {
        try {
            Sequencer sequencer = MidiSystem.getSequencer();
            System.out.println("We got a sequencer");
        } catch (MidiUnavailableException ex) {
            System.out.println("Bummer");
        }
    }

    public static void main(String[] args) {
        MusicTest1 mt = new MusicTest1();
        mt.play();
    }
}
