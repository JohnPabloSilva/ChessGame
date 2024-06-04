package board;

public class Board {

    private int rows;
    private int columns;
    private Piece[][] pieces;

    public Board (int rows, int columns){
        if (rows < 1 || columns < 1){
            throw new BoardException("");
        }
        this.rows = rows;
        this.columns = columns;
        pieces = new Piece[rows][columns];
    }
    
    public int getRows(){
        return rows;
    }

    public int getColumns(){
        return columns;
    }

    public Piece piece(int row, int column){
        if (!positionExists( row, column)){
            throw new BoardException("Error creating board: there must be at least 1 row and 1 column");
        }
        return pieces[row][column];
    }

    public Piece piece(Position position){
        return pieces[position.getRow()][position.getColumn()];
    }

    public void placePiece(Piece piece, Position position){
        if (thereIsAPiece(position)){
            throw new BoardException("There is already a piece on position " + position);
        }
        pieces[position.getRow()][position.getColumn()] = piece;
        piece.position = position;
        }

    public Piece removePiece(Position pos){
        if (!positionExists(pos)){          
            throw new BoardException("Position not on the board");
        }
        if (piece(pos) == null){
            return null;
        }
        Piece aux = piece(pos);
        aux.position = null;
        pieces[pos.getRow()][pos.getColumn()] = null;
        return aux;
    }
    
    public boolean positionExists(int row, int column){
        return row >= 0 && row < this.rows && column >= 0 && column < this.columns;
    }

    public boolean positionExists(Position pos){
        return positionExists(pos.getRow(), pos.getColumn());
    }

    public boolean thereIsAPiece(Position pos){
        if (!positionExists(pos)){
            throw new BoardException("Position not on the board");
        }
            return piece(pos) != null;
    }
}
