package Generator;

// TODO 這好像是用C寫的
// 擴充功能：
	// shift => reverse
	// 斷掉地方可以穿過去
	// 撞4面牆不屎
	
//Snake game:
//Use the arrow keys to direct the snake. Press shift to reverse
//the snake's direction.


int nCols = 30;
int nRows = 30;

float columnWidth;
float rowHeight;

//Reference to snakeGame object
SnakeGame snakeGame;

//initialise key input
char nextInput = '\0';

//flag variable for game ending
boolean gameOver = false;


//start here
void setup() {
 size(300, 300);

 columnWidth = width/nCols;
 rowHeight = height/nRows;

 frameRate(25);
 ellipseMode(CORNER);

 // TEST: reverse
 // LinkedList testList = new LinkedList();
 // testList.addFront(new Node(1, 1));
 // testList.addFront(new Node(2, 2));
 // testList.addFront(new Node(3, 3));
 // testList.addFront(new Node(4, 4));
 // println(testList.toString());
 // testList.reverse();
 // println(testList.toString());

 snakeGame = new SnakeGame();
}

void draw() {
     // main loop - if game still running..
 if (!gameOver) {
     background(180, 195, 20);    // Classic yellow-green background
     // Here we display the game, update the snake's position,
     // and then check for a game over state.
     snakeGame.submitMove(nextInput);
     snakeGame.update();
     snakeGame.display();
     if (snakeGame.snake.checkCollision()) {
         gameOver = true;
         snakeGame.gameOver();
     }
     // Reset the input:
     nextInput = '\0';
             text("press Shift-key to reverse",width-180,height-10);
 } else if (nextInput == ' ') {
     // Space has been pressed, so a new game starts.
     gameOver = false;
 }
}

void keyPressed() {
 // First, we check if the key is a non-character
 // (coded) key.
 if (key == CODED) {
     // Now we check which key code and set nextInput accordingly:
     switch (keyCode) {
         case UP:
             nextInput = 'U'; // go upwards
             break;
         case DOWN:
             nextInput = 'D'; // go downwards
             break;
         case LEFT:
             nextInput = 'L'; // go left
             break;
         case RIGHT:
             nextInput = 'R'; // go right
             break;
         case SHIFT:
             nextInput = 'S'; // reverse
             break;
     }
 } else if (key == ' ') { // start again.
     nextInput = ' ';
 }
}

class SnakeGame {
 LinkedList snake;    // This list holds each of our snake's nodes

 int goalColumn;
 int goalRow;        // The position of the current goal

 int score = 0;        // The player's current score

 SnakeGame() {
     resetGame();
 }

 // resetGame creates a new snake of length 8. It also resets
 // the score, direction, and goal.
 void resetGame() {
     createSnake(8);
     score = 0;
     resetGoal();
 }

 void createSnake(int n) {
     snake = new LinkedList(); // create a doubly linked list
     if (n<1) {
         return;
     }
     snake.addFront(new Node(nRows/2, nCols/2, 0, -1));
     for (int i=0; i<n-1; i++) {
         snake.addTailNode();
     }
 }

 // Resets the position of the goal to a random location.
 void resetGoal(){
     goalColumn = floor(random(nCols));
     goalRow = floor(random(nRows));
 }

 // Displays the game over screen and resets the game.
 void gameOver() {
     textAlign(CENTER);
     textSize(20);
     text("Game over", width/2, height/2 - 20);
     textSize(18);
     text("Score: " + score, width/2, height/2);
     textSize(14);
     text("Press space bar to play again", width/2, height/2 + 15);
     resetGame();
 }

 // Checks if the head of the snake is coincident with the goal.
 boolean checkGoal(int column, int row) {
     return column == goalColumn && row == goalRow;
 }

 // Submits a players move. This should be called once before updating
 // the game, so that the latest move is registered.
 void submitMove(char move) {
     switch(move) {
         case 'U':
             snake.setDirection(0, -1);
             break;
         case 'D':
             snake.setDirection(0, 1);
             break;
         case 'L':
             snake.setDirection(-1, 0);
             break;
         case 'R':
             snake.setDirection(1, 0);
             break;
         case 'S':
             snake.reverse();
             snake.propagateDirections();
             break;
     }
 }

 // Displays the snake and the goal, and the retro overlay.
 void display() {
     snake.display();
     stroke(0);
     strokeWeight(3);
     noFill();
     ellipse(goalColumn * columnWidth, goalRow * rowHeight, columnWidth, rowHeight);

     // OPTIONAL:
     displayOverlay();
 }


     // updates the state of the snake
 void update() {
     snake.updatePositions();
     snake.propagateDirections();
     if (checkGoal(snake.currentHead().column, snake.currentHead().row)) {
         score++;
         resetGoal();
         snake.addTailNode();
     }
 }

 // OPTIONAL:
 // Here, we add code to make the game look more
 // like Snake on an old Nokia. We need to mimic the large
 // pixels of an old screen. The easiest (while not perfect)
 // way of doing this is to draw a series of vertical and
 // horizontal lines over the top of everything else.
 void displayOverlay() {
     stroke(180, 195, 20);
     strokeWeight(0.5);
     float spacing = 3;
     for (float i=0; i<width; i+=spacing) {
         line(i, 0, i, height);
     }
     for (float i=0; i<height; i+=spacing) {
         line(0, i, width, i);
     }
 }
}

//This is similar to the linked list that we've seen before,
//but this is a doubly linked list. We've included methods
//that our SnakeGame needs: addFront, removeEnd, and reverse.
class LinkedList {
 int size = 0;    // The number of Nodes in the list
 Node head;        // The first Node in the list
 Node end;        // The last Node in the list
 boolean reversed = false;

 // Adds a Node to the front of the list.
 void addFront(Node node) {
     node.next = head;
     if (size == 0) {
         end = node;
     } else {
         head.prev = node;
     }
     head = node;
     size++;
 }

 // Adds a Node to the end of the list.
 void addEnd(Node node) {
     if (size == 0) {
         head = node;
         end = node;
         return;
     }
     end.next = node;
     node.prev = end;
     end = node;
     size++;
 }

 // This method creates a new Node and places it on the beginning or
 // the end of the list, depending on the specified direction.
 void addTailNode() {
     if (!reversed && end != null) {
         addEnd(new Node(end.column - end.xDirection,
                         end.row - end.yDirection,
                         end.xDirection, end.yDirection));
     } else if (head != null) {
         addFront(new Node(head.column + head.xDirection,
                              head.row + head.yDirection, head.xDirection,
                              head.yDirection));
     }
 }

     // update the position of all the nodes in the snake
 void updatePositions() {
     Node current = head;
     while (current != null) {
         current.updatePosition(reversed);
         current = current.next;
     }
 }

 // This method propagates each Node's direction through the list. The
 // direction of propagation depends on whether the snake is going in
 // reverse.
 void propagateDirections() {
     if (!reversed) {
         // If not reversed, we iterate from end to beginning, making use
         // of the double links of our list.
         Node current = end;
         while (current != null) {
             current.updateDirection(reversed);
             current = current.prev;
         }
     } else {
         // If the snake is reversed, we need to iterate over the list from
         // beginning to end.
         Node current = head;
         while (current != null) {
             current.updateDirection(reversed);
             current = current.next;
         }
     }
 }

 Node currentHead() {
     return reversed ? end : head;
 }

 void setDirection(int xDirection, int yDirection) {
             // sets the direction of the head node
     Node currentHead = this.currentHead();
             // motion is reversed if the direction if the user has
             // used the shift key to reverse snake
     if (reversed) {
         xDirection = -xDirection;
         yDirection = -yDirection;
     }
             // update the current head direction to have the right sign
     if (currentHead.xDirection != -xDirection
                 || currentHead.yDirection != -yDirection) {
         currentHead.xDirection = xDirection;
         currentHead.yDirection = yDirection;
     }
 }

 // This method returns true if the head of the snake has collided with
 // any of the other Nodes in the snake, and false otherwise. It should
 // be called after updating the game.
 boolean checkCollision() {
             Node currentHead = this.currentHead();  // finds the current head
     //Node currentHead = reversed ? end : head; // finds the current head
     Node current = reversed ? head : end;
     while (current != currentHead) {
         if (current.row == currentHead.row && current.column == currentHead.column) {
             return true;
         }
                     // propagate in correct direction
         if (!reversed) {
             current = current.prev;
         } else {
             current = current.next;
         }
     }
     return false;
 }

 void reverse() {
     reversed = !reversed;
 }

 // Traverses through the linked list, displaying each node.
 void display() {
     Node current = head;
     while (current != null) {
         current.display();
         current = current.next;
     }
 }

 // This method concatenates the String representations of all
 // the nodes in the list, separated by commas.
 String toString() {
     if (size == 0) {
         return "";
     }
     String listString = head.toString();
     Node current = head.next;
     while (current != null) {
         listString += ", " + current.toString();
         current = current.next;
     }
     return listString;
 }
}

//Each Node object stores the column and row number
//that it currently occupies. The counting of columns/rows
//starts at 0.
class Node {
 Node prev, next;

 int column, row;
 int xDirection, yDirection;

 Node(int column, int row, int xDirection, int yDirection) {
     this.column = column;
     this.row = row;
     this.xDirection = xDirection;
     this.yDirection = yDirection;
 }

 // Displays a single node as a rectangle. The position of the node is
 // the column/row number multiplied by the width of each column/row.
 void display() {
     fill(0);
     noStroke();
     rect(column * columnWidth, row * rowHeight, columnWidth, rowHeight);
 }

 void updatePosition(boolean reversed) {
     int direction = reversed ? -1 : 1;
     column = wrap(column + direction*xDirection, nCols);
     row = wrap(row + direction*yDirection, nRows);
 }

 void updateDirection(boolean reversed) {
     if (!reversed && prev != null) {
         xDirection = prev.xDirection;
         yDirection = prev.yDirection;
     } else if (next != null) {
         xDirection = next.xDirection;
         yDirection = next.yDirection;
     }
 }

 // This method ensures that n is between 0 and max. If n is outside that
 // range, it wraps around. For example, wrap(5, 3) will return 2.
 int wrap(int n, int max) {
     n %= max;
     if (n < 0) {
         n = max + n;
     }
     return n;
 }

 // Returns a String representation of a node, which is of the form
 // (column, row).
 String toString() {
     return "(" + column + ", " + row + ")";
 }
}
