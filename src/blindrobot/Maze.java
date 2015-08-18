
package blindrobot;

import java.util.ArrayList;
import java.util.LinkedList;

public final class Maze {
    private final int height;
    private final int width;
    private int numOfUnvisitedCells;
    private final Cell[][] maze;
    private Cell currentCell;
    private Cell nextCell;
    private final LinkedList<Cell> stack = new LinkedList<>();
    
    public Maze(int height, int width) {
        this.height = height;
        this.width = width;
        maze = new Cell[height][width];
        buildField(height, width);
        
        numOfUnvisitedCells = getUnvisitedCells().size();
        setCurrentCell(maze[1][1]);

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
        while(numOfUnvisitedCells > 0) {
            if(getRandomNeighbour(currentCell) != null) {
                stack.push(currentCell);
                nextCell = getRandomNeighbour(currentCell);
                removeWall(currentCell, nextCell);
                setCurrentCell(nextCell);
            }
            else if(!stack.isEmpty()) {
                setCurrentCell(stack.pop());
            }
            else {
                setCurrentCell(getRandomUnvisitedCell());
            }
        }     
    }
    
    private void setCurrentCell(Cell c) {
        currentCell = c;
        c.setVisitedState(true);
        numOfUnvisitedCells--;
    }
    
    private ArrayList<Cell> getUnvisitedCells() {
        ArrayList<Cell> unvisitedCells;
        unvisitedCells = new ArrayList<>();
        for(int i = 0; i < height; i++) {
            for(int j = 0; j < width; j++) {
                if(!maze[i][j].getVisitedState() && maze[i][j].getBlockedState().equals("O")) {
                    unvisitedCells.add(maze[i][j]);
                }
            }
        }
        return unvisitedCells;
    }
    
    private Cell getRandomUnvisitedCell(){
        ArrayList<Cell> unvisitedCells;
        unvisitedCells = getUnvisitedCells();
        int randomIndex = (int) (Math.random() * unvisitedCells.size());
        Cell randomUnvisitedCell = unvisitedCells.get(randomIndex);
        return randomUnvisitedCell;
    }
    
    
    private Cell getRandomNeighbour(Cell c) {
        ArrayList<Cell> neighbours;     
        neighbours = new ArrayList<>();
        
        int randomIndex;
        int x = c.getX();
        int y = c.getY();
        
        if(y+2 < this.height) {
            if(!maze[x][y+2].getVisitedState()) neighbours.add(maze[x][y+2]);
        }
        if(y-2 > 0) {
            if(!maze[x][y-2].getVisitedState()) neighbours.add(maze[x][y-2]);
        }
        if(x+2 < this.width) {
            if(!maze[x+2][y].getVisitedState()) neighbours.add(maze[x+2][y]);
        }
        if(x-2 > 0) {
            if(!maze[x-2][y].getVisitedState()) neighbours.add(maze[x-2][y]);
        }
        
        if(!neighbours.isEmpty()) {
            randomIndex = (int) (Math.random() * neighbours.size());    
            return neighbours.get(randomIndex);
        }
        
        return null;            
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
        maze[x][y].setVisitedState(true);
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
    
    public void printVisitedCells() {
        System.out.println("Ячейки со следующими координатами были посещены: ");
        for(int i = 0; i < height; i++) {
            for(int j = 0; j < width; j++) {
                if(maze[i][j].getVisitedState()) {
                    System.out.println("x = " + maze[i][j].getX() + ", y = " + maze[i][j].getY());
                }
            }
        }
    }
    
}
