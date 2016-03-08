# House Of Liars

Game written in ClojureScript with Reagent. Created for the Intro To ClojureScript series, hosted by [Point Slope](https://pointslope.com/) for the [Miami Clojure MeetUp](http://www.meetup.com/Miami-Clojure-Meetup/) group.
The intention is to build this application by completing a series of tasks. Each task highlights a features of the language and/or interoperability between ClojureScript and JavaScript. The code in this repository is the final working example application.

## Exercise 3

This is the third part in a series of ClojureScript exercises.  The following tasks are designed to illustrate interoperability between JavaScript and ClojureScript including using third-party libraries like jQuery.

## Tasks

### 1. Access API resource and populate app-state with response

Lets use jQuery to make an XHR to our API.

_Working File: src/houseofliars/api.cljs_

* __Edit the function body of ```(get-resources)```. We want to return the result of the success handler of jQuery's XHR function. The success handler returns the data from our api endpoint.__

**HINT**

Notice we are passing in two arugments to ```(get-resources url handler fn)```
These should be used by our jQuery XHR function. There are two possible jQuerty XHR functions we can use. Use the simplest one.

### 2. Convert JavaScript object to Clojure map

You will run into the need to convert between collection types when building ClojureScript applications. Some JavaScript function take an object literal as an argument or return an object as a value. And perhaps we need to pass a Clojure map to a JavaScript function which is expecting an object literal. Converting between the two is easy.

* __Our success handler returns an object literal representation of our data from the API, however we need to convert it to a Clojure map. Edit the both success handler function found in the file below convert the data to a Clojure map and add it to the app-state__

__BONUS: Shuffle the data int the quotes success handler before adding it to the app-state__

_Working File: src/houseofliars/state.cljs_

**HINT**

We can convert between the two by using a simple Clojure form ```(js->clj)``` or ```(clj->js)```

```
;; Notice we can pass an optional key boolean which converts our keys into Clojure keywords. This is VERY useful.
(js->clj some-javascript-object-literal :keywordize-keys true)
```

### 3. Create onClick event for our Button component

The component-did-mount function of the button component will bind any function to the element that is being rendered (mounted) onto the DOM. We want to bind an onClick event to the *liar* button which will determine if the candidate you chose actually said the lie.

_Working File: src/houseofliars/components/button-component.cljs_

**HINT**

You will need to use the *data attirbute* of the target element.
You will also need to *get* the value of the nested keys ```[:tracker :current-quote]``` from the app-state

**IMPORTANT HINT**

The final operation of the onClick event should be to call the function below
```
;; This function takes two arguments. A boolean value which represents if the answer was correct or not
;; and the candidate_id of the quote displayed

(utils/process-turn isCorrect? candidate_id)
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
