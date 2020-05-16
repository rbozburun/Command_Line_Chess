package Chess;

public class Square {
    // Square object have row and col attributes, also it may be have Piece.
    public Piece piece;
    int row;
    int col;
    ChessBoard boardClass;


    public Square(int row, int col, ChessBoard boardClass) {
        this.row = row;
        this.col = col;
        this.boardClass = boardClass;

    }

    @Override
    public String toString() {
        return this.piece == null ? " ": this.piece.toString();
    }

    public void setPiece(Piece piece) {
        // If square has a piece, this means there is attacking. So that, I will decrement pieces number.
        if(this.piece != null){
            boardClass.decrementPiece(this.piece.getColor());
        }
        this.piece = piece;
    }

    public ChessBoard getBoard() {
        return this.boardClass;
    }

    public int getRowDistance(Square location, int color) {

        return color == ChessBoard.WHITE ? Math.abs(this.row - location.row) : location.row - this.row;
    }

    public boolean isAtSameColumn(Square targetLocation) {
        return this.col == targetLocation.col;
    }

    public boolean isAtSameDiagonal(Square targetLocation) {
        return (Math.abs(this.row - targetLocation.row  ) == Math.abs(this.col - targetLocation.col));
    }

    public boolean isAtSameRow(Square targetLocation) {
        return this.row == targetLocation.row;
    }

    public boolean isEmpty() {
        return this.piece == null;
    }

    public boolean isNeighbourColumn(Square targetLocation) {
        return Math.abs(this.col - targetLocation.col) == 1;
    }

    public Piece getPiece() {
        return this.piece;
    }

    public boolean isAtLastRow(int color) {
        return ((color == ChessBoard.WHITE) ? (this.row == 0) : (this.row == 7));
    }

    // sets piece to Queen
    public void putNewQueen(int color) {
        this.piece = new Queen(color,this);
    }

    public void clear() {
        this.piece = null;
    }
}
