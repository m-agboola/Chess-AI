# Chess-AI
A Chess Engine using Minimax Algorithm with Alpha Beta Pruning

###### Motivation
The aim of starting this project is to learn Java while working on something challenging yet fun. 
Code quality and readability is my main focus for now. As this is a continuous project, performance and optimizations will be improved upon with time.

###### How it works
The computer player uses the minimax strategy with alpha-beta pruning for generating and deciding moves. It explores all possible moves, then explores their possible moves and so on. This essentially creates a search tree to a depth of 3. The best move is decided by evaluating the 'score' of the board. Zobrist hashing is used to store best moves for previously evaluated position and really speed up move generations.

A graphical representation of the board is rendered with a side menu with contextual tips, that displays useful information such as whose turn it is, if the move you're attempting is invalid, if someone is in check, among other things. The mouse is used to select pieces and move them. The program only allows you to make valid moves according to the rules of chess, and also includes the special moves: castling, and promotion. The program automatically detects check and checkmate, and for the latter, ends the game and declares the winner.
