public class Snake extends Monster {

    
    public Snake() {
	super();
	hp = 50;
	speed = 20;
	damage = 15;
	image = new String[][]{  
	    {" ","_","_","_","_","_","_"," "," "," "," " },
	    { "<"," ","."," "," ","."," ",">"," "," "," " },
	    { " ","\\"," ",".","."," ","/"," ","|"," "," " },
	    { " "," ","\\","_","_","/","|"," ","|"," "," "},
	    { " "," ","_","_","|","/"," ","/"," "," "," " },
	    { " "," ","\\"," ","^"," ","/","_","_","_","_" },
	    { " "," "," ","\\","_","_","_","_","_","_","/" }
	};
	//stuff to add

    }

    public int attack() { //stuff to add
	return 0;
    }
}