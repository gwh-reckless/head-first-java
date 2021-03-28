import javax.sound.midi.*;

public class MidiDemo {
    public static void main(String[] args) {
        try {
            Sequencer sequencer = MidiSystem.getSequencer();
            sequencer.open();

            Sequence seq = new Sequence(Sequence.PPQ, 4);
            Track track = seq.createTrack();

            ShortMessage a0 = new ShortMessage();
            a0.setMessage(144, 1, 64, 100);
            MidiEvent noteOn = new MidiEvent(a0, 0);
            track.add(noteOn);

            ShortMessage a1 = new ShortMessage();
            a1.setMessage(128, 1, 64, 100);
            MidiEvent noteOff = new MidiEvent(a1, 1);
            track.add(noteOff);

            ShortMessage b0 = new ShortMessage();
            b0.setMessage(144, 1, 67, 100);
            MidiEvent bnoteOn = new MidiEvent(b0, 0);
            track.add(bnoteOn);

            ShortMessage b1 = new ShortMessage();
            b1.setMessage(128, 1, 67, 100);
            MidiEvent bnoteOff = new MidiEvent(b1, 1);
            track.add(bnoteOff);

            sequencer.setSequence(seq);
            sequencer.start();

        } catch (Exception ex) {

        }
    }
}
