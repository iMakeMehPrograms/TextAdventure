 + is a intersection of rooms
 | and - are walls
 : is an exit
 M is a enemy
 P is the spawnpoint
 G is the goal
 C is a chest

 This is the plan:

 Phase 1:

 Map:
 +---+---+---+
 | M : P : G |
 +---+---+---+
 Functions:
 "Look" function (This will be to see what is in the room)
  Move function
  Make a menu. #
  Make a player definition sequence. [PDS] (gender, hair color, has mullet, eye color, weirdness factor, other things that are useable but never used or are) #

  Phase 2:
  
  Map:
  +---+---+---+
  |   :   :   |
  +-:-+-:-+-:-+
  | P | M | G |
  +---+---+---+
  Functions:
  Chance Battle & Reatreat (with messages telling of player adjectives defined in the player definition sequence)

  Phase 3:

  Map:
  +---+---+---+
  | M : P | G |
  +-:-+-:-+-:-+
  | C :   | M |
  +---+-:-+-:-+
  | M :   :   |
  +---+---+---+ 
  Functions:
  Equipment
  Investigate (Find items or traps)

  Phase 4:

  Improve, change, or create another adventure in a different genre

  Documentation:

    Game.java:
  Not much to see there, just the calling and running of the game, but nothing too complicated other than the player definition sequence.

    Room.java:
  Really complicated, it basically is a database of each room's information, all completely made by me, and has a function the finds what room your in and displays all of the options in a playable way. It also contains the basic win/lose functions.

    Entity and its subclasses (child classes)
  They contain every entity in the game, including the player. Also determins the looks, quotes, health, and chances of every enemy.


  Entity ASCII Art
    
    Rad'puter
    _________
    | '80s  |
    |_______|
     /_____\ 

     Sand Worm
    /-------------(/=
    |<<<<<<<<<<<<<(}
    \-------------(\=

     Boombox
    [============]/
    | # :+::+: # |
    [============]

     L Tetrimino
     [=]
     [=][=][=]

    Twiglet
    \/\/\/
     @\/@ 
     /--\ 
     /||\ 

     Branchlet
     \|^^|/
      |:)|
      |  |
      /--\

     Tree.
    \\/||\//
     ||;)||
     ||  ||
     /\/\/\

      Metal Killer
        [_______]
    ^/==+|&`~`&|+==\^
    ||  [‾/|||\‾]  ||
    \/     | |     \/
           ! !
      

      Everything past this point is not implemented

     Spider
       ___
     _|%-%|_
     /     \

     Spider-King
       \∆__∆/
     __|%  %|__
     //|____|\\
     ||      ||

     Lenny
     ___                       ___
        \     / \  \    \     /
         \    |  \  \ / |    /
          \___\  ----/  /___/

     
    