
package blindrobot;

import java.util.ArrayList;

public class Maze {
    private final int height;
    private final int width;
    private Cell[][] maze;
    
    public Maze(int height, int width){
        this.height = height;
        this.width = width;
        maze = new Cell[height][width];
        makeField(height, width);
        generate();
    }
    
    private void makeField(int height, int width){
        for(int i = 0; i < height; i++){
            for(int j = 0; j < width; j++){
                if((i % 2 != 0  && j % 2 != 0) && (i < height-1 && j < width-1)){
                    maze[i][j] = new Cell(j, i, "EMPTY");
                }
                else{
                    maze[i][j] = new Cell(j, i, "WALL");
                }         
            }
        }
    }
    
    public void generate(){
        int nextX = 1;
        int nextY = 1;
        ArrayList<Cell> n = getNeighbours(nextX, nextY);
        
        while(!n.isEmpty()){
            int size = n.size();
            int index = (int) (Math.random() * size);
            
            nextX = n.get(index).getX();
            nextY = n.get(index).getY();
            
            removeWall(n, index);
            n = getNeighbours(nextX, nextY);
        }       
    }
    
    public ArrayList<Cell> getNeighbours(int x, int y){
        ArrayList<Cell> neighbours = new ArrayList<>();
        
        if(y+2 < this.height){
            if(!maze[x][y+2].getIsVisited()) neighbours.add(maze[x][y+2]);
        }
        if(y-2 > 0){
            if(!maze[x][y-2].getIsVisited()) neighbours.add(maze[x][y-2]);
        }
        if(x+2 < this.width){
            if(!maze[x+2][y].getIsVisited()) neighbours.add(maze[x+2][y]);
        }
        if(x-2 > 0){
            if(!maze[x-2][y].getIsVisited()) neighbours.add(maze[x-2][y]);
        }
        
        return neighbours;
            
    }
    
    public void removeWall(ArrayList<Cell> neighbours, int index){
        neighbours.get(index).setState("EMPTY");
        neighbours.get(index).setIsVisited(true);
    }
    
    public void printMaze(){
        for(int i = 0; i < height; i++){
            for(int j = 0; j < width; j++){
                System.out.print(maze[i][j].getState() + " ");
            }
            System.out.println();
        }
    }
    
}
