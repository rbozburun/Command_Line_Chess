package Chess;
/* It is abstract because actually there is no special Piece object on the table. There are Pawn objects, King objects, Bishop
objects... But they inherits similar attributes (location and color) from Piece objects. Also they may be a
Piece object since they uses its attributes.
*/

public abstract class Piece {

    public int color;
    public Square location;

    // All of pieces have color and location attributes, they inherits them from Piece class.
    public Piece(int color, Square location){
        this.color = color;
        this.location = location;
        // Sets piece to location.
        this.location.setPiece(this);
    }

    public int getColor(){
        return this.color;
    }

    // Each piece have different movement rule, so they override this method.
    public abstract boolean canMove(String to);

    // Move method is same for each piece.
    public  void move(String to){
        Square targetLocation = location.getBoard().getSquareAt(to);
        targetLocation.setPiece(this);
        //clear previous location
        location.clear();
        //update current location
        location = targetLocation;
        location.getBoard().nextPlayer();
        //piece has been moved at least once
    }

    protected boolean isEnemy(Piece p) {
        return !(this.color == p.color);
    }
}
