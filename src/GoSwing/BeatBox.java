import java.awt.*;
import javax.swing.*;
import javax.sound.midi.*;
import java.util.*;
import java.awt.event.*;

public class BeatBox {
  JPanel mainPanel;
  ArrayList<JCheckBox> checkboxList;
  Sequencer sequencer;
  Sequence sequence;
  Track track;
  JFrame theFrame;

  String[] instrumentNames = { "Bass Drum", "Closed Hi-Hat", "Open Hi-Hat", "Acoustic Snare", "Crash Cymbal",
      "Hand Clap", "High Tom", "Hi Bongo", "Maracas", "Whistle", "Low Conga", "Cowbell", "Vibraslap", "Low-mid Tom",
      "High Agogo", "Open Hi Conga" };

  int[] instruments = { 35, 42, 46, 38, 49, 39, 50, 60, 70, 72, 64, 56, 58, 47, 67, 63 };

  public static void main(String[] args) {
    new BeatBox().buildGUI();
  }

  public void buildGUI() {
    // Create JFrame
    theFrame = new JFrame("Cyber BeatBox");
    theFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // Use Border
    BorderLayout layout = new BorderLayout();

    // Create a JPanel with border layout as background
    JPanel background = new JPanel(layout);
    // Add border for the JPanel: Background
    background.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

    // Create a list of JCheckBox
    checkboxList = new ArrayList<JCheckBox>();

    // Create a Box , to contain buttons, using BoxLayout vertically
    Box buttonBox = new Box(BoxLayout.Y_AXIS);

    // Create Start Button, and add the MyStartListenerwhich is a inner class
    // implement the ActionListener.
    // Finally, add the Button to the Box.
    JButton start = new JButton("Start");
    start.addActionListener(new MyStartListener());
    buttonBox.add(start);

    JButton stop = new JButton("Stop");
    stop.addActionListener(new MyStopListener());
    buttonBox.add(stop);

    JButton upTempo = new JButton("Tempo up");
    upTempo.addActionListener(new MyUpTempoListener());
    buttonBox.add(upTempo);

    JButton downTempo = new JButton("Tempo down");
    downTempo.addActionListener(new MyDownTempoListener());
    buttonBox.add(downTempo);

    // Create a new Box contains labels.
    Box nameBox = new Box(BoxLayout.Y_AXIS);

    // Create Labels use instrumentNames, which is an array of instrument names
    for (int i = 0; i < 16; i++) {
      nameBox.add(new Label(instrumentNames[i]));
    }

    // Add button box to the east of JPanel: background
    background.add(BorderLayout.EAST, buttonBox);
    // Add labels box to the west of JPanel: background
    background.add(BorderLayout.WEST, nameBox);

    // add the JPanel:background to the Frame.
    theFrame.getContentPane().add(background);

    // Crate a GridLayout with 16 * 16 grids.
    GridLayout grid = new GridLayout(16, 16);
    // Set the verticall gap
    grid.setVgap(1);
    // Set the horizontal gap
    grid.setHgap(2);
    // Create a new JPanel: mainPanel with the GridLayout:grid
    mainPanel = new JPanel(grid);
    // add JPnael:mainPnael, to the center of the JPanel: background
    background.add(BorderLayout.CENTER, mainPanel);

    // There's 256 JCheckBox need to add
    for (int i = 0; i < 256; i++) {
      JCheckBox c = new JCheckBox();
      c.setSelected(false);
      // Add the checkbox to the Array: checkboxList
      checkboxList.add(c);
      // Add the checkbox to the JPanel: mainPanel
      mainPanel.add(c);
    }

    // call setUpMidi()
    setUpMidi();

    // set the bounds of the JFrame: theFrame.
    theFrame.setBounds(50, 50, 300, 300);
    theFrame.pack();

    theFrame.setVisible(true);
  } // close method

  public void setUpMidi() {
    try {
      sequencer = MidiSystem.getSequencer();
      sequencer.open();
      sequence = new Sequence(Sequence.PPQ, 4);
      track = sequence.createTrack();
      sequencer.setTempoInBPM(120);

    } catch (Exception e) {
      e.printStackTrace();
    }
  } // close method

  public void buildTrackAndStart() {
    int[] trackList = null;

    sequence.deleteTrack(track);
    track = sequence.createTrack();

    for (int i = 0; i < 16; i++) {
      trackList = new int[16];

      int key = instruments[i];

      for (int j = 0; j < 16; j++) {
        JCheckBox jc = checkboxList.get(j + 16 * i);
        if (jc.isSelected()) {
          trackList[j] = key;
        } else {
          trackList[j] = 0;
        }
      } // close inner loop
      for (int j = 0; j < 16; j++) {
        System.out.print(trackList[j]);
      }
      System.out.println();
      makeTracks(trackList);
      // track.add(makeEvent(176,1,127,0,16));
    } // close outer

    track.add(makeEvent(192, 9, 2, 0, 15));
    try {
      sequencer.setSequence(sequence);
      sequencer.setLoopCount(sequencer.LOOP_CONTINUOUSLY);
      sequencer.start();
      sequencer.setTempoInBPM(120);
    } catch (Exception e) {
      e.printStackTrace();
    }
  } // close buildTrackAndStart method

  public class MyStartListener implements ActionListener {
    public void actionPerformed(ActionEvent a) {
      buildTrackAndStart();
    }
  } // close inner class

  public class MyStopListener implements ActionListener {
    public void actionPerformed(ActionEvent a) {
      sequencer.stop();
    }
  } // close inner class

  public class MyUpTempoListener implements ActionListener {
    public void actionPerformed(ActionEvent a) {
      float tempoFactor = sequencer.getTempoFactor();
      sequencer.setTempoFactor((float) (tempoFactor * 1.03));
    }
  } // close inner class

  public class MyDownTempoListener implements ActionListener {
    public void actionPerformed(ActionEvent a) {
      float tempoFactor = sequencer.getTempoFactor();
      sequencer.setTempoFactor((float) (tempoFactor * 0.97));
    }
  } // close inner class

  public void makeTracks(int[] list) {
    for (int i = 0; i < 16; i++) {
      int key = list[i];
      if (key != 0) {
        track.add(makeEvent(144, 9, key, 100, i));
        track.add(makeEvent(128, 9, key, 100, i + 1));
      }
    }
  }

  public MidiEvent makeEvent(int comd, int chan, int one, int two, int tick) {
    MidiEvent event = null;
    try {
      ShortMessage a = new ShortMessage();
      a.setMessage(comd, chan, one, two);
      event = new MidiEvent(a, tick);
    } catch (Exception e) {
      e.printStackTrace();
    }
    ;
    return event;
  }
}
