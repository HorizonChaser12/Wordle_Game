# Wordle Clone - Java Edition

A command-line implementation of the popular word-guessing game Wordle, written in Java.

## 🎮 Features

- Classic Wordle gameplay mechanics
- 6 attempts to guess the hidden 5-letter word
- Color-coded feedback system (G/Y/-)
- Input validation for word length
- Case-insensitive guesses
- Proper handling of duplicate letters
- Clear win/lose conditions

## 🕹️ How to Play

1. Guess the hidden 5-letter word in 6 tries
2. After each guess, receive feedback:
   - `G` (Green): Correct letter in correct position
   - `Y` (Yellow): Correct letter in wrong position
   - `-` (Gray): Letter not in the word
3. Use the feedback to refine subsequent guesses

## ⚙️ Installation

1. Ensure Java JDK 11+ is installed
2. Clone the repository:
   ```bash
   git clone https://github.com/your-username/wordle-clone-java.git
3. Navigate to project directory:
    ```bash
      Copy
    cd wordle-clone-java

🚀 Running the Game

Compile and run from command line:
```bash
javac WordleGame.java
java WordleGame
```

🔧 Customization

Easily modify game parameters by editing:

    CORRECT_WORD: Change the target word

    MAX_ATTEMPTS: Adjust number of allowed guesses

🤝 Contributing

Pull requests welcome! For major changes, please open an issue first to discuss proposed changes.
