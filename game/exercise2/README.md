# House Of Liars

Game written in ClojureScript with Reagent. Created for the Intro To ClojureScript series, hosted by [Point Slope](https://pointslope.com/) for the [Miami Clojure MeetUp](http://www.meetup.com/Miami-Clojure-Meetup/) group.
The intention is to build this application by completing a series of tasks. Each task highlights a features of the language and/or interoperability between ClojureScript and JavaScript. The code in this repository is the final working example application.

## Exercise 2

This is the second part in a series of ClojureScript exercises. The goal of this exercise is to get comfortable using Clojure.

## Tasks

### 1. Add mock data to our app-state

Our application requires a collection of candidates and quotes to exist in our app-state atom. For this exercise we'll just be adding mock data to our application state so our components have data to display.

* __Edit our *initial-app-state* map and add a ```:candidate``` key which will contain a vector (array) of maps. Each map in this ```:candidates``` vector will contain information about our candidate. Below is an example of how the data should be shaped and the keys it should contain.__

Candidates List:
 * Hillary Clinton
 * Bernie Sanders
 * Donald Trump
 * Marco Rubio
 * Ted Cruz

```
:candidates [{:id 1
              :fname "Hillary"
              :lname "Clinton"
              :head "/img/head-hillary.png"} ...]
```
For the :head key follow this pattern ```"/img/head-(first name lower case).png"```


* __Edit our *initial-app-state* map and a ```:quote``` key which will contain a vector (array) of maps.__

Add one quote per candidate. You should end up with vector of 5 maps. One for each candidate.

```
:quotes [{:candidate_id 1
          :quote "Email server? What email server?"} ...]
```

### 2. Render each candidate in our candidate collection

Now that we have mock data in our app-state we can use that data to render our components.

_Working File: src/houseofliars/components/candidates.cljs_

* __Get our candidate collection from our app-state, loop through the collection and pass each candidate map to our candidate component function.__

*HINT*  You will need to use a Clojure function that allows you to iterate over a collection. It's common among all languages.


### 3. Create our Quote Component

This task is going to touch on a couple concepts. Binding variables, writing conditionals, and calling components.

_Working File: src/houseofliars/components/message.cljs_

* __The Quote component is going to render either our candidate quote OR a final assesment message. So our Quote component function must somehow get either determine that we've reached our max questions limit OR get the next quote in our quote collection.__


*HINT* You can build this component function using the following Clojure functions:
* let
* if-not
* when
* <

*HINT* Our conditional must call either of these component functions in order to render a message

```
[candidate-quote-component quote] ;; Notice this compontent fn takes one argument - a quote map
[game-over-component]
```

*HINT* In order to get the next quote call this utils function

```
(utils/select-random-quote)
```

# Task Resources

[ClojureScript CheatSheet](http://cljs.info/cheatsheet/)
[CLJSJ](http://cljsjs.github.io/)
[Hiccup](https://github.com/weavejester/hiccup)


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
