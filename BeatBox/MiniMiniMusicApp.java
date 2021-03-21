import javax.sound.midi.*;

public class MiniMiniMusicApp{
  public static void main(String[] args) {
    MiniMiniMusicApp mini = new MiniMiniMusicApp();
    mini.play();
  }
  public void play(){
    try{
      Sequencer player = MidiSystem.getSequencer();
      player.open();

      Sequence seq = new Sequence(Sequence.PPQ, 4);

      Track track = seq.createTrack();

      ShortMessage a = new ShortMessage();
      ShortMessage b = new ShortMessage();
      // 1: Mesage Type : NOTE ON
      // 2: channel 1 -> keyboard palyer  9 -> drummer
      // 3: note to play
      // 4 : Velocity
      a.setMessage(144, 1, 44, 100);
      b.setMessage(128, 1, 44, 100);
      MidiEvent noteOn = new MidiEvent(a,1);
      MidiEvent noteOff = new MidiEvent(b,10);
      track.add(noteOn);
      track.add(noteOff);



      player.setSequence(seq);

      player.start();
    } catch (Exception ex){
      ex.printStackTrace();
    }
  } // close play
} // close class
