# guess

This is a lab for a "Guess My Number" game. A partial implementation is already given. Your task is to complete the game.

## Mechanics

When the game loads, the computer has generated a random integer between 1 and 10, inclusive. There is a number input box and a button provided for the user to guess the computer's chosen number. When the button is clicked, the user's current guess is evaluated. Currently, the evaluation code adds the user's latest guess to a vector containing the history of guesses, but does not make a determination if the user is correct. The following tasks should be attempted by the student:

* Evaluate the guess to determine if the user has won
* If the user's guess is correct:
  * Display a message to the user so they know the won!
  * Disable the button that allows them to continue guessing
  * Display a button that gives the user the opportunity to Play Again
    * If the Play Again button is clicked:
      * Re-enable the guessing button
      * Replace the number to be guessed
      * Empty the vector of guesses
      * Hide the Play Again button
* Limit the number of guesses the user is allowed to make before declaring a loss and ending the game
* Keep track of the "high score" (the lowest number of guesses resulting in a win)

## Setup

To get an interactive development environment run:

    rlwrap lein figwheel

and open your browser at [localhost:3449](http://localhost:3449/).
This will auto compile and send all changes to the browser without the
need to reload. After the compilation process is complete, you will
get a Browser Connected REPL. An easy way to try it is:

    (js/alert "Am I connected?")

and you should see an alert in the browser window.

To clean all compiled files:

    lein clean

To create a production build run:

    lein do clean, cljsbuild once min

And open your browser in `resources/public/index.html`. You will not
get live reloading, nor a REPL. 

## Alternative for Emacs + Cider 

This application is setup to work with cider-mode. Open **core.cljs** and type `C-c M-J` to launch both a Clojure REPL and ClojureScript REPL. This takes the place of running `lein figwheel` from the command line.

## License

Copyright © 2016 Point Slope, LLC

Distributed under the Eclipse Public License either version 1.0 or (at your option) any later version.
