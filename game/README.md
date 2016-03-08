# Clojure CheatSheet

This guide covers the concepts and functions that will be used as part of our exercises

## Mutable Reference Types

### Atom

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

## Collections

### hash-map

The syntax for Clojure maps is fairly straight forward.
```
{} ;; literal map syntax

(hash-map) ;; hash-map function

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


## Bindings

### let
```
;; We use let bindings in order to create lexically scoped variables inside our function body
(defn my-awesome-function
 [some-vector]
    (let [some-var-name    (some-cool-function)
          someBooleanValue? (if (< 0 (count some-vector)))]
        (some-other-function someBooleanValue? some-var-name)))
```

## Conditionals

### if

```
;; Example psudeo code
(if conditional
   do-this
   else-do-that)


(if (< 10 20)
    true
    false)
=> true
```

### if-not

```
;; Example psudeo code
(if-not conditional
   do-this
   else-do-that)

(if-not (< 5 10)
    true
    false)
=> false
```

### when

```
;; Example psudeo code
(when conditional
   do-this)

(when (< 5 10)
    (some-cool-function)
    (another-cool-function))
```

### <
```
(< 10 20)
=> true
```