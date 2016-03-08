# House Of Liars

Game written in ClojureScript with Reagent. Created for the Intro To ClojureScript series, hosted by [Point Slope](https://pointslope.com/) for the [Miami Clojure MeetUp](http://www.meetup.com/Miami-Clojure-Meetup/) group.
The intention is to build this application by completing a series of tasks. Each task highlights a features of the language and/or interoperability between ClojureScript and JavaScript. The code in this repository is the final working example application. 

## Overview

This game allows you to test your political lie detecting mettle. You must read the quote in the message box and guess which of the candidates lied to your face. These are highly trained, professional liars. Do you have what it takes? Good Luck! 

## Setup

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

## License

Copyright © 2014 FIXME

Distributed under the Eclipse Public License either version 1.0 or (at your option) any later version.
