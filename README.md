### ColorSwitch

#Details

Created by: Shruti Jha and Abhinav Gudipati

This is a clone of the video game, Color Switch, originally developed by Fortafy Games.

A working demo of the game can be seen here.

Made as the course project in Advanced Programming course at IIIT-Delhi.

Uses **Java** and **JavaFx**.

#Features and Implementation

 1) Main Menu: Used to start new game, or load any saved game, to open game rules/instructions, to open leaderboard for highest score, and
 to select day/night mode.
 2) On starting a new game, player is taken to the game screen, with different kind of multi-colored obstacles containing stars.
 3) On loading a saved game, player is taken to the game screen with the player ball and obstacles at exact positions where game was left.
 4) Game screen: Contains current score, stars collected, and highest score, obstacles and player ball.
 5) Star collection : Each time the player collides with a star, it is added to the player’s star count for that particular game, and score is
 incremented by 1.
 6) Game screen has 3 levels with obstacles of increasing difficulty based on player’s score:
 a) Scenes Easy - 6 obstacles : Circle , Square , Rhombus , Vertical Lines , Horizontal Lines , Plus Sign
 b) Scenes Medium - 6 Obstacles : Concentric Circles (2) , Concentric Squares (2) , Concentric Rhombuses (2) , Vertical Lines ,
 Horizontal Lines , Plus Sign
 c) Scenes Difficult - 6 Obstacles : Concentric Circles (3) , Concentric Squares (3) , Horizontal Lines ( 3 ) , Vertical Lines , Horizontal
 Lines ( 2 parallel lines ) , Plus Sign
 7) Pause Menu: Player can press ‘P’ to pause game at any time. Option available in pause menu are: resume game, restart game, to open
 game rules/instructions, and exit to main menu.
 8) Save Game and Restart Game options : Player can save multiple game states. Player can also restart the same game at any point of time.
 9) Game End Alert Box: On collision with an obstacle of color other than that of player, the game end alert box is thrown with following
 options: resurrect, restart game, open game rules/instructions, and exit to main menu.
 10) Resurrection: Player can resurrect if number of starts collected >=10, and a new game with same score but 10 stars deducted would be
 started.

