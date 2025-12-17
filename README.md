# Jazz Lick Generator

This project is music generation tool intended to generate jazz licks over common jazz chord types.

##  Quick Guide

To generate a new lick, input a chord progression in the upper text field with slashes in between chords.
  - For example, a ii-V-I in C major would be input into the field as "Dmin7, Gdom7, Cmaj".

Then, input an output folder for the midi file generated to be stored.

Click the generate button to run the program.

The midi file is intended to be opened using a music notion software such as Musescore (not played).

## Chord Types

This project currently allows the following chord types:

- Major 7
- Minor 7
- Dominant 7

##  Lick Generation Algorithm

The program follows the following procedure to generate a jazz lick over a chord progression.

  1. Randomonly selects a cell with the matching chord type in the cell database.
  2. Transposes the selected cell to the corresponsing key center in the chord progression.
  3. Check for any adjacent duplicate notes or cells. (will replace cells that have either)
  4. Look for cells with starting notes that have a distance of 4 scale degrees. If they do, implement scalar motion between         those two cells.
  5. Use the rhythmic database to rhythmically translate each cell randomly.

##  Databases

This program uses a TextDatabase class to read .txt files as an easier way to input cell data.

## 📦 Dependencies

- **JMusic Library:** https://explodingart.com/jmusic/
  - used for musical classes and manipulation methods
- **Tips4Java:** https://tips4java.wordpress.com/2009/11/29/text-prompt/
  -   used for simplified ghost text on JTextField objects

---

