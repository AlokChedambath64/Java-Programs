public class inter {
    public static void main(String args[]){
        Queen obj1 = new Queen();
        Rook obj2 = new Rook();
        King obj3 = new King();
        Bishop obj4 = new Bishop();
        Knight obj5 = new Knight();

        obj1.moves();
        obj2.moves();
        obj3.moves();
        obj4.moves();
        obj5.moves();
    }
}

interface ChessPlayer{
    void moves();
}

class Queen implements ChessPlayer{
    public void moves(){
        System.out.println("All Directions");
    }
}

class Rook implements ChessPlayer{
    public void moves(){
        System.out.println("Horizontal and Vertical");
    }
}

class Bishop implements ChessPlayer{

    public void moves(){
        System.out.println("Horizontal");
    }
}

class Knight implements ChessPlayer{
    public void moves(){
        System.out.println("L- Shape");
    }
}

class King implements ChessPlayer{
    public void moves(){
        System.out.println("One step in each direction");
    }
}
