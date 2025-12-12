# 🎷 Jazz Lick Generator

A Java-based tool that generates original jazz licks from user-provided chord progressions. The program outputs a MIDI file and uses the **JMusic** library for MIDI creation and manipulation.

## 📘 Concept

This project creates a melodic jazz phrase (a “lick”) using a chord progression consisting of:

- Major 7
- Minor 7
- Dominant 7
- Dominant 7 (♭9)
- Half-diminished 7

Chords can be placed only on beats **1** and **3**.  
Once the progression is submitted, the program constructs a unique lick using melodic cells, scale logic, rhythm variations, and controlled randomness.

## 🧱 Project Structure

### **LickGenerator**
- Core class responsible for generating the full lick.
- Combines MelodicCells, Scales, and random number logic.

### **MelodicCell**
- Small musical “vocabulary” unit tied to a specific chord.
- Contains: note, rhythm, length, and chord context.
- Used as building blocks for entire phrases.

### **Scales**
- Stores scale note values used when adding scalar motion.

### **UserInterface**
- Handles input from the user.
- Provides a simple and minimal GUI.

## 🎼 Lick Generation Algorithm

1. Build a basic lick using chord-tone MelodicCells.
2. Add scalar motion using the Scales class.
3. Modify rhythms using a rhythm-pattern database.
4. Add chromatic passing tones where musically appropriate.
5. Remove selected notes to create phrasing and breathing space.

## 📦 Dependencies

- **JMusic Library:** https://explodingart.com/jmusic/

---

