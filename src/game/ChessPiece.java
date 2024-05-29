package game;

import board.Piece;
import board.Board;
import game.Color;

public class ChessPiece extends Piece {
    
    private Color color;

    public ChessPiece(Board board, Color color){
        super(board);
        this.color = color;
    }

    public Color getColor(){
        return this.color;
    }
}
