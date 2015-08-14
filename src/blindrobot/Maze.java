
package blindrobot;

import java.util.ArrayList;

public final class Maze {
    private final int height;
    private final int width;
    private final Cell[][] maze;
    private Cell currentCell;
    private Cell nextCell;
    
    public Maze(int height, int width){
        this.height = height;
        this.width = width;
        maze = new Cell[height][width];
        buildField(height, width);
        generateMaze();
    }
      
    private void buildField(int height, int width){
        for(int i = 0; i < height; i++){
            for(int j = 0; j < width; j++){
                if((i % 2 != 0  && j % 2 != 0) && (i < height-1 && j < width-1)){
                    maze[i][j] = new Cell(j, i, "EMPTY");
                }
                else{
                    maze[i][j] = new Cell(j, i, "BLOCKED");
                }         
            }
        }
    }
    
    private void generateMaze(){
        setCurrentCell(maze[1][1]);
        getUnvisitedCells();
//        while(unvisitedCells > 0){
//            if(getRandomNeighbour(currentCell) != null){
//                
//            }
//        }
        nextCell = getRandomNeighbour(currentCell);
        
        while(nextCell != null){
            removeWall(currentCell, nextCell);
            setCurrentCell(nextCell);
            nextCell = getRandomNeighbour(currentCell);
        }
    }
    
    private void setCurrentCell(Cell c){
        currentCell = c;
        c.setIsVisited(true);
    }
    
    private int getUnvisitedCells(){
        int unvisitedCells = 0;
        
        for(int i = 0; i < height; i++){
            for(int j = 0; j < width; j++){
                if(!maze[i][j].getIsVisited() && maze[i][j].getState().equals("EMPTY")){
                    unvisitedCells++;
                }
            }
        }
        return unvisitedCells;
    }
    
    private Cell getRandomNeighbour(Cell c){
        
        ArrayList<Cell> neighbours;     
        neighbours = new ArrayList<>();
        
        int randomIndex;
        int x = c.getX();
        int y = c.getY();
        
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
        
        if(!neighbours.isEmpty()){
            randomIndex = (int) (Math.random() * neighbours.size());    
            return neighbours.get(randomIndex);
        }
        
        return null;
            
    }
    
    private void removeWall(Cell currentCell, Cell nextCell){
        int x = currentCell.getX();
        int y = currentCell.getY();
        
        if(currentCell.getX() < nextCell.getX()){
            x = nextCell.getX() - currentCell.getX();
        }
        if(currentCell.getX() > nextCell.getX()){
            x = currentCell.getX() - nextCell.getX();
        }
        if(currentCell.getY() < nextCell.getY()){
            y = nextCell.getY() - currentCell.getY();
        }
        if(currentCell.getY() > nextCell.getY()){
            y = currentCell.getY() - nextCell.getY();
        }
        
        maze[x][y].setState("EMPTY");
        maze[x][y].setIsVisited(true);
    }
    
    public int getHeigth(){
        return height;
    }
    
    public int getWidth(){
        return width;
    }
    
    public String checkState(int x, int y){
        return maze[x][y].getState();
    }
   
    public void printMaze(){
        for(int i = 0; i < height; i++){
            for(int j = 0; j < width; j++){
                System.out.print(maze[i][j].getState() + " ");
            }
            System.out.println();
        }
    }
    
    public void printVisitedCells(){
        System.out.println("Ячейки со следующими координатами были посещены: ");
        for(int i = 0; i < height; i++){
            for(int j = 0; j < width; j++){
                if(maze[i][j].getIsVisited()){
                    System.out.println("x = " + maze[i][j].getX() + ", y = " + maze[i][j].getY());
                }
            }
        }
    }
    
}
