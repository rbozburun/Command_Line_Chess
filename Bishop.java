package Chess;

public class Bishop extends Piece{
    public Bishop(int color, Square location) {
        super(color,location);
    }

    @Override
    public boolean canMove(String to) {
        boolean validMove = false;
        Square targetLocation = location.getBoard().getSquareAt(to);
        Square [] between = location.getBoard().getSquaresBetween(location,targetLocation);
        if(this.location.isAtSameDiagonal(targetLocation)){
            // for loop checks squares between target and initial location are empty
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
        return color == 0 ? "B":"b";
    }
}
