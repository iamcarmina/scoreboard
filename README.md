# scoreboard
Coding Exercise

This is a simple library implementation of a Football World Cup Score Board. 

The implementation is done in a simple Java application. 

A Match can be of different sports such as Football, Basketball, Baseball, Tennis, etc. A match consist of two Teams with a score and a name. For now it's only limited to these two properties but other information such as no. of players, date the team created, etc. may be added as needed.

IScoreBoard is a generic interface with Match type parameter. This will give the implementing class a freedom to implement the provided interface. As for the case of this coding exercise, I can only think of adding a new match, update the score of the match, finish a match and summarize the match. 

Since there is no database or backend storage for the records of matches, an ArrayList is used. ScoreBoard is initialized with an empty collection of matches and a matchId is assigned to be able to update the scores of each match based on the ID. Additional information is added such as start and end datetime of the match as well as a boolean flag for match that has ended.

App.java is where all the interface methods are put into use, following the coding exercise checklist.

1. When creating a game or match, each team (home & away) is initialized to have 0 scores. 
2. When updating a score for the specified match, an ID is passed to the updateScore(...) and the home and away scores respectively. 
3. When new game or match is added a addMatch(...) is called. In the App.java, the game start date is purposedly modified to be able to be able to comply the requirement in item #4. MatchId 6, start date is changed to be later than the matchId 7. Although in reality this should not be the case.
4. When finishing a game, it won't be removed from the collections of match but is only flagged as match has finished and an end date is set.
5. summarizeMatch() will sort the match based on the most total no. of score first, and if scores of other matches are same it will be sort based on when it was added in the scoreboard.



