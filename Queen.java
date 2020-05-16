package Chess;

public class Queen extends  Piece{
    public Queen(int color, Square location) {
        super(color,location);
    }

    @Override
    public boolean canMove(String to) {
        boolean validMove = false;
        Square targetLocation = location.getBoard().getSquareAt(to);
        Square [] between = location.getBoard().getSquaresBetween(location,targetLocation);
        // Queen can move only horizontal, vertical or diagonal. If player trying to move with different shape, it will return false.
        if(this.location.isAtSameColumn(targetLocation) || this.location.isAtSameRow(targetLocation) || this.location.isAtSameDiagonal(targetLocation)){
            for (Square square : between){
                validMove = square.isEmpty();
            }
            if(!validMove){
                if(targetLocation.getPiece() != null && targetLocation.getPiece().isEnemy(this))
                    validMove = true;
            }
            return validMove;
        }

        return false;
    }

    @Override
    public String toString() {
        return color == 0 ? "Q":"q";
    }
}
