package Chess;

public class Pawn extends Piece{
    public static boolean  initialLocation = true;
    public static int count = 0;

    public Pawn(int color, Square location) {
        super(color,location);
    }

    @Override
    public boolean canMove(String to) {

        boolean validMove = false;
        Square targetLocation = location.getBoard().getSquareAt(to);
        int rowDistance = targetLocation.getRowDistance(location,this.color);
        if (this.location.isAtSameColumn(targetLocation)){
            if(color == ChessBoard.WHITE && rowDistance > 0 && rowDistance <= 2){
                if(rowDistance == 2){
                    if(initialLocation){
                        // Pawn is moving TWICE. Check two squares in front of are empty.
                        Square[] between = location.getBoard().getSquaresBetween(location,targetLocation);
                        validMove = targetLocation.isEmpty() && between[0].isEmpty();
                    }
                } else{
                    validMove =targetLocation.isEmpty();
                }
                return validMove;
            }else if( color == ChessBoard.BLACK && rowDistance < 0 && rowDistance >= -2){
                if(rowDistance == -2){
                    if(initialLocation){
                        // Pawn is moving TWICE. Check two squares in front of are empty.
                        Square[] between = location.getBoard().getSquaresBetween(location,targetLocation);
                        validMove = targetLocation.isEmpty() && between[0].isEmpty();
                    }
                }else{
                    validMove = targetLocation.isEmpty();
                }
            }
        // if the target column is not at the same column, it should be a neighbour column
        }else if(this.location.isNeighbourColumn(targetLocation)){
            // pawn only move forward diagonals if there is an oppenen there (attack)
            if(color == ChessBoard.WHITE && rowDistance == 1){
                validMove = !targetLocation.isEmpty() && targetLocation.getPiece().getColor() == ChessBoard.BLACK;
            }else if (color == ChessBoard.BLACK && rowDistance == -1){
                validMove = !targetLocation.isEmpty() && targetLocation.getPiece().getColor() == ChessBoard.WHITE;
            }
        }

        return validMove;
    }

    @Override
    public void move(String to) {
        Square targetLocation = location.getBoard().getSquareAt(to);
        //promoteToQueen
        if (targetLocation.isAtLastRow(color)) {
            targetLocation.putNewQueen(color);
        }else{
            targetLocation.setPiece(this);
        }
        //clear previous location
        location.clear();
        //update current location
        location = targetLocation;
        location.getBoard().nextPlayer();
        //piece has been moved at least once
        count++;
        if (count > 1)
            initialLocation = false;
    }

    @Override
    public String toString() {
        return color == 0 ? "P":"p";
    }
}
