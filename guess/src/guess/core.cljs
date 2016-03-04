(ns guess.core
  "This is the main namespace for the CLJS application"
  (:require [reagent.core :as reagent :refer [atom]]
            [goog.string :as str]))

(enable-console-print!)

;; -== Application State ==- 

(def app-state
  "This atom contains the application's state"
  (atom {:number (inc (rand-int 10))
         :guesses []}))

;; -== Utilities ==- 

(defn valid-guess?
  "Checks if the string contains a valid numeric guess"
  [s]
  (and (not (str/isEmpty s))
       (str/isNumeric s)))

;; -== Event Handlers ==-
;;
;; Event handlers should execute in response to user
;; input. They are responsible for reacting to events
;; and updating the state of the application.

(defn evaluate-guess
  "This function should evaluate a user's guess
  and update the application state accordingly."
  [guess]
  (when (valid-guess? guess)
    (let [g (js/parseInt guess)]
      (swap! app-state update-in [:guesses] conj g))))

;; -== React Components ==- 
;;
;; React components display the current application
;; state. They should not mutate that state directly,
;; but rather should emit events upon user interaction.

(defn app-title
  "The title section of the application"
  []
  [:hgroup
   [:h1 "Guess My Number"]
   [:h2 "Choose a number between 1 and 10 inclusive"]])

;; TASK:
;; Create a "New Game" button component that will start a new guessing game
;; by generating a new number to be guessed and replacing the current
;; value in the application state.

(defn guessing-box
  "This component presents the user with controls to make their guesses"
  []
  [:div.guess
   [:span (str "Guesses so far " (count (:guesses @app-state)))]
   [:input {:id "guess" :type "number" :min 1 :max 10 :step 1}]
   [:button {:type "button"
             :onClick (fn [e] (evaluate-guess
                              (.-value (.getElementById js/document "guess")))) } "Guess!"]])

(defn root
  "The root component in the tree"
  []
  [:main
   [app-title]
   [guessing-box]])

;; -== Render the component tree to the DOM ==- 

(reagent/render-component
 [root]
 (. js/document (getElementById "app")))

;; a development-time hook that fires when Figwheel reloads the page

(defn on-js-reload [])
