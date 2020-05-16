package Chess;

import java.util.Arrays;

public class Rook extends  Piece{


    public Rook(int color, Square location) {
        super(color,location);
    }

    @Override
    public String toString() {
        return color == 0 ? "R":"r";
    }

    @Override
    public boolean canMove(String to) {

        boolean validMove = false;
       Square targetLocation = location.getBoard().getSquareAt(to);
       Square [] between = location.getBoard().getSquaresBetween(location,targetLocation);

       if(location.isAtSameRow(targetLocation) || location.isAtSameColumn(targetLocation)){
           // for loop checks squares between target and target are empty
           for (int i = 0; i<between.length-1; i++){
               validMove = between[i].isEmpty();
               if(!validMove)
                   break;
           }
           if(validMove){
               if(targetLocation.getPiece() != null && targetLocation.getPiece().isEnemy(this))
                   validMove = true;

               Square[] betweenWithoutTarget = Arrays.copyOfRange(between, 1, between.length);
                int index =0;
                int i;
               for (Square square : betweenWithoutTarget){
                   validMove = square.isEmpty();
                   int [] validArray = new int[betweenWithoutTarget.length];
                   if(validMove)
                       i = 0; // 0 -> True
                   else
                       i = 1; // 1 -> False
                   validArray[index] = i;
                   index++;
                   for (int value : validArray)
                       if (value == 1) {
                           validMove = false;
                           break;
                       }
               }
           }
           return validMove;
       }
        return false;
    }

}
