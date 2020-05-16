package Chess;

public class King extends Piece{

    public King(int color, Square location) {
        super(color,location);
    }

    @Override
    public String toString() {
        return color == 0 ? "K":"k";
    }

    // Same with Queen, King can move only diagonal, vertical and horizontal. But for only 1 square.
    @Override
    public boolean canMove(String to) {
        boolean validMove;
        Square targetLocation = location.getBoard().getSquareAt(to);
        Square[] between = location.getBoard().getSquaresBetween(location,targetLocation);
        validMove = targetLocation.isEmpty() && between.length == 1;
        if(!validMove && between.length == 1){
            if(targetLocation.getPiece() != null && targetLocation.getPiece().isEnemy(this))
                validMove = true;
        }

        return validMove;
    }


}
