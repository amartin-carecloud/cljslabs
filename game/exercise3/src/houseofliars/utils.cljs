(ns houseofliars.utils
  (:require-macros [cljs.core.async.macros :refer [go]])
  (:require
   [reagent.core :as reagent]
   [cljs.core.async :as async :refer [timeout chan <!]]
   [houseofliars.state :as state :refer [app-state]]))

(defn toggle-candidate-animation
  "Toggles the animation class which moves the candidate head by id.
  There is a one second time to switch the animation toggle on / off."
  [id]
  (swap! app-state assoc-in [:animate id :toggle] true)
  (let [ch (timeout 1000)]
    (go (<! ch)
        (swap! app-state assoc-in [:animate id :toggle] false))))

(defn record-score
  "Increments the right or wrong score tally."
  [isCorrect?]
  (if isCorrect?
    (swap! app-state update-in [:score :right] inc)
    (swap! app-state update-in [:score :wrong] inc)))

(defn select-random-quote
  "Adds a quote to the [:tracker :current-quote] key in the app-state.
Returns the quote.
"
  []
  (let [hasQuote? (< 0 (count (:quotes @app-state)))
        quote (when hasQuote? (first (:quotes @app-state)))]
    (swap! app-state assoc-in [:tracker :current-quote] quote)
    quote))

(defn remove-quote-from-list
  "Removes the current quote from the :quote collection in the app-state and
updates the app-state with the collection of filtered quotes."

  []
  (let [current-quote (get-in @app-state [:tracker :current-quote])
        filtered-quotes (vec (filter #(not= % current-quote) (:quotes @app-state)))]
    (swap! app-state assoc-in [:quotes] filtered-quotes)))

(defn final-assessment
  "Determines which message should be display depending on the tally of the score."
  []
  (let [{:keys [right wrong]} (get-in @app-state [:score])
        even? (= right wrong)
        winner? (> right wrong)]
    (cond
      even?
      "Sharpen up your middle-of-the-road lie detecting skills."

      winner?
      "Nice job! You can smell the bull from a mile away..."

      :else
      "Sorry buddy, but you're an easy mark.")))

(defn max-questions-countdown
  "Decreases the value of :max-questions by 1. The application will use
this value to determine when the game is over."
  []
  (swap! app-state update-in [:max-questions] dec))

(defn process-turn
  "Calls all the functions necessary to initiate another turn. Takes two arugments. A boolean and an int."
  [isCorrect? candidate_id]
  (when (< 0 (:max-questions @app-state))
    (record-score isCorrect?)
    (toggle-candidate-animation candidate_id)
    (remove-quote-from-list)
    (select-random-quote)
    (max-questions-countdown)))

