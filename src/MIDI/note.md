# MIDI

Purpose: focus on getting some MIDI-generated sound to come out of your computer.

**MIDI**: MIDI, standards for Musical Instrument Digitial Interface, and is a standard protocol for getting different kinds of electronic sound equiment to communicate.

**MIDI FILE** : MIDI file has information aobut how a song should be played, but it doesnt' have any actual sound data. It's kind of like sheet music instructions for a player-piano.

**MIDI-capable Instrument** : MIDI device knows how to 'read' a MIDI file and play back the sound. The device might be a synthesizer keyboard or some other kind of instrument. Usually, a MIDI instrument can play a lot of differnet sounds(piano, drums, violin, etc.), and all at the same time. So a MIDI file isn't like sheet music for just one musician in the band -- it can hold the parts for ALL the musicians playing a particular song.

**The JavaSound API**
JavaSound is a collection of classes and interfaces added to Java starting with version 1.3. These aren't special add-ons, they're part of the standard J2SE class libraray. JavaSound is split into two parts : MIDI and Sampled. We use only MIDI here.

## How to Make Sound using JavaSound API?

Sequencer --plays--> Sequence --has a--> track --holds--> MidiEvents

Seqeunecer -> CD player

Seqeunce -> CD

Track -> Song

MidiEvents -> The components of the songs
