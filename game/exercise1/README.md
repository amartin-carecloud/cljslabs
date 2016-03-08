# House Of Liars

Game written in ClojureScript with Reagent. Created for the Intro To ClojureScript series, hosted by [Point Slope](https://pointslope.com/) for the [Miami Clojure MeetUp](http://www.meetup.com/Miami-Clojure-Meetup/) group.
The intention is to build this application by completing a series of tasks. Each task highlights a features of the language and/or interoperability between ClojureScript and JavaScript. The code in this repository is the final working example application.

## Exercise 1

This is the first in a series of ClojureScript exercises. The goal of this exercise is to familiarize yourself with the project skeleton, the app-state atom and how to create a component using Reagent.

## Tasks

### Add jQuery and Bootstrap to project.clj from using CLJSJS.

Use [CLJSJS](http://cljsjs.github.io/) to add our javascript dependencies to our project.clj file.

### Require jQuery in Core component

In order for us to reference the almighty jQuery bling ($) within our application we must require it in our project. Think RequireJS. Use this [ClJSJS documentation](https://github.com/cljsjs/packages/wiki/Using-Packages) as a guide.

### Add the animated css file from a CDN to the index.html file.

It's common to reqiure more than one stylesheet for our applications. Adding another stylesheet, aside from the default ```/css/style.css``` that is automatically generated for you, is fairly straight forward.

* Add the animated.css stylesheet to our ```index.html``` file.

### Add key to initial app-state

Our application state is held in a reactive [atom](http://clojuredocs.org/clojure.core/atom) which in essentially a map that we are able to mutate atomically using the ```swap!``` fn. Reagent, our thin wrapper our ReactJS, "reacts" to changes in our app-state and re-renders the components which depend on the data from the app-state.

The *app-state* for this application is created in our ```state.cljs``` file.

#### Clojure maps

The syntax for Clojure maps is fairly straight forward.
```
{:keyword "value"}

;; Notice: Clojure map values can by anything; keywords, strings, numbers, and collections
{:foo "bar" :flim :flam}

;; Notice: Clojure map keys can be keywords, string, numbers, and even other collections
{1 "one" 2 "two"}
```

Access values from our map
```
(def mapp {:foo "bar" :fizz "buzz"})

;; We can use the keyword from our map to look up the value
(:foo mapp)
=> "bar"

;; The converse works as well
(mapp :foo)
=> "bar"

(def nested-map {:foo "bar" :fizz {:buzz "flam"}})

;; Here we use 'get-in' and pass it our map and the a vector of nested keys which will return our value.
(get-in nested-map [:fizz :buzz])
=> "flam"
```

#### Working With Atoms

Atoms can hold any value, but for the purpose of our application Atom's are mutable maps.

```
;; Here we created an atom that points to an empty map.
(def app-state (atom {}))
(def app-state (atom {:foo ""}))

;; Now we can populate (mutate) our Atom with a key and value using ```swap!``` (pronounced swap-bang)
(swap! app-state assoc :foo "bar")

;; Because our Atom is a map, we can treat it like a Clojure map. However, notice the *@* symbol prepended on our Atom var name. The *@* symbol is a macro that allows us to dereference our Atom and whatever the value is of the atom at that exact execution time.
(:foo @app-state)
=> "bar"

;; Lets add a nested map to our atom
(swap! app-state assoc-in [:foo :fizz :buzz] "flam")

;; Printing the app-state will return the nested map
(println @app-state)
=> {:foo "bar" :fizz {:buzz "flam"}}
```

* Add :game-title key to our app-state and provide a clever title for your game.


### Create a game title component and populate it with a value from the app-state.

Our application uses a library called Hiccup which allows us represent HTML in Clojure. We write our HTML using the easy to use Hiccip syntax and our application compiles it to HTML.

#### Example Hiccup Syntax
Creating a simple div element with text.
*Hiccup*
```
[:div "I'm a div"]
```

*HTML*
```
<div>I'm a div</div>
```

Creating a div with a class with a child anchor tag.
*Hiccup*
```
[:div.some-class
    [:a {:href "http://some-url.tld" :target "_blank" :alt "Some alt text"} "Link Text"]]
```

*HTML*
```
<div class="some-class">
    <a href="http://some-url.tld" target="_blank" alt="Some alt text">Link Text<a>
</div>
```

* The game title component should be created in our ```main.cljs``` file.
* Your component must render an H1 with and id of "gameTitle".
* The H1 tag must be a child of a *div* with the class name of *row*
* The text of the H1 tag should be the value of the game-title key in our app-state

### Display our Game title on our application.

* Call our Game component from our Main component in order to display the game title

#### Example Component Structure

```
(defn hello-component [name]
  [:p "Hello, " name "!"])

(defn say-hello []
  [hello-component "world"])
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
