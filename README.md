# Into To ClojureScript: CLJS Labs

A series of labs by Point Slope for the Miami Clojure Meetup's Intro to ClojureScript
series.

## Getting Started

Clone our repository and navigate to one of the two exerise projects

```
git clone git@github.com:pointslope/cljslabs.git
```

## Running the ClojureScript applications

To get an interactive development environment run:

    lein figwheel

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