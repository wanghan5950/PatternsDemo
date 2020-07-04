package com.example.patterns.memorandum;

public class Client {

    public static void main(String[] args) {
        Game game = new Game();
        game.play();

        Caretaker caretaker = new Caretaker();
        caretaker.saveMemo(game.createMemo());

        game.quit();

        Game restoreGame = new Game();
        restoreGame.restore(caretaker.getMemo());
        restoreGame.play();
    }
}
