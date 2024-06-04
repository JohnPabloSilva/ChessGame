package chess;

import board.Piece;
import board.Position;
import board.Board;

public abstract class ChessPiece extends Piece {
    
    private Color color;
    private int moveCount;

    public ChessPiece(Board board, Color color){
        super(board);
        this.color = color;
    }

    public Color getColor(){
        return this.color;
    }

    public ChessPosition getChessPosition(){
        return ChessPosition.fromPosition(position);
    }

    protected boolean isThereOpponentPiece(Position position){

        ChessPiece p = (ChessPiece)getBoard().piece(position);
        return p != null && p.getColor() != color;

    }

    protected void increaseMoveCount(){
        moveCount ++;
    }

    protected void decreaseMoveCount(){
        moveCount --;
    }

    public int getMoveCount(){
        return moveCount;
    }


}
