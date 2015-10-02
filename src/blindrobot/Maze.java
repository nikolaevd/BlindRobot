
package blindrobot;

import java.util.ArrayList;
import java.util.LinkedList;

public final class Maze {
    
    private final int height;
    private final int width;
    
    private final Cell[][] maze;
    
    private Cell currentCell;
    private Cell nextCell;
    
    private ArrayList<Cell> unvisitedCells;
    private ArrayList<Cell> neighbours;
    private LinkedList<Cell> stack;
        
    public Maze(int height, int width) {
        this.height = height;
        this.width = width;
        maze = new Cell[height][width];
        setCellsField(height, width);
        initializeUnvisitedCells();  
        generateMaze();
    }
      
    private void setCellsField(int height, int width) {
        for(int i = 0; i < height; i++) {
            for(int j = 0; j < width; j++) {
                if((i % 2 != 0  && j % 2 != 0) && (i < height-1 && j < width-1)) {
                    maze[i][j] = new Cell(j, i, "EMPTY");
                }
                else {
                    maze[i][j] = new Cell(j, i, "BLOCKED");
                }         
            }
        }
    }
    
    // TO DO
    // Метод должен быть public и возвращать значение
    private void initializeUnvisitedCells() {
        unvisitedCells = new ArrayList<>();
       
        for(int i = 1; i < height-1; i++) {
            for(int j = 1; j < width-1; j++) {
                if(maze[i][j].getBlockedState().equals("EMPTY")) {
                    unvisitedCells.add(maze[i][j]);
                }
            }
        }
    } 
    
    private void generateMaze() {        
        stack = new LinkedList<>();
        setCurrentCell(maze[1][1]);
        
        while(!unvisitedCells.isEmpty()) {
            neighbours = getNeighbours(currentCell);
            if(!neighbours.isEmpty()){
                stack.push(currentCell);
                nextCell = getRandomCell(neighbours);
                removeWall(currentCell, nextCell);
                setCurrentCell(nextCell);
            }            
            else if(!stack.isEmpty()) {
                setCurrentCell(stack.pop());
            }
            else {
                setCurrentCell(getRandomCell(unvisitedCells));
            }
        }     
    }
    
    private void setCurrentCell(Cell c) {
        currentCell = c;
        if(unvisitedCells.contains(c)){
            unvisitedCells.remove(c);
        }   
    }
     
    private ArrayList<Cell> getNeighbours(Cell c) {     
        ArrayList<Cell> cells = new ArrayList<>();
        
        int x = c.getX();
        int y = c.getY();        
                
        if(y+2 < this.height) {
            if(unvisitedCells.contains(maze[y+2][x])) cells.add(maze[y+2][x]);
        }
        if(y-2 > 0) {
            if(unvisitedCells.contains(maze[y-2][x])) cells.add(maze[y-2][x]);
        }
        if(x+2 < this.width) {
            if(unvisitedCells.contains(maze[y][x+2])) cells.add(maze[y][x+2]);
        }
        if(x-2 > 0) {
            if(unvisitedCells.contains(maze[y][x-2])) cells.add(maze[y][x-2]);
        }
        
        return cells;          
    }
    
    private Cell getRandomCell (ArrayList<Cell> cells) {        
        int randomIndex = (int) (Math.random() * cells.size());
        Cell randomCell = cells.get(randomIndex);
        return randomCell;
    }
    
    private void removeWall(Cell currentCell, Cell nextCell) {
        int x = currentCell.getX();        
        int y = currentCell.getY();
                
        if(currentCell.getX() < nextCell.getX()) {
            x = currentCell.getX()+1;
        }
        if(currentCell.getX() > nextCell.getX()) {
            x = currentCell.getX()-1;
        }
        if(currentCell.getY() < nextCell.getY()) {
            y = currentCell.getY()+1;
        }
        if(currentCell.getY() > nextCell.getY()) {
            y = currentCell.getY()-1;
        }
        
        maze[y][x].setBlockedState("EMPTY");
    }
    
    public int getHeigth() {
        return height;
    }
    
    public int getWidth() {
        return width;
    }
    
    public String checkState(int y, int x) {
        return maze[y][x].getBlockedState();
    }
   
    public void printMaze() {
        for(int i = 0; i < height; i++) {
            for(int j = 0; j < width; j++) {
                System.out.print(maze[i][j].getBlockedState() + " ");
            }
            System.out.println();
        }
    }
    
}
