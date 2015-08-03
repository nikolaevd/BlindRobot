
package blindrobot;

public class BlindRobot {
    
    public enum Course {SOUTH, WEST, NORTH, EAST, DONE};
    
    public void makeMove(Course selectedCourse){
        if(selectedCourse == Course.NORTH){
            System.out.println("Идем на север!");
        }
        else if(selectedCourse == Course.WEST){
            
        }
        else if(selectedCourse == Course.SOUTH){
            
        }
        else if(selectedCourse == Course.EAST){
            
        }
        else if(selectedCourse == Course.DONE){
            
        }
        else{
            System.out.println("Идем в закат!");
        }
    }
    
}
