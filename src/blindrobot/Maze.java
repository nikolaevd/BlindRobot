
package blindrobot;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Iterator;

public final class Maze {
    private final int height;
    private final int width;
    private final Cell[][] maze;
    private Cell currentCell;
    private Cell nextCell;
    private final ArrayList<Cell> unvisitedCells;
    private LinkedList<Cell> stack;
    private ArrayList<Cell> neighbours;
    
    public Maze(int height, int width) {
        this.height = height;
        this.width = width;
        maze = new Cell[height][width];
        buildField(height, width);
        unvisitedCells = getUnvisitedCells();  
        generateMaze();
    }
      
    private void buildField(int height, int width) {
        for(int i = 0; i < height; i++) {
            for(int j = 0; j < width; j++) {
                if((i % 2 != 0  && j % 2 != 0) && (i < height-1 && j < width-1)) {
                    maze[i][j] = new Cell(j, i, "O");
                }
                else {
                    maze[i][j] = new Cell(j, i, "X");
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
    
    private ArrayList<Cell> getUnvisitedCells() {
        ArrayList<Cell> cells = new ArrayList<>();
       
        for(int i = 1; i < height-1; i++) {
            for(int j = 1; j < width-1; j++) {
                if(maze[i][j].getBlockedState().equals("O")) {
                    cells.add(maze[i][j]);
                }
            }
        }
        return cells;
    }        
    
    //TO DO метод работает некорректно!
    private ArrayList<Cell> getNeighbours(Cell c) {     
        ArrayList<Cell> cells = new ArrayList<>();
        
        int x = c.getX();
        int y = c.getY();
        
        if(y+2 < this.height) {
            if(unvisitedCells.contains(maze[x][y+2])) cells.add(maze[x][y+2]);
        }
        if(y-2 > 0) {
            if(unvisitedCells.contains(maze[x][y-2])) cells.add(maze[x][y-2]);
        }
        if(x+2 < this.width) {
            if(unvisitedCells.contains(maze[x+2][y])) cells.add(maze[x+2][y]);
        }
        if(x-2 > 0) {
            if(unvisitedCells.contains(maze[x-2][y])) cells.add(maze[x-2][y]);
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
            x = nextCell.getX() - currentCell.getX();
        }
        if(currentCell.getX() > nextCell.getX()) {
            x = currentCell.getX() - nextCell.getX();
        }
        if(currentCell.getY() < nextCell.getY()) {
            y = nextCell.getY() - currentCell.getY();
        }
        if(currentCell.getY() > nextCell.getY()) {
            y = currentCell.getY() - nextCell.getY();
        }
        
        maze[x][y].setBlockedState("O");
    }
    
    public int getHeigth() {
        return height;
    }
    
    public int getWidth() {
        return width;
    }
    
    public String checkState(int x, int y) {
        return maze[x][y].getBlockedState();
    }
   
    public void printMaze() {
        for(int i = 0; i < height; i++) {
            for(int j = 0; j < width; j++) {
                System.out.print(maze[i][j].getBlockedState() + " ");
            }
            System.out.println();
        }
    }
    
    public void printUnvisitedCells() {
        for(Iterator i = unvisitedCells.iterator(); i.hasNext();){
            Cell cell = (Cell) i.next();
            System.out.println("x = " + cell.getX() + " , y = " + cell.getY());
        }
    }
    
}
