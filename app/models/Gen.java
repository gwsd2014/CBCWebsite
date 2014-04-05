package models;

import generator.Control;
import generator.ProblemType;
import generator.Question;
import play.db.ebean.Model;

public class Gen extends Model {
    
    /**
     * 
	 */
	private static final long serialVersionUID = 1L;

	public Gen(){        
    }
    
    public static Question createProblem(int level, int weight){
        return Control.run(1, 2, ProblemType.MULTI_CHOICE);
    }

}