# Game Of Life
### Description
One year ago, I stumbled across Conway's Game of Life on youtube. I thought it was a neat little simulation of cellular life.
I would find out later that these types of simulations are called cellular automata. 

After completing Chamber Crawler, I knew I wanted to try my hand at implementing Conway's Game of Life in Java. Unlike
Chamber Crawler, I wanted to give this project an actual GUI and graphics instead of printing characters repeatedly in the
console.

Conway's Game of Life is a zero-player game where an intial generation of cells is created and left to evolve. Each cell's 
state (alive or dead) is determined by four "game" rules.

### Cell Rules
* Any live cell with fewer than two live neighbours dies, as if by underpopulation.
* Any live cell with two or three live neighbours lives on to the next generation.
* Any live cell with more than three live neighbours dies, as if by overpopulation.
* Any dead cell with exactly three live neighbours becomes a live cell, as if by reproduction.

### Implementation
In my version of Conway's Game of Life, the user is able to pause the evolution at any moment. When the game is paused the
user is able to change the state of any cell in the gameboard. The user also has the ability to evolve the cells one generation
at a time by pressing the "Single Step" button. The clear button will clear the board of all existing cells.Examples of the 
game running can be seen below in the form of gifs.

### Drawing the cells of the first generation
![](drawing.gif)
### Pausing evoluton and adding more cells to current generation
![](starting.gif)
![](ending.gif)
### Gosper's Glider running in game
![](glidercreator.gif)
