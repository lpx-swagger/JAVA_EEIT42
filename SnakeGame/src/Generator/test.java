// 鍵盤監聽事件:按鍵控制遊戲是否開始
@Override
public void keyPressed(KeyEvent e) {
        // TODO Auto-generated method stub
	// 鍵盤按下未釋放
        int keyCode = e.getKeyCode();
	if (keyCode == KeyEvent.VK_SPACE) {
	if (isOver) {// 當遊戲失敗時重新開始遊戲
		isOver = false;
		Init();	
		// new GamePanel();//重新進入遊戲
	} else {// 當遊戲為結束時，按下空格鍵暫停遊戲
 		// 如果按下空格鍵
		isStart = !isStart;// 控制遊戲開關取反
	}
	repaint();// 重新繪製介面
	}

	// 按鍵上下左右控制貪吃蛇的頭部方向
	if (keyCode == KeyEvent.VK_RIGHT) {
	if (dir.equals("L") == false) {
		dir = "R";// 如果蛇當前移動的方向不是向左時，則可以向右移動
	}
	} else if (keyCode == KeyEvent.VK_DOWN) {
		if (dir.equals("U") == false) {
		dir = "D";// 如果蛇當前移動的方向不是向上時，則可以向下移動
	}
	} else if (keyCode == KeyEvent.VK_LEFT) {
		if (dir.equals("R") == false) {
		dir = "L";// 如果蛇當前移動的方向不是向右時，則可以向左移動
	}
	} else if (keyCode == KeyEvent.VK_UP) {
		if (dir.equals("D") == false) {
			dir = "U";// 如果蛇當前移動的方向不是向右時，則可以向左移動
		}
	}
}


@Override
public void keyTyped(KeyEvent e) {
}
 
@Override
public void keyReleased(KeyEvent e) {
}
 
// 定時器執行的操作
@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	// 如果遊戲處於開始狀態，並且沒有結束，則蛇可以移動
	if (isStart == true && isOver == false) {
	// 右移：讓後一個移到前一個的位置即可
	for (int i = len - 1; i > 0; i--) {
		snakeX[i] = snakeX[i - 1];
		snakeY[i] = snakeY[i - 1];
	}

	// 貪吃蛇頭部按照按鍵控制的方向移動
	if (dir.equals("R")) {
		snakeX[0] = snakeX[0] + 25;// 蛇頭向右移動一個單位：25為一個單位
	if (snakeX[0] >= 850) {
		// snakeX[0] = 50;//如果蛇頭超出有邊界則貪吃蛇從牆的左邊出來
		isOver = true;// 貪吃蛇撞牆，遊戲失敗
	}
	
	} else if (dir.equals("D")) {// 蛇頭向下移動一個單位
		snakeY[0] = snakeY[0] + 25;
		if (snakeY[0] >= 725) {
	 	// snakeY[0] = 100;//如果蛇頭超出有邊界則貪吃蛇從牆的上邊出來
	 	isOver = true;// 貪吃蛇撞牆，遊戲失敗
		}
	} else if (dir.equals("L")) {// 蛇頭向左移動一個單位
		snakeX[0] = snakeX[0] - 25;
		if (snakeX[0] <= 25) {
	 		// snakeX[0] = 850;//如果蛇頭超出有邊界則貪吃蛇從牆的右邊出來
			isOver = true;// 貪吃蛇撞牆，遊戲失敗
		}
	} else if (dir.equals("U")) {// 蛇頭向上移動一個單位
		snakeY[0] = snakeY[0] - 25;
		if (snakeY[0] <= 75) {
	 	// snakeY[0] = 725;//如果蛇頭超出有邊界則貪吃蛇從牆的下邊出來
	 	isOver = true;// 貪吃蛇撞牆，遊戲失敗
		}
	}
