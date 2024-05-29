package game;

public class App {
    public static void main(String[] args) throws Exception {

        ChessMatch cm = new ChessMatch();

        UI.printBoard(cm.getPieces());

    }

    
}
