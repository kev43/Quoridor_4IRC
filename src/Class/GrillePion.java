package Class;
import java.util.ArrayList;


public class GrillePion extends AbstractGrille{
	
	public GrillePion() {
		super(new ArrayList<Pion>());
	}

	public boolean isAddOk(Coordonnees coord){
		boolean validX, validY;
		validX = (coord.getX() >= 0 && coord.getX() < 9);
		validY = (coord.getY() >= 0 && coord.getY() < 9);

		return validX && validY;
	}
}
