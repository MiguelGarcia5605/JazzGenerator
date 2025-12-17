# Jazz Lick Generator

This project is music generation tool intended to generate jazz licks over common jazz chord types.

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

## 📦 Dependencies

- **JMusic Library:** https://explodingart.com/jmusic/
- **Tips4Java:** https://tips4java.wordpress.com/2009/11/29/text-prompt/
-   used for simplified ghost text on JTextField objects

---

