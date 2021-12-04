
/**
 * Purpose: first sound player app
 * How? 
 *  1. Get a Sequencer and open it
 *  2. Make a new sequence
 *  3. Get a new Track from the sequence
 *  4. Fill the track with MidiEvents and give the sequence to the sequencer
 */
import javax.sound.midi.*;

public class MiniMiniMusicApp {
    public static void main(String[] args) {
        MiniMiniMusicApp mini = new MiniMiniMusicApp();
        mini.play();
    }

    public void play() {
        try {
            // Get a sequencer and open it
            Sequencer player = MidiSystem.getSequencer();
            player.open();

            Sequence seq = new Sequence(Sequence.PPQ, 4);

            // Ask the Sequence for a Track. Remember, the Track lives in the Sequence,
            // and the MIDI data lives in the Track.
            Track track = seq.createTrack();

            ShortMessage a = new ShortMessage();
            // a.setMessage(command, channel, data1, data2);
            a.setMessage(144, 1, 44, 100);
            MidiEvent noteOn = new MidiEvent(a, 1);
            track.add(noteOn);

            ShortMessage b = new ShortMessage();
            b.setMessage(128, 1, 44, 100);
            MidiEvent noteOff = new MidiEvent(b, 16);
            track.add(noteOff);

            player.setSequence(seq);
            player.start();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    } // close play
} // close class
